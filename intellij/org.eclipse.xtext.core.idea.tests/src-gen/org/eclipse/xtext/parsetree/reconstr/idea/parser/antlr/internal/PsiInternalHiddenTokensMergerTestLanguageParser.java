package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalHiddenTokensMergerTestLanguage.g"; }



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
    // PsiInternalHiddenTokensMergerTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalHiddenTokensMergerTestLanguage.g:58:1: ruleModel : ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:58:10: ( ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:59:2: ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:59:2: ( ruleDatatypeBug286557 | ruleEnumBug | ruleCommentable | ruleValueList | ruleRefList | ruleSingleRef | ruleAppendToFileEnd | ruleAction1 )
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
                    // PsiInternalHiddenTokensMergerTestLanguage.g:60:3: ruleDatatypeBug286557
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeBug286557ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatypeBug286557();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:68:3: ruleEnumBug
                    {

                    			markComposite(elementTypeProvider.getModel_EnumBugParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEnumBug();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:76:3: ruleCommentable
                    {

                    			markComposite(elementTypeProvider.getModel_CommentableParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCommentable();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:84:3: ruleValueList
                    {

                    			markComposite(elementTypeProvider.getModel_ValueListParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleValueList();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:92:3: ruleRefList
                    {

                    			markComposite(elementTypeProvider.getModel_RefListParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRefList();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:100:3: ruleSingleRef
                    {

                    			markComposite(elementTypeProvider.getModel_SingleRefParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSingleRef();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:108:3: ruleAppendToFileEnd
                    {

                    			markComposite(elementTypeProvider.getModel_AppendToFileEndParserRuleCall_6ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAppendToFileEnd();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:116:3: ruleAction1
                    {

                    			markComposite(elementTypeProvider.getModel_Action1ParserRuleCall_7ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:127:1: entryRuleDatatypeBug286557 : ruleDatatypeBug286557 EOF ;
    public final void entryRuleDatatypeBug286557() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:127:27: ( ruleDatatypeBug286557 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:128:2: ruleDatatypeBug286557 EOF
            {
             markComposite(elementTypeProvider.getDatatypeBug286557ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatypeBug286557();

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
    // $ANTLR end "entryRuleDatatypeBug286557"


    // $ANTLR start "ruleDatatypeBug286557"
    // PsiInternalHiddenTokensMergerTestLanguage.g:133:1: ruleDatatypeBug286557 : (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) ;
    public final void ruleDatatypeBug286557() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:133:22: ( (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:134:2: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:134:2: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:135:3: otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';'
            {

            			markLeaf(elementTypeProvider.getDatatypeBug286557_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:142:3: ( (lv_name_1_0= ruleFQN ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:143:4: (lv_name_1_0= ruleFQN )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:143:4: (lv_name_1_0= ruleFQN )
            // PsiInternalHiddenTokensMergerTestLanguage.g:144:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getDatatypeBug286557_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:153:3: (otherlv_2= 'ref' ( ( ruleFQN ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:154:4: otherlv_2= 'ref' ( ( ruleFQN ) )
                    {

                    				markLeaf(elementTypeProvider.getDatatypeBug286557_RefKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalHiddenTokensMergerTestLanguage.g:161:4: ( ( ruleFQN ) )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:162:5: ( ruleFQN )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:162:5: ( ruleFQN )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:163:6: ruleFQN
                    {

                    						markComposite(elementTypeProvider.getDatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_5);
                    ruleFQN();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getDatatypeBug286557_SemicolonKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleDatatypeBug286557"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalHiddenTokensMergerTestLanguage.g:184:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:184:13: ( ruleFQN EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:185:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalHiddenTokensMergerTestLanguage.g:190:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:190:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:191:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:191:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:192:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:199:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:200:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    				doneLeaf(this_ID_2);
            	    			

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
    // PsiInternalHiddenTokensMergerTestLanguage.g:219:1: entryRuleEnumBug : ruleEnumBug EOF ;
    public final void entryRuleEnumBug() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:219:17: ( ruleEnumBug EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:220:2: ruleEnumBug EOF
            {
             markComposite(elementTypeProvider.getEnumBugElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumBug();

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
    // $ANTLR end "entryRuleEnumBug"


    // $ANTLR start "ruleEnumBug"
    // PsiInternalHiddenTokensMergerTestLanguage.g:225:1: ruleEnumBug : (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final void ruleEnumBug() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:225:12: ( (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:226:2: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:226:2: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:227:3: otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getEnumBug_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getEnumBug_Kw1Keyword_1ElementType());
            		
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:241:3: ( (lv_return_2_0= ruleEnumBugEnum ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:242:4: (lv_return_2_0= ruleEnumBugEnum )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:242:4: (lv_return_2_0= ruleEnumBugEnum )
            // PsiInternalHiddenTokensMergerTestLanguage.g:243:5: lv_return_2_0= ruleEnumBugEnum
            {

            					markComposite(elementTypeProvider.getEnumBug_ReturnEnumBugEnumEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            ruleEnumBugEnum();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:252:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:253:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:253:4: (lv_name_3_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:254:5: lv_name_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumBug_NameIDTerminalRuleCall_3_0ElementType());
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_3_0);
            				

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
    // PsiInternalHiddenTokensMergerTestLanguage.g:267:1: entryRuleCommentable : ruleCommentable EOF ;
    public final void entryRuleCommentable() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:267:21: ( ruleCommentable EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:268:2: ruleCommentable EOF
            {
             markComposite(elementTypeProvider.getCommentableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCommentable();

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
    // $ANTLR end "entryRuleCommentable"


    // $ANTLR start "ruleCommentable"
    // PsiInternalHiddenTokensMergerTestLanguage.g:273:1: ruleCommentable : (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) ;
    public final void ruleCommentable() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:273:16: ( (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:274:2: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:274:2: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:275:3: otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )*
            {

            			markLeaf(elementTypeProvider.getCommentable_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:282:3: ( (lv_item_1_0= ruleCommentableItem ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:283:4: (lv_item_1_0= ruleCommentableItem )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:283:4: (lv_item_1_0= ruleCommentableItem )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:284:5: lv_item_1_0= ruleCommentableItem
            	    {

            	    					markComposite(elementTypeProvider.getCommentable_ItemCommentableItemParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_9);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:297:1: entryRuleCommentableItem : ruleCommentableItem EOF ;
    public final void entryRuleCommentableItem() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:297:25: ( ruleCommentableItem EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:298:2: ruleCommentableItem EOF
            {
             markComposite(elementTypeProvider.getCommentableItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCommentableItem();

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
    // $ANTLR end "entryRuleCommentableItem"


    // $ANTLR start "ruleCommentableItem"
    // PsiInternalHiddenTokensMergerTestLanguage.g:303:1: ruleCommentableItem : (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final void ruleCommentableItem() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_id_1_0=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:303:20: ( (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:304:2: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:304:2: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:305:3: otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getCommentableItem_ItemKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:312:3: ( (lv_id_1_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:313:4: (lv_id_1_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:313:4: (lv_id_1_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:314:5: lv_id_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommentableItem_IdIDTerminalRuleCall_1_0ElementType());
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_id_1_0);
            				

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
    // PsiInternalHiddenTokensMergerTestLanguage.g:327:1: entryRuleValueList : ruleValueList EOF ;
    public final void entryRuleValueList() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:327:19: ( ruleValueList EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:328:2: ruleValueList EOF
            {
             markComposite(elementTypeProvider.getValueListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleValueList();

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
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // PsiInternalHiddenTokensMergerTestLanguage.g:333:1: ruleValueList : (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) ;
    public final void ruleValueList() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:333:14: ( (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:334:2: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:334:2: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:335:3: otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )*
            {

            			markLeaf(elementTypeProvider.getValueList_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:342:3: ( (lv_ids_1_0= ruleFQN ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:343:4: (lv_ids_1_0= ruleFQN )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:343:4: (lv_ids_1_0= ruleFQN )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:344:5: lv_ids_1_0= ruleFQN
            	    {

            	    					markComposite(elementTypeProvider.getValueList_IdsFQNParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:357:1: entryRuleRefList : ruleRefList EOF ;
    public final void entryRuleRefList() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:357:17: ( ruleRefList EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:358:2: ruleRefList EOF
            {
             markComposite(elementTypeProvider.getRefListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRefList();

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
    // $ANTLR end "entryRuleRefList"


    // $ANTLR start "ruleRefList"
    // PsiInternalHiddenTokensMergerTestLanguage.g:363:1: ruleRefList : (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) ;
    public final void ruleRefList() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:363:12: ( (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:364:2: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:364:2: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:365:3: otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )*
            {

            			markLeaf(elementTypeProvider.getRefList_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:372:3: ( (lv_objs_1_0= ruleRefObj ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:373:4: (lv_objs_1_0= ruleRefObj )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:373:4: (lv_objs_1_0= ruleRefObj )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:374:5: lv_objs_1_0= ruleRefObj
            	    {

            	    					markComposite(elementTypeProvider.getRefList_ObjsRefObjParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
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


            			markLeaf(elementTypeProvider.getRefList_RefsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:390:3: ( ( ruleFQN ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:391:4: ( ruleFQN )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:391:4: ( ruleFQN )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:392:5: ruleFQN
            	    {

            	    					markComposite(elementTypeProvider.getRefList_RefsRefObjCrossReference_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:405:1: entryRuleRefObj : ruleRefObj EOF ;
    public final void entryRuleRefObj() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:405:16: ( ruleRefObj EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:406:2: ruleRefObj EOF
            {
             markComposite(elementTypeProvider.getRefObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRefObj();

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
    // $ANTLR end "entryRuleRefObj"


    // $ANTLR start "ruleRefObj"
    // PsiInternalHiddenTokensMergerTestLanguage.g:411:1: ruleRefObj : ( (lv_name_0_0= ruleFQN ) ) ;
    public final void ruleRefObj() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:411:11: ( ( (lv_name_0_0= ruleFQN ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:412:2: ( (lv_name_0_0= ruleFQN ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:412:2: ( (lv_name_0_0= ruleFQN ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:413:3: (lv_name_0_0= ruleFQN )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:413:3: (lv_name_0_0= ruleFQN )
            // PsiInternalHiddenTokensMergerTestLanguage.g:414:4: lv_name_0_0= ruleFQN
            {

            				markComposite(elementTypeProvider.getRefObj_NameFQNParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:426:1: entryRuleSingleRef : ruleSingleRef EOF ;
    public final void entryRuleSingleRef() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:426:19: ( ruleSingleRef EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:427:2: ruleSingleRef EOF
            {
             markComposite(elementTypeProvider.getSingleRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSingleRef();

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
    // $ANTLR end "entryRuleSingleRef"


    // $ANTLR start "ruleSingleRef"
    // PsiInternalHiddenTokensMergerTestLanguage.g:432:1: ruleSingleRef : (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) ;
    public final void ruleSingleRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:432:14: ( (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:433:2: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:433:2: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:434:3: otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) )
            {

            			markLeaf(elementTypeProvider.getSingleRef_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:441:3: ( (lv_obj_1_0= ruleRefObj ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:442:4: (lv_obj_1_0= ruleRefObj )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:442:4: (lv_obj_1_0= ruleRefObj )
            // PsiInternalHiddenTokensMergerTestLanguage.g:443:5: lv_obj_1_0= ruleRefObj
            {

            					markComposite(elementTypeProvider.getSingleRef_ObjRefObjParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_12);
            ruleRefObj();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getSingleRef_RefKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:459:3: ( ( ruleFQN ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:460:4: ( ruleFQN )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:460:4: ( ruleFQN )
            // PsiInternalHiddenTokensMergerTestLanguage.g:461:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getSingleRef_RefRefObjCrossReference_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:474:1: entryRuleAppendToFileEnd : ruleAppendToFileEnd EOF ;
    public final void entryRuleAppendToFileEnd() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:474:25: ( ruleAppendToFileEnd EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:475:2: ruleAppendToFileEnd EOF
            {
             markComposite(elementTypeProvider.getAppendToFileEndElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAppendToFileEnd();

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
    // $ANTLR end "entryRuleAppendToFileEnd"


    // $ANTLR start "ruleAppendToFileEnd"
    // PsiInternalHiddenTokensMergerTestLanguage.g:480:1: ruleAppendToFileEnd : (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) ;
    public final void ruleAppendToFileEnd() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:480:20: ( (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:481:2: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:481:2: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:482:3: otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            {

            			markLeaf(elementTypeProvider.getAppendToFileEnd_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_13); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:489:3: ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:490:4: (lv_items_1_0= ruleAppendToFileEndItem )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:490:4: (lv_items_1_0= ruleAppendToFileEndItem )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:491:5: lv_items_1_0= ruleAppendToFileEndItem
            	    {

            	    					markComposite(elementTypeProvider.getAppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_13);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:504:1: entryRuleAppendToFileEndItem : ruleAppendToFileEndItem EOF ;
    public final void entryRuleAppendToFileEndItem() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:504:29: ( ruleAppendToFileEndItem EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:505:2: ruleAppendToFileEndItem EOF
            {
             markComposite(elementTypeProvider.getAppendToFileEndItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAppendToFileEndItem();

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
    // $ANTLR end "entryRuleAppendToFileEndItem"


    // $ANTLR start "ruleAppendToFileEndItem"
    // PsiInternalHiddenTokensMergerTestLanguage.g:510:1: ruleAppendToFileEndItem : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) ;
    public final void ruleAppendToFileEndItem() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:510:24: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:511:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:511:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:512:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass'
            {

            			markLeaf(elementTypeProvider.getAppendToFileEndItem_ClassKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:519:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:520:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:520:4: (lv_name_1_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:521:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAppendToFileEndItem_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getAppendToFileEndItem_EndclassKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleAppendToFileEndItem"


    // $ANTLR start "entryRuleAction1"
    // PsiInternalHiddenTokensMergerTestLanguage.g:541:1: entryRuleAction1 : ruleAction1 EOF ;
    public final void entryRuleAction1() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:541:17: ( ruleAction1 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:542:2: ruleAction1 EOF
            {
             markComposite(elementTypeProvider.getAction1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAction1();

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
    // $ANTLR end "entryRuleAction1"


    // $ANTLR start "ruleAction1"
    // PsiInternalHiddenTokensMergerTestLanguage.g:547:1: ruleAction1 : (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) ;
    public final void ruleAction1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_2_0=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:547:12: ( (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:548:2: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:548:2: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:549:3: otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            {

            			markLeaf(elementTypeProvider.getAction1_NumberSignDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:556:3: ()
            // PsiInternalHiddenTokensMergerTestLanguage.g:557:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1_Action1Action_1ElementType());
            				doneComposite();
            			

            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:562:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:563:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:563:4: (lv_name_2_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:564:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAction1_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:573:3: ( (lv_actions2_3_0= ruleAction1Sub1 ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:574:4: (lv_actions2_3_0= ruleAction1Sub1 )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:574:4: (lv_actions2_3_0= ruleAction1Sub1 )
            // PsiInternalHiddenTokensMergerTestLanguage.g:575:5: lv_actions2_3_0= ruleAction1Sub1
            {

            					markComposite(elementTypeProvider.getAction1_Actions2Action1Sub1ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_16);
            ruleAction1Sub1();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:584:3: ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:585:4: (lv_actions2_4_0= ruleAction1Sub2 )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:585:4: (lv_actions2_4_0= ruleAction1Sub2 )
            // PsiInternalHiddenTokensMergerTestLanguage.g:586:5: lv_actions2_4_0= ruleAction1Sub2
            {

            					markComposite(elementTypeProvider.getAction1_Actions2Action1Sub2ParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalHiddenTokensMergerTestLanguage.g:599:1: entryRuleAction1Sub1 : ruleAction1Sub1 EOF ;
    public final void entryRuleAction1Sub1() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:599:21: ( ruleAction1Sub1 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:600:2: ruleAction1Sub1 EOF
            {
             markComposite(elementTypeProvider.getAction1Sub1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAction1Sub1();

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
    // $ANTLR end "entryRuleAction1Sub1"


    // $ANTLR start "ruleAction1Sub1"
    // PsiInternalHiddenTokensMergerTestLanguage.g:605:1: ruleAction1Sub1 : ( () otherlv_1= 'sub1' ) ;
    public final void ruleAction1Sub1() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:605:16: ( ( () otherlv_1= 'sub1' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:606:2: ( () otherlv_1= 'sub1' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:606:2: ( () otherlv_1= 'sub1' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:607:3: () otherlv_1= 'sub1'
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:607:3: ()
            // PsiInternalHiddenTokensMergerTestLanguage.g:608:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1Sub1_Action1SubAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getAction1Sub1_Sub1Keyword_1ElementType());
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

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
    // PsiInternalHiddenTokensMergerTestLanguage.g:624:1: entryRuleAction1Sub2 : ruleAction1Sub2 EOF ;
    public final void entryRuleAction1Sub2() throws RecognitionException {
        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:624:21: ( ruleAction1Sub2 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:625:2: ruleAction1Sub2 EOF
            {
             markComposite(elementTypeProvider.getAction1Sub2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAction1Sub2();

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
    // $ANTLR end "entryRuleAction1Sub2"


    // $ANTLR start "ruleAction1Sub2"
    // PsiInternalHiddenTokensMergerTestLanguage.g:630:1: ruleAction1Sub2 : ( () otherlv_1= 'sub2' ) ;
    public final void ruleAction1Sub2() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:630:16: ( ( () otherlv_1= 'sub2' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:631:2: ( () otherlv_1= 'sub2' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:631:2: ( () otherlv_1= 'sub2' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:632:3: () otherlv_1= 'sub2'
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:632:3: ()
            // PsiInternalHiddenTokensMergerTestLanguage.g:633:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1Sub2_Action1SubClassAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getAction1Sub2_Sub2Keyword_1ElementType());
            		
            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

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
    // PsiInternalHiddenTokensMergerTestLanguage.g:649:1: ruleEnumBugEnum : ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) ;
    public final void ruleEnumBugEnum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:649:16: ( ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:650:2: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:650:2: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
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
                    // PsiInternalHiddenTokensMergerTestLanguage.g:651:3: (enumLiteral_0= 'array' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:651:3: (enumLiteral_0= 'array' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:652:4: enumLiteral_0= 'array'
                    {

                    				markLeaf(elementTypeProvider.getEnumBugEnum_ArrayEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:661:3: (enumLiteral_1= 'object' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:661:3: (enumLiteral_1= 'object' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:662:4: enumLiteral_1= 'object'
                    {

                    				markLeaf(elementTypeProvider.getEnumBugEnum_ObjectEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:671:3: (enumLiteral_2= 'resultSet' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:671:3: (enumLiteral_2= 'resultSet' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:672:4: enumLiteral_2= 'resultSet'
                    {

                    				markLeaf(elementTypeProvider.getEnumBugEnum_ResultSetEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:681:3: (enumLiteral_3= 'iterator' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:681:3: (enumLiteral_3= 'iterator' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:682:4: enumLiteral_3= 'iterator'
                    {

                    				markLeaf(elementTypeProvider.getEnumBugEnum_IteratorEnumLiteralDeclaration_3ElementType());
                    			
                    enumLiteral_3=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_3);
                    			

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000001E0000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000000L});
    }


}