package XMLTest;

public class Person
{
    public String name, lastName;
    public int age;

    public Person(String name, String lastName, int age)
    {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
