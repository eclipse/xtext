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
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess;


public class XtextParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		if(object == null) throw new IllegalArgumentException("The to-be-serialialized model is null");
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
		return XtextGrammarAccess.INSTANCE.prGrammar().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele000Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele0000Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00000Alternatives();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele000000AssignmentAbstract();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstract",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstract");
		if("abstract language".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prGrammar().ele0000000KeywordAbstractLanguage();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele000001KeywordLanguage();
	}	
}


// idElements += ID
protected class Grammar_0_0_0_0_1_Assignment_idElements extends AssignmentToken  {
	
	public Grammar_0_0_0_0_1_Assignment_idElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00001AssignmentIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("idElements",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("idElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prGrammar().ele000010LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele0001Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00010KeywordFullStop();
	}	
}

// idElements += ID
protected class Grammar_0_0_0_1_1_Assignment_idElements extends AssignmentToken  {
	
	public Grammar_0_0_0_1_1_Assignment_idElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00011AssignmentIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("idElements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("idElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prGrammar().ele000110LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele001Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele0010Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00100KeywordExtends();
	}	
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_0_1_Assignment_superGrammarIdElements extends AssignmentToken  {
	
	public Grammar_0_0_1_0_1_Assignment_superGrammarIdElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00101AssignmentSuperGrammarIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("superGrammarIdElements",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("superGrammarIdElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prGrammar().ele001010LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele0011Group();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00110KeywordFullStop();
	}	
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_1_1_Assignment_superGrammarIdElements extends AssignmentToken  {
	
	public Grammar_0_0_1_1_1_Assignment_superGrammarIdElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prGrammar().ele00111AssignmentSuperGrammarIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("superGrammarIdElements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("superGrammarIdElements");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prGrammar().ele001110LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele01AssignmentMetamodelDeclarations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("metamodelDeclarations",!IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prGrammar().ele1AssignmentRules();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rules",IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prAbstractRule().eleAlternatives();
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
		return XtextGrammarAccess.INSTANCE.prAbstractRule().ele0ParserRuleCallLexerRule();
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
		return XtextGrammarAccess.INSTANCE.prAbstractRule().ele1ParserRuleCallParserRule();
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
		return XtextGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().eleAlternatives();
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
		return XtextGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel();
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
		return XtextGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel();
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
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele00Group();
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
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele000KeywordGenerate();
	}	
}

// name = ID
protected class GeneratedMetamodel_0_0_1_Assignment_name extends AssignmentToken  {
	
	public GeneratedMetamodel_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele0010LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele01AssignmentNsURI();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nsURI",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nsURI");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele010LexerRuleCallSTRING();
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
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele1Group();
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
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele10KeywordAs();
	}	
}

// alias = ID
protected class GeneratedMetamodel_1_1_Assignment_alias extends AssignmentToken  {
	
	public GeneratedMetamodel_1_1_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele11AssignmentAlias();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele110LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele00KeywordImport();
	}	
}

// uri = STRING
protected class ReferencedMetamodel_0_1_Assignment_uri extends AssignmentToken  {
	
	public ReferencedMetamodel_0_1_Assignment_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele01AssignmentUri();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("uri",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("uri");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele010LexerRuleCallSTRING();
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
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele1Group();
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
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele10KeywordAs();
	}	
}

// alias = ID
protected class ReferencedMetamodel_1_1_Assignment_alias extends AssignmentToken  {
	
	public ReferencedMetamodel_1_1_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele11AssignmentAlias();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele110LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele00Group();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele000Group();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele0000Group();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele00000Alternatives();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele000000KeywordNative();
	}	
}

// 'lexer'
protected class LexerRule_0_0_0_0_0_1_Keyword_lexer extends KeywordToken  {
	
	public LexerRule_0_0_0_0_0_1_Keyword_lexer(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele000001KeywordLexer();
	}	
}


// name = ID
protected class LexerRule_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public LexerRule_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele00001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prLexerRule().ele000010LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele0001Group();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele00010KeywordReturns();
	}	
}

// type = TypeRef
protected class LexerRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public LexerRule_0_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele00011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",!IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele001KeywordColon();
	}	
}


// body = STRING
protected class LexerRule_0_1_Assignment_body extends AssignmentToken  {
	
	public LexerRule_0_1_Assignment_body(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele01AssignmentBody();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("body",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("body");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prLexerRule().ele010LexerRuleCallSTRING();
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
		return XtextGrammarAccess.INSTANCE.prLexerRule().ele1KeywordSemicolon();
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
		return XtextGrammarAccess.INSTANCE.prParserRule().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele00Group();
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele000Group();
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele0000AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prParserRule().ele00000LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele0001Group();
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele00010KeywordReturns();
	}	
}

// type = TypeRef
protected class ParserRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public ParserRule_0_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prParserRule().ele00011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",!IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele001KeywordColon();
	}	
}


