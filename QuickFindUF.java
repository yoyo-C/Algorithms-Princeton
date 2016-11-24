package com.yuyu.coursera.algorithms.unionFind;

/**
 * Created by chenyuyu on 16/11/18.
 */
public class QuickFindUF {
    private int[] id;
    public QuickFindUF(int N){
        id = new int[N];
        for(int i = 0; i <  N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    /**
     * *returns the largest element in the connected component containing i
     */

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}
