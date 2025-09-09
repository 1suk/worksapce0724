package project.jdbc.model.vo;

public class Team {
	private int teamId;
	private String teamName;
	private int win;
	private int lose;
	private int draw;
	private int totalScore;
	
	public Team() {
		super();
	}

	public Team(String teamName, int win, int lose, int draw, int totalScore) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
		this.totalScore = totalScore;
	}
	

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", win=" + win + ", lose=" + lose + ", draw=" + draw + ", totalScore="
				+ totalScore + "]";
	}
	
	

	
	
	
}
