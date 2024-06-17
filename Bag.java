package www;

public class Bag {



        public static int rec_opt(int[] arr,int i){
            if(i==0) return arr[0];
		else if(i==1) return arr[0]>arr[1]?arr[0]:arr[1];
            else {
                int a = rec_opt(arr, i-2)+arr[i];
                int b = rec_opt(arr, i-1);
                return a>b?a:b;
            }
        }

        public static int dp_opt(int[] arr) {
            int[] opt = new int[arr.length];
            opt[0] = arr[0];
            opt[1] = arr[0]>arr[1]?arr[0]:arr[1];
            for(int i=2;i<opt.length;i++) {
                int a = opt[i-2]+arr[i];
                int b = opt[i-1];
                opt[i] = a>b?a:b;
            }
            return opt[arr.length-1];
        }

        public static void main(String[] args) {
            int[] arr = {4,1,1,9,1};
            System.out.println(dp_opt(arr));
            System.out.println(rec_opt(arr,arr.length-1));
        }


    }