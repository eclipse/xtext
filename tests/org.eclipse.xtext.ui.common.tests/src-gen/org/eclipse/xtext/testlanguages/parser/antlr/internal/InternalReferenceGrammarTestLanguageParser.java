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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:70:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:70:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:71:2: iv_ruleSpielplatz= ruleSpielplatz EOF
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:78:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )? ;
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:83:6: ( ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:1: ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:1: ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:2: ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* ) '}'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:2: ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )* )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:3: ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )*
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:3: ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:4: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:4: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:5: ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )?
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:5: ( 'spielplatz' (lv_groesse_1= RULE_INT ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:6: 'spielplatz' (lv_groesse_1= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz120); 

                            createLeafNode(grammarAccess.prSpielplatz().ele00000KeywordSpielplatz(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:88:1: (lv_groesse_1= RULE_INT )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:90:6: lv_groesse_1= RULE_INT
                    {
                    lv_groesse_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz142); 

                    		createLeafNode(grammarAccess.prSpielplatz().ele000010LexerRuleCallINT(), "groesse"); 
                    	

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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:108:3: (lv_beschreibung_2= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:110:6: lv_beschreibung_2= RULE_STRING
                            {
                            lv_beschreibung_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz173); 

                            		createLeafNode(grammarAccess.prSpielplatz().ele00010LexerRuleCallSTRING(), "beschreibung"); 
                            	

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

                    match(input,12,FOLLOW_12_in_ruleSpielplatz192); 

                            createLeafNode(grammarAccess.prSpielplatz().ele001KeywordLeftCurlyBracket(), null); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:132:2: ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )*
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:132:3: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:132:3: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )
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
                    	            new NoViableAltException("132:3: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )", 3, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:132:4: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )
                    	            {
                    	            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:132:4: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )
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
                    	                    new NoViableAltException("132:4: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )", 2, 0, input);

                    	                throw nvae;
                    	            }
                    	            switch (alt2) {
                    	                case 1 :
                    	                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:132:5: (lv_kinder_4= ruleKind )
                    	                    {
                    	                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:132:5: (lv_kinder_4= ruleKind )
                    	                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:135:6: lv_kinder_4= ruleKind
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele010000ParserRuleCallKind(), currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz230);
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
                    	                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:154:6: (lv_erzieher_5= ruleErwachsener )
                    	                    {
                    	                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:154:6: (lv_erzieher_5= ruleErwachsener )
                    	                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:157:6: lv_erzieher_5= ruleErwachsener
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele010010ParserRuleCallErwachsener(), currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz274);
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
                    	            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:176:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	            {
                    	            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:176:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:179:6: lv_spielzeuge_6= ruleSpielzeug
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele01010ParserRuleCallSpielzeug(), currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz319);
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:198:6: (lv_familie_7= ruleFamilie )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:198:6: (lv_familie_7= ruleFamilie )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:201:6: lv_familie_7= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0110ParserRuleCallFamilie(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz364);
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

                    match(input,13,FOLLOW_13_in_ruleSpielplatz380); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:234:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:234:46: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:235:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKind().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind418);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind428); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:242:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:247:6: ( ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:1: ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:1: ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:2: ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:2: ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:3: ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:3: ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:4: ( 'kind' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:4: ( 'kind' '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:248:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind465); 

                    createLeafNode(grammarAccess.prKind().ele0000KeywordKind(), null); 
                
            match(input,15,FOLLOW_15_in_ruleKind474); 

                    createLeafNode(grammarAccess.prKind().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:256:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:258:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind497); 

            		createLeafNode(grammarAccess.prKind().ele0010LexerRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:276:3: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:278:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind528); 

            		createLeafNode(grammarAccess.prKind().ele010LexerRuleCallINT(), "age"); 
            	

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

            match(input,16,FOLLOW_16_in_ruleKind546); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:309:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:309:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:310:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode(grammarAccess.prErwachsener().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener581);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener591); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:317:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:322:6: ( ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:1: ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:1: ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:2: ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:2: ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:3: ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:3: ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:4: ( 'erwachsener' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:4: ( 'erwachsener' '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener628); 

                    createLeafNode(grammarAccess.prErwachsener().ele0000KeywordErwachsener(), null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener637); 

                    createLeafNode(grammarAccess.prErwachsener().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:331:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:333:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener660); 

            		createLeafNode(grammarAccess.prErwachsener().ele0010LexerRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:351:3: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:353:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener691); 

            		createLeafNode(grammarAccess.prErwachsener().ele010LexerRuleCallINT(), "age"); 
            	

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

            match(input,16,FOLLOW_16_in_ruleErwachsener709); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:384:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:384:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:385:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpielzeug().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug744);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug754); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_farbe_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:397:6: ( ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:1: ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:1: ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:2: ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:2: ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:3: ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:3: ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:4: ( 'spielzeug' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:4: ( 'spielzeug' '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug791); 

                    createLeafNode(grammarAccess.prSpielzeug().ele0000KeywordSpielzeug(), null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug800); 

                    createLeafNode(grammarAccess.prSpielzeug().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:406:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:408:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug823); 

            		createLeafNode(grammarAccess.prSpielzeug().ele0010LexerRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:426:3: (lv_farbe_3= ruleFarbe )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:429:6: lv_farbe_3= ruleFarbe
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prSpielzeug().ele010ParserRuleCallFarbe(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug866);
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

            match(input,16,FOLLOW_16_in_ruleSpielzeug880); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:460:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:460:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:461:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFarbe().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe915);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe925); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:468:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:473:6: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )
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
                    new NoViableAltException("474:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
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
                            new NoViableAltException("474:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:3: ( 'ROT' | 'BLAU' )
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:3: ( 'ROT' | 'BLAU' )
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
                                    new NoViableAltException("474:3: ( 'ROT' | 'BLAU' )", 6, 0, input);

                                throw nvae;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:4: 'ROT'
                                    {
                                    match(input,19,FOLLOW_19_in_ruleFarbe961); 

                                            createLeafNode(grammarAccess.prFarbe().ele000KeywordROT(), null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:479:6: 'BLAU'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe976); 

                                            createLeafNode(grammarAccess.prFarbe().ele001KeywordBLAU(), null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:6: 'GELB'
                            {
                            match(input,21,FOLLOW_21_in_ruleFarbe992); 

                                    createLeafNode(grammarAccess.prFarbe().ele01KeywordGELB(), null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:489:6: 'GR\\u00DCN'
                    {
                    match(input,22,FOLLOW_22_in_ruleFarbe1008); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:502:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:502:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:503:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFamilie().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie1043);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie1053); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:510:1: ruleFamilie returns [EObject current=null] : ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:515:6: ( ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:3: ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )*
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:3: ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:4: ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:4: ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:5: ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:5: ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:6: ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:6: ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:7: ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:7: ( 'familie' '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:8: 'familie' '('
            {
            match(input,23,FOLLOW_23_in_ruleFamilie1093); 

                    createLeafNode(grammarAccess.prFamilie().ele0000000KeywordFamilie(), null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie1102); 

                    createLeafNode(grammarAccess.prFamilie().ele0000001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:524:2: (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:526:6: lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:526:16: ( ( 'keyword' | RULE_STRING ) | RULE_ID )
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
                    new NoViableAltException("526:16: ( ( 'keyword' | RULE_STRING ) | RULE_ID )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:526:17: ( 'keyword' | RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:526:17: ( 'keyword' | RULE_STRING )
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
                            new NoViableAltException("526:17: ( 'keyword' | RULE_STRING )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:526:18: 'keyword'
                            {
                            match(input,24,FOLLOW_24_in_ruleFamilie1126); 

                                    createLeafNode(grammarAccess.prFamilie().ele000001000KeywordKeyword(), "name"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:532:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1143); 

                            		createLeafNode(grammarAccess.prFamilie().ele000001001LexerRuleCallSTRING(), "name"); 
                            	

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:538:7: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1157); 

                    		createLeafNode(grammarAccess.prFamilie().ele00000101LexerRuleCallID(), "name"); 
                    	

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:557:3: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:560:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1190); 

            		createLeafNode(grammarAccess.prFamilie().ele000010CrossReferenceEStringErwachsener(), "mutter"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:573:3: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:576:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1216); 

            		createLeafNode(grammarAccess.prFamilie().ele00010CrossReferenceEStringErwachsener(), "vater"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:589:3: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:592:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1242); 

            		createLeafNode(grammarAccess.prFamilie().ele0010CrossReferenceEStringKind(), "kinder"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:605:3: ( ',' ( RULE_ID ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:605:4: ',' ( RULE_ID )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleFamilie1256); 

            	            createLeafNode(grammarAccess.prFamilie().ele010KeywordComma(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:609:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:612:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1278); 

            	    		createLeafNode(grammarAccess.prFamilie().ele0110CrossReferenceEStringKind(), "kinder"); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleFamilie1293); 

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
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz142 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz173 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz192 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz230 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz274 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz319 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz364 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind465 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind474 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind528 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener628 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener637 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener691 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug791 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug800 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug823 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug866 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFarbe961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie1043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFamilie1093 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie1102 = new BitSet(new long[]{0x0000000001000060L});
    public static final BitSet FOLLOW_24_in_ruleFamilie1126 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1143 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1157 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1190 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1216 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1242 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_ruleFamilie1256 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1278 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1293 = new BitSet(new long[]{0x0000000000000002L});

}