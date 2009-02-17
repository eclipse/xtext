/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.testlanguages.services.LexerTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class LexerTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private LexerTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf(grammarAccess.prModel().getRule().getType().getType()) && (s = new Model_Assignment_children(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prElement().getRule().getType().getType()) && (s = new Element_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Model ****************
 *
 * Model:   (children+=Element)*;
 *
 **/


// (children+=Element)*
protected class Model_Assignment_children extends AssignmentToken  {
	
	public Model_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prModel().eleAssignmentChildren();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("children",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prElement().getRule().getType().getType())) {
				Solution s = new Element_Group(param, this).firstSolution();
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

/************ end Rule Model ****************/


/************ begin Rule Element ****************
 *
 * Element:   name=ID h=STRING;
 *
 **/


// name=ID h=STRING
protected class Element_Group extends GroupToken {
	
	public Element_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prElement().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Element_1_Assignment_h(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Element_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID
protected class Element_0_Assignment_name extends AssignmentToken  {
	
	public Element_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prElement().ele0AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prElement().ele00LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// h=STRING
protected class Element_1_Assignment_h extends AssignmentToken  {
	
	public Element_1_Assignment_h(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prElement().ele1AssignmentH();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("h",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("h");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prElement().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Element ****************/

}
