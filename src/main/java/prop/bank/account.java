package prop.bank;

public class account {
	long acc_no;
	String acc_ho_nm;
	long balance;
	String phone;
	String email;
	String address;
	long password;
	
	account(){}
	
	account(long no,String nm, long bal,String ph,String em,String add,long pass)
	{
		this.acc_no = no;
		this.acc_ho_nm=nm;
		this.balance=bal;
		this.phone=ph;
		this.email=em;
		this.address=add;
		this.password=pass;
	}
	
	public String toString() {
		return this.acc_ho_nm+" || "+this.acc_no+" || "+this.balance+" || "+this.phone+" || "+this.email+" || "+this.address;
	}

}
