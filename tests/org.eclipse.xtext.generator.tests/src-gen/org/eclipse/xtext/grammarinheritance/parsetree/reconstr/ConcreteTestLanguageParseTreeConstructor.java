/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class ConcreteTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("ConcreteParserRule")) {
			proceedConcreteParserRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("InheritedParserRule")) {
			proceedInheritedParserRule(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String ConcreteParserRuleRecursionCheck = null;
protected void proceedConcreteParserRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ConcreteParserRuleRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ConcreteParserRuleRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("elements"); 
		}
}.check() ){

	final Object value = obj.consume("elements");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedInheritedParserRule(val,callback);
			
			if (!val.isConsumed()) 
				throw new XtextSerializationException(val,"unserialized state");
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("magicNumber");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

	} finally {
		ConcreteParserRuleRecursionCheck = null;
	}
}

private String InheritedParserRuleRecursionCheck = null;
protected void proceedInheritedParserRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(InheritedParserRuleRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		InheritedParserRuleRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0"));

}


}

	} finally {
		InheritedParserRuleRecursionCheck = null;
	}
}

}
