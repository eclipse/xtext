/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class SimpleReconstrTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private SimpleReconstrTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf(grammarAccess.prOp().getRule().getType().getType()) && (s = new Op_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prTerm().getRule().getType().getType()) && (s = new Term_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prAtom().getRule().getType().getType()) && (s = new Atom_Assignment_name(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prParens().getRule().getType().getType()) && (s = new Parens_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prTwoNumbers().getRule().getType().getType()) && (s = new TwoNumbers_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prManyStrings().getRule().getType().getType()) && (s = new ManyStrings_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prType().getRule().getType().getType()) && (s = new Type_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prRef2().getRule().getType().getType()) && (s = new Ref2_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prSpare().getRule().getType().getType()) && (s = new Spare_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prBoolean().getRule().getType().getType()) && (s = new Boolean_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Op ****************
 *
 * Op returns Expression:   Term ({current=Op.values+=current} values+=Term)*;
 *
 **/


// Term ({current=Op.values+=current} values+=Term)*
protected class Op_Group extends GroupToken {
	
	public Op_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prOp().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Op_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_0_RuleCall_Term(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// Term
protected class Op_0_RuleCall_Term extends RuleCallToken {
	
	public Op_0_RuleCall_Term(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prOp().ele0ParserRuleCallTerm();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Term_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prTerm().getRule().getType().getType())) return null;
		return new Term_Alternatives(current, this).firstSolution();
	}
}

// ({current=Op.values+=current} values+=Term)*
protected class Op_1_Group extends GroupToken {
	
	public Op_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prOp().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Op_1_1_Assignment_values(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_0_Action_Op_values(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// {current=Op.values+=current}
protected class Op_1_0_Action_Op_values extends ActionToken  {

	public Op_1_0_Action_Op_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.prOp().ele10ActionOpvalues();
	}
	
	@Override
	protected Solution createSolution() {
		if(!current.isInstanceOf(grammarAccess.prOp().ele10ActionOpvalues().getTypeName().getType())) return null;
		Object val = current.getConsumable("values", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("values")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// values+=Term
protected class Op_1_1_Assignment_values extends AssignmentToken  {
	
	public Op_1_1_Assignment_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prOp().ele11AssignmentValues();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("values",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("values");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prTerm().getRule().getType().getType())) {
				Solution s = new Term_Alternatives(param, this).firstSolution();
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



/************ end Rule Op ****************/


/************ begin Rule Term ****************
 *
 * Term returns Expression:   Atom|TwoNumbers|ManyStrings|Parens|Type|Ref2|Spare|Boolean;
 *
 **/


// Atom|TwoNumbers|ManyStrings|Parens|Type|Ref2|Spare|Boolean
protected class Term_Alternatives extends AlternativesToken {

	public Term_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prTerm().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_1_RuleCall_Boolean(current, this) : new Term_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom|TwoNumbers|ManyStrings|Parens|Type|Ref2|Spare
protected class Term_0_Alternatives extends AlternativesToken {

	public Term_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prTerm().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_1_RuleCall_Spare(current, this) : new Term_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom|TwoNumbers|ManyStrings|Parens|Type|Ref2
protected class Term_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prTerm().ele00Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_1_RuleCall_Ref2(current, this) : new Term_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom|TwoNumbers|ManyStrings|Parens|Type
protected class Term_0_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prTerm().ele000Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_0_1_RuleCall_Type(current, this) : new Term_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom|TwoNumbers|ManyStrings|Parens
protected class Term_0_0_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prTerm().ele0000Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_0_0_1_RuleCall_Parens(current, this) : new Term_0_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom|TwoNumbers|ManyStrings
protected class Term_0_0_0_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prTerm().ele00000Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_0_0_0_1_RuleCall_ManyStrings(current, this) : new Term_0_0_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom|TwoNumbers
protected class Term_0_0_0_0_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prTerm().ele000000Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_0_0_0_0_1_RuleCall_TwoNumbers(current, this) : new Term_0_0_0_0_0_0_0_RuleCall_Atom(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom
protected class Term_0_0_0_0_0_0_0_RuleCall_Atom extends RuleCallToken {
	
	public Term_0_0_0_0_0_0_0_RuleCall_Atom(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele0000000ParserRuleCallAtom();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Atom_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prAtom().getRule().getType().getType())) return null;
		return new Atom_Assignment_name(current, this).firstSolution();
	}
}

// TwoNumbers
protected class Term_0_0_0_0_0_0_1_RuleCall_TwoNumbers extends RuleCallToken {
	
	public Term_0_0_0_0_0_0_1_RuleCall_TwoNumbers(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele0000001ParserRuleCallTwoNumbers();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(TwoNumbers_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prTwoNumbers().getRule().getType().getType())) return null;
		return new TwoNumbers_Group(current, this).firstSolution();
	}
}


// ManyStrings
protected class Term_0_0_0_0_0_1_RuleCall_ManyStrings extends RuleCallToken {
	
	public Term_0_0_0_0_0_1_RuleCall_ManyStrings(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele000001ParserRuleCallManyStrings();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ManyStrings_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prManyStrings().getRule().getType().getType())) return null;
		return new ManyStrings_Group(current, this).firstSolution();
	}
}


// Parens
protected class Term_0_0_0_0_1_RuleCall_Parens extends RuleCallToken {
	
	public Term_0_0_0_0_1_RuleCall_Parens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele00001ParserRuleCallParens();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Parens_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prParens().getRule().getType().getType())) return null;
		return new Parens_Group(current, this).firstSolution();
	}
}


// Type
protected class Term_0_0_0_1_RuleCall_Type extends RuleCallToken {
	
	public Term_0_0_0_1_RuleCall_Type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele0001ParserRuleCallType();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Type_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prType().getRule().getType().getType())) return null;
		return new Type_Group(current, this).firstSolution();
	}
}


