package QuizApp;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	// Class to represent a single Quiz Question
	class Question {
	    String questionText;
	    String[] options;
	    int correctAnswer; // index of the correct option (0-based)

	    // Constructor to initialize a question
	    public Question(String questionText, String[] options, int correctAnswer) {
	        this.questionText = questionText;
	        this.options = options;
	        this.correctAnswer = correctAnswer;
	    }

	    // Method to display the question and options
	    public void displayQuestion() {
	        System.out.println("\n" + questionText);
	        for (int i = 0; i < options.length; i++) {
	            System.out.println((i + 1) + ". " + options[i]);
	        }
	    }

	    // Method to check if the user's answer is correct
	    public boolean isCorrect(int answer) {
	        return answer - 1 == correctAnswer; // -1 because user enters 1-based choice
	    }
	}

	// Main class for the Quiz App
	public class QuizApp {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create a list to store questions
	        List<Question> questions = new ArrayList<>();

	        // Adding some sample questions
	        questions.add(new Question(
	            "What is the capital of India?",
	            new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"},
	            1
	        ));

	        questions.add(new Question(
	            "Which language is used for Android development?",
	            new String[]{"Java", "Python", "C#", "Ruby"},
	            0
	        ));

	        questions.add(new Question(
	            "What is 5 + 7?",
	            new String[]{"10", "11", "12", "13"},
	            2
	        ));

	        int score = 0;

	        // Loop through all questions
	        for (Question q : questions) {
	            q.displayQuestion();
	            System.out.print("Enter your answer (1-4): ");
	            int userAnswer = scanner.nextInt();

	            if (q.isCorrect(userAnswer)) {
	                System.out.println("Correct!");
	                score++;
	            } else {
	                System.out.println("Wrong! Correct answer was: " + q.options[q.correctAnswer]);
	            }
	        }

	        // Display final score
	        System.out.println("\nQuiz Over! Your Score: " + score + "/" + questions.size());

	        scanner.close();
	    }
	}
