package algorithms;

/**
 * Created by maykoone on 07/10/17.
 */
public class WeightedQuickUnionTest extends UnionFindTest {
    @Override
    protected UnionFind createInstanceWithNumberOfObjects(int n) {
        return new WeightedQuickUnion(n);
    }
}
