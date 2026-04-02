package workshop5;

// Demonstrates private, protected, and public access
class Parent {
    private int privateVar = 10;      // only inside Parent
    protected int protectedVar = 20;  // Parent + subclasses
    public int publicVar = 30;        // everywhere

    public int getPrivateVar() {      // getter to access private from outside
        return privateVar;
    }
}

class Child extends Parent {

    public void showVars() {
        // privateVar is NOT directly accessible here (would cause compile error)
        // System.out.println(privateVar); // ERROR!

        System.out.println("Protected Var: " + protectedVar);  // OK
        System.out.println("Public Var: " + publicVar);        // OK
        System.out.println("Private Var (via getter): " + getPrivateVar()); // OK
    }

    public static void main(String[] args) {
        System.out.println("--- Access Modifiers Demo ---");
        Child child = new Child();
        child.showVars();
    }
}
