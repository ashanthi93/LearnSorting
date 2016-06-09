/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortgame;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author ASHI
 */
public class VLCPlayer {

    public static void main(String args[]) {
        JFrame f = new JFrame();

        f.setLocation(100, 100);
        f.setSize(1000, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Canvas c = new Canvas();

        c.setBackground(Color.black);
        JPanel p = new JPanel();

        p.setLayout(new BorderLayout());

        p.add(c);
        f.add(p);

        try {
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "lib");
            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

            MediaPlayerFactory mpf = new MediaPlayerFactory();

            EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer();
            emp.setVideoSurface(mpf.newVideoSurface(c));

            emp.toggleFullScreen();

            emp.setEnableKeyInputHandling(false);
            emp.setEnableMouseInputHandling(false);

            String file = "Selection Sort Intro.mp4";

            emp.prepareMedia(file);

            emp.play();

        } catch (Exception e) {
            System.err.println("Exception : " + e);
        }

    }

}
