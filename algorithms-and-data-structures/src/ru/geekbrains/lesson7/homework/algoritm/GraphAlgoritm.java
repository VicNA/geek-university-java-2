package ru.geekbrains.lesson7.homework.algoritm;

import ru.geekbrains.lesson7.Graph;

import java.util.LinkedList;

public abstract class GraphAlgoritm {
    boolean[] marked;
    int[] edgeTo;
    int source;

    public GraphAlgoritm() {
    }

    public GraphAlgoritm(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
