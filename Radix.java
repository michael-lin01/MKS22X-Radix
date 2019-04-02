import java.util.*;

public class Radix{
  //extend array to include negatives
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    int max = data[0];
    for(int i: data){
      if(i>max) max = i;
    }

    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for(int i = 0; i < buckets.length;i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    for(int place = 1; max/place > 0; place*=10){
      for(int i = 0; i < data.length;i++){
        //if number's nth place > 0
        if(data[i]/(place)>0){
          //add to appropriate bucket
          buckets[data[i]/place%10].addEnd(data[i]);
        }
      }
    }
  }

  public static void main(String args[]){
    int[] data = new int[10];
    radixsort(data);
  }
}
