package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

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
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'familie'", "'keyword'", "','"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalReferenceGrammarTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g"; }


     
     	private ReferenceGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public InternalReferenceGrammarTestLanguageParser(TokenStream input, IAstFactory factory, ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	} 



    // $ANTLR start entryRuleSpielplatz
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:72:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:72:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:73:2: iv_ruleSpielplatz= ruleSpielplatz EOF
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:80:1: ruleSpielplatz returns [EObject current=null] : ( 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse_1_0=null;
        Token lv_beschreibung_2_0=null;
        EObject lv_kinder_4_0 = null;

        EObject lv_erzieher_5_0 = null;

        EObject lv_spielzeuge_6_0 = null;

        EObject lv_familie_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:85:6: ( ( 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* '}' )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:86:1: ( 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* '}' )?
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:86:1: ( 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:86:2: 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* '}'
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz117); 

                            createLeafNode(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:90:1: ( (lv_groesse_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:91:1: (lv_groesse_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:91:1: (lv_groesse_1_0= RULE_INT )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:92:3: lv_groesse_1_0= RULE_INT
                    {
                    lv_groesse_1_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz134); 

                    			createLeafNode(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0(), "groesse"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"groesse",
                    	        		lv_groesse_1_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:114:2: ( (lv_beschreibung_2_0= RULE_STRING ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:115:1: (lv_beschreibung_2_0= RULE_STRING )
                            {
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:115:1: (lv_beschreibung_2_0= RULE_STRING )
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:116:3: lv_beschreibung_2_0= RULE_STRING
                            {
                            lv_beschreibung_2_0=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz156); 

                            			createLeafNode(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0(), "beschreibung"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"beschreibung",
                            	        		lv_beschreibung_2_0, 
                            	        		"STRING", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;

                    }

                    match(input,12,FOLLOW_12_in_ruleSpielplatz171); 

                            createLeafNode(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:142:1: ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )*
                    loop2:
                    do {
                        int alt2=5;
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
                        case 23:
                            {
                            alt2=4;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:142:2: ( (lv_kinder_4_0= ruleKind ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:142:2: ( (lv_kinder_4_0= ruleKind ) )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:143:1: (lv_kinder_4_0= ruleKind )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:143:1: (lv_kinder_4_0= ruleKind )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:144:3: lv_kinder_4_0= ruleKind
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz193);
                    	    lv_kinder_4_0=ruleKind();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"kinder",
                    	    	        		lv_kinder_4_0, 
                    	    	        		"Kind", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:167:6: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:167:6: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:168:1: (lv_erzieher_5_0= ruleErwachsener )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:168:1: (lv_erzieher_5_0= ruleErwachsener )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:169:3: lv_erzieher_5_0= ruleErwachsener
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz220);
                    	    lv_erzieher_5_0=ruleErwachsener();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"erzieher",
                    	    	        		lv_erzieher_5_0, 
                    	    	        		"Erwachsener", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:192:6: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:192:6: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:193:1: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:193:1: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:194:3: lv_spielzeuge_6_0= ruleSpielzeug
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz247);
                    	    lv_spielzeuge_6_0=ruleSpielzeug();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"spielzeuge",
                    	    	        		lv_spielzeuge_6_0, 
                    	    	        		"Spielzeug", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:217:6: ( (lv_familie_7_0= ruleFamilie ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:217:6: ( (lv_familie_7_0= ruleFamilie ) )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:218:1: (lv_familie_7_0= ruleFamilie )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:218:1: (lv_familie_7_0= ruleFamilie )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:219:3: lv_familie_7_0= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz274);
                    	    lv_familie_7_0=ruleFamilie();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSpielplatzRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"familie",
                    	    	        		lv_familie_7_0, 
                    	    	        		"Familie", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ruleSpielplatz285); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:254:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:254:46: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:255:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKindRule(), currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind321);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind331); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:262:1: ruleKind returns [EObject current=null] : ( 'kind' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token lv_age_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:267:6: ( ( 'kind' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:268:1: ( 'kind' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:268:1: ( 'kind' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:268:2: 'kind' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')'
            {
            match(input,14,FOLLOW_14_in_ruleKind365); 

                    createLeafNode(grammarAccess.getKindAccess().getKindKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleKind374); 

                    createLeafNode(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:276:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:277:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:277:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:278:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind391); 

            			createLeafNode(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getKindRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:300:2: ( (lv_age_3_0= RULE_INT ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:301:1: (lv_age_3_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:301:1: (lv_age_3_0= RULE_INT )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:302:3: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind413); 

            			createLeafNode(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0(), "age"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getKindRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"age",
            	        		lv_age_3_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind427); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:335:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:335:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:336:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode(grammarAccess.getErwachsenerRule(), currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener460);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener470); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:343:1: ruleErwachsener returns [EObject current=null] : ( 'erwachsener' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token lv_age_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:348:6: ( ( 'erwachsener' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:349:1: ( 'erwachsener' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:349:1: ( 'erwachsener' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:349:2: 'erwachsener' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) ')'
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener504); 

                    createLeafNode(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener513); 

                    createLeafNode(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:357:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:358:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:358:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:359:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener530); 

            			createLeafNode(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getErwachsenerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:381:2: ( (lv_age_3_0= RULE_INT ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:382:1: (lv_age_3_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:382:1: (lv_age_3_0= RULE_INT )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:383:3: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener552); 

            			createLeafNode(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0(), "age"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getErwachsenerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"age",
            	        		lv_age_3_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener566); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:416:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:416:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:417:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpielzeugRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug599);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug609); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:424:1: ruleSpielzeug returns [EObject current=null] : ( 'spielzeug' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_farbe_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:429:6: ( ( 'spielzeug' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:430:1: ( 'spielzeug' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:430:1: ( 'spielzeug' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:430:2: 'spielzeug' '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) ')'
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug643); 

                    createLeafNode(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug652); 

                    createLeafNode(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:438:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:439:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:439:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:440:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug669); 

            			createLeafNode(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSpielzeugRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:462:2: ( (lv_farbe_3_0= ruleFarbe ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:463:1: (lv_farbe_3_0= ruleFarbe )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:463:1: (lv_farbe_3_0= ruleFarbe )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:464:3: lv_farbe_3_0= ruleFarbe
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug695);
            lv_farbe_3_0=ruleFarbe();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSpielzeugRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"farbe",
            	        		lv_farbe_3_0, 
            	        		"Farbe", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug704); 

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


    // $ANTLR start entryRuleFarbe
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:497:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:497:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:498:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFarbeRule(), currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe737);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe747); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:505:1: ruleFarbe returns [EObject current=null] : ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert_0_1=null;
        Token lv_wert_0_2=null;
        Token lv_wert_0_3=null;
        Token lv_wert_0_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:510:6: ( ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:511:1: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:511:1: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:512:1: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:512:1: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:513:1: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:513:1: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 21:
                {
                alt4=3;
                }
                break;
            case 22:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("513:1: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:514:3: lv_wert_0_1= 'ROT'
                    {
                    lv_wert_0_1=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleFarbe790); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0(), "wert"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFarbeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "wert", lv_wert_0_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:532:8: lv_wert_0_2= 'BLAU'
                    {
                    lv_wert_0_2=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleFarbe818); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1(), "wert"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFarbeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "wert", lv_wert_0_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:550:8: lv_wert_0_3= 'GELB'
                    {
                    lv_wert_0_3=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleFarbe846); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2(), "wert"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFarbeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "wert", lv_wert_0_3, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:568:8: lv_wert_0_4= 'GR\\u00DCN'
                    {
                    lv_wert_0_4=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleFarbe874); 

                            createLeafNode(grammarAccess.getFarbeAccess().getWertGRÜNKeyword_0_3(), "wert"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFarbeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "wert", lv_wert_0_4, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

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
    // $ANTLR end ruleFarbe


    // $ANTLR start entryRuleFamilie
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:596:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:596:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:597:2: iv_ruleFamilie= ruleFamilie EOF
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:604:1: ruleFamilie returns [EObject current=null] : ( 'familie' '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        Token lv_name_2_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:609:6: ( ( 'familie' '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:610:1: ( 'familie' '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:610:1: ( 'familie' '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:610:2: 'familie' '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ')'
            {
            match(input,23,FOLLOW_23_in_ruleFamilie966); 

                    createLeafNode(grammarAccess.getFamilieAccess().getFamilieKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie975); 

                    createLeafNode(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:618:1: ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:619:1: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:619:1: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:620:1: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:620:1: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt5=1;
                }
                break;
            case RULE_STRING:
                {
                alt5=2;
                }
                break;
            case RULE_ID:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("620:1: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:621:3: lv_name_2_1= 'keyword'
                    {
                    lv_name_2_1=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleFamilie994); 

                            createLeafNode(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_2_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:639:8: lv_name_2_2= RULE_STRING
                    {
                    lv_name_2_2=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1022); 

                    			createLeafNode(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_2_2, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:660:8: lv_name_2_3= RULE_ID
                    {
                    lv_name_2_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1042); 

                    			createLeafNode(grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_2_3, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:684:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:685:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:685:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:686:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1068); 

            		createLeafNode(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0(), "mutter"); 
            	

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:698:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:699:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:699:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:700:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1086); 

            		createLeafNode(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0(), "vater"); 
            	

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:712:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:713:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:713:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:714:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1104); 

            		createLeafNode(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0(), "kinder"); 
            	

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:726:2: ( ',' ( ( RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:726:3: ',' ( ( RULE_ID ) )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleFamilie1114); 

            	            createLeafNode(grammarAccess.getFamilieAccess().getCommaKeyword_6_0(), null); 
            	        
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:730:1: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:731:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:731:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:732:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getFamilieRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1132); 

            	    		createLeafNode(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0(), "kinder"); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,16,FOLLOW_16_in_ruleFamilie1143); 

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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz134 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz156 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz171 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz193 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz220 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz247 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz274 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind365 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind374 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind413 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener504 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener513 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener552 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug643 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug652 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug669 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug695 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFarbe790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFamilie966 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie975 = new BitSet(new long[]{0x0000000001000060L});
    public static final BitSet FOLLOW_24_in_ruleFamilie994 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1022 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1042 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1068 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1086 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1104 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_ruleFamilie1114 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1132 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1143 = new BitSet(new long[]{0x0000000000000002L});

}