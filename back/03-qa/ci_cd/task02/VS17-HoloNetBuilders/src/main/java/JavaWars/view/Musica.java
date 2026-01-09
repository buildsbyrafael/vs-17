package view;

import javax.sound.sampled.*;
import java.net.URL;

public class Musica {

    private static Clip clip;

    public static void playLoop() {
        try {
            if (clip == null) {
                URL url = Musica.class.getResource("/Theme.wav");
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);

                clip = AudioSystem.getClip();
                clip.open(audio);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-10.0f);
            }

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void setVolume(float gainInDB) {
        if (clip != null && clip.isOpen() && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            try {

                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                float min = gainControl.getMinimum();
                float max = gainControl.getMaximum();

                if (gainInDB < min) {
                    gainInDB = min;
                } else if (gainInDB > max) {
                    gainInDB = max;
                }

                gainControl.setValue(gainInDB);

            } catch (IllegalArgumentException e) {
                System.err.println("Erro ao obter o controle de volume: " + e.getMessage());
            }
        } else {
            System.out.println("O áudio deve ser iniciado com playLoop() antes de ajustar o volume.");
        }
    }
}