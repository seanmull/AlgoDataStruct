package stack_queue;

import java.util.ArrayList;

public class ThreeInOne {
	int[] top;
	int[] bottom;
	int[] size;
	ArrayList<Integer> data;
	
	ThreeInOne(){
		this.data = new ArrayList<Integer>();
		this.top = new int[] {0,0,0};
		this.bottom = new int[] {0,0,0};
		this.size = new int[] {0,0,0};
	}
	
	private void add(int val, int stackNum) {
		switch(stackNum) {
		case 0: 
			this.data.add(this.size[0],val);
			if(this.size[0] != 0) {
				this.top[0]++;
				this.top[1]++;
				this.top[2]++;
				this.bottom[1]++;
				this.bottom[2]++;
			}
			this.size[0]++;
			break;
		case 1:
			this.data.add(this.size[1] + this.size[0],val);
			if(this.size[1] != 0) {
				this.top[2]++;
				this.bottom[2]++;
			}else{
				this.bottom[1]++;
				this.top[2]++;
				this.bottom[2]++;
			}
			this.top[1]++;
			this.size[1]++;
			break;
		case 2:
			this.data.add(this.size[1] + this.size[0] + this.size[2],val);
			if(this.size[2] == 0) this.bottom[2]++;
			this.top[2]++;
			this.size[2]++;
			break;
		}
	}
	
	private void print() {
		for(int i = 0; i < this.size[0] + this.size[1] + this.size[2]; i++) {
			System.out.print(this.data.get(i)+",");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		//3.1 Three in One: Describe how you could use a single array to implement 
		//three stacks.Hints: #2, #72, #38, #58
		// 2   5    8
		// 3   7    10
		// 8   11   6
        
		
		// 2,5,8,5,7,11,8,10,6
		// ^   ^ ^   ^  ^    ^
		
		/*ArrayList a = new ArrayList();
		a.add(1);a.add(2);a.add(3);
		
		System.out.println(a);*/
		
		
		
		
		ThreeInOne t = new ThreeInOne();
		t.add(8, 0);
		t.add(5, 0);
		t.add(2, 0);
		t.add(11, 1);
		t.add(7, 1);
		t.add(5, 1);
		t.add(8, 2);
		t.add(10, 2);
		t.add(6, 2);
		//t.print();
		System.out.println(t.size[0] + " " + t.bottom[0] + " " + t.top[0]);
		System.out.println(t.size[1] + " " + t.bottom[1] + " " + t.top[1]);
		System.out.println(t.size[2] + " " + t.bottom[2] + " " + t.top[2]);
		t.print();
	}

}
