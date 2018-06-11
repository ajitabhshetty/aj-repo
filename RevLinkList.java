/*
Reverse a singly linked list.
5->3->6->9->7->null

rec end condition
void rev(trav) {
  if (trav->next!=null){
    prev=trav;
    rev(trav->next);
    trav->next->next = prev;
    prev->next=null;
  } else {
    head=trav;
  }
}

//recursive call stack have to do it
rev     rev      rev      rev        rev
trav(5) trav(3)  trav(6)  trav=9     trav=7
prev(5) prev(3)  prev(6)  prev(9)    //prev(7)
rev(3)  rev(6)   rev(9)   rev(7)     //rev(null)
                          assign     //go back (head=7)
*/
import java.util.*;

class Node {
  int data;
  Node next;
}

public class RevLinkList {
  public static void main (String[] args) {
    Node head=null;
    List<Integer> nums = Arrays.asList(5,3,6,9,7);
    head = buildList(nums,head);
    System.out.println("Before");
    printList(head);
    head=revList(head,head);
    System.out.println("\nAfter");
    printList(head);
    System.out.println();
  }

  public static Node buildList(List<Integer> nums, Node head) {
    for (Integer num:nums) {
      Node node = new Node();
      node.data = num;
      node.next = null;
      if (head==null) {
        head = node;
      } else {
          Node trav = head;
          while(trav.next!=null) {
            trav=trav.next;
          }
          trav.next=node;
      }
    }
    return head;
  }
  public static void printList(Node trav) {
    while (trav!=null) {
      System.out.print(trav.data+" ");
      trav=trav.next;
    }
  }
  public static Node revList(Node trav,Node head) {
    if (trav.next!=null) {
      Node prev = trav;
      head=revList(trav.next,head);
      trav.next.next=prev;
      prev.next=null;
    } else{
      head=trav;
    }
    return head;
  }
}
