package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.reconstr.services.Bug299395TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug299395TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'['", "']'", "'subModel'", "'1'", "'2'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug299395TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug299395TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug299395TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g"; }



    	protected Bug299395TestLanguageGrammarAccess grammarAccess;

    	protected Bug299395TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug299395TestLanguageParser(PsiBuilder builder, TokenStream input, Bug299395TestLanguageElementTypeProvider elementTypeProvider, Bug299395TestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:59:1: ruleModel : ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_strings_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_keys_5_0=null;
        Token lv_values_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:59:10: ( ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:60:2: ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:60:2: ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:61:3: () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:61:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:62:4: 
            {

            				precedeComposite(elementTypeProvider.getModel_ModelAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:67:3: (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:68:4: otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}'
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel98); 

            	    				doneLeaf(otherlv_1, elementTypeProvider.getModel_LeftCurlyBracketKeyword_1_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:75:4: ( (lv_strings_2_0= RULE_STRING ) )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==RULE_STRING) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:76:5: (lv_strings_2_0= RULE_STRING )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:76:5: (lv_strings_2_0= RULE_STRING )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:77:6: lv_strings_2_0= RULE_STRING
            	            {

            	            						markLeaf();
            	            					
            	            lv_strings_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel130); 

            	            						doneLeaf(lv_strings_2_0, elementTypeProvider.getModel_StringsSTRINGTerminalRuleCall_1_1_0ElementType());
            	            					

            	            }


            	            }
            	            break;

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel161); 

            	    				doneLeaf(otherlv_3, elementTypeProvider.getModel_RightCurlyBracketKeyword_1_2ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:94:3: (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:95:4: otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']'
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel187); 

            	    				doneLeaf(otherlv_4, elementTypeProvider.getModel_LeftSquareBracketKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:102:4: ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_STRING) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:103:5: ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) )
            	    	    {
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:103:5: ( (lv_keys_5_0= RULE_STRING ) )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:104:6: (lv_keys_5_0= RULE_STRING )
            	    	    {
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:104:6: (lv_keys_5_0= RULE_STRING )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:105:7: lv_keys_5_0= RULE_STRING
            	    	    {

            	    	    							markLeaf();
            	    	    						
            	    	    lv_keys_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel228); 

            	    	    							doneLeaf(lv_keys_5_0, elementTypeProvider.getModel_KeysSTRINGTerminalRuleCall_2_1_0_0ElementType());
            	    	    						

            	    	    }


            	    	    }

            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:114:5: ( (lv_values_6_0= RULE_STRING ) )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:115:6: (lv_values_6_0= RULE_STRING )
            	    	    {
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:115:6: (lv_values_6_0= RULE_STRING )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:116:7: lv_values_6_0= RULE_STRING
            	    	    {

            	    	    							markLeaf();
            	    	    						
            	    	    lv_values_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel280); 

            	    	    							doneLeaf(lv_values_6_0, elementTypeProvider.getModel_ValuesSTRINGTerminalRuleCall_2_1_1_0ElementType());
            	    	    						

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);


            	    				markLeaf();
            	    			
            	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel319); 

            	    				doneLeaf(otherlv_7, elementTypeProvider.getModel_RightSquareBracketKeyword_2_2ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:134:3: (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:135:4: otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) )
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel345); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getModel_SubModelKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:142:4: ( (lv_subModel_9_0= ruleSubModel ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:143:5: (lv_subModel_9_0= ruleSubModel )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:143:5: (lv_subModel_9_0= ruleSubModel )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:144:6: lv_subModel_9_0= ruleSubModel
                    {

                    						markComposite(elementTypeProvider.getModel_SubModelSubModelParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleSubModel_in_ruleModel377);
                    ruleSubModel();

                    state._fsp--;


                    						doneComposite();
                    					

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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSubModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:158:1: entryRuleSubModel : ruleSubModel EOF ;
    public final void entryRuleSubModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:158:18: ( ruleSubModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:159:2: ruleSubModel EOF
            {
             markComposite(elementTypeProvider.getSubModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubModel_in_entryRuleSubModel416);
            ruleSubModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubModel422); 

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
    // $ANTLR end "entryRuleSubModel"


    // $ANTLR start "ruleSubModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:165:1: ruleSubModel : ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* ) ;
    public final void ruleSubModel() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_strings_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:165:13: ( ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:166:2: ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:166:2: ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:167:3: () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:167:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:168:4: 
            {

            				precedeComposite(elementTypeProvider.getSubModel_SubModelAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:173:3: (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:174:4: otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )?
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSubModel460); 

            	    				doneLeaf(otherlv_1, elementTypeProvider.getSubModel_DigitOneKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSubModel477); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getSubModel_DigitTwoKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:188:4: ( (lv_strings_3_0= RULE_STRING ) )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==RULE_STRING) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:189:5: (lv_strings_3_0= RULE_STRING )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:189:5: (lv_strings_3_0= RULE_STRING )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalBug299395TestLanguage.g:190:6: lv_strings_3_0= RULE_STRING
            	            {

            	            						markLeaf();
            	            					
            	            lv_strings_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSubModel509); 

            	            						doneLeaf(lv_strings_3_0, elementTypeProvider.getSubModel_StringsSTRINGTerminalRuleCall_1_2_0ElementType());
            	            					

            	            }


            	            }
            	            break;

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
    // $ANTLR end "ruleSubModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel98 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel130 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel161 = new BitSet(new long[]{0x000000000000A802L});
        public static final BitSet FOLLOW_13_in_ruleModel187 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel228 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel280 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleModel319 = new BitSet(new long[]{0x000000000000A002L});
        public static final BitSet FOLLOW_15_in_ruleModel345 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleSubModel_in_ruleModel377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubModel_in_entryRuleSubModel416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubModel422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSubModel460 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSubModel477 = new BitSet(new long[]{0x0000000000010012L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSubModel509 = new BitSet(new long[]{0x0000000000010002L});
    }


}