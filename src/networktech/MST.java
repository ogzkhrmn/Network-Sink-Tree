/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networktech;

import java.util.ArrayList;

/**
 *
 * @author ogzkhrmn
 */
public class MST {

    ArrayList<ArrayList<Integer>> weightArray = new ArrayList<ArrayList<Integer>>();
    ArrayList<String> arraylist = new ArrayList<>();
    ArrayList<Integer> visited = new ArrayList<Integer>();
    ArrayList<Integer> d = new ArrayList<Integer>();
    ArrayList<Integer> p = new ArrayList<Integer>();
    int verticeCount;
    int min;
    int u, v;
    int total = 0;

    public MST(ArrayList<ArrayList<Integer>> myweightArray, int verticeCount) {
        //we are cloning our graph matrix.
        for (int i = 0; i < verticeCount; i++) {
            weightArray.add(new ArrayList<Integer>());
            for (int j = 0; j < verticeCount; j++) {
                weightArray.get(i).add(myweightArray.get(i).get(j));
            }
        }
        this.verticeCount = verticeCount;
        u = 0;
        v = 0;
        total = 0;
        min = 35555;
    }

    //calculating MST
    public ArrayList<String> findMST() {
        for (int i = 0; i < verticeCount; i++) {
            visited.add(0);
        }
        visited.set(0, 1);
        for (int counter = 0; counter < verticeCount - 1; counter++) {
            min = 35555;
            for (int i = 0; i < verticeCount; i++) {
                if (visited.get(i) == 1) {
                    for (int j = 0; j < verticeCount; j++) {
                        if (visited.get(j) == 0) {
                            if (min > weightArray.get(i).get(j)) {
                                min = weightArray.get(i).get(j);
                                u = i;
                                v = j;
                            }
                        }
                    }
                }
            }
            visited.set(v, 1);
            total += min;
            weightArray.get(v).set(u, 35555);
            weightArray.get(u).set(v, 35555);
            arraylist.add((u + 1) + "," + (v + 1));
            arraylist.add((v + 1) + "," + (u + 1));
        }
        return arraylist;
    }
}
