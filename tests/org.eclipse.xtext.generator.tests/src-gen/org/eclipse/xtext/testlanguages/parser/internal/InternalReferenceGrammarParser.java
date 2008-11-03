// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g 2008-11-03 16:11:08

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GRÜN'"
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g"; }


     
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:62:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:62:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:63:2: iv_ruleSpielplatz= ruleSpielplatz EOF
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:70:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse=null;
        Token lv_beschreibung=null;
        EObject lv_kinder = null;

        EObject lv_erzieher = null;

        EObject lv_spielzeuge = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:72:33: ( ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{'
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:5: ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )?
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:5: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:73:6: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz118); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:77:1: (lv_groesse= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:79:6: lv_groesse= RULE_INT
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

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:93:3: (lv_beschreibung= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:95:6: lv_beschreibung= RULE_STRING
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

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:2: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==14||LA3_0==17) ) {
                            alt3=1;
                        }
                        else if ( (LA3_0==18) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
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
                    	            new NoViableAltException("113:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 2, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:4: (lv_kinder= ruleKind )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:113:4: (lv_kinder= ruleKind )
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:116:6: lv_kinder= ruleKind
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz231);
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
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:131:6: (lv_erzieher= ruleErwachsener )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:131:6: (lv_erzieher= ruleErwachsener )
                    	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:134:6: lv_erzieher= ruleErwachsener
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz275);
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:149:6: (lv_spielzeuge= ruleSpielzeug )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:149:6: (lv_spielzeuge= ruleSpielzeug )
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:152:6: lv_spielzeuge= ruleSpielzeug
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz320);
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

                    match(input,13,FOLLOW_13_in_ruleSpielplatz336); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:177:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:177:46: (iv_ruleKind= ruleKind EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:178:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind374);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind384); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:185:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:187:33: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:4: ( 'kind' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:188:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind421); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleKind430); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:196:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:198:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind452); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:212:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:214:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind485); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "age", lv_age,"INT");
            	         

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind506); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:237:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:237:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:238:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener541);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener551); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:245:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:247:33: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:4: ( 'erwachsener' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:248:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener588); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener597); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:256:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:258:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener619); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:272:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:274:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener652); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "age", lv_age,"INT");
            	         

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener673); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:297:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:297:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:298:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug708);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug718); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:305:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:307:33: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:4: ( 'spielzeug' '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:308:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug755); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug764); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:316:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:318:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug786); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:332:3: (lv_farbe= ruleFarbe )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:335:6: lv_farbe= ruleFarbe
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug832);
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

            match(input,16,FOLLOW_16_in_ruleSpielzeug846); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:358:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:358:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:359:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe881);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe891); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:366:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:368:33: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:369:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:369:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=19 && LA7_0<=21)) ) {
                alt7=1;
            }
            else if ( (LA7_0==22) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("369:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:369:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:369:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==21) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("369:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:369:3: ( 'ROT' | 'BLAU' )
                            {
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:369:3: ( 'ROT' | 'BLAU' )
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==19) ) {
                                alt5=1;
                            }
                            else if ( (LA5_0==20) ) {
                                alt5=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("369:3: ( 'ROT' | 'BLAU' )", 5, 0, input);

                                throw nvae;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:369:4: 'ROT'
                                    {
                                    match(input,19,FOLLOW_19_in_ruleFarbe927); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:374:6: 'BLAU'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe942); 

                                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:379:6: 'GELB'
                            {
                            match(input,21,FOLLOW_21_in_ruleFarbe958); 

                                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.g:384:6: 'GRÜN'
                    {
                    match(input,22,FOLLOW_22_in_ruleFarbe974); 

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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz139 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz172 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz194 = new BitSet(new long[]{0x0000000000066000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz231 = new BitSet(new long[]{0x0000000000066000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz275 = new BitSet(new long[]{0x0000000000066000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz320 = new BitSet(new long[]{0x0000000000066000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind421 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind430 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind485 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener588 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener597 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener619 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener652 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug755 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug764 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug786 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug832 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFarbe927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe974 = new BitSet(new long[]{0x0000000000000002L});

}