package com.mathscontest;

public class Entry {
	
	private Student entrant;
	private int[] quizScores;
	private int count = 0;
	
	
	
	public Entry(Student _entrant, int numOfScores)
	{
		entrant = _entrant;
		quizScores = new int[numOfScores];
		
	}

	public Student getEntrant() {
		return entrant;
	}


	public int[] getScore() {
		return quizScores;
	}

	public void setScore(int score) {
		if(count < quizScores.length)
		{
			quizScores[count] = score;
			count++;
		}
	}
	
	public int totalScore()
	{
		int total = 0;
		for(int index = 0; index < quizScores.length; index++)
		{
			total = total + quizScores[index];
		}
		return total;
	}
	

	
	

}
