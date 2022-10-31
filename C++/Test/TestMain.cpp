#include "Test.hpp"

int main(int argc, char* argv[])
{
    A *sth;
 
    A::B *sth2;

    sth = new A();
    sth2 = new A::B();
    sth->someMethod(*sth2);

return 0;
}