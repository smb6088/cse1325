#include <iostream>
#include <algorithm>

int main()
{
	std::string s;
	std::vector<std::string> v;
	while(true)
	{
		std::cin >> s;
		if(std::cin.eof())
		{
			break;
			
		}
		v.push_back(s);
	}
	std::sort(v.begin(),v.end());
	std::cout << "Sorted:" << "\n";
	for(auto c : v)
	{
		std::cout << c << "\n";
	}
	
	return 0;
}