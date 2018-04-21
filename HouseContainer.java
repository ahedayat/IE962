import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.util.*;
import java.lang.*;

class HouseContainer{
	Map<String,House> houses;				// id -> House
	List<String> idOfHouses;
	
	public HouseContainer(){									//tested
		this.houses = new HashMap<String,House>();
		this.idOfHouses = new ArrayList<String>();
	}

	public void put(House newHouse){							//tested		
		this.idOfHouses.add(newHouse.getId());					// add id of new House to id of houses 
		this.houses.put(newHouse.getId(),newHouse);				// add new House to houses map
	}
	
																//tested
	private Boolean checkHouseProperties(House h,Double area,String buildingType,String kindOfAgreement,Integer price){
		
		Boolean term1,term2,term3,term4;

		term1 = area.doubleValue() < h.getArea().doubleValue();
		term2 = buildingType.equals(h.getBuildingType());
		term3 = kindOfAgreement.equals(h.getKindOfAgreement());

		if(kindOfAgreement.equals("sell"))
			term4 = (price.intValue() > h.getSellPrice().intValue());
		else if(kindOfAgreement.equals("rent"))
			term4 = (price.intValue() > h.getRentPrice().intValue());
		else
			term4 = (price.intValue() > h.getBasePrice().intValue());

		return term1.equals(true) && term2.equals(true) && term3.equals(true) && term4.equals(true);
	}

																//tested
	public ArrayList<House> find(Double area,String buildingType,String kindOfAgreement,Integer price){
		ArrayList<House> requestedHouses = new ArrayList<House>();
		for(String id: idOfHouses){
			if( checkHouseProperties(houses.get(id),area,buildingType,kindOfAgreement,price) )
				requestedHouses.add(houses.get(id));
		}
		return requestedHouses;
	}

	public House getHouseById(String id){						//tested
		if(idOfHouses.contains(id))
			return houses.get(id);
		else
			throw new IllegalArgumentException("Bad id for house");
	}

	public void print(){										//tested
		Integer counter=0;
		for(String id : idOfHouses){
			++counter;
			House crrHouse = this.houses.get(id);
			System.out.println("# " + counter);
			crrHouse.print();
			System.out.println("--------------------------------");
		}
	}

	public Integer size(){										//tested									
		return houses.size();
	}
	public Integer size2(){										//tested
		return idOfHouses.size();
	}

}
