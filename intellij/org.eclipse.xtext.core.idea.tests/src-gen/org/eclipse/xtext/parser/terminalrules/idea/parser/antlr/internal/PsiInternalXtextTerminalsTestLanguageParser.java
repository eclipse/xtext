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
    // PsiInternalXtextTerminalsTestLanguage.g:52:1: entryRuleGrammar returns [Boolean current=false] : iv_ruleGrammar= ruleGrammar EOF ;
    public final Boolean entryRuleGrammar() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGrammar = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:52:49: (iv_ruleGrammar= ruleGrammar EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:53:2: iv_ruleGrammar= ruleGrammar EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:59:1: ruleGrammar returns [Boolean current=false] : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
    public final Boolean ruleGrammar() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_definesHiddenTokens_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Boolean lv_name_1_0 = null;

        Boolean lv_metamodelDeclarations_12_0 = null;

        Boolean lv_rules_13_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:60:1: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // PsiInternalXtextTerminalsTestLanguage.g:61:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:61:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // PsiInternalXtextTerminalsTestLanguage.g:62:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {

            			markLeaf(elementTypeProvider.getGrammar_GrammarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:69:3: ( (lv_name_1_0= ruleGrammarID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:70:4: (lv_name_1_0= ruleGrammarID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:70:4: (lv_name_1_0= ruleGrammarID )
            // PsiInternalXtextTerminalsTestLanguage.g:71:5: lv_name_1_0= ruleGrammarID
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

            // PsiInternalXtextTerminalsTestLanguage.g:84:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:85:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {

                    				markLeaf(elementTypeProvider.getGrammar_WithKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:92:4: ( ( ruleGrammarID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:93:5: ( ruleGrammarID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:93:5: ( ruleGrammarID )
                    // PsiInternalXtextTerminalsTestLanguage.g:94:6: ruleGrammarID
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

                    // PsiInternalXtextTerminalsTestLanguage.g:109:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalXtextTerminalsTestLanguage.g:110:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getGrammar_CommaKeyword_2_2_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:117:5: ( ( ruleGrammarID ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:118:6: ( ruleGrammarID )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:118:6: ( ruleGrammarID )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:119:7: ruleGrammarID
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

            // PsiInternalXtextTerminalsTestLanguage.g:136:3: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:137:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')'
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:137:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:138:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:138:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // PsiInternalXtextTerminalsTestLanguage.g:139:6: lv_definesHiddenTokens_6_0= 'hidden'
                    {

                    						markLeaf(elementTypeProvider.getGrammar_DefinesHiddenTokensHiddenKeyword_3_0_0ElementType());
                    					
                    lv_definesHiddenTokens_6_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                    						doneLeaf(lv_definesHiddenTokens_6_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getGrammar_LeftParenthesisKeyword_3_1ElementType());
                    			
                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_7);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:161:4: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // PsiInternalXtextTerminalsTestLanguage.g:162:5: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:162:5: ( (otherlv_8= RULE_ID ) )
                            // PsiInternalXtextTerminalsTestLanguage.g:163:6: (otherlv_8= RULE_ID )
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:163:6: (otherlv_8= RULE_ID )
                            // PsiInternalXtextTerminalsTestLanguage.g:164:7: otherlv_8= RULE_ID
                            {

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            							markLeaf(elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType());
                            						
                            otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            							doneLeaf(otherlv_8);
                            						

                            }


                            }

                            // PsiInternalXtextTerminalsTestLanguage.g:179:5: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // PsiInternalXtextTerminalsTestLanguage.g:180:6: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getGrammar_CommaKeyword_3_2_1_0ElementType());
                            	    					
                            	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            	    						doneLeaf(otherlv_9);
                            	    					
                            	    // PsiInternalXtextTerminalsTestLanguage.g:187:6: ( (otherlv_10= RULE_ID ) )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:188:7: (otherlv_10= RULE_ID )
                            	    {
                            	    // PsiInternalXtextTerminalsTestLanguage.g:188:7: (otherlv_10= RULE_ID )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:189:8: otherlv_10= RULE_ID
                            	    {

                            	    								if (!current) {
                            	    									associateWithSemanticElement();
                            	    									current = true;
                            	    								}
                            	    							

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

            // PsiInternalXtextTerminalsTestLanguage.g:214:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalXtextTerminalsTestLanguage.g:215:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // PsiInternalXtextTerminalsTestLanguage.g:215:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // PsiInternalXtextTerminalsTestLanguage.g:216:5: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_metamodelDeclarations_12_0=ruleAbstractMetamodelDeclaration();

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
            	    break loop6;
                }
            } while (true);

            // PsiInternalXtextTerminalsTestLanguage.g:229:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
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
            	    // PsiInternalXtextTerminalsTestLanguage.g:230:4: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // PsiInternalXtextTerminalsTestLanguage.g:230:4: (lv_rules_13_0= ruleAbstractRule )
            	    // PsiInternalXtextTerminalsTestLanguage.g:231:5: lv_rules_13_0= ruleAbstractRule
            	    {

            	    					markComposite(elementTypeProvider.getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    lv_rules_13_0=ruleAbstractRule();

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
        return current;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleGrammarID"
    // PsiInternalXtextTerminalsTestLanguage.g:248:1: entryRuleGrammarID returns [Boolean current=false] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final Boolean entryRuleGrammarID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGrammarID = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:248:51: (iv_ruleGrammarID= ruleGrammarID EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:249:2: iv_ruleGrammarID= ruleGrammarID EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:255:1: ruleGrammarID returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleGrammarID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:256:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalXtextTerminalsTestLanguage.g:257:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:257:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalXtextTerminalsTestLanguage.g:258:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getGrammarID_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:265:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalXtextTerminalsTestLanguage.g:266:4: kw= '.' this_ID_2= RULE_ID
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
    // PsiInternalXtextTerminalsTestLanguage.g:285:1: entryRuleAbstractRule returns [Boolean current=false] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final Boolean entryRuleAbstractRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractRule = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:285:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:286:2: iv_ruleAbstractRule= ruleAbstractRule EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:292:1: ruleAbstractRule returns [Boolean current=false] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final Boolean ruleAbstractRule() throws RecognitionException {
        Boolean current = false;

        Boolean this_ParserRule_0 = null;

        Boolean this_TerminalRule_1 = null;

        Boolean this_EnumRule_2 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:293:1: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // PsiInternalXtextTerminalsTestLanguage.g:294:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:294:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:295:3: this_ParserRule_0= ruleParserRule
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
                    // PsiInternalXtextTerminalsTestLanguage.g:304:3: this_TerminalRule_1= ruleTerminalRule
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
                    // PsiInternalXtextTerminalsTestLanguage.g:313:3: this_EnumRule_2= ruleEnumRule
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
    // PsiInternalXtextTerminalsTestLanguage.g:325:1: entryRuleAbstractMetamodelDeclaration returns [Boolean current=false] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final Boolean entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:325:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:326:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:332:1: ruleAbstractMetamodelDeclaration returns [Boolean current=false] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final Boolean ruleAbstractMetamodelDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean this_GeneratedMetamodel_0 = null;

        Boolean this_ReferencedMetamodel_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:333:1: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // PsiInternalXtextTerminalsTestLanguage.g:334:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:334:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:335:3: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
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
                    // PsiInternalXtextTerminalsTestLanguage.g:344:3: this_ReferencedMetamodel_1= ruleReferencedMetamodel
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
    // PsiInternalXtextTerminalsTestLanguage.g:356:1: entryRuleGeneratedMetamodel returns [Boolean current=false] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final Boolean entryRuleGeneratedMetamodel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGeneratedMetamodel = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:356:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:357:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:363:1: ruleGeneratedMetamodel returns [Boolean current=false] : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final Boolean ruleGeneratedMetamodel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:364:1: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:365:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:365:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:366:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getGeneratedMetamodel_GenerateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:373:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:374:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:374:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:375:5: lv_name_1_0= RULE_ID
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

            // PsiInternalXtextTerminalsTestLanguage.g:390:3: ( (otherlv_2= RULE_STRING ) )
            // PsiInternalXtextTerminalsTestLanguage.g:391:4: (otherlv_2= RULE_STRING )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:391:4: (otherlv_2= RULE_STRING )
            // PsiInternalXtextTerminalsTestLanguage.g:392:5: otherlv_2= RULE_STRING
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

            // PsiInternalXtextTerminalsTestLanguage.g:407:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:408:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getGeneratedMetamodel_AsKeyword_3_0ElementType());
                    			
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:415:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:416:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:416:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:417:6: lv_alias_4_0= RULE_ID
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
    // PsiInternalXtextTerminalsTestLanguage.g:437:1: entryRuleReferencedMetamodel returns [Boolean current=false] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final Boolean entryRuleReferencedMetamodel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleReferencedMetamodel = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:437:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:438:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:444:1: ruleReferencedMetamodel returns [Boolean current=false] : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final Boolean ruleReferencedMetamodel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:445:1: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:446:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:446:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:447:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getReferencedMetamodel_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:454:3: ( (otherlv_1= RULE_STRING ) )
            // PsiInternalXtextTerminalsTestLanguage.g:455:4: (otherlv_1= RULE_STRING )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:455:4: (otherlv_1= RULE_STRING )
            // PsiInternalXtextTerminalsTestLanguage.g:456:5: otherlv_1= RULE_STRING
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

            // PsiInternalXtextTerminalsTestLanguage.g:471:3: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:472:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getReferencedMetamodel_AsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:479:4: ( (lv_alias_3_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:480:5: (lv_alias_3_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:480:5: (lv_alias_3_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:481:6: lv_alias_3_0= RULE_ID
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
    // PsiInternalXtextTerminalsTestLanguage.g:501:1: entryRuleParserRule returns [Boolean current=false] : iv_ruleParserRule= ruleParserRule EOF ;
    public final Boolean entryRuleParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParserRule = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:501:52: (iv_ruleParserRule= ruleParserRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:502:2: iv_ruleParserRule= ruleParserRule EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:508:1: ruleParserRule returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) ;
    public final Boolean ruleParserRule() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_type_2_0 = null;

        Boolean lv_alternatives_10_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:509:1: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:510:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:510:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            // PsiInternalXtextTerminalsTestLanguage.g:511:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';'
            {
            // PsiInternalXtextTerminalsTestLanguage.g:511:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:512:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:512:4: (lv_name_0_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:513:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParserRule_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:528:3: (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:529:4: otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {

                    				markLeaf(elementTypeProvider.getParserRule_ReturnsKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:536:4: ( (lv_type_2_0= ruleTypeRef ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:537:5: (lv_type_2_0= ruleTypeRef )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:537:5: (lv_type_2_0= ruleTypeRef )
                    // PsiInternalXtextTerminalsTestLanguage.g:538:6: lv_type_2_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getParserRule_TypeTypeRefParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_type_2_0=ruleTypeRef();

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

            // PsiInternalXtextTerminalsTestLanguage.g:552:3: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:553:4: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')'
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:553:4: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:554:5: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:554:5: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // PsiInternalXtextTerminalsTestLanguage.g:555:6: lv_definesHiddenTokens_3_0= 'hidden'
                    {

                    						markLeaf(elementTypeProvider.getParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0ElementType());
                    					
                    lv_definesHiddenTokens_3_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                    						doneLeaf(lv_definesHiddenTokens_3_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getParserRule_LeftParenthesisKeyword_2_1ElementType());
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:577:4: ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // PsiInternalXtextTerminalsTestLanguage.g:578:5: ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:578:5: ( (otherlv_5= RULE_ID ) )
                            // PsiInternalXtextTerminalsTestLanguage.g:579:6: (otherlv_5= RULE_ID )
                            {
                            // PsiInternalXtextTerminalsTestLanguage.g:579:6: (otherlv_5= RULE_ID )
                            // PsiInternalXtextTerminalsTestLanguage.g:580:7: otherlv_5= RULE_ID
                            {

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            							markLeaf(elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0ElementType());
                            						
                            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            							doneLeaf(otherlv_5);
                            						

                            }


                            }

                            // PsiInternalXtextTerminalsTestLanguage.g:595:5: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // PsiInternalXtextTerminalsTestLanguage.g:596:6: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getParserRule_CommaKeyword_2_2_1_0ElementType());
                            	    					
                            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            	    						doneLeaf(otherlv_6);
                            	    					
                            	    // PsiInternalXtextTerminalsTestLanguage.g:603:6: ( (otherlv_7= RULE_ID ) )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:604:7: (otherlv_7= RULE_ID )
                            	    {
                            	    // PsiInternalXtextTerminalsTestLanguage.g:604:7: (otherlv_7= RULE_ID )
                            	    // PsiInternalXtextTerminalsTestLanguage.g:605:8: otherlv_7= RULE_ID
                            	    {

                            	    								if (!current) {
                            	    									associateWithSemanticElement();
                            	    									current = true;
                            	    								}
                            	    							

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
            		
            // PsiInternalXtextTerminalsTestLanguage.g:637:3: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // PsiInternalXtextTerminalsTestLanguage.g:638:4: (lv_alternatives_10_0= ruleAlternatives )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:638:4: (lv_alternatives_10_0= ruleAlternatives )
            // PsiInternalXtextTerminalsTestLanguage.g:639:5: lv_alternatives_10_0= ruleAlternatives
            {

            					markComposite(elementTypeProvider.getParserRule_AlternativesAlternativesParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            lv_alternatives_10_0=ruleAlternatives();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "entryRuleTypeRef"
    // PsiInternalXtextTerminalsTestLanguage.g:663:1: entryRuleTypeRef returns [Boolean current=false] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final Boolean entryRuleTypeRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeRef = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:663:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:664:2: iv_ruleTypeRef= ruleTypeRef EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:670:1: ruleTypeRef returns [Boolean current=false] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final Boolean ruleTypeRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:671:1: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:672:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:672:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:673:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:673:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
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
                    // PsiInternalXtextTerminalsTestLanguage.g:674:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:674:4: ( (otherlv_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:675:5: (otherlv_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:675:5: (otherlv_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:676:6: otherlv_0= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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

            // PsiInternalXtextTerminalsTestLanguage.g:699:3: ( (otherlv_2= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:700:4: (otherlv_2= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:700:4: (otherlv_2= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:701:5: otherlv_2= RULE_ID
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
    // PsiInternalXtextTerminalsTestLanguage.g:720:1: entryRuleAlternatives returns [Boolean current=false] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final Boolean entryRuleAlternatives() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAlternatives = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:720:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:721:2: iv_ruleAlternatives= ruleAlternatives EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:727:1: ruleAlternatives returns [Boolean current=false] : (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final Boolean ruleAlternatives() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Group_0 = null;

        Boolean lv_groups_3_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:728:1: ( (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:729:2: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:729:2: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:730:3: this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAlternatives_GroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            this_Group_0=ruleGroup();

            state._fsp--;


            			current = this_Group_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:738:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:739:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:739:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:740:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAlternatives_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:746:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
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
                    	    // PsiInternalXtextTerminalsTestLanguage.g:747:5: otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_16); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:754:5: ( (lv_groups_3_0= ruleGroup ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:755:6: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:755:6: (lv_groups_3_0= ruleGroup )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:756:7: lv_groups_3_0= ruleGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getAlternatives_GroupsGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    lv_groups_3_0=ruleGroup();

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
        return current;
    }
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleGroup"
    // PsiInternalXtextTerminalsTestLanguage.g:775:1: entryRuleGroup returns [Boolean current=false] : iv_ruleGroup= ruleGroup EOF ;
    public final Boolean entryRuleGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGroup = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:775:47: (iv_ruleGroup= ruleGroup EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:776:2: iv_ruleGroup= ruleGroup EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:782:1: ruleGroup returns [Boolean current=false] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) ;
    public final Boolean ruleGroup() throws RecognitionException {
        Boolean current = false;

        Boolean this_AbstractToken_0 = null;

        Boolean lv_tokens_2_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:783:1: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:784:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:784:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:785:3: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getGroup_AbstractTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_20);
            this_AbstractToken_0=ruleAbstractToken();

            state._fsp--;


            			current = this_AbstractToken_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:793:3: ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==15||LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:794:4: () ( (lv_tokens_2_0= ruleAbstractToken ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:794:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:795:5: 
                    {

                    					precedeComposite(elementTypeProvider.getGroup_GroupTokensAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:801:4: ( (lv_tokens_2_0= ruleAbstractToken ) )+
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
                    	    // PsiInternalXtextTerminalsTestLanguage.g:802:5: (lv_tokens_2_0= ruleAbstractToken )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:802:5: (lv_tokens_2_0= ruleAbstractToken )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:803:6: lv_tokens_2_0= ruleAbstractToken
                    	    {

                    	    						markComposite(elementTypeProvider.getGroup_TokensAbstractTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_20);
                    	    lv_tokens_2_0=ruleAbstractToken();

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
        return current;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // PsiInternalXtextTerminalsTestLanguage.g:821:1: entryRuleAbstractToken returns [Boolean current=false] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final Boolean entryRuleAbstractToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractToken = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:821:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:822:2: iv_ruleAbstractToken= ruleAbstractToken EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:828:1: ruleAbstractToken returns [Boolean current=false] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final Boolean ruleAbstractToken() throws RecognitionException {
        Boolean current = false;

        Boolean this_AbstractTokenWithCardinality_0 = null;

        Boolean this_Action_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:829:1: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // PsiInternalXtextTerminalsTestLanguage.g:830:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:830:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:831:3: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
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
                    // PsiInternalXtextTerminalsTestLanguage.g:840:3: this_Action_1= ruleAction
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
    // PsiInternalXtextTerminalsTestLanguage.g:852:1: entryRuleAbstractTokenWithCardinality returns [Boolean current=false] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final Boolean entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractTokenWithCardinality = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:852:70: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:853:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:859:1: ruleAbstractTokenWithCardinality returns [Boolean current=false] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final Boolean ruleAbstractTokenWithCardinality() throws RecognitionException {
        Boolean current = false;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        Boolean this_Assignment_0 = null;

        Boolean this_AbstractTerminal_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:860:1: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:861:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:861:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:862:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // PsiInternalXtextTerminalsTestLanguage.g:862:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==EOF||(LA23_1>=RULE_ID && LA23_1<=RULE_STRING)||(LA23_1>=15 && LA23_1<=16)||LA23_1==23||(LA23_1>=25 && LA23_1<=29)) ) {
                    alt23=2;
                }
                else if ( ((LA23_1>=30 && LA23_1<=31)||LA23_1==34) ) {
                    alt23=1;
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
                    // PsiInternalXtextTerminalsTestLanguage.g:863:4: this_Assignment_0= ruleAssignment
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_21);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;


                    				current = this_Assignment_0;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:872:4: this_AbstractTerminal_1= ruleAbstractTerminal
                    {

                    				markComposite(elementTypeProvider.getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_21);
                    this_AbstractTerminal_1=ruleAbstractTerminal();

                    state._fsp--;


                    				current = this_AbstractTerminal_1;
                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalXtextTerminalsTestLanguage.g:881:3: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=26 && LA25_0<=28)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:882:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:882:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:883:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:883:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
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
                            // PsiInternalXtextTerminalsTestLanguage.g:884:6: lv_cardinality_2_1= '?'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					
                            lv_cardinality_2_1=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_2_1);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalXtextTerminalsTestLanguage.g:898:6: lv_cardinality_2_2= '*'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					
                            lv_cardinality_2_2=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_2_2);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;
                        case 3 :
                            // PsiInternalXtextTerminalsTestLanguage.g:912:6: lv_cardinality_2_3= '+'
                            {

                            						markLeaf(elementTypeProvider.getAbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					
                            lv_cardinality_2_3=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_2_3);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

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
        return current;
    }
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "entryRuleAction"
    // PsiInternalXtextTerminalsTestLanguage.g:932:1: entryRuleAction returns [Boolean current=false] : iv_ruleAction= ruleAction EOF ;
    public final Boolean entryRuleAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAction = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:932:48: (iv_ruleAction= ruleAction EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:933:2: iv_ruleAction= ruleAction EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:939:1: ruleAction returns [Boolean current=false] : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
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
            // PsiInternalXtextTerminalsTestLanguage.g:940:1: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:941:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:941:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // PsiInternalXtextTerminalsTestLanguage.g:942:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getAction_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:949:3: ( (lv_type_1_0= ruleTypeRef ) )
            // PsiInternalXtextTerminalsTestLanguage.g:950:4: (lv_type_1_0= ruleTypeRef )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:950:4: (lv_type_1_0= ruleTypeRef )
            // PsiInternalXtextTerminalsTestLanguage.g:951:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getAction_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_22);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:964:3: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:965:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {

                    				markLeaf(elementTypeProvider.getAction_FullStopKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:972:4: ( (lv_feature_3_0= RULE_ID ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:973:5: (lv_feature_3_0= RULE_ID )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:973:5: (lv_feature_3_0= RULE_ID )
                    // PsiInternalXtextTerminalsTestLanguage.g:974:6: lv_feature_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAction_FeatureIDTerminalRuleCall_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

                    						doneLeaf(lv_feature_3_0);
                    					

                    }


                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:989:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:990:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:990:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:991:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:991:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
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
                            // PsiInternalXtextTerminalsTestLanguage.g:992:7: lv_operator_4_1= '='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorEqualsSignKeyword_2_2_0_0ElementType());
                            						
                            lv_operator_4_1=(Token)match(input,30,FollowSets000.FOLLOW_24); 

                            							doneLeaf(lv_operator_4_1);
                            						

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalXtextTerminalsTestLanguage.g:1006:7: lv_operator_4_2= '+='
                            {

                            							markLeaf(elementTypeProvider.getAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType());
                            						
                            lv_operator_4_2=(Token)match(input,31,FollowSets000.FOLLOW_24); 

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
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:1041:1: entryRuleAbstractTerminal returns [Boolean current=false] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final Boolean entryRuleAbstractTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractTerminal = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1041:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1042:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1048:1: ruleAbstractTerminal returns [Boolean current=false] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final Boolean ruleAbstractTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean this_Keyword_0 = null;

        Boolean this_RuleCall_1 = null;

        Boolean this_ParenthesizedElement_2 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1049:1: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1050:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1050:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1051:3: this_Keyword_0= ruleKeyword
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1060:3: this_RuleCall_1= ruleRuleCall
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1069:3: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {

                    			markComposite(elementTypeProvider.getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();

                    state._fsp--;


                    			current = this_ParenthesizedElement_2;
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
    // PsiInternalXtextTerminalsTestLanguage.g:1081:1: entryRuleKeyword returns [Boolean current=false] : iv_ruleKeyword= ruleKeyword EOF ;
    public final Boolean entryRuleKeyword() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleKeyword = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1081:49: (iv_ruleKeyword= ruleKeyword EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1082:2: iv_ruleKeyword= ruleKeyword EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1088:1: ruleKeyword returns [Boolean current=false] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final Boolean ruleKeyword() throws RecognitionException {
        Boolean current = false;

        Token lv_value_0_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1089:1: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1090:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1090:2: ( (lv_value_0_0= RULE_STRING ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1091:3: (lv_value_0_0= RULE_STRING )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1091:3: (lv_value_0_0= RULE_STRING )
            // PsiInternalXtextTerminalsTestLanguage.g:1092:4: lv_value_0_0= RULE_STRING
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
    // PsiInternalXtextTerminalsTestLanguage.g:1110:1: entryRuleRuleCall returns [Boolean current=false] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final Boolean entryRuleRuleCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRuleCall = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1110:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1111:2: iv_ruleRuleCall= ruleRuleCall EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1117:1: ruleRuleCall returns [Boolean current=false] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean ruleRuleCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1118:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1119:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1119:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1120:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1120:3: (otherlv_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:1121:4: otherlv_0= RULE_ID
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

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
        return current;
    }
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // PsiInternalXtextTerminalsTestLanguage.g:1139:1: entryRuleAssignment returns [Boolean current=false] : iv_ruleAssignment= ruleAssignment EOF ;
    public final Boolean entryRuleAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignment = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1139:52: (iv_ruleAssignment= ruleAssignment EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1140:2: iv_ruleAssignment= ruleAssignment EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1146:1: ruleAssignment returns [Boolean current=false] : ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) ;
    public final Boolean ruleAssignment() throws RecognitionException {
        Boolean current = false;

        Token lv_feature_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        Boolean lv_terminal_2_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1147:1: ( ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1148:2: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1148:2: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1149:3: ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1149:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1150:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1150:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:1151:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1166:3: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1167:4: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1167:4: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1168:5: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1168:5: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1169:6: lv_operator_1_1= '+='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorPlusSignEqualsSignKeyword_1_0_0ElementType());
                    					
                    lv_operator_1_1=(Token)match(input,31,FollowSets000.FOLLOW_27); 

                    						doneLeaf(lv_operator_1_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1183:6: lv_operator_1_2= '='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorEqualsSignKeyword_1_0_1ElementType());
                    					
                    lv_operator_1_2=(Token)match(input,30,FollowSets000.FOLLOW_27); 

                    						doneLeaf(lv_operator_1_2);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1197:6: lv_operator_1_3= '?='
                    {

                    						markLeaf(elementTypeProvider.getAssignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2ElementType());
                    					
                    lv_operator_1_3=(Token)match(input,34,FollowSets000.FOLLOW_27); 

                    						doneLeaf(lv_operator_1_3);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1213:3: ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1214:4: (lv_terminal_2_0= ruleAssignableTerminal )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1214:4: (lv_terminal_2_0= ruleAssignableTerminal )
            // PsiInternalXtextTerminalsTestLanguage.g:1215:5: lv_terminal_2_0= ruleAssignableTerminal
            {

            					markComposite(elementTypeProvider.getAssignment_TerminalAssignableTerminalParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_2_0=ruleAssignableTerminal();

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


    // $ANTLR start "entryRuleAssignableTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:1232:1: entryRuleAssignableTerminal returns [Boolean current=false] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final Boolean entryRuleAssignableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignableTerminal = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1232:60: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1233:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1239:1: ruleAssignableTerminal returns [Boolean current=false] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final Boolean ruleAssignableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean this_Keyword_0 = null;

        Boolean this_RuleCall_1 = null;

        Boolean this_ParenthesizedAssignableElement_2 = null;

        Boolean this_CrossReference_3 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1240:1: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1241:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1241:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1242:3: this_Keyword_0= ruleKeyword
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1251:3: this_RuleCall_1= ruleRuleCall
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1260:3: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1269:3: this_CrossReference_3= ruleCrossReference
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
    // PsiInternalXtextTerminalsTestLanguage.g:1281:1: entryRuleParenthesizedAssignableElement returns [Boolean current=false] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final Boolean entryRuleParenthesizedAssignableElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesizedAssignableElement = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1281:72: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1282:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1288:1: ruleParenthesizedAssignableElement returns [Boolean current=false] : (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final Boolean ruleParenthesizedAssignableElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_AssignableAlternatives_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1289:1: ( (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1290:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1290:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            // PsiInternalXtextTerminalsTestLanguage.g:1291:3: otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_28);
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
    // PsiInternalXtextTerminalsTestLanguage.g:1317:1: entryRuleAssignableAlternatives returns [Boolean current=false] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final Boolean entryRuleAssignableAlternatives() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignableAlternatives = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1317:64: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1318:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1324:1: ruleAssignableAlternatives returns [Boolean current=false] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final Boolean ruleAssignableAlternatives() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_AssignableTerminal_0 = null;

        Boolean lv_groups_3_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1325:1: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1326:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1326:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1327:3: this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            this_AssignableTerminal_0=ruleAssignableTerminal();

            state._fsp--;


            			current = this_AssignableTerminal_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1335:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1336:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1336:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1337:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAssignableAlternatives_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:1343:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
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
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1344:5: otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_27); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1351:5: ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1352:6: (lv_groups_3_0= ruleAssignableTerminal )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1352:6: (lv_groups_3_0= ruleAssignableTerminal )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1353:7: lv_groups_3_0= ruleAssignableTerminal
                    	    {

                    	    							markComposite(elementTypeProvider.getAssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    lv_groups_3_0=ruleAssignableTerminal();

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
        return current;
    }
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // PsiInternalXtextTerminalsTestLanguage.g:1372:1: entryRuleCrossReference returns [Boolean current=false] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final Boolean entryRuleCrossReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCrossReference = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1372:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1373:2: iv_ruleCrossReference= ruleCrossReference EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1379:1: ruleCrossReference returns [Boolean current=false] : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final Boolean ruleCrossReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_type_1_0 = null;

        Boolean lv_terminal_3_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1380:1: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1381:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1381:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // PsiInternalXtextTerminalsTestLanguage.g:1382:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {

            			markLeaf(elementTypeProvider.getCrossReference_LeftSquareBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1389:3: ( (lv_type_1_0= ruleTypeRef ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1390:4: (lv_type_1_0= ruleTypeRef )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1390:4: (lv_type_1_0= ruleTypeRef )
            // PsiInternalXtextTerminalsTestLanguage.g:1391:5: lv_type_1_0= ruleTypeRef
            {

            					markComposite(elementTypeProvider.getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_29);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1404:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1405:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {

                    				markLeaf(elementTypeProvider.getCrossReference_VerticalLineKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_30); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:1412:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1413:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1413:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // PsiInternalXtextTerminalsTestLanguage.g:1414:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						markComposite(elementTypeProvider.getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_31);
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
        return current;
    }
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // PsiInternalXtextTerminalsTestLanguage.g:1439:1: entryRuleCrossReferenceableTerminal returns [Boolean current=false] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final Boolean entryRuleCrossReferenceableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCrossReferenceableTerminal = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1439:68: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1440:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1446:1: ruleCrossReferenceableTerminal returns [Boolean current=false] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) ;
    public final Boolean ruleCrossReferenceableTerminal() throws RecognitionException {
        Boolean current = false;

        Boolean this_Keyword_0 = null;

        Boolean this_RuleCall_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1447:1: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1448:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1448:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1449:3: this_Keyword_0= ruleKeyword
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1458:3: this_RuleCall_1= ruleRuleCall
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
    // PsiInternalXtextTerminalsTestLanguage.g:1470:1: entryRuleParenthesizedElement returns [Boolean current=false] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final Boolean entryRuleParenthesizedElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesizedElement = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1470:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1471:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1477:1: ruleParenthesizedElement returns [Boolean current=false] : (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final Boolean ruleParenthesizedElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Alternatives_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1478:1: ( (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1479:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1479:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // PsiInternalXtextTerminalsTestLanguage.g:1480:3: otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedElement_AlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_28);
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


    // $ANTLR start "entryRuleTerminalRule"
    // PsiInternalXtextTerminalsTestLanguage.g:1506:1: entryRuleTerminalRule returns [Boolean current=false] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final Boolean entryRuleTerminalRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalRule = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1506:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1507:2: iv_ruleTerminalRule= ruleTerminalRule EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1513:1: ruleTerminalRule returns [Boolean current=false] : (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) ;
    public final Boolean ruleTerminalRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_alternatives_5_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1514:1: ( (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1515:2: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1515:2: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            // PsiInternalXtextTerminalsTestLanguage.g:1516:3: otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';'
            {

            			markLeaf(elementTypeProvider.getTerminalRule_TerminalKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1523:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1524:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1524:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:1525:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:1540:3: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==21) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1541:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {

                    				markLeaf(elementTypeProvider.getTerminalRule_ReturnsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:1548:4: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1549:5: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1549:5: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalXtextTerminalsTestLanguage.g:1550:6: lv_type_3_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getTerminalRule_TypeTypeRefParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_15);
                    lv_type_3_0=ruleTypeRef();

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


            			markLeaf(elementTypeProvider.getTerminalRule_ColonKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1571:3: ( (lv_alternatives_5_0= ruleTerminalAlternatives ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1572:4: (lv_alternatives_5_0= ruleTerminalAlternatives )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1572:4: (lv_alternatives_5_0= ruleTerminalAlternatives )
            // PsiInternalXtextTerminalsTestLanguage.g:1573:5: lv_alternatives_5_0= ruleTerminalAlternatives
            {

            					markComposite(elementTypeProvider.getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            lv_alternatives_5_0=ruleTerminalAlternatives();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // PsiInternalXtextTerminalsTestLanguage.g:1597:1: entryRuleTerminalAlternatives returns [Boolean current=false] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final Boolean entryRuleTerminalAlternatives() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalAlternatives = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1597:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1598:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1604:1: ruleTerminalAlternatives returns [Boolean current=false] : (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final Boolean ruleTerminalAlternatives() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_TerminalGroup_0 = null;

        Boolean lv_groups_3_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1605:1: ( (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1606:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1606:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1607:3: this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            this_TerminalGroup_0=ruleTerminalGroup();

            state._fsp--;


            			current = this_TerminalGroup_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1615:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1616:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1616:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1617:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalAlternatives_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:1623:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
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
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1624:5: otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_33); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1631:5: ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1632:6: (lv_groups_3_0= ruleTerminalGroup )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1632:6: (lv_groups_3_0= ruleTerminalGroup )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1633:7: lv_groups_3_0= ruleTerminalGroup
                    	    {

                    	    							markComposite(elementTypeProvider.getTerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    lv_groups_3_0=ruleTerminalGroup();

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
        return current;
    }
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // PsiInternalXtextTerminalsTestLanguage.g:1652:1: entryRuleTerminalGroup returns [Boolean current=false] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final Boolean entryRuleTerminalGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalGroup = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1652:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1653:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1659:1: ruleTerminalGroup returns [Boolean current=false] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) ;
    public final Boolean ruleTerminalGroup() throws RecognitionException {
        Boolean current = false;

        Boolean this_TerminalToken_0 = null;

        Boolean lv_tokens_2_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1660:1: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1661:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1661:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1662:3: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            {

            			markComposite(elementTypeProvider.getTerminalGroup_TerminalTokenParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_34);
            this_TerminalToken_0=ruleTerminalToken();

            state._fsp--;


            			current = this_TerminalToken_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1670:3: ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)||LA39_0==15||LA39_0==17||(LA39_0>=38 && LA39_0<=39)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1671:4: () ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1671:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:1672:5: 
                    {

                    					precedeComposite(elementTypeProvider.getTerminalGroup_GroupTokensAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:1678:4: ( (lv_tokens_2_0= ruleTerminalToken ) )+
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
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1679:5: (lv_tokens_2_0= ruleTerminalToken )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1679:5: (lv_tokens_2_0= ruleTerminalToken )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:1680:6: lv_tokens_2_0= ruleTerminalToken
                    	    {

                    	    						markComposite(elementTypeProvider.getTerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_34);
                    	    lv_tokens_2_0=ruleTerminalToken();

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
        return current;
    }
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // PsiInternalXtextTerminalsTestLanguage.g:1698:1: entryRuleTerminalToken returns [Boolean current=false] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final Boolean entryRuleTerminalToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalToken = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1698:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1699:2: iv_ruleTerminalToken= ruleTerminalToken EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1705:1: ruleTerminalToken returns [Boolean current=false] : (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final Boolean ruleTerminalToken() throws RecognitionException {
        Boolean current = false;

        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;
        Boolean this_TerminalTokenElement_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1706:1: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1707:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1707:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:1708:3: this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {

            			markComposite(elementTypeProvider.getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_21);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();

            state._fsp--;


            			current = this_TerminalTokenElement_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1716:3: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=26 && LA41_0<=28)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1717:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1717:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:1718:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:1718:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
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
                            // PsiInternalXtextTerminalsTestLanguage.g:1719:6: lv_cardinality_1_1= '?'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityQuestionMarkKeyword_1_0_0ElementType());
                            					
                            lv_cardinality_1_1=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_1_1);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalXtextTerminalsTestLanguage.g:1733:6: lv_cardinality_1_2= '*'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityAsteriskKeyword_1_0_1ElementType());
                            					
                            lv_cardinality_1_2=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_1_2);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;
                        case 3 :
                            // PsiInternalXtextTerminalsTestLanguage.g:1747:6: lv_cardinality_1_3= '+'
                            {

                            						markLeaf(elementTypeProvider.getTerminalToken_CardinalityPlusSignKeyword_1_0_2ElementType());
                            					
                            lv_cardinality_1_3=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                            						doneLeaf(lv_cardinality_1_3);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

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
        return current;
    }
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // PsiInternalXtextTerminalsTestLanguage.g:1767:1: entryRuleTerminalTokenElement returns [Boolean current=false] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final Boolean entryRuleTerminalTokenElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalTokenElement = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1767:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1768:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1774:1: ruleTerminalTokenElement returns [Boolean current=false] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final Boolean ruleTerminalTokenElement() throws RecognitionException {
        Boolean current = false;

        Boolean this_CharacterRange_0 = null;

        Boolean this_RuleCall_1 = null;

        Boolean this_ParenthesizedTerminalElement_2 = null;

        Boolean this_AbstractNegatedToken_3 = null;

        Boolean this_Wildcard_4 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1775:1: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1776:2: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1776:2: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1777:3: this_CharacterRange_0= ruleCharacterRange
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1786:3: this_RuleCall_1= ruleRuleCall
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_RuleCallParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalXtextTerminalsTestLanguage.g:1795:3: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1804:3: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1813:3: this_Wildcard_4= ruleWildcard
                    {

                    			markComposite(elementTypeProvider.getTerminalTokenElement_WildcardParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Wildcard_4=ruleWildcard();

                    state._fsp--;


                    			current = this_Wildcard_4;
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
    // PsiInternalXtextTerminalsTestLanguage.g:1825:1: entryRuleParenthesizedTerminalElement returns [Boolean current=false] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final Boolean entryRuleParenthesizedTerminalElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesizedTerminalElement = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1825:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1826:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1832:1: ruleParenthesizedTerminalElement returns [Boolean current=false] : (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final Boolean ruleParenthesizedTerminalElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_TerminalAlternatives_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1833:1: ( (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1834:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1834:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            // PsiInternalXtextTerminalsTestLanguage.g:1835:3: otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_28);
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
    // PsiInternalXtextTerminalsTestLanguage.g:1861:1: entryRuleAbstractNegatedToken returns [Boolean current=false] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final Boolean entryRuleAbstractNegatedToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractNegatedToken = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1861:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1862:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1868:1: ruleAbstractNegatedToken returns [Boolean current=false] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final Boolean ruleAbstractNegatedToken() throws RecognitionException {
        Boolean current = false;

        Boolean this_NegatedToken_0 = null;

        Boolean this_UntilToken_1 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1869:1: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1870:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1870:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1871:3: this_NegatedToken_0= ruleNegatedToken
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
                    // PsiInternalXtextTerminalsTestLanguage.g:1880:3: this_UntilToken_1= ruleUntilToken
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
    // PsiInternalXtextTerminalsTestLanguage.g:1892:1: entryRuleNegatedToken returns [Boolean current=false] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final Boolean entryRuleNegatedToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNegatedToken = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1892:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1893:2: iv_ruleNegatedToken= ruleNegatedToken EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1899:1: ruleNegatedToken returns [Boolean current=false] : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final Boolean ruleNegatedToken() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_terminal_1_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1900:1: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1901:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1901:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1902:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getNegatedToken_ExclamationMarkKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1909:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1910:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1910:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // PsiInternalXtextTerminalsTestLanguage.g:1911:5: lv_terminal_1_0= ruleTerminalTokenElement
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
    // PsiInternalXtextTerminalsTestLanguage.g:1928:1: entryRuleUntilToken returns [Boolean current=false] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final Boolean entryRuleUntilToken() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUntilToken = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1928:52: (iv_ruleUntilToken= ruleUntilToken EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1929:2: iv_ruleUntilToken= ruleUntilToken EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1935:1: ruleUntilToken returns [Boolean current=false] : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final Boolean ruleUntilToken() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_terminal_1_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1936:1: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1937:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1937:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1938:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {

            			markLeaf(elementTypeProvider.getUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:1945:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1946:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1946:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // PsiInternalXtextTerminalsTestLanguage.g:1947:5: lv_terminal_1_0= ruleTerminalTokenElement
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
    // PsiInternalXtextTerminalsTestLanguage.g:1964:1: entryRuleWildcard returns [Boolean current=false] : iv_ruleWildcard= ruleWildcard EOF ;
    public final Boolean entryRuleWildcard() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleWildcard = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1964:50: (iv_ruleWildcard= ruleWildcard EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1965:2: iv_ruleWildcard= ruleWildcard EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1971:1: ruleWildcard returns [Boolean current=false] : ( () otherlv_1= '.' ) ;
    public final Boolean ruleWildcard() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1972:1: ( ( () otherlv_1= '.' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:1973:2: ( () otherlv_1= '.' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1973:2: ( () otherlv_1= '.' )
            // PsiInternalXtextTerminalsTestLanguage.g:1974:3: () otherlv_1= '.'
            {
            // PsiInternalXtextTerminalsTestLanguage.g:1974:3: ()
            // PsiInternalXtextTerminalsTestLanguage.g:1975:4: 
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


    // $ANTLR start "entryRuleCharacterRange"
    // PsiInternalXtextTerminalsTestLanguage.g:1992:1: entryRuleCharacterRange returns [Boolean current=false] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final Boolean entryRuleCharacterRange() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCharacterRange = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:1992:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:1993:2: iv_ruleCharacterRange= ruleCharacterRange EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:1999:1: ruleCharacterRange returns [Boolean current=false] : (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final Boolean ruleCharacterRange() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Keyword_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:2000:1: ( (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:2001:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2001:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:2002:3: this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			markComposite(elementTypeProvider.getCharacterRange_KeywordParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_35);
            this_Keyword_0=ruleKeyword();

            state._fsp--;


            			current = this_Keyword_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:2010:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==40) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:2011:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:2011:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:2012:5: 
                    {

                    					precedeComposite(elementTypeProvider.getCharacterRange_CharacterRangeLeftAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }


                    				markLeaf(elementTypeProvider.getCharacterRange_FullStopFullStopKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:2025:4: ( (lv_right_3_0= ruleKeyword ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:2026:5: (lv_right_3_0= ruleKeyword )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:2026:5: (lv_right_3_0= ruleKeyword )
                    // PsiInternalXtextTerminalsTestLanguage.g:2027:6: lv_right_3_0= ruleKeyword
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
    // PsiInternalXtextTerminalsTestLanguage.g:2045:1: entryRuleEnumRule returns [Boolean current=false] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final Boolean entryRuleEnumRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumRule = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:2045:50: (iv_ruleEnumRule= ruleEnumRule EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:2046:2: iv_ruleEnumRule= ruleEnumRule EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:2052:1: ruleEnumRule returns [Boolean current=false] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) ;
    public final Boolean ruleEnumRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_alternatives_5_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:2053:1: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) )
            // PsiInternalXtextTerminalsTestLanguage.g:2054:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2054:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            // PsiInternalXtextTerminalsTestLanguage.g:2055:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';'
            {

            			markLeaf(elementTypeProvider.getEnumRule_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:2062:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:2063:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2063:4: (lv_name_1_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:2064:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumRule_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:2079:3: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==21) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:2080:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumRule_ReturnsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:2087:4: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:2088:5: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:2088:5: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalXtextTerminalsTestLanguage.g:2089:6: lv_type_3_0= ruleTypeRef
                    {

                    						markComposite(elementTypeProvider.getEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_15);
                    lv_type_3_0=ruleTypeRef();

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


            			markLeaf(elementTypeProvider.getEnumRule_ColonKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalXtextTerminalsTestLanguage.g:2110:3: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // PsiInternalXtextTerminalsTestLanguage.g:2111:4: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2111:4: (lv_alternatives_5_0= ruleEnumLiterals )
            // PsiInternalXtextTerminalsTestLanguage.g:2112:5: lv_alternatives_5_0= ruleEnumLiterals
            {

            					markComposite(elementTypeProvider.getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            lv_alternatives_5_0=ruleEnumLiterals();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // PsiInternalXtextTerminalsTestLanguage.g:2136:1: entryRuleEnumLiterals returns [Boolean current=false] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final Boolean entryRuleEnumLiterals() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumLiterals = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:2136:54: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:2137:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:2143:1: ruleEnumLiterals returns [Boolean current=false] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final Boolean ruleEnumLiterals() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_EnumLiteralDeclaration_0 = null;

        Boolean lv_groups_3_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:2144:1: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:2145:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2145:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // PsiInternalXtextTerminalsTestLanguage.g:2146:3: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			markComposite(elementTypeProvider.getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_19);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();

            state._fsp--;


            			current = this_EnumLiteralDeclaration_0;
            			doneComposite();
            		
            // PsiInternalXtextTerminalsTestLanguage.g:2154:3: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==25) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:2155:4: () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:2155:4: ()
                    // PsiInternalXtextTerminalsTestLanguage.g:2156:5: 
                    {

                    					precedeComposite(elementTypeProvider.getEnumLiterals_AlternativesGroupsAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalXtextTerminalsTestLanguage.g:2162:4: (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
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
                    	    // PsiInternalXtextTerminalsTestLanguage.g:2163:5: otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getEnumLiterals_VerticalLineKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalXtextTerminalsTestLanguage.g:2170:5: ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:2171:6: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // PsiInternalXtextTerminalsTestLanguage.g:2171:6: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    // PsiInternalXtextTerminalsTestLanguage.g:2172:7: lv_groups_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							markComposite(elementTypeProvider.getEnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    lv_groups_3_0=ruleEnumLiteralDeclaration();

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
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // PsiInternalXtextTerminalsTestLanguage.g:2191:1: entryRuleEnumLiteralDeclaration returns [Boolean current=false] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final Boolean entryRuleEnumLiteralDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumLiteralDeclaration = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:2191:64: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // PsiInternalXtextTerminalsTestLanguage.g:2192:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
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
    // PsiInternalXtextTerminalsTestLanguage.g:2198:1: ruleEnumLiteralDeclaration returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final Boolean ruleEnumLiteralDeclaration() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Boolean lv_literal_2_0 = null;


        try {
            // PsiInternalXtextTerminalsTestLanguage.g:2199:1: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // PsiInternalXtextTerminalsTestLanguage.g:2200:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2200:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // PsiInternalXtextTerminalsTestLanguage.g:2201:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2201:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalXtextTerminalsTestLanguage.g:2202:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalXtextTerminalsTestLanguage.g:2202:4: (otherlv_0= RULE_ID )
            // PsiInternalXtextTerminalsTestLanguage.g:2203:5: otherlv_0= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_36); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // PsiInternalXtextTerminalsTestLanguage.g:2218:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // PsiInternalXtextTerminalsTestLanguage.g:2219:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {

                    				markLeaf(elementTypeProvider.getEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalXtextTerminalsTestLanguage.g:2226:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // PsiInternalXtextTerminalsTestLanguage.g:2227:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // PsiInternalXtextTerminalsTestLanguage.g:2227:5: (lv_literal_2_0= ruleKeyword )
                    // PsiInternalXtextTerminalsTestLanguage.g:2228:6: lv_literal_2_0= ruleKeyword
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