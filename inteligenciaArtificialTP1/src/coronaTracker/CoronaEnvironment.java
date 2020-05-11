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

import coronaTracker.Domain.Camino;
import coronaTracker.Domain.Ciudadano;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CoronaEnvironment extends Environment {

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

        return perception;
    }

    @Override
    public String toString() {
        return "";
    }

	public ArrayList<Camino> getCaminosCortados() {
        // TODO Auto-generated method stub
        /*
        para la prueba quiero ir de J6 a L6 pero corto el camino entre ellos
        */
        Camino camino = new Camino(CoronaEnvironmentState.J6, CoronaEnvironmentState.L6
        ArrayList<Camino> caminos = new ArrayList<Camino>();
        caminos.add(camino);
        return caminos;
	}

	public ArrayList<Ciudadano> getNuevosEscapados() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Ciudadano> getNuevosInfectados() {
		// TODO Auto-generated method stub
		return null;
	}
    
}