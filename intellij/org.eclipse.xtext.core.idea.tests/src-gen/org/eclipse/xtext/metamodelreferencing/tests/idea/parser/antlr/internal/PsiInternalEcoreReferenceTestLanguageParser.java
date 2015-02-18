package org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.services.EcoreReferenceTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEcoreReferenceTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ExtendsNsURIEObject'", "'EObject'", "'ExtendsPluginEObject'", "'ExtendsResourceEObject'", "'MyEAttribute'", "'EAttribute'", "'object'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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


        public PsiInternalEcoreReferenceTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEcoreReferenceTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEcoreReferenceTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g"; }



    	protected EcoreReferenceTestLanguageGrammarAccess grammarAccess;

    	protected EcoreReferenceTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEcoreReferenceTestLanguageParser(PsiBuilder builder, TokenStream input, EcoreReferenceTestLanguageElementTypeProvider elementTypeProvider, EcoreReferenceTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:59:1: ruleModel : ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:59:10: ( ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:60:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:60:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:61:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:61:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:62:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:62:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:63:5: lv_extends_0_0= ruleExtendsNsURIEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsNsURIEObjectParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleModel96);
            ruleExtendsNsURIEObject();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:72:3: ( (lv_extends_1_0= ruleExtendsPluginEObject ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:73:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:73:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:74:5: lv_extends_1_0= ruleExtendsPluginEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsPluginEObjectParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleModel134);
            ruleExtendsPluginEObject();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:83:3: ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:84:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:84:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:85:5: lv_extends_2_0= ruleExtendsResourceEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsResourceEObjectParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleModel172);
            ruleExtendsResourceEObject();

            state._fsp--;


            					doneComposite();
            				

            }


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExtendsNsURIEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:98:1: entryRuleExtendsNsURIEObject : ruleExtendsNsURIEObject EOF ;
    public final void entryRuleExtendsNsURIEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:98:29: ( ruleExtendsNsURIEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:99:2: ruleExtendsNsURIEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsNsURIEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_entryRuleExtendsNsURIEObject203);
            ruleExtendsNsURIEObject();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsNsURIEObject209); 

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
    // $ANTLR end "entryRuleExtendsNsURIEObject"


    // $ANTLR start "ruleExtendsNsURIEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:107:1: ruleExtendsNsURIEObject : (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) ;
    public final void ruleExtendsNsURIEObject() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:107:24: ( (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:108:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:108:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:109:3: otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsNsURIEObject232); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:116:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:117:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:117:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:118:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsNsURIEObject259);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:127:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:128:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:128:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:129:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsNsURIEObject297); 

                    					doneLeaf(otherlv_2, elementTypeProvider.getExtendsNsURIEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:136:5: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:137:6: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:137:6: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:138:7: otherlv_3= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject334); 

                    							doneLeaf(otherlv_3, elementTypeProvider.getExtendsNsURIEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:149:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:149:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:150:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsNsURIEObject388); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:157:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:158:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:158:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:159:7: otherlv_5= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject425); 

                    							doneLeaf(otherlv_5, elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:170:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:170:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:171:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsNsURIEObject479); 

                    					doneLeaf(otherlv_6, elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:178:5: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:179:6: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:179:6: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:180:7: otherlv_7= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject516); 

                    							doneLeaf(otherlv_7, elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:191:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:191:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:192:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsNsURIEObject570); 

                    					doneLeaf(otherlv_8, elementTypeProvider.getExtendsNsURIEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:199:5: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:200:6: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:200:6: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:201:7: otherlv_9= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject607); 

                    							doneLeaf(otherlv_9, elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:212:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_ID) ) {
                        alt5=1;
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:213:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsNsURIEObject653); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:220:4: ( (otherlv_11= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:221:5: (otherlv_11= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:221:5: (otherlv_11= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:222:6: otherlv_11= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject685); 

                    						doneLeaf(otherlv_11, elementTypeProvider.getExtendsNsURIEObject_EAttributeReferenceMyEAttributeCrossReference_3_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:231:4: ( (otherlv_12= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:232:5: (otherlv_12= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:232:5: (otherlv_12= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:233:6: otherlv_12= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject730); 

                    						doneLeaf(otherlv_12, elementTypeProvider.getExtendsNsURIEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_2_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:242:4: ( (otherlv_13= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:243:5: (otherlv_13= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:243:5: (otherlv_13= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:244:6: otherlv_13= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject775); 

                    						doneLeaf(otherlv_13, elementTypeProvider.getExtendsNsURIEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_3_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:253:4: ( (otherlv_14= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:254:5: (otherlv_14= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:254:5: (otherlv_14= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:255:6: otherlv_14= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject820); 

                    						doneLeaf(otherlv_14, elementTypeProvider.getExtendsNsURIEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_4_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:264:4: ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==11) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:265:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:265:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:266:6: lv_eObjectContainment_15_0= ruleExtendsNsURIEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_5_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsNsURIEObject865);
                            ruleExtendsNsURIEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:275:4: ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:276:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:276:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:277:6: lv_eObjectContainment_16_0= ruleExtendsPluginEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_6_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsNsURIEObject911);
                            ruleExtendsPluginEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:286:4: ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:287:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:287:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:288:6: lv_eObjectContainment_17_0= ruleExtendsResourceEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_7_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsNsURIEObject957);
                            ruleExtendsResourceEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:297:4: ( (lv_eObjectContainment_18_0= ruleEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:298:5: (lv_eObjectContainment_18_0= ruleEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:298:5: (lv_eObjectContainment_18_0= ruleEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:299:6: lv_eObjectContainment_18_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEObjectParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsNsURIEObject1003);
                    ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:308:4: ( (lv_eObjectContainment_19_0= ruleEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:309:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:309:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:310:6: lv_eObjectContainment_19_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsNsURIEObject1048);
                    ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:319:4: ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:320:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:320:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:321:6: lv_eObjectContainment_20_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentMyEAttributeParserRuleCall_3_10_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsNsURIEObject1093);
                    ruleMyEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleExtendsNsURIEObject"


    // $ANTLR start "entryRuleMyEAttribute"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:335:1: entryRuleMyEAttribute : ruleMyEAttribute EOF ;
    public final void entryRuleMyEAttribute() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:335:22: ( ruleMyEAttribute EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:336:2: ruleMyEAttribute EOF
            {
             markComposite(elementTypeProvider.getMyEAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_entryRuleMyEAttribute1132);
            ruleMyEAttribute();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyEAttribute1138); 

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
    // $ANTLR end "entryRuleMyEAttribute"


    // $ANTLR start "ruleMyEAttribute"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:344:1: ruleMyEAttribute : ( () otherlv_1= 'MyEAttribute' ) ;
    public final void ruleMyEAttribute() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:344:17: ( ( () otherlv_1= 'MyEAttribute' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:345:2: ( () otherlv_1= 'MyEAttribute' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:345:2: ( () otherlv_1= 'MyEAttribute' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:346:3: () otherlv_1= 'MyEAttribute'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:346:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:347:4: 
            {

            				precedeComposite(elementTypeProvider.getMyEAttribute_MyEAttributeAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMyEAttribute1174); 

            			doneLeaf(otherlv_1, elementTypeProvider.getMyEAttribute_MyEAttributeKeyword_1ElementType());
            		

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
    // $ANTLR end "ruleMyEAttribute"


    // $ANTLR start "entryRuleEAttribute"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:363:1: entryRuleEAttribute : ruleEAttribute EOF ;
    public final void entryRuleEAttribute() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:363:20: ( ruleEAttribute EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:364:2: ruleEAttribute EOF
            {
             markComposite(elementTypeProvider.getEAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_entryRuleEAttribute1194);
            ruleEAttribute();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAttribute1200); 

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
    // $ANTLR end "entryRuleEAttribute"


    // $ANTLR start "ruleEAttribute"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:372:1: ruleEAttribute : ( () otherlv_1= 'EAttribute' ) ;
    public final void ruleEAttribute() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:372:15: ( ( () otherlv_1= 'EAttribute' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:373:2: ( () otherlv_1= 'EAttribute' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:373:2: ( () otherlv_1= 'EAttribute' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:374:3: () otherlv_1= 'EAttribute'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:374:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:375:4: 
            {

            				precedeComposite(elementTypeProvider.getEAttribute_EAttributeAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEAttribute1236); 

            			doneLeaf(otherlv_1, elementTypeProvider.getEAttribute_EAttributeKeyword_1ElementType());
            		

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
    // $ANTLR end "ruleEAttribute"


    // $ANTLR start "entryRuleExtendsPluginEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:391:1: entryRuleExtendsPluginEObject : ruleExtendsPluginEObject EOF ;
    public final void entryRuleExtendsPluginEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:391:30: ( ruleExtendsPluginEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:392:2: ruleExtendsPluginEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsPluginEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_entryRuleExtendsPluginEObject1256);
            ruleExtendsPluginEObject();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsPluginEObject1262); 

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
    // $ANTLR end "entryRuleExtendsPluginEObject"


    // $ANTLR start "ruleExtendsPluginEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:400:1: ruleExtendsPluginEObject : (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final void ruleExtendsPluginEObject() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:400:25: ( (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:401:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:401:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:402:3: otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1285); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:409:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:410:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:410:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:411:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsPluginEObject1312);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:420:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt6=1;
                }
                break;
            case 11:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:421:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:421:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:422:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsPluginEObject1350); 

                    					doneLeaf(otherlv_2, elementTypeProvider.getExtendsPluginEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:429:5: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:430:6: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:430:6: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:431:7: otherlv_3= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1387); 

                    							doneLeaf(otherlv_3, elementTypeProvider.getExtendsPluginEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:442:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:442:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:443:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsPluginEObject1441); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getExtendsPluginEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:450:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:451:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:451:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:452:7: otherlv_5= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1478); 

                    							doneLeaf(otherlv_5, elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:463:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:463:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:464:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1532); 

                    					doneLeaf(otherlv_6, elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:471:5: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:472:6: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:472:6: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:473:7: otherlv_7= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1569); 

                    							doneLeaf(otherlv_7, elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:484:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:484:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:485:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsPluginEObject1623); 

                    					doneLeaf(otherlv_8, elementTypeProvider.getExtendsPluginEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:492:5: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:493:6: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:493:6: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:494:7: otherlv_9= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1660); 

                    							doneLeaf(otherlv_9, elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:505:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:506:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1706); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:513:4: ( (otherlv_11= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:514:5: (otherlv_11= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:514:5: (otherlv_11= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:515:6: otherlv_11= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1738); 

                    						doneLeaf(otherlv_11, elementTypeProvider.getExtendsPluginEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:524:4: ( (otherlv_12= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:525:5: (otherlv_12= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:525:5: (otherlv_12= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:526:6: otherlv_12= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1783); 

                    						doneLeaf(otherlv_12, elementTypeProvider.getExtendsPluginEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:535:4: ( (otherlv_13= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:536:5: (otherlv_13= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:536:5: (otherlv_13= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:537:6: otherlv_13= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1828); 

                    						doneLeaf(otherlv_13, elementTypeProvider.getExtendsPluginEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:546:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==11) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:547:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:547:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:548:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsPluginEObject1873);
                            ruleExtendsNsURIEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:557:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==13) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:558:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:558:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:559:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsPluginEObject1919);
                            ruleExtendsPluginEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:568:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==14) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:569:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:569:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:570:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsPluginEObject1965);
                            ruleExtendsResourceEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:579:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:580:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:580:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:581:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsPluginEObject2011);
                    ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:590:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:591:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:591:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:592:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsPluginEObject2056);
                    ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:601:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:602:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:602:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:603:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsPluginEObject2101);
                    ruleMyEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleExtendsPluginEObject"


    // $ANTLR start "entryRuleExtendsResourceEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:617:1: entryRuleExtendsResourceEObject : ruleExtendsResourceEObject EOF ;
    public final void entryRuleExtendsResourceEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:617:32: ( ruleExtendsResourceEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:618:2: ruleExtendsResourceEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsResourceEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_entryRuleExtendsResourceEObject2140);
            ruleExtendsResourceEObject();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsResourceEObject2146); 

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
    // $ANTLR end "entryRuleExtendsResourceEObject"


    // $ANTLR start "ruleExtendsResourceEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:626:1: ruleExtendsResourceEObject : (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final void ruleExtendsResourceEObject() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:626:27: ( (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:627:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:627:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:628:3: otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject2169); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:635:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:636:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:636:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:637:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsResourceEObject2196);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:646:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt11=1;
                }
                break;
            case 11:
                {
                alt11=2;
                }
                break;
            case 13:
                {
                alt11=3;
                }
                break;
            case 14:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:647:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:647:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:648:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsResourceEObject2234); 

                    					doneLeaf(otherlv_2, elementTypeProvider.getExtendsResourceEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:655:5: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:656:6: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:656:6: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:657:7: otherlv_3= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2271); 

                    							doneLeaf(otherlv_3, elementTypeProvider.getExtendsResourceEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:668:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:668:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:669:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsResourceEObject2325); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getExtendsResourceEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:676:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:677:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:677:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:678:7: otherlv_5= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2362); 

                    							doneLeaf(otherlv_5, elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:689:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:689:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:690:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsResourceEObject2416); 

                    					doneLeaf(otherlv_6, elementTypeProvider.getExtendsResourceEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:697:5: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:698:6: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:698:6: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:699:7: otherlv_7= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2453); 

                    							doneLeaf(otherlv_7, elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:710:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:710:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:711:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject2507); 

                    					doneLeaf(otherlv_8, elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:718:5: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:719:6: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:719:6: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:720:7: otherlv_9= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2544); 

                    							doneLeaf(otherlv_9, elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:731:3: (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==14) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:732:4: otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject2590); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:739:4: ( (otherlv_11= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:740:5: (otherlv_11= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:740:5: (otherlv_11= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:741:6: otherlv_11= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2622); 

                    						doneLeaf(otherlv_11, elementTypeProvider.getExtendsResourceEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:750:4: ( (otherlv_12= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:751:5: (otherlv_12= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:751:5: (otherlv_12= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:752:6: otherlv_12= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2667); 

                    						doneLeaf(otherlv_12, elementTypeProvider.getExtendsResourceEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:761:4: ( (otherlv_13= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:762:5: (otherlv_13= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:762:5: (otherlv_13= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:763:6: otherlv_13= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2712); 

                    						doneLeaf(otherlv_13, elementTypeProvider.getExtendsResourceEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:772:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:773:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:773:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:774:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsResourceEObject2757);
                    ruleExtendsNsURIEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:783:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:784:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:784:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:785:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsResourceEObject2802);
                    ruleExtendsPluginEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:794:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:795:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:795:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:796:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsResourceEObject2847);
                    ruleExtendsResourceEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:805:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:806:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:806:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:807:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsResourceEObject2892);
                    ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:816:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:817:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:817:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:818:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsResourceEObject2937);
                    ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:827:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:828:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:828:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:829:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsResourceEObject2982);
                    ruleMyEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleExtendsResourceEObject"


    // $ANTLR start "entryRuleEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:843:1: entryRuleEObject : ruleEObject EOF ;
    public final void entryRuleEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:843:17: ( ruleEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:844:2: ruleEObject EOF
            {
             markComposite(elementTypeProvider.getEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEObject_in_entryRuleEObject3021);
            ruleEObject();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObject3027); 

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
    // $ANTLR end "entryRuleEObject"


    // $ANTLR start "ruleEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:852:1: ruleEObject : ( () otherlv_1= 'object' ) ;
    public final void ruleEObject() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:852:12: ( ( () otherlv_1= 'object' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:853:2: ( () otherlv_1= 'object' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:853:2: ( () otherlv_1= 'object' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:854:3: () otherlv_1= 'object'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:854:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:855:4: 
            {

            				precedeComposite(elementTypeProvider.getEObject_EObjectAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEObject3063); 

            			doneLeaf(otherlv_1, elementTypeProvider.getEObject_ObjectKeyword_1ElementType());
            		

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
    // $ANTLR end "ruleEObject"


    // $ANTLR start "entryRuleValidID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:871:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:871:17: ( ruleValidID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:872:2: ruleValidID EOF
            {
             markComposite(elementTypeProvider.getValidIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_entryRuleValidID3083);
            ruleValidID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValidID3089); 

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:880:1: ruleValidID : this_ID_0= RULE_ID ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:880:12: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:881:2: this_ID_0= RULE_ID
            {

            		markLeaf();
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValidID3107); 

            		doneLeaf(this_ID_0, elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
            	

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
    // $ANTLR end "ruleValidID"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleModel96 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleModel134 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleModel172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_entryRuleExtendsNsURIEObject203 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsNsURIEObject209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsNsURIEObject232 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsNsURIEObject259 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsNsURIEObject297 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject334 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsNsURIEObject388 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject425 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsNsURIEObject479 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject516 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsNsURIEObject570 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject607 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsNsURIEObject653 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject685 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject730 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject775 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject820 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsNsURIEObject865 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsNsURIEObject911 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsNsURIEObject957 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsNsURIEObject1003 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsNsURIEObject1048 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsNsURIEObject1093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_entryRuleMyEAttribute1132 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyEAttribute1138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleMyEAttribute1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttribute_in_entryRuleEAttribute1194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAttribute1200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEAttribute1236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_entryRuleExtendsPluginEObject1256 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsPluginEObject1262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1285 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsPluginEObject1312 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsPluginEObject1350 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1387 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsPluginEObject1441 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1478 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1532 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1569 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsPluginEObject1623 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1660 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1706 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1738 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1783 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1828 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsPluginEObject1873 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsPluginEObject1919 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsPluginEObject1965 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsPluginEObject2011 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsPluginEObject2056 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsPluginEObject2101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_entryRuleExtendsResourceEObject2140 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsResourceEObject2146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject2169 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsResourceEObject2196 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsResourceEObject2234 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2271 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsResourceEObject2325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2362 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsResourceEObject2416 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2453 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject2507 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2544 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject2590 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2622 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2667 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2712 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsResourceEObject2757 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsResourceEObject2802 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsResourceEObject2847 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsResourceEObject2892 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsResourceEObject2937 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsResourceEObject2982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObject_in_entryRuleEObject3021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObject3027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleEObject3063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID3083 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValidID3089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValidID3107 = new BitSet(new long[]{0x0000000000000002L});
    }


}