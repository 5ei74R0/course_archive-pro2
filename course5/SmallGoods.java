public class SmallGoods extends Goods {
    public SmallGoods(String type, int num, int unitPrice, String destination) {
        super(type, num, unitPrice, destination);
    }

    @Override
    public int getCharge() {
        return 1000;
    }
}
