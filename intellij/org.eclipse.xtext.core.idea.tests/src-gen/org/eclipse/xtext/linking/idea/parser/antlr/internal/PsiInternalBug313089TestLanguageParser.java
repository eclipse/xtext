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
    // PsiInternalBug313089TestLanguage.g:52:1: entryRuleFoo returns [Boolean current=false] : iv_ruleFoo= ruleFoo EOF ;
    public final Boolean entryRuleFoo() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFoo = null;


        try {
            // PsiInternalBug313089TestLanguage.g:52:45: (iv_ruleFoo= ruleFoo EOF )
            // PsiInternalBug313089TestLanguage.g:53:2: iv_ruleFoo= ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // PsiInternalBug313089TestLanguage.g:59:1: ruleFoo returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) ;
    public final Boolean ruleFoo() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        Boolean lv_bar_1_0 = null;

        Boolean lv_baz_2_0 = null;


        try {
            // PsiInternalBug313089TestLanguage.g:60:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) )
            // PsiInternalBug313089TestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            {
            // PsiInternalBug313089TestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            // PsiInternalBug313089TestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) )
            {
            // PsiInternalBug313089TestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:64:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFoo_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalBug313089TestLanguage.g:79:3: ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) )
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
                    // PsiInternalBug313089TestLanguage.g:80:4: ( (lv_bar_1_0= ruleBar ) )
                    {
                    // PsiInternalBug313089TestLanguage.g:80:4: ( (lv_bar_1_0= ruleBar ) )
                    // PsiInternalBug313089TestLanguage.g:81:5: (lv_bar_1_0= ruleBar )
                    {
                    // PsiInternalBug313089TestLanguage.g:81:5: (lv_bar_1_0= ruleBar )
                    // PsiInternalBug313089TestLanguage.g:82:6: lv_bar_1_0= ruleBar
                    {

                    						markComposite(elementTypeProvider.getFoo_BarBarParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_bar_1_0=ruleBar();

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
                    // PsiInternalBug313089TestLanguage.g:96:4: ( (lv_baz_2_0= ruleBaz ) )
                    {
                    // PsiInternalBug313089TestLanguage.g:96:4: ( (lv_baz_2_0= ruleBaz ) )
                    // PsiInternalBug313089TestLanguage.g:97:5: (lv_baz_2_0= ruleBaz )
                    {
                    // PsiInternalBug313089TestLanguage.g:97:5: (lv_baz_2_0= ruleBaz )
                    // PsiInternalBug313089TestLanguage.g:98:6: lv_baz_2_0= ruleBaz
                    {

                    						markComposite(elementTypeProvider.getFoo_BazBazParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_baz_2_0=ruleBaz();

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

            }

            // PsiInternalBug313089TestLanguage.g:112:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:113:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:113:4: (otherlv_3= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:114:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleBar"
    // PsiInternalBug313089TestLanguage.g:133:1: entryRuleBar returns [Boolean current=false] : iv_ruleBar= ruleBar EOF ;
    public final Boolean entryRuleBar() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBar = null;


        try {
            // PsiInternalBug313089TestLanguage.g:133:45: (iv_ruleBar= ruleBar EOF )
            // PsiInternalBug313089TestLanguage.g:134:2: iv_ruleBar= ruleBar EOF
            {
             markComposite(elementTypeProvider.getBarElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBar=ruleBar();

            state._fsp--;

             current =iv_ruleBar; 
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
    // $ANTLR end "entryRuleBar"


    // $ANTLR start "ruleBar"
    // PsiInternalBug313089TestLanguage.g:140:1: ruleBar returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleBar() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;

        try {
            // PsiInternalBug313089TestLanguage.g:141:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBug313089TestLanguage.g:142:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBug313089TestLanguage.g:142:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBug313089TestLanguage.g:143:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalBug313089TestLanguage.g:143:3: ()
            // PsiInternalBug313089TestLanguage.g:144:4: 
            {

            				precedeComposite(elementTypeProvider.getBar_BarAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalBug313089TestLanguage.g:150:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:151:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:151:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:152:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBar_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleBar"


    // $ANTLR start "entryRuleBaz"
    // PsiInternalBug313089TestLanguage.g:171:1: entryRuleBaz returns [Boolean current=false] : iv_ruleBaz= ruleBaz EOF ;
    public final Boolean entryRuleBaz() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBaz = null;


        try {
            // PsiInternalBug313089TestLanguage.g:171:45: (iv_ruleBaz= ruleBaz EOF )
            // PsiInternalBug313089TestLanguage.g:172:2: iv_ruleBaz= ruleBaz EOF
            {
             markComposite(elementTypeProvider.getBazElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBaz=ruleBaz();

            state._fsp--;

             current =iv_ruleBaz; 
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
    // $ANTLR end "entryRuleBaz"


    // $ANTLR start "ruleBaz"
    // PsiInternalBug313089TestLanguage.g:178:1: ruleBaz returns [Boolean current=false] : (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleBaz() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

        try {
            // PsiInternalBug313089TestLanguage.g:179:1: ( (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) )
            // PsiInternalBug313089TestLanguage.g:180:2: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            {
            // PsiInternalBug313089TestLanguage.g:180:2: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            // PsiInternalBug313089TestLanguage.g:181:3: otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getBaz_BazKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug313089TestLanguage.g:188:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug313089TestLanguage.g:189:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug313089TestLanguage.g:189:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug313089TestLanguage.g:190:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBaz_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalBug313089TestLanguage.g:205:3: ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalBug313089TestLanguage.g:206:4: () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) )
            	    {
            	    // PsiInternalBug313089TestLanguage.g:206:4: ()
            	    // PsiInternalBug313089TestLanguage.g:207:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getBaz_BazChildAction_2_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getBaz_BazKeyword_2_1ElementType());
            	    			
            	    otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalBug313089TestLanguage.g:220:4: ( (lv_name_4_0= RULE_ID ) )
            	    // PsiInternalBug313089TestLanguage.g:221:5: (lv_name_4_0= RULE_ID )
            	    {
            	    // PsiInternalBug313089TestLanguage.g:221:5: (lv_name_4_0= RULE_ID )
            	    // PsiInternalBug313089TestLanguage.g:222:6: lv_name_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getBaz_NameIDTerminalRuleCall_2_2_0ElementType());
            	    					
            	    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

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
        return current;
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