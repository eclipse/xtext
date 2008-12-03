/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class XtextGrammarTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
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
		if(inst.isInstanceOf("RuleCall") && (s = new RuleCall_Assignment_rule(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Grammar ****************
 *
 * Grammar : ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) + ;
 *
 **/


// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) +
protected class Grammar_Group extends GroupToken {
	
	public Grammar_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_1_Assignment_rules(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) *
protected class Grammar_0_Group extends GroupToken {
	
	public Grammar_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_1_Assignment_metamodelDeclarations(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ?
protected class Grammar_0_0_Group extends GroupToken {
	
	public Grammar_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) *
protected class Grammar_0_0_0_Group extends GroupToken {
	
	public Grammar_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( abstract ?= 'abstract language' | 'language' ) idElements += ID
protected class Grammar_0_0_0_0_Group extends GroupToken {
	
	public Grammar_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_0_0_1_Assignment_idElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_0_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// abstract ?= 'abstract language' | 'language'
protected class Grammar_0_0_0_0_0_Alternatives extends AlternativesToken {

	public Grammar_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Grammar_0_0_0_0_0_1_Keyword_language(current, this) : new Grammar_0_0_0_0_0_0_Assignment_abstract(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// abstract ?= 'abstract language'
protected class Grammar_0_0_0_0_0_0_Assignment_abstract extends AssignmentToken  {
	
	public Grammar_0_0_0_0_0_0_Assignment_abstract(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstract",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstract");
		if("abstract language".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal");
			return new Solution(obj);
		}
		return null;
	}
}

// 'language'
protected class Grammar_0_0_0_0_0_1_Keyword_language extends KeywordToken  {
	
	public Grammar_0_0_0_0_0_1_Keyword_language(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1");
	}	
}


// idElements += ID
protected class Grammar_0_0_0_0_1_Assignment_idElements extends AssignmentToken  {
	
	public Grammar_0_0_0_0_1_Assignment_idElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("idElements",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("idElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( '.' idElements += ID ) *
protected class Grammar_0_0_0_1_Group extends GroupToken {
	
	public Grammar_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_0_1_1_Assignment_idElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '.'
protected class Grammar_0_0_0_1_0_Keyword extends KeywordToken  {
	
	public Grammar_0_0_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}	
}

// idElements += ID
protected class Grammar_0_0_0_1_1_Assignment_idElements extends AssignmentToken  {
	
	public Grammar_0_0_0_1_1_Assignment_idElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("idElements",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("idElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}



// ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ?
protected class Grammar_0_0_1_Group extends GroupToken {
	
	public Grammar_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'extends' superGrammarIdElements += ID
protected class Grammar_0_0_1_0_Group extends GroupToken {
	
	public Grammar_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_0_1_Assignment_superGrammarIdElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_1_0_0_Keyword_extends(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'extends'
protected class Grammar_0_0_1_0_0_Keyword_extends extends KeywordToken  {
	
	public Grammar_0_0_1_0_0_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	}	
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_0_1_Assignment_superGrammarIdElements extends AssignmentToken  {
	
	public Grammar_0_0_1_0_1_Assignment_superGrammarIdElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("superGrammarIdElements",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("superGrammarIdElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( '.' superGrammarIdElements += ID ) *
protected class Grammar_0_0_1_1_Group extends GroupToken {
	
	public Grammar_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_1_1_Assignment_superGrammarIdElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '.'
protected class Grammar_0_0_1_1_0_Keyword extends KeywordToken  {
	
	public Grammar_0_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0");
	}	
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_1_1_Assignment_superGrammarIdElements extends AssignmentToken  {
	
	public Grammar_0_0_1_1_1_Assignment_superGrammarIdElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("superGrammarIdElements",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("superGrammarIdElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}




// ( metamodelDeclarations += AbstractMetamodelDeclaration ) *
protected class Grammar_0_1_Assignment_metamodelDeclarations extends AssignmentToken  {
	
	public Grammar_0_1_Assignment_metamodelDeclarations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("metamodelDeclarations",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("metamodelDeclarations");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractMetamodelDeclaration")) {
				Solution s = new AbstractMetamodelDeclaration_Alternatives(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// ( rules += AbstractRule ) +
protected class Grammar_1_Assignment_rules extends AssignmentToken  {
	
	public Grammar_1_Assignment_rules(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.0/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rules",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rules");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				Solution s = new AbstractRule_Alternatives(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


/************ end Rule Grammar ****************/

/************ begin Rule AbstractRule ****************
 *
 * AbstractRule : LexerRule | ParserRule ;
 *
 **/


// LexerRule | ParserRule
protected class AbstractRule_Alternatives extends AlternativesToken {

	public AbstractRule_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.1/@alternatives");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractRule_1_RuleCall_ParserRule(current, this) : new AbstractRule_0_RuleCall_LexerRule(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// LexerRule
protected class AbstractRule_0_RuleCall_LexerRule extends RuleCallToken {
	
	public AbstractRule_0_RuleCall_LexerRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.1/@alternatives/@groups.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(LexerRule_Group.class, current)) return null;
		if(!current.isInstanceOf("LexerRule")) return null;
		return new LexerRule_Group(current, this).firstSolution();
	}
}

// ParserRule
protected class AbstractRule_1_RuleCall_ParserRule extends RuleCallToken {
	
	public AbstractRule_1_RuleCall_ParserRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.1/@alternatives/@groups.1");
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
protected class AbstractMetamodelDeclaration_Alternatives extends AlternativesToken {

	public AbstractMetamodelDeclaration_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.2/@alternatives");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractMetamodelDeclaration_1_RuleCall_ReferencedMetamodel(current, this) : new AbstractMetamodelDeclaration_0_RuleCall_GeneratedMetamodel(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// GeneratedMetamodel
protected class AbstractMetamodelDeclaration_0_RuleCall_GeneratedMetamodel extends RuleCallToken {
	
	public AbstractMetamodelDeclaration_0_RuleCall_GeneratedMetamodel(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.2/@alternatives/@groups.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(GeneratedMetamodel_Group.class, current)) return null;
		if(!current.isInstanceOf("GeneratedMetamodel")) return null;
		return new GeneratedMetamodel_Group(current, this).firstSolution();
	}
}

// ReferencedMetamodel
protected class AbstractMetamodelDeclaration_1_RuleCall_ReferencedMetamodel extends RuleCallToken {
	
	public AbstractMetamodelDeclaration_1_RuleCall_ReferencedMetamodel(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.2/@alternatives/@groups.1");
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
	
	public GeneratedMetamodel_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'generate' name = ID nsURI = STRING
protected class GeneratedMetamodel_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_0_1_Assignment_nsURI(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'generate' name = ID
protected class GeneratedMetamodel_0_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_0_0_0_Keyword_generate(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'generate'
protected class GeneratedMetamodel_0_0_0_Keyword_generate extends KeywordToken  {
	
	public GeneratedMetamodel_0_0_0_Keyword_generate(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// name = ID
protected class GeneratedMetamodel_0_0_1_Assignment_name extends AssignmentToken  {
	
	public GeneratedMetamodel_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// nsURI = STRING
protected class GeneratedMetamodel_0_1_Assignment_nsURI extends AssignmentToken  {
	
	public GeneratedMetamodel_0_1_Assignment_nsURI(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nsURI",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nsURI");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( 'as' alias = ID ) ?
protected class GeneratedMetamodel_1_Group extends GroupToken {
	
	public GeneratedMetamodel_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_1_1_Assignment_alias(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_1_0_Keyword_as(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'as'
protected class GeneratedMetamodel_1_0_Keyword_as extends KeywordToken  {
	
	public GeneratedMetamodel_1_0_Keyword_as(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}	
}

// alias = ID
protected class GeneratedMetamodel_1_1_Assignment_alias extends AssignmentToken  {
	
	public GeneratedMetamodel_1_1_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
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
	
	public ReferencedMetamodel_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ReferencedMetamodel_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReferencedMetamodel_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'import' uri = STRING
protected class ReferencedMetamodel_0_Group extends GroupToken {
	
	public ReferencedMetamodel_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ReferencedMetamodel_0_1_Assignment_uri(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReferencedMetamodel_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'import'
protected class ReferencedMetamodel_0_0_Keyword_import extends KeywordToken  {
	
	public ReferencedMetamodel_0_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}	
}

// uri = STRING
protected class ReferencedMetamodel_0_1_Assignment_uri extends AssignmentToken  {
	
	public ReferencedMetamodel_0_1_Assignment_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("uri",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("uri");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( 'as' alias = ID ) ?
protected class ReferencedMetamodel_1_Group extends GroupToken {
	
	public ReferencedMetamodel_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ReferencedMetamodel_1_1_Assignment_alias(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReferencedMetamodel_1_0_Keyword_as(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'as'
protected class ReferencedMetamodel_1_0_Keyword_as extends KeywordToken  {
	
	public ReferencedMetamodel_1_0_Keyword_as(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}	
}

// alias = ID
protected class ReferencedMetamodel_1_1_Assignment_alias extends AssignmentToken  {
	
	public ReferencedMetamodel_1_1_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
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
	
	public LexerRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING
protected class LexerRule_0_Group extends GroupToken {
	
	public LexerRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_1_Assignment_body(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':'
protected class LexerRule_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ?
protected class LexerRule_0_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( 'native' | 'lexer' ) name = ID
protected class LexerRule_0_0_0_0_Group extends GroupToken {
	
	public LexerRule_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_0_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'native' | 'lexer'
protected class LexerRule_0_0_0_0_0_Alternatives extends AlternativesToken {

	public LexerRule_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new LexerRule_0_0_0_0_0_1_Keyword_lexer(current, this) : new LexerRule_0_0_0_0_0_0_Keyword_native(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// 'native'
protected class LexerRule_0_0_0_0_0_0_Keyword_native extends KeywordToken  {
	
	public LexerRule_0_0_0_0_0_0_Keyword_native(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0");
	}	
}

// 'lexer'
protected class LexerRule_0_0_0_0_0_1_Keyword_lexer extends KeywordToken  {
	
	public LexerRule_0_0_0_0_0_1_Keyword_lexer(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1");
	}	
}


// name = ID
protected class LexerRule_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public LexerRule_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( 'returns' type = TypeRef ) ?
protected class LexerRule_0_0_0_1_Group extends GroupToken {
	
	public LexerRule_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_1_0_Keyword_returns(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'returns'
protected class LexerRule_0_0_0_1_0_Keyword_returns extends KeywordToken  {
	
	public LexerRule_0_0_0_1_0_Keyword_returns(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}	
}

// type = TypeRef
protected class LexerRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public LexerRule_0_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}



// ':'
protected class LexerRule_0_0_1_Keyword extends KeywordToken  {
	
	public LexerRule_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// body = STRING
protected class LexerRule_0_1_Assignment_body extends AssignmentToken  {
	
	public LexerRule_0_1_Assignment_body(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("body",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("body");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ';'
protected class LexerRule_1_Keyword extends KeywordToken  {
	
	public LexerRule_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.5/@alternatives/@abstractTokens.1");
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
	
	public ParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives
protected class ParserRule_0_Group extends GroupToken {
	
	public ParserRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_1_Assignment_alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID ( 'returns' type = TypeRef ) ? ':'
protected class ParserRule_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID ( 'returns' type = TypeRef ) ?
protected class ParserRule_0_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID
protected class ParserRule_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public ParserRule_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// ( 'returns' type = TypeRef ) ?
protected class ParserRule_0_0_0_1_Group extends GroupToken {
	
	public ParserRule_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_1_0_Keyword_returns(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'returns'
protected class ParserRule_0_0_0_1_0_Keyword_returns extends KeywordToken  {
	
	public ParserRule_0_0_0_1_0_Keyword_returns(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}	
}

// type = TypeRef
protected class ParserRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public ParserRule_0_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}



// ':'
protected class ParserRule_0_0_1_Keyword extends KeywordToken  {
	
	public ParserRule_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// alternatives = Alternatives
protected class ParserRule_0_1_Assignment_alternatives extends AssignmentToken  {
	
	public ParserRule_0_1_Assignment_alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alternatives",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alternatives");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new Alternatives_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// ';'
protected class ParserRule_1_Keyword extends KeywordToken  {
	
	public ParserRule_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.6/@alternatives/@abstractTokens.1");
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
	
	public TypeRef_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.7/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TypeRef_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TypeRef_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( alias = ID '::' ) ?
protected class TypeRef_0_Group extends GroupToken {
	
	public TypeRef_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.7/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TypeRef_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TypeRef_0_0_Assignment_alias(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// alias = ID
protected class TypeRef_0_0_Assignment_alias extends AssignmentToken  {
	
	public TypeRef_0_0_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// '::'
protected class TypeRef_0_1_Keyword extends KeywordToken  {
	
	public TypeRef_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}	
}


// name = ID
protected class TypeRef_1_Assignment_name extends AssignmentToken  {
	
	public TypeRef_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.7/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
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
	
	public Alternatives_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.8/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Alternatives_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Alternatives_0_RuleCall_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// Group
protected class Alternatives_0_RuleCall_Group extends RuleCallToken {
	
	public Alternatives_0_RuleCall_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.8/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Group_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new Group_Group(current, this).firstSolution();
	}
}

// ( { current = Alternatives . groups += current } '|' groups += Group ) *
protected class Alternatives_1_Group extends GroupToken {
	
	public Alternatives_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.8/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Alternatives_1_1_Assignment_groups(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Alternatives_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = Alternatives . groups += current } '|'
protected class Alternatives_1_0_Group extends GroupToken {
	
	public Alternatives_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Alternatives_1_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Alternatives_1_0_0_Action_Alternatives_groups(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = Alternatives . groups += current }
protected class Alternatives_1_0_0_Action_Alternatives_groups extends ActionToken  {

	public Alternatives_1_0_0_Action_Alternatives_groups(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Alternatives")) return null;
		Object val = current.getConsumable("groups", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("groups")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// '|'
protected class Alternatives_1_0_1_Keyword extends KeywordToken  {
	
	public Alternatives_1_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	}	
}


// groups += Group
protected class Alternatives_1_1_Assignment_groups extends AssignmentToken  {
	
	public Alternatives_1_1_Assignment_groups(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("groups",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("groups");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new Group_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
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
	
	public Group_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.9/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Group_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Group_0_RuleCall_AbstractToken(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// AbstractToken
protected class Group_0_RuleCall_AbstractToken extends RuleCallToken {
	
	public Group_0_RuleCall_AbstractToken(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.9/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(AbstractToken_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new AbstractToken_Group(current, this).firstSolution();
	}
}

// ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) *
protected class Group_1_Group extends GroupToken {
	
	public Group_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.9/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Group_1_1_Assignment_abstractTokens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Group_1_0_Action_Group_abstractTokens(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = Group . abstractTokens += current }
protected class Group_1_0_Action_Group_abstractTokens extends ActionToken  {

	public Group_1_0_Action_Group_abstractTokens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Group")) return null;
		Object val = current.getConsumable("abstractTokens", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("abstractTokens")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// abstractTokens += AbstractToken
protected class Group_1_1_Assignment_abstractTokens extends AssignmentToken  {
	
	public Group_1_1_Assignment_abstractTokens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstractTokens",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstractTokens");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new AbstractToken_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
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
	
	public AbstractToken_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new AbstractToken_1_Assignment_cardinality(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractToken_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// Assignment | Action | AbstractTerminal
protected class AbstractToken_0_Alternatives extends AlternativesToken {

	public AbstractToken_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractToken_0_1_RuleCall_AbstractTerminal(current, this) : new AbstractToken_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Assignment | Action
protected class AbstractToken_0_0_Alternatives extends AlternativesToken {

	public AbstractToken_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@groups.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractToken_0_0_1_RuleCall_Action(current, this) : new AbstractToken_0_0_0_RuleCall_Assignment(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Assignment
protected class AbstractToken_0_0_0_RuleCall_Assignment extends RuleCallToken {
	
	public AbstractToken_0_0_0_RuleCall_Assignment(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Assignment_Group.class, current)) return null;
		if(!current.isInstanceOf("Assignment")) return null;
		return new Assignment_Group(current, this).firstSolution();
	}
}

// Action
protected class AbstractToken_0_0_1_RuleCall_Action extends RuleCallToken {
	
	public AbstractToken_0_0_1_RuleCall_Action(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Action_Group.class, current)) return null;
		if(!current.isInstanceOf("Action")) return null;
		return new Action_Group(current, this).firstSolution();
	}
}


// AbstractTerminal
protected class AbstractToken_0_1_RuleCall_AbstractTerminal extends RuleCallToken {
	
	public AbstractToken_0_1_RuleCall_AbstractTerminal(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.0/@groups.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(AbstractTerminal_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new AbstractTerminal_Alternatives(current, this).firstSolution();
	}
}


// ( cardinality = ( '?' | '*' | '+' ) ) ?
protected class AbstractToken_1_Assignment_cardinality extends AssignmentToken  {
	
	public AbstractToken_1_Assignment_cardinality(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("cardinality",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("cardinality");
		if("?".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0");
			return new Solution(obj);
		}
		if("*".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1");
			return new Solution(obj);
		}
		if("+".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.10/@alternatives/@abstractTokens.1/@terminal/@groups.1");
			return new Solution(obj);
		}
		return null;
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
	
	public Assignment_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Assignment_1_Assignment_terminal(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Assignment_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// feature = ID operator = ( '+=' | '=' | '?=' )
protected class Assignment_0_Group extends GroupToken {
	
	public Assignment_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Assignment_0_1_Assignment_operator(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Assignment_0_0_Assignment_feature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// feature = ID
protected class Assignment_0_0_Assignment_feature extends AssignmentToken  {
	
	public Assignment_0_0_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// operator = ( '+=' | '=' | '?=' )
protected class Assignment_0_1_Assignment_operator extends AssignmentToken  {
	
	public Assignment_0_1_Assignment_operator(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");
		if("+=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0");
			return new Solution(obj);
		}
		if("=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1");
			return new Solution(obj);
		}
		if("?=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
			return new Solution(obj);
		}
		return null;
	}
}


// terminal = AbstractTerminal
protected class Assignment_1_Assignment_terminal extends AssignmentToken  {
	
	public Assignment_1_Assignment_terminal(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.11/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("terminal",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("terminal");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new AbstractTerminal_Alternatives(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
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
	
	public Action_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current'
protected class Action_0_Group extends GroupToken {
	
	public Action_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_1_Keyword_current(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' )
protected class Action_0_0_Group extends GroupToken {
	
	public Action_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_1_Assignment_operator(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID
protected class Action_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_1_Assignment_feature(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef '.'
protected class Action_0_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '{' ( 'current' '=' ) ? typeName = TypeRef
protected class Action_0_0_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_0_1_Assignment_typeName(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '{' ( 'current' '=' ) ?
protected class Action_0_0_0_0_0_0_Group extends GroupToken {
	
	public Action_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '{'
protected class Action_0_0_0_0_0_0_0_Keyword extends KeywordToken  {
	
	public Action_0_0_0_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// ( 'current' '=' ) ?
protected class Action_0_0_0_0_0_0_1_Group extends GroupToken {
	
	public Action_0_0_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_0_1_0_Keyword_current(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'current'
protected class Action_0_0_0_0_0_0_1_0_Keyword_current extends KeywordToken  {
	
	public Action_0_0_0_0_0_0_1_0_Keyword_current(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}	
}

// '='
protected class Action_0_0_0_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public Action_0_0_0_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}	
}



// typeName = TypeRef
protected class Action_0_0_0_0_0_1_Assignment_typeName extends AssignmentToken  {
	
	public Action_0_0_0_0_0_1_Assignment_typeName(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("typeName",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("typeName");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// '.'
protected class Action_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public Action_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// feature = ID
protected class Action_0_0_0_1_Assignment_feature extends AssignmentToken  {
	
	public Action_0_0_0_1_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// operator = ( '=' | '+=' )
protected class Action_0_0_1_Assignment_operator extends AssignmentToken  {
	
	public Action_0_0_1_Assignment_operator(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");
		if("=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
			return new Solution(obj);
		}
		if("+=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
			return new Solution(obj);
		}
		return null;
	}
}


// 'current'
protected class Action_0_1_Keyword_current extends KeywordToken  {
	
	public Action_0_1_Keyword_current(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}	
}


// '}'
protected class Action_1_Keyword extends KeywordToken  {
	
	public Action_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.12/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Action ****************/

/************ begin Rule AbstractTerminal ****************
 *
 * AbstractTerminal returns AbstractElement : Keyword | RuleCall | ParenthesizedElement | CrossReference ;
 *
 **/


// Keyword | RuleCall | ParenthesizedElement | CrossReference
protected class AbstractTerminal_Alternatives extends AlternativesToken {

	public AbstractTerminal_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.13/@alternatives");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractTerminal_1_RuleCall_CrossReference(current, this) : new AbstractTerminal_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Keyword | RuleCall | ParenthesizedElement
protected class AbstractTerminal_0_Alternatives extends AlternativesToken {

	public AbstractTerminal_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.13/@alternatives/@groups.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractTerminal_0_1_RuleCall_ParenthesizedElement(current, this) : new AbstractTerminal_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Keyword | RuleCall
protected class AbstractTerminal_0_0_Alternatives extends AlternativesToken {

	public AbstractTerminal_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.13/@alternatives/@groups.0/@groups.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractTerminal_0_0_1_RuleCall_RuleCall(current, this) : new AbstractTerminal_0_0_0_RuleCall_Keyword(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Keyword
protected class AbstractTerminal_0_0_0_RuleCall_Keyword extends RuleCallToken {
	
	public AbstractTerminal_0_0_0_RuleCall_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.13/@alternatives/@groups.0/@groups.0/@groups.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Keyword_Assignment_value.class, current)) return null;
		if(!current.isInstanceOf("Keyword")) return null;
		return new Keyword_Assignment_value(current, this).firstSolution();
	}
}

// RuleCall
protected class AbstractTerminal_0_0_1_RuleCall_RuleCall extends RuleCallToken {
	
	public AbstractTerminal_0_0_1_RuleCall_RuleCall(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.13/@alternatives/@groups.0/@groups.0/@groups.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(RuleCall_Assignment_rule.class, current)) return null;
		if(!current.isInstanceOf("RuleCall")) return null;
		return new RuleCall_Assignment_rule(current, this).firstSolution();
	}
}


// ParenthesizedElement
protected class AbstractTerminal_0_1_RuleCall_ParenthesizedElement extends RuleCallToken {
	
	public AbstractTerminal_0_1_RuleCall_ParenthesizedElement(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.13/@alternatives/@groups.0/@groups.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(ParenthesizedElement_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new ParenthesizedElement_Group(current, this).firstSolution();
	}
}


// CrossReference
protected class AbstractTerminal_1_RuleCall_CrossReference extends RuleCallToken {
	
	public AbstractTerminal_1_RuleCall_CrossReference(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.13/@alternatives/@groups.1");
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
 * CrossReference : '[' type = TypeRef ( '|' rule = [ LexerRule ] ) ? ']' ;
 *
 **/


// '[' type = TypeRef ( '|' rule = [ LexerRule ] ) ? ']'
protected class CrossReference_Group extends GroupToken {
	
	public CrossReference_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '[' type = TypeRef ( '|' rule = [ LexerRule ] ) ?
protected class CrossReference_0_Group extends GroupToken {
	
	public CrossReference_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '[' type = TypeRef
protected class CrossReference_0_0_Group extends GroupToken {
	
	public CrossReference_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_0_0_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '['
protected class CrossReference_0_0_0_Keyword extends KeywordToken  {
	
	public CrossReference_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// type = TypeRef
protected class CrossReference_0_0_1_Assignment_type extends AssignmentToken  {
	
	public CrossReference_0_0_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// ( '|' rule = [ LexerRule ] ) ?
protected class CrossReference_0_1_Group extends GroupToken {
	
	public CrossReference_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_0_1_1_Assignment_rule(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '|'
protected class CrossReference_0_1_0_Keyword extends KeywordToken  {
	
	public CrossReference_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}	
}

// rule = [ LexerRule ]
protected class CrossReference_0_1_1_Assignment_rule extends AssignmentToken  {
	
	public CrossReference_0_1_1_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("LexerRule")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



// ']'
protected class CrossReference_1_Keyword extends KeywordToken  {
	
	public CrossReference_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.14/@alternatives/@abstractTokens.1");
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
	
	public ParenthesizedElement_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.15/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParenthesizedElement_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParenthesizedElement_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '(' Alternatives
protected class ParenthesizedElement_0_Group extends GroupToken {
	
	public ParenthesizedElement_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.15/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParenthesizedElement_0_1_RuleCall_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParenthesizedElement_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '('
protected class ParenthesizedElement_0_0_Keyword extends KeywordToken  {
	
	public ParenthesizedElement_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}	
}

// Alternatives
protected class ParenthesizedElement_0_1_RuleCall_Alternatives extends RuleCallToken {
	
	public ParenthesizedElement_0_1_RuleCall_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Alternatives_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new Alternatives_Group(current, this).firstSolution();
	}
}


// ')'
protected class ParenthesizedElement_1_Keyword extends KeywordToken  {
	
	public ParenthesizedElement_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.15/@alternatives/@abstractTokens.1");
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
	
	public Keyword_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.16/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.16/@alternatives/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Keyword ****************/

/************ begin Rule RuleCall ****************
 *
 * RuleCall : rule = [ AbstractRule ] ;
 *
 **/


// rule = [ AbstractRule ]
protected class RuleCall_Assignment_rule extends AssignmentToken  {
	
	public RuleCall_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.17/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@rules.17/@alternatives/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

/************ end Rule RuleCall ****************/

}
