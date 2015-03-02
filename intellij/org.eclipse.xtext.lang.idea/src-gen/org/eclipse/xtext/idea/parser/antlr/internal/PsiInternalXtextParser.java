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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'returns'", "':'", "';'", "'::'", "'|'", "'&'", "'?'", "'*'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'=>'", "'->'", "'?='", "'['", "']'", "'terminal'", "'fragment'", "'!'", "'EOF'", "'..'", "'enum'"
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


        public PsiInternalXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalXtextParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g"; }



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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:52:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:52:17: ( ruleGrammar EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:53:2: ruleGrammar EOF
            {
             markComposite(elementTypeProvider.getGrammarElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_entryRuleGrammar54);
            ruleGrammar();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammar60); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:59:1: ruleGrammar : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
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
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:59:12: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:60:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:60:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:61:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleGrammar79); 

            			doneLeaf(otherlv_0, elementTypeProvider.getGrammar_GrammarKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:68:3: ( (lv_name_1_0= ruleGrammarID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:69:4: (lv_name_1_0= ruleGrammarID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:69:4: (lv_name_1_0= ruleGrammarID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:70:5: lv_name_1_0= ruleGrammarID
            {

            					markComposite(elementTypeProvider.getGrammar_NameGrammarIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar106);
            ruleGrammarID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:79:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:80:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGrammar137); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getGrammar_WithKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:87:4: ( ( ruleGrammarID ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:88:5: ( ruleGrammarID )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:88:5: ( ruleGrammarID )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:89:6: ruleGrammarID
                    {

                    						markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar167);
                    ruleGrammarID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:98:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:99:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar204); 

                    	    					doneLeaf(otherlv_4, elementTypeProvider.getGrammar_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:106:5: ( ( ruleGrammarID ) )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:107:6: ( ruleGrammarID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:107:6: ( ruleGrammarID )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:108:7: ruleGrammarID
                    	    {

                    	    							markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar239);
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

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:119:3: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:120:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')'
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:120:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:121:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:121:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:122:6: lv_definesHiddenTokens_6_0= 'hidden'
                    {

                    						markLeaf();
                    					
                    lv_definesHiddenTokens_6_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleGrammar302); 

                    						doneLeaf(lv_definesHiddenTokens_6_0, elementTypeProvider.getGrammar_DefinesHiddenTokensHiddenKeyword_3_0_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleGrammar332); 

                    				doneLeaf(otherlv_7, elementTypeProvider.getGrammar_LeftParenthesisKeyword_3_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:138:4: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:139:5: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:139:5: ( (otherlv_8= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:140:6: (otherlv_8= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:140:6: (otherlv_8= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:141:7: otherlv_8= RULE_ID
                            {

                            							markLeaf();
                            						
                            otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar373); 

                            							doneLeaf(otherlv_8, elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType());
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:150:5: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:151:6: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                            	    {

                            	    						markLeaf();
                            	    					
                            	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar416); 

                            	    						doneLeaf(otherlv_9, elementTypeProvider.getGrammar_CommaKeyword_3_2_1_0ElementType());
                            	    					
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:158:6: ( (otherlv_10= RULE_ID ) )
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:159:7: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:159:7: (otherlv_10= RULE_ID )
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:160:8: otherlv_10= RULE_ID
                            	    {

                            	    								markLeaf();
                            	    							
                            	    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar458); 

                            	    								doneLeaf(otherlv_10, elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0ElementType());
                            	    							

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


                    				markLeaf();
                    			
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGrammar507); 

                    				doneLeaf(otherlv_11, elementTypeProvider.getGrammar_RightParenthesisKeyword_3_3ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:179:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:180:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:180:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:181:5: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar540);
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

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:190:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==40||LA7_0==45) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:191:4: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:191:4: (lv_rules_13_0= ruleAbstractRule )
            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:192:5: lv_rules_13_0= ruleAbstractRule
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleGrammar579);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:205:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:205:19: ( ruleGrammarID EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:206:2: ruleGrammarID EOF
            {
             markComposite(elementTypeProvider.getGrammarIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID611);
            ruleGrammarID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammarID617); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:212:1: ruleGrammarID : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleGrammarID() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:212:14: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:213:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:213:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:214:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID636); 

            			doneLeaf(this_ID_0, elementTypeProvider.getGrammarID_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:221:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:222:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGrammarID656); 

            	    				doneLeaf(kw, elementTypeProvider.getGrammarID_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID673); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getGrammarID_IDTerminalRuleCall_1_1ElementType());
            	    			

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:241:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:241:22: ( ruleAbstractRule EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:242:2: ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule699);
            ruleAbstractRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule705); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:248:1: ruleAbstractRule : ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) ;
    public final void ruleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:248:17: ( ( ruleParserRule | ruleTerminalRule | ruleEnumRule ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:249:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:249:2: ( ruleParserRule | ruleTerminalRule | ruleEnumRule )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt9=1;
                }
                break;
            case 40:
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
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:250:3: ruleParserRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_ruleAbstractRule722);
                    ruleParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:258:3: ruleTerminalRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_TerminalRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleAbstractRule742);
                    ruleTerminalRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:266:3: ruleEnumRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_EnumRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_ruleAbstractRule762);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:277:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:277:38: ( ruleAbstractMetamodelDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:278:2: ruleAbstractMetamodelDeclaration EOF
            {
             markComposite(elementTypeProvider.getAbstractMetamodelDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration782);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration788); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:284:1: ruleAbstractMetamodelDeclaration : ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:284:33: ( ( ruleGeneratedMetamodel | ruleReferencedMetamodel ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:285:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:285:2: ( ruleGeneratedMetamodel | ruleReferencedMetamodel )
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
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:286:3: ruleGeneratedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration805);
                    ruleGeneratedMetamodel();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:294:3: ruleReferencedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration825);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:305:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:305:28: ( ruleGeneratedMetamodel EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:306:2: ruleGeneratedMetamodel EOF
            {
             markComposite(elementTypeProvider.getGeneratedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel845);
            ruleGeneratedMetamodel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGeneratedMetamodel851); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:312:1: ruleGeneratedMetamodel : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:312:23: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:313:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:313:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:314:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGeneratedMetamodel870); 

            			doneLeaf(otherlv_0, elementTypeProvider.getGeneratedMetamodel_GenerateKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:321:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:322:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:322:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:323:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel897); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:332:3: ( (otherlv_2= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:333:4: (otherlv_2= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:333:4: (otherlv_2= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:334:5: otherlv_2= RULE_STRING
            {

            					markLeaf();
            				
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel935); 

            					doneLeaf(otherlv_2, elementTypeProvider.getGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:343:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:344:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGeneratedMetamodel966); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getGeneratedMetamodel_AsKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:351:4: ( (lv_alias_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:352:5: (lv_alias_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:352:5: (lv_alias_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:353:6: lv_alias_4_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel998); 

                    						doneLeaf(lv_alias_4_0, elementTypeProvider.getGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType());
                    					

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:367:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:367:29: ( ruleReferencedMetamodel EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:368:2: ruleReferencedMetamodel EOF
            {
             markComposite(elementTypeProvider.getReferencedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1037);
            ruleReferencedMetamodel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel1043); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:374:1: ruleReferencedMetamodel : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:374:24: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:375:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:375:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:376:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferencedMetamodel1062); 

            			doneLeaf(otherlv_0, elementTypeProvider.getReferencedMetamodel_ImportKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:383:3: ( (otherlv_1= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:384:4: (otherlv_1= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:384:4: (otherlv_1= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:385:5: otherlv_1= RULE_STRING
            {

            					markLeaf();
            				
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1089); 

            					doneLeaf(otherlv_1, elementTypeProvider.getReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:394:3: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:395:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferencedMetamodel1120); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getReferencedMetamodel_AsKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:402:4: ( (lv_alias_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:403:5: (lv_alias_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:403:5: (lv_alias_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:404:6: lv_alias_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferencedMetamodel1152); 

                    						doneLeaf(lv_alias_3_0, elementTypeProvider.getReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType());
                    					

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:418:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:418:20: ( ruleParserRule EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:419:2: ruleParserRule EOF
            {
             markComposite(elementTypeProvider.getParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule1191);
            ruleParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRule1197); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:425:1: ruleParserRule : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) ;
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
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:425:15: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:426:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:426:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:427:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';'
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:427:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:428:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:428:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:429:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1229); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getParserRule_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:438:3: (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:439:4: otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRule1260); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getParserRule_ReturnsKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:446:4: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:447:5: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:447:5: (lv_type_2_0= ruleTypeRef )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:448:6: lv_type_2_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getParserRule_TypeTypeRefParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleParserRule1292);
                    ruleTypeRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:458:3: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:459:4: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')'
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:459:4: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:460:5: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:460:5: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:461:6: lv_definesHiddenTokens_3_0= 'hidden'
                    {

                    						markLeaf();
                    					
                    lv_definesHiddenTokens_3_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRule1346); 

                    						doneLeaf(lv_definesHiddenTokens_3_0, elementTypeProvider.getParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRule1376); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getParserRule_LeftParenthesisKeyword_2_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:477:4: ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:478:5: ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:478:5: ( (otherlv_5= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:479:6: (otherlv_5= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:479:6: (otherlv_5= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:480:7: otherlv_5= RULE_ID
                            {

                            							markLeaf();
                            						
                            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1417); 

                            							doneLeaf(otherlv_5, elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0ElementType());
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:489:5: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:490:6: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                            	    {

                            	    						markLeaf();
                            	    					
                            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRule1460); 

                            	    						doneLeaf(otherlv_6, elementTypeProvider.getParserRule_CommaKeyword_2_2_1_0ElementType());
                            	    					
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:497:6: ( (otherlv_7= RULE_ID ) )
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:498:7: (otherlv_7= RULE_ID )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:498:7: (otherlv_7= RULE_ID )
                            	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:499:8: otherlv_7= RULE_ID
                            	    {

                            	    								markLeaf();
                            	    							
                            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1502); 

                            	    								doneLeaf(otherlv_7, elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0ElementType());
                            	    							

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


                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRule1551); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getParserRule_RightParenthesisKeyword_2_3ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRule1571); 

            			doneLeaf(otherlv_9, elementTypeProvider.getParserRule_ColonKeyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:525:3: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:526:4: (lv_alternatives_10_0= ruleAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:526:4: (lv_alternatives_10_0= ruleAlternatives )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:527:5: lv_alternatives_10_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getParserRule_AlternativesAlternativesParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParserRule1598);
            ruleAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_11=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRule1623); 

            			doneLeaf(otherlv_11, elementTypeProvider.getParserRule_SemicolonKeyword_5ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:547:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:547:17: ( ruleTypeRef EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:548:2: ruleTypeRef EOF
            {
             markComposite(elementTypeProvider.getTypeRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef1643);
            ruleTypeRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef1649); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:554:1: ruleTypeRef : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final void ruleTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:554:12: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:555:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:555:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:556:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:556:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
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
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:557:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:557:4: ( (otherlv_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:558:5: (otherlv_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:558:5: (otherlv_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:559:6: otherlv_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1689); 

                    						doneLeaf(otherlv_0, elementTypeProvider.getTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTypeRef1719); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getTypeRef_ColonColonKeyword_0_1ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:576:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:577:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:577:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:578:5: otherlv_2= RULE_ID
            {

            					markLeaf();
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1752); 

            					doneLeaf(otherlv_2, elementTypeProvider.getTypeRef_ClassifierEClassifierCrossReference_1_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:591:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:591:22: ( ruleAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:592:2: ruleAlternatives EOF
            {
             markComposite(elementTypeProvider.getAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives1783);
            ruleAlternatives();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternatives1789); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:598:1: ruleAlternatives : ( ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? ) ;
    public final void ruleAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:598:17: ( ( ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:599:2: ( ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:599:2: ( ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:600:3: ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAlternatives_UnorderedGroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1806);
            ruleUnorderedGroup();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:607:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:608:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:608:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:609:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:614:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+
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
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:615:5: otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAlternatives1849); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:622:5: ( (lv_elements_3_0= ruleUnorderedGroup ) )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:623:6: (lv_elements_3_0= ruleUnorderedGroup )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:623:6: (lv_elements_3_0= ruleUnorderedGroup )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:624:7: lv_elements_3_0= ruleUnorderedGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getAlternatives_ElementsUnorderedGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1886);
                    	    ruleUnorderedGroup();

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


    // $ANTLR start "entryRuleUnorderedGroup"
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:639:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:639:24: ( ruleUnorderedGroup EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:640:2: ruleUnorderedGroup EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup1934);
            ruleUnorderedGroup();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroup1940); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:646:1: ruleUnorderedGroup : ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:646:19: ( ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:647:2: ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:647:2: ( ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:648:3: ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getUnorderedGroup_GroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup1957);
            ruleGroup();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:655:3: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:656:4: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:656:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:657:5: 
                    {

                    					precedeComposite(elementTypeProvider.getUnorderedGroup_UnorderedGroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:662:4: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==26) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:663:5: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnorderedGroup2000); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getUnorderedGroup_AmpersandKeyword_1_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:670:5: ( (lv_elements_3_0= ruleGroup ) )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:671:6: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:671:6: (lv_elements_3_0= ruleGroup )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:672:7: lv_elements_3_0= ruleGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getUnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup2037);
                    	    ruleGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


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
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:687:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:687:15: ( ruleGroup EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:688:2: ruleGroup EOF
            {
             markComposite(elementTypeProvider.getGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup2085);
            ruleGroup();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup2091); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:694:1: ruleGroup : ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final void ruleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:694:10: ( ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:695:2: ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:695:2: ( ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:696:3: ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getGroup_AbstractTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup2108);
            ruleAbstractToken();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:703:3: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==15||LA23_0==30||(LA23_0>=35 && LA23_0<=36)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:704:4: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:704:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:705:5: 
                    {

                    					precedeComposite(elementTypeProvider.getGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:710:4: ( (lv_elements_2_0= ruleAbstractToken ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||LA22_0==15||LA22_0==30||(LA22_0>=35 && LA22_0<=36)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:711:5: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:711:5: (lv_elements_2_0= ruleAbstractToken )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:712:6: lv_elements_2_0= ruleAbstractToken
                    	    {

                    	    						markComposite(elementTypeProvider.getGroup_ElementsAbstractTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup2159);
                    	    ruleAbstractToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:726:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:726:23: ( ruleAbstractToken EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:727:2: ruleAbstractToken EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2199);
            ruleAbstractToken();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken2205); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:733:1: ruleAbstractToken : ( ruleAbstractTokenWithCardinality | ruleAction ) ;
    public final void ruleAbstractToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:733:18: ( ( ruleAbstractTokenWithCardinality | ruleAction ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:734:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:734:2: ( ruleAbstractTokenWithCardinality | ruleAction )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==15||(LA24_0>=35 && LA24_0<=36)) ) {
                alt24=1;
            }
            else if ( (LA24_0==30) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:735:3: ruleAbstractTokenWithCardinality
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2222);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:743:3: ruleAction
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_ActionParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleAbstractToken2242);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:754:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:754:38: ( ruleAbstractTokenWithCardinality EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:755:2: ruleAbstractTokenWithCardinality EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenWithCardinalityElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2262);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2268); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:761:1: ruleAbstractTokenWithCardinality : ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {
        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:761:33: ( ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:762:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:762:2: ( ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:763:3: ( ruleAssignment | ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:763:3: ( ruleAssignment | ruleAbstractTerminal )
            int alt25=2;
            switch ( input.LA(1) ) {
            case 35:
                {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==RULE_ID) ) {
                    int LA25_5 = input.LA(3);

                    if ( (LA25_5==EOF||(LA25_5>=RULE_ID && LA25_5<=RULE_STRING)||(LA25_5>=15 && LA25_5<=16)||LA25_5==23||(LA25_5>=25 && LA25_5<=30)||(LA25_5>=35 && LA25_5<=36)) ) {
                        alt25=2;
                    }
                    else if ( ((LA25_5>=31 && LA25_5<=32)||LA25_5==37) ) {
                        alt25=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 5, input);

                        throw nvae;
                    }
                }
                else if ( (LA25_1==RULE_STRING||LA25_1==15) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==RULE_STRING||LA25_2==15) ) {
                    alt25=2;
                }
                else if ( (LA25_2==RULE_ID) ) {
                    int LA25_5 = input.LA(3);

                    if ( (LA25_5==EOF||(LA25_5>=RULE_ID && LA25_5<=RULE_STRING)||(LA25_5>=15 && LA25_5<=16)||LA25_5==23||(LA25_5>=25 && LA25_5<=30)||(LA25_5>=35 && LA25_5<=36)) ) {
                        alt25=2;
                    }
                    else if ( ((LA25_5>=31 && LA25_5<=32)||LA25_5==37) ) {
                        alt25=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA25_3 = input.LA(2);

                if ( (LA25_3==EOF||(LA25_3>=RULE_ID && LA25_3<=RULE_STRING)||(LA25_3>=15 && LA25_3<=16)||LA25_3==23||(LA25_3>=25 && LA25_3<=30)||(LA25_3>=35 && LA25_3<=36)) ) {
                    alt25=2;
                }
                else if ( ((LA25_3>=31 && LA25_3<=32)||LA25_3==37) ) {
                    alt25=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 15:
                {
                alt25=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:764:4: ruleAssignment
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2291);
                    ruleAssignment();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:772:4: ruleAbstractTerminal
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2315);
                    ruleAbstractTerminal();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:780:3: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=27 && LA27_0<=29)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:781:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:781:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:782:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:782:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    int alt26=3;
                    switch ( input.LA(1) ) {
                    case 27:
                        {
                        alt26=1;
                        }
                        break;
                    case 28:
                        {
                        alt26=2;
                        }
                        break;
                    case 29:
                        {
                        alt26=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }

                    switch (alt26) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:783:6: lv_cardinality_2_1= '?'
                            {

                            						markLeaf();
                            					
                            lv_cardinality_2_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAbstractTokenWithCardinality2355); 

                            						doneLeaf(lv_cardinality_2_1, elementTypeProvider.getAbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:791:6: lv_cardinality_2_2= '*'
                            {

                            						markLeaf();
                            					
                            lv_cardinality_2_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAbstractTokenWithCardinality2389); 

                            						doneLeaf(lv_cardinality_2_2, elementTypeProvider.getAbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:799:6: lv_cardinality_2_3= '+'
                            {

                            						markLeaf();
                            					
                            lv_cardinality_2_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAbstractTokenWithCardinality2423); 

                            						doneLeaf(lv_cardinality_2_3, elementTypeProvider.getAbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:813:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:813:16: ( ruleAction EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:814:2: ruleAction EOF
            {
             markComposite(elementTypeProvider.getActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction2462);
            ruleAction();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction2468); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:820:1: ruleAction : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final void ruleAction() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:820:11: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:821:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:821:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:822:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleAction2487); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAction_LeftCurlyBracketKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:829:3: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:830:4: (lv_type_1_0= ruleTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:830:4: (lv_type_1_0= ruleTypeRef )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:831:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getAction_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleAction2514);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:840:3: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==17) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:841:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAction2545); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getAction_FullStopKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:848:4: ( (lv_feature_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:849:5: (lv_feature_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:849:5: (lv_feature_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:850:6: lv_feature_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction2577); 

                    						doneLeaf(lv_feature_3_0, elementTypeProvider.getAction_FeatureIDTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:859:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:860:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:860:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:861:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:861:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==31) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==32) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:862:7: lv_operator_4_1= '='
                            {

                            							markLeaf();
                            						
                            lv_operator_4_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAction2631); 

                            							doneLeaf(lv_operator_4_1, elementTypeProvider.getAction_OperatorEqualsSignKeyword_2_2_0_0ElementType());
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:870:7: lv_operator_4_2= '+='
                            {

                            							markLeaf();
                            						
                            lv_operator_4_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAction2669); 

                            							doneLeaf(lv_operator_4_2, elementTypeProvider.getAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType());
                            						

                            }
                            break;

                    }


                    }


                    }


                    				markLeaf();
                    			
                    otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAction2707); 

                    				doneLeaf(otherlv_5, elementTypeProvider.getAction_CurrentKeyword_2_3ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAction2727); 

            			doneLeaf(otherlv_6, elementTypeProvider.getAction_RightCurlyBracketKeyword_3ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:899:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:899:26: ( ruleAbstractTerminal EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:900:2: ruleAbstractTerminal EOF
            {
             markComposite(elementTypeProvider.getAbstractTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2747);
            ruleAbstractTerminal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal2753); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:906:1: ruleAbstractTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:906:21: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:907:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:907:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedElement | rulePredicatedKeyword | rulePredicatedRuleCall | rulePredicatedGroup )
            int alt30=6;
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
                switch ( input.LA(2) ) {
                case 15:
                    {
                    alt30=6;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt30=4;
                    }
                    break;
                case RULE_ID:
                    {
                    alt30=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 4, input);

                    throw nvae;
                }

                }
                break;
            case 36:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt30=5;
                    }
                    break;
                case 15:
                    {
                    alt30=6;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt30=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 5, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:908:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAbstractTerminal2770);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:916:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2790);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:924:3: ruleParenthesizedElement
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2810);
                    ruleParenthesizedElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:932:3: rulePredicatedKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedKeywordParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedKeyword_in_ruleAbstractTerminal2830);
                    rulePredicatedKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:940:3: rulePredicatedRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedRuleCallParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedRuleCall_in_ruleAbstractTerminal2850);
                    rulePredicatedRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:948:3: rulePredicatedGroup
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedGroupParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePredicatedGroup_in_ruleAbstractTerminal2870);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:959:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:959:17: ( ruleKeyword EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:960:2: ruleKeyword EOF
            {
             markComposite(elementTypeProvider.getKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword2890);
            ruleKeyword();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword2896); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:966:1: ruleKeyword : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final void ruleKeyword() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:966:12: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:967:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:967:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:968:3: (lv_value_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:968:3: (lv_value_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:969:4: lv_value_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleKeyword2921); 

            				doneLeaf(lv_value_0_0, elementTypeProvider.getKeyword_ValueSTRINGTerminalRuleCall_0ElementType());
            			

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:981:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:981:18: ( ruleRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:982:2: ruleRuleCall EOF
            {
             markComposite(elementTypeProvider.getRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall2946);
            ruleRuleCall();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall2952); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:988:1: ruleRuleCall : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleRuleCall() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:988:13: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:989:2: ( (otherlv_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:989:2: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:990:3: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:990:3: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:991:4: otherlv_0= RULE_ID
            {

            				markLeaf();
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCall2977); 

            				doneLeaf(otherlv_0, elementTypeProvider.getRuleCall_RuleAbstractRuleCrossReference_0ElementType());
            			

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


    // $ANTLR start "entryRulePredicatedKeyword"
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1003:1: entryRulePredicatedKeyword : rulePredicatedKeyword EOF ;
    public final void entryRulePredicatedKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1003:27: ( rulePredicatedKeyword EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1004:2: rulePredicatedKeyword EOF
            {
             markComposite(elementTypeProvider.getPredicatedKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedKeyword_in_entryRulePredicatedKeyword3002);
            rulePredicatedKeyword();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedKeyword3008); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1010:1: rulePredicatedKeyword : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final void rulePredicatedKeyword() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token lv_value_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1010:22: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1011:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1011:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1012:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1012:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            else if ( (LA31_0==36) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1013:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1013:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1014:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1014:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1015:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf();
                    					
                    lv_predicated_0_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_rulePredicatedKeyword3048); 

                    						doneLeaf(lv_predicated_0_0, elementTypeProvider.getPredicatedKeyword_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1025:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1025:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1026:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1026:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1027:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf();
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_rulePredicatedKeyword3102); 

                    						doneLeaf(lv_firstSetPredicated_1_0, elementTypeProvider.getPredicatedKeyword_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1037:3: ( (lv_value_2_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1038:4: (lv_value_2_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1038:4: (lv_value_2_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1039:5: lv_value_2_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rulePredicatedKeyword3147); 

            					doneLeaf(lv_value_2_0, elementTypeProvider.getPredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1052:1: entryRulePredicatedRuleCall : rulePredicatedRuleCall EOF ;
    public final void entryRulePredicatedRuleCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1052:28: ( rulePredicatedRuleCall EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1053:2: rulePredicatedRuleCall EOF
            {
             markComposite(elementTypeProvider.getPredicatedRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedRuleCall_in_entryRulePredicatedRuleCall3178);
            rulePredicatedRuleCall();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedRuleCall3184); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1059:1: rulePredicatedRuleCall : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final void rulePredicatedRuleCall() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1059:23: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1060:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1060:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1061:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (otherlv_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1061:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==35) ) {
                alt32=1;
            }
            else if ( (LA32_0==36) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1062:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1062:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1063:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1063:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1064:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf();
                    					
                    lv_predicated_0_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_rulePredicatedRuleCall3224); 

                    						doneLeaf(lv_predicated_0_0, elementTypeProvider.getPredicatedRuleCall_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1074:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1074:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1075:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1075:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1076:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf();
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_rulePredicatedRuleCall3278); 

                    						doneLeaf(lv_firstSetPredicated_1_0, elementTypeProvider.getPredicatedRuleCall_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1086:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1087:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1087:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1088:5: otherlv_2= RULE_ID
            {

            					markLeaf();
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePredicatedRuleCall3323); 

            					doneLeaf(otherlv_2, elementTypeProvider.getPredicatedRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1101:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1101:20: ( ruleAssignment EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1102:2: ruleAssignment EOF
            {
             markComposite(elementTypeProvider.getAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment3354);
            ruleAssignment();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment3360); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1108:1: ruleAssignment : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= RULE_ID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) ) ;
    public final void ruleAssignment() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token lv_feature_2_0=null;
        Token lv_operator_3_1=null;
        Token lv_operator_3_2=null;
        Token lv_operator_3_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1108:15: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= RULE_ID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1109:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= RULE_ID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1109:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= RULE_ID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1110:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= RULE_ID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1110:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==35) ) {
                alt33=1;
            }
            else if ( (LA33_0==36) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1111:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1111:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1112:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1112:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1113:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf();
                    					
                    lv_predicated_0_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAssignment3400); 

                    						doneLeaf(lv_predicated_0_0, elementTypeProvider.getAssignment_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1123:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1123:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1124:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1124:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1125:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf();
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleAssignment3454); 

                    						doneLeaf(lv_firstSetPredicated_1_0, elementTypeProvider.getAssignment_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1135:3: ( (lv_feature_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1136:4: (lv_feature_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1136:4: (lv_feature_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1137:5: lv_feature_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_feature_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment3500); 

            					doneLeaf(lv_feature_2_0, elementTypeProvider.getAssignment_FeatureIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1146:3: ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1147:4: ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1147:4: ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1148:5: (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1148:5: (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' )
            int alt34=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt34=1;
                }
                break;
            case 31:
                {
                alt34=2;
                }
                break;
            case 37:
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
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1149:6: lv_operator_3_1= '+='
                    {

                    						markLeaf();
                    					
                    lv_operator_3_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAssignment3546); 

                    						doneLeaf(lv_operator_3_1, elementTypeProvider.getAssignment_OperatorPlusSignEqualsSignKeyword_2_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1157:6: lv_operator_3_2= '='
                    {

                    						markLeaf();
                    					
                    lv_operator_3_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignment3580); 

                    						doneLeaf(lv_operator_3_2, elementTypeProvider.getAssignment_OperatorEqualsSignKeyword_2_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1165:6: lv_operator_3_3= '?='
                    {

                    						markLeaf();
                    					
                    lv_operator_3_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleAssignment3614); 

                    						doneLeaf(lv_operator_3_3, elementTypeProvider.getAssignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2ElementType());
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1175:3: ( (lv_terminal_4_0= ruleAssignableTerminal ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1176:4: (lv_terminal_4_0= ruleAssignableTerminal )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1176:4: (lv_terminal_4_0= ruleAssignableTerminal )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1177:5: lv_terminal_4_0= ruleAssignableTerminal
            {

            					markComposite(elementTypeProvider.getAssignment_TerminalAssignableTerminalParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignment3659);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1190:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1190:28: ( ruleAssignableTerminal EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1191:2: ruleAssignableTerminal EOF
            {
             markComposite(elementTypeProvider.getAssignableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3690);
            ruleAssignableTerminal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal3696); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1197:1: ruleAssignableTerminal : ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1197:23: ( ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1198:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1198:2: ( ruleKeyword | ruleRuleCall | ruleParenthesizedAssignableElement | ruleCrossReference )
            int alt35=4;
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
            case 38:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1199:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAssignableTerminal3713);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1207:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3733);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1215:3: ruleParenthesizedAssignableElement
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3753);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1223:3: ruleCrossReference
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_CrossReferenceParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3773);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1234:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1234:40: ( ruleParenthesizedAssignableElement EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1235:2: ruleParenthesizedAssignableElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedAssignableElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3793);
            ruleParenthesizedAssignableElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3799); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1241:1: ruleParenthesizedAssignableElement : (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1241:35: ( (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1242:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1242:2: (otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1243:3: otherlv_0= '(' ruleAssignableAlternatives otherlv_2= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedAssignableElement3818); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3830);
            ruleAssignableAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedAssignableElement3844); 

            			doneLeaf(otherlv_2, elementTypeProvider.getParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1268:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1268:32: ( ruleAssignableAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1269:2: ruleAssignableAlternatives EOF
            {
             markComposite(elementTypeProvider.getAssignableAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3864);
            ruleAssignableAlternatives();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives3870); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1275:1: ruleAssignableAlternatives : ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1275:27: ( ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1276:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1276:2: ( ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1277:3: ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3887);
            ruleAssignableTerminal();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1284:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1285:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1285:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1286:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAssignableAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1291:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
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
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1292:5: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAssignableAlternatives3930); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1299:5: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1300:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1300:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1301:7: lv_elements_3_0= ruleAssignableTerminal
                    	    {

                    	    							markComposite(elementTypeProvider.getAssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3967);
                    	    ruleAssignableTerminal();

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
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1316:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1316:24: ( ruleCrossReference EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1317:2: ruleCrossReference EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference4015);
            ruleCrossReference();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference4021); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1323:1: ruleCrossReference : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final void ruleCrossReference() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1323:19: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1324:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1324:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1325:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleCrossReference4040); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCrossReference_LeftSquareBracketKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1332:3: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1333:4: (lv_type_1_0= ruleTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1333:4: (lv_type_1_0= ruleTypeRef )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1334:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleCrossReference4067);
            ruleTypeRef();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1343:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==25) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1344:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleCrossReference4098); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getCrossReference_VerticalLineKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1351:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1352:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1352:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1353:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						markComposite(elementTypeProvider.getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference4130);
                    ruleCrossReferenceableTerminal();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleCrossReference4163); 

            			doneLeaf(otherlv_4, elementTypeProvider.getCrossReference_RightSquareBracketKeyword_3ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1374:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1374:36: ( ruleCrossReferenceableTerminal EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1375:2: ruleCrossReferenceableTerminal EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal4183);
            ruleCrossReferenceableTerminal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal4189); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1381:1: ruleCrossReferenceableTerminal : ( ruleKeyword | ruleRuleCall ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1381:31: ( ( ruleKeyword | ruleRuleCall ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1382:2: ( ruleKeyword | ruleRuleCall )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1382:2: ( ruleKeyword | ruleRuleCall )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_STRING) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_ID) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1383:3: ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal4206);
                    ruleKeyword();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1391:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal4226);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1402:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1402:30: ( ruleParenthesizedElement EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1403:2: ruleParenthesizedElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4246);
            ruleParenthesizedElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement4252); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1409:1: ruleParenthesizedElement : (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1409:25: ( (otherlv_0= '(' ruleAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1410:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1410:2: (otherlv_0= '(' ruleAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1411:3: otherlv_0= '(' ruleAlternatives otherlv_2= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedElement4271); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParenthesizedElement_LeftParenthesisKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getParenthesizedElement_AlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4283);
            ruleAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedElement4297); 

            			doneLeaf(otherlv_2, elementTypeProvider.getParenthesizedElement_RightParenthesisKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1436:1: entryRulePredicatedGroup : rulePredicatedGroup EOF ;
    public final void entryRulePredicatedGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1436:25: ( rulePredicatedGroup EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1437:2: rulePredicatedGroup EOF
            {
             markComposite(elementTypeProvider.getPredicatedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePredicatedGroup_in_entryRulePredicatedGroup4317);
            rulePredicatedGroup();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicatedGroup4323); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1443:1: rulePredicatedGroup : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' ) ;
    public final void rulePredicatedGroup() throws RecognitionException {
        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1443:20: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1444:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1444:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1445:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')'
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1445:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            else if ( (LA40_0==36) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1446:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1446:4: ( (lv_predicated_0_0= '=>' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1447:5: (lv_predicated_0_0= '=>' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1447:5: (lv_predicated_0_0= '=>' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1448:6: lv_predicated_0_0= '=>'
                    {

                    						markLeaf();
                    					
                    lv_predicated_0_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_rulePredicatedGroup4363); 

                    						doneLeaf(lv_predicated_0_0, elementTypeProvider.getPredicatedGroup_PredicatedEqualsSignGreaterThanSignKeyword_0_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1458:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1458:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1459:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1459:5: (lv_firstSetPredicated_1_0= '->' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1460:6: lv_firstSetPredicated_1_0= '->'
                    {

                    						markLeaf();
                    					
                    lv_firstSetPredicated_1_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_rulePredicatedGroup4417); 

                    						doneLeaf(lv_firstSetPredicated_1_0, elementTypeProvider.getPredicatedGroup_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePredicatedGroup4449); 

            			doneLeaf(otherlv_2, elementTypeProvider.getPredicatedGroup_LeftParenthesisKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1477:3: ( (lv_elements_3_0= ruleAlternatives ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1478:4: (lv_elements_3_0= ruleAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1478:4: (lv_elements_3_0= ruleAlternatives )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1479:5: lv_elements_3_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getPredicatedGroup_ElementsAlternativesParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rulePredicatedGroup4476);
            ruleAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePredicatedGroup4501); 

            			doneLeaf(otherlv_4, elementTypeProvider.getPredicatedGroup_RightParenthesisKeyword_3ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1499:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1499:22: ( ruleTerminalRule EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1500:2: ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule4521);
            ruleTerminalRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule4527); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1506:1: ruleTerminalRule : (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' ) ;
    public final void ruleTerminalRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_fragment_1_0=null;
        Token lv_name_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1506:17: ( (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1507:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1507:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1508:3: otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) otherlv_6= ':' ( (lv_alternatives_7_0= ruleTerminalAlternatives ) ) otherlv_8= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleTerminalRule4546); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTerminalRule_TerminalKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1515:3: ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==41) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_ID) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1516:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1516:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1517:5: ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1517:5: ( (lv_fragment_1_0= 'fragment' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1518:6: (lv_fragment_1_0= 'fragment' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1518:6: (lv_fragment_1_0= 'fragment' )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1519:7: lv_fragment_1_0= 'fragment'
                    {

                    							markLeaf();
                    						
                    lv_fragment_1_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleTerminalRule4590); 

                    							doneLeaf(lv_fragment_1_0, elementTypeProvider.getTerminalRule_FragmentFragmentKeyword_1_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1528:5: ( (lv_name_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1529:6: (lv_name_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1529:6: (lv_name_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1530:7: lv_name_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule4642); 

                    							doneLeaf(lv_name_2_0, elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1541:4: ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1541:4: ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1542:5: ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )?
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1542:5: ( (lv_name_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1543:6: (lv_name_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1543:6: (lv_name_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1544:7: lv_name_3_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule4713); 

                    							doneLeaf(lv_name_3_0, elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_1_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1553:5: (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==21) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1554:6: otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) )
                            {

                            						markLeaf();
                            					
                            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTerminalRule4756); 

                            						doneLeaf(otherlv_4, elementTypeProvider.getTerminalRule_ReturnsKeyword_1_1_1_0ElementType());
                            					
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1561:6: ( (lv_type_5_0= ruleTypeRef ) )
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1562:7: (lv_type_5_0= ruleTypeRef )
                            {
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1562:7: (lv_type_5_0= ruleTypeRef )
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1563:8: lv_type_5_0= ruleTypeRef
                            {

                            								markComposite(elementTypeProvider.getTerminalRule_TypeTypeRefParserRuleCall_1_1_1_1_0ElementType());
                            							
                            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleTerminalRule4798);
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


            			markLeaf();
            		
            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTerminalRule4848); 

            			doneLeaf(otherlv_6, elementTypeProvider.getTerminalRule_ColonKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1582:3: ( (lv_alternatives_7_0= ruleTerminalAlternatives ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1583:4: (lv_alternatives_7_0= ruleTerminalAlternatives )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1583:4: (lv_alternatives_7_0= ruleTerminalAlternatives )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1584:5: lv_alternatives_7_0= ruleTerminalAlternatives
            {

            					markComposite(elementTypeProvider.getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4875);
            ruleTerminalAlternatives();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_8=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTerminalRule4900); 

            			doneLeaf(otherlv_8, elementTypeProvider.getTerminalRule_SemicolonKeyword_4ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1604:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1604:30: ( ruleTerminalAlternatives EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1605:2: ruleTerminalAlternatives EOF
            {
             markComposite(elementTypeProvider.getTerminalAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4920);
            ruleTerminalAlternatives();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives4926); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1611:1: ruleTerminalAlternatives : ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1611:25: ( ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1612:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1612:2: ( ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1613:3: ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4943);
            ruleTerminalGroup();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1620:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==25) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1621:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1621:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1622:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1627:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    int cnt43=0;
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==25) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1628:5: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalAlternatives4986); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1635:5: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1636:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1636:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1637:7: lv_elements_3_0= ruleTerminalGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getTerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives5023);
                    	    ruleTerminalGroup();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt43 >= 1 ) break loop43;
                                EarlyExitException eee =
                                    new EarlyExitException(43, input);
                                throw eee;
                        }
                        cnt43++;
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1652:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1652:23: ( ruleTerminalGroup EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1653:2: ruleTerminalGroup EOF
            {
             markComposite(elementTypeProvider.getTerminalGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup5071);
            ruleTerminalGroup();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup5077); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1659:1: ruleTerminalGroup : ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final void ruleTerminalGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1659:18: ( ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1660:2: ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1660:2: ( ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1661:3: ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalGroup_TerminalTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup5094);
            ruleTerminalToken();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1668:3: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_STRING)||LA46_0==15||LA46_0==17||LA46_0==36||(LA46_0>=42 && LA46_0<=43)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1669:4: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1669:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1670:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1675:4: ( (lv_elements_2_0= ruleTerminalToken ) )+
                    int cnt45=0;
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_STRING)||LA45_0==15||LA45_0==17||LA45_0==36||(LA45_0>=42 && LA45_0<=43)) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1676:5: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1676:5: (lv_elements_2_0= ruleTerminalToken )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1677:6: lv_elements_2_0= ruleTerminalToken
                    	    {

                    	    						markComposite(elementTypeProvider.getTerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup5145);
                    	    ruleTerminalToken();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt45 >= 1 ) break loop45;
                                EarlyExitException eee =
                                    new EarlyExitException(45, input);
                                throw eee;
                        }
                        cnt45++;
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1691:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1691:23: ( ruleTerminalToken EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1692:2: ruleTerminalToken EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken5185);
            ruleTerminalToken();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken5191); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1698:1: ruleTerminalToken : ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final void ruleTerminalToken() throws RecognitionException {
        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1698:18: ( ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1699:2: ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1699:2: ( ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1700:3: ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {

            			markComposite(elementTypeProvider.getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken5208);
            ruleTerminalTokenElement();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1707:3: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=27 && LA48_0<=29)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1708:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1708:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1709:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1709:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    int alt47=3;
                    switch ( input.LA(1) ) {
                    case 27:
                        {
                        alt47=1;
                        }
                        break;
                    case 28:
                        {
                        alt47=2;
                        }
                        break;
                    case 29:
                        {
                        alt47=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }

                    switch (alt47) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1710:6: lv_cardinality_1_1= '?'
                            {

                            						markLeaf();
                            					
                            lv_cardinality_1_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTerminalToken5243); 

                            						doneLeaf(lv_cardinality_1_1, elementTypeProvider.getTerminalToken_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1718:6: lv_cardinality_1_2= '*'
                            {

                            						markLeaf();
                            					
                            lv_cardinality_1_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTerminalToken5277); 

                            						doneLeaf(lv_cardinality_1_2, elementTypeProvider.getTerminalToken_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1726:6: lv_cardinality_1_3= '+'
                            {

                            						markLeaf();
                            					
                            lv_cardinality_1_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTerminalToken5311); 

                            						doneLeaf(lv_cardinality_1_3, elementTypeProvider.getTerminalToken_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1740:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1740:30: ( ruleTerminalTokenElement EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1741:2: ruleTerminalTokenElement EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement5350);
            ruleTerminalTokenElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement5356); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1747:1: ruleTerminalTokenElement : ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1747:25: ( ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1748:2: ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1748:2: ( ruleCharacterRange | ruleRuleCall | ruleParenthesizedTerminalElement | ruleAbstractNegatedToken | ruleWildcard | ruleEOF )
            int alt49=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt49=1;
                }
                break;
            case RULE_ID:
                {
                alt49=2;
                }
                break;
            case 15:
                {
                alt49=3;
                }
                break;
            case 36:
            case 42:
                {
                alt49=4;
                }
                break;
            case 17:
                {
                alt49=5;
                }
                break;
            case 43:
                {
                alt49=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1749:3: ruleCharacterRange
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement5373);
                    ruleCharacterRange();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1757:3: ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement5393);
                    ruleRuleCall();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1765:3: ruleParenthesizedTerminalElement
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement5413);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1773:3: ruleAbstractNegatedToken
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement5433);
                    ruleAbstractNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1781:3: ruleWildcard
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_WildcardParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_ruleTerminalTokenElement5453);
                    ruleWildcard();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1789:3: ruleEOF
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_EOFParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEOF_in_ruleTerminalTokenElement5473);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1800:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1800:38: ( ruleParenthesizedTerminalElement EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1801:2: ruleParenthesizedTerminalElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedTerminalElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement5493);
            ruleParenthesizedTerminalElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement5499); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1807:1: ruleParenthesizedTerminalElement : (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1807:33: ( (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1808:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1808:2: (otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1809:3: otherlv_0= '(' ruleTerminalAlternatives otherlv_2= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedTerminalElement5518); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement5530);
            ruleTerminalAlternatives();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedTerminalElement5544); 

            			doneLeaf(otherlv_2, elementTypeProvider.getParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1834:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1834:30: ( ruleAbstractNegatedToken EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1835:2: ruleAbstractNegatedToken EOF
            {
             markComposite(elementTypeProvider.getAbstractNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken5564);
            ruleAbstractNegatedToken();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken5570); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1841:1: ruleAbstractNegatedToken : ( ruleNegatedToken | ruleUntilToken ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1841:25: ( ( ruleNegatedToken | ruleUntilToken ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1842:2: ( ruleNegatedToken | ruleUntilToken )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1842:2: ( ruleNegatedToken | ruleUntilToken )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==42) ) {
                alt50=1;
            }
            else if ( (LA50_0==36) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1843:3: ruleNegatedToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken5587);
                    ruleNegatedToken();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1851:3: ruleUntilToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken5607);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1862:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1862:22: ( ruleNegatedToken EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1863:2: ruleNegatedToken EOF
            {
             markComposite(elementTypeProvider.getNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken5627);
            ruleNegatedToken();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken5633); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1869:1: ruleNegatedToken : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1869:17: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1870:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1870:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1871:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleNegatedToken5652); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNegatedToken_ExclamationMarkKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1878:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1879:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1879:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1880:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5679);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1893:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1893:20: ( ruleUntilToken EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1894:2: ruleUntilToken EOF
            {
             markComposite(elementTypeProvider.getUntilTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken5710);
            ruleUntilToken();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken5716); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1900:1: ruleUntilToken : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final void ruleUntilToken() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1900:15: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1901:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1901:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1902:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUntilToken5735); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1909:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1910:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1910:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1911:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5762);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1924:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1924:18: ( ruleWildcard EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1925:2: ruleWildcard EOF
            {
             markComposite(elementTypeProvider.getWildcardElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard5793);
            ruleWildcard();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard5799); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1931:1: ruleWildcard : ( () otherlv_1= '.' ) ;
    public final void ruleWildcard() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1931:13: ( ( () otherlv_1= '.' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1932:2: ( () otherlv_1= '.' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1932:2: ( () otherlv_1= '.' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1933:3: () otherlv_1= '.'
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1933:3: ()
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1934:4: 
            {

            				precedeComposite(elementTypeProvider.getWildcard_WildcardAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleWildcard5831); 

            			doneLeaf(otherlv_1, elementTypeProvider.getWildcard_FullStopKeyword_1ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1950:1: entryRuleEOF : ruleEOF EOF ;
    public final void entryRuleEOF() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1950:13: ( ruleEOF EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1951:2: ruleEOF EOF
            {
             markComposite(elementTypeProvider.getEOFElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOF_in_entryRuleEOF5851);
            ruleEOF();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEOF5857); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1957:1: ruleEOF : ( () otherlv_1= 'EOF' ) ;
    public final void ruleEOF() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1957:8: ( ( () otherlv_1= 'EOF' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1958:2: ( () otherlv_1= 'EOF' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1958:2: ( () otherlv_1= 'EOF' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1959:3: () otherlv_1= 'EOF'
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1959:3: ()
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1960:4: 
            {

            				precedeComposite(elementTypeProvider.getEOF_EOFAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEOF5889); 

            			doneLeaf(otherlv_1, elementTypeProvider.getEOF_EOFKeyword_1ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1976:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1976:24: ( ruleCharacterRange EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1977:2: ruleCharacterRange EOF
            {
             markComposite(elementTypeProvider.getCharacterRangeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5909);
            ruleCharacterRange();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange5915); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1983:1: ruleCharacterRange : ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final void ruleCharacterRange() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1983:19: ( ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1984:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1984:2: ( ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1985:3: ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			markComposite(elementTypeProvider.getCharacterRange_KeywordParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5932);
            ruleKeyword();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1992:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==44) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1993:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1993:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:1994:5: 
                    {

                    					precedeComposite(elementTypeProvider.getCharacterRange_CharacterRangeLeftAction_1_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCharacterRange5968); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getCharacterRange_FullStopFullStopKeyword_1_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2006:4: ( (lv_right_3_0= ruleKeyword ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2007:5: (lv_right_3_0= ruleKeyword )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2007:5: (lv_right_3_0= ruleKeyword )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2008:6: lv_right_3_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange6000);
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2022:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2022:18: ( ruleEnumRule EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2023:2: ruleEnumRule EOF
            {
             markComposite(elementTypeProvider.getEnumRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule6039);
            ruleEnumRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule6045); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2029:1: ruleEnumRule : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) ;
    public final void ruleEnumRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2029:13: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2030:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2030:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2031:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEnumRule6064); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEnumRule_EnumKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2038:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2039:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2039:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2040:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumRule6091); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEnumRule_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2049:3: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==21) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2050:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumRule6122); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getEnumRule_ReturnsKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2057:4: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2058:5: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2058:5: (lv_type_3_0= ruleTypeRef )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2059:6: lv_type_3_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleEnumRule6154);
                    ruleTypeRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEnumRule6187); 

            			doneLeaf(otherlv_4, elementTypeProvider.getEnumRule_ColonKeyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2076:3: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2077:4: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2077:4: (lv_alternatives_5_0= ruleEnumLiterals )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2078:5: lv_alternatives_5_0= ruleEnumLiterals
            {

            					markComposite(elementTypeProvider.getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_ruleEnumRule6214);
            ruleEnumLiterals();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumRule6239); 

            			doneLeaf(otherlv_6, elementTypeProvider.getEnumRule_SemicolonKeyword_5ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2098:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2098:22: ( ruleEnumLiterals EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2099:2: ruleEnumLiterals EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals6259);
            ruleEnumLiterals();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals6265); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2105:1: ruleEnumLiterals : ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final void ruleEnumLiterals() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2105:17: ( ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2106:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2106:2: ( ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2107:3: ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6282);
            ruleEnumLiteralDeclaration();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2114:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==25) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2115:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2115:4: ()
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2116:5: 
                    {

                    					precedeComposite(elementTypeProvider.getEnumLiterals_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2121:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    int cnt53=0;
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==25) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2122:5: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumLiterals6325); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getEnumLiterals_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2129:5: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2130:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2130:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2131:7: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							markComposite(elementTypeProvider.getEnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6362);
                    	    ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt53 >= 1 ) break loop53;
                                EarlyExitException eee =
                                    new EarlyExitException(53, input);
                                throw eee;
                        }
                        cnt53++;
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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2146:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2146:32: ( ruleEnumLiteralDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2147:2: ruleEnumLiteralDeclaration EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration6410);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration6416); 

            }

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
    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2153:1: ruleEnumLiteralDeclaration : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2153:27: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2154:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2154:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2155:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2155:3: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2156:4: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2156:4: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2157:5: otherlv_0= RULE_ID
            {

            					markLeaf();
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration6448); 

            					doneLeaf(otherlv_0, elementTypeProvider.getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2166:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==31) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2167:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEnumLiteralDeclaration6479); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2174:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2175:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2175:5: (lv_literal_2_0= ruleKeyword )
                    // ../../intellij/org.eclipse.xtext.lang.idea/src-gen/org/eclipse/xtext/idea/parser/antlr/internal/PsiInternalXtext.g:2176:6: lv_literal_2_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration6511);
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
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammar60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleGrammar79 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar106 = new BitSet(new long[]{0x0000210000145010L});
        public static final BitSet FOLLOW_12_in_ruleGrammar137 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar167 = new BitSet(new long[]{0x0000210000147010L});
        public static final BitSet FOLLOW_13_in_ruleGrammar204 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar239 = new BitSet(new long[]{0x0000210000147010L});
        public static final BitSet FOLLOW_14_in_ruleGrammar302 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleGrammar332 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar373 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleGrammar416 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar458 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleGrammar507 = new BitSet(new long[]{0x0000210000145010L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar540 = new BitSet(new long[]{0x0000210000145010L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar579 = new BitSet(new long[]{0x0000210000145012L});
        public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID611 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID636 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleGrammarID656 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID673 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule699 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_ruleAbstractRule762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration782 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel845 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel870 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel897 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel935 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel966 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1037 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1062 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1089 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1120 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1191 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1229 = new BitSet(new long[]{0x0000000000604000L});
        public static final BitSet FOLLOW_21_in_ruleParserRule1260 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1292 = new BitSet(new long[]{0x0000000000404000L});
        public static final BitSet FOLLOW_14_in_ruleParserRule1346 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleParserRule1376 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1417 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleParserRule1460 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1502 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleParserRule1551 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleParserRule1571 = new BitSet(new long[]{0x0000001840008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1598 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleParserRule1623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1643 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1689 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleTypeRef1719 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1783 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1806 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAlternatives1849 = new BitSet(new long[]{0x0000001840008030L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1886 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup1934 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroup1940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup1957 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleUnorderedGroup2000 = new BitSet(new long[]{0x0000001840008030L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup2037 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2085 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup2091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2108 = new BitSet(new long[]{0x0000001840008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2159 = new BitSet(new long[]{0x0000001840008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2199 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2291 = new BitSet(new long[]{0x0000000038000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2315 = new BitSet(new long[]{0x0000000038000002L});
        public static final BitSet FOLLOW_27_in_ruleAbstractTokenWithCardinality2355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAbstractTokenWithCardinality2389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAbstractTokenWithCardinality2423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2462 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction2468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleAction2487 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2514 = new BitSet(new long[]{0x0000000400020000L});
        public static final BitSet FOLLOW_17_in_ruleAction2545 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAction2577 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleAction2631 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_32_in_ruleAction2669 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleAction2707 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAction2727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2747 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedKeyword_in_ruleAbstractTerminal2830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedRuleCall_in_ruleAbstractTerminal2850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedGroup_in_ruleAbstractTerminal2870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2946 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedKeyword_in_entryRulePredicatedKeyword3002 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedKeyword3008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rulePredicatedKeyword3048 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_36_in_rulePredicatedKeyword3102 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_rulePredicatedKeyword3147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedRuleCall_in_entryRulePredicatedRuleCall3178 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedRuleCall3184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rulePredicatedRuleCall3224 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_36_in_rulePredicatedRuleCall3278 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePredicatedRuleCall3323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3354 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleAssignment3400 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_36_in_ruleAssignment3454 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3500 = new BitSet(new long[]{0x0000002180000000L});
        public static final BitSet FOLLOW_32_in_ruleAssignment3546 = new BitSet(new long[]{0x0000004000008030L});
        public static final BitSet FOLLOW_31_in_ruleAssignment3580 = new BitSet(new long[]{0x0000004000008030L});
        public static final BitSet FOLLOW_37_in_ruleAssignment3614 = new BitSet(new long[]{0x0000004000008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment3659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3690 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal3696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal3713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement3818 = new BitSet(new long[]{0x0000004000008030L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3830 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement3844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3864 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives3870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3887 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAssignableAlternatives3930 = new BitSet(new long[]{0x0000004000008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3967 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4015 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleCrossReference4040 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4067 = new BitSet(new long[]{0x0000008002000000L});
        public static final BitSet FOLLOW_25_in_ruleCrossReference4098 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference4130 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleCrossReference4163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal4183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal4189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal4206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal4226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4246 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedElement4271 = new BitSet(new long[]{0x0000001840008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4283 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedElement4297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicatedGroup_in_entryRulePredicatedGroup4317 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicatedGroup4323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rulePredicatedGroup4363 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_36_in_rulePredicatedGroup4417 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_rulePredicatedGroup4449 = new BitSet(new long[]{0x0000001840008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rulePredicatedGroup4476 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_rulePredicatedGroup4501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule4521 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule4527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleTerminalRule4546 = new BitSet(new long[]{0x0000020000000010L});
        public static final BitSet FOLLOW_41_in_ruleTerminalRule4590 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule4642 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule4713 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleTerminalRule4756 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule4798 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleTerminalRule4848 = new BitSet(new long[]{0x00000C1000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4875 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTerminalRule4900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4920 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives4926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4943 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleTerminalAlternatives4986 = new BitSet(new long[]{0x00000C1000028030L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives5023 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup5071 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup5077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup5094 = new BitSet(new long[]{0x00000C1000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup5145 = new BitSet(new long[]{0x00000C1000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken5185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken5191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken5208 = new BitSet(new long[]{0x0000000038000002L});
        public static final BitSet FOLLOW_27_in_ruleTerminalToken5243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleTerminalToken5277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleTerminalToken5311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement5350 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement5356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement5373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement5393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement5413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement5433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement5453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOF_in_ruleTerminalTokenElement5473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement5493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement5499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement5518 = new BitSet(new long[]{0x00000C1000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement5530 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement5544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken5564 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken5570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken5587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken5607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken5627 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken5633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleNegatedToken5652 = new BitSet(new long[]{0x00000C1000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken5710 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken5716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUntilToken5735 = new BitSet(new long[]{0x00000C1000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard5793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard5799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleWildcard5831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOF_in_entryRuleEOF5851 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEOF5857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEOF5889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange5915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5932 = new BitSet(new long[]{0x0000100000000002L});
        public static final BitSet FOLLOW_44_in_ruleCharacterRange5968 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange6000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule6039 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule6045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEnumRule6064 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumRule6091 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleEnumRule6122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleEnumRule6154 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEnumRule6187 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule6214 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleEnumRule6239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals6259 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals6265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6282 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleEnumLiterals6325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6362 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration6410 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration6416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration6448 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_31_in_ruleEnumLiteralDeclaration6479 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration6511 = new BitSet(new long[]{0x0000000000000002L});
    }


}