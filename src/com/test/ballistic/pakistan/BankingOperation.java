package com.test.ballistic.pakistan;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ballistic.pakistan.Account;
import com.ballistic.pakistan.BankBranch;
import com.ballistic.pakistan.Customer;
import com.ballistic.pakistan.Transaction;
import com.constant.ballistic.pakistan.AccountType;
import com.constant.ballistic.pakistan.CurrencyType;
import com.constant.ballistic.pakistan.Gender;
import com.constant.ballistic.pakistan.TransectionType;

public class BankingOperation {
	
	EntityManagerFactory emfactory;
    EntityManager entitymanager;
     //suppose we have six branch of bank....
	BankBranch bankBranch;    
	// Customer....
	Customer customer;
	// Account.......
	Account account;
	 //one customer have many account....
	List<Account> accounts;
	 //this is used at the end of the code.....
	
	
	public void callfirst(){
		 //init the jpa
		emfactory = Persistence.createEntityManagerFactory( "BallisticPakistan" );
		entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
			
		
	}
	
	@Test
	public void createNewBranch(){
		callfirst();
		bankBranch = new BankBranch();
		bankBranch.setDescription("Pakistan");
		bankBranch.setName("Faysal Bank");
		bankBranch.setLocation("3-A2, 1/111, Karachi");
		
		entitymanager.persist(bankBranch);
		
		commint();
		
		BankBranch tempBankBranch = entitymanager.find(BankBranch.class, 1);
		assertEquals(bankBranch.toString(),tempBankBranch.toString());
		close();

		 
	}
	
	@Test
	public void createNewAccount(){
		callfirst();
		customer = new Customer();
		account = new Account();
		accounts = new ArrayList<Account>();
		
		//first customer detail get.....
		customer.setNric("31202-1336824-5");
		customer.setUserName("Ali jan");
		customer.setGivenName("nabeel.amd93@gmail.com");
		customer.setPassWord("Pakistan zindabad");
		//
		customer.setDateOfBirth(Date.valueOf("1993-06-08"));
		customer.setAddress("B3rd");
		customer.setGender(Gender.MALE);
		customer.setDateOfJoin(new java.sql.Date(System.currentTimeMillis()));
		customer.setNationality("Pakistan");
	
		// create the new account.... related to the which branch id.....
		account.setAccountType(AccountType.Checking);
		account.setAmmount(5000L);
		account.setCurrencyType(CurrencyType.Pakistan);
		account.setPin(2568);
		account.setBankBranch(this.bankBranch);
		accounts.add(account);
		customer.setAccounts(accounts);
		
		// here need the Transaction.... for new customer as...
		Transaction transaction = new Transaction();
		
		transaction.setAmmount(account.getAmmount());
		transaction.setCustName(customer.getGivenName());
		transaction.setType(TransectionType.Create);
		transaction.setTransectionTimeAndDate(new java.sql.Date(System.currentTimeMillis()));
		
		//
		entitymanager.persist(customer);
		entitymanager.persist( account);
		entitymanager.persist( transaction );
		commint();
		
		// know we have to fine the customer Nice
		Customer tempCustomer = entitymanager.find(Customer.class, 1);
		//
		assertEquals(customer.getNric(),tempCustomer.getNric());
		close();
	}
	

	@Test
	public void deposit(){
		// which open the tube.
		callfirst();
		 
		List<Account> depositAccount = new ArrayList<Account>();
	     //get the customer....
	    Customer customer = entitymanager.find( Customer.class, 1 );
	    
	    depositAccount =  customer.getAccounts();
	    //
	    System.out.println("--------------------------");
	    
	    Long currentammount = 0L;
	    for (Account account : depositAccount) {
			System.out.println(account.getAccountID());
			if(account.getAccountID() == 1){
				//
				currentammount = account.getAmmount() + 500L;
				account.setAmmount(currentammount);
				//
				
				System.out.println(currentammount);
				entitymanager.persist(account);
				break;
			}
	
		}
	    System.out.println("---------------------------");
		//
	    Transaction depositeTransaction = new Transaction(null, TransectionType.Deposit,500L , new java.sql.Date(System.currentTimeMillis()));
	    depositeTransaction.setCustName(customer.getGivenName());
	    entitymanager.persist(depositeTransaction);
	    commint();
		
	    //
	    Transaction tempTransaction = entitymanager.find(Transaction.class, 2);
	    assertEquals((Long)500L,tempTransaction.getAmmount());
	    close();
	}
	
	@Test
	public void withdraw(){
	    callfirst();	
		// Customer detail
	    List<Account> withdrawAccounts = new ArrayList<Account>();
	    // get the customer....
	    Customer customer = entitymanager.find( Customer.class, 1 );
	    
	    withdrawAccounts =  customer.getAccounts();
	     //this loop used because one customer have many account.... that way...
	     //but here we put one account only on the this customer
	    // bad....logic ..... here i used due to the no time for update....
	    Long currentammount = 0L;
	    for (Account account : withdrawAccounts) {
		    
			if(account.getAccountID() == 1){
				//
				currentammount = account.getAmmount();
				if(currentammount < 500L){
					// but here need more logic for transaction but i'm not used...... here due to time 
					System.out.println("ammount is less than 500....Rs");
				}else{
					// do process......
					currentammount = currentammount - 500L;
					account.setAmmount(currentammount);
					entitymanager.persist(account);
				}
				break;
			}
		}
	    
	    Transaction withdrawTransaction = new Transaction(null, TransectionType.Withdraw,500L , new java.sql.Date(System.currentTimeMillis()));
	    withdrawTransaction.setCustName(customer.getGivenName());
	    entitymanager.persist(withdrawTransaction);
	    commint();
	    
	    Transaction tempTransaction = entitymanager.find(Transaction.class, 3);
	    assertEquals((Long)500L,tempTransaction.getAmmount());
		close();
	}
	
	@Ignore
	@Test
	public void transfer(){
		//
		// not used method......
	}
	@Ignore
	@Test
	public void transferHistory(){
		// not used method....
	}
	
	public void commint(){
		entitymanager.getTransaction( ).commit( );
	}
	
	public void close(){
		entitymanager.close( );
		emfactory.close( );
	}
	
	
	

}
