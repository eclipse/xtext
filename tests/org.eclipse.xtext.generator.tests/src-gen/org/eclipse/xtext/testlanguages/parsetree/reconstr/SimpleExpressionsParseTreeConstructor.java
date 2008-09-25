/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class SimpleExpressionsParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new Sequence_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Addition_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Multiplication_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Term_1_Alternatives(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Atom_0_Assignment_name(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Parens_1_Group(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Sequence ****************/


protected class Sequence_0_Group extends GroupToken {
	
	public Sequence_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Sequence_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Sequence_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Sequence_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Sequence_0_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Sequence_0_0_RuleCall extends RuleCallToken {
	
	public Sequence_0_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Sequence_0_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Sequence_0_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Addition_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Sequence_0_1_Group extends GroupToken {
	
	public Sequence_0_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Sequence_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Sequence_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Sequence_0_1_1_Assignment_expressions(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Sequence_0_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Sequence_0_1_0_Action extends AssignmentToken  {

	public Sequence_0_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Sequence_0_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Sequence_0_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("expressions")) return null;
		Object val = obj.consume("expressions");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Sequence_0_1_1_Assignment_expressions extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Sequence_0_1_1_Assignment_expressions(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Sequence_0_1_1_Assignment_expressions(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Sequence_0_1_1_Assignment_expressions(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("expressions")) return null;
		value = obj.consume("expressions");
		AbstractToken t = new Addition_1_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Sequence_0_1_1_Assignment_expressionsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Addition
	}
}



/************ end Rule Sequence ****************/
/************ begin Rule Addition ****************/


protected class Addition_1_Group extends GroupToken {
	
	public Addition_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Addition_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Addition_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Addition_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Addition_1_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Addition_1_0_RuleCall extends RuleCallToken {
	
	public Addition_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Addition_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Addition_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Multiplication_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Addition_1_1_Group extends GroupToken {
	
	public Addition_1_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Addition_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Addition_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Addition_1_1_1_Assignment_values(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Addition_1_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Addition_1_1_0_Group extends GroupToken {
	
	public Addition_1_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Addition_1_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Addition_1_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Addition_1_1_0_1_Assignment_operator(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Addition_1_1_0_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Addition_1_1_0_0_Action extends AssignmentToken  {

	public Addition_1_1_0_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Addition_1_1_0_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Addition_1_1_0_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("values")) return null;
		Object val = obj.consume("values");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Addition_1_1_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Addition_1_1_0_1_Assignment_operator(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Addition_1_1_0_1_Assignment_operator(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Addition_1_1_0_1_Assignment_operator(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("operator")) return null;
		value = obj.consume("operator");
		if("+".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
		else 		if("-".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Addition_1_1_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(object, (Keyword)element);
	}
}


protected class Addition_1_1_1_Assignment_values extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Addition_1_1_1_Assignment_values(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Addition_1_1_1_Assignment_values(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Addition_1_1_1_Assignment_values(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("values")) return null;
		value = obj.consume("values");
		AbstractToken t = new Multiplication_1_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Addition_1_1_1_Assignment_valuesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Multiplication
	}
}



/************ end Rule Addition ****************/
/************ begin Rule Multiplication ****************/


protected class Multiplication_1_Group extends GroupToken {
	
	public Multiplication_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Multiplication_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Multiplication_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Multiplication_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Multiplication_1_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Multiplication_1_0_RuleCall extends RuleCallToken {
	
	public Multiplication_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Multiplication_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Multiplication_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Term_1_Alternatives(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Multiplication_1_1_Group extends GroupToken {
	
	public Multiplication_1_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Multiplication_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Multiplication_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Multiplication_1_1_1_Assignment_values(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Multiplication_1_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Multiplication_1_1_0_Group extends GroupToken {
	
	public Multiplication_1_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Multiplication_1_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Multiplication_1_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Multiplication_1_1_0_1_Assignment_operator(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Multiplication_1_1_0_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Multiplication_1_1_0_0_Action extends AssignmentToken  {

	public Multiplication_1_1_0_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Multiplication_1_1_0_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Multiplication_1_1_0_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("values")) return null;
		Object val = obj.consume("values");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Multiplication_1_1_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Multiplication_1_1_0_1_Assignment_operator(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Multiplication_1_1_0_1_Assignment_operator(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Multiplication_1_1_0_1_Assignment_operator(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("operator")) return null;
		value = obj.consume("operator");
		if("*".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
		else 		if("/".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Multiplication_1_1_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(object, (Keyword)element);
	}
}


protected class Multiplication_1_1_1_Assignment_values extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Multiplication_1_1_1_Assignment_values(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Multiplication_1_1_1_Assignment_values(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Multiplication_1_1_1_Assignment_values(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("values")) return null;
		value = obj.consume("values");
		AbstractToken t = new Term_1_Alternatives(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Multiplication_1_1_1_Assignment_valuesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Term
	}
}



/************ end Rule Multiplication ****************/
/************ begin Rule Term ****************/


protected class Term_1_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public Term_1_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_Alternatives(predecessor, true, false);
	}

	
	protected boolean activateNextOption() {
		if(currentOption > 0) {
			currentOption--;
			return true;
		}
		return false;
	}
	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t, r;
		do {		
			switch(currentOption) {
			case 0: t = new Term_1_1_RuleCall(predecessor); break;
			case 1: t = new Term_1_0_RuleCall(predecessor); break;
			default: throw new RuntimeException("Undefinex Index: "+currentOption);
			}
			r = t.createFirstSolution(predecessor.getObject());
		} while (r == null && activateNextOption());
		//System.out.println("found:"+r);
		return r;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Term_1_0_RuleCall extends RuleCallToken {
	
	public Term_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Atom_0_Assignment_name(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Term_1_1_RuleCall extends RuleCallToken {
	
	public Term_1_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Parens_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


/************ end Rule Term ****************/
/************ begin Rule Atom ****************/


protected class Atom_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.4/@alternatives/@terminal");
	protected Object value;
	
	public Atom_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Atom_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Atom_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Atom_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

/************ end Rule Atom ****************/
/************ begin Rule Parens ****************/


protected class Parens_1_Group extends GroupToken {
	
	public Parens_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Parens_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Parens_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Parens_1_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Parens_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Parens_1_0_Group extends GroupToken {
	
	public Parens_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Parens_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Parens_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Parens_1_0_1_RuleCall(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Parens_1_0_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Parens_1_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public Parens_1_0_0_Keyword(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
		
	protected AbstractToken newInstance(AbstractToken predecessor) {
		throw new UnsupportedOperationException();
	}
	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(object, keyword);
	}
}

protected class Parens_1_0_1_RuleCall extends RuleCallToken {
	
	public Parens_1_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Parens_1_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Parens_1_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Addition_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}



protected class Parens_1_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.1");
	
	public Parens_1_1_Keyword(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
		
	protected AbstractToken newInstance(AbstractToken predecessor) {
		throw new UnsupportedOperationException();
	}
	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(object, keyword);
	}
}


/************ end Rule Parens ****************/
}
