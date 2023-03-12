public class IncorrectArgumentException extends Exception {
    private String argument;

    public IncorrectArgumentException(String message, String argument) {
        super(message);
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }
}
