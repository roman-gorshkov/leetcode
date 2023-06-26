import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        List<Person> persons = Data.getPersons();

        List<Person> persons2 = persons.stream()
//                    .map(person -> new Person(person.getFirstName(), person.getLastName(), person.getAge() + 100))
                    .filter(p -> p.getAge() > 30)
                    .sorted()
                    .collect(Collectors.toList());

        persons2.forEach(p -> System.out.println(p));
    }
}
