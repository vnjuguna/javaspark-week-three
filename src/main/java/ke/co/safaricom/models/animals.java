package ke.co.safaricom.models;

public class animals {
        private int id;
        private String name;
        private boolean endangered;
        private int age;
        private String health;

    // Constructors, getters, and setters for the properties

        public animals() {
        //this.deleted = false;
     }

    @Override
    public String toString() {
        return "animals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", endangered=" + endangered +
                ", age=" + age +
                ", health='" + health + '\'' +
                '}';
    }

    public animals(int id, String name, boolean endangered, int age, String health) {
        this.id = id;
        this.name = name;
        this.endangered = endangered;
        this.age = age;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }



    }



