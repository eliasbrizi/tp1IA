package coronaTracker.actions;
import coronaTracker.CoronaTrackerAgentState;
import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import coronaTracker.Domain.Camino;
public class GoC15 extends SearchAction {
   @Override
   public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CoronaTrackerAgentState agentState = (CoronaTrackerAgentState) s;
       if (agentState.getVisitedPositions().contains(CoronaTrackerAgentState.C15)) {
          return null;
      }
      ArrayList<String> successors = new ArrayList<String>();
      successors.addAll(agentState.getSuccessors());
      if (successors != null) {
          int index = successors.indexOf(CoronaTrackerAgentState.C15);
          if (index >= 0 && !agentState.getCaminosCortados().contains(new Camino(agentState.getPosition(),CoronaTrackerAgentState.C15))) {
               agentState.setPosition(CoronaTrackerAgentState.C15);
               agentState.setCostCount(agentState.getCostCount() + this.getCost());
//               System.out.println("working... C15");
               return agentState;
         }
   }
     return null;
  }
   @Override
   public EnvironmentState execute(AgentState ast, EnvironmentState est) {
       this.execute((SearchBasedAgentState) ast);
      return null;
  }
  @Override
  public Double getCost() {
      return new Double(1);
  }
@Override
  public String toString() {
      return "GoC15";
  }
}