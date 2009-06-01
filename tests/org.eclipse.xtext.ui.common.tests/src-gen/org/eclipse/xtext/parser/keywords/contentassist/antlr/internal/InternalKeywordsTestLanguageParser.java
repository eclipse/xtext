package org.eclipse.xtext.parser.keywords.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalKeywordsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo\\\\bar'", "'foo\\\\'", "'\\\\bar'", "'\\\\'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalKeywordsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g"; }


     
     	private KeywordsTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(KeywordsTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:55:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:55:16: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:56:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:63:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:67:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:68:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:68:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:69:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:70:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:70:2: rule__Model__Alternatives
            {
            pushFollow(FOLLOW_rule__Model__Alternatives_in_ruleModel94);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:81:1: rule__Model__Alternatives : ( ( ( ( ( 'foo\\\\bar' ) ) ) ) | ( ( ( ( 'foo\\\\' ) ) ) ) | ( ( ( ( '\\\\bar' ) ) ) ) | ( ( ( ( '\\\\' ) ) ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:85:1: ( ( ( ( ( 'foo\\\\bar' ) ) ) ) | ( ( ( ( 'foo\\\\' ) ) ) ) | ( ( ( ( '\\\\bar' ) ) ) ) | ( ( ( ( '\\\\' ) ) ) ) )
            int alt1=4;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("81:1: rule__Model__Alternatives : ( ( ( ( ( 'foo\\\\bar' ) ) ) ) | ( ( ( ( 'foo\\\\' ) ) ) ) | ( ( ( ( '\\\\bar' ) ) ) ) | ( ( ( ( '\\\\' ) ) ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:86:1: ( ( ( ( 'foo\\\\bar' ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:86:1: ( ( ( ( 'foo\\\\bar' ) ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:87:1: ( ( ( 'foo\\\\bar' ) ) )
                    {
                     before(grammarAccess.getModelAccess().getFirstAssignment_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:88:1: ( ( ( 'foo\\\\bar' ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:89:1: ( ( 'foo\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:89:1: ( ( 'foo\\\\bar' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:90:1: ( 'foo\\\\bar' )
                    {
                     before(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:91:1: ( 'foo\\\\bar' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:92:1: 'foo\\\\bar'
                    {
                     before(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__Model__Alternatives141); 
                     after(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 

                    }

                     after(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0()); 

                    }


                    }

                     after(grammarAccess.getModelAccess().getFirstAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:104:6: ( ( ( ( 'foo\\\\' ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:104:6: ( ( ( ( 'foo\\\\' ) ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:105:1: ( ( ( 'foo\\\\' ) ) )
                    {
                     before(grammarAccess.getModelAccess().getSecondAssignment_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:106:1: ( ( ( 'foo\\\\' ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:107:1: ( ( 'foo\\\\' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:107:1: ( ( 'foo\\\\' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:108:1: ( 'foo\\\\' )
                    {
                     before(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:109:1: ( 'foo\\\\' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:110:1: 'foo\\\\'
                    {
                     before(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 
                    match(input,12,FOLLOW_12_in_rule__Model__Alternatives183); 
                     after(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 

                    }

                     after(grammarAccess.getModelAccess().getSecondFooKeyword_1_0()); 

                    }


                    }

                     after(grammarAccess.getModelAccess().getSecondAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:122:6: ( ( ( ( '\\\\bar' ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:122:6: ( ( ( ( '\\\\bar' ) ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:123:1: ( ( ( '\\\\bar' ) ) )
                    {
                     before(grammarAccess.getModelAccess().getThirdAssignment_2()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:124:1: ( ( ( '\\\\bar' ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:125:1: ( ( '\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:125:1: ( ( '\\\\bar' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:126:1: ( '\\\\bar' )
                    {
                     before(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:127:1: ( '\\\\bar' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:128:1: '\\\\bar'
                    {
                     before(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 
                    match(input,13,FOLLOW_13_in_rule__Model__Alternatives225); 
                     after(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 

                    }

                     after(grammarAccess.getModelAccess().getThirdBarKeyword_2_0()); 

                    }


                    }

                     after(grammarAccess.getModelAccess().getThirdAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:140:6: ( ( ( ( '\\\\' ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:140:6: ( ( ( ( '\\\\' ) ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:141:1: ( ( ( '\\\\' ) ) )
                    {
                     before(grammarAccess.getModelAccess().getForthAssignment_3()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:142:1: ( ( ( '\\\\' ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:143:1: ( ( '\\\\' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:143:1: ( ( '\\\\' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:144:1: ( '\\\\' )
                    {
                     before(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:145:1: ( '\\\\' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g:146:1: '\\\\'
                    {
                     before(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 
                    match(input,14,FOLLOW_14_in_rule__Model__Alternatives267); 
                     after(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 

                    }

                     after(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0()); 

                    }


                    }

                     after(grammarAccess.getModelAccess().getForthAssignment_3()); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Model__Alternatives141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Model__Alternatives183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Model__Alternatives225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Model__Alternatives267 = new BitSet(new long[]{0x0000000000000002L});

}