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
import java.util.HashMap;

import frsf.cidisi.faia.state.EnvironmentState;

public class CoronaEnvironmentState extends EnvironmentState {

    /**
     * This map has a point of the world (A, B, C, ...) as key, and a collection
     * of successors of that point.
     */
    private HashMap<String, Collection<String>> map;
    
    // private ArrayList<Ciudadano> ciudadanosInfectados;
    // private ArrayList<Ciudadano> ciudadanosEscapados;
    // private ArrayList<Camino> caminosCortados;

    public static final String[][] POSITIONS = new String[][]{
		};

    CoronaEnvironmentState() {
        map = new HashMap<String, Collection<String>>();
    }

    @Override
    public Object clone() {
        return map.clone();
    }

    @Override
    public void initState() {
        /**
         * In this matrix the first element of each row represents a position
         * in the map and the seccessors of that position.
         */
        map = new HashMap<String, Collection<String>>();
        
        for (int i = 0; i < POSITIONS.length; i++) {
            ArrayList<String> successors = new ArrayList<String>();
            for (int j = 1; j < POSITIONS[i].length; j++) {
                successors.add(POSITIONS[i][j]);
            }
            map.put(POSITIONS[i][0], successors);

        }
        
        // this.ciudadanosInfectados = new ArrayList<>();
        // this.ciudadanosEscapados = new ArrayList<>();
        // this.caminosCortados = new ArrayList<>();
    }

    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (String point : map.keySet()) {
            str = str + "[ " + point + " --> ";
            Collection<String> successors = map.get(point);
            if (successors != null) {
                for (String successor : successors) {
                    str = str + successor + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    // public ArrayList<Ciudadano> getCiudadanosInfectados() {
	// 	return ciudadanosInfectados;
	// }

	// public void setCiudadanosInfectados(ArrayList<Ciudadano> ciudadanosInfectados) {
	// 	this.ciudadanosInfectados = ciudadanosInfectados;
	// }

	// public ArrayList<Ciudadano> getCiudadanosEscapados() {
	// 	return ciudadanosEscapados;
	// }

	// public void setCiudadanosEscapados(ArrayList<Ciudadano> ciudadanosEscapados) {
	// 	this.ciudadanosEscapados = ciudadanosEscapados;
	// }

	// public ArrayList<Camino> getCaminosCortados() {
	// 	return caminosCortados;
	// }

	// public void setCaminosCortados(ArrayList<Camino> caminosCortados) {
	// 	this.caminosCortados = caminosCortados;
	// }

	@Override
    public boolean equals(Object obj) {
        // Returns always true. This method is not used.
        return true;
    }
}
