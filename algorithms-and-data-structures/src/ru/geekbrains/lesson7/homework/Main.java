package ru.geekbrains.lesson7.homework;

import ru.geekbrains.lesson7.Graph;
import ru.geekbrains.lesson7.homework.algoritm.BreadthFirstPath;
import ru.geekbrains.lesson7.homework.algoritm.GraphAlgoritm;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 6);
        graph.addEdge(1, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);
        graph.addEdge(2, 5);
        graph.addEdge(5, 7);
        graph.addEdge(7, 3);
        graph.addEdge(7, 8);
        graph.addEdge(6, 8);
        graph.addEdge(6, 8);

        GraphAlgoritm bfp = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(8));
        System.out.println(bfp.pathTo(8));
    }
}
