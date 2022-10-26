#include <iostream>
#include <cstring>

int main(int argc, char* argv[])
{
	std::string s;
	strcpy(s,argv[1]);
	for(char c : s)
	{
		std::cout << c << std::endl;
	}

	return 0;
}