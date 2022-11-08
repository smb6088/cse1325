#ifndef __MATRIX_H
#define __MATRIX_H

#include <iostream>
#include <exception>
#include <vector>

class Matrix3 {
	public:
		Matrix3(int m00=0, int m01=0, int m02=0, int m10=0, int m11=0, int m12=0, int m20=0, int m21=0, int m22=0);
		friend std::ostream & operator<<(std::ostream& out, const Matrix3 &m);
		friend std::istream & operator>>(std::istream& in, Matrix3 &m);
		int get(int x, int y);
		Matrix3 operator+(const Matrix3 rhs);
	private:
		int data[3][3];
};
#endif