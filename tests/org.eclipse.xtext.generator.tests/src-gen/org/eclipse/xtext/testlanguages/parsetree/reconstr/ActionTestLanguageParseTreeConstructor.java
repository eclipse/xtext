/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class ActionTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Model")) {
			proceedModel(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Element")) {
			proceedElement(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Item")) {
			proceedItem(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String ModelRecursionCheck = null;
protected void proceedModel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ModelRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ModelRecursionCheck = s;
	
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.0/@alternatives/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedElement(val,callback);
			
			if (!val.isConsumed()) 
				throw new XtextSerializationException(val,"unserialized state");
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

	} finally {
		ModelRecursionCheck = null;
	}
}

private String ElementRecursionCheck = null;
protected void proceedElement(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ElementRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ElementRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("items");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedItem(val,callback);
			
			if (!val.isConsumed()) 
				throw new XtextSerializationException(val,"unserialized state");
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("items"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0"));
	obj = newObj;

}


}

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedItem(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}


}

	} finally {
		ElementRecursionCheck = null;
	}
}

private String ItemRecursionCheck = null;
protected void proceedItem(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ItemRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ItemRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("content"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0"));
	obj = newObj;

}


}

	} finally {
		ItemRecursionCheck = null;
	}
}

}
