package framework.xml;

import java.io.*;
import java.util.ArrayList;

public class XMLReader {

    public static final void readXML(XMLDocument document, File file) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        XMLNode currentNode = null;

        {
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                String lineData = clearEmpty(line.split("[<|>]"))[0];
                String[] data = lineData.split("\\s+");
                if(line.substring(0, 5).equalsIgnoreCase("<?xml")) {

                    String[] attr = null;

                    attr = data[1].split("=");
                    document.setVersion(attr[1].substring(0, attr[1].length() - 2));

                    attr = data[2].split("=");
                    document.setEncoding(attr[1].substring(0, attr[1].length() - 2));

                    continue;
                }

                if(document.getRoot() == null) {
                    document.setRoot(new XMLNode());
                    document.getRoot().setNodeName(data[0]);
                    currentNode = document.getRoot();

                    for(int i = 1; i < data.length; i++) {
                        String[] attr = data[i].split("=");
                        XMLAttribute attribute = new XMLAttribute();
                        attribute.setName(attr[0]);
                        if(attr[1].endsWith("/"))
                            attr[1] = attr[1].substring(0, attr[1].length() - 2);
                        attribute.setValue(attr[1]);
                        currentNode.addAttribute(attribute);
                    }

                    continue;
                }

                if(!data[0].contains("/")) {
                    XMLNode subNode = new XMLNode();
                    subNode.setNodeName(data[0]);
                    currentNode.add(subNode);
                    currentNode = subNode;

                    for(int i = 1; i < data.length; i++) {
                        String[] attr = data[i].split("=");
                        XMLAttribute attribute = new XMLAttribute();
                        attribute.setName(attr[0]);
                        if(attr[1].endsWith("/"))
                            attr[1] = attr[1].substring(0, attr[1].length() - 2);
                        attribute.setValue(attr[1]);
                        currentNode.addAttribute(attribute);
                    }

                }
                else {
                    currentNode = currentNode.getParent();
                }
            }
        }
        bufferedReader.close();

    }

    private static final String[] clearEmpty(String[] args) {
        ArrayList<String> containsData = new ArrayList<>();
        for(String str : args) {
            if(str.trim().length() > 0)
                containsData.add(str);
        }
        String[] goodData = new String[containsData.size()];
        containsData.toArray(goodData);

        return goodData;
    }

}