// Ref2
protected class Term_0_0_1_RuleCall_Ref2 extends RuleCallToken {
	
	public Term_0_0_1_RuleCall_Ref2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele001ParserRuleCallRef2();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Ref2_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prRef2().getRule().getType().getType())) return null;
		return new Ref2_Group(current, this).firstSolution();
	}
}


// Spare
protected class Term_0_1_RuleCall_Spare extends RuleCallToken {
	
	public Term_0_1_RuleCall_Spare(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele01ParserRuleCallSpare();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Spare_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prSpare().getRule().getType().getType())) return null;
		return new Spare_Group(current, this).firstSolution();
	}
}


// Boolean
protected class Term_1_RuleCall_Boolean extends RuleCallToken {
	
	public Term_1_RuleCall_Boolean(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prTerm().ele1ParserRuleCallBoolean();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Boolean_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prBoolean().getRule().getType().getType())) return null;
		return new Boolean_Group(current, this).firstSolution();
	}
}


/************ end Rule Term ****************/


/************ begin Rule Atom ****************
 *
 * Atom:   name=ID;
 *
 **/


// name=ID
protected class Atom_Assignment_name extends AssignmentToken  {
	
	public Atom_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prAtom().eleAssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prAtom().ele0LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Atom ****************/


/************ begin Rule Parens ****************
 *
 * Parens returns Expression:   "(" Op ")" (em="!")?;
 *
 **/


// "(" Op ")" (em="!")?
protected class Parens_Group extends GroupToken {
	
	public Parens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prParens().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Parens_1_Assignment_em(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "(" Op ")"
protected class Parens_0_Group extends GroupToken {
	
	public Parens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prParens().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Parens_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "(" Op
protected class Parens_0_0_Group extends GroupToken {
	
	public Parens_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prParens().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Parens_0_0_1_RuleCall_Op(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "("
protected class Parens_0_0_0_Keyword extends KeywordToken  {
	
	public Parens_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prParens().ele000KeywordLeftParenthesis();
	}	
}

// Op
protected class Parens_0_0_1_RuleCall_Op extends RuleCallToken {
	
	public Parens_0_0_1_RuleCall_Op(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prParens().ele001ParserRuleCallOp();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Op_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prOp().getRule().getType().getType())) return null;
		return new Op_Group(current, this).firstSolution();
	}
}


// ")"
protected class Parens_0_1_Keyword extends KeywordToken  {
	
	public Parens_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prParens().ele01KeywordRightParenthesis();
	}	
}


// (em="!")?
protected class Parens_1_Assignment_em extends AssignmentToken  {
	
