package Lesson8.Tree;

public class TreeClass {
    public static void main(String[] args) {
        Tree root =
                new Tree(0,
                        new Tree(1, new Tree(3,
                                new Tree(4,
                                        new Tree(5),null,null),null,null),null,null),
                        new Tree(2),
                        new Tree(6));
        System.out.println(root.sum());
    }

    static class Tree {
        int value;
        Tree left;
        Tree middle;
        Tree right;


        public Tree(int value, Tree left, Tree middle, Tree right) {
            this.value = value;
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        public int sum() {
            int summ = value;

            if (left != null) {
                summ += left.sum();
            }

            if (right != null) {
                summ += right.sum();
            }
            return summ;
        }
    }
}
