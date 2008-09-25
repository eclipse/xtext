/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class SimpleReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new Op_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Term_1_Alternatives(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Atom_0_Assignment_name(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Parens_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TwoNumbers_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new ManyStrings_0_Group(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Op ****************/


protected class Op_1_Group extends GroupToken {
	
	public Op_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Op_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Op_1_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Op_1_0_RuleCall extends RuleCallToken {
	
	public Op_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Term_1_Alternatives(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Op_1_1_Group extends GroupToken {
	
	public Op_1_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Op_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Op_1_1_1_Assignment_values(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Op_1_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Op_1_1_0_Action extends AssignmentToken  {

	public Op_1_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_0_Action(predecessor, true, false);
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

protected class Op_1_1_1_Assignment_values extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Op_1_1_1_Assignment_values(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_1_Assignment_values(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_1_Assignment_values(predecessor, true, false);
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
		// System.out.println("Op_1_1_1_Assignment_valuesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Term
	}
}



/************ end Rule Op ****************/
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
			case 1: t = new Term_1_0_Alternatives(predecessor); break;
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

protected class Term_1_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public Term_1_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_0_Alternatives(predecessor, true, false);
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
			case 0: t = new Term_1_0_1_RuleCall(predecessor); break;
			case 1: t = new Term_1_0_0_Alternatives(predecessor); break;
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

protected class Term_1_0_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public Term_1_0_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_0_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_0_0_Alternatives(predecessor, true, false);
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
			case 0: t = new Term_1_0_0_1_RuleCall(predecessor); break;
			case 1: t = new Term_1_0_0_0_RuleCall(predecessor); break;
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

protected class Term_1_0_0_0_RuleCall extends RuleCallToken {
	
	public Term_1_0_0_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_0_0_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_0_0_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Atom_0_Assignment_name(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Term_1_0_0_1_RuleCall extends RuleCallToken {
	
	public Term_1_0_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_0_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_0_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new TwoNumbers_0_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Term_1_0_1_RuleCall extends RuleCallToken {
	
	public Term_1_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Term_1_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Term_1_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new ManyStrings_0_Group(predecessor);
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.2/@alternatives/@terminal");
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
		AbstractToken t1 = new Parens_1_1_Assignment_em(predecessor);
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
		AbstractToken t1 = new Parens_1_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Parens_1_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Parens_1_0_0_Group extends GroupToken {
	
	public Parens_1_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Parens_1_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Parens_1_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Parens_1_0_0_1_RuleCall(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Parens_1_0_0_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Parens_1_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Parens_1_0_0_0_Keyword(AbstractToken predecessor) {
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

protected class Parens_1_0_0_1_RuleCall extends RuleCallToken {
	
	public Parens_1_0_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Parens_1_0_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Parens_1_0_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Op_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}



protected class Parens_1_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Parens_1_0_1_Keyword(AbstractToken predecessor) {
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


protected class Parens_1_1_Assignment_em extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Parens_1_1_Assignment_em(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private Parens_1_1_Assignment_em(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Parens_1_1_Assignment_em(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("em")) return null;
		value = obj.consume("em");
		// nothing special needs to be done for xtext::Keyword
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Parens_1_1_Assignment_emCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(object, (Keyword)element);
	}
}


/************ end Rule Parens ****************/
/************ begin Rule TwoNumbers ****************/


protected class TwoNumbers_0_Group extends GroupToken {
	
	public TwoNumbers_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TwoNumbers_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TwoNumbers_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TwoNumbers_0_1_Assignment_num2(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TwoNumbers_0_0_Assignment_num1(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TwoNumbers_0_0_Assignment_num1 extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TwoNumbers_0_0_Assignment_num1(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TwoNumbers_0_0_Assignment_num1(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TwoNumbers_0_0_Assignment_num1(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("num1")) return null;
		value = obj.consume("num1");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TwoNumbers_0_0_Assignment_num1Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TwoNumbers_0_1_Assignment_num2 extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TwoNumbers_0_1_Assignment_num2(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TwoNumbers_0_1_Assignment_num2(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TwoNumbers_0_1_Assignment_num2(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("num2")) return null;
		value = obj.consume("num2");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TwoNumbers_0_1_Assignment_num2Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule TwoNumbers ****************/
/************ begin Rule ManyStrings ****************/


protected class ManyStrings_0_Group extends GroupToken {
	
	public ManyStrings_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ManyStrings_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ManyStrings_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ManyStrings_0_1_Assignment_str2(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ManyStrings_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ManyStrings_0_0_Group extends GroupToken {
	
	public ManyStrings_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ManyStrings_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ManyStrings_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ManyStrings_0_0_1_Assignment_str1(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ManyStrings_0_0_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ManyStrings_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ManyStrings_0_0_0_Keyword(AbstractToken predecessor) {
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

protected class ManyStrings_0_0_1_Assignment_str1 extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ManyStrings_0_0_1_Assignment_str1(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private ManyStrings_0_0_1_Assignment_str1(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ManyStrings_0_0_1_Assignment_str1(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("str1")) return null;
		value = obj.consume("str1");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ManyStrings_0_0_1_Assignment_str1Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class ManyStrings_0_1_Assignment_str2 extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ManyStrings_0_1_Assignment_str2(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ManyStrings_0_1_Assignment_str2(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ManyStrings_0_1_Assignment_str2(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("str2")) return null;
		value = obj.consume("str2");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ManyStrings_0_1_Assignment_str2Callback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule ManyStrings ****************/
}
