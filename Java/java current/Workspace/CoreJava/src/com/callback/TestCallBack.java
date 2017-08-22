package com.callback;

import java.util.ArrayList;
import java.util.List;

interface Bplistener {
    void check();
}

class BloodPressure{
	private List<Bplistener> listeners = new ArrayList<Bplistener>();
	public void addListener(Bplistener toAdd) {
        listeners.add(toAdd);
    }

	private int bloodpressure;	
	public void setBloodpressure(int bloodpressure){
		this.bloodpressure = bloodpressure;
		if(this.bloodpressure>140){
			for (Bplistener hl : listeners)
	            hl.check();
		}else{
			System.out.println("Your bp is under control");
		}
	}
	
	public class CheckBp implements Bplistener{
		@Override
		public void check() {
			System.out.println("Warning! Bp above 140");		
		}
	}
	
	
}
public class TestCallBack {
	public static void main(String[] args) {
		BloodPressure a = new BloodPressure();
		BloodPressure.CheckBp b = a.new CheckBp();
		BloodPressure.CheckBp c = a.new CheckBp();
		BloodPressure.CheckBp d = a.new CheckBp();
		a.addListener(b);
		a.addListener(c);
		a.addListener(d);
		a.setBloodpressure(100);
		a.setBloodpressure(160);
		a.setBloodpressure(100);
		a.setBloodpressure(190);
	}
}