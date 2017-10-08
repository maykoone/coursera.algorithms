package algorithms;

/**
 * Created by maykoone on 07/10/17.
 */
public class QuickUnion implements UnionFind {
    private int[] id;

    public QuickUnion(int numberOfObjects) {
        id = new int[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int size() {
        return id.length;
    }

    private int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

}
