import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

class Chess {
    Icon iconb0g, iconb1g, iconb2g, iconb3g, iconb4g, iconb5g, iconb0l, iconb1l, iconb2l, iconb3l, iconb4l, iconb5l;
    Icon iconw0g, iconw1g, iconw2g, iconw3g, iconw4g, iconw5g, iconw0l, iconw1l, iconw2l, iconw3l, iconw4l, iconw5l;
    Icon iconl, icong, changeicon;
    String startwi = null, startbi = null, endwi = null, endbi = null, between = null;
    int count = 0, sm = 0, sn = 0, em = 0, en = 0;

    String lilac = "C:\\Users\\LENOVO\\Desktop\\Games\\lilac.jpg";
    String gray = "C:\\Users\\LENOVO\\Desktop\\Games\\gray.jpg";

    String b0g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb0g.jpg";
    String b1g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb1g.jpg";
    String b2g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb2g.jpg";
    String b3g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb3g.jpg";
    String b4g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb4g.jpg";
    String b5g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb5g.jpg";

    String b0l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb0l.jpg";
    String b1l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb1l.jpg";
    String b2l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb2l.jpg";
    String b3l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb3l.jpg";
    String b4l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb4l.jpg";
    String b5l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconb5l.jpg";

    String w0g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw0g.jpg";
    String w1g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw1g.jpg";
    String w2g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw2g.jpg";
    String w3g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw3g.jpg";
    String w4g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw4g.jpg";
    String w5g = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw5g.jpg";

    String w0l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw0l.jpg";
    String w1l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw1l.jpg";
    String w2l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw2l.jpg";
    String w3l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw3l.jpg";
    String w4l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw4l.jpg";
    String w5l = "C:\\Users\\LENOVO\\Desktop\\Games\\iconw5l.jpg";

    JLabel[] jl = new JLabel[64];
    JPanel chesspanel;
    JButton[] j = new JButton[64];
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    public void chessmoves(int a) {
        System.out.println(count);
        if (count % 4 == 0) {
            startwi = j[a].getText();
            if ((startwi != "lilacll") && (startwi != "grayggg") && (color(startwi) == 0)) {
                count++;
                sm = a;
            }
        } else if (count % 4 == 1) {
            endwi = j[a].getText();
            em = a;
            if ((startwi != null) && (color(startwi) == 0) && (move(sm, em, startwi, endwi) != null)
                    && (!endwi.substring(4, 5).equals("w"))) {
                changeicon = new ImageIcon(move(sm, em, startwi, endwi));
                jl[em].setIcon(changeicon);
                j[em].setText(move(sm, em, startwi, endwi).substring(30, 37));
                count++;
                if (colorblock(startwi) == 1) {
                    jl[sm].setIcon(icong);
                    j[sm].setText("grayggg");
                    endwi = "grayggg";
                } else if (colorblock(startwi) == 0) {
                    jl[sm].setIcon(iconl);
                    j[sm].setText("lilacll");
                    endwi = "lilacll";
                }
                sm = 0;
                em = 0;
                winChess();
            } else
                count--;
        } else if (count % 4 == 2) {
            startbi = j[a].getText();
            System.out.println(startbi);
            if ((startbi != "lilacll") && (startbi != "grayggg") && (color(startbi) == 1)) {
                count++;
                sn = a;
            }
        } else if (count % 4 == 3) {
            endbi = j[a].getText();
            en = a;
            if ((startbi != null) && (color(startbi) == 1) && (move(sn, en, startbi, endbi) != null)
                    && (!endbi.substring(4, 5).equals("b"))) {
                changeicon = new ImageIcon(move(sn, en, startbi, endbi));
                jl[en].setIcon(changeicon);
                j[en].setText(move(sn, en, startbi, endbi).substring(30, 37));
                count++;
                if (colorblock(startbi) == 1) {
                    jl[sn].setIcon(icong);
                    j[sn].setText("grayggg");
                    endbi = "grayggg";
                } else if (colorblock(startbi) == 0) {
                    jl[sn].setIcon(iconl);
                    j[sn].setText("lilacll");
                    endbi = "lilacll";
                }
                sn = 0;
                en = 0;
                winChess();
            } else
                count--;
        }
        if (count == 4)
            count = 0;
        System.out.println(count);
        System.out.println("StartWI: " + startwi);
        System.out.println("StartBI: " + startbi);
        System.out.println("EndWI: " + endwi);
        System.out.println("EndBI: " + endbi + "\n");
    }

