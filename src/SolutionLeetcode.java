import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionLeetcode {
    /**
     * 113
     * 给定一个二叉树和一个目标和，
     * 找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<String> list = pathSumString(root);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            List<Integer> digitList = new ArrayList<>();
            //以空格划分字符串
            String[] splited = s.split("\\s+");
            for(int k = 0; k < splited.length; k++){
                digitList.add(Integer.parseInt(splited[k]));
            }
            int total = 0;
            for(int k =0; k < digitList.size(); k++){
                total += digitList.get(k);
            }
            if(total == sum){
                res.add(digitList);
            }
        }
        System.out.println(res);
        return res;
    }
    // 257 变形
    public List<String> pathSumString(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null){
            //退出的条件,已经到达叶子节点
            String s = root.val+"";
            res.add(s);
            return res;
        }
        if(root.left != null){
            List<String> left = pathSumString(root.left);
            for(int i = 0; i < left.size(); i++){
                res.add(root.val+" "+left.get(i));
            }
        }
        if(root.right != null){
            List<String> right = pathSumString(root.right);
            for(int i = 0; i < right.size(); i++){
                res.add(root.val+" "+right.get(i));
            }
        }
        return res;
    }

    public int sumNumbers(TreeNode root) {
        List<String> list = pathSumString1(root);
        int total = 0;
        for(int i = 0; i < list.size(); i++){
            total += Integer.parseInt(list.get(i));
        }
        System.out.println(total);
        return total;
    }
    public List<String> pathSumString1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null){
            //退出的条件,已经到达叶子节点
            String s = root.val+"";
            res.add(s);
            return res;
        }
        if(root.left != null){
            List<String> left = pathSumString1(root.left);
            for(int i = 0; i < left.size(); i++){
                res.add(root.val+""+left.get(i));
            }
        }
        if(root.right != null){
            List<String> right = pathSumString1(root.right);
            for(int i = 0; i < right.size(); i++){
                res.add(root.val+""+right.get(i));
            }
        }
        return res;
    }

    /**
     * 437
     * @param root
     * @param sum
     * @return
     */
    public int pathSum437(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int res = findSum(root, sum);
        res += pathSum437(root.left, sum);
        res += pathSum437(root.right, sum);

        return res;
    }
    // 以node为根节点，找到一共有多少条路径，其包含node，并且路径的和为num
    public int findSum(TreeNode node, int num){
        if(node == null){
            return 0;
        }
        int res = 0;
        if(node.val == num){
            res += 1;
        }
        res += findSum(node.left, num-node.val);
        res += findSum(node.right, num-node.val);
        return res;
    }

    /**
     * 235
     * 最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == null || q == null){
            return null;
        }
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p , q);
        }
        return root;
    }

    /**
     * 98
     * 验证一棵树是二叉搜索树
     * @param root
     * @return
     */
    private boolean ans = true;
    private TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre != null && node.val <= pre.val)
            ans = false;
        pre = node;
        dfs(node.right);
    }

}
