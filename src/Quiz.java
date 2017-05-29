import java.util.Scanner;

public class Quiz {
	public static void doQuizWithWordBank(Scanner input, QuestionData data, int[] questionOrder) {
		randomizeArray(questionOrder);
		boolean[] finishedQuestions = new boolean[data.getTotalQuestions()];
		String[] possibleAnswers = data.getColumn(1);
		int numberWrong = 0;
		int questionsAnswered = 0;

		int indexNumber = 0;
		String wordBank = getPossibleAnswers(possibleAnswers);
		while (true) {
			if (checkAllQuestionsCorrect(finishedQuestions)) {
				break;
			}
			while (finishedQuestions[indexNumber]) {
				indexNumber = incrementIndexNumber(indexNumber, finishedQuestions.length);
			}
			int questionNumber = questionOrder[indexNumber];
			String[] question = data.getQuestion(questionNumber);
			System.out.println(wordBank);
			boolean isCorrect = askQuestion(input, question[0], question[1]);
			if (!isCorrect) {
				numberWrong++;
			}
			finishedQuestions[indexNumber] = isCorrect;
			questionsAnswered++;
			indexNumber = incrementIndexNumber(indexNumber, finishedQuestions.length);
		}
		System.out.println("Done! You got " + numberWrong + " questions wrong out of " + questionsAnswered + ".");
	}

	public static void doQuiz(Scanner input, QuestionData data, int[] questionOrder) {
		randomizeArray(questionOrder);
		boolean[] finishedQuestions = new boolean[data.getTotalQuestions()];
		int numberWrong = 0;
		int questionsAnswered = 0;

		int indexNumber = 0;
		while (true) {
			if (checkAllQuestionsCorrect(finishedQuestions)) {
				break;
			}
			while (finishedQuestions[indexNumber]) {
				indexNumber = incrementIndexNumber(indexNumber, finishedQuestions.length);
			}
			int questionNumber = questionOrder[indexNumber];
			String[] question = data.getQuestion(questionNumber);

			boolean isCorrect = askQuestion(input, question[0], question[1]);
			if (!isCorrect) {
				numberWrong++;
			}
			finishedQuestions[indexNumber] = isCorrect;
			questionsAnswered++;
			indexNumber = incrementIndexNumber(indexNumber, finishedQuestions.length);
		}
		System.out.println("Done! You got " + numberWrong + " questions wrong out of " + questionsAnswered + ".");
	}

	private static String getPossibleAnswers(String[] answers) {
		String out = "";
		for (int i = 0; i < answers.length - 1; i++) {
			out += answers[i] + ", ";

		}
		out += "or " + answers[answers.length - 1];
		return out;
	}

	private static int incrementIndexNumber(int indexNumber, int returnIndex) {
		indexNumber++;
		if (indexNumber >= returnIndex) {
			indexNumber = 0;
		}
		return indexNumber;
	}

	private static boolean askQuestion(Scanner input, String question, String answer) {

		System.out.println(question);
		String response = input.nextLine();
		boolean isCorrect = answer.equals(response);
		if (isCorrect) {
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect. It is " + answer + ".");
			String newAnswer = question + " is " + answer;
			for (int i = 0; i < 5; i++) {
				System.out.print("Type in " + newAnswer + ":");
				String response2 = input.nextLine();

				while (!response2.equals(newAnswer)) {
					System.out.print("Please type in " + newAnswer + ":");
					response2 = input.nextLine();
				}
			}

		}
		System.out.println();
		return isCorrect;
	}

	private static boolean checkAllQuestionsCorrect(boolean[] questions) {
		for (int i = 0; i < questions.length; i++) {
			if (!questions[i]) {
				return false;
			}
		}
		return true;
	}

	private static void randomizeArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int randomIndex = (int) (Math.random() * arr.length);
			int replacedValue = arr[randomIndex];
			arr[randomIndex] = arr[i];
			arr[i] = replacedValue;
		}
	}

}
