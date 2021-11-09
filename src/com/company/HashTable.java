package com.company;


public class HashTable {

    private HashTableElement[] data;
    private int capacity;
    private int size;

    public static final HashTableElement DEFAULT=new HashTableElement("Default",null);

    public HashTable(int capacity){
        this.capacity=capacity;
        data=new HashTableElement[capacity];//Создание массива длины capacity,состоящего из элементов
        //HashTableElement
        for(int i=0;i<data.length;i++){
            data[i]=DEFAULT;//установка дефолтных значений для стартовой таблицы

        }

    }

    public HashTableElement[] getData() {
        return data;
    }

    public void setData(HashTableElement[] data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    //хеш-функция методом деления
    public int HashFunc(String key){
        return key.hashCode()%capacity;
    }

    //метод получения элемента по ключу
    public Object get(String key){
        int hash=HashFunc(key);//вычисление хеш-значения

        while(data[hash].getKey()!=key && data[hash]!=DEFAULT){
            hash=(hash+1)%capacity;//пока не найдём нужный ключ или не дойдём до
            //значения по умолчанию
        }
        return data[hash].getElement();
    }

    //метод вставки элемента
    public void put(String key,Object element){
        if(key!=null){
            size++;
            int hash=HashFunc(key);
            while(data[hash].getKey()!=key && data[hash]!=DEFAULT){
                hash=(hash+1)%capacity;
            }
            data[hash]=new HashTableElement(key,element);
        }

    }
    //метод удаления элемента
    public void remove(String key){
        if(key!=null){

            int hash=HashFunc(key);
            while(data[hash].getKey()!=key && data[hash]!=DEFAULT){
                hash=(hash+1)%capacity;
            }
            data[hash]=DEFAULT;
            size--;
        }
    }


    //вывод табл
    @Override
    public String toString()
    {
        String s = "HashTable[";
        for (int i = 0; i < this.capacity; i++)
        {
            if (data[i].getElement() != null)
            {
                s += data[i].toString();

            }
        }
        s += "]";
        return s;
    }
}
