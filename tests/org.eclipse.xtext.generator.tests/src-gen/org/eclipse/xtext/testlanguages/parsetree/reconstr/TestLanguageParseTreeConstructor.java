/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class TestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new EntryRule_1_Assignment_multiFeature(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new AbstractRule_1_Alternatives(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new ChoiceRule_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new ReducibleRule_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TerminalRule_1_Assignment_stringFeature(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule EntryRule ****************/


protected class EntryRule_1_Assignment_multiFeature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public EntryRule_1_Assignment_multiFeature(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private EntryRule_1_Assignment_multiFeature(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new EntryRule_1_Assignment_multiFeature(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("multiFeature")) return null;
		value = obj.consume("multiFeature");
		AbstractToken t = new AbstractRule_1_Alternatives(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("EntryRule_1_Assignment_multiFeatureCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractRule
	}
}

/************ end Rule EntryRule ****************/
/************ begin Rule AbstractRule ****************/


protected class AbstractRule_1_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractRule_1_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractRule_1_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractRule_1_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractRule_1_1_RuleCall(predecessor); break;
			case 1: t = new AbstractRule_1_0_RuleCall(predecessor); break;
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

protected class AbstractRule_1_0_RuleCall extends RuleCallToken {
	
	public AbstractRule_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractRule_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractRule_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new ChoiceRule_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class AbstractRule_1_1_RuleCall extends RuleCallToken {
	
	public AbstractRule_1_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractRule_1_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractRule_1_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new ReducibleRule_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


/************ end Rule AbstractRule ****************/
/************ begin Rule ChoiceRule ****************/


protected class ChoiceRule_1_Group extends GroupToken {
	
	public ChoiceRule_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ChoiceRule_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ChoiceRule_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ChoiceRule_1_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ChoiceRule_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ChoiceRule_1_0_Group extends GroupToken {
	
	public ChoiceRule_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ChoiceRule_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ChoiceRule_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ChoiceRule_1_0_1_Assignment_optionalKeyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ChoiceRule_1_0_0_Keyword_choice(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ChoiceRule_1_0_0_Keyword_choice extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ChoiceRule_1_0_0_Keyword_choice(AbstractToken predecessor) {
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

protected class ChoiceRule_1_0_1_Assignment_optionalKeyword extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ChoiceRule_1_0_1_Assignment_optionalKeyword(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private ChoiceRule_1_0_1_Assignment_optionalKeyword(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ChoiceRule_1_0_1_Assignment_optionalKeyword(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("optionalKeyword")) return null;
		value = obj.consume("optionalKeyword");
		// nothing special needs to be done for xtext::Keyword
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ChoiceRule_1_0_1_Assignment_optionalKeywordCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(object, (Keyword)element);
	}
}


protected class ChoiceRule_1_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ChoiceRule_1_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ChoiceRule_1_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ChoiceRule_1_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ChoiceRule_1_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule ChoiceRule ****************/
/************ begin Rule ReducibleRule ****************/


protected class ReducibleRule_1_Group extends GroupToken {
	
	public ReducibleRule_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReducibleRule_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReducibleRule_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ReducibleRule_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ReducibleRule_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ReducibleRule_1_0_Group extends GroupToken {
	
	public ReducibleRule_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReducibleRule_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReducibleRule_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ReducibleRule_1_0_1_RuleCall(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ReducibleRule_1_0_0_Keyword_reducible(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ReducibleRule_1_0_0_Keyword_reducible extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ReducibleRule_1_0_0_Keyword_reducible(AbstractToken predecessor) {
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

protected class ReducibleRule_1_0_1_RuleCall extends RuleCallToken {
	
	public ReducibleRule_1_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReducibleRule_1_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReducibleRule_1_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new TerminalRule_1_Assignment_stringFeature(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ReducibleRule_1_1_Group extends GroupToken {
	
	public ReducibleRule_1_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private ReducibleRule_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReducibleRule_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ReducibleRule_1_1_1_Assignment_actionFeature(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ReducibleRule_1_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ReducibleRule_1_1_0_Action extends AssignmentToken  {

	public ReducibleRule_1_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReducibleRule_1_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReducibleRule_1_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("actionFeature")) return null;
		Object val = obj.consume("actionFeature");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ReducibleRule_1_1_1_Assignment_actionFeature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ReducibleRule_1_1_1_Assignment_actionFeature(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReducibleRule_1_1_1_Assignment_actionFeature(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReducibleRule_1_1_1_Assignment_actionFeature(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("actionFeature")) return null;
		value = obj.consume("actionFeature");
		AbstractToken t = new TerminalRule_1_Assignment_stringFeature(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ReducibleRule_1_1_1_Assignment_actionFeatureCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TerminalRule
	}
}



/************ end Rule ReducibleRule ****************/
/************ begin Rule TerminalRule ****************/


protected class TerminalRule_1_Assignment_stringFeature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.4/@alternatives/@terminal");
	protected Object value;
	
	public TerminalRule_1_Assignment_stringFeature(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TerminalRule_1_Assignment_stringFeature(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TerminalRule_1_Assignment_stringFeature(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("stringFeature")) return null;
		value = obj.consume("stringFeature");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TerminalRule_1_Assignment_stringFeatureCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

/************ end Rule TerminalRule ****************/
}
