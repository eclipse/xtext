package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.services.Bug287988TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug287988TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'actions'", "'simple'", "'rulecall'", "'rulecall2'", "'rulecall3'", "'inlinedActions'", "'ref'", "';'", "'attribute'", "'master'", "'call'", "'me'"
    };
    public static final int RULE_ID=4;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalBug287988TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug287988TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug287988TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug287988TestLanguage.g"; }



    	protected Bug287988TestLanguageGrammarAccess grammarAccess;

    	protected Bug287988TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug287988TestLanguageParser(PsiBuilder builder, TokenStream input, Bug287988TestLanguageElementTypeProvider elementTypeProvider, Bug287988TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalBug287988TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalBug287988TestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBug287988TestLanguage.g:58:1: ruleModel : ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;

        try {
            // PsiInternalBug287988TestLanguage.g:58:10: ( ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) )
            // PsiInternalBug287988TestLanguage.g:59:2: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            {
            // PsiInternalBug287988TestLanguage.g:59:2: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
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
                    // PsiInternalBug287988TestLanguage.g:60:3: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:60:3: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:61:4: otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_ActionsKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug287988TestLanguage.g:68:4: ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=19 && LA1_0<=20)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:69:5: (lv_attributes_1_0= ruleBaseAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:69:5: (lv_attributes_1_0= ruleBaseAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:70:6: lv_attributes_1_0= ruleBaseAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesBaseAttributeParserRuleCall_0_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    ruleBaseAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:81:3: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:81:3: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:82:4: otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_SimpleKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalBug287988TestLanguage.g:89:4: ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:90:5: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:90:5: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:91:6: lv_attributes_3_0= ruleSimpleAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesSimpleAttributeParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    ruleSimpleAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:102:3: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:102:3: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:103:4: otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_RulecallKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalBug287988TestLanguage.g:110:4: ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:111:5: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:111:5: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:112:6: lv_attributes_5_0= ruleRuleCallAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesRuleCallAttributeParserRuleCall_2_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    ruleRuleCallAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:123:3: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:123:3: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    // PsiInternalBug287988TestLanguage.g:124:4: otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_Rulecall2Keyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalBug287988TestLanguage.g:131:4: ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:132:5: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:132:5: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    // PsiInternalBug287988TestLanguage.g:133:6: lv_attributes_7_0= ruleRuleCallAttribute2
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesRuleCallAttribute2ParserRuleCall_3_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    ruleRuleCallAttribute2();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:144:3: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:144:3: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    // PsiInternalBug287988TestLanguage.g:145:4: otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_Rulecall3Keyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalBug287988TestLanguage.g:152:4: ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:153:5: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:153:5: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    // PsiInternalBug287988TestLanguage.g:154:6: lv_attributes_9_0= ruleRuleCallAttribute3
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesRuleCallAttribute3ParserRuleCall_4_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    ruleRuleCallAttribute3();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:165:3: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:165:3: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:166:4: otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_InlinedActionsKeyword_5_0ElementType());
                    			
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalBug287988TestLanguage.g:173:4: ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:174:5: (lv_attributes_11_0= ruleActionAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:174:5: (lv_attributes_11_0= ruleActionAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:175:6: lv_attributes_11_0= ruleActionAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesActionAttributeParserRuleCall_5_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    ruleActionAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleBaseAttribute"
    // PsiInternalBug287988TestLanguage.g:189:1: entryRuleBaseAttribute : ruleBaseAttribute EOF ;
    public final void entryRuleBaseAttribute() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:189:23: ( ruleBaseAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:190:2: ruleBaseAttribute EOF
            {
             markComposite(elementTypeProvider.getBaseAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBaseAttribute();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBaseAttribute"


    // $ANTLR start "ruleBaseAttribute"
    // PsiInternalBug287988TestLanguage.g:195:1: ruleBaseAttribute : ( ( ruleAttribute | ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) ;
    public final void ruleBaseAttribute() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;

        try {
            // PsiInternalBug287988TestLanguage.g:195:18: ( ( ( ruleAttribute | ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) )
            // PsiInternalBug287988TestLanguage.g:196:2: ( ( ruleAttribute | ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:196:2: ( ( ruleAttribute | ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            // PsiInternalBug287988TestLanguage.g:197:3: ( ruleAttribute | ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';'
            {
            // PsiInternalBug287988TestLanguage.g:197:3: ( ruleAttribute | ruleMaster )
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
                    // PsiInternalBug287988TestLanguage.g:198:4: ruleAttribute
                    {

                    				markComposite(elementTypeProvider.getBaseAttribute_AttributeParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleAttribute();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:206:4: ruleMaster
                    {

                    				markComposite(elementTypeProvider.getBaseAttribute_MasterParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleMaster();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:214:3: ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:215:4: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:215:4: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:216:5: otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getBaseAttribute_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalBug287988TestLanguage.g:223:5: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:224:6: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:224:6: (otherlv_3= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:225:7: otherlv_3= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getBaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:236:4: ( (lv_type_4_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:236:4: ( (lv_type_4_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:237:5: (lv_type_4_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:237:5: (lv_type_4_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:238:6: lv_type_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getBaseAttribute_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_type_4_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:248:3: ( (lv_name_5_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:249:4: (lv_name_5_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:249:4: (lv_name_5_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:250:5: lv_name_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBaseAttribute_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_name_5_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBaseAttribute_SemicolonKeyword_3ElementType());
            		
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleBaseAttribute"


    // $ANTLR start "entryRuleAttribute"
    // PsiInternalBug287988TestLanguage.g:270:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:270:19: ( ruleAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:271:2: ruleAttribute EOF
            {
             markComposite(elementTypeProvider.getAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttribute();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // PsiInternalBug287988TestLanguage.g:276:1: ruleAttribute : ( () otherlv_1= 'attribute' ) ;
    public final void ruleAttribute() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalBug287988TestLanguage.g:276:14: ( ( () otherlv_1= 'attribute' ) )
            // PsiInternalBug287988TestLanguage.g:277:2: ( () otherlv_1= 'attribute' )
            {
            // PsiInternalBug287988TestLanguage.g:277:2: ( () otherlv_1= 'attribute' )
            // PsiInternalBug287988TestLanguage.g:278:3: () otherlv_1= 'attribute'
            {
            // PsiInternalBug287988TestLanguage.g:278:3: ()
            // PsiInternalBug287988TestLanguage.g:279:4: 
            {

            				precedeComposite(elementTypeProvider.getAttribute_AttributeAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getAttribute_AttributeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleMaster"
    // PsiInternalBug287988TestLanguage.g:295:1: entryRuleMaster : ruleMaster EOF ;
    public final void entryRuleMaster() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:295:16: ( ruleMaster EOF )
            // PsiInternalBug287988TestLanguage.g:296:2: ruleMaster EOF
            {
             markComposite(elementTypeProvider.getMasterElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMaster();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMaster"


    // $ANTLR start "ruleMaster"
    // PsiInternalBug287988TestLanguage.g:301:1: ruleMaster : ( () otherlv_1= 'master' ) ;
    public final void ruleMaster() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalBug287988TestLanguage.g:301:11: ( ( () otherlv_1= 'master' ) )
            // PsiInternalBug287988TestLanguage.g:302:2: ( () otherlv_1= 'master' )
            {
            // PsiInternalBug287988TestLanguage.g:302:2: ( () otherlv_1= 'master' )
            // PsiInternalBug287988TestLanguage.g:303:3: () otherlv_1= 'master'
            {
            // PsiInternalBug287988TestLanguage.g:303:3: ()
            // PsiInternalBug287988TestLanguage.g:304:4: 
            {

            				precedeComposite(elementTypeProvider.getMaster_MasterAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getMaster_MasterKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleMaster"


    // $ANTLR start "entryRuleActionAttribute"
    // PsiInternalBug287988TestLanguage.g:320:1: entryRuleActionAttribute : ruleActionAttribute EOF ;
    public final void entryRuleActionAttribute() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:320:25: ( ruleActionAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:321:2: ruleActionAttribute EOF
            {
             markComposite(elementTypeProvider.getActionAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleActionAttribute();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActionAttribute"


    // $ANTLR start "ruleActionAttribute"
    // PsiInternalBug287988TestLanguage.g:326:1: ruleActionAttribute : ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) ;
    public final void ruleActionAttribute() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_type_6_0=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;

        try {
            // PsiInternalBug287988TestLanguage.g:326:20: ( ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) )
            // PsiInternalBug287988TestLanguage.g:327:2: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:327:2: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            // PsiInternalBug287988TestLanguage.g:328:3: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';'
            {
            // PsiInternalBug287988TestLanguage.g:328:3: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) )
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
                    // PsiInternalBug287988TestLanguage.g:329:4: ( () otherlv_1= 'attribute' )
                    {
                    // PsiInternalBug287988TestLanguage.g:329:4: ( () otherlv_1= 'attribute' )
                    // PsiInternalBug287988TestLanguage.g:330:5: () otherlv_1= 'attribute'
                    {
                    // PsiInternalBug287988TestLanguage.g:330:5: ()
                    // PsiInternalBug287988TestLanguage.g:331:6: 
                    {

                    						precedeComposite(elementTypeProvider.getActionAttribute_AttributeAction_0_0_0ElementType());
                    						doneComposite();
                    					

                    }


                    					markLeaf(elementTypeProvider.getActionAttribute_AttributeKeyword_0_0_1ElementType());
                    				
                    otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_7); 

                    					doneLeaf(otherlv_1);
                    				

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:345:4: ( () otherlv_3= 'master' )
                    {
                    // PsiInternalBug287988TestLanguage.g:345:4: ( () otherlv_3= 'master' )
                    // PsiInternalBug287988TestLanguage.g:346:5: () otherlv_3= 'master'
                    {
                    // PsiInternalBug287988TestLanguage.g:346:5: ()
                    // PsiInternalBug287988TestLanguage.g:347:6: 
                    {

                    						precedeComposite(elementTypeProvider.getActionAttribute_MasterAction_0_1_0ElementType());
                    						doneComposite();
                    					

                    }


                    					markLeaf(elementTypeProvider.getActionAttribute_MasterKeyword_0_1_1ElementType());
                    				
                    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_7); 

                    					doneLeaf(otherlv_3);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:361:3: ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:362:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:362:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:363:5: otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getActionAttribute_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalBug287988TestLanguage.g:370:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:371:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:371:6: (otherlv_5= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:372:7: otherlv_5= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:383:4: ( (lv_type_6_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:383:4: ( (lv_type_6_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:384:5: (lv_type_6_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:384:5: (lv_type_6_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:385:6: lv_type_6_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getActionAttribute_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_type_6_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:395:3: ( (lv_name_7_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:396:4: (lv_name_7_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:396:4: (lv_name_7_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:397:5: lv_name_7_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getActionAttribute_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_name_7_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getActionAttribute_SemicolonKeyword_3ElementType());
            		
            otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_8);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleActionAttribute"


    // $ANTLR start "entryRuleSimpleAttribute"
    // PsiInternalBug287988TestLanguage.g:417:1: entryRuleSimpleAttribute : ruleSimpleAttribute EOF ;
    public final void entryRuleSimpleAttribute() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:417:25: ( ruleSimpleAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:418:2: ruleSimpleAttribute EOF
            {
             markComposite(elementTypeProvider.getSimpleAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleAttribute();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleAttribute"


    // $ANTLR start "ruleSimpleAttribute"
    // PsiInternalBug287988TestLanguage.g:423:1: ruleSimpleAttribute : ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) ;
    public final void ruleSimpleAttribute() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalBug287988TestLanguage.g:423:20: ( ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) )
            // PsiInternalBug287988TestLanguage.g:424:2: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:424:2: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            // PsiInternalBug287988TestLanguage.g:425:3: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';'
            {
            // PsiInternalBug287988TestLanguage.g:425:3: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:426:4: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:426:4: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:427:5: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAttribute_RefKeyword_0_0_0ElementType());
                    				
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_0);
                    				
                    // PsiInternalBug287988TestLanguage.g:434:5: ( (otherlv_1= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:435:6: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:435:6: (otherlv_1= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:436:7: otherlv_1= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getSimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0ElementType());
                    						
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    							doneLeaf(otherlv_1);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:447:4: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:447:4: ( (lv_type_2_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:448:5: (lv_type_2_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:448:5: (lv_type_2_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:449:6: lv_type_2_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSimpleAttribute_TypeIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_type_2_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:459:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:460:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:460:4: (lv_name_3_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:461:5: lv_name_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleAttribute_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_name_3_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSimpleAttribute_SemicolonKeyword_2ElementType());
            		
            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleSimpleAttribute"


    // $ANTLR start "entryRuleRuleCallAttribute"
    // PsiInternalBug287988TestLanguage.g:481:1: entryRuleRuleCallAttribute : ruleRuleCallAttribute EOF ;
    public final void entryRuleRuleCallAttribute() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:481:27: ( ruleRuleCallAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:482:2: ruleRuleCallAttribute EOF
            {
             markComposite(elementTypeProvider.getRuleCallAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleCallAttribute();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleCallAttribute"


    // $ANTLR start "ruleRuleCallAttribute"
    // PsiInternalBug287988TestLanguage.g:487:1: ruleRuleCallAttribute : ( ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final void ruleRuleCallAttribute() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug287988TestLanguage.g:487:22: ( ( ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // PsiInternalBug287988TestLanguage.g:488:2: ( ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:488:2: ( ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // PsiInternalBug287988TestLanguage.g:489:3: ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markComposite(elementTypeProvider.getRuleCallAttribute_CallMeParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_8);
            ruleCallMe();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug287988TestLanguage.g:496:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:497:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:497:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:498:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRuleCallAttribute_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getRuleCallAttribute_SemicolonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleRuleCallAttribute"


    // $ANTLR start "entryRuleCallMe"
    // PsiInternalBug287988TestLanguage.g:518:1: entryRuleCallMe : ruleCallMe EOF ;
    public final void entryRuleCallMe() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:518:16: ( ruleCallMe EOF )
            // PsiInternalBug287988TestLanguage.g:519:2: ruleCallMe EOF
            {
             markComposite(elementTypeProvider.getCallMeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCallMe();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallMe"


    // $ANTLR start "ruleCallMe"
    // PsiInternalBug287988TestLanguage.g:524:1: ruleCallMe : ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final void ruleCallMe() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;

        try {
            // PsiInternalBug287988TestLanguage.g:524:11: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) )
            // PsiInternalBug287988TestLanguage.g:525:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            {
            // PsiInternalBug287988TestLanguage.g:525:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:526:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:526:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:527:4: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getCallMe_RefKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug287988TestLanguage.g:534:4: ( (otherlv_1= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:535:5: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:535:5: (otherlv_1= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:536:6: otherlv_1= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getCallMe_TypeRefBaseAttributeCrossReference_0_1_0ElementType());
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_1);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:547:3: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:547:3: ( (lv_type_2_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:548:4: (lv_type_2_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:548:4: (lv_type_2_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:549:5: lv_type_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getCallMe_TypeIDTerminalRuleCall_1_0ElementType());
                    				
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_type_2_0);
                    				

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleCallMe"


    // $ANTLR start "entryRuleRuleCallAttribute2"
    // PsiInternalBug287988TestLanguage.g:562:1: entryRuleRuleCallAttribute2 : ruleRuleCallAttribute2 EOF ;
    public final void entryRuleRuleCallAttribute2() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:562:28: ( ruleRuleCallAttribute2 EOF )
            // PsiInternalBug287988TestLanguage.g:563:2: ruleRuleCallAttribute2 EOF
            {
             markComposite(elementTypeProvider.getRuleCallAttribute2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleCallAttribute2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleCallAttribute2"


    // $ANTLR start "ruleRuleCallAttribute2"
    // PsiInternalBug287988TestLanguage.g:568:1: ruleRuleCallAttribute2 : ( ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final void ruleRuleCallAttribute2() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalBug287988TestLanguage.g:568:23: ( ( ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // PsiInternalBug287988TestLanguage.g:569:2: ( ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:569:2: ( ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // PsiInternalBug287988TestLanguage.g:570:3: ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {

            			markComposite(elementTypeProvider.getRuleCallAttribute2_CallMe2ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            ruleCallMe2();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug287988TestLanguage.g:577:3: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:578:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:578:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:579:5: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getRuleCallAttribute2_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalBug287988TestLanguage.g:586:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:587:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:587:6: (otherlv_2= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:588:7: otherlv_2= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getRuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:599:4: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:599:4: ( (lv_type_3_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:600:5: (lv_type_3_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:600:5: (lv_type_3_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:601:6: lv_type_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getRuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						doneLeaf(lv_type_3_0);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getRuleCallAttribute2_SemicolonKeyword_2ElementType());
            		
            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleRuleCallAttribute2"


    // $ANTLR start "entryRuleCallMe2"
    // PsiInternalBug287988TestLanguage.g:622:1: entryRuleCallMe2 : ruleCallMe2 EOF ;
    public final void entryRuleCallMe2() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:622:17: ( ruleCallMe2 EOF )
            // PsiInternalBug287988TestLanguage.g:623:2: ruleCallMe2 EOF
            {
             markComposite(elementTypeProvider.getCallMe2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCallMe2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallMe2"


    // $ANTLR start "ruleCallMe2"
    // PsiInternalBug287988TestLanguage.g:628:1: ruleCallMe2 : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleCallMe2() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalBug287988TestLanguage.g:628:12: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalBug287988TestLanguage.g:629:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalBug287988TestLanguage.g:629:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:630:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:630:3: (lv_name_0_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:631:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getCallMe2_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_name_0_0);
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleCallMe2"


    // $ANTLR start "entryRuleRuleCallAttribute3"
    // PsiInternalBug287988TestLanguage.g:643:1: entryRuleRuleCallAttribute3 : ruleRuleCallAttribute3 EOF ;
    public final void entryRuleRuleCallAttribute3() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:643:28: ( ruleRuleCallAttribute3 EOF )
            // PsiInternalBug287988TestLanguage.g:644:2: ruleRuleCallAttribute3 EOF
            {
             markComposite(elementTypeProvider.getRuleCallAttribute3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleCallAttribute3();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleCallAttribute3"


    // $ANTLR start "ruleRuleCallAttribute3"
    // PsiInternalBug287988TestLanguage.g:649:1: ruleRuleCallAttribute3 : ( ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final void ruleRuleCallAttribute3() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalBug287988TestLanguage.g:649:23: ( ( ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // PsiInternalBug287988TestLanguage.g:650:2: ( ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:650:2: ( ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // PsiInternalBug287988TestLanguage.g:651:3: ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {

            			markComposite(elementTypeProvider.getRuleCallAttribute3_CallMe3ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            ruleCallMe3();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug287988TestLanguage.g:658:3: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:659:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:659:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:660:5: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getRuleCallAttribute3_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalBug287988TestLanguage.g:667:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:668:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:668:6: (otherlv_2= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:669:7: otherlv_2= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getRuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:680:4: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:680:4: ( (lv_type_3_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:681:5: (lv_type_3_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:681:5: (lv_type_3_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:682:6: lv_type_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getRuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						doneLeaf(lv_type_3_0);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getRuleCallAttribute3_SemicolonKeyword_2ElementType());
            		
            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleRuleCallAttribute3"


    // $ANTLR start "entryRuleCallMe3"
    // PsiInternalBug287988TestLanguage.g:703:1: entryRuleCallMe3 : ruleCallMe3 EOF ;
    public final void entryRuleCallMe3() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:703:17: ( ruleCallMe3 EOF )
            // PsiInternalBug287988TestLanguage.g:704:2: ruleCallMe3 EOF
            {
             markComposite(elementTypeProvider.getCallMe3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCallMe3();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallMe3"


    // $ANTLR start "ruleCallMe3"
    // PsiInternalBug287988TestLanguage.g:709:1: ruleCallMe3 : (otherlv_0= 'call' otherlv_1= 'me' ruleCallMe4 ) ;
    public final void ruleCallMe3() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalBug287988TestLanguage.g:709:12: ( (otherlv_0= 'call' otherlv_1= 'me' ruleCallMe4 ) )
            // PsiInternalBug287988TestLanguage.g:710:2: (otherlv_0= 'call' otherlv_1= 'me' ruleCallMe4 )
            {
            // PsiInternalBug287988TestLanguage.g:710:2: (otherlv_0= 'call' otherlv_1= 'me' ruleCallMe4 )
            // PsiInternalBug287988TestLanguage.g:711:3: otherlv_0= 'call' otherlv_1= 'me' ruleCallMe4
            {

            			markLeaf(elementTypeProvider.getCallMe3_CallKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getCallMe3_MeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		

            			markComposite(elementTypeProvider.getCallMe3_CallMe4ParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            ruleCallMe4();

            state._fsp--;


            			doneComposite();
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleCallMe3"


    // $ANTLR start "entryRuleCallMe4"
    // PsiInternalBug287988TestLanguage.g:736:1: entryRuleCallMe4 : ruleCallMe4 EOF ;
    public final void entryRuleCallMe4() throws RecognitionException {
        try {
            // PsiInternalBug287988TestLanguage.g:736:17: ( ruleCallMe4 EOF )
            // PsiInternalBug287988TestLanguage.g:737:2: ruleCallMe4 EOF
            {
             markComposite(elementTypeProvider.getCallMe4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCallMe4();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallMe4"


    // $ANTLR start "ruleCallMe4"
    // PsiInternalBug287988TestLanguage.g:742:1: ruleCallMe4 : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleCallMe4() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalBug287988TestLanguage.g:742:12: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalBug287988TestLanguage.g:743:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalBug287988TestLanguage.g:743:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:744:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:744:3: (lv_name_0_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:745:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getCallMe4_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_name_0_0);
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
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