package com.algorithmsassiginment.classes;

import java.util.Scanner;

public class Stockers {
    Scanner input = new Scanner(System.in);
    StockLinkedList sll = new StockLinkedList();

  public void inputStocks() {
    System.out.println("Enter the no of companies");
    int companyNumber = input.nextInt();
   
    for (int i = 0; i < companyNumber; i++) {
      System.out.println("Enter the Stock of the " + (i + 1) + " Company");
      double d = input.nextDouble();
      
      System.out.println("Did the stock rise ?: ");
      boolean b = input.nextBoolean();
     
      sll.createNode(d, b);
    }
     
      sll.printStocks();
      sll.mergeSort(sll.head);
      sll.printStocks();
 
  } 
}
