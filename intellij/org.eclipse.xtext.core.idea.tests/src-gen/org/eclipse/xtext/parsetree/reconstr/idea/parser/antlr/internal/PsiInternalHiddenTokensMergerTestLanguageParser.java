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
    // PsiInternalHiddenTokensMergerTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalHiddenTokensMergerTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean this_DatatypeBug286557_0 = null;

        Boolean this_EnumBug_1 = null;

        Boolean this_Commentable_2 = null;

        Boolean this_ValueList_3 = null;

        Boolean this_RefList_4 = null;

        Boolean this_SingleRef_5 = null;

        Boolean this_AppendToFileEnd_6 = null;

        Boolean this_Action1_7 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:60:1: ( (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:61:2: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:61:2: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 )
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
                    // PsiInternalHiddenTokensMergerTestLanguage.g:62:3: this_DatatypeBug286557_0= ruleDatatypeBug286557
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeBug286557ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DatatypeBug286557_0=ruleDatatypeBug286557();

                    state._fsp--;


                    			current = this_DatatypeBug286557_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:71:3: this_EnumBug_1= ruleEnumBug
                    {

                    			markComposite(elementTypeProvider.getModel_EnumBugParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EnumBug_1=ruleEnumBug();

                    state._fsp--;


                    			current = this_EnumBug_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:80:3: this_Commentable_2= ruleCommentable
                    {

                    			markComposite(elementTypeProvider.getModel_CommentableParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Commentable_2=ruleCommentable();

                    state._fsp--;


                    			current = this_Commentable_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:89:3: this_ValueList_3= ruleValueList
                    {

                    			markComposite(elementTypeProvider.getModel_ValueListParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ValueList_3=ruleValueList();

                    state._fsp--;


                    			current = this_ValueList_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:98:3: this_RefList_4= ruleRefList
                    {

                    			markComposite(elementTypeProvider.getModel_RefListParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RefList_4=ruleRefList();

                    state._fsp--;


                    			current = this_RefList_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:107:3: this_SingleRef_5= ruleSingleRef
                    {

                    			markComposite(elementTypeProvider.getModel_SingleRefParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SingleRef_5=ruleSingleRef();

                    state._fsp--;


                    			current = this_SingleRef_5;
                    			doneComposite();
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:116:3: this_AppendToFileEnd_6= ruleAppendToFileEnd
                    {

                    			markComposite(elementTypeProvider.getModel_AppendToFileEndParserRuleCall_6ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AppendToFileEnd_6=ruleAppendToFileEnd();

                    state._fsp--;


                    			current = this_AppendToFileEnd_6;
                    			doneComposite();
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:125:3: this_Action1_7= ruleAction1
                    {

                    			markComposite(elementTypeProvider.getModel_Action1ParserRuleCall_7ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Action1_7=ruleAction1();

                    state._fsp--;


                    			current = this_Action1_7;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDatatypeBug286557"
    // PsiInternalHiddenTokensMergerTestLanguage.g:137:1: entryRuleDatatypeBug286557 returns [Boolean current=false] : iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF ;
    public final Boolean entryRuleDatatypeBug286557() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatypeBug286557 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:137:59: (iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:138:2: iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF
            {
             markComposite(elementTypeProvider.getDatatypeBug286557ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeBug286557=ruleDatatypeBug286557();

            state._fsp--;

             current =iv_ruleDatatypeBug286557; 
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
    // $ANTLR end "entryRuleDatatypeBug286557"


    // $ANTLR start "ruleDatatypeBug286557"
    // PsiInternalHiddenTokensMergerTestLanguage.g:144:1: ruleDatatypeBug286557 returns [Boolean current=false] : (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) ;
    public final Boolean ruleDatatypeBug286557() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_name_1_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:145:1: ( (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:146:2: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:146:2: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:147:3: otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';'
            {

            			markLeaf(elementTypeProvider.getDatatypeBug286557_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:154:3: ( (lv_name_1_0= ruleFQN ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:155:4: (lv_name_1_0= ruleFQN )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:155:4: (lv_name_1_0= ruleFQN )
            // PsiInternalHiddenTokensMergerTestLanguage.g:156:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getDatatypeBug286557_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:169:3: (otherlv_2= 'ref' ( ( ruleFQN ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:170:4: otherlv_2= 'ref' ( ( ruleFQN ) )
                    {

                    				markLeaf(elementTypeProvider.getDatatypeBug286557_RefKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalHiddenTokensMergerTestLanguage.g:177:4: ( ( ruleFQN ) )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:178:5: ( ruleFQN )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:178:5: ( ruleFQN )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:179:6: ruleFQN
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleDatatypeBug286557"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalHiddenTokensMergerTestLanguage.g:206:1: entryRuleFQN returns [Boolean current=false] : iv_ruleFQN= ruleFQN EOF ;
    public final Boolean entryRuleFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:206:45: (iv_ruleFQN= ruleFQN EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:207:2: iv_ruleFQN= ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN; 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalHiddenTokensMergerTestLanguage.g:213:1: ruleFQN returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleFQN() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:214:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:215:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:215:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:216:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:223:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:224:4: kw= '.' this_ID_2= RULE_ID
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
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleEnumBug"
    // PsiInternalHiddenTokensMergerTestLanguage.g:243:1: entryRuleEnumBug returns [Boolean current=false] : iv_ruleEnumBug= ruleEnumBug EOF ;
    public final Boolean entryRuleEnumBug() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumBug = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:243:49: (iv_ruleEnumBug= ruleEnumBug EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:244:2: iv_ruleEnumBug= ruleEnumBug EOF
            {
             markComposite(elementTypeProvider.getEnumBugElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumBug=ruleEnumBug();

            state._fsp--;

             current =iv_ruleEnumBug; 
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
    // $ANTLR end "entryRuleEnumBug"


    // $ANTLR start "ruleEnumBug"
    // PsiInternalHiddenTokensMergerTestLanguage.g:250:1: ruleEnumBug returns [Boolean current=false] : (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleEnumBug() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Boolean lv_return_2_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:251:1: ( (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:252:2: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:252:2: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:253:3: otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getEnumBug_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getEnumBug_Kw1Keyword_1ElementType());
            		
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:267:3: ( (lv_return_2_0= ruleEnumBugEnum ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:268:4: (lv_return_2_0= ruleEnumBugEnum )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:268:4: (lv_return_2_0= ruleEnumBugEnum )
            // PsiInternalHiddenTokensMergerTestLanguage.g:269:5: lv_return_2_0= ruleEnumBugEnum
            {

            					markComposite(elementTypeProvider.getEnumBug_ReturnEnumBugEnumEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            lv_return_2_0=ruleEnumBugEnum();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:282:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:283:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:283:4: (lv_name_3_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:284:5: lv_name_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumBug_NameIDTerminalRuleCall_3_0ElementType());
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleEnumBug"


    // $ANTLR start "entryRuleCommentable"
    // PsiInternalHiddenTokensMergerTestLanguage.g:303:1: entryRuleCommentable returns [Boolean current=false] : iv_ruleCommentable= ruleCommentable EOF ;
    public final Boolean entryRuleCommentable() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCommentable = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:303:53: (iv_ruleCommentable= ruleCommentable EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:304:2: iv_ruleCommentable= ruleCommentable EOF
            {
             markComposite(elementTypeProvider.getCommentableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommentable=ruleCommentable();

            state._fsp--;

             current =iv_ruleCommentable; 
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
    // $ANTLR end "entryRuleCommentable"


    // $ANTLR start "ruleCommentable"
    // PsiInternalHiddenTokensMergerTestLanguage.g:310:1: ruleCommentable returns [Boolean current=false] : (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) ;
    public final Boolean ruleCommentable() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_item_1_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:311:1: ( (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:312:2: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:312:2: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:313:3: otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )*
            {

            			markLeaf(elementTypeProvider.getCommentable_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:320:3: ( (lv_item_1_0= ruleCommentableItem ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:321:4: (lv_item_1_0= ruleCommentableItem )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:321:4: (lv_item_1_0= ruleCommentableItem )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:322:5: lv_item_1_0= ruleCommentableItem
            	    {

            	    					markComposite(elementTypeProvider.getCommentable_ItemCommentableItemParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    lv_item_1_0=ruleCommentableItem();

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
    // $ANTLR end "ruleCommentable"


    // $ANTLR start "entryRuleCommentableItem"
    // PsiInternalHiddenTokensMergerTestLanguage.g:339:1: entryRuleCommentableItem returns [Boolean current=false] : iv_ruleCommentableItem= ruleCommentableItem EOF ;
    public final Boolean entryRuleCommentableItem() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCommentableItem = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:339:57: (iv_ruleCommentableItem= ruleCommentableItem EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:340:2: iv_ruleCommentableItem= ruleCommentableItem EOF
            {
             markComposite(elementTypeProvider.getCommentableItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommentableItem=ruleCommentableItem();

            state._fsp--;

             current =iv_ruleCommentableItem; 
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
    // $ANTLR end "entryRuleCommentableItem"


    // $ANTLR start "ruleCommentableItem"
    // PsiInternalHiddenTokensMergerTestLanguage.g:346:1: ruleCommentableItem returns [Boolean current=false] : (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleCommentableItem() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_id_1_0=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:347:1: ( (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:348:2: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:348:2: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:349:3: otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getCommentableItem_ItemKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:356:3: ( (lv_id_1_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:357:4: (lv_id_1_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:357:4: (lv_id_1_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:358:5: lv_id_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommentableItem_IdIDTerminalRuleCall_1_0ElementType());
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleCommentableItem"


    // $ANTLR start "entryRuleValueList"
    // PsiInternalHiddenTokensMergerTestLanguage.g:377:1: entryRuleValueList returns [Boolean current=false] : iv_ruleValueList= ruleValueList EOF ;
    public final Boolean entryRuleValueList() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleValueList = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:377:51: (iv_ruleValueList= ruleValueList EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:378:2: iv_ruleValueList= ruleValueList EOF
            {
             markComposite(elementTypeProvider.getValueListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueList=ruleValueList();

            state._fsp--;

             current =iv_ruleValueList; 
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
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // PsiInternalHiddenTokensMergerTestLanguage.g:384:1: ruleValueList returns [Boolean current=false] : (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) ;
    public final Boolean ruleValueList() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_ids_1_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:385:1: ( (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:386:2: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:386:2: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:387:3: otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )*
            {

            			markLeaf(elementTypeProvider.getValueList_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:394:3: ( (lv_ids_1_0= ruleFQN ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:395:4: (lv_ids_1_0= ruleFQN )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:395:4: (lv_ids_1_0= ruleFQN )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:396:5: lv_ids_1_0= ruleFQN
            	    {

            	    					markComposite(elementTypeProvider.getValueList_IdsFQNParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_ids_1_0=ruleFQN();

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
    // $ANTLR end "ruleValueList"


    // $ANTLR start "entryRuleRefList"
    // PsiInternalHiddenTokensMergerTestLanguage.g:413:1: entryRuleRefList returns [Boolean current=false] : iv_ruleRefList= ruleRefList EOF ;
    public final Boolean entryRuleRefList() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRefList = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:413:49: (iv_ruleRefList= ruleRefList EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:414:2: iv_ruleRefList= ruleRefList EOF
            {
             markComposite(elementTypeProvider.getRefListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRefList=ruleRefList();

            state._fsp--;

             current =iv_ruleRefList; 
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
    // $ANTLR end "entryRuleRefList"


    // $ANTLR start "ruleRefList"
    // PsiInternalHiddenTokensMergerTestLanguage.g:420:1: ruleRefList returns [Boolean current=false] : (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) ;
    public final Boolean ruleRefList() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_objs_1_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:421:1: ( (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:422:2: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:422:2: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:423:3: otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )*
            {

            			markLeaf(elementTypeProvider.getRefList_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:430:3: ( (lv_objs_1_0= ruleRefObj ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:431:4: (lv_objs_1_0= ruleRefObj )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:431:4: (lv_objs_1_0= ruleRefObj )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:432:5: lv_objs_1_0= ruleRefObj
            	    {

            	    					markComposite(elementTypeProvider.getRefList_ObjsRefObjParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_objs_1_0=ruleRefObj();

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
            	    break loop6;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getRefList_RefsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:452:3: ( ( ruleFQN ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:453:4: ( ruleFQN )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:453:4: ( ruleFQN )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:454:5: ruleFQN
            	    {

            	    					if (!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
        return current;
    }
    // $ANTLR end "ruleRefList"


    // $ANTLR start "entryRuleRefObj"
    // PsiInternalHiddenTokensMergerTestLanguage.g:473:1: entryRuleRefObj returns [Boolean current=false] : iv_ruleRefObj= ruleRefObj EOF ;
    public final Boolean entryRuleRefObj() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRefObj = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:473:48: (iv_ruleRefObj= ruleRefObj EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:474:2: iv_ruleRefObj= ruleRefObj EOF
            {
             markComposite(elementTypeProvider.getRefObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRefObj=ruleRefObj();

            state._fsp--;

             current =iv_ruleRefObj; 
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
    // $ANTLR end "entryRuleRefObj"


    // $ANTLR start "ruleRefObj"
    // PsiInternalHiddenTokensMergerTestLanguage.g:480:1: ruleRefObj returns [Boolean current=false] : ( (lv_name_0_0= ruleFQN ) ) ;
    public final Boolean ruleRefObj() throws RecognitionException {
        Boolean current = false;

        Boolean lv_name_0_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:481:1: ( ( (lv_name_0_0= ruleFQN ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:482:2: ( (lv_name_0_0= ruleFQN ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:482:2: ( (lv_name_0_0= ruleFQN ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:483:3: (lv_name_0_0= ruleFQN )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:483:3: (lv_name_0_0= ruleFQN )
            // PsiInternalHiddenTokensMergerTestLanguage.g:484:4: lv_name_0_0= ruleFQN
            {

            				markComposite(elementTypeProvider.getRefObj_NameFQNParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=ruleFQN();

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
    // $ANTLR end "ruleRefObj"


    // $ANTLR start "entryRuleSingleRef"
    // PsiInternalHiddenTokensMergerTestLanguage.g:500:1: entryRuleSingleRef returns [Boolean current=false] : iv_ruleSingleRef= ruleSingleRef EOF ;
    public final Boolean entryRuleSingleRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleRef = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:500:51: (iv_ruleSingleRef= ruleSingleRef EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:501:2: iv_ruleSingleRef= ruleSingleRef EOF
            {
             markComposite(elementTypeProvider.getSingleRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleRef=ruleSingleRef();

            state._fsp--;

             current =iv_ruleSingleRef; 
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
    // $ANTLR end "entryRuleSingleRef"


    // $ANTLR start "ruleSingleRef"
    // PsiInternalHiddenTokensMergerTestLanguage.g:507:1: ruleSingleRef returns [Boolean current=false] : (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) ;
    public final Boolean ruleSingleRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_obj_1_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:508:1: ( (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:509:2: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:509:2: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:510:3: otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) )
            {

            			markLeaf(elementTypeProvider.getSingleRef_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:517:3: ( (lv_obj_1_0= ruleRefObj ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:518:4: (lv_obj_1_0= ruleRefObj )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:518:4: (lv_obj_1_0= ruleRefObj )
            // PsiInternalHiddenTokensMergerTestLanguage.g:519:5: lv_obj_1_0= ruleRefObj
            {

            					markComposite(elementTypeProvider.getSingleRef_ObjRefObjParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_12);
            lv_obj_1_0=ruleRefObj();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getSingleRef_RefKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:539:3: ( ( ruleFQN ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:540:4: ( ruleFQN )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:540:4: ( ruleFQN )
            // PsiInternalHiddenTokensMergerTestLanguage.g:541:5: ruleFQN
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleSingleRef"


    // $ANTLR start "entryRuleAppendToFileEnd"
    // PsiInternalHiddenTokensMergerTestLanguage.g:560:1: entryRuleAppendToFileEnd returns [Boolean current=false] : iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF ;
    public final Boolean entryRuleAppendToFileEnd() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAppendToFileEnd = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:560:57: (iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:561:2: iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF
            {
             markComposite(elementTypeProvider.getAppendToFileEndElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAppendToFileEnd=ruleAppendToFileEnd();

            state._fsp--;

             current =iv_ruleAppendToFileEnd; 
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
    // $ANTLR end "entryRuleAppendToFileEnd"


    // $ANTLR start "ruleAppendToFileEnd"
    // PsiInternalHiddenTokensMergerTestLanguage.g:567:1: ruleAppendToFileEnd returns [Boolean current=false] : (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) ;
    public final Boolean ruleAppendToFileEnd() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_items_1_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:568:1: ( (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:569:2: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:569:2: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            // PsiInternalHiddenTokensMergerTestLanguage.g:570:3: otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            {

            			markLeaf(elementTypeProvider.getAppendToFileEnd_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_13); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:577:3: ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:578:4: (lv_items_1_0= ruleAppendToFileEndItem )
            	    {
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:578:4: (lv_items_1_0= ruleAppendToFileEndItem )
            	    // PsiInternalHiddenTokensMergerTestLanguage.g:579:5: lv_items_1_0= ruleAppendToFileEndItem
            	    {

            	    					markComposite(elementTypeProvider.getAppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_items_1_0=ruleAppendToFileEndItem();

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
        return current;
    }
    // $ANTLR end "ruleAppendToFileEnd"


    // $ANTLR start "entryRuleAppendToFileEndItem"
    // PsiInternalHiddenTokensMergerTestLanguage.g:596:1: entryRuleAppendToFileEndItem returns [Boolean current=false] : iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF ;
    public final Boolean entryRuleAppendToFileEndItem() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAppendToFileEndItem = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:596:61: (iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:597:2: iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF
            {
             markComposite(elementTypeProvider.getAppendToFileEndItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAppendToFileEndItem=ruleAppendToFileEndItem();

            state._fsp--;

             current =iv_ruleAppendToFileEndItem; 
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
    // $ANTLR end "entryRuleAppendToFileEndItem"


    // $ANTLR start "ruleAppendToFileEndItem"
    // PsiInternalHiddenTokensMergerTestLanguage.g:603:1: ruleAppendToFileEndItem returns [Boolean current=false] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) ;
    public final Boolean ruleAppendToFileEndItem() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:604:1: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:605:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:605:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:606:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass'
            {

            			markLeaf(elementTypeProvider.getAppendToFileEndItem_ClassKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:613:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:614:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:614:4: (lv_name_1_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:615:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAppendToFileEndItem_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleAppendToFileEndItem"


    // $ANTLR start "entryRuleAction1"
    // PsiInternalHiddenTokensMergerTestLanguage.g:641:1: entryRuleAction1 returns [Boolean current=false] : iv_ruleAction1= ruleAction1 EOF ;
    public final Boolean entryRuleAction1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAction1 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:641:49: (iv_ruleAction1= ruleAction1 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:642:2: iv_ruleAction1= ruleAction1 EOF
            {
             markComposite(elementTypeProvider.getAction1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction1=ruleAction1();

            state._fsp--;

             current =iv_ruleAction1; 
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
    // $ANTLR end "entryRuleAction1"


    // $ANTLR start "ruleAction1"
    // PsiInternalHiddenTokensMergerTestLanguage.g:648:1: ruleAction1 returns [Boolean current=false] : (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) ;
    public final Boolean ruleAction1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Boolean lv_actions2_3_0 = null;

        Boolean lv_actions2_4_0 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:649:1: ( (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:650:2: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:650:2: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:651:3: otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            {

            			markLeaf(elementTypeProvider.getAction1_NumberSignDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokensMergerTestLanguage.g:658:3: ()
            // PsiInternalHiddenTokensMergerTestLanguage.g:659:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1_Action1Action_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:665:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:666:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:666:4: (lv_name_2_0= RULE_ID )
            // PsiInternalHiddenTokensMergerTestLanguage.g:667:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAction1_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:682:3: ( (lv_actions2_3_0= ruleAction1Sub1 ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:683:4: (lv_actions2_3_0= ruleAction1Sub1 )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:683:4: (lv_actions2_3_0= ruleAction1Sub1 )
            // PsiInternalHiddenTokensMergerTestLanguage.g:684:5: lv_actions2_3_0= ruleAction1Sub1
            {

            					markComposite(elementTypeProvider.getAction1_Actions2Action1Sub1ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_16);
            lv_actions2_3_0=ruleAction1Sub1();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalHiddenTokensMergerTestLanguage.g:697:3: ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:698:4: (lv_actions2_4_0= ruleAction1Sub2 )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:698:4: (lv_actions2_4_0= ruleAction1Sub2 )
            // PsiInternalHiddenTokensMergerTestLanguage.g:699:5: lv_actions2_4_0= ruleAction1Sub2
            {

            					markComposite(elementTypeProvider.getAction1_Actions2Action1Sub2ParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_actions2_4_0=ruleAction1Sub2();

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
    // $ANTLR end "ruleAction1"


    // $ANTLR start "entryRuleAction1Sub1"
    // PsiInternalHiddenTokensMergerTestLanguage.g:716:1: entryRuleAction1Sub1 returns [Boolean current=false] : iv_ruleAction1Sub1= ruleAction1Sub1 EOF ;
    public final Boolean entryRuleAction1Sub1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAction1Sub1 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:716:53: (iv_ruleAction1Sub1= ruleAction1Sub1 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:717:2: iv_ruleAction1Sub1= ruleAction1Sub1 EOF
            {
             markComposite(elementTypeProvider.getAction1Sub1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction1Sub1=ruleAction1Sub1();

            state._fsp--;

             current =iv_ruleAction1Sub1; 
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
    // $ANTLR end "entryRuleAction1Sub1"


    // $ANTLR start "ruleAction1Sub1"
    // PsiInternalHiddenTokensMergerTestLanguage.g:723:1: ruleAction1Sub1 returns [Boolean current=false] : ( () otherlv_1= 'sub1' ) ;
    public final Boolean ruleAction1Sub1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:724:1: ( ( () otherlv_1= 'sub1' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:725:2: ( () otherlv_1= 'sub1' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:725:2: ( () otherlv_1= 'sub1' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:726:3: () otherlv_1= 'sub1'
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:726:3: ()
            // PsiInternalHiddenTokensMergerTestLanguage.g:727:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1Sub1_Action1SubAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
        return current;
    }
    // $ANTLR end "ruleAction1Sub1"


    // $ANTLR start "entryRuleAction1Sub2"
    // PsiInternalHiddenTokensMergerTestLanguage.g:744:1: entryRuleAction1Sub2 returns [Boolean current=false] : iv_ruleAction1Sub2= ruleAction1Sub2 EOF ;
    public final Boolean entryRuleAction1Sub2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAction1Sub2 = null;


        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:744:53: (iv_ruleAction1Sub2= ruleAction1Sub2 EOF )
            // PsiInternalHiddenTokensMergerTestLanguage.g:745:2: iv_ruleAction1Sub2= ruleAction1Sub2 EOF
            {
             markComposite(elementTypeProvider.getAction1Sub2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction1Sub2=ruleAction1Sub2();

            state._fsp--;

             current =iv_ruleAction1Sub2; 
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
    // $ANTLR end "entryRuleAction1Sub2"


    // $ANTLR start "ruleAction1Sub2"
    // PsiInternalHiddenTokensMergerTestLanguage.g:751:1: ruleAction1Sub2 returns [Boolean current=false] : ( () otherlv_1= 'sub2' ) ;
    public final Boolean ruleAction1Sub2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:752:1: ( ( () otherlv_1= 'sub2' ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:753:2: ( () otherlv_1= 'sub2' )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:753:2: ( () otherlv_1= 'sub2' )
            // PsiInternalHiddenTokensMergerTestLanguage.g:754:3: () otherlv_1= 'sub2'
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:754:3: ()
            // PsiInternalHiddenTokensMergerTestLanguage.g:755:4: 
            {

            				precedeComposite(elementTypeProvider.getAction1Sub2_Action1SubClassAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
        return current;
    }
    // $ANTLR end "ruleAction1Sub2"


    // $ANTLR start "ruleEnumBugEnum"
    // PsiInternalHiddenTokensMergerTestLanguage.g:772:1: ruleEnumBugEnum returns [Boolean current=false] : ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) ;
    public final Boolean ruleEnumBugEnum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

        try {
            // PsiInternalHiddenTokensMergerTestLanguage.g:773:1: ( ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) )
            // PsiInternalHiddenTokensMergerTestLanguage.g:774:2: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
            {
            // PsiInternalHiddenTokensMergerTestLanguage.g:774:2: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
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
                    // PsiInternalHiddenTokensMergerTestLanguage.g:775:3: (enumLiteral_0= 'array' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:775:3: (enumLiteral_0= 'array' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:776:4: enumLiteral_0= 'array'
                    {

                    				markLeaf(elementTypeProvider.getEnumBugEnum_ArrayEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:785:3: (enumLiteral_1= 'object' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:785:3: (enumLiteral_1= 'object' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:786:4: enumLiteral_1= 'object'
                    {

                    				markLeaf(elementTypeProvider.getEnumBugEnum_ObjectEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:795:3: (enumLiteral_2= 'resultSet' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:795:3: (enumLiteral_2= 'resultSet' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:796:4: enumLiteral_2= 'resultSet'
                    {

                    				markLeaf(elementTypeProvider.getEnumBugEnum_ResultSetEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalHiddenTokensMergerTestLanguage.g:805:3: (enumLiteral_3= 'iterator' )
                    {
                    // PsiInternalHiddenTokensMergerTestLanguage.g:805:3: (enumLiteral_3= 'iterator' )
                    // PsiInternalHiddenTokensMergerTestLanguage.g:806:4: enumLiteral_3= 'iterator'
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
        return current;
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