package Exercise4;

import java.util.Objects;

public class Student {
    private final String name;
    private final Integer age;
    private final Gender gender; // исправил тип с Sex на Gender

    public Student(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;

    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false; // исправил синтаксис instanceof
        Student student = (Student) o; // исправил приведение типа с маленькой буквы
        return Objects.equals(name, student.name) && // исправил точку на запятую
                Objects.equals(age, student.age) &&
                Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

}
