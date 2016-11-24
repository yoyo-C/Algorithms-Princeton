package com.yuyu.coursera.algorithms.stacksandqueues;

import java.io.*;

/**
 * Created by chenyuyu on 16/11/19.
 */
public class SocialNetworkConnectivity {
    /**
     * Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships,
     * design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).
     * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
     * The running time of your algorithm should be mlogn or better and use extra space proportional to n
     */
    private int[] id;
    private int[] sz;
    private int members;

    public SocialNetworkConnectivity(int n){
        id = new int[n];
        sz = new int[n];
        members = n;

        for(int i = 0 ; i < n; i++){
            id[i] = i;
            sz[i] = 1;

        }
    }

    private int root(int i){
        if(id[i] != i){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private boolean connected(int p, int q){
        return root(p) == root(q);
    }

    private boolean union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j){
            return false;
        }
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
            if(sz[j] == members){
                return true;
            }
        }else{
            id[j] = i;
            sz[i] += sz[j];
            if(sz[i] == members){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int n = 100;
        String earlistTime;
        SocialNetworkConnectivity snc = new SocialNetworkConnectivity(n);

        String log = "SocialNetworkConnectivity.log";

        try{
            File logfile = new File(log);
            BufferedReader bf = new BufferedReader(new FileReader(logfile));

            String s = bf.readLine();
            while(s != null){
                String[] subStr = s.split(" ");
                int p = Integer.valueOf(subStr[1]);
                int q = Integer.valueOf(subStr[2]);

                if(snc.connected(p, q)){
                    continue;
                }
                else{
                    if(snc.union(p,q)){
                        earlistTime = subStr[0];
                        System.out.println(earlistTime);
                        break;
                    }
                }

            }

        }catch (FileNotFoundException e){

        }catch (IOException e){

        }
    }

}
