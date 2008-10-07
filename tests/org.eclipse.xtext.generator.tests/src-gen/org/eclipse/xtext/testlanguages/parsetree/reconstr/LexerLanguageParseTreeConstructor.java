/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class LexerLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.getPredecessor().executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if((s = new Model_Assignment_children(inst, null).firstSolution()) != null) return s;
		if((s = new Element_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Model ****************/


protected class Model_Assignment_children extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public Model_Assignment_children(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("children")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("children");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Element")) return null;
		AbstractToken t = new Element_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Model_Assignment_childrenCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Element
	}
}

/************ end Rule Model ****************/
/************ begin Rule Element ****************/


protected class Element_Group extends GroupToken {
	
	public Element_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Element_1_Assignment_h(current, this).firstSolution();
		if(s1 == null) return null;
		return new Element_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Element_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Element_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Element_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class Element_1_Assignment_h extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_1_Assignment_h(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("h")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("h");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_1_Assignment_hCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule Element ****************/
}
