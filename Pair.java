public class Pair<E1,E2> {

   E1 e1;
   E2 e2;
   public Pair(E1 e1, E2 e2)
   {
      this.e1 = e1; this.e2 = e2;
   }
   public E1 first()
   {
      return e1;
   }
   public E2 second()
   {
      return e2;
   }

}

