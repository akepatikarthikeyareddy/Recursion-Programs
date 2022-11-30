/*
Given A Singly Linked List: A0→A1→...→An-2→An-1, Reorder It To: A0→An-1→A1→An-2→A2→An-3→...
For Example: Given 1->2->3->4->5 Its Reorder Is 1->5->2->4->3.
*/

import java.util.Scanner;
class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
    }
}
class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Node head = new Node(-1);
        Node tail = head;
        int numOfNodes = input.nextInt();
        for(int i = 0; i < numOfNodes; i++){
            tail.next = new Node(input.nextInt());
            tail = tail.next;
        }
        Node reversed = reorderlist(head.next);
        print(reversed);
    }
    static Node reorderlist(Node head) {
        Node slow = head, fast = head, temp;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = slow.next;
        slow.next = null;
        Node firstHalf = head;
        secondHalf = reverse(secondHalf);
        Node ansHead = new Node(-1);
        Node ansTail = ansHead;
        while(firstHalf != null){
            temp = firstHalf;
            firstHalf = firstHalf.next;
            temp.next = null;
            ansTail.next = temp;
            ansTail = ansTail.next;
            if(secondHalf != null){
                temp = secondHalf;
                secondHalf = secondHalf.next;
                temp.next = null;
                ansTail.next = temp;
                ansTail = ansTail.next;
            }
        }
        return ansHead.next;
    }
    static Node reverse(Node head){
        Node temp = null, reversed = null;
        while(head != null){
            temp = head;
            head = head.next;
            temp.next = reversed;
            reversed = temp;
        }
        return reversed;
    }
    static void print(Node head){
        while(head.next != null){
            System.out.print(head.data + "-->");
            head = head.next;
        }
        System.out.print(head.data);
    }
}
/*
Input:  NoOfNodes  = 6
        LinkedList = 1-->2-->3-->4-->5-->6
Output: LinkedList = 1-->6-->2-->5-->3-->4

Time Complexity : O(N)
Space Complexity: O(1)
*/