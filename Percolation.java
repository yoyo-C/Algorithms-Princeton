package com.yuyu.coursera.algorithms.unionFind;

/**
 * Created by chenyuyu on 16/11/19.
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private boolean[][] sites; // n * n grid
    private int numOfGrids; // length of grid
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private WeightedQuickUnionUF weightedQuickUnionUFB;

    // create a n * n grid with all sites blocked
    public Percolation(int n){
        if (n <= 0) { throw new IllegalArgumentException(); }
        sites = new boolean[n][n];
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
        weightedQuickUnionUFB = new WeightedQuickUnionUF(n * n + 1);
        numOfGrids = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sites[i][j] = false;
            }
        }
    }
    //open site
    public void open(int row, int col){
        if(row > numOfGrids || row <= 0 || col > numOfGrids || col <= 0){
            throw new IndexOutOfBoundsException();
        }
        sites[row - 1][col - 1] = true;
        int val = (row - 1) * numOfGrids + col;
        if(row == 1){
            weightedQuickUnionUF.union(0, val);
            weightedQuickUnionUFB.union(0,val);
        }
        else if(sites[row - 2][col - 1] == true){
            weightedQuickUnionUF.union(val, val - numOfGrids);
            weightedQuickUnionUFB.union(val, val - numOfGrids);
        }
        if(row == numOfGrids){
            weightedQuickUnionUF.union(val, numOfGrids*numOfGrids+1);
        }
        else if(sites[row][col - 1] == true){
            weightedQuickUnionUF.union(val, val + numOfGrids);
            weightedQuickUnionUFB.union(val, val + numOfGrids);
        }
        if ((col != 1) && (sites[row - 1][col - 2] == true)){
            weightedQuickUnionUF.union(val, val - 1);
            weightedQuickUnionUFB.union(val, val - 1);
        }
        if ((col != numOfGrids) && (sites[row - 1][col] == true)){
            weightedQuickUnionUF.union(val, val + 1);
            weightedQuickUnionUFB.union(val,val + 1);
        }
    }

    // is site open?
    public boolean isOpen(int row, int col){
        if (row > numOfGrids || row <= 0 || col > numOfGrids || col <= 0) {
            throw new IndexOutOfBoundsException("out of Bounds");
        }
        return sites[row-1][col-1] == true;
    }
    // is site full?
    public boolean isFull(int row, int col){
        if(row > numOfGrids || row <= 0 || col > numOfGrids || col <= 0){
            throw new IndexOutOfBoundsException("out of bounds");}
        return weightedQuickUnionUFB.connected(0, (row - 1)* numOfGrids + col);
    }
    //does the system percolates?
    public boolean percolates(){
        return weightedQuickUnionUF.connected(0, numOfGrids * numOfGrids + 1);
    }
}
