
package org.eclipse.xtext.parsetree.reconstr;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.parser.SimpleReconstrTestASTFactory;

public class SimpleReconstrTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new SimpleReconstrTestASTFactory();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}
	


public void proceedOp(EObject obj) {
	proceedOp(getDescr(obj));
}

protected void proceedOp(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("values")&&obj.isOfType("Op") && 
	obj.checkConsume("values") && obj.isConsumed(); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("values");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedTerm(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Action */ 
{

	EObject newObj = (EObject) obj.consume("values");
	obj = getDescr(newObj);

}


}

		
/* xtext::RuleCall */ 
{

	
		proceedTerm(obj);
	

}


}

}

public void proceedTerm(EObject obj) {
	proceedTerm(getDescr(obj));
}

protected void proceedTerm(InstanceDescription obj) {
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Atom"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		proceedAtom(obj);
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Expression"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		proceedParens(obj);
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

public void proceedAtom(EObject obj) {
	proceedAtom(getDescr(obj));
}

protected void proceedAtom(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

}

}

public void proceedParens(EObject obj) {
	proceedParens(getDescr(obj));
}

protected void proceedParens(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("em"); 
		}
}.check() ){

	Object value = obj.consume("em");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction(")");

}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
		proceedOp(obj);
	

}

		
/* xtext::Keyword */ 
{

	executeAction("(");

}


}


}


}

}

}
