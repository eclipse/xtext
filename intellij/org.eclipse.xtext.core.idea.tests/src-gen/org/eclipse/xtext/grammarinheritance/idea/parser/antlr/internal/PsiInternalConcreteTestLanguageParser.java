package org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalConcreteTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_ID", "RULE_INT", "RULE_STRING", "SUPER_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "':'", "'overriddenelement'", "'overridden other element'", "'-'", "'subrule1'", "'subrule3'", "'element'", "'overridemodel'", "'extendedmodel'"
    };
    public static final int RULE_ID=5;
    public static final int SUPER_ID=8;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_REAL=4;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public PsiInternalConcreteTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalConcreteTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalConcreteTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalConcreteTestLanguage.g"; }



    	protected ConcreteTestLanguageGrammarAccess grammarAccess;

    	protected ConcreteTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalConcreteTestLanguageParser(PsiBuilder builder, TokenStream input, ConcreteTestLanguageElementTypeProvider elementTypeProvider, ConcreteTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "RootRule";
    	}




    // $ANTLR start "entryRuleRootRule"
    // PsiInternalConcreteTestLanguage.g:52:1: entryRuleRootRule returns [Boolean current=false] : iv_ruleRootRule= ruleRootRule EOF ;
    public final Boolean entryRuleRootRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRootRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:52:50: (iv_ruleRootRule= ruleRootRule EOF )
            // PsiInternalConcreteTestLanguage.g:53:2: iv_ruleRootRule= ruleRootRule EOF
            {
             markComposite(elementTypeProvider.getRootRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRootRule=ruleRootRule();

            state._fsp--;

             current =iv_ruleRootRule; 
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
    // $ANTLR end "entryRuleRootRule"


    // $ANTLR start "ruleRootRule"
    // PsiInternalConcreteTestLanguage.g:59:1: ruleRootRule returns [Boolean current=false] : (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) ;
    public final Boolean ruleRootRule() throws RecognitionException {
        Boolean current = false;

        Boolean this_ConcreteParserRule_0 = null;

        Boolean this_CallOverridenParserRule_1 = null;

        Boolean this_CallExtendedParserRule_2 = null;

        Boolean this_OverridableParserRule2_3 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:60:1: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) )
            // PsiInternalConcreteTestLanguage.g:61:2: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            {
            // PsiInternalConcreteTestLanguage.g:61:2: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 21:
                {
                alt1=2;
                }
                break;
            case 22:
                {
                alt1=3;
                }
                break;
            case 16:
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
                    // PsiInternalConcreteTestLanguage.g:62:3: this_ConcreteParserRule_0= ruleConcreteParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_ConcreteParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ConcreteParserRule_0=ruleConcreteParserRule();

                    state._fsp--;


                    			current = this_ConcreteParserRule_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteTestLanguage.g:71:3: this_CallOverridenParserRule_1= ruleCallOverridenParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_CallOverridenParserRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CallOverridenParserRule_1=ruleCallOverridenParserRule();

                    state._fsp--;


                    			current = this_CallOverridenParserRule_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalConcreteTestLanguage.g:80:3: this_CallExtendedParserRule_2= ruleCallExtendedParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_CallExtendedParserRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CallExtendedParserRule_2=ruleCallExtendedParserRule();

                    state._fsp--;


                    			current = this_CallExtendedParserRule_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalConcreteTestLanguage.g:89:3: this_OverridableParserRule2_3= ruleOverridableParserRule2
                    {

                    			markComposite(elementTypeProvider.getRootRule_OverridableParserRule2ParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OverridableParserRule2_3=ruleOverridableParserRule2();

                    state._fsp--;


                    			current = this_OverridableParserRule2_3;
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
        return current;
    }
    // $ANTLR end "ruleRootRule"


    // $ANTLR start "entryRuleConcreteParserRule"
    // PsiInternalConcreteTestLanguage.g:101:1: entryRuleConcreteParserRule returns [Boolean current=false] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final Boolean entryRuleConcreteParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleConcreteParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:101:60: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:102:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
            {
             markComposite(elementTypeProvider.getConcreteParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConcreteParserRule=ruleConcreteParserRule();

            state._fsp--;

             current =iv_ruleConcreteParserRule; 
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
    // $ANTLR end "entryRuleConcreteParserRule"


    // $ANTLR start "ruleConcreteParserRule"
    // PsiInternalConcreteTestLanguage.g:108:1: ruleConcreteParserRule returns [Boolean current=false] : (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) ;
    public final Boolean ruleConcreteParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_magicNumber_1_0=null;
        Token otherlv_2=null;
        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:109:1: ( (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) )
            // PsiInternalConcreteTestLanguage.g:110:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            {
            // PsiInternalConcreteTestLanguage.g:110:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            // PsiInternalConcreteTestLanguage.g:111:3: otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            {

            			markLeaf(elementTypeProvider.getConcreteParserRule_ModelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:118:3: ( (lv_magicNumber_1_0= RULE_REAL ) )
            // PsiInternalConcreteTestLanguage.g:119:4: (lv_magicNumber_1_0= RULE_REAL )
            {
            // PsiInternalConcreteTestLanguage.g:119:4: (lv_magicNumber_1_0= RULE_REAL )
            // PsiInternalConcreteTestLanguage.g:120:5: lv_magicNumber_1_0= RULE_REAL
            {

            					markLeaf(elementTypeProvider.getConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_magicNumber_1_0=(Token)match(input,RULE_REAL,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_magicNumber_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getConcreteParserRule_ColonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteTestLanguage.g:142:3: ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalConcreteTestLanguage.g:143:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    {
            	    // PsiInternalConcreteTestLanguage.g:143:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    // PsiInternalConcreteTestLanguage.g:144:5: lv_elements_3_0= ruleInheritedParserRule
            	    {

            	    					markComposite(elementTypeProvider.getConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_elements_3_0=ruleInheritedParserRule();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
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
    // $ANTLR end "ruleConcreteParserRule"


    // $ANTLR start "entryRuleOverridableParserRule"
    // PsiInternalConcreteTestLanguage.g:161:1: entryRuleOverridableParserRule returns [Boolean current=false] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final Boolean entryRuleOverridableParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOverridableParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:161:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:162:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();

            state._fsp--;

             current =iv_ruleOverridableParserRule; 
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
    // $ANTLR end "entryRuleOverridableParserRule"


    // $ANTLR start "ruleOverridableParserRule"
    // PsiInternalConcreteTestLanguage.g:168:1: ruleOverridableParserRule returns [Boolean current=false] : (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleOverridableParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalConcreteTestLanguage.g:169:1: ( (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalConcreteTestLanguage.g:170:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteTestLanguage.g:170:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalConcreteTestLanguage.g:171:3: otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getOverridableParserRule_OverriddenelementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:178:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalConcreteTestLanguage.g:179:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalConcreteTestLanguage.g:179:4: (lv_name_1_0= RULE_ID )
            // PsiInternalConcreteTestLanguage.g:180:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleOverridableParserRule"


    // $ANTLR start "entryRuleCallOverridenParserRule"
    // PsiInternalConcreteTestLanguage.g:199:1: entryRuleCallOverridenParserRule returns [Boolean current=false] : iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF ;
    public final Boolean entryRuleCallOverridenParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCallOverridenParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:199:65: (iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:200:2: iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF
            {
             markComposite(elementTypeProvider.getCallOverridenParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallOverridenParserRule=ruleCallOverridenParserRule();

            state._fsp--;

             current =iv_ruleCallOverridenParserRule; 
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
    // $ANTLR end "entryRuleCallOverridenParserRule"


    // $ANTLR start "ruleCallOverridenParserRule"
    // PsiInternalConcreteTestLanguage.g:206:1: ruleCallOverridenParserRule returns [Boolean current=false] : ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) ;
    public final Boolean ruleCallOverridenParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean lv_call_0_0 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:207:1: ( ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) )
            // PsiInternalConcreteTestLanguage.g:208:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            {
            // PsiInternalConcreteTestLanguage.g:208:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            // PsiInternalConcreteTestLanguage.g:209:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            {
            // PsiInternalConcreteTestLanguage.g:209:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            // PsiInternalConcreteTestLanguage.g:210:4: lv_call_0_0= ruleAbstractCallOverridenParserRule
            {

            				markComposite(elementTypeProvider.getCallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_call_0_0=ruleAbstractCallOverridenParserRule();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallOverridenParserRule"


    // $ANTLR start "entryRuleOverridableParserRule2"
    // PsiInternalConcreteTestLanguage.g:226:1: entryRuleOverridableParserRule2 returns [Boolean current=false] : iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF ;
    public final Boolean entryRuleOverridableParserRule2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOverridableParserRule2 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:226:64: (iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF )
            // PsiInternalConcreteTestLanguage.g:227:2: iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridableParserRule2=ruleOverridableParserRule2();

            state._fsp--;

             current =iv_ruleOverridableParserRule2; 
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
    // $ANTLR end "entryRuleOverridableParserRule2"


    // $ANTLR start "ruleOverridableParserRule2"
    // PsiInternalConcreteTestLanguage.g:233:1: ruleOverridableParserRule2 returns [Boolean current=false] : (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) ;
    public final Boolean ruleOverridableParserRule2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_age_3_0=null;

        try {
            // PsiInternalConcreteTestLanguage.g:234:1: ( (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) )
            // PsiInternalConcreteTestLanguage.g:235:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            {
            // PsiInternalConcreteTestLanguage.g:235:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            // PsiInternalConcreteTestLanguage.g:236:3: otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) )
            {

            			markLeaf(elementTypeProvider.getOverridableParserRule2_OverriddenOtherElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:243:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalConcreteTestLanguage.g:244:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalConcreteTestLanguage.g:244:4: (lv_name_1_0= RULE_ID )
            // PsiInternalConcreteTestLanguage.g:245:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getOverridableParserRule2_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getOverridableParserRule2_HyphenMinusKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteTestLanguage.g:267:3: ( (lv_age_3_0= RULE_INT ) )
            // PsiInternalConcreteTestLanguage.g:268:4: (lv_age_3_0= RULE_INT )
            {
            // PsiInternalConcreteTestLanguage.g:268:4: (lv_age_3_0= RULE_INT )
            // PsiInternalConcreteTestLanguage.g:269:5: lv_age_3_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getOverridableParserRule2_AgeINTTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_age_3_0);
            				

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
    // $ANTLR end "ruleOverridableParserRule2"


    // $ANTLR start "entryRuleExtendableParserRule"
    // PsiInternalConcreteTestLanguage.g:288:1: entryRuleExtendableParserRule returns [Boolean current=false] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final Boolean entryRuleExtendableParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExtendableParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:288:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:289:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             markComposite(elementTypeProvider.getExtendableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();

            state._fsp--;

             current =iv_ruleExtendableParserRule; 
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
    // $ANTLR end "entryRuleExtendableParserRule"


    // $ANTLR start "ruleExtendableParserRule"
    // PsiInternalConcreteTestLanguage.g:295:1: ruleExtendableParserRule returns [Boolean current=false] : (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 ) ;
    public final Boolean ruleExtendableParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean this_Subrule1_0 = null;

        Boolean this_Subrule2_1 = null;

        Boolean this_Subrule3_2 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:296:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 ) )
            // PsiInternalConcreteTestLanguage.g:297:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 )
            {
            // PsiInternalConcreteTestLanguage.g:297:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_ID) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==RULE_STRING) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==RULE_INT) ) {
                        alt3=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalConcreteTestLanguage.g:298:3: this_Subrule1_0= ruleSubrule1
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Subrule1_0=ruleSubrule1();

                    state._fsp--;


                    			current = this_Subrule1_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteTestLanguage.g:307:3: this_Subrule2_1= ruleSubrule2
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule2ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Subrule2_1=ruleSubrule2();

                    state._fsp--;


                    			current = this_Subrule2_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalConcreteTestLanguage.g:316:3: this_Subrule3_2= ruleSubrule3
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule3ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Subrule3_2=ruleSubrule3();

                    state._fsp--;


                    			current = this_Subrule3_2;
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
        return current;
    }
    // $ANTLR end "ruleExtendableParserRule"


    // $ANTLR start "entryRuleSubrule1"
    // PsiInternalConcreteTestLanguage.g:328:1: entryRuleSubrule1 returns [Boolean current=false] : iv_ruleSubrule1= ruleSubrule1 EOF ;
    public final Boolean entryRuleSubrule1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSubrule1 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:328:50: (iv_ruleSubrule1= ruleSubrule1 EOF )
            // PsiInternalConcreteTestLanguage.g:329:2: iv_ruleSubrule1= ruleSubrule1 EOF
            {
             markComposite(elementTypeProvider.getSubrule1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubrule1=ruleSubrule1();

            state._fsp--;

             current =iv_ruleSubrule1; 
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
    // $ANTLR end "entryRuleSubrule1"


    // $ANTLR start "ruleSubrule1"
    // PsiInternalConcreteTestLanguage.g:335:1: ruleSubrule1 returns [Boolean current=false] : (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleSubrule1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;

        try {
            // PsiInternalConcreteTestLanguage.g:336:1: ( (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) )
            // PsiInternalConcreteTestLanguage.g:337:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteTestLanguage.g:337:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            // PsiInternalConcreteTestLanguage.g:338:3: otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSubrule1_Subrule1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:345:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalConcreteTestLanguage.g:346:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalConcreteTestLanguage.g:346:4: (lv_name_1_0= RULE_ID )
            // PsiInternalConcreteTestLanguage.g:347:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSubrule1_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalConcreteTestLanguage.g:362:3: ( (lv_sub1_2_0= RULE_ID ) )
            // PsiInternalConcreteTestLanguage.g:363:4: (lv_sub1_2_0= RULE_ID )
            {
            // PsiInternalConcreteTestLanguage.g:363:4: (lv_sub1_2_0= RULE_ID )
            // PsiInternalConcreteTestLanguage.g:364:5: lv_sub1_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSubrule1_Sub1IDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_sub1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_sub1_2_0);
            				

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
    // $ANTLR end "ruleSubrule1"


    // $ANTLR start "entryRuleSubrule2"
    // PsiInternalConcreteTestLanguage.g:383:1: entryRuleSubrule2 returns [Boolean current=false] : iv_ruleSubrule2= ruleSubrule2 EOF ;
    public final Boolean entryRuleSubrule2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSubrule2 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:383:50: (iv_ruleSubrule2= ruleSubrule2 EOF )
            // PsiInternalConcreteTestLanguage.g:384:2: iv_ruleSubrule2= ruleSubrule2 EOF
            {
             markComposite(elementTypeProvider.getSubrule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubrule2=ruleSubrule2();

            state._fsp--;

             current =iv_ruleSubrule2; 
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
    // $ANTLR end "entryRuleSubrule2"


    // $ANTLR start "ruleSubrule2"
    // PsiInternalConcreteTestLanguage.g:390:1: ruleSubrule2 returns [Boolean current=false] : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) ;
    public final Boolean ruleSubrule2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub2_2_0=null;

        try {
            // PsiInternalConcreteTestLanguage.g:391:1: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) )
            // PsiInternalConcreteTestLanguage.g:392:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            {
            // PsiInternalConcreteTestLanguage.g:392:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            // PsiInternalConcreteTestLanguage.g:393:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getSubrule2_Subrule3Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:400:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalConcreteTestLanguage.g:401:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalConcreteTestLanguage.g:401:4: (lv_name_1_0= RULE_ID )
            // PsiInternalConcreteTestLanguage.g:402:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSubrule2_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalConcreteTestLanguage.g:417:3: ( (lv_sub2_2_0= RULE_STRING ) )
            // PsiInternalConcreteTestLanguage.g:418:4: (lv_sub2_2_0= RULE_STRING )
            {
            // PsiInternalConcreteTestLanguage.g:418:4: (lv_sub2_2_0= RULE_STRING )
            // PsiInternalConcreteTestLanguage.g:419:5: lv_sub2_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getSubrule2_Sub2STRINGTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_sub2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_sub2_2_0);
            				

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
    // $ANTLR end "ruleSubrule2"


    // $ANTLR start "entryRuleSubrule3"
    // PsiInternalConcreteTestLanguage.g:438:1: entryRuleSubrule3 returns [Boolean current=false] : iv_ruleSubrule3= ruleSubrule3 EOF ;
    public final Boolean entryRuleSubrule3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSubrule3 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:438:50: (iv_ruleSubrule3= ruleSubrule3 EOF )
            // PsiInternalConcreteTestLanguage.g:439:2: iv_ruleSubrule3= ruleSubrule3 EOF
            {
             markComposite(elementTypeProvider.getSubrule3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubrule3=ruleSubrule3();

            state._fsp--;

             current =iv_ruleSubrule3; 
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
    // $ANTLR end "entryRuleSubrule3"


    // $ANTLR start "ruleSubrule3"
    // PsiInternalConcreteTestLanguage.g:445:1: ruleSubrule3 returns [Boolean current=false] : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) ;
    public final Boolean ruleSubrule3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;

        try {
            // PsiInternalConcreteTestLanguage.g:446:1: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) )
            // PsiInternalConcreteTestLanguage.g:447:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            {
            // PsiInternalConcreteTestLanguage.g:447:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            // PsiInternalConcreteTestLanguage.g:448:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) )
            {

            			markLeaf(elementTypeProvider.getSubrule3_Subrule3Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:455:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalConcreteTestLanguage.g:456:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalConcreteTestLanguage.g:456:4: (lv_name_1_0= RULE_ID )
            // PsiInternalConcreteTestLanguage.g:457:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSubrule3_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalConcreteTestLanguage.g:472:3: ( (lv_sub1_2_0= RULE_INT ) )
            // PsiInternalConcreteTestLanguage.g:473:4: (lv_sub1_2_0= RULE_INT )
            {
            // PsiInternalConcreteTestLanguage.g:473:4: (lv_sub1_2_0= RULE_INT )
            // PsiInternalConcreteTestLanguage.g:474:5: lv_sub1_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getSubrule3_Sub1INTTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_sub1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_sub1_2_0);
            				

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
    // $ANTLR end "ruleSubrule3"


    // $ANTLR start "entryRuleCallExtendedParserRule"
    // PsiInternalConcreteTestLanguage.g:493:1: entryRuleCallExtendedParserRule returns [Boolean current=false] : iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF ;
    public final Boolean entryRuleCallExtendedParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCallExtendedParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:493:64: (iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:494:2: iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF
            {
             markComposite(elementTypeProvider.getCallExtendedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallExtendedParserRule=ruleCallExtendedParserRule();

            state._fsp--;

             current =iv_ruleCallExtendedParserRule; 
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
    // $ANTLR end "entryRuleCallExtendedParserRule"


    // $ANTLR start "ruleCallExtendedParserRule"
    // PsiInternalConcreteTestLanguage.g:500:1: ruleCallExtendedParserRule returns [Boolean current=false] : ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) ;
    public final Boolean ruleCallExtendedParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean lv_call_0_0 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:501:1: ( ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) )
            // PsiInternalConcreteTestLanguage.g:502:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            {
            // PsiInternalConcreteTestLanguage.g:502:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            // PsiInternalConcreteTestLanguage.g:503:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            {
            // PsiInternalConcreteTestLanguage.g:503:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            // PsiInternalConcreteTestLanguage.g:504:4: lv_call_0_0= ruleAbstractCallExtendedParserRule
            {

            				markComposite(elementTypeProvider.getCallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_call_0_0=ruleAbstractCallExtendedParserRule();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallExtendedParserRule"


    // $ANTLR start "entryRuleInheritedParserRule"
    // PsiInternalConcreteTestLanguage.g:520:1: entryRuleInheritedParserRule returns [Boolean current=false] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final Boolean entryRuleInheritedParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleInheritedParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:520:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:521:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             markComposite(elementTypeProvider.getInheritedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();

            state._fsp--;

             current =iv_ruleInheritedParserRule; 
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
    // $ANTLR end "entryRuleInheritedParserRule"


    // $ANTLR start "ruleInheritedParserRule"
    // PsiInternalConcreteTestLanguage.g:527:1: ruleInheritedParserRule returns [Boolean current=false] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleInheritedParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalConcreteTestLanguage.g:528:1: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalConcreteTestLanguage.g:529:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteTestLanguage.g:529:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalConcreteTestLanguage.g:530:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getInheritedParserRule_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:537:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalConcreteTestLanguage.g:538:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalConcreteTestLanguage.g:538:4: (lv_name_1_0= RULE_ID )
            // PsiInternalConcreteTestLanguage.g:539:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleInheritedParserRule"


    // $ANTLR start "entryRuleAbstractCallOverridenParserRule"
    // PsiInternalConcreteTestLanguage.g:558:1: entryRuleAbstractCallOverridenParserRule returns [Boolean current=false] : iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF ;
    public final Boolean entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractCallOverridenParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:558:73: (iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:559:2: iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF
            {
             markComposite(elementTypeProvider.getAbstractCallOverridenParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractCallOverridenParserRule=ruleAbstractCallOverridenParserRule();

            state._fsp--;

             current =iv_ruleAbstractCallOverridenParserRule; 
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
    // $ANTLR end "entryRuleAbstractCallOverridenParserRule"


    // $ANTLR start "ruleAbstractCallOverridenParserRule"
    // PsiInternalConcreteTestLanguage.g:565:1: ruleAbstractCallOverridenParserRule returns [Boolean current=false] : (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) ;
    public final Boolean ruleAbstractCallOverridenParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_elements_1_0 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:566:1: ( (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) )
            // PsiInternalConcreteTestLanguage.g:567:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            {
            // PsiInternalConcreteTestLanguage.g:567:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            // PsiInternalConcreteTestLanguage.g:568:3: otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            {

            			markLeaf(elementTypeProvider.getAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:575:3: ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalConcreteTestLanguage.g:576:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    {
            	    // PsiInternalConcreteTestLanguage.g:576:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    // PsiInternalConcreteTestLanguage.g:577:5: lv_elements_1_0= ruleOverridableParserRule
            	    {

            	    					markComposite(elementTypeProvider.getAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_elements_1_0=ruleOverridableParserRule();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleAbstractCallOverridenParserRule"


    // $ANTLR start "entryRuleAbstractCallExtendedParserRule"
    // PsiInternalConcreteTestLanguage.g:594:1: entryRuleAbstractCallExtendedParserRule returns [Boolean current=false] : iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF ;
    public final Boolean entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractCallExtendedParserRule = null;


        try {
            // PsiInternalConcreteTestLanguage.g:594:72: (iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF )
            // PsiInternalConcreteTestLanguage.g:595:2: iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF
            {
             markComposite(elementTypeProvider.getAbstractCallExtendedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractCallExtendedParserRule=ruleAbstractCallExtendedParserRule();

            state._fsp--;

             current =iv_ruleAbstractCallExtendedParserRule; 
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
    // $ANTLR end "entryRuleAbstractCallExtendedParserRule"


    // $ANTLR start "ruleAbstractCallExtendedParserRule"
    // PsiInternalConcreteTestLanguage.g:601:1: ruleAbstractCallExtendedParserRule returns [Boolean current=false] : (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) ;
    public final Boolean ruleAbstractCallExtendedParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_elements_1_0 = null;


        try {
            // PsiInternalConcreteTestLanguage.g:602:1: ( (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) )
            // PsiInternalConcreteTestLanguage.g:603:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            {
            // PsiInternalConcreteTestLanguage.g:603:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            // PsiInternalConcreteTestLanguage.g:604:3: otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            {

            			markLeaf(elementTypeProvider.getAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteTestLanguage.g:611:3: ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=18 && LA5_0<=19)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalConcreteTestLanguage.g:612:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    {
            	    // PsiInternalConcreteTestLanguage.g:612:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    // PsiInternalConcreteTestLanguage.g:613:5: lv_elements_1_0= ruleExtendableParserRule
            	    {

            	    					markComposite(elementTypeProvider.getAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_elements_1_0=ruleExtendableParserRule();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleAbstractCallExtendedParserRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000C0002L});
    }


}