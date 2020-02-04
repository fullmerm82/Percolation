/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 *
 * @author Matt Fullmer
 */
public class Percolation
{
    WeightedQuickUnionUF open;
    WeightedQuickUnionUF full;
    boolean[][] grid;
    int index1 = 0,index2 = 0,index3 = 0;
    public Percolation(int n){
        grid = new boolean[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                grid[i][j] = false;
        open = new WeightedQuickUnionUF(n^2+2);
        full = new WeightedQuickUnionUF(n^2+1);
        
        
        //connecting the top row to open and full
        for (int i=0;i<=n;i++){
            open.union(full.count()-1, i);
            open.union( open.count()-1, open.count()-(i+1));
            full.union(full.count()-1, i);
            

        }
    }
    public void open(int i, int j){
        //open site (row i, column j) if it is not open already
        if(isOpen(i, j)){
        grid[i][j] = true;        
        //union with any adjasent open sites
                //fill if any adjacent site is full

        if(i!=0){
            if(isOpen(i-1, j))
                open.union(findElement(i, j), findElement(i-1, j));
            if(isFull(i-1,j))
                full.union(findElement(i, j), findElement(i-1, j));
        }
        if(i!=grid.length-1){
            if(isOpen(i+1, j))
                open.union(findElement(i, j), findElement(i+1, j));
            if(isFull(i+1,j))
                full.union(findElement(i, j), findElement(i+1, j));
        }
        if(j!=0){
            if(isOpen(i, j-1))
                open.union(findElement(i, j), findElement(i, j-1));
             if(isFull(i, j-1))
                full.union(findElement(i, j), findElement(i, j-1));
        }
        if(j!=grid.length-1){
            if(isOpen(i, j+1))
                open.union(findElement(i, j), findElement(i, j+1));
            if(isFull(i, j+1))
                full.union(findElement(i, j), findElement(i, j+1));
        }
        }
    }
    public boolean isOpen(int i, int j){
        return grid[i][j];
    }
    public boolean isFull(int i,int j){
        //fill in the logic here
        full.connected(findElement(i, j), full.find(full.count()-1));
        return false;
    }
    public boolean percolates(){
        //to do logic here
        open.connected(open.count()-1, open.count()-2);
        return false;
    }
    private int findElement(int i, int j){
        return grid.length*j+i;
    }
}
