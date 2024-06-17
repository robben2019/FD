package www;
import com.sun.javafx.image.BytePixelSetter;

import java.util.Scanner;

public class Kmp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        int next[]=new int[s1.length()];
        next=getNext(s1);
        int count=Kmp(s2,s1,next);
        System.out.println(count);
    }

    public static int[]getNext(String t)
    {
        int next[]=new int[t.length()];
            int j=0,k=-1;
            next[0]=-1;
            while(j<t.length()-1)
            {
                if(k == -1 || t. charAt(j)== t.charAt(k))
                {
                    j++;k++;
                    next[j] = k;
                }
                else k = next[k];
            }
            return next;
        }



        public static int Kmp(String s1,String s2,int next[])
        {
            int i=0;
            int j=0;
            while(i<s1.length()&&j<s2.length())
            {
                if(j==-1||s1.charAt(i)==s2.charAt(j))
                {
                    i++;
                    j++;
                }
                else {
                    j=next[j];
                }
            }

            if(j>=s2.length())
            {
               return i-s2.length();
            }
            else return 0;

        }
}
