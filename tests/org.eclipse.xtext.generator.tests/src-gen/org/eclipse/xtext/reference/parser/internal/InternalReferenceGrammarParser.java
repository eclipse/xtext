// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g 2008-06-03 16:38:30

package org.eclipse.xtext.reference.parser.internal; 

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
        
        protected void setLexerRule(LeafNode node, Token t) {
        /*    LexerRule lexerRule = ReferenceGrammarTokenTypeResolver.getLexerRule(node, t.getType());
            if(lexerRule != null) {
                node.setGrammarElement(lexerRule);
            }*/
        }



    // $ANTLR start internalParse
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:89:1: internalParse returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:90:3: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:90:3: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_internalParse76);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_internalParse86); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:98:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? ;
    public EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse=null;
        EObject lv_kinder = null;

        EObject lv_erzieher = null;

        EObject lv_spielzeuge = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )? )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:1: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:1: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:2: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:2: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )* )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:3: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' ) ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:3: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{' )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:4: ( 'spielplatz' (lv_groesse= RULE_INT ) ) '{'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:4: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:100:5: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,12,FOLLOW_12_in_ruleSpielplatz115); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:105:1: (lv_groesse= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:106:5: lv_groesse= RULE_INT
                    {
                    lv_groesse=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz133); 
                     
                        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"groesse"); 
                        

                            if (current==null) {
                                current = factory.create("Spielplatz");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "groesse", lv_groesse);    

                    }


                    }

                    match(input,13,FOLLOW_13_in_ruleSpielplatz151); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:122:2: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:122:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:122:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
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
                    	            new NoViableAltException("122:3: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 1, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt1) {
                    	        case 1 :
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:122:4: (lv_kinder= ruleKind )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:122:4: (lv_kinder= ruleKind )
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:124:5: lv_kinder= ruleKind
                    	            {
                    	             
                    	                    currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                
                    	            pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz183);
                    	            lv_kinder=ruleKind();
                    	            _fsp--;


                    	                    currentNode = currentNode.getParent();
                    	                    if (current==null) {
                    	                        current = factory.create("Spielplatz");
                    	                        associateNodeWithAstElement(currentNode, current);
                    	                    }
                    	                    factory.add(current, "kinder", lv_kinder);    

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:136:6: (lv_erzieher= ruleErwachsener )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:136:6: (lv_erzieher= ruleErwachsener )
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:138:5: lv_erzieher= ruleErwachsener
                    	            {
                    	             
                    	                    currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                
                    	            pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz218);
                    	            lv_erzieher=ruleErwachsener();
                    	            _fsp--;


                    	                    currentNode = currentNode.getParent();
                    	                    if (current==null) {
                    	                        current = factory.create("Spielplatz");
                    	                        associateNodeWithAstElement(currentNode, current);
                    	                    }
                    	                    factory.add(current, "erzieher", lv_erzieher);    

                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:150:6: (lv_spielzeuge= ruleSpielzeug )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:150:6: (lv_spielzeuge= ruleSpielzeug )
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:152:5: lv_spielzeuge= ruleSpielzeug
                    	    {
                    	     
                    	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	        
                    	    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz254);
                    	    lv_spielzeuge=ruleSpielzeug();
                    	    _fsp--;


                    	            currentNode = currentNode.getParent();
                    	            if (current==null) {
                    	                current = factory.create("Spielplatz");
                    	                associateNodeWithAstElement(currentNode, current);
                    	            }
                    	            factory.add(current, "spielzeuge", lv_spielzeuge);    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }

                    match(input,14,FOLLOW_14_in_ruleSpielplatz267); 

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


    // $ANTLR start rulePerson
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:172:1: rulePerson returns [EObject current=null] : (this_Kind= ruleKind | this_Erwachsener= ruleErwachsener ) ;
    public EObject rulePerson() throws RecognitionException {
        EObject current = null;

        EObject this_Kind = null;

        EObject this_Erwachsener = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:174:1: ( (this_Kind= ruleKind | this_Erwachsener= ruleErwachsener ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:174:1: (this_Kind= ruleKind | this_Erwachsener= ruleErwachsener )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:174:1: (this_Kind= ruleKind | this_Erwachsener= ruleErwachsener )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("174:1: (this_Kind= ruleKind | this_Erwachsener= ruleErwachsener )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:174:2: this_Kind= ruleKind
                    {
                    pushFollow(FOLLOW_ruleKind_in_rulePerson304);
                    this_Kind=ruleKind();
                    _fsp--;

                     
                            current = this_Kind; 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:179:6: this_Erwachsener= ruleErwachsener
                    {
                    pushFollow(FOLLOW_ruleErwachsener_in_rulePerson320);
                    this_Erwachsener=ruleErwachsener();
                    _fsp--;

                     
                            current = this_Erwachsener; 
                        

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
    // $ANTLR end rulePerson


    // $ANTLR start ruleKind
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:187:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:1: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:4: ( 'kind' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:189:5: 'kind' '('
            {
            match(input,15,FOLLOW_15_in_ruleKind355); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleKind365); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:199:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:200:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind384); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Kind");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:211:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:212:5: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind410); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
                

                    if (current==null) {
                        current = factory.create("Kind");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "age", lv_age);    

            }


            }

            match(input,17,FOLLOW_17_in_ruleKind428); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:232:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:1: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:4: ( 'erwachsener' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:234:5: 'erwachsener' '('
            {
            match(input,18,FOLLOW_18_in_ruleErwachsener465); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleErwachsener475); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:244:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:245:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener494); 
             
                createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Erwachsener");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:256:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:257:5: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener520); 
             
                createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
                

                    if (current==null) {
                        current = factory.create("Erwachsener");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "age", lv_age);    

            }


            }

            match(input,17,FOLLOW_17_in_ruleErwachsener538); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:277:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:1: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:4: ( 'spielzeug' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:279:5: 'spielzeug' '('
            {
            match(input,19,FOLLOW_19_in_ruleSpielzeug575); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,16,FOLLOW_16_in_ruleSpielzeug585); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:289:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:290:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug604); 
             
                createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Spielzeug");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:301:3: (lv_farbe= ruleFarbe )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:303:5: lv_farbe= ruleFarbe
            {
             
                    currentNode=createCompositeNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug641);
            lv_farbe=ruleFarbe();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Spielzeug");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "farbe", lv_farbe);    

            }


            }

            match(input,17,FOLLOW_17_in_ruleSpielzeug652); 

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
    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:323:1: ruleFarbe returns [EObject current=null] : ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ;
    public EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:1: ( ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
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
                    new NoViableAltException("325:1: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
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
                            new NoViableAltException("325:2: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:3: ( 'ROT' | 'BLAU' )
                            {
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:3: ( 'ROT' | 'BLAU' )
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
                                    new NoViableAltException("325:3: ( 'ROT' | 'BLAU' )", 5, 0, input);

                                throw nvae;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:325:4: 'ROT'
                                    {
                                    match(input,20,FOLLOW_20_in_ruleFarbe688); 

                                            createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, currentNode,null); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:331:6: 'BLAU'
                                    {
                                    match(input,21,FOLLOW_21_in_ruleFarbe704); 

                                            createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:337:6: 'GELB'
                            {
                            match(input,22,FOLLOW_22_in_ruleFarbe721); 

                                    createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g:343:6: 'GRÜN'
                    {
                    match(input,23,FOLLOW_23_in_ruleFarbe738); 

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


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_internalParse76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz133 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz151 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz183 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz218 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz254 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_14_in_ruleSpielplatz267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_rulePerson304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_rulePerson320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleKind355 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind384 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind410 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKind428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleErwachsener465 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener475 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener520 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSpielzeug575 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug585 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug604 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug641 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSpielzeug652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFarbe688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFarbe704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe738 = new BitSet(new long[]{0x0000000000000002L});

}