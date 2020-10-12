package finalProject;

enum Alphabet {
	A(3), B(1), C(0), D(1), E(4), F(3), G(2), H(3), I(1), J(0), K(3), L(2), M(4), N(3), O(0), P(1), Q(1), R(1), S(0),
	T(2), U(0), V(2), W(4), X(2), Y(3), Z(3);

	private final int numVal;

	private Alphabet(int numVal) {
		this.numVal = numVal;
	}

	public int getVal() {
		return numVal;
	}
}


public class Cipher {
	private String encryptedText;
	private String decryptedText;
	private int key;
	private String word;

	Cipher() {
		encryptedText = "";
		decryptedText = "";
		key = (int) (Math.random() * 3) + 1;
	}

	public void start() {
		decryptGame decryptgame = new decryptGame();
		decryptgame.start();
	}
	
	public String getEncryptedText() {
		return encryptedText;
	}

	public String getDecryptedText() {
		return decryptedText;
	}

	public void setEncryptedText (String encryptedText) {
		this.encryptedText = encryptedText;
	}

	public void setDecryptedText (String decryptedText) {
		this.decryptedText = decryptedText;
	}

	
	public String createRandomWord(int len) {
		word = "";
		for (int i = 0; i < len; i++) {
			int rand = 1 + (int) (Math.random() * 26);
			char c = (char) (rand + 'A' - 1);
			word += c;
		}
		return word;
	}

	
	public void encryptToNum(String message) {
		word = "";
		for(int i=0; i<message.length(); i++) {
			char oneChar = message.charAt(i);
			Alphabet abc = Alphabet.valueOf(Character.toString(oneChar).toUpperCase());
			word += abc.getVal();
		}
		setEncryptedText(word);
	}


	public void encrypt(String message) {
		word = "";
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);

			char newchar = (char) (c + key);

			// if out of bounds
			if (newchar > 'Z')
				word += (char) (c - (26 - key));
			else
				word += newchar;
		}
		setEncryptedText(word);
	}


	public void decrypt(String message) {
		word ="";
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);

			char newchar = (char) (c - key);

			// if out of bounds
			if (newchar < 'A')
				word += (char) (c + (26 - key));
			else
				word+= newchar;

		}
		setDecryptedText(word);
	}

}
