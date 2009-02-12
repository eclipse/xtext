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
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;

}

@parser::members {
 
 	private ReferenceGrammarGrammarAccess grammarAccess;
 	
    public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, ReferenceGrammarGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
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
	{ currentNode = createCompositeNode(grammarAccess.prSpielplatz().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prSpielplatz().ele00000KeywordSpielplatz(), null); 
    }
(	
	
	    lv_groesse=RULE_INT
    { 
    createLeafNode(grammarAccess.prSpielplatz().ele000010LexerRuleCallINT(), "groesse"); 
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
    createLeafNode(grammarAccess.prSpielplatz().ele00010LexerRuleCallSTRING(), "beschreibung"); 
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
        createLeafNode(grammarAccess.prSpielplatz().ele001KeywordLeftCurlyBracket(), null); 
    }
)(((((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0100000ParserRuleCallKind(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0100010ParserRuleCallErwachsener(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele010010ParserRuleCallSpielzeug(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele01010ParserRuleCallFamilie(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0110ParserRuleCallCustomTypeParserRule(), currentNode); 
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
        createLeafNode(grammarAccess.prSpielplatz().ele1KeywordRightCurlyBracket(), null); 
    }
)?;









// Entry rule entryRuleKind
entryRuleKind returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prKind().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prKind().ele0000KeywordKind(), null); 
    }
'(' 
    {
        createLeafNode(grammarAccess.prKind().ele0001KeywordLeftParenthesis(), null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prKind().ele0010LexerRuleCallID(), "name"); 
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
    createLeafNode(grammarAccess.prKind().ele010LexerRuleCallINT(), "age"); 
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
        createLeafNode(grammarAccess.prKind().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleErwachsener
entryRuleErwachsener returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prErwachsener().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prErwachsener().ele0000KeywordErwachsener(), null); 
    }
'(' 
    {
        createLeafNode(grammarAccess.prErwachsener().ele0001KeywordLeftParenthesis(), null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prErwachsener().ele0010LexerRuleCallID(), "name"); 
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
    createLeafNode(grammarAccess.prErwachsener().ele010LexerRuleCallINT(), "age"); 
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
        createLeafNode(grammarAccess.prErwachsener().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleSpielzeug
entryRuleSpielzeug returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prSpielzeug().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prSpielzeug().ele0000KeywordSpielzeug(), null); 
    }
'(' 
    {
        createLeafNode(grammarAccess.prSpielzeug().ele0001KeywordLeftParenthesis(), null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prSpielzeug().ele0010LexerRuleCallID(), "name"); 
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
	        currentNode=createCompositeNode(grammarAccess.prSpielzeug().ele010ParserRuleCallFarbe(), currentNode); 
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
        createLeafNode(grammarAccess.prSpielzeug().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleFamilie
entryRuleFamilie returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prFamilie().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prFamilie().ele0000000KeywordFamilie(), null); 
    }
'(' 
    {
        createLeafNode(grammarAccess.prFamilie().ele0000001KeywordLeftParenthesis(), null); 
    }
)(	
	
	    lv_name=(('keyword' 
    {
        createLeafNode(grammarAccess.prFamilie().ele000001000KeywordKeyword(), "name"); 
    }

    |RULE_STRING
    { 
    createLeafNode(grammarAccess.prFamilie().ele000001001LexerRuleCallSTRING(), "name"); 
    }
)
    |RULE_ID
    { 
    createLeafNode(grammarAccess.prFamilie().ele00000101LexerRuleCallID(), "name"); 
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
    createLeafNode(grammarAccess.prFamilie().ele000010CrossReferenceEStringErwachsener(), "mutter"); 
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
    createLeafNode(grammarAccess.prFamilie().ele00010CrossReferenceEStringErwachsener(), "vater"); 
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
    createLeafNode(grammarAccess.prFamilie().ele0010CrossReferenceEStringKind(), "kinder"); 
    }
) 
	
))(',' 
    {
        createLeafNode(grammarAccess.prFamilie().ele010KeywordComma(), null); 
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
    createLeafNode(grammarAccess.prFamilie().ele0110CrossReferenceEStringKind(), "kinder"); 
    }
) 
	
))*)')' 
    {
        createLeafNode(grammarAccess.prFamilie().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleFarbe
entryRuleFarbe returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prFarbe().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prFarbe().ele0000KeywordROT(), "wert"); 
    }

    |'BLAU' 
    {
        createLeafNode(grammarAccess.prFarbe().ele0001KeywordBLAU(), "wert"); 
    }
)
    |'GELB' 
    {
        createLeafNode(grammarAccess.prFarbe().ele001KeywordGELB(), "wert"); 
    }
)
    |'GR\u00DCN' 
    {
        createLeafNode(grammarAccess.prFarbe().ele01KeywordGRÜN(), "wert"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prCustomTypeParserRule().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prCustomTypeParserRule().ele0KeywordType(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prCustomTypeParserRule().ele10LexerRuleCallID(), "name"); 
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


