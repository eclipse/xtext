
package org.eclipse.xtext.test;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.test.parser.TestLanguageASTFactory;

public class TestLanguageParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new TestLanguageASTFactory();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}
	


public void proceedEntryRule(EObject obj) {
	proceedEntryRule(getDescr(obj));
}

protected void proceedEntryRule(InstanceDescription obj) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("multiFeature"); 
		}
}.check() ){

	Object value = obj.consume("multiFeature");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedAbstractRule(getDescr((EObject)value));
	

}

    

}

}

public void proceedAbstractRule(EObject obj) {
	proceedAbstractRule(getDescr(obj));
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

	
		proceedChoiceRule(obj);
	

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

	
		proceedReducibleRule(obj);
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

public void proceedChoiceRule(EObject obj) {
	proceedChoiceRule(getDescr(obj));
}

protected void proceedChoiceRule(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

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

	Object value = obj.consume("optionalKeyword");
    
    	
    	
/* xtext::Keyword */ 
{

	executeAction("optional");

}

    	
    

}

		
/* xtext::Keyword */ 
{

	executeAction("choice");

}


}


}

}

public void proceedReducibleRule(EObject obj) {
	proceedReducibleRule(getDescr(obj));
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

	Object value = obj.consume("actionFeature");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedTerminalRule(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Action */ 
{

	EObject newObj = (EObject) obj.consume("actionFeature");
	obj = getDescr(newObj);

}


}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
		proceedTerminalRule(obj);
	

}

		
/* xtext::Keyword */ 
{

	executeAction("reducible");

}


}


}

}

public void proceedTerminalRule(EObject obj) {
	proceedTerminalRule(getDescr(obj));
}

protected void proceedTerminalRule(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	Object value = obj.consume("stringFeature");
    
    	
    	executeAction(value);
    	
    

}

}

}
