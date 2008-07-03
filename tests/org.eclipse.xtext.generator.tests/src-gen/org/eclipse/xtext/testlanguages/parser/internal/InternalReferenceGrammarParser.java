// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g 2008-07-03 10:53:25

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GRÜN'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalReferenceGrammarParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g"; }


     
        public InternalReferenceGrammarParser(TokenStream input, IElementFactory factory, Grammar g) {
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:99:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:99:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:100:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz80);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielplatz90); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:107:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse=null;
        Token lv_beschreibung=null;
        EObject lv_kinder = null;

        EObject lv_erzieher = null;

        EObject lv_spielzeuge = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:109:33: ( ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{'
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:5: ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )?
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:5: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:110:6: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,12,FOLLOW_12_in_ruleSpielplatz128); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:115:1: (lv_groesse= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:116:5: lv_groesse= RULE_INT
                    {
                    lv_groesse=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz146); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"groesse"); 
                        

                            if (current==null) {
                                current = factory.create("Spielplatz");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "groesse", lv_groesse,"INT");    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:127:3: (lv_beschreibung= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:128:5: lv_beschreibung= RULE_STRING
                            {
                            lv_beschreibung=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz172); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"beschreibung"); 
                                

                                    if (current==null) {
                                        current = factory.create("Spielplatz");
                                        associateNodeWithAstElement(currentNode, current);
                                    }
                                    factory.set(current, "beschreibung", lv_beschreibung,"STRING");    

                            }
                            break;

                    }


                    }

                    match(input,13,FOLLOW_13_in_ruleSpielplatz191); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:144:2: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15||LA3_0==18) ) {
                            alt3=1;
                        }
                        else if ( (LA3_0==19) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:144:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:144:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==15) ) {
                    	        alt2=1;
                    	    }
                    	    else if ( (LA2_0==18) ) {
                    	        alt2=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("144:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 2, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:144:4: (lv_kinder= ruleKind )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:144:4: (lv_kinder= ruleKind )
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:146:5: lv_kinder= ruleKind
                    	            {
                    	             
                    	                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                
                    	            pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz223);
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
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:158:6: (lv_erzieher= ruleErwachsener )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:158:6: (lv_erzieher= ruleErwachsener )
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:160:5: lv_erzieher= ruleErwachsener
                    	            {
                    	             
                    	                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                
                    	            pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz258);
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:172:6: (lv_spielzeuge= ruleSpielzeug )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:172:6: (lv_spielzeuge= ruleSpielzeug )
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:174:5: lv_spielzeuge= ruleSpielzeug
                    	    {
                    	     
                    	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	        
                    	    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz294);
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

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }

                    match(input,14,FOLLOW_14_in_ruleSpielplatz307); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:197:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:197:46: (iv_ruleKind= ruleKind EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:198:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind346);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind356); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:205:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:207:33: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:4: ( 'kind' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:208:5: 'kind' '('
            {
            match(input,15,FOLLOW_15_in_ruleKind393); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleKind403); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:218:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:219:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind422); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Kind");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name,"ID");    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:230:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:231:5: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind448); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
                

                    if (current==null) {
                        current = factory.create("Kind");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "age", lv_age,"INT");    

            }


            }

            match(input,17,FOLLOW_17_in_ruleKind466); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:252:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:252:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:253:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener502);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener512); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:260:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:262:33: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:4: ( 'erwachsener' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:263:5: 'erwachsener' '('
            {
            match(input,18,FOLLOW_18_in_ruleErwachsener549); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleErwachsener559); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:273:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:274:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener578); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Erwachsener");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name,"ID");    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:285:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:286:5: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener604); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
                

                    if (current==null) {
                        current = factory.create("Erwachsener");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "age", lv_age,"INT");    

            }


            }

            match(input,17,FOLLOW_17_in_ruleErwachsener622); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:307:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:307:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug658);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug668); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:315:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:317:33: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:4: ( 'spielzeug' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:5: 'spielzeug' '('
            {
            match(input,19,FOLLOW_19_in_ruleSpielzeug705); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleSpielzeug715); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:328:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:329:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug734); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Spielzeug");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name,"ID");    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:340:3: (lv_farbe= ruleFarbe )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:342:5: lv_farbe= ruleFarbe
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug771);
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

            match(input,17,FOLLOW_17_in_ruleSpielzeug782); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:363:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:363:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:364:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe818);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe828); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:371:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:373:33: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=20 && LA7_0<=22)) ) {
                alt7=1;
            }
            else if ( (LA7_0==23) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("374:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=20 && LA6_0<=21)) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==22) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("374:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:3: ( 'ROT' | 'BLAU' )
                            {
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:3: ( 'ROT' | 'BLAU' )
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            else if ( (LA5_0==21) ) {
                                alt5=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("374:3: ( 'ROT' | 'BLAU' )", 5, 0, input);

                                throw nvae;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:4: 'ROT'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe864); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, currentNode,null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:380:6: 'BLAU'
                                    {
                                    match(input,21,FOLLOW_21_in_ruleFarbe880); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:386:6: 'GELB'
                            {
                            match(input,22,FOLLOW_22_in_ruleFarbe897); 

                                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:392:6: 'GRÜN'
                    {
                    match(input,23,FOLLOW_23_in_ruleFarbe914); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.1" /* xtext::Keyword */, currentNode,null); 
                        

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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz80 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz146 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz172 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz191 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz223 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz258 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz294 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_14_in_ruleSpielplatz307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleKind393 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind403 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind448 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKind466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleErwachsener549 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener559 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener578 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener604 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSpielzeug705 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug715 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug734 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug771 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSpielzeug782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe818 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe914 = new BitSet(new long[]{0x0000000000000002L});

}