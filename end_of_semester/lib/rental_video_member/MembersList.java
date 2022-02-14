package lib.rental_video_member;

import java.util.HashMap;

import lib.util.exception.ExistenceException;
import lib.util.exception.ForbiddenActionException;

import java.util.ArrayList;

public class MembersList {
    public MembersList() {
        this.nameIndexedDict = new HashMap<>();
        this.idIndexedDict = new HashMap<>();
    }

    private HashMap<String, ArrayList<RentalVideoMember>> nameIndexedDict;
    private HashMap<Integer, RentalVideoMember> idIndexedDict;

    // return assigned id
    public int registerMember(String name) {
        RentalVideoMember member = new RentalVideoMember(name);
        idIndexedDict.put(member.id, member);
        if (nameIndexedDict.containsKey(name)) {
            ArrayList<RentalVideoMember> array = nameIndexedDict.get(name);
            array.add(member);
            nameIndexedDict.put(name, array);
        } else {
            ArrayList<RentalVideoMember> array = new ArrayList<>();
            array.add(member);
            nameIndexedDict.put(name, array);
        }
        return member.id;
    }

    public void withdraw(int id) throws ExistenceException, ForbiddenActionException {
        RentalVideoMember member = this.searchById(id);
        if (member == null) {
            throw new ExistenceException("No such ID is registered.");
        }
        if (!member.holdingVideos.isEmpty()) {
            throw new ForbiddenActionException("The member still holds some videos");
        }
        this.idIndexedDict.remove(id);
        var array = this.nameIndexedDict.get(member.name);
        array.remove(member);
        if (array.isEmpty()) {
            this.nameIndexedDict.remove(member.name);
        }
    }

    public RentalVideoMember searchById(int id) throws ExistenceException {
        if (!this.idIndexedDict.containsKey(id)) {
            throw new ExistenceException("No such ID exists.");
        }
        return this.idIndexedDict.get(id);
    }

    // we cannot decide one user, when the system includes more than one user having
    // same username.
    public ArrayList<RentalVideoMember> searchByName(String name) throws ExistenceException {
        if (!this.nameIndexedDict.containsKey(name)) {
            throw new ExistenceException("No such username exists.");
        }
        return this.nameIndexedDict.get(name);
    }
}
