package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    //Przedstawienie działania zaimplementowanych funkcjonalności. Pozdrawiam serdecznie, Jakub Banach
        List<WallBlock> wallBlockList = new ArrayList<>();

        wallBlockList.add(new WallBlock("blue", "metalic"));
        wallBlockList.add(new WallBlock("green", "metalic"));
        wallBlockList.add(new WallBlock("yellow", "metalic"));
        wallBlockList.add(new WallBlock("orange", "fabric"));
        wallBlockList.add(new WallBlock("brown", "fabric"));
        wallBlockList.add(new WallBlock("purple", "wood"));
        wallBlockList.add(new WallBlock("magenta", "wood"));

        System.out.println(wallBlockList.size());

        System.out.println(wallBlockList.get(0).getColor());
        System.out.println(wallBlockList.get(0).getMaterial());

        Wall simsWall = new Wall(wallBlockList);

        System.out.println(simsWall.findBlockByColor("blue"));
        System.out.println(simsWall.findBlockByColor("not blue"));

        System.out.println(simsWall.findBlocksByMaterial("fabric"));
        System.out.println(simsWall.findBlocksByMaterial("not fabric"));

        System.out.println(simsWall.count());
    }
}
