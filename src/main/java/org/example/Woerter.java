package org.example;

import java.util.Map;
import java.util.TreeMap;

public class Woerter {

    private Map<String, String> woerter;

    public Woerter() {
        woerter= new TreeMap<>();
        woerter.put("Tisch", "https://res.cloudinary.com/frohraum/image/upload/c_limit,f_auto,w_555/v1/production/shop/active_storage/6jiray8jadut2ppdfi63aowb1c2c/esstisch-et10-a1-bein8x8-buche-kgl.png");
        woerter.put("Fisch", "https://png.pngtree.com/png-vector/20190726/ourmid/pngtree-fish-vector-png-png-image_1610034.jpg");
        woerter.put("Sonne", "https://png.pngtree.com/element_our/20190601/ourmid/pngtree-cartoon-cute-cute-little-sun-image_1335670.jpg");
        woerter.put("Mond", "https://png.pngtree.com/png-vector/20210131/ourmid/pngtree-the-surface-of-a-round-moon-png-image_2873731.png");
        woerter.put("Flasche", "https://png.pngtree.com/element_pic/00/16/09/1557da1301bfab7.jpg");
        woerter.put("Wasser", "https://png.pngtree.com/png-vector/20210924/ourmid/pngtree-pure-water-splash-png-image_3944713.jpg");
    }

    public Map<String, String> getWoerter() {
         return woerter;
    }
}
