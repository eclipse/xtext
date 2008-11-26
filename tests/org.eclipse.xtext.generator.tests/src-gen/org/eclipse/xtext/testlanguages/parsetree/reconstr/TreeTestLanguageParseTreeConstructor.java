/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class TreeTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new Model_Assignment_children(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Node") && (s = new Node_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Model ****************
 *
 * Model : ( children += Node ) * ;
 *
 **/


// ( children += Node ) *
protected class Model_Assignment_children extends AssignmentToken  {
	
	public Model_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.0/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("children",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Node")) {
				Solution s = new Node_Group(param, this).firstSolution();
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
 * Node : name = ID '(' attrib = STRING ')' '{' ( children += Node ) * '};' ;
 *
 **/


// name = ID '(' attrib = STRING ')' '{' ( children += Node ) * '};'
protected class Node_Group extends GroupToken {
	
	public Node_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Node_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID '(' attrib = STRING ')' '{' ( children += Node ) *
protected class Node_0_Group extends GroupToken {
	
	public Node_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Node_0_1_Assignment_children(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID '(' attrib = STRING ')' '{'
protected class Node_0_0_Group extends GroupToken {
	
	public Node_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID '(' attrib = STRING ')'
protected class Node_0_0_0_Group extends GroupToken {
	
	public Node_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID '(' attrib = STRING
protected class Node_0_0_0_0_Group extends GroupToken {
	
	public Node_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_0_0_1_Assignment_attrib(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID '('
protected class Node_0_0_0_0_0_Group extends GroupToken {
	
	public Node_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Node_0_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Node_0_0_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID
protected class Node_0_0_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public Node_0_0_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// '('
protected class Node_0_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public Node_0_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// attrib = STRING
protected class Node_0_0_0_0_1_Assignment_attrib extends AssignmentToken  {
	
	public Node_0_0_0_0_1_Assignment_attrib(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("attrib",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("attrib");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ')'
protected class Node_0_0_0_1_Keyword extends KeywordToken  {
	
	public Node_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// '{'
protected class Node_0_0_1_Keyword extends KeywordToken  {
	
	public Node_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( children += Node ) *
protected class Node_0_1_Assignment_children extends AssignmentToken  {
	
	public Node_0_1_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("children",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Node")) {
				Solution s = new Node_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// '};'
protected class Node_1_Keyword extends KeywordToken  {
	
	public Node_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Node ****************/

}
