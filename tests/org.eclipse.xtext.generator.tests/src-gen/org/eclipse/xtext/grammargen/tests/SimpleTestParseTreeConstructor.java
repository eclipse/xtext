
package org.eclipse.xtext.grammargen.tests;

import java.util.*;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTestASTFactory;

public class SimpleTestParseTreeConstructor extends AbstractParseTreeConstructor {
    protected ILanguageFacade getFacade() {
    	return LanguageFacadeFactory.getFacade("org/eclipse/xtext/grammargen/tests/SimpleTest");
    }

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Foo")) {
			proceedFoo(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedFoo(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

}
