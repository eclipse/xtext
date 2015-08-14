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
    // PsiInternalReferenceGrammarTestLanguage.g:52:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // PsiInternalReferenceGrammarTestLanguage.g:52:20: ( ruleSpielplatz EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:53:2: ruleSpielplatz EOF
            {
             markComposite(elementTypeProvider.getSpielplatzElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSpielplatz();

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
    // $ANTLR end "entryRuleSpielplatz"


    // $ANTLR start "ruleSpielplatz"
    // PsiInternalReferenceGrammarTestLanguage.g:58:1: ruleSpielplatz : (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? ;
    public final void ruleSpielplatz() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_groesse_1_0=null;
        Token lv_beschreibung_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:58:15: ( (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? )
            // PsiInternalReferenceGrammarTestLanguage.g:59:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            {
            // PsiInternalReferenceGrammarTestLanguage.g:59:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalReferenceGrammarTestLanguage.g:60:3: otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}'
                    {

                    			markLeaf(elementTypeProvider.getSpielplatz_SpielplatzKeyword_0ElementType());
                    		
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    			doneLeaf(otherlv_0);
                    		
                    // PsiInternalReferenceGrammarTestLanguage.g:67:3: ( (lv_groesse_1_0= RULE_INT ) )
                    // PsiInternalReferenceGrammarTestLanguage.g:68:4: (lv_groesse_1_0= RULE_INT )
                    {
                    // PsiInternalReferenceGrammarTestLanguage.g:68:4: (lv_groesse_1_0= RULE_INT )
                    // PsiInternalReferenceGrammarTestLanguage.g:69:5: lv_groesse_1_0= RULE_INT
                    {

                    					markLeaf(elementTypeProvider.getSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType());
                    				
                    lv_groesse_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

                    					doneLeaf(lv_groesse_1_0);
                    				

                    }


                    }

                    // PsiInternalReferenceGrammarTestLanguage.g:78:3: ( (lv_beschreibung_2_0= RULE_STRING ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // PsiInternalReferenceGrammarTestLanguage.g:79:4: (lv_beschreibung_2_0= RULE_STRING )
                            {
                            // PsiInternalReferenceGrammarTestLanguage.g:79:4: (lv_beschreibung_2_0= RULE_STRING )
                            // PsiInternalReferenceGrammarTestLanguage.g:80:5: lv_beschreibung_2_0= RULE_STRING
                            {

                            					markLeaf(elementTypeProvider.getSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType());
                            				
                            lv_beschreibung_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_5); 

                            					doneLeaf(lv_beschreibung_2_0);
                            				

                            }


                            }
                            break;

                    }


                    			markLeaf(elementTypeProvider.getSpielplatz_LeftCurlyBracketKeyword_3ElementType());
                    		
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                    			doneLeaf(otherlv_3);
                    		
                    // PsiInternalReferenceGrammarTestLanguage.g:96:3: ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )*
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
                    	    // PsiInternalReferenceGrammarTestLanguage.g:97:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:97:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:98:5: (lv_kinder_4_0= ruleKind )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:98:5: (lv_kinder_4_0= ruleKind )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:99:6: lv_kinder_4_0= ruleKind
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    ruleKind();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalReferenceGrammarTestLanguage.g:109:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:109:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:110:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:110:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:111:6: lv_erzieher_5_0= ruleErwachsener
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    ruleErwachsener();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // PsiInternalReferenceGrammarTestLanguage.g:121:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:121:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:122:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:122:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:123:6: lv_spielzeuge_6_0= ruleSpielzeug
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    ruleSpielzeug();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // PsiInternalReferenceGrammarTestLanguage.g:133:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:133:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:134:5: (lv_familie_7_0= ruleFamilie )
                    	    {
                    	    // PsiInternalReferenceGrammarTestLanguage.g:134:5: (lv_familie_7_0= ruleFamilie )
                    	    // PsiInternalReferenceGrammarTestLanguage.g:135:6: lv_familie_7_0= ruleFamilie
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    ruleFamilie();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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
        return ;
    }
    // $ANTLR end "ruleSpielplatz"


    // $ANTLR start "entryRuleKind"
    // PsiInternalReferenceGrammarTestLanguage.g:156:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // PsiInternalReferenceGrammarTestLanguage.g:156:14: ( ruleKind EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:157:2: ruleKind EOF
            {
             markComposite(elementTypeProvider.getKindElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKind();

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
    // $ANTLR end "entryRuleKind"


    // $ANTLR start "ruleKind"
    // PsiInternalReferenceGrammarTestLanguage.g:162:1: ruleKind : (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final void ruleKind() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:162:9: ( (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:163:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:163:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:164:3: otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getKind_KindKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getKind_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:178:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:179:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:179:4: (lv_name_2_0= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:180:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:189:3: ( (lv_age_3_0= RULE_INT ) )
            // PsiInternalReferenceGrammarTestLanguage.g:190:4: (lv_age_3_0= RULE_INT )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:190:4: (lv_age_3_0= RULE_INT )
            // PsiInternalReferenceGrammarTestLanguage.g:191:5: lv_age_3_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getKind_AgeINTTerminalRuleCall_3_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleKind"


    // $ANTLR start "entryRuleErwachsener"
    // PsiInternalReferenceGrammarTestLanguage.g:211:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // PsiInternalReferenceGrammarTestLanguage.g:211:21: ( ruleErwachsener EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:212:2: ruleErwachsener EOF
            {
             markComposite(elementTypeProvider.getErwachsenerElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleErwachsener();

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
    // $ANTLR end "entryRuleErwachsener"


    // $ANTLR start "ruleErwachsener"
    // PsiInternalReferenceGrammarTestLanguage.g:217:1: ruleErwachsener : (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final void ruleErwachsener() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:217:16: ( (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:218:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:218:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:219:3: otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getErwachsener_ErwachsenerKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getErwachsener_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:233:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:234:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:234:4: (lv_name_2_0= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:235:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:244:3: ( (lv_age_3_0= RULE_INT ) )
            // PsiInternalReferenceGrammarTestLanguage.g:245:4: (lv_age_3_0= RULE_INT )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:245:4: (lv_age_3_0= RULE_INT )
            // PsiInternalReferenceGrammarTestLanguage.g:246:5: lv_age_3_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getErwachsener_AgeINTTerminalRuleCall_3_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleErwachsener"


    // $ANTLR start "entryRuleSpielzeug"
    // PsiInternalReferenceGrammarTestLanguage.g:266:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // PsiInternalReferenceGrammarTestLanguage.g:266:19: ( ruleSpielzeug EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:267:2: ruleSpielzeug EOF
            {
             markComposite(elementTypeProvider.getSpielzeugElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSpielzeug();

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
    // $ANTLR end "entryRuleSpielzeug"


    // $ANTLR start "ruleSpielzeug"
    // PsiInternalReferenceGrammarTestLanguage.g:272:1: ruleSpielzeug : (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) ;
    public final void ruleSpielzeug() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:272:14: ( (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:273:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:273:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:274:3: otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getSpielzeug_SpielzeugKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getSpielzeug_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:288:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:289:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:289:4: (lv_name_2_0= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:290:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSpielzeug_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:299:3: ( (lv_farbe_3_0= ruleFarbe ) )
            // PsiInternalReferenceGrammarTestLanguage.g:300:4: (lv_farbe_3_0= ruleFarbe )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:300:4: (lv_farbe_3_0= ruleFarbe )
            // PsiInternalReferenceGrammarTestLanguage.g:301:5: lv_farbe_3_0= ruleFarbe
            {

            					markComposite(elementTypeProvider.getSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            ruleFarbe();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleSpielzeug"


    // $ANTLR start "entryRuleFarbe"
    // PsiInternalReferenceGrammarTestLanguage.g:321:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // PsiInternalReferenceGrammarTestLanguage.g:321:15: ( ruleFarbe EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:322:2: ruleFarbe EOF
            {
             markComposite(elementTypeProvider.getFarbeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFarbe();

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
    // $ANTLR end "entryRuleFarbe"


    // $ANTLR start "ruleFarbe"
    // PsiInternalReferenceGrammarTestLanguage.g:327:1: ruleFarbe : ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) ;
    public final void ruleFarbe() throws RecognitionException {
        Token lv_wert_0_1=null;
        Token lv_wert_0_2=null;
        Token lv_wert_0_3=null;
        Token lv_wert_0_4=null;

        try {
            // PsiInternalReferenceGrammarTestLanguage.g:327:10: ( ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) )
            // PsiInternalReferenceGrammarTestLanguage.g:328:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:328:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            // PsiInternalReferenceGrammarTestLanguage.g:329:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:329:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:330:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:330:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
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
                    // PsiInternalReferenceGrammarTestLanguage.g:331:5: lv_wert_0_1= 'ROT'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertROTKeyword_0_0ElementType());
                    				
                    lv_wert_0_1=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_1);
                    				

                    }
                    break;
                case 2 :
                    // PsiInternalReferenceGrammarTestLanguage.g:339:5: lv_wert_0_2= 'BLAU'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertBLAUKeyword_0_1ElementType());
                    				
                    lv_wert_0_2=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_2);
                    				

                    }
                    break;
                case 3 :
                    // PsiInternalReferenceGrammarTestLanguage.g:347:5: lv_wert_0_3= 'GELB'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertGELBKeyword_0_2ElementType());
                    				
                    lv_wert_0_3=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_3);
                    				

                    }
                    break;
                case 4 :
                    // PsiInternalReferenceGrammarTestLanguage.g:355:5: lv_wert_0_4= 'GR\\u00DCN'
                    {

                    					markLeaf(elementTypeProvider.getFarbe_WertGRÜNKeyword_0_3ElementType());
                    				
                    lv_wert_0_4=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_wert_0_4);
                    				

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
    // $ANTLR end "ruleFarbe"


    // $ANTLR start "entryRuleFamilie"
    // PsiInternalReferenceGrammarTestLanguage.g:368:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // PsiInternalReferenceGrammarTestLanguage.g:368:17: ( ruleFamilie EOF )
            // PsiInternalReferenceGrammarTestLanguage.g:369:2: ruleFamilie EOF
            {
             markComposite(elementTypeProvider.getFamilieElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFamilie();

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
    // $ANTLR end "entryRuleFamilie"


    // $ANTLR start "ruleFamilie"
    // PsiInternalReferenceGrammarTestLanguage.g:374:1: ruleFamilie : (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) ;
    public final void ruleFamilie() throws RecognitionException {
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
            // PsiInternalReferenceGrammarTestLanguage.g:374:12: ( (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) )
            // PsiInternalReferenceGrammarTestLanguage.g:375:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:375:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            // PsiInternalReferenceGrammarTestLanguage.g:376:3: otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')'
            {

            			markLeaf(elementTypeProvider.getFamilie_FamilieKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getFamilie_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalReferenceGrammarTestLanguage.g:390:3: ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) )
            // PsiInternalReferenceGrammarTestLanguage.g:391:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:391:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:392:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:392:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
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
                    // PsiInternalReferenceGrammarTestLanguage.g:393:6: lv_name_2_1= 'keyword'
                    {

                    						markLeaf(elementTypeProvider.getFamilie_NameKeywordKeyword_2_0_0ElementType());
                    					
                    lv_name_2_1=(Token)match(input,24,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_name_2_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalReferenceGrammarTestLanguage.g:401:6: lv_name_2_2= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType());
                    					
                    lv_name_2_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_name_2_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalReferenceGrammarTestLanguage.g:409:6: lv_name_2_3= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getFamilie_NameIDTerminalRuleCall_2_0_2ElementType());
                    					
                    lv_name_2_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_name_2_3);
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:419:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:420:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:420:4: (otherlv_3= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:421:5: otherlv_3= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFamilie_MutterErwachsenerCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(otherlv_3);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:430:3: ( (otherlv_4= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:431:4: (otherlv_4= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:431:4: (otherlv_4= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:432:5: otherlv_4= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFamilie_VaterErwachsenerCrossReference_4_0ElementType());
            				
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(otherlv_4);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:441:3: ( (otherlv_5= RULE_ID ) )
            // PsiInternalReferenceGrammarTestLanguage.g:442:4: (otherlv_5= RULE_ID )
            {
            // PsiInternalReferenceGrammarTestLanguage.g:442:4: (otherlv_5= RULE_ID )
            // PsiInternalReferenceGrammarTestLanguage.g:443:5: otherlv_5= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFamilie_KinderKindCrossReference_5_0ElementType());
            				
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(otherlv_5);
            				

            }


            }

            // PsiInternalReferenceGrammarTestLanguage.g:452:3: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalReferenceGrammarTestLanguage.g:453:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getFamilie_CommaKeyword_6_0ElementType());
            	    			
            	    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            	    				doneLeaf(otherlv_6);
            	    			
            	    // PsiInternalReferenceGrammarTestLanguage.g:460:4: ( (otherlv_7= RULE_ID ) )
            	    // PsiInternalReferenceGrammarTestLanguage.g:461:5: (otherlv_7= RULE_ID )
            	    {
            	    // PsiInternalReferenceGrammarTestLanguage.g:461:5: (otherlv_7= RULE_ID )
            	    // PsiInternalReferenceGrammarTestLanguage.g:462:6: otherlv_7= RULE_ID
            	    {

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
        return ;
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