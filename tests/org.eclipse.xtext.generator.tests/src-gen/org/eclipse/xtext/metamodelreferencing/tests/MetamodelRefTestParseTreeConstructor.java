
package org.eclipse.xtext.metamodelreferencing.tests;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestASTFactory;

public class MetamodelRefTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new MetamodelRefTestASTFactory();
	
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

	
		proceedNameRef(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

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
    
    	
    	executeAction(value);
    	
    

}

}

}
