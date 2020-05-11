package coronaTracker.actions;
import coronaTracker.CoronaTrackerAgentState;
import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import coronaTracker.Domain.Camino;
public class GoE16 extends SearchAction {
   @Override
   public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CoronaTrackerAgentState agentState = (CoronaTrackerAgentState) s;
       if (agentState.getVisitedPositions().contains(CoronaTrackerAgentState.E16)) {
          return null;
      }
      ArrayList<String> successors = new ArrayList<String>();
      successors.addAll(agentState.getSuccessors());
      if (successors != null) {
          int index = successors.indexOf(CoronaTrackerAgentState.E16);
          if (index >= 0 && !agentState.getCaminosCortados().contains(new Camino(agentState.getPosition(),CoronaTrackerAgentState.E16))) {
              agentState.setPosition(CoronaTrackerAgentState.E16);
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
      return "GoE16";
  }
}