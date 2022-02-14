public class BigGoods extends Goods {
    public BigGoods(String type, int num, int unitPrice, String destination) {
        super(type, num, unitPrice, destination);
    }

    @Override
    public int getCharge() {
        return 3000;
    }
}
