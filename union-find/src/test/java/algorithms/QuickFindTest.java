package algorithms;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by maykoone on 07/10/17.
 */
@RunWith(JUnit4.class)
public class QuickFindTest extends UnionFindTest{
    @Override
    protected UnionFind createInstanceWithNumberOfObjects(int n) {
        return new QuickFind(10);
    }
}
