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
    // PsiInternalComplexReconstrTestLanguage.g:52:1: entryRuleRoot returns [Boolean current=false] : iv_ruleRoot= ruleRoot EOF ;
    public final Boolean entryRuleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRoot = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:52:46: (iv_ruleRoot= ruleRoot EOF )
            // PsiInternalComplexReconstrTestLanguage.g:53:2: iv_ruleRoot= ruleRoot EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:59:1: ruleRoot returns [Boolean current=false] : (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG ) ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean this_Op_0 = null;

        Boolean this_TrickyG_1 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:60:1: ( (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG ) )
            // PsiInternalComplexReconstrTestLanguage.g:61:2: (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG )
            {
            // PsiInternalComplexReconstrTestLanguage.g:61:2: (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG )
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
                    // PsiInternalComplexReconstrTestLanguage.g:62:3: this_Op_0= ruleOp
                    {

                    			markComposite(elementTypeProvider.getRoot_OpParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Op_0=ruleOp();

                    state._fsp--;


                    			current = this_Op_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalComplexReconstrTestLanguage.g:71:3: this_TrickyG_1= ruleTrickyG
                    {

                    			markComposite(elementTypeProvider.getRoot_TrickyGParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TrickyG_1=ruleTrickyG();

                    state._fsp--;


                    			current = this_TrickyG_1;
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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleOp"
    // PsiInternalComplexReconstrTestLanguage.g:83:1: entryRuleOp returns [Boolean current=false] : iv_ruleOp= ruleOp EOF ;
    public final Boolean entryRuleOp() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOp = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:83:44: (iv_ruleOp= ruleOp EOF )
            // PsiInternalComplexReconstrTestLanguage.g:84:2: iv_ruleOp= ruleOp EOF
            {
             markComposite(elementTypeProvider.getOpElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOp=ruleOp();

            state._fsp--;

             current =iv_ruleOp; 
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
    // $ANTLR end "entryRuleOp"


    // $ANTLR start "ruleOp"
    // PsiInternalComplexReconstrTestLanguage.g:90:1: ruleOp returns [Boolean current=false] : (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) ;
    public final Boolean ruleOp() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_5=null;
        Boolean this_Term_0 = null;

        Boolean lv_addOperands_3_0 = null;

        Boolean lv_minusOperands_6_0 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:91:1: ( (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) )
            // PsiInternalComplexReconstrTestLanguage.g:92:2: (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            {
            // PsiInternalComplexReconstrTestLanguage.g:92:2: (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            // PsiInternalComplexReconstrTestLanguage.g:93:3: this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
            {

            			markComposite(elementTypeProvider.getOp_TermParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Term_0=ruleTerm();

            state._fsp--;


            			current = this_Term_0;
            			doneComposite();
            		
            // PsiInternalComplexReconstrTestLanguage.g:101:3: ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
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
            	    // PsiInternalComplexReconstrTestLanguage.g:102:4: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:102:4: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:103:5: () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:103:5: ()
            	    // PsiInternalComplexReconstrTestLanguage.g:104:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getOp_AddAddOperandsAction_1_0_0ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }


            	    					markLeaf(elementTypeProvider.getOp_PlusSignKeyword_1_0_1ElementType());
            	    				
            	    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            	    					doneLeaf(otherlv_2);
            	    				
            	    // PsiInternalComplexReconstrTestLanguage.g:117:5: ( (lv_addOperands_3_0= ruleTerm ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:118:6: (lv_addOperands_3_0= ruleTerm )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:118:6: (lv_addOperands_3_0= ruleTerm )
            	    // PsiInternalComplexReconstrTestLanguage.g:119:7: lv_addOperands_3_0= ruleTerm
            	    {

            	    							markComposite(elementTypeProvider.getOp_AddOperandsTermParserRuleCall_1_0_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_addOperands_3_0=ruleTerm();

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
            	    // PsiInternalComplexReconstrTestLanguage.g:134:4: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:134:4: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:135:5: () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:135:5: ()
            	    // PsiInternalComplexReconstrTestLanguage.g:136:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getOp_MinusMinusOperandsAction_1_1_0ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }


            	    					markLeaf(elementTypeProvider.getOp_HyphenMinusKeyword_1_1_1ElementType());
            	    				
            	    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    					doneLeaf(otherlv_5);
            	    				
            	    // PsiInternalComplexReconstrTestLanguage.g:149:5: ( (lv_minusOperands_6_0= ruleTerm ) )
            	    // PsiInternalComplexReconstrTestLanguage.g:150:6: (lv_minusOperands_6_0= ruleTerm )
            	    {
            	    // PsiInternalComplexReconstrTestLanguage.g:150:6: (lv_minusOperands_6_0= ruleTerm )
            	    // PsiInternalComplexReconstrTestLanguage.g:151:7: lv_minusOperands_6_0= ruleTerm
            	    {

            	    							markComposite(elementTypeProvider.getOp_MinusOperandsTermParserRuleCall_1_1_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_minusOperands_6_0=ruleTerm();

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
    // $ANTLR end "ruleOp"


    // $ANTLR start "entryRuleTerm"
    // PsiInternalComplexReconstrTestLanguage.g:170:1: entryRuleTerm returns [Boolean current=false] : iv_ruleTerm= ruleTerm EOF ;
    public final Boolean entryRuleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerm = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:170:46: (iv_ruleTerm= ruleTerm EOF )
            // PsiInternalComplexReconstrTestLanguage.g:171:2: iv_ruleTerm= ruleTerm EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:177:1: ruleTerm returns [Boolean current=false] : (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) ;
    public final Boolean ruleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean this_Atom_0 = null;

        Boolean this_Parens_1 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:178:1: ( (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) )
            // PsiInternalComplexReconstrTestLanguage.g:179:2: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
            {
            // PsiInternalComplexReconstrTestLanguage.g:179:2: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
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
                    // PsiInternalComplexReconstrTestLanguage.g:180:3: this_Atom_0= ruleAtom
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
                    // PsiInternalComplexReconstrTestLanguage.g:189:3: this_Parens_1= ruleParens
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
    // PsiInternalComplexReconstrTestLanguage.g:201:1: entryRuleAtom returns [Boolean current=false] : iv_ruleAtom= ruleAtom EOF ;
    public final Boolean entryRuleAtom() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAtom = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:201:46: (iv_ruleAtom= ruleAtom EOF )
            // PsiInternalComplexReconstrTestLanguage.g:202:2: iv_ruleAtom= ruleAtom EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:208:1: ruleAtom returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleAtom() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalComplexReconstrTestLanguage.g:209:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:210:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalComplexReconstrTestLanguage.g:210:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalComplexReconstrTestLanguage.g:211:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalComplexReconstrTestLanguage.g:211:3: (lv_name_0_0= RULE_ID )
            // PsiInternalComplexReconstrTestLanguage.g:212:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getAtom_NameIDTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
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
        return current;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParens"
    // PsiInternalComplexReconstrTestLanguage.g:230:1: entryRuleParens returns [Boolean current=false] : iv_ruleParens= ruleParens EOF ;
    public final Boolean entryRuleParens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParens = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:230:48: (iv_ruleParens= ruleParens EOF )
            // PsiInternalComplexReconstrTestLanguage.g:231:2: iv_ruleParens= ruleParens EOF
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
    // PsiInternalComplexReconstrTestLanguage.g:237:1: ruleParens returns [Boolean current=false] : (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final Boolean ruleParens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;
        Boolean this_Op_1 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:238:1: ( (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // PsiInternalComplexReconstrTestLanguage.g:239:2: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // PsiInternalComplexReconstrTestLanguage.g:239:2: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // PsiInternalComplexReconstrTestLanguage.g:240:3: otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {

            			markLeaf(elementTypeProvider.getParens_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParens_OpParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_5);
            this_Op_1=ruleOp();

            state._fsp--;


            			current = this_Op_1;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParens_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalComplexReconstrTestLanguage.g:262:3: ( (lv_em_3_0= '!' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalComplexReconstrTestLanguage.g:263:4: (lv_em_3_0= '!' )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:263:4: (lv_em_3_0= '!' )
                    // PsiInternalComplexReconstrTestLanguage.g:264:5: lv_em_3_0= '!'
                    {

                    					markLeaf(elementTypeProvider.getParens_EmExclamationMarkKeyword_3_0ElementType());
                    				
                    lv_em_3_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_em_3_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
    }
    // $ANTLR end "ruleParens"


    // $ANTLR start "entryRuleTrickyG"
    // PsiInternalComplexReconstrTestLanguage.g:283:1: entryRuleTrickyG returns [Boolean current=false] : iv_ruleTrickyG= ruleTrickyG EOF ;
    public final Boolean entryRuleTrickyG() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTrickyG = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:283:49: (iv_ruleTrickyG= ruleTrickyG EOF )
            // PsiInternalComplexReconstrTestLanguage.g:284:2: iv_ruleTrickyG= ruleTrickyG EOF
            {
             markComposite(elementTypeProvider.getTrickyGElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTrickyG=ruleTrickyG();

            state._fsp--;

             current =iv_ruleTrickyG; 
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
    // $ANTLR end "entryRuleTrickyG"


    // $ANTLR start "ruleTrickyG"
    // PsiInternalComplexReconstrTestLanguage.g:290:1: ruleTrickyG returns [Boolean current=false] : (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) ;
    public final Boolean ruleTrickyG() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_tree_1_0 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:291:1: ( (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:292:2: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            {
            // PsiInternalComplexReconstrTestLanguage.g:292:2: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:293:3: otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) )
            {

            			markLeaf(elementTypeProvider.getTrickyG_TGKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalComplexReconstrTestLanguage.g:300:3: ( (lv_tree_1_0= ruleTrickyG1 ) )
            // PsiInternalComplexReconstrTestLanguage.g:301:4: (lv_tree_1_0= ruleTrickyG1 )
            {
            // PsiInternalComplexReconstrTestLanguage.g:301:4: (lv_tree_1_0= ruleTrickyG1 )
            // PsiInternalComplexReconstrTestLanguage.g:302:5: lv_tree_1_0= ruleTrickyG1
            {

            					markComposite(elementTypeProvider.getTrickyG_TreeTrickyG1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_tree_1_0=ruleTrickyG1();

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
    // $ANTLR end "ruleTrickyG"


    // $ANTLR start "entryRuleTrickyG1"
    // PsiInternalComplexReconstrTestLanguage.g:319:1: entryRuleTrickyG1 returns [Boolean current=false] : iv_ruleTrickyG1= ruleTrickyG1 EOF ;
    public final Boolean entryRuleTrickyG1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTrickyG1 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:319:50: (iv_ruleTrickyG1= ruleTrickyG1 EOF )
            // PsiInternalComplexReconstrTestLanguage.g:320:2: iv_ruleTrickyG1= ruleTrickyG1 EOF
            {
             markComposite(elementTypeProvider.getTrickyG1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTrickyG1=ruleTrickyG1();

            state._fsp--;

             current =iv_ruleTrickyG1; 
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
    // $ANTLR end "entryRuleTrickyG1"


    // $ANTLR start "ruleTrickyG1"
    // PsiInternalComplexReconstrTestLanguage.g:326:1: ruleTrickyG1 returns [Boolean current=false] : (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) ;
    public final Boolean ruleTrickyG1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_vals_1_0 = null;

        Boolean lv_vals_3_0 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:327:1: ( (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) )
            // PsiInternalComplexReconstrTestLanguage.g:328:2: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            {
            // PsiInternalComplexReconstrTestLanguage.g:328:2: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            // PsiInternalComplexReconstrTestLanguage.g:329:3: otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']'
            {

            			markLeaf(elementTypeProvider.getTrickyG1_LeftSquareBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalComplexReconstrTestLanguage.g:336:3: ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT||LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalComplexReconstrTestLanguage.g:337:4: ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:337:4: ( (lv_vals_1_0= ruleTrickyG2 ) )
                    // PsiInternalComplexReconstrTestLanguage.g:338:5: (lv_vals_1_0= ruleTrickyG2 )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:338:5: (lv_vals_1_0= ruleTrickyG2 )
                    // PsiInternalComplexReconstrTestLanguage.g:339:6: lv_vals_1_0= ruleTrickyG2
                    {

                    						markComposite(elementTypeProvider.getTrickyG1_ValsTrickyG2ParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_vals_1_0=ruleTrickyG2();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalComplexReconstrTestLanguage.g:352:4: (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // PsiInternalComplexReconstrTestLanguage.g:353:5: otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getTrickyG1_CommaKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_10); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalComplexReconstrTestLanguage.g:360:5: ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    // PsiInternalComplexReconstrTestLanguage.g:361:6: (lv_vals_3_0= ruleTrickyG2 )
                    	    {
                    	    // PsiInternalComplexReconstrTestLanguage.g:361:6: (lv_vals_3_0= ruleTrickyG2 )
                    	    // PsiInternalComplexReconstrTestLanguage.g:362:7: lv_vals_3_0= ruleTrickyG2
                    	    {

                    	    							markComposite(elementTypeProvider.getTrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_9);
                    	    lv_vals_3_0=ruleTrickyG2();

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
        return current;
    }
    // $ANTLR end "ruleTrickyG1"


    // $ANTLR start "entryRuleTrickyG2"
    // PsiInternalComplexReconstrTestLanguage.g:388:1: entryRuleTrickyG2 returns [Boolean current=false] : iv_ruleTrickyG2= ruleTrickyG2 EOF ;
    public final Boolean entryRuleTrickyG2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTrickyG2 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:388:50: (iv_ruleTrickyG2= ruleTrickyG2 EOF )
            // PsiInternalComplexReconstrTestLanguage.g:389:2: iv_ruleTrickyG2= ruleTrickyG2 EOF
            {
             markComposite(elementTypeProvider.getTrickyG2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTrickyG2=ruleTrickyG2();

            state._fsp--;

             current =iv_ruleTrickyG2; 
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
    // $ANTLR end "entryRuleTrickyG2"


    // $ANTLR start "ruleTrickyG2"
    // PsiInternalComplexReconstrTestLanguage.g:395:1: ruleTrickyG2 returns [Boolean current=false] : (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final Boolean ruleTrickyG2() throws RecognitionException {
        Boolean current = false;

        Token lv_val_1_0=null;
        Boolean this_TrickyG1_0 = null;


        try {
            // PsiInternalComplexReconstrTestLanguage.g:396:1: ( (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) )
            // PsiInternalComplexReconstrTestLanguage.g:397:2: (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
            {
            // PsiInternalComplexReconstrTestLanguage.g:397:2: (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
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
                    // PsiInternalComplexReconstrTestLanguage.g:398:3: this_TrickyG1_0= ruleTrickyG1
                    {

                    			markComposite(elementTypeProvider.getTrickyG2_TrickyG1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TrickyG1_0=ruleTrickyG1();

                    state._fsp--;


                    			current = this_TrickyG1_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalComplexReconstrTestLanguage.g:407:3: ( (lv_val_1_0= RULE_INT ) )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:407:3: ( (lv_val_1_0= RULE_INT ) )
                    // PsiInternalComplexReconstrTestLanguage.g:408:4: (lv_val_1_0= RULE_INT )
                    {
                    // PsiInternalComplexReconstrTestLanguage.g:408:4: (lv_val_1_0= RULE_INT )
                    // PsiInternalComplexReconstrTestLanguage.g:409:5: lv_val_1_0= RULE_INT
                    {

                    					markLeaf(elementTypeProvider.getTrickyG2_ValINTTerminalRuleCall_1_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
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
        return current;
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