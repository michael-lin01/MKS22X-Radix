public class MyLinkedList<T>{
  private int size;
  private Node<T> start,end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public Node<T> start(){
    return start;
  }

  public Node<T> end(){
    return end;
  }

  private Node<T> getNode(int n){
    Node<T> current = start;
    for (int i = 0; i < n; i++){
      current = current.next();
    }
    return current;
  }

  public void clear(){
    size = 0;
  }

  public boolean add(T value){
    Node<T> n = new Node<T>(value);
    //special case if list is empty - node would be both start and end node
    if (size == 0){
      start = n;
      end = n;
    }
    else{
      end.setNext(n);
      n.setPrev(end);
      end = n;
    }
    size++;
    return true;
  }

  public T removeFront(){
    Node<T> n = start;
    if(size==1){
      
    }
    start = start.next();
    start.setPrev(null);
    return n.getData();
  }

  public void extend(MyLinkedList<T> other){
    end.setNext(other.start());
    end = other.end();
    size+= other.size();
    other.clear();
  }

  public String toString(){
    if (size == 0){
      return "[]";
    }
    String ans = "[";
    //transversing list
    Node current = start;
    while(current != null){
      ans += (current.getData()+", ");
      current = current.next();
    }
    return ans.substring(0,ans.length()-2)+"]";
  }
}
