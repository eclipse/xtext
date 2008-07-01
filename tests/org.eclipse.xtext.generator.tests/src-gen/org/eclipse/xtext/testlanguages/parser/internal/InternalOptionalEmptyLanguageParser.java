// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g 2008-07-01 17:32:53

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

public class InternalOptionalEmptyLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'hallo'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalOptionalEmptyLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g"; }


     
        public InternalOptionalEmptyLanguageParser(TokenStream input, IElementFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalOptionalEmptyLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:99:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:99:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:100:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel80);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel90); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:107:1: ruleModel returns [EObject current=null] : (lv_child= ruleGreeting )? ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_child = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:109:33: ( (lv_child= ruleGreeting )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:110:1: (lv_child= ruleGreeting )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:110:1: (lv_child= ruleGreeting )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:112:5: lv_child= ruleGreeting
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleGreeting_in_ruleModel142);
                    lv_child=ruleGreeting();
                    _fsp--;


                            currentNode = currentNode.getParent();
                            if (current==null) {
                                current = factory.create("Model");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "child", lv_child,null);    

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleGreeting
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:128:1: entryRuleGreeting returns [EObject current=null] : iv_ruleGreeting= ruleGreeting EOF ;
    public final EObject entryRuleGreeting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreeting = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:128:50: (iv_ruleGreeting= ruleGreeting EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:129:2: iv_ruleGreeting= ruleGreeting EOF
            {
             currentNode = createCompositeNode("//@parserRules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGreeting_in_entryRuleGreeting178);
            iv_ruleGreeting=ruleGreeting();
            _fsp--;

             current =iv_ruleGreeting; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreeting188); 

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
    // $ANTLR end entryRuleGreeting


    // $ANTLR start ruleGreeting
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:136:1: ruleGreeting returns [EObject current=null] : ( 'hallo' (lv_name= RULE_ID ) ) ;
    public final EObject ruleGreeting() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:33: ( ( 'hallo' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:139:1: ( 'hallo' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:139:1: ( 'hallo' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:139:2: 'hallo' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleGreeting222); 

                    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:144:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:145:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGreeting240); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Greeting");
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
    // $ANTLR end ruleGreeting


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel80 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreeting188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleGreeting222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGreeting240 = new BitSet(new long[]{0x0000000000000002L});

}