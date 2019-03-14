/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements = 0; // the number of elements in this list

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private Element currentElement = new Element();
    private Object[] arrayOfElements;

    private static final int INITIAL_CAPACITY = 10;
    private static final int INTEGER_TYPE = 0;
    private static final int DOUBLE_TYPE = 1;
    private static final int STRING_TYPE = 2;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
      intElements = new int[INITIAL_CAPACITY];
      doubleElements = new double[INITIAL_CAPACITY];
      stringElements = new String[INITIAL_CAPACITY];
      typeOfElements = new int[INITIAL_CAPACITY];
      arrayOfElements = new Object[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
      return filledElements;
    }

    public Object get(int index) {
      return arrayOfElements[index];
    }

     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
      String result = "[";
      int index;
      for( index = 0; index < filledElements; index++) {
        result += get(index) + ",";
      }
    return result + "]";
  }

    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int    intVal
                       , double doubleVal
                       , String stringVal
                       ) {
      //Fills in appropriate array with value
      //fills in other arrays with useless values to be ignored
      if (filledElements == typeOfElements.length) expand();
      if (type == 0){
        Integer integerValue = intVal;
        arrayOfElements[filledElements] = integerValue;
      }
      if (type == 1){
        Double doubleValue = doubleVal;
        arrayOfElements[filledElements] = doubleValue;
      }
      if (type == 2){
        arrayOfElements[filledElements] = stringVal;
      }
      filledElements++;
      return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");

        //expanding the intElements array
        Object[] biggerArrayOfElements = new Object[ filledElements * 2];
        for(int elemIndex = 0; elemIndex < filledElements; elemIndex++)
          biggerArrayOfElements[elemIndex] = arrayOfElements[elemIndex];
        arrayOfElements = biggerArrayOfElements;

           // /* S.O.P. rules for debugging:
              // Working methods should be silent. But during
              // development, the programmer must verify that
              // this method is called when that is appropriate.
              // So test using the println(), then comment it out.
              // */
     }
}
