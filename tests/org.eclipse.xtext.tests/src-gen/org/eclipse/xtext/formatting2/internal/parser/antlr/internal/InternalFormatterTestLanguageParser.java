package org.eclipse.xtext.formatting2.internal.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFormatterTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'idlist'", "'kwlist'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'kw5'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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


        public InternalFormatterTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFormatterTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFormatterTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g"; }



     	private FormatterTestLanguageGrammarAccess grammarAccess;
     	
        public InternalFormatterTestLanguageParser(TokenStream input, FormatterTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected FormatterTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:67:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:68:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:69:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot85); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:76:1: ruleRoot returns [EObject current=null] : (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_IDList_0 = null;

        EObject this_KWList_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:79:28: ( (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:80:1: (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:80:1: (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:81:5: this_IDList_0= ruleIDList
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getIDListParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIDList_in_ruleRoot132);
                    this_IDList_0=ruleIDList();

                    state._fsp--;

                     
                            current = this_IDList_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:91:5: this_KWList_1= ruleKWList
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getKWListParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKWList_in_ruleRoot159);
                    this_KWList_1=ruleKWList();

                    state._fsp--;

                     
                            current = this_KWList_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleIDList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:107:1: entryRuleIDList returns [EObject current=null] : iv_ruleIDList= ruleIDList EOF ;
    public final EObject entryRuleIDList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIDList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:108:2: (iv_ruleIDList= ruleIDList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:109:2: iv_ruleIDList= ruleIDList EOF
            {
             newCompositeNode(grammarAccess.getIDListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIDList_in_entryRuleIDList194);
            iv_ruleIDList=ruleIDList();

            state._fsp--;

             current =iv_ruleIDList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIDList204); 

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
    // $ANTLR end "entryRuleIDList"


    // $ANTLR start "ruleIDList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:116:1: ruleIDList returns [EObject current=null] : ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* ) ;
    public final EObject ruleIDList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_ids_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:119:28: ( ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:120:1: ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:120:1: ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:120:2: () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:120:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:121:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIDListAccess().getIDListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleIDList250); 

                	newLeafNode(otherlv_1, grammarAccess.getIDListAccess().getIdlistKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:130:1: ( (lv_ids_2_0= RULE_ID ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:131:1: (lv_ids_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:131:1: (lv_ids_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:132:3: lv_ids_2_0= RULE_ID
            	    {
            	    lv_ids_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIDList267); 

            	    			newLeafNode(lv_ids_2_0, grammarAccess.getIDListAccess().getIdsIDTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getIDListRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"ids",
            	            		lv_ids_2_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruleIDList"


    // $ANTLR start "entryRuleKWList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:156:1: entryRuleKWList returns [EObject current=null] : iv_ruleKWList= ruleKWList EOF ;
    public final EObject entryRuleKWList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKWList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:157:2: (iv_ruleKWList= ruleKWList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:158:2: iv_ruleKWList= ruleKWList EOF
            {
             newCompositeNode(grammarAccess.getKWListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKWList_in_entryRuleKWList309);
            iv_ruleKWList=ruleKWList();

            state._fsp--;

             current =iv_ruleKWList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKWList319); 

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
    // $ANTLR end "entryRuleKWList"


    // $ANTLR start "ruleKWList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:165:1: ruleKWList returns [EObject current=null] : ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? ) ;
    public final EObject ruleKWList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_kw1_2_0=null;
        Token lv_kw2_3_0=null;
        Token lv_kw3_4_0=null;
        Token lv_kw4_5_0=null;
        Token lv_kw5_6_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:168:28: ( ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:169:1: ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:169:1: ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:169:2: () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:169:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:170:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getKWListAccess().getKWListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleKWList365); 

                	newLeafNode(otherlv_1, grammarAccess.getKWListAccess().getKwlistKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:179:1: ( (lv_kw1_2_0= 'kw1' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:180:1: (lv_kw1_2_0= 'kw1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:180:1: (lv_kw1_2_0= 'kw1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:181:3: lv_kw1_2_0= 'kw1'
                    {
                    lv_kw1_2_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleKWList383); 

                            newLeafNode(lv_kw1_2_0, grammarAccess.getKWListAccess().getKw1Kw1Keyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKWListRule());
                    	        }
                           		setWithLastConsumed(current, "kw1", true, "kw1");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:194:3: ( (lv_kw2_3_0= 'kw2' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:195:1: (lv_kw2_3_0= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:195:1: (lv_kw2_3_0= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:196:3: lv_kw2_3_0= 'kw2'
                    {
                    lv_kw2_3_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleKWList415); 

                            newLeafNode(lv_kw2_3_0, grammarAccess.getKWListAccess().getKw2Kw2Keyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKWListRule());
                    	        }
                           		setWithLastConsumed(current, "kw2", true, "kw2");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:209:3: ( (lv_kw3_4_0= 'kw3' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:210:1: (lv_kw3_4_0= 'kw3' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:210:1: (lv_kw3_4_0= 'kw3' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:211:3: lv_kw3_4_0= 'kw3'
                    {
                    lv_kw3_4_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleKWList447); 

                            newLeafNode(lv_kw3_4_0, grammarAccess.getKWListAccess().getKw3Kw3Keyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKWListRule());
                    	        }
                           		setWithLastConsumed(current, "kw3", true, "kw3");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:224:3: ( (lv_kw4_5_0= 'kw4' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:225:1: (lv_kw4_5_0= 'kw4' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:225:1: (lv_kw4_5_0= 'kw4' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:226:3: lv_kw4_5_0= 'kw4'
                    {
                    lv_kw4_5_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleKWList479); 

                            newLeafNode(lv_kw4_5_0, grammarAccess.getKWListAccess().getKw4Kw4Keyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKWListRule());
                    	        }
                           		setWithLastConsumed(current, "kw4", true, "kw4");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:239:3: ( (lv_kw5_6_0= 'kw5' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:240:1: (lv_kw5_6_0= 'kw5' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:240:1: (lv_kw5_6_0= 'kw5' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/internal/parser/antlr/internal/InternalFormatterTestLanguage.g:241:3: lv_kw5_6_0= 'kw5'
                    {
                    lv_kw5_6_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleKWList511); 

                            newLeafNode(lv_kw5_6_0, grammarAccess.getKWListAccess().getKw5Kw5Keyword_6_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKWListRule());
                    	        }
                           		setWithLastConsumed(current, "kw5", true, "kw5");
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end "ruleKWList"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIDList_in_ruleRoot132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKWList_in_ruleRoot159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIDList_in_entryRuleIDList194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIDList204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleIDList250 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIDList267 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleKWList_in_entryRuleKWList309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKWList319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleKWList365 = new BitSet(new long[]{0x000000000003E002L});
        public static final BitSet FOLLOW_13_in_ruleKWList383 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_14_in_ruleKWList415 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_15_in_ruleKWList447 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_16_in_ruleKWList479 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleKWList511 = new BitSet(new long[]{0x0000000000000002L});
    }


}