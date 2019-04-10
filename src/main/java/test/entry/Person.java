package test.entry;

public class Person {

    private String name;

    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person per = (Person) obj;
            if(this.name == null && per.getName() == null){
                if(this.age == per.getAge()){
                    return true;
                }
            }
            if(this.name != null && per.getName() != null){
                if(this.name.equals(per.getName()) && this.age == per.getAge()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result*31 + (this.name == null ? 0 : this.name.hashCode());
        System.out.println(this.name.hashCode());
        result = result*31 + age;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
