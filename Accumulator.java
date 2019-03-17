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

/* 3.  Stumbling block 0
              Java protects a programmer against applying a method to
              elements in list when some elements of the list might
              omit support for a particular operation.
              This protection is implemented by the compiler
              The following code violates the restriction:
             */
           // [code that violates the restriction]
           /*
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
           /*
            predicted error message: "cannot find symbol"
            actual error message:
              error: cannot find symbol
			           if (element.startsWith("h"))
			                      ^
              symbol:   method startsWith(String)
              location: variable element of type Object
            */
/* 4.  Workaround 0
              A programmer should expect there to be a way to
              work around the stumbling block, because
              the JVM knows the type of an element.
              Java's instanceof operator identifies the type
              of an element to the JVM.
            */
  /* 5.  Stumbling block 1
              However, use of the operator alone is insufficient,
              because the compiler
              objects to the following code that adds use of
              the operator to the code from Stumbling block 0:
            */
            /* Code:

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
             /*
              predicted error message: "cannot find symbol"
              actual error message:
                error: cannot find symbol
  			           if (element.startsWith("h"))
  			                      ^
                symbol:   method startsWith(String)
                location: variable element of type Object
              */

/* 6. Workaround 1
            Programmers use Java's casting facility
            to tell the compiler
            that code uses a subclass's method on an object,
            even though the reference to the object is stored
            in a super-class variable.
            */

/* 7. Stumbling block 2
            However, use of this operator alone is insufficient,
            because the compiler
            objects to the following code that adds use of
            the operator to the code from Stumbling block 0:
            */
            /* Code:
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
             */
             /*
             predicted error message: cannot be cast

             actual error message:
             Exception in thread "main" java.lang.ClassCastException: java.base/java.lang.Integer cannot be cast to java.base/java.lang.String
	             at Test.main(Test.java:12)

        Use of that facility alone is insufficient because the JVM stumbles over not being able to cast certain subclasses of Object into other subclasses.
        For example, it can't convert Integer to String, so a runtime error occurs.
             */
/* 8. Workaround 2
            A programmer can combine use of both operators
            to apply a method to exactly those
            elements in the list that support the method.
            */

/*

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
