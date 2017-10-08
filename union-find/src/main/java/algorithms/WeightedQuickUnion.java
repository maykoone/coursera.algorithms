package algorithms;

/**
 * Created by maykoone on 07/10/17.
 */
public class WeightedQuickUnion extends QuickUnion implements UnionFind {

    private int[] sz;
    public WeightedQuickUnion(int numberOfObjects) {
        super(numberOfObjects);

        sz = new int[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) {
            sz[i] = i;
        }
    }

    private int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(i == j) return;
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
