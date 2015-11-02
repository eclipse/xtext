package org.eclipse.xtext.resource.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalLocationProviderTestLanguage.g"; }



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
    // PsiInternalLocationProviderTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalLocationProviderTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalLocationProviderTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_elements_0_0 = null;

        Boolean lv_components_1_0 = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:60:1: ( ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* ) )
            // PsiInternalLocationProviderTestLanguage.g:61:2: ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* )
            {
            // PsiInternalLocationProviderTestLanguage.g:61:2: ( ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )* )
            // PsiInternalLocationProviderTestLanguage.g:62:3: ( (lv_elements_0_0= ruleElement ) )* ( (lv_components_1_0= ruleComponent ) )*
            {
            // PsiInternalLocationProviderTestLanguage.g:62:3: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalLocationProviderTestLanguage.g:63:4: (lv_elements_0_0= ruleElement )
            	    {
            	    // PsiInternalLocationProviderTestLanguage.g:63:4: (lv_elements_0_0= ruleElement )
            	    // PsiInternalLocationProviderTestLanguage.g:64:5: lv_elements_0_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

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

            // PsiInternalLocationProviderTestLanguage.g:77:3: ( (lv_components_1_0= ruleComponent ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=17 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalLocationProviderTestLanguage.g:78:4: (lv_components_1_0= ruleComponent )
            	    {
            	    // PsiInternalLocationProviderTestLanguage.g:78:4: (lv_components_1_0= ruleComponent )
            	    // PsiInternalLocationProviderTestLanguage.g:79:5: lv_components_1_0= ruleComponent
            	    {

            	    					markComposite(elementTypeProvider.getModel_ComponentsComponentParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_components_1_0=ruleComponent();

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


    // $ANTLR start "entryRuleElement"
    // PsiInternalLocationProviderTestLanguage.g:96:1: entryRuleElement returns [Boolean current=false] : iv_ruleElement= ruleElement EOF ;
    public final Boolean entryRuleElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElement = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:96:49: (iv_ruleElement= ruleElement EOF )
            // PsiInternalLocationProviderTestLanguage.g:97:2: iv_ruleElement= ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalLocationProviderTestLanguage.g:103:1: ruleElement returns [Boolean current=false] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* ) ;
    public final Boolean ruleElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // PsiInternalLocationProviderTestLanguage.g:104:1: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* ) )
            // PsiInternalLocationProviderTestLanguage.g:105:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* )
            {
            // PsiInternalLocationProviderTestLanguage.g:105:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )* )
            // PsiInternalLocationProviderTestLanguage.g:106:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLocationProviderTestLanguage.g:113:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:114:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:114:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:115:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalLocationProviderTestLanguage.g:130:3: (otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalLocationProviderTestLanguage.g:131:4: otherlv_2= 'singleref' ( (otherlv_3= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getElement_SinglerefKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalLocationProviderTestLanguage.g:138:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalLocationProviderTestLanguage.g:139:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalLocationProviderTestLanguage.g:139:5: (otherlv_3= RULE_ID )
                    // PsiInternalLocationProviderTestLanguage.g:140:6: otherlv_3= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getElement_SinglerefElementCrossReference_2_1_0ElementType());
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						doneLeaf(otherlv_3);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalLocationProviderTestLanguage.g:156:3: (otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalLocationProviderTestLanguage.g:157:4: otherlv_4= 'multiref' ( (otherlv_5= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getElement_MultirefKeyword_3_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalLocationProviderTestLanguage.g:164:4: ( (otherlv_5= RULE_ID ) )
            	    // PsiInternalLocationProviderTestLanguage.g:165:5: (otherlv_5= RULE_ID )
            	    {
            	    // PsiInternalLocationProviderTestLanguage.g:165:5: (otherlv_5= RULE_ID )
            	    // PsiInternalLocationProviderTestLanguage.g:166:6: otherlv_5= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getElement_MultirefsElementCrossReference_3_1_0ElementType());
            	    					
            	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    						doneLeaf(otherlv_5);
            	    					

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
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleComponent"
    // PsiInternalLocationProviderTestLanguage.g:186:1: entryRuleComponent returns [Boolean current=false] : iv_ruleComponent= ruleComponent EOF ;
    public final Boolean entryRuleComponent() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleComponent = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:186:51: (iv_ruleComponent= ruleComponent EOF )
            // PsiInternalLocationProviderTestLanguage.g:187:2: iv_ruleComponent= ruleComponent EOF
            {
             markComposite(elementTypeProvider.getComponentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
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
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // PsiInternalLocationProviderTestLanguage.g:193:1: ruleComponent returns [Boolean current=false] : ( (this_Bus_0= ruleBus | this_Processor_1= ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' ) ;
    public final Boolean ruleComponent() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Boolean this_Bus_0 = null;

        Boolean this_Processor_1 = null;

        Boolean lv_mode_3_0 = null;

        Boolean lv_transition_4_0 = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:194:1: ( ( (this_Bus_0= ruleBus | this_Processor_1= ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' ) )
            // PsiInternalLocationProviderTestLanguage.g:195:2: ( (this_Bus_0= ruleBus | this_Processor_1= ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' )
            {
            // PsiInternalLocationProviderTestLanguage.g:195:2: ( (this_Bus_0= ruleBus | this_Processor_1= ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';' )
            // PsiInternalLocationProviderTestLanguage.g:196:3: (this_Bus_0= ruleBus | this_Processor_1= ruleProcessor ) (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )? otherlv_5= 'end' otherlv_6= ';'
            {
            // PsiInternalLocationProviderTestLanguage.g:196:3: (this_Bus_0= ruleBus | this_Processor_1= ruleProcessor )
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
                    // PsiInternalLocationProviderTestLanguage.g:197:4: this_Bus_0= ruleBus
                    {

                    				markComposite(elementTypeProvider.getComponent_BusParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_8);
                    this_Bus_0=ruleBus();

                    state._fsp--;


                    				current = this_Bus_0;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalLocationProviderTestLanguage.g:206:4: this_Processor_1= ruleProcessor
                    {

                    				markComposite(elementTypeProvider.getComponent_ProcessorParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_8);
                    this_Processor_1=ruleProcessor();

                    state._fsp--;


                    				current = this_Processor_1;
                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalLocationProviderTestLanguage.g:215:3: (otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalLocationProviderTestLanguage.g:216:4: otherlv_2= 'modes' ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+
                    {

                    				markLeaf(elementTypeProvider.getComponent_ModesKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_9); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalLocationProviderTestLanguage.g:223:4: ( ( (lv_mode_3_0= ruleMode ) ) | ( (lv_transition_4_0= ruleTransition ) ) )+
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
                    	    // PsiInternalLocationProviderTestLanguage.g:224:5: ( (lv_mode_3_0= ruleMode ) )
                    	    {
                    	    // PsiInternalLocationProviderTestLanguage.g:224:5: ( (lv_mode_3_0= ruleMode ) )
                    	    // PsiInternalLocationProviderTestLanguage.g:225:6: (lv_mode_3_0= ruleMode )
                    	    {
                    	    // PsiInternalLocationProviderTestLanguage.g:225:6: (lv_mode_3_0= ruleMode )
                    	    // PsiInternalLocationProviderTestLanguage.g:226:7: lv_mode_3_0= ruleMode
                    	    {

                    	    							markComposite(elementTypeProvider.getComponent_ModeModeParserRuleCall_1_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_10);
                    	    lv_mode_3_0=ruleMode();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalLocationProviderTestLanguage.g:240:5: ( (lv_transition_4_0= ruleTransition ) )
                    	    {
                    	    // PsiInternalLocationProviderTestLanguage.g:240:5: ( (lv_transition_4_0= ruleTransition ) )
                    	    // PsiInternalLocationProviderTestLanguage.g:241:6: (lv_transition_4_0= ruleTransition )
                    	    {
                    	    // PsiInternalLocationProviderTestLanguage.g:241:6: (lv_transition_4_0= ruleTransition )
                    	    // PsiInternalLocationProviderTestLanguage.g:242:7: lv_transition_4_0= ruleTransition
                    	    {

                    	    							markComposite(elementTypeProvider.getComponent_TransitionTransitionParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_10);
                    	    lv_transition_4_0=ruleTransition();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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


            			markLeaf(elementTypeProvider.getComponent_EndKeyword_2ElementType());
            		
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_5);
            		

            			markLeaf(elementTypeProvider.getComponent_SemicolonKeyword_3ElementType());
            		
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleBus"
    // PsiInternalLocationProviderTestLanguage.g:275:1: entryRuleBus returns [Boolean current=false] : iv_ruleBus= ruleBus EOF ;
    public final Boolean entryRuleBus() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBus = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:275:45: (iv_ruleBus= ruleBus EOF )
            // PsiInternalLocationProviderTestLanguage.g:276:2: iv_ruleBus= ruleBus EOF
            {
             markComposite(elementTypeProvider.getBusElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBus=ruleBus();

            state._fsp--;

             current =iv_ruleBus; 
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
    // $ANTLR end "entryRuleBus"


    // $ANTLR start "ruleBus"
    // PsiInternalLocationProviderTestLanguage.g:282:1: ruleBus returns [Boolean current=false] : (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* ) ;
    public final Boolean ruleBus() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Boolean lv_port_2_0 = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:283:1: ( (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* ) )
            // PsiInternalLocationProviderTestLanguage.g:284:2: (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* )
            {
            // PsiInternalLocationProviderTestLanguage.g:284:2: (otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )* )
            // PsiInternalLocationProviderTestLanguage.g:285:3: otherlv_0= 'bus' ( (lv_name_1_0= RULE_ID ) ) ( (lv_port_2_0= rulePort ) )*
            {

            			markLeaf(elementTypeProvider.getBus_BusKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLocationProviderTestLanguage.g:292:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:293:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:293:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:294:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBus_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalLocationProviderTestLanguage.g:309:3: ( (lv_port_2_0= rulePort ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalLocationProviderTestLanguage.g:310:4: (lv_port_2_0= rulePort )
            	    {
            	    // PsiInternalLocationProviderTestLanguage.g:310:4: (lv_port_2_0= rulePort )
            	    // PsiInternalLocationProviderTestLanguage.g:311:5: lv_port_2_0= rulePort
            	    {

            	    					markComposite(elementTypeProvider.getBus_PortPortParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    lv_port_2_0=rulePort();

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
        return current;
    }
    // $ANTLR end "ruleBus"


    // $ANTLR start "entryRuleProcessor"
    // PsiInternalLocationProviderTestLanguage.g:328:1: entryRuleProcessor returns [Boolean current=false] : iv_ruleProcessor= ruleProcessor EOF ;
    public final Boolean entryRuleProcessor() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleProcessor = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:328:51: (iv_ruleProcessor= ruleProcessor EOF )
            // PsiInternalLocationProviderTestLanguage.g:329:2: iv_ruleProcessor= ruleProcessor EOF
            {
             markComposite(elementTypeProvider.getProcessorElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProcessor=ruleProcessor();

            state._fsp--;

             current =iv_ruleProcessor; 
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
    // $ANTLR end "entryRuleProcessor"


    // $ANTLR start "ruleProcessor"
    // PsiInternalLocationProviderTestLanguage.g:335:1: ruleProcessor returns [Boolean current=false] : (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* ) ;
    public final Boolean ruleProcessor() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Boolean lv_data_2_0 = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:336:1: ( (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* ) )
            // PsiInternalLocationProviderTestLanguage.g:337:2: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* )
            {
            // PsiInternalLocationProviderTestLanguage.g:337:2: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )* )
            // PsiInternalLocationProviderTestLanguage.g:338:3: otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_data_2_0= ruleData ) )*
            {

            			markLeaf(elementTypeProvider.getProcessor_ProcessorKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLocationProviderTestLanguage.g:345:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:346:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:346:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:347:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getProcessor_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalLocationProviderTestLanguage.g:362:3: ( (lv_data_2_0= ruleData ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // PsiInternalLocationProviderTestLanguage.g:363:4: (lv_data_2_0= ruleData )
            	    {
            	    // PsiInternalLocationProviderTestLanguage.g:363:4: (lv_data_2_0= ruleData )
            	    // PsiInternalLocationProviderTestLanguage.g:364:5: lv_data_2_0= ruleData
            	    {

            	    					markComposite(elementTypeProvider.getProcessor_DataDataParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_data_2_0=ruleData();

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
        return current;
    }
    // $ANTLR end "ruleProcessor"


    // $ANTLR start "entryRuleMode"
    // PsiInternalLocationProviderTestLanguage.g:381:1: entryRuleMode returns [Boolean current=false] : iv_ruleMode= ruleMode EOF ;
    public final Boolean entryRuleMode() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMode = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:381:46: (iv_ruleMode= ruleMode EOF )
            // PsiInternalLocationProviderTestLanguage.g:382:2: iv_ruleMode= ruleMode EOF
            {
             markComposite(elementTypeProvider.getModeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMode=ruleMode();

            state._fsp--;

             current =iv_ruleMode; 
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
    // $ANTLR end "entryRuleMode"


    // $ANTLR start "ruleMode"
    // PsiInternalLocationProviderTestLanguage.g:388:1: ruleMode returns [Boolean current=false] : (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final Boolean ruleMode() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalLocationProviderTestLanguage.g:389:1: ( (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // PsiInternalLocationProviderTestLanguage.g:390:2: (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // PsiInternalLocationProviderTestLanguage.g:390:2: (otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // PsiInternalLocationProviderTestLanguage.g:391:3: otherlv_0= 'mode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markLeaf(elementTypeProvider.getMode_ModeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLocationProviderTestLanguage.g:398:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:399:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:399:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:400:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getMode_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMode_SemicolonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleMode"


    // $ANTLR start "entryRuleTransition"
    // PsiInternalLocationProviderTestLanguage.g:426:1: entryRuleTransition returns [Boolean current=false] : iv_ruleTransition= ruleTransition EOF ;
    public final Boolean entryRuleTransition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTransition = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:426:52: (iv_ruleTransition= ruleTransition EOF )
            // PsiInternalLocationProviderTestLanguage.g:427:2: iv_ruleTransition= ruleTransition EOF
            {
             markComposite(elementTypeProvider.getTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // PsiInternalLocationProviderTestLanguage.g:433:1: ruleTransition returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final Boolean ruleTransition() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // PsiInternalLocationProviderTestLanguage.g:434:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // PsiInternalLocationProviderTestLanguage.g:435:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // PsiInternalLocationProviderTestLanguage.g:435:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // PsiInternalLocationProviderTestLanguage.g:436:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            // PsiInternalLocationProviderTestLanguage.g:436:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:437:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:437:4: (lv_name_0_0= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:438:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTransition_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTransition_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLocationProviderTestLanguage.g:460:3: ( (otherlv_2= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:461:4: (otherlv_2= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:461:4: (otherlv_2= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:462:5: otherlv_2= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getTransition_SourceModeCrossReference_2_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            					doneLeaf(otherlv_2);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTransition_HyphenMinusGreaterThanSignKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalLocationProviderTestLanguage.g:484:3: ( (otherlv_4= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:485:4: (otherlv_4= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:485:4: (otherlv_4= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:486:5: otherlv_4= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getTransition_DestinationModeCrossReference_4_0ElementType());
            				
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					doneLeaf(otherlv_4);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTransition_SemicolonKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRulePort"
    // PsiInternalLocationProviderTestLanguage.g:512:1: entryRulePort returns [Boolean current=false] : iv_rulePort= rulePort EOF ;
    public final Boolean entryRulePort() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePort = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:512:46: (iv_rulePort= rulePort EOF )
            // PsiInternalLocationProviderTestLanguage.g:513:2: iv_rulePort= rulePort EOF
            {
             markComposite(elementTypeProvider.getPortElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePort=rulePort();

            state._fsp--;

             current =iv_rulePort; 
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
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // PsiInternalLocationProviderTestLanguage.g:519:1: rulePort returns [Boolean current=false] : (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final Boolean rulePort() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalLocationProviderTestLanguage.g:520:1: ( (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // PsiInternalLocationProviderTestLanguage.g:521:2: (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // PsiInternalLocationProviderTestLanguage.g:521:2: (otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // PsiInternalLocationProviderTestLanguage.g:522:3: otherlv_0= 'port' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markLeaf(elementTypeProvider.getPort_PortKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLocationProviderTestLanguage.g:529:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:530:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:530:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:531:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getPort_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getPort_SemicolonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRuleData"
    // PsiInternalLocationProviderTestLanguage.g:557:1: entryRuleData returns [Boolean current=false] : iv_ruleData= ruleData EOF ;
    public final Boolean entryRuleData() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleData = null;


        try {
            // PsiInternalLocationProviderTestLanguage.g:557:46: (iv_ruleData= ruleData EOF )
            // PsiInternalLocationProviderTestLanguage.g:558:2: iv_ruleData= ruleData EOF
            {
             markComposite(elementTypeProvider.getDataElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleData=ruleData();

            state._fsp--;

             current =iv_ruleData; 
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
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // PsiInternalLocationProviderTestLanguage.g:564:1: ruleData returns [Boolean current=false] : (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final Boolean ruleData() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalLocationProviderTestLanguage.g:565:1: ( (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // PsiInternalLocationProviderTestLanguage.g:566:2: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // PsiInternalLocationProviderTestLanguage.g:566:2: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // PsiInternalLocationProviderTestLanguage.g:567:3: otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {

            			markLeaf(elementTypeProvider.getData_DataKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLocationProviderTestLanguage.g:574:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLocationProviderTestLanguage.g:575:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLocationProviderTestLanguage.g:575:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLocationProviderTestLanguage.g:576:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getData_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getData_SemicolonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleData"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000060802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000003002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    }


}