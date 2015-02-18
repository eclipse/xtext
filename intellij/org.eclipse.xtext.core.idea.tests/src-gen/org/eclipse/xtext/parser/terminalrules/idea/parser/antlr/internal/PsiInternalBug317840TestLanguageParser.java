package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.terminalrules.services.Bug317840TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug317840TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug317840TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug317840TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug317840TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g"; }



    	protected Bug317840TestLanguageGrammarAccess grammarAccess;

    	protected Bug317840TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug317840TestLanguageParser(PsiBuilder builder, TokenStream input, Bug317840TestLanguageElementTypeProvider elementTypeProvider, Bug317840TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:51:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:59:1: ruleModel : ( (lv_elements_0_0= ruleElement ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:59:10: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:60:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:60:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:61:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:61:3: (lv_elements_0_0= ruleElement )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:62:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel89);
            	    ruleElement();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:74:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:74:17: ( ruleElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:75:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement115);
            ruleElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement121); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:83:1: ruleElement : (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) ;
    public final void ruleElement() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:83:12: ( (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:84:2: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:84:2: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:85:3: otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement144); 

            			doneLeaf(otherlv_0, elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:92:3: ( (lv_first_1_0= ruleNamed ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:93:4: (lv_first_1_0= ruleNamed )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:93:4: (lv_first_1_0= ruleNamed )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:94:5: lv_first_1_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getElement_FirstNamedParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement171);
            ruleNamed();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:103:3: ( (lv_second_2_0= ruleNamed ) )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:104:4: (lv_second_2_0= ruleNamed )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:104:4: (lv_second_2_0= ruleNamed )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:105:5: lv_second_2_0= ruleNamed
                    {

                    					markComposite(elementTypeProvider.getElement_SecondNamedParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement209);
                    ruleNamed();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:114:3: ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:115:4: ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:115:4: ( (lv_third_3_0= ruleNamed ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:116:5: (lv_third_3_0= ruleNamed )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:116:5: (lv_third_3_0= ruleNamed )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:117:6: lv_third_3_0= ruleNamed
            	    {

            	    						markComposite(elementTypeProvider.getElement_ThirdNamedParserRuleCall_3_0_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement256);
            	    ruleNamed();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:126:4: ( (lv_forth_4_0= ruleNamed ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:127:5: (lv_forth_4_0= ruleNamed )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:127:5: (lv_forth_4_0= ruleNamed )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:128:6: lv_forth_4_0= ruleNamed
            	    {

            	    						markComposite(elementTypeProvider.getElement_ForthNamedParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement301);
            	    ruleNamed();

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleNamed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:142:1: entryRuleNamed : ruleNamed EOF ;
    public final void entryRuleNamed() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:142:15: ( ruleNamed EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:143:2: ruleNamed EOF
            {
             markComposite(elementTypeProvider.getNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_entryRuleNamed340);
            ruleNamed();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamed346); 

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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:151:1: ruleNamed : ( (lv_name_0_0= ruleNAME ) ) ;
    public final void ruleNamed() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:151:10: ( ( (lv_name_0_0= ruleNAME ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:152:2: ( (lv_name_0_0= ruleNAME ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:152:2: ( (lv_name_0_0= ruleNAME ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:153:3: (lv_name_0_0= ruleNAME )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:153:3: (lv_name_0_0= ruleNAME )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:154:4: lv_name_0_0= ruleNAME
            {

            				markComposite(elementTypeProvider.getNamed_NameNAMEParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleNAME_in_ruleNamed375);
            ruleNAME();

            state._fsp--;


            				doneComposite();
            			

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
    // $ANTLR end "ruleNamed"


    // $ANTLR start "entryRuleNAME"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:166:1: entryRuleNAME : ruleNAME EOF ;
    public final void entryRuleNAME() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:166:14: ( ruleNAME EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:167:2: ruleNAME EOF
            {
             markComposite(elementTypeProvider.getNAMEElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNAME_in_entryRuleNAME400);
            ruleNAME();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNAME406); 

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
    // $ANTLR end "entryRuleNAME"


    // $ANTLR start "ruleNAME"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:175:1: ruleNAME : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleNAME() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:175:9: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:176:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:176:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:177:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNAME429); 

            			doneLeaf(this_ID_0, elementTypeProvider.getNAME_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:184:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug317840TestLanguage.g:185:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNAME449); 

            	    				doneLeaf(kw, elementTypeProvider.getNAME_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNAME466); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getNAME_IDTerminalRuleCall_1_1ElementType());
            	    			

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
        return ;
    }
    // $ANTLR end "ruleNAME"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\14\uffff";
    static final String DFA2_eofS =
        "\1\2\1\5\2\uffff\1\2\1\uffff\1\5\1\uffff\1\5\1\2\1\uffff\1\5";
    static final String DFA2_minS =
        "\2\4\1\uffff\2\4\1\uffff\6\4";
    static final String DFA2_maxS =
        "\1\13\1\14\1\uffff\1\4\1\14\1\uffff\1\14\1\4\2\14\1\4\1\14";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\6\uffff";
    static final String DFA2_specialS =
        "\14\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\6\uffff\1\2",
            "\1\4\6\uffff\1\5\1\3",
            "",
            "\1\6",
            "\1\10\6\uffff\1\2\1\7",
            "",
            "\1\4\6\uffff\1\5\1\3",
            "\1\11",
            "\1\4\6\uffff\1\5\1\12",
            "\1\10\6\uffff\1\2\1\7",
            "\1\13",
            "\1\4\6\uffff\1\5\1\12"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "103:3: ( (lv_second_2_0= ruleNamed ) )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel89 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement144 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement171 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement209 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement256 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement301 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed340 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamed346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNAME_in_ruleNamed375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNAME_in_entryRuleNAME400 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNAME406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNAME429 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleNAME449 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNAME466 = new BitSet(new long[]{0x0000000000001002L});
    }


}