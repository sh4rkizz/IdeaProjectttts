package sh4rkizz.Lab15;

import java.util.ArrayList;

class Node {
    private final static ArrayList<String> message = new ArrayList<>();
    private final static ArrayList<Node> nodes = new ArrayList<>();
    private Node first, second;
    private Node activeNode;

    public void inputNodes() {
        for (byte i = 0; i < 5; i++)
            nodes.add(new Node());

        nodes.get(0).setFirstAndSecond(nodes.get(1), nodes.get(4));
        nodes.get(1).setFirstAndSecond(nodes.get(2), nodes.get(3));
        nodes.get(2).setFirstAndSecond(nodes.get(3), nodes.get(4));
        nodes.get(3).setFirstAndSecond(nodes.get(2), nodes.get(4));
        nodes.get(4).setFirstAndSecond(nodes.get(0), nodes.get(2));

        activeNode = nodes.get(0);

        message.add("create_project");
        message.add("add_library");
        message.add("restart");
        message.add("test");
        message.add("deploy");
        message.add("drop_db");
    }

    private void setFirstAndSecond(Node first, Node second) {
        this.first = first;
        this.second = second;
    }

    private void setActiveNode(Node activeNode, byte step) {
        switch (step) {
            case 0 -> this.activeNode = activeNode.first;
            case 1 -> this.activeNode = activeNode.second;
            default -> this.activeNode = null;
        }
    }

    public String moveByNodes(byte step) {
        setActiveNode(activeNode, step);

        return message.get((byte) (Math.random() * 6));
    }
}


