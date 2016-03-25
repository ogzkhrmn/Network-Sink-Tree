/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networktech;

import java.awt.Color;

/**
 *
 * @author ogzkhrmn
 */
public class Line {

    final int x1;
    final int y1;
    final int x2;
    final int y2;
    final double weight;
    protected Color color;

    public Line(int x1, int y1, int x2, int y2, double weight, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.weight = weight;
        this.color = color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
