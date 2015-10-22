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
    // PsiInternalBug378967TestLanguage.g:52:1: entryRuleRoot returns [Boolean current=false] : iv_ruleRoot= ruleRoot EOF ;
    public final Boolean entryRuleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRoot = null;


        try {
            // PsiInternalBug378967TestLanguage.g:52:46: (iv_ruleRoot= ruleRoot EOF )
            // PsiInternalBug378967TestLanguage.g:53:2: iv_ruleRoot= ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalBug378967TestLanguage.g:59:1: ruleRoot returns [Boolean current=false] : ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_element_1_0 = null;

        Boolean lv_element_3_0 = null;

        Boolean lv_element_5_0 = null;

        Boolean lv_element_7_0 = null;


        try {
            // PsiInternalBug378967TestLanguage.g:60:1: ( ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) )
            // PsiInternalBug378967TestLanguage.g:61:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
            {
            // PsiInternalBug378967TestLanguage.g:61:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
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
                    // PsiInternalBug378967TestLanguage.g:62:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:62:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    // PsiInternalBug378967TestLanguage.g:63:4: otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitOneKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug378967TestLanguage.g:70:4: ( (lv_element_1_0= ruleRule1 ) )
                    // PsiInternalBug378967TestLanguage.g:71:5: (lv_element_1_0= ruleRule1 )
                    {
                    // PsiInternalBug378967TestLanguage.g:71:5: (lv_element_1_0= ruleRule1 )
                    // PsiInternalBug378967TestLanguage.g:72:6: lv_element_1_0= ruleRule1
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule1ParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_1_0=ruleRule1();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug378967TestLanguage.g:87:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:87:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    // PsiInternalBug378967TestLanguage.g:88:4: otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitTwoKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalBug378967TestLanguage.g:95:4: ( (lv_element_3_0= ruleRule2 ) )
                    // PsiInternalBug378967TestLanguage.g:96:5: (lv_element_3_0= ruleRule2 )
                    {
                    // PsiInternalBug378967TestLanguage.g:96:5: (lv_element_3_0= ruleRule2 )
                    // PsiInternalBug378967TestLanguage.g:97:6: lv_element_3_0= ruleRule2
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule2ParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_3_0=ruleRule2();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalBug378967TestLanguage.g:112:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:112:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    // PsiInternalBug378967TestLanguage.g:113:4: otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitThreeKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalBug378967TestLanguage.g:120:4: ( (lv_element_5_0= ruleRule3 ) )
                    // PsiInternalBug378967TestLanguage.g:121:5: (lv_element_5_0= ruleRule3 )
                    {
                    // PsiInternalBug378967TestLanguage.g:121:5: (lv_element_5_0= ruleRule3 )
                    // PsiInternalBug378967TestLanguage.g:122:6: lv_element_5_0= ruleRule3
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule3ParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_5_0=ruleRule3();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalBug378967TestLanguage.g:137:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    {
                    // PsiInternalBug378967TestLanguage.g:137:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    // PsiInternalBug378967TestLanguage.g:138:4: otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitFourKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalBug378967TestLanguage.g:145:4: ( (lv_element_7_0= ruleRule4 ) )
                    // PsiInternalBug378967TestLanguage.g:146:5: (lv_element_7_0= ruleRule4 )
                    {
                    // PsiInternalBug378967TestLanguage.g:146:5: (lv_element_7_0= ruleRule4 )
                    // PsiInternalBug378967TestLanguage.g:147:6: lv_element_7_0= ruleRule4
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule4ParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_7_0=ruleRule4();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleRule1"
    // PsiInternalBug378967TestLanguage.g:165:1: entryRuleRule1 returns [Boolean current=false] : iv_ruleRule1= ruleRule1 EOF ;
    public final Boolean entryRuleRule1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRule1 = null;


        try {
            // PsiInternalBug378967TestLanguage.g:165:47: (iv_ruleRule1= ruleRule1 EOF )
            // PsiInternalBug378967TestLanguage.g:166:2: iv_ruleRule1= ruleRule1 EOF
            {
             markComposite(elementTypeProvider.getRule1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRule1=ruleRule1();

            state._fsp--;

             current =iv_ruleRule1; 
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
    // $ANTLR end "entryRuleRule1"


    // $ANTLR start "ruleRule1"
    // PsiInternalBug378967TestLanguage.g:172:1: ruleRule1 returns [Boolean current=false] : ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) ;
    public final Boolean ruleRule1() throws RecognitionException {
        Boolean current = false;

        Token lv_value_1_0=null;
        Boolean lv_type_0_0 = null;

        Boolean lv_unit_2_0 = null;


        try {
            // PsiInternalBug378967TestLanguage.g:173:1: ( ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) )
            // PsiInternalBug378967TestLanguage.g:174:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            {
            // PsiInternalBug378967TestLanguage.g:174:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            // PsiInternalBug378967TestLanguage.g:175:3: ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) )
            {
            // PsiInternalBug378967TestLanguage.g:175:3: ( (lv_type_0_0= ruleFirstEnum ) )
            // PsiInternalBug378967TestLanguage.g:176:4: (lv_type_0_0= ruleFirstEnum )
            {
            // PsiInternalBug378967TestLanguage.g:176:4: (lv_type_0_0= ruleFirstEnum )
            // PsiInternalBug378967TestLanguage.g:177:5: lv_type_0_0= ruleFirstEnum
            {

            					markComposite(elementTypeProvider.getRule1_TypeFirstEnumEnumRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_type_0_0=ruleFirstEnum();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:190:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:191:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:191:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:192:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule1_ValueINTTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_1_0);
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:207:3: ( (lv_unit_2_0= ruleSecondEnum ) )
            // PsiInternalBug378967TestLanguage.g:208:4: (lv_unit_2_0= ruleSecondEnum )
            {
            // PsiInternalBug378967TestLanguage.g:208:4: (lv_unit_2_0= ruleSecondEnum )
            // PsiInternalBug378967TestLanguage.g:209:5: lv_unit_2_0= ruleSecondEnum
            {

            					markComposite(elementTypeProvider.getRule1_UnitSecondEnumEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_unit_2_0=ruleSecondEnum();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleRule1"


    // $ANTLR start "entryRuleRule2"
    // PsiInternalBug378967TestLanguage.g:226:1: entryRuleRule2 returns [Boolean current=false] : iv_ruleRule2= ruleRule2 EOF ;
    public final Boolean entryRuleRule2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRule2 = null;


        try {
            // PsiInternalBug378967TestLanguage.g:226:47: (iv_ruleRule2= ruleRule2 EOF )
            // PsiInternalBug378967TestLanguage.g:227:2: iv_ruleRule2= ruleRule2 EOF
            {
             markComposite(elementTypeProvider.getRule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRule2=ruleRule2();

            state._fsp--;

             current =iv_ruleRule2; 
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
    // $ANTLR end "entryRuleRule2"


    // $ANTLR start "ruleRule2"
    // PsiInternalBug378967TestLanguage.g:233:1: ruleRule2 returns [Boolean current=false] : (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) ;
    public final Boolean ruleRule2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug378967TestLanguage.g:234:1: ( (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) )
            // PsiInternalBug378967TestLanguage.g:235:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            {
            // PsiInternalBug378967TestLanguage.g:235:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            // PsiInternalBug378967TestLanguage.g:236:3: otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's'
            {

            			markLeaf(elementTypeProvider.getRule2_AfterKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug378967TestLanguage.g:243:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:244:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:244:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:245:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule2_ValueINTTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleRule2"


    // $ANTLR start "entryRuleRule3"
    // PsiInternalBug378967TestLanguage.g:271:1: entryRuleRule3 returns [Boolean current=false] : iv_ruleRule3= ruleRule3 EOF ;
    public final Boolean entryRuleRule3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRule3 = null;


        try {
            // PsiInternalBug378967TestLanguage.g:271:47: (iv_ruleRule3= ruleRule3 EOF )
            // PsiInternalBug378967TestLanguage.g:272:2: iv_ruleRule3= ruleRule3 EOF
            {
             markComposite(elementTypeProvider.getRule3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRule3=ruleRule3();

            state._fsp--;

             current =iv_ruleRule3; 
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
    // $ANTLR end "entryRuleRule3"


    // $ANTLR start "ruleRule3"
    // PsiInternalBug378967TestLanguage.g:278:1: ruleRule3 returns [Boolean current=false] : ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) ;
    public final Boolean ruleRule3() throws RecognitionException {
        Boolean current = false;

        Token lv_value_1_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:279:1: ( ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) )
            // PsiInternalBug378967TestLanguage.g:280:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            {
            // PsiInternalBug378967TestLanguage.g:280:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            // PsiInternalBug378967TestLanguage.g:281:3: ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS
            {

            			markComposite(elementTypeProvider.getRule3_AfterParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            ruleAfter();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug378967TestLanguage.g:288:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:289:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:289:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:290:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule3_ValueINTTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleRule3"


    // $ANTLR start "entryRuleRule4"
    // PsiInternalBug378967TestLanguage.g:316:1: entryRuleRule4 returns [Boolean current=false] : iv_ruleRule4= ruleRule4 EOF ;
    public final Boolean entryRuleRule4() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRule4 = null;


        try {
            // PsiInternalBug378967TestLanguage.g:316:47: (iv_ruleRule4= ruleRule4 EOF )
            // PsiInternalBug378967TestLanguage.g:317:2: iv_ruleRule4= ruleRule4 EOF
            {
             markComposite(elementTypeProvider.getRule4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRule4=ruleRule4();

            state._fsp--;

             current =iv_ruleRule4; 
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
    // $ANTLR end "entryRuleRule4"


    // $ANTLR start "ruleRule4"
    // PsiInternalBug378967TestLanguage.g:323:1: ruleRule4 returns [Boolean current=false] : ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) ;
    public final Boolean ruleRule4() throws RecognitionException {
        Boolean current = false;

        Token lv_value_1_0=null;
        Boolean lv_after_0_0 = null;

        Boolean lv_s_2_0 = null;


        try {
            // PsiInternalBug378967TestLanguage.g:324:1: ( ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) )
            // PsiInternalBug378967TestLanguage.g:325:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            {
            // PsiInternalBug378967TestLanguage.g:325:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            // PsiInternalBug378967TestLanguage.g:326:3: ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) )
            {
            // PsiInternalBug378967TestLanguage.g:326:3: ( (lv_after_0_0= ruleAfterObj ) )
            // PsiInternalBug378967TestLanguage.g:327:4: (lv_after_0_0= ruleAfterObj )
            {
            // PsiInternalBug378967TestLanguage.g:327:4: (lv_after_0_0= ruleAfterObj )
            // PsiInternalBug378967TestLanguage.g:328:5: lv_after_0_0= ruleAfterObj
            {

            					markComposite(elementTypeProvider.getRule4_AfterAfterObjParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_after_0_0=ruleAfterObj();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:341:3: ( (lv_value_1_0= RULE_INT ) )
            // PsiInternalBug378967TestLanguage.g:342:4: (lv_value_1_0= RULE_INT )
            {
            // PsiInternalBug378967TestLanguage.g:342:4: (lv_value_1_0= RULE_INT )
            // PsiInternalBug378967TestLanguage.g:343:5: lv_value_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getRule4_ValueINTTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_1_0);
            				

            }


            }

            // PsiInternalBug378967TestLanguage.g:358:3: ( (lv_s_2_0= ruleSObj ) )
            // PsiInternalBug378967TestLanguage.g:359:4: (lv_s_2_0= ruleSObj )
            {
            // PsiInternalBug378967TestLanguage.g:359:4: (lv_s_2_0= ruleSObj )
            // PsiInternalBug378967TestLanguage.g:360:5: lv_s_2_0= ruleSObj
            {

            					markComposite(elementTypeProvider.getRule4_SSObjParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_s_2_0=ruleSObj();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleRule4"


    // $ANTLR start "entryRuleAfterObj"
    // PsiInternalBug378967TestLanguage.g:377:1: entryRuleAfterObj returns [Boolean current=false] : iv_ruleAfterObj= ruleAfterObj EOF ;
    public final Boolean entryRuleAfterObj() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAfterObj = null;


        try {
            // PsiInternalBug378967TestLanguage.g:377:50: (iv_ruleAfterObj= ruleAfterObj EOF )
            // PsiInternalBug378967TestLanguage.g:378:2: iv_ruleAfterObj= ruleAfterObj EOF
            {
             markComposite(elementTypeProvider.getAfterObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAfterObj=ruleAfterObj();

            state._fsp--;

             current =iv_ruleAfterObj; 
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
    // $ANTLR end "entryRuleAfterObj"


    // $ANTLR start "ruleAfterObj"
    // PsiInternalBug378967TestLanguage.g:384:1: ruleAfterObj returns [Boolean current=false] : ( (lv_value_0_0= 'after' ) ) ;
    public final Boolean ruleAfterObj() throws RecognitionException {
        Boolean current = false;

        Token lv_value_0_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:385:1: ( ( (lv_value_0_0= 'after' ) ) )
            // PsiInternalBug378967TestLanguage.g:386:2: ( (lv_value_0_0= 'after' ) )
            {
            // PsiInternalBug378967TestLanguage.g:386:2: ( (lv_value_0_0= 'after' ) )
            // PsiInternalBug378967TestLanguage.g:387:3: (lv_value_0_0= 'after' )
            {
            // PsiInternalBug378967TestLanguage.g:387:3: (lv_value_0_0= 'after' )
            // PsiInternalBug378967TestLanguage.g:388:4: lv_value_0_0= 'after'
            {

            				markLeaf(elementTypeProvider.getAfterObj_ValueAfterKeyword_0ElementType());
            			
            lv_value_0_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_value_0_0);
            			

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
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
    // $ANTLR end "ruleAfterObj"


    // $ANTLR start "entryRuleSObj"
    // PsiInternalBug378967TestLanguage.g:406:1: entryRuleSObj returns [Boolean current=false] : iv_ruleSObj= ruleSObj EOF ;
    public final Boolean entryRuleSObj() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSObj = null;


        try {
            // PsiInternalBug378967TestLanguage.g:406:46: (iv_ruleSObj= ruleSObj EOF )
            // PsiInternalBug378967TestLanguage.g:407:2: iv_ruleSObj= ruleSObj EOF
            {
             markComposite(elementTypeProvider.getSObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSObj=ruleSObj();

            state._fsp--;

             current =iv_ruleSObj; 
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
    // $ANTLR end "entryRuleSObj"


    // $ANTLR start "ruleSObj"
    // PsiInternalBug378967TestLanguage.g:413:1: ruleSObj returns [Boolean current=false] : ( (lv_value_0_0= 's' ) ) ;
    public final Boolean ruleSObj() throws RecognitionException {
        Boolean current = false;

        Token lv_value_0_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:414:1: ( ( (lv_value_0_0= 's' ) ) )
            // PsiInternalBug378967TestLanguage.g:415:2: ( (lv_value_0_0= 's' ) )
            {
            // PsiInternalBug378967TestLanguage.g:415:2: ( (lv_value_0_0= 's' ) )
            // PsiInternalBug378967TestLanguage.g:416:3: (lv_value_0_0= 's' )
            {
            // PsiInternalBug378967TestLanguage.g:416:3: (lv_value_0_0= 's' )
            // PsiInternalBug378967TestLanguage.g:417:4: lv_value_0_0= 's'
            {

            				markLeaf(elementTypeProvider.getSObj_ValueSKeyword_0ElementType());
            			
            lv_value_0_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_value_0_0);
            			

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
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
    // $ANTLR end "ruleSObj"


    // $ANTLR start "entryRuleAfter"
    // PsiInternalBug378967TestLanguage.g:435:1: entryRuleAfter returns [Boolean current=false] : iv_ruleAfter= ruleAfter EOF ;
    public final Boolean entryRuleAfter() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAfter = null;


        try {
            // PsiInternalBug378967TestLanguage.g:435:47: (iv_ruleAfter= ruleAfter EOF )
            // PsiInternalBug378967TestLanguage.g:436:2: iv_ruleAfter= ruleAfter EOF
            {
             markComposite(elementTypeProvider.getAfterElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAfter=ruleAfter();

            state._fsp--;

             current =iv_ruleAfter; 
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
    // $ANTLR end "entryRuleAfter"


    // $ANTLR start "ruleAfter"
    // PsiInternalBug378967TestLanguage.g:442:1: ruleAfter returns [Boolean current=false] : kw= 'after' ;
    public final Boolean ruleAfter() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalBug378967TestLanguage.g:443:1: (kw= 'after' )
            // PsiInternalBug378967TestLanguage.g:444:2: kw= 'after'
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
        return current;
    }
    // $ANTLR end "ruleAfter"


    // $ANTLR start "entryRuleS"
    // PsiInternalBug378967TestLanguage.g:454:1: entryRuleS returns [Boolean current=false] : iv_ruleS= ruleS EOF ;
    public final Boolean entryRuleS() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleS = null;


        try {
            // PsiInternalBug378967TestLanguage.g:454:43: (iv_ruleS= ruleS EOF )
            // PsiInternalBug378967TestLanguage.g:455:2: iv_ruleS= ruleS EOF
            {
             markComposite(elementTypeProvider.getSElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleS=ruleS();

            state._fsp--;

             current =iv_ruleS; 
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
    // $ANTLR end "entryRuleS"


    // $ANTLR start "ruleS"
    // PsiInternalBug378967TestLanguage.g:461:1: ruleS returns [Boolean current=false] : kw= 's' ;
    public final Boolean ruleS() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalBug378967TestLanguage.g:462:1: (kw= 's' )
            // PsiInternalBug378967TestLanguage.g:463:2: kw= 's'
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
        return current;
    }
    // $ANTLR end "ruleS"


    // $ANTLR start "ruleFirstEnum"
    // PsiInternalBug378967TestLanguage.g:473:1: ruleFirstEnum returns [Boolean current=false] : (enumLiteral_0= 'after' ) ;
    public final Boolean ruleFirstEnum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:474:1: ( (enumLiteral_0= 'after' ) )
            // PsiInternalBug378967TestLanguage.g:475:2: (enumLiteral_0= 'after' )
            {
            // PsiInternalBug378967TestLanguage.g:475:2: (enumLiteral_0= 'after' )
            // PsiInternalBug378967TestLanguage.g:476:3: enumLiteral_0= 'after'
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
        return current;
    }
    // $ANTLR end "ruleFirstEnum"


    // $ANTLR start "ruleSecondEnum"
    // PsiInternalBug378967TestLanguage.g:487:1: ruleSecondEnum returns [Boolean current=false] : (enumLiteral_0= 's' ) ;
    public final Boolean ruleSecondEnum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalBug378967TestLanguage.g:488:1: ( (enumLiteral_0= 's' ) )
            // PsiInternalBug378967TestLanguage.g:489:2: (enumLiteral_0= 's' )
            {
            // PsiInternalBug378967TestLanguage.g:489:2: (enumLiteral_0= 's' )
            // PsiInternalBug378967TestLanguage.g:490:3: enumLiteral_0= 's'
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
        return current;
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