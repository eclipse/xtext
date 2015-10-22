package org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.assignments.services.Bug288432TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug288432TestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalBug288432TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug288432TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug288432TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug288432TestLanguage.g"; }



    	protected Bug288432TestLanguageGrammarAccess grammarAccess;

    	protected Bug288432TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug288432TestLanguageParser(PsiBuilder builder, TokenStream input, Bug288432TestLanguageElementTypeProvider elementTypeProvider, Bug288432TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Body";
    	}




    // $ANTLR start "entryRuleBody"
    // PsiInternalBug288432TestLanguage.g:52:1: entryRuleBody returns [Boolean current=false] : iv_ruleBody= ruleBody EOF ;
    public final Boolean entryRuleBody() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBody = null;


        try {
            // PsiInternalBug288432TestLanguage.g:52:46: (iv_ruleBody= ruleBody EOF )
            // PsiInternalBug288432TestLanguage.g:53:2: iv_ruleBody= ruleBody EOF
            {
             markComposite(elementTypeProvider.getBodyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBody=ruleBody();

            state._fsp--;

             current =iv_ruleBody; 
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
    // $ANTLR end "entryRuleBody"


    // $ANTLR start "ruleBody"
    // PsiInternalBug288432TestLanguage.g:59:1: ruleBody returns [Boolean current=false] : ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) ;
    public final Boolean ruleBody() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Boolean lv_parameter_1_0 = null;

        Boolean lv_parameter_3_0 = null;

        Boolean lv_content_6_1 = null;

        Boolean lv_content_6_2 = null;

        Boolean lv_foo_7_0 = null;


        try {
            // PsiInternalBug288432TestLanguage.g:60:1: ( ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) )
            // PsiInternalBug288432TestLanguage.g:61:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            {
            // PsiInternalBug288432TestLanguage.g:61:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            // PsiInternalBug288432TestLanguage.g:62:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body'
            {
            // PsiInternalBug288432TestLanguage.g:62:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug288432TestLanguage.g:63:4: otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')'
                    {

                    				markLeaf(elementTypeProvider.getBody_LeftParenthesisKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug288432TestLanguage.g:70:4: ( (lv_parameter_1_0= ruleParameter ) )
                    // PsiInternalBug288432TestLanguage.g:71:5: (lv_parameter_1_0= ruleParameter )
                    {
                    // PsiInternalBug288432TestLanguage.g:71:5: (lv_parameter_1_0= ruleParameter )
                    // PsiInternalBug288432TestLanguage.g:72:6: lv_parameter_1_0= ruleParameter
                    {

                    						markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_parameter_1_0=ruleParameter();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalBug288432TestLanguage.g:85:4: (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalBug288432TestLanguage.g:86:5: otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getBody_CommaKeyword_0_2_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalBug288432TestLanguage.g:93:5: ( (lv_parameter_3_0= ruleParameter ) )
                    	    // PsiInternalBug288432TestLanguage.g:94:6: (lv_parameter_3_0= ruleParameter )
                    	    {
                    	    // PsiInternalBug288432TestLanguage.g:94:6: (lv_parameter_3_0= ruleParameter )
                    	    // PsiInternalBug288432TestLanguage.g:95:7: lv_parameter_3_0= ruleParameter
                    	    {

                    	    							markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_parameter_3_0=ruleParameter();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    				markLeaf(elementTypeProvider.getBody_RightParenthesisKeyword_0_3ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_4);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getBody_BodyKeyword_1ElementType());
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalBug288432TestLanguage.g:124:3: ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) )
            // PsiInternalBug288432TestLanguage.g:125:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            {
            // PsiInternalBug288432TestLanguage.g:125:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            // PsiInternalBug288432TestLanguage.g:126:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            {
            // PsiInternalBug288432TestLanguage.g:126:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
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
                    // PsiInternalBug288432TestLanguage.g:127:6: lv_content_6_1= ruleContent
                    {

                    						markComposite(elementTypeProvider.getBody_ContentContentParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_content_6_1=ruleContent();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalBug288432TestLanguage.g:139:6: lv_content_6_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getBody_ContentParameterRefParserRuleCall_2_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_content_6_2=ruleParameterRef();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalBug288432TestLanguage.g:153:3: ( (lv_foo_7_0= ruleFoo ) )+
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
            	    // PsiInternalBug288432TestLanguage.g:154:4: (lv_foo_7_0= ruleFoo )
            	    {
            	    // PsiInternalBug288432TestLanguage.g:154:4: (lv_foo_7_0= ruleFoo )
            	    // PsiInternalBug288432TestLanguage.g:155:5: lv_foo_7_0= ruleFoo
            	    {

            	    					markComposite(elementTypeProvider.getBody_FooFooParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_foo_7_0=ruleFoo();

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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            			markLeaf(elementTypeProvider.getBody_EndBodyKeyword_4ElementType());
            		
            otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_8);
            		

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
    // $ANTLR end "ruleBody"


    // $ANTLR start "entryRuleFoo"
    // PsiInternalBug288432TestLanguage.g:179:1: entryRuleFoo returns [Boolean current=false] : iv_ruleFoo= ruleFoo EOF ;
    public final Boolean entryRuleFoo() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFoo = null;


        try {
            // PsiInternalBug288432TestLanguage.g:179:45: (iv_ruleFoo= ruleFoo EOF )
            // PsiInternalBug288432TestLanguage.g:180:2: iv_ruleFoo= ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // PsiInternalBug288432TestLanguage.g:186:1: ruleFoo returns [Boolean current=false] : ( (lv_fooValue_0_0= RULE_STRING ) ) ;
    public final Boolean ruleFoo() throws RecognitionException {
        Boolean current = false;

        Token lv_fooValue_0_0=null;

        try {
            // PsiInternalBug288432TestLanguage.g:187:1: ( ( (lv_fooValue_0_0= RULE_STRING ) ) )
            // PsiInternalBug288432TestLanguage.g:188:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            {
            // PsiInternalBug288432TestLanguage.g:188:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            // PsiInternalBug288432TestLanguage.g:189:3: (lv_fooValue_0_0= RULE_STRING )
            {
            // PsiInternalBug288432TestLanguage.g:189:3: (lv_fooValue_0_0= RULE_STRING )
            // PsiInternalBug288432TestLanguage.g:190:4: lv_fooValue_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getFoo_FooValueSTRINGTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
            lv_fooValue_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_fooValue_0_0);
            			

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
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleContent"
    // PsiInternalBug288432TestLanguage.g:208:1: entryRuleContent returns [Boolean current=false] : iv_ruleContent= ruleContent EOF ;
    public final Boolean entryRuleContent() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleContent = null;


        try {
            // PsiInternalBug288432TestLanguage.g:208:49: (iv_ruleContent= ruleContent EOF )
            // PsiInternalBug288432TestLanguage.g:209:2: iv_ruleContent= ruleContent EOF
            {
             markComposite(elementTypeProvider.getContentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContent=ruleContent();

            state._fsp--;

             current =iv_ruleContent; 
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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // PsiInternalBug288432TestLanguage.g:215:1: ruleContent returns [Boolean current=false] : (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' ) ;
    public final Boolean ruleContent() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_MyElement_1 = null;


        try {
            // PsiInternalBug288432TestLanguage.g:216:1: ( (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' ) )
            // PsiInternalBug288432TestLanguage.g:217:2: (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' )
            {
            // PsiInternalBug288432TestLanguage.g:217:2: (otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content' )
            // PsiInternalBug288432TestLanguage.g:218:3: otherlv_0= 'content' this_MyElement_1= ruleMyElement otherlv_2= 'end content'
            {

            			markLeaf(elementTypeProvider.getContent_ContentKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getContent_MyElementParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_10);
            this_MyElement_1=ruleMyElement();

            state._fsp--;


            			current = this_MyElement_1;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getContent_EndContentKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleMyElement"
    // PsiInternalBug288432TestLanguage.g:244:1: entryRuleMyElement returns [Boolean current=false] : iv_ruleMyElement= ruleMyElement EOF ;
    public final Boolean entryRuleMyElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMyElement = null;


        try {
            // PsiInternalBug288432TestLanguage.g:244:51: (iv_ruleMyElement= ruleMyElement EOF )
            // PsiInternalBug288432TestLanguage.g:245:2: iv_ruleMyElement= ruleMyElement EOF
            {
             markComposite(elementTypeProvider.getMyElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMyElement=ruleMyElement();

            state._fsp--;

             current =iv_ruleMyElement; 
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
    // $ANTLR end "entryRuleMyElement"


    // $ANTLR start "ruleMyElement"
    // PsiInternalBug288432TestLanguage.g:251:1: ruleMyElement returns [Boolean current=false] : (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) ;
    public final Boolean ruleMyElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_bar_1_1 = null;

        Boolean lv_bar_1_2 = null;


        try {
            // PsiInternalBug288432TestLanguage.g:252:1: ( (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) )
            // PsiInternalBug288432TestLanguage.g:253:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            {
            // PsiInternalBug288432TestLanguage.g:253:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            // PsiInternalBug288432TestLanguage.g:254:3: otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            {

            			markLeaf(elementTypeProvider.getMyElement_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug288432TestLanguage.g:261:3: ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            // PsiInternalBug288432TestLanguage.g:262:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            {
            // PsiInternalBug288432TestLanguage.g:262:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            // PsiInternalBug288432TestLanguage.g:263:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            {
            // PsiInternalBug288432TestLanguage.g:263:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
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
                    // PsiInternalBug288432TestLanguage.g:264:6: lv_bar_1_1= ruleMyInt
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarMyIntParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_bar_1_1=ruleMyInt();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalBug288432TestLanguage.g:276:6: lv_bar_1_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarParameterRefParserRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_bar_1_2=ruleParameterRef();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

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
    // $ANTLR end "ruleMyElement"


    // $ANTLR start "entryRuleParameter"
    // PsiInternalBug288432TestLanguage.g:294:1: entryRuleParameter returns [Boolean current=false] : iv_ruleParameter= ruleParameter EOF ;
    public final Boolean entryRuleParameter() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameter = null;


        try {
            // PsiInternalBug288432TestLanguage.g:294:51: (iv_ruleParameter= ruleParameter EOF )
            // PsiInternalBug288432TestLanguage.g:295:2: iv_ruleParameter= ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // PsiInternalBug288432TestLanguage.g:301:1: ruleParameter returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final Boolean ruleParameter() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalBug288432TestLanguage.g:302:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // PsiInternalBug288432TestLanguage.g:303:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // PsiInternalBug288432TestLanguage.g:303:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            // PsiInternalBug288432TestLanguage.g:304:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // PsiInternalBug288432TestLanguage.g:304:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug288432TestLanguage.g:305:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug288432TestLanguage.g:305:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug288432TestLanguage.g:306:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameter_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalBug288432TestLanguage.g:321:3: ( (otherlv_1= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalBug288432TestLanguage.g:322:4: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalBug288432TestLanguage.g:322:4: (otherlv_1= RULE_ID )
                    // PsiInternalBug288432TestLanguage.g:323:5: otherlv_1= RULE_ID
                    {

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					markLeaf(elementTypeProvider.getParameter_ValueParameterObjectCrossReference_1_0ElementType());
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					doneLeaf(otherlv_1);
                    				

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
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterRef"
    // PsiInternalBug288432TestLanguage.g:342:1: entryRuleParameterRef returns [Boolean current=false] : iv_ruleParameterRef= ruleParameterRef EOF ;
    public final Boolean entryRuleParameterRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameterRef = null;


        try {
            // PsiInternalBug288432TestLanguage.g:342:54: (iv_ruleParameterRef= ruleParameterRef EOF )
            // PsiInternalBug288432TestLanguage.g:343:2: iv_ruleParameterRef= ruleParameterRef EOF
            {
             markComposite(elementTypeProvider.getParameterRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterRef=ruleParameterRef();

            state._fsp--;

             current =iv_ruleParameterRef; 
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
    // $ANTLR end "entryRuleParameterRef"


    // $ANTLR start "ruleParameterRef"
    // PsiInternalBug288432TestLanguage.g:349:1: ruleParameterRef returns [Boolean current=false] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean ruleParameterRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalBug288432TestLanguage.g:350:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalBug288432TestLanguage.g:351:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalBug288432TestLanguage.g:351:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalBug288432TestLanguage.g:352:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalBug288432TestLanguage.g:352:3: (otherlv_0= RULE_ID )
            // PsiInternalBug288432TestLanguage.g:353:4: otherlv_0= RULE_ID
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				markLeaf(elementTypeProvider.getParameterRef_ParameterParameterCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

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
    // $ANTLR end "ruleParameterRef"


    // $ANTLR start "entryRuleMyInt"
    // PsiInternalBug288432TestLanguage.g:371:1: entryRuleMyInt returns [Boolean current=false] : iv_ruleMyInt= ruleMyInt EOF ;
    public final Boolean entryRuleMyInt() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMyInt = null;


        try {
            // PsiInternalBug288432TestLanguage.g:371:47: (iv_ruleMyInt= ruleMyInt EOF )
            // PsiInternalBug288432TestLanguage.g:372:2: iv_ruleMyInt= ruleMyInt EOF
            {
             markComposite(elementTypeProvider.getMyIntElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMyInt=ruleMyInt();

            state._fsp--;

             current =iv_ruleMyInt; 
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
    // $ANTLR end "entryRuleMyInt"


    // $ANTLR start "ruleMyInt"
    // PsiInternalBug288432TestLanguage.g:378:1: ruleMyInt returns [Boolean current=false] : ( (lv_int_0_0= RULE_INT ) ) ;
    public final Boolean ruleMyInt() throws RecognitionException {
        Boolean current = false;

        Token lv_int_0_0=null;

        try {
            // PsiInternalBug288432TestLanguage.g:379:1: ( ( (lv_int_0_0= RULE_INT ) ) )
            // PsiInternalBug288432TestLanguage.g:380:2: ( (lv_int_0_0= RULE_INT ) )
            {
            // PsiInternalBug288432TestLanguage.g:380:2: ( (lv_int_0_0= RULE_INT ) )
            // PsiInternalBug288432TestLanguage.g:381:3: (lv_int_0_0= RULE_INT )
            {
            // PsiInternalBug288432TestLanguage.g:381:3: (lv_int_0_0= RULE_INT )
            // PsiInternalBug288432TestLanguage.g:382:4: lv_int_0_0= RULE_INT
            {

            				markLeaf(elementTypeProvider.getMyInt_IntINTTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
            lv_int_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_int_0_0);
            			

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
    // $ANTLR end "ruleMyInt"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010060L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000022L});
    }


}