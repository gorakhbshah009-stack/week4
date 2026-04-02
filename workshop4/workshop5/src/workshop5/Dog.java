package workshop5;

// Subclass inheriting Animal
public class Dog extends Animal {
    String breed;

    // Constructor using super
    public Dog(String name, int age, String breed) {
        super(name, age); // calls Animal constructor
        this.breed = breed;
    }

    public void display() {
        super.display();
        System.out.println("Breed: " + breed);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Labrador");
        System.out.println("--- Dog Details ---");
        dog.display();
    }
}
