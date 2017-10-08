package algorithms;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

/**
 * Created by maykoone on 02/10/17.
 */
public abstract class UnionFindTest {
    public static final String FILE_NAME = "tinyUF.txt";
    private static Logger log = LoggerFactory.getLogger(UnionFind.class.getName());

    private UnionFind subject;
    public static final int NUMBER_OF_OBJECTS = 10;

    //    @BeforeClass
    public static void setup() throws IOException {
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

    protected abstract UnionFind createInstanceWithNumberOfObjects(int n);


    @Test
    public void shouldBeInitializedWithNumberOfObjects() {
        subject = createInstanceWithNumberOfObjects(NUMBER_OF_OBJECTS);
        Assert.assertEquals(NUMBER_OF_OBJECTS, subject.size());
    }

    @Test
    public void shouldBeConnectedAfterUnion() {
        subject = createInstanceWithNumberOfObjects(NUMBER_OF_OBJECTS);

        subject.union(6, 1);

        Assert.assertTrue(subject.connected(6, 1));
    }

    @Test
    public void shouldNotBeConnected(){
        subject = createInstanceWithNumberOfObjects(NUMBER_OF_OBJECTS);

        Assert.assertFalse(subject.connected(6, 1));
    }

}
