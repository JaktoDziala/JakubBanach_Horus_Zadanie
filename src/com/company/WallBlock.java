package com.company;
// Postanowiłem stworzyć rekord zamiast klasy. Mniej kodu przy zamyśle że nie chce móc edytować pól color i material po stworzeniu bloku.
public record WallBlock(String color, String material) implements Block
{
    // [Implementacja interfejsu Block]
    @Override
    public String getColor() {
        return color;
    }

    // [Implementacja interfejsu Block]
    @Override
    public String getMaterial() {
        return material;
    }
}