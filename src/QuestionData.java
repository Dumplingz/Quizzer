
public class QuestionData {
	String[][] questions;

	private QuestionData(String filepath, String separator) {

		String data = FileIO.readFileAsString(filepath);
		String[] groups = data.split("\n");
		questions = new String[groups.length][2];
		for (int i = 0; i < groups.length; i++) {
			String[] question = groups[i].split(separator);
			questions[i][0] = question[0].trim();
			questions[i][1] = question[1].trim();
		}

	}
	
	public static QuestionData readQuestionFile(String filepath, String separator){
		return new QuestionData(filepath, separator);
	}
	
	public String[] getQuestion(int questionNumber){
		return questions[questionNumber];
	}
	
	public int getTotalQuestions(){
		return questions.length;
	}
	
	public String[] getColumn(int columnNumber){
		String[] column = new String[questions.length];
		for(int i = 0 ;i < column.length; i ++){
			column[i] = questions[i][columnNumber];
		}
		return column;
	}

}
