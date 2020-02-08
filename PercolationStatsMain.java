/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percolation;

/**
 *
 * @author Paladin
 */
public class PercolationStatsMain
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        PercolationStats ps = new PercolationStats(200, 100);
        displayResults(ps);
        ps=new PercolationStats(200, 100);
        displayResults(ps);
        ps=new PercolationStats(2, 100000);
        displayResults(ps);
    }

    private static void displayResults(PercolationStats ps)
    {
        System.out.println();
        System.out.println(ps);
        System.out.println("mean()= "+ps.mean());
        System.out.println("stddev()= "+ps.stddev());
        System.out.println("confidenceLow()= "+ps.confidenceLow());
        System.out.println("confidenceHigh()= "+ps.confidenceHigh());
    }
    
}
