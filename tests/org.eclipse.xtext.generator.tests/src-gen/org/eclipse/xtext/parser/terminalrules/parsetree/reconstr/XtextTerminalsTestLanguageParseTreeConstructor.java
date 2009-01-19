/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;


public class XtextTerminalsTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Grammar") && (s = new Grammar_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractRule") && (s = new AbstractRule_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractMetamodelDeclaration") && (s = new AbstractMetamodelDeclaration_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("GeneratedMetamodel") && (s = new GeneratedMetamodel_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ReferencedMetamodel") && (s = new ReferencedMetamodel_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("LexerRule") && (s = new LexerRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ParserRule") && (s = new ParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ParserRule") && (s = new TerminalRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TypeRef") && (s = new TypeRef_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new Alternatives_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new TerminalAlternatives_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new Group_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new TerminalGroup_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new AbstractToken_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new TerminalToken_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Assignment") && (s = new Assignment_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Action") && (s = new Action_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new AbstractTerminal_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new TerminalTokenElement_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractNegatedToken") && (s = new AbstractNegatedToken_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("NegatedToken") && (s = new NegatedToken_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("UpToToken") && (s = new UpToToken_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Wildcard") && (s = new Wildcard_Assignment_isWildcard(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new CharacterRange_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("CrossReference") && (s = new CrossReference_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new ParenthesizedElement_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new ParenthesizedTerminalElement_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Keyword") && (s = new Keyword_Assignment_value(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("RuleCall") && (s = new RuleCall_Assignment_rule(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Grammar ****************
 *
 * Grammar hidden ( WS , ML_COMMENT , SL_COMMENT ) : ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) + ;
 *
 **/


// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) +
protected class Grammar_Group extends GroupToken {
	
	public Grammar_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_1_Assignment_rules(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_1_Assignment_metamodelDeclarations(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_0_0_1_Assignment_idElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_0_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00000Alternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele000000AssignmentAbstract();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstract",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstract");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele0000000KeywordAbstractLanguage();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele000001KeywordLanguage();
	}	
}


// idElements += ID
protected class Grammar_0_0_0_0_1_Assignment_idElements extends AssignmentToken  {
	
	public Grammar_0_0_0_0_1_Assignment_idElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00001AssignmentIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("idElements",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("idElements");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele000010ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_0_1_1_Assignment_idElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00010KeywordFullStop();
	}	
}

// idElements += ID
protected class Grammar_0_0_0_1_1_Assignment_idElements extends AssignmentToken  {
	
	public Grammar_0_0_0_1_1_Assignment_idElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00011AssignmentIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("idElements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("idElements");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele000110ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele0010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_0_1_Assignment_superGrammarIdElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_1_0_0_Keyword_extends(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00100KeywordExtends();
	}	
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_0_1_Assignment_superGrammarIdElements extends AssignmentToken  {
	
	public Grammar_0_0_1_0_1_Assignment_superGrammarIdElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00101AssignmentSuperGrammarIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("superGrammarIdElements",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("superGrammarIdElements");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele001010ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele0011Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Grammar_0_0_1_1_1_Assignment_superGrammarIdElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Grammar_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00110KeywordFullStop();
	}	
}

// superGrammarIdElements += ID
protected class Grammar_0_0_1_1_1_Assignment_superGrammarIdElements extends AssignmentToken  {
	
	public Grammar_0_0_1_1_1_Assignment_superGrammarIdElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele00111AssignmentSuperGrammarIdElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("superGrammarIdElements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("superGrammarIdElements");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele001110ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele01AssignmentMetamodelDeclarations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("metamodelDeclarations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("metamodelDeclarations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractMetamodelDeclaration")) {
				Solution s = new AbstractMetamodelDeclaration_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar().ele1AssignmentRules();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rules",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rules");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				Solution s = new AbstractRule_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
 * AbstractRule : LexerRule | ParserRule | TerminalRule ;
 *
 **/


// LexerRule | ParserRule | TerminalRule
protected class AbstractRule_Alternatives extends AlternativesToken {

	public AbstractRule_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractRule().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractRule_1_RuleCall_TerminalRule(current, this) : new AbstractRule_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// LexerRule | ParserRule
protected class AbstractRule_0_Alternatives extends AlternativesToken {

	public AbstractRule_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractRule().ele0Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractRule_0_1_RuleCall_ParserRule(current, this) : new AbstractRule_0_0_RuleCall_LexerRule(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// LexerRule
protected class AbstractRule_0_0_RuleCall_LexerRule extends RuleCallToken {
	
	public AbstractRule_0_0_RuleCall_LexerRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractRule().ele00ParserRuleCallLexerRule();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(LexerRule_Group.class, current)) return null;
		if(!current.isInstanceOf("LexerRule")) return null;
		return new LexerRule_Group(current, this).firstSolution();
	}
}

// ParserRule
protected class AbstractRule_0_1_RuleCall_ParserRule extends RuleCallToken {
	
	public AbstractRule_0_1_RuleCall_ParserRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractRule().ele01ParserRuleCallParserRule();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(ParserRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ParserRule")) return null;
		return new ParserRule_Group(current, this).firstSolution();
	}
}


// TerminalRule
protected class AbstractRule_1_RuleCall_TerminalRule extends RuleCallToken {
	
	public AbstractRule_1_RuleCall_TerminalRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractRule().ele1ParserRuleCallTerminalRule();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TerminalRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ParserRule")) return null;
		return new TerminalRule_Group(current, this).firstSolution();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().eleAlternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel();
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
 * GeneratedMetamodel : 'generate' name = ID ePackage = [ EPackage | STRING ] ( 'as' alias = ID ) ? ;
 *
 **/


// 'generate' name = ID ePackage = [ EPackage | STRING ] ( 'as' alias = ID ) ?
protected class GeneratedMetamodel_Group extends GroupToken {
	
	public GeneratedMetamodel_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'generate' name = ID ePackage = [ EPackage | STRING ]
protected class GeneratedMetamodel_0_Group extends GroupToken {
	
	public GeneratedMetamodel_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_0_1_Assignment_ePackage(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_0_0_0_Keyword_generate(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele000KeywordGenerate();
	}	
}

// name = ID
protected class GeneratedMetamodel_0_0_1_Assignment_name extends AssignmentToken  {
	
	public GeneratedMetamodel_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele0010ParserRuleCallID();
			return new Solution(obj);
		}

		return null;
	}
}


// ePackage = [ EPackage | STRING ]
protected class GeneratedMetamodel_0_1_Assignment_ePackage extends AssignmentToken  {
	
	public GeneratedMetamodel_0_1_Assignment_ePackage(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele01AssignmentEPackage();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ePackage",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ePackage");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EPackage")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele010CrossReferenceEStringEPackage(); 
				return new Solution(obj);
			}
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new GeneratedMetamodel_1_1_Assignment_alias(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new GeneratedMetamodel_1_0_Keyword_as(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele10KeywordAs();
	}	
}

// alias = ID
protected class GeneratedMetamodel_1_1_Assignment_alias extends AssignmentToken  {
	
	public GeneratedMetamodel_1_1_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele11AssignmentAlias();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel().ele110ParserRuleCallID();
			return new Solution(obj);
		}

		return null;
	}
}



/************ end Rule GeneratedMetamodel ****************/


/************ begin Rule ReferencedMetamodel ****************
 *
 * ReferencedMetamodel : 'import' ePackage = [ EPackage | STRING ] ( 'as' alias = ID ) ? ;
 *
 **/


// 'import' ePackage = [ EPackage | STRING ] ( 'as' alias = ID ) ?
protected class ReferencedMetamodel_Group extends GroupToken {
	
	public ReferencedMetamodel_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ReferencedMetamodel_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReferencedMetamodel_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'import' ePackage = [ EPackage | STRING ]
protected class ReferencedMetamodel_0_Group extends GroupToken {
	
	public ReferencedMetamodel_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ReferencedMetamodel_0_1_Assignment_ePackage(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReferencedMetamodel_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele00KeywordImport();
	}	
}

// ePackage = [ EPackage | STRING ]
protected class ReferencedMetamodel_0_1_Assignment_ePackage extends AssignmentToken  {
	
	public ReferencedMetamodel_0_1_Assignment_ePackage(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele01AssignmentEPackage();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ePackage",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ePackage");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EPackage")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele010CrossReferenceEStringEPackage(); 
				return new Solution(obj);
			}
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ReferencedMetamodel_1_1_Assignment_alias(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ReferencedMetamodel_1_0_Keyword_as(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele10KeywordAs();
	}	
}

// alias = ID
protected class ReferencedMetamodel_1_1_Assignment_alias extends AssignmentToken  {
	
	public ReferencedMetamodel_1_1_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele11AssignmentAlias();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel().ele110ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_1_Assignment_body(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_0_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele00000Alternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele000000KeywordNative();
	}	
}

// 'lexer'
protected class LexerRule_0_0_0_0_0_1_Keyword_lexer extends KeywordToken  {
	
	public LexerRule_0_0_0_0_0_1_Keyword_lexer(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele000001KeywordLexer();
	}	
}


// name = ID
protected class LexerRule_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public LexerRule_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele00001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele000010ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new LexerRule_0_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LexerRule_0_0_0_1_0_Keyword_returns(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele00010KeywordReturns();
	}	
}

// type = TypeRef
protected class LexerRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public LexerRule_0_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele00011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele001KeywordColon();
	}	
}


// body = STRING
protected class LexerRule_0_1_Assignment_body extends AssignmentToken  {
	
	public LexerRule_0_1_Assignment_body(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele01AssignmentBody();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("body",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("body");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele010ParserRuleCallSTRING();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prLexerRule().ele1KeywordSemicolon();
	}	
}


/************ end Rule LexerRule ****************/


/************ begin Rule ParserRule ****************
 *
 * ParserRule : name = ID ( 'returns' type = TypeRef ) ? ( definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ] ( ',' hiddenTokens += [ AbstractRule ] ) ')' ) ? ':' alternatives = Alternatives ';' ;
 *
 **/


// name = ID ( 'returns' type = TypeRef ) ? ( definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ] ( ',' hiddenTokens += [ AbstractRule ] ) ')' ) ? ':' alternatives = Alternatives ';'
protected class ParserRule_Group extends GroupToken {
	
	public ParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID ( 'returns' type = TypeRef ) ? ( definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ] ( ',' hiddenTokens += [ AbstractRule ] ) ')' ) ? ':' alternatives = Alternatives
protected class ParserRule_0_Group extends GroupToken {
	
	public ParserRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_1_Assignment_alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID ( 'returns' type = TypeRef ) ? ( definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ] ( ',' hiddenTokens += [ AbstractRule ] ) ')' ) ? ':'
protected class ParserRule_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID ( 'returns' type = TypeRef ) ? ( definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ] ( ',' hiddenTokens += [ AbstractRule ] ) ')' ) ?
protected class ParserRule_0_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class ParserRule_0_0_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class ParserRule_0_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public ParserRule_0_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00000AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele000000ParserRuleCallID();
			return new Solution(obj);
		}

		return null;
	}
}

// ( 'returns' type = TypeRef ) ?
protected class ParserRule_0_0_0_0_1_Group extends GroupToken {
	
	public ParserRule_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_0_1_0_Keyword_returns(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class ParserRule_0_0_0_0_1_0_Keyword_returns extends KeywordToken  {
	
	public ParserRule_0_0_0_0_1_0_Keyword_returns(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele000010KeywordReturns();
	}	
}

// type = TypeRef
protected class ParserRule_0_0_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public ParserRule_0_0_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele000011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// ( definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ] ( ',' hiddenTokens += [ AbstractRule ] ) ')' ) ?
protected class ParserRule_0_0_0_1_Group extends GroupToken {
	
	public ParserRule_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ] ( ',' hiddenTokens += [ AbstractRule ] )
protected class ParserRule_0_0_0_1_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// definesHiddenTokens ?= 'hidden' '(' hiddenTokens += [ AbstractRule ]
protected class ParserRule_0_0_0_1_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele000100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_0_0_1_Assignment_hiddenTokens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_1_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// definesHiddenTokens ?= 'hidden' '('
protected class ParserRule_0_0_0_1_0_0_0_Group extends GroupToken {
	
	public ParserRule_0_0_0_1_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele0001000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_1_0_0_0_0_Assignment_definesHiddenTokens(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// definesHiddenTokens ?= 'hidden'
protected class ParserRule_0_0_0_1_0_0_0_0_Assignment_definesHiddenTokens extends AssignmentToken  {
	
	public ParserRule_0_0_0_1_0_0_0_0_Assignment_definesHiddenTokens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00010000AssignmentDefinesHiddenTokens();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("definesHiddenTokens",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("definesHiddenTokens");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele000100000KeywordHidden();
			return new Solution(obj);
		}

		return null;
	}
}

// '('
protected class ParserRule_0_0_0_1_0_0_0_1_Keyword extends KeywordToken  {
	
	public ParserRule_0_0_0_1_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00010001KeywordLeftParenthesis();
	}	
}


// hiddenTokens += [ AbstractRule ]
protected class ParserRule_0_0_0_1_0_0_1_Assignment_hiddenTokens extends AssignmentToken  {
	
	public ParserRule_0_0_0_1_0_0_1_Assignment_hiddenTokens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele0001001AssignmentHiddenTokens();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("hiddenTokens",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("hiddenTokens");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00010010CrossReferenceEStringAbstractRule(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// ',' hiddenTokens += [ AbstractRule ]
protected class ParserRule_0_0_0_1_0_1_Group extends GroupToken {
	
	public ParserRule_0_0_0_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele000101Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParserRule_0_0_0_1_0_1_1_Assignment_hiddenTokens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParserRule_0_0_0_1_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ','
protected class ParserRule_0_0_0_1_0_1_0_Keyword extends KeywordToken  {
	
	public ParserRule_0_0_0_1_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele0001010KeywordComma();
	}	
}

// hiddenTokens += [ AbstractRule ]
protected class ParserRule_0_0_0_1_0_1_1_Assignment_hiddenTokens extends AssignmentToken  {
	
	public ParserRule_0_0_0_1_0_1_1_Assignment_hiddenTokens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele0001011AssignmentHiddenTokens();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("hiddenTokens",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("hiddenTokens");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00010110CrossReferenceEStringAbstractRule(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



// ')'
protected class ParserRule_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public ParserRule_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele00011KeywordRightParenthesis();
	}	
}



// ':'
protected class ParserRule_0_0_1_Keyword extends KeywordToken  {
	
	public ParserRule_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele001KeywordColon();
	}	
}


// alternatives = Alternatives
protected class ParserRule_0_1_Assignment_alternatives extends AssignmentToken  {
	
	public ParserRule_0_1_Assignment_alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele01AssignmentAlternatives();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alternatives",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alternatives");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new Alternatives_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParserRule().ele1KeywordSemicolon();
	}	
}


/************ end Rule ParserRule ****************/


/************ begin Rule TerminalRule ****************
 *
 * TerminalRule returns ParserRule : ^terminal ?= 'terminal' name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = TerminalAlternatives ';' ;
 *
 **/


// ^terminal ?= 'terminal' name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = TerminalAlternatives ';'
protected class TerminalRule_Group extends GroupToken {
	
	public TerminalRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalRule_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ^terminal ?= 'terminal' name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = TerminalAlternatives
protected class TerminalRule_0_Group extends GroupToken {
	
	public TerminalRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalRule_0_1_Assignment_alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ^terminal ?= 'terminal' name = ID ( 'returns' type = TypeRef ) ? ':'
protected class TerminalRule_0_0_Group extends GroupToken {
	
	public TerminalRule_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalRule_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalRule_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ^terminal ?= 'terminal' name = ID ( 'returns' type = TypeRef ) ?
protected class TerminalRule_0_0_0_Group extends GroupToken {
	
	public TerminalRule_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalRule_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalRule_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ^terminal ?= 'terminal' name = ID
protected class TerminalRule_0_0_0_0_Group extends GroupToken {
	
	public TerminalRule_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalRule_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalRule_0_0_0_0_0_Assignment_terminal(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ^terminal ?= 'terminal'
protected class TerminalRule_0_0_0_0_0_Assignment_terminal extends AssignmentToken  {
	
	public TerminalRule_0_0_0_0_0_Assignment_terminal(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele00000AssignmentTerminal();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("terminal",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("terminal");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele000000KeywordTerminal();
			return new Solution(obj);
		}

		return null;
	}
}

// name = ID
protected class TerminalRule_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public TerminalRule_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele00001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele000010ParserRuleCallID();
			return new Solution(obj);
		}

		return null;
	}
}


// ( 'returns' type = TypeRef ) ?
protected class TerminalRule_0_0_0_1_Group extends GroupToken {
	
	public TerminalRule_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalRule_0_0_0_1_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalRule_0_0_0_1_0_Keyword_returns(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class TerminalRule_0_0_0_1_0_Keyword_returns extends KeywordToken  {
	
	public TerminalRule_0_0_0_1_0_Keyword_returns(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele00010KeywordReturns();
	}	
}

// type = TypeRef
protected class TerminalRule_0_0_0_1_1_Assignment_type extends AssignmentToken  {
	
	public TerminalRule_0_0_0_1_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele00011AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
protected class TerminalRule_0_0_1_Keyword extends KeywordToken  {
	
	public TerminalRule_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele001KeywordColon();
	}	
}


// alternatives = TerminalAlternatives
protected class TerminalRule_0_1_Assignment_alternatives extends AssignmentToken  {
	
	public TerminalRule_0_1_Assignment_alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele01AssignmentAlternatives();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alternatives",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alternatives");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new TerminalAlternatives_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
protected class TerminalRule_1_Keyword extends KeywordToken  {
	
	public TerminalRule_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalRule().ele1KeywordSemicolon();
	}	
}


/************ end Rule TerminalRule ****************/


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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TypeRef_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TypeRef_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TypeRef_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TypeRef_0_0_Assignment_metamodel(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef().ele00AssignmentMetamodel();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("metamodel",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("metamodel");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractMetamodelDeclaration")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef().ele000CrossReferenceEStringAbstractMetamodelDeclaration(); 
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef().ele01KeywordColonColon();
	}	
}


// type = [ EClassifier ]
protected class TypeRef_1_Assignment_type extends AssignmentToken  {
	
	public TypeRef_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef().ele1AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EClassifier")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef().ele10CrossReferenceEStringEClassifier(); 
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAlternatives().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Alternatives_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Alternatives_0_RuleCall_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAlternatives().ele0ParserRuleCallGroup();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAlternatives().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Alternatives_1_1_Assignment_groups(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Alternatives_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAlternatives().ele10Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Alternatives_1_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Alternatives_1_0_0_Action_Alternatives_groups(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAlternatives().ele100ActionAlternativesgroups();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAlternatives().ele101KeywordVerticalLine();
	}	
}


// groups += Group
protected class Alternatives_1_1_Assignment_groups extends AssignmentToken  {
	
	public Alternatives_1_1_Assignment_groups(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAlternatives().ele11AssignmentGroups();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("groups",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("groups");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new Group_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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


/************ begin Rule TerminalAlternatives ****************
 *
 * TerminalAlternatives returns AbstractElement : TerminalGroup ( { current = Alternatives . groups += current } '|' groups += TerminalGroup ) * ;
 *
 **/


// TerminalGroup ( { current = Alternatives . groups += current } '|' groups += TerminalGroup ) *
protected class TerminalAlternatives_Group extends GroupToken {
	
	public TerminalAlternatives_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalAlternatives_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalAlternatives_0_RuleCall_TerminalGroup(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// TerminalGroup
protected class TerminalAlternatives_0_RuleCall_TerminalGroup extends RuleCallToken {
	
	public TerminalAlternatives_0_RuleCall_TerminalGroup(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TerminalGroup_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new TerminalGroup_Group(current, this).firstSolution();
	}
}

// ( { current = Alternatives . groups += current } '|' groups += TerminalGroup ) *
protected class TerminalAlternatives_1_Group extends GroupToken {
	
	public TerminalAlternatives_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalAlternatives_1_1_Assignment_groups(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalAlternatives_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class TerminalAlternatives_1_0_Group extends GroupToken {
	
	public TerminalAlternatives_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives().ele10Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalAlternatives_1_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalAlternatives_1_0_0_Action_Alternatives_groups(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class TerminalAlternatives_1_0_0_Action_Alternatives_groups extends ActionToken  {

	public TerminalAlternatives_1_0_0_Action_Alternatives_groups(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives().ele100ActionAlternativesgroups();
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
protected class TerminalAlternatives_1_0_1_Keyword extends KeywordToken  {
	
	public TerminalAlternatives_1_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives().ele101KeywordVerticalLine();
	}	
}


// groups += TerminalGroup
protected class TerminalAlternatives_1_1_Assignment_groups extends AssignmentToken  {
	
	public TerminalAlternatives_1_1_Assignment_groups(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives().ele11AssignmentGroups();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("groups",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("groups");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new TerminalGroup_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



/************ end Rule TerminalAlternatives ****************/


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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGroup().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Group_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Group_0_RuleCall_AbstractToken(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGroup().ele0ParserRuleCallAbstractToken();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGroup().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Group_1_1_Assignment_abstractTokens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Group_1_0_Action_Group_abstractTokens(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGroup().ele10ActionGroupabstractTokens();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGroup().ele11AssignmentAbstractTokens();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstractTokens",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstractTokens");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new AbstractToken_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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


/************ begin Rule TerminalGroup ****************
 *
 * TerminalGroup returns AbstractElement : TerminalToken ( { current = Group . abstractTokens += current } abstractTokens += TerminalToken ) * ;
 *
 **/


// TerminalToken ( { current = Group . abstractTokens += current } abstractTokens += TerminalToken ) *
protected class TerminalGroup_Group extends GroupToken {
	
	public TerminalGroup_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalGroup().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalGroup_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalGroup_0_RuleCall_TerminalToken(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// TerminalToken
protected class TerminalGroup_0_RuleCall_TerminalToken extends RuleCallToken {
	
	public TerminalGroup_0_RuleCall_TerminalToken(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalGroup().ele0ParserRuleCallTerminalToken();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TerminalToken_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new TerminalToken_Group(current, this).firstSolution();
	}
}

// ( { current = Group . abstractTokens += current } abstractTokens += TerminalToken ) *
protected class TerminalGroup_1_Group extends GroupToken {
	
	public TerminalGroup_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalGroup().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalGroup_1_1_Assignment_abstractTokens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalGroup_1_0_Action_Group_abstractTokens(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class TerminalGroup_1_0_Action_Group_abstractTokens extends ActionToken  {

	public TerminalGroup_1_0_Action_Group_abstractTokens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalGroup().ele10ActionGroupabstractTokens();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Group")) return null;
		Object val = current.getConsumable("abstractTokens", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("abstractTokens")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// abstractTokens += TerminalToken
protected class TerminalGroup_1_1_Assignment_abstractTokens extends AssignmentToken  {
	
	public TerminalGroup_1_1_Assignment_abstractTokens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalGroup().ele11AssignmentAbstractTokens();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstractTokens",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstractTokens");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new TerminalToken_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



/************ end Rule TerminalGroup ****************/


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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new AbstractToken_1_Assignment_cardinality(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractToken_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele0Alternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele00Alternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele000ParserRuleCallAssignment();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele001ParserRuleCallAction();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele01ParserRuleCallAbstractTerminal();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele1AssignmentCardinality();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("cardinality",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("cardinality");

		if("?".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele1000KeywordQuestionMark();
			return new Solution(obj);
		}


		if("*".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele1001KeywordAsterisk();
			return new Solution(obj);
		}


		if("+".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken().ele101KeywordPlusSign();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule AbstractToken ****************/


/************ begin Rule TerminalToken ****************
 *
 * TerminalToken returns AbstractElement : TerminalTokenElement ( cardinality = ( '?' | '*' | '+' ) ) ? ;
 *
 **/


// TerminalTokenElement ( cardinality = ( '?' | '*' | '+' ) ) ?
protected class TerminalToken_Group extends GroupToken {
	
	public TerminalToken_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalToken().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TerminalToken_1_Assignment_cardinality(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TerminalToken_0_RuleCall_TerminalTokenElement(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// TerminalTokenElement
protected class TerminalToken_0_RuleCall_TerminalTokenElement extends RuleCallToken {
	
	public TerminalToken_0_RuleCall_TerminalTokenElement(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalToken().ele0ParserRuleCallTerminalTokenElement();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TerminalTokenElement_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new TerminalTokenElement_Alternatives(current, this).firstSolution();
	}
}

// ( cardinality = ( '?' | '*' | '+' ) ) ?
protected class TerminalToken_1_Assignment_cardinality extends AssignmentToken  {
	
	public TerminalToken_1_Assignment_cardinality(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalToken().ele1AssignmentCardinality();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("cardinality",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("cardinality");

		if("?".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalToken().ele1000KeywordQuestionMark();
			return new Solution(obj);
		}


		if("*".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalToken().ele1001KeywordAsterisk();
			return new Solution(obj);
		}


		if("+".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalToken().ele101KeywordPlusSign();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule TerminalToken ****************/


/************ begin Rule Assignment ****************
 *
 * Assignment : feature = ID operator = ( '+=' | '=' | '?=' ) ^terminal = AbstractTerminal ;
 *
 **/


// feature = ID operator = ( '+=' | '=' | '?=' ) ^terminal = AbstractTerminal
protected class Assignment_Group extends GroupToken {
	
	public Assignment_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Assignment_1_Assignment_terminal(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Assignment_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Assignment_0_1_Assignment_operator(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Assignment_0_0_Assignment_feature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele00AssignmentFeature();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele000ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele01AssignmentOperator();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");

		if("+=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele01000KeywordPlusSignEqualsSign();
			return new Solution(obj);
		}


		if("=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele01001KeywordEqualsSign();
			return new Solution(obj);
		}


		if("?=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele0101KeywordQuestionMarkEqualsSign();
			return new Solution(obj);
		}

		return null;
	}
}


// ^terminal = AbstractTerminal
protected class Assignment_1_Assignment_terminal extends AssignmentToken  {
	
	public Assignment_1_Assignment_terminal(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAssignment().ele1AssignmentTerminal();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("terminal",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("terminal");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new AbstractTerminal_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_1_Keyword_current(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_1_Assignment_operator(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_1_Assignment_feature(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_0_1_Assignment_typeName(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele0000000KeywordLeftCurlyBracket();
	}	
}

// ( 'current' '=' ) ?
protected class Action_0_0_0_0_0_0_1_Group extends GroupToken {
	
	public Action_0_0_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele0000001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Action_0_0_0_0_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Action_0_0_0_0_0_0_1_0_Keyword_current(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00000010KeywordCurrent();
	}	
}

// '='
protected class Action_0_0_0_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public Action_0_0_0_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00000011KeywordEqualsSign();
	}	
}



// typeName = TypeRef
protected class Action_0_0_0_0_0_1_Assignment_typeName extends AssignmentToken  {
	
	public Action_0_0_0_0_0_1_Assignment_typeName(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele000001AssignmentTypeName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("typeName",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("typeName");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00001KeywordFullStop();
	}	
}


// feature = ID
protected class Action_0_0_0_1_Assignment_feature extends AssignmentToken  {
	
	public Action_0_0_0_1_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele0001AssignmentFeature();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00010ParserRuleCallID();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele001AssignmentOperator();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");

		if("=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00100KeywordEqualsSign();
			return new Solution(obj);
		}


		if("+=".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele00101KeywordPlusSignEqualsSign();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele01KeywordCurrent();
	}	
}


// '}'
protected class Action_1_Keyword extends KeywordToken  {
	
	public Action_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction().ele1KeywordRightCurlyBracket();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal().eleAlternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal().ele0Alternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal().ele00Alternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal().ele000ParserRuleCallKeyword();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal().ele001ParserRuleCallRuleCall();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal().ele01ParserRuleCallParenthesizedElement();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal().ele1ParserRuleCallCrossReference();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(CrossReference_Group.class, current)) return null;
		if(!current.isInstanceOf("CrossReference")) return null;
		return new CrossReference_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractTerminal ****************/


/************ begin Rule TerminalTokenElement ****************
 *
 * TerminalTokenElement returns AbstractElement : CharacterRange | RuleCall | ParenthesizedTerminalElement | AbstractNegatedToken | Wildcard ;
 *
 **/


// CharacterRange | RuleCall | ParenthesizedTerminalElement | AbstractNegatedToken | Wildcard
protected class TerminalTokenElement_Alternatives extends AlternativesToken {

	public TerminalTokenElement_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TerminalTokenElement_1_RuleCall_Wildcard(current, this) : new TerminalTokenElement_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// CharacterRange | RuleCall | ParenthesizedTerminalElement | AbstractNegatedToken
protected class TerminalTokenElement_0_Alternatives extends AlternativesToken {

	public TerminalTokenElement_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele0Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TerminalTokenElement_0_1_RuleCall_AbstractNegatedToken(current, this) : new TerminalTokenElement_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// CharacterRange | RuleCall | ParenthesizedTerminalElement
protected class TerminalTokenElement_0_0_Alternatives extends AlternativesToken {

	public TerminalTokenElement_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele00Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TerminalTokenElement_0_0_1_RuleCall_ParenthesizedTerminalElement(current, this) : new TerminalTokenElement_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// CharacterRange | RuleCall
protected class TerminalTokenElement_0_0_0_Alternatives extends AlternativesToken {

	public TerminalTokenElement_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TerminalTokenElement_0_0_0_1_RuleCall_RuleCall(current, this) : new TerminalTokenElement_0_0_0_0_RuleCall_CharacterRange(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// CharacterRange
protected class TerminalTokenElement_0_0_0_0_RuleCall_CharacterRange extends RuleCallToken {
	
	public TerminalTokenElement_0_0_0_0_RuleCall_CharacterRange(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele0000ParserRuleCallCharacterRange();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(CharacterRange_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new CharacterRange_Group(current, this).firstSolution();
	}
}

// RuleCall
protected class TerminalTokenElement_0_0_0_1_RuleCall_RuleCall extends RuleCallToken {
	
	public TerminalTokenElement_0_0_0_1_RuleCall_RuleCall(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele0001ParserRuleCallRuleCall();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(RuleCall_Assignment_rule.class, current)) return null;
		if(!current.isInstanceOf("RuleCall")) return null;
		return new RuleCall_Assignment_rule(current, this).firstSolution();
	}
}


// ParenthesizedTerminalElement
protected class TerminalTokenElement_0_0_1_RuleCall_ParenthesizedTerminalElement extends RuleCallToken {
	
	public TerminalTokenElement_0_0_1_RuleCall_ParenthesizedTerminalElement(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele001ParserRuleCallParenthesizedTerminalElement();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(ParenthesizedTerminalElement_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new ParenthesizedTerminalElement_Group(current, this).firstSolution();
	}
}


// AbstractNegatedToken
protected class TerminalTokenElement_0_1_RuleCall_AbstractNegatedToken extends RuleCallToken {
	
	public TerminalTokenElement_0_1_RuleCall_AbstractNegatedToken(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele01ParserRuleCallAbstractNegatedToken();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(AbstractNegatedToken_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("AbstractNegatedToken")) return null;
		return new AbstractNegatedToken_Alternatives(current, this).firstSolution();
	}
}


// Wildcard
protected class TerminalTokenElement_1_RuleCall_Wildcard extends RuleCallToken {
	
	public TerminalTokenElement_1_RuleCall_Wildcard(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement().ele1ParserRuleCallWildcard();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Wildcard_Assignment_isWildcard.class, current)) return null;
		if(!current.isInstanceOf("Wildcard")) return null;
		return new Wildcard_Assignment_isWildcard(current, this).firstSolution();
	}
}


/************ end Rule TerminalTokenElement ****************/


/************ begin Rule AbstractNegatedToken ****************
 *
 * AbstractNegatedToken : NegatedToken | UpToToken ;
 *
 **/


// NegatedToken | UpToToken
protected class AbstractNegatedToken_Alternatives extends AlternativesToken {

	public AbstractNegatedToken_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractNegatedToken().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractNegatedToken_1_RuleCall_UpToToken(current, this) : new AbstractNegatedToken_0_RuleCall_NegatedToken(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// NegatedToken
protected class AbstractNegatedToken_0_RuleCall_NegatedToken extends RuleCallToken {
	
	public AbstractNegatedToken_0_RuleCall_NegatedToken(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(NegatedToken_Group.class, current)) return null;
		if(!current.isInstanceOf("NegatedToken")) return null;
		return new NegatedToken_Group(current, this).firstSolution();
	}
}

// UpToToken
protected class AbstractNegatedToken_1_RuleCall_UpToToken extends RuleCallToken {
	
	public AbstractNegatedToken_1_RuleCall_UpToToken(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractNegatedToken().ele1ParserRuleCallUpToToken();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(UpToToken_Group.class, current)) return null;
		if(!current.isInstanceOf("UpToToken")) return null;
		return new UpToToken_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractNegatedToken ****************/


/************ begin Rule NegatedToken ****************
 *
 * NegatedToken : '!' ^terminal = TerminalTokenElement ;
 *
 **/


// '!' ^terminal = TerminalTokenElement
protected class NegatedToken_Group extends GroupToken {
	
	public NegatedToken_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prNegatedToken().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new NegatedToken_1_Assignment_terminal(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NegatedToken_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '!'
protected class NegatedToken_0_Keyword extends KeywordToken  {
	
	public NegatedToken_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prNegatedToken().ele0KeywordExclamationMark();
	}	
}

// ^terminal = TerminalTokenElement
protected class NegatedToken_1_Assignment_terminal extends AssignmentToken  {
	
	public NegatedToken_1_Assignment_terminal(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prNegatedToken().ele1AssignmentTerminal();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("terminal",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("terminal");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new TerminalTokenElement_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


/************ end Rule NegatedToken ****************/


/************ begin Rule UpToToken ****************
 *
 * UpToToken : '->' ^terminal = TerminalTokenElement ;
 *
 **/


// '->' ^terminal = TerminalTokenElement
protected class UpToToken_Group extends GroupToken {
	
	public UpToToken_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prUpToToken().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new UpToToken_1_Assignment_terminal(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new UpToToken_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '->'
protected class UpToToken_0_Keyword extends KeywordToken  {
	
	public UpToToken_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prUpToToken().ele0KeywordHyphenMinusGreaterThanSign();
	}	
}

// ^terminal = TerminalTokenElement
protected class UpToToken_1_Assignment_terminal extends AssignmentToken  {
	
	public UpToToken_1_Assignment_terminal(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prUpToToken().ele1AssignmentTerminal();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("terminal",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("terminal");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractElement")) {
				Solution s = new TerminalTokenElement_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


/************ end Rule UpToToken ****************/


/************ begin Rule Wildcard ****************
 *
 * Wildcard : isWildcard ?= '.' ;
 *
 **/


// isWildcard ?= '.'
protected class Wildcard_Assignment_isWildcard extends AssignmentToken  {
	
	public Wildcard_Assignment_isWildcard(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prWildcard().eleAssignmentIsWildcard();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("isWildcard",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("isWildcard");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prWildcard().ele0KeywordFullStop();
			return new Solution(obj);
		}

		return null;
	}
}

/************ end Rule Wildcard ****************/


/************ begin Rule CharacterRange ****************
 *
 * CharacterRange returns AbstractElement : Keyword ( { current = CharacterRange . left = current } '..' right = Keyword ) ? ;
 *
 **/


// Keyword ( { current = CharacterRange . left = current } '..' right = Keyword ) ?
protected class CharacterRange_Group extends GroupToken {
	
	public CharacterRange_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCharacterRange().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CharacterRange_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CharacterRange_0_RuleCall_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// Keyword
protected class CharacterRange_0_RuleCall_Keyword extends RuleCallToken {
	
	public CharacterRange_0_RuleCall_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCharacterRange().ele0ParserRuleCallKeyword();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Keyword_Assignment_value.class, current)) return null;
		if(!current.isInstanceOf("Keyword")) return null;
		return new Keyword_Assignment_value(current, this).firstSolution();
	}
}

// ( { current = CharacterRange . left = current } '..' right = Keyword ) ?
protected class CharacterRange_1_Group extends GroupToken {
	
	public CharacterRange_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCharacterRange().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CharacterRange_1_1_Assignment_right(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CharacterRange_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = CharacterRange . left = current } '..'
protected class CharacterRange_1_0_Group extends GroupToken {
	
	public CharacterRange_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCharacterRange().ele10Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CharacterRange_1_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CharacterRange_1_0_0_Action_CharacterRange_left(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// { current = CharacterRange . left = current }
protected class CharacterRange_1_0_0_Action_CharacterRange_left extends ActionToken  {

	public CharacterRange_1_0_0_Action_CharacterRange_left(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCharacterRange().ele100ActionCharacterRangeleft();
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("CharacterRange")) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// '..'
protected class CharacterRange_1_0_1_Keyword extends KeywordToken  {
	
	public CharacterRange_1_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCharacterRange().ele101KeywordFullStopFullStop();
	}	
}


// right = Keyword
protected class CharacterRange_1_1_Assignment_right extends AssignmentToken  {
	
	public CharacterRange_1_1_Assignment_right(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCharacterRange().ele11AssignmentRight();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("right",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Keyword")) {
				Solution s = new Keyword_Assignment_value(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



/************ end Rule CharacterRange ****************/


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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_0_0_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele000KeywordLeftSquareBracket();
	}	
}

// type = TypeRef
protected class CrossReference_0_0_1_Assignment_type extends AssignmentToken  {
	
	public CrossReference_0_0_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele001AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new CrossReference_0_1_1_Assignment_rule(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CrossReference_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele010KeywordVerticalLine();
	}	
}

// rule = [ AbstractRule ]
protected class CrossReference_0_1_1_Assignment_rule extends AssignmentToken  {
	
	public CrossReference_0_1_1_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele011AssignmentRule();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele0110CrossReferenceEStringAbstractRule(); 
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prCrossReference().ele1KeywordRightSquareBracket();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedElement().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParenthesizedElement_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParenthesizedElement_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedElement().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParenthesizedElement_0_1_RuleCall_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParenthesizedElement_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedElement().ele00KeywordLeftParenthesis();
	}	
}

// Alternatives
protected class ParenthesizedElement_0_1_RuleCall_Alternatives extends RuleCallToken {
	
	public ParenthesizedElement_0_1_RuleCall_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedElement().ele01ParserRuleCallAlternatives();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedElement().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule ParenthesizedElement ****************/


/************ begin Rule ParenthesizedTerminalElement ****************
 *
 * ParenthesizedTerminalElement returns AbstractElement : '(' TerminalAlternatives ')' ;
 *
 **/


// '(' TerminalAlternatives ')'
protected class ParenthesizedTerminalElement_Group extends GroupToken {
	
	public ParenthesizedTerminalElement_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedTerminalElement().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParenthesizedTerminalElement_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParenthesizedTerminalElement_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// '(' TerminalAlternatives
protected class ParenthesizedTerminalElement_0_Group extends GroupToken {
	
	public ParenthesizedTerminalElement_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedTerminalElement().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ParenthesizedTerminalElement_0_1_RuleCall_TerminalAlternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ParenthesizedTerminalElement_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
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
protected class ParenthesizedTerminalElement_0_0_Keyword extends KeywordToken  {
	
	public ParenthesizedTerminalElement_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedTerminalElement().ele00KeywordLeftParenthesis();
	}	
}

// TerminalAlternatives
protected class ParenthesizedTerminalElement_0_1_RuleCall_TerminalAlternatives extends RuleCallToken {
	
	public ParenthesizedTerminalElement_0_1_RuleCall_TerminalAlternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedTerminalElement().ele01ParserRuleCallTerminalAlternatives();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TerminalAlternatives_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractElement")) return null;
		return new TerminalAlternatives_Group(current, this).firstSolution();
	}
}


// ')'
protected class ParenthesizedTerminalElement_1_Keyword extends KeywordToken  {
	
	public ParenthesizedTerminalElement_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedTerminalElement().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule ParenthesizedTerminalElement ****************/


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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prKeyword().eleAssignmentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prKeyword().ele0ParserRuleCallSTRING();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prRuleCall().eleAssignmentRule();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prRuleCall().ele0CrossReferenceEStringAbstractRule(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

/************ end Rule RuleCall ****************/








}
