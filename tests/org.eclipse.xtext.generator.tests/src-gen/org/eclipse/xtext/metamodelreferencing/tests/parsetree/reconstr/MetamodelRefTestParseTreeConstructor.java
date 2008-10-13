/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parsetree.reconstr;

//import org.apache.log4j.Logger;
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
		IInstanceDescription inst = getDescr(obj);
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
	
	public Foo_Group(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Foo_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// ( nameRefs += NameRef ) *
protected class Foo_1_Assignment_nameRefs extends AssignmentToken  {
	
	public Foo_1_Assignment_nameRefs(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nameRefs",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nameRefs");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("xtext::RuleCall")) {
				Solution s = new NameRef_Assignment_name(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
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
	
	public NameRef_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@rules.1/@alternatives/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule NameRef ****************/

}
