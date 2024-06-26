import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Számold össze, hogy összesen hány mezőt léptek a világos és sötét vezérek együtt.
        // Egy mérkőzés adatai egy-egy sorban vannak
        // A lépések az egyszerűség kedvéért nem tartalmazzák a sakk, matt, jó / rossz lépés jelzéseket

        List<List<String>> merkozesek = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("e4", "d5", "exd5", "Vxd5", "Hc3", "Vd8", "Fc4", "Hf6", "Hf3", "Fg4", "h3", "Fxf3", "Vxf3", "e6", "Vxb7", "Hbd7", "Hb5", "Bc8", "Hxa7", "Hb6", "Hxc8", "Hxc8", "d4", "Hd6", "Fb5", "Hxb5", "Vxb5", "Hd7", "d5", "exd5", "Fe3", "Fd6", "Bd1", "Vf6", "Bxd5", "Vg6", "Ff4", "Fxf4", "Vxd7", "Kf8", "Vd8")),
                new ArrayList<>(Arrays.asList("e4", "d6", "d4", "Hf6", "Hc3", "Hbd7", "f4", "e5", "Hf3", "exd4", "Vxd4", "c6", "Fe3", "d5", "e5", "Fc5", "Vd2", "Fxe3", "Vxe3", "Hg4", "Vd2", "Hc5", "b4", "He6", "Fd3", "Vb6", "h3", "Ve3", "Vxe3", "Hxe3", "Kf2", "Hc4", "f5", "Hf4", "Fxc4", "dxc4", "g4", "O-O", "Bad1", "g6", "Hh4", "b5", "He4", "Hd5", "a3", "Bd8", "Bhe1", "a5", "Hc5", "axb4", "axb4", "Ba2", "Be2", "Be8", "He4", "Kg7", "Hd6", "Bd8", "Bdd2", "Ba3", "Hf3", "Hf4", "Be4", "Hd5", "Bed4", "Hxb4", "f6", "Kg8", "Hxc8", "Bxd4", "Hxd4", "Bxh3", "Hf3", "Hd5", "He7")),
                new ArrayList<>(Arrays.asList("e4", "c5", "Hf3", "Hc6", "d4", "cxd4", "Hxd4", "e5", "Hb5", "d6", "H1c3", "a6", "Ha3", "f5", "Fd3", "Hf6", "Fg5", "Fe7", "Fxf6", "Fxf6", "exf5", "Hd4", "Vh5", "Kf8", "Fc4", "Vc7", "Hd5", "Hxc2", "Kd2", "Vc5", "He3", "d5", "Fxd5", "g6", "fxg6", "Fg4", "g7", "Kxg7", "Vxg4")),
                new ArrayList<>(Arrays.asList("e4", "c5", "c3", "Hf6", "Fd3", "Hc6", "f4", "e5", "Fc2", "d5", "d4", "cxd4", "cxd4", "Fg4", "He2", "Hxd4", "fxe5", "Fc5", "exf6", "Fxe2", "fxg7", "Bg8", "Fa4", "b5", "Fxb5", "Fxb5", "Hc3", "Bxg7", "Fe3", "Bxg2", "Ff2", "Bxf2", "Kxf2", "He2", "Ke1", "Hxc3", "Vh5", "Vf6", "Vf5", "Vh4", "Kd2", "Hxe4", "Kc2", "Vf2", "Vxf2", "Fxf2", "a4", "Bc8", "Kb3", "Fe2", "a5", "Bc5", "Ba4", "Ff3", "Bf1", "Hd2")),
                new ArrayList<>(Arrays.asList("d4", "d6", "c4", "e5", "Hf3", "exd4", "Hxd4", "Hc6", "Hc3", "g6", "e4", "Fg7", "Fe3", "Hxd4", "Fxd4", "Fxd4", "Vxd4", "Vf6", "Vd2", "Ve5", "f4", "Vc5", "Hd5", "f6", "b4", "Vc6", "c5", "Vd7", "Vc3", "dxc5", "Bd1", "Vg7", "Vxc5", "c6", "Fb5", "Bb8", "Vd6", "cxb5", "Vxb8", "He7", "Hxe7", "Kxe7", "Vc7")),
                new ArrayList<>(Arrays.asList("b4", "a5", "b5", "Hf6", "Fb2", "d6", "e3", "b6", "c4", "e5", "Hc3", "Fb7", "Hf3", "Hbd7", "Fe2", "e4", "Hd4", "He5", "Vc2", "Fe7", "O-O", "O-O", "Hf5", "Vd7", "Hg3", "Hf3")),
                new ArrayList<>(Arrays.asList("e4", "c5", "Hf3", "Hf6", "e5", "Hd5", "d4", "Va5", "Fd2", "Vb6", "c4", "Hb4", "d5", "Vg6", "Fxb4", "cxb4", "Vd4", "d6", "Hbd2", "e6", "Fd3", "Vh6", "O-O", "g5", "He4", "dxe5", "Vxe5", "Fg7", "Hd6", "Kf8", "Vg3", "Ha6", "Hxg5", "Fxb2", "Hdxf7", "Vg7", "Vd6", "Kg8", "dxe6", "Ff6", "f4", "h6", "Hxh8", "hxg5", "Hg6", "g4", "e7")),
                new ArrayList<>(Arrays.asList("e4", "e5", "Hf3", "Hc6", "Fb5", "a6", "Fa4", "b5", "Fb3", "Ha5", "Fxf7", "Kxf7", "Hxe5", "Ke7", "Vf3", "Ve8", "d4", "h6", "Va3", "d6", "Vxa5", "Kd8", "Ff4", "g5", "Fg3", "Hf6", "Hc3", "Fb7", "O-O-O", "Hxe4", "Hxe4", "Fxe4", "Bhe1", "Fxg2", "d5", "Kc8", "a4", "dxe5", "Bxe5", "Vd7", "Be8", "Kb7", "Bxa8", "Kxa8", "Vxa6", "Kb8", "axb5", "Fd6", "b6")),
                new ArrayList<>(Arrays.asList("e4", "c5", "Hc3", "Hc6", "g3", "g6", "Fg2", "Fg7", "d3", "d6", "Fe3", "Bb8", "Bb1", "b5", "f4", "b4", "Ha4", "Fd7", "c3", "bxc3", "bxc3", "Bxb1", "Vxb1", "Va5", "Vb3", "Hd8", "Hxc5", "Fxc3", "Kf2", "dxc5", "He2", "Fd2", "Vb2", "Fxe3", "Kxe3", "Hf6", "h3", "Fc6", "Bb1", "O-O")),
                new ArrayList<>(Arrays.asList("d4", "Hf6", "c4", "g6", "Hc3", "d6", "e4", "Fg7", "Fe2", "O-O", "Fg5", "Hbd7", "Vd2", "e5", "d5", "Hc5", "f3", "Ve8", "g4", "a6", "h4", "h5", "gxh5", "Hxh5", "Hh3", "Hg3", "Bh2", "Hxe2", "Vxe2", "Fxh3", "Bxh3", "Vd7", "Bh1", "b5", "cxb5", "axb5", "h5", "b4", "Hd1", "b3", "h6", "Bxa2", "Bc1", "Bxb2", "Ve3", "Bc2", "hxg7", "Ba8", "Ff6")),
                new ArrayList<>(Arrays.asList("e4", "e5", "Hf3", "Hc6", "d4", "exd4", "Fc4", "Fc5", "c3", "Hf6", "e5", "d5", "Fb5", "He4", "Hxd4", "O-O", "Fxc6", "bxc6", "O-O", "Fa6", "Be1", "Be8", "Fe3", "Vh4", "Hd2", "Bxe5", "H2f3", "Vh5", "Hxe5", "Vxe5", "Hxc6", "Vd6", "Fxc5", "Vxc5", "Vxd5", "Vxf2", "Kh1", "Hf6", "He7", "Kf8", "Vxa8", "He8", "Hg6", "hxg6", "Vxe8")),
                new ArrayList<>(Arrays.asList("e4", "c5", "Hc3", "d6", "g3", "Hc6", "Fg2", "g6", "Hge2", "Fg7", "d3", "e6", "Bb1", "Hge7", "O-O", "O-O", "Fg5", "h6", "Fe3", "Hd4", "Vd2", "Kh7", "a3", "b6", "Hf4", "Fb7", "b4", "Bc8", "Hce2", "e5", "Fxd4", "cxd4", "Hd5", "Hxd5", "exd5", "f5", "Bbc1", "f4", "gxf4", "exf4", "Fe4", "f3", "Hg3", "h5")),
                new ArrayList<>(Arrays.asList("e4", "c5", "Hf3", "e6", "c3", "Hc6", "d4", "d5", "exd5", "Vxd5", "Fe2", "cxd4", "cxd4", "Hf6", "O-O", "h6", "Hc3", "Vd6", "Hb5", "Vd8", "Ff4", "Hd5", "Fg3", "Fe7", "Be1", "a6", "Hc3", "O-O", "b4", "Ff6", "b5", "Be8", "bxa6", "Hxc3", "axb7", "Hxd4", "Va4", "Hxa4", "bxa8=V", "Hxe2", "Bxe2", "Hb6", "Va7", "Be7", "Vxe7", "Vxe7", "Bb1", "Fa6", "Bee1", "Hd5", "Bb3", "Hc3", "h3", "He2", "Kh2", "Hxg3", "fxg3", "Fc4", "Bbb1", "Fd5", "Bbd1", "Vd6", "Hd2", "Va3", "Hf1", "Vb2", "Bd2", "Vc3", "Bed1", "h5", "h4", "Ve5", "Kh1", "g5", "hxg5", "Fxg5")),
                new ArrayList<>(Arrays.asList("e4", "c5", "Hf3", "Hc6", "d4", "cxd4", "Hxd4", "e6", "c4", "Vb6", "Hb3", "Hf6", "Hc3", "Fb4", "Fe3", "Fxc3", "bxc3", "Vc7", "f3", "b6", "Hd4", "He5", "Hb5", "Vc6", "Vd4", "Hg6", "e5", "Hh5", "Vg4", "Hxe5", "Vxh5", "d6", "Bd1", "g6", "Vg5", "O-O", "Bxd6", "Vxf3", "Vxe5", "Vf5", "Vxf5", "exf5", "Hc7", "Bb8", "Fh6", "Fb7", "Fxf8", "Kxf8", "Kf2", "Ke7", "Bd4", "Fe4", "Fd3", "Fxd3", "Bxd3", "Kf6", "Be1", "h5", "Be8", "Bxe8", "Hxe8", "Ke5", "Kf3", "f4", "Bd5", "Ke6", "Kxf4", "f6", "Hc7", "Kf7", "Bd7", "Kf8", "Hd5")),
                new ArrayList<>(Arrays.asList("e4", "e6", "d4", "d5", "Hc3", "Fb4", "e5", "c5", "a3", "Fxc3", "bxc3", "He7", "Vg4", "Vc7", "Vxg7", "Bg8", "Vxh7", "cxd4", "Kd1", "Hd7", "Hf3", "Hxe5", "Ff4", "Vxc3", "Hxe5", "Vxa1", "Fc1", "Bf8", "Fd3", "Fd7", "Ke2", "Hc6", "Hg6", "O-O-O", "Hxf8", "Bxf8", "Be1", "Vc3", "Kf1", "f6", "Vg7", "Bd8", "Vxf6", "e5", "f3", "Vc5", "Kg1", "Be8", "Vg5", "Kb8", "h4", "Ve7", "Vxe7", "Bxe7", "Fg5", "Be8", "h5", "Bg8", "Ff6", "Fh3", "h6", "Bxg2", "Kh1")),
                new ArrayList<>(Arrays.asList("e4", "d5", "exd5", "Hf6", "c4", "c6", "dxc6", "Hxc6", "Hc3", "e5", "d3", "Ff5", "Fg5", "Fc5", "Hf3", "Vd6", "Ve2", "O-O-O", "Bd1", "Bhe8", "a3", "Hd4", "Vd2", "e4", "dxe4", "Fxe4", "Hxe4", "Hxe4", "Vd3", "Hxf3")),
                new ArrayList<>(Arrays.asList("e4", "e6", "d4", "d5", "Hc3", "Hf6", "e5", "Hfd7", "Hf3", "c5", "He2", "Hc6", "c3", "Fe7", "Fe3", "O-O", "dxc5", "Fxc5", "Fxc5", "Hxc5", "Hed4", "f6", "Hxc6", "bxc6", "b4", "He4", "Fd3", "Hxf2", "Kxf2", "fxe5", "Be1", "Vb6", "Kg3", "e4", "Fxe4", "dxe4", "Bxe4", "c5", "bxc5", "Vxc5", "Vd4", "Vc6", "He5", "Vc7", "Bae1", "Fb7", "Bg4", "Bad8", "Ve3", "Bf5", "Bd4", "Bd5", "Bxd5", "Fxd5", "h4", "Fxa2", "Kh3", "Fd5", "g4", "Bf8", "Ba1", "a5", "Ba4", "Bb8", "Vd4", "Bb3")),
                new ArrayList<>(Arrays.asList("e4", "e5", "Hf3", "Hc6", "Fc4", "Hf6", "d3", "Fc5", "c3", "O-O", "Hbd2", "Be8", "O-O", "Fb6", "h3", "h6", "Be1", "d5", "exd5", "Hxd5", "He4", "Ff5", "Fxh6", "Vd7", "Hh4", "Fe6", "Vh5", "Bad8", "Fxd5", "f5", "Hxf5")),
                new ArrayList<>(Arrays.asList("e4", "c6", "d4", "d5", "e5", "Ff5", "Fd3", "Fxd3", "Vxd3", "Va5", "Fd2", "Va6", "Vxa6", "Hxa6", "Hf3", "e6", "O-O", "He7", "a3", "Hg6", "g3", "Fe7", "h4", "h6", "h5", "Hf8", "b3", "Hd7", "c4", "c5", "cxd5", "exd5", "Hc3", "Hc7", "Fe3", "O-O", "a4", "a6", "Bac1", "b6", "Bfd1", "Bfd8", "dxc5", "Hxc5", "b4", "H5e6", "Fxb6", "Fxb4", "Ha2", "Fa3", "Bc3", "Fb2", "Bb3")),
                new ArrayList<>(Arrays.asList("e4", "e6", "d4", "d5", "Hc3", "dxe4", "Hxe4", "Fd7", "Hf3", "Fc6", "Fd3", "Hd7", "c3", "Fe7", "Ve2", "Hgf6", "Hxf6", "Fxf6", "Fe4", "Fxe4", "Vxe4", "c6", "Ff4", "Va5", "O-O", "Fe7", "He5", "Hf6", "Ve2", "O-O", "Bfe1", "Bad8", "Hc4", "Vf5", "Ve5", "Vd3", "Ve2", "Vf5", "Ve5", "Vg6", "Fg3", "Hd5", "Ve2", "Vf5", "Ve5", "Vd3", "Ve2", "Vxe2", "Bxe2", "h5", "He3", "c5", "Hxd5", "cxd4", "Hxe7")),
                new ArrayList<>(Arrays.asList("e4", "c5", "Hf3", "d6", "d4", "cxd4", "Hxd4", "Hf6", "Hc3", "a6", "h3"
                        , "g6", "Fc4", "b5", "Fb3", "Fb7", "O-O", "Fg7", "Be1", "O-O", "a4", "Hc6", "Hxc6", "Fxc6", "Fg5", "h6", "Fh4", "g5", "Fg3", "Hd7", "axb5", "axb5", "Bxa8", "Vxa8", "Hd5", "Vd8", "c3", "Hc5", "Fc2", "Vd7", "h4", "Bd8", "hxg5", "hxg5", "Vh5", "He6", "He3", "b4", "Hf5", "bxc3", "e5")),
                new ArrayList<>(Arrays.asList("e4", "d5", "exd5", "Vxd5", "Hc3", "Va5", "d4", "Hf6", "Fd2", "Fg4",
                        "f3", "Ff5", "Fc4", "Vb6", "Hge2", "c6", "Fb3", "e6", "g4", "Fg6", "h4", "h6", "Hf4", "Fh7",
                        "Ve2", "Hbd7", "O-O-O", "O-O-O", "g5", "Hd5", "Hcxd5", "exd5", "Vf2", "Ff5", "Hg2", "hxg5",
                        "hxg5", "Fd6", "He3", "Vxd4", "Fc3", "Vf4", "Kb1", "Fc5", "Fd2", "Bde8", "Hxf5", "Vxf5", "Vg3", "Bxh1", "Bxh1", "Be2", "Bh8", "Hf8", "Ff4", "Kd7", "Bh1", "He6", "Fc1", "Hd4", "Vh3", "Vxh3", "Bxh3", "Be1", "a3", "Hxb3", "cxb3", "Fe3"))
                //teszt
                //new ArrayList<>(Arrays.asList("Ve2", "Vxh4", "Vxa6"))
        ));

        int teljestav = 0;
        for (List<String> merkozes : merkozesek) {
            String vilagosVezerLegutobbiPozicioja = "d1";
            String sotetVezerLegutobbiPozicioja = "d8";
            //System.out.println("Mérkőzés kezdete");
            for(int i = 0; i < merkozes.size(); i++) {
                String lepes = merkozes.get(i);
                if (lepes.startsWith("V")) {
                    String vezerJelenlegiPozicioja = lepes.contains("x") ? lepes.substring(2, 4) : lepes.substring(1,3);
                    if (i % 2 == 0) {
                        //System.out.println("Világos vezér lépése: " + vilagosVezerLegutobbiPozicioja + " -> " +
                        // vezerJelenlegiPozicioja);
                        teljestav += tavolsag(vilagosVezerLegutobbiPozicioja, vezerJelenlegiPozicioja);
                        vilagosVezerLegutobbiPozicioja = vezerJelenlegiPozicioja;
                    }
                    else {
                        //System.out.println("Sötét vezér lépése: " + sotetVezerLegutobbiPozicioja + " -> " +
                        // vezerJelenlegiPozicioja);
                        teljestav += tavolsag(sotetVezerLegutobbiPozicioja, vezerJelenlegiPozicioja);
                        sotetVezerLegutobbiPozicioja = vezerJelenlegiPozicioja;
                    }
                }
            }
            //System.out.println("Mérkőzés vége: " + teljestav);
        }
        System.out.println("Teljes vezérek által megtett távolság: " + teljestav + " mező");
    }

    public static int tavolsag(String pozicio1, String pozicio2) {
        int oszlopKulonbseg = Math.abs(pozicio2.charAt(0) - pozicio1.charAt(0));
        int sorKulonbseg = Math.abs(pozicio2.charAt(1) - pozicio1.charAt(1));
        return Math.max(oszlopKulonbseg, sorKulonbseg);
    }
}
