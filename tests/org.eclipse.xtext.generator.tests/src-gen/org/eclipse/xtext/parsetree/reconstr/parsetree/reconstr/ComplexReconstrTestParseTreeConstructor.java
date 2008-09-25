/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class ComplexReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

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
		t = new TrickyA_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TrickyA1_1_Assignment_name(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TrickyB_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TrickyC_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TrickyD_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TrickyE_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TrickyF_0_Group(null);
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
		AbstractToken t1 = new Op_1_1_Alternatives(predecessor);
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

protected class Op_1_1_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public Op_1_1_Alternatives(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Op_1_1_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_Alternatives(predecessor, true, false);
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
			case 0: t = new Op_1_1_1_Group(predecessor); break;
			case 1: t = new Op_1_1_0_Group(predecessor); break;
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

protected class Op_1_1_0_Group extends GroupToken {
	
	public Op_1_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Op_1_1_0_1_Assignment_addOperands(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Op_1_1_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Op_1_1_0_0_Group extends GroupToken {
	
	public Op_1_1_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Op_1_1_0_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Op_1_1_0_0_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Op_1_1_0_0_0_Action extends AssignmentToken  {

	public Op_1_1_0_0_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_0_0_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_0_0_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("addOperands")) return null;
		Object val = obj.consume("addOperands");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Op_1_1_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1");
	
	public Op_1_1_0_0_1_Keyword(AbstractToken predecessor) {
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


protected class Op_1_1_0_1_Assignment_addOperands extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Op_1_1_0_1_Assignment_addOperands(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_0_1_Assignment_addOperands(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_0_1_Assignment_addOperands(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("addOperands")) return null;
		value = obj.consume("addOperands");
		AbstractToken t = new Term_1_Alternatives(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Op_1_1_0_1_Assignment_addOperandsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Term
	}
}


protected class Op_1_1_1_Group extends GroupToken {
	
	public Op_1_1_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Op_1_1_1_1_Assignment_minusOperands(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Op_1_1_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Op_1_1_1_0_Group extends GroupToken {
	
	public Op_1_1_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Op_1_1_1_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Op_1_1_1_0_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Op_1_1_1_0_0_Action extends AssignmentToken  {

	public Op_1_1_1_0_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_1_0_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_1_0_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("minusOperands")) return null;
		Object val = obj.consume("minusOperands");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Op_1_1_1_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1");
	
	public Op_1_1_1_0_1_Keyword(AbstractToken predecessor) {
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


protected class Op_1_1_1_1_Assignment_minusOperands extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Op_1_1_1_1_Assignment_minusOperands(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Op_1_1_1_1_Assignment_minusOperands(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Op_1_1_1_1_Assignment_minusOperands(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("minusOperands")) return null;
		value = obj.consume("minusOperands");
		AbstractToken t = new Term_1_Alternatives(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Op_1_1_1_1_Assignment_minusOperandsCallback(\"xtext::RuleCall\", " + value + ")");
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.2/@alternatives/@terminal");
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

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
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

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
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

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal");
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
/************ begin Rule TrickyA ****************/


protected class TrickyA_1_Group extends GroupToken {
	
	public TrickyA_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyA_1_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyA_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyA_1_0_Group extends GroupToken {
	
	public TrickyA_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyA_1_0_1_Alternatives(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyA_1_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyA_1_0_0_Group extends GroupToken {
	
	public TrickyA_1_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyA_1_0_0_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyA_1_0_0_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyA_1_0_0_0_RuleCall extends RuleCallToken {
	
	public TrickyA_1_0_0_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_0_0_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_0_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new TrickyA1_1_Assignment_name(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyA_1_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyA_1_0_0_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyA_1_0_0_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_0_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyA_1_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class TrickyA_1_0_1_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public TrickyA_1_0_1_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyA_1_0_1_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_1_Alternatives(predecessor, true, false);
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
			case 0: t = new TrickyA_1_0_1_1_Group(predecessor); break;
			case 1: t = new TrickyA_1_0_1_0_Group(predecessor); break;
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

protected class TrickyA_1_0_1_0_Group extends GroupToken {
	
	public TrickyA_1_0_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_0_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyA_1_0_1_0_1_Keyword_x(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyA_1_0_1_0_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyA_1_0_1_0_0_Action extends AssignmentToken  {

	public TrickyA_1_0_1_0_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_0_1_0_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_1_0_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("x")) return null;
		Object val = obj.consume("x");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class TrickyA_1_0_1_0_1_Keyword_x extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1");
	
	public TrickyA_1_0_1_0_1_Keyword_x(AbstractToken predecessor) {
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


protected class TrickyA_1_0_1_1_Group extends GroupToken {
	
	public TrickyA_1_0_1_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_0_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyA_1_0_1_1_1_Keyword_y(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyA_1_0_1_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyA_1_0_1_1_0_Action extends AssignmentToken  {

	public TrickyA_1_0_1_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_0_1_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_0_1_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("x")) return null;
		Object val = obj.consume("x");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class TrickyA_1_0_1_1_1_Keyword_y extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.1");
	
	public TrickyA_1_0_1_1_1_Keyword_y(AbstractToken predecessor) {
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




protected class TrickyA_1_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyA_1_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA_1_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA_1_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyA_1_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule TrickyA ****************/
/************ begin Rule TrickyA1 ****************/


protected class TrickyA1_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.5/@alternatives/@terminal");
	protected Object value;
	
	public TrickyA1_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyA1_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyA1_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyA1_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

/************ end Rule TrickyA1 ****************/
/************ begin Rule TrickyB ****************/


protected class TrickyB_0_Group extends GroupToken {
	
	public TrickyB_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyB_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyB_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyB_0_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyB_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyB_0_0_Group extends GroupToken {
	
	public TrickyB_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyB_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyB_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyB_0_0_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyB_0_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyB_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyB_0_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyB_0_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyB_0_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyB_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyB_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyB_0_0_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyB_0_0_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyB_0_0_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyB_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class TrickyB_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyB_0_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyB_0_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyB_0_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyB_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule TrickyB ****************/
/************ begin Rule TrickyC ****************/


protected class TrickyC_0_Group extends GroupToken {
	
	public TrickyC_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyC_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyC_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyC_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyC_0_0_Group extends GroupToken {
	
	public TrickyC_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyC_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyC_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyC_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyC_0_0_0_Group extends GroupToken {
	
	public TrickyC_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyC_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyC_0_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyC_0_0_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyC_0_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyC_0_0_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyC_0_0_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_0_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyC_0_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyC_0_0_0_1_Group extends GroupToken {
	
	public TrickyC_0_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyC_0_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyC_0_0_0_1_1_Keyword_x(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyC_0_0_0_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyC_0_0_0_1_0_Action extends AssignmentToken  {

	public TrickyC_0_0_0_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyC_0_0_0_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_0_0_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("x")) return null;
		Object val = obj.consume("x");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class TrickyC_0_0_0_1_1_Keyword_x extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	
	public TrickyC_0_0_0_1_1_Keyword_x(AbstractToken predecessor) {
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



protected class TrickyC_0_0_1_Group extends GroupToken {
	
	public TrickyC_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyC_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyC_0_0_1_1_Keyword_y(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyC_0_0_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyC_0_0_1_0_Action extends AssignmentToken  {

	public TrickyC_0_0_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyC_0_0_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_0_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("y")) return null;
		Object val = obj.consume("y");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class TrickyC_0_0_1_1_Keyword_y extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	
	public TrickyC_0_0_1_1_Keyword_y(AbstractToken predecessor) {
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



protected class TrickyC_0_1_Group extends GroupToken {
	
	public TrickyC_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyC_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyC_0_1_1_Keyword_z(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyC_0_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyC_0_1_0_Action extends AssignmentToken  {

	public TrickyC_0_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyC_0_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyC_0_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("z")) return null;
		Object val = obj.consume("z");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class TrickyC_0_1_1_Keyword_z extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@abstractTokens.1");
	
	public TrickyC_0_1_1_Keyword_z(AbstractToken predecessor) {
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



/************ end Rule TrickyC ****************/
/************ begin Rule TrickyD ****************/


protected class TrickyD_0_Group extends GroupToken {
	
	public TrickyD_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyD_0_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyD_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyD_0_0_Group extends GroupToken {
	
	public TrickyD_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyD_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyD_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyD_0_0_0_Group extends GroupToken {
	
	public TrickyD_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyD_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyD_0_0_0_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyD_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyD_0_0_0_0_Group extends GroupToken {
	
	public TrickyD_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyD_0_0_0_0_1_Assignment_foo(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyD_0_0_0_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyD_0_0_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyD_0_0_0_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_0_0_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_0_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_0_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyD_0_0_0_0_1_Assignment_foo extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_0_0_0_0_1_Assignment_foo(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_0_0_0_1_Assignment_foo(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_0_0_1_Assignment_foo(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("foo")) return null;
		value = obj.consume("foo");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_0_0_0_1_Assignment_fooCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class TrickyD_0_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_0_0_0_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_0_0_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_0_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class TrickyD_0_0_1_Group extends GroupToken {
	
	public TrickyD_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyD_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyD_0_0_1_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyD_0_0_1_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyD_0_0_1_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyD_0_0_1_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_0_1_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_1_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_0_1_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyD_0_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_0_0_1_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyD_0_0_1_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_0_1_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



protected class TrickyD_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.8/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyD_0_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyD_0_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyD_0_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyD_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule TrickyD ****************/
/************ begin Rule TrickyE ****************/


protected class TrickyE_0_Group extends GroupToken {
	
	public TrickyE_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyE_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyE_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyE_0_0_Group extends GroupToken {
	
	public TrickyE_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyE_0_0_1_Keyword_x(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyE_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyE_0_0_0_Group extends GroupToken {
	
	public TrickyE_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyE_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyE_0_0_0_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyE_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyE_0_0_0_0_Group extends GroupToken {
	
	public TrickyE_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyE_0_0_0_0_1_Assignment_foo(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyE_0_0_0_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyE_0_0_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyE_0_0_0_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_0_0_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_0_0_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_0_0_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyE_0_0_0_0_1_Assignment_foo extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyE_0_0_0_0_1_Assignment_foo(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_0_0_0_1_Assignment_foo(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_0_0_0_1_Assignment_foo(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("foo")) return null;
		value = obj.consume("foo");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_0_0_0_0_1_Assignment_fooCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class TrickyE_0_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyE_0_0_0_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_0_0_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_0_0_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_0_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



protected class TrickyE_0_0_1_Keyword_x extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public TrickyE_0_0_1_Keyword_x(AbstractToken predecessor) {
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


protected class TrickyE_0_1_Group extends GroupToken {
	
	public TrickyE_0_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyE_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyE_0_1_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyE_0_1_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyE_0_1_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyE_0_1_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_1_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_1_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_0_1_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyE_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyE_0_1_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyE_0_1_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyE_0_1_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyE_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



/************ end Rule TrickyE ****************/
/************ begin Rule TrickyF ****************/


protected class TrickyF_0_Group extends GroupToken {
	
	public TrickyF_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyF_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyF_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyF_0_1_Alternatives(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyF_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyF_0_0_Group extends GroupToken {
	
	public TrickyF_0_0_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private TrickyF_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyF_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TrickyF_0_0_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TrickyF_0_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TrickyF_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TrickyF_0_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyF_0_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyF_0_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyF_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyF_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TrickyF_0_0_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyF_0_0_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyF_0_0_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyF_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class TrickyF_0_1_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public TrickyF_0_1_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyF_0_1_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyF_0_1_Alternatives(predecessor, true, false);
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
			case 0: t = new TrickyF_0_1_1_Assignment_type(predecessor); break;
			case 1: t = new TrickyF_0_1_0_Assignment_name(predecessor); break;
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

protected class TrickyF_0_1_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.0/@terminal");
	protected Object value;
	
	public TrickyF_0_1_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyF_0_1_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyF_0_1_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyF_0_1_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class TrickyF_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@groups.1/@terminal");
	protected Object value;
	
	public TrickyF_0_1_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TrickyF_0_1_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TrickyF_0_1_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TrickyF_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



/************ end Rule TrickyF ****************/
}
