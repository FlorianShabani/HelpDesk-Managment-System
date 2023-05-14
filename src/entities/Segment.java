package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public abstract class Segment {

    int Width, Height;
    protected int x, y, width, height, padding, margin;

    public Segment(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.padding = 10;
        this.margin = 10;

        this.Width = width + margin + margin;
        this.Height = height + margin + margin;
    }

    public void drawC(Graphics gd) {
        Graphics2D g = (Graphics2D) gd;
        AffineTransform tr = g.getTransform();
        g.translate(margin, margin);

        draw(g);
        g.setColor(new Color(181, 229, 237, 160));
        g.fillRoundRect(x, y, width, height, padding, padding);

        g.setTransform(tr);
    }

    public abstract void draw(Graphics g);

    public void tick() {

    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getwidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getheight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}