import java.util.Scanner;

public class Quizzer {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		QuestionData data = QuestionData.readQuestionFile("files/Spanish4FinalVocabA,D.txt", ",");

		int[] questionOrder = new int[data.getTotalQuestions()];
		for (int i = 0; i < questionOrder.length; i++) {
			questionOrder[i] = i;
		}
		Quiz.doQuiz(input, data, questionOrder);
	}

}
