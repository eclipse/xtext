package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ide.tests.testlanguage.services.IndentationAwareUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIndentationAwareUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_COMMENT", "RULE_INDENT", "RULE_DEDENT", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_DEDENT=6;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SL_COMMENT=4;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_INDENT=5;

    // delegates
    // delegators


        public InternalIndentationAwareUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIndentationAwareUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIndentationAwareUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIndentationAwareUiTestLanguageParser.g"; }


    	private IndentationAwareUiTestLanguageGrammarAccess grammarAccess;
    	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
    	
    	{
    	}

    	public void setGrammarAccess(IndentationAwareUiTestLanguageGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		String result = tokenNameToValue.get(tokenName);
    		if (result == null)
    			result = tokenName;
    		return result;
    	}



    // $ANTLR start "entryRuleTree"
    // InternalIndentationAwareUiTestLanguageParser.g:60:1: entryRuleTree : ruleTree EOF ;
    public final void entryRuleTree() throws RecognitionException {
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:61:1: ( ruleTree EOF )
            // InternalIndentationAwareUiTestLanguageParser.g:62:1: ruleTree EOF
            {
             before(grammarAccess.getTreeRule()); 
            pushFollow(FOLLOW_1);
            ruleTree();

            state._fsp--;

             after(grammarAccess.getTreeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTree"


    // $ANTLR start "ruleTree"
    // InternalIndentationAwareUiTestLanguageParser.g:69:1: ruleTree : ( ( rule__Tree__Group__0 ) ) ;
    public final void ruleTree() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:73:2: ( ( ( rule__Tree__Group__0 ) ) )
            // InternalIndentationAwareUiTestLanguageParser.g:74:2: ( ( rule__Tree__Group__0 ) )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:74:2: ( ( rule__Tree__Group__0 ) )
            // InternalIndentationAwareUiTestLanguageParser.g:75:3: ( rule__Tree__Group__0 )
            {
             before(grammarAccess.getTreeAccess().getGroup()); 
            // InternalIndentationAwareUiTestLanguageParser.g:76:3: ( rule__Tree__Group__0 )
            // InternalIndentationAwareUiTestLanguageParser.g:76:4: rule__Tree__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTreeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTree"


    // $ANTLR start "entryRuleTreeNode"
    // InternalIndentationAwareUiTestLanguageParser.g:85:1: entryRuleTreeNode : ruleTreeNode EOF ;
    public final void entryRuleTreeNode() throws RecognitionException {
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:86:1: ( ruleTreeNode EOF )
            // InternalIndentationAwareUiTestLanguageParser.g:87:1: ruleTreeNode EOF
            {
             before(grammarAccess.getTreeNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeNodeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTreeNode"


    // $ANTLR start "ruleTreeNode"
    // InternalIndentationAwareUiTestLanguageParser.g:94:1: ruleTreeNode : ( ( rule__TreeNode__Group__0 ) ) ;
    public final void ruleTreeNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:98:2: ( ( ( rule__TreeNode__Group__0 ) ) )
            // InternalIndentationAwareUiTestLanguageParser.g:99:2: ( ( rule__TreeNode__Group__0 ) )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:99:2: ( ( rule__TreeNode__Group__0 ) )
            // InternalIndentationAwareUiTestLanguageParser.g:100:3: ( rule__TreeNode__Group__0 )
            {
             before(grammarAccess.getTreeNodeAccess().getGroup()); 
            // InternalIndentationAwareUiTestLanguageParser.g:101:3: ( rule__TreeNode__Group__0 )
            // InternalIndentationAwareUiTestLanguageParser.g:101:4: rule__TreeNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTreeNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTreeNode"


    // $ANTLR start "entryRuleOtherTreeNode"
    // InternalIndentationAwareUiTestLanguageParser.g:110:1: entryRuleOtherTreeNode : ruleOtherTreeNode EOF ;
    public final void entryRuleOtherTreeNode() throws RecognitionException {
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:111:1: ( ruleOtherTreeNode EOF )
            // InternalIndentationAwareUiTestLanguageParser.g:112:1: ruleOtherTreeNode EOF
            {
             before(grammarAccess.getOtherTreeNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleOtherTreeNode();

            state._fsp--;

             after(grammarAccess.getOtherTreeNodeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOtherTreeNode"


    // $ANTLR start "ruleOtherTreeNode"
    // InternalIndentationAwareUiTestLanguageParser.g:119:1: ruleOtherTreeNode : ( ( rule__OtherTreeNode__Group__0 ) ) ;
    public final void ruleOtherTreeNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:123:2: ( ( ( rule__OtherTreeNode__Group__0 ) ) )
            // InternalIndentationAwareUiTestLanguageParser.g:124:2: ( ( rule__OtherTreeNode__Group__0 ) )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:124:2: ( ( rule__OtherTreeNode__Group__0 ) )
            // InternalIndentationAwareUiTestLanguageParser.g:125:3: ( rule__OtherTreeNode__Group__0 )
            {
             before(grammarAccess.getOtherTreeNodeAccess().getGroup()); 
            // InternalIndentationAwareUiTestLanguageParser.g:126:3: ( rule__OtherTreeNode__Group__0 )
            // InternalIndentationAwareUiTestLanguageParser.g:126:4: rule__OtherTreeNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OtherTreeNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOtherTreeNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOtherTreeNode"


    // $ANTLR start "entryRuleChildList"
    // InternalIndentationAwareUiTestLanguageParser.g:135:1: entryRuleChildList : ruleChildList EOF ;
    public final void entryRuleChildList() throws RecognitionException {
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:136:1: ( ruleChildList EOF )
            // InternalIndentationAwareUiTestLanguageParser.g:137:1: ruleChildList EOF
            {
             before(grammarAccess.getChildListRule()); 
            pushFollow(FOLLOW_1);
            ruleChildList();

            state._fsp--;

             after(grammarAccess.getChildListRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleChildList"


    // $ANTLR start "ruleChildList"
    // InternalIndentationAwareUiTestLanguageParser.g:144:1: ruleChildList : ( ( rule__ChildList__Group__0 ) ) ;
    public final void ruleChildList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:148:2: ( ( ( rule__ChildList__Group__0 ) ) )
            // InternalIndentationAwareUiTestLanguageParser.g:149:2: ( ( rule__ChildList__Group__0 ) )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:149:2: ( ( rule__ChildList__Group__0 ) )
            // InternalIndentationAwareUiTestLanguageParser.g:150:3: ( rule__ChildList__Group__0 )
            {
             before(grammarAccess.getChildListAccess().getGroup()); 
            // InternalIndentationAwareUiTestLanguageParser.g:151:3: ( rule__ChildList__Group__0 )
            // InternalIndentationAwareUiTestLanguageParser.g:151:4: rule__ChildList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ChildList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChildListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChildList"


    // $ANTLR start "rule__Tree__Group__0"
    // InternalIndentationAwareUiTestLanguageParser.g:159:1: rule__Tree__Group__0 : rule__Tree__Group__0__Impl rule__Tree__Group__1 ;
    public final void rule__Tree__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:163:1: ( rule__Tree__Group__0__Impl rule__Tree__Group__1 )
            // InternalIndentationAwareUiTestLanguageParser.g:164:2: rule__Tree__Group__0__Impl rule__Tree__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Tree__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group__0"


    // $ANTLR start "rule__Tree__Group__0__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:171:1: rule__Tree__Group__0__Impl : ( () ) ;
    public final void rule__Tree__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:175:1: ( ( () ) )
            // InternalIndentationAwareUiTestLanguageParser.g:176:1: ( () )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:176:1: ( () )
            // InternalIndentationAwareUiTestLanguageParser.g:177:2: ()
            {
             before(grammarAccess.getTreeAccess().getTreeAction_0()); 
            // InternalIndentationAwareUiTestLanguageParser.g:178:2: ()
            // InternalIndentationAwareUiTestLanguageParser.g:178:3: 
            {
            }

             after(grammarAccess.getTreeAccess().getTreeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group__0__Impl"


    // $ANTLR start "rule__Tree__Group__1"
    // InternalIndentationAwareUiTestLanguageParser.g:186:1: rule__Tree__Group__1 : rule__Tree__Group__1__Impl rule__Tree__Group__2 ;
    public final void rule__Tree__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:190:1: ( rule__Tree__Group__1__Impl rule__Tree__Group__2 )
            // InternalIndentationAwareUiTestLanguageParser.g:191:2: rule__Tree__Group__1__Impl rule__Tree__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Tree__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group__1"


    // $ANTLR start "rule__Tree__Group__1__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:198:1: rule__Tree__Group__1__Impl : ( ( rule__Tree__NodesAssignment_1 )* ) ;
    public final void rule__Tree__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:202:1: ( ( ( rule__Tree__NodesAssignment_1 )* ) )
            // InternalIndentationAwareUiTestLanguageParser.g:203:1: ( ( rule__Tree__NodesAssignment_1 )* )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:203:1: ( ( rule__Tree__NodesAssignment_1 )* )
            // InternalIndentationAwareUiTestLanguageParser.g:204:2: ( rule__Tree__NodesAssignment_1 )*
            {
             before(grammarAccess.getTreeAccess().getNodesAssignment_1()); 
            // InternalIndentationAwareUiTestLanguageParser.g:205:2: ( rule__Tree__NodesAssignment_1 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIndentationAwareUiTestLanguageParser.g:205:3: rule__Tree__NodesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Tree__NodesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getTreeAccess().getNodesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group__1__Impl"


    // $ANTLR start "rule__Tree__Group__2"
    // InternalIndentationAwareUiTestLanguageParser.g:213:1: rule__Tree__Group__2 : rule__Tree__Group__2__Impl ;
    public final void rule__Tree__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:217:1: ( rule__Tree__Group__2__Impl )
            // InternalIndentationAwareUiTestLanguageParser.g:218:2: rule__Tree__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group__2"


    // $ANTLR start "rule__Tree__Group__2__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:224:1: rule__Tree__Group__2__Impl : ( ( rule__Tree__MoreNodesAssignment_2 )* ) ;
    public final void rule__Tree__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:228:1: ( ( ( rule__Tree__MoreNodesAssignment_2 )* ) )
            // InternalIndentationAwareUiTestLanguageParser.g:229:1: ( ( rule__Tree__MoreNodesAssignment_2 )* )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:229:1: ( ( rule__Tree__MoreNodesAssignment_2 )* )
            // InternalIndentationAwareUiTestLanguageParser.g:230:2: ( rule__Tree__MoreNodesAssignment_2 )*
            {
             before(grammarAccess.getTreeAccess().getMoreNodesAssignment_2()); 
            // InternalIndentationAwareUiTestLanguageParser.g:231:2: ( rule__Tree__MoreNodesAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_STRING) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalIndentationAwareUiTestLanguageParser.g:231:3: rule__Tree__MoreNodesAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Tree__MoreNodesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTreeAccess().getMoreNodesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group__2__Impl"


    // $ANTLR start "rule__TreeNode__Group__0"
    // InternalIndentationAwareUiTestLanguageParser.g:240:1: rule__TreeNode__Group__0 : rule__TreeNode__Group__0__Impl rule__TreeNode__Group__1 ;
    public final void rule__TreeNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:244:1: ( rule__TreeNode__Group__0__Impl rule__TreeNode__Group__1 )
            // InternalIndentationAwareUiTestLanguageParser.g:245:2: rule__TreeNode__Group__0__Impl rule__TreeNode__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__TreeNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__0"


    // $ANTLR start "rule__TreeNode__Group__0__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:252:1: rule__TreeNode__Group__0__Impl : ( ( rule__TreeNode__NameAssignment_0 ) ) ;
    public final void rule__TreeNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:256:1: ( ( ( rule__TreeNode__NameAssignment_0 ) ) )
            // InternalIndentationAwareUiTestLanguageParser.g:257:1: ( ( rule__TreeNode__NameAssignment_0 ) )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:257:1: ( ( rule__TreeNode__NameAssignment_0 ) )
            // InternalIndentationAwareUiTestLanguageParser.g:258:2: ( rule__TreeNode__NameAssignment_0 )
            {
             before(grammarAccess.getTreeNodeAccess().getNameAssignment_0()); 
            // InternalIndentationAwareUiTestLanguageParser.g:259:2: ( rule__TreeNode__NameAssignment_0 )
            // InternalIndentationAwareUiTestLanguageParser.g:259:3: rule__TreeNode__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTreeNodeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__0__Impl"


    // $ANTLR start "rule__TreeNode__Group__1"
    // InternalIndentationAwareUiTestLanguageParser.g:267:1: rule__TreeNode__Group__1 : rule__TreeNode__Group__1__Impl ;
    public final void rule__TreeNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:271:1: ( rule__TreeNode__Group__1__Impl )
            // InternalIndentationAwareUiTestLanguageParser.g:272:2: rule__TreeNode__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__1"


    // $ANTLR start "rule__TreeNode__Group__1__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:278:1: rule__TreeNode__Group__1__Impl : ( ( rule__TreeNode__Group_1__0 )? ) ;
    public final void rule__TreeNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:282:1: ( ( ( rule__TreeNode__Group_1__0 )? ) )
            // InternalIndentationAwareUiTestLanguageParser.g:283:1: ( ( rule__TreeNode__Group_1__0 )? )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:283:1: ( ( rule__TreeNode__Group_1__0 )? )
            // InternalIndentationAwareUiTestLanguageParser.g:284:2: ( rule__TreeNode__Group_1__0 )?
            {
             before(grammarAccess.getTreeNodeAccess().getGroup_1()); 
            // InternalIndentationAwareUiTestLanguageParser.g:285:2: ( rule__TreeNode__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INDENT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalIndentationAwareUiTestLanguageParser.g:285:3: rule__TreeNode__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TreeNode__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTreeNodeAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__1__Impl"


    // $ANTLR start "rule__TreeNode__Group_1__0"
    // InternalIndentationAwareUiTestLanguageParser.g:294:1: rule__TreeNode__Group_1__0 : rule__TreeNode__Group_1__0__Impl rule__TreeNode__Group_1__1 ;
    public final void rule__TreeNode__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:298:1: ( rule__TreeNode__Group_1__0__Impl rule__TreeNode__Group_1__1 )
            // InternalIndentationAwareUiTestLanguageParser.g:299:2: rule__TreeNode__Group_1__0__Impl rule__TreeNode__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TreeNode__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__0"


    // $ANTLR start "rule__TreeNode__Group_1__0__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:306:1: rule__TreeNode__Group_1__0__Impl : ( RULE_INDENT ) ;
    public final void rule__TreeNode__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:310:1: ( ( RULE_INDENT ) )
            // InternalIndentationAwareUiTestLanguageParser.g:311:1: ( RULE_INDENT )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:311:1: ( RULE_INDENT )
            // InternalIndentationAwareUiTestLanguageParser.g:312:2: RULE_INDENT
            {
             before(grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0()); 
            match(input,RULE_INDENT,FOLLOW_2); 
             after(grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__0__Impl"


    // $ANTLR start "rule__TreeNode__Group_1__1"
    // InternalIndentationAwareUiTestLanguageParser.g:321:1: rule__TreeNode__Group_1__1 : rule__TreeNode__Group_1__1__Impl rule__TreeNode__Group_1__2 ;
    public final void rule__TreeNode__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:325:1: ( rule__TreeNode__Group_1__1__Impl rule__TreeNode__Group_1__2 )
            // InternalIndentationAwareUiTestLanguageParser.g:326:2: rule__TreeNode__Group_1__1__Impl rule__TreeNode__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__TreeNode__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__1"


    // $ANTLR start "rule__TreeNode__Group_1__1__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:333:1: rule__TreeNode__Group_1__1__Impl : ( ( rule__TreeNode__ChildrenAssignment_1_1 )* ) ;
    public final void rule__TreeNode__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:337:1: ( ( ( rule__TreeNode__ChildrenAssignment_1_1 )* ) )
            // InternalIndentationAwareUiTestLanguageParser.g:338:1: ( ( rule__TreeNode__ChildrenAssignment_1_1 )* )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:338:1: ( ( rule__TreeNode__ChildrenAssignment_1_1 )* )
            // InternalIndentationAwareUiTestLanguageParser.g:339:2: ( rule__TreeNode__ChildrenAssignment_1_1 )*
            {
             before(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1()); 
            // InternalIndentationAwareUiTestLanguageParser.g:340:2: ( rule__TreeNode__ChildrenAssignment_1_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalIndentationAwareUiTestLanguageParser.g:340:3: rule__TreeNode__ChildrenAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__TreeNode__ChildrenAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__1__Impl"


    // $ANTLR start "rule__TreeNode__Group_1__2"
    // InternalIndentationAwareUiTestLanguageParser.g:348:1: rule__TreeNode__Group_1__2 : rule__TreeNode__Group_1__2__Impl ;
    public final void rule__TreeNode__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:352:1: ( rule__TreeNode__Group_1__2__Impl )
            // InternalIndentationAwareUiTestLanguageParser.g:353:2: rule__TreeNode__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__2"


    // $ANTLR start "rule__TreeNode__Group_1__2__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:359:1: rule__TreeNode__Group_1__2__Impl : ( RULE_DEDENT ) ;
    public final void rule__TreeNode__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:363:1: ( ( RULE_DEDENT ) )
            // InternalIndentationAwareUiTestLanguageParser.g:364:1: ( RULE_DEDENT )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:364:1: ( RULE_DEDENT )
            // InternalIndentationAwareUiTestLanguageParser.g:365:2: RULE_DEDENT
            {
             before(grammarAccess.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2()); 
            match(input,RULE_DEDENT,FOLLOW_2); 
             after(grammarAccess.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__2__Impl"


    // $ANTLR start "rule__OtherTreeNode__Group__0"
    // InternalIndentationAwareUiTestLanguageParser.g:375:1: rule__OtherTreeNode__Group__0 : rule__OtherTreeNode__Group__0__Impl rule__OtherTreeNode__Group__1 ;
    public final void rule__OtherTreeNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:379:1: ( rule__OtherTreeNode__Group__0__Impl rule__OtherTreeNode__Group__1 )
            // InternalIndentationAwareUiTestLanguageParser.g:380:2: rule__OtherTreeNode__Group__0__Impl rule__OtherTreeNode__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__OtherTreeNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OtherTreeNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OtherTreeNode__Group__0"


    // $ANTLR start "rule__OtherTreeNode__Group__0__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:387:1: rule__OtherTreeNode__Group__0__Impl : ( ( rule__OtherTreeNode__NameAssignment_0 ) ) ;
    public final void rule__OtherTreeNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:391:1: ( ( ( rule__OtherTreeNode__NameAssignment_0 ) ) )
            // InternalIndentationAwareUiTestLanguageParser.g:392:1: ( ( rule__OtherTreeNode__NameAssignment_0 ) )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:392:1: ( ( rule__OtherTreeNode__NameAssignment_0 ) )
            // InternalIndentationAwareUiTestLanguageParser.g:393:2: ( rule__OtherTreeNode__NameAssignment_0 )
            {
             before(grammarAccess.getOtherTreeNodeAccess().getNameAssignment_0()); 
            // InternalIndentationAwareUiTestLanguageParser.g:394:2: ( rule__OtherTreeNode__NameAssignment_0 )
            // InternalIndentationAwareUiTestLanguageParser.g:394:3: rule__OtherTreeNode__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OtherTreeNode__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOtherTreeNodeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OtherTreeNode__Group__0__Impl"


    // $ANTLR start "rule__OtherTreeNode__Group__1"
    // InternalIndentationAwareUiTestLanguageParser.g:402:1: rule__OtherTreeNode__Group__1 : rule__OtherTreeNode__Group__1__Impl ;
    public final void rule__OtherTreeNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:406:1: ( rule__OtherTreeNode__Group__1__Impl )
            // InternalIndentationAwareUiTestLanguageParser.g:407:2: rule__OtherTreeNode__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OtherTreeNode__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OtherTreeNode__Group__1"


    // $ANTLR start "rule__OtherTreeNode__Group__1__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:413:1: rule__OtherTreeNode__Group__1__Impl : ( ( rule__OtherTreeNode__ChildListAssignment_1 )? ) ;
    public final void rule__OtherTreeNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:417:1: ( ( ( rule__OtherTreeNode__ChildListAssignment_1 )? ) )
            // InternalIndentationAwareUiTestLanguageParser.g:418:1: ( ( rule__OtherTreeNode__ChildListAssignment_1 )? )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:418:1: ( ( rule__OtherTreeNode__ChildListAssignment_1 )? )
            // InternalIndentationAwareUiTestLanguageParser.g:419:2: ( rule__OtherTreeNode__ChildListAssignment_1 )?
            {
             before(grammarAccess.getOtherTreeNodeAccess().getChildListAssignment_1()); 
            // InternalIndentationAwareUiTestLanguageParser.g:420:2: ( rule__OtherTreeNode__ChildListAssignment_1 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INDENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalIndentationAwareUiTestLanguageParser.g:420:3: rule__OtherTreeNode__ChildListAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__OtherTreeNode__ChildListAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOtherTreeNodeAccess().getChildListAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OtherTreeNode__Group__1__Impl"


    // $ANTLR start "rule__ChildList__Group__0"
    // InternalIndentationAwareUiTestLanguageParser.g:429:1: rule__ChildList__Group__0 : rule__ChildList__Group__0__Impl rule__ChildList__Group__1 ;
    public final void rule__ChildList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:433:1: ( rule__ChildList__Group__0__Impl rule__ChildList__Group__1 )
            // InternalIndentationAwareUiTestLanguageParser.g:434:2: rule__ChildList__Group__0__Impl rule__ChildList__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__ChildList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChildList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__0"


    // $ANTLR start "rule__ChildList__Group__0__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:441:1: rule__ChildList__Group__0__Impl : ( () ) ;
    public final void rule__ChildList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:445:1: ( ( () ) )
            // InternalIndentationAwareUiTestLanguageParser.g:446:1: ( () )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:446:1: ( () )
            // InternalIndentationAwareUiTestLanguageParser.g:447:2: ()
            {
             before(grammarAccess.getChildListAccess().getChildListAction_0()); 
            // InternalIndentationAwareUiTestLanguageParser.g:448:2: ()
            // InternalIndentationAwareUiTestLanguageParser.g:448:3: 
            {
            }

             after(grammarAccess.getChildListAccess().getChildListAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__0__Impl"


    // $ANTLR start "rule__ChildList__Group__1"
    // InternalIndentationAwareUiTestLanguageParser.g:456:1: rule__ChildList__Group__1 : rule__ChildList__Group__1__Impl rule__ChildList__Group__2 ;
    public final void rule__ChildList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:460:1: ( rule__ChildList__Group__1__Impl rule__ChildList__Group__2 )
            // InternalIndentationAwareUiTestLanguageParser.g:461:2: rule__ChildList__Group__1__Impl rule__ChildList__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__ChildList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChildList__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__1"


    // $ANTLR start "rule__ChildList__Group__1__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:468:1: rule__ChildList__Group__1__Impl : ( RULE_INDENT ) ;
    public final void rule__ChildList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:472:1: ( ( RULE_INDENT ) )
            // InternalIndentationAwareUiTestLanguageParser.g:473:1: ( RULE_INDENT )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:473:1: ( RULE_INDENT )
            // InternalIndentationAwareUiTestLanguageParser.g:474:2: RULE_INDENT
            {
             before(grammarAccess.getChildListAccess().getINDENTTerminalRuleCall_1()); 
            match(input,RULE_INDENT,FOLLOW_2); 
             after(grammarAccess.getChildListAccess().getINDENTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__1__Impl"


    // $ANTLR start "rule__ChildList__Group__2"
    // InternalIndentationAwareUiTestLanguageParser.g:483:1: rule__ChildList__Group__2 : rule__ChildList__Group__2__Impl rule__ChildList__Group__3 ;
    public final void rule__ChildList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:487:1: ( rule__ChildList__Group__2__Impl rule__ChildList__Group__3 )
            // InternalIndentationAwareUiTestLanguageParser.g:488:2: rule__ChildList__Group__2__Impl rule__ChildList__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__ChildList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChildList__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__2"


    // $ANTLR start "rule__ChildList__Group__2__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:495:1: rule__ChildList__Group__2__Impl : ( ( ( rule__ChildList__ChildrenAssignment_2 ) ) ( ( rule__ChildList__ChildrenAssignment_2 )* ) ) ;
    public final void rule__ChildList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:499:1: ( ( ( ( rule__ChildList__ChildrenAssignment_2 ) ) ( ( rule__ChildList__ChildrenAssignment_2 )* ) ) )
            // InternalIndentationAwareUiTestLanguageParser.g:500:1: ( ( ( rule__ChildList__ChildrenAssignment_2 ) ) ( ( rule__ChildList__ChildrenAssignment_2 )* ) )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:500:1: ( ( ( rule__ChildList__ChildrenAssignment_2 ) ) ( ( rule__ChildList__ChildrenAssignment_2 )* ) )
            // InternalIndentationAwareUiTestLanguageParser.g:501:2: ( ( rule__ChildList__ChildrenAssignment_2 ) ) ( ( rule__ChildList__ChildrenAssignment_2 )* )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:501:2: ( ( rule__ChildList__ChildrenAssignment_2 ) )
            // InternalIndentationAwareUiTestLanguageParser.g:502:3: ( rule__ChildList__ChildrenAssignment_2 )
            {
             before(grammarAccess.getChildListAccess().getChildrenAssignment_2()); 
            // InternalIndentationAwareUiTestLanguageParser.g:503:3: ( rule__ChildList__ChildrenAssignment_2 )
            // InternalIndentationAwareUiTestLanguageParser.g:503:4: rule__ChildList__ChildrenAssignment_2
            {
            pushFollow(FOLLOW_5);
            rule__ChildList__ChildrenAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getChildListAccess().getChildrenAssignment_2()); 

            }

            // InternalIndentationAwareUiTestLanguageParser.g:506:2: ( ( rule__ChildList__ChildrenAssignment_2 )* )
            // InternalIndentationAwareUiTestLanguageParser.g:507:3: ( rule__ChildList__ChildrenAssignment_2 )*
            {
             before(grammarAccess.getChildListAccess().getChildrenAssignment_2()); 
            // InternalIndentationAwareUiTestLanguageParser.g:508:3: ( rule__ChildList__ChildrenAssignment_2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_STRING) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalIndentationAwareUiTestLanguageParser.g:508:4: rule__ChildList__ChildrenAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__ChildList__ChildrenAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getChildListAccess().getChildrenAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__2__Impl"


    // $ANTLR start "rule__ChildList__Group__3"
    // InternalIndentationAwareUiTestLanguageParser.g:517:1: rule__ChildList__Group__3 : rule__ChildList__Group__3__Impl ;
    public final void rule__ChildList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:521:1: ( rule__ChildList__Group__3__Impl )
            // InternalIndentationAwareUiTestLanguageParser.g:522:2: rule__ChildList__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChildList__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__3"


    // $ANTLR start "rule__ChildList__Group__3__Impl"
    // InternalIndentationAwareUiTestLanguageParser.g:528:1: rule__ChildList__Group__3__Impl : ( RULE_DEDENT ) ;
    public final void rule__ChildList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:532:1: ( ( RULE_DEDENT ) )
            // InternalIndentationAwareUiTestLanguageParser.g:533:1: ( RULE_DEDENT )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:533:1: ( RULE_DEDENT )
            // InternalIndentationAwareUiTestLanguageParser.g:534:2: RULE_DEDENT
            {
             before(grammarAccess.getChildListAccess().getDEDENTTerminalRuleCall_3()); 
            match(input,RULE_DEDENT,FOLLOW_2); 
             after(grammarAccess.getChildListAccess().getDEDENTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__Group__3__Impl"


    // $ANTLR start "rule__Tree__NodesAssignment_1"
    // InternalIndentationAwareUiTestLanguageParser.g:544:1: rule__Tree__NodesAssignment_1 : ( ruleTreeNode ) ;
    public final void rule__Tree__NodesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:548:1: ( ( ruleTreeNode ) )
            // InternalIndentationAwareUiTestLanguageParser.g:549:2: ( ruleTreeNode )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:549:2: ( ruleTreeNode )
            // InternalIndentationAwareUiTestLanguageParser.g:550:3: ruleTreeNode
            {
             before(grammarAccess.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__NodesAssignment_1"


    // $ANTLR start "rule__Tree__MoreNodesAssignment_2"
    // InternalIndentationAwareUiTestLanguageParser.g:559:1: rule__Tree__MoreNodesAssignment_2 : ( ruleOtherTreeNode ) ;
    public final void rule__Tree__MoreNodesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:563:1: ( ( ruleOtherTreeNode ) )
            // InternalIndentationAwareUiTestLanguageParser.g:564:2: ( ruleOtherTreeNode )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:564:2: ( ruleOtherTreeNode )
            // InternalIndentationAwareUiTestLanguageParser.g:565:3: ruleOtherTreeNode
            {
             before(grammarAccess.getTreeAccess().getMoreNodesOtherTreeNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOtherTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeAccess().getMoreNodesOtherTreeNodeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__MoreNodesAssignment_2"


    // $ANTLR start "rule__TreeNode__NameAssignment_0"
    // InternalIndentationAwareUiTestLanguageParser.g:574:1: rule__TreeNode__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__TreeNode__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:578:1: ( ( RULE_ID ) )
            // InternalIndentationAwareUiTestLanguageParser.g:579:2: ( RULE_ID )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:579:2: ( RULE_ID )
            // InternalIndentationAwareUiTestLanguageParser.g:580:3: RULE_ID
            {
             before(grammarAccess.getTreeNodeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTreeNodeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__NameAssignment_0"


    // $ANTLR start "rule__TreeNode__ChildrenAssignment_1_1"
    // InternalIndentationAwareUiTestLanguageParser.g:589:1: rule__TreeNode__ChildrenAssignment_1_1 : ( ruleTreeNode ) ;
    public final void rule__TreeNode__ChildrenAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:593:1: ( ( ruleTreeNode ) )
            // InternalIndentationAwareUiTestLanguageParser.g:594:2: ( ruleTreeNode )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:594:2: ( ruleTreeNode )
            // InternalIndentationAwareUiTestLanguageParser.g:595:3: ruleTreeNode
            {
             before(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__ChildrenAssignment_1_1"


    // $ANTLR start "rule__OtherTreeNode__NameAssignment_0"
    // InternalIndentationAwareUiTestLanguageParser.g:604:1: rule__OtherTreeNode__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__OtherTreeNode__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:608:1: ( ( RULE_STRING ) )
            // InternalIndentationAwareUiTestLanguageParser.g:609:2: ( RULE_STRING )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:609:2: ( RULE_STRING )
            // InternalIndentationAwareUiTestLanguageParser.g:610:3: RULE_STRING
            {
             before(grammarAccess.getOtherTreeNodeAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getOtherTreeNodeAccess().getNameSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OtherTreeNode__NameAssignment_0"


    // $ANTLR start "rule__OtherTreeNode__ChildListAssignment_1"
    // InternalIndentationAwareUiTestLanguageParser.g:619:1: rule__OtherTreeNode__ChildListAssignment_1 : ( ruleChildList ) ;
    public final void rule__OtherTreeNode__ChildListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:623:1: ( ( ruleChildList ) )
            // InternalIndentationAwareUiTestLanguageParser.g:624:2: ( ruleChildList )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:624:2: ( ruleChildList )
            // InternalIndentationAwareUiTestLanguageParser.g:625:3: ruleChildList
            {
             before(grammarAccess.getOtherTreeNodeAccess().getChildListChildListParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleChildList();

            state._fsp--;

             after(grammarAccess.getOtherTreeNodeAccess().getChildListChildListParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OtherTreeNode__ChildListAssignment_1"


    // $ANTLR start "rule__ChildList__ChildrenAssignment_2"
    // InternalIndentationAwareUiTestLanguageParser.g:634:1: rule__ChildList__ChildrenAssignment_2 : ( ruleOtherTreeNode ) ;
    public final void rule__ChildList__ChildrenAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIndentationAwareUiTestLanguageParser.g:638:1: ( ( ruleOtherTreeNode ) )
            // InternalIndentationAwareUiTestLanguageParser.g:639:2: ( ruleOtherTreeNode )
            {
            // InternalIndentationAwareUiTestLanguageParser.g:639:2: ( ruleOtherTreeNode )
            // InternalIndentationAwareUiTestLanguageParser.g:640:3: ruleOtherTreeNode
            {
             before(grammarAccess.getChildListAccess().getChildrenOtherTreeNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOtherTreeNode();

            state._fsp--;

             after(grammarAccess.getChildListAccess().getChildrenOtherTreeNodeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildList__ChildrenAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});

}