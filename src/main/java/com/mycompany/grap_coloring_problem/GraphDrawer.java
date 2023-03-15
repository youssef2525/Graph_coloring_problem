package com.mycompany.grap_coloring_problem;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GraphDrawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private final int[][] graph;
    private final Color[] colors;
    private final String[] nodeNames;

    public GraphDrawer(int[][] graph, Color[] colors, String[] nodeNames) {
        this.graph = graph;
        this.colors = colors;
        this.nodeNames = nodeNames;
    }


@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int nodeRadius = 10; // Radius of each node
    int nodeSpacing = 90; // Spacing between nodes
    for (int i = 0; i < graph.length; i++) {
        g.setColor(colors[i]);
        // Add nodeSpacing to x and y coordinates of each node
        g.fillOval(graph[i][0] + nodeSpacing - nodeRadius, graph[i][1] + nodeSpacing - nodeRadius, 
                   nodeRadius * 2, nodeRadius * 2);
        g.drawString(nodeNames[i], graph[i][0] + nodeSpacing - nodeRadius, graph[i][1] + nodeSpacing - nodeRadius - 10);
        for (int j = 0; j < graph.length; j++) {
            if (i != j) {
                // Add nodeSpacing to x and y coordinates of each node
                int x1 = graph[i][0] + nodeSpacing;
                int y1 = graph[i][1] + nodeSpacing;
                int x2 = graph[j][0] + nodeSpacing;
                int y2 = graph[j][1] + nodeSpacing;
                int dx = x2 - x1;
                int dy = y2 - y1;
                double distance = Math.sqrt(dx * dx + dy * dy);
                int rx = (int) (nodeRadius * dx / distance);
                int ry = (int) (nodeRadius * dy / distance);
                g.drawLine(x1 + rx, y1 + ry, x2 - rx, y2 - ry);
            }
        }
    }
}

}

