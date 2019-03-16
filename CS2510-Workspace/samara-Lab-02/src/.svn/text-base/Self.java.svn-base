interface IAT{}

class unknown implements IAT{
	unknown(){}
}

class AT implements IAT{
	String name;
	IAT left;
	IAT right;
	
	AT(String name, IAT left, IAT right){
		this.name = name;
		this.left = left;
		this.right = right;
	}
}

class Examples2{
	Examples2(){}
	
	IAT i1 = new unknown();
	IAT i2 = new AT("steve", i1, i1);
	IAT i3 = new AT("bill", i1, i1);
	IAT i4 = new AT("hi", i2, i3);
	
}