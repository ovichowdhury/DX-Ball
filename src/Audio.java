import java.applet.Applet;
import java.applet.AudioClip;


public class Audio {
	public static final AudioClip sound = Applet.newAudioClip(Audio.class.getResource("Collision.wav"));
	public static final AudioClip gameOver = Applet.newAudioClip(Audio.class.getResource("Balloon.wav"));
	public static final AudioClip winningSound = Applet.newAudioClip(Audio.class.getResource("winner.wav"));

}
