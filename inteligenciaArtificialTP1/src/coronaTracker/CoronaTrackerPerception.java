/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
 * Luis Ignacio Larrateguy y Milton Pividori.
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

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.util.ArrayList;

import coronaTracker.Domain.*;

public class CoronaTrackerPerception extends Perception {

    private ArrayList<Camino> caminosCortados;
    private ArrayList<Ciudadano> nuevosInfectados;
    private ArrayList<Ciudadano> nuevosEscapados;

    public CoronaTrackerPerception() {
    	this.caminosCortados = new ArrayList<>();
    	this.nuevosEscapados= new ArrayList<>();
    	this.nuevosInfectados = new ArrayList<>();
    }

    public CoronaTrackerPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {
        CoronaTrackerAgent coronaAgent = (CoronaTrackerAgent) agent;
        CoronaEnvironment coronaEnvironment = (CoronaEnvironment) environment;
        CoronaEnvironmentState environmentState =
                (CoronaEnvironmentState) coronaEnvironment.getEnvironmentState();
        /*
         * Obtener calles cortadas, escapados y posibles infectados
         */
        this.caminosCortados.addAll(coronaEnvironment.getCaminosCortados());
        this.nuevosEscapados.addAll(coronaEnvironment.getNuevosEscapados());
        this.nuevosInfectados.addAll(coronaEnvironment.getNuevosInfectados());
        // Deberia preguntar si ya estan escapados antes de ponerlos como nuevos?
    }



    public ArrayList<Camino> getCaminosCortados() {
		return caminosCortados;
	}

	public void setCaminosCortados(ArrayList<Camino> caminosCortados) {
		this.caminosCortados = caminosCortados;
	}

	public ArrayList<Ciudadano> getNuevosInfectados() {
		return nuevosInfectados;
	}

	public void setNuevosInfectados(ArrayList<Ciudadano> nuevosInfectados) {
		this.nuevosInfectados = nuevosInfectados;
	}

	public ArrayList<Ciudadano> getNuevosEscapados() {
		return nuevosEscapados;
	}

	public void setNuevosEscapados(ArrayList<Ciudadano> nuevosEscapados) {
		this.nuevosEscapados = nuevosEscapados;
	}

	@Override
    public String toString() {
        String str = "Caminos cortados: "+ caminosCortados.size()
        + "\nNuevos Escapados: "+nuevosEscapados.size()
        + "\nNuevos Infectados: "+nuevosInfectados.size();
        return str.toString();
    }

}