    public int color(String a) {
        if ((a.equals("iconb0g")) || (a.equals("iconb1g")) || (a.equals("iconb2g")) || (a.equals("iconb3g"))
                || (a.equals("iconb4g")) || (a.equals("iconb5g")) || (a.equals("iconb0l")) || (a.equals("iconb1l"))
                || (a.equals("iconb2l")) || (a.equals("iconb3l")) || (a.equals("iconb4l")) || (a.equals("iconb5l")))
            return 1;
        else
            return 0;
    }

    public int colorblock(String a) {
        if ((a.equals("iconb0g")) || (a.equals("iconb1g")) || (a.equals("iconb2g")) || (a.equals("iconb3g"))
                || (a.equals("iconb4g")) || (a.equals("iconb5g")) || (a.equals("iconw0g")) || (a.equals("iconw1g"))
                || (a.equals("iconw2g")) || (a.equals("iconw3g")) || (a.equals("iconw4g")) || (a.equals("iconw5g")))
            return 1;
        else
            return 0;
    }

    public int piece(String a) {
        if ((a.equals("iconb0l")) || (a.equals("iconb0g")) || (a.equals("iconw0l")) || (a.equals("iconw0g"))) // rook
            return 0;
        else if ((a.equals("iconb1l")) || (a.equals("iconb1g")) || (a.equals("iconw1l")) || (a.equals("iconw1g"))) // knight
            return 1;
        else if ((a.equals("iconb2l")) || (a.equals("iconb2g")) || (a.equals("iconw2l")) || (a.equals("iconw2g"))) // bishop
            return 2;
        else if ((a.equals("iconb3l")) || (a.equals("iconb3g")) || (a.equals("iconw3l")) || (a.equals("iconw3g"))) // king
            return 3;
        else if ((a.equals("iconb4l")) || (a.equals("iconb4g")) || (a.equals("iconw4l")) || (a.equals("iconw4g"))) // queen
            return 4;
        else if ((a.equals("iconb5l")) || (a.equals("iconb5g")) || (a.equals("iconw5l")) || (a.equals("iconw5g"))) // pawn
            return 5;
        else
            return 6;
    }

