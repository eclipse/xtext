/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class ConcreteTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		callback.beginSerialize();
		t.getPredecessor().executeAllCallbacks(callback);
		callback.endSerialize();
		System.out.println("success!");
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if((s = new ConcreteParserRule_Group(inst, null).firstSolution()) != null) return s;
		if((s = new InheritedParserRule_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule ConcreteParserRule ****************/


protected class ConcreteParserRule_Group extends GroupToken {
	
	public ConcreteParserRule_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ConcreteParserRule_1_Assignment_elements(current, this).firstSolution();
		if(s1 == null) return null;
		return new ConcreteParserRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class ConcreteParserRule_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ConcreteParserRule_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new ConcreteParserRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class ConcreteParserRule_0_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ConcreteParserRule_0_0_1_Assignment_magicNumber(current, this).firstSolution();
		if(s1 == null) return null;
		return new ConcreteParserRule_0_0_0_Keyword_model(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}


protected class ConcreteParserRule_0_0_0_Keyword_model extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public ConcreteParserRule_0_0_0_Keyword_model(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

protected class ConcreteParserRule_0_0_1_Assignment_magicNumber extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ConcreteParserRule_0_0_1_Assignment_magicNumber(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("magicNumber")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("magicNumber");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ConcreteParserRule_0_0_1_Assignment_magicNumberCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



protected class ConcreteParserRule_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public ConcreteParserRule_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


protected class ConcreteParserRule_1_Assignment_elements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ConcreteParserRule_1_Assignment_elements(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("elements")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("elements");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("mm::AType")) return null;
		AbstractToken t = new InheritedParserRule_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ConcreteParserRule_1_Assignment_elementsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call InheritedParserRule
	}
}


/************ end Rule ConcreteParserRule ****************/
/************ begin Rule InheritedParserRule ****************/


protected class InheritedParserRule_Group extends GroupToken {
	
	public InheritedParserRule_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new InheritedParserRule_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new InheritedParserRule_0_Keyword_element(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}


protected class InheritedParserRule_0_Keyword_element extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	
	public InheritedParserRule_0_Keyword_element(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

protected class InheritedParserRule_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public InheritedParserRule_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("InheritedParserRule_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule InheritedParserRule ****************/
}
