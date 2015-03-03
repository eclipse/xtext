package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalPartialParserTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'container'", "'{'", "'}'", "'nested'", "'children'", "','", "'->'", "'C'", "'('", "')'", "'abstract children'", "'F'", "'S'"
    };
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
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


        public PsiInternalPartialParserTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalPartialParserTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalPartialParserTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g"; }



    	protected PartialParserTestLanguageGrammarAccess grammarAccess;

    	protected PartialParserTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalPartialParserTestLanguageParser(PsiBuilder builder, TokenStream input, PartialParserTestLanguageElementTypeProvider elementTypeProvider, PartialParserTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "SomeContainer";
    	}




    // $ANTLR start "entryRuleSomeContainer"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:52:1: entryRuleSomeContainer : ruleSomeContainer EOF ;
    public final void entryRuleSomeContainer() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:52:23: ( ruleSomeContainer EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:53:2: ruleSomeContainer EOF
            {
             markComposite(elementTypeProvider.getSomeContainerElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer54);
            ruleSomeContainer();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSomeContainer57); 

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
    // $ANTLR end "entryRuleSomeContainer"


    // $ANTLR start "ruleSomeContainer"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:58:1: ruleSomeContainer : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) ;
    public final void ruleSomeContainer() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:58:18: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:59:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:59:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:60:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getSomeContainer_ContainerKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSomeContainer76); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:67:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:69:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSomeContainer_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSomeContainer103); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSomeContainer_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSomeContainer128); 

            			doneLeaf(otherlv_2);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:85:3: ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }
                else if ( (LA1_0==15||LA1_0==21) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:86:4: ( (lv_nested_3_0= ruleNested ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:86:4: ( (lv_nested_3_0= ruleNested ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:87:5: (lv_nested_3_0= ruleNested )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:87:5: (lv_nested_3_0= ruleNested )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:88:6: lv_nested_3_0= ruleNested
            	    {

            	    						markComposite(elementTypeProvider.getSomeContainer_NestedNestedParserRuleCall_3_0_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleNested_in_ruleSomeContainer163);
            	    ruleNested();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:98:4: ( (lv_content_4_0= ruleContent ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:98:4: ( (lv_content_4_0= ruleContent ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:99:5: (lv_content_4_0= ruleContent )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:99:5: (lv_content_4_0= ruleContent )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:100:6: lv_content_4_0= ruleContent
            	    {

            	    						markComposite(elementTypeProvider.getSomeContainer_ContentContentParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleSomeContainer217);
            	    ruleContent();

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


            			markLeaf(elementTypeProvider.getSomeContainer_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSomeContainer250); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleSomeContainer"


    // $ANTLR start "entryRuleNested"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:121:1: entryRuleNested : ruleNested EOF ;
    public final void entryRuleNested() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:121:16: ( ruleNested EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:122:2: ruleNested EOF
            {
             markComposite(elementTypeProvider.getNestedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNested_in_entryRuleNested270);
            ruleNested();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNested273); 

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
    // $ANTLR end "entryRuleNested"


    // $ANTLR start "ruleNested"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:127:1: ruleNested : (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) ;
    public final void ruleNested() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:127:11: ( (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:128:2: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:128:2: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:129:3: otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}'
            {

            			markLeaf(elementTypeProvider.getNested_NestedKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNested292); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getNested_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNested306); 

            			doneLeaf(otherlv_1);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:143:3: ( (lv_nested_2_0= ruleSomeContainer ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:144:4: (lv_nested_2_0= ruleSomeContainer )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:144:4: (lv_nested_2_0= ruleSomeContainer )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:145:5: lv_nested_2_0= ruleSomeContainer
            	    {

            	    					markComposite(elementTypeProvider.getNested_NestedSomeContainerParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleSomeContainer_in_ruleNested333);
            	    ruleSomeContainer();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            			markLeaf(elementTypeProvider.getNested_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNested359); 

            			doneLeaf(otherlv_3);
            		

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
    // $ANTLR end "ruleNested"


    // $ANTLR start "entryRuleContent"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:165:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:165:17: ( ruleContent EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:166:2: ruleContent EOF
            {
             markComposite(elementTypeProvider.getContentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent379);
            ruleContent();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent382); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:171:1: ruleContent : ( ruleChildren | ruleAbstractChildren ) ;
    public final void ruleContent() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:171:12: ( ( ruleChildren | ruleAbstractChildren ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:172:2: ( ruleChildren | ruleAbstractChildren )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:172:2: ( ruleChildren | ruleAbstractChildren )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==21) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:173:3: ruleChildren
                    {

                    			markComposite(elementTypeProvider.getContent_ChildrenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleChildren_in_ruleContent399);
                    ruleChildren();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:181:3: ruleAbstractChildren
                    {

                    			markComposite(elementTypeProvider.getContent_AbstractChildrenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractChildren_in_ruleContent419);
                    ruleAbstractChildren();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleChildren"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:192:1: entryRuleChildren : ruleChildren EOF ;
    public final void entryRuleChildren() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:192:18: ( ruleChildren EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:193:2: ruleChildren EOF
            {
             markComposite(elementTypeProvider.getChildrenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChildren_in_entryRuleChildren439);
            ruleChildren();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChildren442); 

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
    // $ANTLR end "entryRuleChildren"


    // $ANTLR start "ruleChildren"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:198:1: ruleChildren : (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) ;
    public final void ruleChildren() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:198:13: ( (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:199:2: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:199:2: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:200:3: otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getChildren_ChildrenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleChildren461); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getChildren_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleChildren475); 

            			doneLeaf(otherlv_1);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:214:3: ( (lv_children_2_0= ruleChild ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:215:4: (lv_children_2_0= ruleChild )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:215:4: (lv_children_2_0= ruleChild )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:216:5: lv_children_2_0= ruleChild
            {

            					markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleChildren502);
            ruleChild();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:225:3: (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:226:4: otherlv_3= ',' ( (lv_children_4_0= ruleChild ) )
            	    {

            	    				markLeaf(elementTypeProvider.getChildren_CommaKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChildren533); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:233:4: ( (lv_children_4_0= ruleChild ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:234:5: (lv_children_4_0= ruleChild )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:234:5: (lv_children_4_0= ruleChild )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:235:6: lv_children_4_0= ruleChild
            	    {

            	    						markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleChildren565);
            	    ruleChild();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getChildren_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleChildren598); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleChildren"


    // $ANTLR start "entryRuleChild"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:256:1: entryRuleChild : ruleChild EOF ;
    public final void entryRuleChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:256:15: ( ruleChild EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:257:2: ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild618);
            ruleChild();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild621); 

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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:262:1: ruleChild : (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) ;
    public final void ruleChild() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:262:10: ( (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:263:2: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:263:2: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:264:3: otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getChild_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild640); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getChild_CKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild654); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getChild_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleChild668); 

            			doneLeaf(otherlv_2);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:285:3: ( (lv_value_3_0= ruleNamed ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:286:4: (lv_value_3_0= ruleNamed )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:286:4: (lv_value_3_0= ruleNamed )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:287:5: lv_value_3_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getChild_ValueNamedParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleChild695);
            ruleNamed();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getChild_RightParenthesisKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild720); 

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
        return ;
    }
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleAbstractChildren"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:307:1: entryRuleAbstractChildren : ruleAbstractChildren EOF ;
    public final void entryRuleAbstractChildren() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:307:26: ( ruleAbstractChildren EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:308:2: ruleAbstractChildren EOF
            {
             markComposite(elementTypeProvider.getAbstractChildrenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren740);
            ruleAbstractChildren();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractChildren743); 

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
    // $ANTLR end "entryRuleAbstractChildren"


    // $ANTLR start "ruleAbstractChildren"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:313:1: ruleAbstractChildren : (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) ;
    public final void ruleAbstractChildren() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:313:21: ( (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:314:2: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:314:2: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:315:3: otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}'
            {

            			markLeaf(elementTypeProvider.getAbstractChildren_AbstractChildrenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAbstractChildren762); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getAbstractChildren_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAbstractChildren776); 

            			doneLeaf(otherlv_1);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:329:3: ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:330:4: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:330:4: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:331:5: lv_abstractChildren_2_0= ruleAbstractChild
            	    {

            	    					markComposite(elementTypeProvider.getAbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractChild_in_ruleAbstractChildren803);
            	    ruleAbstractChild();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            			markLeaf(elementTypeProvider.getAbstractChildren_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAbstractChildren829); 

            			doneLeaf(otherlv_3);
            		

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
    // $ANTLR end "ruleAbstractChildren"


    // $ANTLR start "entryRuleAbstractChild"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:351:1: entryRuleAbstractChild : ruleAbstractChild EOF ;
    public final void entryRuleAbstractChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:351:23: ( ruleAbstractChild EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:352:2: ruleAbstractChild EOF
            {
             markComposite(elementTypeProvider.getAbstractChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild849);
            ruleAbstractChild();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractChild852); 

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
    // $ANTLR end "entryRuleAbstractChild"


    // $ANTLR start "ruleAbstractChild"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:357:1: ruleAbstractChild : ( ruleFirstConcrete | ruleSecondConcrete ) ;
    public final void ruleAbstractChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:357:18: ( ( ruleFirstConcrete | ruleSecondConcrete ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:358:2: ( ruleFirstConcrete | ruleSecondConcrete )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:358:2: ( ruleFirstConcrete | ruleSecondConcrete )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==22) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==23) ) {
                        alt6=2;
                    }
                    else if ( (LA6_2==19) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:359:3: ruleFirstConcrete
                    {

                    			markComposite(elementTypeProvider.getAbstractChild_FirstConcreteParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleFirstConcrete_in_ruleAbstractChild869);
                    ruleFirstConcrete();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:367:3: ruleSecondConcrete
                    {

                    			markComposite(elementTypeProvider.getAbstractChild_SecondConcreteParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSecondConcrete_in_ruleAbstractChild889);
                    ruleSecondConcrete();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleAbstractChild"


    // $ANTLR start "entryRuleFirstConcrete"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:378:1: entryRuleFirstConcrete : ruleFirstConcrete EOF ;
    public final void entryRuleFirstConcrete() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:378:23: ( ruleFirstConcrete EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:379:2: ruleFirstConcrete EOF
            {
             markComposite(elementTypeProvider.getFirstConcreteElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete909);
            ruleFirstConcrete();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstConcrete912); 

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
    // $ANTLR end "entryRuleFirstConcrete"


    // $ANTLR start "ruleFirstConcrete"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:384:1: ruleFirstConcrete : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) ;
    public final void ruleFirstConcrete() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:384:18: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:385:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:385:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:386:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')'
            {

            			markLeaf(elementTypeProvider.getFirstConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFirstConcrete931); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getFirstConcrete_FKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFirstConcrete945); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getFirstConcrete_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFirstConcrete959); 

            			doneLeaf(otherlv_2);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:407:3: ( (lv_value_3_0= ruleNamed ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:408:4: (lv_value_3_0= ruleNamed )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:408:4: (lv_value_3_0= ruleNamed )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:409:5: lv_value_3_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getFirstConcrete_ValueNamedParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleFirstConcrete986);
            ruleNamed();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:418:3: ( (otherlv_4= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:419:4: (otherlv_4= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:419:4: (otherlv_4= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:420:5: otherlv_4= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getFirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0ElementType());
                    				
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFirstConcrete1024); 

                    					doneLeaf(otherlv_4);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getFirstConcrete_RightParenthesisKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFirstConcrete1050); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleFirstConcrete"


    // $ANTLR start "entryRuleSecondConcrete"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:440:1: entryRuleSecondConcrete : ruleSecondConcrete EOF ;
    public final void entryRuleSecondConcrete() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:440:24: ( ruleSecondConcrete EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:441:2: ruleSecondConcrete EOF
            {
             markComposite(elementTypeProvider.getSecondConcreteElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1070);
            ruleSecondConcrete();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondConcrete1073); 

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
    // $ANTLR end "entryRuleSecondConcrete"


    // $ANTLR start "ruleSecondConcrete"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:446:1: ruleSecondConcrete : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) ;
    public final void ruleSecondConcrete() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:446:19: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:447:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:447:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:448:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')'
            {

            			markLeaf(elementTypeProvider.getSecondConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSecondConcrete1092); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getSecondConcrete_FKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSecondConcrete1106); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getSecondConcrete_SKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSecondConcrete1120); 

            			doneLeaf(otherlv_2);
            		

            			markLeaf(elementTypeProvider.getSecondConcrete_LeftParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSecondConcrete1134); 

            			doneLeaf(otherlv_3);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:476:3: ( (lv_value_4_0= ruleNamed ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:477:4: (lv_value_4_0= ruleNamed )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:477:4: (lv_value_4_0= ruleNamed )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:478:5: lv_value_4_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getSecondConcrete_ValueNamedParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleSecondConcrete1161);
            ruleNamed();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:487:3: ( (otherlv_5= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:488:4: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:488:4: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:489:5: otherlv_5= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getSecondConcrete_ReferencedChildrenChildCrossReference_5_0ElementType());
                    				
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecondConcrete1199); 

                    					doneLeaf(otherlv_5);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getSecondConcrete_RightParenthesisKeyword_6ElementType());
            		
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSecondConcrete1225); 

            			doneLeaf(otherlv_6);
            		

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
    // $ANTLR end "ruleSecondConcrete"


    // $ANTLR start "entryRuleNamed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:509:1: entryRuleNamed : ruleNamed EOF ;
    public final void entryRuleNamed() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:509:15: ( ruleNamed EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:510:2: ruleNamed EOF
            {
             markComposite(elementTypeProvider.getNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_entryRuleNamed1245);
            ruleNamed();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamed1248); 

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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:515:1: ruleNamed : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleNamed() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:515:10: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:516:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:516:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:517:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:517:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalPartialParserTestLanguage.g:518:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getNamed_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamed1273); 

            				doneLeaf(lv_name_0_0);
            			

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
    // $ANTLR end "ruleNamed"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSomeContainer57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSomeContainer76 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSomeContainer103 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSomeContainer128 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_ruleNested_in_ruleSomeContainer163 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_ruleContent_in_ruleSomeContainer217 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_13_in_ruleSomeContainer250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNested_in_entryRuleNested270 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNested273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleNested292 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleNested306 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_ruleSomeContainer_in_ruleNested333 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_13_in_ruleNested359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent379 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChildren_in_ruleContent399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChildren_in_ruleContent419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChildren_in_entryRuleChildren439 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChildren442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleChildren461 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleChildren475 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleChildren502 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleChildren533 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleChildren565 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleChildren598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleChild640 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild654 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleChild668 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleChild695 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChildren743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAbstractChildren762 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAbstractChildren776 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleAbstractChild_in_ruleAbstractChildren803 = new BitSet(new long[]{0x0000000000022000L});
        public static final BitSet FOLLOW_13_in_ruleAbstractChildren829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChild852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstConcrete_in_ruleAbstractChild869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondConcrete_in_ruleAbstractChild889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstConcrete912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleFirstConcrete931 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleFirstConcrete945 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleFirstConcrete959 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleFirstConcrete986 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFirstConcrete1024 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleFirstConcrete1050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1070 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondConcrete1073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSecondConcrete1092 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleSecondConcrete1106 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSecondConcrete1120 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleSecondConcrete1134 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleSecondConcrete1161 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecondConcrete1199 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSecondConcrete1225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed1245 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamed1248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamed1273 = new BitSet(new long[]{0x0000000000000002L});
    }


}