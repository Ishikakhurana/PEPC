import java.util.*;

public class Main{
     private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
   public static void display(Node node) {
    String str = node.data + " -> ";
    for (int i=0;i<node.children.size();i++) {
      str += node.children.get(i).data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (int i=0;i<node.children.size();i++) {
      display(node.children.get(i));
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  static int size;
  static int max;
  static int min;
  static int height;
  public static void multisolver(Node node,int lvl){
size++;
max=Math.max(max,node.data);
min=Math.min(min,node.data);
height=Math.max(height,lvl);
for(int i=0;i<node.children.size();i++){
multisolver(node.children.get(i),lvl+1);
}
}
 
    public static void main(String [] args){
      int[]arr={10,20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100 ,-1, -1, -1,};

      Node root=construct(arr);
      size=0;
      max=Integer.MIN_VALUE;
      min=Integer.MAX_VALUE;
      height=0;
      multisolver(root,0); 
      System.out.println(size);
       System.out.println(max);
        System.out.println(min);
         System.out.println(height);
         display(root);
        

    }
}