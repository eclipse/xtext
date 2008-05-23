
package org.eclipse.xtext.testlanguages;

import java.util.*;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.TestLanguageASTFactory;

public class TestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
    protected ILanguageFacade getFacade() {
    	return LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/TestLanguage");
    }

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("EntryRule")) {
			proceedEntryRule(getDescr(obj));
		} else 		if (ruleToCall.equals("AbstractRule")) {
			proceedAbstractRule(getDescr(obj));
		} else 		if (ruleToCall.equals("ChoiceRule")) {
			proceedChoiceRule(getDescr(obj));
		} else 		if (ruleToCall.equals("ReducibleRule")) {
			proceedReducibleRule(getDescr(obj));
		} else 		if (ruleToCall.equals("TerminalRule")) {
			proceedTerminalRule(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedEntryRule(InstanceDescription obj) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("multiFeature"); 
		}
}.check() ){

	final Object value = obj.consume("multiFeature");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedAbstractRule(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

protected void proceedAbstractRule(InstanceDescription obj) {
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("ChoiceElement"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@groups.0");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedChoiceRule(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("ReducibleElement"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@groups.1");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedReducibleRule(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

protected void proceedChoiceRule(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("optionalKeyword"); 
		}
}.check() ){

	final Object value = obj.consume("optionalKeyword");
    
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

protected void proceedReducibleRule(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("actionFeature")&&obj.isOfType("ReducibleComposite") && 
	obj.checkConsume("actionFeature") && obj.isConsumed(); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("actionFeature");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedTerminalRule(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("actionFeature"));
	action(obj,newObj, (Action) getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"));
	obj = newObj;

}


}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedTerminalRule(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

protected void proceedTerminalRule(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("stringFeature");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.4/@alternatives/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

}
