package assignment11;

public class Main {
	static String reverseByWords(String sentence) {
		String[] words = sentence.split("\\s");
		String revSentence = "";
		for (String word : words) {
			revSentence = word + " " + revSentence;
		}
		return revSentence;
	}

	public static void main(String[] args) {
		String out = reverseByWords("my name is vinod and i live in bangalore");
		System.out.println(out);
	}
}
