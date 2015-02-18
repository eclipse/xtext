package org.eclipse.xtext.resource.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.resource.services.LocationProviderTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalLocationProviderTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'singleref'", "'multiref'", "'modes'", "'end'", "';'", "'bus'", "'processor'", "'mode'", "':'", "'->'", "'port'", "'data'"
    };
    public static final int RULE_ID=4;
    public static final int T__23=23;
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


        public PsiInternalLocationProviderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalLocationProviderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalLocationProviderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g"; }



    	protected LocationProviderTestLanguageGrammarAccess grammarAccess;

    	protected LocationProviderTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalLocationProviderTestLanguageParser(PsiBuilder builder, TokenStream input, LocationProviderTestLanguageElementTypeProvider elementTypeProvider, LocationProviderTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:59:1: ruleModel : ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:59:10: ( ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:60:2: ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:60:2: ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:61:3: ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:61:3: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:62:4: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:62:4: (lv_elements_0_0= ruleElement )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:63:5: lv_elements_0_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel96);
            	    ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:72:3: ( (lv_components_1_0= ruleComponent ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=17 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:73:4: (lv_components_1_0= ruleComponent )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:73:4: (lv_components_1_0= ruleComponent )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:74:5: lv_components_1_0= ruleComponent
            	    {

            	    					markComposite(elementTypeProvider.getModel_ComponentsComponentParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleComponent_in_ruleModel135);
            	    ruleComponent();

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


    // $ANTLR start "entryRuleElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:87:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:87:17: ( ruleElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:88:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement167);
            ruleElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement173); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:96:1: ruleElement : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* ) ;
    public final void ruleElement() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:96:12: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:97:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:97:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:98:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement196); 

            			doneLeaf(otherlv_0, elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:105:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:106:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:106:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:107:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement223); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getElement_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:116:3: (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:117:4: otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleElement254); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getElement_SinglerefKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:124:4: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:125:5: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:125:5: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:126:6: otherlv_3= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement286); 

                    						doneLeaf(otherlv_3, elementTypeProvider.getElement_SinglerefElementCrossReference_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:136:3: (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:137:4: otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleElement325); 

            	    				doneLeaf(otherlv_4, elementTypeProvider.getElement_MultirefKeyword_3_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:144:4: ( (otherlv_5= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:145:5: (otherlv_5= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:145:5: (otherlv_5= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:146:6: otherlv_5= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement357); 

            	    						doneLeaf(otherlv_5, elementTypeProvider.getElement_MultirefsElementCrossReference_3_1_0ElementType());
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleComponent"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:160:1: entryRuleComponent : ruleComponent EOF ;
    public final void entryRuleComponent() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:160:19: ( ruleComponent EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:161:2: ruleComponent EOF
            {
             markComposite(elementTypeProvider.getComponentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleComponent_in_entryRuleComponent396);
            ruleComponent();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComponent402); 

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
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:169:1: ruleComponent : ( ( ruleBus | ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' ) ;
    public final void ruleComponent() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:169:14: ( ( ( ruleBus | ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:170:2: ( ( ruleBus | ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:170:2: ( ( ruleBus | ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:171:3: ( ruleBus | ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:171:3: ( ruleBus | ruleProcessor )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:172:4: ruleBus
                    {

                    				markComposite(elementTypeProvider.getComponent_BusParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleBus_in_ruleComponent429);
                    ruleBus();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:180:4: ruleProcessor
                    {

                    				markComposite(elementTypeProvider.getComponent_ProcessorParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleProcessor_in_ruleComponent453);
                    ruleProcessor();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:188:3: (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:189:4: otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleComponent478); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getComponent_ModesKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:196:4: ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==19) ) {
                            alt6=1;
                        }
                        else if ( (LA6_0==RULE_ID) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:197:5: ( (lv_mode_3_0= ruleMode ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:197:5: ( (lv_mode_3_0= ruleMode ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:198:6: (lv_mode_3_0= ruleMode )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:198:6: (lv_mode_3_0= ruleMode )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:199:7: lv_mode_3_0= ruleMode
                    	    {

                    	    							markComposite(elementTypeProvider.getComponent_ModeModeParserRuleCall_1_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleMode_in_ruleComponent519);
                    	    ruleMode();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:209:5: ( (lv_transition_4_0= ruleTransition ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:209:5: ( (lv_transition_4_0= ruleTransition ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:210:6: (lv_transition_4_0= ruleTransition )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:210:6: (lv_transition_4_0= ruleTransition )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:211:7: lv_transition_4_0= ruleTransition
                    	    {

                    	    							markComposite(elementTypeProvider.getComponent_TransitionTransitionParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleComponent581);
                    	    ruleTransition();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


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


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleComponent623); 

            			doneLeaf(otherlv_5, elementTypeProvider.getComponent_EndKeyword_2ElementType());
            		

            			markLeaf();
            		
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleComponent637); 

            			doneLeaf(otherlv_6, elementTypeProvider.getComponent_SemicolonKeyword_3ElementType());
            		

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
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleBus"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:240:1: entryRuleBus : ruleBus EOF ;
    public final void entryRuleBus() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:240:13: ( ruleBus EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:241:2: ruleBus EOF
            {
             markComposite(elementTypeProvider.getBusElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBus_in_entryRuleBus657);
            ruleBus();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBus663); 

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
    // $ANTLR end "entryRuleBus"


    // $ANTLR start "ruleBus"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:249:1: ruleBus : (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* ) ;
    public final void ruleBus() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:249:8: ( (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:250:2: (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:250:2: (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:251:3: otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleBus686); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBus_BusKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:258:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:259:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:259:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:260:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBus713); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getBus_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:269:3: ( (lv_port_2_0= rulePort ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:270:4: (lv_port_2_0= rulePort )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:270:4: (lv_port_2_0= rulePort )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:271:5: lv_port_2_0= rulePort
            	    {

            	    					markComposite(elementTypeProvider.getBus_PortPortParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_rulePort_in_ruleBus751);
            	    rulePort();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


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
    // $ANTLR end "ruleBus"


    // $ANTLR start "entryRuleProcessor"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:284:1: entryRuleProcessor : ruleProcessor EOF ;
    public final void entryRuleProcessor() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:284:19: ( ruleProcessor EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:285:2: ruleProcessor EOF
            {
             markComposite(elementTypeProvider.getProcessorElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleProcessor_in_entryRuleProcessor783);
            ruleProcessor();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProcessor789); 

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
    // $ANTLR end "entryRuleProcessor"


    // $ANTLR start "ruleProcessor"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:293:1: ruleProcessor : (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* ) ;
    public final void ruleProcessor() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:293:14: ( (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:294:2: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:294:2: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:295:3: otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProcessor812); 

            			doneLeaf(otherlv_0, elementTypeProvider.getProcessor_ProcessorKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:302:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:303:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:303:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:304:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProcessor839); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getProcessor_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:313:3: ( (lv_data_2_0= ruleData ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:314:4: (lv_data_2_0= ruleData )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:314:4: (lv_data_2_0= ruleData )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:315:5: lv_data_2_0= ruleData
            	    {

            	    					markComposite(elementTypeProvider.getProcessor_DataDataParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleData_in_ruleProcessor877);
            	    ruleData();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


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
    // $ANTLR end "ruleProcessor"


    // $ANTLR start "entryRuleMode"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:328:1: entryRuleMode : ruleMode EOF ;
    public final void entryRuleMode() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:328:14: ( ruleMode EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:329:2: ruleMode EOF
            {
             markComposite(elementTypeProvider.getModeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMode_in_entryRuleMode909);
            ruleMode();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMode915); 

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
    // $ANTLR end "entryRuleMode"


    // $ANTLR start "ruleMode"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:337:1: ruleMode : (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final void ruleMode() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:337:9: ( (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:338:2: (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:338:2: (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:339:3: otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMode938); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMode_ModeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:346:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:347:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:347:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:348:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMode965); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getMode_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMode990); 

            			doneLeaf(otherlv_2, elementTypeProvider.getMode_SemicolonKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleMode"


    // $ANTLR start "entryRuleTransition"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:368:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:368:20: ( ruleTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:369:2: ruleTransition EOF
            {
             markComposite(elementTypeProvider.getTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransition_in_entryRuleTransition1010);
            ruleTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransition1016); 

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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:377:1: ruleTransition : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final void ruleTransition() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:377:15: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:378:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:378:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:379:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:379:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:380:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:380:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:381:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransition1052); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getTransition_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTransition1077); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTransition_ColonKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:397:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:398:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:398:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:399:5: otherlv_2= RULE_ID
            {

            					markLeaf();
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransition1104); 

            					doneLeaf(otherlv_2, elementTypeProvider.getTransition_SourceModeCrossReference_2_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTransition1129); 

            			doneLeaf(otherlv_3, elementTypeProvider.getTransition_HyphenMinusGreaterThanSignKeyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:415:3: ( (otherlv_4= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:416:4: (otherlv_4= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:416:4: (otherlv_4= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:417:5: otherlv_4= RULE_ID
            {

            					markLeaf();
            				
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransition1156); 

            					doneLeaf(otherlv_4, elementTypeProvider.getTransition_DestinationModeCrossReference_4_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTransition1181); 

            			doneLeaf(otherlv_5, elementTypeProvider.getTransition_SemicolonKeyword_5ElementType());
            		

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
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRulePort"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:437:1: entryRulePort : rulePort EOF ;
    public final void entryRulePort() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:437:14: ( rulePort EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:438:2: rulePort EOF
            {
             markComposite(elementTypeProvider.getPortElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePort_in_entryRulePort1201);
            rulePort();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePort1207); 

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
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:446:1: rulePort : (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final void rulePort() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:446:9: ( (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:447:2: (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:447:2: (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:448:3: otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePort1230); 

            			doneLeaf(otherlv_0, elementTypeProvider.getPort_PortKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:455:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:456:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:456:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:457:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePort1257); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getPort_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePort1282); 

            			doneLeaf(otherlv_2, elementTypeProvider.getPort_SemicolonKeyword_2ElementType());
            		

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
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRuleData"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:477:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:477:14: ( ruleData EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:478:2: ruleData EOF
            {
             markComposite(elementTypeProvider.getDataElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleData_in_entryRuleData1302);
            ruleData();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleData1308); 

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
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:486:1: ruleData : (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final void ruleData() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:486:9: ( (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:487:2: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:487:2: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:488:3: otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleData1331); 

            			doneLeaf(otherlv_0, elementTypeProvider.getData_DataKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:495:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:496:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:496:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalLocationProviderTestLanguage.g:497:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleData1358); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getData_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleData1383); 

            			doneLeaf(otherlv_2, elementTypeProvider.getData_SemicolonKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleData"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel96 = new BitSet(new long[]{0x0000000000060802L});
        public static final BitSet FOLLOW_ruleComponent_in_ruleModel135 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement167 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement196 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement223 = new BitSet(new long[]{0x0000000000003002L});
        public static final BitSet FOLLOW_12_in_ruleElement254 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement286 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleElement325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement357 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleComponent_in_entryRuleComponent396 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComponent402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBus_in_ruleComponent429 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_ruleProcessor_in_ruleComponent453 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleComponent478 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_ruleMode_in_ruleComponent519 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleComponent581 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_15_in_ruleComponent623 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleComponent637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBus_in_entryRuleBus657 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBus663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleBus686 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBus713 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rulePort_in_ruleBus751 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_ruleProcessor_in_entryRuleProcessor783 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProcessor789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleProcessor812 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProcessor839 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleData_in_ruleProcessor877 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleMode_in_entryRuleMode909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMode915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMode938 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMode965 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleMode990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition1010 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransition1016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransition1052 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTransition1077 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransition1104 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleTransition1129 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransition1156 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleTransition1181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePort_in_entryRulePort1201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePort1207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rulePort1230 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePort1257 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_rulePort1282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleData_in_entryRuleData1302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleData1308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleData1331 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleData1358 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleData1383 = new BitSet(new long[]{0x0000000000000002L});
    }


}