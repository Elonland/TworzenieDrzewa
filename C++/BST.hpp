#ifndef BST_H
#define BST_H
#include <string>
#include <iostream>

//using namespace std;
/**
 * @brief Creates Binary search tree.
 * 
 * @tparam T can be int double string.
 */
template <typename T>
class BST
{
    //template <typename T>
    /**
     * @brief Structure of the tree.
     * 
     */
    class Node
    {
        public:
        T elem;
        Node* left;
        Node* right;
        Node(T elem)
        {
            this->elem = elem;
            left = nullptr;
            right = nullptr;
        }
        ~Node()
        {
            
        }

    };

    Node* node = nullptr;

    public:
    //template <typename T>
    /**
     * @brief User can use this method and it starts the recursive insertion.
     * 
     * @param elem The value that we want to give to the tree.
     * @see ins()
     */
    void insert(T elem)
    {
        node = ins(elem, node);
    }
    /**
     * @brief User can use this method and it starts the recursive drawing.
     * @see drawRec()
     */
    void draw()
    {
        drawRec(node);
        std::cout << "\n";
    }
    /**
     * @brief User can use this method and it starts the recursive search.
     * @see searchRec()
     * @param elem Given value to find.
     */
    void search(T elem)
    {
        searchRec(elem ,node);
    }
    /**
     * @brief User can use this method to recursively delete element.
     * 
     * @param elem Given value to delete.
     */
    void deleteElement(T elem)
    {
        node = deleteRec(node, elem);
    }
/*
    void deleteTree()
    {
        deleteTreeRec(node);
    }
*/
    private:
    /**
     * @brief Recursive insertion it checks if value exists in the tree if it doesnt find one
     * it creates new node.
     * 
     * @param elem value to add.
     * @param node Current node that we are in.
     * @return Node* We return new node.
     */
    Node* ins(T elem, Node* node)
    {
         if(node == nullptr)
        {
            return new Node(elem);
        }
        else if(elem < (*node).elem)
        {
            (*node).left = ins(elem, (*node).left);
        }
        else if(elem > (*node).elem)
        {
            (*node).right = ins(elem, (*node).right);
        }
        return node;
    }
    /**
     * @brief Recursively it prints whole tree.
     * 
     * @param node its the current node.
     */
    void drawRec(Node* node)
    {
        if(node != nullptr)
        {
            std::cout << "( " << (*node).elem << " ";
            drawRec((*node).left);
            drawRec((*node).right);
            std::cout << " )";
        }
        else
            std::cout << "empty ";
    }
    /**
     * @brief Recursively looks for the value.
     * 
     * @param elem Value which we are searching.
     * @param node Current node that we are in.
     */
    void searchRec(T elem, Node* node)
    {
        if(node == nullptr)
            std::cout << "Couldn't find element.\n";
        else
        {
            if(elem == (*node).elem)
                std::cout << "Found element.\n";
            else
            {
                if(elem < (*node).elem)
                    searchRec(elem,(*node).left);
                else
                    searchRec(elem, (*node).right); 
            }
        }

    }
    /**
     * @brief Worst part of the program. It is supposed to delete element from the tree
     * but is C++ so how do I delete anything in this mess?
     * 
     * @param current Node that we are in.
     * @param elem Value to delete.
     * 
     */
    Node* deleteRec(Node* current, T elem)
    {
        if(current == nullptr)
            {
                std::cout << "Nothing to delete.\n";
                return current;
            }
        
        //Searching node
        if(elem < (*current).elem)
        {
            (*current).left = deleteRec((*current).left, elem);
            return current;
        }
            
        else if(elem > (*current).elem)
        {
            (*current).right = deleteRec((*current).right, elem);
            return current;
        }
        else //Found node
        {
            if((*current).left == nullptr)
            {
                Node* parent = (*current).right;
                delete(current);
                //*current = NULL;
                return parent;
            } 
            else if((*current).right == nullptr)
            {
                Node* parent = (*current).left;
                delete(current);
                //*current = NULL;
                return parent;
            }   
            else 
            {
                Node* succParent = current;

                Node* succ = (*current).right;
                //succ is the smallest next node after current.
                while( (*succ).left != nullptr)//Looking for the smallest node.
                {
                    succParent = succ;
                    succ = (*succ).left;
                }

                if(succParent != current)
                {
                    (*succParent).left = (*succ).right;
                } 
                else
                {
                    (*succParent).right = (*succ).right;
                }
                    

                (*current).elem = (*succ).elem;
                delete(succ);
                //*succ = NULL;

                return current;
            }      
        }
    }
    /**
     * @brief Hoped that it would solve something... it didn't.
     * 
     * @param node Node from where we want to delete everything.
     */
    void deleteTreeRec(Node* node)
    {
        if(node != nullptr)
        {
            deleteTreeRec((*node).left);
            deleteTreeRec((*node).right);
            delete(node);

        }
    }
    public:
    ~BST()
    {
        deleteTreeRec(node);
    }
};

#endif