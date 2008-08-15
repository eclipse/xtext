/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class LangAParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Main")) {
			proceedMain(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Import")) {
			proceedImport(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Type")) {
			proceedType(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String MainRecursionCheck = null;
protected void proceedMain(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(MainRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		MainRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("types"); 
		}
}.check() ){

	final Object value = obj.consume("types");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedType(val,callback);
			
			if (!val.isConsumed()) 
				throw new XtextSerializationException(val,"unserialized state");
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("imports"); 
		}
}.check() ){

	final Object value = obj.consume("imports");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedImport(val,callback);
			
			if (!val.isConsumed()) 
				throw new XtextSerializationException(val,"unserialized state");
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}

	} finally {
		MainRecursionCheck = null;
	}
}

private String ImportRecursionCheck = null;
protected void proceedImport(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ImportRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ImportRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("uri");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.0"));

}


}

	} finally {
		ImportRecursionCheck = null;
	}
}

private String TypeRecursionCheck = null;
protected void proceedType(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(TypeRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		TypeRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("extends");
    
/* xtext::CrossReference */ 
{
//Do nothing for 'xtext::CrossReference'\n
}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

	} finally {
		TypeRecursionCheck = null;
	}
}

}
