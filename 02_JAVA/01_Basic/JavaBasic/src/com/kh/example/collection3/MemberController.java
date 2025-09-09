package com.kh.example.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MemberController {
	HashMap<String, Member> map = new HashMap<>();
	
	public boolean joinMembership(String id, Member m) {
		if(map.containsKey(id)) return false; 
			map.put(id, m);
			return true;
	}
	
	public String logIn(String id, String password) {
	    Member mem = map.get(id); 
	    if (mem != null && mem.getPassword().equals(password)) {
	        return mem.getName(); 
	    } else {
	        return null; 
	    }
	}

	public boolean changePassword(String id, String oldPw, String newPw) {
		 Member mem = map.get(id);
		 if(mem != null){
			 if(mem.getPassword().equals(oldPw)) {
				 mem.setPassword(newPw);
				 return true;
			 }else {
				 return false;
			 }
		 }
		 return false;
	}
	
	public void changeName(String id, String newName) {
		 Member mem = map.get(id);
		 if(mem != null) {
			 mem.setName(newName);
		 }
	}
	
	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> result = new TreeMap<>();
		for(Map.Entry<String, Member> e : map.entrySet()) {
			Member m = e.getValue();
			if(m != null && m.getName().equals(name)) {
				result.put(e.getKey(), m.getName());
			}
		}
		return result;
	}
	
	
}
