package Graph;

/**
 * 并查集,用于解决集合所属问题
 * 
 * @author x00427549
 *
 */
public class UnionFindSet {

    private int mRootNums;
    private int[] mParentArr;

    public UnionFindSet(int mRootNums) {
        this.mRootNums = mRootNums;
        this.mParentArr = new int[this.mRootNums];
        for (int i = 0; i < mRootNums; i++) {
            this.mParentArr[i] = i;
        }
    }

    public void union(int i, int j) {
        if (i < 0 || i > this.mRootNums || j < 0 || j > this.mRootNums) {
            return;
        }

        int ri = find(i);
        int rj = find(j);

        if (ri != rj) {
            // 表示不属于同一集合，需要将设置为同一个集合
            this.mParentArr[ri] = rj;
        }
    }

    public int find(int i) {
        if (i < 0 || i > this.mRootNums) {
            return -1;
        }
        int root = i;

        // 这里也可以将根节点设置为负值，非根节点设置为根节点位置标号
        while (root != this.mParentArr[root]) {
            root = this.mParentArr[root];
        }

        // 可以将属于同一个集合的所有元素，都指向root节点
        int t = i;
        int p = 0;
        while (t != root) {
            p = this.mParentArr[t];
            this.mParentArr[t] = root;
            t = p;
        }

        return root;
    }

    public void print() {

    }

    public static void main(String[] args) {
        int N = 10;
        UnionFindSet union = new UnionFindSet(N);

        union.union(2, 6);
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        union.union(5, 6);
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        union.union(1, 8);
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        union.union(2, 9);
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        union.union(5, 3);
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        union.union(4, 8);
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        union.union(4, 0);
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        int[] component = new int[N];
        for (int i = 0; i < N; i++) {
            component[union.find(i)]++;
        }

        int count  = 0;
        for (int i = 0; i < N; i++) {
            if(component[i] != 0){
                count++;
            }
        }
        
        System.out.println("Array:"+java.util.Arrays.toString(union.mParentArr));
        System.out.println("count:"+count);
    }
}
