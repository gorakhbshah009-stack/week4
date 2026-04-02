package workshop5;

// final class - cannot be extended
final class FinalClass {
    public void show() {
        System.out.println("I am a final class!");
    }
}

// Uncommenting the line below would cause a COMPILE ERROR:
// class TryExtend extends FinalClass { }  // ERROR: cannot inherit from final FinalClass

// ---- Final Method Demo ----
class BaseWithFinalMethod {
    // final method - cannot be overridden
    public final void finalMethod() {
        System.out.println("This is a final method.");
    }

    public void normalMethod() {
        System.out.println("This is a normal method.");
    }
}

class SubOfBase extends BaseWithFinalMethod {
    // Uncommenting the below would cause a COMPILE ERROR:
    // public void finalMethod() { }  // ERROR: cannot override final method

    @Override
    public void normalMethod() {
        System.out.println("Overridden normal method.");
    }

    public static void main(String[] args) {
        System.out.println("--- Final Class & Method Demo ---");

        FinalClass fc = new FinalClass();
        fc.show();

        SubOfBase obj = new SubOfBase();
        obj.finalMethod();   // runs the final method from parent
        obj.normalMethod();  // runs the overridden method
    }
}
