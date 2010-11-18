package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBug287184TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug287184TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug287184TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g"; }



     	private Bug287184TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287184TestLanguageParser(TokenStream input, IAstFactory factory, Bug287184TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:80:1: ruleModel returns [EObject current=null] : (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_detail_2_1 = null;

        EObject lv_detail_2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:85:6: ( (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:86:1: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:86:1: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:86:3: otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel122); 

                	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:90:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:91:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:91:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:92:3: lv_name_1_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getNameFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleModel143);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FQN", 
                    		currentNode);
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:109:2: ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:110:1: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:110:1: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:111:1: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:111:1: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
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
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:112:3: lv_detail_2_1= ruleDetail
            	            {
            	             
            	            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDetailDetailParserRuleCall_2_0_0(), currentNode); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_ruleDetail_in_ruleModel166);
            	            lv_detail_2_1=ruleDetail();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"detail",
            	                    		lv_detail_2_1, 
            	                    		"Detail", 
            	                    		currentNode);
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:128:8: lv_detail_2_2= ruleAssociatedDetail
            	            {
            	             
            	            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDetailAssociatedDetailParserRuleCall_2_0_1(), currentNode); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_ruleAssociatedDetail_in_ruleModel185);
            	            lv_detail_2_2=ruleAssociatedDetail();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"detail",
            	                    		lv_detail_2_2, 
            	                    		"AssociatedDetail", 
            	                    		currentNode);
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDetail"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:157:1: entryRuleDetail returns [EObject current=null] : iv_ruleDetail= ruleDetail EOF ;
    public final EObject entryRuleDetail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetail = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:158:2: (iv_ruleDetail= ruleDetail EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:159:2: iv_ruleDetail= ruleDetail EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDetailRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDetail_in_entryRuleDetail227);
            iv_ruleDetail=ruleDetail();

            state._fsp--;

             current =iv_ruleDetail; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDetail237); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:166:1: ruleDetail returns [EObject current=null] : (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) ;
    public final EObject ruleDetail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:171:6: ( (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:172:1: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:172:1: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:172:3: otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDetail274); 

                	createLeafNode(otherlv_0, grammarAccess.getDetailAccess().getDetailKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:176:1: ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=13 && LA4_0<=15)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:177:1: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:177:1: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:178:1: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:178:1: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:179:3: lv_visibility_1_1= 'private'
                            {
                            lv_visibility_1_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDetail294); 

                                    createLeafNode(lv_visibility_1_1, grammarAccess.getDetailAccess().getVisibilityPrivateKeyword_1_0_0(), "visibility");
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDetailRule());
                            	        }
                                   		set(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:191:8: lv_visibility_1_2= 'protected'
                            {
                            lv_visibility_1_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDetail323); 

                                    createLeafNode(lv_visibility_1_2, grammarAccess.getDetailAccess().getVisibilityProtectedKeyword_1_0_1(), "visibility");
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDetailRule());
                            	        }
                                   		set(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:203:8: lv_visibility_1_3= 'public'
                            {
                            lv_visibility_1_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDetail352); 

                                    createLeafNode(lv_visibility_1_3, grammarAccess.getDetailAccess().getVisibilityPublicKeyword_1_0_2(), "visibility");
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDetailRule());
                            	        }
                                   		set(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
                            	    

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:218:3: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:219:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:219:1: ( ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:220:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDetailRule());
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getDetailAccess().getDetailClassModelCrossReference_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDetail392);
            ruleFQN();

            state._fsp--;

             
            	        // currentNode = currentNode.getParent();
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleDetail"


    // $ANTLR start "entryRuleAssociatedDetail"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:242:1: entryRuleAssociatedDetail returns [EObject current=null] : iv_ruleAssociatedDetail= ruleAssociatedDetail EOF ;
    public final EObject entryRuleAssociatedDetail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociatedDetail = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:243:2: (iv_ruleAssociatedDetail= ruleAssociatedDetail EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:244:2: iv_ruleAssociatedDetail= ruleAssociatedDetail EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociatedDetailRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssociatedDetail_in_entryRuleAssociatedDetail428);
            iv_ruleAssociatedDetail=ruleAssociatedDetail();

            state._fsp--;

             current =iv_ruleAssociatedDetail; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssociatedDetail438); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:251:1: ruleAssociatedDetail returns [EObject current=null] : (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) ;
    public final EObject ruleAssociatedDetail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:256:6: ( (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:257:1: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:257:1: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:257:3: otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAssociatedDetail475); 

                	createLeafNode(otherlv_0, grammarAccess.getAssociatedDetailAccess().getAssociatedKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:261:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:262:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:262:1: ( ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:263:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociatedDetailRule());
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getAssociatedDetailAccess().getDetailClassModelCrossReference_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleAssociatedDetail498);
            ruleFQN();

            state._fsp--;

             
            	        // currentNode = currentNode.getParent();
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAssociatedDetail510); 

                	createLeafNode(otherlv_2, grammarAccess.getAssociatedDetailAccess().getSemicolonKeyword_2(), null);
                

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
    // $ANTLR end "ruleAssociatedDetail"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:289:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:290:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:291:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN547);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN558); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:298:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:303:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:304:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:304:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:304:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN598); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:311:1: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:312:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFQN617); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN632); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleModel143 = new BitSet(new long[]{0x0000000000011000L});
        public static final BitSet FOLLOW_ruleDetail_in_ruleModel166 = new BitSet(new long[]{0x0000000000011002L});
        public static final BitSet FOLLOW_ruleAssociatedDetail_in_ruleModel185 = new BitSet(new long[]{0x0000000000011002L});
        public static final BitSet FOLLOW_ruleDetail_in_entryRuleDetail227 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDetail237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleDetail274 = new BitSet(new long[]{0x000000000000E010L});
        public static final BitSet FOLLOW_13_in_ruleDetail294 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleDetail323 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_15_in_ruleDetail352 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDetail392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssociatedDetail_in_entryRuleAssociatedDetail428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssociatedDetail438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleAssociatedDetail475 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleAssociatedDetail498 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAssociatedDetail510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN598 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleFQN617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN632 = new BitSet(new long[]{0x0000000000040002L});
    }


}