package branch1;

public class SparseMatrix {

    private MatrixEntry[] array;
	private int numEntries;

    private final int m;
    private final int n;

    public SparseMatrix(int m, int n) {
        this.m = m;
        this.n = n;

        this.numEntries = 0;
		this.array = new MatrixEntry[4];
    }

    public SparseMatrix(String str) {
    	while ( str.startsWith("0") ) {
    		str = str.replaceFirst("0r\\d+c\\d+(, )?", "");
    	}
    	str = str.replaceAll(", 0r\\d+c\\d+", "");

    	String[] x = str.split(", ");
    	int len = x.length;

		this.numEntries = 0;
		this.array = new MatrixEntry[len];

		int nRows = 0, nCols = 0;
		for (int i = 0; i < len; i ++) {
			int row = Integer.parseInt( x[i].replaceAll(".*r|c.*", "") );
			int col = Integer.parseInt( x[i].replaceFirst(".*c", "") );
			int val = Integer.parseInt( x[i].replaceFirst("r.*", "") );
			insertValue(val, row, col);

			nRows = Math.max(nRows, row);
			nCols = Math.max(nCols, col);
		}

		this.m = nRows;
    	this.n = nCols;
    }

    public SparseMatrix(char matrix) {
		int count = 0;

    	switch (matrix) {
    	case 'C':
    		this.m = 5;
    		this.n = 6;
    		this.numEntries = 0;
    		this.array = new MatrixEntry[15];

    		for (int i = 1; i <= 5; i ++) {
    			for (int j = 1; j <= 6; j ++) {
    				if ((i + j) % 2 == 0) {
    					insertValue(i * j, i, j);
    				}
     			}
    		}
    		break;

    	case 'D':
    		this.m = 6;
    		this.n = 5;
			this.numEntries = 0;
    		this.array = new MatrixEntry[12];

    		for (int i = 1; i <= 6; i ++) {
    			for (int j = 1; j <= 5; j ++) {
    				if ((i * j) % 4 == 0) {
    					insertValue(i + j, i, j);
    				}
    			}
    		}
    		break;

    	case 'E':
    		this.m = this.n = 200;
    		this.numEntries = 0;
    		this.array = new MatrixEntry[4000];

    		for (int i = 1; i <= 200; i ++) {
    			for (int j = 1; j <= 200; j ++) {
    				if (i % 10 == 0) {
    					insertValue(i + (2 * j), i, j);
    				}
    			}
    		}
    		break;

    	case 'F':
    		this.m = 200;
    		this.n = 1;
    		this.numEntries = 0;
    		this.array = new MatrixEntry[40];

    		for (int i = 1; i <= 200; i ++) {
    			if (i % 5 == 0) {
    				insertValue(5 * i, i, 1);
    			}
    		}
    		break;

    	case 'G':
    		this.m = 30000;
    		this.n = 30000;
			this.numEntries = 0;
    		this.array = new MatrixEntry[313925];

    		for (int i = 1; i <= 30000; i ++) {
    			for (int j = 1; j <= 30000; j ++) {
    				if (i % j == 0) {
    					insertValue(i + j, i, j);
    				}
     			}
    		}
    		break;

    	default:
    		this.m = this.n = this.numEntries = 0;
    		this.array = new MatrixEntry[0];
    		break;
    	}
    }

	public void print() {
		System.out.println("The " + m + " x " + n + " matrix is: ");

		int count = 0;
		for (int i = 1; i <= this.m; i ++) {
			if (this.m > 6 && i == 3) {
				int dots;
				if (this.n <= 6)
					dots = this.n;
				else
					dots = 5;
				for (int k = 0; k < dots; k ++) {
					System.out.print("...\t\t");
				}
				i = this.m - 2;
				count = this.numEntries - 1;
				while (count >= 0 && this.array[count].getRow() > i) {
					count --;
				}
				count ++;
				System.out.println();
				continue;
			}

			for (int j = 1; j <= this.n; j ++) {
				if (this.n > 6 && j == 3) {
					System.out.print("...\t\t");
					j = this.n - 2;
					while (count < this.numEntries && this.array[count].getRow() == i && this.array[count].getCol() <= j) {
						count ++;
					}
					continue;
				}

				if (count < this.numEntries && this.array[count].getRow() == i && this.array[count].getCol() == j) {
					System.out.print(this.array[count ++].getValue() + "\t\t");
				} else System.out.print(0 + "\t\t");
			}

			System.out.println();
		}
	}

