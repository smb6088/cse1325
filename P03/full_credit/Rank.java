public class Rank {

	private int rank;
	public static final int MIN = 0;
	public static final int MAX = 9;

	public Rank(int rank){
		this.rank = rank;
	}

	//@Override
	public String toString(){
		return  "" + rank;
	}

}