/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class DummyLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new Model_0_Assignment_elements(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Element_0_Group(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Model ****************/


protected class Model_0_Assignment_elements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public Model_0_Assignment_elements(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Model_0_Assignment_elements(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Model_0_Assignment_elements(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("elements")) return null;
		value = obj.consume("elements");
		AbstractToken t = new Element_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Model_0_Assignment_elementsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Element
	}
}

/************ end Rule Model ****************/
/************ begin Rule Element ****************/


protected class Element_0_Group extends GroupToken {
	
	public Element_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Element_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Element_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_0_0_Group extends GroupToken {
	
	public Element_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Element_0_0_1_Assignment_descriptions(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Element_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_0_0_0_Group extends GroupToken {
	
	public Element_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Element_0_0_0_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Element_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_0_0_0_0_Group extends GroupToken {
	
	public Element_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Element_0_0_0_0_1_Keyword_element(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Element_0_0_0_0_0_Assignment_optional(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Element_0_0_0_0_0_Assignment_optional extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Element_0_0_0_0_0_Assignment_optional(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private Element_0_0_0_0_0_Assignment_optional(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_0_0_0_0_Assignment_optional(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("optional")) return null;
		value = obj.consume("optional");
		// nothing special needs to be done for xtext::Keyword
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_0_0_0_0_Assignment_optionalCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(object, (Keyword)element);
	}
}


protected class Element_0_0_0_0_1_Keyword_element extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Element_0_0_0_0_1_Keyword_element(AbstractToken predecessor) {
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


protected class Element_0_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_0_0_0_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Element_0_0_0_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_0_0_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class Element_0_0_1_Assignment_descriptions extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Element_0_0_1_Assignment_descriptions(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Element_0_0_1_Assignment_descriptions(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Element_0_0_1_Assignment_descriptions(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("descriptions")) return null;
		value = obj.consume("descriptions");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Element_0_0_1_Assignment_descriptionsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



protected class Element_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/dummy/DummyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1");
	
	public Element_0_1_Keyword(AbstractToken predecessor) {
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


/************ end Rule Element ****************/
}
