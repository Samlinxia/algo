/**Given a binary search tree, creates a linked list of all the nodes at each depth
	BFS + dummy node to indicate when we have finished one level and are starting on the next*/
import java.util.*;
class Chap44{
	/*not use queue*/
	public static ArrayList<LinkedList<TreeNode>> findLevelLinkList(
		TreeNode root) {
	int level = 0;
	ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	LinkedList<TreeNode> list = new LinkedList<TreeNode>();
	list.add(root);
	result.add(level, list);
	while (true) {
		list = new LinkedList<TreeNode>();
		for (int i = 0; i < result.get(level).size(); i++) {
			TreeNode n = (TreeNode) result.get(level).get(i);  //LinkedList store as head node
			if (n != null) {
				if (n.left != null)
					list.add(n.left);
				if (n.right != null)
					list.add(n.right);
			}
		}
		if (list.size() > 0) {
			result.add(level + 1, list);
		} else {
			break;
		}
		level++;
	}
	return result;
}

	
	/*use two queue*/
	public ArrayList<LinkedList<TreeNode>> findLevelLinkList2(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> levelList = new LinkedList<TreeNode>();
		AQueue<TreeNode> q1 = new AQueue<TreeNode>();
		AQueue<TreeNode> q2 = new AQueue<TreeNode>();
		AQueue<TreeNode> qTemp;  //serves as swap
		int level = 0;
		TreeNode temp = null;
		q1.enqueue(root);
		while(!q1.isEmpty())
		{
			while(!q1.isEmpty())
			{
				temp = q1.dequeue();
			
				if(temp.left != null)
					q2.enqueue(temp.left);
				if(temp.right != null)
					q2.enqueue(temp.right);
				levelList.add(temp);
			}
			result.add(level,levelList);
			level++;
			//swap q1 and q2
			qTemp = q1;
			q1 = q2;
			q2 = qTemp;
		}
		return result;
	}
	
	
}