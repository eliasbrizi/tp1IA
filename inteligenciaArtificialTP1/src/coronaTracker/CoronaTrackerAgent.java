/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa
 * y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package coronaTracker;

import java.util.Vector;

import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;

import java.util.logging.Level;
import java.util.logging.Logger;
import coronaTracker.actions.*;

public class CoronaTrackerAgent extends SearchBasedAgent {

    public CoronaTrackerAgent() {
        // Robot agent goal
        CoronaGoal goal = new CoronaGoal();

        // Robot agent state
        CoronaTrackerAgentState agentState = new CoronaTrackerAgentState();
        this.setAgentState(agentState);

        // Robot agent actions
        Vector<SearchAction> actions = new Vector<SearchAction>();
    /*
    * Acciones mapa grande
    */
        // actions.addElement(new GoA1());
        // actions.addElement(new GoA2());
        // actions.addElement(new GoA3());
        // actions.addElement(new GoA5());
        // actions.addElement(new GoA6());
        // actions.addElement(new GoA7());
        // actions.addElement(new GoA8());
        // actions.addElement(new GoA9());
        // actions.addElement(new GoA10());
        // actions.addElement(new GoA11());
        // actions.addElement(new GoA12());
        // actions.addElement(new GoA14());
        // actions.addElement(new GoA15());
        // actions.addElement(new GoA16());
        // actions.addElement(new GoA17());
        // actions.addElement(new GoB15());
        // actions.addElement(new GoB16());
        // actions.addElement(new GoB17());
        // actions.addElement(new GoC10());
        // actions.addElement(new GoC11());
        // actions.addElement(new GoC12());
        // actions.addElement(new GoC14());
        // actions.addElement(new GoC15());
        // actions.addElement(new GoC16());
        // actions.addElement(new GoC17());
        // actions.addElement(new GoD1());
        // actions.addElement(new GoD2());
        // actions.addElement(new GoD3());
        // actions.addElement(new GoD5());
        // actions.addElement(new GoD6());
        // actions.addElement(new GoD7());
        // actions.addElement(new GoD8());
        // actions.addElement(new GoD9());
        // actions.addElement(new GoD10());
        // actions.addElement(new GoD11());
        // actions.addElement(new GoD12());
        // actions.addElement(new GoD13());
        // actions.addElement(new GoD14());
        // actions.addElement(new GoD15());
        // actions.addElement(new GoD16());
        // actions.addElement(new GoD17());
        // actions.addElement(new GoE1());
        // actions.addElement(new GoE2());
        // actions.addElement(new GoE3());
        // actions.addElement(new GoE5());
        // actions.addElement(new GoE6());
        // actions.addElement(new GoE7());
        // actions.addElement(new GoE8());
        // actions.addElement(new GoE9());
        // actions.addElement(new GoE10());
        // actions.addElement(new GoE11());
        // actions.addElement(new GoE12());
        // actions.addElement(new GoE13());
        // actions.addElement(new GoE14());
        // actions.addElement(new GoE15());
        // actions.addElement(new GoE16());
        // actions.addElement(new GoE17());
        // actions.addElement(new GoF1());
        // actions.addElement(new GoF2());
        // actions.addElement(new GoF3());
        // actions.addElement(new GoF4());
        // actions.addElement(new GoF5());
        // actions.addElement(new GoF6());
        // actions.addElement(new GoF7());
        // actions.addElement(new GoF8());
        // actions.addElement(new GoF9());
        // actions.addElement(new GoF10());
        // actions.addElement(new GoF11());
        // actions.addElement(new GoF12());
        // actions.addElement(new GoF13());
        // actions.addElement(new GoF14());
        // actions.addElement(new GoF15());
        // actions.addElement(new GoF16());
        // actions.addElement(new GoF17());
        // actions.addElement(new GoG6());
        // actions.addElement(new GoG7());
        // actions.addElement(new GoH1());
        // actions.addElement(new GoH2());
        // actions.addElement(new GoH3());
        // actions.addElement(new GoH4());
        // actions.addElement(new GoH5());
        // actions.addElement(new GoH6());
        // actions.addElement(new GoH7());
        // actions.addElement(new GoH8());
        // actions.addElement(new GoH9());
        // actions.addElement(new GoH10());
        // actions.addElement(new GoH11());
        // actions.addElement(new GoH12());
        // actions.addElement(new GoH13());
        // actions.addElement(new GoH14());
        // actions.addElement(new GoH15());
        // actions.addElement(new GoH16());
        // actions.addElement(new GoH17());
        // actions.addElement(new GoI1());
        // actions.addElement(new GoI2());
        // actions.addElement(new GoI3());
        // actions.addElement(new GoI5());
        // actions.addElement(new GoI6());
        // actions.addElement(new GoI7());
        // actions.addElement(new GoI8());
        // actions.addElement(new GoI9());
        // actions.addElement(new GoI10());
        // actions.addElement(new GoI11());
        // actions.addElement(new GoI12());
        // actions.addElement(new GoI13());
        // actions.addElement(new GoI14());
        // actions.addElement(new GoI15());
        // actions.addElement(new GoI16());
        // actions.addElement(new GoI17());
        // actions.addElement(new GoJ1());
        // actions.addElement(new GoJ2());
        // actions.addElement(new GoJ3());
        // actions.addElement(new GoJ5());
        // actions.addElement(new GoJ6());
        // actions.addElement(new GoJ7());
        // actions.addElement(new GoJ8());
        // actions.addElement(new GoJ9());
        // actions.addElement(new GoJ10());
        // actions.addElement(new GoJ11());
        // actions.addElement(new GoJ12());
        // actions.addElement(new GoJ14());
        // actions.addElement(new GoJ15());
        // actions.addElement(new GoK1());
        // actions.addElement(new GoK2());
        // actions.addElement(new GoK3());
        // actions.addElement(new GoK5());
        // actions.addElement(new GoK6());
        // actions.addElement(new GoK7());
        // actions.addElement(new GoK8());
        // actions.addElement(new GoK9());
        // actions.addElement(new GoK10());
        // actions.addElement(new GoK11());
        // actions.addElement(new GoK12());
        // actions.addElement(new GoK14());
        // actions.addElement(new GoL1());
        // actions.addElement(new GoL2());
        // actions.addElement(new GoL3());
        // actions.addElement(new GoL5());
        // actions.addElement(new GoL6());
        // actions.addElement(new GoL7());
        // actions.addElement(new GoL8());
        // actions.addElement(new GoL9());
        // actions.addElement(new GoL10());
        // actions.addElement(new GoL11());
        // actions.addElement(new GoM1());
        // actions.addElement(new GoM2());
        // actions.addElement(new GoM3());
        // actions.addElement(new GoM5());
        // actions.addElement(new GoM6());
        // actions.addElement(new GoM7());
        // actions.addElement(new GoM8());
        // actions.addElement(new GoM9());
        // actions.addElement(new GoM10());
        // actions.addElement(new GoM11());
        // actions.addElement(new GoM12());
        // actions.addElement(new GoM14());
        // actions.addElement(new GoM15());
        // actions.addElement(new GoM16());
        // actions.addElement(new GoM17());
    /*
    * Acciones mapa chico
    */
        actions.addElement(new GoJ1());
        actions.addElement(new GoJ2());
        actions.addElement(new GoJ3());
        actions.addElement(new GoJ5());
        actions.addElement(new GoJ6());
        actions.addElement(new GoJ7());
        actions.addElement(new GoJ8());
        actions.addElement(new GoK1());
        actions.addElement(new GoK2());
        actions.addElement(new GoK3());
        actions.addElement(new GoK5());
        actions.addElement(new GoK6());
        actions.addElement(new GoK7());
        actions.addElement(new GoK8());
        actions.addElement(new GoL1());
        actions.addElement(new GoL2());
        actions.addElement(new GoL3());
        actions.addElement(new GoL5());
        actions.addElement(new GoL6());
        actions.addElement(new GoL7());
        actions.addElement(new GoL8());
        actions.addElement(new GoM1());
        actions.addElement(new GoM2());
        actions.addElement(new GoM3());
        actions.addElement(new GoM5());
        actions.addElement(new GoM6());
        actions.addElement(new GoM7());
        actions.addElement(new GoM8());

        actions.addElement(new MandarACasa());

        // Robot agent problem
        Problem problem = new Problem(goal, agentState, actions);
        this.setProblem(problem);
    }

    @Override
    public Action selectAction() {
        // Breath first strategy
     BreathFirstSearch searchStrategy = new BreathFirstSearch();
//        DepthFirstSearch searchStrategy = new DepthFirstSearch();
         
//         IStepCostFunction costFunction = new CostFunction();
//         UniformCostSearch searchStrategy = new UniformCostSearch(costFunction);
        
        Search searchSolver = new Search(searchStrategy);

        // Set the search tree to be written in an XML file
        searchSolver.setVisibleTree(Search.GRAPHVIZ_TREE);

        // Set the search solver
        this.setSolver(searchSolver);

        // Run the actions selection process
        Action selectedAction = null;
        try {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(CoronaTrackerAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
    }

    @Override
    public void see(Perception perception) {
        this.getAgentState().updateState(perception);
    }
}
