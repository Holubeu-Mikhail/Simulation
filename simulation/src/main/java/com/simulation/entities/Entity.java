package com.simulation.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Entity {
    protected Position position;

    public Entity(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected void moveTo(Position target) {
        //position = new Position(position.getX(), position.getY() + 1);
    }

    protected void moveFrom(Position target) {
        //position = new Position(position.getX(), position.getY() + 1);
    }

    private List<Node> findPath(Position startPosition, Position endPosition) {
        Node startNode = new Node(startPosition);
        Node endNode = new Node(endPosition);
        ArrayList<Node> reachableNodes = new ArrayList<>();
        ArrayList<Node> exploredNodes = new ArrayList<>();

        reachableNodes.add(startNode);

        while (reachableNodes.size() > 0) {
            Node node = chooseNode(reachableNodes);

            if (node.getPosition() == endNode.getPosition()) {
                return buildPath(endNode);
            }

            reachableNodes.remove(node);
            exploredNodes.add(node);

            List<Node> newReachableNodes = getAdjacentNodes(node).stream().filter(n -> !exploredNodes.contains(n)).collect(Collectors.toList());

            for (Node adjacent : newReachableNodes) {
                if (!reachableNodes.contains(adjacent)) {
                    adjacent.setPrevious(node);
                    reachableNodes.add(adjacent);
                }
            }
        }

        return null;
    }

    private Node chooseNode(List<Node> nodes) {
        return nodes.get(0);
    }

    private List<Node> buildPath(Node toNode) {
        ArrayList<Node> path = new ArrayList<>();

        while (toNode != null) {
            path.add(toNode);
            toNode = toNode.getPrevious();
        }

        return path;
    }

    private List<Node> getAdjacentNodes(Node node) {
        ArrayList<Node> adjacentNodes = new ArrayList<>();

        return adjacentNodes;
    }
}
