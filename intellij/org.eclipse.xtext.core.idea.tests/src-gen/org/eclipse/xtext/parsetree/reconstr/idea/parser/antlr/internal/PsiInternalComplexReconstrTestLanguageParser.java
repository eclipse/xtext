package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalComplexReconstrTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'-'", "'('", "')'", "'!'", "'TG'", "'['", "','", "']'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
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


        public PsiInternalComplexReconstrTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalComplexReconstrTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalComplexReconstrTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalComplexReconstrTestLanguage.g"; }



    	protected ComplexReconstrTestLanguageGrammarAccess grammarAccess;

    	protected ComplexReconstrTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalComplexReconstrTestLanguageParser(PsiBuilder builder, TokenStream input, ComplexReconstrTestLanguageElementTypeProvider elementTypeProvider, ComplexReconstrTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalComplexReconstrTestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:52:14: ( ruleRoot EOF )
            // PsiInternalComplexReconstrTestLanguage.g:53:2: ruleRoot EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:58:1: ruleRoot : ( ruleOp | ruleTrickyG ) ;
    public final void ruleRoot() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:58:9: ( ( ruleOp | ruleTrickyG ) )
            // PsiInternalComplexReconstrTestLanguage.g:59:2: ( ruleOp | ruleTrickyG )
            {
            // PsiInternalComplexReconstrTestLanguage.g:59:2: ( ruleOp | ruleTrickyG )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==16) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalComplexReconstrTestLanguage.g:60:3: ruleOp
                    {

                    			markComposite(elementTypeProvider.getRoot_OpParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleOp();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalComplexReconstrTestLanguage.g:68:3: ruleTrickyG
                    {

                    			markComposite(elementTypeProvider.getRoot_TrickyGParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTrickyG();

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleOp"
    // PsiInternalComplexReconstrTestLanguage.g:79:1: entryRuleOp : ruleOp EOF ;
    public final void entryRuleOp() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:79:12: ( ruleOp EOF )
            // PsiInternalComplexReconstrTestLanguage.g:80:2: ruleOp EOF
            {
             markComposite(elementTypeProvider.getOpElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOp();

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
    // $ANTLR end "entryRuleOp"


    // $ANTLR start "ruleOp"
    // PsiInternalComplexReconstrTestLanguage.g:85:1: ruleOp : ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) ;
    public final void ruleOp() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // PsiInternalComplexReconstrTestLanguage.g:85:7: ( ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) )
            // PsiInternalComplexReconstrTestLanguage.g:86:2: ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            {
            // PsiInternalComplexReconstrTestLanguage.g:86:2: ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            // PsiInternalComplexReconstrTestLanguage.g:87:3: ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
            {

            			markComposite(elementTypeProvider.getOp_TermParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            ruleTerm();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalComplexReconstrTestLanguage.g:94:3: ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }
                else if ( (LA2_0==12) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalComplexReconstrTestLanguage.g:95:4: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:95:4: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:96:5: () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:96:5: ()
            	    // PsiInternalComplexReconstrTestLanguage.g:97:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getOp_AddAddOperandsAction_1_0_0ElementType());
            	    						doneComposite();
            	    					

            	    }


            	    					markLeaf(elementTypeProvider.getOp_PlusSignKeyword_1_0_1ElementType());
            	    				
            	    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            	    					doneLeaf(otherlv_2);
            	    				
            	    // PsiInternalComplexReconstrTestLanguage.g:109:5: ( (lv_addOperands_3_0= ruleTerm ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:110:6: (lv_addOperands_3_0= ruleTerm )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:110:6: (lv_addOperands_3_0= ruleTerm )
            	    // PsiInternalComplexReconstrTestLanguage.g:111:7: lv_addOperands_3_0= ruleTerm
            	    {

            	    							markComposite(elementTypeProvider.getOp_AddOperandsTermParserRuleCall_1_0_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleTerm();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalComplexReconstrTestLanguage.g:122:4: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:122:4: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:123:5: () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:123:5: ()
            	    // PsiInternalComplexReconstrTestLanguage.g:124:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getOp_MinusMinusOperandsAction_1_1_0ElementType());
            	    						doneComposite();
            	    					

            	    }


            	    					markLeaf(elementTypeProvider.getOp_HyphenMinusKeyword_1_1_1ElementType());
            	    				
            	    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    					doneLeaf(otherlv_5);
            	    				
            	    // PsiInternalComplexReconstrTestLanguage.g:136:5: ( (lv_minusOperands_6_0= ruleTerm ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:137:6: (lv_minusOperands_6_0= ruleTerm )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:137:6: (lv_minusOperands_6_0= ruleTerm )
            	    // PsiInternalComplexReconstrTestLanguage.g:138:7: lv_minusOperands_6_0= ruleTerm
            	    {

            	    							markComposite(elementTypeProvider.getOp_MinusOperandsTermParserRuleCall_1_1_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleTerm();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


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
    // $ANTLR end "ruleOp"


    // $ANTLR start "entryRuleTerm"
    // PsiInternalComplexReconstrTestLanguage.g:153:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:153:14: ( ruleTerm EOF )
            // PsiInternalComplexReconstrTestLanguage.g:154:2: ruleTerm EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:159:1: ruleTerm : ( ruleAtom | ruleParens ) ;
    public final void ruleTerm() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:159:9: ( ( ruleAtom | ruleParens ) )
            // PsiInternalComplexReconstrTestLanguage.g:160:2: ( ruleAtom | ruleParens )
            {
            // PsiInternalComplexReconstrTestLanguage.g:160:2: ( ruleAtom | ruleParens )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalComplexReconstrTestLanguage.g:161:3: ruleAtom
                    {

                    			markComposite(elementTypeProvider.getTerm_AtomParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAtom();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalComplexReconstrTestLanguage.g:169:3: ruleParens
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
    // PsiInternalComplexReconstrTestLanguage.g:180:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:180:14: ( ruleAtom EOF )
            // PsiInternalComplexReconstrTestLanguage.g:181:2: ruleAtom EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:186:1: ruleAtom : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleAtom() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalComplexReconstrTestLanguage.g:186:9: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:187:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalComplexReconstrTestLanguage.g:187:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalComplexReconstrTestLanguage.g:188:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalComplexReconstrTestLanguage.g:188:3: (lv_name_0_0= RULE_ID )
            // PsiInternalComplexReconstrTestLanguage.g:189:4: lv_name_0_0= RULE_ID
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
    // PsiInternalComplexReconstrTestLanguage.g:201:1: entryRuleParens : ruleParens EOF ;
    public final void entryRuleParens() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:201:16: ( ruleParens EOF )
            // PsiInternalComplexReconstrTestLanguage.g:202:2: ruleParens EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:207:1: ruleParens : (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final void ruleParens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;

        try {
            // PsiInternalComplexReconstrTestLanguage.g:207:11: ( (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // PsiInternalComplexReconstrTestLanguage.g:208:2: (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // PsiInternalComplexReconstrTestLanguage.g:208:2: (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // PsiInternalComplexReconstrTestLanguage.g:209:3: otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {

            			markLeaf(elementTypeProvider.getParens_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParens_OpParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_5);
            ruleOp();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParens_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalComplexReconstrTestLanguage.g:230:3: ( (lv_em_3_0= '!' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalComplexReconstrTestLanguage.g:231:4: (lv_em_3_0= '!' )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:231:4: (lv_em_3_0= '!' )
                    // PsiInternalComplexReconstrTestLanguage.g:232:5: lv_em_3_0= '!'
                    {

                    					markLeaf(elementTypeProvider.getParens_EmExclamationMarkKeyword_3_0ElementType());
                    				
                    lv_em_3_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_em_3_0);
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleParens"


    // $ANTLR start "entryRuleTrickyG"
    // PsiInternalComplexReconstrTestLanguage.g:245:1: entryRuleTrickyG : ruleTrickyG EOF ;
    public final void entryRuleTrickyG() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:245:17: ( ruleTrickyG EOF )
            // PsiInternalComplexReconstrTestLanguage.g:246:2: ruleTrickyG EOF
            {
             markComposite(elementTypeProvider.getTrickyGElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTrickyG();

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
    // $ANTLR end "entryRuleTrickyG"


    // $ANTLR start "ruleTrickyG"
    // PsiInternalComplexReconstrTestLanguage.g:251:1: ruleTrickyG : (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) ;
    public final void ruleTrickyG() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalComplexReconstrTestLanguage.g:251:12: ( (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:252:2: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            {
            // PsiInternalComplexReconstrTestLanguage.g:252:2: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:253:3: otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) )
            {

            			markLeaf(elementTypeProvider.getTrickyG_TGKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalComplexReconstrTestLanguage.g:260:3: ( (lv_tree_1_0= ruleTrickyG1 ) )
            // PsiInternalComplexReconstrTestLanguage.g:261:4: (lv_tree_1_0= ruleTrickyG1 )
            {
            // PsiInternalComplexReconstrTestLanguage.g:261:4: (lv_tree_1_0= ruleTrickyG1 )
            // PsiInternalComplexReconstrTestLanguage.g:262:5: lv_tree_1_0= ruleTrickyG1
            {

            					markComposite(elementTypeProvider.getTrickyG_TreeTrickyG1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTrickyG1();

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
    // $ANTLR end "ruleTrickyG"


    // $ANTLR start "entryRuleTrickyG1"
    // PsiInternalComplexReconstrTestLanguage.g:275:1: entryRuleTrickyG1 : ruleTrickyG1 EOF ;
    public final void entryRuleTrickyG1() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:275:18: ( ruleTrickyG1 EOF )
            // PsiInternalComplexReconstrTestLanguage.g:276:2: ruleTrickyG1 EOF
            {
             markComposite(elementTypeProvider.getTrickyG1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTrickyG1();

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
    // $ANTLR end "entryRuleTrickyG1"


    // $ANTLR start "ruleTrickyG1"
    // PsiInternalComplexReconstrTestLanguage.g:281:1: ruleTrickyG1 : (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) ;
    public final void ruleTrickyG1() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalComplexReconstrTestLanguage.g:281:13: ( (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) )
            // PsiInternalComplexReconstrTestLanguage.g:282:2: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            {
            // PsiInternalComplexReconstrTestLanguage.g:282:2: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            // PsiInternalComplexReconstrTestLanguage.g:283:3: otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']'
            {

            			markLeaf(elementTypeProvider.getTrickyG1_LeftSquareBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalComplexReconstrTestLanguage.g:290:3: ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT||LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalComplexReconstrTestLanguage.g:291:4: ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:291:4: ( (lv_vals_1_0= ruleTrickyG2 ) )
                    // PsiInternalComplexReconstrTestLanguage.g:292:5: (lv_vals_1_0= ruleTrickyG2 )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:292:5: (lv_vals_1_0= ruleTrickyG2 )
                    // PsiInternalComplexReconstrTestLanguage.g:293:6: lv_vals_1_0= ruleTrickyG2
                    {

                    						markComposite(elementTypeProvider.getTrickyG1_ValsTrickyG2ParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    ruleTrickyG2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalComplexReconstrTestLanguage.g:302:4: (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // PsiInternalComplexReconstrTestLanguage.g:303:5: otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getTrickyG1_CommaKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_10); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalComplexReconstrTestLanguage.g:310:5: ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    // PsiInternalComplexReconstrTestLanguage.g:311:6: (lv_vals_3_0= ruleTrickyG2 )
                    	    {
                    	    // PsiInternalComplexReconstrTestLanguage.g:311:6: (lv_vals_3_0= ruleTrickyG2 )
                    	    // PsiInternalComplexReconstrTestLanguage.g:312:7: lv_vals_3_0= ruleTrickyG2
                    	    {

                    	    							markComposite(elementTypeProvider.getTrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_9);
                    	    ruleTrickyG2();

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
                    break;

            }


            			markLeaf(elementTypeProvider.getTrickyG1_RightSquareBracketKeyword_2ElementType());
            		
            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

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
    // $ANTLR end "ruleTrickyG1"


    // $ANTLR start "entryRuleTrickyG2"
    // PsiInternalComplexReconstrTestLanguage.g:334:1: entryRuleTrickyG2 : ruleTrickyG2 EOF ;
    public final void entryRuleTrickyG2() throws RecognitionException {
        try {
            // PsiInternalComplexReconstrTestLanguage.g:334:18: ( ruleTrickyG2 EOF )
            // PsiInternalComplexReconstrTestLanguage.g:335:2: ruleTrickyG2 EOF
            {
             markComposite(elementTypeProvider.getTrickyG2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTrickyG2();

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
    // $ANTLR end "entryRuleTrickyG2"


    // $ANTLR start "ruleTrickyG2"
    // PsiInternalComplexReconstrTestLanguage.g:340:1: ruleTrickyG2 : ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final void ruleTrickyG2() throws RecognitionException {
        Token lv_val_1_0=null;

        try {
            // PsiInternalComplexReconstrTestLanguage.g:340:13: ( ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:341:2: ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
            {
            // PsiInternalComplexReconstrTestLanguage.g:341:2: ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalComplexReconstrTestLanguage.g:342:3: ruleTrickyG1
                    {

                    			markComposite(elementTypeProvider.getTrickyG2_TrickyG1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTrickyG1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalComplexReconstrTestLanguage.g:350:3: ( (lv_val_1_0= RULE_INT ) )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:350:3: ( (lv_val_1_0= RULE_INT ) )
                    // PsiInternalComplexReconstrTestLanguage.g:351:4: (lv_val_1_0= RULE_INT )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:351:4: (lv_val_1_0= RULE_INT )
                    // PsiInternalComplexReconstrTestLanguage.g:352:5: lv_val_1_0= RULE_INT
                    {

                    					markLeaf(elementTypeProvider.getTrickyG2_ValINTTerminalRuleCall_1_0ElementType());
                    				
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_val_1_0);
                    				

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
    // $ANTLR end "ruleTrickyG2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000A0020L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020020L});
    }


}