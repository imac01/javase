package eu.ase.jcf;

import java.util.HashMap;
import java.util.Map;

 class Person {

    String name;
    Integer age;


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        if (name != null ? !name.equals(person.name) : person.name != null) 
		return false;
        
	return age != null ? age.equals(person.age) : person.age == null;
        //return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        
	result = 31 * result + (age != null ? age.hashCode() : 0);
        
	return result;
        
	//return 30;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class MapExample {

    // HashMap - when calling put(k,v) the hashCode() of the key object! is called;
    // when calling get() - the equals() method is called

    // bucket 1 -> Map.Entry a -> Map.Entry b -> ... (linked list)
    // bucket 2 -> Map.Entry a -> ...
    // bucket - items which have the same hashCode

    /**
     * What will happen if two different HashMap  key objects have the same hashcode?
     * They will be stored in the same bucket but no next node of linked list.
     * And keys equals () method will be used to identify correct key value pair in HashMap.
     */

    // HM.put(k,v) -> k.hashCode() //30 -> bucket(30)
    //HM.... -> k.hashCode() //40 -> bucket(40)
    //HM ... -> k.hashCode() //30 -> bucket(30)

    //HM.get(k) -> k.hashCode() && k.equals()

    public static void main(String[] args) {
        Map<Person, Integer> test = new HashMap<Person, Integer>();

        Person p1 = new Person("Lili", 25);
        Person p2 = new Person("Lulu", 28);

        test.put(p1, 2100);
        test.put(p2, 3000);

        System.out.println(test); // Lulu is retrieved

    } //end main

} //end class
