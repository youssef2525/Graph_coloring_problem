

package com.mycompany.grap_coloring_problem;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Youssef Bentaleb
 */
public class Grap_coloring_problem {

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[] colors = {1, 2, 3};
        GraphColoringPy gc = new GraphColoringPy(graph, colors);
        HashMap<Integer, Integer> nodeColors = gc.colorNodes();
        System.out.println( );

    /*
    // create the graph drawer and draw the graph
    GraphDrawer drawer = new GraphDrawer(graph, colors, nodeNames);
    JFrame frame = new JFrame("Graph");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(drawer);
    frame.pack();
    frame.setVisible(true);*/
    } 
}