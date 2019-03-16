
public class Accumulator {

  public static String catElementsStartingWith (List_inArraySlots list, String pre) {

		String s = "";

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) instanceof String) {

				if (((String)list.get(i)).startsWith("pi"))
				s += list.get(i);
			}
		}

		return s;
	}
}
