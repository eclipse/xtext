package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g"; }



     	private TestLanguageGrammarAccess grammarAccess;
     	
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EntryRule";	
       	}
       	
       	@Override
       	protected TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEntryRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:71:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final EObject entryRuleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:72:2: (iv_ruleEntryRule= ruleEntryRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:73:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEntryRule_in_entryRuleEntryRule75);
            iv_ruleEntryRule=ruleEntryRule();

            state._fsp--;

             current =iv_ruleEntryRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntryRule85); 

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
    // $ANTLR end "entryRuleEntryRule"


    // $ANTLR start "ruleEntryRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:80:1: ruleEntryRule returns [EObject current=null] : ( (lv_multiFeature_0_0= ruleAbstractRule ) )* ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:85:6: ( ( (lv_multiFeature_0_0= ruleAbstractRule ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:86:1: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:86:1: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:87:1: (lv_multiFeature_0_0= ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:87:1: (lv_multiFeature_0_0= ruleAbstractRule )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:88:3: lv_multiFeature_0_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntryRuleAccess().getMultiFeatureAbstractRuleParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleEntryRule130);
            	    lv_multiFeature_0_0=ruleAbstractRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntryRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"multiFeature",
            	    	        		lv_multiFeature_0_0, 
            	    	        		"AbstractRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntryRule"


    // $ANTLR start "entryRuleAbstractRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:118:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:119:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:120:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule166);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule176); 

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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:127:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule_0 = null;

        EObject this_ReducibleRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:132:6: ( (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:133:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:133:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:134:5: this_ChoiceRule_0= ruleChoiceRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getChoiceRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleChoiceRule_in_ruleAbstractRule223);
                    this_ChoiceRule_0=ruleChoiceRule();

                    state._fsp--;

                     
                            current = this_ChoiceRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:144:5: this_ReducibleRule_1= ruleReducibleRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getReducibleRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReducibleRule_in_ruleAbstractRule250);
                    this_ReducibleRule_1=ruleReducibleRule();

                    state._fsp--;

                     
                            current = this_ReducibleRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleChoiceRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:160:1: entryRuleChoiceRule returns [EObject current=null] : iv_ruleChoiceRule= ruleChoiceRule EOF ;
    public final EObject entryRuleChoiceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:161:2: (iv_ruleChoiceRule= ruleChoiceRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:162:2: iv_ruleChoiceRule= ruleChoiceRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChoiceRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule285);
            iv_ruleChoiceRule=ruleChoiceRule();

            state._fsp--;

             current =iv_ruleChoiceRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChoiceRule295); 

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
    // $ANTLR end "entryRuleChoiceRule"


    // $ANTLR start "ruleChoiceRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:169:1: ruleChoiceRule returns [EObject current=null] : (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_optionalKeyword_1_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:174:6: ( (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:175:1: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:175:1: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:175:3: otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleChoiceRule332); 

                	createLeafNode(otherlv_0, grammarAccess.getChoiceRuleAccess().getChoiceKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:179:1: ( (lv_optionalKeyword_1_0= 'optional' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:180:1: (lv_optionalKeyword_1_0= 'optional' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:180:1: (lv_optionalKeyword_1_0= 'optional' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:181:3: lv_optionalKeyword_1_0= 'optional'
                    {
                    lv_optionalKeyword_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleChoiceRule350); 

                            createLeafNode(lv_optionalKeyword_1_0, grammarAccess.getChoiceRuleAccess().getOptionalKeywordOptionalKeyword_1_0(), "optionalKeyword");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getChoiceRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "optionalKeyword", true, "optional", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:200:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:201:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:201:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:202:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChoiceRule381); 

            			createLeafNode(lv_name_2_0, grammarAccess.getChoiceRuleAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChoiceRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoiceRule"


    // $ANTLR start "entryRuleReducibleRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:232:1: entryRuleReducibleRule returns [EObject current=null] : iv_ruleReducibleRule= ruleReducibleRule EOF ;
    public final EObject entryRuleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReducibleRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:233:2: (iv_ruleReducibleRule= ruleReducibleRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:234:2: iv_ruleReducibleRule= ruleReducibleRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReducibleRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule422);
            iv_ruleReducibleRule=ruleReducibleRule();

            state._fsp--;

             current =iv_ruleReducibleRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReducibleRule432); 

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
    // $ANTLR end "entryRuleReducibleRule"


    // $ANTLR start "ruleReducibleRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:241:1: ruleReducibleRule returns [EObject current=null] : (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) ;
    public final EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TerminalRule_1 = null;

        EObject lv_actionFeature_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:246:6: ( (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:247:1: (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:247:1: (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:247:3: otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleReducibleRule469); 

                	createLeafNode(otherlv_0, grammarAccess.getReducibleRuleAccess().getReducibleKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getReducibleRuleAccess().getTerminalRuleParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleReducibleRule491);
            this_TerminalRule_1=ruleTerminalRule();

            state._fsp--;

             
                    current = this_TerminalRule_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:260:1: ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:260:2: () ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:260:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:261:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getReducibleRuleAccess().getReducibleCompositeActionFeatureAction_2_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "actionFeature", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getReducibleRuleAccess().getReducibleCompositeActionFeatureAction_2_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:276:2: ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:277:1: (lv_actionFeature_3_0= ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:277:1: (lv_actionFeature_3_0= ruleTerminalRule )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:278:3: lv_actionFeature_3_0= ruleTerminalRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReducibleRuleAccess().getActionFeatureTerminalRuleParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleReducibleRule521);
                    lv_actionFeature_3_0=ruleTerminalRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReducibleRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"actionFeature",
                    	        		lv_actionFeature_3_0, 
                    	        		"TerminalRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReducibleRule"


    // $ANTLR start "entryRuleTerminalRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:308:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:309:2: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:310:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule559);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule569); 

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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:317:1: ruleTerminalRule returns [EObject current=null] : ( (lv_stringFeature_0_0= RULE_STRING ) ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:322:6: ( ( (lv_stringFeature_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:323:1: ( (lv_stringFeature_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:323:1: ( (lv_stringFeature_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:324:1: (lv_stringFeature_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:324:1: (lv_stringFeature_0_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:325:3: lv_stringFeature_0_0= RULE_STRING
            {
            lv_stringFeature_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTerminalRule610); 

            			createLeafNode(lv_stringFeature_0_0, grammarAccess.getTerminalRuleAccess().getStringFeatureSTRINGTerminalRuleCall_0(), "stringFeature"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTerminalRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"stringFeature",
            	        		lv_stringFeature_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleEntryRule130 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChoiceRule_in_ruleAbstractRule223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReducibleRule_in_ruleAbstractRule250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChoiceRule295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleChoiceRule332 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleChoiceRule350 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule422 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReducibleRule432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleReducibleRule469 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule491 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule559 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule610 = new BitSet(new long[]{0x0000000000000002L});
    }


}