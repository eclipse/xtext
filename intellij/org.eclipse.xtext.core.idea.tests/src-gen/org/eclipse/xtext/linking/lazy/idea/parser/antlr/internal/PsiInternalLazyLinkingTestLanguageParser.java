package org.eclipse.xtext.linking.lazy.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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



    private LazyLinkingTestLanguageGrammarAccess grammarAccess;

    private LazyLinkingTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalLazyLinkingTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, LazyLinkingTestLanguageElementTypeProvider elementTypeProvider, LazyLinkingTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:49:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:49:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:50:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:58:1: ruleModel : ( (lv_types_0_0= ruleType ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:58:10: ( ( (lv_types_0_0= ruleType ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:59:2: ( (lv_types_0_0= ruleType ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:59:2: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:60:3: (lv_types_0_0= ruleType )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:60:3: (lv_types_0_0= ruleType )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:61:4: lv_types_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getModel_TypesTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleModel89);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:73:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:73:14: ( ruleType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:74:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType115);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType121); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:82:1: ruleType : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:82:9: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:83:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:83:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:84:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleType144); 

            			doneLeaf(otherlv_0, elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:91:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:92:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:92:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:93:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType171); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:102:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:103:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleType202); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getType_ExtendsKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:110:4: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:111:5: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:111:5: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:112:6: otherlv_3= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType234); 

                    						doneLeaf(otherlv_3, elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleType264); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getType_FullStopKeyword_2_2ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:128:4: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:129:5: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:129:5: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:130:6: otherlv_5= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType296); 

                    						doneLeaf(otherlv_5, elementTypeProvider.getType_ParentIdPropertyCrossReference_2_3_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:140:3: (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:141:4: otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleType335); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getType_ForKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:148:4: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:149:5: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:149:5: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:150:6: otherlv_7= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType367); 

                    						doneLeaf(otherlv_7, elementTypeProvider.getType_ParentIdPropertyCrossReference_3_1_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleType397); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getType_InKeyword_3_2ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:166:4: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:167:5: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:167:5: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:168:6: otherlv_9= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType429); 

                    						doneLeaf(otherlv_9, elementTypeProvider.getType_ExtendsTypeCrossReference_3_3_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleType462); 

            			doneLeaf(otherlv_10, elementTypeProvider.getType_LeftCurlyBracketKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:185:3: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:186:4: (lv_properties_11_0= ruleProperty )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:186:4: (lv_properties_11_0= ruleProperty )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:187:5: lv_properties_11_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_PropertiesPropertyParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleProperty_in_ruleType489);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:196:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:197:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:197:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:198:5: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {

            	    					markComposite(elementTypeProvider.getType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleUnresolvedProxyProperty_in_ruleType528);
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
            		
            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleType554); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:218:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:218:18: ( ruleProperty EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:219:2: ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleProperty_in_entryRuleProperty574);
            ruleProperty();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProperty580); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:227:1: ruleProperty : ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final void ruleProperty() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:227:13: ( ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:228:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:228:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:229:3: ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:229:3: ( (otherlv_0= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:230:4: (otherlv_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:230:4: (otherlv_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:231:5: otherlv_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty616); 

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:240:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:241:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:241:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:242:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty655); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProperty680); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:262:1: entryRuleUnresolvedProxyProperty : ruleUnresolvedProxyProperty EOF ;
    public final void entryRuleUnresolvedProxyProperty() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:262:33: ( ruleUnresolvedProxyProperty EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:263:2: ruleUnresolvedProxyProperty EOF
            {
             markComposite(elementTypeProvider.getUnresolvedProxyPropertyElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty700);
            ruleUnresolvedProxyProperty();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty706); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:271:1: ruleUnresolvedProxyProperty : (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final void ruleUnresolvedProxyProperty() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:271:28: ( (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:272:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:272:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:273:3: otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleUnresolvedProxyProperty729); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnresolvedProxyProperty_UnresolvedKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:280:3: ( (otherlv_1= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:281:4: (otherlv_1= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:281:4: (otherlv_1= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:282:5: otherlv_1= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty756); 

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:291:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:292:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:292:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalLazyLinkingTestLanguage.g:293:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty795); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnresolvedProxyProperty820); 

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
        public static final BitSet FOLLOW_ruleType_in_ruleModel89 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleType144 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType171 = new BitSet(new long[]{0x0000000000015000L});
        public static final BitSet FOLLOW_12_in_ruleType202 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType234 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleType264 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType296 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_14_in_ruleType335 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType367 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleType397 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType429 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleType462 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_ruleProperty_in_ruleType489 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_ruleType528 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleType554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty574 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProperty580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProperty616 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProperty655 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleProperty680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty700 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleUnresolvedProxyProperty729 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty756 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty795 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleUnresolvedProxyProperty820 = new BitSet(new long[]{0x0000000000000002L});
    }


}