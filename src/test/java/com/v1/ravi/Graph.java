package com.v1.ravi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Graph {
    class Node {
        int data; // 인접한 노드들과의 관계
        LinkedList<Node> adjacent;
        boolean marked;
        int dist;

        Node(int data) {
            this.data = data;
            this.marked = false;
            this.dist = 0;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void visit(Node n) {
        System.out.println("방문 노드: " + n.data + " ");
    }


    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            int count = 0;
            for (Node n : r.adjacent) {


                if (n.marked == false) {
                    n.marked = true;
                    System.out.println("Stack push : " + n.data);
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) {
        if (r == null) return;
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;
        int dept = 0;

        while (!queue.isEmpty()) {
            Node r = queue.poll();
            System.out.println(r.data+ "의 깊이는: " + r.dist);

            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }

    }

}