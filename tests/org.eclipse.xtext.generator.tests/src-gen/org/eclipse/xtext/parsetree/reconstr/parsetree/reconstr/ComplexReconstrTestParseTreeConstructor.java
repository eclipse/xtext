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


public class ComplexReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Expression") && (s = new Op_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Term_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Atom") && (s = new Atom_Assignment_name(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Parens_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TypeA1") && (s = new TrickyA_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TypeD") && (s = new TrickyA1_Assignment_name(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TrickyB") && (s = new TrickyB_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TrickyC") && (s = new TrickyC_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TrickyD") && (s = new TrickyD_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TrickyE") && (s = new TrickyE_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TrickyF") && (s = new TrickyF_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Op ****************
 *
 * Op returns complexrewritetest :: Expression : Term ( { current = complexrewritetest :: Add . addOperands += current } '+' addOperands += Term | { current = complexrewritetest :: Minus . minusOperands += current } '-' minusOperands += Term ) * ;
 *
 **/


// Term ( { current = complexrewritetest :: Add . addOperands += current } '+' addOperands += Term | { current = complexrewritetest :: Minus . minusOperands += current } '-' minusOperands += Term ) *
protected class Op_Group extends GroupToken {
	
	public Op_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_0_RuleCall_Term(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Term_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Term_Alternatives(current, this).firstSolution();
	}
}

// ( { current = complexrewritetest :: Add . addOperands += current } '+' addOperands += Term | { current = complexrewritetest :: Minus . minusOperands += current } '-' minusOperands += Term ) *
protected class Op_1_Alternatives extends AlternativesToken {

	public Op_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1");
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

// { current = complexrewritetest :: Add . addOperands += current } '+' addOperands += Term
protected class Op_1_0_Group extends GroupToken {
	
	public Op_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_0_1_Assignment_addOperands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: Add . addOperands += current } '+'
protected class Op_1_0_0_Group extends GroupToken {
	
	public Op_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_0_0_0_Action_Add_addOperands(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: Add . addOperands += current }
protected class Op_1_0_0_0_Action_Add_addOperands extends ActionToken  {

	public Op_1_0_0_0_Action_Add_addOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// addOperands += Term
protected class Op_1_0_1_Assignment_addOperands extends AssignmentToken  {
	
	public Op_1_0_1_Assignment_addOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("addOperands",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("addOperands");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Expression")) {
				Solution s = new Term_Alternatives(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// { current = complexrewritetest :: Minus . minusOperands += current } '-' minusOperands += Term
protected class Op_1_1_Group extends GroupToken {
	
	public Op_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_1_1_Assignment_minusOperands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: Minus . minusOperands += current } '-'
protected class Op_1_1_0_Group extends GroupToken {
	
	public Op_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Op_1_1_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Op_1_1_0_0_Action_Minus_minusOperands(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: Minus . minusOperands += current }
protected class Op_1_1_0_0_Action_Minus_minusOperands extends ActionToken  {

	public Op_1_1_0_0_Action_Minus_minusOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1");
	}	
}


// minusOperands += Term
protected class Op_1_1_1_Assignment_minusOperands extends AssignmentToken  {
	
	public Op_1_1_1_Assignment_minusOperands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("minusOperands",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("minusOperands");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Expression")) {
				Solution s = new Term_Alternatives(param, this).firstSolution();
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
 * Term returns complexrewritetest :: Expression : Atom | Parens ;
 *
 **/


// Atom | Parens
protected class Term_Alternatives extends AlternativesToken {

	public Term_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.1/@alternatives");
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
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.1/@alternatives/@groups.0");
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
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.1/@alternatives/@groups.1");
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.2/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.2/@alternatives/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Atom ****************/

/************ begin Rule Parens ****************
 *
 * Parens returns complexrewritetest :: Expression : '(' Op ')' ( em = '!' ) ? ;
 *
 **/


// '(' Op ')' ( em = '!' ) ?
protected class Parens_Group extends GroupToken {
	
	public Parens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Parens_1_Assignment_em(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Parens_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Parens_0_0_1_RuleCall_Op(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// Op
protected class Parens_0_0_1_RuleCall_Op extends RuleCallToken {
	
	public Parens_0_0_1_RuleCall_Op(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( em = '!' ) ?
protected class Parens_1_Assignment_em extends AssignmentToken  {
	
	public Parens_1_Assignment_em(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("em",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("em");
		if("!".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal");
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Parens ****************/

/************ begin Rule TrickyA ****************
 *
 * TrickyA returns complexrewritetest :: TypeA1 : 'TA' TrickyA1 ( name += ID ) * ( { current = complexrewritetest :: TypeB . x = current } 'x' | { current = complexrewritetest :: TypeC . x = current } 'y' ) ? name += STRING ;
 *
 **/


// 'TA' TrickyA1 ( name += ID ) * ( { current = complexrewritetest :: TypeB . x = current } 'x' | { current = complexrewritetest :: TypeC . x = current } 'y' ) ? name += STRING
protected class TrickyA_Group extends GroupToken {
	
	public TrickyA_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'TA' TrickyA1 ( name += ID ) * ( { current = complexrewritetest :: TypeB . x = current } 'x' | { current = complexrewritetest :: TypeC . x = current } 'y' ) ?
protected class TrickyA_0_Group extends GroupToken {
	
	public TrickyA_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_0_0_1_RuleCall_TrickyA1(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_0_0_0_Keyword_TA(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// TrickyA1
protected class TrickyA_0_0_0_1_RuleCall_TrickyA1 extends RuleCallToken {
	
	public TrickyA_0_0_0_1_RuleCall_TrickyA1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( { current = complexrewritetest :: TypeB . x = current } 'x' | { current = complexrewritetest :: TypeC . x = current } 'y' ) ?
protected class TrickyA_0_1_Alternatives extends AlternativesToken {

	public TrickyA_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1");
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

// { current = complexrewritetest :: TypeB . x = current } 'x'
protected class TrickyA_0_1_0_Group extends GroupToken {
	
	public TrickyA_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_1_0_1_Keyword_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_1_0_0_Action_TypeB_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: TypeB . x = current }
protected class TrickyA_0_1_0_0_Action_TypeB_x extends ActionToken  {

	public TrickyA_0_1_0_0_Action_TypeB_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1");
	}	
}


// { current = complexrewritetest :: TypeC . x = current } 'y'
protected class TrickyA_0_1_1_Group extends GroupToken {
	
	public TrickyA_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyA_0_1_1_1_Keyword_y(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyA_0_1_1_0_Action_TypeC_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: TypeC . x = current }
protected class TrickyA_0_1_1_0_Action_TypeC_x extends ActionToken  {

	public TrickyA_0_1_1_0_Action_TypeC_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.1");
	}	
}




// name += STRING
protected class TrickyA_1_Assignment_name extends AssignmentToken  {
	
	public TrickyA_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TrickyA ****************/

/************ begin Rule TrickyA1 ****************
 *
 * TrickyA1 returns complexrewritetest :: TypeD : name += ID ;
 *
 **/


// name += ID
protected class TrickyA1_Assignment_name extends AssignmentToken  {
	
	public TrickyA1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.5/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.5/@alternatives/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule TrickyA1 ****************/

/************ begin Rule TrickyB ****************
 *
 * TrickyB : 'TB' ( name = ID type += INT ) ? ( type += ID ) * ;
 *
 **/


// 'TB' ( name = ID type += INT ) ? ( type += ID ) *
protected class TrickyB_Group extends GroupToken {
	
	public TrickyB_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyB_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyB_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyB_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyB_0_0_Keyword_TB(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}	
}

// ( name = ID type += INT ) ?
protected class TrickyB_0_1_Group extends GroupToken {
	
	public TrickyB_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyB_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyB_0_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}



// ( type += ID ) *
protected class TrickyB_1_Assignment_type extends AssignmentToken  {
	
	public TrickyB_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TrickyB ****************/

/************ begin Rule TrickyC ****************
 *
 * TrickyC : 'TC' name = ID ( { current = complexrewritetest :: C1 . x = current } 'x' ) ? ( { current = complexrewritetest :: C2 . y = current } 'y' ) ? ( { current = complexrewritetest :: C3 . z = current } 'z' ) ? ;
 *
 **/


// 'TC' name = ID ( { current = complexrewritetest :: C1 . x = current } 'x' ) ? ( { current = complexrewritetest :: C2 . y = current } 'y' ) ? ( { current = complexrewritetest :: C3 . z = current } 'z' ) ?
protected class TrickyC_Group extends GroupToken {
	
	public TrickyC_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'TC' name = ID ( { current = complexrewritetest :: C1 . x = current } 'x' ) ? ( { current = complexrewritetest :: C2 . y = current } 'y' ) ?
protected class TrickyC_0_Group extends GroupToken {
	
	public TrickyC_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'TC' name = ID ( { current = complexrewritetest :: C1 . x = current } 'x' ) ?
protected class TrickyC_0_0_Group extends GroupToken {
	
	public TrickyC_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_0_0_Keyword_TC(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// name = ID
protected class TrickyC_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public TrickyC_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( { current = complexrewritetest :: C1 . x = current } 'x' ) ?
protected class TrickyC_0_0_1_Group extends GroupToken {
	
	public TrickyC_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_0_1_1_Keyword_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_0_1_0_Action_C1_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: C1 . x = current }
protected class TrickyC_0_0_1_0_Action_C1_x extends ActionToken  {

	public TrickyC_0_0_1_0_Action_C1_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}	
}



// ( { current = complexrewritetest :: C2 . y = current } 'y' ) ?
protected class TrickyC_0_1_Group extends GroupToken {
	
	public TrickyC_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_0_1_1_Keyword_y(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_0_1_0_Action_C2_y(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: C2 . y = current }
protected class TrickyC_0_1_0_Action_C2_y extends ActionToken  {

	public TrickyC_0_1_0_Action_C2_y(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}	
}



// ( { current = complexrewritetest :: C3 . z = current } 'z' ) ?
protected class TrickyC_1_Group extends GroupToken {
	
	public TrickyC_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyC_1_1_Keyword_z(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyC_1_0_Action_C3_z(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = complexrewritetest :: C3 . z = current }
protected class TrickyC_1_0_Action_C3_z extends ActionToken  {

	public TrickyC_1_0_Action_C3_z(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@abstractTokens.0");
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@abstractTokens.1");
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_0_Keyword_TD(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// ( name += INT foo = STRING type += ID ) ?
protected class TrickyD_0_0_1_Group extends GroupToken {
	
	public TrickyD_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_0_1_0_1_Assignment_foo(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_0_1_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("foo",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("foo");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"); 
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyD_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyD_0_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.1/@terminal"); 
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_1_Keyword_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_0_Keyword_TE(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// ( name += INT foo += STRING type += ID ) *
protected class TrickyE_0_0_1_Group extends GroupToken {
	
	public TrickyE_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_0_0_1_0_1_Assignment_foo(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_0_0_1_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("foo",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("foo");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"); 
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( name += INT type += ID ) *
protected class TrickyE_1_Group extends GroupToken {
	
	public TrickyE_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyE_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyE_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"); 
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyF_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyF_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyF_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyF_0_0_Keyword_TF(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}	
}

// ( name += ID type += INT ) *
protected class TrickyF_0_1_Group extends GroupToken {
	
	public TrickyF_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TrickyF_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TrickyF_0_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"); 
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
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1");
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.0/@terminal"); 
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
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule TrickyF ****************/

}
