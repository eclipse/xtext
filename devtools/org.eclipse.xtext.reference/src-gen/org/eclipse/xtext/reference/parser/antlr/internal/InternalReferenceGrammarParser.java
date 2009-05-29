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
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:72:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:72:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:73:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpielplatzRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz73);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielplatz83); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:80:1: ruleSpielplatz returns [EObject current=null] : ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )? ;
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
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:85:6: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )? )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:86:1: ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )?
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:86:1: ( 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:86:2: 'spielplatz' (lv_groesse_1= RULE_INT ) (lv_beschreibung_2= RULE_STRING )? '{' ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )* '}'
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz117); 

                            createLeafNode(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0(), null); 
                        
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:90:1: (lv_groesse_1= RULE_INT )
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:92:6: lv_groesse_1= RULE_INT
                    {
                    lv_groesse_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz139); 

                    		createLeafNode(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0(), "groesse"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "groesse", lv_groesse_1, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:110:2: (lv_beschreibung_2= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:112:6: lv_beschreibung_2= RULE_STRING
                            {
                            lv_beschreibung_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz169); 

                            		createLeafNode(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0(), "beschreibung"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
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

                    match(input,12,FOLLOW_12_in_ruleSpielplatz187); 

                            createLeafNode(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3(), null); 
                        
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:134:1: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) | (lv_spielzeuge_6= ruleSpielzeug ) | (lv_familie_7= ruleFamilie ) | (lv_types_8= ruleCustomTypeParserRule ) )*
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
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:134:2: (lv_kinder_4= ruleKind )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:134:2: (lv_kinder_4= ruleKind )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:137:6: lv_kinder_4= ruleKind
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz222);
                    	    lv_kinder_4=ruleKind();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
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
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:156:6: (lv_erzieher_5= ruleErwachsener )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:156:6: (lv_erzieher_5= ruleErwachsener )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:159:6: lv_erzieher_5= ruleErwachsener
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz266);
                    	    lv_erzieher_5=ruleErwachsener();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
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
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:178:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:178:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:181:6: lv_spielzeuge_6= ruleSpielzeug
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz310);
                    	    lv_spielzeuge_6=ruleSpielzeug();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
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
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:200:6: (lv_familie_7= ruleFamilie )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:200:6: (lv_familie_7= ruleFamilie )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:203:6: lv_familie_7= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz354);
                    	    lv_familie_7=ruleFamilie();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
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
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:222:6: (lv_types_8= ruleCustomTypeParserRule )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:222:6: (lv_types_8= ruleCustomTypeParserRule )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:225:6: lv_types_8= ruleCustomTypeParserRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getTypesCustomTypeParserRuleParserRuleCall_4_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz398);
                    	    lv_types_8=ruleCustomTypeParserRule();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
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

                    match(input,13,FOLLOW_13_in_ruleSpielplatz413); 

                            createLeafNode(grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5(), null); 
                        

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:256:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:256:46: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:257:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKindRule(), currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind449);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind459); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:264:1: ruleKind returns [EObject current=null] : ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:269:6: ( ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:1: ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:1: ( 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:2: 'kind' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')'
            {
            match(input,14,FOLLOW_14_in_ruleKind493); 

                    createLeafNode(grammarAccess.getKindAccess().getKindKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleKind502); 

                    createLeafNode(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:278:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:280:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind524); 

            		createLeafNode(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getKindRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:298:2: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:300:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind554); 

            		createLeafNode(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getKindRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleKind571); 

                    createLeafNode(grammarAccess.getKindAccess().getRightParenthesisKeyword_4(), null); 
                

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:329:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:329:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:330:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode(grammarAccess.getErwachsenerRule(), currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener604);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener614); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:337:1: ruleErwachsener returns [EObject current=null] : ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:342:6: ( ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:343:1: ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:343:1: ( 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:343:2: 'erwachsener' '(' (lv_name_2= RULE_ID ) (lv_age_3= RULE_INT ) ')'
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener648); 

                    createLeafNode(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener657); 

                    createLeafNode(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:351:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:353:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener679); 

            		createLeafNode(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getErwachsenerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:371:2: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:373:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener709); 

            		createLeafNode(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getErwachsenerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleErwachsener726); 

                    createLeafNode(grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4(), null); 
                

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:402:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:402:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:403:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpielzeugRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug759);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug769); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:410:1: ruleSpielzeug returns [EObject current=null] : ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_farbe_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:415:6: ( ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:416:1: ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:416:1: ( 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:416:2: 'spielzeug' '(' (lv_name_2= RULE_ID ) (lv_farbe_3= ruleFarbe ) ')'
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug803); 

                    createLeafNode(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug812); 

                    createLeafNode(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:424:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:426:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug834); 

            		createLeafNode(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSpielzeugRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:444:2: (lv_farbe_3= ruleFarbe )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:447:6: lv_farbe_3= ruleFarbe
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug876);
            lv_farbe_3=ruleFarbe();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSpielzeugRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "farbe", lv_farbe_3, "Farbe", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug889); 

                    createLeafNode(grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4(), null); 
                

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:476:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:476:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:477:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFamilieRule(), currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie922);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie932); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:484:1: ruleFamilie returns [EObject current=null] : ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:6: ( ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:490:1: ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:490:1: ( 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:490:2: 'familie' '(' (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) ) ( RULE_ID ) ( RULE_ID ) ( RULE_ID ) ( ',' ( RULE_ID ) )* ')'
            {
            match(input,19,FOLLOW_19_in_ruleFamilie966); 

                    createLeafNode(grammarAccess.getFamilieAccess().getFamilieKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie975); 

                    createLeafNode(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:498:1: (lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:500:6: lv_name_2= ( 'keyword' | RULE_STRING | RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:500:16: ( 'keyword' | RULE_STRING | RULE_ID )
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
                    new NoViableAltException("500:16: ( 'keyword' | RULE_STRING | RULE_ID )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:500:17: 'keyword'
                    {
                    match(input,20,FOLLOW_20_in_ruleFamilie997); 

                            createLeafNode(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0(), "name"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:506:7: RULE_STRING
                    {
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1014); 

                    		createLeafNode(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1(), "name"); 
                    	

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:511:7: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1026); 

                    		createLeafNode(grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2(), "name"); 
                    	

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", /* lv_name_2 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:530:2: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:533:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1058); 

            		createLeafNode(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0(), "mutter"); 
            	

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:546:2: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:549:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1083); 

            		createLeafNode(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0(), "vater"); 
            	

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:562:2: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:565:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1108); 

            		createLeafNode(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0(), "kinder"); 
            	

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:578:2: ( ',' ( RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==21) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:578:3: ',' ( RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleFamilie1121); 

            	            createLeafNode(grammarAccess.getFamilieAccess().getCommaKeyword_6_0(), null); 
            	        
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:582:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:585:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1143); 

            	    		createLeafNode(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0(), "kinder"); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,16,FOLLOW_16_in_ruleFamilie1157); 

                    createLeafNode(grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7(), null); 
                

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:609:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:609:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:610:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFarbeRule(), currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe1190);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe1200); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:617:1: ruleFarbe returns [EObject current=null] : (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:622:6: ( (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:623:1: (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:623:1: (lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:625:6: lv_wert_0= ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:625:16: ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' )
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
                    new NoViableAltException("625:16: ( 'ROT' | 'BLAU' | 'GELB' | 'GR\\u00DCN' )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:625:17: 'ROT'
                    {
                    match(input,22,FOLLOW_22_in_ruleFarbe1246); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0(), "wert"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:631:6: 'BLAU'
                    {
                    match(input,23,FOLLOW_23_in_ruleFarbe1262); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1(), "wert"); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:637:6: 'GELB'
                    {
                    match(input,24,FOLLOW_24_in_ruleFarbe1278); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2(), "wert"); 
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:643:6: 'GR\\u00DCN'
                    {
                    match(input,25,FOLLOW_25_in_ruleFarbe1294); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertGRÜNKeyword_0_3(), "wert"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFarbeRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:670:1: entryRuleCustomTypeParserRule returns [EObject current=null] : iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF ;
    public final EObject entryRuleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomTypeParserRule = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:670:62: (iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:671:2: iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCustomTypeParserRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1341);
            iv_ruleCustomTypeParserRule=ruleCustomTypeParserRule();
            _fsp--;

             current =iv_ruleCustomTypeParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomTypeParserRule1351); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:678:1: ruleCustomTypeParserRule returns [EObject current=null] : ( 'type' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:683:6: ( ( 'type' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:684:1: ( 'type' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:684:1: ( 'type' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:684:2: 'type' (lv_name_1= RULE_ID )
            {
            match(input,26,FOLLOW_26_in_ruleCustomTypeParserRule1385); 

                    createLeafNode(grammarAccess.getCustomTypeParserRuleAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:688:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:690:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1407); 

            		createLeafNode(grammarAccess.getCustomTypeParserRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCustomTypeParserRuleRule().getType().getClassifier());
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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz139 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz169 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz187 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz222 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz266 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz310 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz354 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz398 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind493 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind502 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind524 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind554 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener648 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener657 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener709 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug803 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug812 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug834 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug876 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFamilie966 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie975 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_20_in_ruleFamilie997 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1014 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1026 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1058 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1083 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1108 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_21_in_ruleFamilie1121 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1143 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe1190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFarbe1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFarbe1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomTypeParserRule1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleCustomTypeParserRule1385 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1407 = new BitSet(new long[]{0x0000000000000002L});

}