public class MyLinkedList<T>{
  private int size;
  private Node<T> start,end;
  public Node<T> current;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
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

  public T next(){
    current = current.next();
    return current.getData();
  }

  public void reset(){
    current = new Node<T>();
    current.setNext(start);
  }

  public boolean addFront(T value){
    Node<T> n = new Node<T>(value);
    if(size==0){
      start = n;
      end = n;
    }
    else{
      start.setPrev(n);
      n.setNext(start);
      start = n;
    }
    size++;
    return true;
  }
  public boolean addEnd(T value){
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
    if(size>1){
      start = start.next();
      start.setPrev(null);
    }
    size--;
    return n.getData();
  }

  public void extend(MyLinkedList<T> other){
    if(size==0) start = other.start;
    else end.setNext(other.start);
    end = other.end;
    size+= other.size();
    other.clear();
  }

  public String toString(){
    if (size == 0){
      return "[]";
    }
    String ans = "[";
    //transversing list
    Node<T> current = start;
    while(current != null){
      ans += (current.getData()+", ");
      current = current.next();
    }
    return ans.substring(0,ans.length()-2)+"]";
  }

  public static void main(String args[]){
    MyLinkedList<Integer> l1 = new MyLinkedList<>();
    MyLinkedList<Integer> l2 = new MyLinkedList<>();
    System.out.println(l1);
    System.out.println(l2);
    for(int i = 0; i < 20; i++){
      l1.addEnd(i);
      l1.addFront(i);
    }
    for(int i = 0; i < 40; i++){
      System.out.println(l1.removeFront());
    }
    System.out.println(l1);
    for(int i = 0; i<20;i++){
      l1.addEnd(i);
      l2.addFront(i*2);
    }
    System.out.println(l1);
    System.out.println(l2);
    l1.extend(l2);
    System.out.println(l1);
    System.out.println(l2);
  }
}
