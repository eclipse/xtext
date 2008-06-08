// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g 2008-06-08 11:15:28

package org.eclipse.xtext.reference.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GRÜN'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalReferenceGrammarParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g"; }


     
        public InternalReferenceGrammarParser(TokenStream input, IElementFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalReferenceGrammarParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.tokens");
        }



    // $ANTLR start internalParse
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:91:1: internalParse returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:91:46: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:92:3: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_internalParse78);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_internalParse88); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end internalParse


    // $ANTLR start ruleSpielplatz
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse=null;
        EObject lv_kinder = null;

        EObject lv_erzieher = null;

        EObject lv_spielzeuge = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:101:33: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:1: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:1: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:2: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:2: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:3: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:3: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:4: ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:4: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:102:5: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,12,FOLLOW_12_in_ruleSpielplatz117); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:107:1: (lv_groesse= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:108:5: lv_groesse= RULE_INT
                    {
                    lv_groesse=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz135); 
                     
                        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"groesse"); 
                        

                            if (current==null) {
                                current = factory.create("Spielplatz");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "groesse", lv_groesse,"INT");    

                    }


                    }

                    match(input,13,FOLLOW_13_in_ruleSpielplatz153); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:124:2: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==15||LA2_0==18) ) {
                            alt2=1;
                        }
                        else if ( (LA2_0==19) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:124:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:124:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	    int alt1=2;
                    	    int LA1_0 = input.LA(1);

                    	    if ( (LA1_0==15) ) {
                    	        alt1=1;
                    	    }
                    	    else if ( (LA1_0==18) ) {
                    	        alt1=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("124:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 1, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt1) {
                    	        case 1 :
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:124:4: (lv_kinder= ruleKind )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:124:4: (lv_kinder= ruleKind )
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:126:5: lv_kinder= ruleKind
                    	            {
                    	             
                    	                    currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                
                    	            pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz185);
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
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:138:6: (lv_erzieher= ruleErwachsener )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:138:6: (lv_erzieher= ruleErwachsener )
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:140:5: lv_erzieher= ruleErwachsener
                    	            {
                    	             
                    	                    currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                
                    	            pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz220);
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
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:152:6: (lv_spielzeuge= ruleSpielzeug )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:152:6: (lv_spielzeuge= ruleSpielzeug )
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:154:5: lv_spielzeuge= ruleSpielzeug
                    	    {
                    	     
                    	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	        
                    	    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz256);
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
                    	    break loop2;
                        }
                    } while (true);


                    }

                    match(input,14,FOLLOW_14_in_ruleSpielplatz269); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }
                    break;

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSpielplatz


    // $ANTLR start ruleKind
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:177:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:178:33: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:4: ( 'kind' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:5: 'kind' '('
            {
            match(input,15,FOLLOW_15_in_ruleKind310); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleKind320); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:190:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind339); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Kind");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name,"ID");    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:201:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:202:5: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind365); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
                

                    if (current==null) {
                        current = factory.create("Kind");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "age", lv_age,"INT");    

            }


            }

            match(input,17,FOLLOW_17_in_ruleKind383); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKind


    // $ANTLR start ruleErwachsener
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:223:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:224:33: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:4: ( 'erwachsener' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:225:5: 'erwachsener' '('
            {
            match(input,18,FOLLOW_18_in_ruleErwachsener421); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleErwachsener431); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:235:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:236:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener450); 
             
                createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Erwachsener");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name,"ID");    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:247:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:248:5: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener476); 
             
                createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
                

                    if (current==null) {
                        current = factory.create("Erwachsener");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "age", lv_age,"INT");    

            }


            }

            match(input,17,FOLLOW_17_in_ruleErwachsener494); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleErwachsener


    // $ANTLR start ruleSpielzeug
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:269:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:270:33: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:4: ( 'spielzeug' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:271:5: 'spielzeug' '('
            {
            match(input,19,FOLLOW_19_in_ruleSpielzeug532); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleSpielzeug542); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:281:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:282:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug561); 
             
                createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Spielzeug");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name,"ID");    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:293:3: (lv_farbe= ruleFarbe )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:295:5: lv_farbe= ruleFarbe
            {
             
                    currentNode=createCompositeNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug598);
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

            match(input,17,FOLLOW_17_in_ruleSpielzeug609); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSpielzeug


    // $ANTLR start ruleFarbe
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:316:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:317:33: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:318:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:318:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=20 && LA6_0<=22)) ) {
                alt6=1;
            }
            else if ( (LA6_0==23) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("318:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:318:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:318:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=20 && LA5_0<=21)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==22) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("318:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:318:3: ( 'ROT' | 'BLAU' )
                            {
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:318:3: ( 'ROT' | 'BLAU' )
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==20) ) {
                                alt4=1;
                            }
                            else if ( (LA4_0==21) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("318:3: ( 'ROT' | 'BLAU' )", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:318:4: 'ROT'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe646); 

                                            createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, currentNode,null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:324:6: 'BLAU'
                                    {
                                    match(input,21,FOLLOW_21_in_ruleFarbe662); 

                                            createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:330:6: 'GELB'
                            {
                            match(input,22,FOLLOW_22_in_ruleFarbe679); 

                                    createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:336:6: 'GRÜN'
                    {
                    match(input,23,FOLLOW_23_in_ruleFarbe696); 

                            createLeafNode("//@parserRules.5/@alternatives/@groups.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }
                    break;

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFarbe


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_internalParse78 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz135 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz153 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz185 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz220 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz256 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_14_in_ruleSpielplatz269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleKind310 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind320 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind365 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKind383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleErwachsener421 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener431 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener450 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener476 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSpielzeug532 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug542 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug561 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug598 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSpielzeug609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe696 = new BitSet(new long[]{0x0000000000000002L});

}