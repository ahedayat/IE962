import java.lang.*;

/*
	this class was tested.
	every thing works very well.
	Ali Hedayatnia,
	2018,Thu,Apr 19 6:30'
*/

public class Individual{
	private String phone;
	private Integer balance;
	private final String username;
	private String password;

	public Individual(String username,String password,Integer balance,String phone){	//tested
		this.username=username;
		this.password=password;
		this.balance=balance;
		this.phone=phone;
	}

	public Boolean checkPassword(String password){								//tested							
		return this.password.equals(password);
	}

	protected void changePassword(String password){								//tested 
		this.password = password;
	}
	protected void changePhone(String phone){									//tested 
		this.phone = phone;
	}

	protected void increaseBalance(Integer delta){								//tested 
		if(delta>0)
			balance+=delta;
		else
			throw new IllegalArgumentException("Delta must be grater than 0");
	}
	protected void decreaseBalance(Integer delta){								//tested 
		if(delta>0){
			if(balance>=delta)
				balance-=delta;
			else
				throw new IllegalArgumentException("There isn't enough money");
		}
		else 
			throw new IllegalArgumentException("Delta must be grater than 0");
	}

	public String getUsername(){												//tested
		return this.username;
	}
	public String getPhone(){													//tested
		return this.phone;
	}

	public Integer getBalance(){												//tested
		return this.balance;
	}

	public void print(){														//tested 
		System.out.println("Username : " + username);
		System.out.println("Password : " + password);
		System.out.println("Balance : " + balance);
		System.out.println("Phone : " + phone);
	}

}