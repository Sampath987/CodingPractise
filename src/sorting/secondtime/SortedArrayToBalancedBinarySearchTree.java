package sorting.secondtime;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBalancedBinarySearchTree
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		
		int[] arr = {0,1,2,3,4,5,6};
		
		TreeNode testNode = solution.sortedArrayToBST(arr);
		
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(testNode);
		
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if(node.left != null) 
				queue.offer(node.left);
			if(node.right != null) 
				queue.offer(node.right);

		}
		
		

		
		
	}
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
 class Solution {
	    
	    TreeNode head = null;
	    int balanceFactor = 0;
	    public TreeNode sortedArrayToBST(int[] nums) {
	        
	        int mid = (nums.length-1)/2 ;
	        int left = mid-1;
	        int right = mid+1;
	        TreeNode root = new TreeNode(nums[mid]);
	        addToBST(head, root);
	        while(left < mid && left >=0 && right > mid && right < nums.length)
	        {
	                    addToBST(head, new TreeNode(nums[left]));
	                    addToBST(head, new TreeNode(nums[right]));
	            left--;
	            right++;
	        }
	        while(left < mid && left >=0)
	            {
	                    addToBST(head, new TreeNode(nums[left]));
	                    left--;
	            }
	        while(right > mid && right < nums.length)
	            {
	                    addToBST(head, new TreeNode(nums[right]));
	                    right++;
	            }
	        return root;
	    }
	    
	    public void addToBST(TreeNode tempHead, TreeNode temp)
	    {
	        if(head==null)
	            head = temp;
	        else
	        {
	            
	                if(tempHead.val > temp.val)
	                {
	                	if(tempHead.left==null)
	        			{
	                		tempHead.left=temp;
	        			}
	        			else
	        			{
	        				addToBST(tempHead.left,temp);
	        				
	        			}
	                }
	                else
	                {
	                	if(tempHead.right==null)
	        			{
	                		tempHead.right=temp;
	        			}
	        			else
	        			{
	        				addToBST(tempHead.right,temp);
	        				
	        			}
	                }
	              
	        }
	        
	        heightBalance(tempHead);
	    }
	    
	    public int height(TreeNode node)
	    {
	        if(node==null)
	            return 0;
	        return Math.max(height(node.right), height(node.left)) + 1;

	    }
	    
	    public int balanceFactorMethod(TreeNode node)
	    {
	            if(node == null)
	                return 0;

	            return height(node.right) - height(node.left);
	         }
	    
	    public void heightBalance(TreeNode node)
	    {
	        if(balanceFactorMethod(node) == 2)
	        {
	            if(balanceFactorMethod(node.right)==1)
	            {
	                TreeNode newNode = new TreeNode(node.val);
	                node.val = node.right.val;
	                node.right.val = node.right.right.val;
	                node.right.right = null;
	                node.left = newNode;

	            }
	            else
	            {
	                TreeNode newNode = new TreeNode(node.val);
	                node.val = node.right.left.val;
	                node.right.left = null;
	                node.left = newNode;
	            }
	        }
	         if(balanceFactorMethod(node) == -2)
	        {
	            if(balanceFactorMethod(node.left)==-1)
	            {
	                TreeNode newNode = new TreeNode(node.val);
	                node.val = node.left.val;
	                node.left.val = node.left.left.val;
	                node.left.left = null;
	                node.right = newNode;

	            }
	            else
	            {
	                TreeNode newNode = new TreeNode(node.val);
	                node.val = node.left.right.val;
	                node.left.right = null;
	                node.right = newNode;
	            }
	        }
	    }
	    }