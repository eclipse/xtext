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
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:70:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:70:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:71:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpielplatz().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz72);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielplatz82); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:78:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse_1=null;
        Token lv_beschreibung_2=null;
        EObject lv_kinder_4 = null;

        EObject lv_erzieher_5 = null;

        EObject lv_spielzeuge_6 = null;

        EObject lv_familie_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:83:6: ( ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:1: ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )?
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:1: ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:2: ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}'
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:2: ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:3: ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )*
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:3: ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:4: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{'
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:4: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:5: ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )?
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:5: ( 'spielplatz' (lv_groesse_1= RULE_INT ) )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:6: 'spielplatz' (lv_groesse_1= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz120); 

                            createLeafNode(grammarAccess.prSpielplatz().ele00000KeywordSpielplatz(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:88:1: (lv_groesse_1= RULE_INT )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:90:6: lv_groesse_1= RULE_INT
                    {
                    lv_groesse_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz141); 

                    		createLeafNode(grammarAccess.prSpielplatz().ele000010ParserRuleCallINT(), "groesse"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "groesse", lv_groesse_1, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:107:3: (lv_beschreibung_2= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:109:6: lv_beschreibung_2= RULE_STRING
                            {
                            lv_beschreibung_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz170); 

                            		createLeafNode(grammarAccess.prSpielplatz().ele00010ParserRuleCallSTRING(), "beschreibung"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
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


                    }

                    match(input,12,FOLLOW_12_in_ruleSpielplatz188); 

                            createLeafNode(grammarAccess.prSpielplatz().ele001KeywordLeftCurlyBracket(), null); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:130:2: ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==14||(LA4_0>=17 && LA4_0<=18)) ) {
                            alt4=1;
                        }
                        else if ( (LA4_0==23) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:130:3: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:130:3: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )
                    	    int alt3=2;
                    	    int LA3_0 = input.LA(1);

                    	    if ( (LA3_0==14||LA3_0==17) ) {
                    	        alt3=1;
                    	    }
                    	    else if ( (LA3_0==18) ) {
                    	        alt3=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("130:3: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )", 3, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:130:4: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )
                    	            {
                    	            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:130:4: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )
                    	            int alt2=2;
                    	            int LA2_0 = input.LA(1);

                    	            if ( (LA2_0==14) ) {
                    	                alt2=1;
                    	            }
                    	            else if ( (LA2_0==17) ) {
                    	                alt2=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("130:4: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )", 2, 0, input);

                    	                throw nvae;
                    	            }
                    	            switch (alt2) {
                    	                case 1 :
                    	                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:130:5: (lv_kinder_4= ruleKind )
                    	                    {
                    	                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:130:5: (lv_kinder_4= ruleKind )
                    	                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:133:6: lv_kinder_4= ruleKind
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele010000ParserRuleCallKind(), currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz226);
                    	                    lv_kinder_4=ruleKind();
                    	                    _fsp--;


                    	                    	        if (current==null) {
                    	                    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
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
                    	                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:152:6: (lv_erzieher_5= ruleErwachsener )
                    	                    {
                    	                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:152:6: (lv_erzieher_5= ruleErwachsener )
                    	                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:155:6: lv_erzieher_5= ruleErwachsener
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele010010ParserRuleCallErwachsener(), currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz270);
                    	                    lv_erzieher_5=ruleErwachsener();
                    	                    _fsp--;


                    	                    	        if (current==null) {
                    	                    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
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

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:174:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	            {
                    	            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:174:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:177:6: lv_spielzeuge_6= ruleSpielzeug
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele01010ParserRuleCallSpielzeug(), currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz315);
                    	            lv_spielzeuge_6=ruleSpielzeug();
                    	            _fsp--;


                    	            	        if (current==null) {
                    	            	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
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

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:196:6: (lv_familie_7= ruleFamilie )
                    	    {
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:196:6: (lv_familie_7= ruleFamilie )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:199:6: lv_familie_7= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0110ParserRuleCallFamilie(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz360);
                    	    lv_familie_7=ruleFamilie();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
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

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }

                    match(input,13,FOLLOW_13_in_ruleSpielplatz376); 

                            createLeafNode(grammarAccess.prSpielplatz().ele1KeywordRightCurlyBracket(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:232:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:232:46: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:233:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKind().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind414);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind424); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:240:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:245:6: ( ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:1: ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:1: ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:2: ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:2: ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:3: ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:3: ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:4: ( 'kind' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:4: ( 'kind' '(' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind461); 

                    createLeafNode(grammarAccess.prKind().ele0000KeywordKind(), null); 
                
            match(input,15,FOLLOW_15_in_ruleKind470); 

                    createLeafNode(grammarAccess.prKind().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:254:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:256:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind492); 

            		createLeafNode(grammarAccess.prKind().ele0010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKind().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:273:3: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:275:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind521); 

            		createLeafNode(grammarAccess.prKind().ele010ParserRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKind().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind538); 

                    createLeafNode(grammarAccess.prKind().ele1KeywordRightParenthesis(), null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:305:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:305:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode(grammarAccess.prErwachsener().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener573);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener583); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:313:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:318:6: ( ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:1: ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:1: ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:2: ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:2: ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:3: ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:3: ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:4: ( 'erwachsener' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:4: ( 'erwachsener' '(' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener620); 

                    createLeafNode(grammarAccess.prErwachsener().ele0000KeywordErwachsener(), null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener629); 

                    createLeafNode(grammarAccess.prErwachsener().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:327:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:329:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener651); 

            		createLeafNode(grammarAccess.prErwachsener().ele0010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prErwachsener().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:346:3: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:348:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener680); 

            		createLeafNode(grammarAccess.prErwachsener().ele010ParserRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prErwachsener().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener697); 

                    createLeafNode(grammarAccess.prErwachsener().ele1KeywordRightParenthesis(), null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:378:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:378:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:379:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpielzeug().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug732);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug742); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:386:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_farbe_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:391:6: ( ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:1: ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:1: ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:2: ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:2: ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:3: ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:3: ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:4: ( 'spielzeug' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:4: ( 'spielzeug' '(' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug779); 

                    createLeafNode(grammarAccess.prSpielzeug().ele0000KeywordSpielzeug(), null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug788); 

                    createLeafNode(grammarAccess.prSpielzeug().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:400:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:402:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug810); 

            		createLeafNode(grammarAccess.prSpielzeug().ele0010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSpielzeug().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:419:3: (lv_farbe_3= ruleFarbe )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:422:6: lv_farbe_3= ruleFarbe
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prSpielzeug().ele010ParserRuleCallFarbe(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug852);
            lv_farbe_3=ruleFarbe();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSpielzeug().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "farbe", lv_farbe_3, "Farbe", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug866); 

                    createLeafNode(grammarAccess.prSpielzeug().ele1KeywordRightParenthesis(), null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:453:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:453:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:454:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFarbe().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe901);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe911); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:461:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:466:6: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=19 && LA8_0<=21)) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("467:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==21) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("467:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:3: ( 'ROT' | 'BLAU' )
                            {
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:3: ( 'ROT' | 'BLAU' )
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0==19) ) {
                                alt6=1;
                            }
                            else if ( (LA6_0==20) ) {
                                alt6=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("467:3: ( 'ROT' | 'BLAU' )", 6, 0, input);

                                throw nvae;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:4: 'ROT'
                                    {
                                    match(input,19,FOLLOW_19_in_ruleFarbe947); 

                                            createLeafNode(grammarAccess.prFarbe().ele000KeywordROT(), null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:472:6: 'BLAU'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe962); 

                                            createLeafNode(grammarAccess.prFarbe().ele001KeywordBLAU(), null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:477:6: 'GELB'
                            {
                            match(input,21,FOLLOW_21_in_ruleFarbe978); 

                                    createLeafNode(grammarAccess.prFarbe().ele01KeywordGELB(), null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:482:6: 'GR\\u00DCN'
                    {
                    match(input,22,FOLLOW_22_in_ruleFarbe994); 

                            createLeafNode(grammarAccess.prFarbe().ele1KeywordGRÜN(), null); 
                        

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
    // $ANTLR end ruleFarbe


    // $ANTLR start entryRuleFamilie
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:495:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:495:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:496:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFamilie().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie1029);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie1039); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:503:1: ruleFamilie returns [EObject current=null] : ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:508:6: ( ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:3: ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )*
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:3: ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:4: ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:4: ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:5: ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:5: ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:6: ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:6: ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:7: ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:7: ( 'familie' '(' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:509:8: 'familie' '('
            {
            match(input,23,FOLLOW_23_in_ruleFamilie1079); 

                    createLeafNode(grammarAccess.prFamilie().ele0000000KeywordFamilie(), null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie1088); 

                    createLeafNode(grammarAccess.prFamilie().ele0000001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:517:2: (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:519:6: lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:519:16: ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING||LA10_0==24) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("519:16: ( ( 'keyword' | RULE_STRING ) | RULE_ID )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:519:17: ( 'keyword' | RULE_STRING )
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:519:17: ( 'keyword' | RULE_STRING )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==24) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==RULE_STRING) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("519:17: ( 'keyword' | RULE_STRING )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:519:18: 'keyword'
                            {
                            match(input,24,FOLLOW_24_in_ruleFamilie1112); 

                                    createLeafNode(grammarAccess.prFamilie().ele000001000KeywordKeyword(), "name"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:525:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1129); 

                            		createLeafNode(grammarAccess.prFamilie().ele000001001ParserRuleCallSTRING(), "name"); 
                            	

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:531:7: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1143); 

                    		createLeafNode(grammarAccess.prFamilie().ele00000101ParserRuleCallID(), "name"); 
                    	

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", /* lv_name_2 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:550:3: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:553:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1176); 

            		createLeafNode(grammarAccess.prFamilie().ele000010CrossReferenceEStringErwachsener(), "mutter"); 
            	

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:566:3: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:569:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1202); 

            		createLeafNode(grammarAccess.prFamilie().ele00010CrossReferenceEStringErwachsener(), "vater"); 
            	

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:582:3: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:585:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1228); 

            		createLeafNode(grammarAccess.prFamilie().ele0010CrossReferenceEStringKind(), "kinder"); 
            	

            }


            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:598:3: ( ',' ( RULE_ID ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:598:4: ',' ( RULE_ID )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleFamilie1242); 

            	            createLeafNode(grammarAccess.prFamilie().ele010KeywordComma(), null); 
            	        
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:602:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:605:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1264); 

            	    		createLeafNode(grammarAccess.prFamilie().ele0110CrossReferenceEStringKind(), "kinder"); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleFamilie1279); 

                    createLeafNode(grammarAccess.prFamilie().ele1KeywordRightParenthesis(), null); 
                

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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz141 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz170 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz188 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz226 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz270 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz315 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz360 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind461 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind470 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind521 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener620 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener629 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener651 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener680 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug779 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug788 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug810 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug852 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFarbe947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFamilie1079 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie1088 = new BitSet(new long[]{0x0000000001000060L});
    public static final BitSet FOLLOW_24_in_ruleFamilie1112 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1129 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1143 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1176 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1202 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1228 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_ruleFamilie1242 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1264 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1279 = new BitSet(new long[]{0x0000000000000002L});

}