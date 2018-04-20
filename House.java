import java.lang.*;
// import com.google.gson.*;
// import com.google.gson.reflect.*;
import java.util.List;
import java.util.ArrayList;
// import org.json.*;

public class House{
	static Integer idCounter;
	static{
		idCounter=0;
	} 

	final String id;
	Double area;
	String buildingType;		//sell , rent , mortgage , rent&mortgage
	String address;
	String imageURL;
	Boolean dealType;			//for optimization reason => consider boolean
	Integer basePrice;
	Integer rentPrice;
	Integer sellPrice;
	String phone;
	String description;
	User owner;
	//Date expireTime;

	private String getNewId(){															//tested													
		++idCounter;
		return idCounter.toString();
	}

																						//tested
	House(User owner,Double area,String buildingType,Boolean dealType,String address,String imageURL,
		  Integer basePrice,Integer rentPrice,Integer sellPrice,String phone,
		  String description){														
		this.id=this.getNewId();
		this.owner=owner;
		this.area = area;
		this.address = address;
		this.imageURL = imageURL;
		this.basePrice = basePrice;
		this.rentPrice = rentPrice;
		this.sellPrice = sellPrice;
		this.phone = phone;
		this.description = description;
		this.buildingType = buildingType;
		this.dealType = dealType;
	}

	protected void changeArea(Double area){												//tested
		this.area = area;
	}
	protected void changeAddress(String address){										//tested
		this.address=address;
	}
	protected void changeImageURL(String imageURL){										//tested
		this.imageURL = imageURL;
	}
	protected void changeDealType(Boolean dealType){									//tested
		this.dealType=dealType;
	}
	protected void changeBasePrice(Integer basePrice){									//tested
		this.basePrice = basePrice;
	}
	protected void changeRentPrice(Integer rentPrice){									//tested
		this.rentPrice = rentPrice;
	}
	protected void changeSellPrice(Integer sellPrice){									//tested
		this.sellPrice = sellPrice;
	}
	protected void changePhone(String phone){											//tested
		this.phone = phone;
	}
	protected void changeDescription(String description){								//tested
		this.description = description;
	}

	public String getBuildingType(){													//tested
		return this.buildingType;
	}
	public Double getArea(){															//tested
		return this.area;
	}
	public Boolean getDealType(){														//tested
		return this.dealType;
	}
	public Integer getBasePrice(){														//tested
		return this.basePrice;
	}
	public Integer getRentPrice(){														//tested
		return this.rentPrice;
	}
	public Integer getSellPrice(){														//tested
		return this.sellPrice;
	}
	public String getImageURL(){														//tested
		return this.imageURL;
	}
	public String getAddress(){															//tested
		return this.address;
	}
	public String getDescription(){														//tested
		return this.description;
	}
	public String getPhone(){															//tested
		return this.phone;
	}
	public String getOwnerPhone(){														//tested
		return this.owner.getPhone();
	}
	protected String getId(){															//tested
		return this.id;
	}
	public String getKindOfAgreement(){													//tested

		if(dealType)
			return "sell";											//just for sell
		else{
			if(rentPrice.equals(0) & !basePrice.equals(0))
				return	"mortgage";									//just for mortgage
			else if(basePrice.equals(0) & !rentPrice.equals(0))
				return "rent";										//just for rent
			else
				return	"rent&mortgage";							//for rent and mortgage
		}
	}

	public void print(){																//tested
		System.out.println("Id : " + this.id);
		System.out.println("Area : " + this.area);
		System.out.println("buildingType : " + this.buildingType);
		System.out.println("Address : " + this.address);
		System.out.println("ImageURL : " + this.imageURL);
		System.out.println("DealType : " + this.dealType);
		System.out.println("Base Price : " + this.basePrice);
		System.out.println("Rent Price : " + this.rentPrice);
		System.out.println("Sell Price : " + this.sellPrice);
		System.out.println("Phone : " + this.phone);
		System.out.println("Description : " + this.description);
		System.out.println("Owner : " + this.owner.getUsername());
	}

	// public static List<House> fromJson(String jsonString){
	// 	// JSONObject json = new JSONObject(jsonString);
	// 	// json.getJSONArray()
	// 	Gson gson = new Gson();
	// 	System.out.println("constructor call.");
	// 	List<House> jsonHouses = gson.fromJson(jsonString, new TypeToken<List<House>>(){}.getType());
	// 	System.out.println("fromJson call.");
	// 	return jsonHouses;
	// }

}