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
    ArrayList<String> arraylist=new ArrayList<>();
    ArrayList<Integer> visited=new ArrayList<Integer>();
    ArrayList<Integer> d=new ArrayList<Integer>();
    ArrayList<Integer> p=new ArrayList<Integer>();
    int verticeCount;
    int min = 35555;
    int u = 0, v = 0;
    int total = 0;

    public MST(ArrayList<ArrayList<Integer>> weightArray,int verticeCount) {
        this.weightArray=(ArrayList<ArrayList<Integer>>)weightArray.clone();
        this.verticeCount=verticeCount;
    }
    
    public ArrayList<String> findMST(){
        for (int i = 0; i < verticeCount; i++) {
            visited.add(0);
        }
        visited.set(0,1);
        for(int counter = 0; counter < verticeCount-1 ; counter++){
			min = 35555;
			for(int i = 0; i < verticeCount; i++){
			if(visited.get(i)==1){
				for(int j = 0; j < verticeCount; j++){
					if(visited.get(j)==0){
						if(min > weightArray.get(i).get(j)){
							min = weightArray.get(i).get(j);
							u = i;
							v = j;
						}
					}
				}
			}
			}
			visited.set(v,1);
			total += min;
                        weightArray.get(v).set(u,35555);
                        weightArray.get(u).set(v,35555);
                        arraylist.add((u+1)+","+(v+1));
                        arraylist.add((v+1)+","+(u+1));
		}
        return arraylist;
    }
}
