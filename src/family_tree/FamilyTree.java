package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList=humanList;
    }



    public boolean addHuman(Human human){
        if(!humanList.contains(human)){
            humanList.add(human);

            addToChi(human);
            addToPar(human);
            return true;

        }
        return false;

    }

    public String getHumanInfo(){
        StringBuilder stringBuilder= new StringBuilder();
        for (Human human:humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void addToPar(Human human){
        if(human.getFather()!=null){
            human.getFather().addChild(human);

        }
        if(human.getMother()!=null){
            human.getMother().addChild(human);
        }

    }

    private void addToChi(Human human){
        for(Human child:human.getChildren()){
            child.addParent(human);
        }

    }

    public Human getByName(String name){
        for(Human human:humanList){
            if(human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb=new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" обьектов: \n");
        for (Human human:humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }




}
