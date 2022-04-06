public class Commission extends Hourly
{
private double total_Sales, commission_Rate, payment;
private int hoursWorked;

    //-----------------------------------------------------------------
    //  Constructor: Sets up the commission with the specified
    //  information.
    //-----------------------------------------------------------------

    public Commission(String eName, String eAddress, String ePhone,  String socSecNumber, double rate, double commission_Rate)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commission_Rate = commission_Rate;
        hoursWorked = 0;
    }

    //-----------------------------------------------------------------
    //  Adds the specified number of sales to this employee's
    //  accumulated sales.
    //-----------------------------------------------------------------

     public void addSales (double totalSales){
        total_Sales = totalSales;
     }

    //-----------------------------------------------------------------
    //  Computes and returns the pay for this hourly employee.
    //-----------------------------------------------------------------

     public double pay ()
     {
         double payment = super.pay() + (super.pay() * commission_Rate);
         return payment;
     }

    //-----------------------------------------------------------------
    //  Returns information about this hourly employee as a string.
    //-----------------------------------------------------------------

     public String toString(){
        String result = super.toString() + " Total sales :" + total_Sales;
        return result;
     }
}
