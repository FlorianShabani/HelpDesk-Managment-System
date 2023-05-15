package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public abstract class Component {

    int Width, Height;
    protected int x, y, width, height;

    public final static int padding = 10, margin = 10;

    public Component(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.Width = width + margin + margin;
        this.Height = height + margin + margin;
    }

    public Component(int width, int height) {
        this(0, 0, width, height);
    }

    public void draw(Graphics gd) {
        Graphics2D g = (Graphics2D) gd;
        AffineTransform tr = g.getTransform();
        g.translate(margin + this.x, margin + this.y);

        drawC(g);

        g.setTransform(tr);
    }

    public void draw(int x, int y, Graphics gd) {
        Graphics2D g = (Graphics2D) gd;
        AffineTransform tr = g.getTransform();
        g.translate(margin + x, margin + y);
        drawC(g);

        g.setTransform(tr);
    }

    public abstract void drawC(Graphics g);

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