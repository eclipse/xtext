/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class MetamodelRefTestParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new Foo_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new NameRef_1_Assignment_name(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Foo ****************/


protected class Foo_0_Group extends GroupToken {
	
	public Foo_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Foo_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Foo_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Foo_0_1_Assignment_nameRefs(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Foo_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Foo_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Foo_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Foo_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Foo_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Foo_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class Foo_0_1_Assignment_nameRefs extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Foo_0_1_Assignment_nameRefs(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Foo_0_1_Assignment_nameRefs(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Foo_0_1_Assignment_nameRefs(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("nameRefs")) return null;
		value = obj.consume("nameRefs");
		AbstractToken t = new NameRef_1_Assignment_name(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Foo_0_1_Assignment_nameRefsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call NameRef
	}
}


/************ end Rule Foo ****************/
/************ begin Rule NameRef ****************/


protected class NameRef_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.1/@alternatives/@terminal");
	protected Object value;
	
	public NameRef_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private NameRef_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new NameRef_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("NameRef_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

/************ end Rule NameRef ****************/
}
