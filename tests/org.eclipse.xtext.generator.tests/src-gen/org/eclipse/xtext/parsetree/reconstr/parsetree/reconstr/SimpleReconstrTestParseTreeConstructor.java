/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr;


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
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Expression") && (s = new Op_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Term_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Atom") && (s = new Atom_Assignment_name(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Parens_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TwoNumbers") && (s = new TwoNumbers_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("ManyStrings") && (s = new ManyStrings_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Op ****************
 *
 * Op returns Expression : Term ( { current = Op . values += current } values += Term ) * ;
 *
 **/


// Term ( { current = Op . values += current } values += Term ) *
protected class Op_Group extends GroupToken {
	
	public Op_Group(InstanceDescription curr, AbstractToken pred) {
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
	
	public Op_0_RuleCall_Term(InstanceDescription curr, AbstractToken pred) {
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
	
	public Op_1_Group(InstanceDescription curr, AbstractToken pred) {
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

	public Op_1_0_Action_Op_values(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Op")) return null;
		if(!current.isConsumable("values")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("values");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// values += Term
protected class Op_1_1_Assignment_values extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Op_1_1_Assignment_values(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("values")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("values");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Expression")) return null;
		AbstractToken t = new Term_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Op_1_1_Assignment_valuesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Term
	}
}



/************ end Rule Op ****************/

/************ begin Rule Term ****************
 *
 * Term returns Expression : Atom | TwoNumbers | ManyStrings | Parens ;
 *
 **/


// Atom | TwoNumbers | ManyStrings | Parens
protected class Term_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Term_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected boolean activateNextSolution() {
		if(first) {
			first = false;
			return true;
		}
		return false;
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_1_RuleCall_Parens(current, this) : new Term_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom | TwoNumbers | ManyStrings
protected class Term_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Term_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected boolean activateNextSolution() {
		if(first) {
			first = false;
			return true;
		}
		return false;
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_1_RuleCall_ManyStrings(current, this) : new Term_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom | TwoNumbers
protected class Term_0_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Term_0_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected boolean activateNextSolution() {
		if(first) {
			first = false;
			return true;
		}
		return false;
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_0_0_1_RuleCall_TwoNumbers(current, this) : new Term_0_0_0_RuleCall_Atom(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Atom
protected class Term_0_0_0_RuleCall_Atom extends RuleCallToken {
	
	public Term_0_0_0_RuleCall_Atom(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Atom_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("Atom")) return null;
		return new Atom_Assignment_name(current, this).firstSolution();
	}
}

// TwoNumbers
protected class Term_0_0_1_RuleCall_TwoNumbers extends RuleCallToken {
	
	public Term_0_0_1_RuleCall_TwoNumbers(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(TwoNumbers_Group.class, current)) return null;
		if(!current.isInstanceOf("TwoNumbers")) return null;
		return new TwoNumbers_Group(current, this).firstSolution();
	}
}


// ManyStrings
protected class Term_0_1_RuleCall_ManyStrings extends RuleCallToken {
	
	public Term_0_1_RuleCall_ManyStrings(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(ManyStrings_Group.class, current)) return null;
		if(!current.isInstanceOf("ManyStrings")) return null;
		return new ManyStrings_Group(current, this).firstSolution();
	}
}


// Parens
protected class Term_1_RuleCall_Parens extends RuleCallToken {
	
	public Term_1_RuleCall_Parens(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.2/@alternatives/@terminal");
	protected Object value;
	
	public Atom_Assignment_name(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("name")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("name");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Atom_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
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
	
	public Parens_Group(InstanceDescription curr, AbstractToken pred) {
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
	
	public Parens_0_Group(InstanceDescription curr, AbstractToken pred) {
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
	
	public Parens_0_0_Group(InstanceDescription curr, AbstractToken pred) {
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
	
	public Parens_0_0_0_Keyword(InstanceDescription curr, AbstractToken pred) {
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
	
	public Parens_0_0_1_RuleCall_Op(InstanceDescription curr, AbstractToken pred) {
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
	
	public Parens_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Parens_1_Assignment_em(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("em")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("em");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Parens_1_Assignment_emCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}


/************ end Rule Parens ****************/

/************ begin Rule TwoNumbers ****************
 *
 * TwoNumbers : num1 = INT num2 = INT ;
 *
 **/


// num1 = INT num2 = INT
protected class TwoNumbers_Group extends GroupToken {
	
	public TwoNumbers_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TwoNumbers_1_Assignment_num2(current, this).firstSolution();
		if(s1 == null) return null;
		return new TwoNumbers_0_Assignment_num1(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// num1 = INT
protected class TwoNumbers_0_Assignment_num1 extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TwoNumbers_0_Assignment_num1(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("num1")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("num1");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TwoNumbers_0_Assignment_num1Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

// num2 = INT
protected class TwoNumbers_1_Assignment_num2 extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TwoNumbers_1_Assignment_num2(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("num2")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("num2");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TwoNumbers_1_Assignment_num2Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
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
	
	public ManyStrings_Group(InstanceDescription curr, AbstractToken pred) {
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
	
	public ManyStrings_0_Group(InstanceDescription curr, AbstractToken pred) {
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
	
	public ManyStrings_0_0_Keyword(InstanceDescription curr, AbstractToken pred) {
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ManyStrings_0_1_Assignment_str1(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("str1")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("str1");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ManyStrings_0_1_Assignment_str1Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// str2 += STRING
protected class ManyStrings_1_Assignment_str2 extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ManyStrings_1_Assignment_str2(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("str2")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("str2");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ManyStrings_1_Assignment_str2Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule ManyStrings ****************/

}
