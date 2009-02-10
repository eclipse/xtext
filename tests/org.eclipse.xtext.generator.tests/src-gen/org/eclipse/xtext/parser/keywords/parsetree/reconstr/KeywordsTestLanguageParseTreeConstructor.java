/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.keywords.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;


public class KeywordsTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new Model_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Model ****************
 *
 * Model:   first?="foo\\bar"|second?="foo\\"|third?="\\bar"|forth?="\\";
 *
 **/


// first?="foo\\bar"|second?="foo\\"|third?="\\bar"|forth?="\\"
protected class Model_Alternatives extends AlternativesToken {

	public Model_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_1_Assignment_forth(current, this) : new Model_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// first?="foo\\bar"|second?="foo\\"|third?="\\bar"
protected class Model_0_Alternatives extends AlternativesToken {

	public Model_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele0Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_1_Assignment_third(current, this) : new Model_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// first?="foo\\bar"|second?="foo\\"
protected class Model_0_0_Alternatives extends AlternativesToken {

	public Model_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele00Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_0_1_Assignment_second(current, this) : new Model_0_0_0_Assignment_first(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// first?="foo\\bar"
protected class Model_0_0_0_Assignment_first extends AssignmentToken  {
	
	public Model_0_0_0_Assignment_first(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele000AssignmentFirst();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("first",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("first");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele0000KeywordFooBar();
			return new Solution(obj);
		}

		return null;
	}
}

// second?="foo\\"
protected class Model_0_0_1_Assignment_second extends AssignmentToken  {
	
	public Model_0_0_1_Assignment_second(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele001AssignmentSecond();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("second",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("second");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele0010KeywordFoo();
			return new Solution(obj);
		}

		return null;
	}
}


// third?="\\bar"
protected class Model_0_1_Assignment_third extends AssignmentToken  {
	
	public Model_0_1_Assignment_third(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele01AssignmentThird();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("third",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("third");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele010KeywordBar();
			return new Solution(obj);
		}

		return null;
	}
}


// forth?="\\"
protected class Model_1_Assignment_forth extends AssignmentToken  {
	
	public Model_1_Assignment_forth(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele1AssignmentForth();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("forth",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("forth");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = KeywordsTestLanguageGrammarAccess.INSTANCE.prModel().ele10KeywordReverseSolidus();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule Model ****************/

}
