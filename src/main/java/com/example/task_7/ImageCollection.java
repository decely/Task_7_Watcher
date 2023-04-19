package com.example.task_7;


import javafx.scene.image.Image;

public class ImageCollection implements Aggregate {
    private String filetopic;
    private Image bi;
    public ImageCollection(String filetopic) {
        this.filetopic = filetopic;
    }

    public ImageCollection() {

    }

    private class ImageIterator implements Iterator {
        private int current = 0;
        private int maxcurrent = 100000000;
        @Override
        public boolean hasNext() {
            if (current == maxcurrent)
                current = 0;
            String filename=filetopic+(current+1)+".jpg";
            try {
                bi = new Image(filename);

                return true;

            } catch (Exception ex) {
                maxcurrent = current;
                current = 0;
                System.err.println("Неудалось загрузить картинку! " + filename );
                //ex.printStackTrace();
                return false;
            }
        }
        @Override
        public Object next() {
            if(this.hasNext()){
                current++;
                return bi;
            }

            return null;
        }

        @Override
        public Object preview() {
            return null;
        }
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
}