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

public class SimpleExpressionsParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Sequence")) {
			proceedSequence(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Addition")) {
			proceedAddition(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Multiplication")) {
			proceedMultiplication(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Term")) {
			proceedTerm(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Atom")) {
			proceedAtom(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Parens")) {
			proceedParens(getDescr(obj),callback);
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedSequence(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("expressions")&&obj.isOfType("Sequence") && 
	obj.checkConsume("expressions") && obj.isConsumed(); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("expressions");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAddition(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("expressions"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0"));
	obj = newObj;

}


}

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0/@alternatives/@abstractTokens.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAddition(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}


}

}

protected void proceedAddition(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("values")&&obj.checkConsume("operator")&&obj.isOfType("Op") && 
	obj.checkConsume("values") && obj.isConsumed(); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("values");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedMultiplication(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("operator");
    
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("+"); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0"));

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("-"); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1"));

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("values"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedMultiplication(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}


}

}

protected void proceedMultiplication(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("values")&&obj.checkConsume("operator")&&obj.isOfType("Op") && 
	obj.checkConsume("values") && obj.isConsumed(); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("values");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTerm(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("operator");
    
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("*"); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0"));

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("/"); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1"));

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("values"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTerm(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}


}

}

protected void proceedTerm(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
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

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.3/@alternatives/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAtom(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

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

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.3/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedParens(val,callback);
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

protected void proceedAtom(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.4/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

}

protected void proceedParens(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAddition(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

}
