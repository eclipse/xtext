// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g 2008-05-20 13:34:20

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.internal.SimpleExpressionsTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleExpressionsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_INT", "RULE_ML_COMMENT", "RULE_LEXER_BODY", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_LEXER_BODY=8;

        public InternalSimpleExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g"; }



    private IElementFactory factory;
    public InternalSimpleExpressionsParser(TokenStream input, IElementFactory factory) {
        this(input);
        this.factory = factory;
    }

    public CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
        CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
        if (parentNode!=null) parentNode.getChildren().add(compositeNode);
        compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
        return compositeNode;
    }

    public Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
        Token token = input.LT(-1);
        Token tokenBefore = input.LT(-2);
        int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
        if (indexOfTokenBefore+1<token.getTokenIndex()) {
            for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
                Token hidden = input.get(x);
                LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                leafNode.setText(hidden.getText());
                leafNode.setHidden(true);
    		    setLexerRule(leafNode, hidden);
                parentNode.getChildren().add(leafNode);
            }
        }
        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
            leafNode.setText(token.getText());
        leafNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
        leafNode.setFeature(feature);
        parentNode.getChildren().add(leafNode);
        return leafNode;
    }

    private void appendTrailingHiddenTokens(CompositeNode parentNode) {
        Token tokenBefore = input.LT(-1);
        int size = input.size();
        if (tokenBefore!=null && tokenBefore.getTokenIndex()<size) {
            for (int x = tokenBefore.getTokenIndex()+1; x<size;x++) {
                Token hidden = input.get(x);
                LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                leafNode.setText(hidden.getText());
                leafNode.setHidden(true);
                setLexerRule(leafNode, hidden);
                parentNode.getChildren().add(leafNode);
            }
        }
    }
        
    public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
        if(node.getElement() != null && node.getElement() != astElement) {
            throw new ParseException(node, "Reassignment of astElement in parse tree node");
        }
        node.setElement(astElement);
        if(astElement instanceof EObject) {
            EObject eObject = (EObject) astElement;
            NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
            adapter.setParserNode(node); 
        }
    }
        
    protected void setLexerRule(LeafNode node, Token t) {
    	LexerRule lexerRule = SimpleExpressionsTokenTypeResolver.getLexerRule(node, t.getType());
    	if(lexerRule != null) {
    		node.setGrammarElement(lexerRule);
    	}
    }

    private CompositeNode currentNode;

    private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.testlanguages.SimpleExpressionsConstants.getSimpleExpressionsGrammar();






    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:98:1: parse returns [EObject current] : ruleMultiplication EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleMultiplication1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:98:33: ( ruleMultiplication EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:99:5: ruleMultiplication EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleMultiplication_in_parse53);
            ruleMultiplication1=ruleMultiplication();
            _fsp--;

             current =ruleMultiplication1; 
            match(input,EOF,FOLLOW_EOF_in_parse67); 
             appendTrailingHiddenTokens(currentNode); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end parse


    // $ANTLR start ruleMultiplication
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:108:1: ruleMultiplication returns [EObject current=null] : (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Addition = null;

        EObject lv_values = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:109:111: ( (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:110:1: (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:110:1: (this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:110:2: this_Addition= ruleAddition ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )*
            {
            pushFollow(FOLLOW_ruleAddition_in_ruleMultiplication109);
            this_Addition=ruleAddition();
            _fsp--;

             
                    current = this_Addition; 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:114:1: ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:114:2: ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleAddition )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:114:2: ( () (lv_operator= ( '+' | '-' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:114:3: () (lv_operator= ( '+' | '-' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:114:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:115:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            factory.add(temp, "values",current);
            	            current = temp; 
            	            temp = null;
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode); 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:123:2: (lv_operator= ( '+' | '-' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:124:5: lv_operator= ( '+' | '-' )
            	    {
            	    lv_operator=(Token)input.LT(1);
            	    if ( (input.LA(1)>=12 && input.LA(1)<=13) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleMultiplication136);    throw mse;
            	    }


            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.set(current, "operator", lv_operator);        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:134:3: (lv_values= ruleAddition )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:136:5: lv_values= ruleAddition
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAddition_in_ruleMultiplication179);
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

             currentNode = entryNode; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplication


    // $ANTLR start ruleAddition
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:151:1: ruleAddition returns [EObject current=null] : (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:152:111: ( (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:153:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:153:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:153:2: this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            {
            pushFollow(FOLLOW_ruleTerm_in_ruleAddition225);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:157:1: ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=14 && LA2_0<=15)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:157:2: ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:157:2: ( () (lv_operator= ( '*' | '/' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:157:3: () (lv_operator= ( '*' | '/' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:157:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:158:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            factory.add(temp, "values",current);
            	            current = temp; 
            	            temp = null;
            	            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode); 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:166:2: (lv_operator= ( '*' | '/' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:167:5: lv_operator= ( '*' | '/' )
            	    {
            	    lv_operator=(Token)input.LT(1);
            	    if ( (input.LA(1)>=14 && input.LA(1)<=15) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAddition252);    throw mse;
            	    }


            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.set(current, "operator", lv_operator);        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:177:3: (lv_values= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:179:5: lv_values= ruleTerm
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleTerm_in_ruleAddition295);
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

             currentNode = entryNode; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAddition


    // $ANTLR start ruleTerm
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:194:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:195:37: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:196:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:196:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
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
                    new NoViableAltException("196:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:196:2: this_Atom= ruleAtom
                    {
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm337);
                    this_Atom=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom; 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:201:6: this_Parens= ruleParens
                    {
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm353);
                    this_Parens=ruleParens();
                    _fsp--;

                     
                            current = this_Parens; 
                        

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTerm


    // $ANTLR start ruleAtom
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:209:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:210:37: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:211:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:211:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:212:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom396); 
             
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAtom


    // $ANTLR start ruleParens
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:227:1: ruleParens returns [EObject current=null] : ( ( '(' this_Multiplication= ruleMultiplication ) ')' ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        EObject this_Multiplication = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:228:37: ( ( ( '(' this_Multiplication= ruleMultiplication ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:229:1: ( ( '(' this_Multiplication= ruleMultiplication ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:229:1: ( ( '(' this_Multiplication= ruleMultiplication ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:229:2: ( '(' this_Multiplication= ruleMultiplication ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:229:2: ( '(' this_Multiplication= ruleMultiplication )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:229:3: '(' this_Multiplication= ruleMultiplication
            {
            match(input,16,FOLLOW_16_in_ruleParens441); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleParens453);
            this_Multiplication=ruleMultiplication();
            _fsp--;

             
                    current = this_Multiplication; 
                

            }

            match(input,17,FOLLOW_17_in_ruleParens462); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParens


 

    public static final BitSet FOLLOW_ruleMultiplication_in_parse53 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleMultiplication109 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_set_in_ruleMultiplication136 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleMultiplication179 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleAddition225 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_set_in_ruleAddition252 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleAddition295 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleParens441 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleParens453 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParens462 = new BitSet(new long[]{0x0000000000000002L});

}