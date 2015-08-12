package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.terminalrules.services.Bug292245TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug292245TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_APOSTROPHE_CHAR", "RULE_CHAR", "RULE_WS", "'FIX'", "'ERROR'", "'TICK'", "'^'"
    };
    public static final int RULE_APOSTROPHE_CHAR=4;
    public static final int T__10=10;
    public static final int RULE_CHAR=5;
    public static final int RULE_WS=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;

    // delegates
    // delegators


        public InternalBug292245TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug292245TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug292245TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g"; }



     	private Bug292245TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug292245TestLanguageParser(TokenStream input, Bug292245TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug292245TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:72:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:82:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_fix_1_0 = null;

        AntlrDatatypeRuleToken lv_error_3_0 = null;

        AntlrDatatypeRuleToken lv_tick_5_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:86:28: ( ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:87:1: ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:87:1: ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 7:
                    {
                    alt4=1;
                    }
                    break;
                case 8:
                    {
                    alt4=2;
                    }
                    break;
                case 9:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:87:2: (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:87:2: (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:87:4: otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+
            	    {
            	    otherlv_0=(Token)match(input,7,FollowSets000.FOLLOW_7_in_ruleModel133); 

            	        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getFIXKeyword_0_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:91:1: ( (lv_fix_1_0= ruleFix ) )+
            	    int cnt1=0;
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:92:1: (lv_fix_1_0= ruleFix )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:92:1: (lv_fix_1_0= ruleFix )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:93:3: lv_fix_1_0= ruleFix
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getModelAccess().getFixFixParserRuleCall_0_1_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFix_in_ruleModel154);
            	    	    lv_fix_1_0=ruleFix();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"fix",
            	    	            		lv_fix_1_0, 
            	    	            		"org.eclipse.xtext.parser.terminalrules.Bug292245TestLanguage.Fix");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt1 >= 1 ) break loop1;
            	                EarlyExitException eee =
            	                    new EarlyExitException(1, input);
            	                throw eee;
            	        }
            	        cnt1++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:110:6: (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:110:6: (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:110:8: otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+
            	    {
            	    otherlv_2=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleModel175); 

            	        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getERRORKeyword_1_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:114:1: ( (lv_error_3_0= ruleError ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:115:1: (lv_error_3_0= ruleError )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:115:1: (lv_error_3_0= ruleError )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:116:3: lv_error_3_0= ruleError
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorErrorParserRuleCall_1_1_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleError_in_ruleModel196);
            	    	    lv_error_3_0=ruleError();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"error",
            	    	            		lv_error_3_0, 
            	    	            		"org.eclipse.xtext.parser.terminalrules.Bug292245TestLanguage.Error");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:133:6: (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:133:6: (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:133:8: otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+
            	    {
            	    otherlv_4=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleModel217); 

            	        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getTICKKeyword_2_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:137:1: ( (lv_tick_5_0= ruleApostrophe ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:138:1: (lv_tick_5_0= ruleApostrophe )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:138:1: (lv_tick_5_0= ruleApostrophe )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:139:3: lv_tick_5_0= ruleApostrophe
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getModelAccess().getTickApostropheParserRuleCall_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleApostrophe_in_ruleModel238);
            	    	    lv_tick_5_0=ruleApostrophe();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"tick",
            	    	            		lv_tick_5_0, 
            	    	            		"org.eclipse.xtext.parser.terminalrules.Bug292245TestLanguage.Apostrophe");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleError"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:166:1: entryRuleError returns [String current=null] : iv_ruleError= ruleError EOF ;
    public final String entryRuleError() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleError = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:170:2: (iv_ruleError= ruleError EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:171:2: iv_ruleError= ruleError EOF
            {
             newCompositeNode(grammarAccess.getErrorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_in_entryRuleError288);
            iv_ruleError=ruleError();

            state._fsp--;

             current =iv_ruleError.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError299); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleError"


    // $ANTLR start "ruleError"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:181:1: ruleError returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ) ;
    public final AntlrDatatypeRuleToken ruleError() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_APOSTROPHE_CHAR_0=null;
        Token this_APOSTROPHE_CHAR_2=null;
        AntlrDatatypeRuleToken this_Graphical_1 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:185:28: ( (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:186:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:186:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:186:6: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR
            {
            this_APOSTROPHE_CHAR_0=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError343); 

            		current.merge(this_APOSTROPHE_CHAR_0);
                
             
                newLeafNode(this_APOSTROPHE_CHAR_0, grammarAccess.getErrorAccess().getAPOSTROPHE_CHARTerminalRuleCall_0()); 
                
             
                    newCompositeNode(grammarAccess.getErrorAccess().getGraphicalParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_ruleError370);
            this_Graphical_1=ruleGraphical();

            state._fsp--;


            		current.merge(this_Graphical_1);
                
             
                    afterParserOrEnumRuleCall();
                
            this_APOSTROPHE_CHAR_2=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError390); 

            		current.merge(this_APOSTROPHE_CHAR_2);
                
             
                newLeafNode(this_APOSTROPHE_CHAR_2, grammarAccess.getErrorAccess().getAPOSTROPHE_CHARTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleError"


    // $ANTLR start "entryRuleFix"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:222:1: entryRuleFix returns [String current=null] : iv_ruleFix= ruleFix EOF ;
    public final String entryRuleFix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFix = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:226:2: (iv_ruleFix= ruleFix EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:227:2: iv_ruleFix= ruleFix EOF
            {
             newCompositeNode(grammarAccess.getFixRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFix_in_entryRuleFix446);
            iv_ruleFix=ruleFix();

            state._fsp--;

             current =iv_ruleFix.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFix457); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFix"


    // $ANTLR start "ruleFix"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:237:1: ruleFix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide ) ;
    public final AntlrDatatypeRuleToken ruleFix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_APOSTROPHE_CHAR_0=null;
        Token this_APOSTROPHE_CHAR_2=null;
        AntlrDatatypeRuleToken this_Graphical_1 = null;

        AntlrDatatypeRuleToken this_Rehide_3 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:241:28: ( (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:242:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:242:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:242:6: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide
            {
            this_APOSTROPHE_CHAR_0=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix501); 

            		current.merge(this_APOSTROPHE_CHAR_0);
                
             
                newLeafNode(this_APOSTROPHE_CHAR_0, grammarAccess.getFixAccess().getAPOSTROPHE_CHARTerminalRuleCall_0()); 
                
             
                    newCompositeNode(grammarAccess.getFixAccess().getGraphicalParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_ruleFix528);
            this_Graphical_1=ruleGraphical();

            state._fsp--;


            		current.merge(this_Graphical_1);
                
             
                    afterParserOrEnumRuleCall();
                
            this_APOSTROPHE_CHAR_2=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix548); 

            		current.merge(this_APOSTROPHE_CHAR_2);
                
             
                newLeafNode(this_APOSTROPHE_CHAR_2, grammarAccess.getFixAccess().getAPOSTROPHE_CHARTerminalRuleCall_2()); 
                
             
                    newCompositeNode(grammarAccess.getFixAccess().getRehideParserRuleCall_3()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRehide_in_ruleFix575);
            this_Rehide_3=ruleRehide();

            state._fsp--;


            		current.merge(this_Rehide_3);
                
             
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFix"


    // $ANTLR start "entryRuleApostrophe"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:289:1: entryRuleApostrophe returns [String current=null] : iv_ruleApostrophe= ruleApostrophe EOF ;
    public final String entryRuleApostrophe() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleApostrophe = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:293:2: (iv_ruleApostrophe= ruleApostrophe EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:294:2: iv_ruleApostrophe= ruleApostrophe EOF
            {
             newCompositeNode(grammarAccess.getApostropheRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleApostrophe_in_entryRuleApostrophe631);
            iv_ruleApostrophe=ruleApostrophe();

            state._fsp--;

             current =iv_ruleApostrophe.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleApostrophe642); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleApostrophe"


    // $ANTLR start "ruleApostrophe"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:304:1: ruleApostrophe returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ;
    public final AntlrDatatypeRuleToken ruleApostrophe() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_APOSTROPHE_CHAR_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:308:28: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:309:5: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR
            {
            this_APOSTROPHE_CHAR_0=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleApostrophe685); 

            		current.merge(this_APOSTROPHE_CHAR_0);
                
             
                newLeafNode(this_APOSTROPHE_CHAR_0, grammarAccess.getApostropheAccess().getAPOSTROPHE_CHARTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleApostrophe"


    // $ANTLR start "entryRuleRehide"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:327:1: entryRuleRehide returns [String current=null] : iv_ruleRehide= ruleRehide EOF ;
    public final String entryRuleRehide() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRehide = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:331:2: (iv_ruleRehide= ruleRehide EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:332:2: iv_ruleRehide= ruleRehide EOF
            {
             newCompositeNode(grammarAccess.getRehideRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRehide_in_entryRuleRehide740);
            iv_ruleRehide=ruleRehide();

            state._fsp--;

             current =iv_ruleRehide.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRehide751); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleRehide"


    // $ANTLR start "ruleRehide"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:342:1: ruleRehide returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '^' )? ;
    public final AntlrDatatypeRuleToken ruleRehide() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:346:28: ( (kw= '^' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:347:1: (kw= '^' )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:347:1: (kw= '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==10) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:348:2: kw= '^'
                    {
                    kw=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleRehide793); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRehideAccess().getCircumflexAccentKeyword()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleRehide"


    // $ANTLR start "entryRuleGraphical"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:364:1: entryRuleGraphical returns [String current=null] : iv_ruleGraphical= ruleGraphical EOF ;
    public final String entryRuleGraphical() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphical = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:365:2: (iv_ruleGraphical= ruleGraphical EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:366:2: iv_ruleGraphical= ruleGraphical EOF
            {
             newCompositeNode(grammarAccess.getGraphicalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_entryRuleGraphical839);
            iv_ruleGraphical=ruleGraphical();

            state._fsp--;

             current =iv_ruleGraphical.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGraphical850); 

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
    // $ANTLR end "entryRuleGraphical"


    // $ANTLR start "ruleGraphical"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:373:1: ruleGraphical returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS ) ;
    public final AntlrDatatypeRuleToken ruleGraphical() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHAR_0=null;
        Token this_WS_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:376:28: ( (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:377:1: (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:377:1: (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_CHAR) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_WS) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:377:6: this_CHAR_0= RULE_CHAR
                    {
                    this_CHAR_0=(Token)match(input,RULE_CHAR,FollowSets000.FOLLOW_RULE_CHAR_in_ruleGraphical890); 

                    		current.merge(this_CHAR_0);
                        
                     
                        newLeafNode(this_CHAR_0, grammarAccess.getGraphicalAccess().getCHARTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:385:10: this_WS_1= RULE_WS
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleGraphical916); 

                    		current.merge(this_WS_1);
                        
                     
                        newLeafNode(this_WS_1, grammarAccess.getGraphicalAccess().getWSTerminalRuleCall_1()); 
                        

                    }
                    break;

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
    // $ANTLR end "ruleGraphical"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_7_in_ruleModel133 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFix_in_ruleModel154 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_8_in_ruleModel175 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleError_in_ruleModel196 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_9_in_ruleModel217 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleApostrophe_in_ruleModel238 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_ruleError_in_entryRuleError288 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError343 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleGraphical_in_ruleError370 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFix_in_entryRuleFix446 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFix457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix501 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleGraphical_in_ruleFix528 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix548 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_ruleRehide_in_ruleFix575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleApostrophe_in_entryRuleApostrophe631 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleApostrophe642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleApostrophe685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRehide_in_entryRuleRehide740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRehide751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_10_in_ruleRehide793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGraphical_in_entryRuleGraphical839 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGraphical850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CHAR_in_ruleGraphical890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleGraphical916 = new BitSet(new long[]{0x0000000000000002L});
    }


}