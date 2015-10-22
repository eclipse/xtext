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
    public String getGrammarFileName() { return "PsiInternalXtextGrammarTestLanguage.g"; }



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
    // PsiInternalXtextGrammarTestLanguage.g:52:1: entryRuleGrammar returns [Boolean current=false] : iv_ruleGrammar= ruleGrammar EOF ;
    public final Boolean entryRuleGrammar() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGrammar = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:52:49: (iv_ruleGrammar= ruleGrammar EOF )
            // PsiInternalXtextGrammarTestLanguage.g:53:2: iv_ruleGrammar= ruleGrammar EOF
            {
             markComposite(elementTypeProvider.getGrammarElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGrammar=ruleGrammar();

            state._fsp--;

             current =iv_ruleGrammar; 
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
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // PsiInternalXtextGrammarTestLanguage.g:59:1: ruleGrammar returns [Boolean current=false] : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ ) ;
    public final Boolean ruleGrammar() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_name_1_0 = null;

        Boolean this_HiddenClause_6 = null;

        Boolean lv_metamodelDeclarations_7_0 = null;

        Boolean lv_rules_8_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:60:1: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ ) )
            // PsiInternalXtextGrammarTestLanguage.g:61:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ )
            {
            // PsiInternalXtextGrammarTestLanguage.g:61:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ )
            // PsiInternalXtextGrammarTestLanguage.g:62:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+
            {

            			markLeaf(elementTypeProvider.getGrammar_GrammarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:69:3: ( (lv_name_1_0= ruleGrammarID ) )
            // PsiInternalXtextGrammarTestLanguage.g:70:4: (lv_name_1_0= ruleGrammarID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:70:4: (lv_name_1_0= ruleGrammarID )
            // PsiInternalXtextGrammarTestLanguage.g:71:5: lv_name_1_0= ruleGrammarID
            {

            					markComposite(elementTypeProvider.getGrammar_NameGrammarIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_name_1_0=ruleGrammarID();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:84:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:85:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {

                    				markLeaf(elementTypeProvider.getGrammar_WithKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:92:4: ( ( ruleGrammarID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:93:5: ( ruleGrammarID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:93:5: ( ruleGrammarID )
                    // PsiInternalXtextGrammarTestLanguage.g:94:6: ruleGrammarID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markComposite(elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_5);
                    ruleGrammarID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalXtextGrammarTestLanguage.g:109:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalXtextGrammarTestLanguage.g:110:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getGrammar_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:117:5: ( ( ruleGrammarID ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:118:6: ( ruleGrammarID )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:118:6: ( ruleGrammarID )
                    	    // PsiInternalXtextGrammarTestLanguage.g:119:7: ruleGrammarID
                    	    {

                    	    							if (!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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

            // PsiInternalXtextGrammarTestLanguage.g:136:3: (this_HiddenClause_6= ruleHiddenClause[$current] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:137:4: this_HiddenClause_6= ruleHiddenClause[$current]
                    {

                    				markComposite(elementTypeProvider.getGrammar_HiddenClauseParserRuleCall_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_HiddenClause_6=ruleHiddenClause(current);

                    state._fsp--;


                    				current = this_HiddenClause_6;
                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalXtextGrammarTestLanguage.g:146:3: ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalXtextGrammarTestLanguage.g:147:4: (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // PsiInternalXtextGrammarTestLanguage.g:147:4: (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration )
            	    // PsiInternalXtextGrammarTestLanguage.g:148:5: lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_metamodelDeclarations_7_0=ruleAbstractMetamodelDeclaration();

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
            	    break loop4;
                }
            } while (true);

            // PsiInternalXtextGrammarTestLanguage.g:161:3: ( (lv_rules_8_0= ruleAbstractRule ) )+
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
            	    // PsiInternalXtextGrammarTestLanguage.g:162:4: (lv_rules_8_0= ruleAbstractRule )
            	    {
            	    // PsiInternalXtextGrammarTestLanguage.g:162:4: (lv_rules_8_0= ruleAbstractRule )
            	    // PsiInternalXtextGrammarTestLanguage.g:163:5: lv_rules_8_0= ruleAbstractRule
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_rules_8_0=ruleAbstractRule();

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
        return current;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "ruleHiddenClause"
    // PsiInternalXtextGrammarTestLanguage.g:181:1: ruleHiddenClause[Boolean in_current] returns [Boolean current=in_current] : ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' ) ;
    public final Boolean ruleHiddenClause(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_definesHiddenTokens_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:182:1: ( ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' ) )
            // PsiInternalXtextGrammarTestLanguage.g:183:2: ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:183:2: ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' )
            // PsiInternalXtextGrammarTestLanguage.g:184:3: ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')'
            {
            // PsiInternalXtextGrammarTestLanguage.g:184:3: ( (lv_definesHiddenTokens_0_0= 'hidden' ) )
            // PsiInternalXtextGrammarTestLanguage.g:185:4: (lv_definesHiddenTokens_0_0= 'hidden' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:185:4: (lv_definesHiddenTokens_0_0= 'hidden' )
            // PsiInternalXtextGrammarTestLanguage.g:186:5: lv_definesHiddenTokens_0_0= 'hidden'
            {

            					markLeaf(elementTypeProvider.getHiddenClause_DefinesHiddenTokensHiddenKeyword_0_0ElementType());
            				
            lv_definesHiddenTokens_0_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_definesHiddenTokens_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getHiddenClause_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalXtextGrammarTestLanguage.g:208:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:209:4: ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:209:4: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:210:5: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:210:5: (otherlv_2= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:211:6: otherlv_2= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getHiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0ElementType());
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						doneLeaf(otherlv_2);
                    					

                    }


                    }

                    // PsiInternalXtextGrammarTestLanguage.g:226:4: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // PsiInternalXtextGrammarTestLanguage.g:227:5: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getHiddenClause_CommaKeyword_2_1_0ElementType());
                    	    				
                    	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_3);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:234:5: ( (otherlv_4= RULE_ID ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:235:6: (otherlv_4= RULE_ID )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:235:6: (otherlv_4= RULE_ID )
                    	    // PsiInternalXtextGrammarTestLanguage.g:236:7: otherlv_4= RULE_ID
                    	    {

                    	    							if (!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    							markLeaf(elementTypeProvider.getHiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0ElementType());
                    	    						
                    	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

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
    // $ANTLR end "ruleHiddenClause"


    // $ANTLR start "entryRuleGrammarID"
    // PsiInternalXtextGrammarTestLanguage.g:264:1: entryRuleGrammarID returns [Boolean current=false] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final Boolean entryRuleGrammarID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGrammarID = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:264:51: (iv_ruleGrammarID= ruleGrammarID EOF )
            // PsiInternalXtextGrammarTestLanguage.g:265:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             markComposite(elementTypeProvider.getGrammarIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGrammarID=ruleGrammarID();

            state._fsp--;

             current =iv_ruleGrammarID; 
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
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // PsiInternalXtextGrammarTestLanguage.g:271:1: ruleGrammarID returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleGrammarID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:272:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalXtextGrammarTestLanguage.g:273:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalXtextGrammarTestLanguage.g:273:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalXtextGrammarTestLanguage.g:274:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getGrammarID_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:281:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalXtextGrammarTestLanguage.g:282:4: kw= '.' this_ID_2= RULE_ID
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
        return current;
    }
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // PsiInternalXtextGrammarTestLanguage.g:301:1: entryRuleAbstractRule returns [Boolean current=false] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final Boolean entryRuleAbstractRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractRule = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:301:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // PsiInternalXtextGrammarTestLanguage.g:302:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // PsiInternalXtextGrammarTestLanguage.g:308:1: ruleAbstractRule returns [Boolean current=false] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final Boolean ruleAbstractRule() throws RecognitionException {
        Boolean current = false;

        Boolean this_ParserRule_0 = null;

        Boolean this_TerminalRule_1 = null;

        Boolean this_EnumRule_2 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:309:1: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // PsiInternalXtextGrammarTestLanguage.g:310:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // PsiInternalXtextGrammarTestLanguage.g:310:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
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
                    // PsiInternalXtextGrammarTestLanguage.g:311:3: this_ParserRule_0= ruleParserRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParserRule_0=ruleParserRule();

                    state._fsp--;


                    			current = this_ParserRule_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:320:3: this_TerminalRule_1= ruleTerminalRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_TerminalRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TerminalRule_1=ruleTerminalRule();

                    state._fsp--;


                    			current = this_TerminalRule_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextGrammarTestLanguage.g:329:3: this_EnumRule_2= ruleEnumRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_EnumRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EnumRule_2=ruleEnumRule();

                    state._fsp--;


                    			current = this_EnumRule_2;
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
        return current;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // PsiInternalXtextGrammarTestLanguage.g:341:1: entryRuleAbstractMetamodelDeclaration returns [Boolean current=false] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final Boolean entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:341:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // PsiInternalXtextGrammarTestLanguage.g:342:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             markComposite(elementTypeProvider.getAbstractMetamodelDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();

            state._fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
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
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // PsiInternalXtextGrammarTestLanguage.g:348:1: ruleAbstractMetamodelDeclaration returns [Boolean current=false] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final Boolean ruleAbstractMetamodelDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean this_GeneratedMetamodel_0 = null;

        Boolean this_ReferencedMetamodel_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:349:1: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // PsiInternalXtextGrammarTestLanguage.g:350:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // PsiInternalXtextGrammarTestLanguage.g:350:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    // PsiInternalXtextGrammarTestLanguage.g:351:3: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();

                    state._fsp--;


                    			current = this_GeneratedMetamodel_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:360:3: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {

                    			markComposite(elementTypeProvider.getAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();

                    state._fsp--;


                    			current = this_ReferencedMetamodel_1;
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
        return current;
    }
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // PsiInternalXtextGrammarTestLanguage.g:372:1: entryRuleGeneratedMetamodel returns [Boolean current=false] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final Boolean entryRuleGeneratedMetamodel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGeneratedMetamodel = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:372:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // PsiInternalXtextGrammarTestLanguage.g:373:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             markComposite(elementTypeProvider.getGeneratedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();

            state._fsp--;

             current =iv_ruleGeneratedMetamodel; 
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
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // PsiInternalXtextGrammarTestLanguage.g:379:1: ruleGeneratedMetamodel returns [Boolean current=false] : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final Boolean ruleGeneratedMetamodel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:380:1: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:381:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:381:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // PsiInternalXtextGrammarTestLanguage.g:382:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getGeneratedMetamodel_GenerateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:389:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:390:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:390:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:391:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:406:3: ( (otherlv_2= RULE_STRING ) )
            // PsiInternalXtextGrammarTestLanguage.g:407:4: (otherlv_2= RULE_STRING )
            {
            // PsiInternalXtextGrammarTestLanguage.g:407:4: (otherlv_2= RULE_STRING )
            // PsiInternalXtextGrammarTestLanguage.g:408:5: otherlv_2= RULE_STRING
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            					doneLeaf(otherlv_2);
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:423:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:424:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getGeneratedMetamodel_AsKeyword_3_0ElementType());
                    			
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:431:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:432:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:432:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:433:6: lv_alias_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
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
        return current;
    }
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // PsiInternalXtextGrammarTestLanguage.g:453:1: entryRuleReferencedMetamodel returns [Boolean current=false] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final Boolean entryRuleReferencedMetamodel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleReferencedMetamodel = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:453:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // PsiInternalXtextGrammarTestLanguage.g:454:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             markComposite(elementTypeProvider.getReferencedMetamodelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();

            state._fsp--;

             current =iv_ruleReferencedMetamodel; 
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
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // PsiInternalXtextGrammarTestLanguage.g:460:1: ruleReferencedMetamodel returns [Boolean current=false] : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final Boolean ruleReferencedMetamodel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:461:1: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:462:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:462:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // PsiInternalXtextGrammarTestLanguage.g:463:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getReferencedMetamodel_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:470:3: ( (otherlv_1= RULE_STRING ) )
            // PsiInternalXtextGrammarTestLanguage.g:471:4: (otherlv_1= RULE_STRING )
            {
            // PsiInternalXtextGrammarTestLanguage.g:471:4: (otherlv_1= RULE_STRING )
            // PsiInternalXtextGrammarTestLanguage.g:472:5: otherlv_1= RULE_STRING
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:487:3: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:488:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getReferencedMetamodel_AsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:495:4: ( (lv_alias_3_0= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:496:5: (lv_alias_3_0= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:496:5: (lv_alias_3_0= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:497:6: lv_alias_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
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
        return current;
    }
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // PsiInternalXtextGrammarTestLanguage.g:517:1: entryRuleParserRule returns [Boolean current=false] : iv_ruleParserRule= ruleParserRule EOF ;
    public final Boolean entryRuleParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParserRule = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:517:52: (iv_ruleParserRule= ruleParserRule EOF )
            // PsiInternalXtextGrammarTestLanguage.g:518:2: iv_ruleParserRule= ruleParserRule EOF
            {
             markComposite(elementTypeProvider.getParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRule=ruleParserRule();

            state._fsp--;

             current =iv_ruleParserRule; 
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
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // PsiInternalXtextGrammarTestLanguage.g:524:1: ruleParserRule returns [Boolean current=false] : ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' ) ;
    public final Boolean ruleParserRule() throws RecognitionException {
        Boolean current = false;

        Token lv_fragment_0_0=null;
        Token lv_wildcard_2_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Boolean this_RuleNameAndParams_1 = null;

        Boolean this_ReturnsClause_3 = null;

        Boolean this_RuleNameAndParams_4 = null;

        Boolean this_ReturnsClause_5 = null;

        Boolean this_HiddenClause_6 = null;

        Boolean lv_alternatives_8_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:525:1: ( ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' ) )
            // PsiInternalXtextGrammarTestLanguage.g:526:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:526:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            // PsiInternalXtextGrammarTestLanguage.g:527:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';'
            {
            // PsiInternalXtextGrammarTestLanguage.g:527:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) )
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
                    // PsiInternalXtextGrammarTestLanguage.g:528:4: ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:528:4: ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) )
                    // PsiInternalXtextGrammarTestLanguage.g:529:5: ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:529:5: ( (lv_fragment_0_0= 'fragment' ) )
                    // PsiInternalXtextGrammarTestLanguage.g:530:6: (lv_fragment_0_0= 'fragment' )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:530:6: (lv_fragment_0_0= 'fragment' )
                    // PsiInternalXtextGrammarTestLanguage.g:531:7: lv_fragment_0_0= 'fragment'
                    {

                    							markLeaf(elementTypeProvider.getParserRule_FragmentFragmentKeyword_0_0_0_0ElementType());
                    						
                    lv_fragment_0_0=(Token)match(input,21,FollowSets000.FOLLOW_13); 

                    							doneLeaf(lv_fragment_0_0);
                    						

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    }


                    }


                    					markComposite(elementTypeProvider.getParserRule_RuleNameAndParamsParserRuleCall_0_0_1ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_14);
                    this_RuleNameAndParams_1=ruleRuleNameAndParams(current);

                    state._fsp--;


                    					current = this_RuleNameAndParams_1;
                    					doneComposite();
                    				
                    // PsiInternalXtextGrammarTestLanguage.g:554:5: ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? )
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
                            // PsiInternalXtextGrammarTestLanguage.g:555:6: ( (lv_wildcard_2_0= '*' ) )
                            {
                            // PsiInternalXtextGrammarTestLanguage.g:555:6: ( (lv_wildcard_2_0= '*' ) )
                            // PsiInternalXtextGrammarTestLanguage.g:556:7: (lv_wildcard_2_0= '*' )
                            {
                            // PsiInternalXtextGrammarTestLanguage.g:556:7: (lv_wildcard_2_0= '*' )
                            // PsiInternalXtextGrammarTestLanguage.g:557:8: lv_wildcard_2_0= '*'
                            {

                            								markLeaf(elementTypeProvider.getParserRule_WildcardAsteriskKeyword_0_0_2_0_0ElementType());
                            							
                            lv_wildcard_2_0=(Token)match(input,22,FollowSets000.FOLLOW_15); 

                            								doneLeaf(lv_wildcard_2_0);
                            							

                            								if (!current) {
                            									associateWithSemanticElement();
                            									current = true;
                            								}
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalXtextGrammarTestLanguage.g:573:6: (this_ReturnsClause_3= ruleReturnsClause[$current] )?
                            {
                            // PsiInternalXtextGrammarTestLanguage.g:573:6: (this_ReturnsClause_3= ruleReturnsClause[$current] )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==27) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // PsiInternalXtextGrammarTestLanguage.g:574:7: this_ReturnsClause_3= ruleReturnsClause[$current]
                                    {

                                    							markComposite(elementTypeProvider.getParserRule_ReturnsClauseParserRuleCall_0_0_2_1ElementType());
                                    						
                                    pushFollow(FollowSets000.FOLLOW_15);
                                    this_ReturnsClause_3=ruleReturnsClause(current);

                                    state._fsp--;


                                    							current = this_ReturnsClause_3;
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
                    // PsiInternalXtextGrammarTestLanguage.g:586:4: (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:586:4: (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? )
                    // PsiInternalXtextGrammarTestLanguage.g:587:5: this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )?
                    {

                    					markComposite(elementTypeProvider.getParserRule_RuleNameAndParamsParserRuleCall_0_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_16);
                    this_RuleNameAndParams_4=ruleRuleNameAndParams(current);

                    state._fsp--;


                    					current = this_RuleNameAndParams_4;
                    					doneComposite();
                    				
                    // PsiInternalXtextGrammarTestLanguage.g:595:5: (this_ReturnsClause_5= ruleReturnsClause[$current] )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==27) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // PsiInternalXtextGrammarTestLanguage.g:596:6: this_ReturnsClause_5= ruleReturnsClause[$current]
                            {

                            						markComposite(elementTypeProvider.getParserRule_ReturnsClauseParserRuleCall_0_1_1ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_15);
                            this_ReturnsClause_5=ruleReturnsClause(current);

                            state._fsp--;


                            						current = this_ReturnsClause_5;
                            						doneComposite();
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // PsiInternalXtextGrammarTestLanguage.g:607:3: (this_HiddenClause_6= ruleHiddenClause[$current] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:608:4: this_HiddenClause_6= ruleHiddenClause[$current]
                    {

                    				markComposite(elementTypeProvider.getParserRule_HiddenClauseParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_17);
                    this_HiddenClause_6=ruleHiddenClause(current);

                    state._fsp--;


                    				current = this_HiddenClause_6;
                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getParserRule_ColonKeyword_2ElementType());
            		
            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_7);
            		
            // PsiInternalXtextGrammarTestLanguage.g:624:3: ( (lv_alternatives_8_0= ruleAlternatives ) )
            // PsiInternalXtextGrammarTestLanguage.g:625:4: (lv_alternatives_8_0= ruleAlternatives )
            {
            // PsiInternalXtextGrammarTestLanguage.g:625:4: (lv_alternatives_8_0= ruleAlternatives )
            // PsiInternalXtextGrammarTestLanguage.g:626:5: lv_alternatives_8_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getParserRule_AlternativesAlternativesParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_19);
            lv_alternatives_8_0=ruleAlternatives();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getParserRule_SemicolonKeyword_4ElementType());
            		
            otherlv_9=(Token)match(input,24,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "ruleRuleNameAndParams"
    // PsiInternalXtextGrammarTestLanguage.g:651:1: ruleRuleNameAndParams[Boolean in_current] returns [Boolean current=in_current] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? ) ;
    public final Boolean ruleRuleNameAndParams(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean lv_parameters_2_0 = null;

        Boolean lv_parameters_4_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:652:1: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:653:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:653:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? )
            // PsiInternalXtextGrammarTestLanguage.g:654:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )?
            {
            // PsiInternalXtextGrammarTestLanguage.g:654:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:655:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:655:4: (lv_name_0_0= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:656:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRuleNameAndParams_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:671:3: (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:672:4: otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']'
                    {

                    				markLeaf(elementTypeProvider.getRuleNameAndParams_LeftSquareBracketKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_21); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:679:4: ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_ID) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // PsiInternalXtextGrammarTestLanguage.g:680:5: ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            {
                            // PsiInternalXtextGrammarTestLanguage.g:680:5: ( (lv_parameters_2_0= ruleParameter ) )
                            // PsiInternalXtextGrammarTestLanguage.g:681:6: (lv_parameters_2_0= ruleParameter )
                            {
                            // PsiInternalXtextGrammarTestLanguage.g:681:6: (lv_parameters_2_0= ruleParameter )
                            // PsiInternalXtextGrammarTestLanguage.g:682:7: lv_parameters_2_0= ruleParameter
                            {

                            							markComposite(elementTypeProvider.getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_22);
                            lv_parameters_2_0=ruleParameter();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }


                            }

                            // PsiInternalXtextGrammarTestLanguage.g:695:5: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==13) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // PsiInternalXtextGrammarTestLanguage.g:696:6: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getRuleNameAndParams_CommaKeyword_1_1_1_0ElementType());
                            	    					
                            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            	    						doneLeaf(otherlv_3);
                            	    					
                            	    // PsiInternalXtextGrammarTestLanguage.g:703:6: ( (lv_parameters_4_0= ruleParameter ) )
                            	    // PsiInternalXtextGrammarTestLanguage.g:704:7: (lv_parameters_4_0= ruleParameter )
                            	    {
                            	    // PsiInternalXtextGrammarTestLanguage.g:704:7: (lv_parameters_4_0= ruleParameter )
                            	    // PsiInternalXtextGrammarTestLanguage.g:705:8: lv_parameters_4_0= ruleParameter
                            	    {

                            	    								markComposite(elementTypeProvider.getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0ElementType());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_22);
                            	    lv_parameters_4_0=ruleParameter();

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
                            	    break loop18;
                                }
                            } while (true);


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getRuleNameAndParams_RightSquareBracketKeyword_1_2ElementType());
                    			
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleRuleNameAndParams"


    // $ANTLR start "ruleReturnsClause"
    // PsiInternalXtextGrammarTestLanguage.g:733:1: ruleReturnsClause[Boolean in_current] returns [Boolean current=in_current] : (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) ) ;
    public final Boolean ruleReturnsClause(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token otherlv_0=null;
        Boolean lv_type_1_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:734:1: ( (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:735:2: (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:735:2: (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:736:3: otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) )
            {

            			markLeaf(elementTypeProvider.getReturnsClause_ReturnsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:743:3: ( (lv_type_1_0= ruleTypeRef ) )
            // PsiInternalXtextGrammarTestLanguage.g:744:4: (lv_type_1_0= ruleTypeRef )
            {
            // PsiInternalXtextGrammarTestLanguage.g:744:4: (lv_type_1_0= ruleTypeRef )
            // PsiInternalXtextGrammarTestLanguage.g:745:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getReturnsClause_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleReturnsClause"


    // $ANTLR start "entryRuleParameter"
    // PsiInternalXtextGrammarTestLanguage.g:762:1: entryRuleParameter returns [Boolean current=false] : iv_ruleParameter= ruleParameter EOF ;
    public final Boolean entryRuleParameter() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameter = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:762:51: (iv_ruleParameter= ruleParameter EOF )
            // PsiInternalXtextGrammarTestLanguage.g:763:2: iv_ruleParameter= ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // PsiInternalXtextGrammarTestLanguage.g:769:1: ruleParameter returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleParameter() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:770:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:771:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:771:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:772:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:772:3: (lv_name_0_0= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:773:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getParameter_NameIDTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeRef"
    // PsiInternalXtextGrammarTestLanguage.g:791:1: entryRuleTypeRef returns [Boolean current=false] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final Boolean entryRuleTypeRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeRef = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:791:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // PsiInternalXtextGrammarTestLanguage.g:792:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             markComposite(elementTypeProvider.getTypeRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;

             current =iv_ruleTypeRef; 
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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // PsiInternalXtextGrammarTestLanguage.g:798:1: ruleTypeRef returns [Boolean current=false] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final Boolean ruleTypeRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:799:1: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:800:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:800:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:801:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:801:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
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
                    // PsiInternalXtextGrammarTestLanguage.g:802:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:802:4: ( (otherlv_0= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:803:5: (otherlv_0= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:803:5: (otherlv_0= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:804:6: otherlv_0= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType());
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

                    						doneLeaf(otherlv_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getTypeRef_ColonColonKeyword_0_1ElementType());
                    			
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;

            }

            // PsiInternalXtextGrammarTestLanguage.g:827:3: ( (otherlv_2= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:828:4: (otherlv_2= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:828:4: (otherlv_2= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:829:5: otherlv_2= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // PsiInternalXtextGrammarTestLanguage.g:848:1: entryRuleAlternatives returns [Boolean current=false] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final Boolean entryRuleAlternatives() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAlternatives = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:848:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // PsiInternalXtextGrammarTestLanguage.g:849:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             markComposite(elementTypeProvider.getAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternatives=ruleAlternatives();

            state._fsp--;

             current =iv_ruleAlternatives; 
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
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // PsiInternalXtextGrammarTestLanguage.g:855:1: ruleAlternatives returns [Boolean current=false] : (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) ;
    public final Boolean ruleAlternatives() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_ConditionalBranch_0 = null;

        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:856:1: ( (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:857:2: (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:857:2: (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            // PsiInternalXtextGrammarTestLanguage.g:858:3: this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAlternatives_ConditionalBranchParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_ConditionalBranch_0=ruleConditionalBranch();

            state._fsp--;


            			current = this_ConditionalBranch_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:866:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:867:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:867:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:868:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:874:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
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
                    	    // PsiInternalXtextGrammarTestLanguage.g:875:5: otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_18); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:882:5: ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:883:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:883:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    // PsiInternalXtextGrammarTestLanguage.g:884:7: lv_elements_3_0= ruleConditionalBranch
                    	    {

                    	    							markComposite(elementTypeProvider.getAlternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleConditionalBranch();

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
        return current;
    }
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleConditionalBranch"
    // PsiInternalXtextGrammarTestLanguage.g:903:1: entryRuleConditionalBranch returns [Boolean current=false] : iv_ruleConditionalBranch= ruleConditionalBranch EOF ;
    public final Boolean entryRuleConditionalBranch() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleConditionalBranch = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:903:59: (iv_ruleConditionalBranch= ruleConditionalBranch EOF )
            // PsiInternalXtextGrammarTestLanguage.g:904:2: iv_ruleConditionalBranch= ruleConditionalBranch EOF
            {
             markComposite(elementTypeProvider.getConditionalBranchElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConditionalBranch=ruleConditionalBranch();

            state._fsp--;

             current =iv_ruleConditionalBranch; 
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
    // $ANTLR end "entryRuleConditionalBranch"


    // $ANTLR start "ruleConditionalBranch"
    // PsiInternalXtextGrammarTestLanguage.g:910:1: ruleConditionalBranch returns [Boolean current=false] : (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) ) ;
    public final Boolean ruleConditionalBranch() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Boolean this_UnorderedGroup_0 = null;

        Boolean lv_filtered_3_0 = null;

        Boolean lv_guardedElement_6_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:911:1: ( (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:912:2: (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:912:2: (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) )
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
                    // PsiInternalXtextGrammarTestLanguage.g:913:3: this_UnorderedGroup_0= ruleUnorderedGroup
                    {

                    			markComposite(elementTypeProvider.getConditionalBranch_UnorderedGroupParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnorderedGroup_0=ruleUnorderedGroup();

                    state._fsp--;


                    			current = this_UnorderedGroup_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:922:3: ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:922:3: ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) )
                    // PsiInternalXtextGrammarTestLanguage.g:923:4: () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:923:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:924:5: 
                    {

                    					precedeComposite(elementTypeProvider.getConditionalBranch_ConditionalBranchAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }


                    				markLeaf(elementTypeProvider.getConditionalBranch_LeftSquareBracketKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:937:4: ( (lv_filtered_3_0= ruleInverseLiteralValue ) )
                    // PsiInternalXtextGrammarTestLanguage.g:938:5: (lv_filtered_3_0= ruleInverseLiteralValue )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:938:5: (lv_filtered_3_0= ruleInverseLiteralValue )
                    // PsiInternalXtextGrammarTestLanguage.g:939:6: lv_filtered_3_0= ruleInverseLiteralValue
                    {

                    						markComposite(elementTypeProvider.getConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_filtered_3_0=ruleInverseLiteralValue();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalXtextGrammarTestLanguage.g:952:4: ( (otherlv_4= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:953:5: (otherlv_4= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:953:5: (otherlv_4= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:954:6: otherlv_4= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getConditionalBranch_ParameterParameterCrossReference_1_3_0ElementType());
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

                    						doneLeaf(otherlv_4);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getConditionalBranch_RightSquareBracketKeyword_1_4ElementType());
                    			
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_27); 

                    				doneLeaf(otherlv_5);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:976:4: ( (lv_guardedElement_6_0= ruleUnorderedGroup ) )
                    // PsiInternalXtextGrammarTestLanguage.g:977:5: (lv_guardedElement_6_0= ruleUnorderedGroup )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:977:5: (lv_guardedElement_6_0= ruleUnorderedGroup )
                    // PsiInternalXtextGrammarTestLanguage.g:978:6: lv_guardedElement_6_0= ruleUnorderedGroup
                    {

                    						markComposite(elementTypeProvider.getConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_guardedElement_6_0=ruleUnorderedGroup();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // PsiInternalXtextGrammarTestLanguage.g:996:1: entryRuleUnorderedGroup returns [Boolean current=false] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final Boolean entryRuleUnorderedGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroup = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:996:56: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // PsiInternalXtextGrammarTestLanguage.g:997:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroup=ruleUnorderedGroup();

            state._fsp--;

             current =iv_ruleUnorderedGroup; 
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
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // PsiInternalXtextGrammarTestLanguage.g:1003:1: ruleUnorderedGroup returns [Boolean current=false] : (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final Boolean ruleUnorderedGroup() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Group_0 = null;

        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1004:1: ( (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:1005:2: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1005:2: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // PsiInternalXtextGrammarTestLanguage.g:1006:3: this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getUnorderedGroup_GroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_28);
            this_Group_0=ruleGroup();

            state._fsp--;


            			current = this_Group_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:1014:3: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==30) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:1015:4: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1015:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:1016:5: 
                    {

                    					precedeComposite(elementTypeProvider.getUnorderedGroup_UnorderedGroupElementsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:1022:4: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
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
                    	    // PsiInternalXtextGrammarTestLanguage.g:1023:5: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getUnorderedGroup_AmpersandKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_27); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:1030:5: ( (lv_elements_3_0= ruleGroup ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:1031:6: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:1031:6: (lv_elements_3_0= ruleGroup )
                    	    // PsiInternalXtextGrammarTestLanguage.g:1032:7: lv_elements_3_0= ruleGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getUnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_28);
                    	    lv_elements_3_0=ruleGroup();

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
        return current;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // PsiInternalXtextGrammarTestLanguage.g:1051:1: entryRuleGroup returns [Boolean current=false] : iv_ruleGroup= ruleGroup EOF ;
    public final Boolean entryRuleGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGroup = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1051:47: (iv_ruleGroup= ruleGroup EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1052:2: iv_ruleGroup= ruleGroup EOF
            {
             markComposite(elementTypeProvider.getGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
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
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // PsiInternalXtextGrammarTestLanguage.g:1058:1: ruleGroup returns [Boolean current=false] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final Boolean ruleGroup() throws RecognitionException {
        Boolean current = false;

        Boolean this_AbstractToken_0 = null;

        Boolean lv_elements_2_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1059:1: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:1060:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1060:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // PsiInternalXtextGrammarTestLanguage.g:1061:3: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getGroup_AbstractTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_29);
            this_AbstractToken_0=ruleAbstractToken();

            state._fsp--;


            			current = this_AbstractToken_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:1069:3: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_STRING)||LA28_0==15||LA28_0==33||(LA28_0>=40 && LA28_0<=41)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:1070:4: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1070:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:1071:5: 
                    {

                    					precedeComposite(elementTypeProvider.getGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:1077:4: ( (lv_elements_2_0= ruleAbstractToken ) )+
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
                    	    // PsiInternalXtextGrammarTestLanguage.g:1078:5: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:1078:5: (lv_elements_2_0= ruleAbstractToken )
                    	    // PsiInternalXtextGrammarTestLanguage.g:1079:6: lv_elements_2_0= ruleAbstractToken
                    	    {

                    	    						markComposite(elementTypeProvider.getGroup_ElementsAbstractTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_29);
                    	    lv_elements_2_0=ruleAbstractToken();

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
        return current;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // PsiInternalXtextGrammarTestLanguage.g:1097:1: entryRuleAbstractToken returns [Boolean current=false] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final Boolean entryRuleAbstractToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractToken = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1097:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1098:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractToken=ruleAbstractToken();

            state._fsp--;

             current =iv_ruleAbstractToken; 
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
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // PsiInternalXtextGrammarTestLanguage.g:1104:1: ruleAbstractToken returns [Boolean current=false] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final Boolean ruleAbstractToken() throws RecognitionException {
        Boolean current = false;

        Boolean this_AbstractTokenWithCardinality_0 = null;

        Boolean this_Action_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1105:1: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // PsiInternalXtextGrammarTestLanguage.g:1106:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1106:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    // PsiInternalXtextGrammarTestLanguage.g:1107:3: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();

                    state._fsp--;


                    			current = this_AbstractTokenWithCardinality_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1116:3: this_Action_1= ruleAction
                    {

                    			markComposite(elementTypeProvider.getAbstractToken_ActionParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Action_1=ruleAction();

                    state._fsp--;


                    			current = this_Action_1;
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
        return current;
    }
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // PsiInternalXtextGrammarTestLanguage.g:1128:1: entryRuleAbstractTokenWithCardinality returns [Boolean current=false] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final Boolean entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractTokenWithCardinality = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1128:70: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1129:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             markComposite(elementTypeProvider.getAbstractTokenWithCardinalityElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();

            state._fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
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
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // PsiInternalXtextGrammarTestLanguage.g:1135:1: ruleAbstractTokenWithCardinality returns [Boolean current=false] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? ) ;
    public final Boolean ruleAbstractTokenWithCardinality() throws RecognitionException {
        Boolean current = false;

        Boolean this_Assignment_0 = null;

        Boolean this_AbstractTerminal_1 = null;

        Boolean this_Cardinalities_2 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1136:1: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:1137:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1137:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? )
            // PsiInternalXtextGrammarTestLanguage.g:1138:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )?
            {
            // PsiInternalXtextGrammarTestLanguage.g:1138:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
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

                if ( (LA30_2==RULE_ID) ) {
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
                else if ( (LA30_2==RULE_STRING||LA30_2==15) ) {
                    alt30=2;
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

                if ( ((LA30_3>=34 && LA30_3<=35)||LA30_3==39) ) {
                    alt30=1;
                }
                else if ( (LA30_3==EOF||(LA30_3>=RULE_ID && LA30_3<=RULE_STRING)||(LA30_3>=15 && LA30_3<=16)||LA30_3==22||(LA30_3>=24 && LA30_3<=25)||(LA30_3>=28 && LA30_3<=33)||(LA30_3>=40 && LA30_3<=41)) ) {
                    alt30=2;
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
                    // PsiInternalXtextGrammarTestLanguage.g:1139:4: this_Assignment_0= ruleAssignment
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_30);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;


                    				current = this_Assignment_0;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1148:4: this_AbstractTerminal_1= ruleAbstractTerminal
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_30);
                    this_AbstractTerminal_1=ruleAbstractTerminal();

                    state._fsp--;


                    				current = this_AbstractTerminal_1;
                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalXtextGrammarTestLanguage.g:1157:3: (this_Cardinalities_2= ruleCardinalities[$current] )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==22||(LA31_0>=31 && LA31_0<=32)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:1158:4: this_Cardinalities_2= ruleCardinalities[$current]
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_CardinalitiesParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Cardinalities_2=ruleCardinalities(current);

                    state._fsp--;


                    				current = this_Cardinalities_2;
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
        return current;
    }
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "ruleCardinalities"
    // PsiInternalXtextGrammarTestLanguage.g:1172:1: ruleCardinalities[Boolean in_current] returns [Boolean current=in_current] : ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) ) ;
    public final Boolean ruleCardinalities(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_cardinality_0_1=null;
        Token lv_cardinality_0_2=null;
        Token lv_cardinality_0_3=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:1173:1: ( ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1174:2: ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1174:2: ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1175:3: ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1175:3: ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) )
            // PsiInternalXtextGrammarTestLanguage.g:1176:4: (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1176:4: (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' )
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
                    // PsiInternalXtextGrammarTestLanguage.g:1177:5: lv_cardinality_0_1= '?'
                    {

                    					markLeaf(elementTypeProvider.getCardinalities_CardinalityQuestionMarkKeyword_0_0ElementType());
                    				
                    lv_cardinality_0_1=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_cardinality_0_1);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1191:5: lv_cardinality_0_2= '*'
                    {

                    					markLeaf(elementTypeProvider.getCardinalities_CardinalityAsteriskKeyword_0_1ElementType());
                    				
                    lv_cardinality_0_2=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_cardinality_0_2);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }
                    break;
                case 3 :
                    // PsiInternalXtextGrammarTestLanguage.g:1205:5: lv_cardinality_0_3= '+'
                    {

                    					markLeaf(elementTypeProvider.getCardinalities_CardinalityPlusSignKeyword_0_2ElementType());
                    				
                    lv_cardinality_0_3=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_cardinality_0_3);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
    }
    // $ANTLR end "ruleCardinalities"


    // $ANTLR start "entryRuleAction"
    // PsiInternalXtextGrammarTestLanguage.g:1224:1: entryRuleAction returns [Boolean current=false] : iv_ruleAction= ruleAction EOF ;
    public final Boolean entryRuleAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAction = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1224:48: (iv_ruleAction= ruleAction EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1225:2: iv_ruleAction= ruleAction EOF
            {
             markComposite(elementTypeProvider.getActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // PsiInternalXtextGrammarTestLanguage.g:1231:1: ruleAction returns [Boolean current=false] : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final Boolean ruleAction() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Boolean lv_type_1_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1232:1: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // PsiInternalXtextGrammarTestLanguage.g:1233:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1233:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // PsiInternalXtextGrammarTestLanguage.g:1234:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getAction_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:1241:3: ( (lv_type_1_0= ruleTypeRef ) )
            // PsiInternalXtextGrammarTestLanguage.g:1242:4: (lv_type_1_0= ruleTypeRef )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1242:4: (lv_type_1_0= ruleTypeRef )
            // PsiInternalXtextGrammarTestLanguage.g:1243:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getAction_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_31);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:1256:3: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==17) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:1257:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {

                    				markLeaf(elementTypeProvider.getAction_FullStopKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:1264:4: ( (lv_feature_3_0= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1265:5: (lv_feature_3_0= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1265:5: (lv_feature_3_0= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:1266:6: lv_feature_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAction_FeatureIDTerminalRuleCall_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

                    						doneLeaf(lv_feature_3_0);
                    					

                    }


                    }

                    // PsiInternalXtextGrammarTestLanguage.g:1281:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1282:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1282:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1283:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1283:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
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
                            // PsiInternalXtextGrammarTestLanguage.g:1284:7: lv_operator_4_1= '='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorEqualsSignKeyword_2_2_0_0ElementType());
                            						
                            lv_operator_4_1=(Token)match(input,34,FollowSets000.FOLLOW_33); 

                            							doneLeaf(lv_operator_4_1);
                            						

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalXtextGrammarTestLanguage.g:1298:7: lv_operator_4_2= '+='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType());
                            						
                            lv_operator_4_2=(Token)match(input,35,FollowSets000.FOLLOW_33); 

                            							doneLeaf(lv_operator_4_2);
                            						

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    				markLeaf(elementTypeProvider.getAction_CurrentKeyword_2_3ElementType());
                    			
                    otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_34); 

                    				doneLeaf(otherlv_5);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getAction_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // PsiInternalXtextGrammarTestLanguage.g:1333:1: entryRuleAbstractTerminal returns [Boolean current=false] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final Boolean entryRuleAbstractTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractTerminal = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1333:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1334:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             markComposite(elementTypeProvider.getAbstractTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();

            state._fsp--;

             current =iv_ruleAbstractTerminal; 
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
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // PsiInternalXtextGrammarTestLanguage.g:1340:1: ruleAbstractTerminal returns [Boolean current=false] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup ) ;
    public final Boolean ruleAbstractTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean this_Keyword_0 = null;

        Boolean this_RuleCall_1 = null;

        Boolean this_ParenthesizedElement_2 = null;

        Boolean this_PredicatedKeyword_3 = null;

        Boolean this_PredicatedRuleCall_4 = null;

        Boolean this_PredicatedGroup_5 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1341:1: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup ) )
            // PsiInternalXtextGrammarTestLanguage.g:1342:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1342:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup )
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
                case RULE_STRING:
                    {
                    alt35=4;
                    }
                    break;
                case RULE_ID:
                    {
                    alt35=5;
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
                    // PsiInternalXtextGrammarTestLanguage.g:1343:3: this_Keyword_0= ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1352:3: this_RuleCall_1= ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextGrammarTestLanguage.g:1361:3: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();

                    state._fsp--;


                    			current = this_ParenthesizedElement_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalXtextGrammarTestLanguage.g:1370:3: this_PredicatedKeyword_3= rulePredicatedKeyword
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedKeywordParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedKeyword_3=rulePredicatedKeyword();

                    state._fsp--;


                    			current = this_PredicatedKeyword_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalXtextGrammarTestLanguage.g:1379:3: this_PredicatedRuleCall_4= rulePredicatedRuleCall
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedRuleCallParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedRuleCall_4=rulePredicatedRuleCall();

                    state._fsp--;


                    			current = this_PredicatedRuleCall_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalXtextGrammarTestLanguage.g:1388:3: this_PredicatedGroup_5= rulePredicatedGroup
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_PredicatedGroupParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedGroup_5=rulePredicatedGroup();

                    state._fsp--;


                    			current = this_PredicatedGroup_5;
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
        return current;
    }
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // PsiInternalXtextGrammarTestLanguage.g:1400:1: entryRuleKeyword returns [Boolean current=false] : iv_ruleKeyword= ruleKeyword EOF ;
    public final Boolean entryRuleKeyword() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleKeyword = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1400:49: (iv_ruleKeyword= ruleKeyword EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1401:2: iv_ruleKeyword= ruleKeyword EOF
            {
             markComposite(elementTypeProvider.getKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
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
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // PsiInternalXtextGrammarTestLanguage.g:1407:1: ruleKeyword returns [Boolean current=false] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final Boolean ruleKeyword() throws RecognitionException {
        Boolean current = false;

        Token lv_value_0_0=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:1408:1: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1409:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1409:2: ( (lv_value_0_0= RULE_STRING ) )
            // PsiInternalXtextGrammarTestLanguage.g:1410:3: (lv_value_0_0= RULE_STRING )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1410:3: (lv_value_0_0= RULE_STRING )
            // PsiInternalXtextGrammarTestLanguage.g:1411:4: lv_value_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getKeyword_ValueSTRINGTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
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
        return current;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // PsiInternalXtextGrammarTestLanguage.g:1429:1: entryRuleRuleCall returns [Boolean current=false] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final Boolean entryRuleRuleCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRuleCall = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1429:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1430:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             markComposite(elementTypeProvider.getRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
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
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // PsiInternalXtextGrammarTestLanguage.g:1436:1: ruleRuleCall returns [Boolean current=false] : ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? ) ;
    public final Boolean ruleRuleCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_arguments_3_0 = null;

        Boolean lv_arguments_5_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1437:1: ( ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:1438:2: ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1438:2: ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? )
            // PsiInternalXtextGrammarTestLanguage.g:1439:3: () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )?
            {
            // PsiInternalXtextGrammarTestLanguage.g:1439:3: ()
            // PsiInternalXtextGrammarTestLanguage.g:1440:4: 
            {

            				precedeComposite(elementTypeProvider.getRuleCall_RuleCallAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalXtextGrammarTestLanguage.g:1446:3: ( ( ruleRuleID ) )
            // PsiInternalXtextGrammarTestLanguage.g:1447:4: ( ruleRuleID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1447:4: ( ruleRuleID )
            // PsiInternalXtextGrammarTestLanguage.g:1448:5: ruleRuleID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markComposite(elementTypeProvider.getRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_20);
            ruleRuleID();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:1463:3: (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:1464:4: otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']'
                    {

                    				markLeaf(elementTypeProvider.getRuleCall_LeftSquareBracketKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_35); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:1471:4: ( (lv_arguments_3_0= ruleNamedArgument ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1472:5: (lv_arguments_3_0= ruleNamedArgument )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1472:5: (lv_arguments_3_0= ruleNamedArgument )
                    // PsiInternalXtextGrammarTestLanguage.g:1473:6: lv_arguments_3_0= ruleNamedArgument
                    {

                    						markComposite(elementTypeProvider.getRuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_22);
                    lv_arguments_3_0=ruleNamedArgument();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalXtextGrammarTestLanguage.g:1486:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==13) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // PsiInternalXtextGrammarTestLanguage.g:1487:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getRuleCall_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_35); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:1494:5: ( (lv_arguments_5_0= ruleNamedArgument ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:1495:6: (lv_arguments_5_0= ruleNamedArgument )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:1495:6: (lv_arguments_5_0= ruleNamedArgument )
                    	    // PsiInternalXtextGrammarTestLanguage.g:1496:7: lv_arguments_5_0= ruleNamedArgument
                    	    {

                    	    							markComposite(elementTypeProvider.getRuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_arguments_5_0=ruleNamedArgument();

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
                    	    break loop36;
                        }
                    } while (true);


                    				markLeaf(elementTypeProvider.getRuleCall_RightSquareBracketKeyword_2_3ElementType());
                    			
                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleLiteralValue"
    // PsiInternalXtextGrammarTestLanguage.g:1522:1: entryRuleLiteralValue returns [Boolean current=false] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final Boolean entryRuleLiteralValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLiteralValue = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1522:54: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1523:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             markComposite(elementTypeProvider.getLiteralValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue; 
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
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // PsiInternalXtextGrammarTestLanguage.g:1529:1: ruleLiteralValue returns [Boolean current=false] : (kw= '!' | kw= '+' ) ;
    public final Boolean ruleLiteralValue() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:1530:1: ( (kw= '!' | kw= '+' ) )
            // PsiInternalXtextGrammarTestLanguage.g:1531:2: (kw= '!' | kw= '+' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1531:2: (kw= '!' | kw= '+' )
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
                    // PsiInternalXtextGrammarTestLanguage.g:1532:3: kw= '!'
                    {

                    			markLeaf(elementTypeProvider.getLiteralValue_ExclamationMarkKeyword_0ElementType());
                    		
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1540:3: kw= '+'
                    {

                    			markLeaf(elementTypeProvider.getLiteralValue_PlusSignKeyword_1ElementType());
                    		
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleInverseLiteralValue"
    // PsiInternalXtextGrammarTestLanguage.g:1551:1: entryRuleInverseLiteralValue returns [Boolean current=false] : iv_ruleInverseLiteralValue= ruleInverseLiteralValue EOF ;
    public final Boolean entryRuleInverseLiteralValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleInverseLiteralValue = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1551:61: (iv_ruleInverseLiteralValue= ruleInverseLiteralValue EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1552:2: iv_ruleInverseLiteralValue= ruleInverseLiteralValue EOF
            {
             markComposite(elementTypeProvider.getInverseLiteralValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInverseLiteralValue=ruleInverseLiteralValue();

            state._fsp--;

             current =iv_ruleInverseLiteralValue; 
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
    // $ANTLR end "entryRuleInverseLiteralValue"


    // $ANTLR start "ruleInverseLiteralValue"
    // PsiInternalXtextGrammarTestLanguage.g:1558:1: ruleInverseLiteralValue returns [Boolean current=false] : ruleLiteralValue ;
    public final Boolean ruleInverseLiteralValue() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:1559:1: ( ruleLiteralValue )
            // PsiInternalXtextGrammarTestLanguage.g:1560:2: ruleLiteralValue
            {

            		markComposite(elementTypeProvider.getInverseLiteralValue_LiteralValueParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
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
        return current;
    }
    // $ANTLR end "ruleInverseLiteralValue"


    // $ANTLR start "entryRuleNamedArgument"
    // PsiInternalXtextGrammarTestLanguage.g:1570:1: entryRuleNamedArgument returns [Boolean current=false] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final Boolean entryRuleNamedArgument() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamedArgument = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1570:55: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1571:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
             markComposite(elementTypeProvider.getNamedArgumentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;

             current =iv_ruleNamedArgument; 
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
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // PsiInternalXtextGrammarTestLanguage.g:1577:1: ruleNamedArgument returns [Boolean current=false] : ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) ) ;
    public final Boolean ruleNamedArgument() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Boolean lv_literalValue_1_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1578:1: ( ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1579:2: ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1579:2: ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1580:3: () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1580:3: ()
            // PsiInternalXtextGrammarTestLanguage.g:1581:4: 
            {

            				precedeComposite(elementTypeProvider.getNamedArgument_NamedArgumentAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalXtextGrammarTestLanguage.g:1587:3: ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==32||LA40_0==38) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==34) ) {
                    alt40=2;
                }
                else if ( (LA40_2==EOF||LA40_2==13||LA40_2==26) ) {
                    alt40=1;
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
                    // PsiInternalXtextGrammarTestLanguage.g:1588:4: ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1588:4: ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1589:5: ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1589:5: ( (lv_literalValue_1_0= ruleLiteralValue ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==32||LA39_0==38) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // PsiInternalXtextGrammarTestLanguage.g:1590:6: (lv_literalValue_1_0= ruleLiteralValue )
                            {
                            // PsiInternalXtextGrammarTestLanguage.g:1590:6: (lv_literalValue_1_0= ruleLiteralValue )
                            // PsiInternalXtextGrammarTestLanguage.g:1591:7: lv_literalValue_1_0= ruleLiteralValue
                            {

                            							markComposite(elementTypeProvider.getNamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_3);
                            lv_literalValue_1_0=ruleLiteralValue();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }


                            }
                            break;

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:1604:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1605:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1605:6: (otherlv_2= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:1606:7: otherlv_2= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getNamedArgument_ParameterParameterCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1623:4: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1623:4: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1624:5: ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1624:5: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1625:6: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1625:6: (otherlv_3= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:1626:7: otherlv_3= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getNamedArgument_ParameterParameterCrossReference_1_1_0_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_36); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getNamedArgument_EqualsSignKeyword_1_1_1ElementType());
                    				
                    otherlv_4=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalXtextGrammarTestLanguage.g:1648:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1649:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1649:6: (otherlv_5= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:1650:7: otherlv_5= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getNamedArgument_ValueParameterCrossReference_1_1_2_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // PsiInternalXtextGrammarTestLanguage.g:1671:1: entryRuleTerminalRuleCall returns [Boolean current=false] : iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF ;
    public final Boolean entryRuleTerminalRuleCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalRuleCall = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1671:58: (iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1672:2: iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRuleCall=ruleTerminalRuleCall();

            state._fsp--;

             current =iv_ruleTerminalRuleCall; 
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
    // $ANTLR end "entryRuleTerminalRuleCall"


    // $ANTLR start "ruleTerminalRuleCall"
    // PsiInternalXtextGrammarTestLanguage.g:1678:1: ruleTerminalRuleCall returns [Boolean current=false] : ( ( ruleRuleID ) ) ;
    public final Boolean ruleTerminalRuleCall() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:1679:1: ( ( ( ruleRuleID ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1680:2: ( ( ruleRuleID ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1680:2: ( ( ruleRuleID ) )
            // PsiInternalXtextGrammarTestLanguage.g:1681:3: ( ruleRuleID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1681:3: ( ruleRuleID )
            // PsiInternalXtextGrammarTestLanguage.g:1682:4: ruleRuleID
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				markComposite(elementTypeProvider.getTerminalRuleCall_RuleAbstractRuleCrossReference_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
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
        return current;
    }
    // $ANTLR end "ruleTerminalRuleCall"


    // $ANTLR start "entryRuleRuleID"
    // PsiInternalXtextGrammarTestLanguage.g:1700:1: entryRuleRuleID returns [Boolean current=false] : iv_ruleRuleID= ruleRuleID EOF ;
    public final Boolean entryRuleRuleID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRuleID = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1700:48: (iv_ruleRuleID= ruleRuleID EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1701:2: iv_ruleRuleID= ruleRuleID EOF
            {
             markComposite(elementTypeProvider.getRuleIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleID=ruleRuleID();

            state._fsp--;

             current =iv_ruleRuleID; 
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
    // $ANTLR end "entryRuleRuleID"


    // $ANTLR start "ruleRuleID"
    // PsiInternalXtextGrammarTestLanguage.g:1707:1: ruleRuleID returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleRuleID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:1708:1: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) )
            // PsiInternalXtextGrammarTestLanguage.g:1709:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1709:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            // PsiInternalXtextGrammarTestLanguage.g:1710:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getRuleID_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:1717:3: (kw= '::' this_ID_2= RULE_ID )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==28) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // PsiInternalXtextGrammarTestLanguage.g:1718:4: kw= '::' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getRuleID_ColonColonKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,28,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getRuleID_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

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
        return current;
    }
    // $ANTLR end "ruleRuleID"


    // $ANTLR start "entryRulePredicatedKeyword"
    // PsiInternalXtextGrammarTestLanguage.g:1737:1: entryRulePredicatedKeyword returns [Boolean current=false] : iv_rulePredicatedKeyword= rulePredicatedKeyword EOF ;
    public final Boolean entryRulePredicatedKeyword() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePredicatedKeyword = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1737:59: (iv_rulePredicatedKeyword= rulePredicatedKeyword EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1738:2: iv_rulePredicatedKeyword= rulePredicatedKeyword EOF
            {
             markComposite(elementTypeProvider.getPredicatedKeywordElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedKeyword=rulePredicatedKeyword();

            state._fsp--;

             current =iv_rulePredicatedKeyword; 
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
    // $ANTLR end "entryRulePredicatedKeyword"


    // $ANTLR start "rulePredicatedKeyword"
    // PsiInternalXtextGrammarTestLanguage.g:1744:1: rulePredicatedKeyword returns [Boolean current=false] : (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final Boolean rulePredicatedKeyword() throws RecognitionException {
        Boolean current = false;

        Token lv_value_1_0=null;
        Boolean this_Predicate_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1745:1: ( (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1746:2: (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1746:2: (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1747:3: this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) )
            {

            			markComposite(elementTypeProvider.getPredicatedKeyword_PredicateParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_11);
            this_Predicate_0=rulePredicate(current);

            state._fsp--;


            			current = this_Predicate_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:1755:3: ( (lv_value_1_0= RULE_STRING ) )
            // PsiInternalXtextGrammarTestLanguage.g:1756:4: (lv_value_1_0= RULE_STRING )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1756:4: (lv_value_1_0= RULE_STRING )
            // PsiInternalXtextGrammarTestLanguage.g:1757:5: lv_value_1_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getPredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "rulePredicatedKeyword"


    // $ANTLR start "entryRulePredicatedRuleCall"
    // PsiInternalXtextGrammarTestLanguage.g:1776:1: entryRulePredicatedRuleCall returns [Boolean current=false] : iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF ;
    public final Boolean entryRulePredicatedRuleCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePredicatedRuleCall = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1776:60: (iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1777:2: iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF
            {
             markComposite(elementTypeProvider.getPredicatedRuleCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedRuleCall=rulePredicatedRuleCall();

            state._fsp--;

             current =iv_rulePredicatedRuleCall; 
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
    // $ANTLR end "entryRulePredicatedRuleCall"


    // $ANTLR start "rulePredicatedRuleCall"
    // PsiInternalXtextGrammarTestLanguage.g:1783:1: rulePredicatedRuleCall returns [Boolean current=false] : (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) ) ;
    public final Boolean rulePredicatedRuleCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean this_Predicate_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1784:1: ( (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1785:2: (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1785:2: (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1786:3: this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) )
            {

            			markComposite(elementTypeProvider.getPredicatedRuleCall_PredicateParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Predicate_0=rulePredicate(current);

            state._fsp--;


            			current = this_Predicate_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:1794:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:1795:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1795:4: (otherlv_1= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:1796:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getPredicatedRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // PsiInternalXtextGrammarTestLanguage.g:1815:1: entryRuleAssignment returns [Boolean current=false] : iv_ruleAssignment= ruleAssignment EOF ;
    public final Boolean entryRuleAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignment = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1815:52: (iv_ruleAssignment= ruleAssignment EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1816:2: iv_ruleAssignment= ruleAssignment EOF
            {
             markComposite(elementTypeProvider.getAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // PsiInternalXtextGrammarTestLanguage.g:1822:1: ruleAssignment returns [Boolean current=false] : ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) ) ;
    public final Boolean ruleAssignment() throws RecognitionException {
        Boolean current = false;

        Token lv_feature_1_0=null;
        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Boolean this_Predicate_0 = null;

        Boolean lv_terminal_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1823:1: ( ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1824:2: ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1824:2: ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1825:3: (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1825:3: (this_Predicate_0= rulePredicate[$current] )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=40 && LA42_0<=41)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:1826:4: this_Predicate_0= rulePredicate[$current]
                    {

                    				markComposite(elementTypeProvider.getAssignment_PredicateParserRuleCall_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_3);
                    this_Predicate_0=rulePredicate(current);

                    state._fsp--;


                    				current = this_Predicate_0;
                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalXtextGrammarTestLanguage.g:1835:3: ( (lv_feature_1_0= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:1836:4: (lv_feature_1_0= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1836:4: (lv_feature_1_0= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:1837:5: lv_feature_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignment_FeatureIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_feature_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_38); 

            					doneLeaf(lv_feature_1_0);
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:1852:3: ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1853:4: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1853:4: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) )
            // PsiInternalXtextGrammarTestLanguage.g:1854:5: (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1854:5: (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' )
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
                    // PsiInternalXtextGrammarTestLanguage.g:1855:6: lv_operator_2_1= '+='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorPlusSignEqualsSignKeyword_2_0_0ElementType());
                    					
                    lv_operator_2_1=(Token)match(input,35,FollowSets000.FOLLOW_39); 

                    						doneLeaf(lv_operator_2_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1869:6: lv_operator_2_2= '='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorEqualsSignKeyword_2_0_1ElementType());
                    					
                    lv_operator_2_2=(Token)match(input,34,FollowSets000.FOLLOW_39); 

                    						doneLeaf(lv_operator_2_2);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalXtextGrammarTestLanguage.g:1883:6: lv_operator_2_3= '?='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2ElementType());
                    					
                    lv_operator_2_3=(Token)match(input,39,FollowSets000.FOLLOW_39); 

                    						doneLeaf(lv_operator_2_3);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:1899:3: ( (lv_terminal_3_0= ruleAssignableTerminal ) )
            // PsiInternalXtextGrammarTestLanguage.g:1900:4: (lv_terminal_3_0= ruleAssignableTerminal )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1900:4: (lv_terminal_3_0= ruleAssignableTerminal )
            // PsiInternalXtextGrammarTestLanguage.g:1901:5: lv_terminal_3_0= ruleAssignableTerminal
            {

            					markComposite(elementTypeProvider.getAssignment_TerminalAssignableTerminalParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_3_0=ruleAssignableTerminal();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "rulePredicate"
    // PsiInternalXtextGrammarTestLanguage.g:1919:1: rulePredicate[Boolean in_current] returns [Boolean current=in_current] : ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ;
    public final Boolean rulePredicate(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:1920:1: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:1921:2: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1921:2: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
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
                    // PsiInternalXtextGrammarTestLanguage.g:1922:3: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1922:3: ( (lv_predicated_0_0= '=>' ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1923:4: (lv_predicated_0_0= '=>' )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1923:4: (lv_predicated_0_0= '=>' )
                    // PsiInternalXtextGrammarTestLanguage.g:1924:5: lv_predicated_0_0= '=>'
                    {

                    					markLeaf(elementTypeProvider.getPredicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0ElementType());
                    				
                    lv_predicated_0_0=(Token)match(input,40,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_predicated_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1940:3: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1940:3: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // PsiInternalXtextGrammarTestLanguage.g:1941:4: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:1941:4: (lv_firstSetPredicated_1_0= '->' )
                    // PsiInternalXtextGrammarTestLanguage.g:1942:5: lv_firstSetPredicated_1_0= '->'
                    {

                    					markLeaf(elementTypeProvider.getPredicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0ElementType());
                    				
                    lv_firstSetPredicated_1_0=(Token)match(input,41,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_firstSetPredicated_1_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
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
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleAssignableTerminal"
    // PsiInternalXtextGrammarTestLanguage.g:1961:1: entryRuleAssignableTerminal returns [Boolean current=false] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final Boolean entryRuleAssignableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignableTerminal = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1961:60: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // PsiInternalXtextGrammarTestLanguage.g:1962:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             markComposite(elementTypeProvider.getAssignableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();

            state._fsp--;

             current =iv_ruleAssignableTerminal; 
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
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // PsiInternalXtextGrammarTestLanguage.g:1968:1: ruleAssignableTerminal returns [Boolean current=false] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final Boolean ruleAssignableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean this_Keyword_0 = null;

        Boolean this_RuleCall_1 = null;

        Boolean this_ParenthesizedAssignableElement_2 = null;

        Boolean this_CrossReference_3 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:1969:1: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // PsiInternalXtextGrammarTestLanguage.g:1970:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // PsiInternalXtextGrammarTestLanguage.g:1970:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    // PsiInternalXtextGrammarTestLanguage.g:1971:3: this_Keyword_0= ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:1980:3: this_RuleCall_1= ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextGrammarTestLanguage.g:1989:3: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();

                    state._fsp--;


                    			current = this_ParenthesizedAssignableElement_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalXtextGrammarTestLanguage.g:1998:3: this_CrossReference_3= ruleCrossReference
                    {

                    			markComposite(elementTypeProvider.getAssignableTerminal_CrossReferenceParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CrossReference_3=ruleCrossReference();

                    state._fsp--;


                    			current = this_CrossReference_3;
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
        return current;
    }
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // PsiInternalXtextGrammarTestLanguage.g:2010:1: entryRuleParenthesizedAssignableElement returns [Boolean current=false] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final Boolean entryRuleParenthesizedAssignableElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesizedAssignableElement = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2010:72: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2011:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedAssignableElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();

            state._fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
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
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // PsiInternalXtextGrammarTestLanguage.g:2017:1: ruleParenthesizedAssignableElement returns [Boolean current=false] : (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final Boolean ruleParenthesizedAssignableElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_AssignableAlternatives_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2018:1: ( (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2019:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2019:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            // PsiInternalXtextGrammarTestLanguage.g:2020:3: otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_39); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_40);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();

            state._fsp--;


            			current = this_AssignableAlternatives_1;
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
        return current;
    }
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // PsiInternalXtextGrammarTestLanguage.g:2046:1: entryRuleAssignableAlternatives returns [Boolean current=false] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final Boolean entryRuleAssignableAlternatives() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignableAlternatives = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2046:64: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2047:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             markComposite(elementTypeProvider.getAssignableAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();

            state._fsp--;

             current =iv_ruleAssignableAlternatives; 
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
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // PsiInternalXtextGrammarTestLanguage.g:2053:1: ruleAssignableAlternatives returns [Boolean current=false] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final Boolean ruleAssignableAlternatives() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_AssignableTerminal_0 = null;

        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2054:1: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:2055:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2055:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // PsiInternalXtextGrammarTestLanguage.g:2056:3: this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_AssignableTerminal_0=ruleAssignableTerminal();

            state._fsp--;


            			current = this_AssignableTerminal_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:2064:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==29) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2065:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2065:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:2066:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAssignableAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:2072:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
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
                    	    // PsiInternalXtextGrammarTestLanguage.g:2073:5: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_39); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:2080:5: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:2081:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:2081:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // PsiInternalXtextGrammarTestLanguage.g:2082:7: lv_elements_3_0= ruleAssignableTerminal
                    	    {

                    	    							markComposite(elementTypeProvider.getAssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleAssignableTerminal();

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
        return current;
    }
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // PsiInternalXtextGrammarTestLanguage.g:2101:1: entryRuleCrossReference returns [Boolean current=false] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final Boolean entryRuleCrossReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCrossReference = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2101:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2102:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossReference=ruleCrossReference();

            state._fsp--;

             current =iv_ruleCrossReference; 
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
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // PsiInternalXtextGrammarTestLanguage.g:2108:1: ruleCrossReference returns [Boolean current=false] : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final Boolean ruleCrossReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_type_1_0 = null;

        Boolean lv_terminal_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2109:1: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2110:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2110:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // PsiInternalXtextGrammarTestLanguage.g:2111:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {

            			markLeaf(elementTypeProvider.getCrossReference_LeftSquareBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2118:3: ( (lv_type_1_0= ruleTypeRef ) )
            // PsiInternalXtextGrammarTestLanguage.g:2119:4: (lv_type_1_0= ruleTypeRef )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2119:4: (lv_type_1_0= ruleTypeRef )
            // PsiInternalXtextGrammarTestLanguage.g:2120:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_41);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:2133:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==29) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2134:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {

                    				markLeaf(elementTypeProvider.getCrossReference_VerticalLineKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_42); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:2141:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // PsiInternalXtextGrammarTestLanguage.g:2142:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2142:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // PsiInternalXtextGrammarTestLanguage.g:2143:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						markComposite(elementTypeProvider.getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_26);
                    lv_terminal_3_0=ruleCrossReferenceableTerminal();

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

            }


            			markLeaf(elementTypeProvider.getCrossReference_RightSquareBracketKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,26,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // PsiInternalXtextGrammarTestLanguage.g:2168:1: entryRuleCrossReferenceableTerminal returns [Boolean current=false] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final Boolean entryRuleCrossReferenceableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCrossReferenceableTerminal = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2168:68: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2169:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             markComposite(elementTypeProvider.getCrossReferenceableTerminalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();

            state._fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
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
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // PsiInternalXtextGrammarTestLanguage.g:2175:1: ruleCrossReferenceableTerminal returns [Boolean current=false] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) ;
    public final Boolean ruleCrossReferenceableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean this_Keyword_0 = null;

        Boolean this_RuleCall_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2176:1: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) )
            // PsiInternalXtextGrammarTestLanguage.g:2177:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2177:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
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
                    // PsiInternalXtextGrammarTestLanguage.g:2178:3: this_Keyword_0= ruleKeyword
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:2187:3: this_RuleCall_1= ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
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
        return current;
    }
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // PsiInternalXtextGrammarTestLanguage.g:2199:1: entryRuleParenthesizedElement returns [Boolean current=false] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final Boolean entryRuleParenthesizedElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesizedElement = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2199:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2200:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();

            state._fsp--;

             current =iv_ruleParenthesizedElement; 
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
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // PsiInternalXtextGrammarTestLanguage.g:2206:1: ruleParenthesizedElement returns [Boolean current=false] : (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final Boolean ruleParenthesizedElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Alternatives_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2207:1: ( (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2208:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2208:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // PsiInternalXtextGrammarTestLanguage.g:2209:3: otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedElement_AlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_40);
            this_Alternatives_1=ruleAlternatives();

            state._fsp--;


            			current = this_Alternatives_1;
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
        return current;
    }
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRulePredicatedGroup"
    // PsiInternalXtextGrammarTestLanguage.g:2235:1: entryRulePredicatedGroup returns [Boolean current=false] : iv_rulePredicatedGroup= rulePredicatedGroup EOF ;
    public final Boolean entryRulePredicatedGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePredicatedGroup = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2235:57: (iv_rulePredicatedGroup= rulePredicatedGroup EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2236:2: iv_rulePredicatedGroup= rulePredicatedGroup EOF
            {
             markComposite(elementTypeProvider.getPredicatedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedGroup=rulePredicatedGroup();

            state._fsp--;

             current =iv_rulePredicatedGroup; 
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
    // $ANTLR end "entryRulePredicatedGroup"


    // $ANTLR start "rulePredicatedGroup"
    // PsiInternalXtextGrammarTestLanguage.g:2242:1: rulePredicatedGroup returns [Boolean current=false] : (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' ) ;
    public final Boolean rulePredicatedGroup() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean this_Predicate_0 = null;

        Boolean lv_elements_2_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2243:1: ( (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2244:2: (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2244:2: (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' )
            // PsiInternalXtextGrammarTestLanguage.g:2245:3: this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')'
            {

            			markComposite(elementTypeProvider.getPredicatedGroup_PredicateParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_Predicate_0=rulePredicate(current);

            state._fsp--;


            			current = this_Predicate_0;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getPredicatedGroup_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2260:3: ( (lv_elements_2_0= ruleAlternatives ) )
            // PsiInternalXtextGrammarTestLanguage.g:2261:4: (lv_elements_2_0= ruleAlternatives )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2261:4: (lv_elements_2_0= ruleAlternatives )
            // PsiInternalXtextGrammarTestLanguage.g:2262:5: lv_elements_2_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getPredicatedGroup_ElementsAlternativesParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_40);
            lv_elements_2_0=ruleAlternatives();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getPredicatedGroup_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // PsiInternalXtextGrammarTestLanguage.g:2286:1: entryRuleTerminalRule returns [Boolean current=false] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final Boolean entryRuleTerminalRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalRule = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2286:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2287:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // PsiInternalXtextGrammarTestLanguage.g:2293:1: ruleTerminalRule returns [Boolean current=false] : (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' ) ;
    public final Boolean ruleTerminalRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_fragment_1_0=null;
        Token lv_name_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Boolean this_ReturnsClause_4 = null;

        Boolean lv_alternatives_6_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2294:1: ( (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2295:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2295:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' )
            // PsiInternalXtextGrammarTestLanguage.g:2296:3: otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';'
            {

            			markLeaf(elementTypeProvider.getTerminalRule_TerminalKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_13); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2303:3: ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) )
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
                    // PsiInternalXtextGrammarTestLanguage.g:2304:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2304:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    // PsiInternalXtextGrammarTestLanguage.g:2305:5: ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2305:5: ( (lv_fragment_1_0= 'fragment' ) )
                    // PsiInternalXtextGrammarTestLanguage.g:2306:6: (lv_fragment_1_0= 'fragment' )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2306:6: (lv_fragment_1_0= 'fragment' )
                    // PsiInternalXtextGrammarTestLanguage.g:2307:7: lv_fragment_1_0= 'fragment'
                    {

                    							markLeaf(elementTypeProvider.getTerminalRule_FragmentFragmentKeyword_1_0_0_0ElementType());
                    						
                    lv_fragment_1_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_fragment_1_0);
                    						

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    }


                    }

                    // PsiInternalXtextGrammarTestLanguage.g:2322:5: ( (lv_name_2_0= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:2323:6: (lv_name_2_0= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2323:6: (lv_name_2_0= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:2324:7: lv_name_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    							doneLeaf(lv_name_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:2341:4: ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2341:4: ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? )
                    // PsiInternalXtextGrammarTestLanguage.g:2342:5: ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )?
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2342:5: ( (lv_name_3_0= RULE_ID ) )
                    // PsiInternalXtextGrammarTestLanguage.g:2343:6: (lv_name_3_0= RULE_ID )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2343:6: (lv_name_3_0= RULE_ID )
                    // PsiInternalXtextGrammarTestLanguage.g:2344:7: lv_name_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_1_0_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

                    							doneLeaf(lv_name_3_0);
                    						

                    }


                    }

                    // PsiInternalXtextGrammarTestLanguage.g:2359:5: (this_ReturnsClause_4= ruleReturnsClause[$current] )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==27) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // PsiInternalXtextGrammarTestLanguage.g:2360:6: this_ReturnsClause_4= ruleReturnsClause[$current]
                            {

                            						markComposite(elementTypeProvider.getTerminalRule_ReturnsClauseParserRuleCall_1_1_1ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_17);
                            this_ReturnsClause_4=ruleReturnsClause(current);

                            state._fsp--;


                            						current = this_ReturnsClause_4;
                            						doneComposite();
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getTerminalRule_ColonKeyword_2ElementType());
            		
            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_44); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2378:3: ( (lv_alternatives_6_0= ruleTerminalAlternatives ) )
            // PsiInternalXtextGrammarTestLanguage.g:2379:4: (lv_alternatives_6_0= ruleTerminalAlternatives )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2379:4: (lv_alternatives_6_0= ruleTerminalAlternatives )
            // PsiInternalXtextGrammarTestLanguage.g:2380:5: lv_alternatives_6_0= ruleTerminalAlternatives
            {

            					markComposite(elementTypeProvider.getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_19);
            lv_alternatives_6_0=ruleTerminalAlternatives();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getTerminalRule_SemicolonKeyword_4ElementType());
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // PsiInternalXtextGrammarTestLanguage.g:2404:1: entryRuleTerminalAlternatives returns [Boolean current=false] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final Boolean entryRuleTerminalAlternatives() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalAlternatives = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2404:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2405:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             markComposite(elementTypeProvider.getTerminalAlternativesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();

            state._fsp--;

             current =iv_ruleTerminalAlternatives; 
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
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // PsiInternalXtextGrammarTestLanguage.g:2411:1: ruleTerminalAlternatives returns [Boolean current=false] : (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final Boolean ruleTerminalAlternatives() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_TerminalGroup_0 = null;

        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2412:1: ( (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:2413:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2413:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // PsiInternalXtextGrammarTestLanguage.g:2414:3: this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_TerminalGroup_0=ruleTerminalGroup();

            state._fsp--;


            			current = this_TerminalGroup_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:2422:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==29) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2423:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2423:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:2424:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalAlternatives_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:2430:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
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
                    	    // PsiInternalXtextGrammarTestLanguage.g:2431:5: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_44); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:2438:5: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:2439:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:2439:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    // PsiInternalXtextGrammarTestLanguage.g:2440:7: lv_elements_3_0= ruleTerminalGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getTerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleTerminalGroup();

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
        return current;
    }
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // PsiInternalXtextGrammarTestLanguage.g:2459:1: entryRuleTerminalGroup returns [Boolean current=false] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final Boolean entryRuleTerminalGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalGroup = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2459:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2460:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             markComposite(elementTypeProvider.getTerminalGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalGroup=ruleTerminalGroup();

            state._fsp--;

             current =iv_ruleTerminalGroup; 
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
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // PsiInternalXtextGrammarTestLanguage.g:2466:1: ruleTerminalGroup returns [Boolean current=false] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final Boolean ruleTerminalGroup() throws RecognitionException {
        Boolean current = false;

        Boolean this_TerminalToken_0 = null;

        Boolean lv_elements_2_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2467:1: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:2468:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2468:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // PsiInternalXtextGrammarTestLanguage.g:2469:3: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalGroup_TerminalTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_45);
            this_TerminalToken_0=ruleTerminalToken();

            state._fsp--;


            			current = this_TerminalToken_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:2477:3: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_STRING)||LA55_0==15||LA55_0==17||LA55_0==38||LA55_0==41||LA55_0==43) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2478:4: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2478:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:2479:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalGroup_GroupElementsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:2485:4: ( (lv_elements_2_0= ruleTerminalToken ) )+
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
                    	    // PsiInternalXtextGrammarTestLanguage.g:2486:5: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:2486:5: (lv_elements_2_0= ruleTerminalToken )
                    	    // PsiInternalXtextGrammarTestLanguage.g:2487:6: lv_elements_2_0= ruleTerminalToken
                    	    {

                    	    						markComposite(elementTypeProvider.getTerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_45);
                    	    lv_elements_2_0=ruleTerminalToken();

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
        return current;
    }
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // PsiInternalXtextGrammarTestLanguage.g:2505:1: entryRuleTerminalToken returns [Boolean current=false] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final Boolean entryRuleTerminalToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalToken = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2505:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2506:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalToken=ruleTerminalToken();

            state._fsp--;

             current =iv_ruleTerminalToken; 
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
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // PsiInternalXtextGrammarTestLanguage.g:2512:1: ruleTerminalToken returns [Boolean current=false] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? ) ;
    public final Boolean ruleTerminalToken() throws RecognitionException {
        Boolean current = false;

        Boolean this_TerminalTokenElement_0 = null;

        Boolean this_Cardinalities_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2513:1: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:2514:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2514:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? )
            // PsiInternalXtextGrammarTestLanguage.g:2515:3: this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )?
            {

            			markComposite(elementTypeProvider.getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_30);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();

            state._fsp--;


            			current = this_TerminalTokenElement_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:2523:3: (this_Cardinalities_1= ruleCardinalities[$current] )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==22||(LA56_0>=31 && LA56_0<=32)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2524:4: this_Cardinalities_1= ruleCardinalities[$current]
                    {

                    				markComposite(elementTypeProvider.getTerminalToken_CardinalitiesParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Cardinalities_1=ruleCardinalities(current);

                    state._fsp--;


                    				current = this_Cardinalities_1;
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
        return current;
    }
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // PsiInternalXtextGrammarTestLanguage.g:2537:1: entryRuleTerminalTokenElement returns [Boolean current=false] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final Boolean entryRuleTerminalTokenElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalTokenElement = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2537:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2538:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             markComposite(elementTypeProvider.getTerminalTokenElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();

            state._fsp--;

             current =iv_ruleTerminalTokenElement; 
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
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // PsiInternalXtextGrammarTestLanguage.g:2544:1: ruleTerminalTokenElement returns [Boolean current=false] : (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF ) ;
    public final Boolean ruleTerminalTokenElement() throws RecognitionException {
        Boolean current = false;

        Boolean this_CharacterRange_0 = null;

        Boolean this_TerminalRuleCall_1 = null;

        Boolean this_ParenthesizedTerminalElement_2 = null;

        Boolean this_AbstractNegatedToken_3 = null;

        Boolean this_Wildcard_4 = null;

        Boolean this_EOF_5 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2545:1: ( (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF ) )
            // PsiInternalXtextGrammarTestLanguage.g:2546:2: (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2546:2: (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF )
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
                    // PsiInternalXtextGrammarTestLanguage.g:2547:3: this_CharacterRange_0= ruleCharacterRange
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CharacterRange_0=ruleCharacterRange();

                    state._fsp--;


                    			current = this_CharacterRange_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:2556:3: this_TerminalRuleCall_1= ruleTerminalRuleCall
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_TerminalRuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TerminalRuleCall_1=ruleTerminalRuleCall();

                    state._fsp--;


                    			current = this_TerminalRuleCall_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextGrammarTestLanguage.g:2565:3: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();

                    state._fsp--;


                    			current = this_ParenthesizedTerminalElement_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalXtextGrammarTestLanguage.g:2574:3: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();

                    state._fsp--;


                    			current = this_AbstractNegatedToken_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalXtextGrammarTestLanguage.g:2583:3: this_Wildcard_4= ruleWildcard
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_WildcardParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Wildcard_4=ruleWildcard();

                    state._fsp--;


                    			current = this_Wildcard_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalXtextGrammarTestLanguage.g:2592:3: this_EOF_5= ruleEOF
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_EOFParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EOF_5=ruleEOF();

                    state._fsp--;


                    			current = this_EOF_5;
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
        return current;
    }
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // PsiInternalXtextGrammarTestLanguage.g:2604:1: entryRuleParenthesizedTerminalElement returns [Boolean current=false] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final Boolean entryRuleParenthesizedTerminalElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesizedTerminalElement = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2604:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2605:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             markComposite(elementTypeProvider.getParenthesizedTerminalElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();

            state._fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
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
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // PsiInternalXtextGrammarTestLanguage.g:2611:1: ruleParenthesizedTerminalElement returns [Boolean current=false] : (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final Boolean ruleParenthesizedTerminalElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_TerminalAlternatives_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2612:1: ( (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2613:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2613:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            // PsiInternalXtextGrammarTestLanguage.g:2614:3: otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_44); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_40);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();

            state._fsp--;


            			current = this_TerminalAlternatives_1;
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
        return current;
    }
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // PsiInternalXtextGrammarTestLanguage.g:2640:1: entryRuleAbstractNegatedToken returns [Boolean current=false] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final Boolean entryRuleAbstractNegatedToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractNegatedToken = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2640:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2641:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             markComposite(elementTypeProvider.getAbstractNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();

            state._fsp--;

             current =iv_ruleAbstractNegatedToken; 
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
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // PsiInternalXtextGrammarTestLanguage.g:2647:1: ruleAbstractNegatedToken returns [Boolean current=false] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final Boolean ruleAbstractNegatedToken() throws RecognitionException {
        Boolean current = false;

        Boolean this_NegatedToken_0 = null;

        Boolean this_UntilToken_1 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2648:1: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // PsiInternalXtextGrammarTestLanguage.g:2649:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2649:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
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
                    // PsiInternalXtextGrammarTestLanguage.g:2650:3: this_NegatedToken_0= ruleNegatedToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NegatedToken_0=ruleNegatedToken();

                    state._fsp--;


                    			current = this_NegatedToken_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalXtextGrammarTestLanguage.g:2659:3: this_UntilToken_1= ruleUntilToken
                    {

                    			markComposite(elementTypeProvider.getAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UntilToken_1=ruleUntilToken();

                    state._fsp--;


                    			current = this_UntilToken_1;
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
        return current;
    }
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // PsiInternalXtextGrammarTestLanguage.g:2671:1: entryRuleNegatedToken returns [Boolean current=false] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final Boolean entryRuleNegatedToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNegatedToken = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2671:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2672:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             markComposite(elementTypeProvider.getNegatedTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNegatedToken=ruleNegatedToken();

            state._fsp--;

             current =iv_ruleNegatedToken; 
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
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // PsiInternalXtextGrammarTestLanguage.g:2678:1: ruleNegatedToken returns [Boolean current=false] : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final Boolean ruleNegatedToken() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_terminal_1_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2679:1: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:2680:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2680:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:2681:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getNegatedToken_ExclamationMarkKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_44); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2688:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // PsiInternalXtextGrammarTestLanguage.g:2689:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2689:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // PsiInternalXtextGrammarTestLanguage.g:2690:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // PsiInternalXtextGrammarTestLanguage.g:2707:1: entryRuleUntilToken returns [Boolean current=false] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final Boolean entryRuleUntilToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUntilToken = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2707:52: (iv_ruleUntilToken= ruleUntilToken EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2708:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             markComposite(elementTypeProvider.getUntilTokenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUntilToken=ruleUntilToken();

            state._fsp--;

             current =iv_ruleUntilToken; 
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
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // PsiInternalXtextGrammarTestLanguage.g:2714:1: ruleUntilToken returns [Boolean current=false] : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final Boolean ruleUntilToken() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_terminal_1_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2715:1: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:2716:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2716:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // PsiInternalXtextGrammarTestLanguage.g:2717:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_44); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2724:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // PsiInternalXtextGrammarTestLanguage.g:2725:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2725:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // PsiInternalXtextGrammarTestLanguage.g:2726:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					markComposite(elementTypeProvider.getUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // PsiInternalXtextGrammarTestLanguage.g:2743:1: entryRuleWildcard returns [Boolean current=false] : iv_ruleWildcard= ruleWildcard EOF ;
    public final Boolean entryRuleWildcard() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleWildcard = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2743:50: (iv_ruleWildcard= ruleWildcard EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2744:2: iv_ruleWildcard= ruleWildcard EOF
            {
             markComposite(elementTypeProvider.getWildcardElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;

             current =iv_ruleWildcard; 
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
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // PsiInternalXtextGrammarTestLanguage.g:2750:1: ruleWildcard returns [Boolean current=false] : ( () otherlv_1= '.' ) ;
    public final Boolean ruleWildcard() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:2751:1: ( ( () otherlv_1= '.' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2752:2: ( () otherlv_1= '.' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2752:2: ( () otherlv_1= '.' )
            // PsiInternalXtextGrammarTestLanguage.g:2753:3: () otherlv_1= '.'
            {
            // PsiInternalXtextGrammarTestLanguage.g:2753:3: ()
            // PsiInternalXtextGrammarTestLanguage.g:2754:4: 
            {

            				precedeComposite(elementTypeProvider.getWildcard_WildcardAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
        return current;
    }
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleEOF"
    // PsiInternalXtextGrammarTestLanguage.g:2771:1: entryRuleEOF returns [Boolean current=false] : iv_ruleEOF= ruleEOF EOF ;
    public final Boolean entryRuleEOF() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEOF = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2771:45: (iv_ruleEOF= ruleEOF EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2772:2: iv_ruleEOF= ruleEOF EOF
            {
             markComposite(elementTypeProvider.getEOFElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEOF=ruleEOF();

            state._fsp--;

             current =iv_ruleEOF; 
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
    // $ANTLR end "entryRuleEOF"


    // $ANTLR start "ruleEOF"
    // PsiInternalXtextGrammarTestLanguage.g:2778:1: ruleEOF returns [Boolean current=false] : ( () otherlv_1= 'EOF' ) ;
    public final Boolean ruleEOF() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalXtextGrammarTestLanguage.g:2779:1: ( ( () otherlv_1= 'EOF' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2780:2: ( () otherlv_1= 'EOF' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2780:2: ( () otherlv_1= 'EOF' )
            // PsiInternalXtextGrammarTestLanguage.g:2781:3: () otherlv_1= 'EOF'
            {
            // PsiInternalXtextGrammarTestLanguage.g:2781:3: ()
            // PsiInternalXtextGrammarTestLanguage.g:2782:4: 
            {

            				precedeComposite(elementTypeProvider.getEOF_EOFAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getEOF_EOFKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_2); 

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
        return current;
    }
    // $ANTLR end "ruleEOF"


    // $ANTLR start "entryRuleCharacterRange"
    // PsiInternalXtextGrammarTestLanguage.g:2799:1: entryRuleCharacterRange returns [Boolean current=false] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final Boolean entryRuleCharacterRange() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCharacterRange = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2799:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2800:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             markComposite(elementTypeProvider.getCharacterRangeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCharacterRange=ruleCharacterRange();

            state._fsp--;

             current =iv_ruleCharacterRange; 
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
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // PsiInternalXtextGrammarTestLanguage.g:2806:1: ruleCharacterRange returns [Boolean current=false] : (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final Boolean ruleCharacterRange() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Keyword_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2807:1: ( (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:2808:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2808:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // PsiInternalXtextGrammarTestLanguage.g:2809:3: this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			markComposite(elementTypeProvider.getCharacterRange_KeywordParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_46);
            this_Keyword_0=ruleKeyword();

            state._fsp--;


            			current = this_Keyword_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:2817:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==44) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2818:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2818:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:2819:5: 
                    {

                    					precedeComposite(elementTypeProvider.getCharacterRange_CharacterRangeLeftAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }


                    				markLeaf(elementTypeProvider.getCharacterRange_FullStopFullStopKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:2832:4: ( (lv_right_3_0= ruleKeyword ) )
                    // PsiInternalXtextGrammarTestLanguage.g:2833:5: (lv_right_3_0= ruleKeyword )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2833:5: (lv_right_3_0= ruleKeyword )
                    // PsiInternalXtextGrammarTestLanguage.g:2834:6: lv_right_3_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=ruleKeyword();

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
        return current;
    }
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // PsiInternalXtextGrammarTestLanguage.g:2852:1: entryRuleEnumRule returns [Boolean current=false] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final Boolean entryRuleEnumRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumRule = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2852:50: (iv_ruleEnumRule= ruleEnumRule EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2853:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             markComposite(elementTypeProvider.getEnumRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumRule=ruleEnumRule();

            state._fsp--;

             current =iv_ruleEnumRule; 
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
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // PsiInternalXtextGrammarTestLanguage.g:2859:1: ruleEnumRule returns [Boolean current=false] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' ) ;
    public final Boolean ruleEnumRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean this_ReturnsClause_2 = null;

        Boolean lv_alternatives_4_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2860:1: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' ) )
            // PsiInternalXtextGrammarTestLanguage.g:2861:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2861:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' )
            // PsiInternalXtextGrammarTestLanguage.g:2862:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';'
            {

            			markLeaf(elementTypeProvider.getEnumRule_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2869:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:2870:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2870:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:2871:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumRule_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:2886:3: (this_ReturnsClause_2= ruleReturnsClause[$current] )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==27) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2887:4: this_ReturnsClause_2= ruleReturnsClause[$current]
                    {

                    				markComposite(elementTypeProvider.getEnumRule_ReturnsClauseParserRuleCall_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_17);
                    this_ReturnsClause_2=ruleReturnsClause(current);

                    state._fsp--;


                    				current = this_ReturnsClause_2;
                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getEnumRule_ColonKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalXtextGrammarTestLanguage.g:2903:3: ( (lv_alternatives_4_0= ruleEnumLiterals ) )
            // PsiInternalXtextGrammarTestLanguage.g:2904:4: (lv_alternatives_4_0= ruleEnumLiterals )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2904:4: (lv_alternatives_4_0= ruleEnumLiterals )
            // PsiInternalXtextGrammarTestLanguage.g:2905:5: lv_alternatives_4_0= ruleEnumLiterals
            {

            					markComposite(elementTypeProvider.getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_19);
            lv_alternatives_4_0=ruleEnumLiterals();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getEnumRule_SemicolonKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // PsiInternalXtextGrammarTestLanguage.g:2929:1: entryRuleEnumLiterals returns [Boolean current=false] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final Boolean entryRuleEnumLiterals() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumLiterals = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2929:54: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2930:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumLiterals=ruleEnumLiterals();

            state._fsp--;

             current =iv_ruleEnumLiterals; 
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
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // PsiInternalXtextGrammarTestLanguage.g:2936:1: ruleEnumLiterals returns [Boolean current=false] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final Boolean ruleEnumLiterals() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_EnumLiteralDeclaration_0 = null;

        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2937:1: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:2938:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2938:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // PsiInternalXtextGrammarTestLanguage.g:2939:3: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();

            state._fsp--;


            			current = this_EnumLiteralDeclaration_0;
            			doneComposite();
            		
            // PsiInternalXtextGrammarTestLanguage.g:2947:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==29) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:2948:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:2948:4: ()
                    // PsiInternalXtextGrammarTestLanguage.g:2949:5: 
                    {

                    					precedeComposite(elementTypeProvider.getEnumLiterals_AlternativesElementsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextGrammarTestLanguage.g:2955:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
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
                    	    // PsiInternalXtextGrammarTestLanguage.g:2956:5: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getEnumLiterals_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextGrammarTestLanguage.g:2963:5: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // PsiInternalXtextGrammarTestLanguage.g:2964:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // PsiInternalXtextGrammarTestLanguage.g:2964:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // PsiInternalXtextGrammarTestLanguage.g:2965:7: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							markComposite(elementTypeProvider.getEnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleEnumLiteralDeclaration();

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
        return current;
    }
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // PsiInternalXtextGrammarTestLanguage.g:2984:1: entryRuleEnumLiteralDeclaration returns [Boolean current=false] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final Boolean entryRuleEnumLiteralDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumLiteralDeclaration = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2984:64: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // PsiInternalXtextGrammarTestLanguage.g:2985:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             markComposite(elementTypeProvider.getEnumLiteralDeclarationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();

            state._fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
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
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // PsiInternalXtextGrammarTestLanguage.g:2991:1: ruleEnumLiteralDeclaration returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final Boolean ruleEnumLiteralDeclaration() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Boolean lv_literal_2_0 = null;


        try {
            // PsiInternalXtextGrammarTestLanguage.g:2992:1: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // PsiInternalXtextGrammarTestLanguage.g:2993:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2993:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // PsiInternalXtextGrammarTestLanguage.g:2994:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // PsiInternalXtextGrammarTestLanguage.g:2994:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalXtextGrammarTestLanguage.g:2995:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalXtextGrammarTestLanguage.g:2995:4: (otherlv_0= RULE_ID )
            // PsiInternalXtextGrammarTestLanguage.g:2996:5: otherlv_0= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_47); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // PsiInternalXtextGrammarTestLanguage.g:3011:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==34) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // PsiInternalXtextGrammarTestLanguage.g:3012:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalXtextGrammarTestLanguage.g:3019:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // PsiInternalXtextGrammarTestLanguage.g:3020:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // PsiInternalXtextGrammarTestLanguage.g:3020:5: (lv_literal_2_0= ruleKeyword )
                    // PsiInternalXtextGrammarTestLanguage.g:3021:6: lv_literal_2_0= ruleKeyword
                    {

                    						markComposite(elementTypeProvider.getEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_literal_2_0=ruleKeyword();

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
        return current;
    }
    // $ANTLR end "ruleEnumLiteralDeclaration"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000240000345010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000240000347010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000240000345012L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008C04000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000804000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008804000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000030202008030L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000004100000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000030200008030L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000030200008032L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000180400002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000002000020000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000C00000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004100000010L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000008C00000000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000002008030L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000008800000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00000A4000028030L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00000A4000028032L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000100000000002L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000400000002L});
    }


}