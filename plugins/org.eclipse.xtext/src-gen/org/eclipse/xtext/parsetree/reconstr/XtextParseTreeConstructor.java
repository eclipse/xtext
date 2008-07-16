/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class XtextParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Grammar")) {
			proceedGrammar(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("AbstractRule")) {
			proceedAbstractRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("AbstractMetamodelDeclaration")) {
			proceedAbstractMetamodelDeclaration(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("GeneratedMetamodel")) {
			proceedGeneratedMetamodel(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("ReferencedMetamodel")) {
			proceedReferencedMetamodel(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("LexerRule")) {
			proceedLexerRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("ParserRule")) {
			proceedParserRule(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("TypeRef")) {
			proceedTypeRef(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Alternatives")) {
			proceedAlternatives(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Group")) {
			proceedGroup(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("AbstractToken")) {
			proceedAbstractToken(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Assignment")) {
			proceedAssignment(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Action")) {
			proceedAction(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("AbstractTerminal")) {
			proceedAbstractTerminal(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("ParenthesizedElement")) {
			proceedParenthesizedElement(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Keyword")) {
			proceedKeyword(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("RuleCall")) {
			proceedRuleCall(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String GrammarRecursionCheck = null;
protected void proceedGrammar(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(GrammarRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		GrammarRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("lexerRules")&&true&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("lexerRules");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLexerRule(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"));

}


}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("parserRules"); 
		}
}.check() ){

	final Object value = obj.consume("parserRules");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedParserRule(val,callback);
			
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

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("metamodelDeclarations"); 
		}
}.check() ){

	final Object value = obj.consume("metamodelDeclarations");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAbstractMetamodelDeclaration(val,callback);
			
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

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("superGrammarIdElements")&&true; 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("superGrammarIdElements")&&true&&obj.checkConsume("superGrammarIdElements")&&true; 
		}
}.check() ){

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("superGrammarIdElements")&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("superGrammarIdElements");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("superGrammarIdElements");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"));

}


}


}

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("idElements")&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("idElements");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("idElements");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("abstract"); 
		}
}.check() ) {
			
/* xtext::Assignment */ 
{

	final Object value = obj.consume("abstract");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1"));

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}


}


}


}


}


}


}

	} finally {
		GrammarRecursionCheck = null;
	}
}

private String AbstractRuleRecursionCheck = null;
protected void proceedAbstractRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AbstractRuleRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AbstractRuleRecursionCheck = s;
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("LexerRule"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.1/@alternatives/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLexerRule(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("ParserRule"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.1/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedParserRule(val,callback);
			
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
		AbstractRuleRecursionCheck = null;
	}
}

private String AbstractMetamodelDeclarationRecursionCheck = null;
protected void proceedAbstractMetamodelDeclaration(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AbstractMetamodelDeclarationRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AbstractMetamodelDeclarationRecursionCheck = s;
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("GeneratedMetamodel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.2/@alternatives/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedGeneratedMetamodel(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("ReferencedMetamodel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.2/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedReferencedMetamodel(val,callback);
			
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
		AbstractMetamodelDeclarationRecursionCheck = null;
	}
}

private String GeneratedMetamodelRecursionCheck = null;
protected void proceedGeneratedMetamodel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(GeneratedMetamodelRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		GeneratedMetamodelRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("alias")&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("alias");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("nsURI");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

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

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

	} finally {
		GeneratedMetamodelRecursionCheck = null;
	}
}

private String ReferencedMetamodelRecursionCheck = null;
protected void proceedReferencedMetamodel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ReferencedMetamodelRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ReferencedMetamodelRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("alias")&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("alias");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("uri");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

	} finally {
		ReferencedMetamodelRecursionCheck = null;
	}
}

private String LexerRuleRecursionCheck = null;
protected void proceedLexerRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(LexerRuleRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		LexerRuleRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("body");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("type")&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("type");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTypeRef(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}


}


}

	} finally {
		LexerRuleRecursionCheck = null;
	}
}

private String ParserRuleRecursionCheck = null;
protected void proceedParserRule(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ParserRuleRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ParserRuleRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("alternatives");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAlternatives(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("type")&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("type");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTypeRef(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}


}


}

	} finally {
		ParserRuleRecursionCheck = null;
	}
}

