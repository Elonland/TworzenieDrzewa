#include "Test.hpp"
#include <iostream>


int A::B::getvalue()
{
    return 1;   
}

void A::someMethod(A::B sth)
{
    std::cout << sth.getvalue() << std::endl;
}