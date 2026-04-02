package workshop5;

// Demonstrates the super keyword
class AnimalSuper {
    String name;

    public AnimalSuper(String name) {
        this.name = name;
        System.out.println("Animal constructor called. Name: " + name);
    }
}

class DogSuper extends AnimalSuper {
    String breed;

    public DogSuper(String name, String breed) {
        super(name); // calling Animal's constructor
        this.breed = breed;
        System.out.println("Dog constructor called. Breed: " + breed);
    }

    public static void main(String[] args) {
        System.out.println("--- Super Keyword Demo ---");
        DogSuper d = new DogSuper("Max", "Poodle");
        System.out.println("Name: " + d.name + ", Breed: " + d.breed);
    }
}
