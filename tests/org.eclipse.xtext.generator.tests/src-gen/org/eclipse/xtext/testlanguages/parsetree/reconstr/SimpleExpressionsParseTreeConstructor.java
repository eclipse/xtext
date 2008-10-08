/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class SimpleExpressionsParseTreeConstructor extends AbstractParseTreeConstructor {

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
		if((s = new Sequence_Group(inst, null).firstSolution()) != null) return s;
		if((s = new Addition_Group(inst, null).firstSolution()) != null) return s;
		if((s = new Multiplication_Group(inst, null).firstSolution()) != null) return s;
		if((s = new Term_Alternatives(inst, null).firstSolution()) != null) return s;
		if((s = new Atom_Assignment_name(inst, null).firstSolution()) != null) return s;
		if((s = new Parens_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Sequence ****************/


protected class Sequence_Group extends GroupToken {
	
	public Sequence_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Sequence_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Sequence_0_RuleCall_Addition(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Sequence_0_RuleCall_Addition extends RuleCallToken {
	
	public Sequence_0_RuleCall_Addition(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Addition_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Addition_Group(current, this).firstSolution();
	}
}

protected class Sequence_1_Group extends GroupToken {
	
	public Sequence_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Sequence_1_1_Assignment_expressions(current, this).firstSolution();
		if(s1 == null) return null;
		return new Sequence_1_0_Action_Sequence_expressions(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Sequence_1_0_Action_Sequence_expressions extends AssignmentToken  {

	public Sequence_1_0_Action_Sequence_expressions(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Sequence")) return null;
		if(!current.isConsumable("expressions")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("expressions");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}

protected class Sequence_1_1_Assignment_expressions extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Sequence_1_1_Assignment_expressions(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("expressions")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("expressions");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Expression")) return null;
		AbstractToken t = new Addition_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Sequence_1_1_Assignment_expressionsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Addition
	}
}



/************ end Rule Sequence ****************/
/************ begin Rule Addition ****************/


protected class Addition_Group extends GroupToken {
	
	public Addition_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Addition_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Addition_0_RuleCall_Multiplication(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Addition_0_RuleCall_Multiplication extends RuleCallToken {
	
	public Addition_0_RuleCall_Multiplication(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Multiplication_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Multiplication_Group(current, this).firstSolution();
	}
}

protected class Addition_1_Group extends GroupToken {
	
	public Addition_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Addition_1_1_Assignment_values(current, this).firstSolution();
		if(s1 == null) return null;
		return new Addition_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Addition_1_0_Group extends GroupToken {
	
	public Addition_1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Addition_1_0_1_Assignment_operator(current, this).firstSolution();
		if(s1 == null) return null;
		return new Addition_1_0_0_Action_Op_values(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Addition_1_0_0_Action_Op_values extends AssignmentToken  {

	public Addition_1_0_0_Action_Op_values(InstanceDescription curr, AbstractToken pred) {
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

protected class Addition_1_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Addition_1_0_1_Assignment_operator(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("operator")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("operator");
		// handling xtext::Alternatives
		if("+".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
		else 		if("-".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Addition_1_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(current, (Keyword)element);
	}
}


protected class Addition_1_1_Assignment_values extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Addition_1_1_Assignment_values(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("values")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("values");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Expression")) return null;
		AbstractToken t = new Multiplication_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Addition_1_1_Assignment_valuesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Multiplication
	}
}



/************ end Rule Addition ****************/
/************ begin Rule Multiplication ****************/


protected class Multiplication_Group extends GroupToken {
	
	public Multiplication_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Multiplication_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Multiplication_0_RuleCall_Term(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Multiplication_0_RuleCall_Term extends RuleCallToken {
	
	public Multiplication_0_RuleCall_Term(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Term_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Term_Alternatives(current, this).firstSolution();
	}
}

protected class Multiplication_1_Group extends GroupToken {
	
	public Multiplication_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Multiplication_1_1_Assignment_values(current, this).firstSolution();
		if(s1 == null) return null;
		return new Multiplication_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Multiplication_1_0_Group extends GroupToken {
	
	public Multiplication_1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Multiplication_1_0_1_Assignment_operator(current, this).firstSolution();
		if(s1 == null) return null;
		return new Multiplication_1_0_0_Action_Op_values(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Multiplication_1_0_0_Action_Op_values extends AssignmentToken  {

	public Multiplication_1_0_0_Action_Op_values(InstanceDescription curr, AbstractToken pred) {
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

protected class Multiplication_1_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Multiplication_1_0_1_Assignment_operator(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("operator")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("operator");
		// handling xtext::Alternatives
		if("*".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
		else 		if("/".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Multiplication_1_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(current, (Keyword)element);
	}
}


protected class Multiplication_1_1_Assignment_values extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Multiplication_1_1_Assignment_values(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Multiplication_1_1_Assignment_valuesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Term
	}
}



/************ end Rule Multiplication ****************/
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.4/@alternatives/@terminal");
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
		Solution s1 = new Parens_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Parens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class Parens_0_Group extends GroupToken {
	
	public Parens_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Parens_0_1_RuleCall_Addition(current, this).firstSolution();
		if(s1 == null) return null;
		return new Parens_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}


protected class Parens_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public Parens_0_0_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

protected class Parens_0_1_RuleCall_Addition extends RuleCallToken {
	
	public Parens_0_1_RuleCall_Addition(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Addition_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Addition_Group(current, this).firstSolution();
	}
}



protected class Parens_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.1");
	
	public Parens_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule Parens ****************/
}
