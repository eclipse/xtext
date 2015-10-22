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
    // PsiInternalLazyLinkingTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalLazyLinkingTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalLazyLinkingTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalLazyLinkingTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_types_0_0= ruleType ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_types_0_0 = null;


        try {
            // PsiInternalLazyLinkingTestLanguage.g:60:1: ( ( (lv_types_0_0= ruleType ) )* )
            // PsiInternalLazyLinkingTestLanguage.g:61:2: ( (lv_types_0_0= ruleType ) )*
            {
            // PsiInternalLazyLinkingTestLanguage.g:61:2: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:62:3: (lv_types_0_0= ruleType )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:62:3: (lv_types_0_0= ruleType )
            	    // PsiInternalLazyLinkingTestLanguage.g:63:4: lv_types_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getModel_TypesTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_types_0_0=ruleType();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleType"
    // PsiInternalLazyLinkingTestLanguage.g:79:1: entryRuleType returns [Boolean current=false] : iv_ruleType= ruleType EOF ;
    public final Boolean entryRuleType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleType = null;


        try {
            // PsiInternalLazyLinkingTestLanguage.g:79:46: (iv_ruleType= ruleType EOF )
            // PsiInternalLazyLinkingTestLanguage.g:80:2: iv_ruleType= ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalLazyLinkingTestLanguage.g:86:1: ruleType returns [Boolean current=false] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) ;
    public final Boolean ruleType() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_properties_11_0 = null;

        Boolean lv_unresolvedProxyProperty_12_0 = null;


        try {
            // PsiInternalLazyLinkingTestLanguage.g:87:1: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) )
            // PsiInternalLazyLinkingTestLanguage.g:88:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            {
            // PsiInternalLazyLinkingTestLanguage.g:88:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            // PsiInternalLazyLinkingTestLanguage.g:89:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}'
            {

            			markLeaf(elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLazyLinkingTestLanguage.g:96:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLazyLinkingTestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLazyLinkingTestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLazyLinkingTestLanguage.g:98:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalLazyLinkingTestLanguage.g:113:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalLazyLinkingTestLanguage.g:114:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getType_ExtendsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:121:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:122:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:122:5: (otherlv_3= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:123:6: otherlv_3= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType());
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						doneLeaf(otherlv_3);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getType_FullStopKeyword_2_2ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:145:4: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:146:5: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:146:5: (otherlv_5= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:147:6: otherlv_5= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getType_ParentIdPropertyCrossReference_2_3_0ElementType());
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						doneLeaf(otherlv_5);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalLazyLinkingTestLanguage.g:163:3: (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalLazyLinkingTestLanguage.g:164:4: otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getType_ForKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:171:4: ( (otherlv_7= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:172:5: (otherlv_7= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:172:5: (otherlv_7= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:173:6: otherlv_7= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getType_ParentIdPropertyCrossReference_3_1_0ElementType());
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(otherlv_7);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getType_InKeyword_3_2ElementType());
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalLazyLinkingTestLanguage.g:195:4: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalLazyLinkingTestLanguage.g:196:5: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalLazyLinkingTestLanguage.g:196:5: (otherlv_9= RULE_ID )
                    // PsiInternalLazyLinkingTestLanguage.g:197:6: otherlv_9= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
            		
            // PsiInternalLazyLinkingTestLanguage.g:220:3: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:221:4: (lv_properties_11_0= ruleProperty )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:221:4: (lv_properties_11_0= ruleProperty )
            	    // PsiInternalLazyLinkingTestLanguage.g:222:5: lv_properties_11_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_PropertiesPropertyParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_properties_11_0=ruleProperty();

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

            // PsiInternalLazyLinkingTestLanguage.g:235:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalLazyLinkingTestLanguage.g:236:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:236:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // PsiInternalLazyLinkingTestLanguage.g:237:5: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_unresolvedProxyProperty_12_0=ruleUnresolvedProxyProperty();

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
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleProperty"
    // PsiInternalLazyLinkingTestLanguage.g:261:1: entryRuleProperty returns [Boolean current=false] : iv_ruleProperty= ruleProperty EOF ;
    public final Boolean entryRuleProperty() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleProperty = null;


        try {
            // PsiInternalLazyLinkingTestLanguage.g:261:50: (iv_ruleProperty= ruleProperty EOF )
            // PsiInternalLazyLinkingTestLanguage.g:262:2: iv_ruleProperty= ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // PsiInternalLazyLinkingTestLanguage.g:268:1: ruleProperty returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final Boolean ruleProperty() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalLazyLinkingTestLanguage.g:269:1: ( ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // PsiInternalLazyLinkingTestLanguage.g:270:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // PsiInternalLazyLinkingTestLanguage.g:270:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // PsiInternalLazyLinkingTestLanguage.g:271:3: ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // PsiInternalLazyLinkingTestLanguage.g:271:3: ( (otherlv_0= RULE_ID ) )+
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
            	    // PsiInternalLazyLinkingTestLanguage.g:272:4: (otherlv_0= RULE_ID )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:272:4: (otherlv_0= RULE_ID )
            	    // PsiInternalLazyLinkingTestLanguage.g:273:5: otherlv_0= RULE_ID
            	    {

            	    					if (!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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

            // PsiInternalLazyLinkingTestLanguage.g:288:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLazyLinkingTestLanguage.g:289:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLazyLinkingTestLanguage.g:289:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLazyLinkingTestLanguage.g:290:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleUnresolvedProxyProperty"
    // PsiInternalLazyLinkingTestLanguage.g:316:1: entryRuleUnresolvedProxyProperty returns [Boolean current=false] : iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF ;
    public final Boolean entryRuleUnresolvedProxyProperty() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnresolvedProxyProperty = null;


        try {
            // PsiInternalLazyLinkingTestLanguage.g:316:65: (iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF )
            // PsiInternalLazyLinkingTestLanguage.g:317:2: iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF
            {
             markComposite(elementTypeProvider.getUnresolvedProxyPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnresolvedProxyProperty=ruleUnresolvedProxyProperty();

            state._fsp--;

             current =iv_ruleUnresolvedProxyProperty; 
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
    // $ANTLR end "entryRuleUnresolvedProxyProperty"


    // $ANTLR start "ruleUnresolvedProxyProperty"
    // PsiInternalLazyLinkingTestLanguage.g:323:1: ruleUnresolvedProxyProperty returns [Boolean current=false] : (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final Boolean ruleUnresolvedProxyProperty() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalLazyLinkingTestLanguage.g:324:1: ( (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // PsiInternalLazyLinkingTestLanguage.g:325:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // PsiInternalLazyLinkingTestLanguage.g:325:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // PsiInternalLazyLinkingTestLanguage.g:326:3: otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {

            			markLeaf(elementTypeProvider.getUnresolvedProxyProperty_UnresolvedKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLazyLinkingTestLanguage.g:333:3: ( (otherlv_1= RULE_ID ) )+
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
            	    // PsiInternalLazyLinkingTestLanguage.g:334:4: (otherlv_1= RULE_ID )
            	    {
            	    // PsiInternalLazyLinkingTestLanguage.g:334:4: (otherlv_1= RULE_ID )
            	    // PsiInternalLazyLinkingTestLanguage.g:335:5: otherlv_1= RULE_ID
            	    {

            	    					if (!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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

            // PsiInternalLazyLinkingTestLanguage.g:350:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalLazyLinkingTestLanguage.g:351:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalLazyLinkingTestLanguage.g:351:4: (lv_name_2_0= RULE_ID )
            // PsiInternalLazyLinkingTestLanguage.g:352:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
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