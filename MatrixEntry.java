package branch1;

public class MatrixEntry {

	private final int value;
	
	private final int row;
	private final int col;
	
	public MatrixEntry(int value, int row, int col) {
		this.value = value;
		this.row = row;
		this.col = col;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
