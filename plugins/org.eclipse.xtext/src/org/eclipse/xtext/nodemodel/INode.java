package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessage;

public interface INode extends TreeIterable<INode> {

	int ROOT = 1 << 0;
	int COMPOSITE = 1 << 1;
	int LEAF = 1 << 2;
	int SYNTAX_ERROR = 1 << 3;
	int SEMANTIC_MODEL_REFERENCE = 1 << 4;
	int HIDDEN = 1 << 5;
	int SYNTHETIC_COMPOSITE = 1 << 6;
	
	ICompositeNode getParent();
	
	int getTotalOffset();
	
	int getTotalLength();
	
	String getText();
	
	EObject getGrammarElement();
		
	SyntaxErrorMessage getSyntaxErrorMessage();
	
	int getNodeType();
	
}
