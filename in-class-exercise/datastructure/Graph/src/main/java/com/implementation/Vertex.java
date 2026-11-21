package com.implementation;

import java.util.Set;

public class Vertex<E> {
    private E value; 
    private Set<Vertex<E>> neighbors;
    
    public E getValue() {
        return this.value;
    }

    public void connect(Vertex<E> neighbor) {

    }

    public boolean connected(Vertex<E> neighbor) {
        if(neighbor == null)  {
            return false;
        }
        
        return true;
    }

    public Set<Vertex<E>> getNeigbors() {
        return this.neighbors;
    }
}
