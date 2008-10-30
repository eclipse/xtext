/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class DummyLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new Model_Assignment_elements(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Element") && (s = new Element_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Model ****************
 *
 * Model : ( elements += Element ) * ;
 *
 **/


// ( elements += Element ) *
protected class Model_Assignment_elements extends AssignmentToken  {
	
	public Model_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.0/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Element")) {
				Solution s = new Element_Group(param, this).firstSolution();
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

/************ begin Rule Element ****************
 *
 * Element : ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) * ';' ;
 *
 **/


// ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) * ';'
protected class Element_Group extends GroupToken {
	
	public Element_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Element_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Element_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) *
protected class Element_0_Group extends GroupToken {
	
	public Element_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Element_0_1_Assignment_descriptions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Element_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( optional ?= 'optional' ) ? 'element' name = ID
protected class Element_0_0_Group extends GroupToken {
	
	public Element_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Element_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Element_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( optional ?= 'optional' ) ? 'element'
protected class Element_0_0_0_Group extends GroupToken {
	
	public Element_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Element_0_0_0_1_Keyword_element(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Element_0_0_0_0_Assignment_optional(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( optional ?= 'optional' ) ?
protected class Element_0_0_0_0_Assignment_optional extends AssignmentToken  {
	
	public Element_0_0_0_0_Assignment_optional(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("optional",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("optional");
		if("optional".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
			return new Solution(obj);
		}
		return null;
	}
}

// 'element'
protected class Element_0_0_0_1_Keyword_element extends KeywordToken  {
	
	public Element_0_0_0_1_Keyword_element(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// name = ID
protected class Element_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Element_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( descriptions += STRING ) *
protected class Element_0_1_Assignment_descriptions extends AssignmentToken  {
	
	public Element_0_1_Assignment_descriptions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("descriptions",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("descriptions");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ';'
protected class Element_1_Keyword extends KeywordToken  {
	
	public Element_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Element ****************/

}
