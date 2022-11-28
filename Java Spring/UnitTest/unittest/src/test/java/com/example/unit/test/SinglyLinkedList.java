package com.example.unit.test;

public class SinglyLinkedList {
	
    public Node head;
    
    public SinglyLinkedList() {
        this.head = null;
    }
    
    public void add(int value) {
    	
        Node newNode = new Node(value);
        
        if(this.head == null) {
        	this.head = newNode;
        }else {
        	
            Node runner = this.head;
            
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
            
        }
    }
    
    public Node removeFront() {
    	
    	if(this.head == null) {
    		return null;
    	}
    	this.head = this.head.next;
    	
		return this.head;
    }
}
