package org.gradoop.common.sort;

public class NameAgeTuple {
    String name;
    int age;

    public NameAgeTuple(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * CS427 https://github.com/dbs-leipzig/gradoop/issues/185
     * <p> Contents of the sorted info object can be given in String format
     * @return Name Age Tuple Object in String format
     */
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
