package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.services.HiddenTokensMergerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalHiddenTokensMergerTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'ref'", "';'", "'.'", "'#2'", "'kw1'", "'#3'", "'item'", "'#4'", "'#5'", "'refs'", "'#6'", "'#7'", "'class'", "'endclass'", "'#8'", "'sub1'", "'sub2'", "'array'", "'object'", "'resultSet'", "'iterator'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalHiddenTokensMergerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalHiddenTokensMergerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalHiddenTokensMergerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g"; }



    	protected HiddenTokensMergerTestLanguageGrammarAccess grammarAccess;

    	protected HiddenTokensMergerTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalHiddenTokensMergerTestLanguageParser(PsiBuilder builder, TokenStream input, HiddenTokensMergerTestLanguageElementTypeProvider elementTypeProvider, HiddenTokensMergerTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:59:1: ruleModel : ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:59:10: ( ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:60:2: ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:60:2: ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 17:
                {
                alt1=3;
                }
                break;
            case 19:
                {
                alt1=4;
                }
                break;
            case 20:
                {
                alt1=5;
                }
                break;
            case 22:
                {
                alt1=6;
                }
                break;
            case 23:
                {
                alt1=7;
                }
                break;
            case 26:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:61:3: ruleDatatypeBug286557
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeBug286557ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeBug286557_in_ruleModel81);
                    ruleDatatypeBug286557();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:69:3: ruleEnumBug
                    {

                    			markComposite(elementTypeProvider.getModel_EnumBugParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEnumBug_in_ruleModel101);
                    ruleEnumBug();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:77:3: ruleCommentable
                    {

                    			markComposite(elementTypeProvider.getModel_CommentableParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCommentable_in_ruleModel121);
                    ruleCommentable();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:85:3: ruleValueList
                    {

                    			markComposite(elementTypeProvider.getModel_ValueListParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleValueList_in_ruleModel141);
                    ruleValueList();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:93:3: ruleRefList
                    {

                    			markComposite(elementTypeProvider.getModel_RefListParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRefList_in_ruleModel161);
                    ruleRefList();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:101:3: ruleSingleRef
                    {

                    			markComposite(elementTypeProvider.getModel_SingleRefParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSingleRef_in_ruleModel181);
                    ruleSingleRef();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:109:3: ruleAppendToFileEnd
                    {

                    			markComposite(elementTypeProvider.getModel_AppendToFileEndParserRuleCall_6ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEnd_in_ruleModel201);
                    ruleAppendToFileEnd();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:117:3: ruleAction1
                    {

                    			markComposite(elementTypeProvider.getModel_Action1ParserRuleCall_7ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAction1_in_ruleModel221);
                    ruleAction1();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDatatypeBug286557"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:128:1: entryRuleDatatypeBug286557 : ruleDatatypeBug286557 EOF ;
    public final void entryRuleDatatypeBug286557() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:128:27: ( ruleDatatypeBug286557 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:129:2: ruleDatatypeBug286557 EOF
            {
             markComposite(elementTypeProvider.getDatatypeBug286557ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557241);
            ruleDatatypeBug286557();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeBug286557247); 

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
    // $ANTLR end "entryRuleDatatypeBug286557"


    // $ANTLR start "ruleDatatypeBug286557"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:137:1: ruleDatatypeBug286557 : (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) ;
    public final void ruleDatatypeBug286557() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:137:22: ( (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:138:2: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:138:2: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:139:3: otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleDatatypeBug286557270); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatypeBug286557_NumberSignDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:146:3: ( (lv_name_1_0= ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:147:4: (lv_name_1_0= ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:147:4: (lv_name_1_0= ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:148:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getDatatypeBug286557_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557297);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:157:3: (otherlv_2= 'ref' ( ( ruleFQN ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:158:4: otherlv_2= 'ref' ( ( ruleFQN ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDatatypeBug286557328); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getDatatypeBug286557_RefKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:165:4: ( ( ruleFQN ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:166:5: ( ruleFQN )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:166:5: ( ruleFQN )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:167:6: ruleFQN
                    {

                    						markComposite(elementTypeProvider.getDatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557358);
                    ruleFQN();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDatatypeBug286557391); 

            			doneLeaf(otherlv_4, elementTypeProvider.getDatatypeBug286557_SemicolonKeyword_3ElementType());
            		

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
    // $ANTLR end "ruleDatatypeBug286557"


    // $ANTLR start "entryRuleFQN"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:188:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:188:13: ( ruleFQN EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:189:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN411);
            ruleFQN();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN417); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:197:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:197:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:198:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:198:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:199:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN440); 

            			doneLeaf(this_ID_0, elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:206:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:207:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleFQN460); 

            	    				doneLeaf(kw, elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN477); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleEnumBug"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:226:1: entryRuleEnumBug : ruleEnumBug EOF ;
    public final void entryRuleEnumBug() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:226:17: ( ruleEnumBug EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:227:2: ruleEnumBug EOF
            {
             markComposite(elementTypeProvider.getEnumBugElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumBug_in_entryRuleEnumBug503);
            ruleEnumBug();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumBug509); 

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
    // $ANTLR end "entryRuleEnumBug"


    // $ANTLR start "ruleEnumBug"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:235:1: ruleEnumBug : (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final void ruleEnumBug() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:235:12: ( (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:236:2: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:236:2: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:237:3: otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumBug532); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEnumBug_NumberSignDigitTwoKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEnumBug546); 

            			doneLeaf(otherlv_1, elementTypeProvider.getEnumBug_Kw1Keyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:251:3: ( (lv_return_2_0= ruleEnumBugEnum ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:252:4: (lv_return_2_0= ruleEnumBugEnum )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:252:4: (lv_return_2_0= ruleEnumBugEnum )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:253:5: lv_return_2_0= ruleEnumBugEnum
            {

            					markComposite(elementTypeProvider.getEnumBug_ReturnEnumBugEnumEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEnumBugEnum_in_ruleEnumBug573);
            ruleEnumBugEnum();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:262:3: ( (lv_name_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:263:4: (lv_name_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:263:4: (lv_name_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:264:5: lv_name_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumBug611); 

            					doneLeaf(lv_name_3_0, elementTypeProvider.getEnumBug_NameIDTerminalRuleCall_3_0ElementType());
            				

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
    // $ANTLR end "ruleEnumBug"


    // $ANTLR start "entryRuleCommentable"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:277:1: entryRuleCommentable : ruleCommentable EOF ;
    public final void entryRuleCommentable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:277:21: ( ruleCommentable EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:278:2: ruleCommentable EOF
            {
             markComposite(elementTypeProvider.getCommentableElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentable_in_entryRuleCommentable642);
            ruleCommentable();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentable648); 

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
    // $ANTLR end "entryRuleCommentable"


    // $ANTLR start "ruleCommentable"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:286:1: ruleCommentable : (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) ;
    public final void ruleCommentable() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:286:16: ( (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:287:2: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:287:2: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:288:3: otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleCommentable671); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCommentable_NumberSignDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:295:3: ( (lv_item_1_0= ruleCommentableItem ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:296:4: (lv_item_1_0= ruleCommentableItem )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:296:4: (lv_item_1_0= ruleCommentableItem )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:297:5: lv_item_1_0= ruleCommentableItem
            	    {

            	    					markComposite(elementTypeProvider.getCommentable_ItemCommentableItemParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_ruleCommentable698);
            	    ruleCommentableItem();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
        return ;
    }
    // $ANTLR end "ruleCommentable"


    // $ANTLR start "entryRuleCommentableItem"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:310:1: entryRuleCommentableItem : ruleCommentableItem EOF ;
    public final void entryRuleCommentableItem() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:310:25: ( ruleCommentableItem EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:311:2: ruleCommentableItem EOF
            {
             markComposite(elementTypeProvider.getCommentableItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem730);
            ruleCommentableItem();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentableItem736); 

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
    // $ANTLR end "entryRuleCommentableItem"


    // $ANTLR start "ruleCommentableItem"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:319:1: ruleCommentableItem : (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final void ruleCommentableItem() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_id_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:319:20: ( (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:320:2: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:320:2: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:321:3: otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCommentableItem759); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCommentableItem_ItemKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:328:3: ( (lv_id_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:329:4: (lv_id_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:329:4: (lv_id_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:330:5: lv_id_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommentableItem786); 

            					doneLeaf(lv_id_1_0, elementTypeProvider.getCommentableItem_IdIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleCommentableItem"


    // $ANTLR start "entryRuleValueList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:343:1: entryRuleValueList : ruleValueList EOF ;
    public final void entryRuleValueList() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:343:19: ( ruleValueList EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:344:2: ruleValueList EOF
            {
             markComposite(elementTypeProvider.getValueListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueList_in_entryRuleValueList817);
            ruleValueList();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueList823); 

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
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:352:1: ruleValueList : (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) ;
    public final void ruleValueList() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:352:14: ( (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:353:2: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:353:2: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:354:3: otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleValueList846); 

            			doneLeaf(otherlv_0, elementTypeProvider.getValueList_NumberSignDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:361:3: ( (lv_ids_1_0= ruleFQN ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:362:4: (lv_ids_1_0= ruleFQN )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:362:4: (lv_ids_1_0= ruleFQN )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:363:5: lv_ids_1_0= ruleFQN
            	    {

            	    					markComposite(elementTypeProvider.getValueList_IdsFQNParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleValueList873);
            	    ruleFQN();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
    // $ANTLR end "ruleValueList"


    // $ANTLR start "entryRuleRefList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:376:1: entryRuleRefList : ruleRefList EOF ;
    public final void entryRuleRefList() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:376:17: ( ruleRefList EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:377:2: ruleRefList EOF
            {
             markComposite(elementTypeProvider.getRefListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRefList_in_entryRuleRefList905);
            ruleRefList();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefList911); 

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
    // $ANTLR end "entryRuleRefList"


    // $ANTLR start "ruleRefList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:385:1: ruleRefList : (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) ;
    public final void ruleRefList() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:385:12: ( (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:386:2: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:386:2: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:387:3: otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRefList934); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRefList_NumberSignDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:394:3: ( (lv_objs_1_0= ruleRefObj ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:395:4: (lv_objs_1_0= ruleRefObj )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:395:4: (lv_objs_1_0= ruleRefObj )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:396:5: lv_objs_1_0= ruleRefObj
            	    {

            	    					markComposite(elementTypeProvider.getRefList_ObjsRefObjParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_ruleRefList961);
            	    ruleRefObj();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRefList987); 

            			doneLeaf(otherlv_2, elementTypeProvider.getRefList_RefsKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:412:3: ( ( ruleFQN ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:413:4: ( ruleFQN )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:413:4: ( ruleFQN )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:414:5: ruleFQN
            	    {

            	    					markComposite(elementTypeProvider.getRefList_RefsRefObjCrossReference_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefList1012);
            	    ruleFQN();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleRefList"


    // $ANTLR start "entryRuleRefObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:427:1: entryRuleRefObj : ruleRefObj EOF ;
    public final void entryRuleRefObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:427:16: ( ruleRefObj EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:428:2: ruleRefObj EOF
            {
             markComposite(elementTypeProvider.getRefObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_entryRuleRefObj1044);
            ruleRefObj();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefObj1050); 

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
    // $ANTLR end "entryRuleRefObj"


    // $ANTLR start "ruleRefObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:436:1: ruleRefObj : ( (lv_name_0_0= ruleFQN ) ) ;
    public final void ruleRefObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:436:11: ( ( (lv_name_0_0= ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:437:2: ( (lv_name_0_0= ruleFQN ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:437:2: ( (lv_name_0_0= ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:438:3: (lv_name_0_0= ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:438:3: (lv_name_0_0= ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:439:4: lv_name_0_0= ruleFQN
            {

            				markComposite(elementTypeProvider.getRefObj_NameFQNParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefObj1079);
            ruleFQN();

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
    // $ANTLR end "ruleRefObj"


    // $ANTLR start "entryRuleSingleRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:451:1: entryRuleSingleRef : ruleSingleRef EOF ;
    public final void entryRuleSingleRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:451:19: ( ruleSingleRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:452:2: ruleSingleRef EOF
            {
             markComposite(elementTypeProvider.getSingleRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleRef_in_entryRuleSingleRef1104);
            ruleSingleRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleRef1110); 

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
    // $ANTLR end "entryRuleSingleRef"


    // $ANTLR start "ruleSingleRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:460:1: ruleSingleRef : (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) ;
    public final void ruleSingleRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:460:14: ( (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:461:2: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:461:2: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:462:3: otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSingleRef1133); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleRef_NumberSignDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:469:3: ( (lv_obj_1_0= ruleRefObj ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:470:4: (lv_obj_1_0= ruleRefObj )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:470:4: (lv_obj_1_0= ruleRefObj )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:471:5: lv_obj_1_0= ruleRefObj
            {

            					markComposite(elementTypeProvider.getSingleRef_ObjRefObjParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_ruleSingleRef1160);
            ruleRefObj();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSingleRef1185); 

            			doneLeaf(otherlv_2, elementTypeProvider.getSingleRef_RefKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:487:3: ( ( ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:488:4: ( ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:488:4: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:489:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getSingleRef_RefRefObjCrossReference_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSingleRef1210);
            ruleFQN();

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
    // $ANTLR end "ruleSingleRef"


    // $ANTLR start "entryRuleAppendToFileEnd"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:502:1: entryRuleAppendToFileEnd : ruleAppendToFileEnd EOF ;
    public final void entryRuleAppendToFileEnd() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:502:25: ( ruleAppendToFileEnd EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:503:2: ruleAppendToFileEnd EOF
            {
             markComposite(elementTypeProvider.getAppendToFileEndElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEnd_in_entryRuleAppendToFileEnd1241);
            ruleAppendToFileEnd();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAppendToFileEnd1247); 

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
    // $ANTLR end "entryRuleAppendToFileEnd"


    // $ANTLR start "ruleAppendToFileEnd"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:511:1: ruleAppendToFileEnd : (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) ;
    public final void ruleAppendToFileEnd() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:511:20: ( (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:512:2: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:512:2: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:513:3: otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAppendToFileEnd1270); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAppendToFileEnd_NumberSignDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:520:3: ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:521:4: (lv_items_1_0= ruleAppendToFileEndItem )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:521:4: (lv_items_1_0= ruleAppendToFileEndItem )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:522:5: lv_items_1_0= ruleAppendToFileEndItem
            	    {

            	    					markComposite(elementTypeProvider.getAppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEndItem_in_ruleAppendToFileEnd1297);
            	    ruleAppendToFileEndItem();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleAppendToFileEnd"


    // $ANTLR start "entryRuleAppendToFileEndItem"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:535:1: entryRuleAppendToFileEndItem : ruleAppendToFileEndItem EOF ;
    public final void entryRuleAppendToFileEndItem() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:535:29: ( ruleAppendToFileEndItem EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:536:2: ruleAppendToFileEndItem EOF
            {
             markComposite(elementTypeProvider.getAppendToFileEndItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEndItem_in_entryRuleAppendToFileEndItem1329);
            ruleAppendToFileEndItem();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAppendToFileEndItem1335); 

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
    // $ANTLR end "entryRuleAppendToFileEndItem"


    // $ANTLR start "ruleAppendToFileEndItem"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:544:1: ruleAppendToFileEndItem : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) ;
    public final void ruleAppendToFileEndItem() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:544:24: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:545:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:545:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:546:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAppendToFileEndItem1358); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAppendToFileEndItem_ClassKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:553:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:554:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:554:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:555:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAppendToFileEndItem1385); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getAppendToFileEndItem_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAppendToFileEndItem1410); 

            			doneLeaf(otherlv_2, elementTypeProvider.getAppendToFileEndItem_EndclassKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleAppendToFileEndItem"


    // $ANTLR start "entryRuleAction1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:575:1: entryRuleAction1 : ruleAction1 EOF ;
    public final void entryRuleAction1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:575:17: ( ruleAction1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:576:2: ruleAction1 EOF
            {
             markComposite(elementTypeProvider.getAction1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction1_in_entryRuleAction11430);
            ruleAction1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction11436); 

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
    // $ANTLR end "entryRuleAction1"


    // $ANTLR start "ruleAction1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:584:1: ruleAction1 : (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) ;
    public final void ruleAction1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:584:12: ( (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:585:2: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:585:2: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:586:3: otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAction11459); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAction1_NumberSignDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:593:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:594:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1_Action1Action_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:599:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:600:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:600:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:601:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction11499); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getAction1_NameIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:610:3: ( (lv_actions2_3_0= ruleAction1Sub1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:611:4: (lv_actions2_3_0= ruleAction1Sub1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:611:4: (lv_actions2_3_0= ruleAction1Sub1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:612:5: lv_actions2_3_0= ruleAction1Sub1
            {

            					markComposite(elementTypeProvider.getAction1_Actions2Action1Sub1ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub1_in_ruleAction11537);
            ruleAction1Sub1();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:621:3: ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:622:4: (lv_actions2_4_0= ruleAction1Sub2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:622:4: (lv_actions2_4_0= ruleAction1Sub2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:623:5: lv_actions2_4_0= ruleAction1Sub2
            {

            					markComposite(elementTypeProvider.getAction1_Actions2Action1Sub2ParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub2_in_ruleAction11575);
            ruleAction1Sub2();

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
    // $ANTLR end "ruleAction1"


    // $ANTLR start "entryRuleAction1Sub1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:636:1: entryRuleAction1Sub1 : ruleAction1Sub1 EOF ;
    public final void entryRuleAction1Sub1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:636:21: ( ruleAction1Sub1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:637:2: ruleAction1Sub1 EOF
            {
             markComposite(elementTypeProvider.getAction1Sub1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub1_in_entryRuleAction1Sub11606);
            ruleAction1Sub1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction1Sub11612); 

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
    // $ANTLR end "entryRuleAction1Sub1"


    // $ANTLR start "ruleAction1Sub1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:645:1: ruleAction1Sub1 : ( () otherlv_1= 'sub1' ) ;
    public final void ruleAction1Sub1() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:645:16: ( ( () otherlv_1= 'sub1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:646:2: ( () otherlv_1= 'sub1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:646:2: ( () otherlv_1= 'sub1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:647:3: () otherlv_1= 'sub1'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:647:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:648:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1Sub1_Action1SubAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAction1Sub11648); 

            			doneLeaf(otherlv_1, elementTypeProvider.getAction1Sub1_Sub1Keyword_1ElementType());
            		

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
    // $ANTLR end "ruleAction1Sub1"


    // $ANTLR start "entryRuleAction1Sub2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:664:1: entryRuleAction1Sub2 : ruleAction1Sub2 EOF ;
    public final void entryRuleAction1Sub2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:664:21: ( ruleAction1Sub2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:665:2: ruleAction1Sub2 EOF
            {
             markComposite(elementTypeProvider.getAction1Sub2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub2_in_entryRuleAction1Sub21668);
            ruleAction1Sub2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction1Sub21674); 

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
    // $ANTLR end "entryRuleAction1Sub2"


    // $ANTLR start "ruleAction1Sub2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:673:1: ruleAction1Sub2 : ( () otherlv_1= 'sub2' ) ;
    public final void ruleAction1Sub2() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:673:16: ( ( () otherlv_1= 'sub2' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:674:2: ( () otherlv_1= 'sub2' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:674:2: ( () otherlv_1= 'sub2' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:675:3: () otherlv_1= 'sub2'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:675:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:676:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1Sub2_Action1SubClassAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAction1Sub21710); 

            			doneLeaf(otherlv_1, elementTypeProvider.getAction1Sub2_Sub2Keyword_1ElementType());
            		

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
    // $ANTLR end "ruleAction1Sub2"


    // $ANTLR start "ruleEnumBugEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:692:1: ruleEnumBugEnum : ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) ;
    public final void ruleEnumBugEnum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:692:16: ( ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:693:2: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:693:2: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt9=1;
                }
                break;
            case 30:
                {
                alt9=2;
                }
                break;
            case 31:
                {
                alt9=3;
                }
                break;
            case 32:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:694:3: (enumLiteral_0= 'array' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:694:3: (enumLiteral_0= 'array' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:695:4: enumLiteral_0= 'array'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEnumBugEnum1743); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getEnumBugEnum_ArrayEnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:704:3: (enumLiteral_1= 'object' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:704:3: (enumLiteral_1= 'object' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:705:4: enumLiteral_1= 'object'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleEnumBugEnum1776); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getEnumBugEnum_ObjectEnumLiteralDeclaration_1ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:714:3: (enumLiteral_2= 'resultSet' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:714:3: (enumLiteral_2= 'resultSet' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:715:4: enumLiteral_2= 'resultSet'
                    {

                    				markLeaf();
                    			
                    enumLiteral_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEnumBugEnum1809); 

                    				doneLeaf(enumLiteral_2, elementTypeProvider.getEnumBugEnum_ResultSetEnumLiteralDeclaration_2ElementType());
                    			

                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:724:3: (enumLiteral_3= 'iterator' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:724:3: (enumLiteral_3= 'iterator' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalHiddenTokensMergerTestLanguage.g:725:4: enumLiteral_3= 'iterator'
                    {

                    				markLeaf();
                    			
                    enumLiteral_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumBugEnum1842); 

                    				doneLeaf(enumLiteral_3, elementTypeProvider.getEnumBugEnum_IteratorEnumLiteralDeclaration_3ElementType());
                    			

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
    // $ANTLR end "ruleEnumBugEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeBug286557_in_ruleModel81 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumBug_in_ruleModel101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentable_in_ruleModel121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_ruleModel141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRefList_in_ruleModel161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleRef_in_ruleModel181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEnd_in_ruleModel201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1_in_ruleModel221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeBug286557247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDatatypeBug286557270 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557297 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleDatatypeBug286557328 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557358 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleDatatypeBug286557391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN411 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN440 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleFQN460 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN477 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleEnumBug_in_entryRuleEnumBug503 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumBug509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEnumBug532 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleEnumBug546 = new BitSet(new long[]{0x00000001E0000000L});
        public static final BitSet FOLLOW_ruleEnumBugEnum_in_ruleEnumBug573 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumBug611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentable_in_entryRuleCommentable642 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentable648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleCommentable671 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_ruleCommentable698 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem730 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentableItem736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleCommentableItem759 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommentableItem786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_entryRuleValueList817 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueList823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleValueList846 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleValueList873 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefList_in_entryRuleRefList905 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefList911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleRefList934 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleRefObj_in_ruleRefList961 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleRefList987 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefList1012 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefObj_in_entryRuleRefObj1044 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefObj1050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefObj1079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleRef_in_entryRuleSingleRef1104 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleRef1110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleSingleRef1133 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleRefObj_in_ruleSingleRef1160 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSingleRef1185 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSingleRef1210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEnd_in_entryRuleAppendToFileEnd1241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAppendToFileEnd1247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleAppendToFileEnd1270 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEndItem_in_ruleAppendToFileEnd1297 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEndItem_in_entryRuleAppendToFileEndItem1329 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAppendToFileEndItem1335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleAppendToFileEndItem1358 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAppendToFileEndItem1385 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleAppendToFileEndItem1410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1_in_entryRuleAction11430 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction11436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleAction11459 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAction11499 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_ruleAction1Sub1_in_ruleAction11537 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_ruleAction1Sub2_in_ruleAction11575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1Sub1_in_entryRuleAction1Sub11606 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction1Sub11612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAction1Sub11648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1Sub2_in_entryRuleAction1Sub21668 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction1Sub21674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAction1Sub21710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleEnumBugEnum1743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleEnumBugEnum1776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleEnumBugEnum1809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumBugEnum1842 = new BitSet(new long[]{0x0000000000000002L});
    }


}