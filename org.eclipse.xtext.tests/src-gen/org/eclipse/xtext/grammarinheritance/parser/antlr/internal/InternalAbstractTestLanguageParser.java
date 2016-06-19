package org.eclipse.xtext.grammarinheritance.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAbstractTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_REAL", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_REAL=6;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalAbstractTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAbstractTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAbstractTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAbstractTestLanguage.g"; }



     	private AbstractTestLanguageGrammarAccess grammarAccess;
     	
        public InternalAbstractTestLanguageParser(TokenStream input, AbstractTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "InheritedParserRule";	
       	}
       	
       	@Override
       	protected AbstractTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleInheritedParserRule"
    // InternalAbstractTestLanguage.g:67:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // InternalAbstractTestLanguage.g:68:2: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // InternalAbstractTestLanguage.g:69:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             newCompositeNode(grammarAccess.getInheritedParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();

            state._fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleInheritedParserRule"


    // $ANTLR start "ruleInheritedParserRule"
    // InternalAbstractTestLanguage.g:76:1: ruleInheritedParserRule returns [EObject current=null] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalAbstractTestLanguage.g:79:28: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalAbstractTestLanguage.g:80:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalAbstractTestLanguage.g:80:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalAbstractTestLanguage.g:80:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0());
                
            // InternalAbstractTestLanguage.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalAbstractTestLanguage.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // InternalAbstractTestLanguage.g:85:1: (lv_name_1_0= RULE_ID )
            // InternalAbstractTestLanguage.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInheritedParserRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.grammarinheritance.AbstractTestLanguage.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInheritedParserRule"


    // $ANTLR start "entryRuleOverridableParserRule"
    // InternalAbstractTestLanguage.g:112:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // InternalAbstractTestLanguage.g:113:2: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // InternalAbstractTestLanguage.g:114:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             newCompositeNode(grammarAccess.getOverridableParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();

            state._fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleOverridableParserRule"


    // $ANTLR start "ruleOverridableParserRule"
    // InternalAbstractTestLanguage.g:121:1: ruleOverridableParserRule returns [EObject current=null] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalAbstractTestLanguage.g:124:28: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalAbstractTestLanguage.g:125:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalAbstractTestLanguage.g:125:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalAbstractTestLanguage.g:125:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getOverridableParserRuleAccess().getElementKeyword_0());
                
            // InternalAbstractTestLanguage.g:129:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalAbstractTestLanguage.g:130:1: (lv_name_1_0= RULE_ID )
            {
            // InternalAbstractTestLanguage.g:130:1: (lv_name_1_0= RULE_ID )
            // InternalAbstractTestLanguage.g:131:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOverridableParserRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.grammarinheritance.AbstractTestLanguage.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOverridableParserRule"


    // $ANTLR start "entryRuleExtendableParserRule"
    // InternalAbstractTestLanguage.g:159:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // InternalAbstractTestLanguage.g:160:2: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // InternalAbstractTestLanguage.g:161:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             newCompositeNode(grammarAccess.getExtendableParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();

            state._fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleExtendableParserRule"


    // $ANTLR start "ruleExtendableParserRule"
    // InternalAbstractTestLanguage.g:168:1: ruleExtendableParserRule returns [EObject current=null] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalAbstractTestLanguage.g:171:28: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalAbstractTestLanguage.g:172:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalAbstractTestLanguage.g:172:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalAbstractTestLanguage.g:172:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExtendableParserRuleAccess().getElementKeyword_0());
                
            // InternalAbstractTestLanguage.g:176:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalAbstractTestLanguage.g:177:1: (lv_name_1_0= RULE_ID )
            {
            // InternalAbstractTestLanguage.g:177:1: (lv_name_1_0= RULE_ID )
            // InternalAbstractTestLanguage.g:178:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExtendableParserRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.grammarinheritance.AbstractTestLanguage.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendableParserRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}