import java.util.Arrays;
import java.util.LinkedList;

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
