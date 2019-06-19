package game;

import java.awt.Color;

public class Teams {
	/* The team colors are stored in this variable */
	protected static Color[] teamColor = {Color.WHITE, Color.BLACK};
	/* The team turn is stored in this variable */
	protected static int teamTurn = 0;
	/* This method allows you to get the team index using its color */
	public static int getTeamIndex(Color c) {
		for (int i = 0; i < teamColor.length; i++) {
			if (teamColor[i] == c) {
				return i;
			}
		}
		return -1;
	}
	/* This method allows you to get the team color using its index */
	public static Color getTeamColor(int i) {
		if (i >= teamColor.length || i < 0) {
			return null;
		}
		return teamColor[i];
	}
	/* This method returns which team has the turn */
	public static int getTeamTurn() {
		return teamTurn;
	}
	/* This method allows you to set the team colors by giving an array of colors as argument */
	public static void setTeamColors(Color[] tc) {
		teamColor = tc;
	}
	/* This method (you know what) turn by giving an integer value (the index) as argument */
	public static boolean setTeamTurn(int i) {
		if (getTeamColor(i) != null) {
			teamTurn = i;
			return true;
		}
		return false;
	}	
	/* This method adds one to the turn. If the number of the turn is bigger than the amount of players, a new round is started */
	public static boolean nextTurn() {
		if (getTeamColor(++teamTurn) == null) {
			teamTurn = 0;
			return true;
		}
		return false;
	}
}