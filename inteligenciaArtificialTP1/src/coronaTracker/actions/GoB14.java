package coronaTracker.actions;
import coronaTracker.CoronaTrackerAgentState;
import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import coronaTracker.Domain.Camino;
public class GoB14 extends SearchAction {
   @Override
   public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CoronaTrackerAgentState agentState = (CoronaTrackerAgentState) s;
       if (agentState.getVisitedPositions().contains(CoronaTrackerAgentState.B14)) {
          return null;
      }
      ArrayList<String> successors = new ArrayList<String>();
      successors.addAll(agentState.getSuccessors());
      if (successors != null) {
          int index = successors.indexOf(CoronaTrackerAgentState.B14);
          if (index >= 0 && !agentState.getCaminosCortados().contains(new Camino(agentState.getPosition(),CoronaTrackerAgentState.B14))) {
              agentState.setPosition(CoronaTrackerAgentState.B14);
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
      return "GoB14";
  }
}