/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;


public class ConcreteTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("RootRule") && (s = new RootRule_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ConcreteParserRule") && (s = new ConcreteParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AType") && (s = new OverridableParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("CallOverridenParserRule") && (s = new CallOverridenParserRule_Assignment_call(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AType2") && (s = new OverridableParserRule2_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AType") && (s = new ExtendableParserRule_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Subrule1") && (s = new Subrule1_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Subrule2") && (s = new Subrule2_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Subrule3") && (s = new Subrule3_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("CallExtendedParserRule") && (s = new CallExtendedParserRule_Assignment_call(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AType") && (s = new InheritedParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AModel") && (s = new AbstractCallOverridenParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AModel") && (s = new AbstractCallExtendedParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule RootRule ****************
 *
 * RootRule:   ConcreteParserRule|CallOverridenParserRule|CallExtendedParserRule|OverridableParserRule2;
 *
 **/


// ConcreteParserRule|CallOverridenParserRule|CallExtendedParserRule|OverridableParserRule2
protected class RootRule_Alternatives extends AlternativesToken {

	public RootRule_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new RootRule_1_RuleCall_OverridableParserRule2(current, this) : new RootRule_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ConcreteParserRule|CallOverridenParserRule|CallExtendedParserRule
protected class RootRule_0_Alternatives extends AlternativesToken {

	public RootRule_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new RootRule_0_1_RuleCall_CallExtendedParserRule(current, this) : new RootRule_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ConcreteParserRule|CallOverridenParserRule
protected class RootRule_0_0_Alternatives extends AlternativesToken {

	public RootRule_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().ele00Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new RootRule_0_0_1_RuleCall_CallOverridenParserRule(current, this) : new RootRule_0_0_0_RuleCall_ConcreteParserRule(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ConcreteParserRule
protected class RootRule_0_0_0_RuleCall_ConcreteParserRule extends RuleCallToken {
	
	public RootRule_0_0_0_RuleCall_ConcreteParserRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().ele000ParserRuleCallConcreteParserRule();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ConcreteParserRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ConcreteParserRule")) return null;
		return new ConcreteParserRule_Group(current, this).firstSolution();
	}
}

// CallOverridenParserRule
protected class RootRule_0_0_1_RuleCall_CallOverridenParserRule extends RuleCallToken {
	
	public RootRule_0_0_1_RuleCall_CallOverridenParserRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().ele001ParserRuleCallCallOverridenParserRule();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(CallOverridenParserRule_Assignment_call.class, current)) return null;
		if(!current.isInstanceOf("CallOverridenParserRule")) return null;
		return new CallOverridenParserRule_Assignment_call(current, this).firstSolution();
	}
}


// CallExtendedParserRule
protected class RootRule_0_1_RuleCall_CallExtendedParserRule extends RuleCallToken {
	
	public RootRule_0_1_RuleCall_CallExtendedParserRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().ele01ParserRuleCallCallExtendedParserRule();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(CallExtendedParserRule_Assignment_call.class, current)) return null;
		if(!current.isInstanceOf("CallExtendedParserRule")) return null;
		return new CallExtendedParserRule_Assignment_call(current, this).firstSolution();
	}
}


// OverridableParserRule2
protected class RootRule_1_RuleCall_OverridableParserRule2 extends RuleCallToken {
	
	public RootRule_1_RuleCall_OverridableParserRule2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().ele1ParserRuleCallOverridableParserRule2();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(OverridableParserRule2_Group.class, current)) return null;
		if(!current.isInstanceOf("AType2")) return null;
		return new OverridableParserRule2_Group(current, this).firstSolution();
	}
}


/************ end Rule RootRule ****************/


/************ begin Rule ConcreteParserRule ****************
 *
 * ConcreteParserRule:   "model" magicNumber=REAL ":" (elements+=InheritedParserRule)*;
 *
 **/


// "model" magicNumber=REAL ":" (elements+=InheritedParserRule)*
protected class ConcreteParserRule_Group extends GroupToken {
	
