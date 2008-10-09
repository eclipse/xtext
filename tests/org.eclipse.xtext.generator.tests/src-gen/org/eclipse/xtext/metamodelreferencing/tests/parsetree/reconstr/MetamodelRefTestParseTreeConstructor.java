/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class MetamodelRefTestParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Foo") && (s = new Foo_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("xtext::RuleCall") && (s = new NameRef_Assignment_name(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Foo ****************
 *
 * Foo : name = ID ( nameRefs += NameRef ) * ;
 *
 **/


// name = ID ( nameRefs += NameRef ) *
protected class Foo_Group extends GroupToken {
	
	public Foo_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Foo_1_Assignment_nameRefs(current, this).firstSolution();
		if(s1 == null) return null;
		return new Foo_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// name = ID
protected class Foo_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Foo_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Foo_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

// ( nameRefs += NameRef ) *
protected class Foo_1_Assignment_nameRefs extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Foo_1_Assignment_nameRefs(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("nameRefs")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("nameRefs");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("xtext::RuleCall")) return null;
		AbstractToken t = new NameRef_Assignment_name(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Foo_1_Assignment_nameRefsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call NameRef
	}
}


/************ end Rule Foo ****************/

/************ begin Rule NameRef ****************
 *
 * NameRef returns xtext :: RuleCall : name = STRING ;
 *
 **/


// name = STRING
protected class NameRef_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.1/@alternatives/@terminal");
	protected Object value;
	
	public NameRef_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("NameRef_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

/************ end Rule NameRef ****************/

}
