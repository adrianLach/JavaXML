package org.javaxml;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class XMLNode extends ArrayList<XMLNode> implements Serializable {

    private String nodeName = "";
    private HashMap<String, XMLAttribute> attributes = new HashMap<>();

    private XMLNode parent;

    public XMLNode() {

    }

    public XMLNode(String nodeName) {
        setNodeName(nodeName);
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void addAttribute(XMLAttribute attribute) {
        attributes.put(attribute.getName(), attribute);
    }

    public XMLNode getParent() {
        return parent;
    }

    public void setParent(XMLNode parent) {
        this.parent = parent;
    }

    public HashMap<String, XMLAttribute> getAttributes() {
        return attributes;
    }

    public XMLAttribute getAttributeByName(String name) {
        XMLAttribute attribute = null;
        attribute = attributes.get(name);
        return attribute;
    }

    @Override
    public boolean add(XMLNode subNode) {
        if(subNode.getNodeName() == null || subNode.getNodeName().length() == 0)
            throw new XMLInvalidNameException();
        subNode.setParent(this);
        return super.add(subNode);
    }

    public void print(PrintStream ps) {
        ps.println("======");
        ps.println(nodeName);
        attributes.forEach(new BiConsumer<String, XMLAttribute>() {
            @Override
            public void accept(String s, XMLAttribute xmlAttribute) {
                ps.println(xmlAttribute.getName() + ": " + xmlAttribute.getValue());
            }
        });
        forEach(new Consumer<XMLNode>() {
            @Override
            public void accept(XMLNode node) {
                node.print(ps);
            }
        });
    }
}
