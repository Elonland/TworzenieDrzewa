/**
 * @brief Creates Binary Search Tree.
 * @tparam T can be int double string it is generic.
 */
public class BST<T extends Comparable<? super T>>
{
    /**
     * @brief Structure of the tree.
     */
    public class Node
    {
        T elem;
        Node left;
        Node right;
        Node(T elem)
        {
        this.elem = elem;
        left = null;
        right = null;
        }
    }
    Node node = null;
    //Metoda insert ktora wstawia element typu T do drzewa.
    /**
     * @brief User can use this method and it starts the recursive insertion.
     * @param elem The value that we want to give to the tree.
     */
    public void insert(T elem)
    {
        node = ins(elem, node);

    }
    /**
     * @brief Recursive insertion it checks if value exists in the tree if it doean't 
     * find one it creates new node.
     * @param elem value to add.
     * @param node Current node that we are in.
     * @return  Node* We return new node.
     */
    private Node ins(T elem, Node node)
    {
        if(node == null)
        {
            return new Node(elem);
        }
        else if(elem.compareTo(node.elem) < 0 )
        {
            node.left = ins(elem, node.left);
        }
        else if(elem.compareTo(node.elem) > 0)
        {
            node.right = ins(elem, node.right);
        }
        return node;
    }
    /**
     * @brief User can use this method and it starts the recursive drawing.
     */
    public void draw()
    {
        System.out.println(drawRec(node) + "\n");
    }
    /**
     * @brief Recursively it prints whole tree.
     * @param node it is the current node.
     */
    private String drawRec(Node node)
    {
        if(node != null)
            return "( " + node.elem + " " + drawRec(node.left) + " " + drawRec(node.right) + " )";
        return "empty";
    }
    /**
     * @brief User can use this method and it starts the recursive search.
     * @param elem Given value to find.
     */
    public void search(T elem)
    {
        searchRec(node,elem);
    }
    /**
     * @brief Recursively looks for the value.
     * @param node Current node that we are in.
     * @param elem Value which we are searching.
     */
    private void searchRec(Node node, T elem)
    {
        if(node == null)
            System.out.println("Couldn't find element.");
        if(elem.compareTo(node.elem) == 0)
            System.out.println("Found element.");
        else
        {
            if(elem.compareTo(node.elem) < 0)
                searchRec(node.left,elem);
            else
                searchRec(node.right, elem); 
        }
        
    }
    /**
     * @biref User can use this method to recursively delete element.
     * @param elem Given value to delte.
     */
    public void deleteElement(T elem)
    {
      node = deleteRec(node, elem);
    }

    /*private Node minNode(Node node) //Used only for the sucessor
    {
        Node min = node;
        while(node.left != null)
        {
            min = node.left;
            node = node.left;
        }
        return min;
    }
    */
    /**
     * @brief Worst part of the program It is supposed to delete element from the
     * tree.
     * @param current Node that we are in.
     * @param elem Value to delete.
     */
    private Node deleteRec(Node current, T elem)
    {
        if(current == null)
            {
                System.out.println("Nothing to delete.\n");
                return current;
            }
        
        //Searching node
        if(elem.compareTo(current.elem) < 0)
        {
            current.left = deleteRec(current.left, elem);
            return current;
        }
            
        else if(elem.compareTo(current.elem) > 0)
        {
            current.right = deleteRec(current.right, elem);
            return current;
        }
        else //Found node
        {
            if(current.left == null)
            {
                Node parent = current.right;
                return parent;
            } 
            else if(current.right == null)
            {
                Node parent = current.left;
                return parent;
            }   
            else 
            {
                Node succParent = current;

                Node succ = current.right;

                while( succ.left != null)
                {
                    succParent = succ;
                    succ = succ.left;
                }

                if(succParent != current)
                    succParent.left = succ.right;
                else
                    succParent.right = succ.right;

                current.elem = succ.elem;

                return current;
            }      
        }
    }

}
