
package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;

public class LexerLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
   
	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Model")) {
			proceedModel(getDescr(obj));
		} else 		if (ruleToCall.equals("Element")) {
			proceedElement(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedModel(InstanceDescription obj) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("children"); 
		}
}.check() ){

	final Object value = obj.consume("children");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedElement(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

protected void proceedElement(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("h");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}


}

}

}
