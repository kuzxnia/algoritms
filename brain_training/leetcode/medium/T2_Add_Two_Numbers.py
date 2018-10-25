# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1, l2):
        temp_sum = 0
        node = None
        head_node = None

        while l1 != None or l2 != None or temp_sum > 0:
            temp_sum = (l1.val if l1 else 0) + (l2.val if l2 else 0) + temp_sum

            if node:
                node.next = ListNode(temp_sum % 10)
                node = node.next
            else:
                node = ListNode(temp_sum % 10)
                head_node = node

            temp_sum = temp_sum // 10

            l1 = l1.next if l1 != None else None
            l2 = l2.next if l2 != None else None

        return head_node
