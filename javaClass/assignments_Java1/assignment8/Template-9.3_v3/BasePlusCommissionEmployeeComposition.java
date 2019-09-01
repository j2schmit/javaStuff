/*
 * BasePlusCommissionEmployeeComposition.java
 */

public class BasePlusCommissionEmployeeComposition {
    
    private double baseSalary; // base salary per week

    // Demonstrate composition of (as opposed to inheritance from) a CommissionEmployee object

	private CommissionEmployee commissionEmployee;
    
    // six-argument constructor
    public BasePlusCommissionEmployeeComposition( String first, String last, 
            String ssn, double sales, double rate, double salary) {

		this.commissionEmployee = new CommissionEmployee();

		commissionEmployee.setFirstName(first);

		commissionEmployee.setLastName(last);

		commissionEmployee.setSocialSecurityNumber(ssn);

		commissionEmployee.setGrossSales(sales);

		commissionEmployee.setCommissionRate(rate);

		if ( salary < 0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = salary;
    }
    
    // Implement accessors and mutators for all six attributes (stubs appear below)
    // As per the text (demonstrated in its BasePlusCommissionEmployee implementation), throw an IllegalArgumentException if the salary argument is negative
    public void setBaseSalary( double salary ) {

		if ( salary < 0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = salary;
    }    

    public double getBaseSalary() {

		return baseSalary;
    }

    public double setBaseSalary(double salary) {

		this.baseSalary = salary;
    }

    public String getFirstName() {

		return commissionEmployee.getFirstName();
    }

    public double setFirstName(String first) {

		commissionEmployee.setFirstName(first);
    }

    public String getLastName() {

		return commissionEmployee.getLastName();
    }

    public double setLastName(String last) {

		commissionEmployee.setLastName(last);
    }

    public String getSocialSecurityNumber() {

		return commissionEmployee.getSocialSecurityNumber();
    }

    public double setSocialSecurityNumber(String ssn) {
 
		commissionEmployee.setSocialSecurityNumber(ssn);
    }

    public double getGrossSales() {

		return commissionEmployee.getGrossSales();
    }

    public void setGrossSales(double sales) {
 
		commissionEmployee.setGrossSales(sales);
    }

    public double getCommissionRate() {

		return commissionEmployee.getCommissionRate();
    }

    public void setCommissionRate(double rate) {
		commissionEmployee.setCommissionRate(rate);
    }

    public double earnings() {

		return this.baseSalary + commissionEmployee.earnings();

    }

    @Override
    public String toString() {
  
		return String.format("%s %s%n%s: %.2f", "base-salaried", commissionEmployee.toString(), "base salary", getBaseSalary());

    }
}
