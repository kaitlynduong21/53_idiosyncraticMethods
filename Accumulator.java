/*
Java protects a programmer against applying a method to elements in list when some elements of the list might omit support for a particular operation.

This protection is implemented by the compiler. The following attempt to violate the restriction is expected to result in the error "cannot find symbol".

public class Test {

	public static void main (String[] args) {

		Object[] list =  new Object[5];

		list[0] = 1;
		list[1] = 3.14;
		list[2] = "hi";
		list[3] = "there";
		list[4] = 420;

		for (Object element : list) {

			if (element.startsWith("h"))
			System.out.println(element);
		}
	}
}
*/

/*
A programmer should expect to be able to work around the stumbling block because the JVM knows the type of an element.

Java's new operator identifies the type of an element to the JVM
*/

/*
Use of the operator alone is insufficient because the compiler continues to stumble over the previous stumbling block of protection against mis-applying a method.

public class Test {

	public static void main (String[] args) {

		Object[] list =  new Object[1];

		list[0] = new String("hi");

		for (Object element : list) {

			if (element.startsWith("h"))
			System.out.println(element);
		}
	}
}

predicted error message: cannot find symbol

cannot find symbol
*/

/*
Java provides a casting facility that a programmer uses to tell the compiler that they are using a subclass's method on an object for which a reference is stored in a super-type variable.

public class Test {

	public static void main (String[] args) {

		Object[] list =  new Object[2];

		list[0] = new String("hi");
    list[1] = 1;

		for (Object element : list) {

			if (((String) element).startsWith("h"))
			System.out.println(element);
		}
	}
}


But use of that facility alone is insufficient because the JVM stumbles over not being able to cast certain subclasses of Object into other subclasses.
For example, it can't convert Integer to String, so a runtime error occurs.

predicted error message: cannot be cast

java.base/java.lang.Integer cannot be cast to java.base/java.lang.String
*/

/*
A programmer can combine use of the operator and the facility to apply a method to exactly those elements in the list that support the method.

public class Test {

	public static void main (String[] args) {

		Object[] list =  new Object[2];

		list[0] = new String("hi");
    list[1] = 1;

		for (Object element : list) {

      if(element instanceof String) {
			   if (((String) element).startsWith("h"))
			      System.out.println(element);
		  }
	  }
  }
}
*/

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

  public static List_inArraySlots finites(List_inArraySlots list) {

    List_inArraySlots finites = new List_inArraySlots();

    for (int i = 0; i < list.size(); i++) {

			if (list.get(i) instanceof Double) {

				if (! (((Double)list.get(i)).isInfinite()))
				finites.add(list.get(i));
			}
		}

		return finites;
  }
}
