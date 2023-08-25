package Animals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
    public String name;
    private boolean repeated;
    private int currentFrame;
    private ArrayList<FrameImage> frameImage;
    private ArrayList<Boolean> ignoreFrame;
    private ArrayList<Double> delayFrame;
    private long beginTime;

    public Animation() {
        delayFrame = new ArrayList<Double>();
        beginTime = 0;
        currentFrame = 0;
        ignoreFrame = new ArrayList<Boolean>();
        frameImage = new ArrayList<FrameImage>();
        repeated = true;
    }

    public Animation(Animation animation) {
        beginTime = animation.beginTime;
        currentFrame = animation.currentFrame;
        repeated = animation.repeated;

        delayFrame = new ArrayList<Double>();
        for (Double d : animation.delayFrame) {
            delayFrame.add(d);
        }

        ignoreFrame = new ArrayList<Boolean>();
        for (boolean b : animation.ignoreFrame) {
            ignoreFrame.add(b);
        }

        frameImage = new ArrayList<FrameImage>();
        for (FrameImage f : animation.frameImage) {
            frameImage.add(new FrameImage(f));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRepeated() {
        return repeated;
    }

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }

    public ArrayList<FrameImage> getFrameImage() {
        return frameImage;
    }

    public void setFrameImage(ArrayList<FrameImage> frameImage) {
        this.frameImage = frameImage;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        if (currentFrame >= 0 && currentFrame < frameImage.size())
            this.currentFrame = currentFrame;
        else
            this.currentFrame = 0;
    }

    public ArrayList<Boolean> getIgnoreFrame() {
        return ignoreFrame;
    }

    public void setIgnoreFrame(ArrayList<Boolean> ignoreFrame) {
        this.ignoreFrame = ignoreFrame;
    }

    public ArrayList<Double> getDelayFrame() {
        return delayFrame;
    }

    public void setDelayFrame(ArrayList<Double> delayFrame) {
        this.delayFrame = delayFrame;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public boolean ignoreFrame(int id) {
        return ignoreFrame.get(id);
    }

    public void setIgnoreFrame(int id) {
        if (id >= 0 && id < ignoreFrame.size())
            ignoreFrame.set(id, true);
    }

    public void unIgnoreFrame(int id) {
        if (id >= 0 && id < ignoreFrame.size())
            ignoreFrame.set(id, false);
    }

    public void reset() {
        currentFrame = 0;
        beginTime = 0;

        for (int i = 0; i < ignoreFrame.size(); i++)
            ignoreFrame.set(i, false);
    }

    public void add(FrameImage frameImage1, double time) {
        ignoreFrame.add(false);
        frameImage.add(frameImage1);
        delayFrame.add(new Double(time));
    }

    public BufferedImage getCurrentImage() {
        return frameImage.get(currentFrame).getImage();
    }

    public void Update(long deltaTime) {
        if (beginTime == 0)
            beginTime = deltaTime;
        else {
            if (deltaTime - beginTime > delayFrame.get(currentFrame)) {
                nextFrame();
                beginTime = deltaTime;
            }
        }
    }

    public void nextFrame() {
        if (currentFrame >= frameImage.size() - 1) {
            if (repeated)
                currentFrame = 0;
        } else
            currentFrame++;
        if (ignoreFrame.get(currentFrame))
            nextFrame();
    }

    public boolean lastFrame() {
        if (currentFrame == frameImage.size() - 1)
            return true;
        else
            return false;
    }

    public void draw(float posX, float posY, Graphics2D g2) {
        BufferedImage image = getCurrentImage();
        g2.drawImage(image, null, (int) posX, (int) posY);
    }

}
