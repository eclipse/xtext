package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug381381TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug381381TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'FIELD-NAME-TO-VARIABLE'", "','", "'SCREEN'", "'='", "'('", "')'", "'VAR'", "'TYPE'", "'REPLACE'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=5;
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
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug381381TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug381381TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug381381TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g"; }



     	private Bug381381TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug381381TestLanguageParser(TokenStream input, Bug381381TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug381381TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_stmt_0_0= ruleCopyFieldNameToVariableStmt ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_stmt_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:79:28: ( ( (lv_stmt_0_0= ruleCopyFieldNameToVariableStmt ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:80:1: ( (lv_stmt_0_0= ruleCopyFieldNameToVariableStmt ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:80:1: ( (lv_stmt_0_0= ruleCopyFieldNameToVariableStmt ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:81:1: (lv_stmt_0_0= ruleCopyFieldNameToVariableStmt )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:81:1: (lv_stmt_0_0= ruleCopyFieldNameToVariableStmt )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:82:3: lv_stmt_0_0= ruleCopyFieldNameToVariableStmt
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getStmtCopyFieldNameToVariableStmtParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleCopyFieldNameToVariableStmt_in_ruleModel130);
            lv_stmt_0_0=ruleCopyFieldNameToVariableStmt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"stmt",
                    		lv_stmt_0_0, 
                    		"CopyFieldNameToVariableStmt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCopyFieldNameToVariableStmt"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:106:1: entryRuleCopyFieldNameToVariableStmt returns [EObject current=null] : iv_ruleCopyFieldNameToVariableStmt= ruleCopyFieldNameToVariableStmt EOF ;
    public final EObject entryRuleCopyFieldNameToVariableStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCopyFieldNameToVariableStmt = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:107:2: (iv_ruleCopyFieldNameToVariableStmt= ruleCopyFieldNameToVariableStmt EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:108:2: iv_ruleCopyFieldNameToVariableStmt= ruleCopyFieldNameToVariableStmt EOF
            {
             newCompositeNode(grammarAccess.getCopyFieldNameToVariableStmtRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCopyFieldNameToVariableStmt_in_entryRuleCopyFieldNameToVariableStmt165);
            iv_ruleCopyFieldNameToVariableStmt=ruleCopyFieldNameToVariableStmt();

            state._fsp--;

             current =iv_ruleCopyFieldNameToVariableStmt; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCopyFieldNameToVariableStmt175); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCopyFieldNameToVariableStmt"


    // $ANTLR start "ruleCopyFieldNameToVariableStmt"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:115:1: ruleCopyFieldNameToVariableStmt returns [EObject current=null] : (otherlv_0= 'FIELD-NAME-TO-VARIABLE' ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleCopyFieldNameToVariableStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_line_6_0=null;
        Token otherlv_7=null;
        Token lv_column_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token lv_name_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:118:28: ( (otherlv_0= 'FIELD-NAME-TO-VARIABLE' ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:119:1: (otherlv_0= 'FIELD-NAME-TO-VARIABLE' ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:119:1: (otherlv_0= 'FIELD-NAME-TO-VARIABLE' ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:119:3: otherlv_0= 'FIELD-NAME-TO-VARIABLE' ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleCopyFieldNameToVariableStmt212); 

                	newLeafNode(otherlv_0, grammarAccess.getCopyFieldNameToVariableStmtAccess().getFIELDNAMETOVARIABLEKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:123:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:125:1: ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:125:1: ( ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:126:2: ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:129:2: ( ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:130:3: ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:130:3: ( ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=4;
                int LA1_0 = input.LA(1);

                if ( LA1_0 ==12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                    int LA1_2 = input.LA(2);

                    if ( LA1_2 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
                        alt1=3;
                    }
                    else if ( LA1_2 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
                        alt1=2;
                    }
                    else if ( LA1_2 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:132:4: ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:132:4: ({...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:133:5: {...}? => ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleCopyFieldNameToVariableStmt", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:133:124: ( ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:134:6: ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:137:6: ({...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:137:7: {...}? => (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCopyFieldNameToVariableStmt", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:137:16: (otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:137:18: otherlv_2= ',' otherlv_3= 'SCREEN' otherlv_4= '=' otherlv_5= '(' ( (lv_line_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_column_8_0= RULE_INT ) ) otherlv_9= ')'
            	    {
            	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCopyFieldNameToVariableStmt270); 

            	        	newLeafNode(otherlv_2, grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_0());
            	        
            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCopyFieldNameToVariableStmt282); 

            	        	newLeafNode(otherlv_3, grammarAccess.getCopyFieldNameToVariableStmtAccess().getSCREENKeyword_1_0_1());
            	        
            	    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCopyFieldNameToVariableStmt294); 

            	        	newLeafNode(otherlv_4, grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_0_2());
            	        
            	    otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleCopyFieldNameToVariableStmt306); 

            	        	newLeafNode(otherlv_5, grammarAccess.getCopyFieldNameToVariableStmtAccess().getLeftParenthesisKeyword_1_0_3());
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:153:1: ( (lv_line_6_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:154:1: (lv_line_6_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:154:1: (lv_line_6_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:155:3: lv_line_6_0= RULE_INT
            	    {
            	    lv_line_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCopyFieldNameToVariableStmt323); 

            	    			newLeafNode(lv_line_6_0, grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineINTTerminalRuleCall_1_0_4_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCopyFieldNameToVariableStmtRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"line",
            	            		lv_line_6_0, 
            	            		"INT");
            	    	    

            	    }


            	    }

            	    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCopyFieldNameToVariableStmt340); 

            	        	newLeafNode(otherlv_7, grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_5());
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:175:1: ( (lv_column_8_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:176:1: (lv_column_8_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:176:1: (lv_column_8_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:177:3: lv_column_8_0= RULE_INT
            	    {
            	    lv_column_8_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCopyFieldNameToVariableStmt357); 

            	    			newLeafNode(lv_column_8_0, grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnINTTerminalRuleCall_1_0_6_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCopyFieldNameToVariableStmtRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"column",
            	            		lv_column_8_0, 
            	            		"INT");
            	    	    

            	    }


            	    }

            	    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleCopyFieldNameToVariableStmt374); 

            	        	newLeafNode(otherlv_9, grammarAccess.getCopyFieldNameToVariableStmtAccess().getRightParenthesisKeyword_1_0_7());
            	        

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:204:4: ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:204:4: ({...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:205:5: {...}? => ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleCopyFieldNameToVariableStmt", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:205:124: ( ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:206:6: ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:209:6: ({...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:209:7: {...}? => (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCopyFieldNameToVariableStmt", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:209:16: (otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:209:18: otherlv_10= ',' otherlv_11= 'VAR' otherlv_12= '=' ( (lv_name_13_0= RULE_ID ) )
            	    {
            	    otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCopyFieldNameToVariableStmt442); 

            	        	newLeafNode(otherlv_10, grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_1_0());
            	        
            	    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleCopyFieldNameToVariableStmt454); 

            	        	newLeafNode(otherlv_11, grammarAccess.getCopyFieldNameToVariableStmtAccess().getVARKeyword_1_1_1());
            	        
            	    otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCopyFieldNameToVariableStmt466); 

            	        	newLeafNode(otherlv_12, grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_1_2());
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:221:1: ( (lv_name_13_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:222:1: (lv_name_13_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:222:1: (lv_name_13_0= RULE_ID )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:223:3: lv_name_13_0= RULE_ID
            	    {
            	    lv_name_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCopyFieldNameToVariableStmt483); 

            	    			newLeafNode(lv_name_13_0, grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameIDTerminalRuleCall_1_1_3_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCopyFieldNameToVariableStmtRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"name",
            	            		lv_name_13_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:246:4: ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:246:4: ({...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:247:5: {...}? => ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleCopyFieldNameToVariableStmt", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:247:124: ( ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:248:6: ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:251:6: ({...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:251:7: {...}? => (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCopyFieldNameToVariableStmt", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:251:16: (otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug381381TestLanguage.g:251:18: otherlv_14= ',' otherlv_15= 'TYPE' otherlv_16= '=' otherlv_17= 'REPLACE'
            	    {
            	    otherlv_14=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCopyFieldNameToVariableStmt556); 

            	        	newLeafNode(otherlv_14, grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_2_0());
            	        
            	    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCopyFieldNameToVariableStmt568); 

            	        	newLeafNode(otherlv_15, grammarAccess.getCopyFieldNameToVariableStmtAccess().getTYPEKeyword_1_2_1());
            	        
            	    otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCopyFieldNameToVariableStmt580); 

            	        	newLeafNode(otherlv_16, grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_2_2());
            	        
            	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCopyFieldNameToVariableStmt592); 

            	        	newLeafNode(otherlv_17, grammarAccess.getCopyFieldNameToVariableStmtAccess().getREPLACEKeyword_1_2_3());
            	        

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleCopyFieldNameToVariableStmt", "getUnorderedGroupHelper().canLeave(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCopyFieldNameToVariableStmt"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCopyFieldNameToVariableStmt_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCopyFieldNameToVariableStmt_in_entryRuleCopyFieldNameToVariableStmt165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCopyFieldNameToVariableStmt175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleCopyFieldNameToVariableStmt212 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCopyFieldNameToVariableStmt270 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCopyFieldNameToVariableStmt282 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCopyFieldNameToVariableStmt294 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleCopyFieldNameToVariableStmt306 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCopyFieldNameToVariableStmt323 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCopyFieldNameToVariableStmt340 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCopyFieldNameToVariableStmt357 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleCopyFieldNameToVariableStmt374 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleCopyFieldNameToVariableStmt442 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleCopyFieldNameToVariableStmt454 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCopyFieldNameToVariableStmt466 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCopyFieldNameToVariableStmt483 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleCopyFieldNameToVariableStmt556 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleCopyFieldNameToVariableStmt568 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCopyFieldNameToVariableStmt580 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleCopyFieldNameToVariableStmt592 = new BitSet(new long[]{0x0000000000001002L});
    }


}