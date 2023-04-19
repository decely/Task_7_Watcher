package com.example.task_7;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ImageLoop extends ImageCollection implements IObserver {
    public ImageCollection imgs = new ImageCollection("Pic");
    public Iterator iter_main = imgs.getIterator();
    ImageView Image1 = new ImageView();
    public ImageLoop(){
        super();
    }
    @Override
    public void update() {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            Image1.setImage(name);
        }
}}
