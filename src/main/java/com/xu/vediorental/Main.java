package com.xu.vediorental;

import com.xu.vediorental.client.IndexPage;
import java.awt.*;


/**
 * @author HaibiaoXu
 * @date Create in 9:48 2019/11/29
 * @modified By
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IndexPage window = new IndexPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
