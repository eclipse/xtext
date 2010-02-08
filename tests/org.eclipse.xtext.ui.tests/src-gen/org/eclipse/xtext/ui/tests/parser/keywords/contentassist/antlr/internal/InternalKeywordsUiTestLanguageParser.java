package org.eclipse.xtext.ui.tests.parser.keywords.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.tests.parser.keywords.services.KeywordsUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalKeywordsUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo\\\\bar'", "'foo\\\\'", "'\\\\bar'", "'\\\\'", "'\"a\"'", "'\\'b\\''", "'\\'c\\''", "'\"d\"'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalKeywordsUiTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g"; }


     
     	private KeywordsUiTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(KeywordsUiTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:76:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:76:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel94);
            rule__Model__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start rule__Model__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:88:1: rule__Model__Alternatives : ( ( ( rule__Model__FirstAssignment_0 ) ) | ( ( rule__Model__SecondAssignment_1 ) ) | ( ( rule__Model__ThirdAssignment_2 ) ) | ( ( rule__Model__ForthAssignment_3 ) ) | ( ( rule__Model__FifthAssignment_4 ) ) | ( ( rule__Model__SixthAssignment_5 ) ) | ( ( rule__Model__SeventhAssignment_6 ) ) | ( ( rule__Model__EighthAssignment_7 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:92:1: ( ( ( rule__Model__FirstAssignment_0 ) ) | ( ( rule__Model__SecondAssignment_1 ) ) | ( ( rule__Model__ThirdAssignment_2 ) ) | ( ( rule__Model__ForthAssignment_3 ) ) | ( ( rule__Model__FifthAssignment_4 ) ) | ( ( rule__Model__SixthAssignment_5 ) ) | ( ( rule__Model__SeventhAssignment_6 ) ) | ( ( rule__Model__EighthAssignment_7 ) ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
                }
                break;
            case 16:
                {
                alt1=6;
                }
                break;
            case 17:
                {
                alt1=7;
                }
                break;
            case 18:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("88:1: rule__Model__Alternatives : ( ( ( rule__Model__FirstAssignment_0 ) ) | ( ( rule__Model__SecondAssignment_1 ) ) | ( ( rule__Model__ThirdAssignment_2 ) ) | ( ( rule__Model__ForthAssignment_3 ) ) | ( ( rule__Model__FifthAssignment_4 ) ) | ( ( rule__Model__SixthAssignment_5 ) ) | ( ( rule__Model__SeventhAssignment_6 ) ) | ( ( rule__Model__EighthAssignment_7 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:93:1: ( ( rule__Model__FirstAssignment_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:93:1: ( ( rule__Model__FirstAssignment_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:94:1: ( rule__Model__FirstAssignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getFirstAssignment_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:95:1: ( rule__Model__FirstAssignment_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:95:2: rule__Model__FirstAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__FirstAssignment_0_in_rule__Model__Alternatives130);
                    rule__Model__FirstAssignment_0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getFirstAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:99:6: ( ( rule__Model__SecondAssignment_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:99:6: ( ( rule__Model__SecondAssignment_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:100:1: ( rule__Model__SecondAssignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getSecondAssignment_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:101:1: ( rule__Model__SecondAssignment_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:101:2: rule__Model__SecondAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__SecondAssignment_1_in_rule__Model__Alternatives148);
                    rule__Model__SecondAssignment_1();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getSecondAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:105:6: ( ( rule__Model__ThirdAssignment_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:105:6: ( ( rule__Model__ThirdAssignment_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:106:1: ( rule__Model__ThirdAssignment_2 )
                    {
                     before(grammarAccess.getModelAccess().getThirdAssignment_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:107:1: ( rule__Model__ThirdAssignment_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:107:2: rule__Model__ThirdAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__ThirdAssignment_2_in_rule__Model__Alternatives166);
                    rule__Model__ThirdAssignment_2();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getThirdAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:111:6: ( ( rule__Model__ForthAssignment_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:111:6: ( ( rule__Model__ForthAssignment_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:112:1: ( rule__Model__ForthAssignment_3 )
                    {
                     before(grammarAccess.getModelAccess().getForthAssignment_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:113:1: ( rule__Model__ForthAssignment_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:113:2: rule__Model__ForthAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__ForthAssignment_3_in_rule__Model__Alternatives184);
                    rule__Model__ForthAssignment_3();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getForthAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:117:6: ( ( rule__Model__FifthAssignment_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:117:6: ( ( rule__Model__FifthAssignment_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:118:1: ( rule__Model__FifthAssignment_4 )
                    {
                     before(grammarAccess.getModelAccess().getFifthAssignment_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:119:1: ( rule__Model__FifthAssignment_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:119:2: rule__Model__FifthAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__FifthAssignment_4_in_rule__Model__Alternatives202);
                    rule__Model__FifthAssignment_4();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getFifthAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:123:6: ( ( rule__Model__SixthAssignment_5 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:123:6: ( ( rule__Model__SixthAssignment_5 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:124:1: ( rule__Model__SixthAssignment_5 )
                    {
                     before(grammarAccess.getModelAccess().getSixthAssignment_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:125:1: ( rule__Model__SixthAssignment_5 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:125:2: rule__Model__SixthAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__SixthAssignment_5_in_rule__Model__Alternatives220);
                    rule__Model__SixthAssignment_5();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getSixthAssignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:129:6: ( ( rule__Model__SeventhAssignment_6 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:129:6: ( ( rule__Model__SeventhAssignment_6 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:130:1: ( rule__Model__SeventhAssignment_6 )
                    {
                     before(grammarAccess.getModelAccess().getSeventhAssignment_6()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:131:1: ( rule__Model__SeventhAssignment_6 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:131:2: rule__Model__SeventhAssignment_6
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__SeventhAssignment_6_in_rule__Model__Alternatives238);
                    rule__Model__SeventhAssignment_6();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getSeventhAssignment_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:135:6: ( ( rule__Model__EighthAssignment_7 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:135:6: ( ( rule__Model__EighthAssignment_7 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:136:1: ( rule__Model__EighthAssignment_7 )
                    {
                     before(grammarAccess.getModelAccess().getEighthAssignment_7()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:137:1: ( rule__Model__EighthAssignment_7 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:137:2: rule__Model__EighthAssignment_7
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__EighthAssignment_7_in_rule__Model__Alternatives256);
                    rule__Model__EighthAssignment_7();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getEighthAssignment_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Alternatives


    // $ANTLR start rule__Model__FirstAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:149:1: rule__Model__FirstAssignment_0 : ( ( 'foo\\\\bar' ) ) ;
    public final void rule__Model__FirstAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:153:1: ( ( ( 'foo\\\\bar' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:154:1: ( ( 'foo\\\\bar' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:154:1: ( ( 'foo\\\\bar' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:155:1: ( 'foo\\\\bar' )
            {
             before(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:156:1: ( 'foo\\\\bar' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:157:1: 'foo\\\\bar'
            {
             before(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Model__FirstAssignment_0297); 
             after(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 

            }

             after(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__FirstAssignment_0


    // $ANTLR start rule__Model__SecondAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:172:1: rule__Model__SecondAssignment_1 : ( ( 'foo\\\\' ) ) ;
    public final void rule__Model__SecondAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:176:1: ( ( ( 'foo\\\\' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:177:1: ( ( 'foo\\\\' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:177:1: ( ( 'foo\\\\' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:178:1: ( 'foo\\\\' )
            {
             before(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:179:1: ( 'foo\\\\' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:180:1: 'foo\\\\'
            {
             before(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__SecondAssignment_1341); 
             after(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 

            }

             after(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__SecondAssignment_1


    // $ANTLR start rule__Model__ThirdAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:195:1: rule__Model__ThirdAssignment_2 : ( ( '\\\\bar' ) ) ;
    public final void rule__Model__ThirdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:199:1: ( ( ( '\\\\bar' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:200:1: ( ( '\\\\bar' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:200:1: ( ( '\\\\bar' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:201:1: ( '\\\\bar' )
            {
             before(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:202:1: ( '\\\\bar' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:203:1: '\\\\bar'
            {
             before(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__ThirdAssignment_2385); 
             after(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 

            }

             after(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ThirdAssignment_2


    // $ANTLR start rule__Model__ForthAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:218:1: rule__Model__ForthAssignment_3 : ( ( '\\\\' ) ) ;
    public final void rule__Model__ForthAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:222:1: ( ( ( '\\\\' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:223:1: ( ( '\\\\' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:223:1: ( ( '\\\\' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:224:1: ( '\\\\' )
            {
             before(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:225:1: ( '\\\\' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:226:1: '\\\\'
            {
             before(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__ForthAssignment_3429); 
             after(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 

            }

             after(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ForthAssignment_3


    // $ANTLR start rule__Model__FifthAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:241:1: rule__Model__FifthAssignment_4 : ( ( '\"a\"' ) ) ;
    public final void rule__Model__FifthAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:245:1: ( ( ( '\"a\"' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:246:1: ( ( '\"a\"' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:246:1: ( ( '\"a\"' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:247:1: ( '\"a\"' )
            {
             before(grammarAccess.getModelAccess().getFifthAKeyword_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:248:1: ( '\"a\"' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:249:1: '\"a\"'
            {
             before(grammarAccess.getModelAccess().getFifthAKeyword_4_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__FifthAssignment_4473); 
             after(grammarAccess.getModelAccess().getFifthAKeyword_4_0()); 

            }

             after(grammarAccess.getModelAccess().getFifthAKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__FifthAssignment_4


    // $ANTLR start rule__Model__SixthAssignment_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:264:1: rule__Model__SixthAssignment_5 : ( ( '\\'b\\'' ) ) ;
    public final void rule__Model__SixthAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:268:1: ( ( ( '\\'b\\'' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:269:1: ( ( '\\'b\\'' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:269:1: ( ( '\\'b\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:270:1: ( '\\'b\\'' )
            {
             before(grammarAccess.getModelAccess().getSixthBKeyword_5_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:271:1: ( '\\'b\\'' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:272:1: '\\'b\\''
            {
             before(grammarAccess.getModelAccess().getSixthBKeyword_5_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__SixthAssignment_5517); 
             after(grammarAccess.getModelAccess().getSixthBKeyword_5_0()); 

            }

             after(grammarAccess.getModelAccess().getSixthBKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__SixthAssignment_5


    // $ANTLR start rule__Model__SeventhAssignment_6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:287:1: rule__Model__SeventhAssignment_6 : ( ( '\\'c\\'' ) ) ;
    public final void rule__Model__SeventhAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:291:1: ( ( ( '\\'c\\'' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:292:1: ( ( '\\'c\\'' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:292:1: ( ( '\\'c\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:293:1: ( '\\'c\\'' )
            {
             before(grammarAccess.getModelAccess().getSeventhCKeyword_6_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:294:1: ( '\\'c\\'' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:295:1: '\\'c\\''
            {
             before(grammarAccess.getModelAccess().getSeventhCKeyword_6_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__SeventhAssignment_6561); 
             after(grammarAccess.getModelAccess().getSeventhCKeyword_6_0()); 

            }

             after(grammarAccess.getModelAccess().getSeventhCKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__SeventhAssignment_6


    // $ANTLR start rule__Model__EighthAssignment_7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:310:1: rule__Model__EighthAssignment_7 : ( ( '\"d\"' ) ) ;
    public final void rule__Model__EighthAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:314:1: ( ( ( '\"d\"' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:315:1: ( ( '\"d\"' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:315:1: ( ( '\"d\"' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:316:1: ( '\"d\"' )
            {
             before(grammarAccess.getModelAccess().getEighthDKeyword_7_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:317:1: ( '\"d\"' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g:318:1: '\"d\"'
            {
             before(grammarAccess.getModelAccess().getEighthDKeyword_7_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Model__EighthAssignment_7605); 
             after(grammarAccess.getModelAccess().getEighthDKeyword_7_0()); 

            }

             after(grammarAccess.getModelAccess().getEighthDKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__EighthAssignment_7


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FirstAssignment_0_in_rule__Model__Alternatives130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__SecondAssignment_1_in_rule__Model__Alternatives148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ThirdAssignment_2_in_rule__Model__Alternatives166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ForthAssignment_3_in_rule__Model__Alternatives184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FifthAssignment_4_in_rule__Model__Alternatives202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__SixthAssignment_5_in_rule__Model__Alternatives220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__SeventhAssignment_6_in_rule__Model__Alternatives238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__EighthAssignment_7_in_rule__Model__Alternatives256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Model__FirstAssignment_0297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__SecondAssignment_1341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__ThirdAssignment_2385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__ForthAssignment_3429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__FifthAssignment_4473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__SixthAssignment_5517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__SeventhAssignment_6561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Model__EighthAssignment_7605 = new BitSet(new long[]{0x0000000000000002L});
    }


}