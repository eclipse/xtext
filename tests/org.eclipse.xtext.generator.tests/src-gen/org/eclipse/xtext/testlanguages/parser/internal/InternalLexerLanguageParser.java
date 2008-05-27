// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g 2008-05-27 16:32:44

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.testlanguages.parser.internal.LexerLanguageTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_EXPLICITTOKENTYPE", "RULE_IMPLICITTOKENTYPE", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "RULE_INT", "RULE_ML_COMMENT", "RULE_LEXER_BODY", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=10;
    public static final int EOF=-1;
    public static final int RULE_IMPLICITTOKENTYPE=6;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_EXPLICITTOKENTYPE=5;
    public static final int RULE_LEXER_BODY=12;

        public InternalLexerLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g"; }


     
        public InternalLexerLanguageParser(TokenStream input, IElementFactory factory) {
            this(input);
            this.factory = factory;
    		grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/LexerLanguage").getGrammar();
        }
        
        protected void setLexerRule(LeafNode node, Token t) {
            LexerRule lexerRule = LexerLanguageTokenTypeResolver.getLexerRule(node, t.getType());
            if(lexerRule != null) {
                node.setGrammarElement(lexerRule);
            }
        }




    // $ANTLR start internalParse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:91:1: internalParse returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:92:3: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:92:3: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_internalParse76);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
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


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:100:1: ruleModel returns [EObject current=null] : (lv_children= ruleElement )* ;
    public EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:102:1: ( (lv_children= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:102:1: (lv_children= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:102:1: (lv_children= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:104:5: lv_children= ruleElement
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel130);
            	    lv_children=ruleElement();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Model");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "children", lv_children);    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end ruleModel


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:119:1: ruleElement returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) ) ;
    public EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_f=null;
        Token lv_g=null;
        Token lv_h=null;
        Token lv_i=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:1: ( ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:1: ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:1: ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:2: ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:2: ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:3: ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:3: ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:4: ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:4: ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:5: (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:121:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:122:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement175); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:133:2: (lv_f= RULE_EXPLICITTOKENTYPE )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:134:5: lv_f= RULE_EXPLICITTOKENTYPE
            {
            lv_f=(Token)input.LT(1);
            match(input,RULE_EXPLICITTOKENTYPE,FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement200); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"f"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "f", lv_f);    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:145:3: (lv_g= RULE_IMPLICITTOKENTYPE )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:146:5: lv_g= RULE_IMPLICITTOKENTYPE
            {
            lv_g=(Token)input.LT(1);
            match(input,RULE_IMPLICITTOKENTYPE,FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement226); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"g"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "g", lv_g);    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:157:3: (lv_h= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:158:5: lv_h= RULE_STRING
            {
            lv_h=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElement252); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"h"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "h", lv_h);    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:169:3: (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:170:5: lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:170:10: ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_EXPLICITTOKENTYPE) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_IMPLICITTOKENTYPE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("170:10: ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:170:11: RULE_EXPLICITTOKENTYPE
                    {
                    match(input,RULE_EXPLICITTOKENTYPE,FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement279); 
                     
                        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal/@groups.0" /* xtext::RuleCall */, currentNode,"i"); 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:175:6: RULE_IMPLICITTOKENTYPE
                    {
                    match(input,RULE_IMPLICITTOKENTYPE,FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement293); 
                     
                        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, currentNode,"i"); 
                        

                    }
                    break;

            }


                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "i", lv_i);    

            }


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
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_internalParse76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel130 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement175 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement200 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement226 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElement252 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement293 = new BitSet(new long[]{0x0000000000000002L});

}