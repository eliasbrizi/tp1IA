package coronaTracker;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 

public class Utilities {

	public static void main(String[] args) {
		acciones();
	}
	
	private static void nodos() {
		for (char a='A' ; a<'N' ; a++){
			for (int i=0 ; i<18 ; i++){
				System.out.println("public static final String " +a + i + " = \"" + a + i +"\";");
			};
		};
	}
	
	public static void acciones() {
		FileWriter flwriter = null;
		BufferedWriter bfwriter;
		try {
			for (char a='A' ; a<'N' ; a++){
				for (int i=0 ; i<18 ; i++){
				//	File file = new File("/home/elias/clasesGo/Go"+a+i+".java");
			flwriter = new FileWriter("/home/elias/clasesGo/Go"+a+i+".java");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			bfwriter = new BufferedWriter(flwriter);
			
				bfwriter.write("package coronaTracker.Actions;\n"+
						"import frsf.cidisi.faia.examples.search.robot.RobotAgentState;\n"+
						"import java.util.ArrayList;\n"+

						"import frsf.cidisi.faia.Agent.search.SearchAction;\n"+
						"import frsf.cidisi.faia.Agent.search.SearchBasedAgentState;\n"+
						"import frsf.cidisi.faia.state.AgentState;\n"+
						"import frsf.cidisi.faia.state.EnvironmentState;\n"+

						"public class Go"+a+i+" extends SearchAction {\n"+

						 "   @Override\n"+
						 "   public SearchBasedAgentState execute(SearchBasedAgentState s) {\n"+
						"        CoronaTrackerAgentState agentState = (CoronaTrackerAgentState) s;\n"+
						 "       if (agentState.getVisitedPositions().contains(CoronaTrackerAgentState."+a+i+")) {\n"+
						  "          return null;\n"+
						  "      }\n"+
						  "      ArrayList<String> successors = new ArrayList<String>();\n"+
						  "      successors.AddAll(agentState.getSuccessors());\n"+
						  "      if (successors != null) {\n"+
						  "          int index = successors.indexOf(CoronaTrackerAgentState."+a+i+");\n"+
						  "          if (index >= 0) {\n"+
						  "              agentState.setPosition(CoronaTrackerAgentState."+a+i+");\n"+
						     "           return agentState;\n"+
						   "         }\n"+
						     "   }\n"+
						   "     return null;\n"+
						  "  }\n"+
						 "   @Override\n"+
						 "   public EnvironmentState execute(AgentState ast, EnvironmentState est) {\n"+
						 "       this.execute((SearchBasedAgentState) ast);\n"+
						  "      return null;\n"+
						  "  }\n"+
						  "  @Override\n"+
						  "  public Double getCost() {\n"+
						  "      return new Double(0);\n"+
						  "  }\n"+
						    "@Override\n"+
						  "  public String toString() {\n"+
						  "      return \"Go"+a+i+"\";\n"+
						  "  }\n"+
						  "}");
		
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
