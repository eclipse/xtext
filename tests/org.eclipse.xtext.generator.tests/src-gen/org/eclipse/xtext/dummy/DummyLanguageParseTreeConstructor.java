
package org.eclipse.xtext.dummy;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.dummy.parser.DummyLanguageASTFactory;

public class DummyLanguageParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new DummyLanguageASTFactory();
	
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
			return obj.checkConsume("elements"); 
		}
}.check() ){

	Object value = obj.consume("elements");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedElement(getDescr((EObject)value));
	

}

    

}

}

public void proceedElement(EObject obj) {
	proceedElement(getDescr(obj));
}

protected void proceedElement(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction(";");

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("descriptions"); 
		}
}.check() ){

	Object value = obj.consume("descriptions");
    
    	
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

	executeAction("element");

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
