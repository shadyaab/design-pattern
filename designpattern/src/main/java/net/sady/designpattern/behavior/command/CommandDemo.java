package net.sady.designpattern.behavior.command;

interface FileExecutor {
    void openFile();

    void writeFile();

    void closeFile();
}

interface Command {
    void execute();
}

class FileExecutorImpl implements FileExecutor {

    @Override
    public void openFile() {
        System.out.println("Opened File");
    }

    @Override
    public void writeFile() {
        System.out.println("Wrote File");
    }

    @Override
    public void closeFile() {
        System.out.println("Closed File");
    }
}

class OpenFileCommand implements Command {

    FileExecutor fileExecutor = null;

    OpenFileCommand(FileExecutor fileExecutor) {
        this.fileExecutor = fileExecutor;
    }

    @Override
    public void execute() {
        this.fileExecutor.openFile();
    }
}

class WriteFileCommand implements Command {

    FileExecutor fileExecutor = null;

    WriteFileCommand(FileExecutor fileExecutor) {
        this.fileExecutor = fileExecutor;
    }

    @Override
    public void execute() {
        this.fileExecutor.writeFile();
    }
}

class Invoker {
    Command command = null;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        OpenFileCommand openFileCommand = new OpenFileCommand(new FileExecutorImpl());
        Invoker commandInvoker = new Invoker(openFileCommand);
        commandInvoker.execute();

        new Invoker(new WriteFileCommand(new FileExecutorImpl())).execute();
    }

}


















