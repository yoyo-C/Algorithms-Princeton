package com.yuyu.coursera.algorithms.unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

/**
 * Created by chenyuyu on 16/11/18.
 */
public class DynamicConnectivityClient {
    public static void main(String[] args){
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!uf.connected(p,q)){
                uf.union(p,q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
