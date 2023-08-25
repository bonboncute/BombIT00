package Animals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class CacheDataLoader {
    private String mapFile = "C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/map1.txt";
    private String soundFile = "C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/sound.wav";
    private Clip clip;

    private int col, row;
    public int[][] map;
    public int range = 1;
    public float volume = 0.2f;
    public boolean songMute;

    public CacheDataLoader() {
        map = new int[17][22];
        loadMap();
        loadSound();
    }

    // public int[][] getMap() {
    // return map;
    // }

    // public void loadData() {
    // loadMap();
    // loadSound();
    // }

    public void loadMap() {
        try {
            FileReader fr = new FileReader(mapFile);
            BufferedReader br = new BufferedReader(fr);

            col = 0;
            row = 0;
            while (col < map[0].length && row < map.length) {
                String line = br.readLine();
                while (col < map[0].length) {
                    String str[] = line.split(" ");
                    int num = Integer.parseInt(str[col]);
                    map[row][col] = num;
                    col++;
                }
                if (col == map[0].length) {
                    col = 0;
                    row++;

                }
            }
            br.close();
        } catch (Exception e) {

        }
    }

    public void loadSound() {
        try {
            File file = new File(soundFile);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);

        } catch (Exception e) {
        }
    }

    public void playMusic() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopMusic() {
        clip.stop();
    }

    public void volume() {

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float gain = range * volume;
        gainControl.setValue(20f * (float) Math.log10(gain));

    }

    public void musicMute() {
        songMute = !songMute;
        BooleanControl booleanControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
        booleanControl.setValue(songMute);
        if (songMute == false)
            playMusic();
        else
            stopMusic();
    }
}
