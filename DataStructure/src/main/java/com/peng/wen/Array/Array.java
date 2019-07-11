package com.peng.wen.Array;

public class Array {

    private int[] data;
    private int size;


    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 数组容量
     */
    public Array(int capacity){
        this.data = new int[capacity];
        this.size = 0;
    }

    /**
     * 无参的构造函数,默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获得元素的个数
     * @return int
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 获得数组的容量
     * @return int
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return Boolean
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 向数组末尾添加元素
     * @param e 需要添加的元素
     */
    public void addLast(int e){
        this.add(this.size,e);
    }

    /**
     * 向数组第一个位置插入元素
     * @param e 元素
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 向数组index位置插入元素额
     * @param index 需要插入的位置
     * @param e 需要插入的元素
     */
    public void add(int index, int e){

        if (size == this.data.length){
            throw new IllegalArgumentException("Add failed.Array is full.");
        }

        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index < 0 || index > size.");
        }

        for(int i = size; i > index; i--){
            this.data[i] = data[i-1];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 获得指定位置的元素
     * @param index 指定的位置
     * @return int
     */
    public int get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return this.data[index];
    }

    /**
     * 修改指定位置的元素
     * @param index 指定位置
     * @param e 元素
     */
    public void set(int index, int e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", this.size, this.data.length));
        res.append('[');
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
