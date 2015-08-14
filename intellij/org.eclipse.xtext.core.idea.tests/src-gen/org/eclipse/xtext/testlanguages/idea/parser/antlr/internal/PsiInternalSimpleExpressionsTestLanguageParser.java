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
    // PsiInternalSimpleExpressionsTestLanguage.g:52:1: entryRuleSequence : ruleSequence EOF ;
    public final void entryRuleSequence() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:52:18: ( ruleSequence EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:53:2: ruleSequence EOF
            {
             markComposite(elementTypeProvider.getSequenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSequence();

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
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // PsiInternalSimpleExpressionsTestLanguage.g:58:1: ruleSequence : ( ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* ) ;
    public final void ruleSequence() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:58:13: ( ( ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:59:2: ( ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:59:2: ( ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )* )
            // PsiInternalSimpleExpressionsTestLanguage.g:60:3: ruleAddition ( () ( (lv_expressions_2_0= ruleAddition ) ) )*
            {

            			markComposite(elementTypeProvider.getSequence_AdditionParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            ruleAddition();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalSimpleExpressionsTestLanguage.g:67:3: ( () ( (lv_expressions_2_0= ruleAddition ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalSimpleExpressionsTestLanguage.g:68:4: () ( (lv_expressions_2_0= ruleAddition ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:68:4: ()
            	    // PsiInternalSimpleExpressionsTestLanguage.g:69:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getSequence_SequenceExpressionsAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:74:4: ( (lv_expressions_2_0= ruleAddition ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:75:5: (lv_expressions_2_0= ruleAddition )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:75:5: (lv_expressions_2_0= ruleAddition )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:76:6: lv_expressions_2_0= ruleAddition
            	    {

            	    						markComposite(elementTypeProvider.getSequence_ExpressionsAdditionParserRuleCall_1_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleAddition();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
        return ;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleAddition"
    // PsiInternalSimpleExpressionsTestLanguage.g:90:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:90:18: ( ruleAddition EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:91:2: ruleAddition EOF
            {
             markComposite(elementTypeProvider.getAdditionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAddition();

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
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // PsiInternalSimpleExpressionsTestLanguage.g:96:1: ruleAddition : ( ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* ) ;
    public final void ruleAddition() throws RecognitionException {
        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;

        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:96:13: ( ( ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:97:2: ( ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:97:2: ( ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )* )
            // PsiInternalSimpleExpressionsTestLanguage.g:98:3: ruleMultiplication ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition_MultiplicationParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            ruleMultiplication();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalSimpleExpressionsTestLanguage.g:105:3: ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalSimpleExpressionsTestLanguage.g:106:4: () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_values_3_0= ruleMultiplication ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:106:4: ()
            	    // PsiInternalSimpleExpressionsTestLanguage.g:107:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition_OpValuesAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:112:4: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:113:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:113:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:114:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:114:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
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
            	            // PsiInternalSimpleExpressionsTestLanguage.g:115:7: lv_operator_2_1= '+'
            	            {

            	            							markLeaf(elementTypeProvider.getAddition_OperatorPlusSignKeyword_1_1_0_0ElementType());
            	            						
            	            lv_operator_2_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_1);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalSimpleExpressionsTestLanguage.g:123:7: lv_operator_2_2= '-'
            	            {

            	            							markLeaf(elementTypeProvider.getAddition_OperatorHyphenMinusKeyword_1_1_0_1ElementType());
            	            						
            	            lv_operator_2_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_2);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:133:4: ( (lv_values_3_0= ruleMultiplication ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:134:5: (lv_values_3_0= ruleMultiplication )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:134:5: (lv_values_3_0= ruleMultiplication )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:135:6: lv_values_3_0= ruleMultiplication
            	    {

            	    						markComposite(elementTypeProvider.getAddition_ValuesMultiplicationParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    ruleMultiplication();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
        return ;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // PsiInternalSimpleExpressionsTestLanguage.g:149:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:149:24: ( ruleMultiplication EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:150:2: ruleMultiplication EOF
            {
             markComposite(elementTypeProvider.getMultiplicationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiplication();

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
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // PsiInternalSimpleExpressionsTestLanguage.g:155:1: ruleMultiplication : ( ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* ) ;
    public final void ruleMultiplication() throws RecognitionException {
        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;

        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:155:19: ( ( ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:156:2: ( ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:156:2: ( ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )* )
            // PsiInternalSimpleExpressionsTestLanguage.g:157:3: ruleTerm ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )*
            {

            			markComposite(elementTypeProvider.getMultiplication_TermParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_6);
            ruleTerm();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalSimpleExpressionsTestLanguage.g:164:3: ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=13 && LA5_0<=14)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalSimpleExpressionsTestLanguage.g:165:4: () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_values_3_0= ruleTerm ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:165:4: ()
            	    // PsiInternalSimpleExpressionsTestLanguage.g:166:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMultiplication_OpValuesAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:171:4: ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:172:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:172:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:173:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:173:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
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
            	            // PsiInternalSimpleExpressionsTestLanguage.g:174:7: lv_operator_2_1= '*'
            	            {

            	            							markLeaf(elementTypeProvider.getMultiplication_OperatorAsteriskKeyword_1_1_0_0ElementType());
            	            						
            	            lv_operator_2_1=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_1);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalSimpleExpressionsTestLanguage.g:182:7: lv_operator_2_2= '/'
            	            {

            	            							markLeaf(elementTypeProvider.getMultiplication_OperatorSolidusKeyword_1_1_0_1ElementType());
            	            						
            	            lv_operator_2_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            	            							doneLeaf(lv_operator_2_2);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalSimpleExpressionsTestLanguage.g:192:4: ( (lv_values_3_0= ruleTerm ) )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:193:5: (lv_values_3_0= ruleTerm )
            	    {
            	    // PsiInternalSimpleExpressionsTestLanguage.g:193:5: (lv_values_3_0= ruleTerm )
            	    // PsiInternalSimpleExpressionsTestLanguage.g:194:6: lv_values_3_0= ruleTerm
            	    {

            	    						markComposite(elementTypeProvider.getMultiplication_ValuesTermParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    ruleTerm();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
        return ;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleTerm"
    // PsiInternalSimpleExpressionsTestLanguage.g:208:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:208:14: ( ruleTerm EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:209:2: ruleTerm EOF
            {
             markComposite(elementTypeProvider.getTermElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerm();

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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // PsiInternalSimpleExpressionsTestLanguage.g:214:1: ruleTerm : ( ruleAtom | ruleParens ) ;
    public final void ruleTerm() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:214:9: ( ( ruleAtom | ruleParens ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:215:2: ( ruleAtom | ruleParens )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:215:2: ( ruleAtom | ruleParens )
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
                    // PsiInternalSimpleExpressionsTestLanguage.g:216:3: ruleAtom
                    {

                    			markComposite(elementTypeProvider.getTerm_AtomParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAtom();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleExpressionsTestLanguage.g:224:3: ruleParens
                    {

                    			markComposite(elementTypeProvider.getTerm_ParensParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParens();

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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // PsiInternalSimpleExpressionsTestLanguage.g:235:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:235:14: ( ruleAtom EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:236:2: ruleAtom EOF
            {
             markComposite(elementTypeProvider.getAtomElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAtom();

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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // PsiInternalSimpleExpressionsTestLanguage.g:241:1: ruleAtom : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleAtom() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:241:9: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:242:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:242:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:243:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:243:3: (lv_name_0_0= RULE_ID )
            // PsiInternalSimpleExpressionsTestLanguage.g:244:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getAtom_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParens"
    // PsiInternalSimpleExpressionsTestLanguage.g:256:1: entryRuleParens : ruleParens EOF ;
    public final void entryRuleParens() throws RecognitionException {
        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:256:16: ( ruleParens EOF )
            // PsiInternalSimpleExpressionsTestLanguage.g:257:2: ruleParens EOF
            {
             markComposite(elementTypeProvider.getParensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParens();

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
    // $ANTLR end "entryRuleParens"


    // $ANTLR start "ruleParens"
    // PsiInternalSimpleExpressionsTestLanguage.g:262:1: ruleParens : (otherlv_0= '(' ruleAddition otherlv_2= ')' ) ;
    public final void ruleParens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalSimpleExpressionsTestLanguage.g:262:11: ( (otherlv_0= '(' ruleAddition otherlv_2= ')' ) )
            // PsiInternalSimpleExpressionsTestLanguage.g:263:2: (otherlv_0= '(' ruleAddition otherlv_2= ')' )
            {
            // PsiInternalSimpleExpressionsTestLanguage.g:263:2: (otherlv_0= '(' ruleAddition otherlv_2= ')' )
            // PsiInternalSimpleExpressionsTestLanguage.g:264:3: otherlv_0= '(' ruleAddition otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParens_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParens_AdditionParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            ruleAddition();

            state._fsp--;


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
        return ;
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