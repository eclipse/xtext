
package org.eclipse.xtext.grammargen.tests;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTest2ASTFactory;

public class SimpleTest2ParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new SimpleTest2ASTFactory();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}
	


public void proceedModel(EObject obj) {
	proceedModel(getDescr(obj));
}

protected void proceedModel(InstanceDescription obj) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("contents"); 
		}
}.check() ){

	Object value = obj.consume("contents");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedChild(getDescr((EObject)value));
	

}

    

}

}

public void proceedChild(EObject obj) {
	proceedChild(getDescr(obj));
}

protected void proceedChild(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction("}");

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction("{");

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("number");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction("keyword");

}

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("optional"); 
		}
}.check() ){

	Object value = obj.consume("optional");
    
    	
    	
/* xtext::Keyword */ 
{

	executeAction("optional");

}

    	
    

}


}


}


}


}


}

}

}
