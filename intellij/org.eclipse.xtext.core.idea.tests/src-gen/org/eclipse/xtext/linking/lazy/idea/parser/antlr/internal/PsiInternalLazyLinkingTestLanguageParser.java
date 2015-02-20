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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:59:1: ruleModel : ( (lv_types_0_0= ruleType ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:59:10: ( ( (lv_types_0_0= ruleType ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:60:2: ( (lv_types_0_0= ruleType ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:60:2: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:61:3: (lv_types_0_0= ruleType )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:61:3: (lv_types_0_0= ruleType )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:62:4: lv_types_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getModel_TypesTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleModel85);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:74:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:74:14: ( ruleType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:75:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType111);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType117); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:81:1: ruleType : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:81:9: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:82:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:82:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:83:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleType136); 

            			doneLeaf(otherlv_0, elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:90:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:91:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:91:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:92:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType163); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:101:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:102:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleType194); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getType_ExtendsKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:109:4: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:110:5: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:110:5: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:111:6: otherlv_3= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType226); 

                    						doneLeaf(otherlv_3, elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleType256); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getType_FullStopKeyword_2_2ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:127:4: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:128:5: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:128:5: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:129:6: otherlv_5= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType288); 

                    						doneLeaf(otherlv_5, elementTypeProvider.getType_ParentIdPropertyCrossReference_2_3_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:139:3: (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:140:4: otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleType327); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getType_ForKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:147:4: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:148:5: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:148:5: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:149:6: otherlv_7= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType359); 

                    						doneLeaf(otherlv_7, elementTypeProvider.getType_ParentIdPropertyCrossReference_3_1_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleType389); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getType_InKeyword_3_2ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:165:4: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:166:5: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:166:5: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:167:6: otherlv_9= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType421); 

                    						doneLeaf(otherlv_9, elementTypeProvider.getType_ExtendsTypeCrossReference_3_3_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleType454); 

            			doneLeaf(otherlv_10, elementTypeProvider.getType_LeftCurlyBracketKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:184:3: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:185:4: (lv_properties_11_0= ruleProperty )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:185:4: (lv_properties_11_0= ruleProperty )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:186:5: lv_properties_11_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_PropertiesPropertyParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleProperty_in_ruleType481);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:195:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:196:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:196:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:197:5: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleUnresolvedProxyProperty_in_ruleType520);
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


            			markLeaf();
            		
            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleType546); 

            			doneLeaf(otherlv_13, elementTypeProvider.getType_RightCurlyBracketKeyword_7ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:217:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:217:18: ( ruleProperty EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:218:2: ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleProperty_in_entryRuleProperty566);
            ruleProperty();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProperty572); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:224:1: ruleProperty : ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final void ruleProperty() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:224:13: ( ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:225:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:225:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:226:3: ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:226:3: ( (otherlv_0= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:227:4: (otherlv_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:227:4: (otherlv_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:228:5: otherlv_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty604); 

            	    					doneLeaf(otherlv_0, elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType());
            	    				

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:237:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:238:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:238:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:239:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty643); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProperty668); 

            			doneLeaf(otherlv_2, elementTypeProvider.getProperty_SemicolonKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:259:1: entryRuleUnresolvedProxyProperty : ruleUnresolvedProxyProperty EOF ;
    public final void entryRuleUnresolvedProxyProperty() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:259:33: ( ruleUnresolvedProxyProperty EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:260:2: ruleUnresolvedProxyProperty EOF
            {
             markComposite(elementTypeProvider.getUnresolvedProxyPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty688);
            ruleUnresolvedProxyProperty();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty694); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:266:1: ruleUnresolvedProxyProperty : (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final void ruleUnresolvedProxyProperty() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:266:28: ( (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:267:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:267:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:268:3: otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleUnresolvedProxyProperty713); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnresolvedProxyProperty_UnresolvedKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:275:3: ( (otherlv_1= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:276:4: (otherlv_1= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:276:4: (otherlv_1= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:277:5: otherlv_1= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty740); 

            	    					doneLeaf(otherlv_1, elementTypeProvider.getUnresolvedProxyProperty_TypeTypeCrossReference_1_0ElementType());
            	    				

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:286:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:287:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:287:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:288:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty779); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnresolvedProxyProperty804); 

            			doneLeaf(otherlv_3, elementTypeProvider.getUnresolvedProxyProperty_SemicolonKeyword_3ElementType());
            		

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleModel85 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleType136 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType163 = new BitSet(new long[]{0x0000000000015000L});
        public static final BitSet FOLLOW_12_in_ruleType194 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType226 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleType256 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType288 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_14_in_ruleType327 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType359 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleType389 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType421 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleType454 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_ruleProperty_in_ruleType481 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_ruleType520 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleType546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty566 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProperty572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProperty604 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProperty643 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleProperty668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleUnresolvedProxyProperty713 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty740 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty779 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleUnresolvedProxyProperty804 = new BitSet(new long[]{0x0000000000000002L});
    }


}