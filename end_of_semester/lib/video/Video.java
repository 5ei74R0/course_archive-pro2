package lib.video;

import java.util.HashMap;
import java.util.ArrayList;

import lib.util.Pair;
import lib.util.exception.ForbiddenActionException;
import lib.util.exception.ExistenceException;

public class Video {
    public Video(String title, int stockNum) {
        this.title = title;
        this.totalNum = stockNum;
        this.lentNum = 0;
        this.currentBorrowers = new HashMap<>();
    }

    /// fields
    public final String title; // every video is identified only by title.
    private int totalNum;
    private int lentNum;
    private HashMap<Integer, Integer> currentBorrowers;  // id, username, num

    /// methods
    public void addStock(int num) {
        this.totalNum += num;
    }

    // if the stock-shortage occurred, then throws TooManyReductionException
    public void reduceStock(int num) throws ForbiddenActionException {
        if (getStockNum() < num) {
            throw new ForbiddenActionException("stock shortage has occurred.");
        }
        this.totalNum -= num;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public int getStockNum() {
        return this.totalNum - lentNum;
    }

    public int getLentNum() {
        return this.lentNum;
    }

    // if the stock-shortage occurred, then throws TooManyReductionException
    public void lendVideo(int borrowerId, int num) throws ForbiddenActionException {
        if (getStockNum() < num) {
            throw new ForbiddenActionException("stock shortage has occurred.");
        }
        lentNum += num;
        this.currentBorrowers.put(borrowerId, num + lentNumOfBorrower(borrowerId));
    }

    public int lentNumOfBorrower(int borrowerId) {
        if (this.currentBorrowers.containsKey(borrowerId)) {
            return this.currentBorrowers.get(borrowerId);
        } else {
            return 0;
        }
    }

    // if the borrower does not exist, then throws ExistenceException
    // if the borrower aims to return too many videos, then throws TooManyReductionException
    public void returnVideo(int borrowerId, int num) throws ExistenceException, ForbiddenActionException {
        if (!this.currentBorrowers.containsKey(borrowerId)) {
            throw new ExistenceException("No such user ID exists.");
        }
        if (num > lentNumOfBorrower(borrowerId)) {
            throw new ForbiddenActionException("too many returning has occurred.");
        }
        this.lentNum -= num;
        this.currentBorrowers.put(borrowerId, lentNumOfBorrower(borrowerId) - num);
        if (this.currentBorrowers.get(borrowerId) == 0) {
            this.currentBorrowers.remove(borrowerId);
        }
    }

    public String getStockStatus() {
        return Integer.toString(this.getStockNum()) + "/" + Integer.toString(this.getTotalNum());
    }

    public ArrayList<Pair<Integer, Integer>> getBorrowerList() {
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        this.currentBorrowers.forEach((borrowerId, num) -> list.add(new Pair<Integer, Integer>(borrowerId, num)));
        return list;
    }
}
