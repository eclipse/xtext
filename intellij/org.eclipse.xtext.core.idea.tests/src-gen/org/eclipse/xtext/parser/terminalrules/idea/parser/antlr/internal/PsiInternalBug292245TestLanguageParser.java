package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.terminalrules.services.Bug292245TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug292245TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_APOSTROPHE_CHAR", "RULE_CHAR", "RULE_WS", "'FIX'", "'ERROR'", "'TICK'", "'^'"
    };
    public static final int RULE_APOSTROPHE_CHAR=4;
    public static final int T__10=10;
    public static final int RULE_CHAR=5;
    public static final int RULE_WS=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;

    // delegates
    // delegators


        public PsiInternalBug292245TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug292245TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug292245TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g"; }



    	protected Bug292245TestLanguageGrammarAccess grammarAccess;

    	protected Bug292245TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug292245TestLanguageParser(PsiBuilder builder, TokenStream input, Bug292245TestLanguageElementTypeProvider elementTypeProvider, Bug292245TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:59:1: ruleModel : ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )* ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:59:10: ( ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:60:2: ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:60:2: ( (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 7:
                    {
                    alt4=1;
                    }
                    break;
                case 8:
                    {
                    alt4=2;
                    }
                    break;
                case 9:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:61:3: (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:61:3: (otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+ )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:62:4: otherlv_0= 'FIX' ( (lv_fix_1_0= ruleFix ) )+
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_0=(Token)match(input,7,FollowSets000.FOLLOW_7_in_ruleModel89); 

            	    				doneLeaf(otherlv_0, elementTypeProvider.getModel_FIXKeyword_0_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:69:4: ( (lv_fix_1_0= ruleFix ) )+
            	    int cnt1=0;
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:70:5: (lv_fix_1_0= ruleFix )
            	    	    {
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:70:5: (lv_fix_1_0= ruleFix )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:71:6: lv_fix_1_0= ruleFix
            	    	    {

            	    	    						markComposite(elementTypeProvider.getModel_FixFixParserRuleCall_0_1_0ElementType());
            	    	    					
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFix_in_ruleModel121);
            	    	    ruleFix();

            	    	    state._fsp--;


            	    	    						doneComposite();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt1 >= 1 ) break loop1;
            	                EarlyExitException eee =
            	                    new EarlyExitException(1, input);
            	                throw eee;
            	        }
            	        cnt1++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:82:3: (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:82:3: (otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+ )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:83:4: otherlv_2= 'ERROR' ( (lv_error_3_0= ruleError ) )+
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleModel168); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getModel_ERRORKeyword_1_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:90:4: ( (lv_error_3_0= ruleError ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:91:5: (lv_error_3_0= ruleError )
            	    	    {
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:91:5: (lv_error_3_0= ruleError )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:92:6: lv_error_3_0= ruleError
            	    	    {

            	    	    						markComposite(elementTypeProvider.getModel_ErrorErrorParserRuleCall_1_1_0ElementType());
            	    	    					
            	    	    pushFollow(FollowSets000.FOLLOW_ruleError_in_ruleModel200);
            	    	    ruleError();

            	    	    state._fsp--;


            	    	    						doneComposite();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:103:3: (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:103:3: (otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:104:4: otherlv_4= 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_4=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleModel247); 

            	    				doneLeaf(otherlv_4, elementTypeProvider.getModel_TICKKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:111:4: ( (lv_tick_5_0= ruleApostrophe ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:112:5: (lv_tick_5_0= ruleApostrophe )
            	    	    {
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:112:5: (lv_tick_5_0= ruleApostrophe )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:113:6: lv_tick_5_0= ruleApostrophe
            	    	    {

            	    	    						markComposite(elementTypeProvider.getModel_TickApostropheParserRuleCall_2_1_0ElementType());
            	    	    					
            	    	    pushFollow(FollowSets000.FOLLOW_ruleApostrophe_in_ruleModel279);
            	    	    ruleApostrophe();

            	    	    state._fsp--;


            	    	    						doneComposite();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


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


    // $ANTLR start "entryRuleError"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:127:1: entryRuleError : ruleError EOF ;
    public final void entryRuleError() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:127:15: ( ruleError EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:128:2: ruleError EOF
            {
             markComposite(elementTypeProvider.getErrorElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_in_entryRuleError319);
            ruleError();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError325); 

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
    // $ANTLR end "entryRuleError"


    // $ANTLR start "ruleError"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:136:1: ruleError : (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ) ;
    public final void ruleError() throws RecognitionException {
        Token this_APOSTROPHE_CHAR_0=null;
        Token this_APOSTROPHE_CHAR_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:136:10: ( (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:137:2: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:137:2: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:138:3: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR
            {

            			markLeaf();
            		
            this_APOSTROPHE_CHAR_0=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError348); 

            			doneLeaf(this_APOSTROPHE_CHAR_0, elementTypeProvider.getError_APOSTROPHE_CHARTerminalRuleCall_0ElementType());
            		

            			markComposite(elementTypeProvider.getError_GraphicalParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_ruleError360);
            ruleGraphical();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            this_APOSTROPHE_CHAR_2=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError374); 

            			doneLeaf(this_APOSTROPHE_CHAR_2, elementTypeProvider.getError_APOSTROPHE_CHARTerminalRuleCall_2ElementType());
            		

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
    // $ANTLR end "ruleError"


    // $ANTLR start "entryRuleFix"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:163:1: entryRuleFix : ruleFix EOF ;
    public final void entryRuleFix() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:163:13: ( ruleFix EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:164:2: ruleFix EOF
            {
             markComposite(elementTypeProvider.getFixElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFix_in_entryRuleFix394);
            ruleFix();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFix400); 

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
    // $ANTLR end "entryRuleFix"


    // $ANTLR start "ruleFix"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:172:1: ruleFix : (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ruleRehide ) ;
    public final void ruleFix() throws RecognitionException {
        Token this_APOSTROPHE_CHAR_0=null;
        Token this_APOSTROPHE_CHAR_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:172:8: ( (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ruleRehide ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:173:2: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ruleRehide )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:173:2: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ruleRehide )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:174:3: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ruleRehide
            {

            			markLeaf();
            		
            this_APOSTROPHE_CHAR_0=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix423); 

            			doneLeaf(this_APOSTROPHE_CHAR_0, elementTypeProvider.getFix_APOSTROPHE_CHARTerminalRuleCall_0ElementType());
            		

            			markComposite(elementTypeProvider.getFix_GraphicalParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_ruleFix435);
            ruleGraphical();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            this_APOSTROPHE_CHAR_2=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix449); 

            			doneLeaf(this_APOSTROPHE_CHAR_2, elementTypeProvider.getFix_APOSTROPHE_CHARTerminalRuleCall_2ElementType());
            		

            			markComposite(elementTypeProvider.getFix_RehideParserRuleCall_3ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleRehide_in_ruleFix461);
            ruleRehide();

            state._fsp--;


            			doneComposite();
            		

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
    // $ANTLR end "ruleFix"


    // $ANTLR start "entryRuleApostrophe"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:206:1: entryRuleApostrophe : ruleApostrophe EOF ;
    public final void entryRuleApostrophe() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:206:20: ( ruleApostrophe EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:207:2: ruleApostrophe EOF
            {
             markComposite(elementTypeProvider.getApostropheElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleApostrophe_in_entryRuleApostrophe481);
            ruleApostrophe();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleApostrophe487); 

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
    // $ANTLR end "entryRuleApostrophe"


    // $ANTLR start "ruleApostrophe"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:215:1: ruleApostrophe : this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ;
    public final void ruleApostrophe() throws RecognitionException {
        Token this_APOSTROPHE_CHAR_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:215:15: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:216:2: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR
            {

            		markLeaf();
            	
            this_APOSTROPHE_CHAR_0=(Token)match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleApostrophe505); 

            		doneLeaf(this_APOSTROPHE_CHAR_0, elementTypeProvider.getApostrophe_APOSTROPHE_CHARTerminalRuleCallElementType());
            	

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
    // $ANTLR end "ruleApostrophe"


    // $ANTLR start "entryRuleRehide"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:226:1: entryRuleRehide : ruleRehide EOF ;
    public final void entryRuleRehide() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:226:16: ( ruleRehide EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:227:2: ruleRehide EOF
            {
             markComposite(elementTypeProvider.getRehideElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRehide_in_entryRuleRehide521);
            ruleRehide();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRehide527); 

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
    // $ANTLR end "entryRuleRehide"


    // $ANTLR start "ruleRehide"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:235:1: ruleRehide : (kw= '^' )? ;
    public final void ruleRehide() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:235:11: ( (kw= '^' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:236:2: (kw= '^' )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:236:2: (kw= '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==10) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:237:3: kw= '^'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleRehide550); 

                    			doneLeaf(kw, elementTypeProvider.getRehide_CircumflexAccentKeywordElementType());
                    		

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
    // $ANTLR end "ruleRehide"


    // $ANTLR start "entryRuleGraphical"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:248:1: entryRuleGraphical : ruleGraphical EOF ;
    public final void entryRuleGraphical() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:248:19: ( ruleGraphical EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:249:2: ruleGraphical EOF
            {
             markComposite(elementTypeProvider.getGraphicalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_entryRuleGraphical571);
            ruleGraphical();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGraphical577); 

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
    // $ANTLR end "entryRuleGraphical"


    // $ANTLR start "ruleGraphical"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:257:1: ruleGraphical : (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS ) ;
    public final void ruleGraphical() throws RecognitionException {
        Token this_CHAR_0=null;
        Token this_WS_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:257:14: ( (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:258:2: (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:258:2: (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_CHAR) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_WS) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:259:3: this_CHAR_0= RULE_CHAR
                    {

                    			markLeaf();
                    		
                    this_CHAR_0=(Token)match(input,RULE_CHAR,FollowSets000.FOLLOW_RULE_CHAR_in_ruleGraphical600); 

                    			doneLeaf(this_CHAR_0, elementTypeProvider.getGraphical_CHARTerminalRuleCall_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug292245TestLanguage.g:267:3: this_WS_1= RULE_WS
                    {

                    			markLeaf();
                    		
                    this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleGraphical622); 

                    			doneLeaf(this_WS_1, elementTypeProvider.getGraphical_WSTerminalRuleCall_1ElementType());
                    		

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
    // $ANTLR end "ruleGraphical"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_7_in_ruleModel89 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFix_in_ruleModel121 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_8_in_ruleModel168 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleError_in_ruleModel200 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_9_in_ruleModel247 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleApostrophe_in_ruleModel279 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_ruleError_in_entryRuleError319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError348 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleGraphical_in_ruleError360 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFix_in_entryRuleFix394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFix400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix423 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleGraphical_in_ruleFix435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix449 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_ruleRehide_in_ruleFix461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleApostrophe_in_entryRuleApostrophe481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleApostrophe487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleApostrophe505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRehide_in_entryRuleRehide521 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRehide527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_10_in_ruleRehide550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGraphical_in_entryRuleGraphical571 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGraphical577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CHAR_in_ruleGraphical600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleGraphical622 = new BitSet(new long[]{0x0000000000000002L});
    }


}