
public class BST<T extends Comparable<? super T>>
{
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
    public void insert(T elem)
    {
        node = ins(elem, node);

    }

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

    public void draw()
    {
        System.out.println(drawRec(node) + "\n");
    }

    private String drawRec(Node node)
    {
        if(node != null)
            return "( " + node.elem + " " + drawRec(node.left) + " " + drawRec(node.right) + " )";
        return "empty";
    }

    public void search(T elem)
    {
        searchRec(node,elem);
    }

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
