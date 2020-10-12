# Java Final Project

Using GUI and java swing.
This is text-based story game. The goal of the game is to escape from an unknown room. In order to escape you must follow the storyline and earn clues from solving mini-games and use them to figure out the password to escape by opening a dial lock.

=> If wanting to add BGM to the game, you must downlaod a BGM (.wav) file and add it to the main.java.

//BGM play
		try
		{
			AudioInputStream bgm = AudioSystem.getAudioInputStream(new File("BGM.wav"));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(bgm);
			clip.start();
		}
		catch (Exception ex) {
			
		}
