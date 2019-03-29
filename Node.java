public class Node<T>{

  private T data;
  private Node<T> next, prev;

  public Node(T data){
    this.data = data;
  }

  public Node<T> next(){
    return next;
  }
   public Node<T> prev(){
     return prev;
   }
   public T getData(){
     return data;
   }
   public void setNext(Node<T> other){
     next = other;
   }
   public void setPrev(Node<T> other){
     prev = other;
   }

   public void setData(T newData){
     data = newData;
   }

   public String toString(){
     return ""+data;
   }


}
