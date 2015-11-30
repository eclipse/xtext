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
    // PsiInternalPartialParserTestLanguage.g:52:1: entryRuleSomeContainer returns [Boolean current=false] : iv_ruleSomeContainer= ruleSomeContainer EOF ;
    public final Boolean entryRuleSomeContainer() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSomeContainer = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:52:55: (iv_ruleSomeContainer= ruleSomeContainer EOF )
            // PsiInternalPartialParserTestLanguage.g:53:2: iv_ruleSomeContainer= ruleSomeContainer EOF
            {
             markComposite(elementTypeProvider.getSomeContainerElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSomeContainer=ruleSomeContainer();

            state._fsp--;

             current =iv_ruleSomeContainer; 
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
    // $ANTLR end "entryRuleSomeContainer"


    // $ANTLR start "ruleSomeContainer"
    // PsiInternalPartialParserTestLanguage.g:59:1: ruleSomeContainer returns [Boolean current=false] : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) ;
    public final Boolean ruleSomeContainer() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Boolean lv_nested_3_0 = null;

        Boolean lv_content_4_0 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:60:1: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:61:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:61:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            // PsiInternalPartialParserTestLanguage.g:62:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getSomeContainer_ContainerKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalPartialParserTestLanguage.g:69:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalPartialParserTestLanguage.g:70:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalPartialParserTestLanguage.g:70:4: (lv_name_1_0= RULE_ID )
            // PsiInternalPartialParserTestLanguage.g:71:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSomeContainer_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSomeContainer_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalPartialParserTestLanguage.g:93:3: ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )*
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
            	    // PsiInternalPartialParserTestLanguage.g:94:4: ( (lv_nested_3_0= ruleNested ) )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:94:4: ( (lv_nested_3_0= ruleNested ) )
            	    // PsiInternalPartialParserTestLanguage.g:95:5: (lv_nested_3_0= ruleNested )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:95:5: (lv_nested_3_0= ruleNested )
            	    // PsiInternalPartialParserTestLanguage.g:96:6: lv_nested_3_0= ruleNested
            	    {

            	    						markComposite(elementTypeProvider.getSomeContainer_NestedNestedParserRuleCall_3_0_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_nested_3_0=ruleNested();

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
            	case 2 :
            	    // PsiInternalPartialParserTestLanguage.g:110:4: ( (lv_content_4_0= ruleContent ) )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:110:4: ( (lv_content_4_0= ruleContent ) )
            	    // PsiInternalPartialParserTestLanguage.g:111:5: (lv_content_4_0= ruleContent )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:111:5: (lv_content_4_0= ruleContent )
            	    // PsiInternalPartialParserTestLanguage.g:112:6: lv_content_4_0= ruleContent
            	    {

            	    						markComposite(elementTypeProvider.getSomeContainer_ContentContentParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_content_4_0=ruleContent();

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
        return current;
    }
    // $ANTLR end "ruleSomeContainer"


    // $ANTLR start "entryRuleNested"
    // PsiInternalPartialParserTestLanguage.g:137:1: entryRuleNested returns [Boolean current=false] : iv_ruleNested= ruleNested EOF ;
    public final Boolean entryRuleNested() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNested = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:137:48: (iv_ruleNested= ruleNested EOF )
            // PsiInternalPartialParserTestLanguage.g:138:2: iv_ruleNested= ruleNested EOF
            {
             markComposite(elementTypeProvider.getNestedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNested=ruleNested();

            state._fsp--;

             current =iv_ruleNested; 
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
    // $ANTLR end "entryRuleNested"


    // $ANTLR start "ruleNested"
    // PsiInternalPartialParserTestLanguage.g:144:1: ruleNested returns [Boolean current=false] : (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) ;
    public final Boolean ruleNested() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_nested_2_0 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:145:1: ( (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:146:2: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:146:2: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            // PsiInternalPartialParserTestLanguage.g:147:3: otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}'
            {

            			markLeaf(elementTypeProvider.getNested_NestedKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getNested_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalPartialParserTestLanguage.g:161:3: ( (lv_nested_2_0= ruleSomeContainer ) )+
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
            	    // PsiInternalPartialParserTestLanguage.g:162:4: (lv_nested_2_0= ruleSomeContainer )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:162:4: (lv_nested_2_0= ruleSomeContainer )
            	    // PsiInternalPartialParserTestLanguage.g:163:5: lv_nested_2_0= ruleSomeContainer
            	    {

            	    					markComposite(elementTypeProvider.getNested_NestedSomeContainerParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_nested_2_0=ruleSomeContainer();

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
        return current;
    }
    // $ANTLR end "ruleNested"


    // $ANTLR start "entryRuleContent"
    // PsiInternalPartialParserTestLanguage.g:187:1: entryRuleContent returns [Boolean current=false] : iv_ruleContent= ruleContent EOF ;
    public final Boolean entryRuleContent() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleContent = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:187:49: (iv_ruleContent= ruleContent EOF )
            // PsiInternalPartialParserTestLanguage.g:188:2: iv_ruleContent= ruleContent EOF
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
    // PsiInternalPartialParserTestLanguage.g:194:1: ruleContent returns [Boolean current=false] : (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) ;
    public final Boolean ruleContent() throws RecognitionException {
        Boolean current = false;

        Boolean this_Children_0 = null;

        Boolean this_AbstractChildren_1 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:195:1: ( (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) )
            // PsiInternalPartialParserTestLanguage.g:196:2: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
            {
            // PsiInternalPartialParserTestLanguage.g:196:2: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
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
                    // PsiInternalPartialParserTestLanguage.g:197:3: this_Children_0= ruleChildren
                    {

                    			markComposite(elementTypeProvider.getContent_ChildrenParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Children_0=ruleChildren();

                    state._fsp--;


                    			current = this_Children_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalPartialParserTestLanguage.g:206:3: this_AbstractChildren_1= ruleAbstractChildren
                    {

                    			markComposite(elementTypeProvider.getContent_AbstractChildrenParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AbstractChildren_1=ruleAbstractChildren();

                    state._fsp--;


                    			current = this_AbstractChildren_1;
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
        return current;
    }
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleChildren"
    // PsiInternalPartialParserTestLanguage.g:218:1: entryRuleChildren returns [Boolean current=false] : iv_ruleChildren= ruleChildren EOF ;
    public final Boolean entryRuleChildren() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChildren = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:218:50: (iv_ruleChildren= ruleChildren EOF )
            // PsiInternalPartialParserTestLanguage.g:219:2: iv_ruleChildren= ruleChildren EOF
            {
             markComposite(elementTypeProvider.getChildrenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChildren=ruleChildren();

            state._fsp--;

             current =iv_ruleChildren; 
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
    // $ANTLR end "entryRuleChildren"


    // $ANTLR start "ruleChildren"
    // PsiInternalPartialParserTestLanguage.g:225:1: ruleChildren returns [Boolean current=false] : (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) ;
    public final Boolean ruleChildren() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean lv_children_2_0 = null;

        Boolean lv_children_4_0 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:226:1: ( (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:227:2: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:227:2: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            // PsiInternalPartialParserTestLanguage.g:228:3: otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getChildren_ChildrenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getChildren_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalPartialParserTestLanguage.g:242:3: ( (lv_children_2_0= ruleChild ) )
            // PsiInternalPartialParserTestLanguage.g:243:4: (lv_children_2_0= ruleChild )
            {
            // PsiInternalPartialParserTestLanguage.g:243:4: (lv_children_2_0= ruleChild )
            // PsiInternalPartialParserTestLanguage.g:244:5: lv_children_2_0= ruleChild
            {

            					markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            lv_children_2_0=ruleChild();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalPartialParserTestLanguage.g:257:3: (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalPartialParserTestLanguage.g:258:4: otherlv_3= ',' ( (lv_children_4_0= ruleChild ) )
            	    {

            	    				markLeaf(elementTypeProvider.getChildren_CommaKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_8); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalPartialParserTestLanguage.g:265:4: ( (lv_children_4_0= ruleChild ) )
            	    // PsiInternalPartialParserTestLanguage.g:266:5: (lv_children_4_0= ruleChild )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:266:5: (lv_children_4_0= ruleChild )
            	    // PsiInternalPartialParserTestLanguage.g:267:6: lv_children_4_0= ruleChild
            	    {

            	    						markComposite(elementTypeProvider.getChildren_ChildrenChildParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    lv_children_4_0=ruleChild();

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
        return current;
    }
    // $ANTLR end "ruleChildren"


    // $ANTLR start "entryRuleChild"
    // PsiInternalPartialParserTestLanguage.g:292:1: entryRuleChild returns [Boolean current=false] : iv_ruleChild= ruleChild EOF ;
    public final Boolean entryRuleChild() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChild = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:292:47: (iv_ruleChild= ruleChild EOF )
            // PsiInternalPartialParserTestLanguage.g:293:2: iv_ruleChild= ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChild=ruleChild();

            state._fsp--;

             current =iv_ruleChild; 
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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // PsiInternalPartialParserTestLanguage.g:299:1: ruleChild returns [Boolean current=false] : (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) ;
    public final Boolean ruleChild() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_value_3_0 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:300:1: ( (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) )
            // PsiInternalPartialParserTestLanguage.g:301:2: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            {
            // PsiInternalPartialParserTestLanguage.g:301:2: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            // PsiInternalPartialParserTestLanguage.g:302:3: otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')'
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
            		
            // PsiInternalPartialParserTestLanguage.g:323:3: ( (lv_value_3_0= ruleNamed ) )
            // PsiInternalPartialParserTestLanguage.g:324:4: (lv_value_3_0= ruleNamed )
            {
            // PsiInternalPartialParserTestLanguage.g:324:4: (lv_value_3_0= ruleNamed )
            // PsiInternalPartialParserTestLanguage.g:325:5: lv_value_3_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getChild_ValueNamedParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_12);
            lv_value_3_0=ruleNamed();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleAbstractChildren"
    // PsiInternalPartialParserTestLanguage.g:349:1: entryRuleAbstractChildren returns [Boolean current=false] : iv_ruleAbstractChildren= ruleAbstractChildren EOF ;
    public final Boolean entryRuleAbstractChildren() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractChildren = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:349:58: (iv_ruleAbstractChildren= ruleAbstractChildren EOF )
            // PsiInternalPartialParserTestLanguage.g:350:2: iv_ruleAbstractChildren= ruleAbstractChildren EOF
            {
             markComposite(elementTypeProvider.getAbstractChildrenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractChildren=ruleAbstractChildren();

            state._fsp--;

             current =iv_ruleAbstractChildren; 
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
    // $ANTLR end "entryRuleAbstractChildren"


    // $ANTLR start "ruleAbstractChildren"
    // PsiInternalPartialParserTestLanguage.g:356:1: ruleAbstractChildren returns [Boolean current=false] : (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) ;
    public final Boolean ruleAbstractChildren() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_abstractChildren_2_0 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:357:1: ( (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) )
            // PsiInternalPartialParserTestLanguage.g:358:2: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            {
            // PsiInternalPartialParserTestLanguage.g:358:2: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            // PsiInternalPartialParserTestLanguage.g:359:3: otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}'
            {

            			markLeaf(elementTypeProvider.getAbstractChildren_AbstractChildrenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getAbstractChildren_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalPartialParserTestLanguage.g:373:3: ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+
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
            	    // PsiInternalPartialParserTestLanguage.g:374:4: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    {
            	    // PsiInternalPartialParserTestLanguage.g:374:4: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    // PsiInternalPartialParserTestLanguage.g:375:5: lv_abstractChildren_2_0= ruleAbstractChild
            	    {

            	    					markComposite(elementTypeProvider.getAbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_abstractChildren_2_0=ruleAbstractChild();

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
        return current;
    }
    // $ANTLR end "ruleAbstractChildren"


    // $ANTLR start "entryRuleAbstractChild"
    // PsiInternalPartialParserTestLanguage.g:399:1: entryRuleAbstractChild returns [Boolean current=false] : iv_ruleAbstractChild= ruleAbstractChild EOF ;
    public final Boolean entryRuleAbstractChild() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractChild = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:399:55: (iv_ruleAbstractChild= ruleAbstractChild EOF )
            // PsiInternalPartialParserTestLanguage.g:400:2: iv_ruleAbstractChild= ruleAbstractChild EOF
            {
             markComposite(elementTypeProvider.getAbstractChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractChild=ruleAbstractChild();

            state._fsp--;

             current =iv_ruleAbstractChild; 
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
    // $ANTLR end "entryRuleAbstractChild"


    // $ANTLR start "ruleAbstractChild"
    // PsiInternalPartialParserTestLanguage.g:406:1: ruleAbstractChild returns [Boolean current=false] : (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) ;
    public final Boolean ruleAbstractChild() throws RecognitionException {
        Boolean current = false;

        Boolean this_FirstConcrete_0 = null;

        Boolean this_SecondConcrete_1 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:407:1: ( (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) )
            // PsiInternalPartialParserTestLanguage.g:408:2: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
            {
            // PsiInternalPartialParserTestLanguage.g:408:2: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
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
                    // PsiInternalPartialParserTestLanguage.g:409:3: this_FirstConcrete_0= ruleFirstConcrete
                    {

                    			markComposite(elementTypeProvider.getAbstractChild_FirstConcreteParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FirstConcrete_0=ruleFirstConcrete();

                    state._fsp--;


                    			current = this_FirstConcrete_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalPartialParserTestLanguage.g:418:3: this_SecondConcrete_1= ruleSecondConcrete
                    {

                    			markComposite(elementTypeProvider.getAbstractChild_SecondConcreteParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SecondConcrete_1=ruleSecondConcrete();

                    state._fsp--;


                    			current = this_SecondConcrete_1;
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
        return current;
    }
    // $ANTLR end "ruleAbstractChild"


    // $ANTLR start "entryRuleFirstConcrete"
    // PsiInternalPartialParserTestLanguage.g:430:1: entryRuleFirstConcrete returns [Boolean current=false] : iv_ruleFirstConcrete= ruleFirstConcrete EOF ;
    public final Boolean entryRuleFirstConcrete() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFirstConcrete = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:430:55: (iv_ruleFirstConcrete= ruleFirstConcrete EOF )
            // PsiInternalPartialParserTestLanguage.g:431:2: iv_ruleFirstConcrete= ruleFirstConcrete EOF
            {
             markComposite(elementTypeProvider.getFirstConcreteElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFirstConcrete=ruleFirstConcrete();

            state._fsp--;

             current =iv_ruleFirstConcrete; 
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
    // $ANTLR end "entryRuleFirstConcrete"


    // $ANTLR start "ruleFirstConcrete"
    // PsiInternalPartialParserTestLanguage.g:437:1: ruleFirstConcrete returns [Boolean current=false] : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) ;
    public final Boolean ruleFirstConcrete() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Boolean lv_value_3_0 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:438:1: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) )
            // PsiInternalPartialParserTestLanguage.g:439:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            {
            // PsiInternalPartialParserTestLanguage.g:439:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            // PsiInternalPartialParserTestLanguage.g:440:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')'
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
            		
            // PsiInternalPartialParserTestLanguage.g:461:3: ( (lv_value_3_0= ruleNamed ) )
            // PsiInternalPartialParserTestLanguage.g:462:4: (lv_value_3_0= ruleNamed )
            {
            // PsiInternalPartialParserTestLanguage.g:462:4: (lv_value_3_0= ruleNamed )
            // PsiInternalPartialParserTestLanguage.g:463:5: lv_value_3_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getFirstConcrete_ValueNamedParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_15);
            lv_value_3_0=ruleNamed();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalPartialParserTestLanguage.g:476:3: ( (otherlv_4= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalPartialParserTestLanguage.g:477:4: (otherlv_4= RULE_ID )
                    {
                    // PsiInternalPartialParserTestLanguage.g:477:4: (otherlv_4= RULE_ID )
                    // PsiInternalPartialParserTestLanguage.g:478:5: otherlv_4= RULE_ID
                    {

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
    }
    // $ANTLR end "ruleFirstConcrete"


    // $ANTLR start "entryRuleSecondConcrete"
    // PsiInternalPartialParserTestLanguage.g:504:1: entryRuleSecondConcrete returns [Boolean current=false] : iv_ruleSecondConcrete= ruleSecondConcrete EOF ;
    public final Boolean entryRuleSecondConcrete() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSecondConcrete = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:504:56: (iv_ruleSecondConcrete= ruleSecondConcrete EOF )
            // PsiInternalPartialParserTestLanguage.g:505:2: iv_ruleSecondConcrete= ruleSecondConcrete EOF
            {
             markComposite(elementTypeProvider.getSecondConcreteElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSecondConcrete=ruleSecondConcrete();

            state._fsp--;

             current =iv_ruleSecondConcrete; 
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
    // $ANTLR end "entryRuleSecondConcrete"


    // $ANTLR start "ruleSecondConcrete"
    // PsiInternalPartialParserTestLanguage.g:511:1: ruleSecondConcrete returns [Boolean current=false] : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) ;
    public final Boolean ruleSecondConcrete() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Boolean lv_value_4_0 = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:512:1: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) )
            // PsiInternalPartialParserTestLanguage.g:513:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            {
            // PsiInternalPartialParserTestLanguage.g:513:2: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            // PsiInternalPartialParserTestLanguage.g:514:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')'
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
            		
            // PsiInternalPartialParserTestLanguage.g:542:3: ( (lv_value_4_0= ruleNamed ) )
            // PsiInternalPartialParserTestLanguage.g:543:4: (lv_value_4_0= ruleNamed )
            {
            // PsiInternalPartialParserTestLanguage.g:543:4: (lv_value_4_0= ruleNamed )
            // PsiInternalPartialParserTestLanguage.g:544:5: lv_value_4_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getSecondConcrete_ValueNamedParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_15);
            lv_value_4_0=ruleNamed();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalPartialParserTestLanguage.g:557:3: ( (otherlv_5= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalPartialParserTestLanguage.g:558:4: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalPartialParserTestLanguage.g:558:4: (otherlv_5= RULE_ID )
                    // PsiInternalPartialParserTestLanguage.g:559:5: otherlv_5= RULE_ID
                    {

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
    }
    // $ANTLR end "ruleSecondConcrete"


    // $ANTLR start "entryRuleNamed"
    // PsiInternalPartialParserTestLanguage.g:585:1: entryRuleNamed returns [Boolean current=false] : iv_ruleNamed= ruleNamed EOF ;
    public final Boolean entryRuleNamed() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamed = null;


        try {
            // PsiInternalPartialParserTestLanguage.g:585:47: (iv_ruleNamed= ruleNamed EOF )
            // PsiInternalPartialParserTestLanguage.g:586:2: iv_ruleNamed= ruleNamed EOF
            {
             markComposite(elementTypeProvider.getNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamed=ruleNamed();

            state._fsp--;

             current =iv_ruleNamed; 
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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // PsiInternalPartialParserTestLanguage.g:592:1: ruleNamed returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleNamed() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalPartialParserTestLanguage.g:593:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalPartialParserTestLanguage.g:594:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalPartialParserTestLanguage.g:594:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalPartialParserTestLanguage.g:595:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalPartialParserTestLanguage.g:595:3: (lv_name_0_0= RULE_ID )
            // PsiInternalPartialParserTestLanguage.g:596:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getNamed_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

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
        return current;
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