package org.eclipse.xtext.parser.bug419429.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.bug419429.services.Bug419429GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug419429Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug419429Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug419429Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug419429Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug419429.g"; }



     	private Bug419429GrammarAccess grammarAccess;
     	
        public InternalBug419429Parser(TokenStream input, Bug419429GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EReference";	
       	}
       	
       	@Override
       	protected Bug419429GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEReference"
    // InternalBug419429.g:67:1: entryRuleEReference returns [EObject current=null] : iv_ruleEReference= ruleEReference EOF ;
    public final EObject entryRuleEReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReference = null;


        try {
            // InternalBug419429.g:68:2: (iv_ruleEReference= ruleEReference EOF )
            // InternalBug419429.g:69:2: iv_ruleEReference= ruleEReference EOF
            {
             newCompositeNode(grammarAccess.getEReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEReference=ruleEReference();

            state._fsp--;

             current =iv_ruleEReference; 
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
    // $ANTLR end "entryRuleEReference"


    // $ANTLR start "ruleEReference"
    // InternalBug419429.g:76:1: ruleEReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleEReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalBug419429.g:79:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalBug419429.g:80:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalBug419429.g:80:1: ( (otherlv_0= RULE_ID ) )
            // InternalBug419429.g:81:1: (otherlv_0= RULE_ID )
            {
            // InternalBug419429.g:81:1: (otherlv_0= RULE_ID )
            // InternalBug419429.g:82:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEReferenceRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getEReferenceAccess().getETypeEClassifierCrossReference_0()); 
            	

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
    // $ANTLR end "ruleEReference"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    }


}