// alternatives = Alternatives
protected class ParserRule_0_1_Assignment_alternatives extends AssignmentToken  {
	
	public ParserRule_0_1_Assignment_alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prParserRule().ele01AssignmentAlternatives();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alternatives",IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prParserRule().ele1KeywordSemicolon();
	}	
}


/************ end Rule ParserRule ****************/


/************ begin Rule TypeRef ****************
 *
 * TypeRef : ( metamodel = [ AbstractMetamodelDeclaration ] '::' ) ? type = [ EClassifier ] ;
 *
 **/


// ( metamodel = [ AbstractMetamodelDeclaration ] '::' ) ? type = [ EClassifier ]
protected class TypeRef_Group extends GroupToken {
	
	public TypeRef_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prTypeRef().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TypeRef_1_Assignment_type(current, this).firstSolution();
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

// ( metamodel = [ AbstractMetamodelDeclaration ] '::' ) ?
protected class TypeRef_0_Group extends GroupToken {
	
	public TypeRef_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prTypeRef().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TypeRef_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TypeRef_0_0_Assignment_metamodel(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// metamodel = [ AbstractMetamodelDeclaration ]
protected class TypeRef_0_0_Assignment_metamodel extends AssignmentToken  {
	
	public TypeRef_0_0_Assignment_metamodel(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prTypeRef().ele00AssignmentMetamodel();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("metamodel",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("metamodel");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractMetamodelDeclaration")) {
				type = AssignmentType.CR;
				element = XtextGrammarAccess.INSTANCE.prTypeRef().ele000CrossReferenceAbstractMetamodelDeclaration(); 
				return new Solution(obj);
			}
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
		return XtextGrammarAccess.INSTANCE.prTypeRef().ele01KeywordColonColon();
	}	
}


// type = [ EClassifier ]
protected class TypeRef_1_Assignment_type extends AssignmentToken  {
	
	public TypeRef_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prTypeRef().ele1AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EClassifier")) {
				type = AssignmentType.CR;
				element = XtextGrammarAccess.INSTANCE.prTypeRef().ele10CrossReferenceEClassifier(); 
				return new Solution(obj);
			}
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
		return XtextGrammarAccess.INSTANCE.prAlternatives().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prAlternatives().ele0ParserRuleCallGroup();
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
		return XtextGrammarAccess.INSTANCE.prAlternatives().ele1Group();
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
		return XtextGrammarAccess.INSTANCE.prAlternatives().ele10Group();
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
		return XtextGrammarAccess.INSTANCE.prAlternatives().ele100ActionAlternativesgroups();
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
		return XtextGrammarAccess.INSTANCE.prAlternatives().ele101KeywordVerticalLine();
	}	
}


// groups += Group
protected class Alternatives_1_1_Assignment_groups extends AssignmentToken  {
	
	public Alternatives_1_1_Assignment_groups(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAlternatives().ele11AssignmentGroups();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("groups",!IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prGroup().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prGroup().ele0ParserRuleCallAbstractToken();
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
		return XtextGrammarAccess.INSTANCE.prGroup().ele1Group();
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
		return XtextGrammarAccess.INSTANCE.prGroup().ele10ActionGroupabstractTokens();
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
		return XtextGrammarAccess.INSTANCE.prGroup().ele11AssignmentAbstractTokens();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstractTokens",!IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prAbstractToken().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prAbstractToken().ele0Alternatives();
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
		return XtextGrammarAccess.INSTANCE.prAbstractToken().ele00Alternatives();
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
		return XtextGrammarAccess.INSTANCE.prAbstractToken().ele000ParserRuleCallAssignment();
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
		return XtextGrammarAccess.INSTANCE.prAbstractToken().ele001ParserRuleCallAction();
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
		return XtextGrammarAccess.INSTANCE.prAbstractToken().ele01ParserRuleCallAbstractTerminal();
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
		return XtextGrammarAccess.INSTANCE.prAbstractToken().ele1AssignmentCardinality();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("cardinality",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("cardinality");
		if("?".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAbstractToken().ele1000KeywordQuestionMark();
			return new Solution(obj);
		}
		if("*".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAbstractToken().ele1001KeywordAsterisk();
			return new Solution(obj);
		}
		if("+".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAbstractToken().ele101KeywordPlusSign();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule AbstractToken ****************/


/************ begin Rule Assignment ****************
 *
 * Assignment : feature = ID operator = ( '+=' | '=' | '?=' ) terminal = AbstractTerminal ;
 *
 **/


// feature = ID operator = ( '+=' | '=' | '?=' ) terminal = AbstractTerminal
protected class Assignment_Group extends GroupToken {
	
	public Assignment_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAssignment().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prAssignment().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prAssignment().ele00AssignmentFeature();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prAssignment().ele000LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prAssignment().ele01AssignmentOperator();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");
		if("+=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAssignment().ele01000KeywordPlusSignEqualsSign();
			return new Solution(obj);
		}
		if("=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAssignment().ele01001KeywordEqualsSign();
			return new Solution(obj);
		}
		if("?=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAssignment().ele0101KeywordQuestionMarkEqualsSign();
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
		return XtextGrammarAccess.INSTANCE.prAssignment().ele1AssignmentTerminal();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("terminal",IS_REQUIRED)) == null) return null;
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
 * Action : '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current' '}' ;
 *
 **/


// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current' '}'
protected class Action_Group extends GroupToken {
	
	public Action_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAction().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele00Group();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele000Group();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele0000Group();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele00000Group();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele000000Group();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele0000000KeywordLeftCurlyBracket();
	}	
}

// ( 'current' '=' ) ?
protected class Action_0_0_0_0_0_0_1_Group extends GroupToken {
	
	public Action_0_0_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAction().ele0000001Group();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele00000010KeywordCurrent();
	}	
}

// '='
protected class Action_0_0_0_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public Action_0_0_0_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAction().ele00000011KeywordEqualsSign();
	}	
}



// typeName = TypeRef
protected class Action_0_0_0_0_0_1_Assignment_typeName extends AssignmentToken  {
	
