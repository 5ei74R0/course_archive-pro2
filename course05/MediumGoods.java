public class MediumGoods extends Goods {
    public MediumGoods(String type, int num, int unitPrice, String destination) {
        super(type, num, unitPrice, destination);
    }

    @Override
    public int getCharge() {
        return 2000;
    }
}
