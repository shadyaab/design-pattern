package net.sady.designpattern.structural.proxy;

interface ServiceProvider{
	public void provideService(String username);
}

class ServiceProviderImpl implements ServiceProvider{

	public void provideService(String username) {
		System.out.println("Service Provided successfully. User : " + username);
	}
	
}

class ServiceProviderProxy implements ServiceProvider{

	private ServiceProvider provider;
	private String userId;
	private String password;
	
	public ServiceProviderProxy(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public void provideService(String username) {
		boolean isAuthorized = this.userId.equals(this.password);
		if(isAuthorized){
			provider = new ServiceProviderImpl();
			provider.provideService(username);
		} else {
			System.out.println("You are not authorized");
		}
	}
}

public class TestProxy {
	
	public static void main(String[] args) {
		ServiceProvider provider1 = new ServiceProviderProxy("sady", "sady");
		provider1.provideService("Shadyaab");
		
		ServiceProvider provider2 = new ServiceProviderProxy("sady", "123");
		provider2.provideService("Shadyaab");
	}
}
