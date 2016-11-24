package com.yuyu.coursera.algorithms.unionFind;

/**
 * Created by chenyuyu on 16/11/19.
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;


public class PercolationStats {
    private double mean = 0; //mean of percolation threshold
    private double stddev; //standard deviation of percolation threshold
    private int trials; // times of trials

    //perform t independent cumpucational experiments on a n * n grid
    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0){
            throw new IllegalArgumentException("illegal Arguments");
        }
        this.trials = trials;
        double[] x = new double[trials];
        for(int t = 0; t < trials; t++){
            Percolation percolation = new Percolation(n);
            for(int count = 1; count <= n * n; count++){
                int i = StdRandom.uniform(n) + 1;
                int j = StdRandom.uniform(n) + 1;
                while(percolation.isOpen(i, j)){
                    i = StdRandom.uniform(n) + 1;
                    j = StdRandom.uniform(n) + 1;
                }
                percolation.open(i,j);
                if(percolation.percolates()){
                    x[t] = (double)count / (n * n);
                    break;
                }
            }
        }
        for(int t = 0; t < trials; t++){
            mean += x[t];
        }
        mean /= trials;
        for(int t = 0; t < trials; t++){
            stddev += (x[t] - mean) * (x[t] - mean);
        }
        stddev /=(trials - 1);
        stddev = Math.sqrt(stddev);
    }
    //mean of percolation threshold
    public double mean(){
        return mean;
    }
    //standard deviation of percolation threshold
    public double stddev(){
        return stddev;

    }
    //returns lower bound of the 95% confidence interval
    public double confidenceLo(){
        return mean - 1.96 * stddev / Math.sqrt(trials);

    }
    //returns upper bound of the 95% confidence interval
    public double confidenceHi(){
        return mean + 1.96 * stddev / Math.sqrt(trials);

    }
    public static void main(String[] args){
//        int n = StdIn.readInt();
//        int trials = StdIn.readInt();
        Stopwatch timer = new Stopwatch();
        PercolationStats ps = new PercolationStats(20, 10);
        double time = timer.elapsedTime();
        System.out.println("time                    = " + time);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
        System.out.println(Math.pow(2,20));
    }
}
