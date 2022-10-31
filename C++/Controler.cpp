#include "BST.hpp"
#include <string>
#include <iostream>

int main(int argc, char* argv[])
{
    BST<int>* tree = new BST<int>();

    (*tree).deleteElement(5);
    (*tree).draw();
    (*tree).insert(10);
    (*tree).insert(8);
    (*tree).insert(9);
    (*tree).insert(20);
    (*tree).insert(15);
    (*tree).insert(25);
    (*tree).insert(12);
    (*tree).draw();
    (*tree).deleteElement(20);
    (*tree).draw();
    (*tree).deleteElement(10);
    (*tree).draw();
    (*tree).insert(10);
    (*tree).draw();

    delete(tree);
}