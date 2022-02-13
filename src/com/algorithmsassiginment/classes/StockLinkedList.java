package com.algorithmsassiginment.classes;

public class StockLinkedList {
  
  class StockNode {
    StockNode next;
    double stockPrice;
    boolean isRise;

    public StockNode(double sPrice, boolean isRising) {
      stockPrice = sPrice;
      isRise = isRising;
    }
  }
  
  StockNode head = null;
  StockNode tail = null;
  int _length = 0;

  public void createNode(double sPrice, boolean isRising) {
    StockNode newCompany = new StockNode(sPrice, isRising);

    if (head == null) {
      head = newCompany;
      tail = newCompany;
    }
    else {
      tail.next = newCompany;
      tail = tail.next;
    }
    tail.next = null;
    _length++;
  }
  
  public void addNode(StockNode node) {
    if (head == null) {
      head = node;
      tail = node;
    }
    else {
      tail.next = node;
      tail = tail.next;
    }
    tail.next = null;
    _length++;
  }

  public int listLength() {
    return _length;
  }

  public StockNode getNodeAtIndex(int idx) {
    StockNode curr = head;
    for(int i = 0; i <= idx; i++) {
      curr = curr.next;
    }
    return curr;
  }

  public double getStock(int idx) {
    StockNode curr = head;
    for(int i = 0; i <= idx; i++) {
      curr = curr.next;
    }
    return curr.stockPrice;
  }

  StockNode merge(StockNode a, StockNode b) {
    StockLinkedList res = new StockLinkedList();

    if (a == null) {
      return b;
    }

    if (b == null) {
      return a;
    }

    if (a.stockPrice < b.stockPrice){
      res.addNode(a);
      res.addNode(merge(a.next, b));
    }
    else {
      res.addNode(b);
      res.addNode(merge(a, b.next));
    }
    
    return res.head;
  }

  public StockNode mergeSort(StockNode stockList) {
    if(head == null || head.next == null) {
      return stockList;
    }

    int m = this._length/2;
    StockNode mid = this.getNodeAtIndex(m);
    StockNode midnext = mid.next;
    
    mid.next = null;

    StockNode Left = mergeSort(mid);
    StockNode Right = mergeSort(midnext);

    StockNode sorted = merge(Left, Right);
    return sorted;
  }

  public void printStocks() {
    StockNode curr = this.head;
    while (curr.next != null) {
      System.out.println(curr.stockPrice + " ");
      curr = curr.next;
    }
  }

}
