import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Platform extends Pane {
    public int id;
    public boolean destroyOnce=false;
    Image platformImg = new Image(getClass().getClassLoader().getResourceAsStream("images/platforms.png"));
    ImageView platformView;

    public void brownPlatform(){
        platformView.setImage(null);
        platformView = new ImageView(platformImg);
        int offsetX = 0;
        int offsetY = 14;
        platformView.setViewport(new Rectangle2D(offsetX,offsetY,68,20));
        platformView.setFitHeight(20);
        platformView.setFitWidth(68);
        getChildren().addAll(this.platformView);
    }

    public void brokenBrownPlatform(){
        platformView.setImage(null);
        platformView = new ImageView(platformImg);
        int offsetX = 0;
        int offsetY = 34;
        platformView.setViewport(new Rectangle2D(offsetX,offsetY,68,20));
        platformView.setFitHeight(20);
        platformView.setFitWidth(68);
        getChildren().addAll(this.platformView);
    }

    public Platform(int id, int x, int y) {
        platformView = new ImageView(platformImg);
        platformView.setFitWidth(68);
        platformView.setFitHeight(14);
        setTranslateX(x);
        setTranslateY(y);

        this.id = id;

        if(id==1){
            platformView.setViewport(new Rectangle2D(0, 0, 68, 14));
        }
        if(id==2){
            platformView.setViewport(new Rectangle2D(0, 14, 68, 20));
        }

        getChildren().add(platformView);
        Game.platforms.add(this);
        Game.gameRoot.getChildren().add(this);
    }

    public boolean isDestroyOnce() {
        return destroyOnce;
    }

    public void setDestroyOnce(boolean destroyOnce) {
        this.destroyOnce = destroyOnce;
    }
}
