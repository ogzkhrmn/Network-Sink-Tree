/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networktech;

import java.awt.Point;

/**
 *
 * @author ogzkhrmn
 */
public class MyButtons {
    private int x;
    private int y;
    private String id;
    private boolean selected;
    private RoundButton rb;

    public MyButtons(int x, int y, String id, boolean selected, RoundButton rb) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.selected = selected;
        this.rb = rb;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the rb
     */
    public RoundButton getRb() {
        return rb;
    }
    
}
