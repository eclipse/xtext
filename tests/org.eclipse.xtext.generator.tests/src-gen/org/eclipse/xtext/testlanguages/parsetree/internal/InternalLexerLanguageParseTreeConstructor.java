
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

public class InternalLexerLanguageParseTreeConstructor extends AbstractInternalParseTreeConstructor {

	public InternalLexerLanguageParseTreeConstructor(GenericEcoreElementFactory factory, Grammar grammar, IValueConverterService converterService) {
		super(factory,grammar,converterService);
	}

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Model")) {
			proceedModel(getDescr(obj));
		} else 		if (ruleToCall.equals("Element")) {
			proceedElement(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedModel(InstanceDescription obj) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("children"); 
		}
}.check() ){

	final Object value = obj.consume("children");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@parserRules.0/@alternatives/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedElement(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

protected void proceedElement(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("h");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LexerLanguage.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}


}

}

}
