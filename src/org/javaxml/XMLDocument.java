package framework.xml;

import java.io.File;
import java.io.IOException;

public class XMLDocument {

    private String version;
    private String encoding;
    private XMLNode root = new XMLNode();

    public XMLDocument() {

    }

    public XMLDocument(File file) {
        try {
            this.loadXML(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public XMLNode getRoot() {
        return root;
    }

    public void setRoot(XMLNode root) {
        this.root = root;
    }

    public void saveXML(File file) throws IOException {
        XMLWriter.writeXML(this, file);
    }

    public void loadXML(File file) throws IOException {

        XMLReader.readXML(this, file);

    }

}
