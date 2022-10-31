public class Controler
{
    public static void main(String[] args) 
    {
        BST<Integer> tree = new BST<Integer>();

        tree.deleteElement(5);
        tree.draw();
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);
        tree.insert(20);
        tree.insert(15);
        tree.insert(25);
        tree.insert(12);
        tree.draw();
        tree.deleteElement(20);
        tree.draw();
        tree.deleteElement(10);
        tree.draw();
        tree.insert(10);
        tree.draw();

    }
}
