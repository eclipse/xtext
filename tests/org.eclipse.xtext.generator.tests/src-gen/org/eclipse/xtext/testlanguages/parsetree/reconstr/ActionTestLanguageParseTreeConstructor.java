/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class ActionTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

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
		t = new Element_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Item_1_Group(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Model ****************/


protected class Model_0_Assignment_children extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.0/@alternatives/@terminal");
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
		AbstractToken t = new Element_1_Group(predecessor);
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


protected class Element_1_Group extends GroupToken {
	
	public Element_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Element_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Element_1_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_1_0_RuleCall extends RuleCallToken {
	
	public Element_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Item_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_1_1_Group extends GroupToken {
	
	public Element_1_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Element_1_1_1_Assignment_items(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Element_1_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_1_1_0_Action extends AssignmentToken  {

	public Element_1_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_1_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_1_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("items")) return null;
		Object val = obj.consume("items");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_1_1_1_Assignment_items extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_1_1_1_Assignment_items(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_1_1_1_Assignment_items(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_1_1_1_Assignment_items(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("items")) return null;
		value = obj.consume("items");
		AbstractToken t = new Item_1_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_1_1_1_Assignment_itemsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Item
	}
}



/************ end Rule Element ****************/
/************ begin Rule Item ****************/


protected class Item_1_Group extends GroupToken {
	
	public Item_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Item_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Item_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Item_1_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Item_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Item_1_0_Action extends AssignmentToken  {

	public Item_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Item_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Item_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("content")) return null;
		Object val = obj.consume("content");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Item_1_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Item_1_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Item_1_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Item_1_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Item_1_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule Item ****************/
}
