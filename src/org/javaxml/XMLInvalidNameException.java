package framework.xml;

public class XMLInvalidNameException extends RuntimeException {

    public XMLInvalidNameException() {
        super("Node name is null or \"\"");
    }
}
