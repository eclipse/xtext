
/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.internal;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parsetree.Predicate;
import org.eclipse.xtext.parsetree.internal.AbstractInternalParseTreeConstructor;

public class InternalReferenceGrammarParseTreeConstructor extends AbstractInternalParseTreeConstructor {

	public InternalReferenceGrammarParseTreeConstructor(GenericEcoreElementFactory factory, Grammar grammar, IValueConverterService converterService) {
		super(factory,grammar,converterService);
	}

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Spielplatz")) {
			proceedSpielplatz(getDescr(obj));
		} else 		if (ruleToCall.equals("Person")) {
			proceedPerson(getDescr(obj));
		} else 		if (ruleToCall.equals("Kind")) {
			proceedKind(getDescr(obj));
		} else 		if (ruleToCall.equals("Erwachsener")) {
			proceedErwachsener(getDescr(obj));
		} else 		if (ruleToCall.equals("Spielzeug")) {
			proceedSpielzeug(getDescr(obj));
		} else 		if (ruleToCall.equals("Farbe")) {
			proceedFarbe(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedSpielplatz(InstanceDescription obj) {
	
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("spielzeuge")&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("kinder")&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&true&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("erzieher")&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ){

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Alternatives */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("kinder"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("erzieher"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("spielzeuge"); 
		}
}.check() ){

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("kinder"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("erzieher"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("kinder"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("kinder");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedKind(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("erzieher"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("erzieher");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedErwachsener(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("spielzeuge"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("spielzeuge");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedSpielzeug(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		}
	

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("groesse");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

}

protected void proceedPerson(InstanceDescription obj) {
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Kind"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@groups.0");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedKind(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Erwachsener"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@groups.1");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedErwachsener(val);
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

protected void proceedKind(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("age");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

}

protected void proceedErwachsener(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("age");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

}

protected void proceedSpielzeug(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("farbe");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedFarbe(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

}

protected void proceedFarbe(InstanceDescription obj) {
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0"));

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1"));

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.5/@alternatives/@groups.0/@groups.1"));

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return true; 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.5/@alternatives/@groups.1"));

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

}
