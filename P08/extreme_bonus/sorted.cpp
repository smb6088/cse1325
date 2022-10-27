#include <iostream>
#include <algorithm>

int main()
{
	std::string s;
	std::vector<std::string> v;
	while(std::cin >> s )
	{
		if(std::cin.eof())
		{
			break;
			
		}
		v.push_back(s);
		//v.push_back("A");
		//v.push_back("ZBF");
		//v.push_back("BBB");
		//v.push_back("algorithm");
	}
	std::sort(v.begin(),v.end());

	for(auto c : v)
	{
		std::cout << c << "\n";
	}
	
	return 0;
}