package csd.starter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class Prime {


    public static List factor(Integer i, List<Integer> result){
        if(result == null){
            result = new ArrayList<Integer>();
        }
        if(i == 1){
            return result;
        }else{
            for(int t = 2; t <=i; t++){
                if(i%t==0){
                    result.add(t);
                    if(i == t){
                        return result;
                    }else{
                        return factor(i/t, result);
                    }

                }
            }
        }
        return result;
    }

    public static <T> List<T> extractPrimeFactor(int i) {
        return factor(i, null);
    }
}
