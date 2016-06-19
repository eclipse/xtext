package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.assignments.services.Bug287184TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug287184TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'detail'", "'private'", "'protected'", "'public'", "'associated'", "';'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug287184TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug287184TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug287184TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug287184TestLanguage.g"; }



     	private Bug287184TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287184TestLanguageParser(TokenStream input, Bug287184TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug287184TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalBug287184TestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug287184TestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug287184TestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug287184TestLanguage.g:76:1: ruleModel returns [EObject current=null] : (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_detail_2_1 = null;

        EObject lv_detail_2_2 = null;


         enterRule(); 
            
        try {
            // InternalBug287184TestLanguage.g:79:28: ( (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) )
            // InternalBug287184TestLanguage.g:80:1: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            {
            // InternalBug287184TestLanguage.g:80:1: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            // InternalBug287184TestLanguage.g:80:3: otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0());
                
            // InternalBug287184TestLanguage.g:84:1: ( (lv_name_1_0= ruleFQN ) )
            // InternalBug287184TestLanguage.g:85:1: (lv_name_1_0= ruleFQN )
            {
            // InternalBug287184TestLanguage.g:85:1: (lv_name_1_0= ruleFQN )
            // InternalBug287184TestLanguage.g:86:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.parser.assignments.Bug287184TestLanguage.FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287184TestLanguage.g:102:2: ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug287184TestLanguage.g:103:1: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    {
            	    // InternalBug287184TestLanguage.g:103:1: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    // InternalBug287184TestLanguage.g:104:1: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    {
            	    // InternalBug287184TestLanguage.g:104:1: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==12) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==16) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalBug287184TestLanguage.g:105:3: lv_detail_2_1= ruleDetail
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getModelAccess().getDetailDetailParserRuleCall_2_0_0()); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_5);
            	            lv_detail_2_1=ruleDetail();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"detail",
            	                    		lv_detail_2_1, 
            	                    		"org.eclipse.xtext.parser.assignments.Bug287184TestLanguage.Detail");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalBug287184TestLanguage.g:120:8: lv_detail_2_2= ruleAssociatedDetail
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getModelAccess().getDetailAssociatedDetailParserRuleCall_2_0_1()); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_5);
            	            lv_detail_2_2=ruleAssociatedDetail();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"detail",
            	                    		lv_detail_2_2, 
            	                    		"org.eclipse.xtext.parser.assignments.Bug287184TestLanguage.AssociatedDetail");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDetail"
    // InternalBug287184TestLanguage.g:148:1: entryRuleDetail returns [EObject current=null] : iv_ruleDetail= ruleDetail EOF ;
    public final EObject entryRuleDetail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetail = null;


        try {
            // InternalBug287184TestLanguage.g:149:2: (iv_ruleDetail= ruleDetail EOF )
            // InternalBug287184TestLanguage.g:150:2: iv_ruleDetail= ruleDetail EOF
            {
             newCompositeNode(grammarAccess.getDetailRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDetail=ruleDetail();

            state._fsp--;

             current =iv_ruleDetail; 
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
    // $ANTLR end "entryRuleDetail"


    // $ANTLR start "ruleDetail"
    // InternalBug287184TestLanguage.g:157:1: ruleDetail returns [EObject current=null] : (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) ;
    public final EObject ruleDetail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

         enterRule(); 
            
        try {
            // InternalBug287184TestLanguage.g:160:28: ( (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) )
            // InternalBug287184TestLanguage.g:161:1: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            {
            // InternalBug287184TestLanguage.g:161:1: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            // InternalBug287184TestLanguage.g:161:3: otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getDetailAccess().getDetailKeyword_0());
                
            // InternalBug287184TestLanguage.g:165:1: ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=13 && LA4_0<=15)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug287184TestLanguage.g:166:1: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    {
                    // InternalBug287184TestLanguage.g:166:1: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    // InternalBug287184TestLanguage.g:167:1: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
                    {
                    // InternalBug287184TestLanguage.g:167:1: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
                    int alt3=3;
                    switch ( input.LA(1) ) {
                    case 13:
                        {
                        alt3=1;
                        }
                        break;
                    case 14:
                        {
                        alt3=2;
                        }
                        break;
                    case 15:
                        {
                        alt3=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // InternalBug287184TestLanguage.g:168:3: lv_visibility_1_1= 'private'
                            {
                            lv_visibility_1_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                                    newLeafNode(lv_visibility_1_1, grammarAccess.getDetailAccess().getVisibilityPrivateKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDetailRule());
                            	        }
                                   		setWithLastConsumed(current, "visibility", lv_visibility_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalBug287184TestLanguage.g:180:8: lv_visibility_1_2= 'protected'
                            {
                            lv_visibility_1_2=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                                    newLeafNode(lv_visibility_1_2, grammarAccess.getDetailAccess().getVisibilityProtectedKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDetailRule());
                            	        }
                                   		setWithLastConsumed(current, "visibility", lv_visibility_1_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // InternalBug287184TestLanguage.g:192:8: lv_visibility_1_3= 'public'
                            {
                            lv_visibility_1_3=(Token)match(input,15,FollowSets000.FOLLOW_3); 

                                    newLeafNode(lv_visibility_1_3, grammarAccess.getDetailAccess().getVisibilityPublicKeyword_1_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDetailRule());
                            	        }
                                   		setWithLastConsumed(current, "visibility", lv_visibility_1_3, null);
                            	    

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalBug287184TestLanguage.g:207:3: ( ( ruleFQN ) )
            // InternalBug287184TestLanguage.g:208:1: ( ruleFQN )
            {
            // InternalBug287184TestLanguage.g:208:1: ( ruleFQN )
            // InternalBug287184TestLanguage.g:209:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDetailRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getDetailAccess().getDetailClassModelCrossReference_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleDetail"


    // $ANTLR start "entryRuleAssociatedDetail"
    // InternalBug287184TestLanguage.g:230:1: entryRuleAssociatedDetail returns [EObject current=null] : iv_ruleAssociatedDetail= ruleAssociatedDetail EOF ;
    public final EObject entryRuleAssociatedDetail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociatedDetail = null;


        try {
            // InternalBug287184TestLanguage.g:231:2: (iv_ruleAssociatedDetail= ruleAssociatedDetail EOF )
            // InternalBug287184TestLanguage.g:232:2: iv_ruleAssociatedDetail= ruleAssociatedDetail EOF
            {
             newCompositeNode(grammarAccess.getAssociatedDetailRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssociatedDetail=ruleAssociatedDetail();

            state._fsp--;

             current =iv_ruleAssociatedDetail; 
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
    // $ANTLR end "entryRuleAssociatedDetail"


    // $ANTLR start "ruleAssociatedDetail"
    // InternalBug287184TestLanguage.g:239:1: ruleAssociatedDetail returns [EObject current=null] : (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) ;
    public final EObject ruleAssociatedDetail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalBug287184TestLanguage.g:242:28: ( (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) )
            // InternalBug287184TestLanguage.g:243:1: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            {
            // InternalBug287184TestLanguage.g:243:1: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            // InternalBug287184TestLanguage.g:243:3: otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAssociatedDetailAccess().getAssociatedKeyword_0());
                
            // InternalBug287184TestLanguage.g:247:1: ( ( ruleFQN ) )
            // InternalBug287184TestLanguage.g:248:1: ( ruleFQN )
            {
            // InternalBug287184TestLanguage.g:248:1: ( ruleFQN )
            // InternalBug287184TestLanguage.g:249:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociatedDetailRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAssociatedDetailAccess().getDetailClassModelCrossReference_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_7);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getAssociatedDetailAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleAssociatedDetail"


    // $ANTLR start "entryRuleFQN"
    // InternalBug287184TestLanguage.g:274:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalBug287184TestLanguage.g:275:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalBug287184TestLanguage.g:276:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalBug287184TestLanguage.g:283:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalBug287184TestLanguage.g:286:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalBug287184TestLanguage.g:287:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalBug287184TestLanguage.g:287:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalBug287184TestLanguage.g:287:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalBug287184TestLanguage.g:294:1: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBug287184TestLanguage.g:295:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000011000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000011002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000E010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040002L});
    }


}