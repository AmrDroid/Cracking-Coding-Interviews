package amazon;

// Operations on Fibonacci Heap in Java

class nodde {
    nodde parent;
    nodde left;
    nodde right;
    nodde child;
    int degree;
    boolean mark;
    int key;

    public nodde() {
        this.degree = 0;
        this.mark = false;
        this.parent = null;
        this.left = this;
        this.right = this;
        this.child = null;
        this.key = Integer.MAX_VALUE;
    }

    nodde(int x) {
        this();
        this.key = x;
    }

    void set_parent(nodde x) {
        this.parent = x;
    }

    nodde get_parent() {
        return this.parent;
    }

    void set_left(nodde x) {
        this.left = x;
    }

    nodde get_left() {
        return this.left;
    }

    void set_right(nodde x) {
        this.right = x;
    }

    nodde get_right() {
        return this.right;
    }

    void set_child(nodde x) {
        this.child = x;
    }

    nodde get_child() {
        return this.child;
    }

    void set_degree(int x) {
        this.degree = x;
    }

    int get_degree() {
        return this.degree;
    }

    void set_mark(boolean m) {
        this.mark = m;
    }

    boolean get_mark() {
        return this.mark;
    }

    void set_key(int x) {
        this.key = x;
    }

    int get_key() {
        return this.key;
    }
}

public class DecreaseKeyOperationMinHeaps {
    nodde min;
    int n;
    boolean trace;
    nodde found;

    public boolean get_trace() {
        return trace;
    }

    public void set_trace(boolean t) {
        this.trace = t;
    }

    public static DecreaseKeyOperationMinHeaps create_heap() {
        return new DecreaseKeyOperationMinHeaps();
    }

    DecreaseKeyOperationMinHeaps() {
        min = null;
        n = 0;
        trace = false;
    }

    private void insert(nodde x) {
        if (min == null) {
            min = x;
            x.set_left(min);
            x.set_right(min);
        } else {
            x.set_right(min);
            x.set_left(min.get_left());
            min.get_left().set_right(x);
            min.set_left(x);
            if (x.get_key() < min.get_key())
                min = x;
        }
        n += 1;
    }

    public void insert(int key) {
        insert(new nodde(key));
    }

    public void display() {
        display(min);
        System.out.println();
    }

    private void display(nodde c) {
        System.out.print("(");
        if (c == null) {
            System.out.print(")");
            return;
        } else {
            nodde temp = c;
            do {
                System.out.print(temp.get_key());
                nodde k = temp.get_child();
                display(k);
                System.out.print("->");
                temp = temp.get_right();
            } while (temp != c);
            System.out.print(")");
        }
    }

    public static void merge_heap(DecreaseKeyOperationMinHeaps H1, DecreaseKeyOperationMinHeaps H2, DecreaseKeyOperationMinHeaps H3) {
        H3.min = H1.min;

        if (H1.min != null && H2.min != null) {
            nodde t1 = H1.min.get_left();
            nodde t2 = H2.min.get_left();
            H1.min.set_left(t2);
            t1.set_right(H2.min);
            H2.min.set_left(t1);
            t2.set_right(H1.min);
        }
        if (H1.min == null || (H2.min != null && H2.min.get_key() < H1.min.get_key()))
            H3.min = H2.min;
        H3.n = H1.n + H2.n;
    }

    public int find_min() {
        return this.min.get_key();
    }

    private void display_nodde(nodde z) {
        System.out.println("right: " + ((z.get_right() == null) ? "-1" : z.get_right().get_key()));
        System.out.println("left: " + ((z.get_left() == null) ? "-1" : z.get_left().get_key()));
        System.out.println("child: " + ((z.get_child() == null) ? "-1" : z.get_child().get_key()));
        System.out.println("degree " + z.get_degree());
    }

