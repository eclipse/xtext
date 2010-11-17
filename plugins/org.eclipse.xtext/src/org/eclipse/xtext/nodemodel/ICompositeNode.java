package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public interface ICompositeNode extends INode {

	Iterable<INode> getChildren();
	
	TreeIterator<INode> treeIterator();
	
//	int getChildCount();
	
	EObject getSemanticElement();
	
	int getLookAhead();
	
}
