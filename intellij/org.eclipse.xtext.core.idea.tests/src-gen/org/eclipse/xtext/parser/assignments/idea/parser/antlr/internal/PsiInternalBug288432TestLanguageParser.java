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
    // PsiInternalBug288432TestLanguage.g:52:1: entryRuleBody : ruleBody EOF ;
    public final void entryRuleBody() throws RecognitionException {
        try {
            // PsiInternalBug288432TestLanguage.g:52:14: ( ruleBody EOF )
            // PsiInternalBug288432TestLanguage.g:53:2: ruleBody EOF
            {
             markComposite(elementTypeProvider.getBodyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBody();

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
    // $ANTLR end "entryRuleBody"


    // $ANTLR start "ruleBody"
    // PsiInternalBug288432TestLanguage.g:58:1: ruleBody : ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) ;
    public final void ruleBody() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;

        try {
            // PsiInternalBug288432TestLanguage.g:58:9: ( ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) )
            // PsiInternalBug288432TestLanguage.g:59:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            {
            // PsiInternalBug288432TestLanguage.g:59:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            // PsiInternalBug288432TestLanguage.g:60:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body'
            {
            // PsiInternalBug288432TestLanguage.g:60:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug288432TestLanguage.g:61:4: otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')'
                    {

                    				markLeaf(elementTypeProvider.getBody_LeftParenthesisKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug288432TestLanguage.g:68:4: ( (lv_parameter_1_0= ruleParameter ) )
                    // PsiInternalBug288432TestLanguage.g:69:5: (lv_parameter_1_0= ruleParameter )
                    {
                    // PsiInternalBug288432TestLanguage.g:69:5: (lv_parameter_1_0= ruleParameter )
                    // PsiInternalBug288432TestLanguage.g:70:6: lv_parameter_1_0= ruleParameter
                    {

                    						markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    ruleParameter();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalBug288432TestLanguage.g:79:4: (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalBug288432TestLanguage.g:80:5: otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getBody_CommaKeyword_0_2_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalBug288432TestLanguage.g:87:5: ( (lv_parameter_3_0= ruleParameter ) )
                    	    // PsiInternalBug288432TestLanguage.g:88:6: (lv_parameter_3_0= ruleParameter )
                    	    {
                    	    // PsiInternalBug288432TestLanguage.g:88:6: (lv_parameter_3_0= ruleParameter )
                    	    // PsiInternalBug288432TestLanguage.g:89:7: lv_parameter_3_0= ruleParameter
                    	    {

                    	    							markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    ruleParameter();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

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
            		
            // PsiInternalBug288432TestLanguage.g:114:3: ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) )
            // PsiInternalBug288432TestLanguage.g:115:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            {
            // PsiInternalBug288432TestLanguage.g:115:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            // PsiInternalBug288432TestLanguage.g:116:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            {
            // PsiInternalBug288432TestLanguage.g:116:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
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
                    // PsiInternalBug288432TestLanguage.g:117:6: lv_content_6_1= ruleContent
                    {

                    						markComposite(elementTypeProvider.getBody_ContentContentParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleContent();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalBug288432TestLanguage.g:125:6: lv_content_6_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getBody_ContentParameterRefParserRuleCall_2_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleParameterRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalBug288432TestLanguage.g:135:3: ( (lv_foo_7_0= ruleFoo ) )+
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
            	    // PsiInternalBug288432TestLanguage.g:136:4: (lv_foo_7_0= ruleFoo )
            	    {
            	    // PsiInternalBug288432TestLanguage.g:136:4: (lv_foo_7_0= ruleFoo )
            	    // PsiInternalBug288432TestLanguage.g:137:5: lv_foo_7_0= ruleFoo
            	    {

            	    					markComposite(elementTypeProvider.getBody_FooFooParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    ruleFoo();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
        return ;
    }
    // $ANTLR end "ruleBody"


    // $ANTLR start "entryRuleFoo"
    // PsiInternalBug288432TestLanguage.g:157:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // PsiInternalBug288432TestLanguage.g:157:13: ( ruleFoo EOF )
            // PsiInternalBug288432TestLanguage.g:158:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFoo();

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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // PsiInternalBug288432TestLanguage.g:163:1: ruleFoo : ( (lv_fooValue_0_0= RULE_STRING ) ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_fooValue_0_0=null;

        try {
            // PsiInternalBug288432TestLanguage.g:163:8: ( ( (lv_fooValue_0_0= RULE_STRING ) ) )
            // PsiInternalBug288432TestLanguage.g:164:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            {
            // PsiInternalBug288432TestLanguage.g:164:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            // PsiInternalBug288432TestLanguage.g:165:3: (lv_fooValue_0_0= RULE_STRING )
            {
            // PsiInternalBug288432TestLanguage.g:165:3: (lv_fooValue_0_0= RULE_STRING )
            // PsiInternalBug288432TestLanguage.g:166:4: lv_fooValue_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getFoo_FooValueSTRINGTerminalRuleCall_0ElementType());
            			
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
        return ;
    }
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleContent"
    // PsiInternalBug288432TestLanguage.g:178:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // PsiInternalBug288432TestLanguage.g:178:17: ( ruleContent EOF )
            // PsiInternalBug288432TestLanguage.g:179:2: ruleContent EOF
            {
             markComposite(elementTypeProvider.getContentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleContent();

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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // PsiInternalBug288432TestLanguage.g:184:1: ruleContent : (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' ) ;
    public final void ruleContent() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug288432TestLanguage.g:184:12: ( (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' ) )
            // PsiInternalBug288432TestLanguage.g:185:2: (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' )
            {
            // PsiInternalBug288432TestLanguage.g:185:2: (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' )
            // PsiInternalBug288432TestLanguage.g:186:3: otherlv_0= 'content' ruleMyElement otherlv_2= 'end content'
            {

            			markLeaf(elementTypeProvider.getContent_ContentKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getContent_MyElementParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_10);
            ruleMyElement();

            state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleMyElement"
    // PsiInternalBug288432TestLanguage.g:211:1: entryRuleMyElement : ruleMyElement EOF ;
    public final void entryRuleMyElement() throws RecognitionException {
        try {
            // PsiInternalBug288432TestLanguage.g:211:19: ( ruleMyElement EOF )
            // PsiInternalBug288432TestLanguage.g:212:2: ruleMyElement EOF
            {
             markComposite(elementTypeProvider.getMyElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyElement();

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
    // $ANTLR end "entryRuleMyElement"


    // $ANTLR start "ruleMyElement"
    // PsiInternalBug288432TestLanguage.g:217:1: ruleMyElement : (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) ;
    public final void ruleMyElement() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalBug288432TestLanguage.g:217:14: ( (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) )
            // PsiInternalBug288432TestLanguage.g:218:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            {
            // PsiInternalBug288432TestLanguage.g:218:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            // PsiInternalBug288432TestLanguage.g:219:3: otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            {

            			markLeaf(elementTypeProvider.getMyElement_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug288432TestLanguage.g:226:3: ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            // PsiInternalBug288432TestLanguage.g:227:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            {
            // PsiInternalBug288432TestLanguage.g:227:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            // PsiInternalBug288432TestLanguage.g:228:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            {
            // PsiInternalBug288432TestLanguage.g:228:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
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
                    // PsiInternalBug288432TestLanguage.g:229:6: lv_bar_1_1= ruleMyInt
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarMyIntParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMyInt();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalBug288432TestLanguage.g:237:6: lv_bar_1_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarParameterRefParserRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParameterRef();

                    state._fsp--;


                    						doneComposite();
                    					

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
        return ;
    }
    // $ANTLR end "ruleMyElement"


    // $ANTLR start "entryRuleParameter"
    // PsiInternalBug288432TestLanguage.g:251:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // PsiInternalBug288432TestLanguage.g:251:19: ( ruleParameter EOF )
            // PsiInternalBug288432TestLanguage.g:252:2: ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameter();

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // PsiInternalBug288432TestLanguage.g:257:1: ruleParameter : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final void ruleParameter() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalBug288432TestLanguage.g:257:14: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // PsiInternalBug288432TestLanguage.g:258:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // PsiInternalBug288432TestLanguage.g:258:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            // PsiInternalBug288432TestLanguage.g:259:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // PsiInternalBug288432TestLanguage.g:259:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug288432TestLanguage.g:260:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug288432TestLanguage.g:260:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug288432TestLanguage.g:261:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameter_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalBug288432TestLanguage.g:270:3: ( (otherlv_1= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalBug288432TestLanguage.g:271:4: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalBug288432TestLanguage.g:271:4: (otherlv_1= RULE_ID )
                    // PsiInternalBug288432TestLanguage.g:272:5: otherlv_1= RULE_ID
                    {

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
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterRef"
    // PsiInternalBug288432TestLanguage.g:285:1: entryRuleParameterRef : ruleParameterRef EOF ;
    public final void entryRuleParameterRef() throws RecognitionException {
        try {
            // PsiInternalBug288432TestLanguage.g:285:22: ( ruleParameterRef EOF )
            // PsiInternalBug288432TestLanguage.g:286:2: ruleParameterRef EOF
            {
             markComposite(elementTypeProvider.getParameterRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameterRef();

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
    // $ANTLR end "entryRuleParameterRef"


    // $ANTLR start "ruleParameterRef"
    // PsiInternalBug288432TestLanguage.g:291:1: ruleParameterRef : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleParameterRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalBug288432TestLanguage.g:291:17: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalBug288432TestLanguage.g:292:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalBug288432TestLanguage.g:292:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalBug288432TestLanguage.g:293:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalBug288432TestLanguage.g:293:3: (otherlv_0= RULE_ID )
            // PsiInternalBug288432TestLanguage.g:294:4: otherlv_0= RULE_ID
            {

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
        return ;
    }
    // $ANTLR end "ruleParameterRef"


    // $ANTLR start "entryRuleMyInt"
    // PsiInternalBug288432TestLanguage.g:306:1: entryRuleMyInt : ruleMyInt EOF ;
    public final void entryRuleMyInt() throws RecognitionException {
        try {
            // PsiInternalBug288432TestLanguage.g:306:15: ( ruleMyInt EOF )
            // PsiInternalBug288432TestLanguage.g:307:2: ruleMyInt EOF
            {
             markComposite(elementTypeProvider.getMyIntElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyInt();

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
    // $ANTLR end "entryRuleMyInt"


    // $ANTLR start "ruleMyInt"
    // PsiInternalBug288432TestLanguage.g:312:1: ruleMyInt : ( (lv_int_0_0= RULE_INT ) ) ;
    public final void ruleMyInt() throws RecognitionException {
        Token lv_int_0_0=null;

        try {
            // PsiInternalBug288432TestLanguage.g:312:10: ( ( (lv_int_0_0= RULE_INT ) ) )
            // PsiInternalBug288432TestLanguage.g:313:2: ( (lv_int_0_0= RULE_INT ) )
            {
            // PsiInternalBug288432TestLanguage.g:313:2: ( (lv_int_0_0= RULE_INT ) )
            // PsiInternalBug288432TestLanguage.g:314:3: (lv_int_0_0= RULE_INT )
            {
            // PsiInternalBug288432TestLanguage.g:314:3: (lv_int_0_0= RULE_INT )
            // PsiInternalBug288432TestLanguage.g:315:4: lv_int_0_0= RULE_INT
            {

            				markLeaf(elementTypeProvider.getMyInt_IntINTTerminalRuleCall_0ElementType());
            			
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
        return ;
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