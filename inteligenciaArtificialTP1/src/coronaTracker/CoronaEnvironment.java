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

import java.util.ArrayList;
import java.util.Collection;

import coronaTracker.*;
import coronaTracker.Domain.Camino;
import coronaTracker.Domain.Ciudadano;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CoronaEnvironment extends Environment {

	private static int _yacree = 0;
	
    public CoronaEnvironment() {
        // Create the environment state
        this.environmentState = new CoronaEnvironmentState();
    }

    @Override
    public Perception getPercept() {
        /*
        Create perception here
        */
        CoronaTrackerPerception perception = new CoronaTrackerPerception();
        perception.setCaminosCortados(this.getCaminosCortados());
        perception.setNuevosEscapados(this.getNuevosEscapados());
        return perception;
    }

    @Override
    public String toString() {
        return "";
    }

	public ArrayList<Camino> getCaminosCortados() {
		
		//TODO generar caminos
		ArrayList<Camino> caminos = new ArrayList<Camino>();
		
        return caminos;
	}

	public ArrayList<Ciudadano> getNuevosEscapados() {
		
		//TODO que se escapen infectados
		
		ArrayList<Ciudadano> escapados = new ArrayList<>();
		if (_yacree%6 == 0) {
			//Sensor 1
			if ( ((Math.round((Math.random()*100))% 4) == 0) || _yacree==0 ) {
				Ciudadano c = new Ciudadano(CoronaTrackerAgentState.A2, CoronaTrackerAgentState.A9, true);
				escapados.add(c);
			}
			//Sensor 2
			if ( (Math.round((Math.random()*100))% 4) == 0) {
				Ciudadano c = new Ciudadano(CoronaTrackerAgentState.A2, CoronaTrackerAgentState.M15, true);
				escapados.add(c);					
			}
			//Sensor 3
			if ( (Math.round((Math.random()*100))% 4) == 0) {
				Ciudadano c = new Ciudadano(CoronaTrackerAgentState.A2, CoronaTrackerAgentState.M8, true);
				escapados.add(c);
			}
			//Sensor 4
			if ( (Math.round((Math.random()*100))% 4) == 0) {
				Ciudadano c = new Ciudadano(CoronaTrackerAgentState.A2, CoronaTrackerAgentState.K2, true);
				escapados.add(c);
			}
		}	
		_yacree++;
		return escapados;
	}

	public ArrayList<Ciudadano> getNuevosInfectados() {
		// TODO Auto-generated method stub
		return null;
	}
	    
}
