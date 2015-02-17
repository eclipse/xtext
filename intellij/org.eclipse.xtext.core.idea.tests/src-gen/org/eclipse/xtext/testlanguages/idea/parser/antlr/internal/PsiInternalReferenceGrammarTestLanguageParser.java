package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g"; }



    private ReferenceGrammarTestLanguageGrammarAccess grammarAccess;

    private ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalReferenceGrammarTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider, ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Spielplatz";
    }




    // $ANTLR start "entryRuleSpielplatz"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:49:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:49:20: ( ruleSpielplatz EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:50:2: ruleSpielplatz EOF
            {
             markComposite(elementTypeProvider.getSpielplatzElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz54);
            ruleSpielplatz();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpielplatz60); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:58:1: ruleSpielplatz : (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? ;
    public final void ruleSpielplatz() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_groesse_1_0=null;
        Token lv_beschreibung_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:58:15: ( (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:59:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:59:2: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:60:3: otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}'
                    {

                    			markLeaf();
                    		
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSpielplatz83); 

                    			doneLeaf(otherlv_0, elementTypeProvider.getSpielplatz_SpielplatzKeyword_0ElementType());
                    		
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:67:3: ( (lv_groesse_1_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:68:4: (lv_groesse_1_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:68:4: (lv_groesse_1_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:69:5: lv_groesse_1_0= RULE_INT
                    {

                    					markLeaf();
                    				
                    lv_groesse_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSpielplatz110); 

                    					doneLeaf(lv_groesse_1_0, elementTypeProvider.getSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType());
                    				

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:78:3: ( (lv_beschreibung_2_0= RULE_STRING ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:79:4: (lv_beschreibung_2_0= RULE_STRING )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:79:4: (lv_beschreibung_2_0= RULE_STRING )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:80:5: lv_beschreibung_2_0= RULE_STRING
                            {

                            					markLeaf();
                            				
                            lv_beschreibung_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSpielplatz148); 

                            					doneLeaf(lv_beschreibung_2_0, elementTypeProvider.getSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType());
                            				

                            }


                            }
                            break;

                    }


                    			markLeaf();
                    		
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSpielplatz174); 

                    			doneLeaf(otherlv_3, elementTypeProvider.getSpielplatz_LeftCurlyBracketKeyword_3ElementType());
                    		
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:96:3: ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )*
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
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:97:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:97:4: ( (lv_kinder_4_0= ruleKind ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:98:5: (lv_kinder_4_0= ruleKind )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:98:5: (lv_kinder_4_0= ruleKind )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:99:6: lv_kinder_4_0= ruleKind
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleKind_in_ruleSpielplatz209);
                    	    ruleKind();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:109:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:109:4: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:110:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:110:5: (lv_erzieher_5_0= ruleErwachsener )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:111:6: lv_erzieher_5_0= ruleErwachsener
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_ruleSpielplatz263);
                    	    ruleErwachsener();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:121:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:121:4: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:122:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:122:5: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:123:6: lv_spielzeuge_6_0= ruleSpielzeug
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_ruleSpielplatz317);
                    	    ruleSpielzeug();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:133:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:133:4: ( (lv_familie_7_0= ruleFamilie ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:134:5: (lv_familie_7_0= ruleFamilie )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:134:5: (lv_familie_7_0= ruleFamilie )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:135:6: lv_familie_7_0= ruleFamilie
                    	    {

                    	    						markComposite(elementTypeProvider.getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_ruleSpielplatz371);
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


                    			markLeaf();
                    		
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpielplatz404); 

                    			doneLeaf(otherlv_8, elementTypeProvider.getSpielplatz_RightCurlyBracketKeyword_5ElementType());
                    		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:156:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:156:14: ( ruleKind EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:157:2: ruleKind EOF
            {
             markComposite(elementTypeProvider.getKindElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKind_in_entryRuleKind425);
            ruleKind();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKind431); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:165:1: ruleKind : (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final void ruleKind() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:165:9: ( (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:166:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:166:2: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:167:3: otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleKind454); 

            			doneLeaf(otherlv_0, elementTypeProvider.getKind_KindKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleKind468); 

            			doneLeaf(otherlv_1, elementTypeProvider.getKind_LeftParenthesisKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:181:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:182:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:182:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:183:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleKind495); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:192:3: ( (lv_age_3_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:193:4: (lv_age_3_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:193:4: (lv_age_3_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:194:5: lv_age_3_0= RULE_INT
            {

            					markLeaf();
            				
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleKind533); 

            					doneLeaf(lv_age_3_0, elementTypeProvider.getKind_AgeINTTerminalRuleCall_3_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleKind558); 

            			doneLeaf(otherlv_4, elementTypeProvider.getKind_RightParenthesisKeyword_4ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:214:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:214:21: ( ruleErwachsener EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:215:2: ruleErwachsener EOF
            {
             markComposite(elementTypeProvider.getErwachsenerElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_entryRuleErwachsener578);
            ruleErwachsener();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleErwachsener584); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:223:1: ruleErwachsener : (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final void ruleErwachsener() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:223:16: ( (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:224:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:224:2: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:225:3: otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleErwachsener607); 

            			doneLeaf(otherlv_0, elementTypeProvider.getErwachsener_ErwachsenerKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleErwachsener621); 

            			doneLeaf(otherlv_1, elementTypeProvider.getErwachsener_LeftParenthesisKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:239:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:240:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:240:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:241:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleErwachsener648); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:250:3: ( (lv_age_3_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:251:4: (lv_age_3_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:251:4: (lv_age_3_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:252:5: lv_age_3_0= RULE_INT
            {

            					markLeaf();
            				
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleErwachsener686); 

            					doneLeaf(lv_age_3_0, elementTypeProvider.getErwachsener_AgeINTTerminalRuleCall_3_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleErwachsener711); 

            			doneLeaf(otherlv_4, elementTypeProvider.getErwachsener_RightParenthesisKeyword_4ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:272:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:272:19: ( ruleSpielzeug EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:273:2: ruleSpielzeug EOF
            {
             markComposite(elementTypeProvider.getSpielzeugElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug731);
            ruleSpielzeug();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpielzeug737); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:281:1: ruleSpielzeug : (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) ;
    public final void ruleSpielzeug() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:281:14: ( (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:282:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:282:2: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:283:3: otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSpielzeug760); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSpielzeug_SpielzeugKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSpielzeug774); 

            			doneLeaf(otherlv_1, elementTypeProvider.getSpielzeug_LeftParenthesisKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:297:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:298:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:298:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:299:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpielzeug801); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getSpielzeug_NameIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:308:3: ( (lv_farbe_3_0= ruleFarbe ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:309:4: (lv_farbe_3_0= ruleFarbe )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:309:4: (lv_farbe_3_0= ruleFarbe )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:310:5: lv_farbe_3_0= ruleFarbe
            {

            					markComposite(elementTypeProvider.getSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_ruleSpielzeug839);
            ruleFarbe();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSpielzeug864); 

            			doneLeaf(otherlv_4, elementTypeProvider.getSpielzeug_RightParenthesisKeyword_4ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:330:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:330:15: ( ruleFarbe EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:331:2: ruleFarbe EOF
            {
             markComposite(elementTypeProvider.getFarbeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_entryRuleFarbe884);
            ruleFarbe();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFarbe890); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:339:1: ruleFarbe : ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) ;
    public final void ruleFarbe() throws RecognitionException {
        Token lv_wert_0_1=null;
        Token lv_wert_0_2=null;
        Token lv_wert_0_3=null;
        Token lv_wert_0_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:339:10: ( ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:340:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:340:2: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:341:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:341:3: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:342:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:342:4: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:343:5: lv_wert_0_1= 'ROT'
                    {

                    					markLeaf();
                    				
                    lv_wert_0_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFarbe926); 

                    					doneLeaf(lv_wert_0_1, elementTypeProvider.getFarbe_WertROTKeyword_0_0ElementType());
                    				

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:351:5: lv_wert_0_2= 'BLAU'
                    {

                    					markLeaf();
                    				
                    lv_wert_0_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFarbe956); 

                    					doneLeaf(lv_wert_0_2, elementTypeProvider.getFarbe_WertBLAUKeyword_0_1ElementType());
                    				

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:359:5: lv_wert_0_3= 'GELB'
                    {

                    					markLeaf();
                    				
                    lv_wert_0_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFarbe986); 

                    					doneLeaf(lv_wert_0_3, elementTypeProvider.getFarbe_WertGELBKeyword_0_2ElementType());
                    				

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:367:5: lv_wert_0_4= 'GR\\u00DCN'
                    {

                    					markLeaf();
                    				
                    lv_wert_0_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFarbe1016); 

                    					doneLeaf(lv_wert_0_4, elementTypeProvider.getFarbe_WertGRÜNKeyword_0_3ElementType());
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:380:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:380:17: ( ruleFamilie EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:381:2: ruleFamilie EOF
            {
             markComposite(elementTypeProvider.getFamilieElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_entryRuleFamilie1047);
            ruleFamilie();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFamilie1053); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:389:1: ruleFamilie : (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:389:12: ( (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:390:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:390:2: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:391:3: otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFamilie1076); 

            			doneLeaf(otherlv_0, elementTypeProvider.getFamilie_FamilieKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFamilie1090); 

            			doneLeaf(otherlv_1, elementTypeProvider.getFamilie_LeftParenthesisKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:405:3: ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:406:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:406:4: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:407:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:407:5: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:408:6: lv_name_2_1= 'keyword'
                    {

                    						markLeaf();
                    					
                    lv_name_2_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleFamilie1125); 

                    						doneLeaf(lv_name_2_1, elementTypeProvider.getFamilie_NameKeywordKeyword_2_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:416:6: lv_name_2_2= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_name_2_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFamilie1159); 

                    						doneLeaf(lv_name_2_2, elementTypeProvider.getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:424:6: lv_name_2_3= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_2_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1193); 

                    						doneLeaf(lv_name_2_3, elementTypeProvider.getFamilie_NameIDTerminalRuleCall_2_0_2ElementType());
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:434:3: ( (otherlv_3= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:435:4: (otherlv_3= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:435:4: (otherlv_3= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:436:5: otherlv_3= RULE_ID
            {

            					markLeaf();
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1238); 

            					doneLeaf(otherlv_3, elementTypeProvider.getFamilie_MutterErwachsenerCrossReference_3_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:445:3: ( (otherlv_4= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:446:4: (otherlv_4= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:446:4: (otherlv_4= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:447:5: otherlv_4= RULE_ID
            {

            					markLeaf();
            				
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1276); 

            					doneLeaf(otherlv_4, elementTypeProvider.getFamilie_VaterErwachsenerCrossReference_4_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:456:3: ( (otherlv_5= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:457:4: (otherlv_5= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:457:4: (otherlv_5= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:458:5: otherlv_5= RULE_ID
            {

            					markLeaf();
            				
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1314); 

            					doneLeaf(otherlv_5, elementTypeProvider.getFamilie_KinderKindCrossReference_5_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:467:3: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:468:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleFamilie1345); 

            	    				doneLeaf(otherlv_6, elementTypeProvider.getFamilie_CommaKeyword_6_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:475:4: ( (otherlv_7= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:476:5: (otherlv_7= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:476:5: (otherlv_7= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalReferenceGrammarTestLanguage.g:477:6: otherlv_7= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1377); 

            	    						doneLeaf(otherlv_7, elementTypeProvider.getFamilie_KinderKindCrossReference_6_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFamilie1410); 

            			doneLeaf(otherlv_8, elementTypeProvider.getFamilie_RightParenthesisKeyword_7ElementType());
            		

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
        public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSpielplatz83 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz110 = new BitSet(new long[]{0x0000000000001020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz148 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSpielplatz174 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz209 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz263 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz317 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz371 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_13_in_ruleSpielplatz404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKind_in_entryRuleKind425 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKind431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleKind454 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleKind468 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleKind495 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleKind533 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleKind558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener578 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleErwachsener607 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleErwachsener621 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener648 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener686 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleErwachsener711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug731 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSpielzeug760 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSpielzeug774 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug801 = new BitSet(new long[]{0x0000000000780000L});
        public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug839 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSpielzeug864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe884 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFarbe890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleFarbe926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleFarbe956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleFarbe986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleFarbe1016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie1047 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFamilie1053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleFamilie1076 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleFamilie1090 = new BitSet(new long[]{0x0000000001000060L});
        public static final BitSet FOLLOW_24_in_ruleFamilie1125 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1159 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1193 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1238 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1276 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1314 = new BitSet(new long[]{0x0000000002010000L});
        public static final BitSet FOLLOW_25_in_ruleFamilie1345 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1377 = new BitSet(new long[]{0x0000000002010000L});
        public static final BitSet FOLLOW_16_in_ruleFamilie1410 = new BitSet(new long[]{0x0000000000000002L});
    }


}