/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class ActionTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

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
		if((s = new Item_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Model ****************/


protected class Model_Assignment_children extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.0/@alternatives/@terminal");
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
		if(!param.isInstanceOf("Type")) return null;
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
		Solution s1 = new Element_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Element_0_RuleCall_Item(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Element_0_RuleCall_Item extends RuleCallToken {
	
	public Element_0_RuleCall_Item(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Item_Group.class, current)) return null;
		if(!current.isInstanceOf("Type")) return null;
		return new Item_Group(current, this).firstSolution();
	}
}

protected class Element_1_Group extends GroupToken {
	
	public Element_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Element_1_1_Assignment_items(current, this).firstSolution();
		if(s1 == null) return null;
		return new Element_1_0_Action_Item_items(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Element_1_0_Action_Item_items extends AssignmentToken  {

	public Element_1_0_Action_Item_items(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Item")) return null;
		if(!current.isConsumable("items")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("items");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}

protected class Element_1_1_Assignment_items extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_1_1_Assignment_items(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("items")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("items");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Type")) return null;
		AbstractToken t = new Item_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_1_1_Assignment_itemsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Item
	}
}



/************ end Rule Element ****************/
/************ begin Rule Item ****************/


protected class Item_Group extends GroupToken {
	
	public Item_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Item_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Item_0_Action_Thing_content(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Item_0_Action_Thing_content extends AssignmentToken  {

	public Item_0_Action_Thing_content(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Thing")) return null;
		if(!current.isConsumable("content")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("content");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}

protected class Item_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Item_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Item_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule Item ****************/
}
