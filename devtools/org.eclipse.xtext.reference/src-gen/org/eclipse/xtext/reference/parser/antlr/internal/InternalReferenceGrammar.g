/*
Generated with Xtext
*/
grammar InternalReferenceGrammar;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.reference.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.reference.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;

}

@parser::members {
 
    public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalReferenceGrammarParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Spielplatz";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleSpielplatz
entryRuleSpielplatz returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSpielplatz=ruleSpielplatz 
	 { $current=$iv_ruleSpielplatz.current; } 
	 EOF 
;

// Rule Spielplatz
ruleSpielplatz returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((('spielplatz' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_groesse=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "groesse"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "groesse", lv_groesse, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_beschreibung=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "beschreibung"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "beschreibung", lv_beschreibung, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_kinder=ruleKind 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "kinder", lv_kinder, "Kind", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_erzieher=ruleErwachsener 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "erzieher", lv_erzieher, "Erwachsener", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_spielzeuge=ruleSpielzeug 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "spielzeuge", lv_spielzeuge, "Spielzeug", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_familie=ruleFamilie 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "familie", lv_familie, "Familie", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_types=ruleCustomTypeParserRule 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "types", lv_types, "CustomTypeParserRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?;









// Entry rule entryRuleKind
entryRuleKind returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleKind=ruleKind 
	 { $current=$iv_ruleKind.current; } 
	 EOF 
;

// Rule Kind
ruleKind returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('kind' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Kind");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_age=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Kind");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "age", lv_age, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleErwachsener
entryRuleErwachsener returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleErwachsener=ruleErwachsener 
	 { $current=$iv_ruleErwachsener.current; } 
	 EOF 
;

// Rule Erwachsener
ruleErwachsener returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('erwachsener' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Erwachsener");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_age=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Erwachsener");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "age", lv_age, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleSpielzeug
entryRuleSpielzeug returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSpielzeug=ruleSpielzeug 
	 { $current=$iv_ruleSpielzeug.current; } 
	 EOF 
;

// Rule Spielzeug
ruleSpielzeug returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('spielzeug' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielzeug");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_farbe=ruleFarbe 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielzeug");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "farbe", lv_farbe, "Farbe", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleFamilie
entryRuleFamilie returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFamilie=ruleFamilie 
	 { $current=$iv_ruleFamilie.current; } 
	 EOF 
;

// Rule Familie
ruleFamilie returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((('familie' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=(('keyword' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "name"); 
    }

    |RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "name"); 
    }
)
    |RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, "name"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Familie");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Familie");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "mutter"); 
    }
) 
	
))(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Familie");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "vater"); 
    }
) 
	
))(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Familie");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
    }
) 
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Familie");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
    }
) 
	
))*)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleFarbe
entryRuleFarbe returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFarbe=ruleFarbe 
	 { $current=$iv_ruleFarbe.current; } 
	 EOF 
;

// Rule Farbe
ruleFarbe returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    lv_wert=((('ROT' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, "wert"); 
    }

    |'BLAU' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, "wert"); 
    }
)
    |'GELB' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "wert"); 
    }
)
    |'GR\u00DCN' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.1" /* xtext::Keyword */, "wert"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Farbe");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "wert", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);







// Entry rule entryRuleCustomTypeParserRule
entryRuleCustomTypeParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCustomTypeParserRule=ruleCustomTypeParserRule 
	 { $current=$iv_ruleCustomTypeParserRule.current; } 
	 EOF 
;

// Rule CustomTypeParserRule
ruleCustomTypeParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('type' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("CustomType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));























RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : 
			  '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | 
              '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
              ;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


