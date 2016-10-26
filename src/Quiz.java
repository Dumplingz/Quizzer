import java.util.Scanner;

public class Quiz {
	public static void doQuizWithWordBank(Scanner input, QuestionData data, int[] questionOrder) {
		randomizeArray(questionOrder, 100);
		boolean[] finishedQuestions = new boolean[data.getTotalQuestions()];
		String[] possibleAnswers = data.getColumn(1);

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
			finishedQuestions[indexNumber] = askQuestion(input, question[0], question[1]);
			indexNumber = incrementIndexNumber(indexNumber, finishedQuestions.length);
		}
		System.out.println("Done!");
	}

	public static void doQuiz(Scanner input, QuestionData data, int[] questionOrder) {
		randomizeArray(questionOrder, 100);
		boolean[] finishedQuestions = new boolean[data.getTotalQuestions()];

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

			finishedQuestions[indexNumber] = askQuestion(input, question[0], question[1]);
			indexNumber = incrementIndexNumber(indexNumber, finishedQuestions.length);
		}
		System.out.println("Done!");
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

	private static void randomizeArray(int[] arr, int times) {
		for (int i = 0; i < times; i++) {
			int randomIndex1 = (int) (Math.random() * arr.length);
			int randomIndex2 = (int) (Math.random() * arr.length);
			int replacedValue = arr[randomIndex1];
			arr[randomIndex1] = arr[randomIndex2];
			arr[randomIndex2] = replacedValue;
		}
	}

}
