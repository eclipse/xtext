/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class TreeTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private TreeTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf(grammarAccess.prModel().getRule().getType().getType()) && (s = new Model_Assignment_children(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prNode().getRule().getType().getType()) && (s = new Node_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Model ****************
 *
 * Model:   (children+=Node)*;
 *
 **/


// (children+=Node)*
protected class Model_Assignment_children extends AssignmentToken  {
	
	public Model_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prModel().eleAssignmentChildren();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("children",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prNode().getRule().getType().getType())) {
				Solution s = new Node_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

/************ end Rule Model ****************/


/************ begin Rule Node ****************
 *
 * Node:   name=ID "(" attrib=STRING ")" "{" (children+=Node)* "};";
 *
 **/


// name=ID "(" attrib=STRING ")" "{" (children+=Node)* "};"
protected class Node_Group extends GroupToken {
	
	public Node_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prNode().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Node_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name=ID "(" attrib=STRING ")" "{" (children+=Node)*
protected class Node_0_Group extends GroupToken {
	
	public Node_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prNode().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Node_0_1_Assignment_children(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name=ID "(" attrib=STRING ")" "{"
protected class Node_0_0_Group extends GroupToken {
	
	public Node_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prNode().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name=ID "(" attrib=STRING ")"
protected class Node_0_0_0_Group extends GroupToken {
	
	public Node_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prNode().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name=ID "(" attrib=STRING
protected class Node_0_0_0_0_Group extends GroupToken {
	
	public Node_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prNode().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_0_0_1_Assignment_attrib(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name=ID "("
protected class Node_0_0_0_0_0_Group extends GroupToken {
	
	public Node_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prNode().ele00000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name=ID
protected class Node_0_0_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public Node_0_0_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prNode().ele000000AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prNode().ele0000000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "("
protected class Node_0_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public Node_0_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prNode().ele000001KeywordLeftParenthesis();
	}	
}


// attrib=STRING
protected class Node_0_0_0_0_1_Assignment_attrib extends AssignmentToken  {
	
	public Node_0_0_0_0_1_Assignment_attrib(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prNode().ele00001AssignmentAttrib();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("attrib",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("attrib");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prNode().ele000010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// ")"
protected class Node_0_0_0_1_Keyword extends KeywordToken  {
	
	public Node_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prNode().ele0001KeywordRightParenthesis();
	}	
}


// "{"
protected class Node_0_0_1_Keyword extends KeywordToken  {
	
	public Node_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prNode().ele001KeywordLeftCurlyBracket();
	}	
}


// (children+=Node)*
protected class Node_0_1_Assignment_children extends AssignmentToken  {
	
	public Node_0_1_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prNode().ele01AssignmentChildren();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("children",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prNode().getRule().getType().getType())) {
				Solution s = new Node_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// "};"
protected class Node_1_Keyword extends KeywordToken  {
	
	public Node_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prNode().ele1KeywordRightCurlyBracketSemicolon();
	}	
}


/************ end Rule Node ****************/

}
