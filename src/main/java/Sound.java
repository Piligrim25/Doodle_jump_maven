import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound{

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    MediaPlayer mediaPlayer;

    public Sound(String url){

        Media sound = new Media(getClass().getResource(url).toString());
        mediaPlayer = new MediaPlayer(sound);

        mediaPlayer.play();
        if (url == "menu.wav"){
            mediaPlayer.setOnEndOfMedia(new Runnable() {
                public void run() {
                    mediaPlayer.seek(Duration.ZERO);
                }
            });
        }
    }

}
