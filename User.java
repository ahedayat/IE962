import java.lang.*;
import java.util.ArrayList;

public class User extends Individual{
	private String name;
	private ArrayList<String> idOfHouses;
	private final static Integer defualHouseNum = 1; 

	public User(String name,String username,String password,Integer balance,String phone){	//tested
		super(username,password,balance,phone);
		idOfHouses = new ArrayList<String>(User.defualHouseNum);
		this.name=name;
	}

	public void addHouse(String id){												//tested
		idOfHouses.add(id);
	}

	public void deleteHouse(String id){												//tested
		int index = idOfHouses.indexOf(id);
		if(index!=-1){
			idOfHouses.remove(index);
		}
		else
			throw new IllegalArgumentException("Bad id for house");
	}
	
	public void changeName(String name){											//tested
		this.name=name;
	}

	public String getName(){														//tested
		return name;
	}

	public void print(){															//tested
		System.out.println("Name : " + name);
		Integer counter = 0;
		for(String x: idOfHouses){
			++counter;
			System.out.println(counter + "." + x);
		}
		super.print();
	}

}