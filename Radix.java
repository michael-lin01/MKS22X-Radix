import java.util.*;

public class Radix{
  //extend array to include negatives
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    int max = data[0];
    for(int i: data){
      if(i>max) max = i;
    }

    MyLinkedList<Integer>[] buckets = new MyLinkedList[19];
    MyLinkedList<Integer> temp = new MyLinkedList<>();

    for(int i = 0; i < buckets.length;i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    for(int i = 0; i < data.length;i++){
      temp.addEnd(data[i]);
    }

    for(int place = 1; max/place > 0; place*=10){
      for(int i = 0; i < data.length;i++){
        int front = temp.removeFront();
        //add to appropriate bucket
        /*
        System.out.println(front);
        System.out.println(temp);
        System.out.println("place: "+front/place%10);
        */
        if(front >= 0) buckets[9+front/place%10].addEnd(front);
        else buckets[9+front/place%10].addFront(front);
      }
      for(int i = 0; i < buckets.length;i++){
        //System.out.println(buckets[i]);
        //System.out.println(temp);
        if(buckets[i].size()>0) temp.extend(buckets[i]);
      }
      //System.out.println( ""+place+" pass: "+temp);
    }
    for(int i = 0; i < data.length;i++){
      data[i]=temp.removeFront();
    }
  }

  public static void main(String args[]){
    int[] data = {2,3,5,10,2,15,25};
    radixsort(data);
    System.out.println(Arrays.toString(data));
  }
}
