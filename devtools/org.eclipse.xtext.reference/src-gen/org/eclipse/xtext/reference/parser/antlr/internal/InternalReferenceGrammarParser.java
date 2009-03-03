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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'familie'", "'keyword'", "','", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'type'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalReferenceGrammarParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g"; }


     
     	private ReferenceGrammarGrammarAccess grammarAccess;
     	
        public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, ReferenceGrammarGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	} 



    // $ANTLR start entryRuleSpielplatz
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:69:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:69:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:70:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpielplatz().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz71);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielplatz81); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSpielplatz


    // $ANTLR start ruleSpielplatz
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:77:1: ruleSpielplatz returns [EObject current=null] : ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse_1=null;
        Token lv_beschreibung_2=null;
        EObject lv_kinder_4 = null;

        EObject lv_erzieher_5 = null;

        EObject lv_spielzeuge_6 = null;

        EObject lv_familie_7 = null;

        EObject lv_types_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:82:6: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )? )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:83:1: ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )?
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:83:1: ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:83:2: 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}'
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz115); 

                            createLeafNode(grammarAccess.prSpielplatz().ele0KeywordSpielplatz(), null); 
                        
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:87:1: (lv_groesse_1= RULE_INT )
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:89:6: lv_groesse_1= RULE_INT
                    {
                    lv_groesse_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz137); 

                    		createLeafNode(grammarAccess.prSpielplatz().ele10TerminalRuleCallINT(), "groesse"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "groesse", lv_groesse_1, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:107:2: (lv_beschreibung_2= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:109:6: lv_beschreibung_2= RULE_STRING
                            {
                            lv_beschreibung_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz167); 

                            		createLeafNode(grammarAccess.prSpielplatz().ele20TerminalRuleCallSTRING(), "beschreibung"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "beschreibung", lv_beschreibung_2, "STRING", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }

                    match(input,12,FOLLOW_12_in_ruleSpielplatz185); 

                            createLeafNode(grammarAccess.prSpielplatz().ele3KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:131:1: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )*
                    loop2:
                    do {
                        int alt2=6;
                        switch ( input.LA(1) ) {
                        case 14:
                            {
                            alt2=1;
                            }
                            break;
                        case 17:
                            {
                            alt2=2;
                            }
                            break;
                        case 18:
                            {
                            alt2=3;
                            }
                            break;
                        case 19:
                            {
                            alt2=4;
                            }
                            break;
                        case 26:
                            {
                            alt2=5;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:131:2: (lv_kinder_4= ruleKind )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:131:2: (lv_kinder_4= ruleKind )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:134:6: lv_kinder_4= ruleKind
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele400ParserRuleCallKind(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz220);
                    	    lv_kinder_4=ruleKind();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "kinder", lv_kinder_4, "Kind", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:153:6: (lv_erzieher_5= ruleErwachsener )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:153:6: (lv_erzieher_5= ruleErwachsener )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:156:6: lv_erzieher_5= ruleErwachsener
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele410ParserRuleCallErwachsener(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz264);
                    	    lv_erzieher_5=ruleErwachsener();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "erzieher", lv_erzieher_5, "Erwachsener", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:175:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:175:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:178:6: lv_spielzeuge_6= ruleSpielzeug
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele420ParserRuleCallSpielzeug(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz308);
                    	    lv_spielzeuge_6=ruleSpielzeug();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "spielzeuge", lv_spielzeuge_6, "Spielzeug", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:197:6: (lv_familie_7= ruleFamilie )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:197:6: (lv_familie_7= ruleFamilie )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:200:6: lv_familie_7= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele430ParserRuleCallFamilie(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz352);
                    	    lv_familie_7=ruleFamilie();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "familie", lv_familie_7, "Familie", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:219:6: (lv_types_8= ruleCustomTypeParserRule )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:219:6: (lv_types_8= ruleCustomTypeParserRule )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:222:6: lv_types_8= ruleCustomTypeParserRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele440ParserRuleCallCustomTypeParserRule(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz396);
                    	    lv_types_8=ruleCustomTypeParserRule();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "types", lv_types_8, "CustomTypeParserRule", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ruleSpielplatz411); 

                            createLeafNode(grammarAccess.prSpielplatz().ele5KeywordRightCurlyBracket(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSpielplatz


    // $ANTLR start entryRuleKind
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:253:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:253:46: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:254:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKind().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind447);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind457); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleKind


    // $ANTLR start ruleKind
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:261:1: ruleKind returns [EObject current=null] : ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:6: ( ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:267:1: ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:267:1: ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:267:2: 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')'
            {
            match(input,14,FOLLOW_14_in_ruleKind491); 

                    createLeafNode(grammarAccess.prKind().ele0KeywordKind(), null); 
                
            match(input,15,FOLLOW_15_in_ruleKind500); 

                    createLeafNode(grammarAccess.prKind().ele1KeywordLeftParenthesis(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:275:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:277:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind522); 

            		createLeafNode(grammarAccess.prKind().ele20TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKind().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:295:2: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:297:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind552); 

            		createLeafNode(grammarAccess.prKind().ele30TerminalRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKind().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleKind569); 

                    createLeafNode(grammarAccess.prKind().ele4KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKind


    // $ANTLR start entryRuleErwachsener
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:326:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:326:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:327:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode(grammarAccess.prErwachsener().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener602);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener612); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleErwachsener


    // $ANTLR start ruleErwachsener
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:334:1: ruleErwachsener returns [EObject current=null] : ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:339:6: ( ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:1: ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:1: ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:2: 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')'
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener646); 

                    createLeafNode(grammarAccess.prErwachsener().ele0KeywordErwachsener(), null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener655); 

                    createLeafNode(grammarAccess.prErwachsener().ele1KeywordLeftParenthesis(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:348:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:350:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener677); 

            		createLeafNode(grammarAccess.prErwachsener().ele20TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prErwachsener().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:368:2: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:370:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener707); 

            		createLeafNode(grammarAccess.prErwachsener().ele30TerminalRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prErwachsener().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleErwachsener724); 

                    createLeafNode(grammarAccess.prErwachsener().ele4KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleErwachsener


    // $ANTLR start entryRuleSpielzeug
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:399:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:399:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:400:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpielzeug().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug757);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug767); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSpielzeug


    // $ANTLR start ruleSpielzeug
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:407:1: ruleSpielzeug returns [EObject current=null] : ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_farbe_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:412:6: ( ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:413:1: ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:413:1: ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:413:2: 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')'
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug801); 

                    createLeafNode(grammarAccess.prSpielzeug().ele0KeywordSpielzeug(), null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug810); 

                    createLeafNode(grammarAccess.prSpielzeug().ele1KeywordLeftParenthesis(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:421:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:423:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug832); 

            		createLeafNode(grammarAccess.prSpielzeug().ele20TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSpielzeug().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:441:2: (lv_farbe_3= ruleFarbe )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:444:6: lv_farbe_3= ruleFarbe
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prSpielzeug().ele30ParserRuleCallFarbe(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug874);
            lv_farbe_3=ruleFarbe();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSpielzeug().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "farbe", lv_farbe_3, "Farbe", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug887); 

                    createLeafNode(grammarAccess.prSpielzeug().ele4KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSpielzeug


    // $ANTLR start entryRuleFamilie
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:473:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:473:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:474:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFamilie().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie920);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie930); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFamilie


    // $ANTLR start ruleFamilie
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:481:1: ruleFamilie returns [EObject current=null] : ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:486:6: ( ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:487:1: ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:487:1: ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:487:2: 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')'
            {
            match(input,19,FOLLOW_19_in_ruleFamilie964); 

                    createLeafNode(grammarAccess.prFamilie().ele0KeywordFamilie(), null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie973); 

                    createLeafNode(grammarAccess.prFamilie().ele1KeywordLeftParenthesis(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:495:1: (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:497:6: lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:497:16: ( 'keyword' | RULE_STRING | RULE_ID )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt4=1;
                }
                break;
            case RULE_STRING:
                {
                alt4=2;
                }
                break;
            case RULE_ID:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("497:16: ( 'keyword' | RULE_STRING | RULE_ID )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:497:17: 'keyword'
                    {
                    match(input,20,FOLLOW_20_in_ruleFamilie995); 

                            createLeafNode(grammarAccess.prFamilie().ele200KeywordKeyword(), "name"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:503:7: RULE_STRING
                    {
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1012); 

                    		createLeafNode(grammarAccess.prFamilie().ele201TerminalRuleCallSTRING(), "name"); 
                    	

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:508:7: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1024); 

                    		createLeafNode(grammarAccess.prFamilie().ele202TerminalRuleCallID(), "name"); 
                    	

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", /* lv_name_2 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:527:2: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:530:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1056); 

            		createLeafNode(grammarAccess.prFamilie().ele30CrossReferenceIDErwachsener(), "mutter"); 
            	

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:543:2: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:546:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1081); 

            		createLeafNode(grammarAccess.prFamilie().ele40CrossReferenceIDErwachsener(), "vater"); 
            	

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:559:2: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:562:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1106); 

            		createLeafNode(grammarAccess.prFamilie().ele50CrossReferenceIDKind(), "kinder"); 
            	

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:575:2: ( ',' ( RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==21) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:575:3: ',' ( RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleFamilie1119); 

            	            createLeafNode(grammarAccess.prFamilie().ele60KeywordComma(), null); 
            	        
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:579:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:582:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1141); 

            	    		createLeafNode(grammarAccess.prFamilie().ele610CrossReferenceIDKind(), "kinder"); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,16,FOLLOW_16_in_ruleFamilie1155); 

                    createLeafNode(grammarAccess.prFamilie().ele7KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFamilie


    // $ANTLR start entryRuleFarbe
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:606:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:606:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:607:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFarbe().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe1188);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe1198); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFarbe


    // $ANTLR start ruleFarbe
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:614:1: ruleFarbe returns [EObject current=null] : (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:6: ( (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:620:1: (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:620:1: (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:622:6: lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:622:16: ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt6=1;
                }
                break;
            case 23:
                {
                alt6=2;
                }
                break;
            case 24:
                {
                alt6=3;
                }
                break;
            case 25:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("622:16: ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:622:17: 'ROT'
                    {
                    match(input,22,FOLLOW_22_in_ruleFarbe1244); 

                            createLeafNode(grammarAccess.prFarbe().ele00KeywordROT(), "wert"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:628:6: 'BLAU'
                    {
                    match(input,23,FOLLOW_23_in_ruleFarbe1260); 

                            createLeafNode(grammarAccess.prFarbe().ele01KeywordBLAU(), "wert"); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:6: 'GELB'
                    {
                    match(input,24,FOLLOW_24_in_ruleFarbe1276); 

                            createLeafNode(grammarAccess.prFarbe().ele02KeywordGELB(), "wert"); 
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:640:6: 'GR\\u00DCN'
                    {
                    match(input,25,FOLLOW_25_in_ruleFarbe1292); 

                            createLeafNode(grammarAccess.prFarbe().ele03KeywordGRÜN(), "wert"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prFarbe().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "wert", /* lv_wert_0 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFarbe


    // $ANTLR start entryRuleCustomTypeParserRule
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:667:1: entryRuleCustomTypeParserRule returns [EObject current=null] : iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF ;
    public final EObject entryRuleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomTypeParserRule = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:667:62: (iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:668:2: iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCustomTypeParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1339);
            iv_ruleCustomTypeParserRule=ruleCustomTypeParserRule();
            _fsp--;

             current =iv_ruleCustomTypeParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomTypeParserRule1349); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCustomTypeParserRule


    // $ANTLR start ruleCustomTypeParserRule
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:675:1: ruleCustomTypeParserRule returns [EObject current=null] : ( 'type' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:680:6: ( ( 'type' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:681:1: ( 'type' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:681:1: ( 'type' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:681:2: 'type' (lv_name_1= RULE_ID )
            {
            match(input,26,FOLLOW_26_in_ruleCustomTypeParserRule1383); 

                    createLeafNode(grammarAccess.prCustomTypeParserRule().ele0KeywordType(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:685:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:687:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1405); 

            		createLeafNode(grammarAccess.prCustomTypeParserRule().ele10TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCustomTypeParserRule().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCustomTypeParserRule


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz137 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz167 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz185 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz220 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz264 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz308 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz352 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz396 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind491 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind500 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind552 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener646 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener655 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener677 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener707 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug801 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug810 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug832 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug874 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFamilie964 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie973 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_20_in_ruleFamilie995 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1012 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1024 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1056 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1081 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1106 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_21_in_ruleFamilie1119 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1141 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe1188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFarbe1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFarbe1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomTypeParserRule1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleCustomTypeParserRule1383 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1405 = new BitSet(new long[]{0x0000000000000002L});

}