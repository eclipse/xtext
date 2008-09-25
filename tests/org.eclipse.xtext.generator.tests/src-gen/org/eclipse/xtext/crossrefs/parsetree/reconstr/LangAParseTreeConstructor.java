/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class LangAParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new Main_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Import_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Type_0_Group(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Main ****************/


protected class Main_0_Group extends GroupToken {
	
	public Main_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Main_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Main_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Main_0_1_Assignment_types(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Main_0_0_Assignment_imports(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Main_0_0_Assignment_imports extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Main_0_0_Assignment_imports(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Main_0_0_Assignment_imports(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Main_0_0_Assignment_imports(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("imports")) return null;
		value = obj.consume("imports");
		AbstractToken t = new Import_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Main_0_0_Assignment_importsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Import
	}
}

protected class Main_0_1_Assignment_types extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Main_0_1_Assignment_types(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Main_0_1_Assignment_types(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Main_0_1_Assignment_types(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("types")) return null;
		value = obj.consume("types");
		AbstractToken t = new Type_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Main_0_1_Assignment_typesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Type
	}
}


/************ end Rule Main ****************/
/************ begin Rule Import ****************/


protected class Import_0_Group extends GroupToken {
	
	public Import_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Import_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Import_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Import_0_1_Assignment_uri(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Import_0_0_Keyword_import(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Import_0_0_Keyword_import extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	
	public Import_0_0_Keyword_import(AbstractToken predecessor) {
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

protected class Import_0_1_Assignment_uri extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Import_0_1_Assignment_uri(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Import_0_1_Assignment_uri(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Import_0_1_Assignment_uri(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("uri")) return null;
		value = obj.consume("uri");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Import_0_1_Assignment_uriCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule Import ****************/
/************ begin Rule Type ****************/


protected class Type_0_Group extends GroupToken {
	
	public Type_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Type_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Type_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Type_0_1_Assignment_extends(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Type_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Type_0_0_Group extends GroupToken {
	
	public Type_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Type_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Type_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Type_0_0_1_Keyword_extends(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Type_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Type_0_0_0_Group extends GroupToken {
	
	public Type_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Type_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Type_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Type_0_0_0_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Type_0_0_0_0_Keyword_type(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Type_0_0_0_0_Keyword_type extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Type_0_0_0_0_Keyword_type(AbstractToken predecessor) {
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

protected class Type_0_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Type_0_0_0_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Type_0_0_0_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Type_0_0_0_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Type_0_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



protected class Type_0_0_1_Keyword_extends extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Type_0_0_1_Keyword_extends(AbstractToken predecessor) {
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


protected class Type_0_1_Assignment_extends extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Type_0_1_Assignment_extends(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Type_0_1_Assignment_extends(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Type_0_1_Assignment_extends(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("extends")) return null;
		value = obj.consume("extends");
		// FIXME: doing nothing for xtext::CrossReference
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Type_0_1_Assignment_extendsCallback(\"xtext::CrossReference\", " + value + ")");
		// FIXME: doing nothing for xtext::CrossReference
	}
}


/************ end Rule Type ****************/
}
