package com.company;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Dzień dobry, przedstawię po krótce wykonanie przeze mnie zadania. Po analizie założeń zdecydowałem się na kilka zmian w kodzie
interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

interface Block {
    String getColor();
    String getMaterial();
}

// Pierwszą zmianą jaką zrobiłem było rozdzielenie interfejsów CompositeBlock i Block.
// W rozumieniu zadania klasa Wall nie potrzebuje informacji o własnych kolorach i materiałach, ponieważ sama nie ma takich pól,
// a może składać się z wielu kolorów i materiałów
// Pola te wprowadziłem do rekordu WallBlock, który to reprezentuje pojedyncze bloki ściany.  Rekord ten implementuje również interfejs Block
interface CompositeBlock{
    List getBlocks();
}

// Zaimplementowałem do klasy Wall interfejsy Structure oraz CompositeBlock
public class Wall implements Structure, CompositeBlock{
    // Zmieniłem typ z List na List<WallBlock>
    private List<WallBlock> blocks;

    //Jako konstruktor klasy przedstawiłem zwykłe przypisywanie bloków. Ponieważ zakładam że ściana może być rozszerzana, nie zmieniłem Listy w final
    Wall(List<WallBlock> blocks)
    {
        this.blocks = blocks;
    }

    // [Implementacja interfejsu Structure]
    // W tej funkcji używam strumienia do pozyskania informacji o bloku danego koloru. Funkcję można przetestować w klasie Main
    @Override
    public Optional findBlockByColor(String color) {
        return blocks.stream().filter(wallBlock -> wallBlock.getColor().equals(color)).findFirst();
    }

    // [Implementacja interfejsu Structure]
    // W tej funkcji używam strumienia do pozyskania informacji o blokach danego materiału. Funkcję można przetestować w klasie Main
    @Override
    public List findBlocksByMaterial(String material) {
        return blocks.stream().filter(wallBlock -> wallBlock.getMaterial().equals(material)).collect(Collectors.toList());
    }

    // [Implementacja interfejsu Structure]
    // Pozyskanie informacji o ilości bloków w ścianie
    @Override
    public int count() {
        return blocks.size();
    }

    // [Implementacja interfejsu CompositeBlock]
    @Override
    public List<WallBlock> getBlocks() {
        return blocks;
    }
}



