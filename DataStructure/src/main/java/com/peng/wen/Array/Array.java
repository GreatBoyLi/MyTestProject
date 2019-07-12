package com.peng.wen.Array;

public class Array<E> {

    private E[] data;
    private int size;


    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 数组容量
     */
    public Array(int capacity){
        this.data = (E[])new Object[capacity];
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
    public void addLast(E e){
        this.add(this.size,e);
    }

    /**
     * 向数组第一个位置插入元素
     * @param e 元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向数组index位置插入元素额
     * @param index 需要插入的位置
     * @param e 需要插入的元素
     */
    public void add(int index, E e){

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
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return this.data[index];
    }

    /**
     * 修改指定位置的元素
     * @param index 指定位置
     * @param e 元素
     */
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断是否包含某一元素
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e){
        for (int i = 0; i < this.size; i++){
            if (this.data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否存在元素e，存在返回对应的第一个索引值，不存在返回-1
     * @param e 元素
     * @return int
     */
    public int findFirst(E e){
        for(int i = 0; i < this.size; i++){
            if (this.data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断是否存在元素e，存在返回对应的最后一个索引值，不存在返回-1
     * @param e 元素
     * @return int
     */
    public int findLast(E e){
        for (int i = size -1; i >= 0; i--){
            if (this.data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查询元素所有的位置
     * @param e 元素
     * @return Array
     */
    public Array findAll(E e){
        Array indexs = new Array(this.size);
        for(int i = 0; i < this.size; i++){
            if (this.data[i].equals(e)){
                indexs.addLast(i);
            }
        }
        return indexs;
    }

    /**
     * 删除指定位置的元素，并返回删除的元素
     * @param index 索引位置
     * @return int
     */
    public E remove(int index){
        if (index < 0 || index >= this.size){
            throw new IllegalArgumentException("Remove failed. The index is illegal.");
        }
        E ret = this.data[index];
        for (int i = index + 1; i < this.size; i++){
            this.data[i - 1] = this.data[i];
        }
        this.size --;
        this.data[size] = null;  // loitering objects !=
        return ret;
    }

    /**
     * 删除第一个元素，返回删除的元素
     * @return int
     */
    public E removeFirst(){
        return this.remove(0);
    }

    /**
     * 删除最后一个元素，返回删除的元素
     * @return int
     */
    public E removeLast(){
        return this.remove(this.size - 1);
    }

    /**
     * 删除第一次出现的指定元素，如果删除成功返回true，不存在该元素删除失败返回false
     * @param e 待删除元素
     * @return boolean
     */
    public boolean removeFirstElement(E e){
        int index = this.findFirst(e);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 删除最后一次出现的指定元素，如果删除成功返回true，不存在该元素删除失败返回false
     * @param e 待删除元素
     * @return boolean
     */
    public boolean removeLastElement(E e){
        int index = this.findLast(e);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * 删除所有指定的元素，删除成功返回true，不存在该元素删除失败返回false
     * @param e 待删除元素
     * @return boolean
     */
    public boolean removeAllElements(E e){
        Array indexs = this.findAll(e);
        if (indexs.size == 0){
            return false;
        }
        for (int i = indexs.size -1; i >= 0; i--){
            this.remove((Integer) indexs.get(i));
        }
        return true;
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
