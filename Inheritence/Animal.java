class Animal {
    private String name ;
    private int age;

    Animal(String name , int age){
        this.name=name;
        this.age=age;
    }
    void displayInfo(){
        System.out.println("Name :"+ name + "Age :" + age);
    }
    void makesound(){
        System.out.println("Animal Sounds");
    }

}
class cat extends Animal{
    cat(String name , int age){
        super(name,age);
    }
    @Override
    void makesound() {
        System.out.println("..meow..");
    }


}
class Dog extends Animal{
    Dog(String name , int age){
        super(name , age);
    }
    @Override
    void makesound() {
        System.out.println("..barks..");
    }

}
class Bird extends Animal{
    Bird(String name , int age){
        super(name , age);
    }
    @Override
    void makesound() {
        System.out.println("..Chirps..");
    }

}
class Main{
    public static void main(String[] args) {
        Animal Dog = new Dog("Sheru ," , 5);
        Animal cat = new cat("Choco ," , 9);
        Animal Bird = new Bird("pheco ," , 7);

        Dog.displayInfo();
        Dog.makesound();

        cat.displayInfo();
        cat.makesound();

        Bird.displayInfo();
        Bird.makesound();

    }
}
