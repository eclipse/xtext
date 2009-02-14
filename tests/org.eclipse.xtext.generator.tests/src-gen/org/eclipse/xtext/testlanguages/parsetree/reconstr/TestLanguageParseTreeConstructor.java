/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;

import com.google.inject.Inject;

public class TestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private TestLanguageGrammarAccess grammarAccess;
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new EntryRule_Assignment_multiFeature(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new AbstractRule_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ChoiceElement") && (s = new ChoiceRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ReducibleElement") && (s = new ReducibleRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TerminalElement") && (s = new TerminalRule_Assignment_stringFeature(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule EntryRule ****************
 *
 * EntryRule returns Model:   (multiFeature+=AbstractRule)*;
 *
 **/


// (multiFeature+=AbstractRule)*
protected class EntryRule_Assignment_multiFeature extends AssignmentToken  {
	
	public EntryRule_Assignment_multiFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prEntryRule().eleAssignmentMultiFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("multiFeature",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("multiFeature");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new AbstractRule_Alternatives(param, this).firstSolution();
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

/************ end Rule EntryRule ****************/


/************ begin Rule AbstractRule ****************
 *
 * AbstractRule returns AbstractElement:   ChoiceRule|ReducibleRule;
 *
 **/


// ChoiceRule|ReducibleRule
protected class AbstractRule_Alternatives extends AlternativesToken {

	public AbstractRule_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return grammarAccess.prAbstractRule().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractRule_1_RuleCall_ReducibleRule(current, this) : new AbstractRule_0_RuleCall_ChoiceRule(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ChoiceRule
protected class AbstractRule_0_RuleCall_ChoiceRule extends RuleCallToken {
	
	public AbstractRule_0_RuleCall_ChoiceRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return grammarAccess.prAbstractRule().ele0ParserRuleCallChoiceRule();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ChoiceRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ChoiceElement")) return null;
		return new ChoiceRule_Group(current, this).firstSolution();
	}
}

// ReducibleRule
protected class AbstractRule_1_RuleCall_ReducibleRule extends RuleCallToken {
	
	public AbstractRule_1_RuleCall_ReducibleRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return grammarAccess.prAbstractRule().ele1ParserRuleCallReducibleRule();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ReducibleRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ReducibleElement")) return null;
		return new ReducibleRule_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractRule ****************/


/************ begin Rule ChoiceRule ****************
 *
 * ChoiceRule returns ChoiceElement:   "choice" (optionalKeyword?="optional")? name=ID;
 *
 **/


// "choice" (optionalKeyword?="optional")? name=ID
protected class ChoiceRule_Group extends GroupToken {
	
	public ChoiceRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prChoiceRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ChoiceRule_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ChoiceRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "choice" (optionalKeyword?="optional")?
protected class ChoiceRule_0_Group extends GroupToken {
	
	public ChoiceRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prChoiceRule().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ChoiceRule_0_1_Assignment_optionalKeyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ChoiceRule_0_0_Keyword_choice(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "choice"
protected class ChoiceRule_0_0_Keyword_choice extends KeywordToken  {
	
	public ChoiceRule_0_0_Keyword_choice(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prChoiceRule().ele00KeywordChoice();
	}	
}

// (optionalKeyword?="optional")?
protected class ChoiceRule_0_1_Assignment_optionalKeyword extends AssignmentToken  {
	
	public ChoiceRule_0_1_Assignment_optionalKeyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prChoiceRule().ele01AssignmentOptionalKeyword();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("optionalKeyword",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("optionalKeyword");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prChoiceRule().ele010KeywordOptional();
			return new Solution(obj);
		}

		return null;
	}
}


// name=ID
protected class ChoiceRule_1_Assignment_name extends AssignmentToken  {
	
	public ChoiceRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prChoiceRule().ele1AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prChoiceRule().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule ChoiceRule ****************/


/************ begin Rule ReducibleRule ****************
 *
 * ReducibleRule returns ReducibleElement:   "reducible" TerminalRule ({current=ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule)?;
 *
 **/


// "reducible" TerminalRule ({current=ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule)?
protected class ReducibleRule_Group extends GroupToken {
	
	public ReducibleRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prReducibleRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ReducibleRule_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReducibleRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "reducible" TerminalRule
protected class ReducibleRule_0_Group extends GroupToken {
	
	public ReducibleRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prReducibleRule().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ReducibleRule_0_1_RuleCall_TerminalRule(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReducibleRule_0_0_Keyword_reducible(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "reducible"
protected class ReducibleRule_0_0_Keyword_reducible extends KeywordToken  {
	
	public ReducibleRule_0_0_Keyword_reducible(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prReducibleRule().ele00KeywordReducible();
	}	
}

// TerminalRule
protected class ReducibleRule_0_1_RuleCall_TerminalRule extends RuleCallToken {
	
	public ReducibleRule_0_1_RuleCall_TerminalRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return grammarAccess.prReducibleRule().ele01ParserRuleCallTerminalRule();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(TerminalRule_Assignment_stringFeature.class, current)) return null;
		if(!current.isInstanceOf("TerminalElement")) return null;
		return new TerminalRule_Assignment_stringFeature(current, this).firstSolution();
	}
}


// ({current=ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule)?
protected class ReducibleRule_1_Group extends GroupToken {
	
	public ReducibleRule_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prReducibleRule().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ReducibleRule_1_1_Assignment_actionFeature(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReducibleRule_1_0_Action_ReducibleComposite_actionFeature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// {current=ReducibleComposite.actionFeature+=current}
protected class ReducibleRule_1_0_Action_ReducibleComposite_actionFeature extends ActionToken  {

	public ReducibleRule_1_0_Action_ReducibleComposite_actionFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return grammarAccess.prReducibleRule().ele10ActionReducibleCompositeactionFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if(!current.isInstanceOf("ReducibleComposite")) return null;
		Object val = current.getConsumable("actionFeature", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("actionFeature")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// actionFeature+=TerminalRule
protected class ReducibleRule_1_1_Assignment_actionFeature extends AssignmentToken  {
	
	public ReducibleRule_1_1_Assignment_actionFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prReducibleRule().ele11AssignmentActionFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("actionFeature",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("actionFeature");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TerminalElement")) {
				Solution s = new TerminalRule_Assignment_stringFeature(param, this).firstSolution();
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



/************ end Rule ReducibleRule ****************/


/************ begin Rule TerminalRule ****************
 *
 * TerminalRule returns TerminalElement:   stringFeature=STRING;
 *
 **/


// stringFeature=STRING
protected class TerminalRule_Assignment_stringFeature extends AssignmentToken  {
	
	public TerminalRule_Assignment_stringFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prTerminalRule().eleAssignmentStringFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("stringFeature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("stringFeature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prTerminalRule().ele0LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule TerminalRule ****************/

}
