import java.util.*;

public class UserOfList {
    public static void main( String[] args ) {
        List_inArraySlots list = new List_inArraySlots();

        list.add(3.14);
	list.add("piazza");
	list.add(6.28);
	list.add("pi");
	list.add(256);
	list.add(Double.POSITIVE_INFINITY);
	list.add("tau");
	list.add("pizza");
	list.add(1e4);
	list.add(Double.NEGATIVE_INFINITY);

	System.out.println(list);

	System.out.println(list.catElementsStartingWith("pi"));
    }
}
