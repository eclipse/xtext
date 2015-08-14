package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalXtextTerminalsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'returns'", "':'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'?='", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'"
    };
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__11=11;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalXtextTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalXtextTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalXtextTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalXtextTerminalsTestLanguage.g"; }



    	protected XtextTerminalsTestLanguageGrammarAccess grammarAccess;

    	protected XtextTerminalsTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalXtextTerminalsTestLanguageParser(PsiBuilder builder, TokenStream input, XtextTerminalsTestLanguageElementTypeProvider elementTypeProvider, XtextTerminalsTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Grammar";
    	}




    // $ANTLR start "entryRuleGrammar"
    // PsiInternalXtextTerminalsTestLanguage.g:52:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:52:17: ( ruleGrammar EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:53:2: ruleGrammar EOF
            {
             markComposite(elementTypeProvider.getGrammarElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammar();

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
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // PsiInternalXtextTerminalsTestLanguage.g:58:1: ruleGrammar : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
    public final void ruleGrammar() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_definesHiddenTokens_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:58:12: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // PsiInternalXtextTerminalsTestLanguage.g:59:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:59:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // PsiInternalXtextTerminalsTestLanguage.g:60:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {

            			markLeaf(elementTypeProvider.getGrammar_GrammarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:67:3: ( (lv_name_1_0= ruleGrammarID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:68:4: (lv_name_1_0= ruleGrammarID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:68:4: (lv_name_1_0= ruleGrammarID )
            // PsiInternalXtextTerminalsTestLanguage.g:69:5: lv_name_1_0= ruleGrammarID
            {

            					markComposite(elementTypeProvider.getGrammar_NameGrammarIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleGrammarID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:78:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:79:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {

                    				markLeaf(elementTypeProvider.getGrammar_WithKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:86:4: ( ( ruleGrammarID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:87:5: ( ruleGrammarID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:87:5: ( ruleGrammarID )
                    // PsiInternalXtextTerminalsTestLanguage.g:88:6: ruleGrammarID
                    {

                    						markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_5);
                    ruleGrammarID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:97:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:98:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getGrammar_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:105:5: ( ( ruleGrammarID ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:106:6: ( ruleGrammarID )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:106:6: ( ruleGrammarID )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:107:7: ruleGrammarID
                    	    {

                    	    							markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    ruleGrammarID();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            // PsiInternalXtextTerminalsTestLanguage.g:118:3: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:119:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')'
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:119:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:120:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:120:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // PsiInternalXtextTerminalsTestLanguage.g:121:6: lv_definesHiddenTokens_6_0= 'hidden'
                    {

                    						markLeaf(elementTypeProvider.getGrammar_DefinesHiddenTokensHiddenKeyword_3_0_0ElementType());
                    					
                    lv_definesHiddenTokens_6_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                    						doneLeaf(lv_definesHiddenTokens_6_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getGrammar_LeftParenthesisKeyword_3_1ElementType());
                    			
                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_7);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:137:4: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // PsiInternalXtextTerminalsTestLanguage.g:138:5: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:138:5: ( (otherlv_8= RULE_ID ) )
                            // PsiInternalXtextTerminalsTestLanguage.g:139:6: (otherlv_8= RULE_ID )
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:139:6: (otherlv_8= RULE_ID )
                            // PsiInternalXtextTerminalsTestLanguage.g:140:7: otherlv_8= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType());
                            						
                            otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            							doneLeaf(otherlv_8);
                            						

                            }


                            }

                            // PsiInternalXtextTerminalsTestLanguage.g:149:5: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // PsiInternalXtextTerminalsTestLanguage.g:150:6: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getGrammar_CommaKeyword_3_2_1_0ElementType());
                            	    					
                            	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            	    						doneLeaf(otherlv_9);
                            	    					
                            	    // PsiInternalXtextTerminalsTestLanguage.g:157:6: ( (otherlv_10= RULE_ID ) )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:158:7: (otherlv_10= RULE_ID )
                            	    {
                            	    // PsiInternalXtextTerminalsTestLanguage.g:158:7: (otherlv_10= RULE_ID )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:159:8: otherlv_10= RULE_ID
                            	    {

                            	    								markLeaf(elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0ElementType());
                            	    							
                            	    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            	    								doneLeaf(otherlv_10);
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getGrammar_RightParenthesisKeyword_3_3ElementType());
                    			
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_11);
                    			

                    }
                    break;

            }

            // PsiInternalXtextTerminalsTestLanguage.g:178:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalXtextTerminalsTestLanguage.g:179:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // PsiInternalXtextTerminalsTestLanguage.g:179:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // PsiInternalXtextTerminalsTestLanguage.g:180:5: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    ruleAbstractMetamodelDeclaration();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // PsiInternalXtextTerminalsTestLanguage.g:189:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==37||LA7_0==41) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalXtextTerminalsTestLanguage.g:190:4: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // PsiInternalXtextTerminalsTestLanguage.g:190:4: (lv_rules_13_0= ruleAbstractRule )
            	    // PsiInternalXtextTerminalsTestLanguage.g:191:5: lv_rules_13_0= ruleAbstractRule
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    ruleAbstractRule();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleGrammarID"
    // PsiInternalXtextTerminalsTestLanguage.g:204:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:204:19: ( ruleGrammarID EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:205:2: ruleGrammarID EOF
            {
             markComposite(elementTypeProvider.getGrammarIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammarID();

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
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // PsiInternalXtextTerminalsTestLanguage.g:210:1: ruleGrammarID : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleGrammarID() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:210:14: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalXtextTerminalsTestLanguage.g:211:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:211:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalXtextTerminalsTestLanguage.g:212:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getGrammarID_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:219:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalXtextTerminalsTestLanguage.g:220:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getGrammarID_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getGrammarID_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            	    				doneLeaf(this_ID_2);
            	    			

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
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // PsiInternalXtextTerminalsTestLanguage.g:239:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:239:22: ( ruleAbstractRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:240:2: ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractRule();

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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // PsiInternalXtextTerminalsTestLanguage.g:245:1: ruleAbstractRule : ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) ;
    public final void ruleAbstractRule() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:245:17: ( ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) )
            // PsiInternalXtextTerminalsTestLanguage.g:246:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:246:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt9=1;
                }
                break;
            case 37:
                {
                alt9=2;
                }
                break;
            case 41:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:247:3: ruleParserRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:255:3: ruleTerminalRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_TerminalRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextTerminalsTestLanguage.g:263:3: ruleEnumRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_EnumRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEnumRule();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // PsiInternalXtextTerminalsTestLanguage.g:274:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:274:38: ( ruleAbstractMetamodelDeclaration EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:275:2: ruleAbstractMetamodelDeclaration EOF
            {
             markComposite(elementTypeProvider.getAbstractMetamodelDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractMetamodelDeclaration();

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
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // PsiInternalXtextTerminalsTestLanguage.g:280:1: ruleAbstractMetamodelDeclaration : ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:280:33: ( ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) )
            // PsiInternalXtextTerminalsTestLanguage.g:281:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:281:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
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
                    // PsiInternalXtextTerminalsTestLanguage.g:282:3: ruleGeneratedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleGeneratedMetamodel();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:290:3: ruleReferencedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReferencedMetamodel();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // PsiInternalXtextTerminalsTestLanguage.g:301:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:301:28: ( ruleGeneratedMetamodel EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:302:2: ruleGeneratedMetamodel EOF
            {
             markComposite(elementTypeProvider.getGeneratedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGeneratedMetamodel();

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
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // PsiInternalXtextTerminalsTestLanguage.g:307:1: ruleGeneratedMetamodel : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:307:23: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:308:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:308:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:309:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getGeneratedMetamodel_GenerateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:316:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:317:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:317:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:318:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:327:3: ( (otherlv_2= RULE_STRING ) )
            // PsiInternalXtextTerminalsTestLanguage.g:328:4: (otherlv_2= RULE_STRING )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:328:4: (otherlv_2= RULE_STRING )
            // PsiInternalXtextTerminalsTestLanguage.g:329:5: otherlv_2= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            					doneLeaf(otherlv_2);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:338:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:339:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getGeneratedMetamodel_AsKeyword_3_0ElementType());
                    			
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:346:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:347:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:347:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:348:6: lv_alias_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType());
                    					
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_alias_4_0);
                    					

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
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // PsiInternalXtextTerminalsTestLanguage.g:362:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:362:29: ( ruleReferencedMetamodel EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:363:2: ruleReferencedMetamodel EOF
            {
             markComposite(elementTypeProvider.getReferencedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReferencedMetamodel();

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
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // PsiInternalXtextTerminalsTestLanguage.g:368:1: ruleReferencedMetamodel : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:368:24: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:369:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:369:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:370:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getReferencedMetamodel_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:377:3: ( (otherlv_1= RULE_STRING ) )
            // PsiInternalXtextTerminalsTestLanguage.g:378:4: (otherlv_1= RULE_STRING )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:378:4: (otherlv_1= RULE_STRING )
            // PsiInternalXtextTerminalsTestLanguage.g:379:5: otherlv_1= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:388:3: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:389:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getReferencedMetamodel_AsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:396:4: ( (lv_alias_3_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:397:5: (lv_alias_3_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:397:5: (lv_alias_3_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:398:6: lv_alias_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_alias_3_0);
                    					

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
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // PsiInternalXtextTerminalsTestLanguage.g:412:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:412:20: ( ruleParserRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:413:2: ruleParserRule EOF
            {
             markComposite(elementTypeProvider.getParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRule();

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
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // PsiInternalXtextTerminalsTestLanguage.g:418:1: ruleParserRule : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) ;
    public final void ruleParserRule() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_definesHiddenTokens_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:418:15: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:419:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:419:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            // PsiInternalXtextTerminalsTestLanguage.g:420:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';'
            {
            // PsiInternalXtextTerminalsTestLanguage.g:420:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:421:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:421:4: (lv_name_0_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:422:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParserRule_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:431:3: (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:432:4: otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {

                    				markLeaf(elementTypeProvider.getParserRule_ReturnsKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:439:4: ( (lv_type_2_0= ruleTypeRef ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:440:5: (lv_type_2_0= ruleTypeRef )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:440:5: (lv_type_2_0= ruleTypeRef )
                    // PsiInternalXtextTerminalsTestLanguage.g:441:6: lv_type_2_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getParserRule_TypeTypeRefParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleTypeRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalXtextTerminalsTestLanguage.g:451:3: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:452:4: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')'
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:452:4: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:453:5: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:453:5: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // PsiInternalXtextTerminalsTestLanguage.g:454:6: lv_definesHiddenTokens_3_0= 'hidden'
                    {

                    						markLeaf(elementTypeProvider.getParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0ElementType());
                    					
                    lv_definesHiddenTokens_3_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                    						doneLeaf(lv_definesHiddenTokens_3_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getParserRule_LeftParenthesisKeyword_2_1ElementType());
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:470:4: ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // PsiInternalXtextTerminalsTestLanguage.g:471:5: ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:471:5: ( (otherlv_5= RULE_ID ) )
                            // PsiInternalXtextTerminalsTestLanguage.g:472:6: (otherlv_5= RULE_ID )
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:472:6: (otherlv_5= RULE_ID )
                            // PsiInternalXtextTerminalsTestLanguage.g:473:7: otherlv_5= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0ElementType());
                            						
                            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            							doneLeaf(otherlv_5);
                            						

                            }


                            }

                            // PsiInternalXtextTerminalsTestLanguage.g:482:5: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // PsiInternalXtextTerminalsTestLanguage.g:483:6: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getParserRule_CommaKeyword_2_2_1_0ElementType());
                            	    					
                            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            	    						doneLeaf(otherlv_6);
                            	    					
                            	    // PsiInternalXtextTerminalsTestLanguage.g:490:6: ( (otherlv_7= RULE_ID ) )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:491:7: (otherlv_7= RULE_ID )
                            	    {
                            	    // PsiInternalXtextTerminalsTestLanguage.g:491:7: (otherlv_7= RULE_ID )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:492:8: otherlv_7= RULE_ID
                            	    {

                            	    								markLeaf(elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0ElementType());
                            	    							
                            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            	    								doneLeaf(otherlv_7);
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getParserRule_RightParenthesisKeyword_2_3ElementType());
                    			
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_15); 

                    				doneLeaf(otherlv_8);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getParserRule_ColonKeyword_3ElementType());
            		
            otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_9);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:518:3: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // PsiInternalXtextTerminalsTestLanguage.g:519:4: (lv_alternatives_10_0= ruleAlternatives )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:519:4: (lv_alternatives_10_0= ruleAlternatives )
            // PsiInternalXtextTerminalsTestLanguage.g:520:5: lv_alternatives_10_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getParserRule_AlternativesAlternativesParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            ruleAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getParserRule_SemicolonKeyword_5ElementType());
            		
            otherlv_11=(Token)match(input,23,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_11);
            		

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
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "entryRuleTypeRef"
    // PsiInternalXtextTerminalsTestLanguage.g:540:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:540:17: ( ruleTypeRef EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:541:2: ruleTypeRef EOF
            {
             markComposite(elementTypeProvider.getTypeRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRef();

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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // PsiInternalXtextTerminalsTestLanguage.g:546:1: ruleTypeRef : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final void ruleTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:546:12: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:547:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:547:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:548:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:548:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==24) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:549:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:549:4: ( (otherlv_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:550:5: (otherlv_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:550:5: (otherlv_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:551:6: otherlv_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType());
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    						doneLeaf(otherlv_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getTypeRef_ColonColonKeyword_0_1ElementType());
                    			
                    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;

            }

            // PsiInternalXtextTerminalsTestLanguage.g:568:3: ( (otherlv_2= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:569:4: (otherlv_2= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:569:4: (otherlv_2= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:570:5: otherlv_2= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTypeRef_ClassifierEClassifierCrossReference_1_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_2);
            				

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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // PsiInternalXtextTerminalsTestLanguage.g:583:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:583:22: ( ruleAlternatives EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:584:2: ruleAlternatives EOF
            {
             markComposite(elementTypeProvider.getAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternatives();

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
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // PsiInternalXtextTerminalsTestLanguage.g:589:1: ruleAlternatives : ( ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final void ruleAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:589:17: ( ( ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:590:2: ( ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:590:2: ( ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:591:3: ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAlternatives_GroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            ruleGroup();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:598:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:599:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:599:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:600:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAlternatives_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:605:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==25) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:606:5: otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_16); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:613:5: ( (lv_groups_3_0= ruleGroup ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:614:6: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:614:6: (lv_groups_3_0= ruleGroup )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:615:7: lv_groups_3_0= ruleGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getAlternatives_GroupsGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    ruleGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


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
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleGroup"
    // PsiInternalXtextTerminalsTestLanguage.g:630:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:630:15: ( ruleGroup EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:631:2: ruleGroup EOF
            {
             markComposite(elementTypeProvider.getGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGroup();

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
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // PsiInternalXtextTerminalsTestLanguage.g:636:1: ruleGroup : ( ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) ;
    public final void ruleGroup() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:636:10: ( ( ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:637:2: ( ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:637:2: ( ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:638:3: ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getGroup_AbstractTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_20);
            ruleAbstractToken();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:645:3: ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==15||LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:646:4: () ( (lv_tokens_2_0= ruleAbstractToken ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:646:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:647:5: 
                    {

                    					precedeComposite(elementTypeProvider.getGroup_GroupTokensAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:652:4: ( (lv_tokens_2_0= ruleAbstractToken ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_STRING)||LA20_0==15||LA20_0==29) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:653:5: (lv_tokens_2_0= ruleAbstractToken )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:653:5: (lv_tokens_2_0= ruleAbstractToken )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:654:6: lv_tokens_2_0= ruleAbstractToken
                    	    {

                    	    						markComposite(elementTypeProvider.getGroup_TokensAbstractTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_20);
                    	    ruleAbstractToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // PsiInternalXtextTerminalsTestLanguage.g:668:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:668:23: ( ruleAbstractToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:669:2: ruleAbstractToken EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractToken();

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
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // PsiInternalXtextTerminalsTestLanguage.g:674:1: ruleAbstractToken : ( ruleAbstractTokenWithCardinality | ruleAction ) ;
    public final void ruleAbstractToken() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:674:18: ( ( ruleAbstractTokenWithCardinality | ruleAction ) )
            // PsiInternalXtextTerminalsTestLanguage.g:675:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:675:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||LA22_0==15) ) {
                alt22=1;
            }
            else if ( (LA22_0==29) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:676:3: ruleAbstractTokenWithCardinality
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:684:3: ruleAction
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_ActionParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAction();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // PsiInternalXtextTerminalsTestLanguage.g:695:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:695:38: ( ruleAbstractTokenWithCardinality EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:696:2: ruleAbstractTokenWithCardinality EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenWithCardinalityElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTokenWithCardinality();

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
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // PsiInternalXtextTerminalsTestLanguage.g:701:1: ruleAbstractTokenWithCardinality : ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {
        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:701:33: ( ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:702:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:702:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:703:3: ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // PsiInternalXtextTerminalsTestLanguage.g:703:3: ( ruleAssignment | ruleAbstractTerminal )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( ((LA23_1>=30 && LA23_1<=31)||LA23_1==34) ) {
                    alt23=1;
                }
                else if ( (LA23_1==EOF||(LA23_1>=RULE_ID && LA23_1<=RULE_STRING)||(LA23_1>=15 && LA23_1<=16)||LA23_1==23||(LA23_1>=25 && LA23_1<=29)) ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==RULE_STRING||LA23_0==15) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:704:4: ruleAssignment
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_21);
                    ruleAssignment();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:712:4: ruleAbstractTerminal
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_21);
                    ruleAbstractTerminal();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalXtextTerminalsTestLanguage.g:720:3: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=26 && LA25_0<=28)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:721:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:721:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:722:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:722:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    int alt24=3;
                    switch ( input.LA(1) ) {
                    case 26:
                        {
                        alt24=1;
                        }
                        break;
                    case 27:
                        {
                        alt24=2;
                        }
                        break;
                    case 28:
                        {
                        alt24=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // PsiInternalXtextTerminalsTestLanguage.g:723:6: lv_cardinality_2_1= '?'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					
                            lv_cardinality_2_1=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_2_1);
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalXtextTerminalsTestLanguage.g:731:6: lv_cardinality_2_2= '*'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					
                            lv_cardinality_2_2=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_2_2);
                            					

                            }
                            break;
                        case 3 :
                            // PsiInternalXtextTerminalsTestLanguage.g:739:6: lv_cardinality_2_3= '+'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					
                            lv_cardinality_2_3=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_2_3);
                            					

                            }
                            break;

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
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "entryRuleAction"
    // PsiInternalXtextTerminalsTestLanguage.g:753:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:753:16: ( ruleAction EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:754:2: ruleAction EOF
            {
             markComposite(elementTypeProvider.getActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAction();

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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // PsiInternalXtextTerminalsTestLanguage.g:759:1: ruleAction : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final void ruleAction() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:759:11: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:760:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:760:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // PsiInternalXtextTerminalsTestLanguage.g:761:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getAction_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:768:3: ( (lv_type_1_0= ruleTypeRef ) )
            // PsiInternalXtextTerminalsTestLanguage.g:769:4: (lv_type_1_0= ruleTypeRef )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:769:4: (lv_type_1_0= ruleTypeRef )
            // PsiInternalXtextTerminalsTestLanguage.g:770:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getAction_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_22);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:779:3: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:780:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {

                    				markLeaf(elementTypeProvider.getAction_FullStopKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:787:4: ( (lv_feature_3_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:788:5: (lv_feature_3_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:788:5: (lv_feature_3_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:789:6: lv_feature_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAction_FeatureIDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

                    						doneLeaf(lv_feature_3_0);
                    					

                    }


                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:798:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:799:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:799:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:800:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:800:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==30) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==31) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // PsiInternalXtextTerminalsTestLanguage.g:801:7: lv_operator_4_1= '='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorEqualsSignKeyword_2_2_0_0ElementType());
                            						
                            lv_operator_4_1=(Token)match(input,30,FollowSets000.FOLLOW_24); 

                            							doneLeaf(lv_operator_4_1);
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalXtextTerminalsTestLanguage.g:809:7: lv_operator_4_2= '+='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType());
                            						
                            lv_operator_4_2=(Token)match(input,31,FollowSets000.FOLLOW_24); 

                            							doneLeaf(lv_operator_4_2);
                            						

                            }
                            break;

                    }


                    }


                    }


                    				markLeaf(elementTypeProvider.getAction_CurrentKeyword_2_3ElementType());
                    			
                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_25); 

                    				doneLeaf(otherlv_5);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getAction_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_6=(Token)match(input,33,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:838:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:838:26: ( ruleAbstractTerminal EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:839:2: ruleAbstractTerminal EOF
            {
             markComposite(elementTypeProvider.getAbstractTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTerminal();

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
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:844:1: ruleAbstractTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:844:21: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement ) )
            // PsiInternalXtextTerminalsTestLanguage.g:845:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:845:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement )
            int alt28=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt28=1;
                }
                break;
            case RULE_ID:
                {
                alt28=2;
                }
                break;
            case 15:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:846:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:854:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextTerminalsTestLanguage.g:862:3: ruleParenthesizedElement
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedElement();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // PsiInternalXtextTerminalsTestLanguage.g:873:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:873:17: ( ruleKeyword EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:874:2: ruleKeyword EOF
            {
             markComposite(elementTypeProvider.getKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKeyword();

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
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // PsiInternalXtextTerminalsTestLanguage.g:879:1: ruleKeyword : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final void ruleKeyword() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:879:12: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:880:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:880:2: ( (lv_value_0_0= RULE_STRING ) )
            // PsiInternalXtextTerminalsTestLanguage.g:881:3: (lv_value_0_0= RULE_STRING )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:881:3: (lv_value_0_0= RULE_STRING )
            // PsiInternalXtextTerminalsTestLanguage.g:882:4: lv_value_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getKeyword_ValueSTRINGTerminalRuleCall_0ElementType());
            			
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_value_0_0);
            			

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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // PsiInternalXtextTerminalsTestLanguage.g:894:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:894:18: ( ruleRuleCall EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:895:2: ruleRuleCall EOF
            {
             markComposite(elementTypeProvider.getRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleCall();

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
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // PsiInternalXtextTerminalsTestLanguage.g:900:1: ruleRuleCall : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleRuleCall() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:900:13: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:901:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:901:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:902:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:902:3: (otherlv_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:903:4: otherlv_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getRuleCall_RuleAbstractRuleCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // PsiInternalXtextTerminalsTestLanguage.g:915:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:915:20: ( ruleAssignment EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:916:2: ruleAssignment EOF
            {
             markComposite(elementTypeProvider.getAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignment();

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // PsiInternalXtextTerminalsTestLanguage.g:921:1: ruleAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) ;
    public final void ruleAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:921:15: ( ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:922:2: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:922:2: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:923:3: ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:923:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:924:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:924:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:925:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:934:3: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:935:4: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:935:4: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:936:5: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:936:5: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt29=1;
                }
                break;
            case 30:
                {
                alt29=2;
                }
                break;
            case 34:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:937:6: lv_operator_1_1= '+='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorPlusSignEqualsSignKeyword_1_0_0ElementType());
                    					
                    lv_operator_1_1=(Token)match(input,31,FollowSets000.FOLLOW_27); 

                    						doneLeaf(lv_operator_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:945:6: lv_operator_1_2= '='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorEqualsSignKeyword_1_0_1ElementType());
                    					
                    lv_operator_1_2=(Token)match(input,30,FollowSets000.FOLLOW_27); 

                    						doneLeaf(lv_operator_1_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalXtextTerminalsTestLanguage.g:953:6: lv_operator_1_3= '?='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2ElementType());
                    					
                    lv_operator_1_3=(Token)match(input,34,FollowSets000.FOLLOW_27); 

                    						doneLeaf(lv_operator_1_3);
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:963:3: ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            // PsiInternalXtextTerminalsTestLanguage.g:964:4: (lv_terminal_2_0= ruleAssignableTerminal )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:964:4: (lv_terminal_2_0= ruleAssignableTerminal )
            // PsiInternalXtextTerminalsTestLanguage.g:965:5: lv_terminal_2_0= ruleAssignableTerminal
            {

            					markComposite(elementTypeProvider.getAssignment_TerminalAssignableTerminalParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleAssignableTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:978:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:978:28: ( ruleAssignableTerminal EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:979:2: ruleAssignableTerminal EOF
            {
             markComposite(elementTypeProvider.getAssignableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableTerminal();

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
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:984:1: ruleAssignableTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:984:23: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) )
            // PsiInternalXtextTerminalsTestLanguage.g:985:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:985:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            int alt30=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt30=1;
                }
                break;
            case RULE_ID:
                {
                alt30=2;
                }
                break;
            case 15:
                {
                alt30=3;
                }
                break;
            case 35:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:986:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:994:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1002:3: ruleParenthesizedAssignableElement
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1010:3: ruleCrossReference
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_CrossReferenceParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCrossReference();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1021:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1021:40: ( ruleParenthesizedAssignableElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1022:2: ruleParenthesizedAssignableElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedAssignableElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedAssignableElement();

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
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1027:1: ruleParenthesizedAssignableElement : (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1027:35: ( (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1028:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1028:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            // PsiInternalXtextTerminalsTestLanguage.g:1029:3: otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_28);
            ruleAssignableAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType());
            		
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
        return ;
    }
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // PsiInternalXtextTerminalsTestLanguage.g:1054:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1054:32: ( ruleAssignableAlternatives EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1055:2: ruleAssignableAlternatives EOF
            {
             markComposite(elementTypeProvider.getAssignableAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableAlternatives();

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
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // PsiInternalXtextTerminalsTestLanguage.g:1060:1: ruleAssignableAlternatives : ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1060:27: ( ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1061:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1061:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1062:3: ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            ruleAssignableTerminal();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1069:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1070:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1070:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1071:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAssignableAlternatives_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:1076:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==25) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1077:5: otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_27); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1084:5: ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1085:6: (lv_groups_3_0= ruleAssignableTerminal )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1085:6: (lv_groups_3_0= ruleAssignableTerminal )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1086:7: lv_groups_3_0= ruleAssignableTerminal
                    	    {

                    	    							markComposite(elementTypeProvider.getAssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    ruleAssignableTerminal();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);


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
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // PsiInternalXtextTerminalsTestLanguage.g:1101:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1101:24: ( ruleCrossReference EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1102:2: ruleCrossReference EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReference();

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
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // PsiInternalXtextTerminalsTestLanguage.g:1107:1: ruleCrossReference : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final void ruleCrossReference() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1107:19: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1108:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1108:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // PsiInternalXtextTerminalsTestLanguage.g:1109:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {

            			markLeaf(elementTypeProvider.getCrossReference_LeftSquareBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1116:3: ( (lv_type_1_0= ruleTypeRef ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1117:4: (lv_type_1_0= ruleTypeRef )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1117:4: (lv_type_1_0= ruleTypeRef )
            // PsiInternalXtextTerminalsTestLanguage.g:1118:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_29);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1127:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1128:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {

                    				markLeaf(elementTypeProvider.getCrossReference_VerticalLineKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_30); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:1135:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1136:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1136:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // PsiInternalXtextTerminalsTestLanguage.g:1137:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						markComposite(elementTypeProvider.getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_31);
                    ruleCrossReferenceableTerminal();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getCrossReference_RightSquareBracketKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:1158:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1158:36: ( ruleCrossReferenceableTerminal EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1159:2: ruleCrossReferenceableTerminal EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReferenceableTerminal();

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
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:1164:1: ruleCrossReferenceableTerminal : ( ruleKeyword | ruleRuleCall ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1164:31: ( ( ruleKeyword | ruleRuleCall ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1165:2: ( ruleKeyword | ruleRuleCall )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1165:2: ( ruleKeyword | ruleRuleCall )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_STRING) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1166:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1174:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1185:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1185:30: ( ruleParenthesizedElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1186:2: ruleParenthesizedElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedElement();

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
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1191:1: ruleParenthesizedElement : (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1191:25: ( (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1192:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1192:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            // PsiInternalXtextTerminalsTestLanguage.g:1193:3: otherlv_0= '(' ruleAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedElement_AlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_28);
            ruleAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedElement_RightParenthesisKeyword_2ElementType());
            		
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
        return ;
    }
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRuleTerminalRule"
    // PsiInternalXtextTerminalsTestLanguage.g:1218:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1218:22: ( ruleTerminalRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1219:2: ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRule();

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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // PsiInternalXtextTerminalsTestLanguage.g:1224:1: ruleTerminalRule : (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) ;
    public final void ruleTerminalRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1224:17: ( (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1225:2: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1225:2: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            // PsiInternalXtextTerminalsTestLanguage.g:1226:3: otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';'
            {

            			markLeaf(elementTypeProvider.getTerminalRule_TerminalKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1233:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1234:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1234:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:1235:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1244:3: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==21) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1245:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {

                    				markLeaf(elementTypeProvider.getTerminalRule_ReturnsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:1252:4: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1253:5: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1253:5: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalXtextTerminalsTestLanguage.g:1254:6: lv_type_3_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getTerminalRule_TypeTypeRefParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_15);
                    ruleTypeRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getTerminalRule_ColonKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1271:3: ( (lv_alternatives_5_0= ruleTerminalAlternatives ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1272:4: (lv_alternatives_5_0= ruleTerminalAlternatives )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1272:4: (lv_alternatives_5_0= ruleTerminalAlternatives )
            // PsiInternalXtextTerminalsTestLanguage.g:1273:5: lv_alternatives_5_0= ruleTerminalAlternatives
            {

            					markComposite(elementTypeProvider.getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            ruleTerminalAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getTerminalRule_SemicolonKeyword_5ElementType());
            		
            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // PsiInternalXtextTerminalsTestLanguage.g:1293:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1293:30: ( ruleTerminalAlternatives EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1294:2: ruleTerminalAlternatives EOF
            {
             markComposite(elementTypeProvider.getTerminalAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalAlternatives();

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
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // PsiInternalXtextTerminalsTestLanguage.g:1299:1: ruleTerminalAlternatives : ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1299:25: ( ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1300:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1300:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1301:3: ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            ruleTerminalGroup();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1308:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1309:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1309:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1310:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalAlternatives_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:1315:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==25) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1316:5: otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_33); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1323:5: ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1324:6: (lv_groups_3_0= ruleTerminalGroup )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1324:6: (lv_groups_3_0= ruleTerminalGroup )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1325:7: lv_groups_3_0= ruleTerminalGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getTerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    ruleTerminalGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);


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
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // PsiInternalXtextTerminalsTestLanguage.g:1340:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1340:23: ( ruleTerminalGroup EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1341:2: ruleTerminalGroup EOF
            {
             markComposite(elementTypeProvider.getTerminalGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalGroup();

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
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // PsiInternalXtextTerminalsTestLanguage.g:1346:1: ruleTerminalGroup : ( ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) ;
    public final void ruleTerminalGroup() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1346:18: ( ( ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1347:2: ( ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1347:2: ( ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1348:3: ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalGroup_TerminalTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_34);
            ruleTerminalToken();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1355:3: ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)||LA39_0==15||LA39_0==17||(LA39_0>=38 && LA39_0<=39)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1356:4: () ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1356:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1357:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalGroup_GroupTokensAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:1362:4: ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)||LA38_0==15||LA38_0==17||(LA38_0>=38 && LA38_0<=39)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1363:5: (lv_tokens_2_0= ruleTerminalToken )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1363:5: (lv_tokens_2_0= ruleTerminalToken )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1364:6: lv_tokens_2_0= ruleTerminalToken
                    	    {

                    	    						markComposite(elementTypeProvider.getTerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_34);
                    	    ruleTerminalToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


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
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1378:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1378:23: ( ruleTerminalToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1379:2: ruleTerminalToken EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalToken();

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
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1384:1: ruleTerminalToken : ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final void ruleTerminalToken() throws RecognitionException {
        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1384:18: ( ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1385:2: ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1385:2: ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1386:3: ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {

            			markComposite(elementTypeProvider.getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_21);
            ruleTerminalTokenElement();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1393:3: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=26 && LA41_0<=28)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1394:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1394:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1395:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1395:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    int alt40=3;
                    switch ( input.LA(1) ) {
                    case 26:
                        {
                        alt40=1;
                        }
                        break;
                    case 27:
                        {
                        alt40=2;
                        }
                        break;
                    case 28:
                        {
                        alt40=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }

                    switch (alt40) {
                        case 1 :
                            // PsiInternalXtextTerminalsTestLanguage.g:1396:6: lv_cardinality_1_1= '?'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					
                            lv_cardinality_1_1=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_1_1);
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalXtextTerminalsTestLanguage.g:1404:6: lv_cardinality_1_2= '*'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					
                            lv_cardinality_1_2=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_1_2);
                            					

                            }
                            break;
                        case 3 :
                            // PsiInternalXtextTerminalsTestLanguage.g:1412:6: lv_cardinality_1_3= '+'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					
                            lv_cardinality_1_3=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_1_3);
                            					

                            }
                            break;

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
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1426:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1426:30: ( ruleTerminalTokenElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1427:2: ruleTerminalTokenElement EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalTokenElement();

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
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1432:1: ruleTerminalTokenElement : ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1432:25: ( ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1433:2: ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1433:2: ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard )
            int alt42=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt42=1;
                }
                break;
            case RULE_ID:
                {
                alt42=2;
                }
                break;
            case 15:
                {
                alt42=3;
                }
                break;
            case 38:
            case 39:
                {
                alt42=4;
                }
                break;
            case 17:
                {
                alt42=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1434:3: ruleCharacterRange
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCharacterRange();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1442:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1450:3: ruleParenthesizedTerminalElement
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1458:3: ruleAbstractNegatedToken
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1466:3: ruleWildcard
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_WildcardParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWildcard();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1477:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1477:38: ( ruleParenthesizedTerminalElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1478:2: ruleParenthesizedTerminalElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedTerminalElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedTerminalElement();

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
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1483:1: ruleParenthesizedTerminalElement : (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1483:33: ( (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1484:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1484:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            // PsiInternalXtextTerminalsTestLanguage.g:1485:3: otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_28);
            ruleTerminalAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType());
            		
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
        return ;
    }
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1510:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1510:30: ( ruleAbstractNegatedToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1511:2: ruleAbstractNegatedToken EOF
            {
             markComposite(elementTypeProvider.getAbstractNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractNegatedToken();

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
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1516:1: ruleAbstractNegatedToken : ( ruleNegatedToken | ruleUntilToken ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1516:25: ( ( ruleNegatedToken | ruleUntilToken ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1517:2: ( ruleNegatedToken | ruleUntilToken )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1517:2: ( ruleNegatedToken | ruleUntilToken )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==38) ) {
                alt43=1;
            }
            else if ( (LA43_0==39) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1518:3: ruleNegatedToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1526:3: ruleUntilToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUntilToken();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1537:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1537:22: ( ruleNegatedToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1538:2: ruleNegatedToken EOF
            {
             markComposite(elementTypeProvider.getNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNegatedToken();

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
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1543:1: ruleNegatedToken : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1543:17: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1544:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1544:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1545:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getNegatedToken_ExclamationMarkKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1552:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1553:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1553:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // PsiInternalXtextTerminalsTestLanguage.g:1554:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

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
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1567:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1567:20: ( ruleUntilToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1568:2: ruleUntilToken EOF
            {
             markComposite(elementTypeProvider.getUntilTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUntilToken();

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
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1573:1: ruleUntilToken : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleUntilToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1573:15: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1574:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1574:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1575:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1582:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1583:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1583:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // PsiInternalXtextTerminalsTestLanguage.g:1584:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

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
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // PsiInternalXtextTerminalsTestLanguage.g:1597:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1597:18: ( ruleWildcard EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1598:2: ruleWildcard EOF
            {
             markComposite(elementTypeProvider.getWildcardElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWildcard();

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
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // PsiInternalXtextTerminalsTestLanguage.g:1603:1: ruleWildcard : ( () otherlv_1= '.' ) ;
    public final void ruleWildcard() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1603:13: ( ( () otherlv_1= '.' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1604:2: ( () otherlv_1= '.' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1604:2: ( () otherlv_1= '.' )
            // PsiInternalXtextTerminalsTestLanguage.g:1605:3: () otherlv_1= '.'
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1605:3: ()
            // PsiInternalXtextTerminalsTestLanguage.g:1606:4: 
            {

            				precedeComposite(elementTypeProvider.getWildcard_WildcardAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getWildcard_FullStopKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleCharacterRange"
    // PsiInternalXtextTerminalsTestLanguage.g:1622:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1622:24: ( ruleCharacterRange EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1623:2: ruleCharacterRange EOF
            {
             markComposite(elementTypeProvider.getCharacterRangeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCharacterRange();

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
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // PsiInternalXtextTerminalsTestLanguage.g:1628:1: ruleCharacterRange : ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final void ruleCharacterRange() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1628:19: ( ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1629:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1629:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1630:3: ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			markComposite(elementTypeProvider.getCharacterRange_KeywordParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_35);
            ruleKeyword();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1637:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==40) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1638:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1638:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1639:5: 
                    {

                    					precedeComposite(elementTypeProvider.getCharacterRange_CharacterRangeLeftAction_1_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getCharacterRange_FullStopFullStopKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:1651:4: ( (lv_right_3_0= ruleKeyword ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1652:5: (lv_right_3_0= ruleKeyword )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1652:5: (lv_right_3_0= ruleKeyword )
                    // PsiInternalXtextTerminalsTestLanguage.g:1653:6: lv_right_3_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

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
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // PsiInternalXtextTerminalsTestLanguage.g:1667:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1667:18: ( ruleEnumRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1668:2: ruleEnumRule EOF
            {
             markComposite(elementTypeProvider.getEnumRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumRule();

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
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // PsiInternalXtextTerminalsTestLanguage.g:1673:1: ruleEnumRule : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) ;
    public final void ruleEnumRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1673:13: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1674:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1674:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            // PsiInternalXtextTerminalsTestLanguage.g:1675:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';'
            {

            			markLeaf(elementTypeProvider.getEnumRule_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1682:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1683:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1683:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:1684:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumRule_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1693:3: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==21) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1694:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumRule_ReturnsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:1701:4: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1702:5: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1702:5: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalXtextTerminalsTestLanguage.g:1703:6: lv_type_3_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_15);
                    ruleTypeRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getEnumRule_ColonKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1720:3: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1721:4: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1721:4: (lv_alternatives_5_0= ruleEnumLiterals )
            // PsiInternalXtextTerminalsTestLanguage.g:1722:5: lv_alternatives_5_0= ruleEnumLiterals
            {

            					markComposite(elementTypeProvider.getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            ruleEnumLiterals();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getEnumRule_SemicolonKeyword_5ElementType());
            		
            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // PsiInternalXtextTerminalsTestLanguage.g:1742:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1742:22: ( ruleEnumLiterals EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1743:2: ruleEnumLiterals EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiterals();

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
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // PsiInternalXtextTerminalsTestLanguage.g:1748:1: ruleEnumLiterals : ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final void ruleEnumLiterals() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1748:17: ( ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1749:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1749:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1750:3: ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            ruleEnumLiteralDeclaration();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1757:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==25) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1758:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1758:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1759:5: 
                    {

                    					precedeComposite(elementTypeProvider.getEnumLiterals_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:1764:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==25) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1765:5: otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getEnumLiterals_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1772:5: ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1773:6: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1773:6: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1774:7: lv_groups_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							markComposite(elementTypeProvider.getEnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);


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
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // PsiInternalXtextTerminalsTestLanguage.g:1789:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1789:32: ( ruleEnumLiteralDeclaration EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1790:2: ruleEnumLiteralDeclaration EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiteralDeclaration();

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
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // PsiInternalXtextTerminalsTestLanguage.g:1795:1: ruleEnumLiteralDeclaration : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1795:27: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1796:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1796:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1797:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1797:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1798:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1798:4: (otherlv_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:1799:5: otherlv_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_36); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1808:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1809:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:1816:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1817:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1817:5: (lv_literal_2_0= ruleKeyword )
                    // PsiInternalXtextTerminalsTestLanguage.g:1818:6: lv_literal_2_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

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
    // $ANTLR end "ruleEnumLiteralDeclaration"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000022000145010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000022000147010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000022000145012L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000604000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000404000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020008030L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020008032L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000200020000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000004C0000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000C000028032L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000040000002L});
    }


}