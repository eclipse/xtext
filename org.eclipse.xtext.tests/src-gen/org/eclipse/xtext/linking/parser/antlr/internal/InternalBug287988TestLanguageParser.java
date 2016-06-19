package org.eclipse.xtext.linking.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.linking.services.Bug287988TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug287988TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'actions'", "'simple'", "'rulecall'", "'rulecall2'", "'rulecall3'", "'inlinedActions'", "'ref'", "';'", "'attribute'", "'master'", "'call'", "'me'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug287988TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug287988TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug287988TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug287988TestLanguage.g"; }



     	private Bug287988TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287988TestLanguageParser(TokenStream input, Bug287988TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug287988TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalBug287988TestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug287988TestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug287988TestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug287988TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_attributes_1_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_attributes_5_0 = null;

        EObject lv_attributes_7_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_attributes_11_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:79:28: ( ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) )
            // InternalBug287988TestLanguage.g:80:1: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            {
            // InternalBug287988TestLanguage.g:80:1: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt7=1;
                }
                break;
            case 12:
                {
                alt7=2;
                }
                break;
            case 13:
                {
                alt7=3;
                }
                break;
            case 14:
                {
                alt7=4;
                }
                break;
            case 15:
                {
                alt7=5;
                }
                break;
            case 16:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalBug287988TestLanguage.g:80:2: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    {
                    // InternalBug287988TestLanguage.g:80:2: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    // InternalBug287988TestLanguage.g:80:4: otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getActionsKeyword_0_0());
                        
                    // InternalBug287988TestLanguage.g:84:1: ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=19 && LA1_0<=20)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalBug287988TestLanguage.g:85:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    {
                    	    // InternalBug287988TestLanguage.g:85:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    // InternalBug287988TestLanguage.g:86:3: lv_attributes_1_0= ruleBaseAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributesBaseAttributeParserRuleCall_0_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_attributes_1_0=ruleBaseAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_1_0, 
                    	            		"org.eclipse.xtext.linking.Bug287988TestLanguage.BaseAttribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:103:6: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    {
                    // InternalBug287988TestLanguage.g:103:6: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    // InternalBug287988TestLanguage.g:103:8: otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getSimpleKeyword_1_0());
                        
                    // InternalBug287988TestLanguage.g:107:1: ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBug287988TestLanguage.g:108:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    {
                    	    // InternalBug287988TestLanguage.g:108:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    // InternalBug287988TestLanguage.g:109:3: lv_attributes_3_0= ruleSimpleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributesSimpleAttributeParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_attributes_3_0=ruleSimpleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_3_0, 
                    	            		"org.eclipse.xtext.linking.Bug287988TestLanguage.SimpleAttribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalBug287988TestLanguage.g:126:6: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    {
                    // InternalBug287988TestLanguage.g:126:6: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    // InternalBug287988TestLanguage.g:126:8: otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getRulecallKeyword_2_0());
                        
                    // InternalBug287988TestLanguage.g:130:1: ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBug287988TestLanguage.g:131:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    {
                    	    // InternalBug287988TestLanguage.g:131:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    // InternalBug287988TestLanguage.g:132:3: lv_attributes_5_0= ruleRuleCallAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttributeParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_attributes_5_0=ruleRuleCallAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_5_0, 
                    	            		"org.eclipse.xtext.linking.Bug287988TestLanguage.RuleCallAttribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // InternalBug287988TestLanguage.g:149:6: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    {
                    // InternalBug287988TestLanguage.g:149:6: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    // InternalBug287988TestLanguage.g:149:8: otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getRulecall2Keyword_3_0());
                        
                    // InternalBug287988TestLanguage.g:153:1: ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBug287988TestLanguage.g:154:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    {
                    	    // InternalBug287988TestLanguage.g:154:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    // InternalBug287988TestLanguage.g:155:3: lv_attributes_7_0= ruleRuleCallAttribute2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute2ParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_attributes_7_0=ruleRuleCallAttribute2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_7_0, 
                    	            		"org.eclipse.xtext.linking.Bug287988TestLanguage.RuleCallAttribute2");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 5 :
                    // InternalBug287988TestLanguage.g:172:6: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    {
                    // InternalBug287988TestLanguage.g:172:6: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    // InternalBug287988TestLanguage.g:172:8: otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_8, grammarAccess.getModelAccess().getRulecall3Keyword_4_0());
                        
                    // InternalBug287988TestLanguage.g:176:1: ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBug287988TestLanguage.g:177:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    {
                    	    // InternalBug287988TestLanguage.g:177:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    // InternalBug287988TestLanguage.g:178:3: lv_attributes_9_0= ruleRuleCallAttribute3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute3ParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_attributes_9_0=ruleRuleCallAttribute3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_9_0, 
                    	            		"org.eclipse.xtext.linking.Bug287988TestLanguage.RuleCallAttribute3");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 6 :
                    // InternalBug287988TestLanguage.g:195:6: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    {
                    // InternalBug287988TestLanguage.g:195:6: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    // InternalBug287988TestLanguage.g:195:8: otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_10, grammarAccess.getModelAccess().getInlinedActionsKeyword_5_0());
                        
                    // InternalBug287988TestLanguage.g:199:1: ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalBug287988TestLanguage.g:200:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    {
                    	    // InternalBug287988TestLanguage.g:200:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    // InternalBug287988TestLanguage.g:201:3: lv_attributes_11_0= ruleActionAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributesActionAttributeParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_attributes_11_0=ruleActionAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_11_0, 
                    	            		"org.eclipse.xtext.linking.Bug287988TestLanguage.ActionAttribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleBaseAttribute"
    // InternalBug287988TestLanguage.g:225:1: entryRuleBaseAttribute returns [EObject current=null] : iv_ruleBaseAttribute= ruleBaseAttribute EOF ;
    public final EObject entryRuleBaseAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseAttribute = null;


        try {
            // InternalBug287988TestLanguage.g:226:2: (iv_ruleBaseAttribute= ruleBaseAttribute EOF )
            // InternalBug287988TestLanguage.g:227:2: iv_ruleBaseAttribute= ruleBaseAttribute EOF
            {
             newCompositeNode(grammarAccess.getBaseAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBaseAttribute=ruleBaseAttribute();

            state._fsp--;

             current =iv_ruleBaseAttribute; 
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
    // $ANTLR end "entryRuleBaseAttribute"


    // $ANTLR start "ruleBaseAttribute"
    // InternalBug287988TestLanguage.g:234:1: ruleBaseAttribute returns [EObject current=null] : ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) ;
    public final EObject ruleBaseAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        EObject this_Attribute_0 = null;

        EObject this_Master_1 = null;


         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:237:28: ( ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) )
            // InternalBug287988TestLanguage.g:238:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            {
            // InternalBug287988TestLanguage.g:238:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            // InternalBug287988TestLanguage.g:238:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';'
            {
            // InternalBug287988TestLanguage.g:238:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug287988TestLanguage.g:239:5: this_Attribute_0= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getBaseAttributeAccess().getAttributeParserRuleCall_0_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_7);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:249:5: this_Master_1= ruleMaster
                    {
                     
                            newCompositeNode(grammarAccess.getBaseAttributeAccess().getMasterParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_7);
                    this_Master_1=ruleMaster();

                    state._fsp--;

                     
                            current = this_Master_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalBug287988TestLanguage.g:257:2: ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug287988TestLanguage.g:257:3: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalBug287988TestLanguage.g:257:3: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    // InternalBug287988TestLanguage.g:257:5: otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_2, grammarAccess.getBaseAttributeAccess().getRefKeyword_1_0_0());
                        
                    // InternalBug287988TestLanguage.g:261:1: ( (otherlv_3= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:262:1: (otherlv_3= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:262:1: (otherlv_3= RULE_ID )
                    // InternalBug287988TestLanguage.g:263:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBaseAttributeRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    		newLeafNode(otherlv_3, grammarAccess.getBaseAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:275:6: ( (lv_type_4_0= RULE_ID ) )
                    {
                    // InternalBug287988TestLanguage.g:275:6: ( (lv_type_4_0= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:276:1: (lv_type_4_0= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:276:1: (lv_type_4_0= RULE_ID )
                    // InternalBug287988TestLanguage.g:277:3: lv_type_4_0= RULE_ID
                    {
                    lv_type_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    			newLeafNode(lv_type_4_0, grammarAccess.getBaseAttributeAccess().getTypeIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBaseAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalBug287988TestLanguage.g:293:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalBug287988TestLanguage.g:294:1: (lv_name_5_0= RULE_ID )
            {
            // InternalBug287988TestLanguage.g:294:1: (lv_name_5_0= RULE_ID )
            // InternalBug287988TestLanguage.g:295:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			newLeafNode(lv_name_5_0, grammarAccess.getBaseAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBaseAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_5_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getBaseAttributeAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleBaseAttribute"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug287988TestLanguage.g:323:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalBug287988TestLanguage.g:324:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalBug287988TestLanguage.g:325:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBug287988TestLanguage.g:332:1: ruleAttribute returns [EObject current=null] : ( () otherlv_1= 'attribute' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:335:28: ( ( () otherlv_1= 'attribute' ) )
            // InternalBug287988TestLanguage.g:336:1: ( () otherlv_1= 'attribute' )
            {
            // InternalBug287988TestLanguage.g:336:1: ( () otherlv_1= 'attribute' )
            // InternalBug287988TestLanguage.g:336:2: () otherlv_1= 'attribute'
            {
            // InternalBug287988TestLanguage.g:336:2: ()
            // InternalBug287988TestLanguage.g:337:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttributeAccess().getAttributeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getAttributeKeyword_1());
                

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleMaster"
    // InternalBug287988TestLanguage.g:354:1: entryRuleMaster returns [EObject current=null] : iv_ruleMaster= ruleMaster EOF ;
    public final EObject entryRuleMaster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaster = null;


        try {
            // InternalBug287988TestLanguage.g:355:2: (iv_ruleMaster= ruleMaster EOF )
            // InternalBug287988TestLanguage.g:356:2: iv_ruleMaster= ruleMaster EOF
            {
             newCompositeNode(grammarAccess.getMasterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMaster=ruleMaster();

            state._fsp--;

             current =iv_ruleMaster; 
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
    // $ANTLR end "entryRuleMaster"


    // $ANTLR start "ruleMaster"
    // InternalBug287988TestLanguage.g:363:1: ruleMaster returns [EObject current=null] : ( () otherlv_1= 'master' ) ;
    public final EObject ruleMaster() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:366:28: ( ( () otherlv_1= 'master' ) )
            // InternalBug287988TestLanguage.g:367:1: ( () otherlv_1= 'master' )
            {
            // InternalBug287988TestLanguage.g:367:1: ( () otherlv_1= 'master' )
            // InternalBug287988TestLanguage.g:367:2: () otherlv_1= 'master'
            {
            // InternalBug287988TestLanguage.g:367:2: ()
            // InternalBug287988TestLanguage.g:368:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMasterAccess().getMasterAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_1, grammarAccess.getMasterAccess().getMasterKeyword_1());
                

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
    // $ANTLR end "ruleMaster"


    // $ANTLR start "entryRuleActionAttribute"
    // InternalBug287988TestLanguage.g:385:1: entryRuleActionAttribute returns [EObject current=null] : iv_ruleActionAttribute= ruleActionAttribute EOF ;
    public final EObject entryRuleActionAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionAttribute = null;


        try {
            // InternalBug287988TestLanguage.g:386:2: (iv_ruleActionAttribute= ruleActionAttribute EOF )
            // InternalBug287988TestLanguage.g:387:2: iv_ruleActionAttribute= ruleActionAttribute EOF
            {
             newCompositeNode(grammarAccess.getActionAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleActionAttribute=ruleActionAttribute();

            state._fsp--;

             current =iv_ruleActionAttribute; 
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
    // $ANTLR end "entryRuleActionAttribute"


    // $ANTLR start "ruleActionAttribute"
    // InternalBug287988TestLanguage.g:394:1: ruleActionAttribute returns [EObject current=null] : ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) ;
    public final EObject ruleActionAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_type_6_0=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:397:28: ( ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) )
            // InternalBug287988TestLanguage.g:398:1: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            {
            // InternalBug287988TestLanguage.g:398:1: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            // InternalBug287988TestLanguage.g:398:2: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';'
            {
            // InternalBug287988TestLanguage.g:398:2: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalBug287988TestLanguage.g:398:3: ( () otherlv_1= 'attribute' )
                    {
                    // InternalBug287988TestLanguage.g:398:3: ( () otherlv_1= 'attribute' )
                    // InternalBug287988TestLanguage.g:398:4: () otherlv_1= 'attribute'
                    {
                    // InternalBug287988TestLanguage.g:398:4: ()
                    // InternalBug287988TestLanguage.g:399:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getActionAttributeAccess().getAttributeAction_0_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_1, grammarAccess.getActionAttributeAccess().getAttributeKeyword_0_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:409:6: ( () otherlv_3= 'master' )
                    {
                    // InternalBug287988TestLanguage.g:409:6: ( () otherlv_3= 'master' )
                    // InternalBug287988TestLanguage.g:409:7: () otherlv_3= 'master'
                    {
                    // InternalBug287988TestLanguage.g:409:7: ()
                    // InternalBug287988TestLanguage.g:410:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getActionAttributeAccess().getMasterAction_0_1_0(),
                                current);
                        

                    }

                    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_3, grammarAccess.getActionAttributeAccess().getMasterKeyword_0_1_1());
                        

                    }


                    }
                    break;

            }

            // InternalBug287988TestLanguage.g:419:3: ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalBug287988TestLanguage.g:419:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalBug287988TestLanguage.g:419:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    // InternalBug287988TestLanguage.g:419:6: otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_4, grammarAccess.getActionAttributeAccess().getRefKeyword_1_0_0());
                        
                    // InternalBug287988TestLanguage.g:423:1: ( (otherlv_5= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:424:1: (otherlv_5= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:424:1: (otherlv_5= RULE_ID )
                    // InternalBug287988TestLanguage.g:425:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActionAttributeRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    		newLeafNode(otherlv_5, grammarAccess.getActionAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:437:6: ( (lv_type_6_0= RULE_ID ) )
                    {
                    // InternalBug287988TestLanguage.g:437:6: ( (lv_type_6_0= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:438:1: (lv_type_6_0= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:438:1: (lv_type_6_0= RULE_ID )
                    // InternalBug287988TestLanguage.g:439:3: lv_type_6_0= RULE_ID
                    {
                    lv_type_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    			newLeafNode(lv_type_6_0, grammarAccess.getActionAttributeAccess().getTypeIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getActionAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"type",
                            		lv_type_6_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalBug287988TestLanguage.g:455:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalBug287988TestLanguage.g:456:1: (lv_name_7_0= RULE_ID )
            {
            // InternalBug287988TestLanguage.g:456:1: (lv_name_7_0= RULE_ID )
            // InternalBug287988TestLanguage.g:457:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			newLeafNode(lv_name_7_0, grammarAccess.getActionAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActionAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_7_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_8, grammarAccess.getActionAttributeAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleActionAttribute"


    // $ANTLR start "entryRuleSimpleAttribute"
    // InternalBug287988TestLanguage.g:485:1: entryRuleSimpleAttribute returns [EObject current=null] : iv_ruleSimpleAttribute= ruleSimpleAttribute EOF ;
    public final EObject entryRuleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAttribute = null;


        try {
            // InternalBug287988TestLanguage.g:486:2: (iv_ruleSimpleAttribute= ruleSimpleAttribute EOF )
            // InternalBug287988TestLanguage.g:487:2: iv_ruleSimpleAttribute= ruleSimpleAttribute EOF
            {
             newCompositeNode(grammarAccess.getSimpleAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleAttribute=ruleSimpleAttribute();

            state._fsp--;

             current =iv_ruleSimpleAttribute; 
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
    // $ANTLR end "entryRuleSimpleAttribute"


    // $ANTLR start "ruleSimpleAttribute"
    // InternalBug287988TestLanguage.g:494:1: ruleSimpleAttribute returns [EObject current=null] : ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) ;
    public final EObject ruleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:497:28: ( ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) )
            // InternalBug287988TestLanguage.g:498:1: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            {
            // InternalBug287988TestLanguage.g:498:1: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            // InternalBug287988TestLanguage.g:498:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';'
            {
            // InternalBug287988TestLanguage.g:498:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBug287988TestLanguage.g:498:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // InternalBug287988TestLanguage.g:498:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // InternalBug287988TestLanguage.g:498:5: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_0, grammarAccess.getSimpleAttributeAccess().getRefKeyword_0_0_0());
                        
                    // InternalBug287988TestLanguage.g:502:1: ( (otherlv_1= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:503:1: (otherlv_1= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:503:1: (otherlv_1= RULE_ID )
                    // InternalBug287988TestLanguage.g:504:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAttributeRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    		newLeafNode(otherlv_1, grammarAccess.getSimpleAttributeAccess().getTypeRefBaseAttributeCrossReference_0_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:516:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // InternalBug287988TestLanguage.g:516:6: ( (lv_type_2_0= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:517:1: (lv_type_2_0= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:517:1: (lv_type_2_0= RULE_ID )
                    // InternalBug287988TestLanguage.g:518:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    			newLeafNode(lv_type_2_0, grammarAccess.getSimpleAttributeAccess().getTypeIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"type",
                            		lv_type_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalBug287988TestLanguage.g:534:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalBug287988TestLanguage.g:535:1: (lv_name_3_0= RULE_ID )
            {
            // InternalBug287988TestLanguage.g:535:1: (lv_name_3_0= RULE_ID )
            // InternalBug287988TestLanguage.g:536:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			newLeafNode(lv_name_3_0, grammarAccess.getSimpleAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAttributeAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleSimpleAttribute"


    // $ANTLR start "entryRuleRuleCallAttribute"
    // InternalBug287988TestLanguage.g:564:1: entryRuleRuleCallAttribute returns [EObject current=null] : iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF ;
    public final EObject entryRuleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute = null;


        try {
            // InternalBug287988TestLanguage.g:565:2: (iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF )
            // InternalBug287988TestLanguage.g:566:2: iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF
            {
             newCompositeNode(grammarAccess.getRuleCallAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallAttribute=ruleRuleCallAttribute();

            state._fsp--;

             current =iv_ruleRuleCallAttribute; 
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
    // $ANTLR end "entryRuleRuleCallAttribute"


    // $ANTLR start "ruleRuleCallAttribute"
    // InternalBug287988TestLanguage.g:573:1: ruleRuleCallAttribute returns [EObject current=null] : (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject this_CallMe_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:576:28: ( (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalBug287988TestLanguage.g:577:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalBug287988TestLanguage.g:577:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalBug287988TestLanguage.g:578:5: this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
             
                    newCompositeNode(grammarAccess.getRuleCallAttributeAccess().getCallMeParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_8);
            this_CallMe_0=ruleCallMe();

            state._fsp--;

             
                    current = this_CallMe_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalBug287988TestLanguage.g:586:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug287988TestLanguage.g:587:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug287988TestLanguage.g:587:1: (lv_name_1_0= RULE_ID )
            // InternalBug287988TestLanguage.g:588:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuleCallAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getRuleCallAttributeAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleRuleCallAttribute"


    // $ANTLR start "entryRuleCallMe"
    // InternalBug287988TestLanguage.g:616:1: entryRuleCallMe returns [EObject current=null] : iv_ruleCallMe= ruleCallMe EOF ;
    public final EObject entryRuleCallMe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe = null;


        try {
            // InternalBug287988TestLanguage.g:617:2: (iv_ruleCallMe= ruleCallMe EOF )
            // InternalBug287988TestLanguage.g:618:2: iv_ruleCallMe= ruleCallMe EOF
            {
             newCompositeNode(grammarAccess.getCallMeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe=ruleCallMe();

            state._fsp--;

             current =iv_ruleCallMe; 
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
    // $ANTLR end "entryRuleCallMe"


    // $ANTLR start "ruleCallMe"
    // InternalBug287988TestLanguage.g:625:1: ruleCallMe returns [EObject current=null] : ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final EObject ruleCallMe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;

         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:628:28: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) )
            // InternalBug287988TestLanguage.g:629:1: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            {
            // InternalBug287988TestLanguage.g:629:1: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalBug287988TestLanguage.g:629:2: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // InternalBug287988TestLanguage.g:629:2: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // InternalBug287988TestLanguage.g:629:4: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_0, grammarAccess.getCallMeAccess().getRefKeyword_0_0());
                        
                    // InternalBug287988TestLanguage.g:633:1: ( (otherlv_1= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:634:1: (otherlv_1= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:634:1: (otherlv_1= RULE_ID )
                    // InternalBug287988TestLanguage.g:635:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCallMeRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_1, grammarAccess.getCallMeAccess().getTypeRefBaseAttributeCrossReference_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:647:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // InternalBug287988TestLanguage.g:647:6: ( (lv_type_2_0= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:648:1: (lv_type_2_0= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:648:1: (lv_type_2_0= RULE_ID )
                    // InternalBug287988TestLanguage.g:649:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_type_2_0, grammarAccess.getCallMeAccess().getTypeIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCallMeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"type",
                            		lv_type_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


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
    // $ANTLR end "ruleCallMe"


    // $ANTLR start "entryRuleRuleCallAttribute2"
    // InternalBug287988TestLanguage.g:673:1: entryRuleRuleCallAttribute2 returns [EObject current=null] : iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF ;
    public final EObject entryRuleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute2 = null;


        try {
            // InternalBug287988TestLanguage.g:674:2: (iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF )
            // InternalBug287988TestLanguage.g:675:2: iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF
            {
             newCompositeNode(grammarAccess.getRuleCallAttribute2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallAttribute2=ruleRuleCallAttribute2();

            state._fsp--;

             current =iv_ruleRuleCallAttribute2; 
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
    // $ANTLR end "entryRuleRuleCallAttribute2"


    // $ANTLR start "ruleRuleCallAttribute2"
    // InternalBug287988TestLanguage.g:682:1: ruleRuleCallAttribute2 returns [EObject current=null] : (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final EObject ruleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        EObject this_CallMe2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:685:28: ( (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // InternalBug287988TestLanguage.g:686:1: (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // InternalBug287988TestLanguage.g:686:1: (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // InternalBug287988TestLanguage.g:687:5: this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {
             
                    newCompositeNode(grammarAccess.getRuleCallAttribute2Access().getCallMe2ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_7);
            this_CallMe2_0=ruleCallMe2();

            state._fsp--;

             
                    current = this_CallMe2_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalBug287988TestLanguage.g:695:1: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalBug287988TestLanguage.g:695:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalBug287988TestLanguage.g:695:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // InternalBug287988TestLanguage.g:695:4: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleCallAttribute2Access().getRefKeyword_1_0_0());
                        
                    // InternalBug287988TestLanguage.g:699:1: ( (otherlv_2= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:700:1: (otherlv_2= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:700:1: (otherlv_2= RULE_ID )
                    // InternalBug287988TestLanguage.g:701:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleCallAttribute2Rule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    		newLeafNode(otherlv_2, grammarAccess.getRuleCallAttribute2Access().getTypeRefBaseAttributeCrossReference_1_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:713:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // InternalBug287988TestLanguage.g:713:6: ( (lv_type_3_0= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:714:1: (lv_type_3_0= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:714:1: (lv_type_3_0= RULE_ID )
                    // InternalBug287988TestLanguage.g:715:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    			newLeafNode(lv_type_3_0, grammarAccess.getRuleCallAttribute2Access().getTypeIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleCallAttribute2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"type",
                            		lv_type_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getRuleCallAttribute2Access().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleRuleCallAttribute2"


    // $ANTLR start "entryRuleCallMe2"
    // InternalBug287988TestLanguage.g:743:1: entryRuleCallMe2 returns [EObject current=null] : iv_ruleCallMe2= ruleCallMe2 EOF ;
    public final EObject entryRuleCallMe2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe2 = null;


        try {
            // InternalBug287988TestLanguage.g:744:2: (iv_ruleCallMe2= ruleCallMe2 EOF )
            // InternalBug287988TestLanguage.g:745:2: iv_ruleCallMe2= ruleCallMe2 EOF
            {
             newCompositeNode(grammarAccess.getCallMe2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe2=ruleCallMe2();

            state._fsp--;

             current =iv_ruleCallMe2; 
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
    // $ANTLR end "entryRuleCallMe2"


    // $ANTLR start "ruleCallMe2"
    // InternalBug287988TestLanguage.g:752:1: ruleCallMe2 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:755:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalBug287988TestLanguage.g:756:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalBug287988TestLanguage.g:756:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalBug287988TestLanguage.g:757:1: (lv_name_0_0= RULE_ID )
            {
            // InternalBug287988TestLanguage.g:757:1: (lv_name_0_0= RULE_ID )
            // InternalBug287988TestLanguage.g:758:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCallMe2Access().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCallMe2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleCallMe2"


    // $ANTLR start "entryRuleRuleCallAttribute3"
    // InternalBug287988TestLanguage.g:782:1: entryRuleRuleCallAttribute3 returns [EObject current=null] : iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF ;
    public final EObject entryRuleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute3 = null;


        try {
            // InternalBug287988TestLanguage.g:783:2: (iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF )
            // InternalBug287988TestLanguage.g:784:2: iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF
            {
             newCompositeNode(grammarAccess.getRuleCallAttribute3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallAttribute3=ruleRuleCallAttribute3();

            state._fsp--;

             current =iv_ruleRuleCallAttribute3; 
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
    // $ANTLR end "entryRuleRuleCallAttribute3"


    // $ANTLR start "ruleRuleCallAttribute3"
    // InternalBug287988TestLanguage.g:791:1: ruleRuleCallAttribute3 returns [EObject current=null] : (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final EObject ruleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        EObject this_CallMe3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:794:28: ( (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // InternalBug287988TestLanguage.g:795:1: (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // InternalBug287988TestLanguage.g:795:1: (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // InternalBug287988TestLanguage.g:796:5: this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {
             
                    newCompositeNode(grammarAccess.getRuleCallAttribute3Access().getCallMe3ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_7);
            this_CallMe3_0=ruleCallMe3();

            state._fsp--;

             
                    current = this_CallMe3_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalBug287988TestLanguage.g:804:1: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalBug287988TestLanguage.g:804:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalBug287988TestLanguage.g:804:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // InternalBug287988TestLanguage.g:804:4: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleCallAttribute3Access().getRefKeyword_1_0_0());
                        
                    // InternalBug287988TestLanguage.g:808:1: ( (otherlv_2= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:809:1: (otherlv_2= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:809:1: (otherlv_2= RULE_ID )
                    // InternalBug287988TestLanguage.g:810:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleCallAttribute3Rule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    		newLeafNode(otherlv_2, grammarAccess.getRuleCallAttribute3Access().getTypeRefBaseAttributeCrossReference_1_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287988TestLanguage.g:822:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // InternalBug287988TestLanguage.g:822:6: ( (lv_type_3_0= RULE_ID ) )
                    // InternalBug287988TestLanguage.g:823:1: (lv_type_3_0= RULE_ID )
                    {
                    // InternalBug287988TestLanguage.g:823:1: (lv_type_3_0= RULE_ID )
                    // InternalBug287988TestLanguage.g:824:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    			newLeafNode(lv_type_3_0, grammarAccess.getRuleCallAttribute3Access().getTypeIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleCallAttribute3Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"type",
                            		lv_type_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getRuleCallAttribute3Access().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleRuleCallAttribute3"


    // $ANTLR start "entryRuleCallMe3"
    // InternalBug287988TestLanguage.g:852:1: entryRuleCallMe3 returns [EObject current=null] : iv_ruleCallMe3= ruleCallMe3 EOF ;
    public final EObject entryRuleCallMe3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe3 = null;


        try {
            // InternalBug287988TestLanguage.g:853:2: (iv_ruleCallMe3= ruleCallMe3 EOF )
            // InternalBug287988TestLanguage.g:854:2: iv_ruleCallMe3= ruleCallMe3 EOF
            {
             newCompositeNode(grammarAccess.getCallMe3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe3=ruleCallMe3();

            state._fsp--;

             current =iv_ruleCallMe3; 
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
    // $ANTLR end "entryRuleCallMe3"


    // $ANTLR start "ruleCallMe3"
    // InternalBug287988TestLanguage.g:861:1: ruleCallMe3 returns [EObject current=null] : (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 ) ;
    public final EObject ruleCallMe3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_CallMe4_2 = null;


         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:864:28: ( (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 ) )
            // InternalBug287988TestLanguage.g:865:1: (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 )
            {
            // InternalBug287988TestLanguage.g:865:1: (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 )
            // InternalBug287988TestLanguage.g:865:3: otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getCallMe3Access().getCallKeyword_0());
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getCallMe3Access().getMeKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getCallMe3Access().getCallMe4ParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_CallMe4_2=ruleCallMe4();

            state._fsp--;

             
                    current = this_CallMe4_2; 
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
        }
        return current;
    }
    // $ANTLR end "ruleCallMe3"


    // $ANTLR start "entryRuleCallMe4"
    // InternalBug287988TestLanguage.g:890:1: entryRuleCallMe4 returns [EObject current=null] : iv_ruleCallMe4= ruleCallMe4 EOF ;
    public final EObject entryRuleCallMe4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe4 = null;


        try {
            // InternalBug287988TestLanguage.g:891:2: (iv_ruleCallMe4= ruleCallMe4 EOF )
            // InternalBug287988TestLanguage.g:892:2: iv_ruleCallMe4= ruleCallMe4 EOF
            {
             newCompositeNode(grammarAccess.getCallMe4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe4=ruleCallMe4();

            state._fsp--;

             current =iv_ruleCallMe4; 
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
    // $ANTLR end "entryRuleCallMe4"


    // $ANTLR start "ruleCallMe4"
    // InternalBug287988TestLanguage.g:899:1: ruleCallMe4 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe4() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalBug287988TestLanguage.g:902:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalBug287988TestLanguage.g:903:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalBug287988TestLanguage.g:903:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalBug287988TestLanguage.g:904:1: (lv_name_0_0= RULE_ID )
            {
            // InternalBug287988TestLanguage.g:904:1: (lv_name_0_0= RULE_ID )
            // InternalBug287988TestLanguage.g:905:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCallMe4Access().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCallMe4Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleCallMe4"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    }


}