private String TypeRefRecursionCheck = null;
protected void proceedTypeRef(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(TypeRefRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		TypeRefRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.7/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("alias"); 
		}
}.check() ){

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("alias");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}

	} finally {
		TypeRefRecursionCheck = null;
	}
}

private String AlternativesRecursionCheck = null;
protected void proceedAlternatives(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AlternativesRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AlternativesRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("groups")&&true&&obj.isOfType("Alternatives") && 
	obj.checkConsume("groups") && obj.isConsumed(); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("groups");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedGroup(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("groups"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedGroup(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}


}

	} finally {
		AlternativesRecursionCheck = null;
	}
}

private String GroupRecursionCheck = null;
protected void proceedGroup(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(GroupRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		GroupRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("abstractTokens")&&obj.isOfType("Group") && 
	obj.checkConsume("abstractTokens") && obj.isConsumed(); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("abstractTokens");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAbstractToken(val,callback);
			
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

	InstanceDescription newObj = getDescr((EObject) obj.consume("abstractTokens"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0"));
	obj = newObj;

}


}

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.9/@alternatives/@abstractTokens.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAbstractToken(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}


}

	} finally {
		GroupRecursionCheck = null;
	}
}

private String AbstractTokenRecursionCheck = null;
protected void proceedAbstractToken(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AbstractTokenRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AbstractTokenRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("cardinality"); 
		}
}.check() ){

	final Object value = obj.consume("cardinality");
    
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("?"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return value.equals("*"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("?"); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0"));

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("*"); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1"));

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
			return value.equals("+"); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.1"));

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Assignment"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Action"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Assignment"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAssignment(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Action"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAction(val,callback);
			
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
			return obj.isInstanceOf("AbstractElement"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAbstractTerminal(val,callback);
			
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

	} finally {
		AbstractTokenRecursionCheck = null;
	}
}

private String AssignmentRecursionCheck = null;
protected void proceedAssignment(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AssignmentRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AssignmentRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("terminal");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAbstractTerminal(val,callback);
			
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

	final Object value = obj.consume("operator");
    
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("+="); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return value.equals("="); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("+="); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0"));

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("="); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1"));

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
			return value.equals("?="); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1"));

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("feature");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}

	} finally {
		AssignmentRecursionCheck = null;
	}
}

private String ActionRecursionCheck = null;
protected void proceedAction(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ActionRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ActionRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1"));

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
			return value.equals("="); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0"));

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return value.equals("+="); 
		}
}.check() ) {
			
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1"));

}

		}
	
		else {
		    throw new XtextSerializationException(obj, "No alternative matched");
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("feature");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("typeName");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTypeRef(val,callback);
			
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

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return true&&true; 
		}
}.check() ){

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"));

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}


}


}


}

	} finally {
		ActionRecursionCheck = null;
	}
}

private String AbstractTerminalRecursionCheck = null;
protected void proceedAbstractTerminal(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AbstractTerminalRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AbstractTerminalRecursionCheck = s;
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Keyword"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("RuleCall"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Keyword"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13/@alternatives/@groups.0/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedKeyword(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("RuleCall"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13/@alternatives/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedRuleCall(val,callback);
			
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
			return obj.isInstanceOf("AbstractElement"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedParenthesizedElement(val,callback);
			
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
		AbstractTerminalRecursionCheck = null;
	}
}

private String ParenthesizedElementRecursionCheck = null;
protected void proceedParenthesizedElement(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ParenthesizedElementRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ParenthesizedElementRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedAlternatives(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

	} finally {
		ParenthesizedElementRecursionCheck = null;
	}
}

private String KeywordRecursionCheck = null;
protected void proceedKeyword(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(KeywordRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		KeywordRecursionCheck = s;
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("value");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.15/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

	} finally {
		KeywordRecursionCheck = null;
	}
}

private String RuleCallRecursionCheck = null;
protected void proceedRuleCall(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(RuleCallRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		RuleCallRecursionCheck = s;
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.16/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

	} finally {
		RuleCallRecursionCheck = null;
	}
}

}
