/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;


public class ComplexReconstrTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Root") && (s = new Root_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Expression") && (s = new Op_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Expression") && (s = new Term_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Atom") && (s = new Atom_Assignment_name(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Expression") && (s = new Parens_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TypeA1") && (s = new TrickyA_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TypeD") && (s = new TrickyA1_Assignment_name(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyB") && (s = new TrickyB_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyC") && (s = new TrickyC_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyD") && (s = new TrickyD_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyE") && (s = new TrickyE_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyF") && (s = new TrickyF_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyG") && (s = new TrickyG_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyG1") && (s = new TrickyG1_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TrickyG2") && (s = new TrickyG2_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Root ****************
 *
 * Root : Op | TrickyG ;
 *
 **/


// Op | TrickyG
protected class Root_Alternatives extends AlternativesToken {

	public Root_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prRoot().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Root_1_RuleCall_TrickyG(current, this) : new Root_0_RuleCall_Op(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Op
protected class Root_0_RuleCall_Op extends RuleCallToken {
	
	public Root_0_RuleCall_Op(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prRoot().ele0ParserRuleCallOp();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Op_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Op_Group(current, this).firstSolution();
	}
}

// TrickyG
protected class Root_1_RuleCall_TrickyG extends RuleCallToken {
	
	public Root_1_RuleCall_TrickyG(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prRoot().ele1ParserRuleCallTrickyG();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TrickyG_Group.class, current)) return null;
		if(!current.isInstanceOf("TrickyG")) return null;
		return new TrickyG_Group(current, this).firstSolution();
	}
}


/************ end Rule Root ****************/


/************ begin Rule Op ****************
 *
 * Op returns Expression : Term ( { current = Add . addOperands += current } '+' addOperands += Term | { current = Minus . minusOperands += current } '-' minusOperands += Term ) * ;
 *
 **/


// Term ( { current = Add . addOperands += current } '+' addOperands += Term | { current = Minus . minusOperands += current } '-' minusOperands += Term ) *
protected class Op_Group extends GroupToken {
	
	public Op_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_Alternatives(current, this).firstSolution();
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
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele0ParserRuleCallTerm();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Term_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Term_Alternatives(current, this).firstSolution();
	}
}

// ( { current = Add . addOperands += current } '+' addOperands += Term | { current = Minus . minusOperands += current } '-' minusOperands += Term ) *
protected class Op_1_Alternatives extends AlternativesToken {

	public Op_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele1Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Op_1_1_Group(current, this) : new Op_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// { current = Add . addOperands += current } '+' addOperands += Term
protected class Op_1_0_Group extends GroupToken {
	
	public Op_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele10Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_0_1_Assignment_addOperands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Add . addOperands += current } '+'
protected class Op_1_0_0_Group extends GroupToken {
	
	public Op_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_0_0_0_Action_Add_addOperands(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Add . addOperands += current }
protected class Op_1_0_0_0_Action_Add_addOperands extends ActionToken  {

	public Op_1_0_0_0_Action_Add_addOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele1000ActionAddaddOperands();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Add")) return null;
		Object val = current.getConsumable("addOperands", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("addOperands")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// '+'
protected class Op_1_0_0_1_Keyword extends KeywordToken  {
	
	public Op_1_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele1001KeywordPlusSign();
	}	
}


// addOperands += Term
protected class Op_1_0_1_Assignment_addOperands extends AssignmentToken  {
	
	public Op_1_0_1_Assignment_addOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele101AssignmentAddOperands();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("addOperands",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("addOperands");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Expression")) {
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


// { current = Minus . minusOperands += current } '-' minusOperands += Term
protected class Op_1_1_Group extends GroupToken {
	
	public Op_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele11Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_1_1_Assignment_minusOperands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Minus . minusOperands += current } '-'
protected class Op_1_1_0_Group extends GroupToken {
	
	public Op_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele110Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_1_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_1_0_0_Action_Minus_minusOperands(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Minus . minusOperands += current }
protected class Op_1_1_0_0_Action_Minus_minusOperands extends ActionToken  {

	public Op_1_1_0_0_Action_Minus_minusOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele1100ActionMinusminusOperands();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Minus")) return null;
		Object val = current.getConsumable("minusOperands", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("minusOperands")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// '-'
protected class Op_1_1_0_1_Keyword extends KeywordToken  {
	
	public Op_1_1_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele1101KeywordHyphenMinus();
	}	
}


// minusOperands += Term
protected class Op_1_1_1_Assignment_minusOperands extends AssignmentToken  {
	
	public Op_1_1_1_Assignment_minusOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp().ele111AssignmentMinusOperands();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("minusOperands",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("minusOperands");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Expression")) {
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
 * Term returns Expression : Atom | Parens ;
 *
 **/


// Atom | Parens
protected class Term_Alternatives extends AlternativesToken {

	public Term_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTerm().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_1_RuleCall_Parens(current, this) : new Term_0_RuleCall_Atom(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom
protected class Term_0_RuleCall_Atom extends RuleCallToken {
	
	public Term_0_RuleCall_Atom(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTerm().ele0ParserRuleCallAtom();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Atom_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("Atom")) return null;
		return new Atom_Assignment_name(current, this).firstSolution();
	}
}

// Parens
protected class Term_1_RuleCall_Parens extends RuleCallToken {
	
	public Term_1_RuleCall_Parens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTerm().ele1ParserRuleCallParens();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Parens_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Parens_Group(current, this).firstSolution();
	}
}


/************ end Rule Term ****************/


/************ begin Rule Atom ****************
 *
 * Atom : name = ID ;
 *
 **/


// name = ID
protected class Atom_Assignment_name extends AssignmentToken  {
	
	public Atom_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prAtom().eleAssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prAtom().ele0LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Atom ****************/


/************ begin Rule Parens ****************
 *
 * Parens returns Expression : '(' Op ')' ( em = '!' ) ? ;
 *
 **/


// '(' Op ')' ( em = '!' ) ?
protected class Parens_Group extends GroupToken {
	
	public Parens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().eleGroup();
	}
		
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

// '(' Op ')'
protected class Parens_0_Group extends GroupToken {
	
	public Parens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().ele0Group();
	}
		
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

// '(' Op
protected class Parens_0_0_Group extends GroupToken {
	
	public Parens_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().ele00Group();
	}
		
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

// '('
protected class Parens_0_0_0_Keyword extends KeywordToken  {
	
	public Parens_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().ele000KeywordLeftParenthesis();
	}	
}

// Op
protected class Parens_0_0_1_RuleCall_Op extends RuleCallToken {
	
	public Parens_0_0_1_RuleCall_Op(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().ele001ParserRuleCallOp();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Op_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Op_Group(current, this).firstSolution();
	}
}


// ')'
protected class Parens_0_1_Keyword extends KeywordToken  {
	
	public Parens_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().ele01KeywordRightParenthesis();
	}	
}


// ( em = '!' ) ?
protected class Parens_1_Assignment_em extends AssignmentToken  {
	
	public Parens_1_Assignment_em(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().ele1AssignmentEm();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("em",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("em");

		if("!".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens().ele10KeywordExclamationMark();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule Parens ****************/


/************ begin Rule TrickyA ****************
 *
 * TrickyA returns TypeA1 : 'TA' TrickyA1 ( name += ID ) * ( { current = TypeB . x = current } 'x' | { current = TypeC . x = current } 'y' ) ? name += STRING ;
 *
 **/


// 'TA' TrickyA1 ( name += ID ) * ( { current = TypeB . x = current } 'x' | { current = TypeC . x = current } 'y' ) ? name += STRING
protected class TrickyA_Group extends GroupToken {
	
	public TrickyA_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TA' TrickyA1 ( name += ID ) * ( { current = TypeB . x = current } 'x' | { current = TypeC . x = current } 'y' ) ?
protected class TrickyA_0_Group extends GroupToken {
	
	public TrickyA_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TA' TrickyA1 ( name += ID ) *
protected class TrickyA_0_0_Group extends GroupToken {
	
	public TrickyA_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TA' TrickyA1
protected class TrickyA_0_0_0_Group extends GroupToken {
	
	public TrickyA_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_0_0_1_RuleCall_TrickyA1(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_0_0_0_Keyword_TA(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TA'
protected class TrickyA_0_0_0_0_Keyword_TA extends KeywordToken  {
	
	public TrickyA_0_0_0_0_Keyword_TA(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0000KeywordTA();
	}	
}

// TrickyA1
protected class TrickyA_0_0_0_1_RuleCall_TrickyA1 extends RuleCallToken {
	
	public TrickyA_0_0_0_1_RuleCall_TrickyA1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0001ParserRuleCallTrickyA1();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TrickyA1_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("TypeD")) return null;
		return new TrickyA1_Assignment_name(current, this).firstSolution();
	}
}


// ( name += ID ) *
protected class TrickyA_0_0_1_Assignment_name extends AssignmentToken  {
	
	public TrickyA_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ( { current = TypeB . x = current } 'x' | { current = TypeC . x = current } 'y' ) ?
protected class TrickyA_0_1_Alternatives extends AlternativesToken {

	public TrickyA_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele01Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TrickyA_0_1_1_Group(current, this) : new TrickyA_0_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// { current = TypeB . x = current } 'x'
protected class TrickyA_0_1_0_Group extends GroupToken {
	
	public TrickyA_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_1_0_1_Keyword_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_1_0_0_Action_TypeB_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = TypeB . x = current }
protected class TrickyA_0_1_0_0_Action_TypeB_x extends ActionToken  {

	public TrickyA_0_1_0_0_Action_TypeB_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0100ActionTypeBx();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("TypeB")) return null;
		Object val = current.getConsumable("x", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("x")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// 'x'
protected class TrickyA_0_1_0_1_Keyword_x extends KeywordToken  {
	
	public TrickyA_0_1_0_1_Keyword_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0101KeywordX();
	}	
}


// { current = TypeC . x = current } 'y'
protected class TrickyA_0_1_1_Group extends GroupToken {
	
	public TrickyA_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele011Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_1_1_1_Keyword_y(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_1_1_0_Action_TypeC_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = TypeC . x = current }
protected class TrickyA_0_1_1_0_Action_TypeC_x extends ActionToken  {

	public TrickyA_0_1_1_0_Action_TypeC_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0110ActionTypeCx();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("TypeC")) return null;
		Object val = current.getConsumable("x", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("x")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// 'y'
protected class TrickyA_0_1_1_1_Keyword_y extends KeywordToken  {
	
	public TrickyA_0_1_1_1_Keyword_y(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele0111KeywordY();
	}	
}




// name += STRING
protected class TrickyA_1_Assignment_name extends AssignmentToken  {
	
	public TrickyA_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele1AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TrickyA ****************/


/************ begin Rule TrickyA1 ****************
 *
 * TrickyA1 returns TypeD : name += ID ;
 *
 **/


// name += ID
protected class TrickyA1_Assignment_name extends AssignmentToken  {
	
	public TrickyA1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA1().eleAssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA1().ele0LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule TrickyA1 ****************/


/************ begin Rule TrickyB ****************
 *
 * TrickyB : 'TB' ( name = ID type += INT ) ? ( type += INT ) * ;
 *
 **/


// 'TB' ( name = ID type += INT ) ? ( type += INT ) *
protected class TrickyB_Group extends GroupToken {
	
	public TrickyB_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyB_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyB_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TB' ( name = ID type += INT ) ?
protected class TrickyB_0_Group extends GroupToken {
	
	public TrickyB_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyB_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyB_0_0_Keyword_TB(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TB'
protected class TrickyB_0_0_Keyword_TB extends KeywordToken  {
	
	public TrickyB_0_0_Keyword_TB(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele00KeywordTB();
	}	
}

// ( name = ID type += INT ) ?
protected class TrickyB_0_1_Group extends GroupToken {
	
	public TrickyB_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyB_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyB_0_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class TrickyB_0_1_0_Assignment_name extends AssignmentToken  {
	
	public TrickyB_0_1_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele010AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele0100LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// type += INT
protected class TrickyB_0_1_1_Assignment_type extends AssignmentToken  {
	
	public TrickyB_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele0110LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}



// ( type += INT ) *
protected class TrickyB_1_Assignment_type extends AssignmentToken  {
	
	public TrickyB_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele1AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB().ele10LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TrickyB ****************/


/************ begin Rule TrickyC ****************
 *
 * TrickyC : 'TC' name = ID ( { current = C1 . x = current } 'x' ) ? ( { current = C2 . y = current } 'y' ) ? ( { current = C3 . z = current } 'z' ) ? ;
 *
 **/


// 'TC' name = ID ( { current = C1 . x = current } 'x' ) ? ( { current = C2 . y = current } 'y' ) ? ( { current = C3 . z = current } 'z' ) ?
protected class TrickyC_Group extends GroupToken {
	
	public TrickyC_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TC' name = ID ( { current = C1 . x = current } 'x' ) ? ( { current = C2 . y = current } 'y' ) ?
protected class TrickyC_0_Group extends GroupToken {
	
	public TrickyC_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TC' name = ID ( { current = C1 . x = current } 'x' ) ?
protected class TrickyC_0_0_Group extends GroupToken {
	
	public TrickyC_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TC' name = ID
protected class TrickyC_0_0_0_Group extends GroupToken {
	
	public TrickyC_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_0_0_Keyword_TC(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TC'
protected class TrickyC_0_0_0_0_Keyword_TC extends KeywordToken  {
	
	public TrickyC_0_0_0_0_Keyword_TC(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele0000KeywordTC();
	}	
}

// name = ID
protected class TrickyC_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public TrickyC_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele0001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele00010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ( { current = C1 . x = current } 'x' ) ?
protected class TrickyC_0_0_1_Group extends GroupToken {
	
	public TrickyC_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_0_1_1_Keyword_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_1_0_Action_C1_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = C1 . x = current }
protected class TrickyC_0_0_1_0_Action_C1_x extends ActionToken  {

	public TrickyC_0_0_1_0_Action_C1_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele0010ActionC1x();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("C1")) return null;
		Object val = current.getConsumable("x", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("x")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// 'x'
protected class TrickyC_0_0_1_1_Keyword_x extends KeywordToken  {
	
	public TrickyC_0_0_1_1_Keyword_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele0011KeywordX();
	}	
}



// ( { current = C2 . y = current } 'y' ) ?
protected class TrickyC_0_1_Group extends GroupToken {
	
	public TrickyC_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_1_1_Keyword_y(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_1_0_Action_C2_y(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = C2 . y = current }
protected class TrickyC_0_1_0_Action_C2_y extends ActionToken  {

	public TrickyC_0_1_0_Action_C2_y(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele010ActionC2y();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("C2")) return null;
		Object val = current.getConsumable("y", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("y")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// 'y'
protected class TrickyC_0_1_1_Keyword_y extends KeywordToken  {
	
	public TrickyC_0_1_1_Keyword_y(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele011KeywordY();
	}	
}



// ( { current = C3 . z = current } 'z' ) ?
protected class TrickyC_1_Group extends GroupToken {
	
	public TrickyC_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_1_1_Keyword_z(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_1_0_Action_C3_z(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = C3 . z = current }
protected class TrickyC_1_0_Action_C3_z extends ActionToken  {

	public TrickyC_1_0_Action_C3_z(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele10ActionC3z();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("C3")) return null;
		Object val = current.getConsumable("z", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("z")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// 'z'
protected class TrickyC_1_1_Keyword_z extends KeywordToken  {
	
	public TrickyC_1_1_Keyword_z(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC().ele11KeywordZ();
	}	
}



/************ end Rule TrickyC ****************/


/************ begin Rule TrickyD ****************
 *
 * TrickyD : 'TD' ( name += INT foo = STRING type += ID ) ? ( name += INT type += ID ) ? ( type += ID ) * ;
 *
 **/


// 'TD' ( name += INT foo = STRING type += ID ) ? ( name += INT type += ID ) ? ( type += ID ) *
protected class TrickyD_Group extends GroupToken {
	
	public TrickyD_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TD' ( name += INT foo = STRING type += ID ) ? ( name += INT type += ID ) ?
protected class TrickyD_0_Group extends GroupToken {
	
	public TrickyD_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TD' ( name += INT foo = STRING type += ID ) ?
protected class TrickyD_0_0_Group extends GroupToken {
	
	public TrickyD_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_0_Keyword_TD(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TD'
protected class TrickyD_0_0_0_Keyword_TD extends KeywordToken  {
	
	public TrickyD_0_0_0_Keyword_TD(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele000KeywordTD();
	}	
}

// ( name += INT foo = STRING type += ID ) ?
protected class TrickyD_0_0_1_Group extends GroupToken {
	
	public TrickyD_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name += INT foo = STRING
protected class TrickyD_0_0_1_0_Group extends GroupToken {
	
	public TrickyD_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele0010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_0_1_0_1_Assignment_foo(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_1_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name += INT
protected class TrickyD_0_0_1_0_0_Assignment_name extends AssignmentToken  {
	
	public TrickyD_0_0_1_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele00100AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele001000LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}

// foo = STRING
protected class TrickyD_0_0_1_0_1_Assignment_foo extends AssignmentToken  {
	
	public TrickyD_0_0_1_0_1_Assignment_foo(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele00101AssignmentFoo();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("foo",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("foo");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele001010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// type += ID
protected class TrickyD_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public TrickyD_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele0011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele00110LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}



// ( name += INT type += ID ) ?
protected class TrickyD_0_1_Group extends GroupToken {
	
	public TrickyD_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name += INT
protected class TrickyD_0_1_0_Assignment_name extends AssignmentToken  {
	
	public TrickyD_0_1_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele010AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele0100LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}

// type += ID
protected class TrickyD_0_1_1_Assignment_type extends AssignmentToken  {
	
	public TrickyD_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele0110LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}



// ( type += ID ) *
protected class TrickyD_1_Assignment_type extends AssignmentToken  {
	
	public TrickyD_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele1AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TrickyD ****************/


/************ begin Rule TrickyE ****************
 *
 * TrickyE : 'TE' ( name += INT foo += STRING type += ID ) * 'x' ( name += INT type += ID ) * ;
 *
 **/


// 'TE' ( name += INT foo += STRING type += ID ) * 'x' ( name += INT type += ID ) *
protected class TrickyE_Group extends GroupToken {
	
	public TrickyE_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TE' ( name += INT foo += STRING type += ID ) * 'x'
protected class TrickyE_0_Group extends GroupToken {
	
	public TrickyE_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_1_Keyword_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TE' ( name += INT foo += STRING type += ID ) *
protected class TrickyE_0_0_Group extends GroupToken {
	
	public TrickyE_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_0_Keyword_TE(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TE'
protected class TrickyE_0_0_0_Keyword_TE extends KeywordToken  {
	
	public TrickyE_0_0_0_Keyword_TE(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele000KeywordTE();
	}	
}

// ( name += INT foo += STRING type += ID ) *
protected class TrickyE_0_0_1_Group extends GroupToken {
	
	public TrickyE_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name += INT foo += STRING
protected class TrickyE_0_0_1_0_Group extends GroupToken {
	
	public TrickyE_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele0010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_0_1_0_1_Assignment_foo(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_1_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name += INT
protected class TrickyE_0_0_1_0_0_Assignment_name extends AssignmentToken  {
	
	public TrickyE_0_0_1_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele00100AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele001000LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}

// foo += STRING
protected class TrickyE_0_0_1_0_1_Assignment_foo extends AssignmentToken  {
	
	public TrickyE_0_0_1_0_1_Assignment_foo(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele00101AssignmentFoo();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("foo",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("foo");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele001010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// type += ID
protected class TrickyE_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public TrickyE_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele0011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele00110LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}



// 'x'
protected class TrickyE_0_1_Keyword_x extends KeywordToken  {
	
	public TrickyE_0_1_Keyword_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele01KeywordX();
	}	
}


// ( name += INT type += ID ) *
protected class TrickyE_1_Group extends GroupToken {
	
	public TrickyE_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name += INT
protected class TrickyE_1_0_Assignment_name extends AssignmentToken  {
	
	public TrickyE_1_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele10AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele100LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}

// type += ID
protected class TrickyE_1_1_Assignment_type extends AssignmentToken  {
	
	public TrickyE_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele11AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE().ele110LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule TrickyE ****************/


/************ begin Rule TrickyF ****************
 *
 * TrickyF : 'TF' ( name += ID type += INT ) * ( name += ID | type += INT ) ;
 *
 **/


// 'TF' ( name += ID type += INT ) * ( name += ID | type += INT )
protected class TrickyF_Group extends GroupToken {
	
	public TrickyF_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyF_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyF_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TF' ( name += ID type += INT ) *
protected class TrickyF_0_Group extends GroupToken {
	
	public TrickyF_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyF_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyF_0_0_Keyword_TF(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TF'
protected class TrickyF_0_0_Keyword_TF extends KeywordToken  {
	
	public TrickyF_0_0_Keyword_TF(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele00KeywordTF();
	}	
}

// ( name += ID type += INT ) *
protected class TrickyF_0_1_Group extends GroupToken {
	
	public TrickyF_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyF_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyF_0_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name += ID
protected class TrickyF_0_1_0_Assignment_name extends AssignmentToken  {
	
	public TrickyF_0_1_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele010AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele0100LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// type += INT
protected class TrickyF_0_1_1_Assignment_type extends AssignmentToken  {
	
	public TrickyF_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele0110LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}



// name += ID | type += INT
protected class TrickyF_1_Alternatives extends AlternativesToken {

	public TrickyF_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele1Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TrickyF_1_1_Assignment_type(current, this) : new TrickyF_1_0_Assignment_name(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// name += ID
protected class TrickyF_1_0_Assignment_name extends AssignmentToken  {
	
	public TrickyF_1_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele10AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele100LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// type += INT
protected class TrickyF_1_1_Assignment_type extends AssignmentToken  {
	
	public TrickyF_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele11AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF().ele110LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule TrickyF ****************/


/************ begin Rule TrickyG ****************
 *
 * TrickyG : 'TG' tree = TrickyG1 ;
 *
 **/


// 'TG' tree = TrickyG1
protected class TrickyG_Group extends GroupToken {
	
	public TrickyG_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyG_1_Assignment_tree(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyG_0_Keyword_TG(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'TG'
protected class TrickyG_0_Keyword_TG extends KeywordToken  {
	
	public TrickyG_0_Keyword_TG(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG().ele0KeywordTG();
	}	
}

// tree = TrickyG1
protected class TrickyG_1_Assignment_tree extends AssignmentToken  {
	
	public TrickyG_1_Assignment_tree(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG().ele1AssignmentTree();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("tree",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("tree");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TrickyG1")) {
				Solution s = new TrickyG1_Group(param, this).firstSolution();
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


/************ end Rule TrickyG ****************/


/************ begin Rule TrickyG1 ****************
 *
 * TrickyG1 : '[' ( vals += TrickyG2 ( ',' vals += TrickyG2 ) * ) ? ']' ;
 *
 **/


// '[' ( vals += TrickyG2 ( ',' vals += TrickyG2 ) * ) ? ']'
protected class TrickyG1_Group extends GroupToken {
	
	public TrickyG1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyG1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyG1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// '[' ( vals += TrickyG2 ( ',' vals += TrickyG2 ) * ) ?
protected class TrickyG1_0_Group extends GroupToken {
	
	public TrickyG1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyG1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyG1_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// '['
protected class TrickyG1_0_0_Keyword extends KeywordToken  {
	
	public TrickyG1_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele00KeywordLeftSquareBracket();
	}	
}

// ( vals += TrickyG2 ( ',' vals += TrickyG2 ) * ) ?
protected class TrickyG1_0_1_Group extends GroupToken {
	
	public TrickyG1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyG1_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyG1_0_1_0_Assignment_vals(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// vals += TrickyG2
protected class TrickyG1_0_1_0_Assignment_vals extends AssignmentToken  {
	
	public TrickyG1_0_1_0_Assignment_vals(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele010AssignmentVals();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("vals",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("vals");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TrickyG2")) {
				Solution s = new TrickyG2_Alternatives(param, this).firstSolution();
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

// ( ',' vals += TrickyG2 ) *
protected class TrickyG1_0_1_1_Group extends GroupToken {
	
	public TrickyG1_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele011Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyG1_0_1_1_1_Assignment_vals(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyG1_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ','
protected class TrickyG1_0_1_1_0_Keyword extends KeywordToken  {
	
	public TrickyG1_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele0110KeywordComma();
	}	
}

// vals += TrickyG2
protected class TrickyG1_0_1_1_1_Assignment_vals extends AssignmentToken  {
	
	public TrickyG1_0_1_1_1_Assignment_vals(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele0111AssignmentVals();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("vals",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("vals");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TrickyG2")) {
				Solution s = new TrickyG2_Alternatives(param, this).firstSolution();
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




// ']'
protected class TrickyG1_1_Keyword extends KeywordToken  {
	
	public TrickyG1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1().ele1KeywordRightSquareBracket();
	}	
}


/************ end Rule TrickyG1 ****************/


/************ begin Rule TrickyG2 ****************
 *
 * TrickyG2 : TrickyG1 | val = INT ;
 *
 **/


// TrickyG1 | val = INT
protected class TrickyG2_Alternatives extends AlternativesToken {

	public TrickyG2_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG2().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TrickyG2_1_Assignment_val(current, this) : new TrickyG2_0_RuleCall_TrickyG1(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// TrickyG1
protected class TrickyG2_0_RuleCall_TrickyG1 extends RuleCallToken {
	
	public TrickyG2_0_RuleCall_TrickyG1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG2().ele0ParserRuleCallTrickyG1();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TrickyG1_Group.class, current)) return null;
		if(!current.isInstanceOf("TrickyG1")) return null;
		return new TrickyG1_Group(current, this).firstSolution();
	}
}

// val = INT
protected class TrickyG2_1_Assignment_val extends AssignmentToken  {
	
	public TrickyG2_1_Assignment_val(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG2().ele1AssignmentVal();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("val",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("val");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG2().ele10LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TrickyG2 ****************/

}
