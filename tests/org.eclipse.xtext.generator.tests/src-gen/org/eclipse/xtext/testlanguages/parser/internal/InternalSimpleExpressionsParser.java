// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g 2008-05-27 16:32:45

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.testlanguages.parser.internal.SimpleExpressionsTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleExpressionsParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "RULE_INT", "RULE_ML_COMMENT", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int RULE_INT=8;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=6;
    public static final int RULE_LEXER_BODY=10;

        public InternalSimpleExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g"; }


     
        public InternalSimpleExpressionsParser(TokenStream input, IElementFactory factory) {
            this(input);
            this.factory = factory;
    		grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/SimpleExpressions").getGrammar();
        }
        
        protected void setLexerRule(LeafNode node, Token t) {
            LexerRule lexerRule = SimpleExpressionsTokenTypeResolver.getLexerRule(node, t.getType());
            if(lexerRule != null) {
                node.setGrammarElement(lexerRule);
            }
        }




    // $ANTLR start internalParse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:91:1: internalParse returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:92:3: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:92:3: iv_ruleMultiplication= ruleMultiplication EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleMultiplication_in_internalParse76);
            iv_ruleMultiplication=ruleMultiplication();
            _fsp--;

             current =iv_ruleMultiplication; 
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


    // $ANTLR start ruleMultiplication
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:100:1: ruleMultiplication returns [EObject current=null] : (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* ) ;
    public EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Addition = null;

        EObject lv_values = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:102:1: ( (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:102:1: (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:102:1: (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:102:2: this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )*
            {
            pushFollow(FOLLOW_ruleAddition_in_ruleMultiplication114);
            this_Addition=ruleAddition();
            _fsp--;

             
                    current = this_Addition; 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:106:1: ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:106:2: ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:106:2: ( () (lv_operator= ( '+' | '-' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:106:3: () (lv_operator= ( '+' | '-' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:106:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:107:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            factory.add(temp, "values",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:117:2: (lv_operator= ( '+' | '-' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:118:5: lv_operator= ( '+' | '-' )
            	    {
            	    lv_operator=(Token)input.LT(1);
            	    if ( (input.LA(1)>=12 && input.LA(1)<=13) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleMultiplication141);    throw mse;
            	    }


            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.set(current, "operator", lv_operator);        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:128:3: (lv_values= ruleAddition )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:130:5: lv_values= ruleAddition
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAddition_in_ruleMultiplication184);
            	    lv_values=ruleAddition();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "values", lv_values);    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end ruleMultiplication


    // $ANTLR start ruleAddition
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:145:1: ruleAddition returns [EObject current=null] : (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) ;
    public EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:147:1: ( (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:147:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:147:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:147:2: this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            {
            pushFollow(FOLLOW_ruleTerm_in_ruleAddition222);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:151:1: ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=14 && LA2_0<=15)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:151:2: ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:151:2: ( () (lv_operator= ( '*' | '/' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:151:3: () (lv_operator= ( '*' | '/' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:151:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:152:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            factory.add(temp, "values",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:162:2: (lv_operator= ( '*' | '/' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:163:5: lv_operator= ( '*' | '/' )
            	    {
            	    lv_operator=(Token)input.LT(1);
            	    if ( (input.LA(1)>=14 && input.LA(1)<=15) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAddition249);    throw mse;
            	    }


            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.set(current, "operator", lv_operator);        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:173:3: (lv_values= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:175:5: lv_values= ruleTerm
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleTerm_in_ruleAddition292);
            	    lv_values=ruleTerm();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "values", lv_values);    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end ruleAddition


    // $ANTLR start ruleTerm
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:190:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:192:1: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:192:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:192:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("192:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:192:2: this_Atom= ruleAtom
                    {
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm330);
                    this_Atom=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom; 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:197:6: this_Parens= ruleParens
                    {
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm346);
                    this_Parens=ruleParens();
                    _fsp--;

                     
                            current = this_Parens; 
                        

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
    // $ANTLR end ruleTerm


    // $ANTLR start ruleAtom
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:205:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:207:1: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:207:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:207:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:208:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom385); 
             
                createLeafNode("//@parserRules.3/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Atom");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

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
    // $ANTLR end ruleAtom


    // $ANTLR start ruleParens
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:223:1: ruleParens returns [EObject current=null] : ( ( '(' this_Multiplication= ruleMultiplication ) ')' ) ;
    public EObject ruleParens() throws RecognitionException {
        EObject current = null;

        EObject this_Multiplication = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:225:1: ( ( ( '(' this_Multiplication= ruleMultiplication ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:225:1: ( ( '(' this_Multiplication= ruleMultiplication ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:225:1: ( ( '(' this_Multiplication= ruleMultiplication ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:225:2: ( '(' this_Multiplication= ruleMultiplication ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:225:2: ( '(' this_Multiplication= ruleMultiplication )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:225:3: '(' this_Multiplication= ruleMultiplication
            {
            match(input,16,FOLLOW_16_in_ruleParens426); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleParens438);
            this_Multiplication=ruleMultiplication();
            _fsp--;

             
                    current = this_Multiplication; 
                

            }

            match(input,17,FOLLOW_17_in_ruleParens447); 

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
    // $ANTLR end ruleParens


 

    public static final BitSet FOLLOW_ruleMultiplication_in_internalParse76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleMultiplication114 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_set_in_ruleMultiplication141 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleMultiplication184 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleAddition222 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_set_in_ruleAddition249 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleAddition292 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleParens426 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleParens438 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParens447 = new BitSet(new long[]{0x0000000000000002L});

}