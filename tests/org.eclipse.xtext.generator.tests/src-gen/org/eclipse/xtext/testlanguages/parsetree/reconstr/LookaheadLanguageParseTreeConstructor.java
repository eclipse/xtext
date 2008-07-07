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

public class LookaheadLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Entry")) {
			proceedEntry(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Alts")) {
			proceedAlts(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("LookAhead0")) {
			proceedLookAhead0(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("LookAhead1")) {
			proceedLookAhead1(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("LookAhead2")) {
			proceedLookAhead2(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("LookAhead3")) {
			proceedLookAhead3(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("LookAhead4")) {
			proceedLookAhead4(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String EntryRecursionCheck = null;
protected void proceedEntry(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(EntryRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		EntryRecursionCheck = s;
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("contents"); 
		}
}.check() ){

	final Object value = obj.consume("contents");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.0/@alternatives/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAlts(val,callback);
			
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
		EntryRecursionCheck = null;
	}
}

private String AltsRecursionCheck = null;
protected void proceedAlts(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AltsRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AltsRecursionCheck = s;
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("LookAhead0"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("LookAhead1"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("LookAhead0"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.0/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLookAhead0(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("LookAhead1"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLookAhead1(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("LookAhead3"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLookAhead3(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}

	} finally {
		AltsRecursionCheck = null;
	}
}

private String LookAhead0RecursionCheck = null;
protected void proceedLookAhead0(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(LookAhead0RecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		LookAhead0RecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("x");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.0"));

}


}

	} finally {
		LookAhead0RecursionCheck = null;
	}
}

private String LookAhead1RecursionCheck = null;
protected void proceedLookAhead1(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(LookAhead1RecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		LookAhead1RecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("x");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("x");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("y");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLookAhead2(val,callback);
			
			if (!val.isConsumed()) 
				throw new XtextSerializationException(val,"unserialized state");
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

	} finally {
		LookAhead1RecursionCheck = null;
	}
}

private String LookAhead2RecursionCheck = null;
protected void proceedLookAhead2(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(LookAhead2RecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		LookAhead2RecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("z"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("z");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@groups.0/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("z"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("z");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@groups.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}


}

	} finally {
		LookAhead2RecursionCheck = null;
	}
}

private String LookAhead3RecursionCheck = null;
protected void proceedLookAhead3(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(LookAhead3RecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		LookAhead3RecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("z");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLookAhead4(val,callback);
			
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

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("x");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

	} finally {
		LookAhead3RecursionCheck = null;
	}
}

private String LookAhead4RecursionCheck = null;
protected void proceedLookAhead4(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(LookAhead4RecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		LookAhead4RecursionCheck = s;
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("x"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("x");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6/@alternatives/@groups.0/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("x"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("x");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6/@alternatives/@groups.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}

	} finally {
		LookAhead4RecursionCheck = null;
	}
}

}
