object InsertTest {

    /**
     * Write a recursive Scala function that returns the element at index k in a list. 
     */
    def get[A](l : List[A], k : Int) : A = {
        if (k == 0)
           l.head
        else
            get(l.tail, k-1);
    }


    /**
     *Write a recursive Scala function that inserts an element x at index k into an 
     * existing immutable Scala list and returns a new list. 
     */
    def insert[A](l : List[A], x : A, k : Int) : List[A]= {
        if (k == 0)
            x :: l
        else
            l.head :: insert(l.tail, x, k-1)
    }


    def main(args: Array[String]): Unit = {
        val li : List[Integer] = List(1,2,3,4,5);

        println(get(li, 3)); // Should print 4

        val res1 = insert(li,7,0);
        println(res1); // Should print 7,1,2,3,4,5

        val res2 = insert(li,7,2);
        println(res2); // Should print 1,2,7,3,4,5
        
        val res3 = insert(li,7,5);
        println(res3); // Should print 1,2,3,4,5,7

    }

}
