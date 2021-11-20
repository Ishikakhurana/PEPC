import java.util.*;
public class Construct{

public static class Node{
int data;
Node left;
Node right;
Node(int data,Node left,Node right){
    this.data=data;
    this.left=left;
    this.right=right;
}
}
public static class Pair{
    Node node;
int state;
    Pair(Node node,int state){
this.state=state;
this.node=node;
    }
}
public static Node construct(Integer[] arr){
Node root=new Node(arr[0],null,null);
Pair rop=new Pair(root,1);
Stack <Pair> st=new Stack<>();
st.push(rop);
int i=0;
while(st.size()>0){
Pair top=st.peek();
if(top.state==1){
    //waiting for left
    i++;
    top.state++;
if(arr[i]!=null){
    top.node.left=new Node(arr[i],null,null);
    Pair lp=new Pair(top.node.left,1);
    st.push(lp);
}
else{
    top.node.left=null;
}
}
else if(top.state==2){
    //waiting for right
    i++;
    top.state++;
if(arr[i]!=null){
    top.node.right=new Node(arr[i],null,null);
    Pair rp=new Pair(top.node.right,1);
    st.push(rp);
}
else{
    top.node.right=null;
}
}
else if(top.state==3){
    st.pop();
}

}
return root; 
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
public static void traversal(Node node){
    if(node==null)
{
    return;
}
System.out.println(node.data+" "+"pre");
traversal(node.left);
System.out.println(node.data+" "+"in");
traversal(node.right);
System.out.println(node.data+" "+"post");

}

public static void main(String[] args){
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
    Node root=construct(arr);
    display(root);
    traversal(root);
    }
}