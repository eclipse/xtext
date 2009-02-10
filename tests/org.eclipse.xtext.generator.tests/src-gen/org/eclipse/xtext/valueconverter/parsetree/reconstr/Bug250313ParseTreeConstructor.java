/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;


public class Bug250313ParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Ref2") && (s = new Ref2_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Ref2 ****************
 *
 * Ref2:   "#2" ref2=("mykeyword1"|STRING|ID);
 *
 **/


// "#2" ref2=("mykeyword1"|STRING|ID)
protected class Ref2_Group extends GroupToken {
	
	public Ref2_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prRef2().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Ref2_1_Assignment_ref2(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Ref2_0_Keyword_2(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#2"
protected class Ref2_0_Keyword_2 extends KeywordToken  {
	
	public Ref2_0_Keyword_2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prRef2().ele0KeywordNumberSignDigitTwo();
	}	
}

// ref2=("mykeyword1"|STRING|ID)
protected class Ref2_1_Assignment_ref2 extends AssignmentToken  {
	
	public Ref2_1_Assignment_ref2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prRef2().ele1AssignmentRef2();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ref2",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ref2");

		if("mykeyword1".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = Bug250313GrammarAccess.INSTANCE.prRef2().ele1000KeywordMykeyword1();
			return new Solution(obj);
		}

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = Bug250313GrammarAccess.INSTANCE.prRef2().ele1001LexerRuleCallSTRING();
			return new Solution(obj);
		}
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = Bug250313GrammarAccess.INSTANCE.prRef2().ele101LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Ref2 ****************/

}
