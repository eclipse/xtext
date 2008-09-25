/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class XtextParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		AbstractToken t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		t.executeAllCallbacks(callback);
		System.out.println("success!");
	}
	
	protected AbstractToken internalSerialize(EObject obj) {
		AbstractToken t = new Grammar_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new AbstractRule_0_Alternatives(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new AbstractMetamodelDeclaration_0_Alternatives(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new GeneratedMetamodel_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new ReferencedMetamodel_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new LexerRule_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new ParserRule_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new TypeRef_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Alternatives_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Group_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new AbstractToken_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Assignment_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Action_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new AbstractTerminal_1_Alternatives(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new CrossReference_0_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new ParenthesizedElement_1_Group(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new Keyword_0_Assignment_value(null);
		t = t.createFirstSolution(getDescr(obj));
		if(t != null) return t;
		t = new RuleCall_0_Assignment_name(null);
		return t.createFirstSolution(getDescr(obj));
	}
	
/************ begin Rule Grammar ****************/


protected class Grammar_0_Group extends GroupToken {
	
	public Grammar_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_1_Assignment_rules(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Grammar_0_0_Group extends GroupToken {
	
	public Grammar_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_1_Assignment_metamodelDeclarations(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Grammar_0_0_0_Group extends GroupToken {
	
	public Grammar_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Grammar_0_0_0_0_Group extends GroupToken {
	
	public Grammar_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Grammar_0_0_0_0_0_Group extends GroupToken {
	
	public Grammar_0_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_0_0_0_1_Assignment_idElements(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_0_0_0_Alternatives(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Grammar_0_0_0_0_0_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public Grammar_0_0_0_0_0_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_0_0_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_0_0_0_Alternatives(predecessor, true, false);
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
			case 0: t = new Grammar_0_0_0_0_0_0_1_Keyword_language(predecessor); break;
			case 1: t = new Grammar_0_0_0_0_0_0_0_Assignment_abstract(predecessor); break;
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

protected class Grammar_0_0_0_0_0_0_0_Assignment_abstract extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_0_0_0_0_Assignment_abstract(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_0_0_0_0_Assignment_abstract(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_0_0_0_0_Assignment_abstract(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("abstract")) return null;
		value = obj.consume("abstract");
		// nothing special needs to be done for xtext::Keyword
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_0_0_0_0_Assignment_abstractCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(object, (Keyword)element);
	}
}


protected class Grammar_0_0_0_0_0_0_1_Keyword_language extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1");
	
	public Grammar_0_0_0_0_0_0_1_Keyword_language(AbstractToken predecessor) {
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


protected class Grammar_0_0_0_0_0_1_Assignment_idElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_0_0_1_Assignment_idElements(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_0_0_1_Assignment_idElements(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_0_0_1_Assignment_idElements(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("idElements")) return null;
		value = obj.consume("idElements");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_0_0_1_Assignment_idElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class Grammar_0_0_0_0_1_Group extends GroupToken {
	
	public Grammar_0_0_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Grammar_0_0_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_0_0_1_1_Assignment_idElements(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_0_1_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Grammar_0_0_0_0_1_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public Grammar_0_0_0_0_1_0_Keyword(AbstractToken predecessor) {
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

protected class Grammar_0_0_0_0_1_1_Assignment_idElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_0_1_1_Assignment_idElements(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_0_1_1_Assignment_idElements(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_0_1_1_Assignment_idElements(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("idElements")) return null;
		value = obj.consume("idElements");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_0_1_1_Assignment_idElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



protected class Grammar_0_0_0_1_Group extends GroupToken {
	
	public Grammar_0_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private Grammar_0_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_0_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Grammar_0_0_0_1_0_Group extends GroupToken {
	
	public Grammar_0_0_0_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_0_1_0_1_Assignment_superGrammarIdElements(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_1_0_0_Keyword_extends(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Grammar_0_0_0_1_0_0_Keyword_extends extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	
	public Grammar_0_0_0_1_0_0_Keyword_extends(AbstractToken predecessor) {
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

protected class Grammar_0_0_0_1_0_1_Assignment_superGrammarIdElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_1_0_1_Assignment_superGrammarIdElements(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_1_0_1_Assignment_superGrammarIdElements(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_1_0_1_Assignment_superGrammarIdElements(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("superGrammarIdElements")) return null;
		value = obj.consume("superGrammarIdElements");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_1_0_1_Assignment_superGrammarIdElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class Grammar_0_0_0_1_1_Group extends GroupToken {
	
	public Grammar_0_0_0_1_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Grammar_0_0_0_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Grammar_0_0_0_1_1_1_Assignment_superGrammarIdElements(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Grammar_0_0_0_1_1_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Grammar_0_0_0_1_1_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0");
	
	public Grammar_0_0_0_1_1_0_Keyword(AbstractToken predecessor) {
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

protected class Grammar_0_0_0_1_1_1_Assignment_superGrammarIdElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_1_1_1_Assignment_superGrammarIdElements(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_0_0_1_1_1_Assignment_superGrammarIdElements(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_0_1_1_1_Assignment_superGrammarIdElements(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("superGrammarIdElements")) return null;
		value = obj.consume("superGrammarIdElements");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_1_1_1_Assignment_superGrammarIdElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}




protected class Grammar_0_0_1_Assignment_metamodelDeclarations extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_1_Assignment_metamodelDeclarations(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Grammar_0_0_1_Assignment_metamodelDeclarations(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_0_1_Assignment_metamodelDeclarations(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("metamodelDeclarations")) return null;
		value = obj.consume("metamodelDeclarations");
		AbstractToken t = new AbstractMetamodelDeclaration_0_Alternatives(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_1_Assignment_metamodelDeclarationsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractMetamodelDeclaration
	}
}


protected class Grammar_0_1_Assignment_rules extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_1_Assignment_rules(AbstractToken predecessor) {
		super(predecessor, IS_MANY, IS_REQUIRED);
	}
	
	private Grammar_0_1_Assignment_rules(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Grammar_0_1_Assignment_rules(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("rules")) return null;
		value = obj.consume("rules");
		AbstractToken t = new AbstractRule_0_Alternatives(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_1_Assignment_rulesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractRule
	}
}


/************ end Rule Grammar ****************/
/************ begin Rule AbstractRule ****************/


protected class AbstractRule_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractRule_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractRule_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractRule_0_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractRule_0_1_RuleCall(predecessor); break;
			case 1: t = new AbstractRule_0_0_RuleCall(predecessor); break;
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

protected class AbstractRule_0_0_RuleCall extends RuleCallToken {
	
	public AbstractRule_0_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractRule_0_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractRule_0_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new LexerRule_0_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class AbstractRule_0_1_RuleCall extends RuleCallToken {
	
	public AbstractRule_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractRule_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractRule_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new ParserRule_0_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


/************ end Rule AbstractRule ****************/
/************ begin Rule AbstractMetamodelDeclaration ****************/


protected class AbstractMetamodelDeclaration_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractMetamodelDeclaration_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractMetamodelDeclaration_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractMetamodelDeclaration_0_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractMetamodelDeclaration_0_1_RuleCall(predecessor); break;
			case 1: t = new AbstractMetamodelDeclaration_0_0_RuleCall(predecessor); break;
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

protected class AbstractMetamodelDeclaration_0_0_RuleCall extends RuleCallToken {
	
	public AbstractMetamodelDeclaration_0_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractMetamodelDeclaration_0_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractMetamodelDeclaration_0_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new GeneratedMetamodel_0_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class AbstractMetamodelDeclaration_0_1_RuleCall extends RuleCallToken {
	
	public AbstractMetamodelDeclaration_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractMetamodelDeclaration_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractMetamodelDeclaration_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new ReferencedMetamodel_0_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


/************ end Rule AbstractMetamodelDeclaration ****************/
/************ begin Rule GeneratedMetamodel ****************/


protected class GeneratedMetamodel_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private GeneratedMetamodel_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new GeneratedMetamodel_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new GeneratedMetamodel_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new GeneratedMetamodel_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class GeneratedMetamodel_0_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private GeneratedMetamodel_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new GeneratedMetamodel_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new GeneratedMetamodel_0_0_1_Assignment_nsURI(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new GeneratedMetamodel_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class GeneratedMetamodel_0_0_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private GeneratedMetamodel_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new GeneratedMetamodel_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new GeneratedMetamodel_0_0_0_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new GeneratedMetamodel_0_0_0_0_Keyword_generate(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class GeneratedMetamodel_0_0_0_0_Keyword_generate extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public GeneratedMetamodel_0_0_0_0_Keyword_generate(AbstractToken predecessor) {
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

protected class GeneratedMetamodel_0_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public GeneratedMetamodel_0_0_0_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private GeneratedMetamodel_0_0_0_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new GeneratedMetamodel_0_0_0_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("GeneratedMetamodel_0_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class GeneratedMetamodel_0_0_1_Assignment_nsURI extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public GeneratedMetamodel_0_0_1_Assignment_nsURI(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private GeneratedMetamodel_0_0_1_Assignment_nsURI(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new GeneratedMetamodel_0_0_1_Assignment_nsURI(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("nsURI")) return null;
		value = obj.consume("nsURI");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("GeneratedMetamodel_0_0_1_Assignment_nsURICallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class GeneratedMetamodel_0_1_Group extends GroupToken {
	
	public GeneratedMetamodel_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private GeneratedMetamodel_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new GeneratedMetamodel_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new GeneratedMetamodel_0_1_1_Assignment_alias(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new GeneratedMetamodel_0_1_0_Keyword_as(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class GeneratedMetamodel_0_1_0_Keyword_as extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.0");
	
	public GeneratedMetamodel_0_1_0_Keyword_as(AbstractToken predecessor) {
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

protected class GeneratedMetamodel_0_1_1_Assignment_alias extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public GeneratedMetamodel_0_1_1_Assignment_alias(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private GeneratedMetamodel_0_1_1_Assignment_alias(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new GeneratedMetamodel_0_1_1_Assignment_alias(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("alias")) return null;
		value = obj.consume("alias");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("GeneratedMetamodel_0_1_1_Assignment_aliasCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



/************ end Rule GeneratedMetamodel ****************/
/************ begin Rule ReferencedMetamodel ****************/


protected class ReferencedMetamodel_0_Group extends GroupToken {
	
	public ReferencedMetamodel_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReferencedMetamodel_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReferencedMetamodel_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ReferencedMetamodel_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ReferencedMetamodel_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ReferencedMetamodel_0_0_Group extends GroupToken {
	
	public ReferencedMetamodel_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReferencedMetamodel_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReferencedMetamodel_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ReferencedMetamodel_0_0_1_Assignment_uri(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ReferencedMetamodel_0_0_0_Keyword_import(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ReferencedMetamodel_0_0_0_Keyword_import extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ReferencedMetamodel_0_0_0_Keyword_import(AbstractToken predecessor) {
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

protected class ReferencedMetamodel_0_0_1_Assignment_uri extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ReferencedMetamodel_0_0_1_Assignment_uri(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReferencedMetamodel_0_0_1_Assignment_uri(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReferencedMetamodel_0_0_1_Assignment_uri(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("uri")) return null;
		value = obj.consume("uri");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ReferencedMetamodel_0_0_1_Assignment_uriCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class ReferencedMetamodel_0_1_Group extends GroupToken {
	
	public ReferencedMetamodel_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private ReferencedMetamodel_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReferencedMetamodel_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ReferencedMetamodel_0_1_1_Assignment_alias(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ReferencedMetamodel_0_1_0_Keyword_as(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ReferencedMetamodel_0_1_0_Keyword_as extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0");
	
	public ReferencedMetamodel_0_1_0_Keyword_as(AbstractToken predecessor) {
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

protected class ReferencedMetamodel_0_1_1_Assignment_alias extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ReferencedMetamodel_0_1_1_Assignment_alias(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ReferencedMetamodel_0_1_1_Assignment_alias(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ReferencedMetamodel_0_1_1_Assignment_alias(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("alias")) return null;
		value = obj.consume("alias");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ReferencedMetamodel_0_1_1_Assignment_aliasCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



/************ end Rule ReferencedMetamodel ****************/
/************ begin Rule LexerRule ****************/


protected class LexerRule_0_Group extends GroupToken {
	
	public LexerRule_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new LexerRule_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new LexerRule_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class LexerRule_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new LexerRule_0_0_1_Assignment_body(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new LexerRule_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class LexerRule_0_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new LexerRule_0_0_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new LexerRule_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class LexerRule_0_0_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new LexerRule_0_0_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new LexerRule_0_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class LexerRule_0_0_0_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new LexerRule_0_0_0_0_0_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new LexerRule_0_0_0_0_0_0_Alternatives(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class LexerRule_0_0_0_0_0_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public LexerRule_0_0_0_0_0_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_0_0_0_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_0_0_0_0_Alternatives(predecessor, true, false);
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
			case 0: t = new LexerRule_0_0_0_0_0_0_1_Keyword_lexer(predecessor); break;
			case 1: t = new LexerRule_0_0_0_0_0_0_0_Keyword_native(predecessor); break;
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


protected class LexerRule_0_0_0_0_0_0_0_Keyword_native extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0");
	
	public LexerRule_0_0_0_0_0_0_0_Keyword_native(AbstractToken predecessor) {
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


protected class LexerRule_0_0_0_0_0_0_1_Keyword_lexer extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1");
	
	public LexerRule_0_0_0_0_0_0_1_Keyword_lexer(AbstractToken predecessor) {
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


protected class LexerRule_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LexerRule_0_0_0_0_0_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_0_0_0_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_0_0_0_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LexerRule_0_0_0_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class LexerRule_0_0_0_0_1_Group extends GroupToken {
	
	public LexerRule_0_0_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private LexerRule_0_0_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new LexerRule_0_0_0_0_1_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new LexerRule_0_0_0_0_1_0_Keyword_returns(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class LexerRule_0_0_0_0_1_0_Keyword_returns extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public LexerRule_0_0_0_0_1_0_Keyword_returns(AbstractToken predecessor) {
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

protected class LexerRule_0_0_0_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LexerRule_0_0_0_0_1_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_0_0_1_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_0_0_1_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		AbstractToken t = new TypeRef_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LexerRule_0_0_0_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}




protected class LexerRule_0_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public LexerRule_0_0_0_1_Keyword(AbstractToken predecessor) {
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


protected class LexerRule_0_0_1_Assignment_body extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LexerRule_0_0_1_Assignment_body(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private LexerRule_0_0_1_Assignment_body(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new LexerRule_0_0_1_Assignment_body(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("body")) return null;
		value = obj.consume("body");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LexerRule_0_0_1_Assignment_bodyCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}



protected class LexerRule_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.1");
	
	public LexerRule_0_1_Keyword(AbstractToken predecessor) {
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


/************ end Rule LexerRule ****************/
/************ begin Rule ParserRule ****************/


protected class ParserRule_0_Group extends GroupToken {
	
	public ParserRule_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParserRule_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ParserRule_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ParserRule_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ParserRule_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParserRule_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ParserRule_0_0_1_Assignment_alternatives(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ParserRule_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ParserRule_0_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParserRule_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ParserRule_0_0_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ParserRule_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ParserRule_0_0_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParserRule_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ParserRule_0_0_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ParserRule_0_0_0_0_0_Assignment_name(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ParserRule_0_0_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public ParserRule_0_0_0_0_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParserRule_0_0_0_0_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_0_0_0_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ParserRule_0_0_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class ParserRule_0_0_0_0_1_Group extends GroupToken {
	
	public ParserRule_0_0_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private ParserRule_0_0_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_0_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ParserRule_0_0_0_0_1_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ParserRule_0_0_0_0_1_0_Keyword_returns(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ParserRule_0_0_0_0_1_0_Keyword_returns extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public ParserRule_0_0_0_0_1_0_Keyword_returns(AbstractToken predecessor) {
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

protected class ParserRule_0_0_0_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ParserRule_0_0_0_0_1_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParserRule_0_0_0_0_1_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_0_0_0_1_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		AbstractToken t = new TypeRef_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ParserRule_0_0_0_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}




protected class ParserRule_0_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public ParserRule_0_0_0_1_Keyword(AbstractToken predecessor) {
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


protected class ParserRule_0_0_1_Assignment_alternatives extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ParserRule_0_0_1_Assignment_alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParserRule_0_0_1_Assignment_alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParserRule_0_0_1_Assignment_alternatives(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("alternatives")) return null;
		value = obj.consume("alternatives");
		AbstractToken t = new Alternatives_1_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ParserRule_0_0_1_Assignment_alternativesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Alternatives
	}
}



protected class ParserRule_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.1");
	
	public ParserRule_0_1_Keyword(AbstractToken predecessor) {
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


/************ end Rule ParserRule ****************/
/************ begin Rule TypeRef ****************/


protected class TypeRef_0_Group extends GroupToken {
	
	public TypeRef_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TypeRef_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TypeRef_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TypeRef_0_1_Assignment_name(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TypeRef_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TypeRef_0_0_Group extends GroupToken {
	
	public TypeRef_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private TypeRef_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TypeRef_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new TypeRef_0_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new TypeRef_0_0_0_Assignment_alias(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class TypeRef_0_0_0_Assignment_alias extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TypeRef_0_0_0_Assignment_alias(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TypeRef_0_0_0_Assignment_alias(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TypeRef_0_0_0_Assignment_alias(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("alias")) return null;
		value = obj.consume("alias");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TypeRef_0_0_0_Assignment_aliasCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class TypeRef_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public TypeRef_0_0_1_Keyword(AbstractToken predecessor) {
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


protected class TypeRef_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TypeRef_0_1_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private TypeRef_0_1_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new TypeRef_0_1_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TypeRef_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


/************ end Rule TypeRef ****************/
/************ begin Rule Alternatives ****************/


protected class Alternatives_1_Group extends GroupToken {
	
	public Alternatives_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Alternatives_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Alternatives_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Alternatives_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Alternatives_1_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Alternatives_1_0_RuleCall extends RuleCallToken {
	
	public Alternatives_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Alternatives_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Alternatives_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Group_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Alternatives_1_1_Group extends GroupToken {
	
	public Alternatives_1_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Alternatives_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Alternatives_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Alternatives_1_1_1_Assignment_groups(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Alternatives_1_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Alternatives_1_1_0_Group extends GroupToken {
	
	public Alternatives_1_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Alternatives_1_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Alternatives_1_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Alternatives_1_1_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Alternatives_1_1_0_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Alternatives_1_1_0_0_Action extends AssignmentToken  {

	public Alternatives_1_1_0_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Alternatives_1_1_0_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Alternatives_1_1_0_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("groups")) return null;
		Object val = obj.consume("groups");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Alternatives_1_1_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	
	public Alternatives_1_1_0_1_Keyword(AbstractToken predecessor) {
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


protected class Alternatives_1_1_1_Assignment_groups extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Alternatives_1_1_1_Assignment_groups(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Alternatives_1_1_1_Assignment_groups(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Alternatives_1_1_1_Assignment_groups(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("groups")) return null;
		value = obj.consume("groups");
		AbstractToken t = new Group_1_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Alternatives_1_1_1_Assignment_groupsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Group
	}
}



/************ end Rule Alternatives ****************/
/************ begin Rule Group ****************/


protected class Group_1_Group extends GroupToken {
	
	public Group_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Group_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Group_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Group_1_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Group_1_0_RuleCall(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Group_1_0_RuleCall extends RuleCallToken {
	
	public Group_1_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Group_1_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Group_1_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new AbstractToken_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Group_1_1_Group extends GroupToken {
	
	public Group_1_1_Group(AbstractToken predecessor) {
		super(predecessor, IS_MANY, !IS_REQUIRED);
	}
	
	private Group_1_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Group_1_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Group_1_1_1_Assignment_abstractTokens(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Group_1_1_0_Action(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Group_1_1_0_Action extends AssignmentToken  {

	public Group_1_1_0_Action(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Group_1_1_0_Action(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Group_1_1_0_Action(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("abstractTokens")) return null;
		Object val = obj.consume("abstractTokens");
		if(!obj.isConsumed()) return null;
		object = getDescr((EObject)val);
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Group_1_1_1_Assignment_abstractTokens extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Group_1_1_1_Assignment_abstractTokens(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Group_1_1_1_Assignment_abstractTokens(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Group_1_1_1_Assignment_abstractTokens(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("abstractTokens")) return null;
		value = obj.consume("abstractTokens");
		AbstractToken t = new AbstractToken_1_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Group_1_1_1_Assignment_abstractTokensCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractToken
	}
}



/************ end Rule Group ****************/
/************ begin Rule AbstractToken ****************/


protected class AbstractToken_1_Group extends GroupToken {
	
	public AbstractToken_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractToken_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractToken_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new AbstractToken_1_1_Assignment_cardinality(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new AbstractToken_1_0_Alternatives(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class AbstractToken_1_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractToken_1_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractToken_1_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractToken_1_0_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractToken_1_0_1_RuleCall(predecessor); break;
			case 1: t = new AbstractToken_1_0_0_Alternatives(predecessor); break;
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

protected class AbstractToken_1_0_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractToken_1_0_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractToken_1_0_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractToken_1_0_0_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractToken_1_0_0_1_RuleCall(predecessor); break;
			case 1: t = new AbstractToken_1_0_0_0_RuleCall(predecessor); break;
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

protected class AbstractToken_1_0_0_0_RuleCall extends RuleCallToken {
	
	public AbstractToken_1_0_0_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractToken_1_0_0_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractToken_1_0_0_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Assignment_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class AbstractToken_1_0_0_1_RuleCall extends RuleCallToken {
	
	public AbstractToken_1_0_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractToken_1_0_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractToken_1_0_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Action_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class AbstractToken_1_0_1_RuleCall extends RuleCallToken {
	
	public AbstractToken_1_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractToken_1_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractToken_1_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new AbstractTerminal_1_Alternatives(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class AbstractToken_1_1_Assignment_cardinality extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public AbstractToken_1_1_Assignment_cardinality(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private AbstractToken_1_1_Assignment_cardinality(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractToken_1_1_Assignment_cardinality(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("cardinality")) return null;
		value = obj.consume("cardinality");
		if("?".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0");
		else 		if("*".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1");
		else 		if("+".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("AbstractToken_1_1_Assignment_cardinalityCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(object, (Keyword)element);
	}
}


/************ end Rule AbstractToken ****************/
/************ begin Rule Assignment ****************/


protected class Assignment_1_Group extends GroupToken {
	
	public Assignment_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Assignment_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Assignment_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Assignment_1_1_Assignment_terminal(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Assignment_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Assignment_1_0_Group extends GroupToken {
	
	public Assignment_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Assignment_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Assignment_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Assignment_1_0_1_Assignment_operator(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Assignment_1_0_0_Assignment_feature(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Assignment_1_0_0_Assignment_feature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Assignment_1_0_0_Assignment_feature(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Assignment_1_0_0_Assignment_feature(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Assignment_1_0_0_Assignment_feature(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("feature")) return null;
		value = obj.consume("feature");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Assignment_1_0_0_Assignment_featureCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

protected class Assignment_1_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Assignment_1_0_1_Assignment_operator(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Assignment_1_0_1_Assignment_operator(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Assignment_1_0_1_Assignment_operator(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("operator")) return null;
		value = obj.consume("operator");
		if("+=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0");
		else 		if("=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1");
		else 		if("?=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Assignment_1_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(object, (Keyword)element);
	}
}


protected class Assignment_1_1_Assignment_terminal extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Assignment_1_1_Assignment_terminal(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Assignment_1_1_Assignment_terminal(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Assignment_1_1_Assignment_terminal(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("terminal")) return null;
		value = obj.consume("terminal");
		AbstractToken t = new AbstractTerminal_1_Alternatives(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Assignment_1_1_Assignment_terminalCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractTerminal
	}
}


/************ end Rule Assignment ****************/
/************ begin Rule Action ****************/


protected class Action_1_Group extends GroupToken {
	
	public Action_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Action_1_0_Group extends GroupToken {
	
	public Action_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_0_1_Keyword_current(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Action_1_0_0_Group extends GroupToken {
	
	public Action_1_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_0_0_1_Assignment_operator(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Action_1_0_0_0_Group extends GroupToken {
	
	public Action_1_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_0_0_0_1_Assignment_feature(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Action_1_0_0_0_0_Group extends GroupToken {
	
	public Action_1_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_0_0_0_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Action_1_0_0_0_0_0_Group extends GroupToken {
	
	public Action_1_0_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_0_0_0_0_0_1_Assignment_typeName(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_0_0_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class Action_1_0_0_0_0_0_0_Group extends GroupToken {
	
	public Action_1_0_0_0_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_0_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_0_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_0_0_0_0_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_0_0_0_0_0_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Action_1_0_0_0_0_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Action_1_0_0_0_0_0_0_0_Keyword(AbstractToken predecessor) {
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

protected class Action_1_0_0_0_0_0_0_1_Group extends GroupToken {
	
	public Action_1_0_0_0_0_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private Action_1_0_0_0_0_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_0_0_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new Action_1_0_0_0_0_0_0_1_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new Action_1_0_0_0_0_0_0_1_0_Keyword_current(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class Action_1_0_0_0_0_0_0_1_0_Keyword_current extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public Action_1_0_0_0_0_0_0_1_0_Keyword_current(AbstractToken predecessor) {
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


protected class Action_1_0_0_0_0_0_0_1_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	
	public Action_1_0_0_0_0_0_0_1_1_Keyword(AbstractToken predecessor) {
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



protected class Action_1_0_0_0_0_0_1_Assignment_typeName extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Action_1_0_0_0_0_0_1_Assignment_typeName(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_0_0_0_1_Assignment_typeName(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_0_0_0_1_Assignment_typeName(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("typeName")) return null;
		value = obj.consume("typeName");
		AbstractToken t = new TypeRef_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Action_1_0_0_0_0_0_1_Assignment_typeNameCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}



protected class Action_1_0_0_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Action_1_0_0_0_0_1_Keyword(AbstractToken predecessor) {
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


protected class Action_1_0_0_0_1_Assignment_feature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Action_1_0_0_0_1_Assignment_feature(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_0_1_Assignment_feature(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_0_1_Assignment_feature(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("feature")) return null;
		value = obj.consume("feature");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Action_1_0_0_0_1_Assignment_featureCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}


protected class Action_1_0_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Action_1_0_0_1_Assignment_operator(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Action_1_0_0_1_Assignment_operator(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Action_1_0_0_1_Assignment_operator(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("operator")) return null;
		value = obj.consume("operator");
		if("=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
		else 		if("+=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Action_1_0_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(object, (Keyword)element);
	}
}



protected class Action_1_0_1_Keyword_current extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Action_1_0_1_Keyword_current(AbstractToken predecessor) {
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



protected class Action_1_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.1");
	
	public Action_1_1_Keyword(AbstractToken predecessor) {
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


/************ end Rule Action ****************/
/************ begin Rule AbstractTerminal ****************/


protected class AbstractTerminal_1_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractTerminal_1_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractTerminal_1_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractTerminal_1_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractTerminal_1_1_RuleCall(predecessor); break;
			case 1: t = new AbstractTerminal_1_0_Alternatives(predecessor); break;
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

protected class AbstractTerminal_1_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractTerminal_1_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractTerminal_1_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractTerminal_1_0_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractTerminal_1_0_1_RuleCall(predecessor); break;
			case 1: t = new AbstractTerminal_1_0_0_Alternatives(predecessor); break;
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

protected class AbstractTerminal_1_0_0_Alternatives extends GroupToken {
	
	private int currentOption = 1;

	public AbstractTerminal_1_0_0_Alternatives(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractTerminal_1_0_0_Alternatives(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractTerminal_1_0_0_Alternatives(predecessor, true, false);
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
			case 0: t = new AbstractTerminal_1_0_0_1_RuleCall(predecessor); break;
			case 1: t = new AbstractTerminal_1_0_0_0_RuleCall(predecessor); break;
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

protected class AbstractTerminal_1_0_0_0_RuleCall extends RuleCallToken {
	
	public AbstractTerminal_1_0_0_0_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractTerminal_1_0_0_0_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractTerminal_1_0_0_0_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Keyword_0_Assignment_value(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class AbstractTerminal_1_0_0_1_RuleCall extends RuleCallToken {
	
	public AbstractTerminal_1_0_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractTerminal_1_0_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractTerminal_1_0_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new RuleCall_0_Assignment_name(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class AbstractTerminal_1_0_1_RuleCall extends RuleCallToken {
	
	public AbstractTerminal_1_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractTerminal_1_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractTerminal_1_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new ParenthesizedElement_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class AbstractTerminal_1_1_RuleCall extends RuleCallToken {
	
	public AbstractTerminal_1_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private AbstractTerminal_1_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new AbstractTerminal_1_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new CrossReference_0_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


/************ end Rule AbstractTerminal ****************/
/************ begin Rule CrossReference ****************/


protected class CrossReference_0_Group extends GroupToken {
	
	public CrossReference_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private CrossReference_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new CrossReference_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new CrossReference_0_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new CrossReference_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class CrossReference_0_0_Group extends GroupToken {
	
	public CrossReference_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private CrossReference_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new CrossReference_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new CrossReference_0_0_1_Group(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new CrossReference_0_0_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class CrossReference_0_0_0_Group extends GroupToken {
	
	public CrossReference_0_0_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private CrossReference_0_0_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new CrossReference_0_0_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new CrossReference_0_0_0_1_Assignment_type(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new CrossReference_0_0_0_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class CrossReference_0_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public CrossReference_0_0_0_0_Keyword(AbstractToken predecessor) {
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

protected class CrossReference_0_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public CrossReference_0_0_0_1_Assignment_type(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private CrossReference_0_0_0_1_Assignment_type(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new CrossReference_0_0_0_1_Assignment_type(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("type")) return null;
		value = obj.consume("type");
		AbstractToken t = new TypeRef_0_Group(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("CrossReference_0_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}


protected class CrossReference_0_0_1_Group extends GroupToken {
	
	public CrossReference_0_0_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, !IS_REQUIRED);
	}
	
	private CrossReference_0_0_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new CrossReference_0_0_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new CrossReference_0_0_1_1_Assignment_rule(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new CrossReference_0_0_1_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class CrossReference_0_0_1_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public CrossReference_0_0_1_0_Keyword(AbstractToken predecessor) {
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

protected class CrossReference_0_0_1_1_Assignment_rule extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public CrossReference_0_0_1_1_Assignment_rule(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private CrossReference_0_0_1_1_Assignment_rule(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new CrossReference_0_0_1_1_Assignment_rule(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("rule")) return null;
		value = obj.consume("rule");
		AbstractToken t = new RuleCall_0_Assignment_name(predecessor);
		predecessor = t.createFirstSolution(getDescr((EObject)value));
		if(predecessor == null) return null;
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("CrossReference_0_0_1_1_Assignment_ruleCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call RuleCall
	}
}




protected class CrossReference_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.1");
	
	public CrossReference_0_1_Keyword(AbstractToken predecessor) {
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


/************ end Rule CrossReference ****************/
/************ begin Rule ParenthesizedElement ****************/


protected class ParenthesizedElement_1_Group extends GroupToken {
	
	public ParenthesizedElement_1_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParenthesizedElement_1_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParenthesizedElement_1_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ParenthesizedElement_1_1_Keyword(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ParenthesizedElement_1_0_Group(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}

protected class ParenthesizedElement_1_0_Group extends GroupToken {
	
	public ParenthesizedElement_1_0_Group(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParenthesizedElement_1_0_Group(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParenthesizedElement_1_0_Group(predecessor, true, false);
	}

		
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		AbstractToken t1 = new ParenthesizedElement_1_0_1_RuleCall(predecessor);
		predecessor = t1.createFirstSolution(object);
		if(predecessor == null) return null;
		AbstractToken t0 = new ParenthesizedElement_1_0_0_Keyword(predecessor);
		predecessor = t0.createFirstSolution(t1.getObject());
		if(predecessor == null) return null;
		object = t0.getObject();
		return predecessor;
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}


protected class ParenthesizedElement_1_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ParenthesizedElement_1_0_0_Keyword(AbstractToken predecessor) {
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

protected class ParenthesizedElement_1_0_1_RuleCall extends RuleCallToken {
	
	public ParenthesizedElement_1_0_1_RuleCall(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private ParenthesizedElement_1_0_1_RuleCall(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new ParenthesizedElement_1_0_1_RuleCall(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		if(checkForRecursion()) return null;
		AbstractToken t = new Alternatives_1_Group(predecessor);
		return t.createFirstSolution(predecessor.getObject());
	}

	public void executeCallback(IParseTreeConstructorCallback callback) {
	}
}



protected class ParenthesizedElement_1_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.1");
	
	public ParenthesizedElement_1_1_Keyword(AbstractToken predecessor) {
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


/************ end Rule ParenthesizedElement ****************/
/************ begin Rule Keyword ****************/


protected class Keyword_0_Assignment_value extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@terminal");
	protected Object value;
	
	public Keyword_0_Assignment_value(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private Keyword_0_Assignment_value(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new Keyword_0_Assignment_value(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("value")) return null;
		value = obj.consume("value");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Keyword_0_Assignment_valueCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

/************ end Rule Keyword ****************/
/************ begin Rule RuleCall ****************/


protected class RuleCall_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.17/@alternatives/@terminal");
	protected Object value;
	
	public RuleCall_0_Assignment_name(AbstractToken predecessor) {
		super(predecessor, !IS_MANY, IS_REQUIRED);
	}
	
	private RuleCall_0_Assignment_name(AbstractToken predecessor, boolean many, boolean required) {
		super(predecessor, many, required);
	}
	
	protected AbstractToken newInstance(AbstractToken predecessor) {
		return new RuleCall_0_Assignment_name(predecessor, true, false);
	}

	
	protected AbstractToken createOneChild(AbstractToken predecessor) {
		IInstanceDescription obj = object.createClone();
		if(!obj.isConsumable("name")) return null;
		value = obj.consume("name");
		object = (InstanceDescription)obj;
		return predecessor;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("RuleCall_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(getObject(), (RuleCall) element, value);
	}
}

/************ end Rule RuleCall ****************/
}