    public int extract_min() {
        nodde z = this.min;
        if (z != null) {
            nodde c = z.get_child();
            nodde k = c, p;
            if (c != null) {
                do {
                    p = c.get_right();
                    insert(c);
                    c.set_parent(null);
                    c = p;
                } while (c != null && c != k);
            }
            z.get_left().set_right(z.get_right());
            z.get_right().set_left(z.get_left());
            z.set_child(null);
            if (z == z.get_right())
                this.min = null;
            else {
                this.min = z.get_right();
                this.consolidate();
            }
            this.n -= 1;
            return z.get_key();
        }
        return Integer.MAX_VALUE;
    }

    public void consolidate() {
        double phi = (1 + Math.sqrt(5)) / 2;
        int Dofn = (int) (Math.log(this.n) / Math.log(phi));
        nodde[] A = new nodde[Dofn + 1];
        for (int i = 0; i <= Dofn; ++i)
            A[i] = null;
        nodde w = min;
        if (w != null) {
            nodde check = min;
            do {
                nodde x = w;
                int d = x.get_degree();
                while (A[d] != null) {
                    nodde y = A[d];
                    if (x.get_key() > y.get_key()) {
                        nodde temp = x;
                        x = y;
                        y = temp;
                        w = x;
                    }
                    fib_heap_link(y, x);
                    check = x;
                    A[d] = null;
                    d += 1;
                }
                A[d] = x;
                w = w.get_right();
            } while (w != null && w != check);
            this.min = null;
            for (int i = 0; i <= Dofn; ++i) {
                if (A[i] != null) {
                    insert(A[i]);
                }
            }
        }
    }

    private void fib_heap_link(nodde y, nodde x) {
        y.get_left().set_right(y.get_right());
        y.get_right().set_left(y.get_left());

        nodde p = x.get_child();
        if (p == null) {
            y.set_right(y);
            y.set_left(y);
        } else {
            y.set_right(p);
            y.set_left(p.get_left());
            p.get_left().set_right(y);
            p.set_left(y);
        }
        y.set_parent(x);
        x.set_child(y);
        x.set_degree(x.get_degree() + 1);
        y.set_mark(false);
    }

    private void find(int key, nodde c) {
        if (found != null || c == null)
            return;
        else {
            nodde temp = c;
            do {
                if (key == temp.get_key())
                    found = temp;
                else {
                    nodde k = temp.get_child();
                    find(key, k);
                    temp = temp.get_right();
                }
            } while (temp != c && found == null);
        }
    }

    public nodde find(int k) {
        found = null;
        find(k, this.min);
        return found;
    }

    public void decrease_key(int key, int nval) {
        nodde x = find(key);
        decrease_key(x, nval);
    }

    private void decrease_key(nodde x, int k) {
        if (k > x.get_key())
            return;
        x.set_key(k);
        nodde y = x.get_parent();
        if (y != null && x.get_key() < y.get_key()) {
            cut(x, y);
            cascading_cut(y);
        }
        if (x.get_key() < min.get_key())
            min = x;
    }

    private void cut(nodde x, nodde y) {
        x.get_right().set_left(x.get_left());
        x.get_left().set_right(x.get_right());

        y.set_degree(y.get_degree() - 1);

        x.set_right(null);
        x.set_left(null);
        insert(x);
        x.set_parent(null);
        x.set_mark(false);
    }

    private void cascading_cut(nodde y) {
        nodde z = y.get_parent();
        if (z != null) {
            if (y.get_mark() == false)
                y.set_mark(true);
            else {
                cut(y, z);
                cascading_cut(z);
            }
        }
    }

    public void delete(nodde x) {
        decrease_key(x, Integer.MIN_VALUE);
        int p = extract_min();
    }

    public static void main(String[] args) {
        DecreaseKeyOperationMinHeaps obj = create_heap();
        obj.insert(7);
        obj.insert(26);
        obj.insert(30);
        obj.insert(39);
        obj.insert(10);
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();
        System.out.println(obj.extract_min());
        obj.display();
        System.out.println(obj.extract_min());
        obj.display();
        System.out.println(obj.extract_min());
        obj.display();
        System.out.println(obj.extract_min());
        obj.display();
    }
}

