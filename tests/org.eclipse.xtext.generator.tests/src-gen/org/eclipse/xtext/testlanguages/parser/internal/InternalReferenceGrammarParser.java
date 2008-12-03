// $ANTLR 3.0.1 ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g 2008-12-03 11:41:01

package org.eclipse.xtext.testlanguages.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarParser extends AbstractAntlrParser {
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

        public InternalReferenceGrammarParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g"; }


     
        public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalReferenceGrammarParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	} 



    // $ANTLR start entryRuleSpielplatz
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:62:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:62:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:63:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz70);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielplatz80); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:70:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )? ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:72:33: ( ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:5: ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:5: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:6: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz118); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:77:1: (lv_groesse= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:79:6: lv_groesse= RULE_INT
                    {
                    lv_groesse=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz139); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "groesse"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Spielplatz");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "groesse", lv_groesse,"INT");
                    	         

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:93:3: (lv_beschreibung= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:95:6: lv_beschreibung= RULE_STRING
                            {
                            lv_beschreibung=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz172); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "beschreibung"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("Spielplatz");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        factory.set(current, "beschreibung", lv_beschreibung,"STRING");
                            	         

                            }
                            break;

                    }


                    }

                    match(input,12,FOLLOW_12_in_ruleSpielplatz194); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:2: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )*
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:3: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:3: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
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
                    	            new NoViableAltException("113:3: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )", 3, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:4: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	            {
                    	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:4: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
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
                    	                    new NoViableAltException("113:4: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 2, 0, input);

                    	                throw nvae;
                    	            }
                    	            switch (alt2) {
                    	                case 1 :
                    	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:5: (lv_kinder= ruleKind )
                    	                    {
                    	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:5: (lv_kinder= ruleKind )
                    	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:116:6: lv_kinder= ruleKind
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz232);
                    	                    lv_kinder=ruleKind();
                    	                    _fsp--;


                    	                    	        currentNode = currentNode.getParent();
                    	                    	        if (current==null) {
                    	                    	            current = factory.create("Spielplatz");
                    	                    	            associateNodeWithAstElement(currentNode, current);
                    	                    	        }
                    	                    	        
                    	                    	        factory.add(current, "kinder", lv_kinder,null);
                    	                    	         

                    	                    }


                    	                    }
                    	                    break;
                    	                case 2 :
                    	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:131:6: (lv_erzieher= ruleErwachsener )
                    	                    {
                    	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:131:6: (lv_erzieher= ruleErwachsener )
                    	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:134:6: lv_erzieher= ruleErwachsener
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz276);
                    	                    lv_erzieher=ruleErwachsener();
                    	                    _fsp--;


                    	                    	        currentNode = currentNode.getParent();
                    	                    	        if (current==null) {
                    	                    	            current = factory.create("Spielplatz");
                    	                    	            associateNodeWithAstElement(currentNode, current);
                    	                    	        }
                    	                    	        
                    	                    	        factory.add(current, "erzieher", lv_erzieher,null);
                    	                    	         

                    	                    }


                    	                    }
                    	                    break;

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:149:6: (lv_spielzeuge= ruleSpielzeug )
                    	            {
                    	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:149:6: (lv_spielzeuge= ruleSpielzeug )
                    	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:152:6: lv_spielzeuge= ruleSpielzeug
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz321);
                    	            lv_spielzeuge=ruleSpielzeug();
                    	            _fsp--;


                    	            	        currentNode = currentNode.getParent();
                    	            	        if (current==null) {
                    	            	            current = factory.create("Spielplatz");
                    	            	            associateNodeWithAstElement(currentNode, current);
                    	            	        }
                    	            	        
                    	            	        factory.add(current, "spielzeuge", lv_spielzeuge,null);
                    	            	         

                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:167:6: (lv_familie= ruleFamilie )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:167:6: (lv_familie= ruleFamilie )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:170:6: lv_familie= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz366);
                    	    lv_familie=ruleFamilie();
                    	    _fsp--;


                    	    	        currentNode = currentNode.getParent();
                    	    	        if (current==null) {
                    	    	            current = factory.create("Spielplatz");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        factory.add(current, "familie", lv_familie,null);
                    	    	         

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }

                    match(input,13,FOLLOW_13_in_ruleSpielplatz382); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:195:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:195:46: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:196:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind420);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind430); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:203:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:205:33: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:4: ( 'kind' '(' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:206:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind467); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleKind476); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:214:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:216:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind498); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:230:3: (lv_age= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:232:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind531); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "age", lv_age,"INT");
            	         

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind552); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:255:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:255:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:256:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener587);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener597); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:265:33: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:4: ( 'erwachsener' '(' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:266:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener634); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener643); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:274:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:276:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener665); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:290:3: (lv_age= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:292:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener698); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "age", lv_age,"INT");
            	         

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener719); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:315:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:315:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:316:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug754);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug764); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:323:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:325:33: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:4: ( 'spielzeug' '(' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:326:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug801); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug810); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:334:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:336:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug832); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:350:3: (lv_farbe= ruleFarbe )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:353:6: lv_farbe= ruleFarbe
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug878);
            lv_farbe=ruleFarbe();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "farbe", lv_farbe,null);
            	         

            }


            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug892); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:376:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:376:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:377:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe927);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe937); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:384:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:386:33: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:387:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:387:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
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
                    new NoViableAltException("387:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:387:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:387:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
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
                            new NoViableAltException("387:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:387:3: ( 'ROT' | 'BLAU' )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:387:3: ( 'ROT' | 'BLAU' )
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
                                    new NoViableAltException("387:3: ( 'ROT' | 'BLAU' )", 6, 0, input);

                                throw nvae;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:387:4: 'ROT'
                                    {
                                    match(input,19,FOLLOW_19_in_ruleFarbe973); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:392:6: 'BLAU'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe988); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:397:6: 'GELB'
                            {
                            match(input,21,FOLLOW_21_in_ruleFarbe1004); 

                                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:402:6: 'GRÜN'
                    {
                    match(input,22,FOLLOW_22_in_ruleFarbe1020); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.1" /* xtext::Keyword */, null); 
                        

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:411:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:411:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:412:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie1055);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie1065); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:419:1: ruleFamilie returns [EObject current=null] : ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:421:33: ( ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:7: ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:7: ( 'familie' '(' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:422:8: 'familie' '('
            {
            match(input,23,FOLLOW_23_in_ruleFamilie1105); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie1114); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:430:2: (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:432:6: lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:432:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )
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
                    new NoViableAltException("432:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:432:15: ( 'keyword' | RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:432:15: ( 'keyword' | RULE_STRING )
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
                            new NoViableAltException("432:15: ( 'keyword' | RULE_STRING )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:432:16: 'keyword'
                            {
                            match(input,24,FOLLOW_24_in_ruleFamilie1138); 

                                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "name"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:437:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1153); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "name"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:442:6: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1168); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, "name"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", input.LT(-1),null);
            	         

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:456:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:459:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:465:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:466:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1205); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "mutter"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:471:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:474:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:480:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:481:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1234); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "vater"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:486:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:489:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:495:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:496:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1263); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:501:3: ( ',' ( ( RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:501:4: ',' ( ( RULE_ID ) )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleFamilie1278); 

            	            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:505:1: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:508:3: ( RULE_ID )
            	    {

            	    			if (current==null) {
            	    	            current = factory.create("Familie");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:514:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:515:2: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1302); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
            	        

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleFamilie1318); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz139 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz172 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz194 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz232 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz276 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz321 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz366 = new BitSet(new long[]{0x0000000000866000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind467 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind476 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind531 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener634 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener643 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener698 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug801 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug810 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug832 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug878 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFarbe973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie1055 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFamilie1105 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie1114 = new BitSet(new long[]{0x0000000001000060L});
    public static final BitSet FOLLOW_24_in_ruleFamilie1138 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1153 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1168 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1205 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1234 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1263 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_ruleFamilie1278 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1302 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1318 = new BitSet(new long[]{0x0000000000000002L});

}