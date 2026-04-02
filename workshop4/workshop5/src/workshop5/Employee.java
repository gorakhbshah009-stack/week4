package workshop5;

// Demonstrates protected keyword
class Person {
    protected String address; // accessible in subclass

    public Person(String address) {
        this.address = address;
    }
}

class Employee extends Person {
    String department;

    public Employee(String address, String department) {
        super(address);
        this.department = department;
    }

    public void display() {
        // Can access 'address' because it is protected
        System.out.println("Address: " + address);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        System.out.println("--- Protected Keyword Demo ---");
        Employee emp = new Employee("123 Main St", "IT");
        emp.display();
    }
}
