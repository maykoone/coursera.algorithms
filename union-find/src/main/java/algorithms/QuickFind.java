package algorithms;

/**
 * Created by maykoone on 07/10/17.
 */
public class QuickFind implements UnionFind {
    private int[] id;

    public QuickFind(int numberOfObjects) {
        id = new int[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int size() {
        return id.length;
    }
}
