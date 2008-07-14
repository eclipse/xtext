/*
Generated with Xtext
*/
package org.eclipse.xtext.preference.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class PreferenceGrammarParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		if (ruleToCall.equals("Description")) {
			proceedDescription(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Page")) {
			proceedPage(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Panel")) {
			proceedPanel(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Row")) {
			proceedRow(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Entry")) {
			proceedEntry(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Widget")) {
			proceedWidget(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("NamedPanel")) {
			proceedNamedPanel(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("CheckedPanel")) {
			proceedCheckedPanel(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("MasterDetail")) {
			proceedMasterDetail(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Label")) {
			proceedLabel(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Text")) {
			proceedText(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Check")) {
			proceedCheck(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("Combo")) {
			proceedCombo(getDescr(obj),callback);
		} else 		if (ruleToCall.equals("QName")) {
			proceedQName(getDescr(obj),callback);
		} else {
			throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
private String DescriptionRecursionCheck = null;
protected void proceedDescription(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(DescriptionRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		DescriptionRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("pages");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedPage(val,callback);
			
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

	final Object value = obj.consume("idPrefix");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedQName(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

	} finally {
		DescriptionRecursionCheck = null;
	}
}

private String PageRecursionCheck = null;
protected void proceedPage(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(PageRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		PageRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("panel");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedPanel(val,callback);
			
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

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedQName(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

	} finally {
		PageRecursionCheck = null;
	}
}

private String PanelRecursionCheck = null;
protected void proceedPanel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(PanelRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		PanelRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("rows"); 
		}
}.check() ){

	final Object value = obj.consume("rows");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedRow(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

	} finally {
		PanelRecursionCheck = null;
	}
}

private String RowRecursionCheck = null;
protected void proceedRow(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(RowRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		RowRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("entries"); 
		}
}.check() ){

	final Object value = obj.consume("entries");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedEntry(val,callback);
			
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
		RowRecursionCheck = null;
	}
}

private String EntryRecursionCheck = null;
protected void proceedEntry(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(EntryRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		EntryRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("widget");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedWidget(val,callback);
			
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
{

	final Object value = obj.consume("colspan");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}

	} finally {
		EntryRecursionCheck = null;
	}
}

private String WidgetRecursionCheck = null;
protected void proceedWidget(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(WidgetRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		WidgetRecursionCheck = s;
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Label"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Text"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Check"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Combo"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Panel"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("NamedPanel"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Label"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Text"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Check"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Combo"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Panel"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Label"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Text"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Check"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Combo"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Label"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Text"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Check"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Label"); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Text"); 
		}
}.check() ) {
			
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Label"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedLabel(val,callback);
			
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Text"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedText(val,callback);
			
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
			return obj.isInstanceOf("Check"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedCheck(val,callback);
			
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
			return obj.isInstanceOf("Combo"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedCombo(val,callback);
			
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
			return obj.isInstanceOf("Panel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedPanel(val,callback);
			
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
			return obj.isInstanceOf("NamedPanel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedNamedPanel(val,callback);
			
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
			return obj.isInstanceOf("CheckedPanel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedCheckedPanel(val,callback);
			
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
		WidgetRecursionCheck = null;
	}
}

private String NamedPanelRecursionCheck = null;
protected void proceedNamedPanel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(NamedPanelRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		NamedPanelRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("rows"); 
		}
}.check() ){

	final Object value = obj.consume("rows");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedRow(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}


}

	} finally {
		NamedPanelRecursionCheck = null;
	}
}

private String CheckedPanelRecursionCheck = null;
protected void proceedCheckedPanel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(CheckedPanelRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		CheckedPanelRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("rows"); 
		}
}.check() ){

	final Object value = obj.consume("rows");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedRow(val,callback);
			
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}


}


}

	} finally {
		CheckedPanelRecursionCheck = null;
	}
}

private String MasterDetailRecursionCheck = null;
protected void proceedMasterDetail(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(MasterDetailRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		MasterDetailRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{


}


}

	} finally {
		MasterDetailRecursionCheck = null;
	}
}

private String LabelRecursionCheck = null;
protected void proceedLabel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(LabelRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		LabelRecursionCheck = s;
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("value");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.9/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

	} finally {
		LabelRecursionCheck = null;
	}
}

private String TextRecursionCheck = null;
protected void proceedText(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(TextRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		TextRecursionCheck = s;
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.10/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

	} finally {
		TextRecursionCheck = null;
	}
}

private String CheckRecursionCheck = null;
protected void proceedCheck(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(CheckRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		CheckRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.11/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.11/@alternatives/@abstractTokens.0"));

}


}

	} finally {
		CheckRecursionCheck = null;
	}
}

private String ComboRecursionCheck = null;
protected void proceedCombo(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(ComboRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		ComboRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("alts");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("alts");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

	} finally {
		ComboRecursionCheck = null;
	}
}

private String QNameRecursionCheck = null;
protected void proceedQName(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	try {
		String s = obj.uniqueStateString();
		if (s.equals(QNameRecursionCheck))
			throw new XtextSerializationException(obj, obj.getDelegate()+" couldn't be serialized.");
		QNameRecursionCheck = s;
	
/* xtext::Group */ 
{

		
/* xtext::Group */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("element")&&obj.checkConsume("element"); 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("element");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.13/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("element");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.13/@alternatives/@abstractTokens.1/@abstractTokens.0/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("element");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.13/@alternatives/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}

	} finally {
		QNameRecursionCheck = null;
	}
}

}
