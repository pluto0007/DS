package org.com.exam.module1;

import java.util.HashMap;
import java.util.Map;

public class MaxAverage {
	
	public static class Demo {
		public int score;
		public int frequency;
		public Demo(int score, int frequency) {
			super();
			this.score = score;
			this.frequency = frequency;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public int getFrequency() {
			return frequency;
		}
		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}
		
		public void increaseScore(int score) {
			this.score = (this.score+score)/frequency;
		}
		
		public void increaseFrequency() {
			frequency++;
		}
	}

	public static void main(String[] args) {
			
		  String[][] scores = {{"jerry","65"},{"bob","31"}, {"jerry","23"}, {"Eric","33"}};
		  Map<String, Demo> scoreMap = new HashMap<>();
		  int highScorer=0;
		  String studentName="";
		  for(int i=0;i<scores.length;i++) {
			  
			  if(scoreMap.containsKey(scores[i][0])) {
				  Demo temp=scoreMap.get(scores[i][0]);
				  temp.increaseFrequency();
				  temp.increaseScore(Integer.parseInt(scores[i][1]));
				  scoreMap.put(scores[i][0], temp);
				  
				  int currentScore = scoreMap.get(scores[i][0]).score;
				  if(currentScore>highScorer) {
					  highScorer = currentScore;
					  studentName =  scores[i][0];
				  }
			  }
			  else {
				  scoreMap.put(scores[i][0], new Demo(Integer.parseInt(scores[i][1]),1));
				  int currentScore = scoreMap.get(scores[i][0]).score;
				  if(currentScore>highScorer) {
					  highScorer = currentScore;
					  studentName =  scores[i][0];
				  }
			  }
	
		  }
		  System.out.println(studentName);
		  

	}

}