	public Parens_1_Assignment_em(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prParens().ele1AssignmentEm();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("em",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("em");

		if("!".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prParens().ele10KeywordExclamationMark();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule Parens ****************/


/************ begin Rule TwoNumbers ****************
 *
 * TwoNumbers:   num1=INT num2=INT ("#" num3+=INT)*;
 *
 **/


// num1=INT num2=INT ("#" num3+=INT)*
protected class TwoNumbers_Group extends GroupToken {
	
	public TwoNumbers_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prTwoNumbers().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new TwoNumbers_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TwoNumbers_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// num1=INT num2=INT
protected class TwoNumbers_0_Group extends GroupToken {
	
	public TwoNumbers_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prTwoNumbers().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new TwoNumbers_0_1_Assignment_num2(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TwoNumbers_0_0_Assignment_num1(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// num1=INT
protected class TwoNumbers_0_0_Assignment_num1 extends AssignmentToken  {
	
	public TwoNumbers_0_0_Assignment_num1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prTwoNumbers().ele00AssignmentNum1();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("num1",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("num1");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prTwoNumbers().ele000LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}

// num2=INT
protected class TwoNumbers_0_1_Assignment_num2 extends AssignmentToken  {
	
	public TwoNumbers_0_1_Assignment_num2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prTwoNumbers().ele01AssignmentNum2();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("num2",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("num2");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prTwoNumbers().ele010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// ("#" num3+=INT)*
protected class TwoNumbers_1_Group extends GroupToken {
	
	public TwoNumbers_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prTwoNumbers().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new TwoNumbers_1_1_Assignment_num3(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TwoNumbers_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#"
protected class TwoNumbers_1_0_Keyword extends KeywordToken  {
	
	public TwoNumbers_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prTwoNumbers().ele10KeywordNumberSign();
	}	
}

// num3+=INT
protected class TwoNumbers_1_1_Assignment_num3 extends AssignmentToken  {
	
	public TwoNumbers_1_1_Assignment_num3(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prTwoNumbers().ele11AssignmentNum3();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("num3",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("num3");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prTwoNumbers().ele110LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule TwoNumbers ****************/


/************ begin Rule ManyStrings ****************
 *
 * ManyStrings:   "=" (str1+=STRING)* str2+=STRING;
 *
 **/


// "=" (str1+=STRING)* str2+=STRING
protected class ManyStrings_Group extends GroupToken {
	
	public ManyStrings_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prManyStrings().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ManyStrings_1_Assignment_str2(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ManyStrings_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "=" (str1+=STRING)*
protected class ManyStrings_0_Group extends GroupToken {
	
	public ManyStrings_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prManyStrings().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ManyStrings_0_1_Assignment_str1(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ManyStrings_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "="
protected class ManyStrings_0_0_Keyword extends KeywordToken  {
	
	public ManyStrings_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prManyStrings().ele00KeywordEqualsSign();
	}	
}

// (str1+=STRING)*
protected class ManyStrings_0_1_Assignment_str1 extends AssignmentToken  {
	
	public ManyStrings_0_1_Assignment_str1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prManyStrings().ele01AssignmentStr1();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("str1",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("str1");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prManyStrings().ele010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// str2+=STRING
protected class ManyStrings_1_Assignment_str2 extends AssignmentToken  {
	
	public ManyStrings_1_Assignment_str2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prManyStrings().ele1AssignmentStr2();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("str2",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("str2");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prManyStrings().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule ManyStrings ****************/


/************ begin Rule Type ****************
 *
 * Type:   "type" name=ID "extends" ^extends=[Type];
 *
 **/


// "type" name=ID "extends" ^extends=[Type]
protected class Type_Group extends GroupToken {
	
	public Type_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prType().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Type_1_Assignment_extends(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Type_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "type" name=ID "extends"
protected class Type_0_Group extends GroupToken {
	
	public Type_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prType().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Type_0_1_Keyword_extends(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Type_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "type" name=ID
protected class Type_0_0_Group extends GroupToken {
	
	public Type_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prType().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Type_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Type_0_0_0_Keyword_type(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "type"
protected class Type_0_0_0_Keyword_type extends KeywordToken  {
	
	public Type_0_0_0_Keyword_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prType().ele000KeywordType();
	}	
}

// name=ID
protected class Type_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Type_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prType().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prType().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "extends"
protected class Type_0_1_Keyword_extends extends KeywordToken  {
	
	public Type_0_1_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prType().ele01KeywordExtends();
	}	
}


// ^extends=[Type]
protected class Type_1_Assignment_extends extends AssignmentToken  {
	
	public Type_1_Assignment_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prType().ele1AssignmentExtends();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("extends",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("extends");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prType().ele10CrossReferenceEStringType().getType().getType())) {
				type = AssignmentType.CR;
				element = grammarAccess.prType().ele10CrossReferenceEStringType(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


/************ end Rule Type ****************/


/************ begin Rule Ref2 ****************
 *
 * Ref2:   "#2" ref2=("mykeyword1"|STRING|"mykeyword2");
 *
 **/


// "#2" ref2=("mykeyword1"|STRING|"mykeyword2")
protected class Ref2_Group extends GroupToken {
	
	public Ref2_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prRef2().eleGroup();
	}
		
	@Override
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
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prRef2().ele0KeywordNumberSignDigitTwo();
	}	
}

// ref2=("mykeyword1"|STRING|"mykeyword2")
protected class Ref2_1_Assignment_ref2 extends AssignmentToken  {
	
	public Ref2_1_Assignment_ref2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prRef2().ele1AssignmentRef2();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("ref2",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ref2");

		if("mykeyword1".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prRef2().ele1000KeywordMykeyword1();
			return new Solution(obj);
		}


		if("mykeyword2".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prRef2().ele101KeywordMykeyword2();
			return new Solution(obj);
		}

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prRef2().ele1001LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Ref2 ****************/


/************ begin Rule Spare ****************
 *
 * Spare:   "#3" id+=ID ("." id+=ID)*;
 *
 **/


// "#3" id+=ID ("." id+=ID)*
protected class Spare_Group extends GroupToken {
	
	public Spare_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prSpare().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spare_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spare_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#3" id+=ID
protected class Spare_0_Group extends GroupToken {
	
	public Spare_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prSpare().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spare_0_1_Assignment_id(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spare_0_0_Keyword_3(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#3"
protected class Spare_0_0_Keyword_3 extends KeywordToken  {
	
	public Spare_0_0_Keyword_3(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prSpare().ele00KeywordNumberSignDigitThree();
	}	
}

// id+=ID
protected class Spare_0_1_Assignment_id extends AssignmentToken  {
	
	public Spare_0_1_Assignment_id(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prSpare().ele01AssignmentId();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("id",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("id");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prSpare().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("." id+=ID)*
protected class Spare_1_Group extends GroupToken {
	
	public Spare_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prSpare().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spare_1_1_Assignment_id(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spare_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "."
protected class Spare_1_0_Keyword extends KeywordToken  {
	
	public Spare_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prSpare().ele10KeywordFullStop();
	}	
}

// id+=ID
protected class Spare_1_1_Assignment_id extends AssignmentToken  {
	
	public Spare_1_1_Assignment_id(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prSpare().ele11AssignmentId();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("id",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("id");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prSpare().ele110LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule Spare ****************/


/************ begin Rule Boolean ****************
 *
 * Boolean:   "#4" (bool?="myoption")? "kw" value=ID;
 *
 **/


// "#4" (bool?="myoption")? "kw" value=ID
protected class Boolean_Group extends GroupToken {
	
	public Boolean_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prBoolean().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Boolean_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Boolean_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#4" (bool?="myoption")? "kw"
protected class Boolean_0_Group extends GroupToken {
	
	public Boolean_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prBoolean().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Boolean_0_1_Keyword_kw(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Boolean_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#4" (bool?="myoption")?
protected class Boolean_0_0_Group extends GroupToken {
	
	public Boolean_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prBoolean().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Boolean_0_0_1_Assignment_bool(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Boolean_0_0_0_Keyword_4(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#4"
protected class Boolean_0_0_0_Keyword_4 extends KeywordToken  {
	
	public Boolean_0_0_0_Keyword_4(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prBoolean().ele000KeywordNumberSignDigitFour();
	}	
}

// (bool?="myoption")?
protected class Boolean_0_0_1_Assignment_bool extends AssignmentToken  {
	
	public Boolean_0_0_1_Assignment_bool(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prBoolean().ele001AssignmentBool();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("bool",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("bool");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prBoolean().ele0010KeywordMyoption();
			return new Solution(obj);
		}

		return null;
	}
}


// "kw"
protected class Boolean_0_1_Keyword_kw extends KeywordToken  {
	
	public Boolean_0_1_Keyword_kw(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prBoolean().ele01KeywordKw();
	}	
}


// value=ID
protected class Boolean_1_Assignment_value extends AssignmentToken  {
	
	public Boolean_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prBoolean().ele1AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prBoolean().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Boolean ****************/

}
