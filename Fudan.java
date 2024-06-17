package www;

import com.sun.javafx.image.BytePixelSetter;
import javafx.beans.binding.StringBinding;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;


public class Fudan {


    public static void main(String[] args) {
        int cnt=1;
        LinkedList<Node> list = new LinkedList<>();
        Node empty=new Node(0);
        list.add(empty);

            Scanner get=new Scanner(System.in);
            String str=get.nextLine();
            String[] srr=str.split(" ");
            ArrayList<String> arr=new ArrayList<>();
            for (int i = 0; i < srr.length; i++) {
                arr.add(String.valueOf(srr[i]));
            }
            get.close();



        for (int i = 0; i < arr.size(); i++) {
            String element = arr.get(i);
           if(element.equals("null"))
           {
               Node x=new Node(0);
               list.add(x);
           }
           else {
               int change=Integer.parseInt(element);
               Node y=new Node(change);
               list.add(y);
           }
        }

        
        for(int i=2; i<list.size(); i++){
            if (list.get(i).value==0)
                continue;
            if(list.get(i).value>=list.get(i/2).value) {
                cnt++;
            }
            else list.get(i).value=list.get(i/2).value;
        }
        System.out.println(cnt);




    }



}



 class Node{
    // 数据域
    int value;
    // 指针域
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


     public Node ()
     {

     }
 }