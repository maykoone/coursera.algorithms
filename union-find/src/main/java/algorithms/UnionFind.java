package algorithms;

/**
 * Created by maykoone on 02/10/17.
 */
public interface UnionFind {

    void union(int p, int q);
    boolean connected(int p, int q);

    int size();
}
