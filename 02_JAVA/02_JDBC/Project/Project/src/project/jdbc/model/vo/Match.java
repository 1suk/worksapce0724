package project.jdbc.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Match{
	private int matchId;
    private String teamA;
    private String teamB;
    private LocalDate matchDate;
    private String result;

    public Match() {
    	super();
    }

    public Match(String teamA, String teamB, LocalDate matchDate) {
    	super();
    	this.matchId = matchId;
    	this.teamA = teamA;
    	this.teamB= teamB;
    	this.matchDate= matchDate;
    	this.result = result;
    }

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getTeamA() {
		return teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	public String getTeamB() {
		return teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void getResult() {
		return;
	}

	@Override
	public String toString() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (E)");
	    String formattedDate = matchDate.format(formatter);
	    
	    return String.format("%s vs %s | 경기일: %s", teamA, teamB, formattedDate);
	}

}
