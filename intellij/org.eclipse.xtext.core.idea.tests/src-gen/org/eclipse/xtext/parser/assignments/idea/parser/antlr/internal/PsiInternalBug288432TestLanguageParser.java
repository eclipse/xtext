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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:52:1: entryRuleBody : ruleBody EOF ;
    public final void entryRuleBody() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:52:14: ( ruleBody EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:53:2: ruleBody EOF
            {
             markComposite(elementTypeProvider.getBodyElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBody_in_entryRuleBody54);
            ruleBody();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBody60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:59:1: ruleBody : ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) ;
    public final void ruleBody() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:59:9: ( ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:60:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:60:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:61:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:61:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:62:4: otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')'
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBody85); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getBody_LeftParenthesisKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:69:4: ( (lv_parameter_1_0= ruleParameter ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:70:5: (lv_parameter_1_0= ruleParameter )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:70:5: (lv_parameter_1_0= ruleParameter )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:71:6: lv_parameter_1_0= ruleParameter
                    {

                    						markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody117);
                    ruleParameter();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:80:4: (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:81:5: otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleBody154); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getBody_CommaKeyword_0_2_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:88:5: ( (lv_parameter_3_0= ruleParameter ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:89:6: (lv_parameter_3_0= ruleParameter )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:89:6: (lv_parameter_3_0= ruleParameter )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:90:7: lv_parameter_3_0= ruleParameter
                    	    {

                    	    							markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody191);
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


                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBody230); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getBody_RightParenthesisKeyword_0_3ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBody250); 

            			doneLeaf(otherlv_5, elementTypeProvider.getBody_BodyKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:115:3: ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:116:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:116:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:117:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:117:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:118:6: lv_content_6_1= ruleContent
                    {

                    						markComposite(elementTypeProvider.getBody_ContentContentParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleBody285);
                    ruleContent();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:126:6: lv_content_6_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getBody_ContentParameterRefParserRuleCall_2_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleBody319);
                    ruleParameterRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:136:3: ( (lv_foo_7_0= ruleFoo ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:137:4: (lv_foo_7_0= ruleFoo )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:137:4: (lv_foo_7_0= ruleFoo )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:138:5: lv_foo_7_0= ruleFoo
            	    {

            	    					markComposite(elementTypeProvider.getBody_FooFooParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleFoo_in_ruleBody364);
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


            			markLeaf();
            		
            otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleBody390); 

            			doneLeaf(otherlv_8, elementTypeProvider.getBody_EndBodyKeyword_4ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:158:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:158:13: ( ruleFoo EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:159:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo410);
            ruleFoo();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo416); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:165:1: ruleFoo : ( (lv_fooValue_0_0= RULE_STRING ) ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_fooValue_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:165:8: ( ( (lv_fooValue_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:166:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:166:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:167:3: (lv_fooValue_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:167:3: (lv_fooValue_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:168:4: lv_fooValue_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_fooValue_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFoo441); 

            				doneLeaf(lv_fooValue_0_0, elementTypeProvider.getFoo_FooValueSTRINGTerminalRuleCall_0ElementType());
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:180:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:180:17: ( ruleContent EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:181:2: ruleContent EOF
            {
             markComposite(elementTypeProvider.getContentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent466);
            ruleContent();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent472); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:187:1: ruleContent : (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' ) ;
    public final void ruleContent() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:187:12: ( (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:188:2: (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:188:2: (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:189:3: otherlv_0= 'content' ruleMyElement otherlv_2= 'end content'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleContent491); 

            			doneLeaf(otherlv_0, elementTypeProvider.getContent_ContentKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getContent_MyElementParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_ruleContent503);
            ruleMyElement();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleContent517); 

            			doneLeaf(otherlv_2, elementTypeProvider.getContent_EndContentKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:214:1: entryRuleMyElement : ruleMyElement EOF ;
    public final void entryRuleMyElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:214:19: ( ruleMyElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:215:2: ruleMyElement EOF
            {
             markComposite(elementTypeProvider.getMyElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_entryRuleMyElement537);
            ruleMyElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyElement543); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:221:1: ruleMyElement : (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) ;
    public final void ruleMyElement() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:221:14: ( (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:222:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:222:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:223:3: otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMyElement562); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMyElement_ElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:230:3: ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:231:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:231:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:232:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:232:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:233:6: lv_bar_1_1= ruleMyInt
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarMyIntParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_ruleMyElement597);
                    ruleMyInt();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:241:6: lv_bar_1_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarParameterRefParserRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleMyElement631);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:255:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:255:19: ( ruleParameter EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:256:2: ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter669);
            ruleParameter();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter675); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:262:1: ruleParameter : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final void ruleParameter() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:262:14: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:263:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:263:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:264:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:264:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:265:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:265:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:266:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter707); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getParameter_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:275:3: ( (otherlv_1= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:276:4: (otherlv_1= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:276:4: (otherlv_1= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:277:5: otherlv_1= RULE_ID
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter745); 

                    					doneLeaf(otherlv_1, elementTypeProvider.getParameter_ValueParameterObjectCrossReference_1_0ElementType());
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:290:1: entryRuleParameterRef : ruleParameterRef EOF ;
    public final void entryRuleParameterRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:290:22: ( ruleParameterRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:291:2: ruleParameterRef EOF
            {
             markComposite(elementTypeProvider.getParameterRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_entryRuleParameterRef777);
            ruleParameterRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterRef783); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:297:1: ruleParameterRef : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleParameterRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:297:17: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:298:2: ( (otherlv_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:298:2: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:299:3: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:299:3: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:300:4: otherlv_0= RULE_ID
            {

            				markLeaf();
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameterRef808); 

            				doneLeaf(otherlv_0, elementTypeProvider.getParameterRef_ParameterParameterCrossReference_0ElementType());
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:312:1: entryRuleMyInt : ruleMyInt EOF ;
    public final void entryRuleMyInt() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:312:15: ( ruleMyInt EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:313:2: ruleMyInt EOF
            {
             markComposite(elementTypeProvider.getMyIntElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_entryRuleMyInt833);
            ruleMyInt();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyInt839); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:319:1: ruleMyInt : ( (lv_int_0_0= RULE_INT ) ) ;
    public final void ruleMyInt() throws RecognitionException {
        Token lv_int_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:319:10: ( ( (lv_int_0_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:320:2: ( (lv_int_0_0= RULE_INT ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:320:2: ( (lv_int_0_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:321:3: (lv_int_0_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:321:3: (lv_int_0_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:322:4: lv_int_0_0= RULE_INT
            {

            				markLeaf();
            			
            lv_int_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMyInt864); 

            				doneLeaf(lv_int_0_0, elementTypeProvider.getMyInt_IntINTTerminalRuleCall_0ElementType());
            			

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
        public static final BitSet FOLLOW_ruleBody_in_entryRuleBody54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBody60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleBody85 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody117 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleBody154 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody191 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_13_in_ruleBody230 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleBody250 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_ruleContent_in_ruleBody285 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleBody319 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFoo_in_ruleBody364 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleBody390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo410 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFoo441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent466 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleContent491 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMyElement_in_ruleContent503 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleContent517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyElement_in_entryRuleMyElement537 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyElement543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMyElement562 = new BitSet(new long[]{0x0000000000010060L});
        public static final BitSet FOLLOW_ruleMyInt_in_ruleMyElement597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleMyElement631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter669 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter707 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_entryRuleParameterRef777 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterRef783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameterRef808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyInt_in_entryRuleMyInt833 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyInt839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMyInt864 = new BitSet(new long[]{0x0000000000000002L});
    }


}