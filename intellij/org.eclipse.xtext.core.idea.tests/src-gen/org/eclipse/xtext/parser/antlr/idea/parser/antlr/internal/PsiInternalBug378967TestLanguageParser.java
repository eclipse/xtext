package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.services.Bug378967TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug378967TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'3'", "'4'", "'after'", "'s'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug378967TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug378967TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug378967TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug378967TestLanguage.g"; }



    	protected Bug378967TestLanguageGrammarAccess grammarAccess;

    	protected Bug378967TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug378967TestLanguageParser(PsiBuilder builder, TokenStream input, Bug378967TestLanguageElementTypeProvider elementTypeProvider, Bug378967TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Root";
    	}




    // $ANTLR start "entryRuleRoot"
    // PsiInternalBug378967TestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:52:14: ( ruleRoot EOF )
            // PsiInternalBug378967TestLanguage.g:53:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRoot();

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalBug378967TestLanguage.g:58:1: ruleRoot : ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalBug378967TestLanguage.g:58:9: ( ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) )
            // PsiInternalBug378967TestLanguage.g:59:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
            {
            // PsiInternalBug378967TestLanguage.g:59:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalBug378967TestLanguage.g:60:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:60:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    // PsiInternalBug378967TestLanguage.g:61:4: otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitOneKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug378967TestLanguage.g:68:4: ( (lv_element_1_0= ruleRule1 ) )
                    // PsiInternalBug378967TestLanguage.g:69:5: (lv_element_1_0= ruleRule1 )
                    {
                    // PsiInternalBug378967TestLanguage.g:69:5: (lv_element_1_0= ruleRule1 )
                    // PsiInternalBug378967TestLanguage.g:70:6: lv_element_1_0= ruleRule1
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule1ParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRule1();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug378967TestLanguage.g:81:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:81:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    // PsiInternalBug378967TestLanguage.g:82:4: otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitTwoKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalBug378967TestLanguage.g:89:4: ( (lv_element_3_0= ruleRule2 ) )
                    // PsiInternalBug378967TestLanguage.g:90:5: (lv_element_3_0= ruleRule2 )
                    {
                    // PsiInternalBug378967TestLanguage.g:90:5: (lv_element_3_0= ruleRule2 )
                    // PsiInternalBug378967TestLanguage.g:91:6: lv_element_3_0= ruleRule2
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule2ParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRule2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalBug378967TestLanguage.g:102:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:102:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    // PsiInternalBug378967TestLanguage.g:103:4: otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitThreeKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalBug378967TestLanguage.g:110:4: ( (lv_element_5_0= ruleRule3 ) )
                    // PsiInternalBug378967TestLanguage.g:111:5: (lv_element_5_0= ruleRule3 )
                    {
                    // PsiInternalBug378967TestLanguage.g:111:5: (lv_element_5_0= ruleRule3 )
                    // PsiInternalBug378967TestLanguage.g:112:6: lv_element_5_0= ruleRule3
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule3ParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRule3();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalBug378967TestLanguage.g:123:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:123:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    // PsiInternalBug378967TestLanguage.g:124:4: otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitFourKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalBug378967TestLanguage.g:131:4: ( (lv_element_7_0= ruleRule4 ) )
                    // PsiInternalBug378967TestLanguage.g:132:5: (lv_element_7_0= ruleRule4 )
                    {
                    // PsiInternalBug378967TestLanguage.g:132:5: (lv_element_7_0= ruleRule4 )
                    // PsiInternalBug378967TestLanguage.g:133:6: lv_element_7_0= ruleRule4
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule4ParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRule4();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleRule1"
    // PsiInternalBug378967TestLanguage.g:147:1: entryRuleRule1 : ruleRule1 EOF ;
    public final void entryRuleRule1() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:147:15: ( ruleRule1 EOF )
            // PsiInternalBug378967TestLanguage.g:148:2: ruleRule1 EOF
            {
             markComposite(elementTypeProvider.getRule1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRule1();

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
    // $ANTLR end "entryRuleRule1"


    // $ANTLR start "ruleRule1"
    // PsiInternalBug378967TestLanguage.g:153:1: ruleRule1 : ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) ;
    public final void ruleRule1() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:153:10: ( ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) )
            // PsiInternalBug378967TestLanguage.g:154:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            {
            // PsiInternalBug378967TestLanguage.g:154:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            // PsiInternalBug378967TestLanguage.g:155:3: ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) )
            {
            // PsiInternalBug378967TestLanguage.g:155:3: ( (lv_type_0_0= ruleFirstEnum ) )
            // PsiInternalBug378967TestLanguage.g:156:4: (lv_type_0_0= ruleFirstEnum )
            {
            // PsiInternalBug378967TestLanguage.g:156:4: (lv_type_0_0= ruleFirstEnum )
            // PsiInternalBug378967TestLanguage.g:157:5: lv_type_0_0= ruleFirstEnum
            {

            					markComposite(elementTypeProvider.getRule1_TypeFirstEnumEnumRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleFirstEnum();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:166:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:167:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:167:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:168:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule1_ValueINTTerminalRuleCall_1_0ElementType());
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_1_0);
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:177:3: ( (lv_unit_2_0= ruleSecondEnum ) )
            // PsiInternalBug378967TestLanguage.g:178:4: (lv_unit_2_0= ruleSecondEnum )
            {
            // PsiInternalBug378967TestLanguage.g:178:4: (lv_unit_2_0= ruleSecondEnum )
            // PsiInternalBug378967TestLanguage.g:179:5: lv_unit_2_0= ruleSecondEnum
            {

            					markComposite(elementTypeProvider.getRule1_UnitSecondEnumEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSecondEnum();

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
    // $ANTLR end "ruleRule1"


    // $ANTLR start "entryRuleRule2"
    // PsiInternalBug378967TestLanguage.g:192:1: entryRuleRule2 : ruleRule2 EOF ;
    public final void entryRuleRule2() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:192:15: ( ruleRule2 EOF )
            // PsiInternalBug378967TestLanguage.g:193:2: ruleRule2 EOF
            {
             markComposite(elementTypeProvider.getRule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRule2();

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
    // $ANTLR end "entryRuleRule2"


    // $ANTLR start "ruleRule2"
    // PsiInternalBug378967TestLanguage.g:198:1: ruleRule2 : (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) ;
    public final void ruleRule2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug378967TestLanguage.g:198:10: ( (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) )
            // PsiInternalBug378967TestLanguage.g:199:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            {
            // PsiInternalBug378967TestLanguage.g:199:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            // PsiInternalBug378967TestLanguage.g:200:3: otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's'
            {

            			markLeaf(elementTypeProvider.getRule2_AfterKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug378967TestLanguage.g:207:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:208:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:208:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:209:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule2_ValueINTTerminalRuleCall_1_0ElementType());
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getRule2_SKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleRule2"


    // $ANTLR start "entryRuleRule3"
    // PsiInternalBug378967TestLanguage.g:229:1: entryRuleRule3 : ruleRule3 EOF ;
    public final void entryRuleRule3() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:229:15: ( ruleRule3 EOF )
            // PsiInternalBug378967TestLanguage.g:230:2: ruleRule3 EOF
            {
             markComposite(elementTypeProvider.getRule3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRule3();

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
    // $ANTLR end "entryRuleRule3"


    // $ANTLR start "ruleRule3"
    // PsiInternalBug378967TestLanguage.g:235:1: ruleRule3 : ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) ;
    public final void ruleRule3() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:235:10: ( ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) )
            // PsiInternalBug378967TestLanguage.g:236:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            {
            // PsiInternalBug378967TestLanguage.g:236:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            // PsiInternalBug378967TestLanguage.g:237:3: ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS
            {

            			markComposite(elementTypeProvider.getRule3_AfterParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            ruleAfter();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug378967TestLanguage.g:244:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:245:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:245:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:246:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule3_ValueINTTerminalRuleCall_1_0ElementType());
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_1_0);
            				

            }


            }


            			markComposite(elementTypeProvider.getRule3_SParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            ruleS();

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
    // $ANTLR end "ruleRule3"


    // $ANTLR start "entryRuleRule4"
    // PsiInternalBug378967TestLanguage.g:266:1: entryRuleRule4 : ruleRule4 EOF ;
    public final void entryRuleRule4() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:266:15: ( ruleRule4 EOF )
            // PsiInternalBug378967TestLanguage.g:267:2: ruleRule4 EOF
            {
             markComposite(elementTypeProvider.getRule4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRule4();

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
    // $ANTLR end "entryRuleRule4"


    // $ANTLR start "ruleRule4"
    // PsiInternalBug378967TestLanguage.g:272:1: ruleRule4 : ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) ;
    public final void ruleRule4() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:272:10: ( ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) )
            // PsiInternalBug378967TestLanguage.g:273:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            {
            // PsiInternalBug378967TestLanguage.g:273:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            // PsiInternalBug378967TestLanguage.g:274:3: ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) )
            {
            // PsiInternalBug378967TestLanguage.g:274:3: ( (lv_after_0_0= ruleAfterObj ) )
            // PsiInternalBug378967TestLanguage.g:275:4: (lv_after_0_0= ruleAfterObj )
            {
            // PsiInternalBug378967TestLanguage.g:275:4: (lv_after_0_0= ruleAfterObj )
            // PsiInternalBug378967TestLanguage.g:276:5: lv_after_0_0= ruleAfterObj
            {

            					markComposite(elementTypeProvider.getRule4_AfterAfterObjParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleAfterObj();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:285:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:286:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:286:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:287:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule4_ValueINTTerminalRuleCall_1_0ElementType());
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_1_0);
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:296:3: ( (lv_s_2_0= ruleSObj ) )
            // PsiInternalBug378967TestLanguage.g:297:4: (lv_s_2_0= ruleSObj )
            {
            // PsiInternalBug378967TestLanguage.g:297:4: (lv_s_2_0= ruleSObj )
            // PsiInternalBug378967TestLanguage.g:298:5: lv_s_2_0= ruleSObj
            {

            					markComposite(elementTypeProvider.getRule4_SSObjParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSObj();

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
    // $ANTLR end "ruleRule4"


    // $ANTLR start "entryRuleAfterObj"
    // PsiInternalBug378967TestLanguage.g:311:1: entryRuleAfterObj : ruleAfterObj EOF ;
    public final void entryRuleAfterObj() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:311:18: ( ruleAfterObj EOF )
            // PsiInternalBug378967TestLanguage.g:312:2: ruleAfterObj EOF
            {
             markComposite(elementTypeProvider.getAfterObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAfterObj();

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
    // $ANTLR end "entryRuleAfterObj"


    // $ANTLR start "ruleAfterObj"
    // PsiInternalBug378967TestLanguage.g:317:1: ruleAfterObj : ( (lv_value_0_0= 'after' ) ) ;
    public final void ruleAfterObj() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:317:13: ( ( (lv_value_0_0= 'after' ) ) )
            // PsiInternalBug378967TestLanguage.g:318:2: ( (lv_value_0_0= 'after' ) )
            {
            // PsiInternalBug378967TestLanguage.g:318:2: ( (lv_value_0_0= 'after' ) )
            // PsiInternalBug378967TestLanguage.g:319:3: (lv_value_0_0= 'after' )
            {
            // PsiInternalBug378967TestLanguage.g:319:3: (lv_value_0_0= 'after' )
            // PsiInternalBug378967TestLanguage.g:320:4: lv_value_0_0= 'after'
            {

            				markLeaf(elementTypeProvider.getAfterObj_ValueAfterKeyword_0ElementType());
            			
            lv_value_0_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_value_0_0);
            			

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
    // $ANTLR end "ruleAfterObj"


    // $ANTLR start "entryRuleSObj"
    // PsiInternalBug378967TestLanguage.g:332:1: entryRuleSObj : ruleSObj EOF ;
    public final void entryRuleSObj() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:332:14: ( ruleSObj EOF )
            // PsiInternalBug378967TestLanguage.g:333:2: ruleSObj EOF
            {
             markComposite(elementTypeProvider.getSObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSObj();

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
    // $ANTLR end "entryRuleSObj"


    // $ANTLR start "ruleSObj"
    // PsiInternalBug378967TestLanguage.g:338:1: ruleSObj : ( (lv_value_0_0= 's' ) ) ;
    public final void ruleSObj() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:338:9: ( ( (lv_value_0_0= 's' ) ) )
            // PsiInternalBug378967TestLanguage.g:339:2: ( (lv_value_0_0= 's' ) )
            {
            // PsiInternalBug378967TestLanguage.g:339:2: ( (lv_value_0_0= 's' ) )
            // PsiInternalBug378967TestLanguage.g:340:3: (lv_value_0_0= 's' )
            {
            // PsiInternalBug378967TestLanguage.g:340:3: (lv_value_0_0= 's' )
            // PsiInternalBug378967TestLanguage.g:341:4: lv_value_0_0= 's'
            {

            				markLeaf(elementTypeProvider.getSObj_ValueSKeyword_0ElementType());
            			
            lv_value_0_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_value_0_0);
            			

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
    // $ANTLR end "ruleSObj"


    // $ANTLR start "entryRuleAfter"
    // PsiInternalBug378967TestLanguage.g:353:1: entryRuleAfter : ruleAfter EOF ;
    public final void entryRuleAfter() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:353:15: ( ruleAfter EOF )
            // PsiInternalBug378967TestLanguage.g:354:2: ruleAfter EOF
            {
             markComposite(elementTypeProvider.getAfterElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAfter();

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
    // $ANTLR end "entryRuleAfter"


    // $ANTLR start "ruleAfter"
    // PsiInternalBug378967TestLanguage.g:359:1: ruleAfter : kw= 'after' ;
    public final void ruleAfter() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalBug378967TestLanguage.g:359:10: (kw= 'after' )
            // PsiInternalBug378967TestLanguage.g:360:2: kw= 'after'
            {

            		markLeaf(elementTypeProvider.getAfter_AfterKeywordElementType());
            	
            kw=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            		doneLeaf(kw);
            	

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
    // $ANTLR end "ruleAfter"


    // $ANTLR start "entryRuleS"
    // PsiInternalBug378967TestLanguage.g:370:1: entryRuleS : ruleS EOF ;
    public final void entryRuleS() throws RecognitionException {
        try {
            // PsiInternalBug378967TestLanguage.g:370:11: ( ruleS EOF )
            // PsiInternalBug378967TestLanguage.g:371:2: ruleS EOF
            {
             markComposite(elementTypeProvider.getSElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleS();

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
    // $ANTLR end "entryRuleS"


    // $ANTLR start "ruleS"
    // PsiInternalBug378967TestLanguage.g:376:1: ruleS : kw= 's' ;
    public final void ruleS() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalBug378967TestLanguage.g:376:6: (kw= 's' )
            // PsiInternalBug378967TestLanguage.g:377:2: kw= 's'
            {

            		markLeaf(elementTypeProvider.getS_SKeywordElementType());
            	
            kw=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            		doneLeaf(kw);
            	

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
    // $ANTLR end "ruleS"


    // $ANTLR start "ruleFirstEnum"
    // PsiInternalBug378967TestLanguage.g:387:1: ruleFirstEnum : (enumLiteral_0= 'after' ) ;
    public final void ruleFirstEnum() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:387:14: ( (enumLiteral_0= 'after' ) )
            // PsiInternalBug378967TestLanguage.g:388:2: (enumLiteral_0= 'after' )
            {
            // PsiInternalBug378967TestLanguage.g:388:2: (enumLiteral_0= 'after' )
            // PsiInternalBug378967TestLanguage.g:389:3: enumLiteral_0= 'after'
            {

            			markLeaf(elementTypeProvider.getFirstEnum_ValueEnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleFirstEnum"


    // $ANTLR start "ruleSecondEnum"
    // PsiInternalBug378967TestLanguage.g:400:1: ruleSecondEnum : (enumLiteral_0= 's' ) ;
    public final void ruleSecondEnum() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:400:15: ( (enumLiteral_0= 's' ) )
            // PsiInternalBug378967TestLanguage.g:401:2: (enumLiteral_0= 's' )
            {
            // PsiInternalBug378967TestLanguage.g:401:2: (enumLiteral_0= 's' )
            // PsiInternalBug378967TestLanguage.g:402:3: enumLiteral_0= 's'
            {

            			markLeaf(elementTypeProvider.getSecondEnum_ValueEnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleSecondEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    }


}