package datastructures.practice.binary_search_tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

class BSTNode {

    private int data;
    private int count;
    private BSTNode left, right;

    BSTNode(int data) {
        this.data = data;
        this.count = 1;
    }

    void insert(int value) {
        if (value == data) {
            this.count += 1;
        } else if (value < data) {
            if (left == null) {
                left = new BSTNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BSTNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    BSTNode delete(int x) {
        if (x > this.data && this.right != null) {
            this.right = this.right.delete(x);
        } else if (x < this.data && this.left != null) {
            this.left = this.left.delete(x);
        } else if (this.data == x) {
            boolean isLeaf = this.left == null && this.right == null;
            boolean hasOnlyLeftChild = this.left != null && this.right == null;
            boolean hasOnlyRightChild = this.left == null && this.right != null;
            if (isLeaf) {
                return null;
            } else if (hasOnlyLeftChild) {
                return this.left;
            } else if (hasOnlyRightChild) {
                return this.right;
            } else {
                BSTNode maxOfLeftSubTree = this.left.getMax();
                this.data = maxOfLeftSubTree.data;
                this.count = maxOfLeftSubTree.count;
                this.left.delete(maxOfLeftSubTree.data);
            }
        }
        return this;
    }

    BSTNode getMax() {
        BSTNode temp = this;
        while (true) {
            if (temp.right == null) break;
            temp = this.right;
        }
        return temp;
    }

    BSTNode getMin() {
        BSTNode temp = this;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    boolean contains(int value) {
        if (value == this.data) {
            return true;
        } else if (value < this.data) {
            return (left != null) && left.contains(value);
        } else {
            return (right != null) && right.contains(value);
        }
    }

    BSTNode find(int value) {
        if (value == this.data) {
            return this;
        } else if (value > this.data) {
            return (this.right == null) ? null : this.right.find(value);
        } else {
            return (this.left == null) ? null : this.left.find(value);
        }
    }

    List<Integer> retrieveInOrderList() {
        List<Integer> order = new LinkedList<>();
        if (left != null) {
            List<Integer> leftValues = left.retrieveInOrderList();
            order.addAll(leftValues);
        }
        for (int i = 0; i < this.count; i++) {
            order.add(this.data);
        }
        if (right != null) {
            List<Integer> rightValues = right.retrieveInOrderList();
            order.addAll(rightValues);
        }
        return order;
    }

    void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.data);
        }
        if (right != null) {
            right.printInOrder();
        }
    }

    int getData() {
        return data;
    }

    BSTNode getLeft() {
        return left;
    }

    BSTNode getRight() {
        return right;
    }

    int size() {
        return 1 + ((left == null) ? 0 : left.size()) + ((right == null) ? 0 : right.size());
    }

    int height() {
        return 1 + Math.max(((left == null) ? 0 : left.height()), ((right == null) ? 0 : right.height()));
    }

    private void inOrderNodesList(LinkedList<BSTNode> nodes, BSTNode root) {
        if (root.left != null) {
            inOrderNodesList(nodes, root.left);
        }
        nodes.add(root);
        if (root.right != null) {
            inOrderNodesList(nodes, root.right);
        }
    }

    void printLevelOrder() {
        ArrayDeque<BSTNode> queue = new ArrayDeque<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            BSTNode bstNode = queue.removeFirst();
            System.out.println(bstNode.data);
            if (bstNode.left != null) {
                queue.addLast(bstNode.left);
            }
            if (bstNode.right != null) {
                queue.addLast(bstNode.right);
            }
        }
    }

    BSTNode balance() {
        LinkedList<BSTNode> nodesList = new LinkedList<>();
        inOrderNodesList(nodesList, this);
        return buildTree(nodesList, 0, nodesList.size() - 1);
    }

    private BSTNode buildTree(LinkedList<BSTNode> nodesList, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        BSTNode node = nodesList.get(mid);
        node.left = buildTree(nodesList, left, mid - 1);
        node.right = buildTree(nodesList, mid + 1, right);
        return node;
    }

    boolean isBalanced() {
        return isBalanced(left) != -1 && isBalanced(right) != -1;
    }

    private int isBalanced(BSTNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = isBalanced(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = isBalanced(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", BSTNode.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("count=" + count)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }
}