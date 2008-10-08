/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class ComplexReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		callback.beginSerialize();
		t.getPredecessor().executeAllCallbacks(callback);
		callback.endSerialize();
		System.out.println("success!");
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if((s = new Op_Group(inst, null).firstSolution()) != null) return s;
		if((s = new Term_Alternatives(inst, null).firstSolution()) != null) return s;
		if((s = new Atom_Assignment_name(inst, null).firstSolution()) != null) return s;
		if((s = new Parens_Group(inst, null).firstSolution()) != null) return s;
		if((s = new TrickyA_Group(inst, null).firstSolution()) != null) return s;
		if((s = new TrickyA1_Assignment_name(inst, null).firstSolution()) != null) return s;
		if((s = new TrickyB_Group(inst, null).firstSolution()) != null) return s;
		if((s = new TrickyC_Group(inst, null).firstSolution()) != null) return s;
		if((s = new TrickyD_Group(inst, null).firstSolution()) != null) return s;
		if((s = new TrickyE_Group(inst, null).firstSolution()) != null) return s;
		if((s = new TrickyF_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Op ****************/


protected class Op_Group extends GroupToken {
	
	public Op_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Op_1_Alternatives(current, this).firstSolution();
		if(s1 == null) return null;
		return new Op_0_RuleCall_Term(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

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

protected class Op_1_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Op_1_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected boolean activateNextSolution() {
		if(first) {
			first = false;
			return true;
		}
		return false;
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Op_1_1_Group(current, this) : new Op_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class Op_1_0_Group extends GroupToken {
	
	public Op_1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Op_1_0_1_Assignment_addOperands(current, this).firstSolution();
		if(s1 == null) return null;
		return new Op_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Op_1_0_0_Group extends GroupToken {
	
	public Op_1_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Op_1_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Op_1_0_0_0_Action_Add_addOperands(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Op_1_0_0_0_Action_Add_addOperands extends AssignmentToken  {

	public Op_1_0_0_0_Action_Add_addOperands(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Add")) return null;
		if(!current.isConsumable("addOperands")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("addOperands");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}


protected class Op_1_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1");
	
	public Op_1_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


protected class Op_1_0_1_Assignment_addOperands extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Op_1_0_1_Assignment_addOperands(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("addOperands")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("addOperands");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Expression")) return null;
		AbstractToken t = new Term_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Op_1_0_1_Assignment_addOperandsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Term
	}
}


protected class Op_1_1_Group extends GroupToken {
	
	public Op_1_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Op_1_1_1_Assignment_minusOperands(current, this).firstSolution();
		if(s1 == null) return null;
		return new Op_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Op_1_1_0_Group extends GroupToken {
	
	public Op_1_1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Op_1_1_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Op_1_1_0_0_Action_Minus_minusOperands(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Op_1_1_0_0_Action_Minus_minusOperands extends AssignmentToken  {

	public Op_1_1_0_0_Action_Minus_minusOperands(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Minus")) return null;
		if(!current.isConsumable("minusOperands")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("minusOperands");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}


protected class Op_1_1_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1");
	
	public Op_1_1_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


protected class Op_1_1_1_Assignment_minusOperands extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Op_1_1_1_Assignment_minusOperands(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("minusOperands")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("minusOperands");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Expression")) return null;
		AbstractToken t = new Term_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Op_1_1_1_Assignment_minusOperandsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Term
	}
}




/************ end Rule Op ****************/
/************ begin Rule Term ****************/


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
		AbstractToken t = (first) ? new Term_1_RuleCall_Parens(current, this) : new Term_0_RuleCall_Atom(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class Term_0_RuleCall_Atom extends RuleCallToken {
	
	public Term_0_RuleCall_Atom(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Atom_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("Atom")) return null;
		return new Atom_Assignment_name(current, this).firstSolution();
	}
}

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
/************ begin Rule Atom ****************/


protected class Atom_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.2/@alternatives/@terminal");
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
/************ begin Rule Parens ****************/


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


protected class Parens_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
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



protected class Parens_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
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


protected class Parens_1_Assignment_em extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal");
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
/************ begin Rule TrickyA ****************/


protected class TrickyA_Group extends GroupToken {
	
	public TrickyA_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyA_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyA_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyA_0_Group extends GroupToken {
	
	public TrickyA_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyA_0_1_Alternatives(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyA_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyA_0_0_Group extends GroupToken {
	
	public TrickyA_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyA_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyA_0_0_0_RuleCall_TrickyA1(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyA_0_0_0_RuleCall_TrickyA1 extends RuleCallToken {
	
	public TrickyA_0_0_0_RuleCall_TrickyA1(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(TrickyA1_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("TypeD")) return null;
		return new TrickyA1_Assignment_name(current, this).firstSolution();
	}
}

protected class TrickyA_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyA_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("name")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("name");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyA_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


protected class TrickyA_0_1_Alternatives extends GroupToken {
	
	private boolean first = true;

	public TrickyA_0_1_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

	
	protected boolean activateNextSolution() {
		if(first) {
			first = false;
			return true;
		}
		return false;
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TrickyA_0_1_1_Group(current, this) : new TrickyA_0_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class TrickyA_0_1_0_Group extends GroupToken {
	
	public TrickyA_0_1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyA_0_1_0_1_Keyword_x(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyA_0_1_0_0_Action_TypeB_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyA_0_1_0_0_Action_TypeB_x extends AssignmentToken  {

	public TrickyA_0_1_0_0_Action_TypeB_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("TypeB")) return null;
		if(!current.isConsumable("x")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("x");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}


protected class TrickyA_0_1_0_1_Keyword_x extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1");
	
	public TrickyA_0_1_0_1_Keyword_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


protected class TrickyA_0_1_1_Group extends GroupToken {
	
	public TrickyA_0_1_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyA_0_1_1_1_Keyword_y(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyA_0_1_1_0_Action_TypeC_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyA_0_1_1_0_Action_TypeC_x extends AssignmentToken  {

	public TrickyA_0_1_1_0_Action_TypeC_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("TypeC")) return null;
		if(!current.isConsumable("x")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("x");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}


protected class TrickyA_0_1_1_1_Keyword_y extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.1");
	
	public TrickyA_0_1_1_1_Keyword_y(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}




protected class TrickyA_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyA_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyA_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule TrickyA ****************/
/************ begin Rule TrickyA1 ****************/


protected class TrickyA1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.5/@alternatives/@terminal");
	protected Object value;
	
	public TrickyA1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyA1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

/************ end Rule TrickyA1 ****************/
/************ begin Rule TrickyB ****************/


protected class TrickyB_Group extends GroupToken {
	
	public TrickyB_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyB_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyB_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyB_0_Group extends GroupToken {
	
	public TrickyB_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyB_0_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyB_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyB_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyB_0_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyB_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyB_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyB_0_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyB_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


protected class TrickyB_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyB_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyB_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule TrickyB ****************/
/************ begin Rule TrickyC ****************/


protected class TrickyC_Group extends GroupToken {
	
	public TrickyC_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyC_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyC_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyC_0_Group extends GroupToken {
	
	public TrickyC_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyC_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyC_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyC_0_0_Group extends GroupToken {
	
	public TrickyC_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyC_0_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyC_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyC_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyC_0_0_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyC_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyC_0_0_1_Group extends GroupToken {
	
	public TrickyC_0_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyC_0_0_1_1_Keyword_x(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyC_0_0_1_0_Action_C1_x(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyC_0_0_1_0_Action_C1_x extends AssignmentToken  {

	public TrickyC_0_0_1_0_Action_C1_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("C1")) return null;
		if(!current.isConsumable("x")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("x");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}


protected class TrickyC_0_0_1_1_Keyword_x extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	
	public TrickyC_0_0_1_1_Keyword_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}



protected class TrickyC_0_1_Group extends GroupToken {
	
	public TrickyC_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyC_0_1_1_Keyword_y(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyC_0_1_0_Action_C2_y(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyC_0_1_0_Action_C2_y extends AssignmentToken  {

	public TrickyC_0_1_0_Action_C2_y(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("C2")) return null;
		if(!current.isConsumable("y")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("y");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}


protected class TrickyC_0_1_1_Keyword_y extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	
	public TrickyC_0_1_1_Keyword_y(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}



protected class TrickyC_1_Group extends GroupToken {
	
	public TrickyC_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyC_1_1_Keyword_z(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyC_1_0_Action_C3_z(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyC_1_0_Action_C3_z extends AssignmentToken  {

	public TrickyC_1_0_Action_C3_z(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("C3")) return null;
		if(!current.isConsumable("z")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("z");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}


protected class TrickyC_1_1_Keyword_z extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@abstractTokens.1");
	
	public TrickyC_1_1_Keyword_z(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}



/************ end Rule TrickyC ****************/
/************ begin Rule TrickyD ****************/


protected class TrickyD_Group extends GroupToken {
	
	public TrickyD_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyD_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyD_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyD_0_Group extends GroupToken {
	
	public TrickyD_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyD_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyD_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyD_0_0_Group extends GroupToken {
	
	public TrickyD_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyD_0_0_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyD_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyD_0_0_0_Group extends GroupToken {
	
	public TrickyD_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyD_0_0_0_1_Assignment_foo(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyD_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyD_0_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyD_0_0_0_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyD_0_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyD_0_0_0_1_Assignment_foo extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_0_0_0_1_Assignment_foo(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("foo")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("foo");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_0_0_1_Assignment_fooCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


protected class TrickyD_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_0_0_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


protected class TrickyD_0_1_Group extends GroupToken {
	
	public TrickyD_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyD_0_1_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyD_0_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyD_0_1_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyD_0_1_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyD_0_1_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyD_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_0_1_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



protected class TrickyD_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule TrickyD ****************/
/************ begin Rule TrickyE ****************/


protected class TrickyE_Group extends GroupToken {
	
	public TrickyE_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyE_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyE_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyE_0_Group extends GroupToken {
	
	public TrickyE_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyE_0_1_Keyword_x(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyE_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyE_0_0_Group extends GroupToken {
	
	public TrickyE_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyE_0_0_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyE_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyE_0_0_0_Group extends GroupToken {
	
	public TrickyE_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyE_0_0_0_1_Assignment_foo(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyE_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyE_0_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyE_0_0_0_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyE_0_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyE_0_0_0_1_Assignment_foo extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyE_0_0_0_1_Assignment_foo(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("foo")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("foo");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_0_0_0_1_Assignment_fooCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


protected class TrickyE_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyE_0_0_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



protected class TrickyE_0_1_Keyword_x extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public TrickyE_0_1_Keyword_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


protected class TrickyE_1_Group extends GroupToken {
	
	public TrickyE_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyE_1_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyE_1_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyE_1_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyE_1_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyE_1_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyE_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyE_1_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



/************ end Rule TrickyE ****************/
/************ begin Rule TrickyF ****************/


protected class TrickyF_Group extends GroupToken {
	
	public TrickyF_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyF_1_Alternatives(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyF_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyF_0_Group extends GroupToken {
	
	public TrickyF_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TrickyF_0_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new TrickyF_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class TrickyF_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyF_0_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyF_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyF_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyF_0_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyF_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


protected class TrickyF_1_Alternatives extends GroupToken {
	
	private boolean first = true;

	public TrickyF_1_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new TrickyF_1_1_Assignment_type(current, this) : new TrickyF_1_0_Assignment_name(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class TrickyF_1_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.0/@terminal");
	protected Object value;
	
	public TrickyF_1_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TrickyF_1_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

protected class TrickyF_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.1/@terminal");
	protected Object value;
	
	public TrickyF_1_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyF_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



/************ end Rule TrickyF ****************/
}
