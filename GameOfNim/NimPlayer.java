package nim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Artificial Intelligence responsible for playing the game of Nim!
 * Implements the alpha-beta-pruning mini-max search algorithm to play Game of Nim with computer opponent
 * @Author Sam Gibson, Veda Ashok
 */
public class NimPlayer {
    
    private final int MAX_REMOVAL;
    private Map<GameTreeNode, Integer> visited = new HashMap<>();
    
    NimPlayer (int MAX_REMOVAL) {
        this.MAX_REMOVAL = MAX_REMOVAL;
    }
    
    /**
     * 
     * @param   remaining   Integer representing the amount of stones left in the pile
     * @return  An int action representing the number of stones to remove in the range
     *          of [1, MAX_REMOVAL]
     */
    public int choose (int remaining) {
        GameTreeNode root = new GameTreeNode(remaining, 0, true);
        alphaBetaMinimax(root, -1, 2, true, visited);
        int optimalMove = 1;
        int optimalScore = 0;
        for(int i = 0; i < root.children.size(); i++) {
        	if(root.children.get(i).score > optimalScore) {
        		optimalMove = root.children.get(i).action;
        		optimalScore = root.children.get(i).score;
        	}
        }
        return optimalMove;
        
    }
    
    /**
     * Constructs the minimax game tree by the tenets of alpha-beta pruning with
     * memoization for repeated states.
     * @param   node    The root of the current game sub-tree
     * @param   alpha   Smallest minimax score possible
     * @param   beta    Largest minimax score possible
     * @param   isMax   Boolean representing whether the given node is a max (true) or min (false) node
     * @param   visited Map of GameTreeNodes to their minimax scores to avoid repeating large subtrees
     * @return  Minimax score of the given node + [Side effect] constructs the game tree originating
     *          from the given node
     */
    private int alphaBetaMinimax (GameTreeNode node, int alpha, int beta, boolean isMax, Map<GameTreeNode, Integer> visited) {
    	int v;
    	if(node.remaining == 0) {
    		node.score = isMax ? 0 : 1;
    		return node.score;
    	}
    	int removalCounter = MAX_REMOVAL > node.remaining ? node.remaining : MAX_REMOVAL;
    	if(visited.containsKey(node)) {
    		node.score = visited.get(node);
    		return visited.get(node);
    	}
    	if(isMax) {
    		v = -1;
    		for(int i = 1; i <= removalCounter; i++) {
    			GameTreeNode child = new GameTreeNode(node.remaining - i, i, !node.isMax);
    			node.children.add(child);
    			v = Math.max(v, alphaBetaMinimax(node.children.get(i - 1), alpha, beta, false, visited));
    			alpha = Math.max(alpha, v);
    			if(beta < alpha) {
    				break;
    			}
    		}
    		node.score = v;
    		visited.put(node, v);
    		return v;
    	} else {
    		v = 2;
    		for(int i = 1; i <= removalCounter; i++) {
    			GameTreeNode child = new GameTreeNode(node.remaining - i, i, !node.isMax);
    			node.children.add(child);
    			v = Math.min(v, alphaBetaMinimax(node.children.get(i - 1), alpha, beta, true, visited));
    			beta = Math.min(beta, v);
    			if(beta < alpha) {
    				break;
    			}
    		}
    		node.score = v;
    		visited.put(node, v);
    		return v;
    	}
    }

}

/**
 * GameTreeNode to manage the Nim game tree.
 */
class GameTreeNode {
    
    int remaining, action, score;
    boolean isMax;
    ArrayList<GameTreeNode> children;
    
    /**
     * Constructs a new GameTreeNode with the given number of stones
     * remaining in the pile, and the action that led to it. We also
     * initialize an empty ArrayList of children that can be added-to
     * during search, and a placeholder score of -1 to be updated during
     * search.
     * 
     * @param   remaining   The Nim game state represented by this node: the #
     *          of stones remaining in the pile
     * @param   action  The action (# of stones removed) that led to this node
     * @param   isMax   Boolean as to whether or not this is a maxnode
     */
    GameTreeNode (int remaining, int action, boolean isMax) {
        this.remaining = remaining;
        this.action = action;
        this.isMax = isMax;
        children = new ArrayList<>();
        score = -1;
    }
    
    @Override
    public boolean equals (Object other) {
        return other instanceof GameTreeNode 
            ? remaining == ((GameTreeNode) other).remaining && 
              isMax == ((GameTreeNode) other).isMax &&
              action == ((GameTreeNode) other).action
            : false;
    }
    
    @Override
    public int hashCode () {
        return remaining + ((isMax) ? 1 : 0);
    }
    
}