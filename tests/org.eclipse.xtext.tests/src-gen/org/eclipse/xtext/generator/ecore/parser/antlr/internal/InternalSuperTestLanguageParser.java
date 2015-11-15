package org.eclipse.xtext.generator.ecore.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.generator.ecore.services.SuperTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSuperTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'super'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalSuperTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSuperTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSuperTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSuperTestLanguage.g"; }



     	private SuperTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSuperTestLanguageParser(TokenStream input, SuperTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SuperMain";	
       	}
       	
       	@Override
       	protected SuperTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSuperMain"
    // InternalSuperTestLanguage.g:67:1: entryRuleSuperMain returns [EObject current=null] : iv_ruleSuperMain= ruleSuperMain EOF ;
    public final EObject entryRuleSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperMain = null;


        try {
            // InternalSuperTestLanguage.g:68:2: (iv_ruleSuperMain= ruleSuperMain EOF )
            // InternalSuperTestLanguage.g:69:2: iv_ruleSuperMain= ruleSuperMain EOF
            {
             newCompositeNode(grammarAccess.getSuperMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSuperMain=ruleSuperMain();

            state._fsp--;

             current =iv_ruleSuperMain; 
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
    // $ANTLR end "entryRuleSuperMain"


    // $ANTLR start "ruleSuperMain"
    // InternalSuperTestLanguage.g:76:1: ruleSuperMain returns [EObject current=null] : (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSuperMain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalSuperTestLanguage.g:79:28: ( (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSuperTestLanguage.g:80:1: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSuperTestLanguage.g:80:1: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSuperTestLanguage.g:80:3: otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSuperMainAccess().getSuperKeyword_0());
                
            // InternalSuperTestLanguage.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSuperTestLanguage.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSuperTestLanguage.g:85:1: (lv_name_1_0= RULE_ID )
            // InternalSuperTestLanguage.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSuperMainAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSuperMainRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleSuperMain"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}