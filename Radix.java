public class Radix{
  //extend array to include negatives
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList<Integer>[10];
    for(int i = 0; i < buckets.length;i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    int place = 1;
    for(int i = 0; i < data.length;i++){
      if(data[i]/(place)>0){
        buckets[data[i]/place%10].addEnd(data[i]);
      }
    }
  }
}
