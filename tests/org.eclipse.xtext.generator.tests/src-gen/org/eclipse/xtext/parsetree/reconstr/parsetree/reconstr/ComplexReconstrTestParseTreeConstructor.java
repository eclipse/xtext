/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class ComplexReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Op")) {
			proceedOp(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Term")) {
			proceedTerm(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Atom")) {
			proceedAtom(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Parens")) {
			proceedParens(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String OpRecursionCheck = null;
protected void proceedOp(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(OpRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		OpRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Alternatives */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("addOperands")&&true&&obj.isOfType("Add") && 
	obj.checkConsume("addOperands") && obj.isConsumed(); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("minusOperands")&&true&&obj.isOfType("Minus") && 
	obj.checkConsume("minusOperands") && obj.isConsumed(); 
		}
}.check() ){

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("addOperands")&&true&&obj.isOfType("Add") && 
	obj.checkConsume("addOperands") && obj.isConsumed(); 
		}
}.check() ) {
			
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("addOperands");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTerm(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("addOperands"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("minusOperands")&&true&&obj.isOfType("Minus") && 
	obj.checkConsume("minusOperands") && obj.isConsumed(); 
		}
}.check() ) {
			
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("minusOperands");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTerm(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("minusOperands"));
	callback.actionCall(obj, newObj, (Action) getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		}
	

}

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedTerm(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}


}

	} finally {
		OpRecursionCheck = null;
	}
}

private String TermRecursionCheck = null;
protected void proceedTerm(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(TermRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		TermRecursionCheck = s;
	
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.1/@alternatives/@groups.0");
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.1/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedParens(val,callback);
			
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
		TermRecursionCheck = null;
	}
}

private String AtomRecursionCheck = null;
protected void proceedAtom(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(AtomRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		AtomRecursionCheck = s;
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.2/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

	} finally {
		AtomRecursionCheck = null;
	}
}

private String ParensRecursionCheck = null;
protected void proceedParens(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ParensRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ParensRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("em"); 
		}
}.check() ){

	final Object value = obj.consume("em");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedOp(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

	} finally {
		ParensRecursionCheck = null;
	}
}

}
