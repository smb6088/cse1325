#include "Matrix3.h"

class Matrix3 {
	public:
		Matrix3(int m00, int m01, int m02, int m10, int m11, int m12, int m20, int m21, int m22)
		: data[0][0]{m00}, data[0][1]{m01}, data[0][2]{m02}, data[1][0]{m10}, data[1][1]{m11}, data[1][2]{m12}, data[2][0]{m20}, data[2][1]{m21}, data[2][2]{m22} {

		}
		/*
		int get(int x, int y){
			return data[x][y];
		}
		*/
		friend std::ostream & operator<<(std::ostream& out, Matrix3 m)
		{
			for(int i = 0;i<3;i++)
			{
				for(int j = 0; j<3;j++)
				{
					std::cout << data[i][j] << " ";
				}
				std::cout << "\n";
			}

			return out;
		}
		friend std::istream & operator>>(std::istream& in, Matrix3 m){
			in >> Matrix3.data[0][0];
			in >> Matrix3.data[0][1];
			in >> Matrix3.data[0][2];
			in >> Matrix3.data[1][0];
			in >> Matrix3.data[1][1];
			in >> Matrix3.data[1][2];
			in >> Matrix3.data[2][0];
			in >> Matrix3.data[2][1];
			in >> Matrix3.data[2][2];

			return in;
		}
	private:
		int data[3][3];
}