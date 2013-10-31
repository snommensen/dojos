import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=1585&rd=6535
 */
public class BusinessTasks {

    public String getTask(String[] list, int n) {
        LinkedList<String> internalList = new LinkedList<>(Arrays.asList(list));
        int idx = 0;
        while (internalList.size() > 1) {
            idx = calculateListIndex(internalList.size(), idx + n);
            internalList.remove(idx);
        }
        return internalList.get(0);
    }

    int calculateListIndex(int listSize, int n) {
        return (n - 1) % listSize;
    }
}
