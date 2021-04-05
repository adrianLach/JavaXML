package org.javaxml;

public class XMLInvalidNameException extends RuntimeException {

    public XMLInvalidNameException() {
        super("Node name is null or \"\"");
    }
}
