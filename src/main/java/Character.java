import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Character extends Pane{

    Image doodleImg = new Image(getClass().getClassLoader().getResourceAsStream("images/doodler.png"));
    ImageView imageView = new ImageView(doodleImg);
    public Point2D playerVelocity = new Point2D(0,0);
    private boolean canJump = true;

    public Character(int characterType){
        imageView.setFitHeight(76);
        imageView.setFitWidth(76);

        getChildren().addAll(this.imageView);
    }

    public void moveX(int value){
        boolean movingRight = value > 0;
        for(int i = 0; i<Math.abs(value); i++) {
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    public void moveY(int value){
        boolean movingDown = value >0;
        for(int i = 0; i < Math.abs(value); i++){
            for(Platform platform : Game.platforms){
                if(getBoundsInParent().intersects(platform.getBoundsInParent())){
                    if(movingDown){
                        if(this.getTranslateY()+ this.getHeight() == platform.getTranslateY() && platform.id == 1){
                            new Sound ("/sounds/jump.mp3");
                            this.setTranslateY(this.getTranslateY()-1);
                            canJump = true;
                            return;
                        }
                        if(this.getTranslateY()+ this.getHeight() == platform.getTranslateY() && platform.id == 2 && !platform.isDestroyOnce()) {
                            new Sound ("/sounds/lomise.wav");
                            platform.brokenBrownPlatform();
                            platform.setDestroyOnce(true);
                            return;
                        }
                    }
                }
            }
            this.setTranslateY(this.getTranslateY() + (movingDown?1:-1));
            ifFalls();
        }
    }

    public boolean ifFalls(){
        boolean falls = false;
        if(this.getTranslateY()>700){
            falls = true;
        }

        return falls;
    }

    public void jumpPlayer(){
        if(canJump){
            playerVelocity = playerVelocity.add(0,-30);
            canJump = false;
        }
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }
}
