import java.util.*;

public class Radix{
  //extend array to include negatives
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    int max = Math.abs(data[0]);
    for(int i: data){
      if(Math.abs(i)>max) max = Math.abs(i);
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
      temp.reset();
      for(int i = 0; i < data.length;i++){
        int n = temp.next();
        //System.out.println(n);
        //add to appropriate bucket
        buckets[9+n/place%10].addEnd(n);
      }
      temp.clear();
      for(int i = 0; i < buckets.length;i++){
        //System.out.println("bucket "+i+": "+buckets[i]);
        if(buckets[i].size()>0) {
          temp.extend(buckets[i]);
          //System.out.println("temp: "+temp);
        }
      }
    }
    for(int i = 0; i < data.length;i++){
      data[i]=temp.removeFront();
    }
  }

  public static void main(String args[]){
    System.out.println(Math.pow(-1,(1+(int)(Math.random()*2))));
    int[] data = {2,3,5,10,2,15,25,-12,-19,-99,-109,-20};
    radixsort(data);
    System.out.println(Arrays.toString(data));
  }
}
