class MyCircularDeque{
    int[]q;int f=0,r=0,s=0,c;
    public MyCircularDeque(int k){c=k;q=new int[k];}
    public boolean insertFront(int v){
        if(s==c)return false;
        f=(f-1+c)%c;q[f]=v;s++;return true;
    }
    public boolean insertLast(int v){
        if(s==c)return false;
        q[r]=v;r=(r+1)%c;s++;return true;
    }
    public boolean deleteFront(){
        if(s==0)return false;
        f=(f+1)%c;s--;return true;
    }
    public boolean deleteLast(){
        if(s==0)return false;
        r=(r-1+c)%c;s--;return true;
    }
    public int getFront(){return s==0?-1:q[f];}
    public int getRear(){return s==0?-1:q[(r-1+c)%c];}
    public boolean isEmpty(){return s==0;}
    public boolean isFull(){return s==c;}
}