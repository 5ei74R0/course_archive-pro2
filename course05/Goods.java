public abstract class Goods {
    private String type;
    private int num;
    private int unitPrice;
    private String destination;
    protected Goods(String type, int num, int unitPrice, String destination) {
        this.type = type;
        this.num = num;
        this.unitPrice = unitPrice;
        this.destination = destination;
    }

    public String getType() {
        String res = new String(type);
        return res;
    }

    public int getNum() {
        return num;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getDestination() {
        String res = new String(destination);
        return res;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTotalPrice() {
        return unitPrice * num;
    }

    public void print() {
        System.out.println(">   type of goods: " + this.getType());
        System.out.println(">   number of goods: " + this.getNum());
        System.out.println(">   unit price: " + this.getUnitPrice());
        System.out.println(">   destination: " + this.getDestination());
    }

    public abstract int getCharge();
}