    public boolean equals(SparseMatrix M) {
    	if (this.m != M.m || this.n != M.n || this.numEntries != M.numEntries)	return false;

    	for (int i = 0; i < this.numEntries; i ++) {
    		if (this.array[i].getRow() != M.array[i].getRow() || this.array[i].getCol() != M.array[i].getCol()
    				|| this.array[i].getValue() != M.array[i].getValue()) {
    			return false;
   			}
   		}

    	return true;
    }

    public SparseMatrix scalarMultiply(int c) {
        SparseMatrix R = new SparseMatrix(this.m, this. n);
        R.array = new MatrixEntry[this.numEntries];
        R.numEntries = this.numEntries;

        for (int i = 0; i < this.numEntries; i ++) {
        	R.array[i] = new MatrixEntry(this.array[i].getValue() * c, this.array[i].getRow(), this.array[i].getCol());
        }

        return R;
    }

    public SparseMatrix add(SparseMatrix M) {
        if (this.m != M.m || this.n != M.n)
        	return null;

        SparseMatrix R = new SparseMatrix(this.m, this.n);

        int idx1 = 0, idx2 = 0;
       	while (idx1 < this.numEntries && idx2 < M.numEntries) {
       		int row1 = this.array[idx1].getRow(), row2 = M.array[idx2].getRow();
			int col1 = this.array[idx1].getCol(), col2 = M.array[idx1].getCol();

       		if (row1 == row2) {
       			if (col1 == col2) {
       				R.insertValue(this.array[idx1].getValue() + M.array[idx2].getValue(), row1, col1);
       				idx1 ++;
       				idx2 ++;
				} else if (col1 < col2) {
       				R.insertValue(this.array[idx1].getValue(), row1, col1);
       				idx1 ++;
				} else {
					R.insertValue(M.array[idx2].getValue(), row2, col2);
					idx2 ++;
				}
			} else if (row1 < row2) {
				R.insertValue(this.array[idx1].getValue(), row1, col1);
				idx1 ++;
			} else {
				R.insertValue(M.array[idx2].getValue(), row2, col2);
				idx2 ++;
			}
		}

		while (idx1 < this.numEntries) {
       		R.insertValue(this.array[idx1].getValue(), this.array[idx1].getRow(), this.array[idx1].getCol());
		}

		while (idx2 < M.numEntries) {
			R.insertValue(M.array[idx2].getValue(), M.array[idx2].getRow(), M.array[idx2].getCol());
		}

        return R;
    }

    public SparseMatrix subtract(SparseMatrix M) {
    	if (this.m != M.m || this.n != M.n)
        	return null;

        SparseMatrix R = new SparseMatrix(this.m, this.n);

		int idx1 = 0, idx2 = 0;
		while (idx1 < this.numEntries && idx2 < M.numEntries) {
			int row1 = this.array[idx1].getRow(), row2 = M.array[idx2].getRow();
			int col1 = this.array[idx1].getCol(), col2 = M.array[idx1].getCol();

			if (row1 == row2) {
				if (col1 == col2) {
					R.insertValue(this.array[idx1].getValue() - M.array[idx2].getValue(), row1, col1);
					idx1 ++;
					idx2 ++;
				} else if (col1 < col2) {
					R.insertValue(this.array[idx1].getValue(), row1, col1);
					idx1 ++;
				} else {
					R.insertValue(- M.array[idx2].getValue(), row2, col2);
					idx2 ++;
				}
			} else if (row1 < row2) {
				R.insertValue(this.array[idx1].getValue(), row1, col1);
				idx1 ++;
			} else {
				R.insertValue(- M.array[idx2].getValue(), row2, col2);
				idx2 ++;
			}
		}

		while (idx1 < this.numEntries) {
			R.insertValue(this.array[idx1].getValue(), this.array[idx1].getRow(), this.array[idx1].getCol());
		}

		while (idx2 < M.numEntries) {
			R.insertValue(-M.array[idx2].getValue(), M.array[idx2].getRow(), M.array[idx2].getCol());
		}

        return R;
    }

