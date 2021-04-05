package framework.xml;

import java.io.Serializable;
import java.util.HashMap;

public class XMLAttribute implements Serializable {

    private String name = "";
    private String value = "";

    public XMLAttribute() {
    }

    public XMLAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
