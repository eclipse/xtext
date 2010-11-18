package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__18=18;
    public static final int T__15=15;

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
     	
        public InternalBug288432TestLanguageParser(TokenStream input, IAstFactory factory, Bug288432TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:71:1: entryRuleBody returns [EObject current=null] : iv_ruleBody= ruleBody EOF ;
    public final EObject entryRuleBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBody = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:72:2: (iv_ruleBody= ruleBody EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:73:2: iv_ruleBody= ruleBody EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBodyRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:80:1: ruleBody returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:85:6: ( ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:1: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:1: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:2: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:2: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:4: otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBody123); 

                        	createLeafNode(otherlv_0, grammarAccess.getBodyAccess().getLeftParenthesisKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:90:1: ( (lv_parameter_1_0= ruleParameter ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:91:1: (lv_parameter_1_0= ruleParameter )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:91:1: (lv_parameter_1_0= ruleParameter )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:92:3: lv_parameter_1_0= ruleParameter
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getParameterParameterParserRuleCall_0_1_0(), currentNode); 
                    	    
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
                            		"Parameter", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:109:2: (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:109:4: otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleBody157); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getBodyAccess().getCommaKeyword_0_2_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:113:1: ( (lv_parameter_3_0= ruleParameter ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:114:1: (lv_parameter_3_0= ruleParameter )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:114:1: (lv_parameter_3_0= ruleParameter )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:115:3: lv_parameter_3_0= ruleParameter
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getParameterParameterParserRuleCall_0_2_1_0(), currentNode); 
                    	    	    
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
                    	            		"Parameter", 
                    	            		currentNode);
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

                        	createLeafNode(otherlv_4, grammarAccess.getBodyAccess().getRightParenthesisKeyword_0_3(), null);
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBody206); 

                	createLeafNode(otherlv_5, grammarAccess.getBodyAccess().getBodyKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:140:1: ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:141:1: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:141:1: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:142:1: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:142:1: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:143:3: lv_content_6_1= ruleContent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getContentContentParserRuleCall_2_0_0(), currentNode); 
                    	    
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
                            		"Content", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:159:8: lv_content_6_2= ruleParameterRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getContentParameterRefParserRuleCall_2_0_1(), currentNode); 
                    	    
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
                            		"ParameterRef", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:178:2: ( (lv_foo_7_0= ruleFoo ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:179:1: (lv_foo_7_0= ruleFoo )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:179:1: (lv_foo_7_0= ruleFoo )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:180:3: lv_foo_7_0= ruleFoo
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getFooFooParserRuleCall_3_0(), currentNode); 
            	    	    
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
            	            		"Foo", 
            	            		currentNode);
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

                	createLeafNode(otherlv_8, grammarAccess.getBodyAccess().getEndBodyKeyword_4(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:209:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:210:2: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:211:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFooRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:218:1: ruleFoo returns [EObject current=null] : ( (lv_fooValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_fooValue_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:223:6: ( ( (lv_fooValue_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:224:1: ( (lv_fooValue_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:224:1: ( (lv_fooValue_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:225:1: (lv_fooValue_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:225:1: (lv_fooValue_0_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:226:3: lv_fooValue_0_0= RULE_STRING
            {
            lv_fooValue_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFoo372); 

            			createLeafNode(lv_fooValue_0_0, grammarAccess.getFooAccess().getFooValueSTRINGTerminalRuleCall_0(), "fooValue"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFooRule());
            	        }
                   		set(
                   			current, 
                   			"fooValue",
                    		lv_fooValue_0_0, 
                    		"STRING", 
                    		lastConsumedNode);
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:251:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:252:2: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:253:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContentRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:260:1: ruleContent returns [EObject current=null] : (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_MyElement_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:265:6: ( (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:266:1: (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:266:1: (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:266:3: otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleContent459); 

                	createLeafNode(otherlv_0, grammarAccess.getContentAccess().getContentKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getContentAccess().getMyElementParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_ruleContent481);
            this_MyElement_1=ruleMyElement();

            state._fsp--;

             
                    current = this_MyElement_1; 
                    // currentNode = currentNode.getParent();
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleContent492); 

                	createLeafNode(otherlv_2, grammarAccess.getContentAccess().getEndContentKeyword_2(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:292:1: entryRuleMyElement returns [EObject current=null] : iv_ruleMyElement= ruleMyElement EOF ;
    public final EObject entryRuleMyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:293:2: (iv_ruleMyElement= ruleMyElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:294:2: iv_ruleMyElement= ruleMyElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMyElementRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:301:1: ruleMyElement returns [EObject current=null] : (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) ;
    public final EObject ruleMyElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_bar_1_1 = null;

        EObject lv_bar_1_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:306:6: ( (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:307:1: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:307:1: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:307:3: otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMyElement575); 

                	createLeafNode(otherlv_0, grammarAccess.getMyElementAccess().getElementKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:311:1: ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:312:1: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:312:1: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:313:1: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:313:1: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:314:3: lv_bar_1_1= ruleMyInt
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMyElementAccess().getBarMyIntParserRuleCall_1_0_0(), currentNode); 
                    	    
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
                            		"MyInt", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:330:8: lv_bar_1_2= ruleParameterRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMyElementAccess().getBarParameterRefParserRuleCall_1_0_1(), currentNode); 
                    	    
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
                            		"ParameterRef", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:359:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:360:2: (iv_ruleParameter= ruleParameter EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:361:2: iv_ruleParameter= ruleParameter EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:368:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:373:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:374:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:374:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:374:2: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:374:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:375:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:375:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:376:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter710); 

            			createLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:393:2: ( (otherlv_1= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:394:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:394:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:395:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getParameterRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter735); 

                    		createLeafNode(otherlv_1, grammarAccess.getParameterAccess().getValueParameterObjectCrossReference_1_0(), "value"); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:414:1: entryRuleParameterRef returns [EObject current=null] : iv_ruleParameterRef= ruleParameterRef EOF ;
    public final EObject entryRuleParameterRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:415:2: (iv_ruleParameterRef= ruleParameterRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:416:2: iv_ruleParameterRef= ruleParameterRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterRefRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:423:1: ruleParameterRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleParameterRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:428:6: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:429:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:429:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:430:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:430:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:431:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterRefRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameterRef826); 

            		createLeafNode(otherlv_0, grammarAccess.getParameterRefAccess().getParameterParameterCrossReference_0(), "parameter"); 
            	

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:450:1: entryRuleMyInt returns [EObject current=null] : iv_ruleMyInt= ruleMyInt EOF ;
    public final EObject entryRuleMyInt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyInt = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:451:2: (iv_ruleMyInt= ruleMyInt EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:452:2: iv_ruleMyInt= ruleMyInt EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMyIntRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:459:1: ruleMyInt returns [EObject current=null] : ( (lv_int_0_0= RULE_INT ) ) ;
    public final EObject ruleMyInt() throws RecognitionException {
        EObject current = null;

        Token lv_int_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:464:6: ( ( (lv_int_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:465:1: ( (lv_int_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:465:1: ( (lv_int_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:466:1: (lv_int_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:466:1: (lv_int_0_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:467:3: lv_int_0_0= RULE_INT
            {
            lv_int_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMyInt912); 

            			createLeafNode(lv_int_0_0, grammarAccess.getMyIntAccess().getIntINTTerminalRuleCall_0(), "int"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMyIntRule());
            	        }
                   		set(
                   			current, 
                   			"int",
                    		lv_int_0_0, 
                    		"INT", 
                    		lastConsumedNode);
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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