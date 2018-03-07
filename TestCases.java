package branch1;

public class TestCases {
///*
	public static void main(String[] args) {
		// Initialization
		SparseMatrix A = new SparseMatrix("-5r4c4, 5r1c4, 2r2c2, 5r3c1, -3r3c2, 6r4c2, -7r2c3, 3r1c1");
		SparseMatrix B = new SparseMatrix("1r4c1, 1r1c1, 1r2c6, 1r2c2, 1r3c3, 1r4c4, 1r1c5");
		SparseMatrix C = new SparseMatrix('C');
		SparseMatrix D = new SparseMatrix('D');
		SparseMatrix E = new SparseMatrix('E');
		SparseMatrix F = new SparseMatrix('F');
		SparseMatrix G = new SparseMatrix('G');
		G.print();
		long startTime, endTime;

		// Transpose
		startTime = System.nanoTime();
		SparseMatrix AT = A.transpose();
		System.out.println("The matrix A^T:");
		AT.print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		SparseMatrix BT = B.transpose();
		System.out.println("The matrix B^T:");
		BT.print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		SparseMatrix CT = C.transpose();
		System.out.println("The matrix C^T:");
		CT.print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		SparseMatrix DT = D.transpose();
		System.out.println("The matrix D^T:");
		DT.print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		SparseMatrix ET = E.transpose();
		System.out.println("The matrix E^T:");
		ET.print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		SparseMatrix FT = F.transpose();
		System.out.println("The matrix F^T:");
		FT.print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		SparseMatrix GT = G.transpose();
		System.out.println("The matrix G^T:");
		GT.print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns or " + (endTime - startTime) / 1000000000 + " s\n");
		startTime = System.nanoTime();
		
		// Add
		System.out.println("The matrix A + A:");
		A.add(A).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix B + B:");
		B.add(B).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix C + C:");
		C.add(C).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix D + D:");
		D.add(D).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E + E:");
		E.add(E).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix F + F:");
		F.add(F).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix G + G:");
		G.add(G).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		
		// Subtract
		System.out.println("The matrix A - A:");
		A.subtract(A).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix B - B:");
		B.subtract(B).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix C - C:");
		C.subtract(C).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix D - D:");
		D.subtract(D).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E - E:");
		E.subtract(E).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix F - F:");
		F.subtract(F).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix G - G:");
		G.subtract(G).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		
		// Scalar Multiply and Subtract
		System.out.println("The matrix 5A - A:");
		A.scalarMultiply(5).subtract(A).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix 5B - B:");
		B.scalarMultiply(5).subtract(B).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix 5C - C:");
		C.scalarMultiply(5).subtract(C).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix 5D - D:");
		D.scalarMultiply(5).subtract(D).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix 5E - E:");
		E.scalarMultiply(5).subtract(E).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix 5F - F:");
		F.scalarMultiply(5).subtract(F).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix 5G - G:");
		G.scalarMultiply(5).subtract(G).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		
		// Multiplication
		System.out.println("The matrix B * C^T:");
		B.multiply(CT).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix C * D:");
		C.multiply(D).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix D * C:");
		D.multiply(C).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E * F");
		E.multiply(F).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		
		// Multiply A and E with itself
		System.out.println("The matrix A * A:");
		A.multiply(A).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E * E:");
		E.multiply(E).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		
		// Power
		System.out.println("The matrix A^5:");
		A.power(5).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix A^25:");
		A.power(25).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E^5:");
		E.power(5).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E^25:");
		E.power(25).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		
		
		
		// Multiply with its transpose
		System.out.println("The matrix A * A^T:");
		A.multiply(AT).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix A^T * A:");
		AT.multiply(A).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix B * B^T:");
		B.multiply(BT).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix B^T * B:");
		BT.multiply(B).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix C * C^T:");
		C.multiply(CT).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix C^T * C:");
		CT.multiply(C).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix D * D^T:");
		D.multiply(DT).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix D^T * D:");
		DT.multiply(D).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E * E^T:");
		E.multiply(ET).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix E^T * E:");
		ET.multiply(E).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix F * F^T:");
		F.multiply(FT).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
		startTime = System.nanoTime();
		System.out.println("The matrix F^T * F:");
		FT.multiply(F).print();
		endTime = System.nanoTime();
		System.out.println("Running time: " + (endTime - startTime) + " ns\n");
	}
//*/
/*
	public static void main(String[] args) {
		SparseMatrix A = new SparseMatrix("-5r4c4, 5r1c4, 2r2c2, 5r3c1, -3r3c2, 6r4c2, -7r2c3, 3r1c1");
		SparseMatrix B = new SparseMatrix("1r4c1, 1r1c1, 1r2c6, 1r2c2, 1r3c3, 1r4c4, 1r1c5");
		SparseMatrix C = new SparseMatrix('C');
		SparseMatrix D = new SparseMatrix('D');
		SparseMatrix E = new SparseMatrix('E');
		SparseMatrix F = new SparseMatrix('F');
		SparseMatrix G = new SparseMatrix('G');

		long start, end;

		A.print();
		A.transpose().print();
		F.print();
		E.print();
		G.print();
		start = System.nanoTime();
		G.transpose().print();
		end = System.nanoTime();

		System.out.println((end - start) / 1000000000);
	}
	*/
}
