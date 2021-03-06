import java.io.*;
import java.util.*;

public class Main{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(){
            
        }
        Node(int data){
            this.data=data;
            
        }
    }
    public static Node construct(int[] arr,int lo,int hi){
        if(lo>hi){
            return null;
        }
        int mid=(lo+hi)/2;
        Node node=new Node(arr[mid]);
        node.left=construct(arr,lo,mid-1);
        node.right=construct(arr,mid+1,hi);
        return node;
    }
    public static void display(Node node){
         if (node == null) {
        return;
      }
  
      String str = "";
      str += node.left == null ? "." : node.left.data + "";
      str += " <- " + node.data + " -> ";
      str += node.right == null ? "." : node.right.data + "";
      System.out.println(str);
  
      display(node.left);
      display(node.right);
    }
    public static void main(String[] args)throws Exception{
    int[] arr={20,30,40,50,60,70,80,90,100};
       
        Node root=construct(arr,0,arr.length-1);
        display(root);
    }
}