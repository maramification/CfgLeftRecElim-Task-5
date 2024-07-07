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
	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */
	public CfgLeftRecElim(String cfg) {
		String[] temp = cfg.split("#");
		String[] vars = temp[0].split(";");
		this.terminals = temp[1];
		String[] der = temp[2].split(";");
		
		
		//adding derivations
		for (int i = 0; i < der.length; i++) {
			derivations.add(der[i]);
		}
		
		for (int i = 0; i < vars.length; i++) {
			variables.add(vars[i]);
		}
		
		
		//eliminateLeftRecursion();
		//toString();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Returns a formatted string representation of the CFG. The string
	 *         representation follows the one in the task description
	 */
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
					
					//System.out.println("variable: " + variables.get(i));
					//System.out.println("Vderivations: " + derivations.get(k));
					if (R.equals("")) {
						R = derivations.get(k);
					}
					
					else {
						R = R + ";" + derivations.get(k);
					}
					
					//System.out.println("RRR: " + R);		
			}
			
			
			}
		}
		
		
		finalString = V + "#" + terminals + "#" + R;
		//System.out.println("finalString1: " + finalString);
		// TODO Auto-generated method stub
		return finalString;
	}

	/**
	 * Eliminates Left Recursion from the grammar
	 */
	public void eliminateLeftRecursion() {
		// TODO Auto-generated method stub
		for (int i = 0; i < variables.size(); i++) {
			//System.out.println("ana at iteration " + i);
			if (i == 0) {
				//System.out.println("el variable beta3y: " + variables.get(i));
				elimLeftRecChecker(variables.get(i));
			}
			
			else {
				
				for (int k = 0; k  < i; k++) {
					//System.out.println("prev V: " + variables.get(k));
					//System.out.println("next V: " + variables.get(i));
					if (! (variables.get(k).equals(variables.get(i)))) {
						
						//if none is a left recursive result
						if(! (variables.get(k).length() >=2  || variables.get(i).length() >= 2)) {
							//System.out.println("Im  soooo true");
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
					//System.out.println("ana da el maaya " + temp1[k]);
					//System.out.println("da my variable " + v);
					//String str 
					String str = String.valueOf(temp1[k].charAt(0));
					
					if (v.length() >= 2 && temp1[k].length() >= 2) {
						str = temp1[k].substring(0, 2);
					}
					
					if (str.equals(v)) {
						//System.out.println("im hereeee");
						leftRecurse = true;
						derivations.remove(i);
					}
					
					if (leftRecurse) {
				    // System.out.println("ana be true and im executing: " + v);
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
			//System.out.println("WHAT THA HEEEEELL");
			derivations.add(vDs);
		}
		
		if (! (derivations.contains(vDDs))) {
			derivations.add(vDDs);
		}

		//System.out.println("vDs: " + vDs);
		//System.out.println("vDDs: " + vDDs);
		
	}
	
	
	public ArrayList<String> AllDerivations(String v) {
		ArrayList<String> allD = new ArrayList<String>();
		for (int i = 0; i < derivations.size(); i++) {
			String[] temp = derivations.get(i).split("/");
			//System.out.println("derivations.get(i): " + derivations.get(i));
			
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
		//System.out.println("preVSubs: " + preVSubs);
		
	
		
		for (int i = 0; i < derivations.size(); i++) {
			String[] temp = derivations.get(i).split("/");
			
			
			if (temp[0].equals(v2)) {
				String[] temp1 = temp[1].split(",");
			
				
				
				for (int k = 0; k < temp1.length; k++) {
					
					//System.out.println("tempat1: " + temp1[k]);
					String str =  String.valueOf(temp1[k].charAt(0));
					
					if (v1.length() >= 2 && temp1[k].length() >= 2 ) {
						str = temp1[k].substring(0, 2);
					}
					
					
					//System.out.println("STR: " + str);
					//System.out.println("MY VVV: " + v1);
					
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
		//System.out.println("finalString: " + finalString);
		
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
		
		//System.out.println("newSubs" + newSubs);
		return newSubs;
	}
	
	
	
//	public static void main(String[] args) { 
//		
//		
//	String cfg = "S;U;T;V;K;F;J#j;o;q;u#S/jVFS,uSVqK,SoT,FJJT,KJ;U/jSqV,JJ,oSF,SjKUJ,UU,UTKjV;T/VoT,JUoV,jFq,TJKV,TuTj;V/u,oU,uJ,jVqS;K/jFuS,oT;F/JSjKK,qSjJS,JoTF,KjSUV,VJqKK;J/uK,UJFq,SJoS";
//	CfgLeftRecElim newCFG = new CfgLeftRecElim(cfg);
//	
//	
//	//System.out.println("derivations: " + newCFG.derivations);
//	
//	//System.out.println("variables: " + newCFG.variables);
//	
//	
//	}

}
