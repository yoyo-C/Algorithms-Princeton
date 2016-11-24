package com.yuyu.coursera.algorithms.unionFind;

/**
 * Created by chenyuyu on 16/11/18.
 */
public class QuickUnionUF {
    private int[] id;
    private int[] sz;
    private int[] largestEle;

    public QuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        largestEle = new int[N];
        for ( int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
            largestEle[i] = i;
        }
    }

    private int root(int i){
        while(id[i] != i){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j){
            return ;
        }
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
            largestEle[j] = i > j? i : j;

        }else{
            id[j] = i;
            sz[i] += sz[j];
            largestEle[i] = i > j? i : j;

        }
    }
    public int find(int i){
        return largestEle[root(i)];
    }

    public static void main(String[] args){
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.union(2,3);
        quickUnionUF.union(3,8);
        quickUnionUF.union(8,9);
        System.out.println(quickUnionUF.find(2));

    }

}
