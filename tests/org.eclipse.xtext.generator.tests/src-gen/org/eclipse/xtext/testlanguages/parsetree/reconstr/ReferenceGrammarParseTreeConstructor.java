/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class ReferenceGrammarParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Spielplatz")) {
			proceedSpielplatz(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Person")) {
			proceedPerson(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Kind")) {
			proceedKind(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Erwachsener")) {
			proceedErwachsener(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Spielzeug")) {
			proceedSpielzeug(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Farbe")) {
			proceedFarbe(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String SpielplatzRecursionCheck = null;
protected void proceedSpielplatz(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(SpielplatzRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		SpielplatzRecursionCheck = s;
	
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("spielzeuge")&&true&&obj.checkConsume("beschreibung")&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("kinder")&&true&&obj.checkConsume("beschreibung")&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&true&&true&&obj.checkConsume("beschreibung")&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("erzieher")&&true&&obj.checkConsume("beschreibung")&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("spielzeuge")&&true&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("kinder")&&true&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&true&&true&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("erzieher")&&true&&true&&obj.checkConsume("groesse")&&true; 
		}
}.check() ){

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1"));

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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedKind(val,callback);
			
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedErwachsener(val,callback);
			
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
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedSpielzeug(val,callback);
			
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
	

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("beschreibung"); 
		}
}.check() ){

	final Object value = obj.consume("beschreibung");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("groesse");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}


}

	} finally {
		SpielplatzRecursionCheck = null;
	}
}

private String PersonRecursionCheck = null;
protected void proceedPerson(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(PersonRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		PersonRecursionCheck = s;
	
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.1/@alternatives/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedKind(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.1/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedErwachsener(val,callback);
			
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
		PersonRecursionCheck = null;
	}
}

private String KindRecursionCheck = null;
protected void proceedKind(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(KindRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		KindRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("age");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

	} finally {
		KindRecursionCheck = null;
	}
}

private String ErwachsenerRecursionCheck = null;
protected void proceedErwachsener(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ErwachsenerRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ErwachsenerRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("age");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

	} finally {
		ErwachsenerRecursionCheck = null;
	}
}

private String SpielzeugRecursionCheck = null;
protected void proceedSpielzeug(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(SpielzeugRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		SpielzeugRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("farbe");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedFarbe(val,callback);
			
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

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

	} finally {
		SpielzeugRecursionCheck = null;
	}
}

private String FarbeRecursionCheck = null;
protected void proceedFarbe(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(FarbeRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		FarbeRecursionCheck = s;
	
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.0"));

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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.1"));

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
			return true; 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.1"));

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
			return true; 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.1"));

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}

	} finally {
		FarbeRecursionCheck = null;
	}
}

}
