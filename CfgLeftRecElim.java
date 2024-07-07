package csen1002.main.task5;

import java.util.ArrayList;

/**
 * Write your info here
 * 
 * @name Maram Hossam
 * @id 49-1891
 * @labNumber 18
 */

public class CfgLeftRecElim {

	private String terminals;
	private ArrayList<String> derivations = new ArrayList<String>(); 
	private ArrayList<String> variables = new ArrayList<String>(); 
	ArrayList<String> newDerivations = new ArrayList<String>();

	public CfgLeftRecElim(String cfg) {
		String[] temp = cfg.split("#");
		String[] vars = temp[0].split(";");
		this.terminals = temp[1];
		String[] der = temp[2].split(";");
		
		
		for (int i = 0; i < der.length; i++) {
			derivations.add(der[i]);
		}
		
		for (int i = 0; i < vars.length; i++) {
			variables.add(vars[i]);
		}
	}

	@Override
	public String toString() {
		String finalString = "";
		String V = "";
		String R = "";
		
		for(int i = 0; i < variables.size(); i++) {
		   if (V.equals("")) {
			   V = variables.get(i);
		   }
		   
		   else {
			   V = V + ";" + variables.get(i);
		   }
		}
		
		for (int i = 0; i < variables.size(); i++) {
			for (int k = 0; k < derivations.size(); k++) {
				String[] temp = derivations.get(k).split("/");
				if (temp[0].equals(variables.get(i))) {
					
					if (R.equals("")) {
						R = derivations.get(k);
					}
					
					else {
						R = R + ";" + derivations.get(k);
					}
					
			}
			
			
			}
		}
		
		
		finalString = V + "#" + terminals + "#" + R;
		return finalString;
	}

	public void eliminateLeftRecursion() {
		for (int i = 0; i < variables.size(); i++) {
			if (i == 0) {
				elimLeftRecChecker(variables.get(i));
			}
			
			else {
				
				for (int k = 0; k  < i; k++) {
					if (! (variables.get(k).equals(variables.get(i)))) {
						
						if(! (variables.get(k).length() >=2  || variables.get(i).length() >= 2)) {
							ProductionElim(variables.get(k), variables.get(i));
						}
						
					
					}
				}
				
				
				elimLeftRecChecker(variables.get(i));
				
			}
		}
	}
	
	
	
