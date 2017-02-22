//4737
//Assignment #3
//COP 3530

public class IntData implements Sortable {
	private int data;
	
	public IntData (int x) {
		data =x;
	}
	
	public int compareTo(Object b){
		IntData temp = (IntData) b;
		return (data - temp.getData());
	}
	
	public int getData(){
		return data;
	}
	
	public String toString(){
		return Integer.toString(data);
	}
	
	public boolean equals(Object b){
		if(b instanceof IntData ){
			return ((IntData)b).data == data;
		}
		return false;
	}

}
