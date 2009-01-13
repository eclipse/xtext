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
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;


public class MetamodelRefTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Foo") && (s = new Foo_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("RuleCall") && (s = new NameRef_Assignment_rule(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ParserRule") && (s = new MyRule_Assignment_name(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
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
	
	public Group getGrammarElement() {
		return MetamodelRefTestLanguageGrammarAccess.INSTANCE.prFoo().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Foo_1_Assignment_nameRefs(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Foo_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID
protected class Foo_0_Assignment_name extends AssignmentToken  {
	
	public Foo_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return MetamodelRefTestLanguageGrammarAccess.INSTANCE.prFoo().ele0AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = MetamodelRefTestLanguageGrammarAccess.INSTANCE.prFoo().ele00LexerRuleCallID();
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
	
	public Assignment getGrammarElement() {
		return MetamodelRefTestLanguageGrammarAccess.INSTANCE.prFoo().ele1AssignmentNameRefs();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nameRefs",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nameRefs");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("RuleCall")) {
				Solution s = new NameRef_Assignment_rule(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
 * NameRef returns RuleCall : rule = [ ParserRule ] ;
 *
 **/


// rule = [ ParserRule ]
protected class NameRef_Assignment_rule extends AssignmentToken  {
	
	public NameRef_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return MetamodelRefTestLanguageGrammarAccess.INSTANCE.prNameRef().eleAssignmentRule();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ParserRule")) {
				type = AssignmentType.CR;
				element = MetamodelRefTestLanguageGrammarAccess.INSTANCE.prNameRef().ele0CrossReferenceEStringParserRule(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

/************ end Rule NameRef ****************/


/************ begin Rule MyRule ****************
 *
 * MyRule returns ParserRule : name = ID ;
 *
 **/


// name = ID
protected class MyRule_Assignment_name extends AssignmentToken  {
	
	public MyRule_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return MetamodelRefTestLanguageGrammarAccess.INSTANCE.prMyRule().eleAssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = MetamodelRefTestLanguageGrammarAccess.INSTANCE.prMyRule().ele0LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule MyRule ****************/

}
