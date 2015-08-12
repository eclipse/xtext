package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug307519TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug307519TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo'", "'%'", "'$'", "'T1'", "'T2'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug307519TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug307519TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug307519TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g"; }



     	private Bug307519TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug307519TestLanguageParser(TokenStream input, Bug307519TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug307519TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_e1_0_0= ruleElem1 ) ) | ( (lv_e2_1_0= ruleElem2 ) ) )+ ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_e1_0_0 = null;

        EObject lv_e2_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:80:28: ( ( ( (lv_e1_0_0= ruleElem1 ) ) | ( (lv_e2_1_0= ruleElem2 ) ) )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:81:1: ( ( (lv_e1_0_0= ruleElem1 ) ) | ( (lv_e2_1_0= ruleElem2 ) ) )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:81:1: ( ( (lv_e1_0_0= ruleElem1 ) ) | ( (lv_e2_1_0= ruleElem2 ) ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==11) ) {
                        alt1=2;
                    }
                    else if ( (LA1_2==EOF||(LA1_2>=14 && LA1_2<=15)) ) {
                        alt1=1;
                    }


                }
                else if ( (LA1_0==15) ) {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==EOF||(LA1_3>=14 && LA1_3<=15)) ) {
                        alt1=1;
                    }
                    else if ( (LA1_3==11) ) {
                        alt1=2;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:81:2: ( (lv_e1_0_0= ruleElem1 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:81:2: ( (lv_e1_0_0= ruleElem1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:82:1: (lv_e1_0_0= ruleElem1 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:82:1: (lv_e1_0_0= ruleElem1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:83:3: lv_e1_0_0= ruleElem1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getE1Elem1ParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElem1_in_ruleModel131);
            	    lv_e1_0_0=ruleElem1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"e1",
            	            		lv_e1_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug307519TestLanguage.Elem1");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:100:6: ( (lv_e2_1_0= ruleElem2 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:100:6: ( (lv_e2_1_0= ruleElem2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:101:1: (lv_e2_1_0= ruleElem2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:101:1: (lv_e2_1_0= ruleElem2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:102:3: lv_e2_1_0= ruleElem2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getE2Elem2ParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElem2_in_ruleModel158);
            	    lv_e2_1_0=ruleElem2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"e2",
            	            		lv_e2_1_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug307519TestLanguage.Elem2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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


    // $ANTLR start "entryRuleElem1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:126:1: entryRuleElem1 returns [EObject current=null] : iv_ruleElem1= ruleElem1 EOF ;
    public final EObject entryRuleElem1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElem1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:127:2: (iv_ruleElem1= ruleElem1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:128:2: iv_ruleElem1= ruleElem1 EOF
            {
             newCompositeNode(grammarAccess.getElem1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem1_in_entryRuleElem1195);
            iv_ruleElem1=ruleElem1();

            state._fsp--;

             current =iv_ruleElem1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElem1205); 

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
    // $ANTLR end "entryRuleElem1"


    // $ANTLR start "ruleElem1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:135:1: ruleElem1 returns [EObject current=null] : ( (lv_value_0_0= ruleEnumT ) ) ;
    public final EObject ruleElem1() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:138:28: ( ( (lv_value_0_0= ruleEnumT ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:139:1: ( (lv_value_0_0= ruleEnumT ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:139:1: ( (lv_value_0_0= ruleEnumT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:140:1: (lv_value_0_0= ruleEnumT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:140:1: (lv_value_0_0= ruleEnumT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:141:3: lv_value_0_0= ruleEnumT
            {
             
            	        newCompositeNode(grammarAccess.getElem1Access().getValueEnumTEnumRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumT_in_ruleElem1250);
            lv_value_0_0=ruleEnumT();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getElem1Rule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug307519TestLanguage.EnumT");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleElem1"


    // $ANTLR start "entryRuleElem2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:165:1: entryRuleElem2 returns [EObject current=null] : iv_ruleElem2= ruleElem2 EOF ;
    public final EObject entryRuleElem2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElem2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:166:2: (iv_ruleElem2= ruleElem2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:167:2: iv_ruleElem2= ruleElem2 EOF
            {
             newCompositeNode(grammarAccess.getElem2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem2_in_entryRuleElem2285);
            iv_ruleElem2=ruleElem2();

            state._fsp--;

             current =iv_ruleElem2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElem2295); 

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
    // $ANTLR end "entryRuleElem2"


    // $ANTLR start "ruleElem2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:174:1: ruleElem2 returns [EObject current=null] : ( ( (lv_value_0_0= ruleEnumT ) ) otherlv_1= 'foo' otherlv_2= '%' otherlv_3= '$' ) ;
    public final EObject ruleElem2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:177:28: ( ( ( (lv_value_0_0= ruleEnumT ) ) otherlv_1= 'foo' otherlv_2= '%' otherlv_3= '$' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:178:1: ( ( (lv_value_0_0= ruleEnumT ) ) otherlv_1= 'foo' otherlv_2= '%' otherlv_3= '$' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:178:1: ( ( (lv_value_0_0= ruleEnumT ) ) otherlv_1= 'foo' otherlv_2= '%' otherlv_3= '$' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:178:2: ( (lv_value_0_0= ruleEnumT ) ) otherlv_1= 'foo' otherlv_2= '%' otherlv_3= '$'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:178:2: ( (lv_value_0_0= ruleEnumT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:179:1: (lv_value_0_0= ruleEnumT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:179:1: (lv_value_0_0= ruleEnumT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:180:3: lv_value_0_0= ruleEnumT
            {
             
            	        newCompositeNode(grammarAccess.getElem2Access().getValueEnumTEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumT_in_ruleElem2341);
            lv_value_0_0=ruleEnumT();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getElem2Rule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug307519TestLanguage.EnumT");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElem2353); 

                	newLeafNode(otherlv_1, grammarAccess.getElem2Access().getFooKeyword_1());
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleElem2365); 

                	newLeafNode(otherlv_2, grammarAccess.getElem2Access().getPercentSignKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleElem2377); 

                	newLeafNode(otherlv_3, grammarAccess.getElem2Access().getDollarSignKeyword_3());
                

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
    // $ANTLR end "ruleElem2"


    // $ANTLR start "ruleEnumT"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:216:1: ruleEnumT returns [Enumerator current=null] : ( (enumLiteral_0= 'T1' ) | (enumLiteral_1= 'T2' ) ) ;
    public final Enumerator ruleEnumT() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:218:28: ( ( (enumLiteral_0= 'T1' ) | (enumLiteral_1= 'T2' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:219:1: ( (enumLiteral_0= 'T1' ) | (enumLiteral_1= 'T2' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:219:1: ( (enumLiteral_0= 'T1' ) | (enumLiteral_1= 'T2' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:219:2: (enumLiteral_0= 'T1' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:219:2: (enumLiteral_0= 'T1' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:219:4: enumLiteral_0= 'T1'
                    {
                    enumLiteral_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEnumT427); 

                            current = grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:225:6: (enumLiteral_1= 'T2' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:225:6: (enumLiteral_1= 'T2' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug307519TestLanguage.g:225:8: enumLiteral_1= 'T2'
                    {
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumT444); 

                            current = grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleEnumT"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElem1_in_ruleModel131 = new BitSet(new long[]{0x000000000000C002L});
        public static final BitSet FOLLOW_ruleElem2_in_ruleModel158 = new BitSet(new long[]{0x000000000000C002L});
        public static final BitSet FOLLOW_ruleElem1_in_entryRuleElem1195 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElem1205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumT_in_ruleElem1250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElem2_in_entryRuleElem2285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElem2295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumT_in_ruleElem2341 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleElem2353 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleElem2365 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleElem2377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleEnumT427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEnumT444 = new BitSet(new long[]{0x0000000000000002L});
    }


}