	public ConcreteParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ConcreteParserRule_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ConcreteParserRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "model" magicNumber=REAL ":"
protected class ConcreteParserRule_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ConcreteParserRule_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ConcreteParserRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "model" magicNumber=REAL
protected class ConcreteParserRule_0_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ConcreteParserRule_0_0_1_Assignment_magicNumber(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ConcreteParserRule_0_0_0_Keyword_model(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "model"
protected class ConcreteParserRule_0_0_0_Keyword_model extends KeywordToken  {
	
	public ConcreteParserRule_0_0_0_Keyword_model(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele000KeywordModel();
	}	
}

// magicNumber=REAL
protected class ConcreteParserRule_0_0_1_Assignment_magicNumber extends AssignmentToken  {
	
	public ConcreteParserRule_0_0_1_Assignment_magicNumber(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele001AssignmentMagicNumber();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("magicNumber",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("magicNumber");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele0010LexerRuleCallREAL();
			return new Solution(obj);
		}
		return null;
	}
}


// ":"
protected class ConcreteParserRule_0_1_Keyword extends KeywordToken  {
	
	public ConcreteParserRule_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele01KeywordColon();
	}	
}


// (elements+=InheritedParserRule)*
protected class ConcreteParserRule_1_Assignment_elements extends AssignmentToken  {
	
	public ConcreteParserRule_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele1AssignmentElements();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AType")) {
				Solution s = new InheritedParserRule_Group(param, this).firstSolution();
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


/************ end Rule ConcreteParserRule ****************/


/************ begin Rule OverridableParserRule ****************
 *
 * OverridableParserRule returns AType:   "overriddenelement" name=ID;
 *
 **/


// "overriddenelement" name=ID
protected class OverridableParserRule_Group extends GroupToken {
	
	public OverridableParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new OverridableParserRule_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridableParserRule_0_Keyword_overriddenelement(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overriddenelement"
protected class OverridableParserRule_0_Keyword_overriddenelement extends KeywordToken  {
	
	public OverridableParserRule_0_Keyword_overriddenelement(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().ele0KeywordOverriddenelement();
	}	
}

// name=ID
protected class OverridableParserRule_1_Assignment_name extends AssignmentToken  {
	
	public OverridableParserRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().ele1AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule OverridableParserRule ****************/


/************ begin Rule CallOverridenParserRule ****************
 *
 * CallOverridenParserRule:   call=AbstractCallOverridenParserRule;
 *
 **/


// call=AbstractCallOverridenParserRule
protected class CallOverridenParserRule_Assignment_call extends AssignmentToken  {
	
	public CallOverridenParserRule_Assignment_call(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prCallOverridenParserRule().eleAssignmentCall();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("call",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("call");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AModel")) {
				Solution s = new AbstractCallOverridenParserRule_Group(param, this).firstSolution();
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

/************ end Rule CallOverridenParserRule ****************/


/************ begin Rule OverridableParserRule2 ****************
 *
 * OverridableParserRule2 returns AType2:   "overridden other element" name=ID "-" age=INT;
 *
 **/


// "overridden other element" name=ID "-" age=INT
protected class OverridableParserRule2_Group extends GroupToken {
	
	public OverridableParserRule2_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new OverridableParserRule2_1_Assignment_age(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridableParserRule2_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overridden other element" name=ID "-"
protected class OverridableParserRule2_0_Group extends GroupToken {
	
	public OverridableParserRule2_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new OverridableParserRule2_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridableParserRule2_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overridden other element" name=ID
protected class OverridableParserRule2_0_0_Group extends GroupToken {
	
	public OverridableParserRule2_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new OverridableParserRule2_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridableParserRule2_0_0_0_Keyword_overriddenotherelement(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overridden other element"
protected class OverridableParserRule2_0_0_0_Keyword_overriddenotherelement extends KeywordToken  {
	
	public OverridableParserRule2_0_0_0_Keyword_overriddenotherelement(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele000KeywordOverriddenOtherElement();
	}	
}

// name=ID
protected class OverridableParserRule2_0_0_1_Assignment_name extends AssignmentToken  {
	
	public OverridableParserRule2_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "-"
protected class OverridableParserRule2_0_1_Keyword extends KeywordToken  {
	
	public OverridableParserRule2_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele01KeywordHyphenMinus();
	}	
}


// age=INT
protected class OverridableParserRule2_1_Assignment_age extends AssignmentToken  {
	
	public OverridableParserRule2_1_Assignment_age(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele1AssignmentAge();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("age",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("age");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule2().ele10LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule OverridableParserRule2 ****************/


/************ begin Rule ExtendableParserRule ****************
 *
 * ExtendableParserRule returns AType:   Subrule1|Subrule2|Subrule3;
 *
 **/


// Subrule1|Subrule2|Subrule3
protected class ExtendableParserRule_Alternatives extends AlternativesToken {

	public ExtendableParserRule_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ExtendableParserRule_1_RuleCall_Subrule3(current, this) : new ExtendableParserRule_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Subrule1|Subrule2
protected class ExtendableParserRule_0_Alternatives extends AlternativesToken {

	public ExtendableParserRule_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ExtendableParserRule_0_1_RuleCall_Subrule2(current, this) : new ExtendableParserRule_0_0_RuleCall_Subrule1(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Subrule1
protected class ExtendableParserRule_0_0_RuleCall_Subrule1 extends RuleCallToken {
	
	public ExtendableParserRule_0_0_RuleCall_Subrule1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().ele00ParserRuleCallSubrule1();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Subrule1_Group.class, current)) return null;
		if(!current.isInstanceOf("Subrule1")) return null;
		return new Subrule1_Group(current, this).firstSolution();
	}
}

// Subrule2
protected class ExtendableParserRule_0_1_RuleCall_Subrule2 extends RuleCallToken {
	
	public ExtendableParserRule_0_1_RuleCall_Subrule2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().ele01ParserRuleCallSubrule2();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Subrule2_Group.class, current)) return null;
		if(!current.isInstanceOf("Subrule2")) return null;
		return new Subrule2_Group(current, this).firstSolution();
	}
}


// Subrule3
protected class ExtendableParserRule_1_RuleCall_Subrule3 extends RuleCallToken {
	
	public ExtendableParserRule_1_RuleCall_Subrule3(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().ele1ParserRuleCallSubrule3();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Subrule3_Group.class, current)) return null;
		if(!current.isInstanceOf("Subrule3")) return null;
		return new Subrule3_Group(current, this).firstSolution();
	}
}


/************ end Rule ExtendableParserRule ****************/


/************ begin Rule Subrule1 ****************
 *
 * Subrule1:   "subrule1" name=ID sub1=ID;
 *
 **/


// "subrule1" name=ID sub1=ID
protected class Subrule1_Group extends GroupToken {
	
	public Subrule1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule1().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Subrule1_1_Assignment_sub1(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Subrule1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "subrule1" name=ID
protected class Subrule1_0_Group extends GroupToken {
	
	public Subrule1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule1().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Subrule1_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Subrule1_0_0_Keyword_subrule1(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "subrule1"
protected class Subrule1_0_0_Keyword_subrule1 extends KeywordToken  {
	
	public Subrule1_0_0_Keyword_subrule1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule1().ele00KeywordSubrule1();
	}	
}

// name=ID
protected class Subrule1_0_1_Assignment_name extends AssignmentToken  {
	
	public Subrule1_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule1().ele01AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule1().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// sub1=ID
protected class Subrule1_1_Assignment_sub1 extends AssignmentToken  {
	
	public Subrule1_1_Assignment_sub1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule1().ele1AssignmentSub1();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("sub1",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("sub1");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule1().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Subrule1 ****************/


/************ begin Rule Subrule2 ****************
 *
 * Subrule2:   "subrule3" name=ID sub2=STRING;
 *
 **/


// "subrule3" name=ID sub2=STRING
protected class Subrule2_Group extends GroupToken {
	
	public Subrule2_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule2().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Subrule2_1_Assignment_sub2(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Subrule2_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "subrule3" name=ID
protected class Subrule2_0_Group extends GroupToken {
	
	public Subrule2_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule2().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Subrule2_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Subrule2_0_0_Keyword_subrule3(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "subrule3"
protected class Subrule2_0_0_Keyword_subrule3 extends KeywordToken  {
	
	public Subrule2_0_0_Keyword_subrule3(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule2().ele00KeywordSubrule3();
	}	
}

// name=ID
protected class Subrule2_0_1_Assignment_name extends AssignmentToken  {
	
	public Subrule2_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule2().ele01AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule2().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// sub2=STRING
protected class Subrule2_1_Assignment_sub2 extends AssignmentToken  {
	
	public Subrule2_1_Assignment_sub2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule2().ele1AssignmentSub2();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("sub2",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("sub2");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule2().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Subrule2 ****************/


/************ begin Rule Subrule3 ****************
 *
 * Subrule3:   "subrule3" name=ID sub1=INT;
 *
 **/


// "subrule3" name=ID sub1=INT
protected class Subrule3_Group extends GroupToken {
	
	public Subrule3_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule3().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Subrule3_1_Assignment_sub1(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Subrule3_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "subrule3" name=ID
protected class Subrule3_0_Group extends GroupToken {
	
	public Subrule3_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule3().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Subrule3_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Subrule3_0_0_Keyword_subrule3(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "subrule3"
protected class Subrule3_0_0_Keyword_subrule3 extends KeywordToken  {
	
	public Subrule3_0_0_Keyword_subrule3(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule3().ele00KeywordSubrule3();
	}	
}

// name=ID
protected class Subrule3_0_1_Assignment_name extends AssignmentToken  {
	
	public Subrule3_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule3().ele01AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule3().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// sub1=INT
protected class Subrule3_1_Assignment_sub1 extends AssignmentToken  {
	
	public Subrule3_1_Assignment_sub1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule3().ele1AssignmentSub1();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("sub1",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("sub1");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prSubrule3().ele10LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Subrule3 ****************/


/************ begin Rule CallExtendedParserRule ****************
 *
 * CallExtendedParserRule:   call=AbstractCallExtendedParserRule;
 *
 **/


// call=AbstractCallExtendedParserRule
protected class CallExtendedParserRule_Assignment_call extends AssignmentToken  {
	
	public CallExtendedParserRule_Assignment_call(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prCallExtendedParserRule().eleAssignmentCall();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("call",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("call");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AModel")) {
				Solution s = new AbstractCallExtendedParserRule_Group(param, this).firstSolution();
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

/************ end Rule CallExtendedParserRule ****************/


/************ begin Rule InheritedParserRule ****************
 *
 * InheritedParserRule returns AType:   "element" name=ID;
 *
 **/


// "element" name=ID
protected class InheritedParserRule_Group extends GroupToken {
	
	public InheritedParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new InheritedParserRule_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritedParserRule_0_Keyword_element(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "element"
protected class InheritedParserRule_0_Keyword_element extends KeywordToken  {
	
	public InheritedParserRule_0_Keyword_element(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().ele0KeywordElement();
	}	
}

// name=ID
protected class InheritedParserRule_1_Assignment_name extends AssignmentToken  {
	
	public InheritedParserRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().ele1AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule InheritedParserRule ****************/


/************ begin Rule AbstractCallOverridenParserRule ****************
 *
 * AbstractCallOverridenParserRule returns AModel:   "overridemodel" (elements+=OverridableParserRule)*;
 *
 **/


// "overridemodel" (elements+=OverridableParserRule)*
protected class AbstractCallOverridenParserRule_Group extends GroupToken {
	
	public AbstractCallOverridenParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallOverridenParserRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AbstractCallOverridenParserRule_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractCallOverridenParserRule_0_Keyword_overridemodel(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overridemodel"
protected class AbstractCallOverridenParserRule_0_Keyword_overridemodel extends KeywordToken  {
	
	public AbstractCallOverridenParserRule_0_Keyword_overridemodel(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallOverridenParserRule().ele0KeywordOverridemodel();
	}	
}

// (elements+=OverridableParserRule)*
protected class AbstractCallOverridenParserRule_1_Assignment_elements extends AssignmentToken  {
	
	public AbstractCallOverridenParserRule_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallOverridenParserRule().ele1AssignmentElements();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AType")) {
				Solution s = new OverridableParserRule_Group(param, this).firstSolution();
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


/************ end Rule AbstractCallOverridenParserRule ****************/


/************ begin Rule AbstractCallExtendedParserRule ****************
 *
 * AbstractCallExtendedParserRule returns AModel:   "extendedmodel" (elements+=ExtendableParserRule)*;
 *
 **/


// "extendedmodel" (elements+=ExtendableParserRule)*
protected class AbstractCallExtendedParserRule_Group extends GroupToken {
	
	public AbstractCallExtendedParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallExtendedParserRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AbstractCallExtendedParserRule_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractCallExtendedParserRule_0_Keyword_extendedmodel(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "extendedmodel"
protected class AbstractCallExtendedParserRule_0_Keyword_extendedmodel extends KeywordToken  {
	
	public AbstractCallExtendedParserRule_0_Keyword_extendedmodel(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallExtendedParserRule().ele0KeywordExtendedmodel();
	}	
}

// (elements+=ExtendableParserRule)*
protected class AbstractCallExtendedParserRule_1_Assignment_elements extends AssignmentToken  {
	
	public AbstractCallExtendedParserRule_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallExtendedParserRule().ele1AssignmentElements();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AType")) {
				Solution s = new ExtendableParserRule_Alternatives(param, this).firstSolution();
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


/************ end Rule AbstractCallExtendedParserRule ****************/

}
