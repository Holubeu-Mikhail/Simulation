package com.simulation.entities;

import java.util.Objects;

public class Node {
    private Position position;
    private Node previous;

    public Node(Position position, Node previous) {
        this.position = position;
        this.previous = previous;
    }

    public Node(Position position) {
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(position, node.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
