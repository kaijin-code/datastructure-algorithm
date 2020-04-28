package main.java.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 合并两个有序数组
 */
public class MergeArray {

    public static ArrayList<Integer> merge(int[] a, int[] b){
        //生产的处理结果的数组
        ArrayList<Integer> t = new ArrayList<>();

        int ak = 0;

        int bk = 0;
        //a、 b数组里面元素是否都已经被处理
        boolean isAOk = false;
        boolean isBOk = false;
        //a ,b数组都已经处理结束
        boolean isOk = false;

        while(!isOk){
            if( !isAOk && a[ak] < b[bk]){
                t.add(a[ak]);

                if(ak < a.length - 1){
                    ak++;
                }else{
                    isAOk = true;
                    //a处理完，直接把b数组剩下的加进去即可
                    for(int tmp = bk; tmp < b.length; tmp++){
                        t.add(b[tmp]);
                    }
                    //a,b都处理完 程序结束
                    isOk = true;
                }
            }else if(!isBOk && a[ak] > b[bk]){
                t.add(b[bk]);
                if(bk < b.length - 1){
                    bk++;
                }else {
                    isBOk = true;
                    for (int tmp = ak; tmp < a.length; tmp++) {
                        t.add(a[tmp]);
                    }
                    isOk = true;
                }
            }

        }
        return t;

    }

    public static void main(String[] args) {
        int[] a = {1,3,7};
        int[] b = {4, 8,10};
        ArrayList result = merge(a, b);
        result.forEach(e-> System.out.println(e));
    }
}
