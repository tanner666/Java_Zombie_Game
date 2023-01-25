package ZombieInvasion;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    //loops through objects in game and updates + renders them
    //linkedlist !!!!

    LinkedList<ZombieInvasion.GameObject> object = new LinkedList<ZombieInvasion.GameObject>();

    public void tick(){
        //System.out.println("Tick");
        //loops through every object in linked list
        for (int i = 0; i < object.size(); i++){
            ZombieInvasion.GameObject tempObject = object.get(i);
            if(tempObject == null)
                continue;
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        //System.out.println("render");
        for(int i = 0; i < object.size(); i++){
            ZombieInvasion.GameObject tempObject = object.get(i);
            if(tempObject == null)
                continue;
            tempObject.render(g);
        }
    }

    public int objectCount(ID id){
        int counter = 0;
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i) == null)
                continue;
            if (object.get(i).getID() == id)
                counter++;
        }
        return counter;
    }

    public int assign_id_Number(){
        return object.size();
    }

    public GameObject getObject(int id_num){
        return object.get(id_num);
    }

    public void addObject(ZombieInvasion.GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        int id = object.getID_num();
        this.object.remove(object);
        for (int i = id; i < this.object.size(); i++){
            this.object.get(i).setID_num(i);
        }
    }

    public LinkedList<ZombieInvasion.GameObject> getList(){
        return object;
    }

}
