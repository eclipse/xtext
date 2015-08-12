package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.assignments.services.Bug288432TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug288432TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "','", "')'", "'body'", "'end body'", "'content'", "'end content'", "'element'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
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


        public InternalBug288432TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug288432TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug288432TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g"; }



     	private Bug288432TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug288432TestLanguageParser(TokenStream input, Bug288432TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Body";	
       	}
       	
       	@Override
       	protected Bug288432TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleBody"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:67:1: entryRuleBody returns [EObject current=null] : iv_ruleBody= ruleBody EOF ;
    public final EObject entryRuleBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBody = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:68:2: (iv_ruleBody= ruleBody EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:69:2: iv_ruleBody= ruleBody EOF
            {
             newCompositeNode(grammarAccess.getBodyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBody_in_entryRuleBody75);
            iv_ruleBody=ruleBody();

            state._fsp--;

             current =iv_ruleBody; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBody85); 

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
    // $ANTLR end "entryRuleBody"


    // $ANTLR start "ruleBody"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:76:1: ruleBody returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) ;
    public final EObject ruleBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_parameter_1_0 = null;

        EObject lv_parameter_3_0 = null;

        EObject lv_content_6_1 = null;

        EObject lv_content_6_2 = null;

        EObject lv_foo_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:79:28: ( ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:80:1: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:80:1: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:80:2: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:80:2: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:80:4: otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBody123); 

                        	newLeafNode(otherlv_0, grammarAccess.getBodyAccess().getLeftParenthesisKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:84:1: ( (lv_parameter_1_0= ruleParameter ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:85:1: (lv_parameter_1_0= ruleParameter )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:85:1: (lv_parameter_1_0= ruleParameter )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:3: lv_parameter_1_0= ruleParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getBodyAccess().getParameterParameterParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody144);
                    lv_parameter_1_0=ruleParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBodyRule());
                    	        }
                           		add(
                           			current, 
                           			"parameter",
                            		lv_parameter_1_0, 
                            		"org.eclipse.xtext.parser.assignments.Bug288432TestLanguage.Parameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:102:2: (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:102:4: otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleBody157); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getBodyAccess().getCommaKeyword_0_2_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:106:1: ( (lv_parameter_3_0= ruleParameter ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:107:1: (lv_parameter_3_0= ruleParameter )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:107:1: (lv_parameter_3_0= ruleParameter )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:108:3: lv_parameter_3_0= ruleParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getBodyAccess().getParameterParameterParserRuleCall_0_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody178);
                    	    lv_parameter_3_0=ruleParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getBodyRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameter",
                    	            		lv_parameter_3_0, 
                    	            		"org.eclipse.xtext.parser.assignments.Bug288432TestLanguage.Parameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBody192); 

                        	newLeafNode(otherlv_4, grammarAccess.getBodyAccess().getRightParenthesisKeyword_0_3());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBody206); 

                	newLeafNode(otherlv_5, grammarAccess.getBodyAccess().getBodyKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:132:1: ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:133:1: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:133:1: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:134:1: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:134:1: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:135:3: lv_content_6_1= ruleContent
                    {
                     
                    	        newCompositeNode(grammarAccess.getBodyAccess().getContentContentParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleBody229);
                    lv_content_6_1=ruleContent();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBodyRule());
                    	        }
                           		set(
                           			current, 
                           			"content",
                            		lv_content_6_1, 
                            		"org.eclipse.xtext.parser.assignments.Bug288432TestLanguage.Content");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:150:8: lv_content_6_2= ruleParameterRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getBodyAccess().getContentParameterRefParserRuleCall_2_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleBody248);
                    lv_content_6_2=ruleParameterRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBodyRule());
                    	        }
                           		set(
                           			current, 
                           			"content",
                            		lv_content_6_2, 
                            		"org.eclipse.xtext.parser.assignments.Bug288432TestLanguage.ParameterRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:168:2: ( (lv_foo_7_0= ruleFoo ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_STRING) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:169:1: (lv_foo_7_0= ruleFoo )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:169:1: (lv_foo_7_0= ruleFoo )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:170:3: lv_foo_7_0= ruleFoo
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBodyAccess().getFooFooParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFoo_in_ruleBody272);
            	    lv_foo_7_0=ruleFoo();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"foo",
            	            		lv_foo_7_0, 
            	            		"org.eclipse.xtext.parser.assignments.Bug288432TestLanguage.Foo");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleBody285); 

                	newLeafNode(otherlv_8, grammarAccess.getBodyAccess().getEndBodyKeyword_4());
                

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
    // $ANTLR end "ruleBody"


    // $ANTLR start "entryRuleFoo"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:198:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:199:2: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:200:2: iv_ruleFoo= ruleFoo EOF
            {
             newCompositeNode(grammarAccess.getFooRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo321);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo331); 

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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:207:1: ruleFoo returns [EObject current=null] : ( (lv_fooValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_fooValue_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:210:28: ( ( (lv_fooValue_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:211:1: ( (lv_fooValue_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:211:1: ( (lv_fooValue_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:212:1: (lv_fooValue_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:212:1: (lv_fooValue_0_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:213:3: lv_fooValue_0_0= RULE_STRING
            {
            lv_fooValue_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFoo372); 

            			newLeafNode(lv_fooValue_0_0, grammarAccess.getFooAccess().getFooValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFooRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fooValue",
                    		lv_fooValue_0_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleContent"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:237:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:238:2: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:239:2: iv_ruleContent= ruleContent EOF
            {
             newCompositeNode(grammarAccess.getContentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent412);
            iv_ruleContent=ruleContent();

            state._fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent422); 

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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:246:1: ruleContent returns [EObject current=null] : (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_MyElement_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:249:28: ( (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:250:1: (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:250:1: (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:250:3: otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleContent459); 

                	newLeafNode(otherlv_0, grammarAccess.getContentAccess().getContentKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getContentAccess().getMyElementParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_ruleContent481);
            this_MyElement_1=ruleMyElement();

            state._fsp--;

             
                    current = this_MyElement_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleContent492); 

                	newLeafNode(otherlv_2, grammarAccess.getContentAccess().getEndContentKeyword_2());
                

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
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleMyElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:275:1: entryRuleMyElement returns [EObject current=null] : iv_ruleMyElement= ruleMyElement EOF ;
    public final EObject entryRuleMyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:276:2: (iv_ruleMyElement= ruleMyElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:277:2: iv_ruleMyElement= ruleMyElement EOF
            {
             newCompositeNode(grammarAccess.getMyElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_entryRuleMyElement528);
            iv_ruleMyElement=ruleMyElement();

            state._fsp--;

             current =iv_ruleMyElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyElement538); 

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
    // $ANTLR end "entryRuleMyElement"


    // $ANTLR start "ruleMyElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:284:1: ruleMyElement returns [EObject current=null] : (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) ;
    public final EObject ruleMyElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_bar_1_1 = null;

        EObject lv_bar_1_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:287:28: ( (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:288:1: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:288:1: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:288:3: otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMyElement575); 

                	newLeafNode(otherlv_0, grammarAccess.getMyElementAccess().getElementKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:292:1: ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:293:1: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:293:1: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:294:1: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:294:1: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:295:3: lv_bar_1_1= ruleMyInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getMyElementAccess().getBarMyIntParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_ruleMyElement598);
                    lv_bar_1_1=ruleMyInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMyElementRule());
                    	        }
                           		set(
                           			current, 
                           			"bar",
                            		lv_bar_1_1, 
                            		"org.eclipse.xtext.parser.assignments.Bug288432TestLanguage.MyInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:310:8: lv_bar_1_2= ruleParameterRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getMyElementAccess().getBarParameterRefParserRuleCall_1_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleMyElement617);
                    lv_bar_1_2=ruleParameterRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMyElementRule());
                    	        }
                           		set(
                           			current, 
                           			"bar",
                            		lv_bar_1_2, 
                            		"org.eclipse.xtext.parser.assignments.Bug288432TestLanguage.ParameterRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleMyElement"


    // $ANTLR start "entryRuleParameter"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:338:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:339:2: (iv_ruleParameter= ruleParameter EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:340:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter658);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter668); 

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:347:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:350:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:351:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:351:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:351:2: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:351:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:352:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:352:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:353:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter710); 

            			newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:369:2: ( (otherlv_1= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:370:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:370:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:371:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getParameterRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter735); 

                    		newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getValueParameterObjectCrossReference_1_0()); 
                    	

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:390:1: entryRuleParameterRef returns [EObject current=null] : iv_ruleParameterRef= ruleParameterRef EOF ;
    public final EObject entryRuleParameterRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:391:2: (iv_ruleParameterRef= ruleParameterRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:392:2: iv_ruleParameterRef= ruleParameterRef EOF
            {
             newCompositeNode(grammarAccess.getParameterRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_entryRuleParameterRef772);
            iv_ruleParameterRef=ruleParameterRef();

            state._fsp--;

             current =iv_ruleParameterRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterRef782); 

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
    // $ANTLR end "entryRuleParameterRef"


    // $ANTLR start "ruleParameterRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:399:1: ruleParameterRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleParameterRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:402:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:403:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:403:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:404:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:404:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:405:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterRefRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameterRef826); 

            		newLeafNode(otherlv_0, grammarAccess.getParameterRefAccess().getParameterParameterCrossReference_0()); 
            	

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
    // $ANTLR end "ruleParameterRef"


    // $ANTLR start "entryRuleMyInt"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:424:1: entryRuleMyInt returns [EObject current=null] : iv_ruleMyInt= ruleMyInt EOF ;
    public final EObject entryRuleMyInt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyInt = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:425:2: (iv_ruleMyInt= ruleMyInt EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:426:2: iv_ruleMyInt= ruleMyInt EOF
            {
             newCompositeNode(grammarAccess.getMyIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_entryRuleMyInt861);
            iv_ruleMyInt=ruleMyInt();

            state._fsp--;

             current =iv_ruleMyInt; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyInt871); 

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
    // $ANTLR end "entryRuleMyInt"


    // $ANTLR start "ruleMyInt"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:433:1: ruleMyInt returns [EObject current=null] : ( (lv_int_0_0= RULE_INT ) ) ;
    public final EObject ruleMyInt() throws RecognitionException {
        EObject current = null;

        Token lv_int_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:436:28: ( ( (lv_int_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:437:1: ( (lv_int_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:437:1: ( (lv_int_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:438:1: (lv_int_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:438:1: (lv_int_0_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:439:3: lv_int_0_0= RULE_INT
            {
            lv_int_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMyInt912); 

            			newLeafNode(lv_int_0_0, grammarAccess.getMyIntAccess().getIntINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMyIntRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"int",
                    		lv_int_0_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

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
    // $ANTLR end "ruleMyInt"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBody_in_entryRuleBody75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBody85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleBody123 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody144 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleBody157 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody178 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_13_in_ruleBody192 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleBody206 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_ruleContent_in_ruleBody229 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleBody248 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFoo_in_ruleBody272 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleBody285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFoo372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent412 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleContent459 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMyElement_in_ruleContent481 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleContent492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyElement_in_entryRuleMyElement528 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyElement538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMyElement575 = new BitSet(new long[]{0x0000000000010060L});
        public static final BitSet FOLLOW_ruleMyInt_in_ruleMyElement598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleMyElement617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter710 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_entryRuleParameterRef772 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterRef782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameterRef826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyInt_in_entryRuleMyInt861 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyInt871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMyInt912 = new BitSet(new long[]{0x0000000000000002L});
    }


}