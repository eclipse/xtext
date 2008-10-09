/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class XtextParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Grammar") && (s = new Grammar_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractRule") && (s = new AbstractRule_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractMetamodelDeclaration") && (s = new AbstractMetamodelDeclaration_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("GeneratedMetamodel") && (s = new GeneratedMetamodel_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("ReferencedMetamodel") && (s = new ReferencedMetamodel_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("LexerRule") && (s = new LexerRule_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("ParserRule") && (s = new ParserRule_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TypeRef") && (s = new TypeRef_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new Alternatives_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new Group_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new AbstractToken_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Assignment") && (s = new Assignment_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Action") && (s = new Action_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new AbstractTerminal_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("CrossReference") && (s = new CrossReference_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new ParenthesizedElement_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Keyword") && (s = new Keyword_Assignment_value(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("RuleCall") && (s = new RuleCall_Assignment_name(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Grammar ****************
 *
 * Grammar : ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) + ;
 *
 **/


// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) +
protected class Grammar_Group extends GroupToken {
	
	public Grammar_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_1_Assignment_rules(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) *
protected class Grammar_0_Group extends GroupToken {
	
	public Grammar_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_1_Assignment_metamodelDeclarations(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ?
protected class Grammar_0_0_Group extends GroupToken {
	
	public Grammar_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) *
protected class Grammar_0_0_0_Group extends GroupToken {
	
	public Grammar_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_0_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID
protected class Grammar_0_0_0_0_Group extends GroupToken {
	
	public Grammar_0_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_0_0_0_1_Assignment_idElements(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_0_0_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// abstract ?= 'abstract language' | 'language'
protected class Grammar_0_0_0_0_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Grammar_0_0_0_0_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Grammar_0_0_0_0_0_1_Keyword_language(current, this) : new Grammar_0_0_0_0_0_0_Assignment_abstract(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// abstract ?= 'abstract language'
protected class Grammar_0_0_0_0_0_0_Assignment_abstract extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_0_0_0_Assignment_abstract(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("abstract")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("abstract");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_0_0_0_Assignment_abstractCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}

// 'language'
protected class Grammar_0_0_0_0_0_1_Keyword_language extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1");
	
	public Grammar_0_0_0_0_0_1_Keyword_language(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// idElements += ID
protected class Grammar_0_0_0_0_1_Assignment_idElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_0_1_Assignment_idElements(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("idElements")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("idElements");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_0_1_Assignment_idElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ( '.' idElements += ID ) *
protected class Grammar_0_0_0_1_Group extends GroupToken {
	
	public Grammar_0_0_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_0_0_1_1_Assignment_idElements(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '.'
protected class Grammar_0_0_0_1_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public Grammar_0_0_0_1_0_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// idElements += ID
protected class Grammar_0_0_0_1_1_Assignment_idElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_0_1_1_Assignment_idElements(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("idElements")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("idElements");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_0_1_1_Assignment_idElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



// ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ?
protected class Grammar_0_0_1_Group extends GroupToken {
	
	public Grammar_0_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_0_1_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'extends' superGrammarIdElements += ID
protected class Grammar_0_0_1_0_Group extends GroupToken {
	
	public Grammar_0_0_1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_0_1_0_1_Assignment_superGrammarIdElements(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_1_0_0_Keyword_extends(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'extends'
protected class Grammar_0_0_1_0_0_Keyword_extends extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	
	public Grammar_0_0_1_0_0_Keyword_extends(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_0_1_Assignment_superGrammarIdElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_1_0_1_Assignment_superGrammarIdElements(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("superGrammarIdElements")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("superGrammarIdElements");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_1_0_1_Assignment_superGrammarIdElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ( '.' superGrammarIdElements += ID ) *
protected class Grammar_0_0_1_1_Group extends GroupToken {
	
	public Grammar_0_0_1_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Grammar_0_0_1_1_1_Assignment_superGrammarIdElements(current, this).firstSolution();
		if(s1 == null) return null;
		return new Grammar_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '.'
protected class Grammar_0_0_1_1_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0");
	
	public Grammar_0_0_1_1_0_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_1_1_Assignment_superGrammarIdElements extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_0_1_1_1_Assignment_superGrammarIdElements(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("superGrammarIdElements")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("superGrammarIdElements");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_0_1_1_1_Assignment_superGrammarIdElementsCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}




// ( metamodelDeclarations += AbstractMetamodelDeclaration ) *
protected class Grammar_0_1_Assignment_metamodelDeclarations extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_0_1_Assignment_metamodelDeclarations(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("metamodelDeclarations")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("metamodelDeclarations");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("AbstractMetamodelDeclaration")) return null;
		AbstractToken t = new AbstractMetamodelDeclaration_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_0_1_Assignment_metamodelDeclarationsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractMetamodelDeclaration
	}
}


// ( rules += AbstractRule ) +
protected class Grammar_1_Assignment_rules extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Grammar_1_Assignment_rules(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("rules")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("rules");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("AbstractRule")) return null;
		AbstractToken t = new AbstractRule_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Grammar_1_Assignment_rulesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractRule
	}
}


/************ end Rule Grammar ****************/

/************ begin Rule AbstractRule ****************
 *
 * AbstractRule : LexerRule | ParserRule ;
 *
 **/


// LexerRule | ParserRule
protected class AbstractRule_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractRule_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new AbstractRule_1_RuleCall_ParserRule(current, this) : new AbstractRule_0_RuleCall_LexerRule(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// LexerRule
protected class AbstractRule_0_RuleCall_LexerRule extends RuleCallToken {
	
	public AbstractRule_0_RuleCall_LexerRule(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(LexerRule_Group.class, current)) return null;
		if(!current.isInstanceOf("LexerRule")) return null;
		return new LexerRule_Group(current, this).firstSolution();
	}
}

// ParserRule
protected class AbstractRule_1_RuleCall_ParserRule extends RuleCallToken {
	
	public AbstractRule_1_RuleCall_ParserRule(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(ParserRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ParserRule")) return null;
		return new ParserRule_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractRule ****************/

/************ begin Rule AbstractMetamodelDeclaration ****************
 *
 * AbstractMetamodelDeclaration : GeneratedMetamodel | ReferencedMetamodel ;
 *
 **/


// GeneratedMetamodel | ReferencedMetamodel
protected class AbstractMetamodelDeclaration_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractMetamodelDeclaration_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new AbstractMetamodelDeclaration_1_RuleCall_ReferencedMetamodel(current, this) : new AbstractMetamodelDeclaration_0_RuleCall_GeneratedMetamodel(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// GeneratedMetamodel
protected class AbstractMetamodelDeclaration_0_RuleCall_GeneratedMetamodel extends RuleCallToken {
	
	public AbstractMetamodelDeclaration_0_RuleCall_GeneratedMetamodel(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(GeneratedMetamodel_Group.class, current)) return null;
		if(!current.isInstanceOf("GeneratedMetamodel")) return null;
		return new GeneratedMetamodel_Group(current, this).firstSolution();
	}
}

// ReferencedMetamodel
protected class AbstractMetamodelDeclaration_1_RuleCall_ReferencedMetamodel extends RuleCallToken {
	
	public AbstractMetamodelDeclaration_1_RuleCall_ReferencedMetamodel(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(ReferencedMetamodel_Group.class, current)) return null;
		if(!current.isInstanceOf("ReferencedMetamodel")) return null;
		return new ReferencedMetamodel_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractMetamodelDeclaration ****************/

/************ begin Rule GeneratedMetamodel ****************
 *
 * GeneratedMetamodel : 'generate' name = ID nsURI = STRING ( 'as' alias = ID ) ? ;
 *
 **/


// 'generate' name = ID nsURI = STRING ( 'as' alias = ID ) ?
protected class GeneratedMetamodel_Group extends GroupToken {
	
	public GeneratedMetamodel_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new GeneratedMetamodel_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new GeneratedMetamodel_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'generate' name = ID nsURI = STRING
protected class GeneratedMetamodel_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new GeneratedMetamodel_0_1_Assignment_nsURI(current, this).firstSolution();
		if(s1 == null) return null;
		return new GeneratedMetamodel_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'generate' name = ID
protected class GeneratedMetamodel_0_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new GeneratedMetamodel_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new GeneratedMetamodel_0_0_0_Keyword_generate(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'generate'
protected class GeneratedMetamodel_0_0_0_Keyword_generate extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public GeneratedMetamodel_0_0_0_Keyword_generate(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// name = ID
protected class GeneratedMetamodel_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public GeneratedMetamodel_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("GeneratedMetamodel_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// nsURI = STRING
protected class GeneratedMetamodel_0_1_Assignment_nsURI extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public GeneratedMetamodel_0_1_Assignment_nsURI(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("nsURI")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("nsURI");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("GeneratedMetamodel_0_1_Assignment_nsURICallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ( 'as' alias = ID ) ?
protected class GeneratedMetamodel_1_Group extends GroupToken {
	
	public GeneratedMetamodel_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new GeneratedMetamodel_1_1_Assignment_alias(current, this).firstSolution();
		if(s1 == null) return null;
		return new GeneratedMetamodel_1_0_Keyword_as(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'as'
protected class GeneratedMetamodel_1_0_Keyword_as extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.0");
	
	public GeneratedMetamodel_1_0_Keyword_as(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// alias = ID
protected class GeneratedMetamodel_1_1_Assignment_alias extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public GeneratedMetamodel_1_1_Assignment_alias(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("alias")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("alias");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("GeneratedMetamodel_1_1_Assignment_aliasCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



/************ end Rule GeneratedMetamodel ****************/

/************ begin Rule ReferencedMetamodel ****************
 *
 * ReferencedMetamodel : 'import' uri = STRING ( 'as' alias = ID ) ? ;
 *
 **/


// 'import' uri = STRING ( 'as' alias = ID ) ?
protected class ReferencedMetamodel_Group extends GroupToken {
	
	public ReferencedMetamodel_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ReferencedMetamodel_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new ReferencedMetamodel_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'import' uri = STRING
protected class ReferencedMetamodel_0_Group extends GroupToken {
	
	public ReferencedMetamodel_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ReferencedMetamodel_0_1_Assignment_uri(current, this).firstSolution();
		if(s1 == null) return null;
		return new ReferencedMetamodel_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'import'
protected class ReferencedMetamodel_0_0_Keyword_import extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ReferencedMetamodel_0_0_Keyword_import(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// uri = STRING
protected class ReferencedMetamodel_0_1_Assignment_uri extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ReferencedMetamodel_0_1_Assignment_uri(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("uri")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("uri");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ReferencedMetamodel_0_1_Assignment_uriCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ( 'as' alias = ID ) ?
protected class ReferencedMetamodel_1_Group extends GroupToken {
	
	public ReferencedMetamodel_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ReferencedMetamodel_1_1_Assignment_alias(current, this).firstSolution();
		if(s1 == null) return null;
		return new ReferencedMetamodel_1_0_Keyword_as(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'as'
protected class ReferencedMetamodel_1_0_Keyword_as extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0");
	
	public ReferencedMetamodel_1_0_Keyword_as(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// alias = ID
protected class ReferencedMetamodel_1_1_Assignment_alias extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ReferencedMetamodel_1_1_Assignment_alias(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("alias")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("alias");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ReferencedMetamodel_1_1_Assignment_aliasCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}



/************ end Rule ReferencedMetamodel ****************/

/************ begin Rule LexerRule ****************
 *
 * LexerRule : ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING ';' ;
 *
 **/


// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING ';'
protected class LexerRule_Group extends GroupToken {
	
	public LexerRule_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LexerRule_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new LexerRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING
protected class LexerRule_0_Group extends GroupToken {
	
	public LexerRule_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LexerRule_0_1_Assignment_body(current, this).firstSolution();
		if(s1 == null) return null;
		return new LexerRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':'
protected class LexerRule_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LexerRule_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new LexerRule_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ?
protected class LexerRule_0_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LexerRule_0_0_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new LexerRule_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( 'native' | 'lexer' ) name = ID
protected class LexerRule_0_0_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LexerRule_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new LexerRule_0_0_0_0_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'native' | 'lexer'
protected class LexerRule_0_0_0_0_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public LexerRule_0_0_0_0_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new LexerRule_0_0_0_0_0_1_Keyword_lexer(current, this) : new LexerRule_0_0_0_0_0_0_Keyword_native(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// 'native'
protected class LexerRule_0_0_0_0_0_0_Keyword_native extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0");
	
	public LexerRule_0_0_0_0_0_0_Keyword_native(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// 'lexer'
protected class LexerRule_0_0_0_0_0_1_Keyword_lexer extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1");
	
	public LexerRule_0_0_0_0_0_1_Keyword_lexer(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// name = ID
protected class LexerRule_0_0_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LexerRule_0_0_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("LexerRule_0_0_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ( 'returns' type = TypeRef ) ?
protected class LexerRule_0_0_0_1_Group extends GroupToken {
	
	public LexerRule_0_0_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LexerRule_0_0_0_1_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new LexerRule_0_0_0_1_0_Keyword_returns(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'returns'
protected class LexerRule_0_0_0_1_0_Keyword_returns extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public LexerRule_0_0_0_1_0_Keyword_returns(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// type = TypeRef
protected class LexerRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LexerRule_0_0_0_1_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("TypeRef")) return null;
		AbstractToken t = new TypeRef_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LexerRule_0_0_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}



// ':'
protected class LexerRule_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public LexerRule_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// body = STRING
protected class LexerRule_0_1_Assignment_body extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LexerRule_0_1_Assignment_body(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("body")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("body");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LexerRule_0_1_Assignment_bodyCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ';'
protected class LexerRule_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.1");
	
	public LexerRule_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule LexerRule ****************/

/************ begin Rule ParserRule ****************
 *
 * ParserRule : name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives ';' ;
 *
 **/


// name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives ';'
protected class ParserRule_Group extends GroupToken {
	
	public ParserRule_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ParserRule_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new ParserRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives
protected class ParserRule_0_Group extends GroupToken {
	
	public ParserRule_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ParserRule_0_1_Assignment_alternatives(current, this).firstSolution();
		if(s1 == null) return null;
		return new ParserRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// name = ID ( 'returns' type = TypeRef ) ? ':'
protected class ParserRule_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ParserRule_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new ParserRule_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// name = ID ( 'returns' type = TypeRef ) ?
protected class ParserRule_0_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ParserRule_0_0_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new ParserRule_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// name = ID
protected class ParserRule_0_0_0_0_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public ParserRule_0_0_0_0_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("ParserRule_0_0_0_0_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

// ( 'returns' type = TypeRef ) ?
protected class ParserRule_0_0_0_1_Group extends GroupToken {
	
	public ParserRule_0_0_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ParserRule_0_0_0_1_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new ParserRule_0_0_0_1_0_Keyword_returns(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'returns'
protected class ParserRule_0_0_0_1_0_Keyword_returns extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public ParserRule_0_0_0_1_0_Keyword_returns(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// type = TypeRef
protected class ParserRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ParserRule_0_0_0_1_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("TypeRef")) return null;
		AbstractToken t = new TypeRef_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ParserRule_0_0_0_1_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}



// ':'
protected class ParserRule_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public ParserRule_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// alternatives = Alternatives
protected class ParserRule_0_1_Assignment_alternatives extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ParserRule_0_1_Assignment_alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("alternatives")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("alternatives");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("AbstractElement")) return null;
		AbstractToken t = new Alternatives_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ParserRule_0_1_Assignment_alternativesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Alternatives
	}
}


// ';'
protected class ParserRule_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.1");
	
	public ParserRule_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule ParserRule ****************/

/************ begin Rule TypeRef ****************
 *
 * TypeRef : ( alias = ID '::' ) ? name = ID ;
 *
 **/


// ( alias = ID '::' ) ? name = ID
protected class TypeRef_Group extends GroupToken {
	
	public TypeRef_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TypeRef_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new TypeRef_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( alias = ID '::' ) ?
protected class TypeRef_0_Group extends GroupToken {
	
	public TypeRef_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new TypeRef_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new TypeRef_0_0_Assignment_alias(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// alias = ID
protected class TypeRef_0_0_Assignment_alias extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public TypeRef_0_0_Assignment_alias(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("alias")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("alias");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TypeRef_0_0_Assignment_aliasCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

// '::'
protected class TypeRef_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public TypeRef_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// name = ID
protected class TypeRef_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public TypeRef_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("TypeRef_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule TypeRef ****************/

/************ begin Rule Alternatives ****************
 *
 * Alternatives returns AbstractElement : Group ( { current = Alternatives . groups += current } '|' groups += Group ) * ;
 *
 **/


// Group ( { current = Alternatives . groups += current } '|' groups += Group ) *
protected class Alternatives_Group extends GroupToken {
	
	public Alternatives_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Alternatives_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Alternatives_0_RuleCall_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// Group
protected class Alternatives_0_RuleCall_Group extends RuleCallToken {
	
	public Alternatives_0_RuleCall_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Group_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new Group_Group(current, this).firstSolution();
	}
}

// ( { current = Alternatives . groups += current } '|' groups += Group ) *
protected class Alternatives_1_Group extends GroupToken {
	
	public Alternatives_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Alternatives_1_1_Assignment_groups(current, this).firstSolution();
		if(s1 == null) return null;
		return new Alternatives_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// { current = Alternatives . groups += current } '|'
protected class Alternatives_1_0_Group extends GroupToken {
	
	public Alternatives_1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Alternatives_1_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Alternatives_1_0_0_Action_Alternatives_groups(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// { current = Alternatives . groups += current }
protected class Alternatives_1_0_0_Action_Alternatives_groups extends AssignmentToken  {

	public Alternatives_1_0_0_Action_Alternatives_groups(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Alternatives")) return null;
		if(!current.isConsumable("groups")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("groups");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// '|'
protected class Alternatives_1_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	
	public Alternatives_1_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// groups += Group
protected class Alternatives_1_1_Assignment_groups extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Alternatives_1_1_Assignment_groups(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("groups")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("groups");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("AbstractElement")) return null;
		AbstractToken t = new Group_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Alternatives_1_1_Assignment_groupsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Group
	}
}



/************ end Rule Alternatives ****************/

/************ begin Rule Group ****************
 *
 * Group returns AbstractElement : AbstractToken ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) * ;
 *
 **/


// AbstractToken ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) *
protected class Group_Group extends GroupToken {
	
	public Group_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Group_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Group_0_RuleCall_AbstractToken(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// AbstractToken
protected class Group_0_RuleCall_AbstractToken extends RuleCallToken {
	
	public Group_0_RuleCall_AbstractToken(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(AbstractToken_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new AbstractToken_Group(current, this).firstSolution();
	}
}

// ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) *
protected class Group_1_Group extends GroupToken {
	
	public Group_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Group_1_1_Assignment_abstractTokens(current, this).firstSolution();
		if(s1 == null) return null;
		return new Group_1_0_Action_Group_abstractTokens(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// { current = Group . abstractTokens += current }
protected class Group_1_0_Action_Group_abstractTokens extends AssignmentToken  {

	public Group_1_0_Action_Group_abstractTokens(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Group")) return null;
		if(!current.isConsumable("abstractTokens")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("abstractTokens");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// abstractTokens += AbstractToken
protected class Group_1_1_Assignment_abstractTokens extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Group_1_1_Assignment_abstractTokens(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("abstractTokens")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("abstractTokens");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("AbstractElement")) return null;
		AbstractToken t = new AbstractToken_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Group_1_1_Assignment_abstractTokensCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractToken
	}
}



/************ end Rule Group ****************/

/************ begin Rule AbstractToken ****************
 *
 * AbstractToken returns AbstractElement : ( Assignment | Action | AbstractTerminal ) ( cardinality = ( '?' | '*' | '+' ) ) ? ;
 *
 **/


// ( Assignment | Action | AbstractTerminal ) ( cardinality = ( '?' | '*' | '+' ) ) ?
protected class AbstractToken_Group extends GroupToken {
	
	public AbstractToken_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new AbstractToken_1_Assignment_cardinality(current, this).firstSolution();
		if(s1 == null) return null;
		return new AbstractToken_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// Assignment | Action | AbstractTerminal
protected class AbstractToken_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractToken_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new AbstractToken_0_1_RuleCall_AbstractTerminal(current, this) : new AbstractToken_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Assignment | Action
protected class AbstractToken_0_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractToken_0_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new AbstractToken_0_0_1_RuleCall_Action(current, this) : new AbstractToken_0_0_0_RuleCall_Assignment(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Assignment
protected class AbstractToken_0_0_0_RuleCall_Assignment extends RuleCallToken {
	
	public AbstractToken_0_0_0_RuleCall_Assignment(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Assignment_Group.class, current)) return null;
		if(!current.isInstanceOf("Assignment")) return null;
		return new Assignment_Group(current, this).firstSolution();
	}
}

// Action
protected class AbstractToken_0_0_1_RuleCall_Action extends RuleCallToken {
	
	public AbstractToken_0_0_1_RuleCall_Action(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Action_Group.class, current)) return null;
		if(!current.isInstanceOf("Action")) return null;
		return new Action_Group(current, this).firstSolution();
	}
}


// AbstractTerminal
protected class AbstractToken_0_1_RuleCall_AbstractTerminal extends RuleCallToken {
	
	public AbstractToken_0_1_RuleCall_AbstractTerminal(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(AbstractTerminal_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new AbstractTerminal_Alternatives(current, this).firstSolution();
	}
}


// ( cardinality = ( '?' | '*' | '+' ) ) ?
protected class AbstractToken_1_Assignment_cardinality extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public AbstractToken_1_Assignment_cardinality(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("cardinality")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("cardinality");
		// handling xtext::Alternatives
		if("?".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0");
		else 		if("*".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1");
		else 		if("+".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("AbstractToken_1_Assignment_cardinalityCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(current, (Keyword)element);
	}
}


/************ end Rule AbstractToken ****************/

/************ begin Rule Assignment ****************
 *
 * Assignment returns Assignment : feature = ID operator = ( '+=' | '=' | '?=' ) terminal = AbstractTerminal ;
 *
 **/


// feature = ID operator = ( '+=' | '=' | '?=' ) terminal = AbstractTerminal
protected class Assignment_Group extends GroupToken {
	
	public Assignment_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Assignment_1_Assignment_terminal(current, this).firstSolution();
		if(s1 == null) return null;
		return new Assignment_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// feature = ID operator = ( '+=' | '=' | '?=' )
protected class Assignment_0_Group extends GroupToken {
	
	public Assignment_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Assignment_0_1_Assignment_operator(current, this).firstSolution();
		if(s1 == null) return null;
		return new Assignment_0_0_Assignment_feature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// feature = ID
protected class Assignment_0_0_Assignment_feature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Assignment_0_0_Assignment_feature(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("feature")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("feature");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Assignment_0_0_Assignment_featureCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

// operator = ( '+=' | '=' | '?=' )
protected class Assignment_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Assignment_0_1_Assignment_operator(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("operator")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("operator");
		// handling xtext::Alternatives
		if("+=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0");
		else 		if("=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1");
		else 		if("?=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Assignment_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(current, (Keyword)element);
	}
}


// terminal = AbstractTerminal
protected class Assignment_1_Assignment_terminal extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Assignment_1_Assignment_terminal(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("terminal")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("terminal");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("AbstractElement")) return null;
		AbstractToken t = new AbstractTerminal_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Assignment_1_Assignment_terminalCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractTerminal
	}
}


/************ end Rule Assignment ****************/

/************ begin Rule Action ****************
 *
 * Action returns Action : '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current' '}' ;
 *
 **/


// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current' '}'
protected class Action_Group extends GroupToken {
	
	public Action_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current'
protected class Action_0_Group extends GroupToken {
	
	public Action_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_0_1_Keyword_current(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' )
protected class Action_0_0_Group extends GroupToken {
	
	public Action_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_0_0_1_Assignment_operator(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID
protected class Action_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_0_0_0_1_Assignment_feature(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.'
protected class Action_0_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_0_0_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef
protected class Action_0_0_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_0_0_0_0_0_1_Assignment_typeName(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '{' ( 'current' '=' ) ?
protected class Action_0_0_0_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_0_0_0_0_0_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_0_0_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '{'
protected class Action_0_0_0_0_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Action_0_0_0_0_0_0_0_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// ( 'current' '=' ) ?
protected class Action_0_0_0_0_0_0_1_Group extends GroupToken {
	
	public Action_0_0_0_0_0_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Action_0_0_0_0_0_0_1_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Action_0_0_0_0_0_0_1_0_Keyword_current(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'current'
protected class Action_0_0_0_0_0_0_1_0_Keyword_current extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public Action_0_0_0_0_0_0_1_0_Keyword_current(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// '='
protected class Action_0_0_0_0_0_0_1_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	
	public Action_0_0_0_0_0_0_1_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}



// typeName = TypeRef
protected class Action_0_0_0_0_0_1_Assignment_typeName extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Action_0_0_0_0_0_1_Assignment_typeName(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("typeName")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("typeName");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("TypeRef")) return null;
		AbstractToken t = new TypeRef_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Action_0_0_0_0_0_1_Assignment_typeNameCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}


// '.'
protected class Action_0_0_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Action_0_0_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// feature = ID
protected class Action_0_0_0_1_Assignment_feature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Action_0_0_0_1_Assignment_feature(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("feature")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("feature");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Action_0_0_0_1_Assignment_featureCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// operator = ( '=' | '+=' )
protected class Action_0_0_1_Assignment_operator extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Action_0_0_1_Assignment_operator(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("operator")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("operator");
		// handling xtext::Alternatives
		if("=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
		else 		if("+=".equals(value))
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
		else 		return null;
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Action_0_0_1_Assignment_operatorCallback(\"xtext::Alternatives\", " + value + ")");
		if(element instanceof Keyword)
			callback.keywordCall(current, (Keyword)element);
	}
}


// 'current'
protected class Action_0_1_Keyword_current extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Action_0_1_Keyword_current(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// '}'
protected class Action_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.1");
	
	public Action_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule Action ****************/

/************ begin Rule AbstractTerminal ****************
 *
 * AbstractTerminal returns AbstractElement : Keyword | RuleCall | ParenthesizedElement | CrossReference ;
 *
 **/


// Keyword | RuleCall | ParenthesizedElement | CrossReference
protected class AbstractTerminal_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractTerminal_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new AbstractTerminal_1_RuleCall_CrossReference(current, this) : new AbstractTerminal_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Keyword | RuleCall | ParenthesizedElement
protected class AbstractTerminal_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractTerminal_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new AbstractTerminal_0_1_RuleCall_ParenthesizedElement(current, this) : new AbstractTerminal_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Keyword | RuleCall
protected class AbstractTerminal_0_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractTerminal_0_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new AbstractTerminal_0_0_1_RuleCall_RuleCall(current, this) : new AbstractTerminal_0_0_0_RuleCall_Keyword(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Keyword
protected class AbstractTerminal_0_0_0_RuleCall_Keyword extends RuleCallToken {
	
	public AbstractTerminal_0_0_0_RuleCall_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Keyword_Assignment_value.class, current)) return null;
		if(!current.isInstanceOf("Keyword")) return null;
		return new Keyword_Assignment_value(current, this).firstSolution();
	}
}

// RuleCall
protected class AbstractTerminal_0_0_1_RuleCall_RuleCall extends RuleCallToken {
	
	public AbstractTerminal_0_0_1_RuleCall_RuleCall(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(RuleCall_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("RuleCall")) return null;
		return new RuleCall_Assignment_name(current, this).firstSolution();
	}
}


// ParenthesizedElement
protected class AbstractTerminal_0_1_RuleCall_ParenthesizedElement extends RuleCallToken {
	
	public AbstractTerminal_0_1_RuleCall_ParenthesizedElement(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(ParenthesizedElement_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new ParenthesizedElement_Group(current, this).firstSolution();
	}
}


// CrossReference
protected class AbstractTerminal_1_RuleCall_CrossReference extends RuleCallToken {
	
	public AbstractTerminal_1_RuleCall_CrossReference(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(CrossReference_Group.class, current)) return null;
		if(!current.isInstanceOf("CrossReference")) return null;
		return new CrossReference_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractTerminal ****************/

/************ begin Rule CrossReference ****************
 *
 * CrossReference : '[' type = TypeRef ( '|' rule = RuleCall ) ? ']' ;
 *
 **/


// '[' type = TypeRef ( '|' rule = RuleCall ) ? ']'
protected class CrossReference_Group extends GroupToken {
	
	public CrossReference_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new CrossReference_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new CrossReference_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '[' type = TypeRef ( '|' rule = RuleCall ) ?
protected class CrossReference_0_Group extends GroupToken {
	
	public CrossReference_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new CrossReference_0_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new CrossReference_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '[' type = TypeRef
protected class CrossReference_0_0_Group extends GroupToken {
	
	public CrossReference_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new CrossReference_0_0_1_Assignment_type(current, this).firstSolution();
		if(s1 == null) return null;
		return new CrossReference_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '['
protected class CrossReference_0_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public CrossReference_0_0_0_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// type = TypeRef
protected class CrossReference_0_0_1_Assignment_type extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public CrossReference_0_0_1_Assignment_type(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("type")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("type");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("TypeRef")) return null;
		AbstractToken t = new TypeRef_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("CrossReference_0_0_1_Assignment_typeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TypeRef
	}
}


// ( '|' rule = RuleCall ) ?
protected class CrossReference_0_1_Group extends GroupToken {
	
	public CrossReference_0_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new CrossReference_0_1_1_Assignment_rule(current, this).firstSolution();
		if(s1 == null) return null;
		return new CrossReference_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '|'
protected class CrossReference_0_1_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	
	public CrossReference_0_1_0_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// rule = RuleCall
protected class CrossReference_0_1_1_Assignment_rule extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public CrossReference_0_1_1_Assignment_rule(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("rule")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("rule");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("RuleCall")) return null;
		AbstractToken t = new RuleCall_Assignment_name(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("CrossReference_0_1_1_Assignment_ruleCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call RuleCall
	}
}



// ']'
protected class CrossReference_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.1");
	
	public CrossReference_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule CrossReference ****************/

/************ begin Rule ParenthesizedElement ****************
 *
 * ParenthesizedElement returns AbstractElement : '(' Alternatives ')' ;
 *
 **/


// '(' Alternatives ')'
protected class ParenthesizedElement_Group extends GroupToken {
	
	public ParenthesizedElement_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ParenthesizedElement_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new ParenthesizedElement_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '(' Alternatives
protected class ParenthesizedElement_0_Group extends GroupToken {
	
	public ParenthesizedElement_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ParenthesizedElement_0_1_RuleCall_Alternatives(current, this).firstSolution();
		if(s1 == null) return null;
		return new ParenthesizedElement_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// '('
protected class ParenthesizedElement_0_0_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ParenthesizedElement_0_0_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// Alternatives
protected class ParenthesizedElement_0_1_RuleCall_Alternatives extends RuleCallToken {
	
	public ParenthesizedElement_0_1_RuleCall_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Alternatives_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new Alternatives_Group(current, this).firstSolution();
	}
}


// ')'
protected class ParenthesizedElement_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.1");
	
	public ParenthesizedElement_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule ParenthesizedElement ****************/

/************ begin Rule Keyword ****************
 *
 * Keyword : value = STRING ;
 *
 **/


// value = STRING
protected class Keyword_Assignment_value extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@terminal");
	protected Object value;
	
	public Keyword_Assignment_value(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("value")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("value");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Keyword_Assignment_valueCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

/************ end Rule Keyword ****************/

/************ begin Rule RuleCall ****************
 *
 * RuleCall : name = ID ;
 *
 **/


// name = ID
protected class RuleCall_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.17/@alternatives/@terminal");
	protected Object value;
	
	public RuleCall_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("RuleCall_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

/************ end Rule RuleCall ****************/

}
