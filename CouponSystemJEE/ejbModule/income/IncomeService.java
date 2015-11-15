package income;

import java.util.Collection;

import javax.ejb.Remote;

@Remote
public interface IncomeService {
	public void storeIncome(Income income);
    public Collection<Income> viewAllIncome();
    public Collection<Income> viewIncomeByCustomer(long customerId);
    public Collection<Income> viewIncomeByCompany(long companyId);
}
