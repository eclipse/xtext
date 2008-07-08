/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;

public class PreferenceParseTreeConstructor extends AbstractParseTreeConstructor {

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
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedDescription(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("pages");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedPage(val,callback);
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedQName(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

protected void proceedPage(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("panel");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedPanel(val,callback);
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedQName(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

protected void proceedPanel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.2/@alternatives/@abstractTokens.1"));

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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedRow(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0"));

}


}


}

}

protected void proceedRow(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.3/@alternatives/@abstractTokens.1"));

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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedEntry(val,callback);
		} finally {
			callback.parserRuleCallEnd();
		}
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}

}

protected void proceedEntry(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("widget");
    
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = (getDescr((EObject)value));
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedWidget(val,callback);
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@terminal"));

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}

}

protected void proceedWidget(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0");
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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedText(val,callback);
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
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Check"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedCheck(val,callback);
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
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Combo"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedCombo(val,callback);
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
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Panel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedPanel(val,callback);
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
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("NamedPanel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedNamedPanel(val,callback);
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
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("CheckedPanel"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		InstanceDescription val = obj;
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.1");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedCheckedPanel(val,callback);
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

protected void proceedNamedPanel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.1"));

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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedRow(val,callback);
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}


}

}

protected void proceedCheckedPanel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.1"));

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
		EObject ruleCall = getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
		try {
			callback.parserRuleCallStart(val, (RuleCall) ruleCall);
			proceedRow(val,callback);
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

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}


}


}


}

}

protected void proceedLabel(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("value");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.8/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

}

protected void proceedText(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.9/@alternatives/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

}

protected void proceedCheck(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.10/@alternatives/@abstractTokens.0"));

}


}

}

protected void proceedCombo(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1"));

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

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"));

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("alts");
    
/* xtext::RuleCall */ 
{

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}


}

}

protected void proceedQName(InstanceDescription obj,IParseTreeConstructorCallback callback) {
	
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

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.12/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("element");
    
/* xtext::Keyword */ 
{

	callback.keywordCall(obj,(Keyword)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.12/@alternatives/@abstractTokens.1/@abstractTokens.0/@terminal"));

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

	
		callback.lexerRuleCall(obj,(RuleCall)getGrammarElement("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@terminal"));
	

}

    if (obj.isConsumed())
    	callback.objectCreation(obj);

}


}

}

}
