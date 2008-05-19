
package org.eclipse.xtext;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;

public class XtextGrammarTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new XtextGrammarTestASTFactory();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}
	


public void proceedGrammar(EObject obj) {
	proceedGrammar(getDescr(obj));
}

protected void proceedGrammar(InstanceDescription obj) {
	
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

	Object value = obj.consume("lexerRules");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedLexerRule(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction(":");

}

		
/* xtext::Keyword */ 
{

	executeAction("lexing");

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

	Object value = obj.consume("parserRules");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedParserRule(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("metamodelDeclarations"); 
		}
}.check() ){

	Object value = obj.consume("metamodelDeclarations");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedAbstractMetamodelDeclaration(getDescr((EObject)value));
	

}

    

}


}


}

}

public void proceedAbstractRule(EObject obj) {
	proceedAbstractRule(getDescr(obj));
}

protected void proceedAbstractRule(InstanceDescription obj) {
	
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

	
		proceedLexerRule(obj);
	

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

	
		proceedParserRule(obj);
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

public void proceedAbstractMetamodelDeclaration(EObject obj) {
	proceedAbstractMetamodelDeclaration(getDescr(obj));
}

protected void proceedAbstractMetamodelDeclaration(InstanceDescription obj) {
	
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

	
		proceedGeneratedMetamodel(obj);
	

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

	
		proceedReferencedMetamodel(obj);
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

public void proceedGeneratedMetamodel(EObject obj) {
	proceedGeneratedMetamodel(getDescr(obj));
}

protected void proceedGeneratedMetamodel(InstanceDescription obj) {
	
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

	Object value = obj.consume("alias");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Keyword */ 
{

	executeAction("as");

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("nsURI");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Keyword */ 
{

	executeAction("generate");

}


}


}


}

}

public void proceedReferencedMetamodel(EObject obj) {
	proceedReferencedMetamodel(getDescr(obj));
}

protected void proceedReferencedMetamodel(InstanceDescription obj) {
	
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

	Object value = obj.consume("alias");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Keyword */ 
{

	executeAction("as");

}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("uri");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Keyword */ 
{

	executeAction("import");

}


}


}

}

public void proceedLexerRule(EObject obj) {
	proceedLexerRule(getDescr(obj));
}

protected void proceedLexerRule(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("body");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction(":");

}

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("tokenType")&&true; 
		}
}.check() ){

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("tokenType");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Keyword */ 
{

	executeAction("tokentype");

}


}

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

}


}


}


}

}

public void proceedParserRule(EObject obj) {
	proceedParserRule(getDescr(obj));
}

protected void proceedParserRule(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction(";");

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("alternatives");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedAlternatives(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction(":");

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

	Object value = obj.consume("type");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedTypeRef(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Keyword */ 
{

	executeAction("returns");

}


}

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

}


}


}


}


}

}

public void proceedTypeRef(EObject obj) {
	proceedTypeRef(getDescr(obj));
}

protected void proceedTypeRef(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

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

	executeAction("::");

}

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("alias");
    
    	
    	executeAction(value);
    	
    

}


}


}

}

public void proceedAlternatives(EObject obj) {
	proceedAlternatives(getDescr(obj));
}

protected void proceedAlternatives(InstanceDescription obj) {
	
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

	Object value = obj.consume("groups");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedGroup(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction("|");

}

		
/* xtext::Action */ 
{

	EObject newObj = (EObject) obj.consume("groups");
	obj = getDescr(newObj);

}


}


}

		
/* xtext::RuleCall */ 
{

	
		proceedGroup(obj);
	

}


}

}

public void proceedGroup(EObject obj) {
	proceedGroup(getDescr(obj));
}

protected void proceedGroup(InstanceDescription obj) {
	
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

	Object value = obj.consume("abstractTokens");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedAbstractToken(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Action */ 
{

	EObject newObj = (EObject) obj.consume("abstractTokens");
	obj = getDescr(newObj);

}


}

		
/* xtext::RuleCall */ 
{

	
		proceedAbstractToken(obj);
	

}


}

}

public void proceedAbstractToken(EObject obj) {
	proceedAbstractToken(getDescr(obj));
}

protected void proceedAbstractToken(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("cardinality"); 
		}
}.check() ){

	Object value = obj.consume("cardinality");
    
    	
    	executeAction(value);
    	
    

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

	
		proceedAssignment(obj);
	

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

	
		proceedAction(obj);
	

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
			return obj.isInstanceOf("AbstractElement"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		proceedAbstractTerminal(obj);
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}


}

}

public void proceedAssignment(EObject obj) {
	proceedAssignment(getDescr(obj));
}

protected void proceedAssignment(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("terminal");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedAbstractTerminal(getDescr((EObject)value));
	

}

    

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("operator");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("feature");
    
    	
    	executeAction(value);
    	
    

}


}


}

}

public void proceedAction(EObject obj) {
	proceedAction(getDescr(obj));
}

protected void proceedAction(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction("}");

}

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return true&&obj.checkConsume("operator")&&obj.checkConsume("feature")&&true; 
		}
}.check() ){

		
/* xtext::Keyword */ 
{

	executeAction("current");

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("operator");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("feature");
    
    	
    	executeAction(value);
    	
    

}

		
/* xtext::Keyword */ 
{

	executeAction(".");

}


}


}


}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("typeName");
    
    	
/* xtext::RuleCall */ 
{

	
		proceedTypeRef(getDescr((EObject)value));
	

}

    

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

	executeAction("=");

}

		
/* xtext::Keyword */ 
{

	executeAction("current");

}


}

		
/* xtext::Keyword */ 
{

	executeAction("{");

}


}


}


}


}

}

public void proceedAbstractTerminal(EObject obj) {
	proceedAbstractTerminal(getDescr(obj));
}

protected void proceedAbstractTerminal(InstanceDescription obj) {
	
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

	
		proceedKeyword(obj);
	

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

	
		proceedRuleCall(obj);
	

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
			return obj.isInstanceOf("AbstractElement"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
		proceedParenthesizedElement(obj);
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

public void proceedParenthesizedElement(EObject obj) {
	proceedParenthesizedElement(getDescr(obj));
}

protected void proceedParenthesizedElement(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	executeAction(")");

}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
		proceedAlternatives(obj);
	

}

		
/* xtext::Keyword */ 
{

	executeAction("(");

}


}


}

}

public void proceedKeyword(EObject obj) {
	proceedKeyword(getDescr(obj));
}

protected void proceedKeyword(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	Object value = obj.consume("value");
    
    	
    	executeAction(value);
    	
    

}

}

public void proceedRuleCall(EObject obj) {
	proceedRuleCall(getDescr(obj));
}

protected void proceedRuleCall(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
    	
    	executeAction(value);
    	
    

}

}

}
