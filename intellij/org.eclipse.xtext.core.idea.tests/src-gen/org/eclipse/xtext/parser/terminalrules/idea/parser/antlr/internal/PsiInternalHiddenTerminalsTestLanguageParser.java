package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalHiddenTerminalsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'without'", "'hiddens'", "';'", "'with'", "'overriding'", "'('", "')'", "'call'", "'inheriting'", "'datatype'", "'rule'", "'hiding'"
    };
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=7;
    public static final int T__10=10;
    public static final int RULE_WS=4;
    public static final int RULE_SL_COMMENT=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int RULE_ML_COMMENT=5;

    // delegates
    // delegators


        public PsiInternalHiddenTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalHiddenTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalHiddenTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g"; }



    private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;

    private HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalHiddenTerminalsTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:49:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:49:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:50:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:58:1: ruleModel : ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:58:10: ( ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:59:2: ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:59:2: ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 8:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:60:3: ruleWithoutHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_WithoutHiddensParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_ruleModel81);
                    ruleWithoutHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:68:3: ruleWithHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_WithHiddensParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_ruleModel101);
                    ruleWithHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:76:3: ruleOverridingHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_OverridingHiddensParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_ruleModel121);
                    ruleOverridingHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:84:3: ruleInheritingHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_InheritingHiddensParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_ruleModel141);
                    ruleInheritingHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:92:3: ruleDatatypeHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeHiddensParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_ruleModel161);
                    ruleDatatypeHiddens();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWithoutHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:103:1: entryRuleWithoutHiddens : ruleWithoutHiddens EOF ;
    public final void entryRuleWithoutHiddens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:103:24: ( ruleWithoutHiddens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:104:2: ruleWithoutHiddens EOF
            {
             markComposite(elementTypeProvider.getWithoutHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens181);
            ruleWithoutHiddens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithoutHiddens187); 

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
    // $ANTLR end "entryRuleWithoutHiddens"


    // $ANTLR start "ruleWithoutHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:112:1: ruleWithoutHiddens : (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) ;
    public final void ruleWithoutHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token otherlv_2=null;
        Token lv_spaces_3_0=null;
        Token lv_valid_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:112:19: ( (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:113:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:113:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:114:3: otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleWithoutHiddens210); 

            			doneLeaf(otherlv_0, elementTypeProvider.getWithoutHiddens_WithoutKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:121:3: ( (lv_spaces_1_0= RULE_WS ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:122:4: (lv_spaces_1_0= RULE_WS )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:122:4: (lv_spaces_1_0= RULE_WS )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:123:5: lv_spaces_1_0= RULE_WS
            {

            					markLeaf();
            				
            lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens237); 

            					doneLeaf(lv_spaces_1_0, elementTypeProvider.getWithoutHiddens_SpacesWSTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleWithoutHiddens262); 

            			doneLeaf(otherlv_2, elementTypeProvider.getWithoutHiddens_HiddensKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:139:3: ( (lv_spaces_3_0= RULE_WS ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:140:4: (lv_spaces_3_0= RULE_WS )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:140:4: (lv_spaces_3_0= RULE_WS )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:141:5: lv_spaces_3_0= RULE_WS
                    {

                    					markLeaf();
                    				
                    lv_spaces_3_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens289); 

                    					doneLeaf(lv_spaces_3_0, elementTypeProvider.getWithoutHiddens_SpacesWSTerminalRuleCall_3_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:150:3: ( (lv_valid_4_0= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:151:4: (lv_valid_4_0= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:151:4: (lv_valid_4_0= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:152:5: lv_valid_4_0= ';'
            {

            					markLeaf();
            				
            lv_valid_4_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleWithoutHiddens328); 

            					doneLeaf(lv_valid_4_0, elementTypeProvider.getWithoutHiddens_ValidSemicolonKeyword_4_0ElementType());
            				

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
    // $ANTLR end "ruleWithoutHiddens"


    // $ANTLR start "entryRuleWithHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:165:1: entryRuleWithHiddens : ruleWithHiddens EOF ;
    public final void entryRuleWithHiddens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:165:21: ( ruleWithHiddens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:166:2: ruleWithHiddens EOF
            {
             markComposite(elementTypeProvider.getWithHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens359);
            ruleWithHiddens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithHiddens365); 

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
    // $ANTLR end "entryRuleWithHiddens"


    // $ANTLR start "ruleWithHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:174:1: ruleWithHiddens : (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) ;
    public final void ruleWithHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_valid_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:174:16: ( (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:175:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:175:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:176:3: otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleWithHiddens388); 

            			doneLeaf(otherlv_0, elementTypeProvider.getWithHiddens_WithKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleWithHiddens402); 

            			doneLeaf(otherlv_1, elementTypeProvider.getWithHiddens_HiddensKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:190:3: ( (lv_valid_2_0= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:191:4: (lv_valid_2_0= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:191:4: (lv_valid_2_0= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:192:5: lv_valid_2_0= ';'
            {

            					markLeaf();
            				
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleWithHiddens429); 

            					doneLeaf(lv_valid_2_0, elementTypeProvider.getWithHiddens_ValidSemicolonKeyword_2_0ElementType());
            				

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
    // $ANTLR end "ruleWithHiddens"


    // $ANTLR start "entryRuleOverridingHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:205:1: entryRuleOverridingHiddens : ruleOverridingHiddens EOF ;
    public final void entryRuleOverridingHiddens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:205:27: ( ruleOverridingHiddens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:206:2: ruleOverridingHiddens EOF
            {
             markComposite(elementTypeProvider.getOverridingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens460);
            ruleOverridingHiddens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddens466); 

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
    // $ANTLR end "entryRuleOverridingHiddens"


    // $ANTLR start "ruleOverridingHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:214:1: ruleOverridingHiddens : (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) ;
    public final void ruleOverridingHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_valid_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:214:22: ( (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:215:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:215:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:216:3: otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleOverridingHiddens489); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOverridingHiddens_OverridingKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleOverridingHiddens503); 

            			doneLeaf(otherlv_1, elementTypeProvider.getOverridingHiddens_HiddensKeyword_1ElementType());
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOverridingHiddens517); 

            			doneLeaf(otherlv_2, elementTypeProvider.getOverridingHiddens_LeftParenthesisKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:237:3: ( (lv_called_3_0= ruleOverridingHiddensCall ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:238:4: (lv_called_3_0= ruleOverridingHiddensCall )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:238:4: (lv_called_3_0= ruleOverridingHiddensCall )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:239:5: lv_called_3_0= ruleOverridingHiddensCall
            {

            					markComposite(elementTypeProvider.getOverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens544);
            ruleOverridingHiddensCall();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOverridingHiddens569); 

            			doneLeaf(otherlv_4, elementTypeProvider.getOverridingHiddens_RightParenthesisKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:255:3: ( (lv_valid_5_0= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:256:4: (lv_valid_5_0= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:256:4: (lv_valid_5_0= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:257:5: lv_valid_5_0= ';'
            {

            					markLeaf();
            				
            lv_valid_5_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddens596); 

            					doneLeaf(lv_valid_5_0, elementTypeProvider.getOverridingHiddens_ValidSemicolonKeyword_5_0ElementType());
            				

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
    // $ANTLR end "ruleOverridingHiddens"


    // $ANTLR start "entryRuleOverridingHiddensCall"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:270:1: entryRuleOverridingHiddensCall : ruleOverridingHiddensCall EOF ;
    public final void entryRuleOverridingHiddensCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:270:31: ( ruleOverridingHiddensCall EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:271:2: ruleOverridingHiddensCall EOF
            {
             markComposite(elementTypeProvider.getOverridingHiddensCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall627);
            ruleOverridingHiddensCall();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddensCall633); 

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
    // $ANTLR end "entryRuleOverridingHiddensCall"


    // $ANTLR start "ruleOverridingHiddensCall"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:279:1: ruleOverridingHiddensCall : (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) ;
    public final void ruleOverridingHiddensCall() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token lv_valid_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:279:26: ( (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:280:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:280:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:281:3: otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOverridingHiddensCall656); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOverridingHiddensCall_CallKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:288:3: ( (lv_spaces_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:289:4: (lv_spaces_1_0= RULE_WS )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:289:4: (lv_spaces_1_0= RULE_WS )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:290:5: lv_spaces_1_0= RULE_WS
                    {

                    					markLeaf();
                    				
                    lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleOverridingHiddensCall683); 

                    					doneLeaf(lv_spaces_1_0, elementTypeProvider.getOverridingHiddensCall_SpacesWSTerminalRuleCall_1_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:299:3: ( (lv_valid_2_0= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:300:4: (lv_valid_2_0= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:300:4: (lv_valid_2_0= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:301:5: lv_valid_2_0= ';'
            {

            					markLeaf();
            				
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddensCall722); 

            					doneLeaf(lv_valid_2_0, elementTypeProvider.getOverridingHiddensCall_ValidSemicolonKeyword_2_0ElementType());
            				

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
    // $ANTLR end "ruleOverridingHiddensCall"


    // $ANTLR start "entryRuleInheritingHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:314:1: entryRuleInheritingHiddens : ruleInheritingHiddens EOF ;
    public final void entryRuleInheritingHiddens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:314:27: ( ruleInheritingHiddens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:315:2: ruleInheritingHiddens EOF
            {
             markComposite(elementTypeProvider.getInheritingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens753);
            ruleInheritingHiddens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddens759); 

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
    // $ANTLR end "entryRuleInheritingHiddens"


    // $ANTLR start "ruleInheritingHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:323:1: ruleInheritingHiddens : (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) ;
    public final void ruleInheritingHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_valid_6_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:323:22: ( (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:324:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:324:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:325:3: otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleInheritingHiddens782); 

            			doneLeaf(otherlv_0, elementTypeProvider.getInheritingHiddens_InheritingKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleInheritingHiddens796); 

            			doneLeaf(otherlv_1, elementTypeProvider.getInheritingHiddens_HiddensKeyword_1ElementType());
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleInheritingHiddens810); 

            			doneLeaf(otherlv_2, elementTypeProvider.getInheritingHiddens_LeftParenthesisKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:346:3: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:347:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:347:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:348:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:348:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:349:6: lv_called_3_0= ruleInheritingHiddensCall
                    {

                    						markComposite(elementTypeProvider.getInheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens845);
                    ruleInheritingHiddensCall();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:359:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:359:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:360:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:360:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:361:6: lv_hidingCalled_4_0= ruleHidingHiddens
                    {

                    						markComposite(elementTypeProvider.getInheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens899);
                    ruleHidingHiddens();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInheritingHiddens931); 

            			doneLeaf(otherlv_5, elementTypeProvider.getInheritingHiddens_RightParenthesisKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:378:3: ( (lv_valid_6_0= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:379:4: (lv_valid_6_0= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:379:4: (lv_valid_6_0= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:380:5: lv_valid_6_0= ';'
            {

            					markLeaf();
            				
            lv_valid_6_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddens958); 

            					doneLeaf(lv_valid_6_0, elementTypeProvider.getInheritingHiddens_ValidSemicolonKeyword_5_0ElementType());
            				

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
    // $ANTLR end "ruleInheritingHiddens"


    // $ANTLR start "entryRuleDatatypeHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:393:1: entryRuleDatatypeHiddens : ruleDatatypeHiddens EOF ;
    public final void entryRuleDatatypeHiddens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:393:25: ( ruleDatatypeHiddens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:394:2: ruleDatatypeHiddens EOF
            {
             markComposite(elementTypeProvider.getDatatypeHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens989);
            ruleDatatypeHiddens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeHiddens995); 

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
    // $ANTLR end "entryRuleDatatypeHiddens"


    // $ANTLR start "ruleDatatypeHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:402:1: ruleDatatypeHiddens : (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) ;
    public final void ruleDatatypeHiddens() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:402:20: ( (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:403:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:403:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:404:3: otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDatatypeHiddens1018); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatypeHiddens_DatatypeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:411:3: ( (lv_valid_1_0= ruleDatatypeRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:412:4: (lv_valid_1_0= ruleDatatypeRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:412:4: (lv_valid_1_0= ruleDatatypeRule )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:413:5: lv_valid_1_0= ruleDatatypeRule
            {

            					markComposite(elementTypeProvider.getDatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1045);
            ruleDatatypeRule();

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
    // $ANTLR end "ruleDatatypeHiddens"


    // $ANTLR start "entryRuleDatatypeRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:426:1: entryRuleDatatypeRule : ruleDatatypeRule EOF ;
    public final void entryRuleDatatypeRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:426:22: ( ruleDatatypeRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:427:2: ruleDatatypeRule EOF
            {
             markComposite(elementTypeProvider.getDatatypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1076);
            ruleDatatypeRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeRule1082); 

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
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:435:1: ruleDatatypeRule : (kw= 'rule' kw= ';' ) ;
    public final void ruleDatatypeRule() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:435:17: ( (kw= 'rule' kw= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:436:2: (kw= 'rule' kw= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:436:2: (kw= 'rule' kw= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:437:3: kw= 'rule' kw= ';'
            {

            			markLeaf();
            		
            kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleDatatypeRule1105); 

            			doneLeaf(kw, elementTypeProvider.getDatatypeRule_RuleKeyword_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleDatatypeRule1119); 

            			doneLeaf(kw, elementTypeProvider.getDatatypeRule_SemicolonKeyword_1ElementType());
            		

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
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleHidingHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:455:1: entryRuleHidingHiddens : ruleHidingHiddens EOF ;
    public final void entryRuleHidingHiddens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:455:23: ( ruleHidingHiddens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:456:2: ruleHidingHiddens EOF
            {
             markComposite(elementTypeProvider.getHidingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1139);
            ruleHidingHiddens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHidingHiddens1145); 

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
    // $ANTLR end "entryRuleHidingHiddens"


    // $ANTLR start "ruleHidingHiddens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:464:1: ruleHidingHiddens : (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) ;
    public final void ruleHidingHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_space_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:464:18: ( (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:465:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:465:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:466:3: otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleHidingHiddens1168); 

            			doneLeaf(otherlv_0, elementTypeProvider.getHidingHiddens_HidingKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:473:3: ( (lv_space_1_0= RULE_WS ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:474:4: (lv_space_1_0= RULE_WS )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:474:4: (lv_space_1_0= RULE_WS )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:475:5: lv_space_1_0= RULE_WS
            {

            					markLeaf();
            				
            lv_space_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleHidingHiddens1195); 

            					doneLeaf(lv_space_1_0, elementTypeProvider.getHidingHiddens_SpaceWSTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:484:3: ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:485:4: (lv_called_2_0= ruleInheritingHiddensCall )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:485:4: (lv_called_2_0= ruleInheritingHiddensCall )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:486:5: lv_called_2_0= ruleInheritingHiddensCall
            {

            					markComposite(elementTypeProvider.getHidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1233);
            ruleInheritingHiddensCall();

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
    // $ANTLR end "ruleHidingHiddens"


    // $ANTLR start "entryRuleInheritingHiddensCall"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:499:1: entryRuleInheritingHiddensCall : ruleInheritingHiddensCall EOF ;
    public final void entryRuleInheritingHiddensCall() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:499:31: ( ruleInheritingHiddensCall EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:500:2: ruleInheritingHiddensCall EOF
            {
             markComposite(elementTypeProvider.getInheritingHiddensCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1264);
            ruleInheritingHiddensCall();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddensCall1270); 

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
    // $ANTLR end "entryRuleInheritingHiddensCall"


    // $ANTLR start "ruleInheritingHiddensCall"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:508:1: ruleInheritingHiddensCall : (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) ;
    public final void ruleInheritingHiddensCall() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_valid_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:508:26: ( (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:509:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:509:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:510:3: otherlv_0= 'call' ( (lv_valid_1_0= ';' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInheritingHiddensCall1293); 

            			doneLeaf(otherlv_0, elementTypeProvider.getInheritingHiddensCall_CallKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:517:3: ( (lv_valid_1_0= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:518:4: (lv_valid_1_0= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:518:4: (lv_valid_1_0= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalHiddenTerminalsTestLanguage.g:519:5: lv_valid_1_0= ';'
            {

            					markLeaf();
            				
            lv_valid_1_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddensCall1320); 

            					doneLeaf(lv_valid_1_0, elementTypeProvider.getInheritingHiddensCall_ValidSemicolonKeyword_1_0ElementType());
            				

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
    // $ANTLR end "ruleInheritingHiddensCall"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_ruleModel81 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_ruleModel101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_ruleModel121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_ruleModel141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_ruleModel161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithoutHiddens187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_ruleWithoutHiddens210 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens237 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithoutHiddens262 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens289 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithoutHiddens328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens359 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithHiddens365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleWithHiddens388 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithHiddens402 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithHiddens429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens460 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddens466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleOverridingHiddens489 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleOverridingHiddens503 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOverridingHiddens517 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens544 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOverridingHiddens569 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddens596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall627 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddensCall633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleOverridingHiddensCall656 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleOverridingHiddensCall683 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddensCall722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens753 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddens759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleInheritingHiddens782 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleInheritingHiddens796 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleInheritingHiddens810 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens845 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens899 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleInheritingHiddens931 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddens958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens989 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeHiddens995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDatatypeHiddens1018 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1076 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule1082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleDatatypeRule1105 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleDatatypeRule1119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1139 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHidingHiddens1145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleHidingHiddens1168 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleHidingHiddens1195 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1264 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddensCall1270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleInheritingHiddensCall1293 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddensCall1320 = new BitSet(new long[]{0x0000000000000002L});
    }


}