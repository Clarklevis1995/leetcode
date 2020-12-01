package 练习.队列.猫狗队列;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("Dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("Cat");
        }
    }


    public static class PetEnter{
        private Pet pet;
        private int count;

        public PetEnter(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public int getCount() {
            return count;
        }

        public String getEnterPetType(){
            return pet.getType();
        }
    }

    public static class PetQueue{
        private Queue<PetEnter> catQueue;
        private Queue<PetEnter> dogQueue;
        private int count;


        public PetQueue() {
            this.catQueue = new LinkedList<>();
            this.dogQueue = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet){
            if (pet.getType() .equals("Dog")){
                dogQueue.add(new PetEnter(new Dog(), count++));
            }else if (pet.getType().equals("Cat")){
                catQueue.add(new PetEnter(new Cat(), count++));
            }else {
                throw new RuntimeException("Not dog or cat!");
            }
        }

        public Pet pollAll(){
            if (!dogQueue.isEmpty()&&!catQueue.isEmpty()){
                return dogQueue.peek().count<catQueue.peek().count?dogQueue.poll().getPet():catQueue.poll().getPet();
            }
            else if (!dogQueue.isEmpty()){
                return dogQueue.poll().getPet();
            }
            else if (!catQueue.isEmpty()){
                return catQueue.poll().getPet();
            }else {
                throw new RuntimeException("The queue is empty!");
            }
        }

        public Pet pollCat(){
            if (catQueue.isEmpty()){
                throw new RuntimeException("CatQueue is empty!");
            }
            return catQueue.poll().getPet();
        }

        public Pet pollDog(){
            if (dogQueue.isEmpty()){
                throw new RuntimeException("DogQueue is empty");
            }
            return dogQueue.poll().getPet();
        }

        public boolean isEmpty(){
            return dogQueue.isEmpty()&&catQueue.isEmpty();
        }

        public boolean isCatEmpty(){
            return catQueue.isEmpty();
        }

        public boolean isDogEmpty(){
            return dogQueue.isEmpty();
        }
    }




}
