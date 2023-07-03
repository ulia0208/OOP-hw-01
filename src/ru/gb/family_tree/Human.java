package ru.gb.family_tree;

import org.w3c.dom.Node;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private static int count;

    private int id=0;
    private String name;
    private Gender gender;
    private LocalDate  birthDate;
    private LocalDate deathDate;

    //private Parent parent;

    private List<Human>parents;

    private List<Human>children;




    public Human(String name, LocalDate birthDate, Gender gender,Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;

        this.deathDate = deathDate;
        parents=new ArrayList<>();

        children=new ArrayList<>();

        if(mother!=null){
            parents.add(mother);
        }
        if(father!=null){
            parents.add(father);
        }

        //System.out.println(LocalDate.of(2021,5,12));
    }

    public Human(String name,LocalDate birthDate, Gender gender){
        this(name,birthDate,gender,null,null);
    }


    public String getName(){
        return name;
    }

    public boolean addParent(Human parent){
        if(!parents.contains(parent)){
            children.add(parent);
            return true;
        }
        return false;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public LocalDate getDeathDate(){
        return  deathDate;
    }

    public Human getFather(){
        for(Human parent:parents){
            if (parent.getGender()==Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for(Human parent:parents){
            if(parent.getGender()==Gender.Female){
                return parent;

            }
        }
        return null;
    }

    public List<Human>getChildren(){
        return children;
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }



    public Gender getGender(){
        return gender;
    }

    public String getBirthdate(){
        return "День рождения " + name + ": " + birthDate + '.' ;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate=birthDate;
    }
    public void setDeathDate(LocalDate deathDate){
        this.deathDate=deathDate;
    }

    public String getInfo(){
        StringBuilder sb=new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");

        sb.append(getAgeInfo());
        sb.append(", ");

        sb.append(getMothInfo());
        sb.append(", ");

        sb.append(getFathInfo());
        sb.append(", ");
        sb.append(getChildInfo());

        return sb.toString();





    }

    public String getMothInfo(){
        String par="мать ";
        Human mother=getMother();
        if(mother!=null){
            par+=mother.getName();
        }
        else {
            par+="неизвестна";
        }
        return par;

    }

    public String getFathInfo(){
        String par="отец ";
        Human father=getFather();
        if(father!=null){
            par+=father.getName();
        }
        else {
            par+="неизвестен";
        }
        return par;

    }

    public String getAgeInfo(){
        String age="возраст: ";
        Integer intAge;
        if(deathDate!=null){
            intAge= deathDate.getYear()-birthDate.getYear();
        }
        else {
            intAge=LocalDate.now().getYear()-birthDate.getYear();
        }
        return age+=intAge.toString();
    }
    public String getChildInfo(){
        StringBuilder par=new StringBuilder();
        par.append("дети: ");
        if(children.size()!=0){
            par.append(children.get(0).getName());
            for(int i =1;i<children.size();i++){
                par.append(", ");
                par.append(children.get(i).getName());
            }

        }else{
            par.append("отсутствуют");
        }
        return par.toString();
    }


    @Override
    public String toString() {
        return name+" name " + birthDate+" birthDate.";
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human=(Human) obj;
        return human.getName().equals(getName());
    }
}
