public class List_inArraySlots {

  private Object[] list;
  private int filledElements; // the number of elements in this list
  private static final int INITIAL_CAPACITY = 10;

  public List_inArraySlots() {
    list = new Object [INITIAL_CAPACITY];
  }

  /**
  @return the number of elements in this list
 */
  public int size() {
    return filledElements;
  }

  public String toString() {
      String s = "[";
      for (int index = 0; index < filledElements; index++ ) {
        s += list[index] + ",";
      }
      return s+= "]";
  }

	public String catElementsStartingWith (String pre) {

		String s = "";

		for (int i = 0; i < filledElements; i++) {

			if (list[i] instanceof String) {
			
				if (((String)list[i]).startsWith("pi"))
				s += list[i];
			}
		}
		
		return s;
	}

  public boolean add (Object element) {

	if (list.length == filledElements)
	expand();

	list[filledElements] = element;
	filledElements++;

	return true;
  }

    private void expand() {
	      Object[] expandedList = new Object [list.length * 2];
        for (int i = 0; i < list.length; i++) {
      	   expandedList[i] = list[i];
    	  }
        list = expandedList;
      }

      public Object get(int index) {
          return list[index];
      }
}
