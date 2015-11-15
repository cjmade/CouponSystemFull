package income;

import java.util.Date;
import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;

@Stateful(mappedName = "income")
public class Income {

	@PersistenceContext
	private long id;
	private String name;
	private Date date;
	private IncomeType description;
	private double amount;
	
    public Income() {
        // TODO Auto-generated constructor stub6n 
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IncomeType getDescription() {
		return description;
	}

	public void setDescription(IncomeType description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
    
    

}
