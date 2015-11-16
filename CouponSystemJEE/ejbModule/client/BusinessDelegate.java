package client;

import java.util.Collection;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;

import income.Income;
import income.IncomeService;

public class BusinessDelegate {

	private QueueSession qsession;
	private QueueSender qsender;
	private IncomeService incomeService;
	
	
	public BusinessDelegate(){
		try{
		InitialContext ctx=new InitialContext();
		QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("ConnectionFactory");
		Queue q=(Queue)ctx.lookup("queue/couponQueue");
		incomeService=(IncomeService)ctx.lookup("incomeService/remote");
		
		QueueConnection qcon=f.createQueueConnection();
		qsession=qcon.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		qsender=qsession.createSender(q);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public synchronized void storeIncome(Income i){
		try{
			qsender.send(qsession.createObjectMessage(i));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Collection<Income> viewAllIncome(){
		return incomeService.viewAllIncome();
	}
	
	public Collection<Income> viewIncomeByCompany(long id){
		return incomeService.viewIncomeByCompany(id);
	}
	
	public Collection<Income> viewIncomeByCustomer(long id){
		return incomeService.viewIncomeByCustomer(id);
	}
}