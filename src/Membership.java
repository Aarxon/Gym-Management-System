public class Membership
{
    private boolean status = false;
    private String startDate = "";
    private String expiryDate = "";
    private String type = "";

    public Membership(boolean status, String startDate, String expiryDate, String type)
    {
        this.status = status;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.type = type;
    }

}
