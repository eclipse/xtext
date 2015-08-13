package org.eclipse.xtext.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.lang.XtextElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.services.XtextGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalXtextParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'fragment'", "'*'", "'returns'", "':'", "';'", "'<'", "'>'", "'::'", "'|'", "'&'", "'?'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'true'", "'false'", "'!'", "'=>'", "'->'", "'?='", "'['", "']'", "'terminal'", "'EOF'", "'..'", "'enum'"
    };
    public static final int RULE_ID=5;
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
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=4;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalXtextParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g"; }



    	protected XtextGrammarAccess grammarAccess;

    	protected XtextElementTypeProvider elementTypeProvider;

    	public PsiInternalXtextParser(PsiBuilder builder, TokenStream input, XtextElementTypeProvider elementTypeProvider, XtextGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:52:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:52:17: ( ruleGrammar EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:53:2: ruleGrammar EOF
            {
             markComposite(elementTypeProvider.getGrammarElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_entryRuleGrammar54);
            ruleGrammar();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammar57); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:58:1: ruleGrammar : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
    public final void ruleGrammar() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_definesHiddenTokens_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:58:12: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:59:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:59:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:60:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {

            			markLeaf(elementTypeProvider.getGrammar_GrammarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleGrammar76); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:67:3: ( (lv_name_1_0= ruleGrammarID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:68:4: (lv_name_1_0= ruleGrammarID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:68:4: (lv_name_1_0= ruleGrammarID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:69:5: lv_name_1_0= ruleGrammarID
            {

            					markComposite(elementTypeProvider.getGrammar_NameGrammarIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar103);
            ruleGrammarID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:78:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:79:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {

                    				markLeaf(elementTypeProvider.getGrammar_WithKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGrammar134); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:86:4: ( ( ruleGrammarID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:87:5: ( ruleGrammarID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:87:5: ( ruleGrammarID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:88:6: ruleGrammarID
                    {

                    						markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar164);
                    ruleGrammarID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:97:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:98:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getGrammar_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar201); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:105:5: ( ( ruleGrammarID ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:106:6: ( ruleGrammarID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:106:6: ( ruleGrammarID )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:107:7: ruleGrammarID
                    	    {

                    	    							markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar236);
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

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:118:3: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:119:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')'
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:119:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:120:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:120:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:121:6: lv_definesHiddenTokens_6_0= 'hidden'
                    {

                    						markLeaf(elementTypeProvider.getGrammar_DefinesHiddenTokensHiddenKeyword_3_0_0ElementType());
                    					
                    lv_definesHiddenTokens_6_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleGrammar299); 

                    						doneLeaf(lv_definesHiddenTokens_6_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getGrammar_LeftParenthesisKeyword_3_1ElementType());
                    			
                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleGrammar329); 

                    				doneLeaf(otherlv_7);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:137:4: ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||(LA4_0>=38 && LA4_0<=39)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:138:5: ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:138:5: ( ( ruleRuleID ) )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:139:6: ( ruleRuleID )
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:139:6: ( ruleRuleID )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:140:7: ruleRuleID
                            {

                            							markComposite(elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleGrammar368);
                            ruleRuleID();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:149:5: (otherlv_9= ',' ( ( ruleRuleID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:150:6: otherlv_9= ',' ( ( ruleRuleID ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getGrammar_CommaKeyword_3_2_1_0ElementType());
                            	    					
                            	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar411); 

                            	    						doneLeaf(otherlv_9);
                            	    					
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:157:6: ( ( ruleRuleID ) )
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:158:7: ( ruleRuleID )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:158:7: ( ruleRuleID )
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:159:8: ruleRuleID
                            	    {

                            	    								markComposite(elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0ElementType());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleGrammar451);
                            	    ruleRuleID();

                            	    state._fsp--;


                            	    								doneComposite();
                            	    							

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
                    			
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGrammar500); 

                    				doneLeaf(otherlv_11);
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:178:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:179:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:179:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:180:5: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar533);
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

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:189:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==21||(LA7_0>=38 && LA7_0<=39)||LA7_0==46||LA7_0==49) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:190:4: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:190:4: (lv_rules_13_0= ruleAbstractRule )
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:191:5: lv_rules_13_0= ruleAbstractRule
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleGrammar572);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:204:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:204:19: ( ruleGrammarID EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:205:2: ruleGrammarID EOF
            {
             markComposite(elementTypeProvider.getGrammarIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID604);
            ruleGrammarID();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammarID607); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:210:1: ruleGrammarID : ( ruleValidID (kw= '.' ruleValidID )* ) ;
    public final void ruleGrammarID() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:210:14: ( ( ruleValidID (kw= '.' ruleValidID )* ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:211:2: ( ruleValidID (kw= '.' ruleValidID )* )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:211:2: ( ruleValidID (kw= '.' ruleValidID )* )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:212:3: ruleValidID (kw= '.' ruleValidID )*
            {

            			markComposite(elementTypeProvider.getGrammarID_ValidIDParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleGrammarID624);
            ruleValidID();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:219:3: (kw= '.' ruleValidID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:220:4: kw= '.' ruleValidID
            	    {

            	    				markLeaf(elementTypeProvider.getGrammarID_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGrammarID644); 

            	    				doneLeaf(kw);
            	    			

            	    				markComposite(elementTypeProvider.getGrammarID_ValidIDParserRuleCall_1_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleGrammarID659);
            	    ruleValidID();

            	    state._fsp--;


            	    				doneComposite();
            	    			

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:239:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:239:22: ( ruleAbstractRule EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:240:2: ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule685);
            ruleAbstractRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule688); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:245:1: ruleAbstractRule : ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) ;
    public final void ruleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:245:17: ( ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:246:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:246:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 21:
            case 38:
            case 39:
                {
                alt9=1;
                }
                break;
            case 46:
                {
                alt9=2;
                }
                break;
            case 49:
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
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:247:3: ruleParserRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_ruleAbstractRule705);
                    ruleParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:255:3: ruleTerminalRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_TerminalRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleAbstractRule725);
                    ruleTerminalRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:263:3: ruleEnumRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_EnumRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_ruleAbstractRule745);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:274:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:274:38: ( ruleAbstractMetamodelDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:275:2: ruleAbstractMetamodelDeclaration EOF
            {
             markComposite(elementTypeProvider.getAbstractMetamodelDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration765);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration768); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:280:1: ruleAbstractMetamodelDeclaration : ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:280:33: ( ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:281:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:281:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
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
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:282:3: ruleGeneratedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration785);
                    ruleGeneratedMetamodel();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:290:3: ruleReferencedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration805);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:301:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:301:28: ( ruleGeneratedMetamodel EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:302:2: ruleGeneratedMetamodel EOF
            {
             markComposite(elementTypeProvider.getGeneratedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel825);
            ruleGeneratedMetamodel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGeneratedMetamodel828); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:307:1: ruleGeneratedMetamodel : (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:307:23: ( (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:308:2: (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:308:2: (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:309:3: otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )?
            {

            			markLeaf(elementTypeProvider.getGeneratedMetamodel_GenerateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGeneratedMetamodel847); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:316:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:317:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:317:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:318:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getGeneratedMetamodel_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleGeneratedMetamodel874);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:327:3: ( (otherlv_2= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:328:4: (otherlv_2= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:328:4: (otherlv_2= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:329:5: otherlv_2= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel912); 

            					doneLeaf(otherlv_2);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:338:3: (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:339:4: otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) )
                    {

                    				markLeaf(elementTypeProvider.getGeneratedMetamodel_AsKeyword_3_0ElementType());
                    			
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGeneratedMetamodel943); 

                    				doneLeaf(otherlv_3);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:346:4: ( (lv_alias_4_0= ruleValidID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:347:5: (lv_alias_4_0= ruleValidID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:347:5: (lv_alias_4_0= ruleValidID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:348:6: lv_alias_4_0= ruleValidID
                    {

                    						markComposite(elementTypeProvider.getGeneratedMetamodel_AliasValidIDParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleGeneratedMetamodel975);
                    ruleValidID();

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
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:362:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:362:29: ( ruleReferencedMetamodel EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:363:2: ruleReferencedMetamodel EOF
            {
             markComposite(elementTypeProvider.getReferencedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1014);
            ruleReferencedMetamodel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel1017); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:368:1: ruleReferencedMetamodel : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:368:24: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:369:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:369:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:370:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )?
            {

            			markLeaf(elementTypeProvider.getReferencedMetamodel_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferencedMetamodel1036); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:377:3: ( (otherlv_1= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:378:4: (otherlv_1= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:378:4: (otherlv_1= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:379:5: otherlv_1= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1063); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:388:3: (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:389:4: otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) )
                    {

                    				markLeaf(elementTypeProvider.getReferencedMetamodel_AsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferencedMetamodel1094); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:396:4: ( (lv_alias_3_0= ruleValidID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:397:5: (lv_alias_3_0= ruleValidID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:397:5: (lv_alias_3_0= ruleValidID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:398:6: lv_alias_3_0= ruleValidID
                    {

                    						markComposite(elementTypeProvider.getReferencedMetamodel_AliasValidIDParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleReferencedMetamodel1126);
                    ruleValidID();

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
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:412:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:412:20: ( ruleParserRule EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:413:2: ruleParserRule EOF
            {
             markComposite(elementTypeProvider.getParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule1165);
            ruleParserRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRule1168); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:418:1: ruleParserRule : ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) ) | ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_8_0= 'hidden' ) ) otherlv_9= '(' ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )? otherlv_13= ')' )? otherlv_14= ':' ( (lv_alternatives_15_0= ruleAlternatives ) ) otherlv_16= ';' ) ;
    public final void ruleParserRule() throws RecognitionException {
        Token lv_fragment_0_0=null;
        Token lv_wildcard_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token lv_definesHiddenTokens_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:418:15: ( ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) ) | ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_8_0= 'hidden' ) ) otherlv_9= '(' ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )? otherlv_13= ')' )? otherlv_14= ':' ( (lv_alternatives_15_0= ruleAlternatives ) ) otherlv_16= ';' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:419:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) ) | ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_8_0= 'hidden' ) ) otherlv_9= '(' ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )? otherlv_13= ')' )? otherlv_14= ':' ( (lv_alternatives_15_0= ruleAlternatives ) ) otherlv_16= ';' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:419:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) ) | ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_8_0= 'hidden' ) ) otherlv_9= '(' ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )? otherlv_13= ')' )? otherlv_14= ':' ( (lv_alternatives_15_0= ruleAlternatives ) ) otherlv_16= ';' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:420:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) ) | ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_8_0= 'hidden' ) ) otherlv_9= '(' ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )? otherlv_13= ')' )? otherlv_14= ':' ( (lv_alternatives_15_0= ruleAlternatives ) ) otherlv_16= ';'
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:420:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) ) | ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_ID||(LA16_0>=38 && LA16_0<=39)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:421:4: ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:421:4: ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:422:5: ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:422:5: ( (lv_fragment_0_0= 'fragment' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:423:6: (lv_fragment_0_0= 'fragment' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:423:6: (lv_fragment_0_0= 'fragment' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:424:7: lv_fragment_0_0= 'fragment'
                    {

                    							markLeaf(elementTypeProvider.getParserRule_FragmentFragmentKeyword_0_0_0_0ElementType());
                    						
                    lv_fragment_0_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRule1217); 

                    							doneLeaf(lv_fragment_0_0);
                    						

                    }


                    }


                    					markComposite(elementTypeProvider.getParserRule_RuleNameAndParamsParserRuleCall_0_0_1ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1250);
                    ruleRuleNameAndParams();

                    state._fsp--;


                    					doneComposite();
                    				
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:440:5: ( ( (lv_wildcard_2_0= '*' ) ) | (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==22) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==14||(LA14_0>=23 && LA14_0<=24)) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:441:6: ( (lv_wildcard_2_0= '*' ) )
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:441:6: ( (lv_wildcard_2_0= '*' ) )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:442:7: (lv_wildcard_2_0= '*' )
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:442:7: (lv_wildcard_2_0= '*' )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:443:8: lv_wildcard_2_0= '*'
                            {

                            								markLeaf(elementTypeProvider.getParserRule_WildcardAsteriskKeyword_0_0_2_0_0ElementType());
                            							
                            lv_wildcard_2_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRule1297); 

                            								doneLeaf(lv_wildcard_2_0);
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:453:6: (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )?
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:453:6: (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==23) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:454:7: otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) )
                                    {

                                    							markLeaf(elementTypeProvider.getParserRule_ReturnsKeyword_0_0_2_1_0ElementType());
                                    						
                                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRule1357); 

                                    							doneLeaf(otherlv_3);
                                    						
                                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:461:7: ( (lv_type_4_0= ruleTypeRef ) )
                                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:462:8: (lv_type_4_0= ruleTypeRef )
                                    {
                                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:462:8: (lv_type_4_0= ruleTypeRef )
                                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:463:9: lv_type_4_0= ruleTypeRef
                                    {

                                    									markComposite(elementTypeProvider.getParserRule_TypeTypeRefParserRuleCall_0_0_2_1_1_0ElementType());
                                    								
                                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleParserRule1404);
                                    ruleTypeRef();

                                    state._fsp--;


                                    									doneComposite();
                                    								

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:476:4: ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:476:4: ( ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )? )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:477:5: ruleRuleNameAndParams (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )?
                    {

                    					markComposite(elementTypeProvider.getParserRule_RuleNameAndParamsParserRuleCall_0_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1476);
                    ruleRuleNameAndParams();

                    state._fsp--;


                    					doneComposite();
                    				
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:484:5: (otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==23) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:485:6: otherlv_6= 'returns' ( (lv_type_7_0= ruleTypeRef ) )
                            {

                            						markLeaf(elementTypeProvider.getParserRule_ReturnsKeyword_0_1_1_0ElementType());
                            					
                            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRule1504); 

                            						doneLeaf(otherlv_6);
                            					
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:492:6: ( (lv_type_7_0= ruleTypeRef ) )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:493:7: (lv_type_7_0= ruleTypeRef )
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:493:7: (lv_type_7_0= ruleTypeRef )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:494:8: lv_type_7_0= ruleTypeRef
                            {

                            								markComposite(elementTypeProvider.getParserRule_TypeTypeRefParserRuleCall_0_1_1_1_0ElementType());
                            							
                            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleParserRule1546);
                            ruleTypeRef();

                            state._fsp--;


                            								doneComposite();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:506:3: ( ( (lv_definesHiddenTokens_8_0= 'hidden' ) ) otherlv_9= '(' ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )? otherlv_13= ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:507:4: ( (lv_definesHiddenTokens_8_0= 'hidden' ) ) otherlv_9= '(' ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )? otherlv_13= ')'
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:507:4: ( (lv_definesHiddenTokens_8_0= 'hidden' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:508:5: (lv_definesHiddenTokens_8_0= 'hidden' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:508:5: (lv_definesHiddenTokens_8_0= 'hidden' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:509:6: lv_definesHiddenTokens_8_0= 'hidden'
                    {

                    						markLeaf(elementTypeProvider.getParserRule_DefinesHiddenTokensHiddenKeyword_1_0_0ElementType());
                    					
                    lv_definesHiddenTokens_8_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRule1617); 

                    						doneLeaf(lv_definesHiddenTokens_8_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getParserRule_LeftParenthesisKeyword_1_1ElementType());
                    			
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRule1647); 

                    				doneLeaf(otherlv_9);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:525:4: ( ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )* )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID||(LA18_0>=38 && LA18_0<=39)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:526:5: ( ( ruleRuleID ) ) (otherlv_11= ',' ( ( ruleRuleID ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:526:5: ( ( ruleRuleID ) )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:527:6: ( ruleRuleID )
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:527:6: ( ruleRuleID )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:528:7: ruleRuleID
                            {

                            							markComposite(elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_1_2_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleParserRule1686);
                            ruleRuleID();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:537:5: (otherlv_11= ',' ( ( ruleRuleID ) ) )*
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==13) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:538:6: otherlv_11= ',' ( ( ruleRuleID ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getParserRule_CommaKeyword_1_2_1_0ElementType());
                            	    					
                            	    otherlv_11=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRule1729); 

                            	    						doneLeaf(otherlv_11);
                            	    					
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:545:6: ( ( ruleRuleID ) )
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:546:7: ( ruleRuleID )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:546:7: ( ruleRuleID )
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:547:8: ruleRuleID
                            	    {

                            	    								markComposite(elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_1_2_1_1_0ElementType());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleParserRule1769);
                            	    ruleRuleID();

                            	    state._fsp--;


                            	    								doneComposite();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop17;
                                }
                            } while (true);


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getParserRule_RightParenthesisKeyword_1_3ElementType());
                    			
                    otherlv_13=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRule1818); 

                    				doneLeaf(otherlv_13);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getParserRule_ColonKeyword_2ElementType());
            		
            otherlv_14=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleParserRule1838); 

            			doneLeaf(otherlv_14);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:573:3: ( (lv_alternatives_15_0= ruleAlternatives ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:574:4: (lv_alternatives_15_0= ruleAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:574:4: (lv_alternatives_15_0= ruleAlternatives )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:575:5: lv_alternatives_15_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getParserRule_AlternativesAlternativesParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParserRule1865);
            ruleAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getParserRule_SemicolonKeyword_4ElementType());
            		
            otherlv_16=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleParserRule1890); 

            			doneLeaf(otherlv_16);
            		

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


    // $ANTLR start "ruleRuleNameAndParams"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:596:1: ruleRuleNameAndParams : ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? ) ;
    public final void ruleRuleNameAndParams() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:596:22: ( ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:597:2: ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:597:2: ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:598:3: ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )?
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:598:3: ( (lv_name_0_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:599:4: (lv_name_0_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:599:4: (lv_name_0_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:600:5: lv_name_0_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getRuleNameAndParams_NameValidIDParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleRuleNameAndParams1931);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:609:3: (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:610:4: otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>'
                    {

                    				markLeaf(elementTypeProvider.getRuleNameAndParams_LessThanSignKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRuleNameAndParams1962); 

                    				doneLeaf(otherlv_1);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:617:4: ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_ID) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:618:5: ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:618:5: ( (lv_parameters_2_0= ruleParameter ) )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:619:6: (lv_parameters_2_0= ruleParameter )
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:619:6: (lv_parameters_2_0= ruleParameter )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:620:7: lv_parameters_2_0= ruleParameter
                            {

                            							markComposite(elementTypeProvider.getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleRuleNameAndParams2003);
                            ruleParameter();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:629:5: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==13) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:630:6: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getRuleNameAndParams_CommaKeyword_1_1_1_0ElementType());
                            	    					
                            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRuleNameAndParams2046); 

                            	    						doneLeaf(otherlv_3);
                            	    					
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:637:6: ( (lv_parameters_4_0= ruleParameter ) )
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:638:7: (lv_parameters_4_0= ruleParameter )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:638:7: (lv_parameters_4_0= ruleParameter )
                            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:639:8: lv_parameters_4_0= ruleParameter
                            	    {

                            	    								markComposite(elementTypeProvider.getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0ElementType());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleRuleNameAndParams2088);
                            	    ruleParameter();

                            	    state._fsp--;


                            	    								doneComposite();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop20;
                                }
                            } while (true);


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getRuleNameAndParams_GreaterThanSignKeyword_1_2ElementType());
                    			
                    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRuleNameAndParams2137); 

                    				doneLeaf(otherlv_5);
                    			

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
    // $ANTLR end "ruleRuleNameAndParams"


    // $ANTLR start "entryRuleParameter"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:662:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:662:19: ( ruleParameter EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:663:2: ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter2163);
            ruleParameter();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter2166); 

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:668:1: ruleParameter : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleParameter() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:668:14: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:669:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:669:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:670:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:670:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:671:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getParameter_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter2191); 

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
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeRef"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:683:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:683:17: ( ruleTypeRef EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:684:2: ruleTypeRef EOF
            {
             markComposite(elementTypeProvider.getTypeRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef2216);
            ruleTypeRef();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef2219); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:689:1: ruleTypeRef : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final void ruleTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:689:12: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:690:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:690:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:691:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:691:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==28) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:692:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:692:4: ( (otherlv_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:693:5: (otherlv_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:693:5: (otherlv_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:694:6: otherlv_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType());
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef2259); 

                    						doneLeaf(otherlv_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getTypeRef_ColonColonKeyword_0_1ElementType());
                    			
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTypeRef2289); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:711:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:712:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:712:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:713:5: otherlv_2= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTypeRef_ClassifierEClassifierCrossReference_1_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef2322); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:726:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:726:22: ( ruleAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:727:2: ruleAlternatives EOF
            {
             markComposite(elementTypeProvider.getAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives2353);
            ruleAlternatives();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternatives2356); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:732:1: ruleAlternatives : ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) ;
    public final void ruleAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:732:17: ( ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:733:2: ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:733:2: ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:734:3: ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAlternatives_ConditionalBranchParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleConditionalBranch_in_ruleAlternatives2373);
            ruleConditionalBranch();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:741:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==29) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:742:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:742:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:743:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:748:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==29) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:749:5: otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAlternatives2416); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:756:5: ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:757:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:757:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:758:7: lv_elements_3_0= ruleConditionalBranch
                    	    {

                    	    							markComposite(elementTypeProvider.getAlternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleConditionalBranch_in_ruleAlternatives2453);
                    	    ruleConditionalBranch();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
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


    // $ANTLR start "entryRuleConditionalBranch"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:773:1: entryRuleConditionalBranch : ruleConditionalBranch EOF ;
    public final void entryRuleConditionalBranch() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:773:27: ( ruleConditionalBranch EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:774:2: ruleConditionalBranch EOF
            {
             markComposite(elementTypeProvider.getConditionalBranchElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConditionalBranch_in_entryRuleConditionalBranch2501);
            ruleConditionalBranch();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConditionalBranch2504); 

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
    // $ANTLR end "entryRuleConditionalBranch"


    // $ANTLR start "ruleConditionalBranch"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:779:1: ruleConditionalBranch : ( ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) ) ;
    public final void ruleConditionalBranch() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:779:22: ( ( ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:780:2: ( ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:780:2: ( ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_ID)||LA27_0==15||LA27_0==33||(LA27_0>=38 && LA27_0<=39)||(LA27_0>=41 && LA27_0<=42)) ) {
                alt27=1;
            }
            else if ( (LA27_0==26) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:781:3: ruleUnorderedGroup
                    {

                    			markComposite(elementTypeProvider.getConditionalBranch_UnorderedGroupParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleConditionalBranch2521);
                    ruleUnorderedGroup();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:789:3: ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:789:3: ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:790:4: () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:790:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:791:5: 
                    {

                    					precedeComposite(elementTypeProvider.getConditionalBranch_GroupAction_1_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getConditionalBranch_LessThanSignKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleConditionalBranch2565); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:803:4: ( (lv_guardCondition_3_0= ruleDisjunction ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:804:5: (lv_guardCondition_3_0= ruleDisjunction )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:804:5: (lv_guardCondition_3_0= ruleDisjunction )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:805:6: lv_guardCondition_3_0= ruleDisjunction
                    {

                    						markComposite(elementTypeProvider.getConditionalBranch_GuardConditionDisjunctionParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDisjunction_in_ruleConditionalBranch2597);
                    ruleDisjunction();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getConditionalBranch_GreaterThanSignKeyword_1_3ElementType());
                    			
                    otherlv_4=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleConditionalBranch2627); 

                    				doneLeaf(otherlv_4);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:821:4: ( (lv_elements_5_0= ruleAbstractToken ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_ID)||LA26_0==15||LA26_0==33||(LA26_0>=38 && LA26_0<=39)||(LA26_0>=41 && LA26_0<=42)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:822:5: (lv_elements_5_0= ruleAbstractToken )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:822:5: (lv_elements_5_0= ruleAbstractToken )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:823:6: lv_elements_5_0= ruleAbstractToken
                    	    {

                    	    						markComposite(elementTypeProvider.getConditionalBranch_ElementsAbstractTokenParserRuleCall_1_4_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleConditionalBranch2659);
                    	    ruleAbstractToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
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
        return ;
    }
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:837:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:837:24: ( ruleUnorderedGroup EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:838:2: ruleUnorderedGroup EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup2698);
            ruleUnorderedGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroup2701); 

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
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:843:1: ruleUnorderedGroup : ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:843:19: ( ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:844:2: ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:844:2: ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:845:3: ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getUnorderedGroup_GroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup2718);
            ruleGroup();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:852:3: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:853:4: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:853:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:854:5: 
                    {

                    					precedeComposite(elementTypeProvider.getUnorderedGroup_UnorderedGroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:859:4: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==30) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:860:5: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getUnorderedGroup_AmpersandKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleUnorderedGroup2761); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:867:5: ( (lv_elements_3_0= ruleGroup ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:868:6: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:868:6: (lv_elements_3_0= ruleGroup )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:869:7: lv_elements_3_0= ruleGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getUnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup2798);
                    	    ruleGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
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
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:884:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:884:15: ( ruleGroup EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:885:2: ruleGroup EOF
            {
             markComposite(elementTypeProvider.getGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup2846);
            ruleGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup2849); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:890:1: ruleGroup : ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final void ruleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:890:10: ( ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:891:2: ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:891:2: ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:892:3: ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getGroup_AbstractTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup2866);
            ruleAbstractToken();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:899:3: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_ID)||LA31_0==15||LA31_0==33||(LA31_0>=38 && LA31_0<=39)||(LA31_0>=41 && LA31_0<=42)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:900:4: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:900:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:901:5: 
                    {

                    					precedeComposite(elementTypeProvider.getGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:906:4: ( (lv_elements_2_0= ruleAbstractToken ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_ID)||LA30_0==15||LA30_0==33||(LA30_0>=38 && LA30_0<=39)||(LA30_0>=41 && LA30_0<=42)) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:907:5: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:907:5: (lv_elements_2_0= ruleAbstractToken )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:908:6: lv_elements_2_0= ruleAbstractToken
                    	    {

                    	    						markComposite(elementTypeProvider.getGroup_ElementsAbstractTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup2917);
                    	    ruleAbstractToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:922:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:922:23: ( ruleAbstractToken EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:923:2: ruleAbstractToken EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2957);
            ruleAbstractToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken2960); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:928:1: ruleAbstractToken : ( ruleAbstractTokenWithCardinality | ruleAction ) ;
    public final void ruleAbstractToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:928:18: ( ( ruleAbstractTokenWithCardinality | ruleAction ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:929:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:929:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)||LA32_0==15||(LA32_0>=38 && LA32_0<=39)||(LA32_0>=41 && LA32_0<=42)) ) {
                alt32=1;
            }
            else if ( (LA32_0==33) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:930:3: ruleAbstractTokenWithCardinality
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2977);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:938:3: ruleAction
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_ActionParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleAbstractToken2997);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:949:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:949:38: ( ruleAbstractTokenWithCardinality EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:950:2: ruleAbstractTokenWithCardinality EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenWithCardinalityElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality3017);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality3020); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:955:1: ruleAbstractTokenWithCardinality : ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {
        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:955:33: ( ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:956:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:956:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:957:3: ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:957:3: ( ruleAssignment | ruleAbstractTerminal )
            int alt33=2;
            switch ( input.LA(1) ) {
            case 41:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA33_7 = input.LA(3);

                    if ( ((LA33_7>=34 && LA33_7<=35)||LA33_7==43) ) {
                        alt33=1;
                    }
                    else if ( (LA33_7==EOF||(LA33_7>=RULE_STRING && LA33_7<=RULE_ID)||(LA33_7>=15 && LA33_7<=16)||LA33_7==22||(LA33_7>=25 && LA33_7<=26)||(LA33_7>=29 && LA33_7<=33)||(LA33_7>=38 && LA33_7<=39)||(LA33_7>=41 && LA33_7<=42)) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case 38:
                case 39:
                    {
                    alt33=1;
                    }
                    break;
                case RULE_STRING:
                case 15:
                    {
                    alt33=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }

                }
                break;
            case 42:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                case 15:
                    {
                    alt33=2;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA33_7 = input.LA(3);

                    if ( ((LA33_7>=34 && LA33_7<=35)||LA33_7==43) ) {
                        alt33=1;
                    }
                    else if ( (LA33_7==EOF||(LA33_7>=RULE_STRING && LA33_7<=RULE_ID)||(LA33_7>=15 && LA33_7<=16)||LA33_7==22||(LA33_7>=25 && LA33_7<=26)||(LA33_7>=29 && LA33_7<=33)||(LA33_7>=38 && LA33_7<=39)||(LA33_7>=41 && LA33_7<=42)) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case 38:
                case 39:
                    {
                    alt33=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_ID:
                {
                int LA33_3 = input.LA(2);

                if ( (LA33_3==EOF||(LA33_3>=RULE_STRING && LA33_3<=RULE_ID)||(LA33_3>=15 && LA33_3<=16)||LA33_3==22||(LA33_3>=25 && LA33_3<=26)||(LA33_3>=28 && LA33_3<=33)||(LA33_3>=38 && LA33_3<=39)||(LA33_3>=41 && LA33_3<=42)) ) {
                    alt33=2;
                }
                else if ( ((LA33_3>=34 && LA33_3<=35)||LA33_3==43) ) {
                    alt33=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 3, input);

                    throw nvae;
                }
                }
                break;
            case 38:
                {
                int LA33_4 = input.LA(2);

                if ( ((LA33_4>=34 && LA33_4<=35)||LA33_4==43) ) {
                    alt33=1;
                }
                else if ( (LA33_4==EOF||(LA33_4>=RULE_STRING && LA33_4<=RULE_ID)||(LA33_4>=15 && LA33_4<=16)||LA33_4==22||(LA33_4>=25 && LA33_4<=26)||(LA33_4>=28 && LA33_4<=33)||(LA33_4>=38 && LA33_4<=39)||(LA33_4>=41 && LA33_4<=42)) ) {
                    alt33=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 4, input);

                    throw nvae;
                }
                }
                break;
            case 39:
                {
                int LA33_5 = input.LA(2);

                if ( (LA33_5==EOF||(LA33_5>=RULE_STRING && LA33_5<=RULE_ID)||(LA33_5>=15 && LA33_5<=16)||LA33_5==22||(LA33_5>=25 && LA33_5<=26)||(LA33_5>=28 && LA33_5<=33)||(LA33_5>=38 && LA33_5<=39)||(LA33_5>=41 && LA33_5<=42)) ) {
                    alt33=2;
                }
                else if ( ((LA33_5>=34 && LA33_5<=35)||LA33_5==43) ) {
                    alt33=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 15:
                {
                alt33=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:958:4: ruleAssignment
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality3043);
                    ruleAssignment();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:966:4: ruleAbstractTerminal
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality3067);
                    ruleAbstractTerminal();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:974:3: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==22||(LA35_0>=31 && LA35_0<=32)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:975:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:975:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:976:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:976:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    int alt34=3;
                    switch ( input.LA(1) ) {
                    case 31:
                        {
                        alt34=1;
                        }
                        break;
                    case 22:
                        {
                        alt34=2;
                        }
                        break;
                    case 32:
                        {
                        alt34=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }

                    switch (alt34) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:977:6: lv_cardinality_2_1= '?'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					
                            lv_cardinality_2_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAbstractTokenWithCardinality3107); 

                            						doneLeaf(lv_cardinality_2_1);
                            					

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:985:6: lv_cardinality_2_2= '*'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					
                            lv_cardinality_2_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAbstractTokenWithCardinality3141); 

                            						doneLeaf(lv_cardinality_2_2);
                            					

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:993:6: lv_cardinality_2_3= '+'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					
                            lv_cardinality_2_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAbstractTokenWithCardinality3175); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1007:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1007:16: ( ruleAction EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1008:2: ruleAction EOF
            {
             markComposite(elementTypeProvider.getActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction3214);
            ruleAction();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction3217); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1013:1: ruleAction : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final void ruleAction() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1013:11: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1014:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1014:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1015:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getAction_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAction3236); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1022:3: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1023:4: (lv_type_1_0= ruleTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1023:4: (lv_type_1_0= ruleTypeRef )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1024:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getAction_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleAction3263);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1033:3: (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==17) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1034:4: otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {

                    				markLeaf(elementTypeProvider.getAction_FullStopKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAction3294); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1041:4: ( (lv_feature_3_0= ruleValidID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1042:5: (lv_feature_3_0= ruleValidID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1042:5: (lv_feature_3_0= ruleValidID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1043:6: lv_feature_3_0= ruleValidID
                    {

                    						markComposite(elementTypeProvider.getAction_FeatureValidIDParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleAction3326);
                    ruleValidID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1052:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1053:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1053:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1054:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1054:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==34) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==35) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1055:7: lv_operator_4_1= '='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorEqualsSignKeyword_2_2_0_0ElementType());
                            						
                            lv_operator_4_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAction3380); 

                            							doneLeaf(lv_operator_4_1);
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1063:7: lv_operator_4_2= '+='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType());
                            						
                            lv_operator_4_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAction3418); 

                            							doneLeaf(lv_operator_4_2);
                            						

                            }
                            break;

                    }


                    }


                    }


                    				markLeaf(elementTypeProvider.getAction_CurrentKeyword_2_3ElementType());
                    			
                    otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleAction3456); 

                    				doneLeaf(otherlv_5);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getAction_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleAction3476); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1092:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1092:26: ( ruleAbstractTerminal EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1093:2: ruleAbstractTerminal EOF
            {
             markComposite(elementTypeProvider.getAbstractTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3496);
            ruleAbstractTerminal();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal3499); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1098:1: ruleAbstractTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1098:21: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1099:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1099:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup )
            int alt38=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt38=1;
                }
                break;
            case RULE_ID:
            case 38:
            case 39:
                {
                alt38=2;
                }
                break;
            case 15:
                {
                alt38=3;
                }
                break;
            case 41:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt38=4;
                    }
                    break;
                case RULE_ID:
                    {
                    alt38=5;
                    }
                    break;
                case 15:
                    {
                    alt38=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 4, input);

                    throw nvae;
                }

                }
                break;
            case 42:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt38=4;
                    }
                    break;
                case RULE_ID:
                    {
                    alt38=5;
                    }
                    break;
                case 15:
                    {
                    alt38=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 5, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1100:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAbstractTerminal3516);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1108:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3536);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1116:3: ruleParenthesizedElement
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3556);
                    ruleParenthesizedElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1124:3: rulePredicatedKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedKeywordParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedKeyword_in_ruleAbstractTerminal3576);
                    rulePredicatedKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1132:3: rulePredicatedRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedRuleCallParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedRuleCall_in_ruleAbstractTerminal3596);
                    rulePredicatedRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1140:3: rulePredicatedGroup
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedGroupParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedGroup_in_ruleAbstractTerminal3616);
                    rulePredicatedGroup();

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1151:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1151:17: ( ruleKeyword EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1152:2: ruleKeyword EOF
            {
             markComposite(elementTypeProvider.getKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword3636);
            ruleKeyword();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword3639); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1157:1: ruleKeyword : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final void ruleKeyword() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1157:12: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1158:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1158:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1159:3: (lv_value_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1159:3: (lv_value_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1160:4: lv_value_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getKeyword_ValueSTRINGTerminalRuleCall_0ElementType());
            			
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleKeyword3664); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1172:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1172:18: ( ruleRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1173:2: ruleRuleCall EOF
            {
             markComposite(elementTypeProvider.getRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall3689);
            ruleRuleCall();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall3692); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1178:1: ruleRuleCall : ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? ) ;
    public final void ruleRuleCall() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1178:13: ( ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1179:2: ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1179:2: ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1180:3: ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )?
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1180:3: ( ( ruleRuleID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1181:4: ( ruleRuleID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1181:4: ( ruleRuleID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1182:5: ruleRuleID
            {

            					markComposite(elementTypeProvider.getRuleCall_RuleAbstractRuleCrossReference_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleRuleCall3722);
            ruleRuleID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1191:3: (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==26) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1192:4: otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>'
                    {

                    				markLeaf(elementTypeProvider.getRuleCall_LessThanSignKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRuleCall3753); 

                    				doneLeaf(otherlv_1);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1199:4: ( (lv_arguments_2_0= ruleNamedArgument ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1200:5: (lv_arguments_2_0= ruleNamedArgument )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1200:5: (lv_arguments_2_0= ruleNamedArgument )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1201:6: lv_arguments_2_0= ruleNamedArgument
                    {

                    						markComposite(elementTypeProvider.getRuleCall_ArgumentsNamedArgumentParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_ruleRuleCall3785);
                    ruleNamedArgument();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1210:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==13) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1211:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getRuleCall_CommaKeyword_1_2_0ElementType());
                    	    				
                    	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRuleCall3822); 

                    	    					doneLeaf(otherlv_3);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1218:5: ( (lv_arguments_4_0= ruleNamedArgument ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1219:6: (lv_arguments_4_0= ruleNamedArgument )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1219:6: (lv_arguments_4_0= ruleNamedArgument )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1220:7: lv_arguments_4_0= ruleNamedArgument
                    	    {

                    	    							markComposite(elementTypeProvider.getRuleCall_ArgumentsNamedArgumentParserRuleCall_1_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_ruleRuleCall3859);
                    	    ruleNamedArgument();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    				markLeaf(elementTypeProvider.getRuleCall_GreaterThanSignKeyword_1_3ElementType());
                    			
                    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRuleCall3898); 

                    				doneLeaf(otherlv_5);
                    			

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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleNamedArgument"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1242:1: entryRuleNamedArgument : ruleNamedArgument EOF ;
    public final void entryRuleNamedArgument() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1242:23: ( ruleNamedArgument EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1243:2: ruleNamedArgument EOF
            {
             markComposite(elementTypeProvider.getNamedArgumentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument3924);
            ruleNamedArgument();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedArgument3927); 

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
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1248:1: ruleNamedArgument : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) ) ;
    public final void ruleNamedArgument() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_calledByName_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1248:18: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1249:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1249:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1250:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1250:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==34) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1251:4: ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1251:4: ( (otherlv_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1252:5: (otherlv_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1252:5: (otherlv_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1253:6: otherlv_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getNamedArgument_ParameterParameterCrossReference_0_0_0ElementType());
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedArgument3967); 

                    						doneLeaf(otherlv_0);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1262:4: ( (lv_calledByName_1_0= '=' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1263:5: (lv_calledByName_1_0= '=' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1263:5: (lv_calledByName_1_0= '=' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1264:6: lv_calledByName_1_0= '='
                    {

                    						markLeaf(elementTypeProvider.getNamedArgument_CalledByNameEqualsSignKeyword_0_1_0ElementType());
                    					
                    lv_calledByName_1_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleNamedArgument4012); 

                    						doneLeaf(lv_calledByName_1_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1274:3: ( (lv_value_2_0= ruleDisjunction ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1275:4: (lv_value_2_0= ruleDisjunction )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1275:4: (lv_value_2_0= ruleDisjunction )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1276:5: lv_value_2_0= ruleDisjunction
            {

            					markComposite(elementTypeProvider.getNamedArgument_ValueDisjunctionParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDisjunction_in_ruleNamedArgument4058);
            ruleDisjunction();

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
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleLiteralCondition"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1289:1: entryRuleLiteralCondition : ruleLiteralCondition EOF ;
    public final void entryRuleLiteralCondition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1289:26: ( ruleLiteralCondition EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1290:2: ruleLiteralCondition EOF
            {
             markComposite(elementTypeProvider.getLiteralConditionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLiteralCondition_in_entryRuleLiteralCondition4089);
            ruleLiteralCondition();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLiteralCondition4092); 

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
    // $ANTLR end "entryRuleLiteralCondition"


    // $ANTLR start "ruleLiteralCondition"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1295:1: ruleLiteralCondition : ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final void ruleLiteralCondition() throws RecognitionException {
        Token lv_true_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1295:21: ( ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1296:2: ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1296:2: ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1297:3: () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1297:3: ()
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1298:4: 
            {

            				precedeComposite(elementTypeProvider.getLiteralCondition_LiteralConditionAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1303:3: ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==38) ) {
                alt42=1;
            }
            else if ( (LA42_0==39) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1304:4: ( (lv_true_1_0= 'true' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1304:4: ( (lv_true_1_0= 'true' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1305:5: (lv_true_1_0= 'true' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1305:5: (lv_true_1_0= 'true' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1306:6: lv_true_1_0= 'true'
                    {

                    						markLeaf(elementTypeProvider.getLiteralCondition_TrueTrueKeyword_1_0_0ElementType());
                    					
                    lv_true_1_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLiteralCondition4145); 

                    						doneLeaf(lv_true_1_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1316:4: otherlv_2= 'false'
                    {

                    				markLeaf(elementTypeProvider.getLiteralCondition_FalseKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLiteralCondition4184); 

                    				doneLeaf(otherlv_2);
                    			

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
    // $ANTLR end "ruleLiteralCondition"


    // $ANTLR start "entryRuleDisjunction"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1328:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1328:21: ( ruleDisjunction EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1329:2: ruleDisjunction EOF
            {
             markComposite(elementTypeProvider.getDisjunctionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDisjunction_in_entryRuleDisjunction4209);
            ruleDisjunction();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDisjunction4212); 

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
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1334:1: ruleDisjunction : ( ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* ) ;
    public final void ruleDisjunction() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1334:16: ( ( ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1335:2: ( ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1335:2: ( ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1336:3: ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )*
            {

            			markComposite(elementTypeProvider.getDisjunction_ConjunctionParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleConjunction_in_ruleDisjunction4229);
            ruleConjunction();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1343:3: ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==29) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1344:4: () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1344:4: ()
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1345:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getDisjunction_DisjunctionLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getDisjunction_VerticalLineKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleDisjunction4265); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1357:4: ( (lv_right_3_0= ruleConjunction ) )
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1358:5: (lv_right_3_0= ruleConjunction )
            	    {
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1358:5: (lv_right_3_0= ruleConjunction )
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1359:6: lv_right_3_0= ruleConjunction
            	    {

            	    						markComposite(elementTypeProvider.getDisjunction_RightConjunctionParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleConjunction_in_ruleDisjunction4297);
            	    ruleConjunction();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1373:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1373:21: ( ruleConjunction EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1374:2: ruleConjunction EOF
            {
             markComposite(elementTypeProvider.getConjunctionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConjunction_in_entryRuleConjunction4336);
            ruleConjunction();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConjunction4339); 

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
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1379:1: ruleConjunction : ( ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* ) ;
    public final void ruleConjunction() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1379:16: ( ( ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1380:2: ( ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1380:2: ( ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1381:3: ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )*
            {

            			markComposite(elementTypeProvider.getConjunction_NegationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleNegation_in_ruleConjunction4356);
            ruleNegation();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1388:3: ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==30) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1389:4: () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1389:4: ()
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1390:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getConjunction_ConjunctionLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getConjunction_AmpersandKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleConjunction4392); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1402:4: ( (lv_right_3_0= ruleNegation ) )
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1403:5: (lv_right_3_0= ruleNegation )
            	    {
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1403:5: (lv_right_3_0= ruleNegation )
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1404:6: lv_right_3_0= ruleNegation
            	    {

            	    						markComposite(elementTypeProvider.getConjunction_RightNegationParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleNegation_in_ruleConjunction4424);
            	    ruleNegation();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
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
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1418:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1418:18: ( ruleNegation EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1419:2: ruleNegation EOF
            {
             markComposite(elementTypeProvider.getNegationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegation_in_entryRuleNegation4463);
            ruleNegation();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegation4466); 

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
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1424:1: ruleNegation : ( ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) ) ;
    public final void ruleNegation() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1424:13: ( ( ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1425:2: ( ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1425:2: ( ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID||LA45_0==15||(LA45_0>=38 && LA45_0<=39)) ) {
                alt45=1;
            }
            else if ( (LA45_0==40) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1426:3: ruleAtom
                    {

                    			markComposite(elementTypeProvider.getNegation_AtomParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_ruleNegation4483);
                    ruleAtom();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1434:3: ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1434:3: ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1435:4: () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1435:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1436:5: 
                    {

                    					precedeComposite(elementTypeProvider.getNegation_NegationAction_1_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getNegation_ExclamationMarkKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleNegation4527); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1448:4: ( (lv_value_3_0= ruleNegation ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1449:5: (lv_value_3_0= ruleNegation )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1449:5: (lv_value_3_0= ruleNegation )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1450:6: lv_value_3_0= ruleNegation
                    {

                    						markComposite(elementTypeProvider.getNegation_ValueNegationParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNegation_in_ruleNegation4559);
                    ruleNegation();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


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
        return ;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleAtom"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1464:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1464:14: ( ruleAtom EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1465:2: ruleAtom EOF
            {
             markComposite(elementTypeProvider.getAtomElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom4597);
            ruleAtom();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom4600); 

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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1470:1: ruleAtom : ( ruleParameterReference | ruleParenthesizedCondition | ruleLiteralCondition ) ;
    public final void ruleAtom() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1470:9: ( ( ruleParameterReference | ruleParenthesizedCondition | ruleLiteralCondition ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1471:2: ( ruleParameterReference | ruleParenthesizedCondition | ruleLiteralCondition )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1471:2: ( ruleParameterReference | ruleParenthesizedCondition | ruleLiteralCondition )
            int alt46=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt46=1;
                }
                break;
            case 15:
                {
                alt46=2;
                }
                break;
            case 38:
            case 39:
                {
                alt46=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1472:3: ruleParameterReference
                    {

                    			markComposite(elementTypeProvider.getAtom_ParameterReferenceParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParameterReference_in_ruleAtom4617);
                    ruleParameterReference();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1480:3: ruleParenthesizedCondition
                    {

                    			markComposite(elementTypeProvider.getAtom_ParenthesizedConditionParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedCondition_in_ruleAtom4637);
                    ruleParenthesizedCondition();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1488:3: ruleLiteralCondition
                    {

                    			markComposite(elementTypeProvider.getAtom_LiteralConditionParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLiteralCondition_in_ruleAtom4657);
                    ruleLiteralCondition();

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
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParenthesizedCondition"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1499:1: entryRuleParenthesizedCondition : ruleParenthesizedCondition EOF ;
    public final void entryRuleParenthesizedCondition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1499:32: ( ruleParenthesizedCondition EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1500:2: ruleParenthesizedCondition EOF
            {
             markComposite(elementTypeProvider.getParenthesizedConditionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedCondition_in_entryRuleParenthesizedCondition4677);
            ruleParenthesizedCondition();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedCondition4680); 

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
    // $ANTLR end "entryRuleParenthesizedCondition"


    // $ANTLR start "ruleParenthesizedCondition"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1505:1: ruleParenthesizedCondition : (otherlv_0= '(' ruleDisjunction otherlv_2= ')' ) ;
    public final void ruleParenthesizedCondition() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1505:27: ( (otherlv_0= '(' ruleDisjunction otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1506:2: (otherlv_0= '(' ruleDisjunction otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1506:2: (otherlv_0= '(' ruleDisjunction otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1507:3: otherlv_0= '(' ruleDisjunction otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedCondition_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedCondition4699); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedCondition_DisjunctionParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDisjunction_in_ruleParenthesizedCondition4711);
            ruleDisjunction();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedCondition_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedCondition4725); 

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
    // $ANTLR end "ruleParenthesizedCondition"


    // $ANTLR start "entryRuleParameterReference"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1532:1: entryRuleParameterReference : ruleParameterReference EOF ;
    public final void entryRuleParameterReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1532:28: ( ruleParameterReference EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1533:2: ruleParameterReference EOF
            {
             markComposite(elementTypeProvider.getParameterReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameterReference_in_entryRuleParameterReference4745);
            ruleParameterReference();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterReference4748); 

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
    // $ANTLR end "entryRuleParameterReference"


    // $ANTLR start "ruleParameterReference"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1538:1: ruleParameterReference : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleParameterReference() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1538:23: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1539:2: ( (otherlv_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1539:2: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1540:3: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1540:3: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1541:4: otherlv_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getParameterReference_ParameterParameterCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameterReference4773); 

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
    // $ANTLR end "ruleParameterReference"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1553:1: entryRuleTerminalRuleCall : ruleTerminalRuleCall EOF ;
    public final void entryRuleTerminalRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1553:26: ( ruleTerminalRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1554:2: ruleTerminalRuleCall EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRuleCall_in_entryRuleTerminalRuleCall4798);
            ruleTerminalRuleCall();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRuleCall4801); 

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
    // $ANTLR end "entryRuleTerminalRuleCall"


    // $ANTLR start "ruleTerminalRuleCall"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1559:1: ruleTerminalRuleCall : ( ( ruleRuleID ) ) ;
    public final void ruleTerminalRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1559:21: ( ( ( ruleRuleID ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1560:2: ( ( ruleRuleID ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1560:2: ( ( ruleRuleID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1561:3: ( ruleRuleID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1561:3: ( ruleRuleID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1562:4: ruleRuleID
            {

            				markComposite(elementTypeProvider.getTerminalRuleCall_RuleAbstractRuleCrossReference_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleTerminalRuleCall4824);
            ruleRuleID();

            state._fsp--;


            				doneComposite();
            			

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
    // $ANTLR end "ruleTerminalRuleCall"


    // $ANTLR start "entryRuleRuleID"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1574:1: entryRuleRuleID : ruleRuleID EOF ;
    public final void entryRuleRuleID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1574:16: ( ruleRuleID EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1575:2: ruleRuleID EOF
            {
             markComposite(elementTypeProvider.getRuleIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_entryRuleRuleID4849);
            ruleRuleID();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleID4852); 

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
    // $ANTLR end "entryRuleRuleID"


    // $ANTLR start "ruleRuleID"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1580:1: ruleRuleID : ( ruleValidID (kw= '::' ruleValidID )* ) ;
    public final void ruleRuleID() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1580:11: ( ( ruleValidID (kw= '::' ruleValidID )* ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1581:2: ( ruleValidID (kw= '::' ruleValidID )* )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1581:2: ( ruleValidID (kw= '::' ruleValidID )* )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1582:3: ruleValidID (kw= '::' ruleValidID )*
            {

            			markComposite(elementTypeProvider.getRuleID_ValidIDParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleRuleID4869);
            ruleValidID();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1589:3: (kw= '::' ruleValidID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==28) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1590:4: kw= '::' ruleValidID
            	    {

            	    				markLeaf(elementTypeProvider.getRuleID_ColonColonKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRuleID4889); 

            	    				doneLeaf(kw);
            	    			

            	    				markComposite(elementTypeProvider.getRuleID_ValidIDParserRuleCall_1_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleRuleID4904);
            	    ruleValidID();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "ruleRuleID"


    // $ANTLR start "entryRuleValidID"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1609:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1609:17: ( ruleValidID EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1610:2: ruleValidID EOF
            {
             markComposite(elementTypeProvider.getValidIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_entryRuleValidID4930);
            ruleValidID();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValidID4933); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1615:1: ruleValidID : (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' ) ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1615:12: ( (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1616:2: (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1616:2: (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' )
            int alt48=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt48=1;
                }
                break;
            case 38:
                {
                alt48=2;
                }
                break;
            case 39:
                {
                alt48=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1617:3: this_ID_0= RULE_ID
                    {

                    			markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCall_0ElementType());
                    		
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValidID4952); 

                    			doneLeaf(this_ID_0);
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1625:3: kw= 'true'
                    {

                    			markLeaf(elementTypeProvider.getValidID_TrueKeyword_1ElementType());
                    		
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleValidID4974); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1633:3: kw= 'false'
                    {

                    			markLeaf(elementTypeProvider.getValidID_FalseKeyword_2ElementType());
                    		
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleValidID4996); 

                    			doneLeaf(kw);
                    		

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
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRulePredicatedKeyword"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1644:1: entryRulePredicatedKeyword : rulePredicatedKeyword EOF ;
    public final void entryRulePredicatedKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1644:27: ( rulePredicatedKeyword EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1645:2: rulePredicatedKeyword EOF
            {
             markComposite(elementTypeProvider.getPredicatedKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedKeyword_in_entryRulePredicatedKeyword5016);
            rulePredicatedKeyword();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedKeyword5019); 

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
    // $ANTLR end "entryRulePredicatedKeyword"


    // $ANTLR start "rulePredicatedKeyword"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1650:1: rulePredicatedKeyword : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final void rulePredicatedKeyword() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token lv_value_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1650:22: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1651:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1651:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1652:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1652:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==41) ) {
                alt49=1;
            }
            else if ( (LA49_0==42) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1653:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1653:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1654:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1654:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1655:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf(elementTypeProvider.getPredicatedKeyword_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					
                    lv_predicated_0_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_rulePredicatedKeyword5059); 

                    						doneLeaf(lv_predicated_0_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1665:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1665:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1666:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1666:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1667:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf(elementTypeProvider.getPredicatedKeyword_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_rulePredicatedKeyword5113); 

                    						doneLeaf(lv_firstSetPredicated_1_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1677:3: ( (lv_value_2_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1678:4: (lv_value_2_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1678:4: (lv_value_2_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1679:5: lv_value_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getPredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rulePredicatedKeyword5158); 

            					doneLeaf(lv_value_2_0);
            				

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
    // $ANTLR end "rulePredicatedKeyword"


    // $ANTLR start "entryRulePredicatedRuleCall"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1692:1: entryRulePredicatedRuleCall : rulePredicatedRuleCall EOF ;
    public final void entryRulePredicatedRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1692:28: ( rulePredicatedRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1693:2: rulePredicatedRuleCall EOF
            {
             markComposite(elementTypeProvider.getPredicatedRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedRuleCall_in_entryRulePredicatedRuleCall5189);
            rulePredicatedRuleCall();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedRuleCall5192); 

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
    // $ANTLR end "entryRulePredicatedRuleCall"


    // $ANTLR start "rulePredicatedRuleCall"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1698:1: rulePredicatedRuleCall : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? ) ;
    public final void rulePredicatedRuleCall() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1698:23: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1699:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1699:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1700:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )?
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1700:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==41) ) {
                alt50=1;
            }
            else if ( (LA50_0==42) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1701:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1701:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1702:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1702:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1703:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf(elementTypeProvider.getPredicatedRuleCall_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					
                    lv_predicated_0_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_rulePredicatedRuleCall5232); 

                    						doneLeaf(lv_predicated_0_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1713:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1713:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1714:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1714:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1715:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf(elementTypeProvider.getPredicatedRuleCall_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_rulePredicatedRuleCall5286); 

                    						doneLeaf(lv_firstSetPredicated_1_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1725:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1726:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1726:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1727:5: otherlv_2= RULE_ID
            {

            					markLeaf(elementTypeProvider.getPredicatedRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePredicatedRuleCall5331); 

            					doneLeaf(otherlv_2);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1736:3: (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==26) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1737:4: otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>'
                    {

                    				markLeaf(elementTypeProvider.getPredicatedRuleCall_LessThanSignKeyword_2_0ElementType());
                    			
                    otherlv_3=(Token)match(input,26,FollowSets000.FOLLOW_26_in_rulePredicatedRuleCall5362); 

                    				doneLeaf(otherlv_3);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1744:4: ( (lv_arguments_4_0= ruleNamedArgument ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1745:5: (lv_arguments_4_0= ruleNamedArgument )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1745:5: (lv_arguments_4_0= ruleNamedArgument )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1746:6: lv_arguments_4_0= ruleNamedArgument
                    {

                    						markComposite(elementTypeProvider.getPredicatedRuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_rulePredicatedRuleCall5394);
                    ruleNamedArgument();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1755:4: (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==13) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1756:5: otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getPredicatedRuleCall_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePredicatedRuleCall5431); 

                    	    					doneLeaf(otherlv_5);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1763:5: ( (lv_arguments_6_0= ruleNamedArgument ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1764:6: (lv_arguments_6_0= ruleNamedArgument )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1764:6: (lv_arguments_6_0= ruleNamedArgument )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1765:7: lv_arguments_6_0= ruleNamedArgument
                    	    {

                    	    							markComposite(elementTypeProvider.getPredicatedRuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_rulePredicatedRuleCall5468);
                    	    ruleNamedArgument();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    				markLeaf(elementTypeProvider.getPredicatedRuleCall_GreaterThanSignKeyword_2_3ElementType());
                    			
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_rulePredicatedRuleCall5507); 

                    				doneLeaf(otherlv_7);
                    			

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
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1787:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1787:20: ( ruleAssignment EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1788:2: ruleAssignment EOF
            {
             markComposite(elementTypeProvider.getAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment5533);
            ruleAssignment();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment5536); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1793:1: ruleAssignment : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) ) ;
    public final void ruleAssignment() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token lv_operator_3_1=null;
        Token lv_operator_3_2=null;
        Token lv_operator_3_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1793:15: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1794:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1794:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1795:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1795:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )?
            int alt53=3;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==41) ) {
                alt53=1;
            }
            else if ( (LA53_0==42) ) {
                alt53=2;
            }
            switch (alt53) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1796:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1796:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1797:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1797:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1798:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf(elementTypeProvider.getAssignment_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					
                    lv_predicated_0_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleAssignment5576); 

                    						doneLeaf(lv_predicated_0_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1808:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1808:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1809:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1809:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1810:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf(elementTypeProvider.getAssignment_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleAssignment5630); 

                    						doneLeaf(lv_firstSetPredicated_1_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1820:3: ( (lv_feature_2_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1821:4: (lv_feature_2_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1821:4: (lv_feature_2_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1822:5: lv_feature_2_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getAssignment_FeatureValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleAssignment5676);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1831:3: ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1832:4: ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1832:4: ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1833:5: (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1833:5: (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt54=1;
                }
                break;
            case 34:
                {
                alt54=2;
                }
                break;
            case 43:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1834:6: lv_operator_3_1= '+='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorPlusSignEqualsSignKeyword_2_0_0ElementType());
                    					
                    lv_operator_3_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAssignment5722); 

                    						doneLeaf(lv_operator_3_1);
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1842:6: lv_operator_3_2= '='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorEqualsSignKeyword_2_0_1ElementType());
                    					
                    lv_operator_3_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAssignment5756); 

                    						doneLeaf(lv_operator_3_2);
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1850:6: lv_operator_3_3= '?='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2ElementType());
                    					
                    lv_operator_3_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleAssignment5790); 

                    						doneLeaf(lv_operator_3_3);
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1860:3: ( (lv_terminal_4_0= ruleAssignableTerminal ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1861:4: (lv_terminal_4_0= ruleAssignableTerminal )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1861:4: (lv_terminal_4_0= ruleAssignableTerminal )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1862:5: lv_terminal_4_0= ruleAssignableTerminal
            {

            					markComposite(elementTypeProvider.getAssignment_TerminalAssignableTerminalParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignment5835);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1875:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1875:28: ( ruleAssignableTerminal EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1876:2: ruleAssignableTerminal EOF
            {
             markComposite(elementTypeProvider.getAssignableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal5866);
            ruleAssignableTerminal();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal5869); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1881:1: ruleAssignableTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1881:23: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1882:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1882:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            int alt55=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt55=1;
                }
                break;
            case RULE_ID:
            case 38:
            case 39:
                {
                alt55=2;
                }
                break;
            case 15:
                {
                alt55=3;
                }
                break;
            case 44:
                {
                alt55=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1883:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAssignableTerminal5886);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1891:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAssignableTerminal5906);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1899:3: ruleParenthesizedAssignableElement
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal5926);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1907:3: ruleCrossReference
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_CrossReferenceParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_ruleAssignableTerminal5946);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1918:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1918:40: ( ruleParenthesizedAssignableElement EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1919:2: ruleParenthesizedAssignableElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedAssignableElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement5966);
            ruleParenthesizedAssignableElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement5969); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1924:1: ruleParenthesizedAssignableElement : (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1924:35: ( (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1925:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1925:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1926:3: otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedAssignableElement5988); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement6000);
            ruleAssignableAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedAssignableElement6014); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1951:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1951:32: ( ruleAssignableAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1952:2: ruleAssignableAlternatives EOF
            {
             markComposite(elementTypeProvider.getAssignableAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives6034);
            ruleAssignableAlternatives();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives6037); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1957:1: ruleAssignableAlternatives : ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1957:27: ( ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1958:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1958:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1959:3: ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives6054);
            ruleAssignableTerminal();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1966:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==29) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1967:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1967:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1968:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAssignableAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1973:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    int cnt56=0;
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==29) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1974:5: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAssignableAlternatives6097); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1981:5: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1982:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1982:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1983:7: lv_elements_3_0= ruleAssignableTerminal
                    	    {

                    	    							markComposite(elementTypeProvider.getAssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives6134);
                    	    ruleAssignableTerminal();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt56 >= 1 ) break loop56;
                                EarlyExitException eee =
                                    new EarlyExitException(56, input);
                                throw eee;
                        }
                        cnt56++;
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1998:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1998:24: ( ruleCrossReference EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1999:2: ruleCrossReference EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference6182);
            ruleCrossReference();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference6185); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2004:1: ruleCrossReference : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final void ruleCrossReference() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2004:19: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2005:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2005:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2006:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {

            			markLeaf(elementTypeProvider.getCrossReference_LeftSquareBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCrossReference6204); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2013:3: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2014:4: (lv_type_1_0= ruleTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2014:4: (lv_type_1_0= ruleTypeRef )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2015:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleCrossReference6231);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2024:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==29) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2025:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {

                    				markLeaf(elementTypeProvider.getCrossReference_VerticalLineKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCrossReference6262); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2032:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2033:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2033:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2034:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						markComposite(elementTypeProvider.getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference6294);
                    ruleCrossReferenceableTerminal();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getCrossReference_RightSquareBracketKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCrossReference6327); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2055:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2055:36: ( ruleCrossReferenceableTerminal EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2056:2: ruleCrossReferenceableTerminal EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal6347);
            ruleCrossReferenceableTerminal();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal6350); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2061:1: ruleCrossReferenceableTerminal : ( ruleKeyword | ruleRuleCall ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2061:31: ( ( ruleKeyword | ruleRuleCall ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2062:2: ( ruleKeyword | ruleRuleCall )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2062:2: ( ruleKeyword | ruleRuleCall )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_STRING) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_ID||(LA59_0>=38 && LA59_0<=39)) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2063:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal6367);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2071:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal6387);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2082:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2082:30: ( ruleParenthesizedElement EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2083:2: ruleParenthesizedElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement6407);
            ruleParenthesizedElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement6410); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2088:1: ruleParenthesizedElement : (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2088:25: ( (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2089:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2089:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2090:3: otherlv_0= '(' ruleAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedElement6429); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedElement_AlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParenthesizedElement6441);
            ruleAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedElement_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedElement6455); 

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


    // $ANTLR start "entryRulePredicatedGroup"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2115:1: entryRulePredicatedGroup : rulePredicatedGroup EOF ;
    public final void entryRulePredicatedGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2115:25: ( rulePredicatedGroup EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2116:2: rulePredicatedGroup EOF
            {
             markComposite(elementTypeProvider.getPredicatedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedGroup_in_entryRulePredicatedGroup6475);
            rulePredicatedGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedGroup6478); 

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
    // $ANTLR end "entryRulePredicatedGroup"


    // $ANTLR start "rulePredicatedGroup"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2121:1: rulePredicatedGroup : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' ) ;
    public final void rulePredicatedGroup() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2121:20: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2122:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2122:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2123:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')'
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2123:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==41) ) {
                alt60=1;
            }
            else if ( (LA60_0==42) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2124:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2124:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2125:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2125:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2126:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf(elementTypeProvider.getPredicatedGroup_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					
                    lv_predicated_0_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_rulePredicatedGroup6518); 

                    						doneLeaf(lv_predicated_0_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2136:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2136:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2137:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2137:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2138:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf(elementTypeProvider.getPredicatedGroup_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_rulePredicatedGroup6572); 

                    						doneLeaf(lv_firstSetPredicated_1_0);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getPredicatedGroup_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePredicatedGroup6604); 

            			doneLeaf(otherlv_2);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2155:3: ( (lv_elements_3_0= ruleAlternatives ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2156:4: (lv_elements_3_0= ruleAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2156:4: (lv_elements_3_0= ruleAlternatives )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2157:5: lv_elements_3_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getPredicatedGroup_ElementsAlternativesParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rulePredicatedGroup6631);
            ruleAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getPredicatedGroup_RightParenthesisKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePredicatedGroup6656); 

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
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2177:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2177:22: ( ruleTerminalRule EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2178:2: ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule6676);
            ruleTerminalRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule6679); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2183:1: ruleTerminalRule : (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) ) | ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' ) ;
    public final void ruleTerminalRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_fragment_1_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2183:17: ( (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) ) | ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2184:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) ) | ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2184:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) ) | ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2185:3: otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) ) | ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';'
            {

            			markLeaf(elementTypeProvider.getTerminalRule_TerminalKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleTerminalRule6698); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2192:3: ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) ) | ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==21) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_ID||(LA62_0>=38 && LA62_0<=39)) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2193:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2193:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2194:5: ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= ruleValidID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2194:5: ( (lv_fragment_1_0= 'fragment' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2195:6: (lv_fragment_1_0= 'fragment' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2195:6: (lv_fragment_1_0= 'fragment' )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2196:7: lv_fragment_1_0= 'fragment'
                    {

                    							markLeaf(elementTypeProvider.getTerminalRule_FragmentFragmentKeyword_1_0_0_0ElementType());
                    						
                    lv_fragment_1_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTerminalRule6742); 

                    							doneLeaf(lv_fragment_1_0);
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2205:5: ( (lv_name_2_0= ruleValidID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2206:6: (lv_name_2_0= ruleValidID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2206:6: (lv_name_2_0= ruleValidID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2207:7: lv_name_2_0= ruleValidID
                    {

                    							markComposite(elementTypeProvider.getTerminalRule_NameValidIDParserRuleCall_1_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleTerminalRule6794);
                    ruleValidID();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2218:4: ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2218:4: ( ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2219:5: ( (lv_name_3_0= ruleValidID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )?
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2219:5: ( (lv_name_3_0= ruleValidID ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2220:6: (lv_name_3_0= ruleValidID )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2220:6: (lv_name_3_0= ruleValidID )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2221:7: lv_name_3_0= ruleValidID
                    {

                    							markComposite(elementTypeProvider.getTerminalRule_NameValidIDParserRuleCall_1_1_0_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleTerminalRule6865);
                    ruleValidID();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2230:5: (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==23) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2231:6: otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) )
                            {

                            						markLeaf(elementTypeProvider.getTerminalRule_ReturnsKeyword_1_1_1_0ElementType());
                            					
                            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTerminalRule6908); 

                            						doneLeaf(otherlv_4);
                            					
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2238:6: ( (lv_type_5_0= ruleTypeRef ) )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2239:7: (lv_type_5_0= ruleTypeRef )
                            {
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2239:7: (lv_type_5_0= ruleTypeRef )
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2240:8: lv_type_5_0= ruleTypeRef
                            {

                            								markComposite(elementTypeProvider.getTerminalRule_TypeTypeRefParserRuleCall_1_1_1_1_0ElementType());
                            							
                            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleTerminalRule6950);
                            ruleTypeRef();

                            state._fsp--;


                            								doneComposite();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getTerminalRule_ColonKeyword_2ElementType());
            		
            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTerminalRule7000); 

            			doneLeaf(otherlv_6);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2259:3: ( (lv_alternatives_7_0= ruleTerminalAlternatives ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2260:4: (lv_alternatives_7_0= ruleTerminalAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2260:4: (lv_alternatives_7_0= ruleTerminalAlternatives )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2261:5: lv_alternatives_7_0= ruleTerminalAlternatives
            {

            					markComposite(elementTypeProvider.getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule7027);
            ruleTerminalAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getTerminalRule_SemicolonKeyword_4ElementType());
            		
            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalRule7052); 

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
        return ;
    }
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2281:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2281:30: ( ruleTerminalAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2282:2: ruleTerminalAlternatives EOF
            {
             markComposite(elementTypeProvider.getTerminalAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives7072);
            ruleTerminalAlternatives();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives7075); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2287:1: ruleTerminalAlternatives : ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2287:25: ( ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2288:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2288:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2289:3: ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives7092);
            ruleTerminalGroup();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2296:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2297:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2297:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2298:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2303:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==29) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2304:5: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTerminalAlternatives7135); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2311:5: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2312:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2312:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2313:7: lv_elements_3_0= ruleTerminalGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getTerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives7172);
                    	    ruleTerminalGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2328:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2328:23: ( ruleTerminalGroup EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2329:2: ruleTerminalGroup EOF
            {
             markComposite(elementTypeProvider.getTerminalGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup7220);
            ruleTerminalGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup7223); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2334:1: ruleTerminalGroup : ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final void ruleTerminalGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2334:18: ( ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2335:2: ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2335:2: ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2336:3: ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalGroup_TerminalTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup7240);
            ruleTerminalToken();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2343:3: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=RULE_STRING && LA66_0<=RULE_ID)||LA66_0==15||LA66_0==17||(LA66_0>=38 && LA66_0<=40)||LA66_0==42||LA66_0==47) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2344:4: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2344:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2345:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2350:4: ( (lv_elements_2_0= ruleTerminalToken ) )+
                    int cnt65=0;
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( ((LA65_0>=RULE_STRING && LA65_0<=RULE_ID)||LA65_0==15||LA65_0==17||(LA65_0>=38 && LA65_0<=40)||LA65_0==42||LA65_0==47) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2351:5: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2351:5: (lv_elements_2_0= ruleTerminalToken )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2352:6: lv_elements_2_0= ruleTerminalToken
                    	    {

                    	    						markComposite(elementTypeProvider.getTerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup7291);
                    	    ruleTerminalToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt65 >= 1 ) break loop65;
                                EarlyExitException eee =
                                    new EarlyExitException(65, input);
                                throw eee;
                        }
                        cnt65++;
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2366:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2366:23: ( ruleTerminalToken EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2367:2: ruleTerminalToken EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken7331);
            ruleTerminalToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken7334); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2372:1: ruleTerminalToken : ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final void ruleTerminalToken() throws RecognitionException {
        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2372:18: ( ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2373:2: ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2373:2: ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2374:3: ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {

            			markComposite(elementTypeProvider.getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken7351);
            ruleTerminalTokenElement();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2381:3: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==22||(LA68_0>=31 && LA68_0<=32)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2382:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2382:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2383:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2383:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    int alt67=3;
                    switch ( input.LA(1) ) {
                    case 31:
                        {
                        alt67=1;
                        }
                        break;
                    case 22:
                        {
                        alt67=2;
                        }
                        break;
                    case 32:
                        {
                        alt67=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }

                    switch (alt67) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2384:6: lv_cardinality_1_1= '?'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					
                            lv_cardinality_1_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleTerminalToken7386); 

                            						doneLeaf(lv_cardinality_1_1);
                            					

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2392:6: lv_cardinality_1_2= '*'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					
                            lv_cardinality_1_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTerminalToken7420); 

                            						doneLeaf(lv_cardinality_1_2);
                            					

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2400:6: lv_cardinality_1_3= '+'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					
                            lv_cardinality_1_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTerminalToken7454); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2414:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2414:30: ( ruleTerminalTokenElement EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2415:2: ruleTerminalTokenElement EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement7493);
            ruleTerminalTokenElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement7496); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2420:1: ruleTerminalTokenElement : ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2420:25: ( ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2421:2: ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2421:2: ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF )
            int alt69=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt69=1;
                }
                break;
            case RULE_ID:
            case 38:
            case 39:
                {
                alt69=2;
                }
                break;
            case 15:
                {
                alt69=3;
                }
                break;
            case 40:
            case 42:
                {
                alt69=4;
                }
                break;
            case 17:
                {
                alt69=5;
                }
                break;
            case 47:
                {
                alt69=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2422:3: ruleCharacterRange
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement7513);
                    ruleCharacterRange();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2430:3: ruleTerminalRuleCall
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_TerminalRuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRuleCall_in_ruleTerminalTokenElement7533);
                    ruleTerminalRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2438:3: ruleParenthesizedTerminalElement
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement7553);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2446:3: ruleAbstractNegatedToken
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement7573);
                    ruleAbstractNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2454:3: ruleWildcard
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_WildcardParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_ruleTerminalTokenElement7593);
                    ruleWildcard();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2462:3: ruleEOF
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_EOFParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEOF_in_ruleTerminalTokenElement7613);
                    ruleEOF();

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2473:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2473:38: ( ruleParenthesizedTerminalElement EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2474:2: ruleParenthesizedTerminalElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedTerminalElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement7633);
            ruleParenthesizedTerminalElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement7636); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2479:1: ruleParenthesizedTerminalElement : (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2479:33: ( (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2480:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2480:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2481:3: otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedTerminalElement7655); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement7667);
            ruleTerminalAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedTerminalElement7681); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2506:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2506:30: ( ruleAbstractNegatedToken EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2507:2: ruleAbstractNegatedToken EOF
            {
             markComposite(elementTypeProvider.getAbstractNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken7701);
            ruleAbstractNegatedToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken7704); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2512:1: ruleAbstractNegatedToken : ( ruleNegatedToken | ruleUntilToken ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2512:25: ( ( ruleNegatedToken | ruleUntilToken ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2513:2: ( ruleNegatedToken | ruleUntilToken )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2513:2: ( ruleNegatedToken | ruleUntilToken )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==40) ) {
                alt70=1;
            }
            else if ( (LA70_0==42) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2514:3: ruleNegatedToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken7721);
                    ruleNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2522:3: ruleUntilToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken7741);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2533:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2533:22: ( ruleNegatedToken EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2534:2: ruleNegatedToken EOF
            {
             markComposite(elementTypeProvider.getNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken7761);
            ruleNegatedToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken7764); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2539:1: ruleNegatedToken : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2539:17: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2540:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2540:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2541:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getNegatedToken_ExclamationMarkKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleNegatedToken7783); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2548:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2549:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2549:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2550:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken7810);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2563:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2563:20: ( ruleUntilToken EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2564:2: ruleUntilToken EOF
            {
             markComposite(elementTypeProvider.getUntilTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken7841);
            ruleUntilToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken7844); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2569:1: ruleUntilToken : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleUntilToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2569:15: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2570:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2570:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2571:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleUntilToken7863); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2578:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2579:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2579:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2580:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken7890);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2593:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2593:18: ( ruleWildcard EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2594:2: ruleWildcard EOF
            {
             markComposite(elementTypeProvider.getWildcardElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard7921);
            ruleWildcard();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard7924); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2599:1: ruleWildcard : ( () otherlv_1= '.' ) ;
    public final void ruleWildcard() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2599:13: ( ( () otherlv_1= '.' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2600:2: ( () otherlv_1= '.' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2600:2: ( () otherlv_1= '.' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2601:3: () otherlv_1= '.'
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2601:3: ()
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2602:4: 
            {

            				precedeComposite(elementTypeProvider.getWildcard_WildcardAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getWildcard_FullStopKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleWildcard7956); 

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


    // $ANTLR start "entryRuleEOF"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2618:1: entryRuleEOF : ruleEOF EOF ;
    public final void entryRuleEOF() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2618:13: ( ruleEOF EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2619:2: ruleEOF EOF
            {
             markComposite(elementTypeProvider.getEOFElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOF_in_entryRuleEOF7976);
            ruleEOF();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEOF7979); 

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
    // $ANTLR end "entryRuleEOF"


    // $ANTLR start "ruleEOF"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2624:1: ruleEOF : ( () otherlv_1= 'EOF' ) ;
    public final void ruleEOF() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2624:8: ( ( () otherlv_1= 'EOF' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2625:2: ( () otherlv_1= 'EOF' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2625:2: ( () otherlv_1= 'EOF' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2626:3: () otherlv_1= 'EOF'
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2626:3: ()
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2627:4: 
            {

            				precedeComposite(elementTypeProvider.getEOF_EOFAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getEOF_EOFKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEOF8011); 

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
    // $ANTLR end "ruleEOF"


    // $ANTLR start "entryRuleCharacterRange"
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2643:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2643:24: ( ruleCharacterRange EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2644:2: ruleCharacterRange EOF
            {
             markComposite(elementTypeProvider.getCharacterRangeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange8031);
            ruleCharacterRange();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange8034); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2649:1: ruleCharacterRange : ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final void ruleCharacterRange() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2649:19: ( ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2650:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2650:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2651:3: ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			markComposite(elementTypeProvider.getCharacterRange_KeywordParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange8051);
            ruleKeyword();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2658:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==48) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2659:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2659:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2660:5: 
                    {

                    					precedeComposite(elementTypeProvider.getCharacterRange_CharacterRangeLeftAction_1_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getCharacterRange_FullStopFullStopKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleCharacterRange8087); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2672:4: ( (lv_right_3_0= ruleKeyword ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2673:5: (lv_right_3_0= ruleKeyword )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2673:5: (lv_right_3_0= ruleKeyword )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2674:6: lv_right_3_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange8119);
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2688:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2688:18: ( ruleEnumRule EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2689:2: ruleEnumRule EOF
            {
             markComposite(elementTypeProvider.getEnumRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule8158);
            ruleEnumRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule8161); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2694:1: ruleEnumRule : (otherlv_0= 'enum' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) ;
    public final void ruleEnumRule() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2694:13: ( (otherlv_0= 'enum' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2695:2: (otherlv_0= 'enum' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2695:2: (otherlv_0= 'enum' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2696:3: otherlv_0= 'enum' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';'
            {

            			markLeaf(elementTypeProvider.getEnumRule_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEnumRule8180); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2703:3: ( (lv_name_1_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2704:4: (lv_name_1_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2704:4: (lv_name_1_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2705:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getEnumRule_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleEnumRule8207);
            ruleValidID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2714:3: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==23) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2715:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumRule_ReturnsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumRule8238); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2722:4: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2723:5: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2723:5: (lv_type_3_0= ruleTypeRef )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2724:6: lv_type_3_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleEnumRule8270);
                    ruleTypeRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getEnumRule_ColonKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEnumRule8303); 

            			doneLeaf(otherlv_4);
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2741:3: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2742:4: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2742:4: (lv_alternatives_5_0= ruleEnumLiterals )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2743:5: lv_alternatives_5_0= ruleEnumLiterals
            {

            					markComposite(elementTypeProvider.getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_ruleEnumRule8330);
            ruleEnumLiterals();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getEnumRule_SemicolonKeyword_5ElementType());
            		
            otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumRule8355); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2763:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2763:22: ( ruleEnumLiterals EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2764:2: ruleEnumLiterals EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals8375);
            ruleEnumLiterals();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals8378); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2769:1: ruleEnumLiterals : ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final void ruleEnumLiterals() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2769:17: ( ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2770:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2770:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2771:3: ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals8395);
            ruleEnumLiteralDeclaration();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2778:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==29) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2779:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2779:4: ()
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2780:5: 
                    {

                    					precedeComposite(elementTypeProvider.getEnumLiterals_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2785:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==29) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2786:5: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getEnumLiterals_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEnumLiterals8438); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2793:5: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2794:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2794:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2795:7: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							markComposite(elementTypeProvider.getEnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals8475);
                    	    ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2810:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2810:32: ( ruleEnumLiteralDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2811:2: ruleEnumLiteralDeclaration EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration8523);
            ruleEnumLiteralDeclaration();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration8526); 

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
    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2816:1: ruleEnumLiteralDeclaration : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2816:27: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2817:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2817:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2818:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2818:3: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2819:4: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2819:4: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2820:5: otherlv_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration8558); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2829:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==34) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2830:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEnumLiteralDeclaration8589); 

                    				doneLeaf(otherlv_1);
                    			
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2837:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2838:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2838:5: (lv_literal_2_0= ruleKeyword )
                    // ../../intellij/org.eclipse.xtext.xtext.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2839:6: lv_literal_2_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration8621);
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
        public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammar57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleGrammar76 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar103 = new BitSet(new long[]{0x000240C000345020L});
        public static final BitSet FOLLOW_12_in_ruleGrammar134 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar164 = new BitSet(new long[]{0x000240C000347020L});
        public static final BitSet FOLLOW_13_in_ruleGrammar201 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar236 = new BitSet(new long[]{0x000240C000347020L});
        public static final BitSet FOLLOW_14_in_ruleGrammar299 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleGrammar329 = new BitSet(new long[]{0x000000C000010020L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleGrammar368 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleGrammar411 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleGrammar451 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleGrammar500 = new BitSet(new long[]{0x000240C000345020L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar533 = new BitSet(new long[]{0x000240C000345020L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar572 = new BitSet(new long[]{0x000240C000345022L});
        public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID604 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleGrammarID624 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleGrammarID644 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleGrammarID659 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule685 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_ruleAbstractRule745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration765 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel825 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel847 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleGeneratedMetamodel874 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel912 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel943 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleGeneratedMetamodel975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1014 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1036 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1063 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1094 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleReferencedMetamodel1126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParserRule1217 = new BitSet(new long[]{0x000000C000200020L});
        public static final BitSet FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1250 = new BitSet(new long[]{0x0000000001C04000L});
        public static final BitSet FOLLOW_22_in_ruleParserRule1297 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_23_in_ruleParserRule1357 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1404 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1476 = new BitSet(new long[]{0x0000000001804000L});
        public static final BitSet FOLLOW_23_in_ruleParserRule1504 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1546 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleParserRule1617 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleParserRule1647 = new BitSet(new long[]{0x000000C000010020L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleParserRule1686 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleParserRule1729 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleParserRule1769 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleParserRule1818 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleParserRule1838 = new BitSet(new long[]{0x000006C204008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1865 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleParserRule1890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleRuleNameAndParams1931 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleRuleNameAndParams1962 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleRuleNameAndParams2003 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_13_in_ruleRuleNameAndParams2046 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleRuleNameAndParams2088 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_27_in_ruleRuleNameAndParams2137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter2166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter2191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2259 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleTypeRef2289 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2353 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConditionalBranch_in_ruleAlternatives2373 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleAlternatives2416 = new BitSet(new long[]{0x000006C204008030L});
        public static final BitSet FOLLOW_ruleConditionalBranch_in_ruleAlternatives2453 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleConditionalBranch_in_entryRuleConditionalBranch2501 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConditionalBranch2504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleConditionalBranch2521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleConditionalBranch2565 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleDisjunction_in_ruleConditionalBranch2597 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleConditionalBranch2627 = new BitSet(new long[]{0x000006C200008030L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleConditionalBranch2659 = new BitSet(new long[]{0x000006C200008032L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup2698 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroup2701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup2718 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleUnorderedGroup2761 = new BitSet(new long[]{0x000006C200008030L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup2798 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2846 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup2849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2866 = new BitSet(new long[]{0x000006C200008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2917 = new BitSet(new long[]{0x000006C200008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2957 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality3017 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality3020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality3043 = new BitSet(new long[]{0x0000000180400002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality3067 = new BitSet(new long[]{0x0000000180400002L});
        public static final BitSet FOLLOW_31_in_ruleAbstractTokenWithCardinality3107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAbstractTokenWithCardinality3141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleAbstractTokenWithCardinality3175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3214 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction3217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleAction3236 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3263 = new BitSet(new long[]{0x0000002000020000L});
        public static final BitSet FOLLOW_17_in_ruleAction3294 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleAction3326 = new BitSet(new long[]{0x0000000C00000000L});
        public static final BitSet FOLLOW_34_in_ruleAction3380 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_35_in_ruleAction3418 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleAction3456 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleAction3476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3496 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedKeyword_in_ruleAbstractTerminal3576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedRuleCall_in_ruleAbstractTerminal3596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedGroup_in_ruleAbstractTerminal3616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword3636 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword3639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword3664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall3689 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall3692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleRuleCall3722 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleRuleCall3753 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_ruleRuleCall3785 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_13_in_ruleRuleCall3822 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_ruleRuleCall3859 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_27_in_ruleRuleCall3898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument3924 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument3927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedArgument3967 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleNamedArgument4012 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleDisjunction_in_ruleNamedArgument4058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralCondition_in_entryRuleLiteralCondition4089 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLiteralCondition4092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleLiteralCondition4145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleLiteralCondition4184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDisjunction_in_entryRuleDisjunction4209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDisjunction4212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConjunction_in_ruleDisjunction4229 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleDisjunction4265 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleConjunction_in_ruleDisjunction4297 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleConjunction_in_entryRuleConjunction4336 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConjunction4339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction4356 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleConjunction4392 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction4424 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation4463 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegation4466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_ruleNegation4483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleNegation4527 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleNegation_in_ruleNegation4559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom4597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom4600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterReference_in_ruleAtom4617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedCondition_in_ruleAtom4637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralCondition_in_ruleAtom4657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedCondition_in_entryRuleParenthesizedCondition4677 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCondition4680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedCondition4699 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleDisjunction_in_ruleParenthesizedCondition4711 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedCondition4725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterReference_in_entryRuleParameterReference4745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterReference4748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameterReference4773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRuleCall_in_entryRuleTerminalRuleCall4798 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRuleCall4801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleTerminalRuleCall4824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleID_in_entryRuleRuleID4849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleID4852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleRuleID4869 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleRuleID4889 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleRuleID4904 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID4930 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValidID4933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValidID4952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleValidID4974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleValidID4996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedKeyword_in_entryRulePredicatedKeyword5016 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedKeyword5019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rulePredicatedKeyword5059 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_42_in_rulePredicatedKeyword5113 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_rulePredicatedKeyword5158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedRuleCall_in_entryRulePredicatedRuleCall5189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedRuleCall5192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rulePredicatedRuleCall5232 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_42_in_rulePredicatedRuleCall5286 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePredicatedRuleCall5331 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_rulePredicatedRuleCall5362 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_rulePredicatedRuleCall5394 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_13_in_rulePredicatedRuleCall5431 = new BitSet(new long[]{0x000001C000008020L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_rulePredicatedRuleCall5468 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_27_in_rulePredicatedRuleCall5507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment5533 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment5536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleAssignment5576 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_42_in_ruleAssignment5630 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleAssignment5676 = new BitSet(new long[]{0x0000080C00000000L});
        public static final BitSet FOLLOW_35_in_ruleAssignment5722 = new BitSet(new long[]{0x000010C000008030L});
        public static final BitSet FOLLOW_34_in_ruleAssignment5756 = new BitSet(new long[]{0x000010C000008030L});
        public static final BitSet FOLLOW_43_in_ruleAssignment5790 = new BitSet(new long[]{0x000010C000008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment5835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal5866 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal5869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal5886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal5906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal5926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal5946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement5966 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement5969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement5988 = new BitSet(new long[]{0x000010C000008030L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement6000 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement6014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives6034 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives6037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives6054 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleAssignableAlternatives6097 = new BitSet(new long[]{0x000010C000008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives6134 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference6182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference6185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleCrossReference6204 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference6231 = new BitSet(new long[]{0x0000200020000000L});
        public static final BitSet FOLLOW_29_in_ruleCrossReference6262 = new BitSet(new long[]{0x000000C000000030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference6294 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleCrossReference6327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal6347 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal6350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal6367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal6387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement6407 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement6410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedElement6429 = new BitSet(new long[]{0x000006C204008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement6441 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedElement6455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedGroup_in_entryRulePredicatedGroup6475 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedGroup6478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rulePredicatedGroup6518 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_42_in_rulePredicatedGroup6572 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_rulePredicatedGroup6604 = new BitSet(new long[]{0x000006C204008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rulePredicatedGroup6631 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_rulePredicatedGroup6656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule6676 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule6679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleTerminalRule6698 = new BitSet(new long[]{0x000000C000200020L});
        public static final BitSet FOLLOW_21_in_ruleTerminalRule6742 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleTerminalRule6794 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleTerminalRule6865 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_23_in_ruleTerminalRule6908 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule6950 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleTerminalRule7000 = new BitSet(new long[]{0x000085C000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule7027 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleTerminalRule7052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives7072 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives7075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives7092 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives7135 = new BitSet(new long[]{0x000085C000028030L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives7172 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup7220 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup7223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup7240 = new BitSet(new long[]{0x000085C000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup7291 = new BitSet(new long[]{0x000085C000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken7331 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken7334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken7351 = new BitSet(new long[]{0x0000000180400002L});
        public static final BitSet FOLLOW_31_in_ruleTerminalToken7386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleTerminalToken7420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleTerminalToken7454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement7493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement7496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement7513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRuleCall_in_ruleTerminalTokenElement7533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement7553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement7573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement7593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOF_in_ruleTerminalTokenElement7613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement7633 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement7636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement7655 = new BitSet(new long[]{0x000085C000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement7667 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement7681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken7701 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken7704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken7721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken7741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken7761 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken7764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleNegatedToken7783 = new BitSet(new long[]{0x000085C000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken7810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken7841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken7844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleUntilToken7863 = new BitSet(new long[]{0x000085C000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken7890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard7921 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard7924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleWildcard7956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOF_in_entryRuleEOF7976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEOF7979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEOF8011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange8031 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange8034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange8051 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleCharacterRange8087 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange8119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule8158 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule8161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEnumRule8180 = new BitSet(new long[]{0x000000C000000020L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleEnumRule8207 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_23_in_ruleEnumRule8238 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleEnumRule8270 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleEnumRule8303 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule8330 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleEnumRule8355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals8375 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals8378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals8395 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleEnumLiterals8438 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals8475 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration8523 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration8526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration8558 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleEnumLiteralDeclaration8589 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration8621 = new BitSet(new long[]{0x0000000000000002L});
    }


}