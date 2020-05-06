package coronaTracker.Actions;
import frsf.cidisi.faia.examples.search.robot.RobotAgentState;
import java.util.ArrayList;
import frsf.cidisi.faia.Agent.search.SearchAction;
import frsf.cidisi.faia.Agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
public class GoM11 extends SearchAction {
   @Override
   public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CoronaTrackerAgentState agentState = (CoronaTrackerAgentState) s;
       if (agentState.getVisitedPositions().contains(CoronaTrackerAgentState.M11)) {
          return null;
      }
      ArrayList<String> successors = new ArrayList<String>();
      successors.AddAll(agentState.getSuccessors());
      if (successors != null) {
          int index = successors.indexOf(CoronaTrackerAgentState.M11);
          if (index >= 0) {
              agentState.setPosition(CoronaTrackerAgentState.M11);
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
      return new Double(0);
  }
@Override
  public String toString() {
      return "GoM11";
  }
}