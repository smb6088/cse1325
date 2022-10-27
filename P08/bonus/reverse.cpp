#include <iostream>
#include <algorithm>
#include <string>

int main(int argc, char* argv[])
{
  for (int i = 1; i < argc; ++i)
  	{

    	std::string si(argv[i]);
    	std::reverse(si.begin(), si.end());
    	std::cout << si << "\n";
	}
    


	return 0;
}