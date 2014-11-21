/**ADT interface for binary tree node*/
public interface BinNode<E>{

/**get and set the element*/
public E element();
public void setElement(E val);

/**@return the left child*/
public BinNode<E> left();

/**@return the right child*/
public BinNode<E> right();

/**@return True if a leaf node, false otherwise*/
public boolean isLeaf();
}
