package networktech;

import java.util.ArrayList;

public class SinkTrees {

    ArrayList<ArrayList<Integer>> weightArray = new ArrayList<ArrayList<Integer>>();

    public SinkTrees(ArrayList<ArrayList<Integer>> myweightArray, int verticeCount) {
        //we are cloning our graph matrix.
        for (int i = 0; i < verticeCount; i++) {
            weightArray.add(new ArrayList<Integer>());
            for (int j = 0; j < verticeCount; j++) {
                weightArray.get(i).add(myweightArray.get(i).get(j));
            }
        }
    }

}
