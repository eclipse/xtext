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

@SuppressWarnings("all")
public class InternalSubTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'ups'", "'super'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalSubTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSubTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSubTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g"; }



     	private SubTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSubTestLanguageParser(TokenStream input, IAstFactory factory, SubTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SubMain";	
       	}
       	
       	@Override
       	protected SubTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSubMain"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:71:1: entryRuleSubMain returns [EObject current=null] : iv_ruleSubMain= ruleSubMain EOF ;
    public final EObject entryRuleSubMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubMain = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:72:2: (iv_ruleSubMain= ruleSubMain EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:73:2: iv_ruleSubMain= ruleSubMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubMain_in_entryRuleSubMain75);
            iv_ruleSubMain=ruleSubMain();

            state._fsp--;

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
    // $ANTLR end "entryRuleSubMain"


    // $ANTLR start "ruleSubMain"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:80:1: ruleSubMain returns [EObject current=null] : (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) ;
    public final EObject ruleSubMain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_superMains_1_0 = null;

        EObject lv_another_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:85:6: ( (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:86:1: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:86:1: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:86:3: otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSubMain122); 

                	createLeafNode(otherlv_0, grammarAccess.getSubMainAccess().getLeftCurlyBracketKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:90:1: ( (lv_superMains_1_0= ruleSuperMain ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:91:1: (lv_superMains_1_0= ruleSuperMain )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:91:1: (lv_superMains_1_0= ruleSuperMain )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:92:3: lv_superMains_1_0= ruleSuperMain
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubMainAccess().getSuperMainsSuperMainParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSuperMain_in_ruleSubMain143);
            lv_superMains_1_0=ruleSuperMain();

            state._fsp--;


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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSubMain155); 

                	createLeafNode(otherlv_2, grammarAccess.getSubMainAccess().getRightCurlyBracketKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:118:1: ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:119:1: (lv_another_3_0= ruleAnotherSuperMain )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:119:1: (lv_another_3_0= ruleAnotherSuperMain )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:120:3: lv_another_3_0= ruleAnotherSuperMain
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubMainAccess().getAnotherAnotherSuperMainParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnotherSuperMain_in_ruleSubMain176);
                    lv_another_3_0=ruleAnotherSuperMain();

                    state._fsp--;


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
    // $ANTLR end "ruleSubMain"


    // $ANTLR start "entryRuleAnotherSuperMain"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:150:1: entryRuleAnotherSuperMain returns [EObject current=null] : iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF ;
    public final EObject entryRuleAnotherSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnotherSuperMain = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:151:2: (iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:152:2: iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAnotherSuperMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAnotherSuperMain_in_entryRuleAnotherSuperMain213);
            iv_ruleAnotherSuperMain=ruleAnotherSuperMain();

            state._fsp--;

             current =iv_ruleAnotherSuperMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnotherSuperMain223); 

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
    // $ANTLR end "entryRuleAnotherSuperMain"


    // $ANTLR start "ruleAnotherSuperMain"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:159:1: ruleAnotherSuperMain returns [EObject current=null] : (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAnotherSuperMain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:164:6: ( (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:165:1: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:165:1: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:165:3: otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAnotherSuperMain260); 

                	createLeafNode(otherlv_0, grammarAccess.getAnotherSuperMainAccess().getUpsKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:169:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:170:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:170:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:171:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAnotherSuperMain277); 

            			createLeafNode(lv_name_1_0, grammarAccess.getAnotherSuperMainAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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
    // $ANTLR end "ruleAnotherSuperMain"


    // $ANTLR start "entryRuleSuperMain"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:201:1: entryRuleSuperMain returns [EObject current=null] : iv_ruleSuperMain= ruleSuperMain EOF ;
    public final EObject entryRuleSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperMain = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:202:2: (iv_ruleSuperMain= ruleSuperMain EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:203:2: iv_ruleSuperMain= ruleSuperMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuperMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSuperMain_in_entryRuleSuperMain318);
            iv_ruleSuperMain=ruleSuperMain();

            state._fsp--;

             current =iv_ruleSuperMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuperMain328); 

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
    // $ANTLR end "entryRuleSuperMain"


    // $ANTLR start "ruleSuperMain"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:210:1: ruleSuperMain returns [EObject current=null] : (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSuperMain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:215:6: ( (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:216:1: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:216:1: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:216:3: otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSuperMain365); 

                	createLeafNode(otherlv_0, grammarAccess.getSuperMainAccess().getSuperKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:220:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:221:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:221:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:222:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuperMain382); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSuperMainAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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
    // $ANTLR end "ruleSuperMain"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSubMain_in_entryRuleSubMain75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubMain85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSubMain122 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleSuperMain_in_ruleSubMain143 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSubMain155 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleAnotherSuperMain_in_ruleSubMain176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherSuperMain_in_entryRuleAnotherSuperMain213 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnotherSuperMain223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleAnotherSuperMain260 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAnotherSuperMain277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuperMain_in_entryRuleSuperMain318 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuperMain328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSuperMain365 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuperMain382 = new BitSet(new long[]{0x0000000000000002L});
    }


}