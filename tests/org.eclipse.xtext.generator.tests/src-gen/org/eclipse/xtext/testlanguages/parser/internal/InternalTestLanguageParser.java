// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g 2008-07-01 14:31:21

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

public class InternalTestLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g"; }


     
        public InternalTestLanguageParser(TokenStream input, IElementFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EntryRule";	
       	} 



    // $ANTLR start entryRuleEntryRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:99:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final EObject entryRuleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:99:51: (iv_ruleEntryRule= ruleEntryRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:100:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEntryRule_in_entryRuleEntryRule80);
            iv_ruleEntryRule=ruleEntryRule();
            _fsp--;

             current =iv_ruleEntryRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryRule90); 

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
    // $ANTLR end entryRuleEntryRule


    // $ANTLR start ruleEntryRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:107:1: ruleEntryRule returns [EObject current=null] : (lv_multiFeature= ruleAbstractRule )* ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:109:33: ( (lv_multiFeature= ruleAbstractRule )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:110:1: (lv_multiFeature= ruleAbstractRule )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:110:1: (lv_multiFeature= ruleAbstractRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:112:5: lv_multiFeature= ruleAbstractRule
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleEntryRule142);
            	    lv_multiFeature=ruleAbstractRule();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Model");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "multiFeature", lv_multiFeature,null);    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end ruleEntryRule


    // $ANTLR start entryRuleAbstractRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:128:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:128:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:129:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode("//@parserRules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule178);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule188); 

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:136:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule = null;

        EObject this_ReducibleRule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:138:33: ( (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:139:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:139:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("139:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:140:5: this_ChoiceRule= ruleChoiceRule
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleChoiceRule_in_ruleAbstractRule235);
                    this_ChoiceRule=ruleChoiceRule();
                    _fsp--;

                     
                            current = this_ChoiceRule; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:150:5: this_ReducibleRule= ruleReducibleRule
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleReducibleRule_in_ruleAbstractRule262);
                    this_ReducibleRule=ruleReducibleRule();
                    _fsp--;

                     
                            current = this_ReducibleRule; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleChoiceRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:163:1: entryRuleChoiceRule returns [EObject current=null] : iv_ruleChoiceRule= ruleChoiceRule EOF ;
    public final EObject entryRuleChoiceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:163:52: (iv_ruleChoiceRule= ruleChoiceRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:164:2: iv_ruleChoiceRule= ruleChoiceRule EOF
            {
             currentNode = createCompositeNode("//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule296);
            iv_ruleChoiceRule=ruleChoiceRule();
            _fsp--;

             current =iv_ruleChoiceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoiceRule306); 

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
    // $ANTLR end entryRuleChoiceRule


    // $ANTLR start ruleChoiceRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:171:1: ruleChoiceRule returns [EObject current=null] : ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) ;
    public final EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token lv_optionalKeyword=null;
        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:173:33: ( ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:174:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:174:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:174:2: ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:174:2: ( 'choice' (lv_optionalKeyword= 'optional' )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:174:3: 'choice' (lv_optionalKeyword= 'optional' )?
            {
            match(input,12,FOLLOW_12_in_ruleChoiceRule341); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:179:1: (lv_optionalKeyword= 'optional' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:180:5: lv_optionalKeyword= 'optional'
                    {
                    lv_optionalKeyword=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleChoiceRule359); 

                            if (current==null) {
                                current = factory.create("ChoiceElement");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "optionalKeyword", true,"optional");        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"optionalKeyword");    

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:188:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:189:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoiceRule381); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("ChoiceElement");
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
    // $ANTLR end ruleChoiceRule


    // $ANTLR start entryRuleReducibleRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:205:1: entryRuleReducibleRule returns [EObject current=null] : iv_ruleReducibleRule= ruleReducibleRule EOF ;
    public final EObject entryRuleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReducibleRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:205:55: (iv_ruleReducibleRule= ruleReducibleRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:206:2: iv_ruleReducibleRule= ruleReducibleRule EOF
            {
             currentNode = createCompositeNode("//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule424);
            iv_ruleReducibleRule=ruleReducibleRule();
            _fsp--;

             current =iv_ruleReducibleRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReducibleRule434); 

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
    // $ANTLR end entryRuleReducibleRule


    // $ANTLR start ruleReducibleRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:213:1: ruleReducibleRule returns [EObject current=null] : ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) ;
    public final EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalRule = null;

        EObject lv_actionFeature = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:215:33: ( ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:216:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:216:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:216:2: ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:216:2: ( 'reducible' this_TerminalRule= ruleTerminalRule )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:216:3: 'reducible' this_TerminalRule= ruleTerminalRule
            {
            match(input,14,FOLLOW_14_in_ruleReducibleRule469); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
             
                    currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule492);
            this_TerminalRule=ruleTerminalRule();
            _fsp--;

             
                    current = this_TerminalRule; 
                    currentNode = currentNode.getParent();
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:230:2: ( () (lv_actionFeature= ruleTerminalRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:230:3: () (lv_actionFeature= ruleTerminalRule )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:230:3: ()
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:231:5: 
                    {
                     
                            temp=factory.create("ReducibleComposite");
                            factory.add(temp, "actionFeature",current);
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:242:2: (lv_actionFeature= ruleTerminalRule )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:244:5: lv_actionFeature= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule530);
                    lv_actionFeature=ruleTerminalRule();
                    _fsp--;


                            currentNode = currentNode.getParent();
                            if (current==null) {
                                current = factory.create("ReducibleElement");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.add(current, "actionFeature", lv_actionFeature,null);    

                    }


                    }
                    break;

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
    // $ANTLR end ruleReducibleRule


    // $ANTLR start entryRuleTerminalRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:260:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:260:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:261:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode("//@parserRules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule568);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule578); 

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
    // $ANTLR end entryRuleTerminalRule


    // $ANTLR start ruleTerminalRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:268:1: ruleTerminalRule returns [EObject current=null] : (lv_stringFeature= RULE_STRING ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:270:33: ( (lv_stringFeature= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:271:1: (lv_stringFeature= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:271:1: (lv_stringFeature= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:272:5: lv_stringFeature= RULE_STRING
            {
            lv_stringFeature=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTerminalRule619); 
             
                createLeafNode("//@parserRules.4/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"stringFeature"); 
                

                    if (current==null) {
                        current = factory.create("TerminalElement");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "stringFeature", lv_stringFeature,"STRING");    

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
    // $ANTLR end ruleTerminalRule


 

    public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule80 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleEntryRule142 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceRule_in_ruleAbstractRule235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReducibleRule_in_ruleAbstractRule262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoiceRule306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleChoiceRule341 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_13_in_ruleChoiceRule359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReducibleRule434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleReducibleRule469 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule492 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule619 = new BitSet(new long[]{0x0000000000000002L});

}