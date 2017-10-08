package algorithms;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by maykoone on 02/10/17.
 */
public abstract class UnionFindTest {
    public static final String FILE_NAME = "tinyUF.txt";
    private static Logger log = LoggerFactory.getLogger(UnionFind.class.getName());

    private UnionFind subject;
    public static final int NUMBER_OF_OBJECTS = 10;

    //    @BeforeClass
    public static void setupClass() throws IOException {
        log.info("Read file {}", FILE_NAME);
        Scanner scanner = new Scanner(UnionFind.class.getClassLoader().getResourceAsStream(FILE_NAME));
        int n = scanner.nextInt();
        log.info("N objects is {}", n);
        while (scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            log.info("pair objects is p:{} and q:{}", p, q);
        }
    }


    @Before
    public void setup() {
        subject = createInstanceWithNumberOfObjects(NUMBER_OF_OBJECTS);
    }

    protected abstract UnionFind createInstanceWithNumberOfObjects(int n);


    @Test
    public void shouldBeInitializedWithNumberOfObjects() {
        assertEquals(NUMBER_OF_OBJECTS, subject.size());
    }

    @Test
    public void shouldBeConnectedAfterUnion() {
        subject.union(6, 1);

        assertTrue(subject.connected(6, 1));
    }

    @Test
    public void shouldNotBeConnected(){
        assertFalse(subject.connected(6, 1));
    }

    @Test
    public void shouldBeReflexive(){
        assertTrue(subject.connected(1, 1));
    }

    @Test
    public void shouldBeSymmetric() {
        int p = 5;
        int q = 0;
        subject.union(p, q);

        assertTrue(subject.connected(p, q)
                    && subject.connected(q, p));
    }

    @Test
    public void shouldBeTransitive() {
        int p = 3;
        int q = 7;
        int r = 2;

        subject.union(p, q);
        subject.union(q, r);

        assertTrue(subject.connected(p, r));
    }

}