	public Action_0_0_0_0_0_1_Assignment_typeName(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAction().ele000001AssignmentTypeName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("typeName",IS_REQUIRED)) == null) return null;
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
		return XtextGrammarAccess.INSTANCE.prAction().ele00001KeywordFullStop();
	}	
}


// feature = ID
protected class Action_0_0_0_1_Assignment_feature extends AssignmentToken  {
	
	public Action_0_0_0_1_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAction().ele0001AssignmentFeature();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prAction().ele00010LexerRuleCallID();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele001AssignmentOperator();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");
		if("=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAction().ele00100KeywordEqualsSign();
			return new Solution(obj);
		}
		if("+=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextGrammarAccess.INSTANCE.prAction().ele00101KeywordPlusSignEqualsSign();
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
		return XtextGrammarAccess.INSTANCE.prAction().ele01KeywordCurrent();
	}	
}


// '}'
protected class Action_1_Keyword extends KeywordToken  {
	
	public Action_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAction().ele1KeywordRightCurlyBracket();
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal().eleAlternatives();
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal().ele0Alternatives();
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal().ele00Alternatives();
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal().ele000ParserRuleCallKeyword();
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal().ele001ParserRuleCallRuleCall();
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal().ele01ParserRuleCallParenthesizedElement();
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal().ele1ParserRuleCallCrossReference();
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
 * CrossReference : '[' type = TypeRef ( '|' rule = [ AbstractRule ] ) ? ']' ;
 *
 **/


// '[' type = TypeRef ( '|' rule = [ AbstractRule ] ) ? ']'
protected class CrossReference_Group extends GroupToken {
	
	public CrossReference_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prCrossReference().eleGroup();
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

// '[' type = TypeRef ( '|' rule = [ AbstractRule ] ) ?
protected class CrossReference_0_Group extends GroupToken {
	
	public CrossReference_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele00Group();
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
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele000KeywordLeftSquareBracket();
	}	
}

// type = TypeRef
protected class CrossReference_0_0_1_Assignment_type extends AssignmentToken  {
	
	public CrossReference_0_0_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele001AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
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


// ( '|' rule = [ AbstractRule ] ) ?
protected class CrossReference_0_1_Group extends GroupToken {
	
	public CrossReference_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele01Group();
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
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele010KeywordVerticalLine();
	}	
}

// rule = [ AbstractRule ]
protected class CrossReference_0_1_1_Assignment_rule extends AssignmentToken  {
	
	public CrossReference_0_1_1_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele011AssignmentRule();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = XtextGrammarAccess.INSTANCE.prCrossReference().ele0110CrossReferenceAbstractRule(); 
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
		return XtextGrammarAccess.INSTANCE.prCrossReference().ele1KeywordRightSquareBracket();
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
		return XtextGrammarAccess.INSTANCE.prParenthesizedElement().eleGroup();
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
		return XtextGrammarAccess.INSTANCE.prParenthesizedElement().ele0Group();
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
		return XtextGrammarAccess.INSTANCE.prParenthesizedElement().ele00KeywordLeftParenthesis();
	}	
}

// Alternatives
protected class ParenthesizedElement_0_1_RuleCall_Alternatives extends RuleCallToken {
	
	public ParenthesizedElement_0_1_RuleCall_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prParenthesizedElement().ele01ParserRuleCallAlternatives();
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
		return XtextGrammarAccess.INSTANCE.prParenthesizedElement().ele1KeywordRightParenthesis();
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
		return XtextGrammarAccess.INSTANCE.prKeyword().eleAssignmentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = XtextGrammarAccess.INSTANCE.prKeyword().ele0LexerRuleCallSTRING();
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
		return XtextGrammarAccess.INSTANCE.prRuleCall().eleAssignmentRule();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = XtextGrammarAccess.INSTANCE.prRuleCall().ele0CrossReferenceAbstractRule(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

/************ end Rule RuleCall ****************/

}
