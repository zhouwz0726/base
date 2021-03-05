package base.JDK8.Stream;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StreamDemo {

    private static final String[] nameArray = {"张三", "李四", "王五", "李六"};

    public static void main(String[] args) {

        List<Person> personList = getStringList();
        //将strList转化成流
        Stream<Person> personListStream = personList.stream();

        //map方法，用于映射每个元素到对应的结果，通俗的说，可以将对象转化为其他对象,类似类型转换，比如下面的我将personList转为一个list<String>
        List<String> nameList = personList.stream().map(Person::getName).collect(toList());
        nameList.forEach(System.out::println);

        //filter方法用于设置条件过滤出元素，最后的collect(toList())，是将结果转成一个List
        List<Person> filterList = personList.stream().filter(person -> person.getAge() > 22).collect(toList());
        println(filterList);

        //reduce方法，用于组合流中的元素，如求和，求最大值，求积；
        //reduce方法有三个重写的方法，第一个重写，一个参数，比如需要求和，reduce(BinaryOperator<T> accumulator)，注意这里返回的是Optional类型
        Optional<Integer> s1 = personList.stream().map(person -> person.getAge()).reduce((a, b) -> a+b);
        System.out.println(s1.get());
        //reduce方法的第二个重写，二个参数，该方法和上一个很像，只不过他可以定义一个初始值，即，第一个参数的值；
        Integer s2 = personList.stream().map(person -> person.getAge()).reduce(1,(a,b)-> a+b);
        System.out.println(s2);
        //reduce方法的第三个重写，三个参数，第一：参数传递要返回的对象；第二：累加器；第三个参数用于并行计算下合并各个线程的计算结果
        Integer s3 = personList.stream().map(person -> person.getAge()).reduce(55,(a,b)-> a+b,(a,b)-> a+b);
        System.out.println(s3);

        //anyMatch方法，流中是否有一个元素匹配给定的条件
        boolean b = personList.stream().anyMatch(person -> person.getAge() == 18);
        System.out.println(b);

        //sorted方法用于对流进行排序，下面的例子是从大到小
        List<Person> sortedList = personList.stream().sorted((p1,p2) -> p2.getAge() - p1.getAge()).collect(toList());
        //简化后写法，顺序排序
        List<Person> sortedList1 = personList.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(toList());
        //简化后写法，逆序排序
        List<Person> sortedList2 = personList.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).collect(toList());
        println(sortedList2);

        //limit方法，参数为n，返回前n个元素
        List<Person> limitList = personList.stream().limit(2).collect(toList());
        println(limitList);

        //skip方法，参数为n，去除前n个元素
        List<Person> skipList = personList.stream().skip(3).collect(toList());
        println(skipList);

    }

    /**
     * 输出到控制台
     * @param list 需要输出的数据
     * */
    private static void println(List<Person> list) {
        for (Person p: list) {
            System.out.println(p.getName()+ ":" + p.getAge());
        }
    }

    /**
     * 组装数据
     * @return 组装的List<Person>数据
     * */
    private static List<Person> getStringList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Person person = new Person();
            person.setName(nameArray[i]);
            person.setAge(i+20);
            personList.add(person);
        }
        Person person = new Person();
        person.setAge(18);
        person.setName("周一");
        personList.add(person);
        return personList;
    }
}
