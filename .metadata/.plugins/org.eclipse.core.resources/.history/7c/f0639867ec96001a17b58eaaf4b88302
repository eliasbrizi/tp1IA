package coronaTracker.actions;
import coronaTracker.CoronaTrackerAgentState;
import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import coronaTracker.Domain.Camino;

public class MandarACasa extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		CoronaTrackerAgentState agente = (CoronaTrackerAgentState) s;
		if (agente.getPosition()
				.equals(agente.getCiudadanosEscapados().get(0).getPosition())) {
			if (!agente.getCiudadanosInfectados().
					contains(agente.getCiudadanosEscapados().get(0))) {
				//TODO ver si hacer random o como saber si lo ponemos como infectado
				if ( (Math.round((Math.random()*100))% 4) != 0)
				agente.getCiudadanosInfectados().add(agente.getCiudadanosEscapados().get(0));
			}
			agente.getCiudadanosEscapados().remove(0);

		    agente.getVisitedPositions().clear();
			return agente; 
		}
			
		return null;
	}

	@Override
	public Double getCost() {
		return 0.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
	       this.execute((SearchBasedAgentState) ast);
	       return null;
	}

	@Override
	public String toString() {
		String str = "Hacer la ley, multar y mandar a casa.";
		return str;
	}

}