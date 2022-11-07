#include <iostream>
#include <exception>

class Matrix3 {
	public:
		Matrix3(int m00, int m01, int m02, int m10, int m11, int m12, int m20, int m21, int m22);
	private:
		int data[3][3];

};