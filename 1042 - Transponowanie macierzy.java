package com.doxpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int m, n;
        int [][]array;
        do
        {
            System.out.println("\nPodaj liczbe m: ");
            m = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Podaj liczbe n: ");
            n = Integer.parseInt(bufferedReader.readLine());
        }
        while(!((m >= 1 && m <= 200) && (n >= 1 && n <= 200)));
        array = new int[m][n];
        fillArray(array, m, n);
        show(array, m, n);
        transposeMat(array, m, n);
    }

    public static void fillArray(int [][]tab, int m, int n)
    {
        Random random = new Random();

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                tab[i][j] = random.nextInt(9) + 1;
    }

    public static void show(int [][]tab, int m, int n)
    {
        System.out.println("Macierz wejsciowa: ");
        for(int i=0; i<m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(tab[i][j]);
                if(j != (n-1))
                    System.out.print(",");
            }
            System.out.println();
        }
    }

    public static void transposeMat(int [][]tab, int m, int n)
    {
        System.out.println("\nMacierz transponowana: ");
        for(int i=0; i<n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(tab[j][i]);
                if(j != (m-1))
                    System.out.print(",");
            }
            System.out.println();
        }
    }
}
