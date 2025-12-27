package Tree;


class SearchBSTSolution {
    public Node searchBST(Node root, int val) {
        if(root==null){
            return null;
        }
        if(root.value==val){
            return root;
        }
        else if(root.value>=val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }
    }
}

public class SearchBST {
    public static void main(String args[]){
        BST tree = new BST();
        int[] values = {4,2,7,1,3};
        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }
        SearchBSTSolution searchBSTSolution= new SearchBSTSolution();
        searchBSTSolution.searchBST(tree.root,2);
    }
}
