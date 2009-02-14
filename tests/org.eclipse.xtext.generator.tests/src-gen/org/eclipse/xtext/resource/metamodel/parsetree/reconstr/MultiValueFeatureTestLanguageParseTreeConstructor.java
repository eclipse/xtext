/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.resource.metamodel.services.MultiValueFeatureTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class MultiValueFeatureTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private MultiValueFeatureTestLanguageGrammarAccess grammarAccess;
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Start") && (s = new Start_Assignment_featureA(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Start ****************
 *
 * Start:   (featureA+=ID)+;
 *
 **/


// (featureA+=ID)+
protected class Start_Assignment_featureA extends AssignmentToken  {
	
	public Start_Assignment_featureA(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prStart().eleAssignmentFeatureA();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("featureA",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("featureA");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prStart().ele0LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Start ****************/

}
