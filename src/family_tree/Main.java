package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree=new FamilyTree();
        FileHandler fileHandler=new FileHandler();
        FileHandler serialize=new FileHandler();

        familyTree.addHuman(new Human("Иван Иванов", LocalDate.of(1960,1,21), Gender.Male));
        familyTree.addHuman(new Human("Лилия Иванова", LocalDate.of(1962,4,11), Gender.Female));
        familyTree.addHuman(new Human("Сергей Иванов", LocalDate.of(1987,3,5),Gender.Male, familyTree.getByName("Иван Иванов"), familyTree.getByName("Лилия Иванова")));

        familyTree.addHuman(new Human("Инна Иванова", LocalDate.of(1988,9,25), Gender.Female));

        familyTree.addHuman(new Human("Серге Иванов", LocalDate.of(2013,8,16),Gender.Male, familyTree.getByName("Сергей Иванов"), familyTree.getByName("Инна Иванова")));
        familyTree.addHuman(new Human("Василий Иванов", LocalDate.of(2016,2,12),Gender.Male, familyTree.getByName("Сергей Иванов"), familyTree.getByName("Инна Иванова")));
        familyTree.addHuman(new Human("Мария Иванова", LocalDate.of(2018,11,10), Gender.Female, familyTree.getByName("Сергей Иванов"), familyTree.getByName("Инна Иванова")));

        System.out.println(familyTree.getInfo());
        fileHandler.save(String.valueOf(familyTree),"src/ru.gb.family_tree/tree.out");
        System.out.println(familyTree);

        fileHandler.save("src/family_tree/famTree.out", familyTree);

    }
}