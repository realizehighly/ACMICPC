package LowerUpperBound;

public class upperbound {
    static int[] arr={1,2,3,4,5};

    static int upper_bound(int first, int last, int key){
        while(first<last){
            int mid = (first+last)/2;
            if(arr[mid]<=key)
                first = mid+1;
            else last = mid;
        }
        return last;
    }

    static int lower_bound(int first, int last, int key){
        while(first<last){
            int mid = (first+last)/2;
            if(arr[mid]>=key)
                last= mid;
            else first = mid+1;
        }
        return first;
    }
    public static void main(String[] args) {
        System.out.println(upper_bound(0,arr.length,4));
        System.out.println(lower_bound(0,arr.length,4));
    }
}
