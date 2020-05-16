package coronaTracker.actions;
import coronaTracker.CoronaTrackerAgentState;
import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import coronaTracker.Domain.Camino;
public class GoB11 extends SearchAction {
   @Override
   public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CoronaTrackerAgentState agentState = (CoronaTrackerAgentState) s;
       if (agentState.getVisitedPositions().contains(CoronaTrackerAgentState.B11)) {
          return null;
      }
      ArrayList<String> successors = new ArrayList<String>();
      successors.addAll(agentState.getSuccessors());
      if (successors != null) {
          int index = successors.indexOf(CoronaTrackerAgentState.B11);
          if (index >= 0 && !agentState.getCaminosCortados().contains(new Camino(agentState.getPosition(),CoronaTrackerAgentState.B11))) {
               agentState.setPosition(CoronaTrackerAgentState.B11);
               agentState.setCostCount(agentState.getCostCount() + this.getCost());
//               System.out.println("working... B11");
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
      return new Double(2);
  }
@Override
  public String toString() {
      return "GoB11";
  }
}