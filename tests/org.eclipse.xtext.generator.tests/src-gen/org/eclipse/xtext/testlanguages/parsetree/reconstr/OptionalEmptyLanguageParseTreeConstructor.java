/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class OptionalEmptyLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

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
		if((s = new Model_Assignment_child(inst, null).firstSolution()) != null) return s;
		if((s = new Greeting_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Model ****************/


protected class Model_Assignment_child extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public Model_Assignment_child(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("child")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("child");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Greeting")) return null;
		AbstractToken t = new Greeting_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Model_Assignment_childCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Greeting
	}
}

/************ end Rule Model ****************/
/************ begin Rule Greeting ****************/


protected class Greeting_Group extends GroupToken {
	
	public Greeting_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Greeting_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Greeting_0_Keyword_hallo(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}


protected class Greeting_0_Keyword_hallo extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	
	public Greeting_0_Keyword_hallo(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

protected class Greeting_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Greeting_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Greeting_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule Greeting ****************/
}
