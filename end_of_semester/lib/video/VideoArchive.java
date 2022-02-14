package lib.video;

import java.util.HashMap;

import lib.util.exception.ExistenceException;
import lib.util.exception.ForbiddenActionException;

// the dictionary to manage Videos. wraps HashMap.
public class VideoArchive {
    public VideoArchive() {
        this.container = new HashMap<>();
    }

    /// fields
    private HashMap<String, Video> container;

    /// methods
    public void addVideo(String title, int num) {
        if (container.containsKey(title)) {
            container.get(title).addStock(num);
        } else {
            container.put(title, new Video(title, num));
        }
    }

    public void reduceVideo(String title, int num) throws ExistenceException, ForbiddenActionException {
        if (!container.containsKey(title)) {
            throw new ExistenceException("No such video exists.");
        }
        container.get(title).reduceStock(num);
        if (container.get(title).getTotalNum() == 0) {
            container.remove(title);
        }
    }

    public void lendVideo(int borrowerId, String title, int num) throws ExistenceException, ForbiddenActionException {
        if (!container.containsKey(title)) {
            throw new ExistenceException("No such video exists.");
        }
        container.get(title).lendVideo(borrowerId, num);
    }

    public void returnVideo(int borrowerId, String title, int num) throws ExistenceException, ForbiddenActionException {
        if (!container.containsKey(title)) {
            throw new ExistenceException("No such video exists");
        }
        container.get(title).returnVideo(borrowerId, num);
    }

    public Video getVideo(String title) throws ExistenceException {
        if (!container.containsKey(title)) {
            throw new ExistenceException("No such video exists.");
        }
        return this.container.get(title);
    }
}
