/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class TestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("EntryRule")) {
			proceedEntryRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("AbstractRule")) {
			proceedAbstractRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("ChoiceRule")) {
			proceedChoiceRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("ReducibleRule")) {
			proceedReducibleRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("TerminalRule")) {
			proceedTerminalRule(getDescr(obj),callback);
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedEntryRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("multiFeature"); 
		}
}.check() ){

	final Object value = obj.consume("multiFeature");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.0/@alternatives/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAbstractRule(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

}

protected void proceedAbstractRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
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

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.1/@alternatives/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedChoiceRule(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

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

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.1/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedReducibleRule(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

protected void proceedChoiceRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

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

	final Object value = obj.consume("optionalKeyword");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

protected void proceedReducibleRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
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

	final Object value = obj.consume("actionFeature");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTerminalRule(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("actionFeature"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"));
	obj = newObj;

}


}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTerminalRule(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

protected void proceedTerminalRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("stringFeature");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.4/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

}

}
