package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalBug313089TestLanguage.g"; }



    	protected Bug313089TestLanguageGrammarAccess grammarAccess;

    	protected Bug313089TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug313089TestLanguageParser(PsiBuilder builder, TokenStream input, Bug313089TestLanguageElementTypeProvider elementTypeProvider, Bug313089TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Foo";
    	}




    // $ANTLR start "entryRuleFoo"
    // PsiInternalBug313089TestLanguage.g:52:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // PsiInternalBug313089TestLanguage.g:52:13: ( ruleFoo EOF )
            // PsiInternalBug313089TestLanguage.g:53:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFoo();

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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // PsiInternalBug313089TestLanguage.g:58:1: ruleFoo : ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalBug313089TestLanguage.g:58:8: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) )
            // PsiInternalBug313089TestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            {
            // PsiInternalBug313089TestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            // PsiInternalBug313089TestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) )
            {
            // PsiInternalBug313089TestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:62:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFoo_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalBug313089TestLanguage.g:71:3: ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) )
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
                    // PsiInternalBug313089TestLanguage.g:72:4: ( (lv_bar_1_0= ruleBar ) )
                    {
                    // PsiInternalBug313089TestLanguage.g:72:4: ( (lv_bar_1_0= ruleBar ) )
                    // PsiInternalBug313089TestLanguage.g:73:5: (lv_bar_1_0= ruleBar )
                    {
                    // PsiInternalBug313089TestLanguage.g:73:5: (lv_bar_1_0= ruleBar )
                    // PsiInternalBug313089TestLanguage.g:74:6: lv_bar_1_0= ruleBar
                    {

                    						markComposite(elementTypeProvider.getFoo_BarBarParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    ruleBar();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug313089TestLanguage.g:84:4: ( (lv_baz_2_0= ruleBaz ) )
                    {
                    // PsiInternalBug313089TestLanguage.g:84:4: ( (lv_baz_2_0= ruleBaz ) )
                    // PsiInternalBug313089TestLanguage.g:85:5: (lv_baz_2_0= ruleBaz )
                    {
                    // PsiInternalBug313089TestLanguage.g:85:5: (lv_baz_2_0= ruleBaz )
                    // PsiInternalBug313089TestLanguage.g:86:6: lv_baz_2_0= ruleBaz
                    {

                    						markComposite(elementTypeProvider.getFoo_BazBazParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    ruleBaz();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug313089TestLanguage.g:96:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:97:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:97:4: (otherlv_3= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:98:5: otherlv_3= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFoo_RefFooCrossReference_2_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_3);
            				

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
    // PsiInternalBug313089TestLanguage.g:111:1: entryRuleBar : ruleBar EOF ;
    public final void entryRuleBar() throws RecognitionException {
        try {
            // PsiInternalBug313089TestLanguage.g:111:13: ( ruleBar EOF )
            // PsiInternalBug313089TestLanguage.g:112:2: ruleBar EOF
            {
             markComposite(elementTypeProvider.getBarElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBar();

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
    // $ANTLR end "entryRuleBar"


    // $ANTLR start "ruleBar"
    // PsiInternalBug313089TestLanguage.g:117:1: ruleBar : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleBar() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // PsiInternalBug313089TestLanguage.g:117:8: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBug313089TestLanguage.g:118:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBug313089TestLanguage.g:118:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBug313089TestLanguage.g:119:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalBug313089TestLanguage.g:119:3: ()
            // PsiInternalBug313089TestLanguage.g:120:4: 
            {

            				precedeComposite(elementTypeProvider.getBar_BarAction_0ElementType());
            				doneComposite();
            			

            }

            // PsiInternalBug313089TestLanguage.g:125:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:126:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:126:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:127:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBar_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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
    // PsiInternalBug313089TestLanguage.g:140:1: entryRuleBaz : ruleBaz EOF ;
    public final void entryRuleBaz() throws RecognitionException {
        try {
            // PsiInternalBug313089TestLanguage.g:140:13: ( ruleBaz EOF )
            // PsiInternalBug313089TestLanguage.g:141:2: ruleBaz EOF
            {
             markComposite(elementTypeProvider.getBazElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBaz();

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
    // $ANTLR end "entryRuleBaz"


    // $ANTLR start "ruleBaz"
    // PsiInternalBug313089TestLanguage.g:146:1: ruleBaz : (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) ;
    public final void ruleBaz() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

        try {
            // PsiInternalBug313089TestLanguage.g:146:8: ( (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) )
            // PsiInternalBug313089TestLanguage.g:147:2: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            {
            // PsiInternalBug313089TestLanguage.g:147:2: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            // PsiInternalBug313089TestLanguage.g:148:3: otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getBaz_BazKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug313089TestLanguage.g:155:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:156:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:156:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:157:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBaz_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalBug313089TestLanguage.g:166:3: ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalBug313089TestLanguage.g:167:4: () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) )
            	    {
            	    // PsiInternalBug313089TestLanguage.g:167:4: ()
            	    // PsiInternalBug313089TestLanguage.g:168:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getBaz_BazChildAction_2_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getBaz_BazKeyword_2_1ElementType());
            	    			
            	    otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalBug313089TestLanguage.g:180:4: ( (lv_name_4_0= RULE_ID ) )
            	    // PsiInternalBug313089TestLanguage.g:181:5: (lv_name_4_0= RULE_ID )
            	    {
            	    // PsiInternalBug313089TestLanguage.g:181:5: (lv_name_4_0= RULE_ID )
            	    // PsiInternalBug313089TestLanguage.g:182:6: lv_name_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getBaz_NameIDTerminalRuleCall_2_2_0ElementType());
            	    					
            	    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            	    						doneLeaf(lv_name_4_0);
            	    					

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000802L});
    }


}