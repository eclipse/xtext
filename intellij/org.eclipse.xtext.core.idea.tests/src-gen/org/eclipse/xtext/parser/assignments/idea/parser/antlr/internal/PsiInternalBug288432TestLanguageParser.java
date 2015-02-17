package org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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



    private Bug288432TestLanguageGrammarAccess grammarAccess;

    private Bug288432TestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalBug288432TestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, Bug288432TestLanguageElementTypeProvider elementTypeProvider, Bug288432TestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Body";
    }




    // $ANTLR start "entryRuleBody"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:49:1: entryRuleBody : ruleBody EOF ;
    public final void entryRuleBody() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:49:14: ( ruleBody EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:50:2: ruleBody EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:58:1: ruleBody : ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) ;
    public final void ruleBody() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:58:9: ( ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:59:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:59:2: ( (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:60:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )? otherlv_5= 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ otherlv_8= 'end body'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:60:3: (otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:61:4: otherlv_0= '(' ( (lv_parameter_1_0= ruleParameter ) ) (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )* otherlv_4= ')'
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBody89); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getBody_LeftParenthesisKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:68:4: ( (lv_parameter_1_0= ruleParameter ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:69:5: (lv_parameter_1_0= ruleParameter )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:69:5: (lv_parameter_1_0= ruleParameter )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:70:6: lv_parameter_1_0= ruleParameter
                    {

                    						markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody121);
                    ruleParameter();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:79:4: (otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:80:5: otherlv_2= ',' ( (lv_parameter_3_0= ruleParameter ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleBody158); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getBody_CommaKeyword_0_2_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:87:5: ( (lv_parameter_3_0= ruleParameter ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:88:6: (lv_parameter_3_0= ruleParameter )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:88:6: (lv_parameter_3_0= ruleParameter )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:89:7: lv_parameter_3_0= ruleParameter
                    	    {

                    	    							markComposite(elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_2_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody195);
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
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBody234); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getBody_RightParenthesisKeyword_0_3ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBody254); 

            			doneLeaf(otherlv_5, elementTypeProvider.getBody_BodyKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:114:3: ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:115:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:115:4: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:116:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:116:5: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:117:6: lv_content_6_1= ruleContent
                    {

                    						markComposite(elementTypeProvider.getBody_ContentContentParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleBody289);
                    ruleContent();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:125:6: lv_content_6_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getBody_ContentParameterRefParserRuleCall_2_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleBody323);
                    ruleParameterRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:135:3: ( (lv_foo_7_0= ruleFoo ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:136:4: (lv_foo_7_0= ruleFoo )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:136:4: (lv_foo_7_0= ruleFoo )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:137:5: lv_foo_7_0= ruleFoo
            	    {

            	    					markComposite(elementTypeProvider.getBody_FooFooParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleFoo_in_ruleBody368);
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
            		
            otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleBody394); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:157:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:157:13: ( ruleFoo EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:158:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo414);
            ruleFoo();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo420); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:166:1: ruleFoo : ( (lv_fooValue_0_0= RULE_STRING ) ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_fooValue_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:166:8: ( ( (lv_fooValue_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:167:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:167:2: ( (lv_fooValue_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:168:3: (lv_fooValue_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:168:3: (lv_fooValue_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:169:4: lv_fooValue_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_fooValue_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFoo449); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:181:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:181:17: ( ruleContent EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:182:2: ruleContent EOF
            {
             markComposite(elementTypeProvider.getContentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent474);
            ruleContent();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent480); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:190:1: ruleContent : (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' ) ;
    public final void ruleContent() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:190:12: ( (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:191:2: (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:191:2: (otherlv_0= 'content' ruleMyElement otherlv_2= 'end content' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:192:3: otherlv_0= 'content' ruleMyElement otherlv_2= 'end content'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleContent503); 

            			doneLeaf(otherlv_0, elementTypeProvider.getContent_ContentKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getContent_MyElementParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_ruleContent515);
            ruleMyElement();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleContent529); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:217:1: entryRuleMyElement : ruleMyElement EOF ;
    public final void entryRuleMyElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:217:19: ( ruleMyElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:218:2: ruleMyElement EOF
            {
             markComposite(elementTypeProvider.getMyElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_entryRuleMyElement549);
            ruleMyElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyElement555); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:226:1: ruleMyElement : (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) ;
    public final void ruleMyElement() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:226:14: ( (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:227:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:227:2: (otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:228:3: otherlv_0= 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMyElement578); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMyElement_ElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:235:3: ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:236:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:236:4: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:237:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:237:5: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:238:6: lv_bar_1_1= ruleMyInt
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarMyIntParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_ruleMyElement613);
                    ruleMyInt();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:246:6: lv_bar_1_2= ruleParameterRef
                    {

                    						markComposite(elementTypeProvider.getMyElement_BarParameterRefParserRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleMyElement647);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:260:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:260:19: ( ruleParameter EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:261:2: ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter685);
            ruleParameter();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter691); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:269:1: ruleParameter : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final void ruleParameter() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:269:14: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:270:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:270:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:271:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:271:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:272:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:272:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:273:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter727); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getParameter_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:282:3: ( (otherlv_1= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:283:4: (otherlv_1= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:283:4: (otherlv_1= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:284:5: otherlv_1= RULE_ID
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter765); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:297:1: entryRuleParameterRef : ruleParameterRef EOF ;
    public final void entryRuleParameterRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:297:22: ( ruleParameterRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:298:2: ruleParameterRef EOF
            {
             markComposite(elementTypeProvider.getParameterRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_entryRuleParameterRef797);
            ruleParameterRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterRef803); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:306:1: ruleParameterRef : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleParameterRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:306:17: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:307:2: ( (otherlv_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:307:2: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:308:3: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:308:3: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:309:4: otherlv_0= RULE_ID
            {

            				markLeaf();
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameterRef832); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:321:1: entryRuleMyInt : ruleMyInt EOF ;
    public final void entryRuleMyInt() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:321:15: ( ruleMyInt EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:322:2: ruleMyInt EOF
            {
             markComposite(elementTypeProvider.getMyIntElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_entryRuleMyInt857);
            ruleMyInt();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyInt863); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:330:1: ruleMyInt : ( (lv_int_0_0= RULE_INT ) ) ;
    public final void ruleMyInt() throws RecognitionException {
        Token lv_int_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:330:10: ( ( (lv_int_0_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:331:2: ( (lv_int_0_0= RULE_INT ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:331:2: ( (lv_int_0_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:332:3: (lv_int_0_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:332:3: (lv_int_0_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug288432TestLanguage.g:333:4: lv_int_0_0= RULE_INT
            {

            				markLeaf();
            			
            lv_int_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMyInt892); 

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
        public static final BitSet FOLLOW_11_in_ruleBody89 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody121 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleBody158 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody195 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_13_in_ruleBody234 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleBody254 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_ruleContent_in_ruleBody289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleBody323 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFoo_in_ruleBody368 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleBody394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo414 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFoo449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent474 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleContent503 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMyElement_in_ruleContent515 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleContent529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyElement_in_entryRuleMyElement549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyElement555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMyElement578 = new BitSet(new long[]{0x0000000000010060L});
        public static final BitSet FOLLOW_ruleMyInt_in_ruleMyElement613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleMyElement647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter685 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter727 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_entryRuleParameterRef797 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterRef803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameterRef832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyInt_in_entryRuleMyInt857 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyInt863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMyInt892 = new BitSet(new long[]{0x0000000000000002L});
    }


}