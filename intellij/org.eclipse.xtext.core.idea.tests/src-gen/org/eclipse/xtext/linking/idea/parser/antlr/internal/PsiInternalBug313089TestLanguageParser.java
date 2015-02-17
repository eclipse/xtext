package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.linking.services.Bug313089TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug313089TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'baz'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug313089TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug313089TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug313089TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g"; }



    private Bug313089TestLanguageGrammarAccess grammarAccess;

    private Bug313089TestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalBug313089TestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, Bug313089TestLanguageElementTypeProvider elementTypeProvider, Bug313089TestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Foo";
    }




    // $ANTLR start "entryRuleFoo"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:49:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:49:13: ( ruleFoo EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:50:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo54);
            ruleFoo();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo60); 

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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:58:1: ruleFoo : ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:58:8: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:62:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo96); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getFoo_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:71:3: ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:72:4: ( (lv_bar_1_0= ruleBar ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:72:4: ( (lv_bar_1_0= ruleBar ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:73:5: (lv_bar_1_0= ruleBar )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:73:5: (lv_bar_1_0= ruleBar )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:74:6: lv_bar_1_0= ruleBar
                    {

                    						markComposite(elementTypeProvider.getFoo_BarBarParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleBar_in_ruleFoo142);
                    ruleBar();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:84:4: ( (lv_baz_2_0= ruleBaz ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:84:4: ( (lv_baz_2_0= ruleBaz ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:85:5: (lv_baz_2_0= ruleBaz )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:85:5: (lv_baz_2_0= ruleBaz )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:86:6: lv_baz_2_0= ruleBaz
                    {

                    						markComposite(elementTypeProvider.getFoo_BazBazParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleBaz_in_ruleFoo196);
                    ruleBaz();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:96:3: ( (otherlv_3= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:97:4: (otherlv_3= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:97:4: (otherlv_3= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:98:5: otherlv_3= RULE_ID
            {

            					markLeaf();
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo241); 

            					doneLeaf(otherlv_3, elementTypeProvider.getFoo_RefFooCrossReference_2_0ElementType());
            				

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
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleBar"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:111:1: entryRuleBar : ruleBar EOF ;
    public final void entryRuleBar() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:111:13: ( ruleBar EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:112:2: ruleBar EOF
            {
             markComposite(elementTypeProvider.getBarElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_entryRuleBar272);
            ruleBar();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBar278); 

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
    // $ANTLR end "entryRuleBar"


    // $ANTLR start "ruleBar"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:120:1: ruleBar : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleBar() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:120:8: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:121:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:121:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:122:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:122:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:123:4: 
            {

            				precedeComposite(elementTypeProvider.getBar_BarAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:128:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:129:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:129:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:130:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar327); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getBar_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleBar"


    // $ANTLR start "entryRuleBaz"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:143:1: entryRuleBaz : ruleBaz EOF ;
    public final void entryRuleBaz() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:143:13: ( ruleBaz EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:144:2: ruleBaz EOF
            {
             markComposite(elementTypeProvider.getBazElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBaz_in_entryRuleBaz358);
            ruleBaz();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBaz364); 

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
    // $ANTLR end "entryRuleBaz"


    // $ANTLR start "ruleBaz"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:152:1: ruleBaz : (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) ;
    public final void ruleBaz() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:152:8: ( (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:153:2: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:153:2: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:154:3: otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBaz387); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBaz_BazKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:161:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:162:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:162:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:163:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaz414); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getBaz_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:172:3: ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:173:4: () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:173:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:174:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getBaz_BazChildAction_2_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBaz461); 

            	    				doneLeaf(otherlv_3, elementTypeProvider.getBaz_BazKeyword_2_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:186:4: ( (lv_name_4_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:187:5: (lv_name_4_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:187:5: (lv_name_4_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug313089TestLanguage.g:188:6: lv_name_4_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaz493); 

            	    						doneLeaf(lv_name_4_0, elementTypeProvider.getBaz_NameIDTerminalRuleCall_2_2_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
        return ;
    }
    // $ANTLR end "ruleBaz"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo96 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_ruleBar_in_ruleFoo142 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleBaz_in_ruleFoo196 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBar_in_entryRuleBar272 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBar278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBaz_in_entryRuleBaz358 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBaz364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleBaz387 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaz414 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_11_in_ruleBaz461 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaz493 = new BitSet(new long[]{0x0000000000000802L});
    }


}