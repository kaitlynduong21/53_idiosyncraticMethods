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

  public boolean add (Object element) {

	if (list.length == filledElements)
	expand();

	list[filledElements] = element;
	filledElements++;

	return true;
  }

  /* public boolean add( int type   // same meaning as in typeOfElements
                              , Integer intValue
                              , Double doubleValue
                              , String stringValue
                              ) {
	     if(list.length == filledElements)
       expand();
       if (type == 0) {
         list[filledElements] = intValue;
       } else {
         if (type == 1) {
           list[filledElements] = doubleValue;
         } else {
           list[filledElements] = stringValue;
         }
       }
       filledElements++;
       return true;
     } //element each time an add method is invoked.
    */

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
