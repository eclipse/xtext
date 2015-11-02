package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSimpleExpressionsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalSimpleExpressionsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSimpleExpressionsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSimpleExpressionsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSimpleExpressionsTestLanguage.g"; }



    	protected SimpleExpressionsTestLanguageGrammarAccess grammarAccess;

    	protected SimpleExpressionsTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSimpleExpressionsTestLanguageParser(PsiBuilder builder, TokenStream input, SimpleExpressionsTestLanguageElementTypeProvider elementTypeProvider, SimpleExpressionsTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Sequence";
    	}




    // $ANTLR start "entryRuleSequence"
    // PsiInternalSimpleExpressionsTestLanguage.g:52:1: entryRuleSequence returns [Boolean current=false] : iv_ruleSequence= ruleSequence EOF ;
    public final Boolean entryRuleSequence() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSequence = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:52:50: (iv_ruleSequence= ruleSequence EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:53:2: iv_ruleSequence= ruleSequence EOF
            {
             markComposite(elementTypeProvider.getSequenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence; 
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
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // PsiInternalSimpleExpressionsTestLanguage.g:59:1: ruleSequence returns [Boolean current=false] : (this_Addition_0= ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* ) ;
    public final Boolean ruleSequence() throws RecognitionException {
        Boolean current = false;

        Boolean this_Addition_0 = null;

        Boolean lv_expressions_2_0 = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:60:1: ( (this_Addition_0= ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:61:2: (this_Addition_0= ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:61:2: (this_Addition_0= ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* )
            // PsiInternalSimpleExpressionsTestLanguage.g:62:3: this_Addition_0= ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )*
            {

            			markComposite(elementTypeProvider.getSequence_AdditionParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Addition_0=ruleAddition();

            state._fsp--;


            			current = this_Addition_0;
            			doneComposite();
            		
            // PsiInternalSimpleExpressionsTestLanguage.g:70:3: ( () ( (lv_expressions_2_0= ruleAddition ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalSimpleExpressionsTestLanguage.g:71:4: () ( (lv_expressions_2_0= ruleAddition ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:71:4: ()
            	    // PsiInternalSimpleExpressionsTestLanguage.g:72:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getSequence_SequenceExpressionsAction_1_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:78:4: ( (lv_expressions_2_0= ruleAddition ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:79:5: (lv_expressions_2_0= ruleAddition )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:79:5: (lv_expressions_2_0= ruleAddition )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:80:6: lv_expressions_2_0= ruleAddition
            	    {

            	    						markComposite(elementTypeProvider.getSequence_ExpressionsAdditionParserRuleCall_1_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_expressions_2_0=ruleAddition();

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

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleAddition"
    // PsiInternalSimpleExpressionsTestLanguage.g:98:1: entryRuleAddition returns [Boolean current=false] : iv_ruleAddition= ruleAddition EOF ;
    public final Boolean entryRuleAddition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAddition = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:98:50: (iv_ruleAddition= ruleAddition EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:99:2: iv_ruleAddition= ruleAddition EOF
            {
             markComposite(elementTypeProvider.getAdditionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
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
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // PsiInternalSimpleExpressionsTestLanguage.g:105:1: ruleAddition returns [Boolean current=false] : (this_Multiplication_0= ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* ) ;
    public final Boolean ruleAddition() throws RecognitionException {
        Boolean current = false;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Boolean this_Multiplication_0 = null;

        Boolean lv_values_3_0 = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:106:1: ( (this_Multiplication_0= ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:107:2: (this_Multiplication_0= ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:107:2: (this_Multiplication_0= ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* )
            // PsiInternalSimpleExpressionsTestLanguage.g:108:3: this_Multiplication_0= ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition_MultiplicationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			doneComposite();
            		
            // PsiInternalSimpleExpressionsTestLanguage.g:116:3: ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalSimpleExpressionsTestLanguage.g:117:4: () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:117:4: ()
            	    // PsiInternalSimpleExpressionsTestLanguage.g:118:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition_OpValuesAction_1_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:124:4: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:125:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:125:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:126:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:126:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==11) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==12) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // PsiInternalSimpleExpressionsTestLanguage.g:127:7: lv_operator_2_1= '+'
            	            {

            	            							markLeaf(elementTypeProvider.getAddition_OperatorPlusSignKeyword_1_1_0_0ElementType());
            	            						
            	            lv_operator_2_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_1);
            	            						

            	            							if (!current) {
            	            								associateWithSemanticElement();
            	            								current = true;
            	            							}
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalSimpleExpressionsTestLanguage.g:141:7: lv_operator_2_2= '-'
            	            {

            	            							markLeaf(elementTypeProvider.getAddition_OperatorHyphenMinusKeyword_1_1_0_1ElementType());
            	            						
            	            lv_operator_2_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_2);
            	            						

            	            							if (!current) {
            	            								associateWithSemanticElement();
            	            								current = true;
            	            							}
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:157:4: ( (lv_values_3_0= ruleMultiplication ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:158:5: (lv_values_3_0= ruleMultiplication )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:158:5: (lv_values_3_0= ruleMultiplication )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:159:6: lv_values_3_0= ruleMultiplication
            	    {

            	    						markComposite(elementTypeProvider.getAddition_ValuesMultiplicationParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_values_3_0=ruleMultiplication();

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

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // PsiInternalSimpleExpressionsTestLanguage.g:177:1: entryRuleMultiplication returns [Boolean current=false] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final Boolean entryRuleMultiplication() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiplication = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:177:56: (iv_ruleMultiplication= ruleMultiplication EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:178:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             markComposite(elementTypeProvider.getMultiplicationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
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
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // PsiInternalSimpleExpressionsTestLanguage.g:184:1: ruleMultiplication returns [Boolean current=false] : (this_Term_0= ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* ) ;
    public final Boolean ruleMultiplication() throws RecognitionException {
        Boolean current = false;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Boolean this_Term_0 = null;

        Boolean lv_values_3_0 = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:185:1: ( (this_Term_0= ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:186:2: (this_Term_0= ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:186:2: (this_Term_0= ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* )
            // PsiInternalSimpleExpressionsTestLanguage.g:187:3: this_Term_0= ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )*
            {

            			markComposite(elementTypeProvider.getMultiplication_TermParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_6);
            this_Term_0=ruleTerm();

            state._fsp--;


            			current = this_Term_0;
            			doneComposite();
            		
            // PsiInternalSimpleExpressionsTestLanguage.g:195:3: ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=13 && LA5_0<=14)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalSimpleExpressionsTestLanguage.g:196:4: () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:196:4: ()
            	    // PsiInternalSimpleExpressionsTestLanguage.g:197:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMultiplication_OpValuesAction_1_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:203:4: ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:204:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:204:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:205:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:205:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==13) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==14) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // PsiInternalSimpleExpressionsTestLanguage.g:206:7: lv_operator_2_1= '*'
            	            {

            	            							markLeaf(elementTypeProvider.getMultiplication_OperatorAsteriskKeyword_1_1_0_0ElementType());
            	            						
            	            lv_operator_2_1=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_1);
            	            						

            	            							if (!current) {
            	            								associateWithSemanticElement();
            	            								current = true;
            	            							}
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalSimpleExpressionsTestLanguage.g:220:7: lv_operator_2_2= '/'
            	            {

            	            							markLeaf(elementTypeProvider.getMultiplication_OperatorSolidusKeyword_1_1_0_1ElementType());
            	            						
            	            lv_operator_2_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_2);
            	            						

            	            							if (!current) {
            	            								associateWithSemanticElement();
            	            								current = true;
            	            							}
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:236:4: ( (lv_values_3_0= ruleTerm ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:237:5: (lv_values_3_0= ruleTerm )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:237:5: (lv_values_3_0= ruleTerm )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:238:6: lv_values_3_0= ruleTerm
            	    {

            	    						markComposite(elementTypeProvider.getMultiplication_ValuesTermParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_values_3_0=ruleTerm();

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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleTerm"
    // PsiInternalSimpleExpressionsTestLanguage.g:256:1: entryRuleTerm returns [Boolean current=false] : iv_ruleTerm= ruleTerm EOF ;
    public final Boolean entryRuleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerm = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:256:46: (iv_ruleTerm= ruleTerm EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:257:2: iv_ruleTerm= ruleTerm EOF
            {
             markComposite(elementTypeProvider.getTermElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // PsiInternalSimpleExpressionsTestLanguage.g:263:1: ruleTerm returns [Boolean current=false] : (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) ;
    public final Boolean ruleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean this_Atom_0 = null;

        Boolean this_Parens_1 = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:264:1: ( (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:265:2: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:265:2: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalSimpleExpressionsTestLanguage.g:266:3: this_Atom_0= ruleAtom
                    {

                    			markComposite(elementTypeProvider.getTerm_AtomParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Atom_0=ruleAtom();

                    state._fsp--;


                    			current = this_Atom_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleExpressionsTestLanguage.g:275:3: this_Parens_1= ruleParens
                    {

                    			markComposite(elementTypeProvider.getTerm_ParensParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Parens_1=ruleParens();

                    state._fsp--;


                    			current = this_Parens_1;
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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // PsiInternalSimpleExpressionsTestLanguage.g:287:1: entryRuleAtom returns [Boolean current=false] : iv_ruleAtom= ruleAtom EOF ;
    public final Boolean entryRuleAtom() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAtom = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:287:46: (iv_ruleAtom= ruleAtom EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:288:2: iv_ruleAtom= ruleAtom EOF
            {
             markComposite(elementTypeProvider.getAtomElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // PsiInternalSimpleExpressionsTestLanguage.g:294:1: ruleAtom returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleAtom() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:295:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:296:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:296:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:297:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:297:3: (lv_name_0_0= RULE_ID )
            // PsiInternalSimpleExpressionsTestLanguage.g:298:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getAtom_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				doneLeaf(lv_name_0_0);
            			

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
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParens"
    // PsiInternalSimpleExpressionsTestLanguage.g:316:1: entryRuleParens returns [Boolean current=false] : iv_ruleParens= ruleParens EOF ;
    public final Boolean entryRuleParens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParens = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:316:48: (iv_ruleParens= ruleParens EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:317:2: iv_ruleParens= ruleParens EOF
            {
             markComposite(elementTypeProvider.getParensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParens=ruleParens();

            state._fsp--;

             current =iv_ruleParens; 
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
    // $ANTLR end "entryRuleParens"


    // $ANTLR start "ruleParens"
    // PsiInternalSimpleExpressionsTestLanguage.g:323:1: ruleParens returns [Boolean current=false] : (otherlv_0= '(' this_Addition_1= ruleAddition otherlv_2= ')' ) ;
    public final Boolean ruleParens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Addition_1 = null;


        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:324:1: ( (otherlv_0= '(' this_Addition_1= ruleAddition otherlv_2= ')' ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:325:2: (otherlv_0= '(' this_Addition_1= ruleAddition otherlv_2= ')' )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:325:2: (otherlv_0= '(' this_Addition_1= ruleAddition otherlv_2= ')' )
            // PsiInternalSimpleExpressionsTestLanguage.g:326:3: otherlv_0= '(' this_Addition_1= ruleAddition otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParens_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParens_AdditionParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_Addition_1=ruleAddition();

            state._fsp--;


            			current = this_Addition_1;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParens_RightParenthesisKeyword_2ElementType());
            		
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
    // $ANTLR end "ruleParens"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    }


}