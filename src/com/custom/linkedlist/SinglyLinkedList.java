/*
 * package com.custom.linkedlist;
 * 
 * public class SinglyLinkedList {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * CustomSinglyList customSinglyList = new CustomSinglyList();
 * customSinglyList.addToSinglyLinkedList(1);
 * customSinglyList.addToSinglyLinkedList(10);
 * customSinglyList.addToSinglyLinkedList(11);
 * customSinglyList.addToSinglyLinkedList(100);
 * customSinglyList.addToSinglyLinkedList(19);
 * 
 * System.out.println("printing"); customSinglyList.getSinglyLinkedList();
 * 
 * System.out.println("Deleting");
 * 
 * customSinglyList.deleteElementFromSinglyLinkedList(11);
 * customSinglyList.deleteElementFromSinglyLinkedList(1);
 * 
 * 
 * customSinglyList.getSinglyLinkedList();
 * 
 * 
 * 
 * 
 * 
 * } }
 * 
 * 
 * class Node { int value; Node nextNode;
 * 
 * public Node() {
 * 
 * } public Node(int value) { this.value=value; this.nextNode=null; }
 * 
 * public String toString() { return "The value of current Node =" + value+
 * " \n";
 * 
 * }
 * 
 * } class CustomSinglyList {
 * 
 * CustomSinglyList() {
 * 
 * } Node head; public void getSinglyLinkedList() { Node temp = head; while
 * (temp!=null) { System.out.println( temp.toString()); temp=temp.nextNode; } }
 * public void addToSinglyLinkedList(int value) { Node newNode = new
 * Node(value); if(head==null) { head = newNode; } else { Node temp = head;
 * while (temp.nextNode!=null) { temp=temp.nextNode; } temp.nextNode=newNode;
 * 
 * } }
 * 
 * public Node deleteElementFromSinglyLinkedList(int value) { Node newNode = new
 * Node(value); if(head==null) { return newNode; } else { Node temp = head;
 * 
 * if(temp.value==value && temp==head) { head=head.nextNode; return temp; } else
 * {
 * 
 * while (temp.nextNode.value!=newNode.value) {
 * 
 * temp=temp.nextNode; } temp.nextNode = temp.nextNode.nextNode;
 * 
 * 
 * return temp; }
 * 
 * 
 * } } }
 * 
 */