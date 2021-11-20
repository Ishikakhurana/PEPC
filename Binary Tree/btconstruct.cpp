#include <bits/stdc++.h>
using namespace std;

class Node{
    public:
    int data;
    Node* left;
    Node*  right;
    Node(int data ){
        this->data=data;
        left=NULL;
        right=NULL;
    }
   
};
 Node* construct(int arr[]){
        Node * root=new Node(arr[0]);
      
        stack<pair<Node*,int>> st;
    int idx=1;
        st.push({root,1});
       
        while(st.size()>0){
            // pair<Node*,int> top=st.top();
        if(st.top().second==1){
              st.top().second++;
        if (arr[idx] != -1) {
          st.top().first->left = new Node(arr[idx]);
        pair<Node*,int> lp={st.top().first->left, 1};
          st.push(lp);
          
        } else {
            
          st.top().first->left = NULL;
         
        }
 idx++;
        
        
      } else if (st.top().second == 2) {
           st.top().second++;
        if (arr[idx] != -1) {
          st.top().first->right = new Node(arr[idx]);
         pair<Node*,int> rp={st.top().first->right, 1};
          st.push(rp);
        } else {
          st.top().first->right = NULL;
        }
idx++;
       
      } 
        else {
            
        st.pop();
      }
    }

    return root;
}
void display(Node * node) {
    if (node == NULL) {
      return;
    }
    if(node->left!=NULL){
cout<<node->left->data;
        
    }
    else{
        cout<<".";
    }
    cout<<"<-"<<node->data<<" -> ";
      if(node->right!=NULL){
cout<<node->right->data<<endl;;
        
    }
    else{
        cout<<"."<<endl;;
    }
     display(node->left);
    display(node->right);

   
  }
void traversal(Node *node){
  if(node==NULL){
    return;
  }
  cout<<"pre"<<" "<<node->data<<endl;
  traversal(node->left);
  cout<<"in"<<" "<<node->data<<endl;
  traversal(node->right);
  cout<<"post"<<" "<<endl; 
} 
int main(){
    Node * l=new Node(20);
    Node * p=new Node(10);
    int arr[]={50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
    Node* root=construct(arr);
    display(root);
    traversal(root);
    
}