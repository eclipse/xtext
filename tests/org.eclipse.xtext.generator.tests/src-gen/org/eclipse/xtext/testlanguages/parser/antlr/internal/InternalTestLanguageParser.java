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

public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g"; }



     	private TestLanguageGrammarAccess grammarAccess;
     	
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EntryRule";	
       	} 



    // $ANTLR start entryRuleEntryRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:72:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final EObject entryRuleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:73:2: (iv_ruleEntryRule= ruleEntryRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:74:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEntryRule_in_entryRuleEntryRule75);
            iv_ruleEntryRule=ruleEntryRule();
            _fsp--;

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
    // $ANTLR end entryRuleEntryRule


    // $ANTLR start ruleEntryRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:81:1: ruleEntryRule returns [EObject current=null] : ( (lv_multiFeature_0_0= ruleAbstractRule ) )* ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:86:6: ( ( (lv_multiFeature_0_0= ruleAbstractRule ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:87:1: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:87:1: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:88:1: (lv_multiFeature_0_0= ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:88:1: (lv_multiFeature_0_0= ruleAbstractRule )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:89:3: lv_multiFeature_0_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntryRuleAccess().getMultiFeatureAbstractRuleParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleEntryRule130);
            	    lv_multiFeature_0_0=ruleAbstractRule();
            	    _fsp--;


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
    // $ANTLR end ruleEntryRule


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:119:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:120:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:121:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule166);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:128:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule_0 = null;

        EObject this_ReducibleRule_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:133:6: ( (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:134:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:134:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
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
                    new NoViableAltException("134:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:135:5: this_ChoiceRule_0= ruleChoiceRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getChoiceRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleChoiceRule_in_ruleAbstractRule223);
                    this_ChoiceRule_0=ruleChoiceRule();
                    _fsp--;

                     
                            current = this_ChoiceRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:145:5: this_ReducibleRule_1= ruleReducibleRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getReducibleRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReducibleRule_in_ruleAbstractRule250);
                    this_ReducibleRule_1=ruleReducibleRule();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleChoiceRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:161:1: entryRuleChoiceRule returns [EObject current=null] : iv_ruleChoiceRule= ruleChoiceRule EOF ;
    public final EObject entryRuleChoiceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:162:2: (iv_ruleChoiceRule= ruleChoiceRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:163:2: iv_ruleChoiceRule= ruleChoiceRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChoiceRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule285);
            iv_ruleChoiceRule=ruleChoiceRule();
            _fsp--;

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
    // $ANTLR end entryRuleChoiceRule


    // $ANTLR start ruleChoiceRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:170:1: ruleChoiceRule returns [EObject current=null] : ( 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token lv_optionalKeyword_1_0=null;
        Token lv_name_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:175:6: ( ( 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:176:1: ( 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:176:1: ( 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:176:3: 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleChoiceRule330); 

                    createLeafNode(grammarAccess.getChoiceRuleAccess().getChoiceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:180:1: ( (lv_optionalKeyword_1_0= 'optional' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:181:1: (lv_optionalKeyword_1_0= 'optional' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:181:1: (lv_optionalKeyword_1_0= 'optional' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:182:3: lv_optionalKeyword_1_0= 'optional'
                    {
                    lv_optionalKeyword_1_0=(Token)input.LT(1);
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleChoiceRule348); 

                            createLeafNode(grammarAccess.getChoiceRuleAccess().getOptionalKeywordOptionalKeyword_1_0(), "optionalKeyword"); 
                        

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:201:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:202:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:202:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:203:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChoiceRule379); 

            			createLeafNode(grammarAccess.getChoiceRuleAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

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
    // $ANTLR end ruleChoiceRule


    // $ANTLR start entryRuleReducibleRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:233:1: entryRuleReducibleRule returns [EObject current=null] : iv_ruleReducibleRule= ruleReducibleRule EOF ;
    public final EObject entryRuleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReducibleRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:234:2: (iv_ruleReducibleRule= ruleReducibleRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:235:2: iv_ruleReducibleRule= ruleReducibleRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReducibleRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule420);
            iv_ruleReducibleRule=ruleReducibleRule();
            _fsp--;

             current =iv_ruleReducibleRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReducibleRule430); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:242:1: ruleReducibleRule returns [EObject current=null] : ( 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) ;
    public final EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalRule_1 = null;

        EObject lv_actionFeature_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:247:6: ( ( 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:248:1: ( 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:248:1: ( 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:248:3: 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleReducibleRule465); 

                    createLeafNode(grammarAccess.getReducibleRuleAccess().getReducibleKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getReducibleRuleAccess().getTerminalRuleParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleReducibleRule487);
            this_TerminalRule_1=ruleTerminalRule();
            _fsp--;

             
                    current = this_TerminalRule_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:261:1: ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:261:2: () ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:261:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:262:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:277:2: ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:278:1: (lv_actionFeature_3_0= ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:278:1: (lv_actionFeature_3_0= ruleTerminalRule )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:279:3: lv_actionFeature_3_0= ruleTerminalRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReducibleRuleAccess().getActionFeatureTerminalRuleParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleReducibleRule517);
                    lv_actionFeature_3_0=ruleTerminalRule();
                    _fsp--;


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
    // $ANTLR end ruleReducibleRule


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:309:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:310:2: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:311:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule555);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule565); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:318:1: ruleTerminalRule returns [EObject current=null] : ( (lv_stringFeature_0_0= RULE_STRING ) ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:323:6: ( ( (lv_stringFeature_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:324:1: ( (lv_stringFeature_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:324:1: ( (lv_stringFeature_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:325:1: (lv_stringFeature_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:325:1: (lv_stringFeature_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:326:3: lv_stringFeature_0_0= RULE_STRING
            {
            lv_stringFeature_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTerminalRule606); 

            			createLeafNode(grammarAccess.getTerminalRuleAccess().getStringFeatureSTRINGTerminalRuleCall_0(), "stringFeature"); 
            		

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
    // $ANTLR end ruleTerminalRule


 

    
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
        public static final BitSet FOLLOW_11_in_ruleChoiceRule330 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleChoiceRule348 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule420 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReducibleRule430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleReducibleRule465 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule487 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule555 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule606 = new BitSet(new long[]{0x0000000000000002L});
    }


}