    public SparseMatrix multiply(SparseMatrix M) {
        if (this.n != M.m)
        	return null;

    	SparseMatrix R = new SparseMatrix(this.m, M.n);

		for (int i = 1; i <= this.m; i ++) {
			int aRowStart = findRowFirst(0, this.numEntries - 1, i);
			if (aRowStart == - 1)	continue;
			int aRowEnd = findRowLast(aRowStart, this.numEntries - 1, i);

			for (int j = 1; j <= M.n; j ++) {
				int sum = 0;
				for (int k = aRowStart; k <= aRowEnd; k ++) {
					int bRow = this.array[k].getCol();
					int bRowStart = M.findRowFirst(0, M.numEntries - 1, bRow);
					if (bRowStart == -1)	continue;
					int bRowEnd = M.findRowLast(bRowStart, M.numEntries - 1, bRow);

					int idx = M.findCol(bRowStart, bRowEnd, j);
					if (idx == -1)	continue;

					sum += this.array[k].getValue() * M.array[idx].getValue();
				}

				R.insertValue(sum, i, j);
			}
		}

    	return R;
    }

    public SparseMatrix power(int p) {
		if (this.m != this.n)	return null;

		int count1 = 1, count2 = 1;
		SparseMatrix R = this, temp = this;
		while (count1 + count2 <= p) {
			while (count1 + count2 <= p) {
				count1 += count2;
				count2 += count2;
				R = R.multiply(temp);
				temp = temp.multiply(temp);
			}
			count2 = 1;
			temp = this;
		}

		return R;
	}

	public SparseMatrix transpose() {
    	SparseMatrix R = new SparseMatrix(this.n, this.m);

		int[] rowStarts = new int[this.m], rowEnds = new int[this.m];
		int oldVal = 0;
		for (int i = 1; i <= this.m; i ++) {
			rowStarts[i - 1] = findRowFirst(oldVal, this.numEntries - 1, i);
			if (rowStarts[i - 1] == -1)	continue;
			rowEnds[i - 1] = findRowLast(rowStarts[i - 1], this.numEntries - 1, i);
		}

		for (int i = 1; i <= this.n; i ++) {
			for (int j = 1; j <= this.m; j ++) {
				int rowStart = rowStarts[j - 1];
				if (rowStart == -1)	continue;
				int rowEnd = rowEnds[j - 1];

				int idx = findCol(rowStart, rowEnd, i);
				if (idx == -1)	continue;

				R.insertValue(this.array[idx].getValue(), i, j);
			}
		}

		return R;
	}

	private void insertValue(int value, int i, int j) {
		if (value == 0)	return;

		if (this.numEntries > this.array.length * 0.75)	increaseArraySize();

		int idx = this.numEntries;
		while (idx > 0 && this.array[idx - 1].getRow() > i) {
			this.array[idx] = this.array[idx - 1];
			idx --;
		}

		while (idx > 0 && this.array[idx - 1].getRow() == i && this.array[idx - 1].getCol() > j) {
			this.array[idx] = this.array[idx - 1];
			idx --;
		}

		this.array[idx] = new MatrixEntry(value, i, j);
		this.numEntries ++;
	}

	private void increaseArraySize() {
		MatrixEntry[] newArray = new MatrixEntry[this.array.length * 2];

		for (int k = 0; k < this.numEntries; k ++) {
			newArray[k] = new MatrixEntry(this.array[k].getValue(), this.array[k].getRow(), this.array[k].getCol());
		}

		this.array = newArray;
	}

	private int findRowFirst(int low, int high, int i) {
		if (low > high)	return -1;

		int mid = (low + high) / 2;
		if (this.array[mid].getRow() == i) {
			if (mid - 1 >= 0 && this.array[mid - 1].getRow() == i) {
				return findRowFirst(low, mid - 1, i);
			} else	return mid;
		} else if (this.array[mid].getRow() > i) {
			return findRowFirst(low, mid - 1, i);
		} else	return findRowFirst(mid + 1, high, i);
	}

	private int findRowLast(int low, int high, int i) {
		int mid = (low + high) / 2;
		if (this.array[mid].getRow() == i) {
			if (mid + 1 < this.numEntries && this.array[mid + 1].getRow() == i) {
				return findRowLast(mid + 1, high, i);
			} else	return mid;
		} else if (this.array[mid].getRow() > i) {
			return findRowLast(low, mid - 1, i);
		} else	return findRowLast(mid + 1, high, i);
	}

	private int findCol(int low, int high, int j) {
		if (low > high)	return -1;

		int mid = (low + high) / 2;
		if (this.array[mid].getCol() == j) {
			return mid;
		} else if (this.array[mid].getCol() > j) {
			return findCol(low, mid - 1, j);
		} else	return findCol(mid + 1, high, j);
	}

	public int getNumEntries() {
		return numEntries;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}
}
