package SimpleTree;

import java.util.*;

class SimpleTreeNode<T> {
	public T NodeValue;
	public SimpleTreeNode<T> Parent;
	public List<SimpleTreeNode<T>> Children;

	public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
		NodeValue = val;
		Parent = parent;
		Children = null;
	}
}

class SimpleTree<T> {
	public SimpleTreeNode<T> Root;

	public SimpleTree(SimpleTreeNode<T> root) {
		Root = root;
	}
	


	public void recNodeAdd(SimpleTreeNode<T> _startNode, SimpleTreeNode<T> _parent, SimpleTreeNode<T> _nodeToAdd) {
		if(_startNode.NodeValue.equals(_parent.NodeValue)) {
			_nodeToAdd.Parent = _startNode;
			if(_startNode.Children == null)
				_startNode.Children = new LinkedList<SimpleTreeNode<T>>();
			_startNode.Children.add(_nodeToAdd);
		}	
		else
		 if(_startNode.Children != null)recListAdd(_startNode.Children, _parent, _nodeToAdd);
		
	}

	public void recListAdd(List<SimpleTreeNode<T>> list, SimpleTreeNode<T> _parent, SimpleTreeNode<T> _nodeToAdd) {
		for(int i = 0; i < list.size(); i++) {
			recNodeAdd(list.get(i), _parent, _nodeToAdd);
		}
	}
	
	
	public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
		if (Root == null) {
			Root = NewChild;
			NewChild.Parent = null;
		} else {
			recNodeAdd(Root, ParentNode, NewChild);	
		}
	}
	
	public void recNodeDelete(SimpleTreeNode<T> _startNode,  SimpleTreeNode<T> _nodeToRemove) {
		 if(_startNode.Children != null)
			 recListDelete(_startNode.Children,  _nodeToRemove);
		
	}

	public void recListDelete(List<SimpleTreeNode<T>> list, SimpleTreeNode<T> _nodeToRemove) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).NodeValue.equals(_nodeToRemove.NodeValue)) {
				list.remove(i);
				return;
			}
			recNodeDelete(list.get(i), _nodeToRemove);
		}
	}

	public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
		if(NodeToDelete.NodeValue.equals(Root))return;
		recNodeDelete(Root, NodeToDelete);
	}
	
	
	public void recNodeFindBy(SimpleTreeNode<T> _startNode,  T val, List<SimpleTreeNode<T>> _listToAdd) {
		if(_startNode.NodeValue.equals(val) && _startNode.Children != null) {
			for(int i = 0; i < _startNode.Children.size(); i++)
				_listToAdd.add(_startNode.Children.get(i));
		}
		 if(_startNode.Children != null)
			 recListFindBy(_startNode, _startNode.Children,  val, _listToAdd);
	}

	public void recListFindBy(SimpleTreeNode<T> _startNode, List<SimpleTreeNode<T>> list, T val, List<SimpleTreeNode<T>> _listToAdd) {
		for(int i = 0; i < list.size(); i++) 
			recNodeFindBy(list.get(i), val, _listToAdd);
	}
	
	
	public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
		List<SimpleTreeNode<T>> res = new LinkedList<SimpleTreeNode<T>>();
		recNodeFindBy(Root, val, res);
		if(res.size() == 0)return null;
		return res;
	}
	
	
	public void recNodeFindAll(SimpleTreeNode<T> _startNode,   List<SimpleTreeNode<T>> _listToAdd) {
		 _listToAdd.add(_startNode);
		 if(_startNode.Children != null)
			 recListFindAll(_startNode.Children, _listToAdd);
	}

	public void recListFindAll(List<SimpleTreeNode<T>> list,  List<SimpleTreeNode<T>> _listToAdd) {
		for(int i = 0; i < list.size(); i++) 
			recNodeFindAll(list.get(i), _listToAdd);
	}
	
	

	public List<SimpleTreeNode<T>> GetAllNodes() {
		List<SimpleTreeNode<T>> res = new LinkedList<SimpleTreeNode<T>>();
		recNodeFindAll(Root, res);
		return res;
	}

	public SimpleTreeNode<T> copyChildren(SimpleTreeNode<T> startNode, List<SimpleTreeNode<T>> list,
			SimpleTreeNode<T> searchingNode) {
		for (int i = 0; i < list.size(); i++) {
			SimpleTreeNode<T> res = list.get(i);
			if (res.NodeValue.equals(searchingNode.NodeValue))
				return res;
			if (res.Children != null)
				copyChildren(res, res.Children, searchingNode);

		}
		return null;
	}

	public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
		SimpleTreeNode<T> tmp = new SimpleTreeNode(OriginalNode.NodeValue, null);
		tmp = copyChildren(Root, Root.Children, OriginalNode);
		DeleteNode(OriginalNode);
		AddChild(NewParent, tmp);
		
	//	
	}

	public int Count() {

		return 0;
	}

	public int LeafCount() {

		return 0;
	}
}