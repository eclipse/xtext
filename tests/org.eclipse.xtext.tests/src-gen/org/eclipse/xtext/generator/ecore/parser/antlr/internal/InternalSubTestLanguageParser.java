package org.eclipse.xtext.generator.ecore.parser.antlr.internal; 

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
import org.eclipse.xtext.generator.ecore.services.SubTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSubTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'ups'", "'super'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSubTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g"; }



     	private SubTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSubTestLanguageParser(TokenStream input, IAstFactory factory, SubTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SubMain";	
       	} 



    // $ANTLR start entryRuleSubMain
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:72:1: entryRuleSubMain returns [EObject current=null] : iv_ruleSubMain= ruleSubMain EOF ;
    public final EObject entryRuleSubMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubMain = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:73:2: (iv_ruleSubMain= ruleSubMain EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:74:2: iv_ruleSubMain= ruleSubMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubMain_in_entryRuleSubMain75);
            iv_ruleSubMain=ruleSubMain();
            _fsp--;

             current =iv_ruleSubMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubMain85); 

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
    // $ANTLR end entryRuleSubMain


    // $ANTLR start ruleSubMain
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:81:1: ruleSubMain returns [EObject current=null] : ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) ;
    public final EObject ruleSubMain() throws RecognitionException {
        EObject current = null;

        EObject lv_superMains_1_0 = null;

        EObject lv_another_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:86:6: ( ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:87:1: ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:87:1: ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:87:3: '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSubMain120); 

                    createLeafNode(grammarAccess.getSubMainAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:91:1: ( (lv_superMains_1_0= ruleSuperMain ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:92:1: (lv_superMains_1_0= ruleSuperMain )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:92:1: (lv_superMains_1_0= ruleSuperMain )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:93:3: lv_superMains_1_0= ruleSuperMain
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubMainAccess().getSuperMainsSuperMainParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSuperMain_in_ruleSubMain141);
            lv_superMains_1_0=ruleSuperMain();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubMainRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"superMains",
            	        		lv_superMains_1_0, 
            	        		"SuperMain", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleSubMain151); 

                    createLeafNode(grammarAccess.getSubMainAccess().getRightCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:119:1: ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:120:1: (lv_another_3_0= ruleAnotherSuperMain )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:120:1: (lv_another_3_0= ruleAnotherSuperMain )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:121:3: lv_another_3_0= ruleAnotherSuperMain
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubMainAccess().getAnotherAnotherSuperMainParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnotherSuperMain_in_ruleSubMain172);
                    lv_another_3_0=ruleAnotherSuperMain();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubMainRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"another",
                    	        		lv_another_3_0, 
                    	        		"AnotherSuperMain", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleSubMain


    // $ANTLR start entryRuleAnotherSuperMain
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:151:1: entryRuleAnotherSuperMain returns [EObject current=null] : iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF ;
    public final EObject entryRuleAnotherSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnotherSuperMain = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:152:2: (iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:153:2: iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAnotherSuperMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAnotherSuperMain_in_entryRuleAnotherSuperMain209);
            iv_ruleAnotherSuperMain=ruleAnotherSuperMain();
            _fsp--;

             current =iv_ruleAnotherSuperMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnotherSuperMain219); 

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
    // $ANTLR end entryRuleAnotherSuperMain


    // $ANTLR start ruleAnotherSuperMain
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:160:1: ruleAnotherSuperMain returns [EObject current=null] : ( 'ups' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAnotherSuperMain() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:165:6: ( ( 'ups' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:166:1: ( 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:166:1: ( 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:166:3: 'ups' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleAnotherSuperMain254); 

                    createLeafNode(grammarAccess.getAnotherSuperMainAccess().getUpsKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:170:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:171:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:171:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:172:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAnotherSuperMain271); 

            			createLeafNode(grammarAccess.getAnotherSuperMainAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAnotherSuperMainRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
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
    // $ANTLR end ruleAnotherSuperMain


    // $ANTLR start entryRuleSuperMain
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:202:1: entryRuleSuperMain returns [EObject current=null] : iv_ruleSuperMain= ruleSuperMain EOF ;
    public final EObject entryRuleSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperMain = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:203:2: (iv_ruleSuperMain= ruleSuperMain EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:204:2: iv_ruleSuperMain= ruleSuperMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuperMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSuperMain_in_entryRuleSuperMain312);
            iv_ruleSuperMain=ruleSuperMain();
            _fsp--;

             current =iv_ruleSuperMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuperMain322); 

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
    // $ANTLR end entryRuleSuperMain


    // $ANTLR start ruleSuperMain
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:211:1: ruleSuperMain returns [EObject current=null] : ( 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSuperMain() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:216:6: ( ( 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:217:1: ( 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:217:1: ( 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:217:3: 'super' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleSuperMain357); 

                    createLeafNode(grammarAccess.getSuperMainAccess().getSuperKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:221:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:222:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:222:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:223:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuperMain374); 

            			createLeafNode(grammarAccess.getSuperMainAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSuperMainRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
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
    // $ANTLR end ruleSuperMain


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSubMain_in_entryRuleSubMain75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubMain85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSubMain120 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleSuperMain_in_ruleSubMain141 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSubMain151 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleAnotherSuperMain_in_ruleSubMain172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherSuperMain_in_entryRuleAnotherSuperMain209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnotherSuperMain219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleAnotherSuperMain254 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAnotherSuperMain271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuperMain_in_entryRuleSuperMain312 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuperMain322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSuperMain357 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuperMain374 = new BitSet(new long[]{0x0000000000000002L});
    }


}