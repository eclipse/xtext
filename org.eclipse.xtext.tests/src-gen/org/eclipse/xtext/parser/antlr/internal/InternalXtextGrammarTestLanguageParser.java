package org.eclipse.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalXtextGrammarTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'fragment'", "'*'", "':'", "';'", "'['", "']'", "'returns'", "'::'", "'|'", "'&'", "'?'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'!'", "'?='", "'=>'", "'->'", "'terminal'", "'EOF'", "'..'", "'enum'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalXtextGrammarTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextGrammarTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextGrammarTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXtextGrammarTestLanguage.g"; }



     	private XtextGrammarTestLanguageGrammarAccess grammarAccess;

        public InternalXtextGrammarTestLanguageParser(TokenStream input, XtextGrammarTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Grammar";
       	}

       	@Override
       	protected XtextGrammarTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGrammar"
    // InternalXtextGrammarTestLanguage.g:69:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // InternalXtextGrammarTestLanguage.g:69:48: (iv_ruleGrammar= ruleGrammar EOF )
            // InternalXtextGrammarTestLanguage.g:70:2: iv_ruleGrammar= ruleGrammar EOF
            {
             newCompositeNode(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGrammar=ruleGrammar();

            state._fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // InternalXtextGrammarTestLanguage.g:76:1: ruleGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_HiddenClause_6 = null;

        EObject lv_metamodelDeclarations_7_0 = null;

        EObject lv_rules_8_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:82:2: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ ) )
            // InternalXtextGrammarTestLanguage.g:83:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ )
            {
            // InternalXtextGrammarTestLanguage.g:83:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+ )
            // InternalXtextGrammarTestLanguage.g:84:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? (this_HiddenClause_6= ruleHiddenClause[$current] )? ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_8_0= ruleAbstractRule ) )+
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGrammarAccess().getGrammarKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:88:3: ( (lv_name_1_0= ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:89:4: (lv_name_1_0= ruleGrammarID )
            {
            // InternalXtextGrammarTestLanguage.g:89:4: (lv_name_1_0= ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:90:5: lv_name_1_0= ruleGrammarID
            {

            					newCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_name_1_0=ruleGrammarID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGrammarRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.GrammarID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:107:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:108:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getGrammarAccess().getWithKeyword_2_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:112:4: ( ( ruleGrammarID ) )
                    // InternalXtextGrammarTestLanguage.g:113:5: ( ruleGrammarID )
                    {
                    // InternalXtextGrammarTestLanguage.g:113:5: ( ruleGrammarID )
                    // InternalXtextGrammarTestLanguage.g:114:6: ruleGrammarID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGrammarRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_5);
                    ruleGrammarID();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXtextGrammarTestLanguage.g:128:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalXtextGrammarTestLanguage.g:129:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:133:5: ( ( ruleGrammarID ) )
                    	    // InternalXtextGrammarTestLanguage.g:134:6: ( ruleGrammarID )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:134:6: ( ruleGrammarID )
                    	    // InternalXtextGrammarTestLanguage.g:135:7: ruleGrammarID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getGrammarRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    ruleGrammarID();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

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

            // InternalXtextGrammarTestLanguage.g:151:3: (this_HiddenClause_6= ruleHiddenClause[$current] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:152:4: this_HiddenClause_6= ruleHiddenClause[$current]
                    {

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getGrammarRule());
                    				}
                    				newCompositeNode(grammarAccess.getGrammarAccess().getHiddenClauseParserRuleCall_3());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_HiddenClause_6=ruleHiddenClause(current);

                    state._fsp--;


                    				current = this_HiddenClause_6;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalXtextGrammarTestLanguage.g:164:3: ( (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:165:4: (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // InternalXtextGrammarTestLanguage.g:165:4: (lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration )
            	    // InternalXtextGrammarTestLanguage.g:166:5: lv_metamodelDeclarations_7_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_metamodelDeclarations_7_0=ruleAbstractMetamodelDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGrammarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"metamodelDeclarations",
            	    						lv_metamodelDeclarations_7_0,
            	    						"org.eclipse.xtext.XtextGrammarTestLanguage.AbstractMetamodelDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalXtextGrammarTestLanguage.g:183:3: ( (lv_rules_8_0= ruleAbstractRule ) )+
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
            	    // InternalXtextGrammarTestLanguage.g:184:4: (lv_rules_8_0= ruleAbstractRule )
            	    {
            	    // InternalXtextGrammarTestLanguage.g:184:4: (lv_rules_8_0= ruleAbstractRule )
            	    // InternalXtextGrammarTestLanguage.g:185:5: lv_rules_8_0= ruleAbstractRule
            	    {

            	    					newCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_rules_8_0=ruleAbstractRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGrammarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rules",
            	    						lv_rules_8_0,
            	    						"org.eclipse.xtext.XtextGrammarTestLanguage.AbstractRule");
            	    					afterParserOrEnumRuleCall();
            	    				

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "ruleHiddenClause"
    // InternalXtextGrammarTestLanguage.g:207:1: ruleHiddenClause[EObject in_current] returns [EObject current=in_current] : ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleHiddenClause(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_definesHiddenTokens_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:213:2: ( ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' ) )
            // InternalXtextGrammarTestLanguage.g:214:2: ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' )
            {
            // InternalXtextGrammarTestLanguage.g:214:2: ( ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')' )
            // InternalXtextGrammarTestLanguage.g:215:3: ( (lv_definesHiddenTokens_0_0= 'hidden' ) ) otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? otherlv_5= ')'
            {
            // InternalXtextGrammarTestLanguage.g:215:3: ( (lv_definesHiddenTokens_0_0= 'hidden' ) )
            // InternalXtextGrammarTestLanguage.g:216:4: (lv_definesHiddenTokens_0_0= 'hidden' )
            {
            // InternalXtextGrammarTestLanguage.g:216:4: (lv_definesHiddenTokens_0_0= 'hidden' )
            // InternalXtextGrammarTestLanguage.g:217:5: lv_definesHiddenTokens_0_0= 'hidden'
            {
            lv_definesHiddenTokens_0_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            					newLeafNode(lv_definesHiddenTokens_0_0, grammarAccess.getHiddenClauseAccess().getDefinesHiddenTokensHiddenKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHiddenClauseRule());
            					}
            					setWithLastConsumed(current, "definesHiddenTokens", lv_definesHiddenTokens_0_0 != null, "hidden");
            				

            }


            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getHiddenClauseAccess().getLeftParenthesisKeyword_1());
            		
            // InternalXtextGrammarTestLanguage.g:233:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:234:4: ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    {
                    // InternalXtextGrammarTestLanguage.g:234:4: ( (otherlv_2= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:235:5: (otherlv_2= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:235:5: (otherlv_2= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:236:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHiddenClauseRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						newLeafNode(otherlv_2, grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_0_0());
                    					

                    }


                    }

                    // InternalXtextGrammarTestLanguage.g:247:4: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalXtextGrammarTestLanguage.g:248:5: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getHiddenClauseAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:252:5: ( (otherlv_4= RULE_ID ) )
                    	    // InternalXtextGrammarTestLanguage.g:253:6: (otherlv_4= RULE_ID )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:253:6: (otherlv_4= RULE_ID )
                    	    // InternalXtextGrammarTestLanguage.g:254:7: otherlv_4= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getHiddenClauseRule());
                    	    							}
                    	    						
                    	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_4, grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_1_1_0());
                    	    						

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

            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getHiddenClauseAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHiddenClause"


    // $ANTLR start "entryRuleGrammarID"
    // InternalXtextGrammarTestLanguage.g:275:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // InternalXtextGrammarTestLanguage.g:275:49: (iv_ruleGrammarID= ruleGrammarID EOF )
            // InternalXtextGrammarTestLanguage.g:276:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             newCompositeNode(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGrammarID=ruleGrammarID();

            state._fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // InternalXtextGrammarTestLanguage.g:282:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:288:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalXtextGrammarTestLanguage.g:289:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalXtextGrammarTestLanguage.g:289:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalXtextGrammarTestLanguage.g:290:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0());
            		
            // InternalXtextGrammarTestLanguage.g:297:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:298:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalXtextGrammarTestLanguage.g:315:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // InternalXtextGrammarTestLanguage.g:315:53: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // InternalXtextGrammarTestLanguage.g:316:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalXtextGrammarTestLanguage.g:322:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:328:2: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // InternalXtextGrammarTestLanguage.g:329:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // InternalXtextGrammarTestLanguage.g:329:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
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
                    // InternalXtextGrammarTestLanguage.g:330:3: this_ParserRule_0= ruleParserRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParserRule_0=ruleParserRule();

                    state._fsp--;


                    			current = this_ParserRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:339:3: this_TerminalRule_1= ruleTerminalRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TerminalRule_1=ruleTerminalRule();

                    state._fsp--;


                    			current = this_TerminalRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:348:3: this_EnumRule_2= ruleEnumRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EnumRule_2=ruleEnumRule();

                    state._fsp--;


                    			current = this_EnumRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // InternalXtextGrammarTestLanguage.g:360:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // InternalXtextGrammarTestLanguage.g:360:69: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:361:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();

            state._fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // InternalXtextGrammarTestLanguage.g:367:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:373:2: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // InternalXtextGrammarTestLanguage.g:374:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // InternalXtextGrammarTestLanguage.g:374:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    // InternalXtextGrammarTestLanguage.g:375:3: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {

                    			newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();

                    state._fsp--;


                    			current = this_GeneratedMetamodel_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:384:3: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {

                    			newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();

                    state._fsp--;


                    			current = this_ReferencedMetamodel_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // InternalXtextGrammarTestLanguage.g:396:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // InternalXtextGrammarTestLanguage.g:396:59: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:397:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             newCompositeNode(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();

            state._fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // InternalXtextGrammarTestLanguage.g:403:1: ruleGeneratedMetamodel returns [EObject current=null] : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:409:2: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // InternalXtextGrammarTestLanguage.g:410:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // InternalXtextGrammarTestLanguage.g:410:2: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // InternalXtextGrammarTestLanguage.g:411:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:415:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:416:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:416:4: (lv_name_1_0= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:417:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:433:3: ( (otherlv_2= RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:434:4: (otherlv_2= RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:434:4: (otherlv_2= RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:435:5: otherlv_2= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            					newLeafNode(otherlv_2, grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0());
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:446:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:447:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:451:4: ( (lv_alias_4_0= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:452:5: (lv_alias_4_0= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:452:5: (lv_alias_4_0= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:453:6: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_alias_4_0, grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"alias",
                    							lv_alias_4_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // InternalXtextGrammarTestLanguage.g:474:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // InternalXtextGrammarTestLanguage.g:474:60: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:475:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             newCompositeNode(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();

            state._fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // InternalXtextGrammarTestLanguage.g:481:1: ruleReferencedMetamodel returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:487:2: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // InternalXtextGrammarTestLanguage.g:488:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // InternalXtextGrammarTestLanguage.g:488:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // InternalXtextGrammarTestLanguage.g:489:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:493:3: ( (otherlv_1= RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:494:4: (otherlv_1= RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:494:4: (otherlv_1= RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:495:5: otherlv_1= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferencedMetamodelRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            					newLeafNode(otherlv_1, grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0());
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:506:3: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:507:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:511:4: ( (lv_alias_3_0= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:512:5: (lv_alias_3_0= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:512:5: (lv_alias_3_0= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:513:6: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_alias_3_0, grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReferencedMetamodelRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"alias",
                    							lv_alias_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // InternalXtextGrammarTestLanguage.g:534:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // InternalXtextGrammarTestLanguage.g:534:51: (iv_ruleParserRule= ruleParserRule EOF )
            // InternalXtextGrammarTestLanguage.g:535:2: iv_ruleParserRule= ruleParserRule EOF
            {
             newCompositeNode(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRule=ruleParserRule();

            state._fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // InternalXtextGrammarTestLanguage.g:541:1: ruleParserRule returns [EObject current=null] : ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_0_0=null;
        Token lv_wildcard_2_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_RuleNameAndParams_1 = null;

        EObject this_ReturnsClause_3 = null;

        EObject this_RuleNameAndParams_4 = null;

        EObject this_ReturnsClause_5 = null;

        EObject this_HiddenClause_6 = null;

        EObject lv_alternatives_8_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:547:2: ( ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' ) )
            // InternalXtextGrammarTestLanguage.g:548:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            {
            // InternalXtextGrammarTestLanguage.g:548:2: ( ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            // InternalXtextGrammarTestLanguage.g:549:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) ) (this_HiddenClause_6= ruleHiddenClause[$current] )? otherlv_7= ':' ( (lv_alternatives_8_0= ruleAlternatives ) ) otherlv_9= ';'
            {
            // InternalXtextGrammarTestLanguage.g:549:3: ( ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) ) | (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? ) )
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
                    // InternalXtextGrammarTestLanguage.g:550:4: ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:550:4: ( ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? ) )
                    // InternalXtextGrammarTestLanguage.g:551:5: ( (lv_fragment_0_0= 'fragment' ) ) this_RuleNameAndParams_1= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? )
                    {
                    // InternalXtextGrammarTestLanguage.g:551:5: ( (lv_fragment_0_0= 'fragment' ) )
                    // InternalXtextGrammarTestLanguage.g:552:6: (lv_fragment_0_0= 'fragment' )
                    {
                    // InternalXtextGrammarTestLanguage.g:552:6: (lv_fragment_0_0= 'fragment' )
                    // InternalXtextGrammarTestLanguage.g:553:7: lv_fragment_0_0= 'fragment'
                    {
                    lv_fragment_0_0=(Token)match(input,21,FollowSets000.FOLLOW_13); 

                    							newLeafNode(lv_fragment_0_0, grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getParserRuleRule());
                    							}
                    							setWithLastConsumed(current, "fragment", lv_fragment_0_0 != null, "fragment");
                    						

                    }


                    }


                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParserRuleRule());
                    					}
                    					newCompositeNode(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_0_1());
                    				
                    pushFollow(FollowSets000.FOLLOW_14);
                    this_RuleNameAndParams_1=ruleRuleNameAndParams(current);

                    state._fsp--;


                    					current = this_RuleNameAndParams_1;
                    					afterParserOrEnumRuleCall();
                    				
                    // InternalXtextGrammarTestLanguage.g:576:5: ( ( (lv_wildcard_2_0= '*' ) ) | (this_ReturnsClause_3= ruleReturnsClause[$current] )? )
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
                            // InternalXtextGrammarTestLanguage.g:577:6: ( (lv_wildcard_2_0= '*' ) )
                            {
                            // InternalXtextGrammarTestLanguage.g:577:6: ( (lv_wildcard_2_0= '*' ) )
                            // InternalXtextGrammarTestLanguage.g:578:7: (lv_wildcard_2_0= '*' )
                            {
                            // InternalXtextGrammarTestLanguage.g:578:7: (lv_wildcard_2_0= '*' )
                            // InternalXtextGrammarTestLanguage.g:579:8: lv_wildcard_2_0= '*'
                            {
                            lv_wildcard_2_0=(Token)match(input,22,FollowSets000.FOLLOW_15); 

                            								newLeafNode(lv_wildcard_2_0, grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getParserRuleRule());
                            								}
                            								setWithLastConsumed(current, "wildcard", lv_wildcard_2_0 != null, "*");
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalXtextGrammarTestLanguage.g:592:6: (this_ReturnsClause_3= ruleReturnsClause[$current] )?
                            {
                            // InternalXtextGrammarTestLanguage.g:592:6: (this_ReturnsClause_3= ruleReturnsClause[$current] )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==27) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // InternalXtextGrammarTestLanguage.g:593:7: this_ReturnsClause_3= ruleReturnsClause[$current]
                                    {

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getParserRuleRule());
                                    							}
                                    							newCompositeNode(grammarAccess.getParserRuleAccess().getReturnsClauseParserRuleCall_0_0_2_1());
                                    						
                                    pushFollow(FollowSets000.FOLLOW_15);
                                    this_ReturnsClause_3=ruleReturnsClause(current);

                                    state._fsp--;


                                    							current = this_ReturnsClause_3;
                                    							afterParserOrEnumRuleCall();
                                    						

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
                    // InternalXtextGrammarTestLanguage.g:608:4: (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? )
                    {
                    // InternalXtextGrammarTestLanguage.g:608:4: (this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )? )
                    // InternalXtextGrammarTestLanguage.g:609:5: this_RuleNameAndParams_4= ruleRuleNameAndParams[$current] (this_ReturnsClause_5= ruleReturnsClause[$current] )?
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParserRuleRule());
                    					}
                    					newCompositeNode(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_16);
                    this_RuleNameAndParams_4=ruleRuleNameAndParams(current);

                    state._fsp--;


                    					current = this_RuleNameAndParams_4;
                    					afterParserOrEnumRuleCall();
                    				
                    // InternalXtextGrammarTestLanguage.g:620:5: (this_ReturnsClause_5= ruleReturnsClause[$current] )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==27) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalXtextGrammarTestLanguage.g:621:6: this_ReturnsClause_5= ruleReturnsClause[$current]
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getParserRuleRule());
                            						}
                            						newCompositeNode(grammarAccess.getParserRuleAccess().getReturnsClauseParserRuleCall_0_1_1());
                            					
                            pushFollow(FollowSets000.FOLLOW_15);
                            this_ReturnsClause_5=ruleReturnsClause(current);

                            state._fsp--;


                            						current = this_ReturnsClause_5;
                            						afterParserOrEnumRuleCall();
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalXtextGrammarTestLanguage.g:635:3: (this_HiddenClause_6= ruleHiddenClause[$current] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:636:4: this_HiddenClause_6= ruleHiddenClause[$current]
                    {

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getParserRuleRule());
                    				}
                    				newCompositeNode(grammarAccess.getParserRuleAccess().getHiddenClauseParserRuleCall_1());
                    			
                    pushFollow(FollowSets000.FOLLOW_17);
                    this_HiddenClause_6=ruleHiddenClause(current);

                    state._fsp--;


                    				current = this_HiddenClause_6;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_18); 

            			newLeafNode(otherlv_7, grammarAccess.getParserRuleAccess().getColonKeyword_2());
            		
            // InternalXtextGrammarTestLanguage.g:652:3: ( (lv_alternatives_8_0= ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:653:4: (lv_alternatives_8_0= ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:653:4: (lv_alternatives_8_0= ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:654:5: lv_alternatives_8_0= ruleAlternatives
            {

            					newCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_19);
            lv_alternatives_8_0=ruleAlternatives();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParserRuleRule());
            					}
            					set(
            						current,
            						"alternatives",
            						lv_alternatives_8_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.Alternatives");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getParserRuleAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "ruleRuleNameAndParams"
    // InternalXtextGrammarTestLanguage.g:680:1: ruleRuleNameAndParams[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? ) ;
    public final EObject ruleRuleNameAndParams(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:686:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? ) )
            // InternalXtextGrammarTestLanguage.g:687:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? )
            {
            // InternalXtextGrammarTestLanguage.g:687:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )? )
            // InternalXtextGrammarTestLanguage.g:688:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )?
            {
            // InternalXtextGrammarTestLanguage.g:688:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:689:4: (lv_name_0_0= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:689:4: (lv_name_0_0= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:690:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getRuleNameAndParamsAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleNameAndParamsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:706:3: (otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:707:4: otherlv_1= '[' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_21); 

                    				newLeafNode(otherlv_1, grammarAccess.getRuleNameAndParamsAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:711:4: ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_ID) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalXtextGrammarTestLanguage.g:712:5: ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            {
                            // InternalXtextGrammarTestLanguage.g:712:5: ( (lv_parameters_2_0= ruleParameter ) )
                            // InternalXtextGrammarTestLanguage.g:713:6: (lv_parameters_2_0= ruleParameter )
                            {
                            // InternalXtextGrammarTestLanguage.g:713:6: (lv_parameters_2_0= ruleParameter )
                            // InternalXtextGrammarTestLanguage.g:714:7: lv_parameters_2_0= ruleParameter
                            {

                            							newCompositeNode(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_22);
                            lv_parameters_2_0=ruleParameter();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRuleNameAndParamsRule());
                            							}
                            							add(
                            								current,
                            								"parameters",
                            								lv_parameters_2_0,
                            								"org.eclipse.xtext.XtextGrammarTestLanguage.Parameter");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalXtextGrammarTestLanguage.g:731:5: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==13) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // InternalXtextGrammarTestLanguage.g:732:6: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            	    						newLeafNode(otherlv_3, grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0());
                            	    					
                            	    // InternalXtextGrammarTestLanguage.g:736:6: ( (lv_parameters_4_0= ruleParameter ) )
                            	    // InternalXtextGrammarTestLanguage.g:737:7: (lv_parameters_4_0= ruleParameter )
                            	    {
                            	    // InternalXtextGrammarTestLanguage.g:737:7: (lv_parameters_4_0= ruleParameter )
                            	    // InternalXtextGrammarTestLanguage.g:738:8: lv_parameters_4_0= ruleParameter
                            	    {

                            	    								newCompositeNode(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_22);
                            	    lv_parameters_4_0=ruleParameter();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getRuleNameAndParamsRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"parameters",
                            	    									lv_parameters_4_0,
                            	    									"org.eclipse.xtext.XtextGrammarTestLanguage.Parameter");
                            	    								afterParserOrEnumRuleCall();
                            	    							

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

                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getRuleNameAndParamsAccess().getRightSquareBracketKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleNameAndParams"


    // $ANTLR start "ruleReturnsClause"
    // InternalXtextGrammarTestLanguage.g:767:1: ruleReturnsClause[EObject in_current] returns [EObject current=in_current] : (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) ) ;
    public final EObject ruleReturnsClause(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:773:2: ( (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) ) )
            // InternalXtextGrammarTestLanguage.g:774:2: (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:774:2: (otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) ) )
            // InternalXtextGrammarTestLanguage.g:775:3: otherlv_0= 'returns' ( (lv_type_1_0= ruleTypeRef ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getReturnsClauseAccess().getReturnsKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:779:3: ( (lv_type_1_0= ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:780:4: (lv_type_1_0= ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:780:4: (lv_type_1_0= ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:781:5: lv_type_1_0= ruleTypeRef
            {

            					newCompositeNode(grammarAccess.getReturnsClauseAccess().getTypeTypeRefParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReturnsClauseRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.TypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturnsClause"


    // $ANTLR start "entryRuleParameter"
    // InternalXtextGrammarTestLanguage.g:802:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalXtextGrammarTestLanguage.g:802:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalXtextGrammarTestLanguage.g:803:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalXtextGrammarTestLanguage.g:809:1: ruleParameter returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:815:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:816:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:816:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:817:3: (lv_name_0_0= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:817:3: (lv_name_0_0= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:818:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getParameterRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeRef"
    // InternalXtextGrammarTestLanguage.g:837:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalXtextGrammarTestLanguage.g:837:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalXtextGrammarTestLanguage.g:838:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             newCompositeNode(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalXtextGrammarTestLanguage.g:844:1: ruleTypeRef returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:850:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // InternalXtextGrammarTestLanguage.g:851:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:851:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:852:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:852:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
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
                    // InternalXtextGrammarTestLanguage.g:853:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalXtextGrammarTestLanguage.g:853:4: ( (otherlv_0= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:854:5: (otherlv_0= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:854:5: (otherlv_0= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:855:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRefRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

                    						newLeafNode(otherlv_0, grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalXtextGrammarTestLanguage.g:871:3: ( (otherlv_2= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:872:4: (otherlv_2= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:872:4: (otherlv_2= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:873:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypeRefRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // InternalXtextGrammarTestLanguage.g:888:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // InternalXtextGrammarTestLanguage.g:888:53: (iv_ruleAlternatives= ruleAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:889:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternatives=ruleAlternatives();

            state._fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // InternalXtextGrammarTestLanguage.g:895:1: ruleAlternatives returns [EObject current=null] : (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ConditionalBranch_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:901:2: ( (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) )
            // InternalXtextGrammarTestLanguage.g:902:2: (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            {
            // InternalXtextGrammarTestLanguage.g:902:2: (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            // InternalXtextGrammarTestLanguage.g:903:3: this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_ConditionalBranch_0=ruleConditionalBranch();

            state._fsp--;


            			current = this_ConditionalBranch_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:911:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:912:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    {
                    // InternalXtextGrammarTestLanguage.g:912:4: ()
                    // InternalXtextGrammarTestLanguage.g:913:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtextGrammarTestLanguage.g:919:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
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
                    	    // InternalXtextGrammarTestLanguage.g:920:5: otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    {
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_18); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:924:5: ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    // InternalXtextGrammarTestLanguage.g:925:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:925:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    // InternalXtextGrammarTestLanguage.g:926:7: lv_elements_3_0= ruleConditionalBranch
                    	    {

                    	    							newCompositeNode(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleConditionalBranch();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAlternativesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.XtextGrammarTestLanguage.ConditionalBranch");
                    	    							afterParserOrEnumRuleCall();
                    	    						

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleConditionalBranch"
    // InternalXtextGrammarTestLanguage.g:949:1: entryRuleConditionalBranch returns [EObject current=null] : iv_ruleConditionalBranch= ruleConditionalBranch EOF ;
    public final EObject entryRuleConditionalBranch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalBranch = null;


        try {
            // InternalXtextGrammarTestLanguage.g:949:58: (iv_ruleConditionalBranch= ruleConditionalBranch EOF )
            // InternalXtextGrammarTestLanguage.g:950:2: iv_ruleConditionalBranch= ruleConditionalBranch EOF
            {
             newCompositeNode(grammarAccess.getConditionalBranchRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConditionalBranch=ruleConditionalBranch();

            state._fsp--;

             current =iv_ruleConditionalBranch; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalBranch"


    // $ANTLR start "ruleConditionalBranch"
    // InternalXtextGrammarTestLanguage.g:956:1: ruleConditionalBranch returns [EObject current=null] : (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) ) ;
    public final EObject ruleConditionalBranch() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject this_UnorderedGroup_0 = null;

        AntlrDatatypeRuleToken lv_filtered_3_0 = null;

        EObject lv_guardedElement_6_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:962:2: ( (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) ) )
            // InternalXtextGrammarTestLanguage.g:963:2: (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:963:2: (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) ) )
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
                    // InternalXtextGrammarTestLanguage.g:964:3: this_UnorderedGroup_0= ruleUnorderedGroup
                    {

                    			newCompositeNode(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnorderedGroup_0=ruleUnorderedGroup();

                    state._fsp--;


                    			current = this_UnorderedGroup_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:973:3: ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:973:3: ( () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) ) )
                    // InternalXtextGrammarTestLanguage.g:974:4: () otherlv_2= '[' ( (lv_filtered_3_0= ruleInverseLiteralValue ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= ']' ( (lv_guardedElement_6_0= ruleUnorderedGroup ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:974:4: ()
                    // InternalXtextGrammarTestLanguage.g:975:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConditionalBranchAccess().getConditionalBranchAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25); 

                    				newLeafNode(otherlv_2, grammarAccess.getConditionalBranchAccess().getLeftSquareBracketKeyword_1_1());
                    			
                    // InternalXtextGrammarTestLanguage.g:985:4: ( (lv_filtered_3_0= ruleInverseLiteralValue ) )
                    // InternalXtextGrammarTestLanguage.g:986:5: (lv_filtered_3_0= ruleInverseLiteralValue )
                    {
                    // InternalXtextGrammarTestLanguage.g:986:5: (lv_filtered_3_0= ruleInverseLiteralValue )
                    // InternalXtextGrammarTestLanguage.g:987:6: lv_filtered_3_0= ruleInverseLiteralValue
                    {

                    						newCompositeNode(grammarAccess.getConditionalBranchAccess().getFilteredInverseLiteralValueParserRuleCall_1_2_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_filtered_3_0=ruleInverseLiteralValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalBranchRule());
                    						}
                    						set(
                    							current,
                    							"filtered",
                    							lv_filtered_3_0,
                    							"org.eclipse.xtext.XtextGrammarTestLanguage.InverseLiteralValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXtextGrammarTestLanguage.g:1004:4: ( (otherlv_4= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:1005:5: (otherlv_4= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:1005:5: (otherlv_4= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:1006:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConditionalBranchRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

                    						newLeafNode(otherlv_4, grammarAccess.getConditionalBranchAccess().getParameterParameterCrossReference_1_3_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_27); 

                    				newLeafNode(otherlv_5, grammarAccess.getConditionalBranchAccess().getRightSquareBracketKeyword_1_4());
                    			
                    // InternalXtextGrammarTestLanguage.g:1021:4: ( (lv_guardedElement_6_0= ruleUnorderedGroup ) )
                    // InternalXtextGrammarTestLanguage.g:1022:5: (lv_guardedElement_6_0= ruleUnorderedGroup )
                    {
                    // InternalXtextGrammarTestLanguage.g:1022:5: (lv_guardedElement_6_0= ruleUnorderedGroup )
                    // InternalXtextGrammarTestLanguage.g:1023:6: lv_guardedElement_6_0= ruleUnorderedGroup
                    {

                    						newCompositeNode(grammarAccess.getConditionalBranchAccess().getGuardedElementUnorderedGroupParserRuleCall_1_5_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_guardedElement_6_0=ruleUnorderedGroup();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalBranchRule());
                    						}
                    						set(
                    							current,
                    							"guardedElement",
                    							lv_guardedElement_6_0,
                    							"org.eclipse.xtext.XtextGrammarTestLanguage.UnorderedGroup");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // InternalXtextGrammarTestLanguage.g:1045:1: entryRuleUnorderedGroup returns [EObject current=null] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final EObject entryRuleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroup = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1045:55: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // InternalXtextGrammarTestLanguage.g:1046:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroup=ruleUnorderedGroup();

            state._fsp--;

             current =iv_ruleUnorderedGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // InternalXtextGrammarTestLanguage.g:1052:1: ruleUnorderedGroup returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1058:2: ( (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // InternalXtextGrammarTestLanguage.g:1059:2: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // InternalXtextGrammarTestLanguage.g:1059:2: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // InternalXtextGrammarTestLanguage.g:1060:3: this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_28);
            this_Group_0=ruleGroup();

            state._fsp--;


            			current = this_Group_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:1068:3: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==30) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1069:4: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // InternalXtextGrammarTestLanguage.g:1069:4: ()
                    // InternalXtextGrammarTestLanguage.g:1070:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtextGrammarTestLanguage.g:1076:4: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
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
                    	    // InternalXtextGrammarTestLanguage.g:1077:5: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_27); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:1081:5: ( (lv_elements_3_0= ruleGroup ) )
                    	    // InternalXtextGrammarTestLanguage.g:1082:6: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:1082:6: (lv_elements_3_0= ruleGroup )
                    	    // InternalXtextGrammarTestLanguage.g:1083:7: lv_elements_3_0= ruleGroup
                    	    {

                    	    							newCompositeNode(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_28);
                    	    lv_elements_3_0=ruleGroup();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getUnorderedGroupRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.XtextGrammarTestLanguage.Group");
                    	    							afterParserOrEnumRuleCall();
                    	    						

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // InternalXtextGrammarTestLanguage.g:1106:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1106:46: (iv_ruleGroup= ruleGroup EOF )
            // InternalXtextGrammarTestLanguage.g:1107:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalXtextGrammarTestLanguage.g:1113:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1119:2: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // InternalXtextGrammarTestLanguage.g:1120:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // InternalXtextGrammarTestLanguage.g:1120:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // InternalXtextGrammarTestLanguage.g:1121:3: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {

            			newCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_29);
            this_AbstractToken_0=ruleAbstractToken();

            state._fsp--;


            			current = this_AbstractToken_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:1129:3: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_STRING)||LA28_0==15||LA28_0==33||(LA28_0>=40 && LA28_0<=41)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1130:4: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // InternalXtextGrammarTestLanguage.g:1130:4: ()
                    // InternalXtextGrammarTestLanguage.g:1131:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getGroupAccess().getGroupElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtextGrammarTestLanguage.g:1137:4: ( (lv_elements_2_0= ruleAbstractToken ) )+
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
                    	    // InternalXtextGrammarTestLanguage.g:1138:5: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:1138:5: (lv_elements_2_0= ruleAbstractToken )
                    	    // InternalXtextGrammarTestLanguage.g:1139:6: lv_elements_2_0= ruleAbstractToken
                    	    {

                    	    						newCompositeNode(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_29);
                    	    lv_elements_2_0=ruleAbstractToken();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getGroupRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_2_0,
                    	    							"org.eclipse.xtext.XtextGrammarTestLanguage.AbstractToken");
                    	    						afterParserOrEnumRuleCall();
                    	    					

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // InternalXtextGrammarTestLanguage.g:1161:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1161:54: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // InternalXtextGrammarTestLanguage.g:1162:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractToken=ruleAbstractToken();

            state._fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // InternalXtextGrammarTestLanguage.g:1168:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1174:2: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // InternalXtextGrammarTestLanguage.g:1175:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // InternalXtextGrammarTestLanguage.g:1175:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    // InternalXtextGrammarTestLanguage.g:1176:3: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {

                    			newCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();

                    state._fsp--;


                    			current = this_AbstractTokenWithCardinality_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1185:3: this_Action_1= ruleAction
                    {

                    			newCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Action_1=ruleAction();

                    state._fsp--;


                    			current = this_Action_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // InternalXtextGrammarTestLanguage.g:1197:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1197:69: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // InternalXtextGrammarTestLanguage.g:1198:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();

            state._fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // InternalXtextGrammarTestLanguage.g:1204:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;

        EObject this_Cardinalities_2 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1210:2: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? ) )
            // InternalXtextGrammarTestLanguage.g:1211:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? )
            {
            // InternalXtextGrammarTestLanguage.g:1211:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )? )
            // InternalXtextGrammarTestLanguage.g:1212:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (this_Cardinalities_2= ruleCardinalities[$current] )?
            {
            // InternalXtextGrammarTestLanguage.g:1212:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
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

                    if ( ((LA30_5>=34 && LA30_5<=35)||LA30_5==39) ) {
                        alt30=1;
                    }
                    else if ( (LA30_5==EOF||(LA30_5>=RULE_ID && LA30_5<=RULE_STRING)||(LA30_5>=15 && LA30_5<=16)||LA30_5==22||LA30_5==24||(LA30_5>=29 && LA30_5<=33)||(LA30_5>=40 && LA30_5<=41)) ) {
                        alt30=2;
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

                    if ( ((LA30_5>=34 && LA30_5<=35)||LA30_5==39) ) {
                        alt30=1;
                    }
                    else if ( (LA30_5==EOF||(LA30_5>=RULE_ID && LA30_5<=RULE_STRING)||(LA30_5>=15 && LA30_5<=16)||LA30_5==22||LA30_5==24||(LA30_5>=29 && LA30_5<=33)||(LA30_5>=40 && LA30_5<=41)) ) {
                        alt30=2;
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
                    // InternalXtextGrammarTestLanguage.g:1213:4: this_Assignment_0= ruleAssignment
                    {

                    				newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0());
                    			
                    pushFollow(FollowSets000.FOLLOW_30);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;


                    				current = this_Assignment_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1222:4: this_AbstractTerminal_1= ruleAbstractTerminal
                    {

                    				newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1());
                    			
                    pushFollow(FollowSets000.FOLLOW_30);
                    this_AbstractTerminal_1=ruleAbstractTerminal();

                    state._fsp--;


                    				current = this_AbstractTerminal_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalXtextGrammarTestLanguage.g:1231:3: (this_Cardinalities_2= ruleCardinalities[$current] )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==22||(LA31_0>=31 && LA31_0<=32)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1232:4: this_Cardinalities_2= ruleCardinalities[$current]
                    {

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                    				}
                    				newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalitiesParserRuleCall_1());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Cardinalities_2=ruleCardinalities(current);

                    state._fsp--;


                    				current = this_Cardinalities_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "ruleCardinalities"
    // InternalXtextGrammarTestLanguage.g:1249:1: ruleCardinalities[EObject in_current] returns [EObject current=in_current] : ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) ) ;
    public final EObject ruleCardinalities(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_cardinality_0_1=null;
        Token lv_cardinality_0_2=null;
        Token lv_cardinality_0_3=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1255:2: ( ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) ) )
            // InternalXtextGrammarTestLanguage.g:1256:2: ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:1256:2: ( ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) ) )
            // InternalXtextGrammarTestLanguage.g:1257:3: ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) )
            {
            // InternalXtextGrammarTestLanguage.g:1257:3: ( (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' ) )
            // InternalXtextGrammarTestLanguage.g:1258:4: (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' )
            {
            // InternalXtextGrammarTestLanguage.g:1258:4: (lv_cardinality_0_1= '?' | lv_cardinality_0_2= '*' | lv_cardinality_0_3= '+' )
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
                    // InternalXtextGrammarTestLanguage.g:1259:5: lv_cardinality_0_1= '?'
                    {
                    lv_cardinality_0_1=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_cardinality_0_1, grammarAccess.getCardinalitiesAccess().getCardinalityQuestionMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCardinalitiesRule());
                    					}
                    					setWithLastConsumed(current, "cardinality", lv_cardinality_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1270:5: lv_cardinality_0_2= '*'
                    {
                    lv_cardinality_0_2=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_cardinality_0_2, grammarAccess.getCardinalitiesAccess().getCardinalityAsteriskKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCardinalitiesRule());
                    					}
                    					setWithLastConsumed(current, "cardinality", lv_cardinality_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1281:5: lv_cardinality_0_3= '+'
                    {
                    lv_cardinality_0_3=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_cardinality_0_3, grammarAccess.getCardinalitiesAccess().getCardinalityPlusSignKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCardinalitiesRule());
                    					}
                    					setWithLastConsumed(current, "cardinality", lv_cardinality_0_3, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCardinalities"


    // $ANTLR start "entryRuleAction"
    // InternalXtextGrammarTestLanguage.g:1297:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1297:47: (iv_ruleAction= ruleAction EOF )
            // InternalXtextGrammarTestLanguage.g:1298:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalXtextGrammarTestLanguage.g:1304:1: ruleAction returns [EObject current=null] : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1310:2: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // InternalXtextGrammarTestLanguage.g:1311:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // InternalXtextGrammarTestLanguage.g:1311:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // InternalXtextGrammarTestLanguage.g:1312:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:1316:3: ( (lv_type_1_0= ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:1317:4: (lv_type_1_0= ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:1317:4: (lv_type_1_0= ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:1318:5: lv_type_1_0= ruleTypeRef
            {

            					newCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_31);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.TypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:1335:3: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==17) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1336:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getFullStopKeyword_2_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:1340:4: ( (lv_feature_3_0= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:1341:5: (lv_feature_3_0= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:1341:5: (lv_feature_3_0= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:1342:6: lv_feature_3_0= RULE_ID
                    {
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

                    						newLeafNode(lv_feature_3_0, grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"feature",
                    							lv_feature_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalXtextGrammarTestLanguage.g:1358:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // InternalXtextGrammarTestLanguage.g:1359:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1359:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // InternalXtextGrammarTestLanguage.g:1360:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1360:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
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
                            // InternalXtextGrammarTestLanguage.g:1361:7: lv_operator_4_1= '='
                            {
                            lv_operator_4_1=(Token)match(input,34,FollowSets000.FOLLOW_33); 

                            							newLeafNode(lv_operator_4_1, grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getActionRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_4_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalXtextGrammarTestLanguage.g:1372:7: lv_operator_4_2= '+='
                            {
                            lv_operator_4_2=(Token)match(input,35,FollowSets000.FOLLOW_33); 

                            							newLeafNode(lv_operator_4_2, grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getActionRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_4_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_34); 

                    				newLeafNode(otherlv_5, grammarAccess.getActionAccess().getCurrentKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // InternalXtextGrammarTestLanguage.g:1398:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1398:57: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:1399:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             newCompositeNode(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();

            state._fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // InternalXtextGrammarTestLanguage.g:1405:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;

        EObject this_PredicatedKeyword_3 = null;

        EObject this_PredicatedRuleCall_4 = null;

        EObject this_PredicatedGroup_5 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1411:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup ) )
            // InternalXtextGrammarTestLanguage.g:1412:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup )
            {
            // InternalXtextGrammarTestLanguage.g:1412:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup )
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
                    // InternalXtextGrammarTestLanguage.g:1413:3: this_Keyword_0= ruleKeyword
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1422:3: this_RuleCall_1= ruleRuleCall
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1431:3: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();

                    state._fsp--;


                    			current = this_ParenthesizedElement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:1440:3: this_PredicatedKeyword_3= rulePredicatedKeyword
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedKeyword_3=rulePredicatedKeyword();

                    state._fsp--;


                    			current = this_PredicatedKeyword_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalXtextGrammarTestLanguage.g:1449:3: this_PredicatedRuleCall_4= rulePredicatedRuleCall
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedRuleCall_4=rulePredicatedRuleCall();

                    state._fsp--;


                    			current = this_PredicatedRuleCall_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalXtextGrammarTestLanguage.g:1458:3: this_PredicatedGroup_5= rulePredicatedGroup
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedGroup_5=rulePredicatedGroup();

                    state._fsp--;


                    			current = this_PredicatedGroup_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // InternalXtextGrammarTestLanguage.g:1470:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1470:48: (iv_ruleKeyword= ruleKeyword EOF )
            // InternalXtextGrammarTestLanguage.g:1471:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // InternalXtextGrammarTestLanguage.g:1477:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1483:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:1484:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalXtextGrammarTestLanguage.g:1484:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:1485:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:1485:3: (lv_value_0_0= RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:1486:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getKeywordRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // InternalXtextGrammarTestLanguage.g:1505:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1505:49: (iv_ruleRuleCall= ruleRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:1506:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             newCompositeNode(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // InternalXtextGrammarTestLanguage.g:1512:1: ruleRuleCall returns [EObject current=null] : ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1518:2: ( ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? ) )
            // InternalXtextGrammarTestLanguage.g:1519:2: ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? )
            {
            // InternalXtextGrammarTestLanguage.g:1519:2: ( () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )? )
            // InternalXtextGrammarTestLanguage.g:1520:3: () ( ( ruleRuleID ) ) (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )?
            {
            // InternalXtextGrammarTestLanguage.g:1520:3: ()
            // InternalXtextGrammarTestLanguage.g:1521:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRuleCallAccess().getRuleCallAction_0(),
            					current);
            			

            }

            // InternalXtextGrammarTestLanguage.g:1527:3: ( ( ruleRuleID ) )
            // InternalXtextGrammarTestLanguage.g:1528:4: ( ruleRuleID )
            {
            // InternalXtextGrammarTestLanguage.g:1528:4: ( ruleRuleID )
            // InternalXtextGrammarTestLanguage.g:1529:5: ruleRuleID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleCallRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_20);
            ruleRuleID();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:1543:3: (otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1544:4: otherlv_2= '[' ( (lv_arguments_3_0= ruleNamedArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_35); 

                    				newLeafNode(otherlv_2, grammarAccess.getRuleCallAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:1548:4: ( (lv_arguments_3_0= ruleNamedArgument ) )
                    // InternalXtextGrammarTestLanguage.g:1549:5: (lv_arguments_3_0= ruleNamedArgument )
                    {
                    // InternalXtextGrammarTestLanguage.g:1549:5: (lv_arguments_3_0= ruleNamedArgument )
                    // InternalXtextGrammarTestLanguage.g:1550:6: lv_arguments_3_0= ruleNamedArgument
                    {

                    						newCompositeNode(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_22);
                    lv_arguments_3_0=ruleNamedArgument();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRuleCallRule());
                    						}
                    						add(
                    							current,
                    							"arguments",
                    							lv_arguments_3_0,
                    							"org.eclipse.xtext.XtextGrammarTestLanguage.NamedArgument");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXtextGrammarTestLanguage.g:1567:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==13) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalXtextGrammarTestLanguage.g:1568:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleNamedArgument ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_35); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRuleCallAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:1572:5: ( (lv_arguments_5_0= ruleNamedArgument ) )
                    	    // InternalXtextGrammarTestLanguage.g:1573:6: (lv_arguments_5_0= ruleNamedArgument )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:1573:6: (lv_arguments_5_0= ruleNamedArgument )
                    	    // InternalXtextGrammarTestLanguage.g:1574:7: lv_arguments_5_0= ruleNamedArgument
                    	    {

                    	    							newCompositeNode(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_arguments_5_0=ruleNamedArgument();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRuleCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"arguments",
                    	    								lv_arguments_5_0,
                    	    								"org.eclipse.xtext.XtextGrammarTestLanguage.NamedArgument");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getRuleCallAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalXtextGrammarTestLanguage.g:1601:1: entryRuleLiteralValue returns [String current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final String entryRuleLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralValue = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1601:52: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalXtextGrammarTestLanguage.g:1602:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             newCompositeNode(grammarAccess.getLiteralValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // InternalXtextGrammarTestLanguage.g:1608:1: ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1614:2: ( (kw= '!' | kw= '+' ) )
            // InternalXtextGrammarTestLanguage.g:1615:2: (kw= '!' | kw= '+' )
            {
            // InternalXtextGrammarTestLanguage.g:1615:2: (kw= '!' | kw= '+' )
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
                    // InternalXtextGrammarTestLanguage.g:1616:3: kw= '!'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLiteralValueAccess().getExclamationMarkKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1622:3: kw= '+'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLiteralValueAccess().getPlusSignKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleInverseLiteralValue"
    // InternalXtextGrammarTestLanguage.g:1631:1: entryRuleInverseLiteralValue returns [String current=null] : iv_ruleInverseLiteralValue= ruleInverseLiteralValue EOF ;
    public final String entryRuleInverseLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInverseLiteralValue = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1631:59: (iv_ruleInverseLiteralValue= ruleInverseLiteralValue EOF )
            // InternalXtextGrammarTestLanguage.g:1632:2: iv_ruleInverseLiteralValue= ruleInverseLiteralValue EOF
            {
             newCompositeNode(grammarAccess.getInverseLiteralValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInverseLiteralValue=ruleInverseLiteralValue();

            state._fsp--;

             current =iv_ruleInverseLiteralValue.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInverseLiteralValue"


    // $ANTLR start "ruleInverseLiteralValue"
    // InternalXtextGrammarTestLanguage.g:1638:1: ruleInverseLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_LiteralValue_0= ruleLiteralValue ;
    public final AntlrDatatypeRuleToken ruleInverseLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_LiteralValue_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1644:2: (this_LiteralValue_0= ruleLiteralValue )
            // InternalXtextGrammarTestLanguage.g:1645:2: this_LiteralValue_0= ruleLiteralValue
            {

            		newCompositeNode(grammarAccess.getInverseLiteralValueAccess().getLiteralValueParserRuleCall());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            this_LiteralValue_0=ruleLiteralValue();

            state._fsp--;


            		current.merge(this_LiteralValue_0);
            	

            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInverseLiteralValue"


    // $ANTLR start "entryRuleNamedArgument"
    // InternalXtextGrammarTestLanguage.g:1658:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1658:54: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // InternalXtextGrammarTestLanguage.g:1659:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
             newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;

             current =iv_ruleNamedArgument; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // InternalXtextGrammarTestLanguage.g:1665:1: ruleNamedArgument returns [EObject current=null] : ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_literalValue_1_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1671:2: ( ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) ) )
            // InternalXtextGrammarTestLanguage.g:1672:2: ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:1672:2: ( () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) ) )
            // InternalXtextGrammarTestLanguage.g:1673:3: () ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:1673:3: ()
            // InternalXtextGrammarTestLanguage.g:1674:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNamedArgumentAccess().getNamedArgumentAction_0(),
            					current);
            			

            }

            // InternalXtextGrammarTestLanguage.g:1680:3: ( ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) ) )
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
                    // InternalXtextGrammarTestLanguage.g:1681:4: ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1681:4: ( ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) ) )
                    // InternalXtextGrammarTestLanguage.g:1682:5: ( (lv_literalValue_1_0= ruleLiteralValue ) )? ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1682:5: ( (lv_literalValue_1_0= ruleLiteralValue ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==32||LA39_0==38) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalXtextGrammarTestLanguage.g:1683:6: (lv_literalValue_1_0= ruleLiteralValue )
                            {
                            // InternalXtextGrammarTestLanguage.g:1683:6: (lv_literalValue_1_0= ruleLiteralValue )
                            // InternalXtextGrammarTestLanguage.g:1684:7: lv_literalValue_1_0= ruleLiteralValue
                            {

                            							newCompositeNode(grammarAccess.getNamedArgumentAccess().getLiteralValueLiteralValueParserRuleCall_1_0_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_3);
                            lv_literalValue_1_0=ruleLiteralValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getNamedArgumentRule());
                            							}
                            							set(
                            								current,
                            								"literalValue",
                            								lv_literalValue_1_0,
                            								"org.eclipse.xtext.XtextGrammarTestLanguage.LiteralValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }
                            break;

                    }

                    // InternalXtextGrammarTestLanguage.g:1701:5: ( (otherlv_2= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:1702:6: (otherlv_2= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:1702:6: (otherlv_2= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:1703:7: otherlv_2= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getNamedArgumentRule());
                    							}
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(otherlv_2, grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_1_0_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1716:4: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1716:4: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) ) )
                    // InternalXtextGrammarTestLanguage.g:1717:5: ( (otherlv_3= RULE_ID ) ) otherlv_4= '=' ( (otherlv_5= RULE_ID ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1717:5: ( (otherlv_3= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:1718:6: (otherlv_3= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:1718:6: (otherlv_3= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:1719:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getNamedArgumentRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_36); 

                    							newLeafNode(otherlv_3, grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_1_1_0_0());
                    						

                    }


                    }

                    otherlv_4=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_4, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_1_1_1());
                    				
                    // InternalXtextGrammarTestLanguage.g:1734:5: ( (otherlv_5= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:1735:6: (otherlv_5= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:1735:6: (otherlv_5= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:1736:7: otherlv_5= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getNamedArgumentRule());
                    							}
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(otherlv_5, grammarAccess.getNamedArgumentAccess().getValueParameterCrossReference_1_1_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // InternalXtextGrammarTestLanguage.g:1753:1: entryRuleTerminalRuleCall returns [EObject current=null] : iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF ;
    public final EObject entryRuleTerminalRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRuleCall = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1753:57: (iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:1754:2: iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF
            {
             newCompositeNode(grammarAccess.getTerminalRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRuleCall=ruleTerminalRuleCall();

            state._fsp--;

             current =iv_ruleTerminalRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalRuleCall"


    // $ANTLR start "ruleTerminalRuleCall"
    // InternalXtextGrammarTestLanguage.g:1760:1: ruleTerminalRuleCall returns [EObject current=null] : ( ( ruleRuleID ) ) ;
    public final EObject ruleTerminalRuleCall() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1766:2: ( ( ( ruleRuleID ) ) )
            // InternalXtextGrammarTestLanguage.g:1767:2: ( ( ruleRuleID ) )
            {
            // InternalXtextGrammarTestLanguage.g:1767:2: ( ( ruleRuleID ) )
            // InternalXtextGrammarTestLanguage.g:1768:3: ( ruleRuleID )
            {
            // InternalXtextGrammarTestLanguage.g:1768:3: ( ruleRuleID )
            // InternalXtextGrammarTestLanguage.g:1769:4: ruleRuleID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTerminalRuleCallRule());
            				}
            			

            				newCompositeNode(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalRuleCall"


    // $ANTLR start "entryRuleRuleID"
    // InternalXtextGrammarTestLanguage.g:1786:1: entryRuleRuleID returns [String current=null] : iv_ruleRuleID= ruleRuleID EOF ;
    public final String entryRuleRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRuleID = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1786:46: (iv_ruleRuleID= ruleRuleID EOF )
            // InternalXtextGrammarTestLanguage.g:1787:2: iv_ruleRuleID= ruleRuleID EOF
            {
             newCompositeNode(grammarAccess.getRuleIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleID=ruleRuleID();

            state._fsp--;

             current =iv_ruleRuleID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleID"


    // $ANTLR start "ruleRuleID"
    // InternalXtextGrammarTestLanguage.g:1793:1: ruleRuleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleRuleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1799:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) )
            // InternalXtextGrammarTestLanguage.g:1800:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            {
            // InternalXtextGrammarTestLanguage.g:1800:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            // InternalXtextGrammarTestLanguage.g:1801:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getRuleIDAccess().getIDTerminalRuleCall_0());
            		
            // InternalXtextGrammarTestLanguage.g:1808:3: (kw= '::' this_ID_2= RULE_ID )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==28) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1809:4: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,28,FollowSets000.FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getRuleIDAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleID"


    // $ANTLR start "entryRulePredicatedKeyword"
    // InternalXtextGrammarTestLanguage.g:1826:1: entryRulePredicatedKeyword returns [EObject current=null] : iv_rulePredicatedKeyword= rulePredicatedKeyword EOF ;
    public final EObject entryRulePredicatedKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicatedKeyword = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1826:58: (iv_rulePredicatedKeyword= rulePredicatedKeyword EOF )
            // InternalXtextGrammarTestLanguage.g:1827:2: iv_rulePredicatedKeyword= rulePredicatedKeyword EOF
            {
             newCompositeNode(grammarAccess.getPredicatedKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedKeyword=rulePredicatedKeyword();

            state._fsp--;

             current =iv_rulePredicatedKeyword; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicatedKeyword"


    // $ANTLR start "rulePredicatedKeyword"
    // InternalXtextGrammarTestLanguage.g:1833:1: rulePredicatedKeyword returns [EObject current=null] : (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject rulePredicatedKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject this_Predicate_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1839:2: ( (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalXtextGrammarTestLanguage.g:1840:2: (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:1840:2: (this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:1841:3: this_Predicate_0= rulePredicate[$current] ( (lv_value_1_0= RULE_STRING ) )
            {

            			if (current==null) {
            				current = createModelElement(grammarAccess.getPredicatedKeywordRule());
            			}
            			newCompositeNode(grammarAccess.getPredicatedKeywordAccess().getPredicateParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_11);
            this_Predicate_0=rulePredicate(current);

            state._fsp--;


            			current = this_Predicate_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:1852:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:1853:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:1853:4: (lv_value_1_0= RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:1854:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPredicatedKeywordRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicatedKeyword"


    // $ANTLR start "entryRulePredicatedRuleCall"
    // InternalXtextGrammarTestLanguage.g:1874:1: entryRulePredicatedRuleCall returns [EObject current=null] : iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF ;
    public final EObject entryRulePredicatedRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicatedRuleCall = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1874:59: (iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:1875:2: iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF
            {
             newCompositeNode(grammarAccess.getPredicatedRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedRuleCall=rulePredicatedRuleCall();

            state._fsp--;

             current =iv_rulePredicatedRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicatedRuleCall"


    // $ANTLR start "rulePredicatedRuleCall"
    // InternalXtextGrammarTestLanguage.g:1881:1: rulePredicatedRuleCall returns [EObject current=null] : (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject rulePredicatedRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_Predicate_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1887:2: ( (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) ) )
            // InternalXtextGrammarTestLanguage.g:1888:2: (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:1888:2: (this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:1889:3: this_Predicate_0= rulePredicate[$current] ( (otherlv_1= RULE_ID ) )
            {

            			if (current==null) {
            				current = createModelElement(grammarAccess.getPredicatedRuleCallRule());
            			}
            			newCompositeNode(grammarAccess.getPredicatedRuleCallAccess().getPredicateParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Predicate_0=rulePredicate(current);

            state._fsp--;


            			current = this_Predicate_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:1900:3: ( (otherlv_1= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:1901:4: (otherlv_1= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:1901:4: (otherlv_1= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:1902:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPredicatedRuleCallRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // InternalXtextGrammarTestLanguage.g:1917:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalXtextGrammarTestLanguage.g:1917:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalXtextGrammarTestLanguage.g:1918:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalXtextGrammarTestLanguage.g:1924:1: ruleAssignment returns [EObject current=null] : ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_1_0=null;
        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_Predicate_0 = null;

        EObject lv_terminal_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:1930:2: ( ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) ) )
            // InternalXtextGrammarTestLanguage.g:1931:2: ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:1931:2: ( (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) ) )
            // InternalXtextGrammarTestLanguage.g:1932:3: (this_Predicate_0= rulePredicate[$current] )? ( (lv_feature_1_0= RULE_ID ) ) ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) ) ( (lv_terminal_3_0= ruleAssignableTerminal ) )
            {
            // InternalXtextGrammarTestLanguage.g:1932:3: (this_Predicate_0= rulePredicate[$current] )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=40 && LA42_0<=41)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1933:4: this_Predicate_0= rulePredicate[$current]
                    {

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getAssignmentRule());
                    				}
                    				newCompositeNode(grammarAccess.getAssignmentAccess().getPredicateParserRuleCall_0());
                    			
                    pushFollow(FollowSets000.FOLLOW_3);
                    this_Predicate_0=rulePredicate(current);

                    state._fsp--;


                    				current = this_Predicate_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalXtextGrammarTestLanguage.g:1945:3: ( (lv_feature_1_0= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:1946:4: (lv_feature_1_0= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:1946:4: (lv_feature_1_0= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:1947:5: lv_feature_1_0= RULE_ID
            {
            lv_feature_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_38); 

            					newLeafNode(lv_feature_1_0, grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"feature",
            						lv_feature_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:1963:3: ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) ) )
            // InternalXtextGrammarTestLanguage.g:1964:4: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) )
            {
            // InternalXtextGrammarTestLanguage.g:1964:4: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' ) )
            // InternalXtextGrammarTestLanguage.g:1965:5: (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' )
            {
            // InternalXtextGrammarTestLanguage.g:1965:5: (lv_operator_2_1= '+=' | lv_operator_2_2= '=' | lv_operator_2_3= '?=' )
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
                    // InternalXtextGrammarTestLanguage.g:1966:6: lv_operator_2_1= '+='
                    {
                    lv_operator_2_1=(Token)match(input,35,FollowSets000.FOLLOW_39); 

                    						newLeafNode(lv_operator_2_1, grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1977:6: lv_operator_2_2= '='
                    {
                    lv_operator_2_2=(Token)match(input,34,FollowSets000.FOLLOW_39); 

                    						newLeafNode(lv_operator_2_2, grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1988:6: lv_operator_2_3= '?='
                    {
                    lv_operator_2_3=(Token)match(input,39,FollowSets000.FOLLOW_39); 

                    						newLeafNode(lv_operator_2_3, grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalXtextGrammarTestLanguage.g:2001:3: ( (lv_terminal_3_0= ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:2002:4: (lv_terminal_3_0= ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:2002:4: (lv_terminal_3_0= ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:2003:5: lv_terminal_3_0= ruleAssignableTerminal
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_3_0=ruleAssignableTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"terminal",
            						lv_terminal_3_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.AssignableTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "rulePredicate"
    // InternalXtextGrammarTestLanguage.g:2025:1: rulePredicate[EObject in_current] returns [EObject current=in_current] : ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ;
    public final EObject rulePredicate(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2031:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) )
            // InternalXtextGrammarTestLanguage.g:2032:2: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:2032:2: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
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
                    // InternalXtextGrammarTestLanguage.g:2033:3: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:2033:3: ( (lv_predicated_0_0= '=>' ) )
                    // InternalXtextGrammarTestLanguage.g:2034:4: (lv_predicated_0_0= '=>' )
                    {
                    // InternalXtextGrammarTestLanguage.g:2034:4: (lv_predicated_0_0= '=>' )
                    // InternalXtextGrammarTestLanguage.g:2035:5: lv_predicated_0_0= '=>'
                    {
                    lv_predicated_0_0=(Token)match(input,40,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_predicated_0_0, grammarAccess.getPredicateAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPredicateRule());
                    					}
                    					setWithLastConsumed(current, "predicated", lv_predicated_0_0 != null, "=>");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:2048:3: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:2048:3: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // InternalXtextGrammarTestLanguage.g:2049:4: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // InternalXtextGrammarTestLanguage.g:2049:4: (lv_firstSetPredicated_1_0= '->' )
                    // InternalXtextGrammarTestLanguage.g:2050:5: lv_firstSetPredicated_1_0= '->'
                    {
                    lv_firstSetPredicated_1_0=(Token)match(input,41,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_firstSetPredicated_1_0, grammarAccess.getPredicateAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPredicateRule());
                    					}
                    					setWithLastConsumed(current, "firstSetPredicated", lv_firstSetPredicated_1_0 != null, "->");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleAssignableTerminal"
    // InternalXtextGrammarTestLanguage.g:2066:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2066:59: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:2067:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             newCompositeNode(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();

            state._fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // InternalXtextGrammarTestLanguage.g:2073:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2079:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // InternalXtextGrammarTestLanguage.g:2080:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // InternalXtextGrammarTestLanguage.g:2080:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    // InternalXtextGrammarTestLanguage.g:2081:3: this_Keyword_0= ruleKeyword
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:2090:3: this_RuleCall_1= ruleRuleCall
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:2099:3: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();

                    state._fsp--;


                    			current = this_ParenthesizedAssignableElement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:2108:3: this_CrossReference_3= ruleCrossReference
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CrossReference_3=ruleCrossReference();

                    state._fsp--;


                    			current = this_CrossReference_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // InternalXtextGrammarTestLanguage.g:2120:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2120:71: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // InternalXtextGrammarTestLanguage.g:2121:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();

            state._fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // InternalXtextGrammarTestLanguage.g:2127:1: ruleParenthesizedAssignableElement returns [EObject current=null] : (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AssignableAlternatives_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2133:2: ( (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) )
            // InternalXtextGrammarTestLanguage.g:2134:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            {
            // InternalXtextGrammarTestLanguage.g:2134:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            // InternalXtextGrammarTestLanguage.g:2135:3: otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_39); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_40);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();

            state._fsp--;


            			current = this_AssignableAlternatives_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // InternalXtextGrammarTestLanguage.g:2155:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2155:63: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:2156:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();

            state._fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // InternalXtextGrammarTestLanguage.g:2162:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AssignableTerminal_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2168:2: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // InternalXtextGrammarTestLanguage.g:2169:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // InternalXtextGrammarTestLanguage.g:2169:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // InternalXtextGrammarTestLanguage.g:2170:3: this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_AssignableTerminal_0=ruleAssignableTerminal();

            state._fsp--;


            			current = this_AssignableTerminal_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:2178:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==29) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2179:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // InternalXtextGrammarTestLanguage.g:2179:4: ()
                    // InternalXtextGrammarTestLanguage.g:2180:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtextGrammarTestLanguage.g:2186:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
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
                    	    // InternalXtextGrammarTestLanguage.g:2187:5: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_39); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:2191:5: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // InternalXtextGrammarTestLanguage.g:2192:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:2192:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // InternalXtextGrammarTestLanguage.g:2193:7: lv_elements_3_0= ruleAssignableTerminal
                    	    {

                    	    							newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleAssignableTerminal();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAssignableAlternativesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.XtextGrammarTestLanguage.AssignableTerminal");
                    	    							afterParserOrEnumRuleCall();
                    	    						

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // InternalXtextGrammarTestLanguage.g:2216:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2216:55: (iv_ruleCrossReference= ruleCrossReference EOF )
            // InternalXtextGrammarTestLanguage.g:2217:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossReference=ruleCrossReference();

            state._fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // InternalXtextGrammarTestLanguage.g:2223:1: ruleCrossReference returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_terminal_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2229:2: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // InternalXtextGrammarTestLanguage.g:2230:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // InternalXtextGrammarTestLanguage.g:2230:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // InternalXtextGrammarTestLanguage.g:2231:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:2235:3: ( (lv_type_1_0= ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:2236:4: (lv_type_1_0= ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:2236:4: (lv_type_1_0= ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:2237:5: lv_type_1_0= ruleTypeRef
            {

            					newCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_41);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCrossReferenceRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.TypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:2254:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==29) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2255:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_42); 

                    				newLeafNode(otherlv_2, grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:2259:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // InternalXtextGrammarTestLanguage.g:2260:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // InternalXtextGrammarTestLanguage.g:2260:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // InternalXtextGrammarTestLanguage.g:2261:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						newCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_26);
                    lv_terminal_3_0=ruleCrossReferenceableTerminal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCrossReferenceRule());
                    						}
                    						set(
                    							current,
                    							"terminal",
                    							lv_terminal_3_0,
                    							"org.eclipse.xtext.XtextGrammarTestLanguage.CrossReferenceableTerminal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // InternalXtextGrammarTestLanguage.g:2287:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2287:67: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:2288:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();

            state._fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // InternalXtextGrammarTestLanguage.g:2294:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2300:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) )
            // InternalXtextGrammarTestLanguage.g:2301:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            {
            // InternalXtextGrammarTestLanguage.g:2301:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
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
                    // InternalXtextGrammarTestLanguage.g:2302:3: this_Keyword_0= ruleKeyword
                    {

                    			newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:2311:3: this_RuleCall_1= ruleRuleCall
                    {

                    			newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // InternalXtextGrammarTestLanguage.g:2323:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2323:61: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // InternalXtextGrammarTestLanguage.g:2324:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();

            state._fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // InternalXtextGrammarTestLanguage.g:2330:1: ruleParenthesizedElement returns [EObject current=null] : (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Alternatives_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2336:2: ( (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // InternalXtextGrammarTestLanguage.g:2337:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // InternalXtextGrammarTestLanguage.g:2337:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // InternalXtextGrammarTestLanguage.g:2338:3: otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_40);
            this_Alternatives_1=ruleAlternatives();

            state._fsp--;


            			current = this_Alternatives_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRulePredicatedGroup"
    // InternalXtextGrammarTestLanguage.g:2358:1: entryRulePredicatedGroup returns [EObject current=null] : iv_rulePredicatedGroup= rulePredicatedGroup EOF ;
    public final EObject entryRulePredicatedGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicatedGroup = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2358:56: (iv_rulePredicatedGroup= rulePredicatedGroup EOF )
            // InternalXtextGrammarTestLanguage.g:2359:2: iv_rulePredicatedGroup= rulePredicatedGroup EOF
            {
             newCompositeNode(grammarAccess.getPredicatedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedGroup=rulePredicatedGroup();

            state._fsp--;

             current =iv_rulePredicatedGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicatedGroup"


    // $ANTLR start "rulePredicatedGroup"
    // InternalXtextGrammarTestLanguage.g:2365:1: rulePredicatedGroup returns [EObject current=null] : (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' ) ;
    public final EObject rulePredicatedGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_Predicate_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2371:2: ( (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' ) )
            // InternalXtextGrammarTestLanguage.g:2372:2: (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' )
            {
            // InternalXtextGrammarTestLanguage.g:2372:2: (this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')' )
            // InternalXtextGrammarTestLanguage.g:2373:3: this_Predicate_0= rulePredicate[$current] otherlv_1= '(' ( (lv_elements_2_0= ruleAlternatives ) ) otherlv_3= ')'
            {

            			if (current==null) {
            				current = createModelElement(grammarAccess.getPredicatedGroupRule());
            			}
            			newCompositeNode(grammarAccess.getPredicatedGroupAccess().getPredicateParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_Predicate_0=rulePredicate(current);

            state._fsp--;


            			current = this_Predicate_0;
            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1());
            		
            // InternalXtextGrammarTestLanguage.g:2388:3: ( (lv_elements_2_0= ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:2389:4: (lv_elements_2_0= ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:2389:4: (lv_elements_2_0= ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:2390:5: lv_elements_2_0= ruleAlternatives
            {

            					newCompositeNode(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0());
            				
            pushFollow(FollowSets000.FOLLOW_40);
            lv_elements_2_0=ruleAlternatives();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPredicatedGroupRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_2_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.Alternatives");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // InternalXtextGrammarTestLanguage.g:2415:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2415:53: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // InternalXtextGrammarTestLanguage.g:2416:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             newCompositeNode(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // InternalXtextGrammarTestLanguage.g:2422:1: ruleTerminalRule returns [EObject current=null] : (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fragment_1_0=null;
        Token lv_name_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject this_ReturnsClause_4 = null;

        EObject lv_alternatives_6_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2428:2: ( (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' ) )
            // InternalXtextGrammarTestLanguage.g:2429:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' )
            {
            // InternalXtextGrammarTestLanguage.g:2429:2: (otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';' )
            // InternalXtextGrammarTestLanguage.g:2430:3: otherlv_0= 'terminal' ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) ) otherlv_5= ':' ( (lv_alternatives_6_0= ruleTerminalAlternatives ) ) otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:2434:3: ( ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? ) )
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
                    // InternalXtextGrammarTestLanguage.g:2435:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:2435:4: ( ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) ) )
                    // InternalXtextGrammarTestLanguage.g:2436:5: ( (lv_fragment_1_0= 'fragment' ) ) ( (lv_name_2_0= RULE_ID ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:2436:5: ( (lv_fragment_1_0= 'fragment' ) )
                    // InternalXtextGrammarTestLanguage.g:2437:6: (lv_fragment_1_0= 'fragment' )
                    {
                    // InternalXtextGrammarTestLanguage.g:2437:6: (lv_fragment_1_0= 'fragment' )
                    // InternalXtextGrammarTestLanguage.g:2438:7: lv_fragment_1_0= 'fragment'
                    {
                    lv_fragment_1_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    							newLeafNode(lv_fragment_1_0, grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTerminalRuleRule());
                    							}
                    							setWithLastConsumed(current, "fragment", lv_fragment_1_0 != null, "fragment");
                    						

                    }


                    }

                    // InternalXtextGrammarTestLanguage.g:2450:5: ( (lv_name_2_0= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:2451:6: (lv_name_2_0= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:2451:6: (lv_name_2_0= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:2452:7: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    							newLeafNode(lv_name_2_0, grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTerminalRuleRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"name",
                    								lv_name_2_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:2470:4: ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? )
                    {
                    // InternalXtextGrammarTestLanguage.g:2470:4: ( ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )? )
                    // InternalXtextGrammarTestLanguage.g:2471:5: ( (lv_name_3_0= RULE_ID ) ) (this_ReturnsClause_4= ruleReturnsClause[$current] )?
                    {
                    // InternalXtextGrammarTestLanguage.g:2471:5: ( (lv_name_3_0= RULE_ID ) )
                    // InternalXtextGrammarTestLanguage.g:2472:6: (lv_name_3_0= RULE_ID )
                    {
                    // InternalXtextGrammarTestLanguage.g:2472:6: (lv_name_3_0= RULE_ID )
                    // InternalXtextGrammarTestLanguage.g:2473:7: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

                    							newLeafNode(lv_name_3_0, grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTerminalRuleRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"name",
                    								lv_name_3_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }

                    // InternalXtextGrammarTestLanguage.g:2489:5: (this_ReturnsClause_4= ruleReturnsClause[$current] )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==27) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalXtextGrammarTestLanguage.g:2490:6: this_ReturnsClause_4= ruleReturnsClause[$current]
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTerminalRuleRule());
                            						}
                            						newCompositeNode(grammarAccess.getTerminalRuleAccess().getReturnsClauseParserRuleCall_1_1_1());
                            					
                            pushFollow(FollowSets000.FOLLOW_17);
                            this_ReturnsClause_4=ruleReturnsClause(current);

                            state._fsp--;


                            						current = this_ReturnsClause_4;
                            						afterParserOrEnumRuleCall();
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_44); 

            			newLeafNode(otherlv_5, grammarAccess.getTerminalRuleAccess().getColonKeyword_2());
            		
            // InternalXtextGrammarTestLanguage.g:2508:3: ( (lv_alternatives_6_0= ruleTerminalAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:2509:4: (lv_alternatives_6_0= ruleTerminalAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:2509:4: (lv_alternatives_6_0= ruleTerminalAlternatives )
            // InternalXtextGrammarTestLanguage.g:2510:5: lv_alternatives_6_0= ruleTerminalAlternatives
            {

            					newCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_19);
            lv_alternatives_6_0=ruleTerminalAlternatives();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
            					}
            					set(
            						current,
            						"alternatives",
            						lv_alternatives_6_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.TerminalAlternatives");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // InternalXtextGrammarTestLanguage.g:2535:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2535:61: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:2536:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             newCompositeNode(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();

            state._fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // InternalXtextGrammarTestLanguage.g:2542:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalGroup_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2548:2: ( (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // InternalXtextGrammarTestLanguage.g:2549:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // InternalXtextGrammarTestLanguage.g:2549:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // InternalXtextGrammarTestLanguage.g:2550:3: this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_TerminalGroup_0=ruleTerminalGroup();

            state._fsp--;


            			current = this_TerminalGroup_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:2558:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==29) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2559:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // InternalXtextGrammarTestLanguage.g:2559:4: ()
                    // InternalXtextGrammarTestLanguage.g:2560:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtextGrammarTestLanguage.g:2566:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
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
                    	    // InternalXtextGrammarTestLanguage.g:2567:5: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_44); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:2571:5: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // InternalXtextGrammarTestLanguage.g:2572:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:2572:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    // InternalXtextGrammarTestLanguage.g:2573:7: lv_elements_3_0= ruleTerminalGroup
                    	    {

                    	    							newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleTerminalGroup();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTerminalAlternativesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.XtextGrammarTestLanguage.TerminalGroup");
                    	    							afterParserOrEnumRuleCall();
                    	    						

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // InternalXtextGrammarTestLanguage.g:2596:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2596:54: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // InternalXtextGrammarTestLanguage.g:2597:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             newCompositeNode(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalGroup=ruleTerminalGroup();

            state._fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // InternalXtextGrammarTestLanguage.g:2603:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2609:2: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // InternalXtextGrammarTestLanguage.g:2610:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // InternalXtextGrammarTestLanguage.g:2610:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // InternalXtextGrammarTestLanguage.g:2611:3: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {

            			newCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_45);
            this_TerminalToken_0=ruleTerminalToken();

            state._fsp--;


            			current = this_TerminalToken_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:2619:3: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_STRING)||LA55_0==15||LA55_0==17||LA55_0==38||LA55_0==41||LA55_0==43) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2620:4: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // InternalXtextGrammarTestLanguage.g:2620:4: ()
                    // InternalXtextGrammarTestLanguage.g:2621:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtextGrammarTestLanguage.g:2627:4: ( (lv_elements_2_0= ruleTerminalToken ) )+
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
                    	    // InternalXtextGrammarTestLanguage.g:2628:5: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:2628:5: (lv_elements_2_0= ruleTerminalToken )
                    	    // InternalXtextGrammarTestLanguage.g:2629:6: lv_elements_2_0= ruleTerminalToken
                    	    {

                    	    						newCompositeNode(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_45);
                    	    lv_elements_2_0=ruleTerminalToken();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTerminalGroupRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_2_0,
                    	    							"org.eclipse.xtext.XtextGrammarTestLanguage.TerminalToken");
                    	    						afterParserOrEnumRuleCall();
                    	    					

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // InternalXtextGrammarTestLanguage.g:2651:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2651:54: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // InternalXtextGrammarTestLanguage.g:2652:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalToken=ruleTerminalToken();

            state._fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // InternalXtextGrammarTestLanguage.g:2658:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalTokenElement_0 = null;

        EObject this_Cardinalities_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2664:2: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? ) )
            // InternalXtextGrammarTestLanguage.g:2665:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? )
            {
            // InternalXtextGrammarTestLanguage.g:2665:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )? )
            // InternalXtextGrammarTestLanguage.g:2666:3: this_TerminalTokenElement_0= ruleTerminalTokenElement (this_Cardinalities_1= ruleCardinalities[$current] )?
            {

            			newCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_30);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();

            state._fsp--;


            			current = this_TerminalTokenElement_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:2674:3: (this_Cardinalities_1= ruleCardinalities[$current] )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==22||(LA56_0>=31 && LA56_0<=32)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2675:4: this_Cardinalities_1= ruleCardinalities[$current]
                    {

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getTerminalTokenRule());
                    				}
                    				newCompositeNode(grammarAccess.getTerminalTokenAccess().getCardinalitiesParserRuleCall_1());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Cardinalities_1=ruleCardinalities(current);

                    state._fsp--;


                    				current = this_Cardinalities_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // InternalXtextGrammarTestLanguage.g:2691:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2691:61: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // InternalXtextGrammarTestLanguage.g:2692:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();

            state._fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // InternalXtextGrammarTestLanguage.g:2698:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_TerminalRuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;

        EObject this_EOF_5 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2704:2: ( (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF ) )
            // InternalXtextGrammarTestLanguage.g:2705:2: (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF )
            {
            // InternalXtextGrammarTestLanguage.g:2705:2: (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF )
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
                    // InternalXtextGrammarTestLanguage.g:2706:3: this_CharacterRange_0= ruleCharacterRange
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CharacterRange_0=ruleCharacterRange();

                    state._fsp--;


                    			current = this_CharacterRange_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:2715:3: this_TerminalRuleCall_1= ruleTerminalRuleCall
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TerminalRuleCall_1=ruleTerminalRuleCall();

                    state._fsp--;


                    			current = this_TerminalRuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:2724:3: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();

                    state._fsp--;


                    			current = this_ParenthesizedTerminalElement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:2733:3: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();

                    state._fsp--;


                    			current = this_AbstractNegatedToken_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalXtextGrammarTestLanguage.g:2742:3: this_Wildcard_4= ruleWildcard
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Wildcard_4=ruleWildcard();

                    state._fsp--;


                    			current = this_Wildcard_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalXtextGrammarTestLanguage.g:2751:3: this_EOF_5= ruleEOF
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EOF_5=ruleEOF();

                    state._fsp--;


                    			current = this_EOF_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // InternalXtextGrammarTestLanguage.g:2763:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2763:69: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // InternalXtextGrammarTestLanguage.g:2764:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();

            state._fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // InternalXtextGrammarTestLanguage.g:2770:1: ruleParenthesizedTerminalElement returns [EObject current=null] : (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_TerminalAlternatives_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2776:2: ( (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) )
            // InternalXtextGrammarTestLanguage.g:2777:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            {
            // InternalXtextGrammarTestLanguage.g:2777:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            // InternalXtextGrammarTestLanguage.g:2778:3: otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_40);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();

            state._fsp--;


            			current = this_TerminalAlternatives_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // InternalXtextGrammarTestLanguage.g:2798:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2798:61: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:2799:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();

            state._fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // InternalXtextGrammarTestLanguage.g:2805:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2811:2: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // InternalXtextGrammarTestLanguage.g:2812:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // InternalXtextGrammarTestLanguage.g:2812:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
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
                    // InternalXtextGrammarTestLanguage.g:2813:3: this_NegatedToken_0= ruleNegatedToken
                    {

                    			newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NegatedToken_0=ruleNegatedToken();

                    state._fsp--;


                    			current = this_NegatedToken_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:2822:3: this_UntilToken_1= ruleUntilToken
                    {

                    			newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UntilToken_1=ruleUntilToken();

                    state._fsp--;


                    			current = this_UntilToken_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // InternalXtextGrammarTestLanguage.g:2834:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2834:53: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:2835:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNegatedToken=ruleNegatedToken();

            state._fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // InternalXtextGrammarTestLanguage.g:2841:1: ruleNegatedToken returns [EObject current=null] : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2847:2: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // InternalXtextGrammarTestLanguage.g:2848:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:2848:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // InternalXtextGrammarTestLanguage.g:2849:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:2853:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:2854:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:2854:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:2855:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					newCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNegatedTokenRule());
            					}
            					set(
            						current,
            						"terminal",
            						lv_terminal_1_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.TerminalTokenElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // InternalXtextGrammarTestLanguage.g:2876:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2876:51: (iv_ruleUntilToken= ruleUntilToken EOF )
            // InternalXtextGrammarTestLanguage.g:2877:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             newCompositeNode(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUntilToken=ruleUntilToken();

            state._fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // InternalXtextGrammarTestLanguage.g:2883:1: ruleUntilToken returns [EObject current=null] : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2889:2: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // InternalXtextGrammarTestLanguage.g:2890:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // InternalXtextGrammarTestLanguage.g:2890:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // InternalXtextGrammarTestLanguage.g:2891:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:2895:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:2896:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:2896:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:2897:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					newCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUntilTokenRule());
            					}
            					set(
            						current,
            						"terminal",
            						lv_terminal_1_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.TerminalTokenElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // InternalXtextGrammarTestLanguage.g:2918:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2918:49: (iv_ruleWildcard= ruleWildcard EOF )
            // InternalXtextGrammarTestLanguage.g:2919:2: iv_ruleWildcard= ruleWildcard EOF
            {
             newCompositeNode(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // InternalXtextGrammarTestLanguage.g:2925:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2931:2: ( ( () otherlv_1= '.' ) )
            // InternalXtextGrammarTestLanguage.g:2932:2: ( () otherlv_1= '.' )
            {
            // InternalXtextGrammarTestLanguage.g:2932:2: ( () otherlv_1= '.' )
            // InternalXtextGrammarTestLanguage.g:2933:3: () otherlv_1= '.'
            {
            // InternalXtextGrammarTestLanguage.g:2933:3: ()
            // InternalXtextGrammarTestLanguage.g:2934:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getWildcardAccess().getWildcardAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleEOF"
    // InternalXtextGrammarTestLanguage.g:2948:1: entryRuleEOF returns [EObject current=null] : iv_ruleEOF= ruleEOF EOF ;
    public final EObject entryRuleEOF() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOF = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2948:44: (iv_ruleEOF= ruleEOF EOF )
            // InternalXtextGrammarTestLanguage.g:2949:2: iv_ruleEOF= ruleEOF EOF
            {
             newCompositeNode(grammarAccess.getEOFRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEOF=ruleEOF();

            state._fsp--;

             current =iv_ruleEOF; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEOF"


    // $ANTLR start "ruleEOF"
    // InternalXtextGrammarTestLanguage.g:2955:1: ruleEOF returns [EObject current=null] : ( () otherlv_1= 'EOF' ) ;
    public final EObject ruleEOF() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2961:2: ( ( () otherlv_1= 'EOF' ) )
            // InternalXtextGrammarTestLanguage.g:2962:2: ( () otherlv_1= 'EOF' )
            {
            // InternalXtextGrammarTestLanguage.g:2962:2: ( () otherlv_1= 'EOF' )
            // InternalXtextGrammarTestLanguage.g:2963:3: () otherlv_1= 'EOF'
            {
            // InternalXtextGrammarTestLanguage.g:2963:3: ()
            // InternalXtextGrammarTestLanguage.g:2964:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEOFAccess().getEOFAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getEOFAccess().getEOFKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEOF"


    // $ANTLR start "entryRuleCharacterRange"
    // InternalXtextGrammarTestLanguage.g:2978:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // InternalXtextGrammarTestLanguage.g:2978:55: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // InternalXtextGrammarTestLanguage.g:2979:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             newCompositeNode(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCharacterRange=ruleCharacterRange();

            state._fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // InternalXtextGrammarTestLanguage.g:2985:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Keyword_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:2991:2: ( (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // InternalXtextGrammarTestLanguage.g:2992:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // InternalXtextGrammarTestLanguage.g:2992:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // InternalXtextGrammarTestLanguage.g:2993:3: this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			newCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_46);
            this_Keyword_0=ruleKeyword();

            state._fsp--;


            			current = this_Keyword_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:3001:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==44) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3002:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:3002:4: ()
                    // InternalXtextGrammarTestLanguage.g:3003:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1());
                    			
                    // InternalXtextGrammarTestLanguage.g:3013:4: ( (lv_right_3_0= ruleKeyword ) )
                    // InternalXtextGrammarTestLanguage.g:3014:5: (lv_right_3_0= ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:3014:5: (lv_right_3_0= ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:3015:6: lv_right_3_0= ruleKeyword
                    {

                    						newCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=ruleKeyword();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRangeRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_3_0,
                    							"org.eclipse.xtext.XtextGrammarTestLanguage.Keyword");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // InternalXtextGrammarTestLanguage.g:3037:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // InternalXtextGrammarTestLanguage.g:3037:49: (iv_ruleEnumRule= ruleEnumRule EOF )
            // InternalXtextGrammarTestLanguage.g:3038:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             newCompositeNode(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumRule=ruleEnumRule();

            state._fsp--;

             current =iv_ruleEnumRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // InternalXtextGrammarTestLanguage.g:3044:1: ruleEnumRule returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' ) ;
    public final EObject ruleEnumRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_ReturnsClause_2 = null;

        EObject lv_alternatives_4_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:3050:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' ) )
            // InternalXtextGrammarTestLanguage.g:3051:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' )
            {
            // InternalXtextGrammarTestLanguage.g:3051:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';' )
            // InternalXtextGrammarTestLanguage.g:3052:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (this_ReturnsClause_2= ruleReturnsClause[$current] )? otherlv_3= ':' ( (lv_alternatives_4_0= ruleEnumLiterals ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumRuleAccess().getEnumKeyword_0());
            		
            // InternalXtextGrammarTestLanguage.g:3056:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:3057:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:3057:4: (lv_name_1_0= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:3058:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:3074:3: (this_ReturnsClause_2= ruleReturnsClause[$current] )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==27) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3075:4: this_ReturnsClause_2= ruleReturnsClause[$current]
                    {

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getEnumRuleRule());
                    				}
                    				newCompositeNode(grammarAccess.getEnumRuleAccess().getReturnsClauseParserRuleCall_2());
                    			
                    pushFollow(FollowSets000.FOLLOW_17);
                    this_ReturnsClause_2=ruleReturnsClause(current);

                    state._fsp--;


                    				current = this_ReturnsClause_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumRuleAccess().getColonKeyword_3());
            		
            // InternalXtextGrammarTestLanguage.g:3091:3: ( (lv_alternatives_4_0= ruleEnumLiterals ) )
            // InternalXtextGrammarTestLanguage.g:3092:4: (lv_alternatives_4_0= ruleEnumLiterals )
            {
            // InternalXtextGrammarTestLanguage.g:3092:4: (lv_alternatives_4_0= ruleEnumLiterals )
            // InternalXtextGrammarTestLanguage.g:3093:5: lv_alternatives_4_0= ruleEnumLiterals
            {

            					newCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0());
            				
            pushFollow(FollowSets000.FOLLOW_19);
            lv_alternatives_4_0=ruleEnumLiterals();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumRuleRule());
            					}
            					set(
            						current,
            						"alternatives",
            						lv_alternatives_4_0,
            						"org.eclipse.xtext.XtextGrammarTestLanguage.EnumLiterals");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // InternalXtextGrammarTestLanguage.g:3118:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // InternalXtextGrammarTestLanguage.g:3118:53: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // InternalXtextGrammarTestLanguage.g:3119:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumLiterals=ruleEnumLiterals();

            state._fsp--;

             current =iv_ruleEnumLiterals; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // InternalXtextGrammarTestLanguage.g:3125:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:3131:2: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // InternalXtextGrammarTestLanguage.g:3132:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // InternalXtextGrammarTestLanguage.g:3132:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // InternalXtextGrammarTestLanguage.g:3133:3: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_24);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();

            state._fsp--;


            			current = this_EnumLiteralDeclaration_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtextGrammarTestLanguage.g:3141:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==29) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3142:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // InternalXtextGrammarTestLanguage.g:3142:4: ()
                    // InternalXtextGrammarTestLanguage.g:3143:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtextGrammarTestLanguage.g:3149:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
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
                    	    // InternalXtextGrammarTestLanguage.g:3150:5: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {
                    	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_3); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtextGrammarTestLanguage.g:3154:5: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // InternalXtextGrammarTestLanguage.g:3155:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // InternalXtextGrammarTestLanguage.g:3155:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // InternalXtextGrammarTestLanguage.g:3156:7: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							newCompositeNode(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_elements_3_0=ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEnumLiteralsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.XtextGrammarTestLanguage.EnumLiteralDeclaration");
                    	    							afterParserOrEnumRuleCall();
                    	    						

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // InternalXtextGrammarTestLanguage.g:3179:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // InternalXtextGrammarTestLanguage.g:3179:63: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:3180:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();

            state._fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // InternalXtextGrammarTestLanguage.g:3186:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;



        	enterRule();

        try {
            // InternalXtextGrammarTestLanguage.g:3192:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // InternalXtextGrammarTestLanguage.g:3193:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // InternalXtextGrammarTestLanguage.g:3193:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // InternalXtextGrammarTestLanguage.g:3194:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // InternalXtextGrammarTestLanguage.g:3194:3: ( (otherlv_0= RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:3195:4: (otherlv_0= RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:3195:4: (otherlv_0= RULE_ID )
            // InternalXtextGrammarTestLanguage.g:3196:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumLiteralDeclarationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_47); 

            					newLeafNode(otherlv_0, grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0());
            				

            }


            }

            // InternalXtextGrammarTestLanguage.g:3207:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==34) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3208:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {
                    otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_11); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0());
                    			
                    // InternalXtextGrammarTestLanguage.g:3212:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // InternalXtextGrammarTestLanguage.g:3213:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:3213:5: (lv_literal_2_0= ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:3214:6: lv_literal_2_0= ruleKeyword
                    {

                    						newCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_literal_2_0=ruleKeyword();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEnumLiteralDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"literal",
                    							lv_literal_2_0,
                    							"org.eclipse.xtext.XtextGrammarTestLanguage.Keyword");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
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