import java.util.Scanner;
public class Solution6
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        if(l >= 1 && l <= 1000)
        {
            int[] arr = new int[l];
            for(int i = 0; i < arr.length; i++)
            {
                int a = sc.nextInt();
                if(a >= 1 && a <= 1000000)
                {
                    arr[i] = a;
                }
            }
            ancientSorting(arr);
            printSortedArray(arr);
        }
    }
    
    public static void ancientSorting(int[] array)
    {
        int n = array.length - 1;
        while(n != 0)
        {
            for(int j = 0; j < n; j++)
            {
                if((array[j]%2 == 0 && array[j+1]%2 == 0) || (array[j]%2 != 0 && array[j+1]%2 != 0))
                {
                    if(array[j] > array[j+1])
                    {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            n = n-1;
        }
    }
    
    public static void printSortedArray(int[] array)
    {
        for(int k = 0; k < array.length; k++)
        {
            System.out.print(array[k] + " ");
        }
        System.out.println();
    }
}
