package org.javaxml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class XMLWriter {

    public static void writeXML(XMLDocument document, File file) throws IOException {

        String xml = write(document.getRoot(), 0);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(xml);
        bufferedWriter.close();
    }

    static class Dummy {
        public String data = "";
    }

    private static String write(XMLNode node, int offset) {
        String tabOffset = "";

        for(int i = 0; i < offset; i++)
            tabOffset += "\t";

        Dummy atr = new Dummy();
        node.getAttributes().forEach(new BiConsumer<String, XMLAttribute>() {
            @Override
            public void accept(String s, XMLAttribute xmlAttribute) {
                atr.data += " " + xmlAttribute.getName() + "=\"" + xmlAttribute.getValue() + "\"";
            }
        });



        String xml = "";
        if(node.size() > 0)
            xml += tabOffset + "<" + node.getNodeName() + atr.data + ">" + "\n";
        else
            xml += tabOffset + "<" + node.getNodeName() + atr.data + "/>" + "\n";

        Dummy d = new Dummy();

        node.forEach(new Consumer<XMLNode>() {
            @Override
            public void accept(XMLNode node) {
                d.data += write(node, offset + 1);
            }
        });

        xml += d.data;

        if(node.size() > 0)
            xml += tabOffset + "</" + node.getNodeName() + ">" + "\n";

        return xml;
    }

}
