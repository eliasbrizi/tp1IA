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

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CoronaTrackerAgentState extends SearchBasedAgentState {

     /**
     * Actual agent position
     */
    String position;

    /**
     * This map has a point of the world (A, B, C, ...) as key, and a collection
     * of successors of that point.
     */
    private HashMap<String, Collection<String>> knownMap;
    private ArrayList<String> visitedPositions;

    public CoronaTrackerAgentState() {
        this.initState();
    }

    @Override
    public CoronaTrackerAgentState clone() {
        CoronaTrackerAgentState newState = new CoronaTrackerAgentState();
        newState.setPosition(position);
        ArrayList<String> visitedPosition = (ArrayList<String>) visitedPositions.clone();
        newState.setVisitedPositions(visitedPosition);
        return newState;
    }

    @Override
    public void initState() {
        position = A;

        /**
         * In this matrix the first element of each row represents a position
         * in the map and the seccessors of that position.
         */
        String[][] positions = new String[][]{
        	{"I5","J5","I6"},{"I6","I7"},
        	{"I7","I8","J7"},{"I8","I9"},
        	{"I9","I10","J9"}, {"I10"}, 
        	{"J5","K5"}, {"J6","J5","L6"}, 
        	{"J7","J6","K7"}, {"J8","J7","L8"}, 
        	{"J9","J8","K9"}, {"J10","J9","L10"}, 
        	{"K5","K6","L5"}, {"K6","K7","J6"}, 
        	{"K7","K8","L7"}, {"K8","K9","J8"}, 
        	{"K9","K10","L9"}, {"K10","J10"}, 
        	{"L5","M5"}, {"L6","L5","K6"}, 
        	{"L7","L6","M7"}, {"L8","L7","K8"}, 
        	{"L9","L8","M9"}, {"L10","L9","K10"}, 
        	{"M5","M6"}, {"M6","M5","M7","L6"}, 
        	{"M7","M6","M8"}, {"M8","M7","M9","L8"}, 
        	{"M9","M8","M10"}};

        knownMap = new HashMap<String, Collection<String>>();
        for (int i = 0; i < positions.length; i++) {
            ArrayList<String> successors = new ArrayList<String>();
            for (int j = 1; j < positions[i].length; j++) {
                successors.add(positions[i][j]);
            }
            knownMap.put(positions[i][0], successors);

        }

        visitedPositions = new ArrayList<String>();

    }

    @Override
    public void updateState(Perception p) {
        visitedPositions.add(position);
    }

    @Override
    public String toString() {
        String str = "Posicion: " + position;

        return str;

    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof CoronaTrackerAgentState)) {
            return false;
        }
        return position.equals(((CoronaTrackerAgentState) obj).getPosition());
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Collection<String> getSuccessors() {
        return knownMap.get(position);
    }

    public ArrayList<String> getVisitedPositions() {
        return visitedPositions;
    }

    public void setVisitedPositions(ArrayList<String> visitedPositions) {
        this.visitedPositions = visitedPositions;
    }
}
