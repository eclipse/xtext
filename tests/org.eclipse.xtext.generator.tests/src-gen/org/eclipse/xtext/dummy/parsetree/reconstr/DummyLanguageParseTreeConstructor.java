/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class DummyLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public Model_Assignment_elements(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("elements")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("elements");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Element")) return null;
		AbstractToken t = new Element_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Model_Assignment_elementsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Element
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
	
	public Element_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Element_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Element_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) *
protected class Element_0_Group extends GroupToken {
	
	public Element_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Element_0_1_Assignment_descriptions(current, this).firstSolution();
		if(s1 == null) return null;
		return new Element_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( optional ?= 'optional' ) ? 'element' name = ID
protected class Element_0_0_Group extends GroupToken {
	
	public Element_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Element_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Element_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( optional ?= 'optional' ) ? 'element'
protected class Element_0_0_0_Group extends GroupToken {
	
	public Element_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Element_0_0_0_1_Keyword_element(current, this).firstSolution();
		if(s1 == null) return null;
		return new Element_0_0_0_0_Assignment_optional(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( optional ?= 'optional' ) ?
protected class Element_0_0_0_0_Assignment_optional extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Element_0_0_0_0_Assignment_optional(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("optional")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("optional");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_0_0_0_Assignment_optionalCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}

// 'element'
protected class Element_0_0_0_1_Keyword_element extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Element_0_0_0_1_Keyword_element(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// name = ID
protected class Element_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("name")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("name");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ( descriptions += STRING ) *
protected class Element_0_1_Assignment_descriptions extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_0_1_Assignment_descriptions(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("descriptions")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("descriptions");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_1_Assignment_descriptionsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ';'
protected class Element_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1");
	
	public Element_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule Element ****************/

}
