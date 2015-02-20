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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:52:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:53:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot54);
            ruleRoot();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:59:1: ruleRoot : ( ruleOp | ruleTrickyG ) ;
    public final void ruleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:59:9: ( ( ruleOp | ruleTrickyG ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:60:2: ( ruleOp | ruleTrickyG )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:60:2: ( ruleOp | ruleTrickyG )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:61:3: ruleOp
                    {

                    			markComposite(elementTypeProvider.getRoot_OpParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleOp_in_ruleRoot77);
                    ruleOp();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:69:3: ruleTrickyG
                    {

                    			markComposite(elementTypeProvider.getRoot_TrickyGParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTrickyG_in_ruleRoot97);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:80:1: entryRuleOp : ruleOp EOF ;
    public final void entryRuleOp() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:80:12: ( ruleOp EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:81:2: ruleOp EOF
            {
             markComposite(elementTypeProvider.getOpElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_entryRuleOp117);
            ruleOp();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOp123); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:87:1: ruleOp : ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) ;
    public final void ruleOp() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:87:7: ( ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:88:2: ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:88:2: ( ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:89:3: ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
            {

            			markComposite(elementTypeProvider.getOp_TermParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp140);
            ruleTerm();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:96:3: ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:97:4: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:97:4: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:98:5: () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:98:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:99:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getOp_AddAddOperandsAction_1_0_0ElementType());
            	    						doneComposite();
            	    					

            	    }


            	    					markLeaf();
            	    				
            	    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleOp186); 

            	    					doneLeaf(otherlv_2, elementTypeProvider.getOp_PlusSignKeyword_1_0_1ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:111:5: ( (lv_addOperands_3_0= ruleTerm ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:112:6: (lv_addOperands_3_0= ruleTerm )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:112:6: (lv_addOperands_3_0= ruleTerm )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:113:7: lv_addOperands_3_0= ruleTerm
            	    {

            	    							markComposite(elementTypeProvider.getOp_AddOperandsTermParserRuleCall_1_0_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp223);
            	    ruleTerm();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:124:4: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:124:4: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:125:5: () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:125:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:126:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getOp_MinusMinusOperandsAction_1_1_0ElementType());
            	    						doneComposite();
            	    					

            	    }


            	    					markLeaf();
            	    				
            	    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleOp296); 

            	    					doneLeaf(otherlv_5, elementTypeProvider.getOp_HyphenMinusKeyword_1_1_1ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:138:5: ( (lv_minusOperands_6_0= ruleTerm ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:139:6: (lv_minusOperands_6_0= ruleTerm )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:139:6: (lv_minusOperands_6_0= ruleTerm )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:140:7: lv_minusOperands_6_0= ruleTerm
            	    {

            	    							markComposite(elementTypeProvider.getOp_MinusOperandsTermParserRuleCall_1_1_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp333);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:155:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:155:14: ( ruleTerm EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:156:2: ruleTerm EOF
            {
             markComposite(elementTypeProvider.getTermElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_entryRuleTerm380);
            ruleTerm();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerm386); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:162:1: ruleTerm : ( ruleAtom | ruleParens ) ;
    public final void ruleTerm() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:162:9: ( ( ruleAtom | ruleParens ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:163:2: ( ruleAtom | ruleParens )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:163:2: ( ruleAtom | ruleParens )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:164:3: ruleAtom
                    {

                    			markComposite(elementTypeProvider.getTerm_AtomParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_ruleTerm403);
                    ruleAtom();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:172:3: ruleParens
                    {

                    			markComposite(elementTypeProvider.getTerm_ParensParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParens_in_ruleTerm423);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:183:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:183:14: ( ruleAtom EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:184:2: ruleAtom EOF
            {
             markComposite(elementTypeProvider.getAtomElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom443);
            ruleAtom();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom449); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:190:1: ruleAtom : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleAtom() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:190:9: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:191:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:191:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:192:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:192:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:193:4: lv_name_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAtom474); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getAtom_NameIDTerminalRuleCall_0ElementType());
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:205:1: entryRuleParens : ruleParens EOF ;
    public final void entryRuleParens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:205:16: ( ruleParens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:206:2: ruleParens EOF
            {
             markComposite(elementTypeProvider.getParensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParens_in_entryRuleParens499);
            ruleParens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParens505); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:212:1: ruleParens : (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final void ruleParens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:212:11: ( (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:213:2: (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:213:2: (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:214:3: otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParens524); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParens_LeftParenthesisKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getParens_OpParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_ruleParens536);
            ruleOp();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParens550); 

            			doneLeaf(otherlv_2, elementTypeProvider.getParens_RightParenthesisKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:235:3: ( (lv_em_3_0= '!' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:236:4: (lv_em_3_0= '!' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:236:4: (lv_em_3_0= '!' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:237:5: lv_em_3_0= '!'
                    {

                    					markLeaf();
                    				
                    lv_em_3_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParens577); 

                    					doneLeaf(lv_em_3_0, elementTypeProvider.getParens_EmExclamationMarkKeyword_3_0ElementType());
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:250:1: entryRuleTrickyG : ruleTrickyG EOF ;
    public final void entryRuleTrickyG() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:250:17: ( ruleTrickyG EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:251:2: ruleTrickyG EOF
            {
             markComposite(elementTypeProvider.getTrickyGElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG_in_entryRuleTrickyG609);
            ruleTrickyG();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrickyG615); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:257:1: ruleTrickyG : (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) ;
    public final void ruleTrickyG() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:257:12: ( (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:258:2: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:258:2: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:259:3: otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTrickyG634); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTrickyG_TGKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:266:3: ( (lv_tree_1_0= ruleTrickyG1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:267:4: (lv_tree_1_0= ruleTrickyG1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:267:4: (lv_tree_1_0= ruleTrickyG1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:268:5: lv_tree_1_0= ruleTrickyG1
            {

            					markComposite(elementTypeProvider.getTrickyG_TreeTrickyG1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG1_in_ruleTrickyG661);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:281:1: entryRuleTrickyG1 : ruleTrickyG1 EOF ;
    public final void entryRuleTrickyG1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:281:18: ( ruleTrickyG1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:282:2: ruleTrickyG1 EOF
            {
             markComposite(elementTypeProvider.getTrickyG1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG1_in_entryRuleTrickyG1692);
            ruleTrickyG1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrickyG1698); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:288:1: ruleTrickyG1 : (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) ;
    public final void ruleTrickyG1() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:288:13: ( (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:289:2: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:289:2: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:290:3: otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTrickyG1717); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTrickyG1_LeftSquareBracketKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:297:3: ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT||LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:298:4: ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:298:4: ( (lv_vals_1_0= ruleTrickyG2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:299:5: (lv_vals_1_0= ruleTrickyG2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:299:5: (lv_vals_1_0= ruleTrickyG2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:300:6: lv_vals_1_0= ruleTrickyG2
                    {

                    						markComposite(elementTypeProvider.getTrickyG1_ValsTrickyG2ParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTrickyG2_in_ruleTrickyG1752);
                    ruleTrickyG2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:309:4: (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:310:5: otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTrickyG1789); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getTrickyG1_CommaKeyword_1_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:317:5: ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:318:6: (lv_vals_3_0= ruleTrickyG2 )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:318:6: (lv_vals_3_0= ruleTrickyG2 )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:319:7: lv_vals_3_0= ruleTrickyG2
                    	    {

                    	    							markComposite(elementTypeProvider.getTrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleTrickyG2_in_ruleTrickyG1826);
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


            			markLeaf();
            		
            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTrickyG1868); 

            			doneLeaf(otherlv_4, elementTypeProvider.getTrickyG1_RightSquareBracketKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:341:1: entryRuleTrickyG2 : ruleTrickyG2 EOF ;
    public final void entryRuleTrickyG2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:341:18: ( ruleTrickyG2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:342:2: ruleTrickyG2 EOF
            {
             markComposite(elementTypeProvider.getTrickyG2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG2_in_entryRuleTrickyG2888);
            ruleTrickyG2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrickyG2894); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:348:1: ruleTrickyG2 : ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final void ruleTrickyG2() throws RecognitionException {
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:348:13: ( ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:349:2: ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:349:2: ( ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:350:3: ruleTrickyG1
                    {

                    			markComposite(elementTypeProvider.getTrickyG2_TrickyG1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTrickyG1_in_ruleTrickyG2911);
                    ruleTrickyG1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:358:3: ( (lv_val_1_0= RULE_INT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:358:3: ( (lv_val_1_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:359:4: (lv_val_1_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:359:4: (lv_val_1_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalComplexReconstrTestLanguage.g:360:5: lv_val_1_0= RULE_INT
                    {

                    					markLeaf();
                    				
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTrickyG2946); 

                    					doneLeaf(lv_val_1_0, elementTypeProvider.getTrickyG2_ValINTTerminalRuleCall_1_0ElementType());
                    				

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
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOp_in_ruleRoot77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG_in_ruleRoot97 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOp_in_entryRuleOp117 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOp123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp140 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_11_in_ruleOp186 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp223 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_12_in_ruleOp296 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp333 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerm386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_ruleTerm403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_ruleTerm423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAtom474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_entryRuleParens499 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParens505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleParens524 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_ruleOp_in_ruleParens536 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleParens550 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleParens577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG_in_entryRuleTrickyG609 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrickyG615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleTrickyG634 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleTrickyG1_in_ruleTrickyG661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG1_in_entryRuleTrickyG1692 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrickyG1698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleTrickyG1717 = new BitSet(new long[]{0x00000000000A0020L});
        public static final BitSet FOLLOW_ruleTrickyG2_in_ruleTrickyG1752 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleTrickyG1789 = new BitSet(new long[]{0x0000000000020020L});
        public static final BitSet FOLLOW_ruleTrickyG2_in_ruleTrickyG1826 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_19_in_ruleTrickyG1868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG2_in_entryRuleTrickyG2888 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrickyG2894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG1_in_ruleTrickyG2911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTrickyG2946 = new BitSet(new long[]{0x0000000000000002L});
    }


}