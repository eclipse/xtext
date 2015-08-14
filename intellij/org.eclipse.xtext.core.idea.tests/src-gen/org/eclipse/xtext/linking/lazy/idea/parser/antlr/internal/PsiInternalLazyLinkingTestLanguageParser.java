package org.eclipse.xtext.linking.lazy.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalLazyLinkingTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'extends'", "'.'", "'for'", "'in'", "'{'", "'}'", "';'", "'unresolved'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
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


        public PsiInternalLazyLinkingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalLazyLinkingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalLazyLinkingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalLazyLinkingTestLanguage.g"; }



    	protected LazyLinkingTestLanguageGrammarAccess grammarAccess;

    	protected LazyLinkingTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalLazyLinkingTestLanguageParser(PsiBuilder builder, TokenStream input, LazyLinkingTestLanguageElementTypeProvider elementTypeProvider, LazyLinkingTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalLazyLinkingTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalLazyLinkingTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalLazyLinkingTestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalLazyLinkingTestLanguage.g:58:1: ruleModel : ( (lv_types_0_0= ruleType ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalLazyLinkingTestLanguage.g:58:10: ( ( (lv_types_0_0= ruleType ) )* )
            // PsiInternalLazyLinkingTestLanguage.g:59:2: ( (lv_types_0_0= ruleType ) )*
            {
            // PsiInternalLazyLinkingTestLanguage.g:59:2: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:60:3: (lv_types_0_0= ruleType )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:60:3: (lv_types_0_0= ruleType )
            	    // PsiInternalLazyLinkingTestLanguage.g:61:4: lv_types_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getModel_TypesTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleType();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleType"
    // PsiInternalLazyLinkingTestLanguage.g:73:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // PsiInternalLazyLinkingTestLanguage.g:73:14: ( ruleType EOF )
            // PsiInternalLazyLinkingTestLanguage.g:74:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleType();

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalLazyLinkingTestLanguage.g:79:1: ruleType : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) ;
    public final void ruleType() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;

        try {
            // PsiInternalLazyLinkingTestLanguage.g:79:9: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) )
            // PsiInternalLazyLinkingTestLanguage.g:80:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            {
            // PsiInternalLazyLinkingTestLanguage.g:80:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            // PsiInternalLazyLinkingTestLanguage.g:81:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}'
            {

            			markLeaf(elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLazyLinkingTestLanguage.g:88:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLazyLinkingTestLanguage.g:89:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLazyLinkingTestLanguage.g:89:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLazyLinkingTestLanguage.g:90:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalLazyLinkingTestLanguage.g:99:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalLazyLinkingTestLanguage.g:100:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getType_ExtendsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:107:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:108:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:108:5: (otherlv_3= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:109:6: otherlv_3= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType());
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						doneLeaf(otherlv_3);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getType_FullStopKeyword_2_2ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:125:4: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:126:5: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:126:5: (otherlv_5= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:127:6: otherlv_5= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getType_ParentIdPropertyCrossReference_2_3_0ElementType());
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						doneLeaf(otherlv_5);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalLazyLinkingTestLanguage.g:137:3: (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalLazyLinkingTestLanguage.g:138:4: otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getType_ForKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:145:4: ( (otherlv_7= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:146:5: (otherlv_7= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:146:5: (otherlv_7= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:147:6: otherlv_7= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getType_ParentIdPropertyCrossReference_3_1_0ElementType());
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(otherlv_7);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getType_InKeyword_3_2ElementType());
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:163:4: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:164:5: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:164:5: (otherlv_9= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:165:6: otherlv_9= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getType_ExtendsTypeCrossReference_3_3_0ElementType());
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						doneLeaf(otherlv_9);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getType_LeftCurlyBracketKeyword_4ElementType());
            		
            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_10);
            		
            // PsiInternalLazyLinkingTestLanguage.g:182:3: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:183:4: (lv_properties_11_0= ruleProperty )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:183:4: (lv_properties_11_0= ruleProperty )
            	    // PsiInternalLazyLinkingTestLanguage.g:184:5: lv_properties_11_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_PropertiesPropertyParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    ruleProperty();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // PsiInternalLazyLinkingTestLanguage.g:193:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:194:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:194:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // PsiInternalLazyLinkingTestLanguage.g:195:5: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    ruleUnresolvedProxyProperty();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getType_RightCurlyBracketKeyword_7ElementType());
            		
            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_13);
            		

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleProperty"
    // PsiInternalLazyLinkingTestLanguage.g:215:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // PsiInternalLazyLinkingTestLanguage.g:215:18: ( ruleProperty EOF )
            // PsiInternalLazyLinkingTestLanguage.g:216:2: ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleProperty();

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // PsiInternalLazyLinkingTestLanguage.g:221:1: ruleProperty : ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final void ruleProperty() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalLazyLinkingTestLanguage.g:221:13: ( ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // PsiInternalLazyLinkingTestLanguage.g:222:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // PsiInternalLazyLinkingTestLanguage.g:222:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // PsiInternalLazyLinkingTestLanguage.g:223:3: ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // PsiInternalLazyLinkingTestLanguage.g:223:3: ( (otherlv_0= RULE_ID ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_ID) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:224:4: (otherlv_0= RULE_ID )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:224:4: (otherlv_0= RULE_ID )
            	    // PsiInternalLazyLinkingTestLanguage.g:225:5: otherlv_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType());
            	    				
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            	    					doneLeaf(otherlv_0);
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // PsiInternalLazyLinkingTestLanguage.g:234:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLazyLinkingTestLanguage.g:235:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLazyLinkingTestLanguage.g:235:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLazyLinkingTestLanguage.g:236:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getProperty_SemicolonKeyword_2ElementType());
            		
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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleUnresolvedProxyProperty"
    // PsiInternalLazyLinkingTestLanguage.g:256:1: entryRuleUnresolvedProxyProperty : ruleUnresolvedProxyProperty EOF ;
    public final void entryRuleUnresolvedProxyProperty() throws RecognitionException {
        try {
            // PsiInternalLazyLinkingTestLanguage.g:256:33: ( ruleUnresolvedProxyProperty EOF )
            // PsiInternalLazyLinkingTestLanguage.g:257:2: ruleUnresolvedProxyProperty EOF
            {
             markComposite(elementTypeProvider.getUnresolvedProxyPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnresolvedProxyProperty();

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
    // $ANTLR end "entryRuleUnresolvedProxyProperty"


    // $ANTLR start "ruleUnresolvedProxyProperty"
    // PsiInternalLazyLinkingTestLanguage.g:262:1: ruleUnresolvedProxyProperty : (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final void ruleUnresolvedProxyProperty() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalLazyLinkingTestLanguage.g:262:28: ( (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // PsiInternalLazyLinkingTestLanguage.g:263:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // PsiInternalLazyLinkingTestLanguage.g:263:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // PsiInternalLazyLinkingTestLanguage.g:264:3: otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {

            			markLeaf(elementTypeProvider.getUnresolvedProxyProperty_UnresolvedKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLazyLinkingTestLanguage.g:271:3: ( (otherlv_1= RULE_ID ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==RULE_ID) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:272:4: (otherlv_1= RULE_ID )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:272:4: (otherlv_1= RULE_ID )
            	    // PsiInternalLazyLinkingTestLanguage.g:273:5: otherlv_1= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getUnresolvedProxyProperty_TypeTypeCrossReference_1_0ElementType());
            	    				
            	    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            	    					doneLeaf(otherlv_1);
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // PsiInternalLazyLinkingTestLanguage.g:282:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalLazyLinkingTestLanguage.g:283:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalLazyLinkingTestLanguage.g:283:4: (lv_name_2_0= RULE_ID )
            // PsiInternalLazyLinkingTestLanguage.g:284:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getUnresolvedProxyProperty_SemicolonKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

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
    // $ANTLR end "ruleUnresolvedProxyProperty"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000015000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    }


}