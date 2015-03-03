package org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel57); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:58:1: ruleModel : ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:58:10: ( ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:59:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:59:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:60:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:60:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:61:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:61:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:62:5: lv_extends_0_0= ruleExtendsNsURIEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsNsURIEObjectParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleModel89);
            ruleExtendsNsURIEObject();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:71:3: ( (lv_extends_1_0= ruleExtendsPluginEObject ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:72:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:72:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:73:5: lv_extends_1_0= ruleExtendsPluginEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsPluginEObjectParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleModel127);
            ruleExtendsPluginEObject();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:82:3: ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:83:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:83:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:84:5: lv_extends_2_0= ruleExtendsResourceEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsResourceEObjectParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleModel165);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:97:1: entryRuleExtendsNsURIEObject : ruleExtendsNsURIEObject EOF ;
    public final void entryRuleExtendsNsURIEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:97:29: ( ruleExtendsNsURIEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:98:2: ruleExtendsNsURIEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsNsURIEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_entryRuleExtendsNsURIEObject196);
            ruleExtendsNsURIEObject();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsNsURIEObject199); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:103:1: ruleExtendsNsURIEObject : (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:103:24: ( (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:104:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:104:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:105:3: otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsNsURIEObject218); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:112:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:113:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:113:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:114:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsNsURIEObject245);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:123:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:124:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:124:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:125:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsNsURIEObject283); 

                    					doneLeaf(otherlv_2);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:132:5: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:133:6: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:133:6: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:134:7: otherlv_3= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject320); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:145:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:145:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:146:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsNsURIEObject374); 

                    					doneLeaf(otherlv_4);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:153:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:154:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:154:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:155:7: otherlv_5= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject411); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:166:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:166:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:167:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsNsURIEObject465); 

                    					doneLeaf(otherlv_6);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:174:5: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:175:6: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:175:6: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:176:7: otherlv_7= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject502); 

                    							doneLeaf(otherlv_7);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:187:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:187:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:188:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsNsURIEObject556); 

                    					doneLeaf(otherlv_8);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:195:5: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:196:6: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:196:6: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:197:7: otherlv_9= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject593); 

                    							doneLeaf(otherlv_9);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:208:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:209:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    {

                    				markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsNsURIEObject639); 

                    				doneLeaf(otherlv_10);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:216:4: ( (otherlv_11= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:217:5: (otherlv_11= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:217:5: (otherlv_11= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:218:6: otherlv_11= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EAttributeReferenceMyEAttributeCrossReference_3_1_0ElementType());
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject671); 

                    						doneLeaf(otherlv_11);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:227:4: ( (otherlv_12= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:228:5: (otherlv_12= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:228:5: (otherlv_12= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:229:6: otherlv_12= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_2_0ElementType());
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject716); 

                    						doneLeaf(otherlv_12);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:238:4: ( (otherlv_13= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:239:5: (otherlv_13= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:239:5: (otherlv_13= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:240:6: otherlv_13= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_3_0ElementType());
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject761); 

                    						doneLeaf(otherlv_13);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:249:4: ( (otherlv_14= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:250:5: (otherlv_14= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:250:5: (otherlv_14= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:251:6: otherlv_14= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_4_0ElementType());
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject806); 

                    						doneLeaf(otherlv_14);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:260:4: ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==11) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:261:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:261:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:262:6: lv_eObjectContainment_15_0= ruleExtendsNsURIEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_5_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsNsURIEObject851);
                            ruleExtendsNsURIEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:271:4: ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:272:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:272:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:273:6: lv_eObjectContainment_16_0= ruleExtendsPluginEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_6_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsNsURIEObject897);
                            ruleExtendsPluginEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:282:4: ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:283:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:283:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:284:6: lv_eObjectContainment_17_0= ruleExtendsResourceEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_7_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsNsURIEObject943);
                            ruleExtendsResourceEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:293:4: ( (lv_eObjectContainment_18_0= ruleEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:294:5: (lv_eObjectContainment_18_0= ruleEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:294:5: (lv_eObjectContainment_18_0= ruleEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:295:6: lv_eObjectContainment_18_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEObjectParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsNsURIEObject989);
                    ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:304:4: ( (lv_eObjectContainment_19_0= ruleEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:305:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:305:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:306:6: lv_eObjectContainment_19_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsNsURIEObject1034);
                    ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:315:4: ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:316:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:316:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:317:6: lv_eObjectContainment_20_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentMyEAttributeParserRuleCall_3_10_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsNsURIEObject1079);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:331:1: entryRuleMyEAttribute : ruleMyEAttribute EOF ;
    public final void entryRuleMyEAttribute() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:331:22: ( ruleMyEAttribute EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:332:2: ruleMyEAttribute EOF
            {
             markComposite(elementTypeProvider.getMyEAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_entryRuleMyEAttribute1118);
            ruleMyEAttribute();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyEAttribute1121); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:337:1: ruleMyEAttribute : ( () otherlv_1= 'MyEAttribute' ) ;
    public final void ruleMyEAttribute() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:337:17: ( ( () otherlv_1= 'MyEAttribute' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:338:2: ( () otherlv_1= 'MyEAttribute' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:338:2: ( () otherlv_1= 'MyEAttribute' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:339:3: () otherlv_1= 'MyEAttribute'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:339:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:340:4: 
            {

            				precedeComposite(elementTypeProvider.getMyEAttribute_MyEAttributeAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getMyEAttribute_MyEAttributeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMyEAttribute1153); 

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
    // $ANTLR end "ruleMyEAttribute"


    // $ANTLR start "entryRuleEAttribute"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:356:1: entryRuleEAttribute : ruleEAttribute EOF ;
    public final void entryRuleEAttribute() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:356:20: ( ruleEAttribute EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:357:2: ruleEAttribute EOF
            {
             markComposite(elementTypeProvider.getEAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_entryRuleEAttribute1173);
            ruleEAttribute();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAttribute1176); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:362:1: ruleEAttribute : ( () otherlv_1= 'EAttribute' ) ;
    public final void ruleEAttribute() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:362:15: ( ( () otherlv_1= 'EAttribute' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:363:2: ( () otherlv_1= 'EAttribute' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:363:2: ( () otherlv_1= 'EAttribute' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:364:3: () otherlv_1= 'EAttribute'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:364:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:365:4: 
            {

            				precedeComposite(elementTypeProvider.getEAttribute_EAttributeAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getEAttribute_EAttributeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEAttribute1208); 

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
    // $ANTLR end "ruleEAttribute"


    // $ANTLR start "entryRuleExtendsPluginEObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:381:1: entryRuleExtendsPluginEObject : ruleExtendsPluginEObject EOF ;
    public final void entryRuleExtendsPluginEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:381:30: ( ruleExtendsPluginEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:382:2: ruleExtendsPluginEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsPluginEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_entryRuleExtendsPluginEObject1228);
            ruleExtendsPluginEObject();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsPluginEObject1231); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:387:1: ruleExtendsPluginEObject : (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:387:25: ( (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:388:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:388:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:389:3: otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1250); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:396:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:397:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:397:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:398:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsPluginEObject1277);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:407:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:408:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:408:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:409:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsPluginEObject1315); 

                    					doneLeaf(otherlv_2);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:416:5: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:417:6: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:417:6: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:418:7: otherlv_3= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1352); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:429:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:429:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:430:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsPluginEObject1406); 

                    					doneLeaf(otherlv_4);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:437:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:438:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:438:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:439:7: otherlv_5= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1443); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:450:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:450:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:451:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1497); 

                    					doneLeaf(otherlv_6);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:458:5: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:459:6: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:459:6: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:460:7: otherlv_7= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1534); 

                    							doneLeaf(otherlv_7);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:471:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:471:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:472:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsPluginEObject1588); 

                    					doneLeaf(otherlv_8);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:479:5: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:480:6: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:480:6: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:481:7: otherlv_9= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1625); 

                    							doneLeaf(otherlv_9);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:492:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:493:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {

                    				markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1671); 

                    				doneLeaf(otherlv_10);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:500:4: ( (otherlv_11= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:501:5: (otherlv_11= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:501:5: (otherlv_11= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:502:6: otherlv_11= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType());
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1703); 

                    						doneLeaf(otherlv_11);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:511:4: ( (otherlv_12= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:512:5: (otherlv_12= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:512:5: (otherlv_12= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:513:6: otherlv_12= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType());
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1748); 

                    						doneLeaf(otherlv_12);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:522:4: ( (otherlv_13= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:523:5: (otherlv_13= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:523:5: (otherlv_13= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:524:6: otherlv_13= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType());
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1793); 

                    						doneLeaf(otherlv_13);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:533:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==11) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:534:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:534:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:535:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsPluginEObject1838);
                            ruleExtendsNsURIEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:544:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==13) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:545:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:545:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:546:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsPluginEObject1884);
                            ruleExtendsPluginEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:555:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==14) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:556:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:556:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:557:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsPluginEObject1930);
                            ruleExtendsResourceEObject();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:566:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:567:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:567:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:568:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsPluginEObject1976);
                    ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:577:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:578:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:578:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:579:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsPluginEObject2021);
                    ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:588:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:589:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:589:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:590:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsPluginEObject2066);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:604:1: entryRuleExtendsResourceEObject : ruleExtendsResourceEObject EOF ;
    public final void entryRuleExtendsResourceEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:604:32: ( ruleExtendsResourceEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:605:2: ruleExtendsResourceEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsResourceEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_entryRuleExtendsResourceEObject2105);
            ruleExtendsResourceEObject();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsResourceEObject2108); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:610:1: ruleExtendsResourceEObject : (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:610:27: ( (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:611:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:611:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:612:3: otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject2127); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:619:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:620:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:620:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:621:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsResourceEObject2154);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:630:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:631:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:631:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:632:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsResourceEObject2192); 

                    					doneLeaf(otherlv_2);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:639:5: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:640:6: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:640:6: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:641:7: otherlv_3= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2229); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:652:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:652:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:653:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsResourceEObject2283); 

                    					doneLeaf(otherlv_4);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:660:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:661:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:661:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:662:7: otherlv_5= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2320); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:673:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:673:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:674:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsResourceEObject2374); 

                    					doneLeaf(otherlv_6);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:681:5: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:682:6: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:682:6: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:683:7: otherlv_7= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2411); 

                    							doneLeaf(otherlv_7);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:694:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:694:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:695:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject2465); 

                    					doneLeaf(otherlv_8);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:702:5: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:703:6: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:703:6: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:704:7: otherlv_9= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2502); 

                    							doneLeaf(otherlv_9);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:715:3: (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==14) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:716:4: otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {

                    				markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject2548); 

                    				doneLeaf(otherlv_10);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:723:4: ( (otherlv_11= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:724:5: (otherlv_11= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:724:5: (otherlv_11= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:725:6: otherlv_11= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType());
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2580); 

                    						doneLeaf(otherlv_11);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:734:4: ( (otherlv_12= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:735:5: (otherlv_12= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:735:5: (otherlv_12= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:736:6: otherlv_12= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType());
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2625); 

                    						doneLeaf(otherlv_12);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:745:4: ( (otherlv_13= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:746:5: (otherlv_13= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:746:5: (otherlv_13= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:747:6: otherlv_13= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType());
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2670); 

                    						doneLeaf(otherlv_13);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:756:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:757:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:757:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:758:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsResourceEObject2715);
                    ruleExtendsNsURIEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:767:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:768:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:768:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:769:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsResourceEObject2760);
                    ruleExtendsPluginEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:778:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:779:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:779:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:780:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsResourceEObject2805);
                    ruleExtendsResourceEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:789:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:790:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:790:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:791:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsResourceEObject2850);
                    ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:800:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:801:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:801:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:802:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsResourceEObject2895);
                    ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:811:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:812:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:812:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:813:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsResourceEObject2940);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:827:1: entryRuleEObject : ruleEObject EOF ;
    public final void entryRuleEObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:827:17: ( ruleEObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:828:2: ruleEObject EOF
            {
             markComposite(elementTypeProvider.getEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEObject_in_entryRuleEObject2979);
            ruleEObject();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObject2982); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:833:1: ruleEObject : ( () otherlv_1= 'object' ) ;
    public final void ruleEObject() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:833:12: ( ( () otherlv_1= 'object' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:834:2: ( () otherlv_1= 'object' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:834:2: ( () otherlv_1= 'object' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:835:3: () otherlv_1= 'object'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:835:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:836:4: 
            {

            				precedeComposite(elementTypeProvider.getEObject_EObjectAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getEObject_ObjectKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEObject3014); 

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
    // $ANTLR end "ruleEObject"


    // $ANTLR start "entryRuleValidID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:852:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:852:17: ( ruleValidID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:853:2: ruleValidID EOF
            {
             markComposite(elementTypeProvider.getValidIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_entryRuleValidID3034);
            ruleValidID();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValidID3037); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:858:1: ruleValidID : this_ID_0= RULE_ID ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:858:12: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalEcoreReferenceTestLanguage.g:859:2: this_ID_0= RULE_ID
            {

            		markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValidID3051); 

            		doneLeaf(this_ID_0);
            	

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
        public static final BitSet FOLLOW_EOF_in_entryRuleModel57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleModel89 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleModel127 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleModel165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_entryRuleExtendsNsURIEObject196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsNsURIEObject199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsNsURIEObject218 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsNsURIEObject245 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsNsURIEObject283 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject320 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsNsURIEObject374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject411 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsNsURIEObject465 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject502 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsNsURIEObject556 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject593 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsNsURIEObject639 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject671 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject716 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject761 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject806 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsNsURIEObject851 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsNsURIEObject897 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsNsURIEObject943 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsNsURIEObject989 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsNsURIEObject1034 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsNsURIEObject1079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_entryRuleMyEAttribute1118 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyEAttribute1121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleMyEAttribute1153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttribute_in_entryRuleEAttribute1173 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAttribute1176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEAttribute1208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_entryRuleExtendsPluginEObject1228 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsPluginEObject1231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1250 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsPluginEObject1277 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsPluginEObject1315 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1352 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsPluginEObject1406 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1443 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1497 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1534 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsPluginEObject1588 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1625 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1671 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1703 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1748 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1793 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsPluginEObject1838 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsPluginEObject1884 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsPluginEObject1930 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsPluginEObject1976 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsPluginEObject2021 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsPluginEObject2066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_entryRuleExtendsResourceEObject2105 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsResourceEObject2108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject2127 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsResourceEObject2154 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsResourceEObject2192 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2229 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsResourceEObject2283 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2320 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsResourceEObject2374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2411 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject2465 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2502 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject2548 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2580 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2625 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject2670 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsResourceEObject2715 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsResourceEObject2760 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsResourceEObject2805 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsResourceEObject2850 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsResourceEObject2895 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsResourceEObject2940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObject_in_entryRuleEObject2979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObject2982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleEObject3014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID3034 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValidID3037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValidID3051 = new BitSet(new long[]{0x0000000000000002L});
    }


}