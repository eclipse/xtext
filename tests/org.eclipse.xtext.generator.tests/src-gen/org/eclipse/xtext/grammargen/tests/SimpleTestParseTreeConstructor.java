
package org.eclipse.xtext.grammargen.tests;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTestASTFactory;

public class SimpleTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new SimpleTestASTFactory();
	private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.grammargen.tests.SimpleTestConstants.getSimpleTestGrammar();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}


public void proceedFoo(EObject obj) {
	proceedFoo(getDescr(obj));
}

protected void proceedFoo(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.0/@alternatives/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

}
