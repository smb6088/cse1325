#include "Matrix3.h"
#include <iostream>
#include <fstream>


int main(int argc, char *argv[])
{
	Matrix3 m[argc];
	for(int i = 2; i< argc;i++)
	{
		std::string file{argv[2]};
		std::ifstream ist{file};
		if(!ist) throw std::runtime_error{"can't open input file " + file};

		int num;
		
		while(ist >> num)
		{
			std::cout << num << "\n";
			std::cin >> m[i];

		}
	}
	int j =2;
	while(j<argc)
	{
		m[1] = m[1] + m[j];
		j++;
	}

	std::cout << m[1] << "\n";


	return 0;
}