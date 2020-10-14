package com.weijiez.test;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;
import com.weijiez.user.User;
import com.weijiez.view.View;
import org.junit.jupiter.api.Test;

public class ViewTest {
    public static void main(String[] args) {
        ViewTest viewTest = new ViewTest();
        try {
            viewTest.indexViewTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void indexViewTest() throws Exception {
        User user = View.indexView();
        System.out.println(user);
    }
}
