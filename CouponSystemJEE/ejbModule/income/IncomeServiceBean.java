package income;

import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.aspects.asynchronous.aspects.jboss.Asynchronous;

@Stateless
@Remote(IncomeService.class)
public class IncomeServiceBean {

    public IncomeServiceBean() {	}
    
    @Asynchronous
    public void storeIncome(Income income)
    {
    	
    }
    
    public Collection<Income> viewAllIncome()
    {
		
    	return null;
    }
    
    public Collection<Income> viewIncomeByCustomer(long customerId)
    {
    	return null;
    }
    
    public Collection<Income> viewIncomeByCompany(long companyId)
    {
    	return null;
    }

}
