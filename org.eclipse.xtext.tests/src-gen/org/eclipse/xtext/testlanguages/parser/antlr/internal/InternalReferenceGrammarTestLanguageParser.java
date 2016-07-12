package org.eclipse.xtext.testlanguages.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReferenceGrammarTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GR\\uFFFDN'", "'familie'", "'keyword'", "','"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalReferenceGrammarTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferenceGrammarTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferenceGrammarTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReferenceGrammarTestLanguage.g"; }



     	private ReferenceGrammarTestLanguageGrammarAccess grammarAccess;

        public InternalReferenceGrammarTestLanguageParser(TokenStream input, ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";
       	}

       	@Override
       	protected ReferenceGrammarTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSpielplatz"
    // InternalReferenceGrammarTestLanguage.g:64:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:64:51: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // InternalReferenceGrammarTestLanguage.g:65:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             newCompositeNode(grammarAccess.getSpielplatzRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpielplatz=ruleSpielplatz();

            state._fsp--;

             current =iv_ruleSpielplatz; 
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
    // $ANTLR end "entryRuleSpielplatz"


    // $ANTLR start "ruleSpielplatz"
    // InternalReferenceGrammarTestLanguage.g:71:1: ruleSpielplatz returns [EObject current=null] : (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_groesse_1_0=null;
        Token lv_beschreibung_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_kinder_4_0 = null;

        EObject lv_erzieher_5_0 = null;

        EObject lv_spielzeuge_6_0 = null;

        EObject lv_familie_7_0 = null;



        	enterRule();

        try {
            // InternalReferenceGrammarTestLanguage.g:77:2: ( (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? )
            // InternalReferenceGrammarTestLanguage.g:78:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            {
            // InternalReferenceGrammarTestLanguage.g:78:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalReferenceGrammarTestLanguage.g:79:3: otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}'
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    			newLeafNode(otherlv_0, grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0());
                    		
                    // InternalReferenceGrammarTestLanguage.g:83:3: ( (lv_groesse_1_0= RULE_INT ) )
                    // InternalReferenceGrammarTestLanguage.g:84:4: (lv_groesse_1_0= RULE_INT )
                    {
                    // InternalReferenceGrammarTestLanguage.g:84:4: (lv_groesse_1_0= RULE_INT )
                    // InternalReferenceGrammarTestLanguage.g:85:5: lv_groesse_1_0= RULE_INT
                    {
                    lv_groesse_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

                    					newLeafNode(lv_groesse_1_0, grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSpielplatzRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"groesse",
                    						lv_groesse_1_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }

                    // InternalReferenceGrammarTestLanguage.g:101:3: ( (lv_beschreibung_2_0= RULE_STRING ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalReferenceGrammarTestLanguage.g:102:4: (lv_beschreibung_2_0= RULE_STRING )
                            {
                            // InternalReferenceGrammarTestLanguage.g:102:4: (lv_beschreibung_2_0= RULE_STRING )
                            // InternalReferenceGrammarTestLanguage.g:103:5: lv_beschreibung_2_0= RULE_STRING
                            {
                            lv_beschreibung_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_5); 

                            					newLeafNode(lv_beschreibung_2_0, grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0());
                            				

                            					if (current==null) {
                            						current = createModelElement(grammarAccess.getSpielplatzRule());
                            					}
                            					setWithLastConsumed(
                            						current,
                            						"beschreibung",
                            						lv_beschreibung_2_0,
                            						"org.eclipse.xtext.common.Terminals.STRING");
                            				

                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                    			newLeafNode(otherlv_3, grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3());
                    		
                    // InternalReferenceGrammarTestLanguage.g:123:3: ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )*
                    loop2:
                    do {
                        int alt2=5;
                        switch ( input.LA(1) ) {
                        case 14:
                            {
                            alt2=1;
                            }
                            break;
                        case 17:
                            {
                            alt2=2;
                            }
                            break;
                        case 18:
                            {
                            alt2=3;
                            }
                            break;
                        case 23:
                            {
                            alt2=4;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // InternalReferenceGrammarTestLanguage.g:124:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:124:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    // InternalReferenceGrammarTestLanguage.g:125:5: (lv_kinder_4_0= ruleKind )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:125:5: (lv_kinder_4_0= ruleKind )
                    	    // InternalReferenceGrammarTestLanguage.g:126:6: lv_kinder_4_0= ruleKind
                    	    {

                    	    						newCompositeNode(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_kinder_4_0=ruleKind();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"kinder",
                    	    							lv_kinder_4_0,
                    	    							"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Kind");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReferenceGrammarTestLanguage.g:144:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:144:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    // InternalReferenceGrammarTestLanguage.g:145:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:145:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    // InternalReferenceGrammarTestLanguage.g:146:6: lv_erzieher_5_0= ruleErwachsener
                    	    {

                    	    						newCompositeNode(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_erzieher_5_0=ruleErwachsener();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"erzieher",
                    	    							lv_erzieher_5_0,
                    	    							"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Erwachsener");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalReferenceGrammarTestLanguage.g:164:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:164:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    // InternalReferenceGrammarTestLanguage.g:165:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:165:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    // InternalReferenceGrammarTestLanguage.g:166:6: lv_spielzeuge_6_0= ruleSpielzeug
                    	    {

                    	    						newCompositeNode(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_spielzeuge_6_0=ruleSpielzeug();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"spielzeuge",
                    	    							lv_spielzeuge_6_0,
                    	    							"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Spielzeug");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalReferenceGrammarTestLanguage.g:184:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:184:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    // InternalReferenceGrammarTestLanguage.g:185:5: (lv_familie_7_0= ruleFamilie )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:185:5: (lv_familie_7_0= ruleFamilie )
                    	    // InternalReferenceGrammarTestLanguage.g:186:6: lv_familie_7_0= ruleFamilie
                    	    {

                    	    						newCompositeNode(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_familie_7_0=ruleFamilie();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"familie",
                    	    							lv_familie_7_0,
                    	    							"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Familie");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    			newLeafNode(otherlv_8, grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5());
                    		

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
    // $ANTLR end "ruleSpielplatz"


    // $ANTLR start "entryRuleKind"
    // InternalReferenceGrammarTestLanguage.g:212:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:212:45: (iv_ruleKind= ruleKind EOF )
            // InternalReferenceGrammarTestLanguage.g:213:2: iv_ruleKind= ruleKind EOF
            {
             newCompositeNode(grammarAccess.getKindRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKind=ruleKind();

            state._fsp--;

             current =iv_ruleKind; 
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
    // $ANTLR end "entryRuleKind"


    // $ANTLR start "ruleKind"
    // InternalReferenceGrammarTestLanguage.g:219:1: ruleKind returns [EObject current=null] : (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReferenceGrammarTestLanguage.g:225:2: ( (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:226:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:226:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalReferenceGrammarTestLanguage.g:227:3: otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getKindAccess().getKindKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getKindAccess().getLeftParenthesisKeyword_1());
            		
            // InternalReferenceGrammarTestLanguage.g:235:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:236:4: (lv_name_2_0= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:236:4: (lv_name_2_0= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:237:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					newLeafNode(lv_name_2_0, grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getKindRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalReferenceGrammarTestLanguage.g:253:3: ( (lv_age_3_0= RULE_INT ) )
            // InternalReferenceGrammarTestLanguage.g:254:4: (lv_age_3_0= RULE_INT )
            {
            // InternalReferenceGrammarTestLanguage.g:254:4: (lv_age_3_0= RULE_INT )
            // InternalReferenceGrammarTestLanguage.g:255:5: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_age_3_0, grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getKindRule());
            					}
            					setWithLastConsumed(
            						current,
            						"age",
            						lv_age_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getKindAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleKind"


    // $ANTLR start "entryRuleErwachsener"
    // InternalReferenceGrammarTestLanguage.g:279:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:279:52: (iv_ruleErwachsener= ruleErwachsener EOF )
            // InternalReferenceGrammarTestLanguage.g:280:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             newCompositeNode(grammarAccess.getErwachsenerRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleErwachsener=ruleErwachsener();

            state._fsp--;

             current =iv_ruleErwachsener; 
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
    // $ANTLR end "entryRuleErwachsener"


    // $ANTLR start "ruleErwachsener"
    // InternalReferenceGrammarTestLanguage.g:286:1: ruleErwachsener returns [EObject current=null] : (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReferenceGrammarTestLanguage.g:292:2: ( (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:293:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:293:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalReferenceGrammarTestLanguage.g:294:3: otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1());
            		
            // InternalReferenceGrammarTestLanguage.g:302:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:303:4: (lv_name_2_0= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:303:4: (lv_name_2_0= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:304:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					newLeafNode(lv_name_2_0, grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getErwachsenerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalReferenceGrammarTestLanguage.g:320:3: ( (lv_age_3_0= RULE_INT ) )
            // InternalReferenceGrammarTestLanguage.g:321:4: (lv_age_3_0= RULE_INT )
            {
            // InternalReferenceGrammarTestLanguage.g:321:4: (lv_age_3_0= RULE_INT )
            // InternalReferenceGrammarTestLanguage.g:322:5: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_age_3_0, grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getErwachsenerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"age",
            						lv_age_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleErwachsener"


    // $ANTLR start "entryRuleSpielzeug"
    // InternalReferenceGrammarTestLanguage.g:346:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:346:50: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // InternalReferenceGrammarTestLanguage.g:347:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             newCompositeNode(grammarAccess.getSpielzeugRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpielzeug=ruleSpielzeug();

            state._fsp--;

             current =iv_ruleSpielzeug; 
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
    // $ANTLR end "entryRuleSpielzeug"


    // $ANTLR start "ruleSpielzeug"
    // InternalReferenceGrammarTestLanguage.g:353:1: ruleSpielzeug returns [EObject current=null] : (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        EObject lv_farbe_3_0 = null;



        	enterRule();

        try {
            // InternalReferenceGrammarTestLanguage.g:359:2: ( (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:360:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:360:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            // InternalReferenceGrammarTestLanguage.g:361:3: otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1());
            		
            // InternalReferenceGrammarTestLanguage.g:369:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:370:4: (lv_name_2_0= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:370:4: (lv_name_2_0= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:371:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpielzeugRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalReferenceGrammarTestLanguage.g:387:3: ( (lv_farbe_3_0= ruleFarbe ) )
            // InternalReferenceGrammarTestLanguage.g:388:4: (lv_farbe_3_0= ruleFarbe )
            {
            // InternalReferenceGrammarTestLanguage.g:388:4: (lv_farbe_3_0= ruleFarbe )
            // InternalReferenceGrammarTestLanguage.g:389:5: lv_farbe_3_0= ruleFarbe
            {

            					newCompositeNode(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            lv_farbe_3_0=ruleFarbe();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpielzeugRule());
            					}
            					set(
            						current,
            						"farbe",
            						lv_farbe_3_0,
            						"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Farbe");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleSpielzeug"


    // $ANTLR start "entryRuleFarbe"
    // InternalReferenceGrammarTestLanguage.g:414:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:414:46: (iv_ruleFarbe= ruleFarbe EOF )
            // InternalReferenceGrammarTestLanguage.g:415:2: iv_ruleFarbe= ruleFarbe EOF
            {
             newCompositeNode(grammarAccess.getFarbeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFarbe=ruleFarbe();

            state._fsp--;

             current =iv_ruleFarbe; 
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
    // $ANTLR end "entryRuleFarbe"


    // $ANTLR start "ruleFarbe"
    // InternalReferenceGrammarTestLanguage.g:421:1: ruleFarbe returns [EObject current=null] : ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' ) ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert_0_1=null;
        Token lv_wert_0_2=null;
        Token lv_wert_0_3=null;
        Token lv_wert_0_4=null;


        	enterRule();

        try {
            // InternalReferenceGrammarTestLanguage.g:427:2: ( ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' ) ) ) )
            // InternalReferenceGrammarTestLanguage.g:428:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' ) ) )
            {
            // InternalReferenceGrammarTestLanguage.g:428:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' ) ) )
            // InternalReferenceGrammarTestLanguage.g:429:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' ) )
            {
            // InternalReferenceGrammarTestLanguage.g:429:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' ) )
            // InternalReferenceGrammarTestLanguage.g:430:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' )
            {
            // InternalReferenceGrammarTestLanguage.g:430:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\uFFFDN' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 21:
                {
                alt4=3;
                }
                break;
            case 22:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalReferenceGrammarTestLanguage.g:431:5: lv_wert_0_1= 'ROT'
                    {
                    lv_wert_0_1=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_wert_0_1, grammarAccess.getFarbeAccess().getWertROTKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFarbeRule());
                    					}
                    					setWithLastConsumed(current, "wert", lv_wert_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarTestLanguage.g:442:5: lv_wert_0_2= 'BLAU'
                    {
                    lv_wert_0_2=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_wert_0_2, grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFarbeRule());
                    					}
                    					setWithLastConsumed(current, "wert", lv_wert_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarTestLanguage.g:453:5: lv_wert_0_3= 'GELB'
                    {
                    lv_wert_0_3=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_wert_0_3, grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFarbeRule());
                    					}
                    					setWithLastConsumed(current, "wert", lv_wert_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalReferenceGrammarTestLanguage.g:464:5: lv_wert_0_4= 'GR\\uFFFDN'
                    {
                    lv_wert_0_4=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_wert_0_4, grammarAccess.getFarbeAccess().getWertGRNKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFarbeRule());
                    					}
                    					setWithLastConsumed(current, "wert", lv_wert_0_4, null);
                    				

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
    // $ANTLR end "ruleFarbe"


    // $ANTLR start "entryRuleFamilie"
    // InternalReferenceGrammarTestLanguage.g:480:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:480:48: (iv_ruleFamilie= ruleFamilie EOF )
            // InternalReferenceGrammarTestLanguage.g:481:2: iv_ruleFamilie= ruleFamilie EOF
            {
             newCompositeNode(grammarAccess.getFamilieRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFamilie=ruleFamilie();

            state._fsp--;

             current =iv_ruleFamilie; 
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
    // $ANTLR end "entryRuleFamilie"


    // $ANTLR start "ruleFamilie"
    // InternalReferenceGrammarTestLanguage.g:487:1: ruleFamilie returns [EObject current=null] : (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        Token lv_name_2_3=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalReferenceGrammarTestLanguage.g:493:2: ( (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:494:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:494:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            // InternalReferenceGrammarTestLanguage.g:495:3: otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getFamilieAccess().getFamilieKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1());
            		
            // InternalReferenceGrammarTestLanguage.g:503:3: ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) )
            // InternalReferenceGrammarTestLanguage.g:504:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            {
            // InternalReferenceGrammarTestLanguage.g:504:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:505:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:505:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt5=1;
                }
                break;
            case RULE_STRING:
                {
                alt5=2;
                }
                break;
            case RULE_ID:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalReferenceGrammarTestLanguage.g:506:6: lv_name_2_1= 'keyword'
                    {
                    lv_name_2_1=(Token)match(input,24,FollowSets000.FOLLOW_8); 

                    						newLeafNode(lv_name_2_1, grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFamilieRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarTestLanguage.g:517:6: lv_name_2_2= RULE_STRING
                    {
                    lv_name_2_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_8); 

                    						newLeafNode(lv_name_2_2, grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFamilieRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_2,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarTestLanguage.g:532:6: lv_name_2_3= RULE_ID
                    {
                    lv_name_2_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						newLeafNode(lv_name_2_3, grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFamilieRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_3,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }
                    break;

            }


            }


            }

            // InternalReferenceGrammarTestLanguage.g:549:3: ( (otherlv_3= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:550:4: (otherlv_3= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:550:4: (otherlv_3= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:551:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFamilieRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					newLeafNode(otherlv_3, grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0());
            				

            }


            }

            // InternalReferenceGrammarTestLanguage.g:562:3: ( (otherlv_4= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:563:4: (otherlv_4= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:563:4: (otherlv_4= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:564:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFamilieRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					newLeafNode(otherlv_4, grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0());
            				

            }


            }

            // InternalReferenceGrammarTestLanguage.g:575:3: ( (otherlv_5= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:576:4: (otherlv_5= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:576:4: (otherlv_5= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:577:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFamilieRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					newLeafNode(otherlv_5, grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0());
            				

            }


            }

            // InternalReferenceGrammarTestLanguage.g:588:3: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReferenceGrammarTestLanguage.g:589:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            	    				newLeafNode(otherlv_6, grammarAccess.getFamilieAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalReferenceGrammarTestLanguage.g:593:4: ( (otherlv_7= RULE_ID ) )
            	    // InternalReferenceGrammarTestLanguage.g:594:5: (otherlv_7= RULE_ID )
            	    {
            	    // InternalReferenceGrammarTestLanguage.g:594:5: (otherlv_7= RULE_ID )
            	    // InternalReferenceGrammarTestLanguage.g:595:6: otherlv_7= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getFamilieRule());
            	    						}
            	    					
            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    						newLeafNode(otherlv_7, grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleFamilie"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001020L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000780000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000060L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002010000L});
    }


}