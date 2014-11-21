class LCA {
/**
LCA: 5 method
1. Top-down search. recursion 套 recursion.  
	time：O(n^2)
2. Bottom-up approach.  Once find a p | q return it, or return null; 
	then consecutively pass it up until find the lca(root.left != null && root.right != null) 
	and return it up.  time:O(n)
3. Top-down approach. use extra space to keep track the path of p & q.  
	Then find the intersection of two path, which is lca.   
	time: O(n), space: O(h)
4. If has parent ptr: use visited hashset to denote the visited node.  
	iterate p & q up, the first re-visited node is lca.   
	time: O(h), best time complexity. since no traversal search time needed. space: O(h)
5. If has parent ptr: calculate the different height 'dh' of p & q, then advance deeper node 'dh' steps
	advance, then two pointer move two node together up, once they enconter, that node is lca
	Best Solution, no extra space needed. time: O(h), space: O(1)
http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html

Vairation: 1. Find intersection of two singlly linked list.  
			solution: rotate LCA problem 90 degree clockwise, treat it use method 5
*/



}