	public void elimLeftRecChecker(String v) {
		boolean leftRecurse = false;
		ArrayList<String> allDs = AllDerivations(v);
		 
		for (int i = 0; i < derivations.size(); i++) {
			String[] temp =  derivations.get(i).split("/");
			if (v.equals(temp[0])) {
				String[] temp1 = temp[1].split(",");
				
				for (int k = 0; k < temp1.length; k++) {
					String str = String.valueOf(temp1[k].charAt(0));
					
					if (v.length() >= 2 && temp1[k].length() >= 2) {
						str = temp1[k].substring(0, 2);
					}
					
					if (str.equals(v)) {
						leftRecurse = true;
						derivations.remove(i);
					}
					
					if (leftRecurse) {
					 elimLeftRec(v, allDs);
					 leftRecurse = false;
					 break;
						
					}
				}
			

					}
				}
		
		
		
			}
		
	
	
	
	public void elimLeftRec(String v, ArrayList<String> derivatives) {
		
		variables.add(v+"'");
		
		String vDerivationsString = "";
		String vDashDerivationsString = "";
		ArrayList<String> vDerivations = new ArrayList<String>();
		ArrayList<String> vDashDerivations = new ArrayList<String>();

		for(int i = 0; i < derivatives.size(); i++) {
			String str = String.valueOf(derivatives.get(i).charAt(0));
			
			if (v.length() >= 2 && derivatives.get(i).length() >= 2) {
				str = derivatives.get(i).substring(0,2);
			}
			
			if (! (str.equals(v))) {
				String derivation = derivatives.get(i) + v + "'";
				vDerivations.add(derivation);
			}
			
			else {
				String derivation = derivatives.get(i).substring(1) + v + "'";
				vDashDerivations.add(derivation);
				
			}
			
		}
		
		
		for (int i = 0; i < vDerivations.size(); i++) {
			if (vDerivationsString.equals("")) {
				vDerivationsString = vDerivations.get(i);
			}
			
			else {
				vDerivationsString = vDerivationsString +  "," + vDerivations.get(i);
			}
		}
		
		
		for (int i = 0; i < vDashDerivations.size(); i++) {
			if (vDashDerivationsString.equals("")) {
				vDashDerivationsString = vDashDerivations.get(i);
			}
			
			else {
				vDashDerivationsString = vDashDerivationsString +  "," + vDashDerivations.get(i);
			}
		}
		
		String vDs = v + "/" + vDerivationsString;
		String vDDs = v + "'" + "/" + vDashDerivationsString + "," + "e";
		
		
		
		if (! (derivations.contains(vDs))) {
			derivations.add(vDs);
		}
		
		if (! (derivations.contains(vDDs))) {
			derivations.add(vDDs);
		}

		
	}
	
	
	public ArrayList<String> AllDerivations(String v) {
		ArrayList<String> allD = new ArrayList<String>();
		for (int i = 0; i < derivations.size(); i++) {
			String[] temp = derivations.get(i).split("/");
			
			if (v.equals(temp[0])) {
				String[] temp1 = temp[1].split(",");
				
				for (int k = 0; k < temp1.length; k++) {
					allD.add(temp1[k]);
				}
			}
		}
		
		
		return allD;
		
	}
	
	
	
	public void ProductionElim(String v1, String v2) {
		ArrayList<String> newSubs = new ArrayList<String>();
		ArrayList<String> preVSubs = new ArrayList<String>();
		
		
		for (int i = 0; i < derivations.size(); i++) {
			String[] temp = derivations.get(i).split("/");
			
			if (temp[0].equals(v1)) {
				preVSubs = AllDerivations(v1);
				break;
			}
		}
		
	
		
		for (int i = 0; i < derivations.size(); i++) {
			String[] temp = derivations.get(i).split("/");
			
			
			if (temp[0].equals(v2)) {
				String[] temp1 = temp[1].split(",");
			
				
				
				for (int k = 0; k < temp1.length; k++) {
					
					String str =  String.valueOf(temp1[k].charAt(0));
					
					if (v1.length() >= 2 && temp1[k].length() >= 2 ) {
						str = temp1[k].substring(0, 2);
					}
					
					
					
					if (str.equals(v1)) {
						ArrayList<String> newSub = ProductionSub(temp1[k], preVSubs);
						newSubs.addAll(newSub);
					}
					
					else {
						newSubs.add(temp1[k]);
					}
				}
			}
			
			
		}
		
		
		String newSubsString = "";
		
		for (int i = 0; i < newSubs.size(); i++) {
			if (newSubsString.equals("")) {
				newSubsString = newSubs.get(i);
			}
			
			else {
				newSubsString = newSubsString + "," + newSubs.get(i);
			}
		}
		
		
		String finalString = v2 + "/" + newSubsString;
		
		for (int i = 0; i < derivations.size(); i++) {
			String[] temp = derivations.get(i).split("/");
			if(temp[0].equals(v2)) {
				derivations.remove(i);
			}
		}
		if (! (derivations.contains(finalString))) {
			derivations.add(finalString);
		}
		
		
		
	}
	
	
	
	public ArrayList<String> ProductionSub(String v, ArrayList<String> subs) {
		ArrayList<String> newSubs = new ArrayList<String>();
		
		for (int i = 0; i < subs.size(); i++) {
			String newSub = subs.get(i) + v.substring(1);
			newSubs.add(newSub);
		}
		
		return newSubs;
	}


}
