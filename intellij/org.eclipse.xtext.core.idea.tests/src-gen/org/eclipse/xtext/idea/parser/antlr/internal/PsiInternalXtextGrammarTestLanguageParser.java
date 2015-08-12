package org.eclipse.xtext.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalXtextGrammarTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'fragment'", "'*'", "':'", "';'", "'['", "']'", "'returns'", "'::'", "'|'", "'&'", "'?'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'!'", "'?='", "'=>'", "'->'", "'terminal'", "'EOF'", "'..'", "'enum'"
    };
    public static final int RULE_ID=4;
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
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
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


        public PsiInternalXtextGrammarTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalXtextGrammarTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalXtextGrammarTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g"; }



    	protected XtextGrammarTestLanguageGrammarAccess grammarAccess;

    	protected XtextGrammarTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalXtextGrammarTestLanguageParser(PsiBuilder builder, TokenStream input, XtextGrammarTestLanguageElementTypeProvider elementTypeProvider, XtextGrammarTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:52:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:52:17: ( ruleGrammar EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:53:2: ruleGrammar EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:58:1: ruleGrammar : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ruleHiddenClause )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ ) ;
    public final void ruleGrammar() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:58:12: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ruleHiddenClause )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:59:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ruleHiddenClause )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:59:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ruleHiddenClause )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:60:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ruleHiddenClause )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+
            {

            			markLeaf(elementTypeProvider.getGrammar_GrammarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleGrammar76); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:67:3: ( (lv_name_1_0= ruleGrammarID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:68:4: (lv_name_1_0= ruleGrammarID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:68:4: (lv_name_1_0= ruleGrammarID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:69:5: lv_name_1_0= ruleGrammarID
            {

            					markComposite(elementTypeProvider.getGrammar_NameGrammarIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar103);
            ruleGrammarID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:78:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:79:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {

                    				markLeaf(elementTypeProvider.getGrammar_WithKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGrammar134); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:86:4: ( ( ruleGrammarID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:87:5: ( ruleGrammarID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:87:5: ( ruleGrammarID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:88:6: ruleGrammarID
                    {

                    						markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar164);
                    ruleGrammarID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:97:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:98:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getGrammar_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar201); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:105:5: ( ( ruleGrammarID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:106:6: ( ruleGrammarID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:106:6: ( ruleGrammarID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:107:7: ruleGrammarID
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:118:3: ( ruleHiddenClause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:119:4: ruleHiddenClause
                    {

                    				markComposite(elementTypeProvider.getGrammar_HiddenClauseParserRuleCall_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleHiddenClause_in_ruleGrammar282);
                    ruleHiddenClause();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:127:3: ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:128:4: (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:128:4: (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:129:5: lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar315);
            	    ruleAbstractMetamodelDeclaration();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:138:3: ( (lv_rules_8_0= ruleAbstractRule ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==21||LA5_0==42||LA5_0==45) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:139:4: (lv_rules_8_0= ruleAbstractRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:139:4: (lv_rules_8_0= ruleAbstractRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:140:5: lv_rules_8_0= ruleAbstractRule
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleGrammar354);
            	    ruleAbstractRule();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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


    // $ANTLR start "ruleHiddenClause"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:154:1: ruleHiddenClause : ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' ) ;
    public final void ruleHiddenClause() throws RecognitionException {
        Token lv_definesHiddenTokens_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:154:17: ( ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:155:2: ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:155:2: ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:156:3: ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:156:3: ( (lv_definesHiddenTokens_0_0= 'hidden' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:157:4: (lv_definesHiddenTokens_0_0= 'hidden' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:157:4: (lv_definesHiddenTokens_0_0= 'hidden' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:158:5: lv_definesHiddenTokens_0_0= 'hidden'
            {

            					markLeaf(elementTypeProvider.getHiddenClause_DefinesHiddenTokensHiddenKeyword_0_0ElementType());
            				
            lv_definesHiddenTokens_0_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleHiddenClause407); 

            					doneLeaf(lv_definesHiddenTokens_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getHiddenClause_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleHiddenClause432); 

            			doneLeaf(otherlv_1);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:174:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:175:4: ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:175:4: ( (otherlv_2= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:176:5: (otherlv_2= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:176:5: (otherlv_2= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:177:6: otherlv_2= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getHiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0ElementType());
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHiddenClause467); 

                    						doneLeaf(otherlv_2);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:186:4: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:187:5: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getHiddenClause_CommaKeyword_2_1_0ElementType());
                    	    				
                    	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleHiddenClause504); 

                    	    					doneLeaf(otherlv_3);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:194:5: ( (otherlv_4= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:195:6: (otherlv_4= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:195:6: (otherlv_4= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:196:7: otherlv_4= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getHiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0ElementType());
                    	    						
                    	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHiddenClause541); 

                    	    							doneLeaf(otherlv_4);
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getHiddenClause_RightParenthesisKeyword_3ElementType());
            		
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleHiddenClause583); 

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
        return ;
    }
    // $ANTLR end "ruleHiddenClause"


    // $ANTLR start "entryRuleGrammarID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:218:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:218:19: ( ruleGrammarID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:219:2: ruleGrammarID EOF
            {
             markComposite(elementTypeProvider.getGrammarIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID603);
            ruleGrammarID();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammarID606); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:224:1: ruleGrammarID : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleGrammarID() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:224:14: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:225:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:225:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:226:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getGrammarID_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID625); 

            			doneLeaf(this_ID_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:233:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:234:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getGrammarID_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGrammarID645); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getGrammarID_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID662); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:253:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:253:22: ( ruleAbstractRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:254:2: ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule688);
            ruleAbstractRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule691); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:259:1: ruleAbstractRule : ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) ;
    public final void ruleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:259:17: ( ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:260:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:260:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 21:
                {
                alt9=1;
                }
                break;
            case 42:
                {
                alt9=2;
                }
                break;
            case 45:
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:261:3: ruleParserRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_ruleAbstractRule708);
                    ruleParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:269:3: ruleTerminalRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_TerminalRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleAbstractRule728);
                    ruleTerminalRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:277:3: ruleEnumRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_EnumRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_ruleAbstractRule748);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:288:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:288:38: ( ruleAbstractMetamodelDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:289:2: ruleAbstractMetamodelDeclaration EOF
            {
             markComposite(elementTypeProvider.getAbstractMetamodelDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration768);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration771); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:294:1: ruleAbstractMetamodelDeclaration : ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:294:33: ( ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:295:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:295:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:296:3: ruleGeneratedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration788);
                    ruleGeneratedMetamodel();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:304:3: ruleReferencedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration808);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:315:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:315:28: ( ruleGeneratedMetamodel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:316:2: ruleGeneratedMetamodel EOF
            {
             markComposite(elementTypeProvider.getGeneratedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel828);
            ruleGeneratedMetamodel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGeneratedMetamodel831); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:321:1: ruleGeneratedMetamodel : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:321:23: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:322:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:322:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:323:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getGeneratedMetamodel_GenerateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGeneratedMetamodel850); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:330:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:331:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:331:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:332:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel877); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:341:3: ( (otherlv_2= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:342:4: (otherlv_2= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:342:4: (otherlv_2= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:343:5: otherlv_2= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel915); 

            					doneLeaf(otherlv_2);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:352:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:353:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getGeneratedMetamodel_AsKeyword_3_0ElementType());
                    			
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGeneratedMetamodel946); 

                    				doneLeaf(otherlv_3);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:360:4: ( (lv_alias_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:361:5: (lv_alias_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:361:5: (lv_alias_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:362:6: lv_alias_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType());
                    					
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel978); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:376:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:376:29: ( ruleReferencedMetamodel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:377:2: ruleReferencedMetamodel EOF
            {
             markComposite(elementTypeProvider.getReferencedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1017);
            ruleReferencedMetamodel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel1020); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:382:1: ruleReferencedMetamodel : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:382:24: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:383:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:383:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:384:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getReferencedMetamodel_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferencedMetamodel1039); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:391:3: ( (otherlv_1= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:392:4: (otherlv_1= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:392:4: (otherlv_1= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:393:5: otherlv_1= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1066); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:402:3: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:403:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getReferencedMetamodel_AsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferencedMetamodel1097); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:410:4: ( (lv_alias_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:411:5: (lv_alias_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:411:5: (lv_alias_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:412:6: lv_alias_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferencedMetamodel1129); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:426:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:426:20: ( ruleParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:427:2: ruleParserRule EOF
            {
             markComposite(elementTypeProvider.getParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule1168);
            ruleParserRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRule1171); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:432:1: ruleParserRule : ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) ) | ( ruleRuleNameAndParams ( ruleReturnsClause )? ) ) ( ruleHiddenClause )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' ) ;
    public final void ruleParserRule() throws RecognitionException {
        Token lv_fragment_0_0=null;
        Token lv_wildcard_2_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:432:15: ( ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) ) | ( ruleRuleNameAndParams ( ruleReturnsClause )? ) ) ( ruleHiddenClause )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:433:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) ) | ( ruleRuleNameAndParams ( ruleReturnsClause )? ) ) ( ruleHiddenClause )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:433:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) ) | ( ruleRuleNameAndParams ( ruleReturnsClause )? ) ) ( ruleHiddenClause )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:434:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) ) | ( ruleRuleNameAndParams ( ruleReturnsClause )? ) ) ( ruleHiddenClause )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:434:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) ) | ( ruleRuleNameAndParams ( ruleReturnsClause )? ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_ID) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:435:4: ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:435:4: ( ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:436:5: ( (lv_fragment_0_0= 'fragment' ) ) ruleRuleNameAndParams ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:436:5: ( (lv_fragment_0_0= 'fragment' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:437:6: (lv_fragment_0_0= 'fragment' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:437:6: (lv_fragment_0_0= 'fragment' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:438:7: lv_fragment_0_0= 'fragment'
                    {

                    							markLeaf(elementTypeProvider.getParserRule_FragmentFragmentKeyword_0_0_0_0ElementType());
                    						
                    lv_fragment_0_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRule1220); 

                    							doneLeaf(lv_fragment_0_0);
                    						

                    }


                    }


                    					markComposite(elementTypeProvider.getParserRule_RuleNameAndParamsParserRuleCall_0_0_1ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1253);
                    ruleRuleNameAndParams();

                    state._fsp--;


                    					doneComposite();
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:454:5: ( ( (lv_wildcard_2_0= '*' ) ) | ( ruleReturnsClause )? )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==22) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==14||LA14_0==23||LA14_0==27) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:455:6: ( (lv_wildcard_2_0= '*' ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:455:6: ( (lv_wildcard_2_0= '*' ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:456:7: (lv_wildcard_2_0= '*' )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:456:7: (lv_wildcard_2_0= '*' )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:457:8: lv_wildcard_2_0= '*'
                            {

                            								markLeaf(elementTypeProvider.getParserRule_WildcardAsteriskKeyword_0_0_2_0_0ElementType());
                            							
                            lv_wildcard_2_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRule1300); 

                            								doneLeaf(lv_wildcard_2_0);
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:467:6: ( ruleReturnsClause )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:467:6: ( ruleReturnsClause )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==27) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:468:7: ruleReturnsClause
                                    {

                                    							markComposite(elementTypeProvider.getParserRule_ReturnsClauseParserRuleCall_0_0_2_1ElementType());
                                    						
                                    pushFollow(FollowSets000.FOLLOW_ruleReturnsClause_in_ruleParserRule1358);
                                    ruleReturnsClause();

                                    state._fsp--;


                                    							doneComposite();
                                    						

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:479:4: ( ruleRuleNameAndParams ( ruleReturnsClause )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:479:4: ( ruleRuleNameAndParams ( ruleReturnsClause )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:480:5: ruleRuleNameAndParams ( ruleReturnsClause )?
                    {

                    					markComposite(elementTypeProvider.getParserRule_RuleNameAndParamsParserRuleCall_0_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1411);
                    ruleRuleNameAndParams();

                    state._fsp--;


                    					doneComposite();
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:487:5: ( ruleReturnsClause )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==27) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:488:6: ruleReturnsClause
                            {

                            						markComposite(elementTypeProvider.getParserRule_ReturnsClauseParserRuleCall_0_1_1ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleReturnsClause_in_ruleParserRule1437);
                            ruleReturnsClause();

                            state._fsp--;


                            						doneComposite();
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:498:3: ( ruleHiddenClause )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:499:4: ruleHiddenClause
                    {

                    				markComposite(elementTypeProvider.getParserRule_HiddenClauseParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleHiddenClause_in_ruleParserRule1474);
                    ruleHiddenClause();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getParserRule_ColonKeyword_2ElementType());
            		
            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRule1494); 

            			doneLeaf(otherlv_7);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:514:3: ( (lv_alternatives_8_0= ruleAlternatives ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:515:4: (lv_alternatives_8_0= ruleAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:515:4: (lv_alternatives_8_0= ruleAlternatives )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:516:5: lv_alternatives_8_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getParserRule_AlternativesAlternativesParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParserRule1521);
            ruleAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getParserRule_SemicolonKeyword_4ElementType());
            		
            otherlv_9=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleParserRule1546); 

            			doneLeaf(otherlv_9);
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:537:1: ruleRuleNameAndParams : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? ) ;
    public final void ruleRuleNameAndParams() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:537:22: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:538:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:538:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:539:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:539:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:540:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:540:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:541:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRuleNameAndParams_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleNameAndParams1587); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:550:3: (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:551:4: otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']'
                    {

                    				markLeaf(elementTypeProvider.getRuleNameAndParams_LeftSquareBracketKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleRuleNameAndParams1618); 

                    				doneLeaf(otherlv_1);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:558:4: ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_ID) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:559:5: ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:559:5: ( (lv_parameters_2_0= ruleParameter ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:560:6: (lv_parameters_2_0= ruleParameter )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:560:6: (lv_parameters_2_0= ruleParameter )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:561:7: lv_parameters_2_0= ruleParameter
                            {

                            							markComposite(elementTypeProvider.getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleRuleNameAndParams1659);
                            ruleParameter();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:570:5: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==13) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:571:6: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getRuleNameAndParams_CommaKeyword_1_1_1_0ElementType());
                            	    					
                            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRuleNameAndParams1702); 

                            	    						doneLeaf(otherlv_3);
                            	    					
                            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:578:6: ( (lv_parameters_4_0= ruleParameter ) )
                            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:579:7: (lv_parameters_4_0= ruleParameter )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:579:7: (lv_parameters_4_0= ruleParameter )
                            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:580:8: lv_parameters_4_0= ruleParameter
                            	    {

                            	    								markComposite(elementTypeProvider.getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0ElementType());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleRuleNameAndParams1744);
                            	    ruleParameter();

                            	    state._fsp--;


                            	    								doneComposite();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop18;
                                }
                            } while (true);


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getRuleNameAndParams_RightSquareBracketKeyword_1_2ElementType());
                    			
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRuleNameAndParams1793); 

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


    // $ANTLR start "ruleReturnsClause"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:604:1: ruleReturnsClause : (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) ) ;
    public final void ruleReturnsClause() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:604:18: ( (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:605:2: (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:605:2: (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:606:3: otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) )
            {

            			markLeaf(elementTypeProvider.getReturnsClause_ReturnsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleReturnsClause1827); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:613:3: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:614:4: (lv_type_1_0= ruleTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:614:4: (lv_type_1_0= ruleTypeRef )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:615:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getReturnsClause_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleReturnsClause1854);
            ruleTypeRef();

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
    // $ANTLR end "ruleReturnsClause"


    // $ANTLR start "entryRuleParameter"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:628:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:628:19: ( ruleParameter EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:629:2: ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter1885);
            ruleParameter();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter1888); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:634:1: ruleParameter : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleParameter() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:634:14: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:635:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:635:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:636:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:636:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:637:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getParameter_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter1913); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:649:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:649:17: ( ruleTypeRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:650:2: ruleTypeRef EOF
            {
             markComposite(elementTypeProvider.getTypeRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef1938);
            ruleTypeRef();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef1941); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:655:1: ruleTypeRef : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final void ruleTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:655:12: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:656:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:656:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:657:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:657:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==28) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:658:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:658:4: ( (otherlv_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:659:5: (otherlv_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:659:5: (otherlv_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:660:6: otherlv_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType());
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1981); 

                    						doneLeaf(otherlv_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getTypeRef_ColonColonKeyword_0_1ElementType());
                    			
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTypeRef2011); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:677:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:678:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:678:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:679:5: otherlv_2= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTypeRef_ClassifierEClassifierCrossReference_1_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef2044); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:692:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:692:22: ( ruleAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:693:2: ruleAlternatives EOF
            {
             markComposite(elementTypeProvider.getAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives2075);
            ruleAlternatives();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternatives2078); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:698:1: ruleAlternatives : ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) ;
    public final void ruleAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:698:17: ( ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:699:2: ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:699:2: ( ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:700:3: ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAlternatives_ConditionalBranchParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleConditionalBranch_in_ruleAlternatives2095);
            ruleConditionalBranch();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:707:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:708:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:708:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:709:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:714:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==29) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:715:5: otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAlternatives2138); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:722:5: ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:723:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:723:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:724:7: lv_elements_3_0= ruleConditionalBranch
                    	    {

                    	    							markComposite(elementTypeProvider.getAlternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleConditionalBranch_in_ruleAlternatives2175);
                    	    ruleConditionalBranch();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:739:1: entryRuleConditionalBranch : ruleConditionalBranch EOF ;
    public final void entryRuleConditionalBranch() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:739:27: ( ruleConditionalBranch EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:740:2: ruleConditionalBranch EOF
            {
             markComposite(elementTypeProvider.getConditionalBranchElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConditionalBranch_in_entryRuleConditionalBranch2223);
            ruleConditionalBranch();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConditionalBranch2226); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:745:1: ruleConditionalBranch : ( ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) ) ;
    public final void ruleConditionalBranch() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:745:22: ( ( ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:746:2: ( ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:746:2: ( ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==15||LA24_0==33||(LA24_0>=40 && LA24_0<=41)) ) {
                alt24=1;
            }
            else if ( (LA24_0==25) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:747:3: ruleUnorderedGroup
                    {

                    			markComposite(elementTypeProvider.getConditionalBranch_UnorderedGroupParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleConditionalBranch2243);
                    ruleUnorderedGroup();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:755:3: ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:755:3: ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:756:4: () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:756:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:757:5: 
                    {

                    					precedeComposite(elementTypeProvider.getConditionalBranch_ConditionalBranchAction_1_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getConditionalBranch_LeftSquareBracketKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleConditionalBranch2287); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:769:4: ( (lv_filtered_3_0= ruleInverseLiteralValue ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:770:5: (lv_filtered_3_0= ruleInverseLiteralValue )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:770:5: (lv_filtered_3_0= ruleInverseLiteralValue )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:771:6: lv_filtered_3_0= ruleInverseLiteralValue
                    {

                    						markComposite(elementTypeProvider.getConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleInverseLiteralValue_in_ruleConditionalBranch2319);
                    ruleInverseLiteralValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:780:4: ( (otherlv_4= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:781:5: (otherlv_4= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:781:5: (otherlv_4= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:782:6: otherlv_4= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getConditionalBranch_ParameterParameterCrossReference_1_3_0ElementType());
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConditionalBranch2364); 

                    						doneLeaf(otherlv_4);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getConditionalBranch_RightSquareBracketKeyword_1_4ElementType());
                    			
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleConditionalBranch2394); 

                    				doneLeaf(otherlv_5);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:798:4: ( (lv_guardedElement_6_0= ruleUnorderedGroup ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:799:5: (lv_guardedElement_6_0= ruleUnorderedGroup )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:799:5: (lv_guardedElement_6_0= ruleUnorderedGroup )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:800:6: lv_guardedElement_6_0= ruleUnorderedGroup
                    {

                    						markComposite(elementTypeProvider.getConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleConditionalBranch2426);
                    ruleUnorderedGroup();

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
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:814:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:814:24: ( ruleUnorderedGroup EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:815:2: ruleUnorderedGroup EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup2464);
            ruleUnorderedGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroup2467); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:820:1: ruleUnorderedGroup : ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:820:19: ( ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:821:2: ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:821:2: ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:822:3: ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getUnorderedGroup_GroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup2484);
            ruleGroup();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:829:3: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==30) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:830:4: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:830:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:831:5: 
                    {

                    					precedeComposite(elementTypeProvider.getUnorderedGroup_UnorderedGroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:836:4: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==30) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:837:5: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getUnorderedGroup_AmpersandKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleUnorderedGroup2527); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:844:5: ( (lv_elements_3_0= ruleGroup ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:845:6: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:845:6: (lv_elements_3_0= ruleGroup )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:846:7: lv_elements_3_0= ruleGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getUnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup2564);
                    	    ruleGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:861:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:861:15: ( ruleGroup EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:862:2: ruleGroup EOF
            {
             markComposite(elementTypeProvider.getGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup2612);
            ruleGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup2615); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:867:1: ruleGroup : ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final void ruleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:867:10: ( ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:868:2: ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:868:2: ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:869:3: ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getGroup_AbstractTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup2632);
            ruleAbstractToken();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:876:3: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_STRING)||LA28_0==15||LA28_0==33||(LA28_0>=40 && LA28_0<=41)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:877:4: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:877:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:878:5: 
                    {

                    					precedeComposite(elementTypeProvider.getGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:883:4: ( (lv_elements_2_0= ruleAbstractToken ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>=RULE_ID && LA27_0<=RULE_STRING)||LA27_0==15||LA27_0==33||(LA27_0>=40 && LA27_0<=41)) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:884:5: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:884:5: (lv_elements_2_0= ruleAbstractToken )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:885:6: lv_elements_2_0= ruleAbstractToken
                    	    {

                    	    						markComposite(elementTypeProvider.getGroup_ElementsAbstractTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup2683);
                    	    ruleAbstractToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:899:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:899:23: ( ruleAbstractToken EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:900:2: ruleAbstractToken EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2723);
            ruleAbstractToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken2726); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:905:1: ruleAbstractToken : ( ruleAbstractTokenWithCardinality | ruleAction ) ;
    public final void ruleAbstractToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:905:18: ( ( ruleAbstractTokenWithCardinality | ruleAction ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:906:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:906:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_STRING)||LA29_0==15||(LA29_0>=40 && LA29_0<=41)) ) {
                alt29=1;
            }
            else if ( (LA29_0==33) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:907:3: ruleAbstractTokenWithCardinality
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2743);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:915:3: ruleAction
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_ActionParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleAbstractToken2763);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:926:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:926:38: ( ruleAbstractTokenWithCardinality EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:927:2: ruleAbstractTokenWithCardinality EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenWithCardinalityElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2783);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2786); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:932:1: ruleAbstractTokenWithCardinality : ( ( ruleAssignment | ruleAbstractTerminal ) ( ruleCardinalities )? ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:932:33: ( ( ( ruleAssignment | ruleAbstractTerminal ) ( ruleCardinalities )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:933:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ruleCardinalities )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:933:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ruleCardinalities )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:934:3: ( ruleAssignment | ruleAbstractTerminal ) ( ruleCardinalities )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:934:3: ( ruleAssignment | ruleAbstractTerminal )
            int alt30=2;
            switch ( input.LA(1) ) {
            case 40:
                {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==RULE_STRING||LA30_1==15) ) {
                    alt30=2;
                }
                else if ( (LA30_1==RULE_ID) ) {
                    int LA30_5 = input.LA(3);

                    if ( (LA30_5==EOF||(LA30_5>=RULE_ID && LA30_5<=RULE_STRING)||(LA30_5>=15 && LA30_5<=16)||LA30_5==22||LA30_5==24||(LA30_5>=29 && LA30_5<=33)||(LA30_5>=40 && LA30_5<=41)) ) {
                        alt30=2;
                    }
                    else if ( ((LA30_5>=34 && LA30_5<=35)||LA30_5==39) ) {
                        alt30=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
                }
                break;
            case 41:
                {
                int LA30_2 = input.LA(2);

                if ( (LA30_2==RULE_STRING||LA30_2==15) ) {
                    alt30=2;
                }
                else if ( (LA30_2==RULE_ID) ) {
                    int LA30_5 = input.LA(3);

                    if ( (LA30_5==EOF||(LA30_5>=RULE_ID && LA30_5<=RULE_STRING)||(LA30_5>=15 && LA30_5<=16)||LA30_5==22||LA30_5==24||(LA30_5>=29 && LA30_5<=33)||(LA30_5>=40 && LA30_5<=41)) ) {
                        alt30=2;
                    }
                    else if ( ((LA30_5>=34 && LA30_5<=35)||LA30_5==39) ) {
                        alt30=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA30_3 = input.LA(2);

                if ( (LA30_3==EOF||(LA30_3>=RULE_ID && LA30_3<=RULE_STRING)||(LA30_3>=15 && LA30_3<=16)||LA30_3==22||(LA30_3>=24 && LA30_3<=25)||(LA30_3>=28 && LA30_3<=33)||(LA30_3>=40 && LA30_3<=41)) ) {
                    alt30=2;
                }
                else if ( ((LA30_3>=34 && LA30_3<=35)||LA30_3==39) ) {
                    alt30=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 15:
                {
                alt30=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:935:4: ruleAssignment
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2809);
                    ruleAssignment();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:943:4: ruleAbstractTerminal
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2833);
                    ruleAbstractTerminal();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:951:3: ( ruleCardinalities )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==22||(LA31_0>=31 && LA31_0<=32)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:952:4: ruleCardinalities
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_CardinalitiesParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleCardinalities_in_ruleAbstractTokenWithCardinality2856);
                    ruleCardinalities();

                    state._fsp--;


                    				doneComposite();
                    			

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


    // $ANTLR start "ruleCardinalities"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:965:1: ruleCardinalities : ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) ) ;
    public final void ruleCardinalities() throws RecognitionException {
        Token lv_cardinality_0_1=null;
        Token lv_cardinality_0_2=null;
        Token lv_cardinality_0_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:965:18: ( ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:966:2: ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:966:2: ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:967:3: ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:967:3: ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:968:4: (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:968:4: (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt32=1;
                }
                break;
            case 22:
                {
                alt32=2;
                }
                break;
            case 32:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:969:5: lv_cardinality_0_1= '?'
                    {

                    					markLeaf(elementTypeProvider.getCardinalities_CardinalityQuestionMarkKeyword_0_0ElementType());
                    				
                    lv_cardinality_0_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCardinalities2903); 

                    					doneLeaf(lv_cardinality_0_1);
                    				

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:977:5: lv_cardinality_0_2= '*'
                    {

                    					markLeaf(elementTypeProvider.getCardinalities_CardinalityAsteriskKeyword_0_1ElementType());
                    				
                    lv_cardinality_0_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCardinalities2933); 

                    					doneLeaf(lv_cardinality_0_2);
                    				

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:985:5: lv_cardinality_0_3= '+'
                    {

                    					markLeaf(elementTypeProvider.getCardinalities_CardinalityPlusSignKeyword_0_2ElementType());
                    				
                    lv_cardinality_0_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleCardinalities2963); 

                    					doneLeaf(lv_cardinality_0_3);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleCardinalities"


    // $ANTLR start "entryRuleAction"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:998:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:998:16: ( ruleAction EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:999:2: ruleAction EOF
            {
             markComposite(elementTypeProvider.getActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction2994);
            ruleAction();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction2997); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1004:1: ruleAction : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final void ruleAction() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1004:11: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1005:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1005:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1006:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getAction_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAction3016); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1013:3: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1014:4: (lv_type_1_0= ruleTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1014:4: (lv_type_1_0= ruleTypeRef )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1015:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getAction_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleAction3043);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1024:3: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==17) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1025:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {

                    				markLeaf(elementTypeProvider.getAction_FullStopKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAction3074); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1032:4: ( (lv_feature_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1033:5: (lv_feature_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1033:5: (lv_feature_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1034:6: lv_feature_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAction_FeatureIDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction3106); 

                    						doneLeaf(lv_feature_3_0);
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1043:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1044:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1044:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1045:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1045:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==34) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==35) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1046:7: lv_operator_4_1= '='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorEqualsSignKeyword_2_2_0_0ElementType());
                            						
                            lv_operator_4_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAction3160); 

                            							doneLeaf(lv_operator_4_1);
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1054:7: lv_operator_4_2= '+='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType());
                            						
                            lv_operator_4_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAction3198); 

                            							doneLeaf(lv_operator_4_2);
                            						

                            }
                            break;

                    }


                    }


                    }


                    				markLeaf(elementTypeProvider.getAction_CurrentKeyword_2_3ElementType());
                    			
                    otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleAction3236); 

                    				doneLeaf(otherlv_5);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getAction_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleAction3256); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1083:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1083:26: ( ruleAbstractTerminal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1084:2: ruleAbstractTerminal EOF
            {
             markComposite(elementTypeProvider.getAbstractTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3276);
            ruleAbstractTerminal();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal3279); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1089:1: ruleAbstractTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1089:21: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1090:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1090:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup )
            int alt35=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt35=1;
                }
                break;
            case RULE_ID:
                {
                alt35=2;
                }
                break;
            case 15:
                {
                alt35=3;
                }
                break;
            case 40:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt35=5;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt35=4;
                    }
                    break;
                case 15:
                    {
                    alt35=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 4, input);

                    throw nvae;
                }

                }
                break;
            case 41:
                {
                switch ( input.LA(2) ) {
                case 15:
                    {
                    alt35=6;
                    }
                    break;
                case RULE_ID:
                    {
                    alt35=5;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt35=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 5, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1091:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAbstractTerminal3296);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1099:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3316);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1107:3: ruleParenthesizedElement
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3336);
                    ruleParenthesizedElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1115:3: rulePredicatedKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedKeywordParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedKeyword_in_ruleAbstractTerminal3356);
                    rulePredicatedKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1123:3: rulePredicatedRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedRuleCallParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedRuleCall_in_ruleAbstractTerminal3376);
                    rulePredicatedRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1131:3: rulePredicatedGroup
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedGroupParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedGroup_in_ruleAbstractTerminal3396);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1142:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1142:17: ( ruleKeyword EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1143:2: ruleKeyword EOF
            {
             markComposite(elementTypeProvider.getKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword3416);
            ruleKeyword();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword3419); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1148:1: ruleKeyword : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final void ruleKeyword() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1148:12: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1149:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1149:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1150:3: (lv_value_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1150:3: (lv_value_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1151:4: lv_value_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getKeyword_ValueSTRINGTerminalRuleCall_0ElementType());
            			
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleKeyword3444); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1163:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1163:18: ( ruleRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1164:2: ruleRuleCall EOF
            {
             markComposite(elementTypeProvider.getRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall3469);
            ruleRuleCall();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall3472); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1169:1: ruleRuleCall : ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? ) ;
    public final void ruleRuleCall() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1169:13: ( ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1170:2: ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1170:2: ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1171:3: () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1171:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1172:4: 
            {

            				precedeComposite(elementTypeProvider.getRuleCall_RuleCallAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1177:3: ( ( ruleRuleID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1178:4: ( ruleRuleID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1178:4: ( ruleRuleID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1179:5: ruleRuleID
            {

            					markComposite(elementTypeProvider.getRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleRuleCall3515);
            ruleRuleID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1188:3: (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1189:4: otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']'
                    {

                    				markLeaf(elementTypeProvider.getRuleCall_LeftSquareBracketKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleRuleCall3546); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1196:4: ( (lv_arguments_3_0= ruleNamedArgument ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1197:5: (lv_arguments_3_0= ruleNamedArgument )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1197:5: (lv_arguments_3_0= ruleNamedArgument )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1198:6: lv_arguments_3_0= ruleNamedArgument
                    {

                    						markComposite(elementTypeProvider.getRuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_ruleRuleCall3578);
                    ruleNamedArgument();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1207:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==13) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1208:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getRuleCall_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRuleCall3615); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1215:5: ( (lv_arguments_5_0= ruleNamedArgument ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1216:6: (lv_arguments_5_0= ruleNamedArgument )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1216:6: (lv_arguments_5_0= ruleNamedArgument )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1217:7: lv_arguments_5_0= ruleNamedArgument
                    	    {

                    	    							markComposite(elementTypeProvider.getRuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_ruleRuleCall3652);
                    	    ruleNamedArgument();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    				markLeaf(elementTypeProvider.getRuleCall_RightSquareBracketKeyword_2_3ElementType());
                    			
                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRuleCall3691); 

                    				doneLeaf(otherlv_6);
                    			

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


    // $ANTLR start "entryRuleLiteralValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1239:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1239:22: ( ruleLiteralValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1240:2: ruleLiteralValue EOF
            {
             markComposite(elementTypeProvider.getLiteralValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue3717);
            ruleLiteralValue();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLiteralValue3720); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1245:1: ruleLiteralValue : (kw= '!' | kw= '+' ) ;
    public final void ruleLiteralValue() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1245:17: ( (kw= '!' | kw= '+' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1246:2: (kw= '!' | kw= '+' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1246:2: (kw= '!' | kw= '+' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==38) ) {
                alt38=1;
            }
            else if ( (LA38_0==32) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1247:3: kw= '!'
                    {

                    			markLeaf(elementTypeProvider.getLiteralValue_ExclamationMarkKeyword_0ElementType());
                    		
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLiteralValue3739); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1255:3: kw= '+'
                    {

                    			markLeaf(elementTypeProvider.getLiteralValue_PlusSignKeyword_1ElementType());
                    		
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLiteralValue3761); 

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
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleInverseLiteralValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1266:1: entryRuleInverseLiteralValue : ruleInverseLiteralValue EOF ;
    public final void entryRuleInverseLiteralValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1266:29: ( ruleInverseLiteralValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1267:2: ruleInverseLiteralValue EOF
            {
             markComposite(elementTypeProvider.getInverseLiteralValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleInverseLiteralValue_in_entryRuleInverseLiteralValue3781);
            ruleInverseLiteralValue();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInverseLiteralValue3784); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInverseLiteralValue"


    // $ANTLR start "ruleInverseLiteralValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1272:1: ruleInverseLiteralValue : ruleLiteralValue ;
    public final void ruleInverseLiteralValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1272:24: ( ruleLiteralValue )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1273:2: ruleLiteralValue
            {

            		markComposite(elementTypeProvider.getInverseLiteralValue_LiteralValueParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleLiteralValue_in_ruleInverseLiteralValue3796);
            ruleLiteralValue();

            state._fsp--;


            		doneComposite();
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleInverseLiteralValue"


    // $ANTLR start "entryRuleNamedArgument"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1283:1: entryRuleNamedArgument : ruleNamedArgument EOF ;
    public final void entryRuleNamedArgument() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1283:23: ( ruleNamedArgument EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1284:2: ruleNamedArgument EOF
            {
             markComposite(elementTypeProvider.getNamedArgumentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument3812);
            ruleNamedArgument();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedArgument3815); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1289:1: ruleNamedArgument : ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) ) ;
    public final void ruleNamedArgument() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1289:18: ( ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1290:2: ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1290:2: ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1291:3: () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1291:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1292:4: 
            {

            				precedeComposite(elementTypeProvider.getNamedArgument_NamedArgumentAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1297:3: ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==32||LA40_0==38) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==EOF||LA40_2==13||LA40_2==26) ) {
                    alt40=1;
                }
                else if ( (LA40_2==34) ) {
                    alt40=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1298:4: ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1298:4: ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1299:5: ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1299:5: ( (lv_literalValue_1_0= ruleLiteralValue ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==32||LA39_0==38) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1300:6: (lv_literalValue_1_0= ruleLiteralValue )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1300:6: (lv_literalValue_1_0= ruleLiteralValue )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1301:7: lv_literalValue_1_0= ruleLiteralValue
                            {

                            							markComposite(elementTypeProvider.getNamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleLiteralValue_in_ruleNamedArgument3877);
                            ruleLiteralValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1310:5: ( (otherlv_2= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1311:6: (otherlv_2= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1311:6: (otherlv_2= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1312:7: otherlv_2= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getNamedArgument_ParameterParameterCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedArgument3930); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1323:4: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1323:4: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1324:5: ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1324:5: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1325:6: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1325:6: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1326:7: otherlv_3= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getNamedArgument_ParameterParameterCrossReference_1_1_0_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedArgument4001); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getNamedArgument_EqualsSignKeyword_1_1_1ElementType());
                    				
                    otherlv_4=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleNamedArgument4036); 

                    					doneLeaf(otherlv_4);
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1342:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1343:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1343:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1344:7: otherlv_5= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getNamedArgument_ValueParameterCrossReference_1_1_2_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedArgument4073); 

                    							doneLeaf(otherlv_5);
                    						

                    }


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
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1359:1: entryRuleTerminalRuleCall : ruleTerminalRuleCall EOF ;
    public final void entryRuleTerminalRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1359:26: ( ruleTerminalRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1360:2: ruleTerminalRuleCall EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRuleCall_in_entryRuleTerminalRuleCall4119);
            ruleTerminalRuleCall();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRuleCall4122); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1365:1: ruleTerminalRuleCall : ( ( ruleRuleID ) ) ;
    public final void ruleTerminalRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1365:21: ( ( ( ruleRuleID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1366:2: ( ( ruleRuleID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1366:2: ( ( ruleRuleID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1367:3: ( ruleRuleID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1367:3: ( ruleRuleID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1368:4: ruleRuleID
            {

            				markComposite(elementTypeProvider.getTerminalRuleCall_RuleAbstractRuleCrossReference_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_ruleTerminalRuleCall4145);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1380:1: entryRuleRuleID : ruleRuleID EOF ;
    public final void entryRuleRuleID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1380:16: ( ruleRuleID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1381:2: ruleRuleID EOF
            {
             markComposite(elementTypeProvider.getRuleIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleID_in_entryRuleRuleID4170);
            ruleRuleID();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleID4173); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1386:1: ruleRuleID : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) ;
    public final void ruleRuleID() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1386:11: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1387:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1387:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1388:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getRuleID_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleID4192); 

            			doneLeaf(this_ID_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1395:3: (kw= '::' this_ID_2= RULE_ID )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==28) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1396:4: kw= '::' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getRuleID_ColonColonKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRuleID4212); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getRuleID_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleID4229); 

            	    				doneLeaf(this_ID_2);
            	    			

            	    }
            	    break;

            	default :
            	    break loop41;
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


    // $ANTLR start "entryRulePredicatedKeyword"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1415:1: entryRulePredicatedKeyword : rulePredicatedKeyword EOF ;
    public final void entryRulePredicatedKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1415:27: ( rulePredicatedKeyword EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1416:2: rulePredicatedKeyword EOF
            {
             markComposite(elementTypeProvider.getPredicatedKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedKeyword_in_entryRulePredicatedKeyword4255);
            rulePredicatedKeyword();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedKeyword4258); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1421:1: rulePredicatedKeyword : ( rulePredicate ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final void rulePredicatedKeyword() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1421:22: ( ( rulePredicate ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1422:2: ( rulePredicate ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1422:2: ( rulePredicate ( (lv_value_1_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1423:3: rulePredicate ( (lv_value_1_0= RULE_STRING ) )
            {

            			markComposite(elementTypeProvider.getPredicatedKeyword_PredicateParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePredicate_in_rulePredicatedKeyword4275);
            rulePredicate();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1430:3: ( (lv_value_1_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1431:4: (lv_value_1_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1431:4: (lv_value_1_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1432:5: lv_value_1_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getPredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0ElementType());
            				
            lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rulePredicatedKeyword4302); 

            					doneLeaf(lv_value_1_0);
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1445:1: entryRulePredicatedRuleCall : rulePredicatedRuleCall EOF ;
    public final void entryRulePredicatedRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1445:28: ( rulePredicatedRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1446:2: rulePredicatedRuleCall EOF
            {
             markComposite(elementTypeProvider.getPredicatedRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedRuleCall_in_entryRulePredicatedRuleCall4333);
            rulePredicatedRuleCall();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedRuleCall4336); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1451:1: rulePredicatedRuleCall : ( rulePredicate ( (otherlv_1= RULE_ID ) ) ) ;
    public final void rulePredicatedRuleCall() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1451:23: ( ( rulePredicate ( (otherlv_1= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1452:2: ( rulePredicate ( (otherlv_1= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1452:2: ( rulePredicate ( (otherlv_1= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1453:3: rulePredicate ( (otherlv_1= RULE_ID ) )
            {

            			markComposite(elementTypeProvider.getPredicatedRuleCall_PredicateParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePredicate_in_rulePredicatedRuleCall4353);
            rulePredicate();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1460:3: ( (otherlv_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1461:4: (otherlv_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1461:4: (otherlv_1= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1462:5: otherlv_1= RULE_ID
            {

            					markLeaf(elementTypeProvider.getPredicatedRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePredicatedRuleCall4380); 

            					doneLeaf(otherlv_1);
            				

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
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1475:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1475:20: ( ruleAssignment EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1476:2: ruleAssignment EOF
            {
             markComposite(elementTypeProvider.getAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment4411);
            ruleAssignment();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment4414); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1481:1: ruleAssignment : ( ( rulePredicate )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) ) ;
    public final void ruleAssignment() throws RecognitionException {
        Token lv_feature_1_0=null;
        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1481:15: ( ( ( rulePredicate )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1482:2: ( ( rulePredicate )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1482:2: ( ( rulePredicate )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1483:3: ( rulePredicate )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1483:3: ( rulePredicate )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=40 && LA42_0<=41)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1484:4: rulePredicate
                    {

                    				markComposite(elementTypeProvider.getAssignment_PredicateParserRuleCall_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_rulePredicate_in_ruleAssignment4437);
                    rulePredicate();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1492:3: ( (lv_feature_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1493:4: (lv_feature_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1493:4: (lv_feature_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1494:5: lv_feature_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignment_FeatureIDTerminalRuleCall_1_0ElementType());
            				
            lv_feature_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment4470); 

            					doneLeaf(lv_feature_1_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1503:3: ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1504:4: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1504:4: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1505:5: (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1505:5: (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt43=1;
                }
                break;
            case 34:
                {
                alt43=2;
                }
                break;
            case 39:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1506:6: lv_operator_2_1= '+='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorPlusSignEqualsSignKeyword_2_0_0ElementType());
                    					
                    lv_operator_2_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAssignment4516); 

                    						doneLeaf(lv_operator_2_1);
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1514:6: lv_operator_2_2= '='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorEqualsSignKeyword_2_0_1ElementType());
                    					
                    lv_operator_2_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAssignment4550); 

                    						doneLeaf(lv_operator_2_2);
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1522:6: lv_operator_2_3= '?='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2ElementType());
                    					
                    lv_operator_2_3=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAssignment4584); 

                    						doneLeaf(lv_operator_2_3);
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1532:3: ( (lv_terminal_3_0= ruleAssignableTerminal ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1533:4: (lv_terminal_3_0= ruleAssignableTerminal )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1533:4: (lv_terminal_3_0= ruleAssignableTerminal )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1534:5: lv_terminal_3_0= ruleAssignableTerminal
            {

            					markComposite(elementTypeProvider.getAssignment_TerminalAssignableTerminalParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignment4629);
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


    // $ANTLR start "rulePredicate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1548:1: rulePredicate : ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ;
    public final void rulePredicate() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1548:14: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1549:2: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1549:2: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==40) ) {
                alt44=1;
            }
            else if ( (LA44_0==41) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1550:3: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1550:3: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1551:4: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1551:4: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1552:5: lv_predicated_0_0= '=>'
                    {

                    					markLeaf(elementTypeProvider.getPredicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0ElementType());
                    				
                    lv_predicated_0_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_rulePredicate4681); 

                    					doneLeaf(lv_predicated_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1562:3: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1562:3: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1563:4: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1563:4: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1564:5: lv_firstSetPredicated_1_0= '->'
                    {

                    					markLeaf(elementTypeProvider.getPredicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0ElementType());
                    				
                    lv_firstSetPredicated_1_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_rulePredicate4727); 

                    					doneLeaf(lv_firstSetPredicated_1_0);
                    				

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
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleAssignableTerminal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1577:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1577:28: ( ruleAssignableTerminal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1578:2: ruleAssignableTerminal EOF
            {
             markComposite(elementTypeProvider.getAssignableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal4758);
            ruleAssignableTerminal();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal4761); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1583:1: ruleAssignableTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1583:23: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1584:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1584:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            int alt45=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt45=1;
                }
                break;
            case RULE_ID:
                {
                alt45=2;
                }
                break;
            case 15:
                {
                alt45=3;
                }
                break;
            case 25:
                {
                alt45=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1585:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAssignableTerminal4778);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1593:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAssignableTerminal4798);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1601:3: ruleParenthesizedAssignableElement
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal4818);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1609:3: ruleCrossReference
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_CrossReferenceParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_ruleAssignableTerminal4838);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1620:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1620:40: ( ruleParenthesizedAssignableElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1621:2: ruleParenthesizedAssignableElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedAssignableElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement4858);
            ruleParenthesizedAssignableElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement4861); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1626:1: ruleParenthesizedAssignableElement : (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1626:35: ( (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1627:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1627:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1628:3: otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedAssignableElement4880); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement4892);
            ruleAssignableAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedAssignableElement4906); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1653:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1653:32: ( ruleAssignableAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1654:2: ruleAssignableAlternatives EOF
            {
             markComposite(elementTypeProvider.getAssignableAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives4926);
            ruleAssignableAlternatives();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives4929); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1659:1: ruleAssignableAlternatives : ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1659:27: ( ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1660:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1660:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1661:3: ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives4946);
            ruleAssignableTerminal();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1668:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==29) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1669:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1669:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1670:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAssignableAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1675:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==29) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1676:5: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAssignableAlternatives4989); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1683:5: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1684:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1684:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1685:7: lv_elements_3_0= ruleAssignableTerminal
                    	    {

                    	    							markComposite(elementTypeProvider.getAssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives5026);
                    	    ruleAssignableTerminal();

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
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1700:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1700:24: ( ruleCrossReference EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1701:2: ruleCrossReference EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference5074);
            ruleCrossReference();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference5077); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1706:1: ruleCrossReference : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final void ruleCrossReference() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1706:19: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1707:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1707:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1708:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {

            			markLeaf(elementTypeProvider.getCrossReference_LeftSquareBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleCrossReference5096); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1715:3: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1716:4: (lv_type_1_0= ruleTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1716:4: (lv_type_1_0= ruleTypeRef )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1717:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleCrossReference5123);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1726:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==29) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1727:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {

                    				markLeaf(elementTypeProvider.getCrossReference_VerticalLineKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCrossReference5154); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1734:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1735:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1735:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1736:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						markComposite(elementTypeProvider.getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference5186);
                    ruleCrossReferenceableTerminal();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getCrossReference_RightSquareBracketKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCrossReference5219); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1757:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1757:36: ( ruleCrossReferenceableTerminal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1758:2: ruleCrossReferenceableTerminal EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal5239);
            ruleCrossReferenceableTerminal();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal5242); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1763:1: ruleCrossReferenceableTerminal : ( ruleKeyword | ruleRuleCall ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1763:31: ( ( ruleKeyword | ruleRuleCall ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1764:2: ( ruleKeyword | ruleRuleCall )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1764:2: ( ruleKeyword | ruleRuleCall )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_STRING) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_ID) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1765:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal5259);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1773:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal5279);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1784:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1784:30: ( ruleParenthesizedElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1785:2: ruleParenthesizedElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement5299);
            ruleParenthesizedElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement5302); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1790:1: ruleParenthesizedElement : (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1790:25: ( (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1791:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1791:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1792:3: otherlv_0= '(' ruleAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedElement5321); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedElement_AlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParenthesizedElement5333);
            ruleAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedElement_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedElement5347); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1817:1: entryRulePredicatedGroup : rulePredicatedGroup EOF ;
    public final void entryRulePredicatedGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1817:25: ( rulePredicatedGroup EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1818:2: rulePredicatedGroup EOF
            {
             markComposite(elementTypeProvider.getPredicatedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedGroup_in_entryRulePredicatedGroup5367);
            rulePredicatedGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedGroup5370); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1823:1: rulePredicatedGroup : ( rulePredicate otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' ) ;
    public final void rulePredicatedGroup() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1823:20: ( ( rulePredicate otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1824:2: ( rulePredicate otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1824:2: ( rulePredicate otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1825:3: rulePredicate otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')'
            {

            			markComposite(elementTypeProvider.getPredicatedGroup_PredicateParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePredicate_in_rulePredicatedGroup5387);
            rulePredicate();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getPredicatedGroup_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePredicatedGroup5401); 

            			doneLeaf(otherlv_1);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1839:3: ( (lv_elements_2_0= ruleAlternatives ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1840:4: (lv_elements_2_0= ruleAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1840:4: (lv_elements_2_0= ruleAlternatives )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1841:5: lv_elements_2_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getPredicatedGroup_ElementsAlternativesParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rulePredicatedGroup5428);
            ruleAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getPredicatedGroup_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePredicatedGroup5453); 

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
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1861:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1861:22: ( ruleTerminalRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1862:2: ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule5473);
            ruleTerminalRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule5476); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1867:1: ruleTerminalRule : (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' ) ;
    public final void ruleTerminalRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_fragment_1_0=null;
        Token lv_name_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1867:17: ( (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1868:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1868:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1869:3: otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';'
            {

            			markLeaf(elementTypeProvider.getTerminalRule_TerminalKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleTerminalRule5495); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1876:3: ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==21) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_ID) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1877:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1877:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1878:5: ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1878:5: ( (lv_fragment_1_0= 'fragment' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1879:6: (lv_fragment_1_0= 'fragment' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1879:6: (lv_fragment_1_0= 'fragment' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1880:7: lv_fragment_1_0= 'fragment'
                    {

                    							markLeaf(elementTypeProvider.getTerminalRule_FragmentFragmentKeyword_1_0_0_0ElementType());
                    						
                    lv_fragment_1_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTerminalRule5539); 

                    							doneLeaf(lv_fragment_1_0);
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1889:5: ( (lv_name_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1890:6: (lv_name_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1890:6: (lv_name_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1891:7: lv_name_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule5591); 

                    							doneLeaf(lv_name_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1902:4: ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1902:4: ( ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1903:5: ( (lv_name_3_0= RULE_ID ) ) ( ruleReturnsClause )?
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1903:5: ( (lv_name_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1904:6: (lv_name_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1904:6: (lv_name_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1905:7: lv_name_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_1_0_0ElementType());
                    						
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule5662); 

                    							doneLeaf(lv_name_3_0);
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1914:5: ( ruleReturnsClause )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==27) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1915:6: ruleReturnsClause
                            {

                            						markComposite(elementTypeProvider.getTerminalRule_ReturnsClauseParserRuleCall_1_1_1ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleReturnsClause_in_ruleTerminalRule5703);
                            ruleReturnsClause();

                            state._fsp--;


                            						doneComposite();
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getTerminalRule_ColonKeyword_2ElementType());
            		
            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTerminalRule5736); 

            			doneLeaf(otherlv_5);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1932:3: ( (lv_alternatives_6_0= ruleTerminalAlternatives ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1933:4: (lv_alternatives_6_0= ruleTerminalAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1933:4: (lv_alternatives_6_0= ruleTerminalAlternatives )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1934:5: lv_alternatives_6_0= ruleTerminalAlternatives
            {

            					markComposite(elementTypeProvider.getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule5763);
            ruleTerminalAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getTerminalRule_SemicolonKeyword_4ElementType());
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTerminalRule5788); 

            			doneLeaf(otherlv_7);
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1954:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1954:30: ( ruleTerminalAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1955:2: ruleTerminalAlternatives EOF
            {
             markComposite(elementTypeProvider.getTerminalAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives5808);
            ruleTerminalAlternatives();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives5811); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1960:1: ruleTerminalAlternatives : ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1960:25: ( ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1961:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1961:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1962:3: ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives5828);
            ruleTerminalGroup();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1969:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==29) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1970:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1970:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1971:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1976:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==29) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1977:5: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTerminalAlternatives5871); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1984:5: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1985:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1985:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:1986:7: lv_elements_3_0= ruleTerminalGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getTerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives5908);
                    	    ruleTerminalGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2001:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2001:23: ( ruleTerminalGroup EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2002:2: ruleTerminalGroup EOF
            {
             markComposite(elementTypeProvider.getTerminalGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup5956);
            ruleTerminalGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup5959); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2007:1: ruleTerminalGroup : ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final void ruleTerminalGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2007:18: ( ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2008:2: ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2008:2: ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2009:3: ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalGroup_TerminalTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup5976);
            ruleTerminalToken();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2016:3: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_STRING)||LA55_0==15||LA55_0==17||LA55_0==38||LA55_0==41||LA55_0==43) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2017:4: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2017:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2018:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2023:4: ( (lv_elements_2_0= ruleTerminalToken ) )+
                    int cnt54=0;
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( ((LA54_0>=RULE_ID && LA54_0<=RULE_STRING)||LA54_0==15||LA54_0==17||LA54_0==38||LA54_0==41||LA54_0==43) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2024:5: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2024:5: (lv_elements_2_0= ruleTerminalToken )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2025:6: lv_elements_2_0= ruleTerminalToken
                    	    {

                    	    						markComposite(elementTypeProvider.getTerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup6027);
                    	    ruleTerminalToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt54 >= 1 ) break loop54;
                                EarlyExitException eee =
                                    new EarlyExitException(54, input);
                                throw eee;
                        }
                        cnt54++;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2039:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2039:23: ( ruleTerminalToken EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2040:2: ruleTerminalToken EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken6067);
            ruleTerminalToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken6070); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2045:1: ruleTerminalToken : ( ruleTerminalTokenElement ( ruleCardinalities )? ) ;
    public final void ruleTerminalToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2045:18: ( ( ruleTerminalTokenElement ( ruleCardinalities )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2046:2: ( ruleTerminalTokenElement ( ruleCardinalities )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2046:2: ( ruleTerminalTokenElement ( ruleCardinalities )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2047:3: ruleTerminalTokenElement ( ruleCardinalities )?
            {

            			markComposite(elementTypeProvider.getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken6087);
            ruleTerminalTokenElement();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2054:3: ( ruleCardinalities )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==22||(LA56_0>=31 && LA56_0<=32)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2055:4: ruleCardinalities
                    {

                    				markComposite(elementTypeProvider.getTerminalToken_CardinalitiesParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleCardinalities_in_ruleTerminalToken6105);
                    ruleCardinalities();

                    state._fsp--;


                    				doneComposite();
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2067:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2067:30: ( ruleTerminalTokenElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2068:2: ruleTerminalTokenElement EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement6131);
            ruleTerminalTokenElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement6134); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2073:1: ruleTerminalTokenElement : ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2073:25: ( ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2074:2: ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2074:2: ( ruleCharacterRange | ruleTerminalRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF )
            int alt57=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt57=1;
                }
                break;
            case RULE_ID:
                {
                alt57=2;
                }
                break;
            case 15:
                {
                alt57=3;
                }
                break;
            case 38:
            case 41:
                {
                alt57=4;
                }
                break;
            case 17:
                {
                alt57=5;
                }
                break;
            case 43:
                {
                alt57=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2075:3: ruleCharacterRange
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement6151);
                    ruleCharacterRange();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2083:3: ruleTerminalRuleCall
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_TerminalRuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRuleCall_in_ruleTerminalTokenElement6171);
                    ruleTerminalRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2091:3: ruleParenthesizedTerminalElement
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement6191);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2099:3: ruleAbstractNegatedToken
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement6211);
                    ruleAbstractNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2107:3: ruleWildcard
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_WildcardParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_ruleTerminalTokenElement6231);
                    ruleWildcard();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2115:3: ruleEOF
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_EOFParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEOF_in_ruleTerminalTokenElement6251);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2126:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2126:38: ( ruleParenthesizedTerminalElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2127:2: ruleParenthesizedTerminalElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedTerminalElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement6271);
            ruleParenthesizedTerminalElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement6274); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2132:1: ruleParenthesizedTerminalElement : (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2132:33: ( (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2133:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2133:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2134:3: otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedTerminalElement6293); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement6305);
            ruleTerminalAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedTerminalElement6319); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2159:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2159:30: ( ruleAbstractNegatedToken EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2160:2: ruleAbstractNegatedToken EOF
            {
             markComposite(elementTypeProvider.getAbstractNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken6339);
            ruleAbstractNegatedToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken6342); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2165:1: ruleAbstractNegatedToken : ( ruleNegatedToken | ruleUntilToken ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2165:25: ( ( ruleNegatedToken | ruleUntilToken ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2166:2: ( ruleNegatedToken | ruleUntilToken )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2166:2: ( ruleNegatedToken | ruleUntilToken )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==38) ) {
                alt58=1;
            }
            else if ( (LA58_0==41) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2167:3: ruleNegatedToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken6359);
                    ruleNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2175:3: ruleUntilToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken6379);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2186:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2186:22: ( ruleNegatedToken EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2187:2: ruleNegatedToken EOF
            {
             markComposite(elementTypeProvider.getNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken6399);
            ruleNegatedToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken6402); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2192:1: ruleNegatedToken : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2192:17: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2193:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2193:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2194:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getNegatedToken_ExclamationMarkKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleNegatedToken6421); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2201:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2202:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2202:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2203:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken6448);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2216:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2216:20: ( ruleUntilToken EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2217:2: ruleUntilToken EOF
            {
             markComposite(elementTypeProvider.getUntilTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken6479);
            ruleUntilToken();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken6482); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2222:1: ruleUntilToken : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleUntilToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2222:15: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2223:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2223:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2224:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleUntilToken6501); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2231:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2232:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2232:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2233:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken6528);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2246:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2246:18: ( ruleWildcard EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2247:2: ruleWildcard EOF
            {
             markComposite(elementTypeProvider.getWildcardElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard6559);
            ruleWildcard();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard6562); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2252:1: ruleWildcard : ( () otherlv_1= '.' ) ;
    public final void ruleWildcard() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2252:13: ( ( () otherlv_1= '.' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2253:2: ( () otherlv_1= '.' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2253:2: ( () otherlv_1= '.' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2254:3: () otherlv_1= '.'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2254:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2255:4: 
            {

            				precedeComposite(elementTypeProvider.getWildcard_WildcardAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getWildcard_FullStopKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleWildcard6594); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2271:1: entryRuleEOF : ruleEOF EOF ;
    public final void entryRuleEOF() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2271:13: ( ruleEOF EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2272:2: ruleEOF EOF
            {
             markComposite(elementTypeProvider.getEOFElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOF_in_entryRuleEOF6614);
            ruleEOF();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEOF6617); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2277:1: ruleEOF : ( () otherlv_1= 'EOF' ) ;
    public final void ruleEOF() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2277:8: ( ( () otherlv_1= 'EOF' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2278:2: ( () otherlv_1= 'EOF' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2278:2: ( () otherlv_1= 'EOF' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2279:3: () otherlv_1= 'EOF'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2279:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2280:4: 
            {

            				precedeComposite(elementTypeProvider.getEOF_EOFAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getEOF_EOFKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEOF6649); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2296:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2296:24: ( ruleCharacterRange EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2297:2: ruleCharacterRange EOF
            {
             markComposite(elementTypeProvider.getCharacterRangeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange6669);
            ruleCharacterRange();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange6672); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2302:1: ruleCharacterRange : ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final void ruleCharacterRange() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2302:19: ( ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2303:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2303:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2304:3: ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			markComposite(elementTypeProvider.getCharacterRange_KeywordParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange6689);
            ruleKeyword();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2311:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==44) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2312:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2312:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2313:5: 
                    {

                    					precedeComposite(elementTypeProvider.getCharacterRange_CharacterRangeLeftAction_1_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getCharacterRange_FullStopFullStopKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCharacterRange6725); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2325:4: ( (lv_right_3_0= ruleKeyword ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2326:5: (lv_right_3_0= ruleKeyword )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2326:5: (lv_right_3_0= ruleKeyword )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2327:6: lv_right_3_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange6757);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2341:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2341:18: ( ruleEnumRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2342:2: ruleEnumRule EOF
            {
             markComposite(elementTypeProvider.getEnumRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule6796);
            ruleEnumRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule6799); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2347:1: ruleEnumRule : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( ruleReturnsClause )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' ) ;
    public final void ruleEnumRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2347:13: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( ruleReturnsClause )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2348:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( ruleReturnsClause )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2348:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( ruleReturnsClause )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2349:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( ruleReturnsClause )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';'
            {

            			markLeaf(elementTypeProvider.getEnumRule_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEnumRule6818); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2356:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2357:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2357:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2358:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumRule_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumRule6845); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2367:3: ( ruleReturnsClause )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==27) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2368:4: ruleReturnsClause
                    {

                    				markComposite(elementTypeProvider.getEnumRule_ReturnsClauseParserRuleCall_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleReturnsClause_in_ruleEnumRule6874);
                    ruleReturnsClause();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getEnumRule_ColonKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumRule6894); 

            			doneLeaf(otherlv_3);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2383:3: ( (lv_alternatives_4_0= ruleEnumLiterals ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2384:4: (lv_alternatives_4_0= ruleEnumLiterals )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2384:4: (lv_alternatives_4_0= ruleEnumLiterals )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2385:5: lv_alternatives_4_0= ruleEnumLiterals
            {

            					markComposite(elementTypeProvider.getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_ruleEnumRule6921);
            ruleEnumLiterals();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getEnumRule_SemicolonKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEnumRule6946); 

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
        return ;
    }
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2405:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2405:22: ( ruleEnumLiterals EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2406:2: ruleEnumLiterals EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals6966);
            ruleEnumLiterals();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals6969); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2411:1: ruleEnumLiterals : ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final void ruleEnumLiterals() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2411:17: ( ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2412:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2412:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2413:3: ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6986);
            ruleEnumLiteralDeclaration();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2420:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==29) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2421:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2421:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2422:5: 
                    {

                    					precedeComposite(elementTypeProvider.getEnumLiterals_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2427:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    int cnt61=0;
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==29) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2428:5: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getEnumLiterals_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEnumLiterals7029); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2435:5: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2436:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2436:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2437:7: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							markComposite(elementTypeProvider.getEnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals7066);
                    	    ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt61 >= 1 ) break loop61;
                                EarlyExitException eee =
                                    new EarlyExitException(61, input);
                                throw eee;
                        }
                        cnt61++;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2452:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2452:32: ( ruleEnumLiteralDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2453:2: ruleEnumLiteralDeclaration EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration7114);
            ruleEnumLiteralDeclaration();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration7117); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2458:1: ruleEnumLiteralDeclaration : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2458:27: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2459:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2459:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2460:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2460:3: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2461:4: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2461:4: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2462:5: otherlv_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration7149); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2471:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==34) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2472:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEnumLiteralDeclaration7180); 

                    				doneLeaf(otherlv_1);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2479:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2480:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2480:5: (lv_literal_2_0= ruleKeyword )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtextGrammarTestLanguage.g:2481:6: lv_literal_2_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration7212);
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
        public static final BitSet FOLLOW_11_in_ruleGrammar76 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar103 = new BitSet(new long[]{0x0000240000345010L});
        public static final BitSet FOLLOW_12_in_ruleGrammar134 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar164 = new BitSet(new long[]{0x0000240000347010L});
        public static final BitSet FOLLOW_13_in_ruleGrammar201 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar236 = new BitSet(new long[]{0x0000240000347010L});
        public static final BitSet FOLLOW_ruleHiddenClause_in_ruleGrammar282 = new BitSet(new long[]{0x0000240000345010L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar315 = new BitSet(new long[]{0x0000240000345010L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar354 = new BitSet(new long[]{0x0000240000345012L});
        public static final BitSet FOLLOW_14_in_ruleHiddenClause407 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleHiddenClause432 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHiddenClause467 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleHiddenClause504 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHiddenClause541 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleHiddenClause583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID603 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID625 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleGrammarID645 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID662 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_ruleAbstractRule748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration768 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel828 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel850 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel877 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel915 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel946 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1017 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1039 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1066 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1097 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1168 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParserRule1220 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1253 = new BitSet(new long[]{0x0000000008C04000L});
        public static final BitSet FOLLOW_22_in_ruleParserRule1300 = new BitSet(new long[]{0x0000000000804000L});
        public static final BitSet FOLLOW_ruleReturnsClause_in_ruleParserRule1358 = new BitSet(new long[]{0x0000000000804000L});
        public static final BitSet FOLLOW_ruleRuleNameAndParams_in_ruleParserRule1411 = new BitSet(new long[]{0x0000000008804000L});
        public static final BitSet FOLLOW_ruleReturnsClause_in_ruleParserRule1437 = new BitSet(new long[]{0x0000000000804000L});
        public static final BitSet FOLLOW_ruleHiddenClause_in_ruleParserRule1474 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleParserRule1494 = new BitSet(new long[]{0x0000030202008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1521 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleParserRule1546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleNameAndParams1587 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleRuleNameAndParams1618 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleRuleNameAndParams1659 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_13_in_ruleRuleNameAndParams1702 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleRuleNameAndParams1744 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_26_in_ruleRuleNameAndParams1793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleReturnsClause1827 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleReturnsClause1854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1885 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter1888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1938 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1981 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleTypeRef2011 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2075 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConditionalBranch_in_ruleAlternatives2095 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleAlternatives2138 = new BitSet(new long[]{0x0000030202008030L});
        public static final BitSet FOLLOW_ruleConditionalBranch_in_ruleAlternatives2175 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleConditionalBranch_in_entryRuleConditionalBranch2223 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConditionalBranch2226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleConditionalBranch2243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleConditionalBranch2287 = new BitSet(new long[]{0x0000004100000000L});
        public static final BitSet FOLLOW_ruleInverseLiteralValue_in_ruleConditionalBranch2319 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConditionalBranch2364 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleConditionalBranch2394 = new BitSet(new long[]{0x0000030200008030L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleConditionalBranch2426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup2464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroup2467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup2484 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleUnorderedGroup2527 = new BitSet(new long[]{0x0000030200008030L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup2564 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2612 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup2615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2632 = new BitSet(new long[]{0x0000030200008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2683 = new BitSet(new long[]{0x0000030200008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2723 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2783 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2809 = new BitSet(new long[]{0x0000000180400002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2833 = new BitSet(new long[]{0x0000000180400002L});
        public static final BitSet FOLLOW_ruleCardinalities_in_ruleAbstractTokenWithCardinality2856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleCardinalities2903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleCardinalities2933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleCardinalities2963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2994 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction2997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleAction3016 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3043 = new BitSet(new long[]{0x0000002000020000L});
        public static final BitSet FOLLOW_17_in_ruleAction3074 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAction3106 = new BitSet(new long[]{0x0000000C00000000L});
        public static final BitSet FOLLOW_34_in_ruleAction3160 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_35_in_ruleAction3198 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleAction3236 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleAction3256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3276 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedKeyword_in_ruleAbstractTerminal3356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedRuleCall_in_ruleAbstractTerminal3376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedGroup_in_ruleAbstractTerminal3396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword3416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword3419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword3444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall3469 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall3472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleRuleCall3515 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleRuleCall3546 = new BitSet(new long[]{0x0000004100000010L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_ruleRuleCall3578 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_13_in_ruleRuleCall3615 = new BitSet(new long[]{0x0000004100000010L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_ruleRuleCall3652 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_26_in_ruleRuleCall3691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue3717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue3720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleLiteralValue3739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleLiteralValue3761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInverseLiteralValue_in_entryRuleInverseLiteralValue3781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInverseLiteralValue3784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralValue_in_ruleInverseLiteralValue3796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument3812 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument3815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralValue_in_ruleNamedArgument3877 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedArgument3930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedArgument4001 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleNamedArgument4036 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedArgument4073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRuleCall_in_entryRuleTerminalRuleCall4119 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRuleCall4122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleID_in_ruleTerminalRuleCall4145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleID_in_entryRuleRuleID4170 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleID4173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleID4192 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleRuleID4212 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleID4229 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_rulePredicatedKeyword_in_entryRulePredicatedKeyword4255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedKeyword4258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicate_in_rulePredicatedKeyword4275 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_rulePredicatedKeyword4302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedRuleCall_in_entryRulePredicatedRuleCall4333 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedRuleCall4336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicate_in_rulePredicatedRuleCall4353 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePredicatedRuleCall4380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment4411 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment4414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicate_in_ruleAssignment4437 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment4470 = new BitSet(new long[]{0x0000008C00000000L});
        public static final BitSet FOLLOW_35_in_ruleAssignment4516 = new BitSet(new long[]{0x0000000002008030L});
        public static final BitSet FOLLOW_34_in_ruleAssignment4550 = new BitSet(new long[]{0x0000000002008030L});
        public static final BitSet FOLLOW_39_in_ruleAssignment4584 = new BitSet(new long[]{0x0000000002008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment4629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rulePredicate4681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rulePredicate4727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal4758 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal4761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal4778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal4798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal4818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal4838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement4858 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement4861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement4880 = new BitSet(new long[]{0x0000000002008030L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement4892 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement4906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives4926 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives4929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives4946 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleAssignableAlternatives4989 = new BitSet(new long[]{0x0000000002008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives5026 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference5074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference5077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleCrossReference5096 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference5123 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_29_in_ruleCrossReference5154 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference5186 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCrossReference5219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal5239 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal5242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal5259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal5279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement5299 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement5302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedElement5321 = new BitSet(new long[]{0x0000030202008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement5333 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedElement5347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedGroup_in_entryRulePredicatedGroup5367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedGroup5370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicate_in_rulePredicatedGroup5387 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_rulePredicatedGroup5401 = new BitSet(new long[]{0x0000030202008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rulePredicatedGroup5428 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_rulePredicatedGroup5453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule5473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule5476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleTerminalRule5495 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleTerminalRule5539 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule5591 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule5662 = new BitSet(new long[]{0x0000000008800000L});
        public static final BitSet FOLLOW_ruleReturnsClause_in_ruleTerminalRule5703 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTerminalRule5736 = new BitSet(new long[]{0x00000A4000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule5763 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleTerminalRule5788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives5808 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives5811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives5828 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives5871 = new BitSet(new long[]{0x00000A4000028030L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives5908 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup5956 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup5959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup5976 = new BitSet(new long[]{0x00000A4000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup6027 = new BitSet(new long[]{0x00000A4000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken6067 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken6070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken6087 = new BitSet(new long[]{0x0000000180400002L});
        public static final BitSet FOLLOW_ruleCardinalities_in_ruleTerminalToken6105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement6131 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement6134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement6151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRuleCall_in_ruleTerminalTokenElement6171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement6191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement6211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement6231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOF_in_ruleTerminalTokenElement6251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement6271 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement6274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement6293 = new BitSet(new long[]{0x00000A4000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement6305 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement6319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken6339 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken6342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken6359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken6379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken6399 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken6402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleNegatedToken6421 = new BitSet(new long[]{0x00000A4000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken6448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken6479 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken6482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleUntilToken6501 = new BitSet(new long[]{0x00000A4000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken6528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard6559 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard6562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleWildcard6594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOF_in_entryRuleEOF6614 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEOF6617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEOF6649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange6669 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange6672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange6689 = new BitSet(new long[]{0x0000100000000002L});
        public static final BitSet FOLLOW_44_in_ruleCharacterRange6725 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange6757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule6796 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule6799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEnumRule6818 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumRule6845 = new BitSet(new long[]{0x0000000008800000L});
        public static final BitSet FOLLOW_ruleReturnsClause_in_ruleEnumRule6874 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleEnumRule6894 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule6921 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleEnumRule6946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals6966 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals6969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6986 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleEnumLiterals7029 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals7066 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration7114 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration7117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration7149 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleEnumLiteralDeclaration7180 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration7212 = new BitSet(new long[]{0x0000000000000002L});
    }


}