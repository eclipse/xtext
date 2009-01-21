/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.core.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.ui.core.services.TestLanguageGrammarAccess;


public class TestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("File") && (s = new File_Assignment_stuff(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Stuff") && (s = new Stuff_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule File ****************
 *
 * File : ( stuff += Stuff ) * ;
 *
 **/


// ( stuff += Stuff ) *
protected class File_Assignment_stuff extends AssignmentToken  {
	
	public File_Assignment_stuff(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TestLanguageGrammarAccess.INSTANCE.prFile().eleAssignmentStuff();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("stuff",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("stuff");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Stuff")) {
				Solution s = new Stuff_Group(param, this).firstSolution();
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

/************ end Rule File ****************/


/************ begin Rule Stuff ****************
 *
 * Stuff : "stuff" name = ID ;
 *
 **/


// "stuff" name = ID
protected class Stuff_Group extends GroupToken {
	
	public Stuff_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TestLanguageGrammarAccess.INSTANCE.prStuff().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Stuff_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Stuff_0_Keyword_stuff(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "stuff"
protected class Stuff_0_Keyword_stuff extends KeywordToken  {
	
	public Stuff_0_Keyword_stuff(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return TestLanguageGrammarAccess.INSTANCE.prStuff().ele0KeywordStuff();
	}	
}

// name = ID
protected class Stuff_1_Assignment_name extends AssignmentToken  {
	
	public Stuff_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TestLanguageGrammarAccess.INSTANCE.prStuff().ele1AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = TestLanguageGrammarAccess.INSTANCE.prStuff().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Stuff ****************/

}
