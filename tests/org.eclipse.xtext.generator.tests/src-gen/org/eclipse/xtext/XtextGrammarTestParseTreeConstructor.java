
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
	if (!proceedGrammar(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedGrammarLock = new HashSet<ConsumationState>();

protected boolean proceedGrammar(InstanceDescription obj) {
	obj.push("proceedGrammar");
	try {
		if (! obj.isInstanceOf("Grammar"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (obj.isConsumable("metamodelDeclarations")){

	if (!obj.isConsumable("metamodelDeclarations")) return false;
    Object value = obj.consume("metamodelDeclarations");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedAbstractMetamodelDeclaration(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 

while (obj.isConsumable("parserRules")){

	if (!obj.isConsumable("parserRules")) return false;
    Object value = obj.consume("parserRules");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedParserRule(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

if ((obj.isConsumable("lexerRules"))){

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("lexing");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print(":");

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("lexerRules")) return false;
    Object value = obj.consume("lexerRules");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedLexerRule(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAbstractRule(EObject obj) {
	if (!proceedAbstractRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedAbstractRuleLock = new HashSet<ConsumationState>();

protected boolean proceedAbstractRule(InstanceDescription obj) {
	obj.push("proceedAbstractRule");
	try {
		if (! obj.isInstanceOf("AbstractRule"))
		   return false;
		
/* xtext::Alternatives */ 
{

		if (proceedLexerRule(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedLexerRule(obj);
	
	

}

		}
	else		if (proceedParserRule(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedParserRule(obj);
	
	

}

		}

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAbstractMetamodelDeclaration(EObject obj) {
	if (!proceedAbstractMetamodelDeclaration(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedAbstractMetamodelDeclarationLock = new HashSet<ConsumationState>();

protected boolean proceedAbstractMetamodelDeclaration(InstanceDescription obj) {
	obj.push("proceedAbstractMetamodelDeclaration");
	try {
		if (! obj.isInstanceOf("AbstractMetamodelDeclaration"))
		   return false;
		
/* xtext::Alternatives */ 
{

		if (proceedGeneratedMetamodel(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedGeneratedMetamodel(obj);
	
	

}

		}
	else		if (proceedReferencedMetamodel(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedReferencedMetamodel(obj);
	
	

}

		}

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedGeneratedMetamodel(EObject obj) {
	if (!proceedGeneratedMetamodel(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedGeneratedMetamodelLock = new HashSet<ConsumationState>();

protected boolean proceedGeneratedMetamodel(InstanceDescription obj) {
	obj.push("proceedGeneratedMetamodel");
	try {
		if (! obj.isInstanceOf("GeneratedMetamodel"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("generate");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("nsURI")) return false;
    Object value = obj.consume("nsURI");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

if ((obj.isConsumable("alias"))){

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("as");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("alias")) return false;
    Object value = obj.consume("alias");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedReferencedMetamodel(EObject obj) {
	if (!proceedReferencedMetamodel(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedReferencedMetamodelLock = new HashSet<ConsumationState>();

protected boolean proceedReferencedMetamodel(InstanceDescription obj) {
	obj.push("proceedReferencedMetamodel");
	try {
		if (! obj.isInstanceOf("ReferencedMetamodel"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("import");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("uri")) return false;
    Object value = obj.consume("uri");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

if ((obj.isConsumable("alias"))){

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("as");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("alias")) return false;
    Object value = obj.consume("alias");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedLexerRule(EObject obj) {
	if (!proceedLexerRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedLexerRuleLock = new HashSet<ConsumationState>();

protected boolean proceedLexerRule(InstanceDescription obj) {
	obj.push("proceedLexerRule");
	try {
		if (! obj.isInstanceOf("LexerRule"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

if ((obj.isConsumable("tokenType"))){

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("tokentype");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("tokenType")) return false;
    Object value = obj.consume("tokenType");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print(":");

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("body")) return false;
    Object value = obj.consume("body");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedParserRule(EObject obj) {
	if (!proceedParserRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedParserRuleLock = new HashSet<ConsumationState>();

protected boolean proceedParserRule(InstanceDescription obj) {
	obj.push("proceedParserRule");
	try {
		if (! obj.isInstanceOf("ParserRule"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

if ((obj.isConsumable("type"))){

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("returns");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("type")) return false;
    Object value = obj.consume("type");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedTypeRef(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print(":");

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("alternatives")) return false;
    Object value = obj.consume("alternatives");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedAlternatives(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print(";");

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedTypeRef(EObject obj) {
	if (!proceedTypeRef(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedTypeRefLock = new HashSet<ConsumationState>();

protected boolean proceedTypeRef(InstanceDescription obj) {
	obj.push("proceedTypeRef");
	try {
		if (! obj.isInstanceOf("TypeRef"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 

if ((obj.isConsumable("alias"))){

		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("alias")) return false;
    Object value = obj.consume("alias");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("::");

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAlternatives(EObject obj) {
	if (!proceedAlternatives(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedAlternativesLock = new HashSet<ConsumationState>();

protected boolean proceedAlternatives(InstanceDescription obj) {
	obj.push("proceedAlternatives");
	try {
		if (! obj.isInstanceOf("AbstractElement"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
	
	{
		InstanceDescription temp = obj;
		obj = obj.newLookaheadDescription();
		
/* xtext::Group */ 

while (((obj.isOfType("Alternatives")) && obj.isConsumable("groups"))){

		
/* xtext::Group */ 
{

		
/* xtext::Action */ 
{

	if (!obj.isConsumable("groups")) return false;
	EObject newObj = (EObject) obj.consume("groups");
	proceedAlternatives(getDescr(newObj,obj.isLookahead()));

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("|");

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("groups")) return false;
    Object value = obj.consume("groups");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedGroup(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}

		if (!obj.isConsumed() && !obj.isRecursion()) //((obj.isOfType("Alternatives")) && obj.isConsumable("groups"))
			proceedGroup(temp);
		obj = temp;
	}
	
	

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

while (((obj.isOfType("Alternatives")) && obj.isConsumable("groups"))){

		
/* xtext::Group */ 
{

		
/* xtext::Action */ 
{

	if (!obj.isConsumable("groups")) return false;
	EObject newObj = (EObject) obj.consume("groups");
	proceedAlternatives(getDescr(newObj,obj.isLookahead()));

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("|");

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("groups")) return false;
    Object value = obj.consume("groups");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedGroup(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedGroup(EObject obj) {
	if (!proceedGroup(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedGroupLock = new HashSet<ConsumationState>();

protected boolean proceedGroup(InstanceDescription obj) {
	obj.push("proceedGroup");
	try {
		if (! obj.isInstanceOf("AbstractElement"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
	
	{
		InstanceDescription temp = obj;
		obj = obj.newLookaheadDescription();
		
/* xtext::Group */ 

while ((obj.isOfType("Group") && obj.isConsumable("abstractTokens"))){

		
/* xtext::Action */ 
{

	if (!obj.isConsumable("abstractTokens")) return false;
	EObject newObj = (EObject) obj.consume("abstractTokens");
	proceedGroup(getDescr(newObj,obj.isLookahead()));

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("abstractTokens")) return false;
    Object value = obj.consume("abstractTokens");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedAbstractToken(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}

		if (!obj.isConsumed() && !obj.isRecursion()) //(obj.isOfType("Group") && obj.isConsumable("abstractTokens"))
			proceedAbstractToken(temp);
		obj = temp;
	}
	
	

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

while ((obj.isOfType("Group") && obj.isConsumable("abstractTokens"))){

		
/* xtext::Action */ 
{

	if (!obj.isConsumable("abstractTokens")) return false;
	EObject newObj = (EObject) obj.consume("abstractTokens");
	proceedGroup(getDescr(newObj,obj.isLookahead()));

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("abstractTokens")) return false;
    Object value = obj.consume("abstractTokens");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedAbstractToken(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAbstractToken(EObject obj) {
	if (!proceedAbstractToken(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedAbstractTokenLock = new HashSet<ConsumationState>();

protected boolean proceedAbstractToken(InstanceDescription obj) {
	obj.push("proceedAbstractToken");
	try {
		if (! obj.isInstanceOf("AbstractElement"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Alternatives */ 
{

		if ((proceedAssignment(obj.newLookaheadDescription()) || proceedAction(obj.newLookaheadDescription()))) {
			
/* xtext::Alternatives */ 
{

		if (proceedAssignment(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedAssignment(obj);
	
	

}

		}
	else		if (proceedAction(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedAction(obj);
	
	

}

		}

}

		}
	else		if (proceedAbstractTerminal(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedAbstractTerminal(obj);
	
	

}

		}

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 

if (obj.isConsumable("cardinality")){

	if (!obj.isConsumable("cardinality")) return false;
    Object value = obj.consume("cardinality");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAssignment(EObject obj) {
	if (!proceedAssignment(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedAssignmentLock = new HashSet<ConsumationState>();

protected boolean proceedAssignment(InstanceDescription obj) {
	obj.push("proceedAssignment");
	try {
		if (! obj.isInstanceOf("Assignment"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("feature")) return false;
    Object value = obj.consume("feature");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("operator")) return false;
    Object value = obj.consume("operator");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("terminal")) return false;
    Object value = obj.consume("terminal");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedAbstractTerminal(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAction(EObject obj) {
	if (!proceedAction(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedActionLock = new HashSet<ConsumationState>();

protected boolean proceedAction(InstanceDescription obj) {
	obj.push("proceedAction");
	try {
		if (! obj.isInstanceOf("Action"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("{");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("current");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("=");

}


}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("typeName")) return false;
    Object value = obj.consume("typeName");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedTypeRef(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

if ((((obj.isConsumable("feature")) && obj.isConsumable("operator")))){

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print(".");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("feature")) return false;
    Object value = obj.consume("feature");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("operator")) return false;
    Object value = obj.consume("operator");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("current");

}


}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("}");

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAbstractTerminal(EObject obj) {
	if (!proceedAbstractTerminal(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedAbstractTerminalLock = new HashSet<ConsumationState>();

protected boolean proceedAbstractTerminal(InstanceDescription obj) {
	obj.push("proceedAbstractTerminal");
	try {
		if (! obj.isInstanceOf("AbstractElement"))
		   return false;
		
/* xtext::Alternatives */ 
{

		if ((proceedKeyword(obj.newLookaheadDescription()) || proceedRuleCall(obj.newLookaheadDescription()))) {
			
/* xtext::Alternatives */ 
{

		if (proceedKeyword(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedKeyword(obj);
	
	

}

		}
	else		if (proceedRuleCall(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedRuleCall(obj);
	
	

}

		}

}

		}
	else		if (proceedParenthesizedElement(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedParenthesizedElement(obj);
	
	

}

		}

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedParenthesizedElement(EObject obj) {
	if (!proceedParenthesizedElement(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedParenthesizedElementLock = new HashSet<ConsumationState>();

protected boolean proceedParenthesizedElement(InstanceDescription obj) {
	obj.push("proceedParenthesizedElement");
	try {
		if (! obj.isInstanceOf("AbstractElement"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("(");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::RuleCall */ 
{

	
	
	proceedAlternatives(obj);
	
	

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print(")");

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedKeyword(EObject obj) {
	if (!proceedKeyword(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedKeywordLock = new HashSet<ConsumationState>();

protected boolean proceedKeyword(InstanceDescription obj) {
	obj.push("proceedKeyword");
	try {
		if (! obj.isInstanceOf("Keyword"))
		   return false;
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("value")) return false;
    Object value = obj.consume("value");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedRuleCall(EObject obj) {
	if (!proceedRuleCall(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedRuleCallLock = new HashSet<ConsumationState>();

protected boolean proceedRuleCall(InstanceDescription obj) {
	obj.push("proceedRuleCall");
	try {
		if (! obj.isInstanceOf("RuleCall"))
		   return false;
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

}
