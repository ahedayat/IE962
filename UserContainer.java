import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;

import java.util.*;

class UserContainer{
	Map<String,User> users;					// Username -> User
	List<String> usernamesOfUsers;
	
	ArrayList<User> onlineUsers;

	public UserContainer(){																//tested 
		users = new HashMap<String,User>();
		usernamesOfUsers = new ArrayList<String>();
		onlineUsers = new ArrayList<User>();
	}

	public Boolean isOnline(String username){											//tested
		if( onlineUsers.contains(users.get(username)) )
			return new Boolean(true);
		return new Boolean(false);
	}

	private Boolean login(User user){													//tested
		if( users.get(user.getUsername()) != null){
			onlineUsers.add(user);
			return new Boolean(true);
		}
		return new Boolean(false);
	}

	public Boolean login(String username,String password){								//tested 
		User crrUser = users.get(username);
		if( crrUser!=null && crrUser.checkPassword(password)){
			this.onlineUsers.add(users.get(username));
			return new Boolean(true);
		}
		return new Boolean(false);
	}

	public Boolean logout(String username){												//tested
		if( onlineUsers.contains(users.get(username)) ){
			this.onlineUsers.remove(users.get(username));
			return new Boolean(true);
		}
		
		return new Boolean(false);
	}

	public ArrayList<User> getOnlineUsers(){											//tested
		return this.onlineUsers;
	}

	public User getOnlineUser(String username){
		User crrOnlineUser = users.get(username);
		if(crrOnlineUser==null)
			throw new IllegalArgumentException("There isn't any user with this username");
		else if(!onlineUsers.contains(crrOnlineUser))
			throw new IllegalArgumentException("This user isn't online!");
		return crrOnlineUser;
	}

	public void put(User newUser){														//tested 
		users.put(newUser.getUsername(),newUser);
		usernamesOfUsers.add(newUser.getUsername());
	}

	public void assignHouse(String newHouseId,String username){							//tested
		if(this.isOnline(username)){
			User user = this.users.get(username);
			user.addHouse(newHouseId);
		}
		else
			throw new IllegalArgumentException("This user isn't online!");
	}

	public void print(){
		Integer counter = new Integer(0);
		for (String username : usernamesOfUsers) {
			++counter;
			System.out.println("# " + counter);
			this.users.get(username).print();
			System.out.println("------------------------------------");
		}
	}
}
