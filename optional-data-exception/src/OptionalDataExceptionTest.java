import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalDataExceptionTest {

    private File file;

    @BeforeEach
    void setUp() {
        file = new File("/tmp/out");
    }

    @Test
    void serialize_정상적인_상황() throws Exception {

        // given
        Person write1st = new Person("al-Khwārizmī", 1237);
        Person write2nd = new Person("Fibonacci", 847);
        int write3rd = 3;

        // given
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(write1st);
        oos.writeObject(write2nd);
        oos.writeInt(write3rd);
        oos.close();

        // when
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person read1st = Person.class.cast(ois.readObject());
        Person read2nd = Person.class.cast(ois.readObject());
        int read3rd = ois.readInt();
        ois.close();

        // then
        assertEquals(write1st, read1st);
        assertEquals(write2nd, read2nd);
        assertEquals(write3rd, read3rd);
    }

    @Test
    void serialize_다음_읽기순서가_원시타입인데_객체로_읽기를_시도하면_ODE_예외가_발생한다() throws Exception {

        // given
        Person write1st = new Person("al-Khwārizmī", 1237);
        Person write2nd = new Person("Fibonacci", 847);
        int write3rd = 3;

        // given
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(write1st);
        oos.writeObject(write2nd);
        oos.writeInt(write3rd);
        oos.close();

        // given
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ois.readObject();
        ois.readObject();

        // when
        assertThrows(OptionalDataException.class, () -> {

            // 원시 타입인데 객체로 읽으려고 시도
            ois.readObject();
        });
    }

    @Test
    void serialize_readObject_직접_구현시_EOF를_지난_읽기를_시도하면_ODE_예외가_발생한다() throws Exception {

        // given
        PersonWithSerializeHandling person =
                new PersonWithSerializeHandling("al-Khwārizmī", 1237);

        // given
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(person);
        oos.close();

        // given
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        // when
        assertThrows(OptionalDataException.class, () -> {

            // `readObject` 직접 구현시, EOF 지난 읽기를 시도
            ois.readObject();
        });
    }

    @AfterEach
    void tearDown() throws IOException {
        file.delete();
    }
}

class Person implements Serializable {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}

class PersonWithSerializeHandling implements Serializable {

    private String name;
    private Integer age;

    PersonWithSerializeHandling(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(name);
//        out.writeObject(age); // 고의로 누락시킨 writeObject
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = String.class.cast(in.readObject());
        age = Integer.class.cast(in.readObject());
    }
}