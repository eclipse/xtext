/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class LexerLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new Model_0_Assignment_children(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Element_0_Group(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Model ****************/


protected class Model_0_Assignment_children extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public Model_0_Assignment_children(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Model_0_Assignment_children(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Model_0_Assignment_children(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("children")) return null;
		value = obj.consume("children");
		AbstractToken t = new Element_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Model_0_Assignment_childrenCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Element
	}
}

/************ end Rule Model ****************/
/************ begin Rule Element ****************/


protected class Element_0_Group extends GroupToken {
	
	public Element_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Element_0_1_Assignment_h(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Element_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Element_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class Element_0_1_Assignment_h extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_0_1_Assignment_h(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_1_Assignment_h(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_1_Assignment_h(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("h")) return null;
		value = obj.consume("h");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_1_Assignment_hCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule Element ****************/
}