    public String move(int x, int y, String a, String b) {
        if (a == null) {
            count = count - 2;
            return null;
        } else {
            if (piece(a) == 0) {
                if (((a.equals("iconw0l")) || (a.equals("iconw0g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("b"))))
                        && ((x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sm, em, a) == null)
                        return w0l;
                    else
                        move(sm, em, startwi, endwi);
                } else if (((a.equals("iconw0l")) || (a.equals("iconw0g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("b"))))
                        && ((x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sm, em, a) == null)
                        return w0g;
                    else
                        move(sm, em, startwi, endwi);
                } else if (((a.equals("iconb0l")) || (a.equals("iconb0g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("w"))))
                        && ((x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sn, en, a) == null)
                        return b0l;
                    else
                        move(sn, en, startbi, endbi);
                } else if (((a.equals("iconb0l")) || (a.equals("iconb0g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("w"))))
                        && ((x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sn, en, a) == null)
                        return b0g;
                    else
                        move(sn, en, startbi, endbi);
                } else
                    return null;
            } else if (piece(a) == 1) {
                if (((a.equals("iconw1l")) || (a.equals("iconw1g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("b"))))
                        && ((((x / 8 - y / 8 == 2) || (y / 8 - x / 8 == 2))
                                && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1)))
                                || (((x / 8 - y / 8 == 1) || (y / 8 - x / 8 == 1))
                                        && ((x % 8 - y % 8 == 2) || (y % 8 - x % 8 == 2)))))
                    return w1l;
                else if (((a.equals("iconw1l")) || (a.equals("iconw1g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("b"))))
                        && ((((x / 8 - y / 8 == 2) || (y / 8 - x / 8 == 2))
                                && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1)))
                                || (((x / 8 - y / 8 == 1) || (y / 8 - x / 8 == 1))
                                        && ((x % 8 - y % 8 == 2) || (y % 8 - x % 8 == 2)))))
                    return w1g;
                else if (((a.equals("iconb1l")) || (a.equals("iconb1g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("w"))))
                        && ((((x / 8 - y / 8 == 2) || (y / 8 - x / 8 == 2))
                                && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1)))
                                || (((x / 8 - y / 8 == 1) || (y / 8 - x / 8 == 1))
                                        && ((x % 8 - y % 8 == 2) || (y % 8 - x % 8 == 2)))))
                    return b1l;
                else if (((a.equals("iconb1l")) || (a.equals("iconb1g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("w"))))
                        && ((((x / 8 - y / 8 == 2) || (y / 8 - x / 8 == 2))
                                && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1)))
                                || (((x / 8 - y / 8 == 1) || (y / 8 - x / 8 == 1))
                                        && ((x % 8 - y % 8 == 2) || (y % 8 - x % 8 == 2)))))
                    return b1g;
                else
                    return null;
            } else if (piece(a) == 2) {
                if ((a.equals("iconw2l"))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("b"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0))) {
                    if (inbetween(sm, em, a) == null)
                        return w2l;
                    else
                        move(sm, em, startwi, endwi);
                } else if ((a.equals("iconw2g"))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("b"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0))) {
                    if (inbetween(sm, em, a) == null)
                        return w2g;
                    else
                        move(sm, em, startwi, endwi);
                } else if ((a.equals("iconb2l"))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("w"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0))) {
                    if (inbetween(sn, en, a) == null)
                        return b2l;
                    else
                        move(sn, en, startbi, endbi);
                } else if ((a.equals("iconb2g"))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("w"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0))) {
                    if (inbetween(sn, en, a) == null)
                        return b2g;
                    else
                        move(sn, en, startbi, endbi);
                } else
                    return null;
            } else if (piece(a) == 3) {
                if (((a.equals("iconw3l")) || (a.equals("iconw3g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("b"))))
                        && ((x / 8 == y / 8 + 1) || (x / 8 == y / 8 - 1) || (x % 8 == y % 8 + 1)
                                || (x % 8 == y % 8 - 1)))
                    return w3l;
                else if (((a.equals("iconw3l")) || (a.equals("iconw3g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("b"))))
                        && ((x / 8 == y / 8 + 1) || (x / 8 == y / 8 - 1) || (x % 8 == y % 8 + 1)
                                || (x % 8 == y % 8 - 1)))
                    return w3g;
                else if (((a.equals("iconb3l")) || (a.equals("iconb3g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("w"))))
                        && ((x / 8 == y / 8 + 1) || (x / 8 == y / 8 - 1) || (x % 8 == y % 8 + 1)
                                || (x % 8 == y % 8 - 1)))
                    return b3l;
                else if (((a.equals("iconb3l")) || (a.equals("iconb3g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("w"))))
                        && ((x / 8 == y / 8 + 1) || (x / 8 == y / 8 - 1) || (x % 8 == y % 8 + 1)
                                || (x % 8 == y % 8 - 1)))
                    return b3g;
                else
                    return null;
            } else if (piece(a) == 4) {
                if (((a.equals("iconw4l")) || (a.equals("iconw4g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("b"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0)
                                || (x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sm, em, a) == null)
                        return w4l;
                    else
                        move(sm, em, startwi, endwi);
                } else if (((a.equals("iconw4l")) || (a.equals("iconw4g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("b"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0)
                                || (x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sm, em, a) == null)
                        return w4g;
                    else
                        move(sm, em, startwi, endwi);
                } else if (((a.equals("iconb4l")) || (a.equals("iconb4g")))
                        && ((b.equals("lilacll")) || ((b.substring(6).equals("l")) && (b.substring(4, 5).equals("w"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0)
                                || (x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sn, en, a) == null)
                        return b4l;
                    else
                        move(sn, en, startbi, endbi);
                } else if (((a.equals("iconb4l")) || (a.equals("iconb4g")))
                        && ((b.equals("grayggg")) || ((b.substring(6).equals("g")) && (b.substring(4, 5).equals("w"))))
                        && (((x / 8 - y / 8) + (x % 8 - y % 8) == 0) || ((x / 8 - y / 8) - (x % 8 - y % 8) == 0)
                                || (x / 8 == y / 8) || (x % 8 == y % 8))) {
                    if (inbetween(sn, en, a) == null)
                        return b4g;
                    else
                        move(sn, en, startbi, endbi);
                } else
                    return null;
            } else if (piece(a) == 5) {
                if ((a.equals("iconw5g")) && (b.equals("lilacll")) && (x / 8 == y / 8 + 1))
                    return w5l;
                else if (((a.equals("iconw5g"))) && (b.substring(4, 5).equals("b"))
                        && ((x / 8 - y / 8 == 1) && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1))))
                    return w5g;
                else if ((a.equals("iconw5l")) && (b.equals("grayggg")) && (x / 8 == y / 8 + 1))
                    return w5g;
                else if (((a.equals("iconw5l"))) && (b.substring(4, 5).equals("b"))
                        && ((x / 8 - y / 8 == 1) && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1))))
                    return w5l;
                else if ((a.equals("iconb5g")) && (b.equals("lilacll")) && (x / 8 == y / 8 - 1))
                    return b5l;
                else if (((a.equals("iconb5g"))) && (b.substring(4, 5).equals("w"))
                        && ((x / 8 - y / 8 == -1) && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1))))
                    return b5g;
                else if ((a.equals("iconb5l")) && (b.equals("grayggg")) && (x / 8 == y / 8 - 1))
                    return b5g;
                else if (((a.equals("iconb5l"))) && (b.substring(4, 5).equals("w"))
                        && ((x / 8 - y / 8 == -1) && ((x % 8 - y % 8 == 1) || (y % 8 - x % 8 == 1))))
                    return b5l;
                else
                    return null;
            } else
                return null;
        }
        return null;
    }

    public String inbetween(int x, int y, String a) {
        // inbetween for rook
        if (a.equals("iconw0l") || a.equals("iconw0g")) {
            if (x / 8 == y / 8) {
                if (x < y) {
                    for (int i = x + 1; i < y; i++) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 1].getText();
                            em = i - 1;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 1; i > y; i--) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 1].getText();
                            em = i + 1;
                            break;
                        }
                    }
                }

            } else if (x % 8 == y % 8) {
                if (x < y) {
                    for (int i = x + 8; i < y; i += 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 8].getText();
                            em = i - 8;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 8; i > y; i -= 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 8].getText();
                            em = i + 8;
                            break;
                        }
                    }
                }

            }
        }

        else if (a.equals("iconb0l") || a.equals("iconb0g")) {
            if (x / 8 == y / 8) {
                if (x < y) {
                    for (int i = x + 1; i < y; i++) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 1].getText();
                            en = i - 1;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 1; i > y; i--) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 1].getText();
                            en = i + 1;
                            break;
                        }
                    }
                }

            } else if (x % 8 == y % 8) {
                if (x < y) {
                    for (int i = x + 8; i < y; i += 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 8].getText();
                            en = i - 8;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 8; i > y; i -= 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 8].getText();
                            en = i + 8;
                            break;
                        }
                    }
                }

            }
        }
        // inbetween for bishop
        if (a.equals("iconw2l") || a.equals("iconw2g")) {
            if ((x / 8 - y / 8) + (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 7; i < y; i += 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 7].getText();
                            em = i - 7;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 7; i > y; i -= 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 7].getText();
                            em = i + 7;
                            break;
                        }
                    }
                }

            } else if ((x / 8 - y / 8) - (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 9; i < y; i += 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 9].getText();
                            em = i - 9;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 9; i > y; i -= 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 9].getText();
                            em = i + 9;
                            break;
                        }
                    }
                }
            }
        }

        else if (a.equals("iconb2l") || a.equals("iconb2g")) {
            if ((x / 8 - y / 8) + (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 7; i < y; i += 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 7].getText();
                            en = i - 7;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 7; i > y; i -= 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 7].getText();
                            en = i + 7;
                            break;
                        }
                    }
                }
            } else if ((x / 8 - y / 8) - (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 9; i < y; i += 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 9].getText();
                            en = i - 9;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 9; i > y; i -= 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 9].getText();
                            en = i + 9;
                            break;
                        }
                    }
                }
            }
        }

        // inbetween for queen
        if (a.equals("iconw4l") || a.equals("iconw4g")) {
            if (x / 8 == y / 8) {
                if (x < y) {
                    for (int i = x + 1; i < y; i++) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 1].getText();
                            em = i - 1;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 1; i > y; i--) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 1].getText();
                            em = i + 1;
                            break;
                        }
                    }
                }
            } else if (x % 8 == y % 8) {
                if (x < y) {
                    for (int i = x + 8; i < y; i += 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 8].getText();
                            em = i - 8;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 8; i > y; i -= 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 8].getText();
                            em = i + 8;
                            break;
                        }
                    }
                }
            } else if ((x / 8 - y / 8) + (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 7; i < y; i += 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 7].getText();
                            em = i - 7;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 7; i > y; i -= 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 7].getText();
                            em = i + 7;
                            break;
                        }
                    }
                }

            } else if ((x / 8 - y / 8) - (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 9; i < y; i += 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i - 9].getText();
                            em = i - 9;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 9; i > y; i -= 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endwi = j[i].getText();
                            em = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endwi = j[i + 9].getText();
                            em = i + 9;
                            break;
                        }
                    }
                }
            }
        } else if (a.equals("iconb4l") || a.equals("iconb4g")) {
            if (x / 8 == y / 8) {
                if (x < y) {
                    for (int i = x + 1; i < y; i++) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 1].getText();
                            en = i - 1;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 1; i > y; i--) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 1].getText();
                            en = i + 1;
                            break;
                        }
                    }
                }

            } else if (x % 8 == y % 8) {
                if (x < y) {
                    for (int i = x + 8; i < y; i += 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 8].getText();
                            en = i - 8;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 8; i > y; i -= 8) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 8].getText();
                            en = i + 8;
                            break;
                        }
                    }
                }
            } else if ((x / 8 - y / 8) + (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 7; i < y; i += 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 7].getText();
                            en = i - 7;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 7; i > y; i -= 7) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 7].getText();
                            en = i + 7;
                            break;
                        }
                    }
                }
            } else if ((x / 8 - y / 8) - (x % 8 - y % 8) == 0) {
                if (x < y) {
                    for (int i = x + 9; i < y; i += 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i - 9].getText();
                            en = i - 9;
                            break;
                        }
                    }
                } else if (x > y) {
                    for (int i = x - 9; i > y; i -= 9) {
                        if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("w"))) {
                            endbi = j[i].getText();
                            en = i;
                            break;
                        } else if ((!j[i].getText().equals("lilacll")) && (!j[i].getText().equals("grayggg"))
                                && (j[i].getText().substring(4, 5).equals("b"))) {
                            endbi = j[i + 9].getText();
                            en = i + 9;
                            break;
                        }
                    }
                }
            }
        }

        return between;
    }

    public void winChess() {
        int wwin = 0, bwin = 0;
        for (int i = 0; i < 64; i++) {
            if ((j[i].getText().equals("iconb3g")) || (j[i].getText().equals("iconb3l")))
                bwin++;
            if ((j[i].getText().equals("iconw3g")) || (j[i].getText().equals("iconw3l")))
                wwin++;
        }
        if (wwin == 0) {
            String st = "BLACK KING WINS!";
            JOptionPane.showMessageDialog(null, st);
            reset();
        } else if (bwin == 0) {
            String st = "WHITE KING WINS!";
            JOptionPane.showMessageDialog(null, st);
            reset();

        }
    }

    public void reset() {
        for (int i = 0; i < 64; i += 8) {
            for (int k = 0; k < 8; k++) {
                if ((i % 16 == 0) && (k % 2 == 0)) {
                    j[i + k].setText("lilacll");
                    jl[i + k].setIcon(iconl);
                } else if ((i % 16 != 0) && (k % 2 != 0)) {
                    j[i + k].setText("lilacll");
                    jl[i + k].setIcon(iconl);
                } else {
                    j[i + k].setText("grayggg");
                    jl[i + k].setIcon(icong);
                }
            }
        }

        jl[0].setIcon(iconb0l);
        jl[1].setIcon(iconb1g);
        jl[2].setIcon(iconb2l);
        jl[3].setIcon(iconb3g);
        jl[4].setIcon(iconb4l);
        jl[5].setIcon(iconb2g);
        jl[6].setIcon(iconb1l);
        jl[7].setIcon(iconb0g);

        jl[8].setIcon(iconb5g);
        jl[9].setIcon(iconb5l);
        jl[10].setIcon(iconb5g);
        jl[11].setIcon(iconb5l);
        jl[12].setIcon(iconb5g);
        jl[13].setIcon(iconb5l);
        jl[14].setIcon(iconb5g);
        jl[15].setIcon(iconb5l);

        jl[56].setIcon(iconw0g);
        jl[57].setIcon(iconw1l);
        jl[58].setIcon(iconw2g);
        jl[59].setIcon(iconw3l);
        jl[60].setIcon(iconw4g);
        jl[61].setIcon(iconw2l);
        jl[62].setIcon(iconw1g);
        jl[63].setIcon(iconw0l);

        jl[48].setIcon(iconw5l);
        jl[49].setIcon(iconw5g);
        jl[50].setIcon(iconw5l);
        jl[51].setIcon(iconw5g);
        jl[52].setIcon(iconw5l);
        jl[53].setIcon(iconw5g);
        jl[54].setIcon(iconw5l);
        jl[55].setIcon(iconw5g);

        j[0].setText("iconb0l");
        j[1].setText("iconb1g");
        j[2].setText("iconb2l");
        j[3].setText("iconb3g");
        j[4].setText("iconb4l");
        j[5].setText("iconb2g");
        j[6].setText("iconb1l");
        j[7].setText("iconb0g");

        j[8].setText("iconb5g");
        j[9].setText("iconb5l");
        j[10].setText("iconb5g");
        j[11].setText("iconb5l");
        j[12].setText("iconb5g");
        j[13].setText("iconb5l");
        j[14].setText("iconb5g");
        j[15].setText("iconb5l");

        j[56].setText("iconw0g");
        j[57].setText("iconw1l");
        j[58].setText("iconw2g");
        j[59].setText("iconw3l");
        j[60].setText("iconw4g");
        j[61].setText("iconw2l");
        j[62].setText("iconw1g");
        j[63].setText("iconw0l");

        j[48].setText("iconw5l");
        j[49].setText("iconw5g");
        j[50].setText("iconw5l");
        j[51].setText("iconw5g");
        j[52].setText("iconw5l");
        j[53].setText("iconw5g");
        j[54].setText("iconw5l");
        j[55].setText("iconw5g");

        count = 0;
        startwi = null;
        startbi = null;
        endwi = null;
        endbi = null;
        sm = 0;
        sn = 0;
        em = 0;
        en = 0;
    }

    Chess() {
        JFrame f = new JFrame("CHESS");
        f.setLayout(new BorderLayout());
        f.setSize(700, 700);
        f.setLocationRelativeTo(null);

        iconl = new ImageIcon(lilac);
        icong = new ImageIcon(gray);

        iconb0g = new ImageIcon(b0g);
        iconb1g = new ImageIcon(b1g);
        iconb2g = new ImageIcon(b2g);
        iconb3g = new ImageIcon(b3g);
        iconb4g = new ImageIcon(b4g);
        iconb5g = new ImageIcon(b5g);

        iconb0l = new ImageIcon(b0l);
        iconb1l = new ImageIcon(b1l);
        iconb2l = new ImageIcon(b2l);
        iconb3l = new ImageIcon(b3l);
        iconb4l = new ImageIcon(b4l);
        iconb5l = new ImageIcon(b5l);

        iconw0g = new ImageIcon(w0g);
        iconw1g = new ImageIcon(w1g);
        iconw2g = new ImageIcon(w2g);
        iconw3g = new ImageIcon(w3g);
        iconw4g = new ImageIcon(w4g);
        iconw5g = new ImageIcon(w5g);

        iconw0l = new ImageIcon(w0l);
        iconw1l = new ImageIcon(w1l);
        iconw2l = new ImageIcon(w2l);
        iconw3l = new ImageIcon(w3l);
        iconw4l = new ImageIcon(w4l);
        iconw5l = new ImageIcon(w5l);

        chesspanel = new JPanel();
        chesspanel.setPreferredSize(new Dimension(700, 700));
        chesspanel.setBackground(Color.WHITE);
        chesspanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        chesspanel.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 64; i += 8) {
            for (int k = 0; k < 8; k++) {
                j[i + k] = new JButton("");
                jl[i + k] = new JLabel("");
                j[i + k].setMargin(new Insets(0, 0, 0, 0));
                chesspanel.add(j[i + k]);
                if ((i % 16 == 0) && (k % 2 == 0)) {
                    j[i + k].setBackground(new Color(231, 206, 242));
                    // j[i+k].setForeground(new Color(231,206,242));
                    jl[i + k].setIcon(iconl);
                    gbc.gridx = i % 8;
                    gbc.gridy = k;
                    j[i + k].add(jl[i + k], gbc);
                    j[i + k].setText("lilacll");
                } else if ((i % 16 != 0) && (k % 2 != 0)) {
                    j[i + k].setBackground(new Color(231, 206, 242));
                    // j[i+k].setForeground(new Color(231,206,242));
                    jl[i + k].setIcon(iconl);
                    gbc.gridx = i % 8;
                    gbc.gridy = k;
                    j[i + k].add(jl[i + k], gbc);
                    j[i + k].setText("lilacll");
                } else {
                    j[i + k].setBackground(new Color(242, 242, 242));
                    // j[i+k].setForeground(new Color(242,242,242));
                    jl[i + k].setIcon(icong);
                    gbc.gridx = i % 8;
                    gbc.gridy = k;
                    j[i + k].add(jl[i + k], gbc);
                    j[i + k].setText("grayggg");
                }
                j[i + k].setFocusPainted(false);
                j[i + k].setPreferredSize(new Dimension(87, 87));
                gbc.gridx = i % 8;
                gbc.gridy = k;
                chesspanel.add(j[i + k], gbc);
            }
        }

        jl[0].setIcon(iconb0l);
        jl[1].setIcon(iconb1g);
        jl[2].setIcon(iconb2l);
        jl[3].setIcon(iconb3g);
        jl[4].setIcon(iconb4l);
        jl[5].setIcon(iconb2g);
        jl[6].setIcon(iconb1l);
        jl[7].setIcon(iconb0g);

        jl[8].setIcon(iconb5g);
        jl[9].setIcon(iconb5l);
        jl[10].setIcon(iconb5g);
        jl[11].setIcon(iconb5l);
        jl[12].setIcon(iconb5g);
        jl[13].setIcon(iconb5l);
        jl[14].setIcon(iconb5g);
        jl[15].setIcon(iconb5l);

        jl[56].setIcon(iconw0g);
        jl[57].setIcon(iconw1l);
        jl[58].setIcon(iconw2g);
        jl[59].setIcon(iconw3l);
        jl[60].setIcon(iconw4g);
        jl[61].setIcon(iconw2l);
        jl[62].setIcon(iconw1g);
        jl[63].setIcon(iconw0l);

        jl[48].setIcon(iconw5l);
        jl[49].setIcon(iconw5g);
        jl[50].setIcon(iconw5l);
        jl[51].setIcon(iconw5g);
        jl[52].setIcon(iconw5l);
        jl[53].setIcon(iconw5g);
        jl[54].setIcon(iconw5l);
        jl[55].setIcon(iconw5g);

        j[0].setText("iconb0l");
        j[1].setText("iconb1g");
        j[2].setText("iconb2l");
        j[3].setText("iconb3g");
        j[4].setText("iconb4l");
        j[5].setText("iconb2g");
        j[6].setText("iconb1l");
        j[7].setText("iconb0g");

        j[8].setText("iconb5g");
        j[9].setText("iconb5l");
        j[10].setText("iconb5g");
        j[11].setText("iconb5l");
        j[12].setText("iconb5g");
        j[13].setText("iconb5l");
        j[14].setText("iconb5g");
        j[15].setText("iconb5l");

        j[56].setText("iconw0g");
        j[57].setText("iconw1l");
        j[58].setText("iconw2g");
        j[59].setText("iconw3l");
        j[60].setText("iconw4g");
        j[61].setText("iconw2l");
        j[62].setText("iconw1g");
        j[63].setText("iconw0l");

        j[48].setText("iconw5l");
        j[49].setText("iconw5g");
        j[50].setText("iconw5l");
        j[51].setText("iconw5g");
        j[52].setText("iconw5l");
        j[53].setText("iconw5g");
        j[54].setText("iconw5l");
        j[55].setText("iconw5g");

        // INSERTING BLACK PIECES
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        j[0].add(jl[0], gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        j[1].add(jl[1], gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        j[2].add(jl[2], gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        j[3].add(jl[3], gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        j[4].add(jl[4], gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        j[5].add(jl[5], gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        j[6].add(jl[6], gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        j[7].add(jl[7], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        j[8].add(jl[8], gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        j[9].add(jl[9], gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        j[10].add(jl[10], gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        j[11].add(jl[11], gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        j[12].add(jl[12], gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        j[13].add(jl[13], gbc);

        gbc.gridx = 6;
        gbc.gridy = 1;
        j[14].add(jl[14], gbc);

        gbc.gridx = 7;
        gbc.gridy = 1;
        j[15].add(jl[15], gbc);

        // INSERTING WHITE PIECES
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        j[48].add(jl[48], gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        j[49].add(jl[49], gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        j[50].add(jl[50], gbc);

        gbc.gridx = 3;
        gbc.gridy = 6;
        j[51].add(jl[51], gbc);

        gbc.gridx = 4;
        gbc.gridy = 6;
        j[52].add(jl[52], gbc);

        gbc.gridx = 5;
        gbc.gridy = 6;
        j[53].add(jl[53], gbc);

        gbc.gridx = 6;
        gbc.gridy = 6;
        j[54].add(jl[54], gbc);

        gbc.gridx = 7;
        gbc.gridy = 6;
        j[55].add(jl[55], gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        j[56].add(jl[56], gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        j[57].add(jl[57], gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        j[58].add(jl[58], gbc);

        gbc.gridx = 3;
        gbc.gridy = 7;
        j[59].add(jl[59], gbc);

        gbc.gridx = 4;
        gbc.gridy = 7;
        j[60].add(jl[60], gbc);

        gbc.gridx = 5;
        gbc.gridy = 7;
        j[61].add(jl[61], gbc);

        gbc.gridx = 6;
        gbc.gridy = 7;
        j[62].add(jl[62], gbc);

        gbc.gridx = 7;
        gbc.gridy = 7;
        j[63].add(jl[63], gbc);

        j[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(0);
            }
        });

        j[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(1);
            }
        });

        j[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(2);
            }
        });

        j[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(3);
            }
        });

        j[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(4);
            }
        });

        j[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(5);
            }
        });

        j[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(6);
            }
        });

        j[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(7);
            }
        });

        j[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(8);
            }
        });

        j[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(9);
            }
        });

        j[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(10);
            }
        });

        j[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(11);
            }
        });

        j[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(12);
            }
        });

        j[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(13);
            }
        });

        j[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(14);
            }
        });

        j[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(15);
            }
        });

        j[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(16);
            }
        });

        j[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(17);
            }
        });

        j[18].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(18);
            }
        });

        j[19].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(19);
            }
        });

        j[20].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(20);
            }
        });

        j[21].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(21);
            }
        });

        j[22].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(22);
            }
        });

        j[23].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(23);
            }
        });

        j[24].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(24);
            }
        });

        j[25].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(25);
            }
        });

        j[26].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(26);
            }
        });

        j[27].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(27);
            }
        });

        j[28].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(28);
            }
        });

        j[29].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(29);
            }
        });

        j[30].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(30);
            }
        });

        j[31].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(31);
            }
        });

        j[32].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(32);
            }
        });

        j[33].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(33);
            }
        });

        j[34].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(34);
            }
        });

        j[35].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(35);
            }
        });

        j[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(36);
            }
        });

        j[37].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(37);
            }
        });

        j[38].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(38);
            }
        });

        j[39].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(39);
            }
        });

        j[40].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(40);
            }
        });

        j[41].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(41);
            }
        });

        j[42].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(42);
            }
        });

        j[43].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(43);
            }
        });

        j[44].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(44);
            }
        });

        j[45].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(45);
            }
        });

        j[46].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(46);
            }
        });

        j[47].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(47);
            }
        });

        j[48].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(48);
            }
        });

        j[49].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(49);
            }
        });

        j[50].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(50);
            }
        });

        j[51].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(51);
            }
        });

        j[52].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(52);
            }
        });

        j[53].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(53);
            }
        });

        j[54].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(54);
            }
        });

        j[55].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(55);
            }
        });

        j[56].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(56);
            }
        });

        j[57].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(57);
            }
        });

        j[58].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(58);
            }
        });

        j[59].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(59);
            }
        });

        j[60].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(60);
            }
        });

        j[61].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(61);
            }
        });

        j[62].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(62);
            }
        });

        j[63].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chessmoves(63);
            }
        });

        f.add(chesspanel, BorderLayout.CENTER);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }

    public static void main(String args[]) {
        new Chess();
    }
}