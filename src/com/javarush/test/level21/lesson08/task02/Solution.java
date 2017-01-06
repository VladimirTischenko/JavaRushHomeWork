package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public Plant clone() throws CloneNotSupportedException
        {
            String name = new String(this.name);
            Plant clonePlant = new Plant(name);
            return clonePlant;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Tree clone() throws CloneNotSupportedException
        {
            Plant clonePlant = super.clone();

            if (this.branches == null)
                return new Tree(clonePlant.name, null);
            int branchesLength = this.branches.length;
            String[] cloneBranches = new String[branchesLength];
            for (int i = 0; i < branchesLength; i++)
                cloneBranches[i] = new String(this.getBranches()[i]);
            Tree cloneTree = new Tree(clonePlant.name, cloneBranches);
            return cloneTree;
        }
    }
}
