// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g 2008-06-18 12:01:22

package org.eclipse.xtext.testlanguages.parser.internal; 

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
        
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.tokens");
        }



    // $ANTLR start internalParse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:91:1: internalParse returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:92:3: (iv_ruleEntryRule= ruleEntryRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:92:3: iv_ruleEntryRule= ruleEntryRule EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEntryRule_in_internalParse78);
            iv_ruleEntryRule=ruleEntryRule();
            _fsp--;

             current =iv_ruleEntryRule; 
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


    // $ANTLR start ruleEntryRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:100:1: ruleEntryRule returns [EObject current=null] : (lv_multiFeature= ruleAbstractRule )* ;
    public EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:102:1: ( (lv_multiFeature= ruleAbstractRule )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:102:1: (lv_multiFeature= ruleAbstractRule )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:102:1: (lv_multiFeature= ruleAbstractRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:104:5: lv_multiFeature= ruleAbstractRule
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleEntryRule132);
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
    // $ANTLR end ruleEntryRule


    // $ANTLR start ruleAbstractRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:120:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) ;
    public EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule = null;

        EObject this_ReducibleRule = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:122:1: ( (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:122:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:122:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
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
                    new NoViableAltException("122:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:123:5: this_ChoiceRule= ruleChoiceRule
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleChoiceRule_in_ruleAbstractRule180);
                    this_ChoiceRule=ruleChoiceRule();
                    _fsp--;

                     
                            current = this_ChoiceRule; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:133:5: this_ReducibleRule= ruleReducibleRule
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleReducibleRule_in_ruleAbstractRule207);
                    this_ReducibleRule=ruleReducibleRule();
                    _fsp--;

                     
                            current = this_ReducibleRule; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start ruleChoiceRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:146:1: ruleChoiceRule returns [EObject current=null] : ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) ;
    public EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token lv_optionalKeyword=null;
        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:148:1: ( ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:148:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:148:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:148:2: ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:148:2: ( 'choice' (lv_optionalKeyword= 'optional' )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:148:3: 'choice' (lv_optionalKeyword= 'optional' )?
            {
            match(input,12,FOLLOW_12_in_ruleChoiceRule241); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:153:1: (lv_optionalKeyword= 'optional' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:154:5: lv_optionalKeyword= 'optional'
                    {
                    lv_optionalKeyword=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleChoiceRule259); 

                            if (current==null) {
                                current = factory.create("ChoiceElement");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "optionalKeyword", true,"optional");        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"optionalKeyword");    

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:162:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:163:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoiceRule281); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("ChoiceElement");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name,"ID");    

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
    // $ANTLR end ruleChoiceRule


    // $ANTLR start ruleReducibleRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:179:1: ruleReducibleRule returns [EObject current=null] : ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) ;
    public EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalRule = null;

        EObject lv_actionFeature = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:181:1: ( ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:181:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:181:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:181:2: ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:181:2: ( 'reducible' this_TerminalRule= ruleTerminalRule )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:181:3: 'reducible' this_TerminalRule= ruleTerminalRule
            {
            match(input,14,FOLLOW_14_in_ruleReducibleRule324); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
             
                    currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule347);
            this_TerminalRule=ruleTerminalRule();
            _fsp--;

             
                    current = this_TerminalRule; 
                    currentNode = currentNode.getParent();
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:195:2: ( () (lv_actionFeature= ruleTerminalRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:195:3: () (lv_actionFeature= ruleTerminalRule )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:195:3: ()
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:196:5: 
                    {
                     
                            temp=factory.create("ReducibleComposite");
                            factory.add(temp, "actionFeature",current);
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:206:2: (lv_actionFeature= ruleTerminalRule )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:208:5: lv_actionFeature= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule385);
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
    // $ANTLR end ruleReducibleRule


    // $ANTLR start ruleTerminalRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:224:1: ruleTerminalRule returns [EObject current=null] : (lv_stringFeature= RULE_STRING ) ;
    public EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:226:1: ( (lv_stringFeature= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:226:1: (lv_stringFeature= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:226:1: (lv_stringFeature= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:5: lv_stringFeature= RULE_STRING
            {
            lv_stringFeature=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTerminalRule429); 
             
                createLeafNode("//@parserRules.4/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"stringFeature"); 
                

                    if (current==null) {
                        current = factory.create("TerminalElement");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "stringFeature", lv_stringFeature,"STRING");    

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
    // $ANTLR end ruleTerminalRule


 

    public static final BitSet FOLLOW_ruleEntryRule_in_internalParse78 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleEntryRule132 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleChoiceRule_in_ruleAbstractRule180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReducibleRule_in_ruleAbstractRule207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleChoiceRule241 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_13_in_ruleChoiceRule259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleReducibleRule324 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule347 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule429 = new BitSet(new long[]{0x0000000000000002L});

}