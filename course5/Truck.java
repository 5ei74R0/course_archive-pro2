public class Truck extends Car {
    private Goods[] cargo;
    private int goodsNum;

    public Truck(int maxNum) {
        this.cargo = new Goods[maxNum];
        this.goodsNum = 0;
    }

    public void addGoods(Goods goods) {
        // search
        for (int i = 0; i < goodsNum; ++i) {
            if (cargo[i].getType().equals(goods.getType()) && cargo[i].getUnitPrice() == goods.getUnitPrice()
                    && cargo[i].getDestination().equals(goods.getDestination())) {
                cargo[i].setNum(cargo[i].getNum() + goods.getNum());
                return;
            }
        }
        // not found
        // ERROR: already full
        if (goodsNum >= cargo.length) {
            System.out.println("cannot add new goods because cargo is already full.");
            return;
        }
        cargo[goodsNum++] = goods;
    }

    public int totalCargoValue() {
        int res = 0;
        for (int i = 0; i < goodsNum; ++i) {
            res += cargo[i].getUnitPrice() * cargo[i].getNum();
        }
        return res;
    }

    public int getTotalCharge() {
        int res = 0;
        for (int i = 0; i < goodsNum; ++i) {
            res += cargo[i].getCharge();
        }
        return res;
    }

    public void showStatus() {
        for (int i = 0; i < goodsNum; ++i) {
            System.out.println("cargo No. " + i);
            cargo[i].print();
        }
        System.out.println("totalCargoValue: " + totalCargoValue());
        System.out.println("totalCharge: " + getTotalCharge());
    }
}
