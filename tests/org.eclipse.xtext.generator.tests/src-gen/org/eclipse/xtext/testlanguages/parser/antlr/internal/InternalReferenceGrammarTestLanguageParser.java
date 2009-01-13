// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g 2009-01-13 09:48:31

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
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GRÜN'", "'familie'", "'keyword'", "','"
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g"; }


     
        public InternalReferenceGrammarTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalReferenceGrammarTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	} 



    // $ANTLR start entryRuleSpielplatz
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:66:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:66:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:67:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:74:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse=null;
        Token lv_beschreibung=null;
        EObject lv_kinder = null;

        EObject lv_erzieher = null;

        EObject lv_spielzeuge = null;

        EObject lv_familie = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:76:33: ( ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{'
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:5: ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )?
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:5: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:77:6: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz119); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:81:1: (lv_groesse= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:83:6: lv_groesse= RULE_INT
                    {
                    lv_groesse=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz140); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "groesse"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Spielplatz");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "groesse", lv_groesse, "INT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:101:3: (lv_beschreibung= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:103:6: lv_beschreibung= RULE_STRING
                            {
                            lv_beschreibung=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz173); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "beschreibung"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("Spielplatz");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "beschreibung", lv_beschreibung, "STRING", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }

                    match(input,12,FOLLOW_12_in_ruleSpielplatz195); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:125:2: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:125:3: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:125:3: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
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
                    	            new NoViableAltException("125:3: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )", 3, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:125:4: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:125:4: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
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
                    	                    new NoViableAltException("125:4: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 2, 0, input);

                    	                throw nvae;
                    	            }
                    	            switch (alt2) {
                    	                case 1 :
                    	                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:125:5: (lv_kinder= ruleKind )
                    	                    {
                    	                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:125:5: (lv_kinder= ruleKind )
                    	                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:128:6: lv_kinder= ruleKind
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz233);
                    	                    lv_kinder=ruleKind();
                    	                    _fsp--;


                    	                    	        if (current==null) {
                    	                    	            current = factory.create("Spielplatz");
                    	                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                    	        }
                    	                    	        
                    	                    	        try {
                    	                    	        	factory.add(current, "kinder", lv_kinder, "Kind", currentNode);
                    	                    	        } catch (ValueConverterException vce) {
                    	                    				handleValueConverterException(vce);
                    	                    	        }
                    	                    	        currentNode = currentNode.getParent();
                    	                    	    

                    	                    }


                    	                    }
                    	                    break;
                    	                case 2 :
                    	                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:147:6: (lv_erzieher= ruleErwachsener )
                    	                    {
                    	                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:147:6: (lv_erzieher= ruleErwachsener )
                    	                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:150:6: lv_erzieher= ruleErwachsener
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz277);
                    	                    lv_erzieher=ruleErwachsener();
                    	                    _fsp--;


                    	                    	        if (current==null) {
                    	                    	            current = factory.create("Spielplatz");
                    	                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                    	        }
                    	                    	        
                    	                    	        try {
                    	                    	        	factory.add(current, "erzieher", lv_erzieher, "Erwachsener", currentNode);
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
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:169:6: (lv_spielzeuge= ruleSpielzeug )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:169:6: (lv_spielzeuge= ruleSpielzeug )
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:172:6: lv_spielzeuge= ruleSpielzeug
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz322);
                    	            lv_spielzeuge=ruleSpielzeug();
                    	            _fsp--;


                    	            	        if (current==null) {
                    	            	            current = factory.create("Spielplatz");
                    	            	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	            	        }
                    	            	        
                    	            	        try {
                    	            	        	factory.add(current, "spielzeuge", lv_spielzeuge, "Spielzeug", currentNode);
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:191:6: (lv_familie= ruleFamilie )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:191:6: (lv_familie= ruleFamilie )
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:194:6: lv_familie= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz367);
                    	    lv_familie=ruleFamilie();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("Spielplatz");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "familie", lv_familie, "Familie", currentNode);
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

                    match(input,13,FOLLOW_13_in_ruleSpielplatz383); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:225:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:225:46: (iv_ruleKind= ruleKind EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:226:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind419);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind429); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:233:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:235:33: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:4: ( 'kind' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:236:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind466); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleKind475); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:244:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:246:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind497); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:264:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:266:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind530); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "age", lv_age, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind551); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:295:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:295:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:296:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener584);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener594); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:303:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:305:33: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:4: ( 'erwachsener' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener631); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener640); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:314:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:316:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener662); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:334:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:336:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener695); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "age", lv_age, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener716); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:365:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:365:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:366:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug749);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug759); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:373:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:375:33: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:4: ( 'spielzeug' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug796); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug805); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:384:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:386:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug827); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:404:3: (lv_farbe= ruleFarbe )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:407:6: lv_farbe= ruleFarbe
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug873);
            lv_farbe=ruleFarbe();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "farbe", lv_farbe, "Farbe", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug887); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:436:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:436:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:437:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe920);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe930); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:444:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:446:33: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
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
                    new NoViableAltException("447:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
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
                            new NoViableAltException("447:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:3: ( 'ROT' | 'BLAU' )
                            {
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:3: ( 'ROT' | 'BLAU' )
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
                                    new NoViableAltException("447:3: ( 'ROT' | 'BLAU' )", 6, 0, input);

                                throw nvae;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:4: 'ROT'
                                    {
                                    match(input,19,FOLLOW_19_in_ruleFarbe966); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:452:6: 'BLAU'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe981); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:457:6: 'GELB'
                            {
                            match(input,21,FOLLOW_21_in_ruleFarbe997); 

                                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:462:6: 'GRÜN'
                    {
                    match(input,22,FOLLOW_22_in_ruleFarbe1013); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.5/@alternatives/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:473:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:473:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie1046);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie1056); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:481:1: ruleFamilie returns [EObject current=null] : ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:483:33: ( ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:7: ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:7: ( 'familie' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:484:8: 'familie' '('
            {
            match(input,23,FOLLOW_23_in_ruleFamilie1096); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie1105); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:492:2: (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:494:6: lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:494:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )
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
                    new NoViableAltException("494:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:494:15: ( 'keyword' | RULE_STRING )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:494:15: ( 'keyword' | RULE_STRING )
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
                            new NoViableAltException("494:15: ( 'keyword' | RULE_STRING )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:494:16: 'keyword'
                            {
                            match(input,24,FOLLOW_24_in_ruleFamilie1129); 

                                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "name"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:499:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1144); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "name"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:504:6: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1159); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, "name"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", input.LT(-1), null, currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:522:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:525:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:531:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:532:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1196); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "mutter"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:537:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:540:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:546:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:547:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1225); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "vater"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:552:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:555:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:561:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:562:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1254); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:567:3: ( ',' ( ( RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:567:4: ',' ( ( RULE_ID ) )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleFamilie1269); 

            	            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:571:1: ( ( RULE_ID ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:574:3: ( RULE_ID )
            	    {

            	    			if (current==null) {
            	    	            current = factory.create("Familie");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:580:1: ( RULE_ID )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalReferenceGrammarTestLanguage.g:581:2: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1293); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
            	        

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleFamilie1309); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz140 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz173 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz195 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz233 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz277 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz322 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz367 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind466 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind475 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind530 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener631 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener640 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener662 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener695 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug796 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug805 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug827 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug873 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFarbe966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie1046 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFamilie1096 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie1105 = new BitSet(new long[]{0x0000000001000060L});
    public static final BitSet FOLLOW_24_in_ruleFamilie1129 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1144 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1159 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1196 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1225 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1254 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_ruleFamilie1269 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1293 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1309 = new BitSet(new long[]{0x0000000000000002L});

}