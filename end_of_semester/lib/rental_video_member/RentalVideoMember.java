package lib.rental_video_member;

import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;
import lib.util.Pair;

public class RentalVideoMember {
    public RentalVideoMember() {
        this.id = ++RentalVideoMember.newestId;
        this.name = Integer.toString(this.id);
        this.holdingVideos = new HashMap<>();
    }

    public RentalVideoMember(String name) {
        this.id = ++RentalVideoMember.newestId;
        this.name = name;
        this.holdingVideos = new HashMap<>();
    }

    /// fields
    static private int newestId;
    public final int id; // every member is identified only by id.
    public String name;
    public HashMap<String, Integer> holdingVideos; // <title, num>

    /// methods
    public void borrowVideo(String title, int num) {
        if (holdingVideos.containsKey(title)) {
            this.holdingVideos.put(title, num + holdingVideos.get(title));
        } else {
            this.holdingVideos.put(title, num);
        }
    }

    public boolean isAbleToReturnVideo(String title, int num) {
        if (this.holdingVideos.containsKey(title) & this.holdingVideos.get(title) >= num) {
            return true;
        } else {
            return false;
        }
    }

    public boolean returnVideo(String title, int num) {
        if (this.holdingVideos.containsKey(title)) {
            if (this.holdingVideos.get(title) > num) {
                this.holdingVideos.put(title, this.holdingVideos.get(title) - num);
                return true;
            } else if (this.holdingVideos.get(title) == num) {
                this.holdingVideos.remove(title);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getFormattedId() {
        Stack<Integer> stack = new Stack<>();
        int copiedId = this.id;
        for (int numOfDigits = 0; numOfDigits < 10; ++numOfDigits) {
            stack.push(copiedId % 10);
            copiedId /= 10;
        }
        String formattedId = "";
        while (!stack.empty())
            formattedId += Integer.toString(stack.pop());
        return formattedId;
    }

    public ArrayList<Pair<String, Integer>> getVideoList() {
        ArrayList<Pair<String, Integer>> list = new ArrayList<>();
        this.holdingVideos.forEach((title, num) -> list.add(new Pair<String, Integer>(title, num)));
        return list;
    }
}
