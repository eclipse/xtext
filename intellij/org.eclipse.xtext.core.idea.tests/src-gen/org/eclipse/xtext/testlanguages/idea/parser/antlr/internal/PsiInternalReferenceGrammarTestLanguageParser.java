package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalReferenceGrammarTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'familie'", "'keyword'", "','"
    };
    public static final int RULE_ID=6;
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
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalReferenceGrammarTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalReferenceGrammarTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalReferenceGrammarTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalReferenceGrammarTestLanguage.g"; }



    	protected ReferenceGrammarTestLanguageGrammarAccess grammarAccess;

    	protected ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalReferenceGrammarTestLanguageParser(PsiBuilder builder, TokenStream input, ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider, ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Spielplatz";
    	}




    // $ANTLR start "entryRuleSpielplatz"
    // PsiInternalReferenceGrammarTestLanguage.g:52:1: entryRuleSpielplatz returns [Boolean current=false] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final Boolean entryRuleSpielplatz() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSpielplatz = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:52:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:53:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             markComposite(elementTypeProvider.getSpielplatzElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpielplatz=ruleSpielplatz();

            state._fsp--;

             current =iv_ruleSpielplatz; 
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
    // $ANTLR end "entryRuleSpielplatz"


    // $ANTLR start "ruleSpielplatz"
    // PsiInternalReferenceGrammarTestLanguage.g:59:1: ruleSpielplatz returns [Boolean current=false] : (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? ;
    public final Boolean ruleSpielplatz() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_groesse_1_0=null;
        Token lv_beschreibung_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        Boolean lv_kinder_4_0 = null;

        Boolean lv_erzieher_5_0 = null;

        Boolean lv_spielzeuge_6_0 = null;

        Boolean lv_familie_7_0 = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:60:1: ( (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? )
            // PsiInternalReferenceGrammarTestLanguage.g:61:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            {
            // PsiInternalReferenceGrammarTestLanguage.g:61:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalReferenceGrammarTestLanguage.g:62:3: otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}'
                    {

                    			markLeaf(elementTypeProvider.getSpielplatz_SpielplatzKeyword_0ElementType());
                    		
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    			doneLeaf(otherlv_0);
                    		
                    // PsiInternalReferenceGrammarTestLanguage.g:69:3: ( (lv_groesse_1_0= RULE_INT ) )
                    // PsiInternalReferenceGrammarTestLanguage.g:70:4: (lv_groesse_1_0= RULE_INT )
                    {
                    // PsiInternalReferenceGrammarTestLanguage.g:70:4: (lv_groesse_1_0= RULE_INT )
                    // PsiInternalReferenceGrammarTestLanguage.g:71:5: lv_groesse_1_0= RULE_INT
                    {

                    					markLeaf(elementTypeProvider.getSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_groesse_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

                    					doneLeaf(lv_groesse_1_0);
                    				

                    }


                    }

                    // PsiInternalReferenceGrammarTestLanguage.g:86:3: ( (lv_beschreibung_2_0= RULE_STRING ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // PsiInternalReferenceGrammarTestLanguage.g:87:4: (lv_beschreibung_2_0= RULE_STRING )
                            {
                            // PsiInternalReferenceGrammarTestLanguage.g:87:4: (lv_beschreibung_2_0= RULE_STRING )
                            // PsiInternalReferenceGrammarTestLanguage.g:88:5: lv_beschreibung_2_0= RULE_STRING
                            {

                            					markLeaf(elementTypeProvider.getSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType());
                            				

                            					if(!current) {
                            						associateWithSemanticElement();
                            						current = true;
                            					}
                            				
                            lv_beschreibung_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_5); 

                            					doneLeaf(lv_beschreibung_2_0);
                            				

                            }


                            }
                            break;

                    }


                    			markLeaf(elementTypeProvider.getSpielplatz_LeftCurlyBracketKeyword_3ElementType());
                    		
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                    			doneLeaf(otherlv_3);
                    		
                    // PsiInternalReferenceGrammarTestLanguage.g:110:3: ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )*
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
                    	    // PsiInternalReferenceGrammarTestLanguage.g:111:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:111:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:112:5: (lv_kinder_4_0= ruleKind )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:112:5: (lv_kinder_4_0= ruleKind )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:113:6: lv_kinder_4_0= ruleKind
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_kinder_4_0=ruleKind();

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
                    	    // PsiInternalReferenceGrammarTestLanguage.g:127:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:127:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:128:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:128:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:129:6: lv_erzieher_5_0= ruleErwachsener
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_erzieher_5_0=ruleErwachsener();

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
                    	case 3 :
                    	    // PsiInternalReferenceGrammarTestLanguage.g:143:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:143:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:144:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:144:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:145:6: lv_spielzeuge_6_0= ruleSpielzeug
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_spielzeuge_6_0=ruleSpielzeug();

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
                    	case 4 :
                    	    // PsiInternalReferenceGrammarTestLanguage.g:159:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:159:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:160:5: (lv_familie_7_0= ruleFamilie )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:160:5: (lv_familie_7_0= ruleFamilie )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:161:6: lv_familie_7_0= ruleFamilie
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_familie_7_0=ruleFamilie();

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
                    	    break loop2;
                        }
                    } while (true);


                    			markLeaf(elementTypeProvider.getSpielplatz_RightCurlyBracketKeyword_5ElementType());
                    		
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    			doneLeaf(otherlv_8);
                    		

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
    // $ANTLR end "ruleSpielplatz"


    // $ANTLR start "entryRuleKind"
    // PsiInternalReferenceGrammarTestLanguage.g:186:1: entryRuleKind returns [Boolean current=false] : iv_ruleKind= ruleKind EOF ;
    public final Boolean entryRuleKind() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleKind = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:186:46: (iv_ruleKind= ruleKind EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:187:2: iv_ruleKind= ruleKind EOF
            {
             markComposite(elementTypeProvider.getKindElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKind=ruleKind();

            state._fsp--;

             current =iv_ruleKind; 
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
    // $ANTLR end "entryRuleKind"


    // $ANTLR start "ruleKind"
    // PsiInternalReferenceGrammarTestLanguage.g:193:1: ruleKind returns [Boolean current=false] : (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final Boolean ruleKind() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:194:1: ( (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:195:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:195:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:196:3: otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getKind_KindKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getKind_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:210:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:211:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:211:4: (lv_name_2_0= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:212:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:227:3: ( (lv_age_3_0= RULE_INT ) )
            // PsiInternalReferenceGrammarTestLanguage.g:228:4: (lv_age_3_0= RULE_INT )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:228:4: (lv_age_3_0= RULE_INT )
            // PsiInternalReferenceGrammarTestLanguage.g:229:5: lv_age_3_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getKind_AgeINTTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_age_3_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getKind_RightParenthesisKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleKind"


    // $ANTLR start "entryRuleErwachsener"
    // PsiInternalReferenceGrammarTestLanguage.g:255:1: entryRuleErwachsener returns [Boolean current=false] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final Boolean entryRuleErwachsener() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleErwachsener = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:255:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:256:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             markComposite(elementTypeProvider.getErwachsenerElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleErwachsener=ruleErwachsener();

            state._fsp--;

             current =iv_ruleErwachsener; 
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
    // $ANTLR end "entryRuleErwachsener"


    // $ANTLR start "ruleErwachsener"
    // PsiInternalReferenceGrammarTestLanguage.g:262:1: ruleErwachsener returns [Boolean current=false] : (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final Boolean ruleErwachsener() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:263:1: ( (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:264:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:264:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:265:3: otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getErwachsener_ErwachsenerKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getErwachsener_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:279:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:280:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:280:4: (lv_name_2_0= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:281:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:296:3: ( (lv_age_3_0= RULE_INT ) )
            // PsiInternalReferenceGrammarTestLanguage.g:297:4: (lv_age_3_0= RULE_INT )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:297:4: (lv_age_3_0= RULE_INT )
            // PsiInternalReferenceGrammarTestLanguage.g:298:5: lv_age_3_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getErwachsener_AgeINTTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_age_3_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getErwachsener_RightParenthesisKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleErwachsener"


    // $ANTLR start "entryRuleSpielzeug"
    // PsiInternalReferenceGrammarTestLanguage.g:324:1: entryRuleSpielzeug returns [Boolean current=false] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final Boolean entryRuleSpielzeug() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSpielzeug = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:324:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:325:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             markComposite(elementTypeProvider.getSpielzeugElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpielzeug=ruleSpielzeug();

            state._fsp--;

             current =iv_ruleSpielzeug; 
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
    // $ANTLR end "entryRuleSpielzeug"


    // $ANTLR start "ruleSpielzeug"
    // PsiInternalReferenceGrammarTestLanguage.g:331:1: ruleSpielzeug returns [Boolean current=false] : (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) ;
    public final Boolean ruleSpielzeug() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Boolean lv_farbe_3_0 = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:332:1: ( (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:333:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:333:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:334:3: otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getSpielzeug_SpielzeugKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getSpielzeug_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:348:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:349:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:349:4: (lv_name_2_0= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:350:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSpielzeug_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:365:3: ( (lv_farbe_3_0= ruleFarbe ) )
            // PsiInternalReferenceGrammarTestLanguage.g:366:4: (lv_farbe_3_0= ruleFarbe )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:366:4: (lv_farbe_3_0= ruleFarbe )
            // PsiInternalReferenceGrammarTestLanguage.g:367:5: lv_farbe_3_0= ruleFarbe
            {

            					markComposite(elementTypeProvider.getSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            lv_farbe_3_0=ruleFarbe();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getSpielzeug_RightParenthesisKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleSpielzeug"


    // $ANTLR start "entryRuleFarbe"
    // PsiInternalReferenceGrammarTestLanguage.g:391:1: entryRuleFarbe returns [Boolean current=false] : iv_ruleFarbe= ruleFarbe EOF ;
    public final Boolean entryRuleFarbe() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFarbe = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:391:47: (iv_ruleFarbe= ruleFarbe EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:392:2: iv_ruleFarbe= ruleFarbe EOF
            {
             markComposite(elementTypeProvider.getFarbeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFarbe=ruleFarbe();

            state._fsp--;

             current =iv_ruleFarbe; 
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
    // $ANTLR end "entryRuleFarbe"


    // $ANTLR start "ruleFarbe"
    // PsiInternalReferenceGrammarTestLanguage.g:398:1: ruleFarbe returns [Boolean current=false] : ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) ;
    public final Boolean ruleFarbe() throws RecognitionException {
        Boolean current = false;

        Token lv_wert_0_1=null;
        Token lv_wert_0_2=null;
        Token lv_wert_0_3=null;
        Token lv_wert_0_4=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:399:1: ( ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) )
            // PsiInternalReferenceGrammarTestLanguage.g:400:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:400:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            // PsiInternalReferenceGrammarTestLanguage.g:401:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:401:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:402:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:402:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
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
                    // PsiInternalReferenceGrammarTestLanguage.g:403:5: lv_wert_0_1= 'ROT'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertROTKeyword_0_0ElementType());
                    				
                    lv_wert_0_1=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_1);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }
                    break;
                case 2 :
                    // PsiInternalReferenceGrammarTestLanguage.g:417:5: lv_wert_0_2= 'BLAU'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertBLAUKeyword_0_1ElementType());
                    				
                    lv_wert_0_2=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_2);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }
                    break;
                case 3 :
                    // PsiInternalReferenceGrammarTestLanguage.g:431:5: lv_wert_0_3= 'GELB'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertGELBKeyword_0_2ElementType());
                    				
                    lv_wert_0_3=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_3);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }
                    break;
                case 4 :
                    // PsiInternalReferenceGrammarTestLanguage.g:445:5: lv_wert_0_4= 'GR\\u00DCN'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertGRÜNKeyword_0_3ElementType());
                    				
                    lv_wert_0_4=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_4);
                    				

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
    // $ANTLR end "ruleFarbe"


    // $ANTLR start "entryRuleFamilie"
    // PsiInternalReferenceGrammarTestLanguage.g:464:1: entryRuleFamilie returns [Boolean current=false] : iv_ruleFamilie= ruleFamilie EOF ;
    public final Boolean entryRuleFamilie() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFamilie = null;


        try {
            // PsiInternalReferenceGrammarTestLanguage.g:464:49: (iv_ruleFamilie= ruleFamilie EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:465:2: iv_ruleFamilie= ruleFamilie EOF
            {
             markComposite(elementTypeProvider.getFamilieElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFamilie=ruleFamilie();

            state._fsp--;

             current =iv_ruleFamilie; 
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
    // $ANTLR end "entryRuleFamilie"


    // $ANTLR start "ruleFamilie"
    // PsiInternalReferenceGrammarTestLanguage.g:471:1: ruleFamilie returns [Boolean current=false] : (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) ;
    public final Boolean ruleFamilie() throws RecognitionException {
        Boolean current = false;

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

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:472:1: ( (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:473:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:473:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:474:3: otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')'
            {

            			markLeaf(elementTypeProvider.getFamilie_FamilieKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getFamilie_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:488:3: ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) )
            // PsiInternalReferenceGrammarTestLanguage.g:489:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:489:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:490:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:490:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
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
                    // PsiInternalReferenceGrammarTestLanguage.g:491:6: lv_name_2_1= 'keyword'
                    {

                    						markLeaf(elementTypeProvider.getFamilie_NameKeywordKeyword_2_0_0ElementType());
                    					
                    lv_name_2_1=(Token)match(input,24,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_name_2_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalReferenceGrammarTestLanguage.g:505:6: lv_name_2_2= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_2_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_name_2_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalReferenceGrammarTestLanguage.g:519:6: lv_name_2_3= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getFamilie_NameIDTerminalRuleCall_2_0_2ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_2_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_name_2_3);
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:535:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:536:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:536:4: (otherlv_3= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:537:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getFamilie_MutterErwachsenerCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(otherlv_3);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:552:3: ( (otherlv_4= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:553:4: (otherlv_4= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:553:4: (otherlv_4= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:554:5: otherlv_4= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getFamilie_VaterErwachsenerCrossReference_4_0ElementType());
            				
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(otherlv_4);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:569:3: ( (otherlv_5= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:570:4: (otherlv_5= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:570:4: (otherlv_5= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:571:5: otherlv_5= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getFamilie_KinderKindCrossReference_5_0ElementType());
            				
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(otherlv_5);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:586:3: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalReferenceGrammarTestLanguage.g:587:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getFamilie_CommaKeyword_6_0ElementType());
            	    			
            	    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            	    				doneLeaf(otherlv_6);
            	    			
            	    // PsiInternalReferenceGrammarTestLanguage.g:594:4: ( (otherlv_7= RULE_ID ) )
            	    // PsiInternalReferenceGrammarTestLanguage.g:595:5: (otherlv_7= RULE_ID )
            	    {
            	    // PsiInternalReferenceGrammarTestLanguage.g:595:5: (otherlv_7= RULE_ID )
            	    // PsiInternalReferenceGrammarTestLanguage.g:596:6: otherlv_7= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getFamilie_KinderKindCrossReference_6_1_0ElementType());
            	    					
            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    						doneLeaf(otherlv_7);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getFamilie_RightParenthesisKeyword_7ElementType());
            		
            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_2); 

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