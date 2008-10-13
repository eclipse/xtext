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


public class SimpleReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Expression") && (s = new Op_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Term_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Atom") && (s = new Atom_Assignment_name(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Parens_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TwoNumbers") && (s = new TwoNumbers_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("ManyStrings") && (s = new ManyStrings_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Type") && (s = new Type_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Ref2") && (s = new Ref2_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Op ****************
 *
 * Op returns Expression : Term ( { current = Op . values += current } values += Term ) * ;
 *
 **/


// Term ( { current = Op . values += current } values += Term ) *
protected class Op_Group extends GroupToken {
	
	public Op_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Op_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Op_0_RuleCall_Term(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// Term
protected class Op_0_RuleCall_Term extends RuleCallToken {
	
	public Op_0_RuleCall_Term(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Term_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Term_Alternatives(current, this).firstSolution();
	}
}

// ( { current = Op . values += current } values += Term ) *
protected class Op_1_Group extends GroupToken {
	
	public Op_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Op_1_1_Assignment_values(current, this).firstSolution();
		if(s1 == null) return null;
		return new Op_1_0_Action_Op_values(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// { current = Op . values += current }
protected class Op_1_0_Action_Op_values extends AssignmentToken  {

	public Op_1_0_Action_Op_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Op")) return null;
		Object val = current.getConsumable("values", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("values")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// values += Term
protected class Op_1_1_Assignment_values extends AssignmentToken  {
	
	public Op_1_1_Assignment_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("values",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("values");
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
 * Term returns Expression : Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 ;
 *
 **/


// Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2
protected class Term_Alternatives extends AlternativesToken {

	public Term_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_1_RuleCall_Ref2(current, this) : new Term_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom | TwoNumbers | ManyStrings | Parens | Type
protected class Term_0_Alternatives extends AlternativesToken {

	public Term_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_1_RuleCall_Type(current, this) : new Term_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom | TwoNumbers | ManyStrings | Parens
protected class Term_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_1_RuleCall_Parens(current, this) : new Term_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom | TwoNumbers | ManyStrings
protected class Term_0_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_0_1_RuleCall_ManyStrings(current, this) : new Term_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom | TwoNumbers
protected class Term_0_0_0_0_Alternatives extends AlternativesToken {

	public Term_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_0_0_1_RuleCall_TwoNumbers(current, this) : new Term_0_0_0_0_0_RuleCall_Atom(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom
protected class Term_0_0_0_0_0_RuleCall_Atom extends RuleCallToken {
	
	public Term_0_0_0_0_0_RuleCall_Atom(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Atom_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("Atom")) return null;
		return new Atom_Assignment_name(current, this).firstSolution();
	}
}

// TwoNumbers
protected class Term_0_0_0_0_1_RuleCall_TwoNumbers extends RuleCallToken {
	
	public Term_0_0_0_0_1_RuleCall_TwoNumbers(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TwoNumbers_Group.class, current)) return null;
		if(!current.isInstanceOf("TwoNumbers")) return null;
		return new TwoNumbers_Group(current, this).firstSolution();
	}
}


// ManyStrings
protected class Term_0_0_0_1_RuleCall_ManyStrings extends RuleCallToken {
	
	public Term_0_0_0_1_RuleCall_ManyStrings(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(ManyStrings_Group.class, current)) return null;
		if(!current.isInstanceOf("ManyStrings")) return null;
		return new ManyStrings_Group(current, this).firstSolution();
	}
}


// Parens
protected class Term_0_0_1_RuleCall_Parens extends RuleCallToken {
	
	public Term_0_0_1_RuleCall_Parens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Parens_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Parens_Group(current, this).firstSolution();
	}
}


// Type
protected class Term_0_1_RuleCall_Type extends RuleCallToken {
	
	public Term_0_1_RuleCall_Type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Type_Group.class, current)) return null;
		if(!current.isInstanceOf("Type")) return null;
		return new Type_Group(current, this).firstSolution();
	}
}


// Ref2
protected class Term_1_RuleCall_Ref2 extends RuleCallToken {
	
	public Term_1_RuleCall_Ref2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Ref2_Group.class, current)) return null;
		if(!current.isInstanceOf("Ref2")) return null;
		return new Ref2_Group(current, this).firstSolution();
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
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.2/@alternatives/@terminal"); 
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
		
	protected Solution createSolution() {
		Solution s1 = new Parens_1_Assignment_em(current, this).firstSolution();
		if(s1 == null) return null;
		return new Parens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '(' Op ')'
protected class Parens_0_Group extends GroupToken {
	
	public Parens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Parens_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Parens_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '(' Op
protected class Parens_0_0_Group extends GroupToken {
	
	public Parens_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Parens_0_0_1_RuleCall_Op(current, this).firstSolution();
		if(s1 == null) return null;
		return new Parens_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '('
protected class Parens_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Parens_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// Op
protected class Parens_0_0_1_RuleCall_Op extends RuleCallToken {
	
	public Parens_0_0_1_RuleCall_Op(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Op_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Op_Group(current, this).firstSolution();
	}
}


// ')'
protected class Parens_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Parens_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// ( em = '!' ) ?
protected class Parens_1_Assignment_em extends AssignmentToken  {
	
	public Parens_1_Assignment_em(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("em",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("em");
		if("!".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal");
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Parens ****************/

/************ begin Rule TwoNumbers ****************
 *
 * TwoNumbers : num1 = INT num2 = INT ( '#' num3 += INT ) * ;
 *
 **/


// num1 = INT num2 = INT ( '#' num3 += INT ) *
protected class TwoNumbers_Group extends GroupToken {
	
	public TwoNumbers_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new TwoNumbers_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new TwoNumbers_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// num1 = INT num2 = INT
protected class TwoNumbers_0_Group extends GroupToken {
	
	public TwoNumbers_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new TwoNumbers_0_1_Assignment_num2(current, this).firstSolution();
		if(s1 == null) return null;
		return new TwoNumbers_0_0_Assignment_num1(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// num1 = INT
protected class TwoNumbers_0_0_Assignment_num1 extends AssignmentToken  {
	
	public TwoNumbers_0_0_Assignment_num1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("num1",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("num1");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// num2 = INT
protected class TwoNumbers_0_1_Assignment_num2 extends AssignmentToken  {
	
	public TwoNumbers_0_1_Assignment_num2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("num2",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("num2");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( '#' num3 += INT ) *
protected class TwoNumbers_1_Group extends GroupToken {
	
	public TwoNumbers_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new TwoNumbers_1_1_Assignment_num3(current, this).firstSolution();
		if(s1 == null) return null;
		return new TwoNumbers_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '#'
protected class TwoNumbers_1_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0");
	
	public TwoNumbers_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// num3 += INT
protected class TwoNumbers_1_1_Assignment_num3 extends AssignmentToken  {
	
	public TwoNumbers_1_1_Assignment_num3(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("num3",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("num3");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule TwoNumbers ****************/

/************ begin Rule ManyStrings ****************
 *
 * ManyStrings : '=' ( str1 += STRING ) * str2 += STRING ;
 *
 **/


// '=' ( str1 += STRING ) * str2 += STRING
protected class ManyStrings_Group extends GroupToken {
	
	public ManyStrings_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new ManyStrings_1_Assignment_str2(current, this).firstSolution();
		if(s1 == null) return null;
		return new ManyStrings_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '=' ( str1 += STRING ) *
protected class ManyStrings_0_Group extends GroupToken {
	
	public ManyStrings_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new ManyStrings_0_1_Assignment_str1(current, this).firstSolution();
		if(s1 == null) return null;
		return new ManyStrings_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '='
protected class ManyStrings_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ManyStrings_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// ( str1 += STRING ) *
protected class ManyStrings_0_1_Assignment_str1 extends AssignmentToken  {
	
	public ManyStrings_0_1_Assignment_str1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("str1",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("str1");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// str2 += STRING
protected class ManyStrings_1_Assignment_str2 extends AssignmentToken  {
	
	public ManyStrings_1_Assignment_str2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("str2",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("str2");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule ManyStrings ****************/

/************ begin Rule Type ****************
 *
 * Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
 *
 **/


// 'type' name = ID 'extends' ^extends = [ Type ]
protected class Type_Group extends GroupToken {
	
	public Type_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Type_1_Assignment_extends(current, this).firstSolution();
		if(s1 == null) return null;
		return new Type_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'type' name = ID 'extends'
protected class Type_0_Group extends GroupToken {
	
	public Type_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Type_0_1_Keyword_extends(current, this).firstSolution();
		if(s1 == null) return null;
		return new Type_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'type' name = ID
protected class Type_0_0_Group extends GroupToken {
	
	public Type_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Type_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Type_0_0_0_Keyword_type(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'type'
protected class Type_0_0_0_Keyword_type extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Type_0_0_0_Keyword_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// name = ID
protected class Type_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Type_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// 'extends'
protected class Type_0_1_Keyword_extends extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Type_0_1_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// ^extends = [ Type ]
protected class Type_1_Assignment_extends extends AssignmentToken  {
	
	public Type_1_Assignment_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("extends",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("extends");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Type")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


/************ end Rule Type ****************/

/************ begin Rule Ref2 ****************
 *
 * Ref2 : '#2' ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' ) ;
 *
 **/


// '#2' ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' )
protected class Ref2_Group extends GroupToken {
	
	public Ref2_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Ref2_1_Assignment_ref2(current, this).firstSolution();
		if(s1 == null) return null;
		return new Ref2_0_Keyword_2(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '#2'
protected class Ref2_0_Keyword_2 extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0");
	
	public Ref2_0_Keyword_2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' )
protected class Ref2_1_Assignment_ref2 extends AssignmentToken  {
	
	public Ref2_1_Assignment_ref2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ref2",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ref2");
		if("mykeyword1".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0");
			return new Solution(obj);
		}
		if("mykeyword2".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.1");
			return new Solution(obj);
		}
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Ref2 ****************/

}
