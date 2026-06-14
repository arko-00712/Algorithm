import java.util.Scanner;
public class Solution7
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        if(total >= 1 && total <= 100)
        {
            for(int i = 1; i <= total; i++)
            {
                int a = sc.nextInt();
                if(a >= 1 && a <= 1000)
                {
                    int[] arr1 = new int[a];
                    int[] arr2 = new int[a];
                    for(int j = 0; j < arr1.length; j++)
                    {
                        int b = sc.nextInt();
                        if(b >= 1 && b <= 1000)
                        {
                            arr1[j] = b;
                        }
                    }
                    for(int k = 0; k < arr1.length; k++)
                    {
                        int c = sc.nextInt();
                        if(c >= 1 && c <= 1000)
                        {
                            arr2[k] = c;
                        }
                    }
                    studentSorting(arr1, arr2);  
                }
            }
        }
    }
    
    public static void studentSorting(int[] array1, int[] array2)
    {
        int min = 0;
        for(int i = 0; i < array1.length-1; i++)
        {             
            int temp1 = i;
            for(int j = i+1; j < array1.length; j++)
            {                 
                 if((array2[temp1] < array2[j]) || (array2[temp1] == array2[j] && array1[temp1] > array1[j]))
                 { 
                     temp1 = j;
                 }               
            }
            if(i != temp1)
            {               
                min++;
                int temp2 = array2[i];
                int temp3 = array1[i];
                array2[i] = array2[temp1];
                array2[temp1] = temp2;
                array1[i] = array1[temp1];
                array1[temp1] = temp3;
            }    
        }
        System.out.println("Minimum swaps: " + min);
        for(int i = 0; i < array1.length; i++)
        {
            System.out.println("ID: " + array1[i] + " Mark: " + array2[i]);
        }
    }
}

            
        
          