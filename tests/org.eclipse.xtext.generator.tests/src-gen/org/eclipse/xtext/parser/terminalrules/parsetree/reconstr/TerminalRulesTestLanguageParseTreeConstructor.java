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
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;


public class TerminalRulesTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new Model_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Model ****************
 *
 * Model : idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT | wsValue = WS | anyValue = ANY_OTHER ;
 *
 **/


// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT | wsValue = WS | anyValue = ANY_OTHER
protected class Model_Alternatives extends AlternativesToken {

	public Model_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_1_Assignment_anyValue(current, this) : new Model_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT | wsValue = WS
protected class Model_0_Alternatives extends AlternativesToken {

	public Model_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_1_Assignment_wsValue(current, this) : new Model_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT
protected class Model_0_0_Alternatives extends AlternativesToken {

	public Model_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele00Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_0_1_Assignment_slCommentValue(current, this) : new Model_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT
protected class Model_0_0_0_Alternatives extends AlternativesToken {

	public Model_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_0_0_1_Assignment_mlCommentValue(current, this) : new Model_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// idValue = ID | intValue = INT | stringValue = STRING
protected class Model_0_0_0_0_Alternatives extends AlternativesToken {

	public Model_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_0_0_0_1_Assignment_stringValue(current, this) : new Model_0_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// idValue = ID | intValue = INT
protected class Model_0_0_0_0_0_Alternatives extends AlternativesToken {

	public Model_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele00000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_0_0_0_0_1_Assignment_intValue(current, this) : new Model_0_0_0_0_0_0_Assignment_idValue(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// idValue = ID
protected class Model_0_0_0_0_0_0_Assignment_idValue extends AssignmentToken  {
	
	public Model_0_0_0_0_0_0_Assignment_idValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele000000AssignmentIdValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("idValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("idValue");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0000000ParserRuleCallID();
			return new Solution(obj);
		}

		return null;
	}
}

// intValue = INT
protected class Model_0_0_0_0_0_1_Assignment_intValue extends AssignmentToken  {
	
	public Model_0_0_0_0_0_1_Assignment_intValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele000001AssignmentIntValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("intValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("intValue");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0000010ParserRuleCallINT();
			return new Solution(obj);
		}

		return null;
	}
}


// stringValue = STRING
protected class Model_0_0_0_0_1_Assignment_stringValue extends AssignmentToken  {
	
	public Model_0_0_0_0_1_Assignment_stringValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele00001AssignmentStringValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("stringValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("stringValue");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele000010ParserRuleCallSTRING();
			return new Solution(obj);
		}

		return null;
	}
}


// mlCommentValue = ML_COMMENT
protected class Model_0_0_0_1_Assignment_mlCommentValue extends AssignmentToken  {
	
	public Model_0_0_0_1_Assignment_mlCommentValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0001AssignmentMlCommentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("mlCommentValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("mlCommentValue");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele00010ParserRuleCallML_COMMENT();
			return new Solution(obj);
		}

		return null;
	}
}


// slCommentValue = SL_COMMENT
protected class Model_0_0_1_Assignment_slCommentValue extends AssignmentToken  {
	
	public Model_0_0_1_Assignment_slCommentValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele001AssignmentSlCommentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("slCommentValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("slCommentValue");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0010ParserRuleCallSL_COMMENT();
			return new Solution(obj);
		}

		return null;
	}
}


// wsValue = WS
protected class Model_0_1_Assignment_wsValue extends AssignmentToken  {
	
	public Model_0_1_Assignment_wsValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele01AssignmentWsValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("wsValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("wsValue");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele010ParserRuleCallWS();
			return new Solution(obj);
		}

		return null;
	}
}


// anyValue = ANY_OTHER
protected class Model_1_Assignment_anyValue extends AssignmentToken  {
	
	public Model_1_Assignment_anyValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele1AssignmentAnyValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("anyValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("anyValue");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele10ParserRuleCallANY_OTHER();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule Model ****************/








}
