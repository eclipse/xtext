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
    // PsiInternalBug287988TestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug287988TestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug287988TestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBug287988TestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Boolean lv_attributes_1_0 = null;

        Boolean lv_attributes_3_0 = null;

        Boolean lv_attributes_5_0 = null;

        Boolean lv_attributes_7_0 = null;

        Boolean lv_attributes_9_0 = null;

        Boolean lv_attributes_11_0 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:60:1: ( ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) )
            // PsiInternalBug287988TestLanguage.g:61:2: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            {
            // PsiInternalBug287988TestLanguage.g:61:2: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
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
                    // PsiInternalBug287988TestLanguage.g:62:3: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:62:3: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:63:4: otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_ActionsKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug287988TestLanguage.g:70:4: ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=19 && LA1_0<=20)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:71:5: (lv_attributes_1_0= ruleBaseAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:71:5: (lv_attributes_1_0= ruleBaseAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:72:6: lv_attributes_1_0= ruleBaseAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesBaseAttributeParserRuleCall_0_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_attributes_1_0=ruleBaseAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:87:3: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:87:3: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:88:4: otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_SimpleKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalBug287988TestLanguage.g:95:4: ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:96:5: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:96:5: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:97:6: lv_attributes_3_0= ruleSimpleAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesSimpleAttributeParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_attributes_3_0=ruleSimpleAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:112:3: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:112:3: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:113:4: otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_RulecallKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalBug287988TestLanguage.g:120:4: ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:121:5: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:121:5: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:122:6: lv_attributes_5_0= ruleRuleCallAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesRuleCallAttributeParserRuleCall_2_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_attributes_5_0=ruleRuleCallAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:137:3: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:137:3: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    // PsiInternalBug287988TestLanguage.g:138:4: otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_Rulecall2Keyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalBug287988TestLanguage.g:145:4: ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:146:5: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:146:5: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    // PsiInternalBug287988TestLanguage.g:147:6: lv_attributes_7_0= ruleRuleCallAttribute2
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesRuleCallAttribute2ParserRuleCall_3_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_attributes_7_0=ruleRuleCallAttribute2();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:162:3: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:162:3: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    // PsiInternalBug287988TestLanguage.g:163:4: otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_Rulecall3Keyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalBug287988TestLanguage.g:170:4: ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:171:5: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:171:5: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    // PsiInternalBug287988TestLanguage.g:172:6: lv_attributes_9_0= ruleRuleCallAttribute3
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesRuleCallAttribute3ParserRuleCall_4_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_attributes_9_0=ruleRuleCallAttribute3();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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
                    // PsiInternalBug287988TestLanguage.g:187:3: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    {
                    // PsiInternalBug287988TestLanguage.g:187:3: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    // PsiInternalBug287988TestLanguage.g:188:4: otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    {

                    				markLeaf(elementTypeProvider.getModel_InlinedActionsKeyword_5_0ElementType());
                    			
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalBug287988TestLanguage.g:195:4: ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // PsiInternalBug287988TestLanguage.g:196:5: (lv_attributes_11_0= ruleActionAttribute )
                    	    {
                    	    // PsiInternalBug287988TestLanguage.g:196:5: (lv_attributes_11_0= ruleActionAttribute )
                    	    // PsiInternalBug287988TestLanguage.g:197:6: lv_attributes_11_0= ruleActionAttribute
                    	    {

                    	    						markComposite(elementTypeProvider.getModel_AttributesActionAttributeParserRuleCall_5_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_attributes_11_0=ruleActionAttribute();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleBaseAttribute"
    // PsiInternalBug287988TestLanguage.g:215:1: entryRuleBaseAttribute returns [Boolean current=false] : iv_ruleBaseAttribute= ruleBaseAttribute EOF ;
    public final Boolean entryRuleBaseAttribute() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBaseAttribute = null;


        try {
            // PsiInternalBug287988TestLanguage.g:215:55: (iv_ruleBaseAttribute= ruleBaseAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:216:2: iv_ruleBaseAttribute= ruleBaseAttribute EOF
            {
             markComposite(elementTypeProvider.getBaseAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBaseAttribute=ruleBaseAttribute();

            state._fsp--;

             current =iv_ruleBaseAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseAttribute"


    // $ANTLR start "ruleBaseAttribute"
    // PsiInternalBug287988TestLanguage.g:222:1: ruleBaseAttribute returns [Boolean current=false] : ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) ;
    public final Boolean ruleBaseAttribute() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Boolean this_Attribute_0 = null;

        Boolean this_Master_1 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:223:1: ( ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) )
            // PsiInternalBug287988TestLanguage.g:224:2: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:224:2: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            // PsiInternalBug287988TestLanguage.g:225:3: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';'
            {
            // PsiInternalBug287988TestLanguage.g:225:3: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster )
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
                    // PsiInternalBug287988TestLanguage.g:226:4: this_Attribute_0= ruleAttribute
                    {

                    				markComposite(elementTypeProvider.getBaseAttribute_AttributeParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_7);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;


                    				current = this_Attribute_0;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:235:4: this_Master_1= ruleMaster
                    {

                    				markComposite(elementTypeProvider.getBaseAttribute_MasterParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_7);
                    this_Master_1=ruleMaster();

                    state._fsp--;


                    				current = this_Master_1;
                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:244:3: ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:245:4: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:245:4: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:246:5: otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getBaseAttribute_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalBug287988TestLanguage.g:253:5: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:254:6: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:254:6: (otherlv_3= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:255:7: otherlv_3= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getBaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:272:4: ( (lv_type_4_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:272:4: ( (lv_type_4_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:273:5: (lv_type_4_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:273:5: (lv_type_4_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:274:6: lv_type_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getBaseAttribute_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_type_4_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:290:3: ( (lv_name_5_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:291:4: (lv_name_5_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:291:4: (lv_name_5_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:292:5: lv_name_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBaseAttribute_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleBaseAttribute"


    // $ANTLR start "entryRuleAttribute"
    // PsiInternalBug287988TestLanguage.g:318:1: entryRuleAttribute returns [Boolean current=false] : iv_ruleAttribute= ruleAttribute EOF ;
    public final Boolean entryRuleAttribute() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAttribute = null;


        try {
            // PsiInternalBug287988TestLanguage.g:318:51: (iv_ruleAttribute= ruleAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:319:2: iv_ruleAttribute= ruleAttribute EOF
            {
             markComposite(elementTypeProvider.getAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // PsiInternalBug287988TestLanguage.g:325:1: ruleAttribute returns [Boolean current=false] : ( () otherlv_1= 'attribute' ) ;
    public final Boolean ruleAttribute() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalBug287988TestLanguage.g:326:1: ( ( () otherlv_1= 'attribute' ) )
            // PsiInternalBug287988TestLanguage.g:327:2: ( () otherlv_1= 'attribute' )
            {
            // PsiInternalBug287988TestLanguage.g:327:2: ( () otherlv_1= 'attribute' )
            // PsiInternalBug287988TestLanguage.g:328:3: () otherlv_1= 'attribute'
            {
            // PsiInternalBug287988TestLanguage.g:328:3: ()
            // PsiInternalBug287988TestLanguage.g:329:4: 
            {

            				precedeComposite(elementTypeProvider.getAttribute_AttributeAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleMaster"
    // PsiInternalBug287988TestLanguage.g:346:1: entryRuleMaster returns [Boolean current=false] : iv_ruleMaster= ruleMaster EOF ;
    public final Boolean entryRuleMaster() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMaster = null;


        try {
            // PsiInternalBug287988TestLanguage.g:346:48: (iv_ruleMaster= ruleMaster EOF )
            // PsiInternalBug287988TestLanguage.g:347:2: iv_ruleMaster= ruleMaster EOF
            {
             markComposite(elementTypeProvider.getMasterElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMaster=ruleMaster();

            state._fsp--;

             current =iv_ruleMaster; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaster"


    // $ANTLR start "ruleMaster"
    // PsiInternalBug287988TestLanguage.g:353:1: ruleMaster returns [Boolean current=false] : ( () otherlv_1= 'master' ) ;
    public final Boolean ruleMaster() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalBug287988TestLanguage.g:354:1: ( ( () otherlv_1= 'master' ) )
            // PsiInternalBug287988TestLanguage.g:355:2: ( () otherlv_1= 'master' )
            {
            // PsiInternalBug287988TestLanguage.g:355:2: ( () otherlv_1= 'master' )
            // PsiInternalBug287988TestLanguage.g:356:3: () otherlv_1= 'master'
            {
            // PsiInternalBug287988TestLanguage.g:356:3: ()
            // PsiInternalBug287988TestLanguage.g:357:4: 
            {

            				precedeComposite(elementTypeProvider.getMaster_MasterAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
        return current;
    }
    // $ANTLR end "ruleMaster"


    // $ANTLR start "entryRuleActionAttribute"
    // PsiInternalBug287988TestLanguage.g:374:1: entryRuleActionAttribute returns [Boolean current=false] : iv_ruleActionAttribute= ruleActionAttribute EOF ;
    public final Boolean entryRuleActionAttribute() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleActionAttribute = null;


        try {
            // PsiInternalBug287988TestLanguage.g:374:57: (iv_ruleActionAttribute= ruleActionAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:375:2: iv_ruleActionAttribute= ruleActionAttribute EOF
            {
             markComposite(elementTypeProvider.getActionAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleActionAttribute=ruleActionAttribute();

            state._fsp--;

             current =iv_ruleActionAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionAttribute"


    // $ANTLR start "ruleActionAttribute"
    // PsiInternalBug287988TestLanguage.g:381:1: ruleActionAttribute returns [Boolean current=false] : ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) ;
    public final Boolean ruleActionAttribute() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_type_6_0=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;

        try {
            // PsiInternalBug287988TestLanguage.g:382:1: ( ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) )
            // PsiInternalBug287988TestLanguage.g:383:2: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:383:2: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            // PsiInternalBug287988TestLanguage.g:384:3: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';'
            {
            // PsiInternalBug287988TestLanguage.g:384:3: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) )
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
                    // PsiInternalBug287988TestLanguage.g:385:4: ( () otherlv_1= 'attribute' )
                    {
                    // PsiInternalBug287988TestLanguage.g:385:4: ( () otherlv_1= 'attribute' )
                    // PsiInternalBug287988TestLanguage.g:386:5: () otherlv_1= 'attribute'
                    {
                    // PsiInternalBug287988TestLanguage.g:386:5: ()
                    // PsiInternalBug287988TestLanguage.g:387:6: 
                    {

                    						precedeComposite(elementTypeProvider.getActionAttribute_AttributeAction_0_0_0ElementType());
                    						doneComposite();
                    						associateWithSemanticElement();
                    					

                    }


                    					markLeaf(elementTypeProvider.getActionAttribute_AttributeKeyword_0_0_1ElementType());
                    				
                    otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_7); 

                    					doneLeaf(otherlv_1);
                    				

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:402:4: ( () otherlv_3= 'master' )
                    {
                    // PsiInternalBug287988TestLanguage.g:402:4: ( () otherlv_3= 'master' )
                    // PsiInternalBug287988TestLanguage.g:403:5: () otherlv_3= 'master'
                    {
                    // PsiInternalBug287988TestLanguage.g:403:5: ()
                    // PsiInternalBug287988TestLanguage.g:404:6: 
                    {

                    						precedeComposite(elementTypeProvider.getActionAttribute_MasterAction_0_1_0ElementType());
                    						doneComposite();
                    						associateWithSemanticElement();
                    					

                    }


                    					markLeaf(elementTypeProvider.getActionAttribute_MasterKeyword_0_1_1ElementType());
                    				
                    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_7); 

                    					doneLeaf(otherlv_3);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:419:3: ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:420:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:420:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:421:5: otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getActionAttribute_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalBug287988TestLanguage.g:428:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:429:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:429:6: (otherlv_5= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:430:7: otherlv_5= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:447:4: ( (lv_type_6_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:447:4: ( (lv_type_6_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:448:5: (lv_type_6_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:448:5: (lv_type_6_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:449:6: lv_type_6_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getActionAttribute_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_type_6_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:465:3: ( (lv_name_7_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:466:4: (lv_name_7_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:466:4: (lv_name_7_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:467:5: lv_name_7_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getActionAttribute_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleActionAttribute"


    // $ANTLR start "entryRuleSimpleAttribute"
    // PsiInternalBug287988TestLanguage.g:493:1: entryRuleSimpleAttribute returns [Boolean current=false] : iv_ruleSimpleAttribute= ruleSimpleAttribute EOF ;
    public final Boolean entryRuleSimpleAttribute() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleAttribute = null;


        try {
            // PsiInternalBug287988TestLanguage.g:493:57: (iv_ruleSimpleAttribute= ruleSimpleAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:494:2: iv_ruleSimpleAttribute= ruleSimpleAttribute EOF
            {
             markComposite(elementTypeProvider.getSimpleAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleAttribute=ruleSimpleAttribute();

            state._fsp--;

             current =iv_ruleSimpleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleAttribute"


    // $ANTLR start "ruleSimpleAttribute"
    // PsiInternalBug287988TestLanguage.g:500:1: ruleSimpleAttribute returns [Boolean current=false] : ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) ;
    public final Boolean ruleSimpleAttribute() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalBug287988TestLanguage.g:501:1: ( ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) )
            // PsiInternalBug287988TestLanguage.g:502:2: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:502:2: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            // PsiInternalBug287988TestLanguage.g:503:3: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';'
            {
            // PsiInternalBug287988TestLanguage.g:503:3: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:504:4: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:504:4: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:505:5: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAttribute_RefKeyword_0_0_0ElementType());
                    				
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_0);
                    				
                    // PsiInternalBug287988TestLanguage.g:512:5: ( (otherlv_1= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:513:6: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:513:6: (otherlv_1= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:514:7: otherlv_1= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getSimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0ElementType());
                    						
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    							doneLeaf(otherlv_1);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:531:4: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:531:4: ( (lv_type_2_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:532:5: (lv_type_2_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:532:5: (lv_type_2_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:533:6: lv_type_2_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSimpleAttribute_TypeIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_type_2_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287988TestLanguage.g:549:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:550:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:550:4: (lv_name_3_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:551:5: lv_name_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleAttribute_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleSimpleAttribute"


    // $ANTLR start "entryRuleRuleCallAttribute"
    // PsiInternalBug287988TestLanguage.g:577:1: entryRuleRuleCallAttribute returns [Boolean current=false] : iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF ;
    public final Boolean entryRuleRuleCallAttribute() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRuleCallAttribute = null;


        try {
            // PsiInternalBug287988TestLanguage.g:577:59: (iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF )
            // PsiInternalBug287988TestLanguage.g:578:2: iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF
            {
             markComposite(elementTypeProvider.getRuleCallAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallAttribute=ruleRuleCallAttribute();

            state._fsp--;

             current =iv_ruleRuleCallAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCallAttribute"


    // $ANTLR start "ruleRuleCallAttribute"
    // PsiInternalBug287988TestLanguage.g:584:1: ruleRuleCallAttribute returns [Boolean current=false] : (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final Boolean ruleRuleCallAttribute() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Boolean this_CallMe_0 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:585:1: ( (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // PsiInternalBug287988TestLanguage.g:586:2: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:586:2: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // PsiInternalBug287988TestLanguage.g:587:3: this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markComposite(elementTypeProvider.getRuleCallAttribute_CallMeParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_8);
            this_CallMe_0=ruleCallMe();

            state._fsp--;


            			current = this_CallMe_0;
            			doneComposite();
            		
            // PsiInternalBug287988TestLanguage.g:595:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:596:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:596:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:597:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRuleCallAttribute_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleRuleCallAttribute"


    // $ANTLR start "entryRuleCallMe"
    // PsiInternalBug287988TestLanguage.g:623:1: entryRuleCallMe returns [Boolean current=false] : iv_ruleCallMe= ruleCallMe EOF ;
    public final Boolean entryRuleCallMe() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCallMe = null;


        try {
            // PsiInternalBug287988TestLanguage.g:623:48: (iv_ruleCallMe= ruleCallMe EOF )
            // PsiInternalBug287988TestLanguage.g:624:2: iv_ruleCallMe= ruleCallMe EOF
            {
             markComposite(elementTypeProvider.getCallMeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe=ruleCallMe();

            state._fsp--;

             current =iv_ruleCallMe; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe"


    // $ANTLR start "ruleCallMe"
    // PsiInternalBug287988TestLanguage.g:630:1: ruleCallMe returns [Boolean current=false] : ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleCallMe() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;

        try {
            // PsiInternalBug287988TestLanguage.g:631:1: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) )
            // PsiInternalBug287988TestLanguage.g:632:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            {
            // PsiInternalBug287988TestLanguage.g:632:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:633:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:633:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:634:4: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getCallMe_RefKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug287988TestLanguage.g:641:4: ( (otherlv_1= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:642:5: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:642:5: (otherlv_1= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:643:6: otherlv_1= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getCallMe_TypeRefBaseAttributeCrossReference_0_1_0ElementType());
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_1);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:660:3: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:660:3: ( (lv_type_2_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:661:4: (lv_type_2_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:661:4: (lv_type_2_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:662:5: lv_type_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getCallMe_TypeIDTerminalRuleCall_1_0ElementType());
                    				
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
    }
    // $ANTLR end "ruleCallMe"


    // $ANTLR start "entryRuleRuleCallAttribute2"
    // PsiInternalBug287988TestLanguage.g:681:1: entryRuleRuleCallAttribute2 returns [Boolean current=false] : iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF ;
    public final Boolean entryRuleRuleCallAttribute2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRuleCallAttribute2 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:681:60: (iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF )
            // PsiInternalBug287988TestLanguage.g:682:2: iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF
            {
             markComposite(elementTypeProvider.getRuleCallAttribute2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallAttribute2=ruleRuleCallAttribute2();

            state._fsp--;

             current =iv_ruleRuleCallAttribute2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCallAttribute2"


    // $ANTLR start "ruleRuleCallAttribute2"
    // PsiInternalBug287988TestLanguage.g:688:1: ruleRuleCallAttribute2 returns [Boolean current=false] : (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final Boolean ruleRuleCallAttribute2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        Boolean this_CallMe2_0 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:689:1: ( (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // PsiInternalBug287988TestLanguage.g:690:2: (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:690:2: (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // PsiInternalBug287988TestLanguage.g:691:3: this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {

            			markComposite(elementTypeProvider.getRuleCallAttribute2_CallMe2ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_CallMe2_0=ruleCallMe2();

            state._fsp--;


            			current = this_CallMe2_0;
            			doneComposite();
            		
            // PsiInternalBug287988TestLanguage.g:699:3: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:700:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:700:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:701:5: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getRuleCallAttribute2_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalBug287988TestLanguage.g:708:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:709:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:709:6: (otherlv_2= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:710:7: otherlv_2= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getRuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:727:4: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:727:4: ( (lv_type_3_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:728:5: (lv_type_3_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:728:5: (lv_type_3_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:729:6: lv_type_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getRuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleRuleCallAttribute2"


    // $ANTLR start "entryRuleCallMe2"
    // PsiInternalBug287988TestLanguage.g:756:1: entryRuleCallMe2 returns [Boolean current=false] : iv_ruleCallMe2= ruleCallMe2 EOF ;
    public final Boolean entryRuleCallMe2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCallMe2 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:756:49: (iv_ruleCallMe2= ruleCallMe2 EOF )
            // PsiInternalBug287988TestLanguage.g:757:2: iv_ruleCallMe2= ruleCallMe2 EOF
            {
             markComposite(elementTypeProvider.getCallMe2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe2=ruleCallMe2();

            state._fsp--;

             current =iv_ruleCallMe2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe2"


    // $ANTLR start "ruleCallMe2"
    // PsiInternalBug287988TestLanguage.g:763:1: ruleCallMe2 returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleCallMe2() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalBug287988TestLanguage.g:764:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalBug287988TestLanguage.g:765:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalBug287988TestLanguage.g:765:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:766:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:766:3: (lv_name_0_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:767:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getCallMe2_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

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
        return current;
    }
    // $ANTLR end "ruleCallMe2"


    // $ANTLR start "entryRuleRuleCallAttribute3"
    // PsiInternalBug287988TestLanguage.g:785:1: entryRuleRuleCallAttribute3 returns [Boolean current=false] : iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF ;
    public final Boolean entryRuleRuleCallAttribute3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRuleCallAttribute3 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:785:60: (iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF )
            // PsiInternalBug287988TestLanguage.g:786:2: iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF
            {
             markComposite(elementTypeProvider.getRuleCallAttribute3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallAttribute3=ruleRuleCallAttribute3();

            state._fsp--;

             current =iv_ruleRuleCallAttribute3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCallAttribute3"


    // $ANTLR start "ruleRuleCallAttribute3"
    // PsiInternalBug287988TestLanguage.g:792:1: ruleRuleCallAttribute3 returns [Boolean current=false] : (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final Boolean ruleRuleCallAttribute3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        Boolean this_CallMe3_0 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:793:1: ( (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // PsiInternalBug287988TestLanguage.g:794:2: (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // PsiInternalBug287988TestLanguage.g:794:2: (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // PsiInternalBug287988TestLanguage.g:795:3: this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {

            			markComposite(elementTypeProvider.getRuleCallAttribute3_CallMe3ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_CallMe3_0=ruleCallMe3();

            state._fsp--;


            			current = this_CallMe3_0;
            			doneComposite();
            		
            // PsiInternalBug287988TestLanguage.g:803:3: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
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
                    // PsiInternalBug287988TestLanguage.g:804:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:804:4: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalBug287988TestLanguage.g:805:5: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getRuleCallAttribute3_RefKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalBug287988TestLanguage.g:812:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:813:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:813:6: (otherlv_2= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:814:7: otherlv_2= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getRuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug287988TestLanguage.g:831:4: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // PsiInternalBug287988TestLanguage.g:831:4: ( (lv_type_3_0= RULE_ID ) )
                    // PsiInternalBug287988TestLanguage.g:832:5: (lv_type_3_0= RULE_ID )
                    {
                    // PsiInternalBug287988TestLanguage.g:832:5: (lv_type_3_0= RULE_ID )
                    // PsiInternalBug287988TestLanguage.g:833:6: lv_type_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getRuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleRuleCallAttribute3"


    // $ANTLR start "entryRuleCallMe3"
    // PsiInternalBug287988TestLanguage.g:860:1: entryRuleCallMe3 returns [Boolean current=false] : iv_ruleCallMe3= ruleCallMe3 EOF ;
    public final Boolean entryRuleCallMe3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCallMe3 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:860:49: (iv_ruleCallMe3= ruleCallMe3 EOF )
            // PsiInternalBug287988TestLanguage.g:861:2: iv_ruleCallMe3= ruleCallMe3 EOF
            {
             markComposite(elementTypeProvider.getCallMe3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe3=ruleCallMe3();

            state._fsp--;

             current =iv_ruleCallMe3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe3"


    // $ANTLR start "ruleCallMe3"
    // PsiInternalBug287988TestLanguage.g:867:1: ruleCallMe3 returns [Boolean current=false] : (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 ) ;
    public final Boolean ruleCallMe3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Boolean this_CallMe4_2 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:868:1: ( (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 ) )
            // PsiInternalBug287988TestLanguage.g:869:2: (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 )
            {
            // PsiInternalBug287988TestLanguage.g:869:2: (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 )
            // PsiInternalBug287988TestLanguage.g:870:3: otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4
            {

            			markLeaf(elementTypeProvider.getCallMe3_CallKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getCallMe3_MeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		

            			markComposite(elementTypeProvider.getCallMe3_CallMe4ParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            this_CallMe4_2=ruleCallMe4();

            state._fsp--;


            			current = this_CallMe4_2;
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
        return current;
    }
    // $ANTLR end "ruleCallMe3"


    // $ANTLR start "entryRuleCallMe4"
    // PsiInternalBug287988TestLanguage.g:896:1: entryRuleCallMe4 returns [Boolean current=false] : iv_ruleCallMe4= ruleCallMe4 EOF ;
    public final Boolean entryRuleCallMe4() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCallMe4 = null;


        try {
            // PsiInternalBug287988TestLanguage.g:896:49: (iv_ruleCallMe4= ruleCallMe4 EOF )
            // PsiInternalBug287988TestLanguage.g:897:2: iv_ruleCallMe4= ruleCallMe4 EOF
            {
             markComposite(elementTypeProvider.getCallMe4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallMe4=ruleCallMe4();

            state._fsp--;

             current =iv_ruleCallMe4; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe4"


    // $ANTLR start "ruleCallMe4"
    // PsiInternalBug287988TestLanguage.g:903:1: ruleCallMe4 returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleCallMe4() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalBug287988TestLanguage.g:904:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalBug287988TestLanguage.g:905:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalBug287988TestLanguage.g:905:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug287988TestLanguage.g:906:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug287988TestLanguage.g:906:3: (lv_name_0_0= RULE_ID )
            // PsiInternalBug287988TestLanguage.g:907:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getCallMe4_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

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