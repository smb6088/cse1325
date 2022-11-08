#include "Matrix3.h"


Matrix3::Matrix3(int m00, int m01, int m02, int m10, int m11, int m12, int m20, int m21, int m22)

		: data{
			{m00,m10,m20},
			{m01,m11,m21},
			{m02,m12,m22}
		}{

		}

int Matrix3::get(int x, int y)
{
	Matrix3 m{*this};
	return m.data[x][y];	
}

Matrix3 Matrix3::operator+(const Matrix3 rhs){
	Matrix3 m{*this};
	m.data[0][0] += rhs.data[0][0];
	m.data[1][0] += rhs.data[1][0];
	m.data[2][0] += rhs.data[2][0];
	m.data[0][1] += rhs.data[0][1];
	m.data[0][2] += rhs.data[0][2];
	m.data[1][1] += rhs.data[1][1];
	m.data[2][2] += rhs.data[2][2];
	m.data[1][2] += rhs.data[1][2];
	m.data[2][1] += rhs.data[2][1];
	return m;
}

std::ostream &operator<<(std::ostream& out, const Matrix3 &m)
{
	for(int i = 0;i<3;i++)
		{
			for(int j = 0; j<3;j++)
			{
				std::cout << m.data[i][j] << " ";
			}
			std::cout << "\n";
		}
	return out;
}

std::istream & operator>>(std::istream& in, Matrix3 &m)
{
	in >> m.data[0][0];
	in >> m.data[0][1];
	in >> m.data[0][2];
	in >> m.data[1][0];
	in >> m.data[1][1];
	in >> m.data[1][2];
	in >> m.data[2][0];
	in >> m.data[2][1];
	in >> m.data[2][2];

	return in;
}
		