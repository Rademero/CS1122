import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mearge {

    public static ArrayList<Integer> merg(ArrayList<Integer> list,ArrayList<Integer> list2){
        ArrayList<Integer> mergrdList = new ArrayList<>();
        while (!list.isEmpty() && !list2.isEmpty()){
            if(!mergrdList.isEmpty() &&list.get(0) == mergrdList.get(mergrdList.size()-1)){
                list.remove(0);
            }else if(!mergrdList.isEmpty() && list2.get(0) == mergrdList.get(mergrdList.size()-1)){
                list2.remove(0);
            }
            else if (list.get(0)<=list2.get(0)){
                mergrdList.add(list.get(0));
                list.remove(0);
            }else {
                mergrdList.add(list2.get(0));
                list2.remove(0);
            }
        }
        while (!list.isEmpty()) {
            if (!mergrdList.isEmpty() && list.get(0) == mergrdList.get(mergrdList.size() - 1)) {
                list.remove(0);
            } else {
                mergrdList.add(list.get(0));
                list.remove(0);
            }
        }
        while (!list2.isEmpty()){
            if(!mergrdList.isEmpty() && list2.get(0) == mergrdList.get(mergrdList.size()-1)){
                list2.remove(0);
            }else {
                mergrdList.add(list2.get(0));
                list2.remove(0);
            }
        }
        return mergrdList;
    }

    public static void main(String[] args) {
        System.out.println(merg(new ArrayList<Integer>(Arrays.asList(new Integer[] {1,4,4,8})),
                new ArrayList<Integer>(Arrays.asList(new Integer[] {2,3,4,9,9}))));
        //nlogn
    }
}

