public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void finalize() {
        System.out.println(name + " is being garbage collected");
    }

    public static void main(String[] args) {
        Person p1 = new Person("John");
        Person p2 = new Person("Jane");
        p1 = null; //making p1 eligible for garbage collection
        p2 = null; //making p2 eligible for garbage collection

        System.gc(); //requesting garbage collector to run
             System.out.println( " is being garbage collected");

    }
}
