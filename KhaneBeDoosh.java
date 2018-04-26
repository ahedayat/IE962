import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.util.*;

class Price{
	public Integer basePrice;
	public Integer rentPrice;
	public Integer sellPrice;
	public Price(String kindOfAgreement,Integer price){
		this.basePrice = new Integer(0);
		this.rentPrice = new Integer(0);
		this.sellPrice = new Integer(0);

		if(kindOfAgreement.equals("sell"))
			this.sellPrice = price;
		else if(kindOfAgreement.equals("rent"))
			this.rentPrice = price;
		else
			this.basePrice = price;
	}
}

public class KhaneBeDoosh{
	private static HouseContainer houses;
	private static UserContainer users;

	private static Integer phonePrice = 1000;

	static{																	//tested
		users = new UserContainer();
		houses = new HouseContainer();
		addUser("بهنام","bk","bk",0,"09120001234");
	}

	private static List<Integer> getPrices(String kindOfAgreement,Integer price){				// return value of base price,rent price,and sell price
		List<Integer> prices = new ArrayList<Integer>();	//0: base price 	1: rent price 		2: sell price 
		Integer basePriceIndex = new Integer(0);
		Integer rentPriceIndex = new Integer(1);
		Integer sellPriceIndex = new Integer(2);

		prices.add(new Integer(0));
		prices.add(new Integer(0));
		prices.add(new Integer(0));

		System.out.println(prices.size());

		if(kindOfAgreement.equals("sell"))
			prices.set(sellPriceIndex,price);
		else if(kindOfAgreement.equals("rent"))
			prices.set(rentPriceIndex,price);
		else
			prices.set(basePriceIndex,price);
		return prices;
	}

	private static Boolean getDealType(String kindOfAgreement){
		if(kindOfAgreement.equals("sell"))
			return new Boolean(false);
		return new Boolean(true);
	}
																			//tested ?!
	public static void addHouse(String username,String area,String buildingType,String kindOfAgreement,String address,
						 String imageURL,String price,String phone,String description){

		Price prices = new Price(kindOfAgreement,Integer.valueOf(price));
		
		Boolean dealType = getDealType(kindOfAgreement);

		House newHouse = new House(users.getOnlineUser(username),Double.valueOf(area),buildingType,dealType
									,address,imageURL,prices.basePrice,prices.rentPrice,prices.sellPrice,phone,
									description);
		houses.put(newHouse);
		users.assignHouse(newHouse.getId(),username);
	}

																			//tested
	public static Boolean addUser(String name,String username,String password,Integer balance,String phone){
		User newUser = new User(name,username,password,balance,phone);
		users.put(newUser);
		Boolean login = users.login(username,password);
		return login;
	}

	public Boolean login(String username,String password){					//tested
		Boolean login = users.login(username,password);
		return login;
	}

	public Boolean logout(String username){									//tested
		Boolean logout = users.logout(username);
		return logout;
	}

	public void buyPhone(String username,String idOfHouse){					
		User user = this.users.getOnlineUser(username);
		user.decreaseBalance(this.phonePrice);
		user.buyPhone(idOfHouse);
	}

	public User getOnlineUser(String username){								//tested
		return users.getOnlineUser(username);
	}

	// static String result;

	// static int counter=0;

	// public ArrayList<String> getOnlineUsersUsername(){
	// 	++counter;
	// 	// System.out.println(counter + " getOnlineUsersUsername :: username : " + users.getOnlineUser().getUsername());
	// 	return users.getOnlineUser(username).getUsername();
	// }
	public static Integer getOnlineUserBalance(String username){			//tested
		return users.getOnlineUser(username).getBalance();
	}
	public static String getOnlineUserPhone(String username){				//tested 
		return users.getOnlineUser(username).getPhone();
	}
	public static ArrayList<House> find(String area,String buildingType,String kindOfAgreement,String price){
		ArrayList<House> requested = houses.find(Double.valueOf(area),buildingType,kindOfAgreement,Integer.valueOf(price));
		return requested;
	}

	public void printUsers(){
		users.print();
	}

}