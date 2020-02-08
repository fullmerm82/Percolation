/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 *
 * @author Paladin
 */
public class PercolationStats
{

    private double[] opens;
    private int n, t;

    public PercolationStats(int n, int t)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        if (t < 0)
        {
            throw new IllegalArgumentException("The number of runs must be greater than 0");
        }

        this.n = n;
        this.t = t;
        // perform T independent experiments on an N-by N grid
        opens = new double[t];
        int x, y;

        Percolation p;
        for (int i = 0; i < t - 1; i++)
        {
            double count = 0.0;
             p = new Percolation(n);
            do
            {
               

                do
                {

                    x = StdRandom.uniform(n);
                    y = StdRandom.uniform(n);
                } while (p.isOpen(x, y));
                p.open(x, y);
                count++;
            } while (!p.percolates());
            this.opens[i] = count / (n * n);
        }
    }

    public double mean()
    {
        return StdStats.mean(opens);
        /*double acc = 0.0;
        for (int i = 0; i < this.opens.length; i++)
        {
            acc += this.opens[i];
        }
        return acc / t;*/
        //sample mean of percolation threshold
    }

    public double stddev()
    {
        //sample standard deviation of percolation threshold
        return StdStats.stddev(opens);
        /*
        double acc = 0.0, temp = 0.0, sigma = 0.0;
        double mean = mean();
        for (int i = 0; i < this.opens.length; i++)
        {
            temp = opens[i] - mean;
            acc += temp * temp;
        }
        sigma = acc / this.t;
        return Math.sqrt(sigma);*/
    }

    public double confidenceLow()
    {
        //low endpoint of 95% confidence interval
        return mean() - ((1.96 * stddev()) / (Math.sqrt(this.t)));
    }

    public double confidenceHigh()
    {
        // high endpoint of 95% confidence interval
        return mean() + ((1.96 * stddev()) / (Math.sqrt(this.t)));
    }
}
