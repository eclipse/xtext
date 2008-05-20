
package org.eclipse.xtext.metamodelreferencing.tests;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestASTFactory;

public class MetamodelRefTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new MetamodelRefTestASTFactory();
	private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestConstants.getMetamodelRefTestGrammar();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}


public void proceedFoo(EObject obj) {
	proceedFoo(getDescr(obj));
}

protected void proceedFoo(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("nameRefs"); 
		}
}.check() ){

	Object value = obj.consume("nameRefs");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedNameRef(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}


}

}

public void proceedNameRef(EObject obj) {
	proceedNameRef(getDescr(obj));
}

protected void proceedNameRef(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

}
