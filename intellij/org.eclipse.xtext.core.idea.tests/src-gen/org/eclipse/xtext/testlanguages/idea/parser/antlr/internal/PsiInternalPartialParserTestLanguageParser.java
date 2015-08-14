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
    public String getGrammarFileName() { return "PsiInternalPartialParserTestLanguage.g"; }



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
    // PsiInternalPartialParserTestLanguage.g:52:1: entryRuleSomeContainer : ruleSomeContainer EOF ;
    public final void entryRuleSomeContainer() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:52:23: ( ruleSomeContainer EOF )
            // PsiInternalPartialParserTestLanguage.g:53:2: ruleSomeContainer EOF
            {
             markComposite(elementTypeProvider.getSomeContainerElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSomeContainer();

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
    // $ANTLR end "entryRuleSomeContainer"


    // $ANTLR start "ruleSomeContainer"
    // PsiInternalPartialParserTestLanguage.g:58:1: ruleSomeContainer : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) ;
    public final void ruleSomeContainer() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:58:18: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:59:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:59:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            // PsiInternalPartialParserTestLanguage.g:60:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getSomeContainer_ContainerKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalPartialParserTestLanguage.g:67:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalPartialParserTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalPartialParserTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            // PsiInternalPartialParserTestLanguage.g:69:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSomeContainer_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSomeContainer_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalPartialParserTestLanguage.g:85:3: ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )*
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
            	    // PsiInternalPartialParserTestLanguage.g:86:4: ( (lv_nested_3_0= ruleNested ) )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:86:4: ( (lv_nested_3_0= ruleNested ) )
            	    // PsiInternalPartialParserTestLanguage.g:87:5: (lv_nested_3_0= ruleNested )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:87:5: (lv_nested_3_0= ruleNested )
            	    // PsiInternalPartialParserTestLanguage.g:88:6: lv_nested_3_0= ruleNested
            	    {

            	    						markComposite(elementTypeProvider.getSomeContainer_NestedNestedParserRuleCall_3_0_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    ruleNested();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalPartialParserTestLanguage.g:98:4: ( (lv_content_4_0= ruleContent ) )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:98:4: ( (lv_content_4_0= ruleContent ) )
            	    // PsiInternalPartialParserTestLanguage.g:99:5: (lv_content_4_0= ruleContent )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:99:5: (lv_content_4_0= ruleContent )
            	    // PsiInternalPartialParserTestLanguage.g:100:6: lv_content_4_0= ruleContent
            	    {

            	    						markComposite(elementTypeProvider.getSomeContainer_ContentContentParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_5);
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
            		
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // PsiInternalPartialParserTestLanguage.g:121:1: entryRuleNested : ruleNested EOF ;
    public final void entryRuleNested() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:121:16: ( ruleNested EOF )
            // PsiInternalPartialParserTestLanguage.g:122:2: ruleNested EOF
            {
             markComposite(elementTypeProvider.getNestedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNested();

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
    // $ANTLR end "entryRuleNested"


    // $ANTLR start "ruleNested"
    // PsiInternalPartialParserTestLanguage.g:127:1: ruleNested : (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) ;
    public final void ruleNested() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:127:11: ( (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:128:2: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:128:2: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            // PsiInternalPartialParserTestLanguage.g:129:3: otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}'
            {

            			markLeaf(elementTypeProvider.getNested_NestedKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getNested_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalPartialParserTestLanguage.g:143:3: ( (lv_nested_2_0= ruleSomeContainer ) )+
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
            	    // PsiInternalPartialParserTestLanguage.g:144:4: (lv_nested_2_0= ruleSomeContainer )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:144:4: (lv_nested_2_0= ruleSomeContainer )
            	    // PsiInternalPartialParserTestLanguage.g:145:5: lv_nested_2_0= ruleSomeContainer
            	    {

            	    					markComposite(elementTypeProvider.getNested_NestedSomeContainerParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
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
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // PsiInternalPartialParserTestLanguage.g:165:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:165:17: ( ruleContent EOF )
            // PsiInternalPartialParserTestLanguage.g:166:2: ruleContent EOF
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
    // PsiInternalPartialParserTestLanguage.g:171:1: ruleContent : ( ruleChildren | ruleAbstractChildren ) ;
    public final void ruleContent() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:171:12: ( ( ruleChildren | ruleAbstractChildren ) )
            // PsiInternalPartialParserTestLanguage.g:172:2: ( ruleChildren | ruleAbstractChildren )
            {
            // PsiInternalPartialParserTestLanguage.g:172:2: ( ruleChildren | ruleAbstractChildren )
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
                    // PsiInternalPartialParserTestLanguage.g:173:3: ruleChildren
                    {

                    			markComposite(elementTypeProvider.getContent_ChildrenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleChildren();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalPartialParserTestLanguage.g:181:3: ruleAbstractChildren
                    {

                    			markComposite(elementTypeProvider.getContent_AbstractChildrenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalPartialParserTestLanguage.g:192:1: entryRuleChildren : ruleChildren EOF ;
    public final void entryRuleChildren() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:192:18: ( ruleChildren EOF )
            // PsiInternalPartialParserTestLanguage.g:193:2: ruleChildren EOF
            {
             markComposite(elementTypeProvider.getChildrenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChildren();

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
    // $ANTLR end "entryRuleChildren"


    // $ANTLR start "ruleChildren"
    // PsiInternalPartialParserTestLanguage.g:198:1: ruleChildren : (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) ;
    public final void ruleChildren() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:198:13: ( (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:199:2: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:199:2: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            // PsiInternalPartialParserTestLanguage.g:200:3: otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getChildren_ChildrenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getChildren_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalPartialParserTestLanguage.g:214:3: ( (lv_children_2_0= ruleChild ) )
            // PsiInternalPartialParserTestLanguage.g:215:4: (lv_children_2_0= ruleChild )
            {
            // PsiInternalPartialParserTestLanguage.g:215:4: (lv_children_2_0= ruleChild )
            // PsiInternalPartialParserTestLanguage.g:216:5: lv_children_2_0= ruleChild
            {

            					markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            ruleChild();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalPartialParserTestLanguage.g:225:3: (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalPartialParserTestLanguage.g:226:4: otherlv_3= ',' ( (lv_children_4_0= ruleChild ) )
            	    {

            	    				markLeaf(elementTypeProvider.getChildren_CommaKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_8); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalPartialParserTestLanguage.g:233:4: ( (lv_children_4_0= ruleChild ) )
            	    // PsiInternalPartialParserTestLanguage.g:234:5: (lv_children_4_0= ruleChild )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:234:5: (lv_children_4_0= ruleChild )
            	    // PsiInternalPartialParserTestLanguage.g:235:6: lv_children_4_0= ruleChild
            	    {

            	    						markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_9);
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
            		
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // PsiInternalPartialParserTestLanguage.g:256:1: entryRuleChild : ruleChild EOF ;
    public final void entryRuleChild() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:256:15: ( ruleChild EOF )
            // PsiInternalPartialParserTestLanguage.g:257:2: ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild();

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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // PsiInternalPartialParserTestLanguage.g:262:1: ruleChild : (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) ;
    public final void ruleChild() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:262:10: ( (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) )
            // PsiInternalPartialParserTestLanguage.g:263:2: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            {
            // PsiInternalPartialParserTestLanguage.g:263:2: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            // PsiInternalPartialParserTestLanguage.g:264:3: otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')'
            {

            			markLeaf(elementTypeProvider.getChild_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getChild_CKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getChild_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalPartialParserTestLanguage.g:285:3: ( (lv_value_3_0= ruleNamed ) )
            // PsiInternalPartialParserTestLanguage.g:286:4: (lv_value_3_0= ruleNamed )
            {
            // PsiInternalPartialParserTestLanguage.g:286:4: (lv_value_3_0= ruleNamed )
            // PsiInternalPartialParserTestLanguage.g:287:5: lv_value_3_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getChild_ValueNamedParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_12);
            ruleNamed();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getChild_RightParenthesisKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_2); 

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
    // PsiInternalPartialParserTestLanguage.g:307:1: entryRuleAbstractChildren : ruleAbstractChildren EOF ;
    public final void entryRuleAbstractChildren() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:307:26: ( ruleAbstractChildren EOF )
            // PsiInternalPartialParserTestLanguage.g:308:2: ruleAbstractChildren EOF
            {
             markComposite(elementTypeProvider.getAbstractChildrenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractChildren();

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
    // $ANTLR end "entryRuleAbstractChildren"


    // $ANTLR start "ruleAbstractChildren"
    // PsiInternalPartialParserTestLanguage.g:313:1: ruleAbstractChildren : (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) ;
    public final void ruleAbstractChildren() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:313:21: ( (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:314:2: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:314:2: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            // PsiInternalPartialParserTestLanguage.g:315:3: otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}'
            {

            			markLeaf(elementTypeProvider.getAbstractChildren_AbstractChildrenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getAbstractChildren_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalPartialParserTestLanguage.g:329:3: ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+
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
            	    // PsiInternalPartialParserTestLanguage.g:330:4: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:330:4: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    // PsiInternalPartialParserTestLanguage.g:331:5: lv_abstractChildren_2_0= ruleAbstractChild
            	    {

            	    					markComposite(elementTypeProvider.getAbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_13);
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
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // PsiInternalPartialParserTestLanguage.g:351:1: entryRuleAbstractChild : ruleAbstractChild EOF ;
    public final void entryRuleAbstractChild() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:351:23: ( ruleAbstractChild EOF )
            // PsiInternalPartialParserTestLanguage.g:352:2: ruleAbstractChild EOF
            {
             markComposite(elementTypeProvider.getAbstractChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractChild();

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
    // $ANTLR end "entryRuleAbstractChild"


    // $ANTLR start "ruleAbstractChild"
    // PsiInternalPartialParserTestLanguage.g:357:1: ruleAbstractChild : ( ruleFirstConcrete | ruleSecondConcrete ) ;
    public final void ruleAbstractChild() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:357:18: ( ( ruleFirstConcrete | ruleSecondConcrete ) )
            // PsiInternalPartialParserTestLanguage.g:358:2: ( ruleFirstConcrete | ruleSecondConcrete )
            {
            // PsiInternalPartialParserTestLanguage.g:358:2: ( ruleFirstConcrete | ruleSecondConcrete )
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
                    // PsiInternalPartialParserTestLanguage.g:359:3: ruleFirstConcrete
                    {

                    			markComposite(elementTypeProvider.getAbstractChild_FirstConcreteParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFirstConcrete();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalPartialParserTestLanguage.g:367:3: ruleSecondConcrete
                    {

                    			markComposite(elementTypeProvider.getAbstractChild_SecondConcreteParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalPartialParserTestLanguage.g:378:1: entryRuleFirstConcrete : ruleFirstConcrete EOF ;
    public final void entryRuleFirstConcrete() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:378:23: ( ruleFirstConcrete EOF )
            // PsiInternalPartialParserTestLanguage.g:379:2: ruleFirstConcrete EOF
            {
             markComposite(elementTypeProvider.getFirstConcreteElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFirstConcrete();

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
    // $ANTLR end "entryRuleFirstConcrete"


    // $ANTLR start "ruleFirstConcrete"
    // PsiInternalPartialParserTestLanguage.g:384:1: ruleFirstConcrete : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) ;
    public final void ruleFirstConcrete() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:384:18: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) )
            // PsiInternalPartialParserTestLanguage.g:385:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            {
            // PsiInternalPartialParserTestLanguage.g:385:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            // PsiInternalPartialParserTestLanguage.g:386:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')'
            {

            			markLeaf(elementTypeProvider.getFirstConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_14); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getFirstConcrete_FKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getFirstConcrete_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalPartialParserTestLanguage.g:407:3: ( (lv_value_3_0= ruleNamed ) )
            // PsiInternalPartialParserTestLanguage.g:408:4: (lv_value_3_0= ruleNamed )
            {
            // PsiInternalPartialParserTestLanguage.g:408:4: (lv_value_3_0= ruleNamed )
            // PsiInternalPartialParserTestLanguage.g:409:5: lv_value_3_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getFirstConcrete_ValueNamedParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_15);
            ruleNamed();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalPartialParserTestLanguage.g:418:3: ( (otherlv_4= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalPartialParserTestLanguage.g:419:4: (otherlv_4= RULE_ID )
                    {
                    // PsiInternalPartialParserTestLanguage.g:419:4: (otherlv_4= RULE_ID )
                    // PsiInternalPartialParserTestLanguage.g:420:5: otherlv_4= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getFirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0ElementType());
                    				
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    					doneLeaf(otherlv_4);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getFirstConcrete_RightParenthesisKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_2); 

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
    // PsiInternalPartialParserTestLanguage.g:440:1: entryRuleSecondConcrete : ruleSecondConcrete EOF ;
    public final void entryRuleSecondConcrete() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:440:24: ( ruleSecondConcrete EOF )
            // PsiInternalPartialParserTestLanguage.g:441:2: ruleSecondConcrete EOF
            {
             markComposite(elementTypeProvider.getSecondConcreteElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSecondConcrete();

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
    // $ANTLR end "entryRuleSecondConcrete"


    // $ANTLR start "ruleSecondConcrete"
    // PsiInternalPartialParserTestLanguage.g:446:1: ruleSecondConcrete : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) ;
    public final void ruleSecondConcrete() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:446:19: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) )
            // PsiInternalPartialParserTestLanguage.g:447:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            {
            // PsiInternalPartialParserTestLanguage.g:447:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            // PsiInternalPartialParserTestLanguage.g:448:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')'
            {

            			markLeaf(elementTypeProvider.getSecondConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_14); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getSecondConcrete_FKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getSecondConcrete_SKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_2);
            		

            			markLeaf(elementTypeProvider.getSecondConcrete_LeftParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalPartialParserTestLanguage.g:476:3: ( (lv_value_4_0= ruleNamed ) )
            // PsiInternalPartialParserTestLanguage.g:477:4: (lv_value_4_0= ruleNamed )
            {
            // PsiInternalPartialParserTestLanguage.g:477:4: (lv_value_4_0= ruleNamed )
            // PsiInternalPartialParserTestLanguage.g:478:5: lv_value_4_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getSecondConcrete_ValueNamedParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_15);
            ruleNamed();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalPartialParserTestLanguage.g:487:3: ( (otherlv_5= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalPartialParserTestLanguage.g:488:4: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalPartialParserTestLanguage.g:488:4: (otherlv_5= RULE_ID )
                    // PsiInternalPartialParserTestLanguage.g:489:5: otherlv_5= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getSecondConcrete_ReferencedChildrenChildCrossReference_5_0ElementType());
                    				
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    					doneLeaf(otherlv_5);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getSecondConcrete_RightParenthesisKeyword_6ElementType());
            		
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_2); 

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
    // PsiInternalPartialParserTestLanguage.g:509:1: entryRuleNamed : ruleNamed EOF ;
    public final void entryRuleNamed() throws RecognitionException {
        try {
            // PsiInternalPartialParserTestLanguage.g:509:15: ( ruleNamed EOF )
            // PsiInternalPartialParserTestLanguage.g:510:2: ruleNamed EOF
            {
             markComposite(elementTypeProvider.getNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamed();

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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // PsiInternalPartialParserTestLanguage.g:515:1: ruleNamed : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleNamed() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:515:10: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalPartialParserTestLanguage.g:516:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalPartialParserTestLanguage.g:516:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalPartialParserTestLanguage.g:517:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalPartialParserTestLanguage.g:517:3: (lv_name_0_0= RULE_ID )
            // PsiInternalPartialParserTestLanguage.g:518:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getNamed_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000022000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    }


}