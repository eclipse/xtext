// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g 2008-11-04 08:49:09

package org.eclipse.xtext.reference.parser.internal; 

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'familie'", "'keyword'", "','", "'ROT'", "'BLAU'", "'GELB'", "'GRÜN'", "'type'"
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g"; }


     
        public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalReferenceGrammarParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	} 



    // $ANTLR start entryRuleSpielplatz
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:62:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:63:2: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:63:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:70:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )? ;
    public EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse=null;
        Token lv_beschreibung=null;
        EObject lv_kinder = null;

        EObject lv_erzieher = null;

        EObject lv_spielzeuge = null;

        EObject lv_familie = null;

        EObject lv_types = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:1: ( ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )? )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:5: ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )?
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:5: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:73:6: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz118); 

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:77:1: (lv_groesse= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:79:6: lv_groesse= RULE_INT
                    {
                    lv_groesse=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz139); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "groesse"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Spielplatz");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "groesse", lv_groesse,"INT");
                    	         

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:93:3: (lv_beschreibung= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:95:6: lv_beschreibung= RULE_STRING
                            {
                            lv_beschreibung=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz172); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "beschreibung"); 
                                

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

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:2: ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==14||(LA5_0>=17 && LA5_0<=19)) ) {
                            alt5=1;
                        }
                        else if ( (LA5_0==26) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:3: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:3: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==14||(LA4_0>=17 && LA4_0<=18)) ) {
                    	        alt4=1;
                    	    }
                    	    else if ( (LA4_0==19) ) {
                    	        alt4=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("113:3: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )", 4, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:4: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:4: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
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
                    	                    new NoViableAltException("113:4: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )", 3, 0, input);

                    	                throw nvae;
                    	            }
                    	            switch (alt3) {
                    	                case 1 :
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:5: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	                    {
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:5: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
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
                    	                            new NoViableAltException("113:5: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 2, 0, input);

                    	                        throw nvae;
                    	                    }
                    	                    switch (alt2) {
                    	                        case 1 :
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:6: (lv_kinder= ruleKind )
                    	                            {
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:113:6: (lv_kinder= ruleKind )
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:116:6: lv_kinder= ruleKind
                    	                            {
                    	                             
                    	                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                            	    
                    	                            pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz233);
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
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:131:6: (lv_erzieher= ruleErwachsener )
                    	                            {
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:131:6: (lv_erzieher= ruleErwachsener )
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:134:6: lv_erzieher= ruleErwachsener
                    	                            {
                    	                             
                    	                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                            	    
                    	                            pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz277);
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
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:149:6: (lv_spielzeuge= ruleSpielzeug )
                    	                    {
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:149:6: (lv_spielzeuge= ruleSpielzeug )
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:152:6: lv_spielzeuge= ruleSpielzeug
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz322);
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
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:167:6: (lv_familie= ruleFamilie )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:167:6: (lv_familie= ruleFamilie )
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:170:6: lv_familie= ruleFamilie
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz367);
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

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:185:6: (lv_types= ruleCustomTypeParserRule )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:185:6: (lv_types= ruleCustomTypeParserRule )
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:188:6: lv_types= ruleCustomTypeParserRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz412);
                    	    lv_types=ruleCustomTypeParserRule();
                    	    _fsp--;


                    	    	        currentNode = currentNode.getParent();
                    	    	        if (current==null) {
                    	    	            current = factory.create("Spielplatz");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        factory.add(current, "types", lv_types,null);
                    	    	         

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }

                    match(input,13,FOLLOW_13_in_ruleSpielplatz428); 

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:213:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:214:2: (iv_ruleKind= ruleKind EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:214:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind466);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind476); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:221:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:1: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:4: ( 'kind' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind513); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleKind522); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:232:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind544); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:248:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:250:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind577); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "age", lv_age,"INT");
            	         

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind598); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:273:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:274:2: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:274:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener633);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener643); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:281:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:1: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:4: ( 'erwachsener' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:284:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener680); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener689); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:292:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:294:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener711); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:308:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:310:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener744); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "age", lv_age,"INT");
            	         

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener765); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:333:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:334:2: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:334:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug800);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug810); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:341:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:1: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:4: ( 'spielzeug' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:344:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug847); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug856); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:352:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:354:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug878); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:368:3: (lv_farbe= ruleFarbe )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:371:6: lv_farbe= ruleFarbe
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug924);
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

            match(input,16,FOLLOW_16_in_ruleSpielzeug938); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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


    // $ANTLR start entryRuleFamilie
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:394:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:395:2: (iv_ruleFamilie= ruleFamilie EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:395:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie973);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie983); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:402:1: ruleFamilie returns [EObject current=null] : ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) ;
    public EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:1: ( ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )*
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:7: ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:7: ( 'familie' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:405:8: 'familie' '('
            {
            match(input,19,FOLLOW_19_in_ruleFamilie1023); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie1032); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:413:2: (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:415:6: lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:415:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("415:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:415:15: ( 'keyword' | RULE_STRING )
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:415:15: ( 'keyword' | RULE_STRING )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==20) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==RULE_STRING) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("415:15: ( 'keyword' | RULE_STRING )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:415:16: 'keyword'
                            {
                            match(input,20,FOLLOW_20_in_ruleFamilie1056); 

                                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "name"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:420:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1071); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "name"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:425:6: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1086); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, "name"); 
                        

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

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:439:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:442:1: ( RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:442:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:443:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1119); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "mutter"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:448:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:451:1: ( RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:451:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:452:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1144); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "vater"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:457:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:460:1: ( RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:460:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:461:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1169); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:466:3: ( ',' ( ( RULE_ID ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:466:4: ',' ( ( RULE_ID ) )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleFamilie1184); 

            	            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:470:1: ( ( RULE_ID ) )
            	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:473:1: ( RULE_ID )
            	    {
            	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:473:1: ( RULE_ID )
            	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:474:2: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1204); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
            	        

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleFamilie1220); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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


    // $ANTLR start entryRuleFarbe
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:488:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:489:2: (iv_ruleFarbe= ruleFarbe EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:489:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe1255);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe1265); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:496:1: ruleFarbe returns [EObject current=null] : (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ) ;
    public EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:499:1: ( (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:499:1: (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:499:1: (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:501:6: lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:501:14: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=22 && LA12_0<=24)) ) {
                alt12=1;
            }
            else if ( (LA12_0==25) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("501:14: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:501:15: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:501:15: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=22 && LA11_0<=23)) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==24) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("501:15: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:501:16: ( 'ROT' | 'BLAU' )
                            {
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:501:16: ( 'ROT' | 'BLAU' )
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0==22) ) {
                                alt10=1;
                            }
                            else if ( (LA10_0==23) ) {
                                alt10=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("501:16: ( 'ROT' | 'BLAU' )", 10, 0, input);

                                throw nvae;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:501:17: 'ROT'
                                    {
                                    match(input,22,FOLLOW_22_in_ruleFarbe1313); 

                                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, "wert"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:506:6: 'BLAU'
                                    {
                                    match(input,23,FOLLOW_23_in_ruleFarbe1328); 

                                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, "wert"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:511:6: 'GELB'
                            {
                            match(input,24,FOLLOW_24_in_ruleFarbe1344); 

                                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "wert"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:516:6: 'GRÜN'
                    {
                    match(input,25,FOLLOW_25_in_ruleFarbe1360); 

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.1" /* xtext::Keyword */, "wert"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Farbe");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "wert", input.LT(-1),null);
            	         

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


    // $ANTLR start entryRuleCustomTypeParserRule
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:535:1: entryRuleCustomTypeParserRule returns [EObject current=null] : iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF ;
    public EObject entryRuleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomTypeParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:536:2: (iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:536:2: iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1407);
            iv_ruleCustomTypeParserRule=ruleCustomTypeParserRule();
            _fsp--;

             current =iv_ruleCustomTypeParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomTypeParserRule1417); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:543:1: ruleCustomTypeParserRule returns [EObject current=null] : ( 'type' (lv_name= RULE_ID ) ) ;
    public EObject ruleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:546:1: ( ( 'type' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:546:1: ( 'type' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:546:1: ( 'type' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:546:2: 'type' (lv_name= RULE_ID )
            {
            match(input,26,FOLLOW_26_in_ruleCustomTypeParserRule1451); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:550:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:552:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1472); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ReferenceModel::CustomType");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


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
    // $ANTLR end ruleCustomTypeParserRule


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz139 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz172 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz194 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz233 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz277 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz322 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz367 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz412 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind466 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind513 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind522 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind577 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener680 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener689 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener744 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug847 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug856 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug878 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug924 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFamilie1023 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie1032 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_20_in_ruleFamilie1056 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1071 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1086 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1119 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1144 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1169 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_21_in_ruleFamilie1184 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1204 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe1255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFarbe1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFarbe1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomTypeParserRule1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleCustomTypeParserRule1451 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1472 = new BitSet(new long[]{0x0000000000000002L});

}