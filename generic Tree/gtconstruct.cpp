#include <bits/stdc++.h>
using namespace std;

class Node{
    public:
    int data;
    vector<Node*> children;
    
   
};
 Node* construct(int arr[],int n){
       Node* root = NULL;
stack<Node*>st;
    for(int i=0;i<n;i++){
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node *t = new Node();
        t->data=arr[i];
        if (st.size() > 0) {
          st.top()->children.push_back(t);
        }else{
            root=t;
        }

        st.push(t);
      }
    }

    return root;
}
void display(Node * node) {
    if (node == NULL) {
      return;
    }
    cout<<node->data<<" -> ";
    for(int i=0;i<node->children.size();i++){
        cout<<node->children.at(i)->data<<",";
    }
    
    cout<<"."<<endl;
    for(int i=0;i<node->children.size();i++){
        display(node->children.at(i));
    }

   
  }

int main(){
   int arr[]={10,20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100 ,-1, -1, -1,};
   int n = sizeof(arr)/sizeof(arr[0]);
    Node* root=construct(arr,n);
    
    display(root);
    
}