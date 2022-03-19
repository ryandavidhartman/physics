/*
 This program draws a tall rectangle via the SampleAWT.html applet tag.
 This is super old school AWT/Applet Java UI stuff as a review of the good
 old days

 Requires Java 8
 appletviewer SampleAWT.html
*/

import java.applet.*;
import java.awt.*;

public class SampleAWT extends Applet {
    private int w,h;

    public void init() {
        w = 45;
        h = 50;
    }

    public void paint(Graphics g)
    {
        g.drawRect(w, h, 20, 80);
    }
}
