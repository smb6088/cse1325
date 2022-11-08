SRC1 = test_matrix3.cpp
SRC2 = Matrix3.cpp
OBJ1 = $(SRC1: .c=.o)
OBJ2 = $(SRC2: .c=.o)
EXE = $(SRC1:.c=.e)

CFLAGS = --std=c++17

all : $(EXE)

$(EXE) : $(OBJ1) $(OBJ2) $(OBJ3) $(OBJ4)
	g++ $(CFLAGS) $(OBJ1) $(OBJ2) $(OBJ3) $(OBJ4) -o $(EXE)

$(OBJ1) : $(SRC1)
	g++ -c $(CFLAGS) $(SRC1)

$(OBJ2) : $(SRC2)
	g++ -c $(CFLAGS) $(SRC2)