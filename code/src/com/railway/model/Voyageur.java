package com.railway.model;

public class Voyageur {
    private String name;
    private int age;

    public Voyageur(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Voyageur{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    
    public void ModifierMotDePasse(String nouveauMotDePasse) {
        // Placeholder implementation for modifying password
        System.out.println("Password modification process initiated.");
        // Add your password modification logic here
    }
    
    public void ConsulterCarteDeReduction() {
        // Placeholder implementation for checking reduction card
        System.out.println("Reduction card consultation process initiated.");
        // Add your reduction card consultation logic here
    }
    
}
