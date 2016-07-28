package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug291022TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug291022TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'{'", "'}'", "':'", "'='"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug291022TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug291022TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug291022TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug291022TestLanguage.g"; }


    	private Bug291022TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug291022TestLanguageGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleRootModel"
    // InternalBug291022TestLanguage.g:53:1: entryRuleRootModel : ruleRootModel EOF ;
    public final void entryRuleRootModel() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:54:1: ( ruleRootModel EOF )
            // InternalBug291022TestLanguage.g:55:1: ruleRootModel EOF
            {
             before(grammarAccess.getRootModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRootModel();

            state._fsp--;

             after(grammarAccess.getRootModelRule()); 
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
    // $ANTLR end "entryRuleRootModel"


    // $ANTLR start "ruleRootModel"
    // InternalBug291022TestLanguage.g:62:1: ruleRootModel : ( ( rule__RootModel__Group__0 )? ) ;
    public final void ruleRootModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:66:2: ( ( ( rule__RootModel__Group__0 )? ) )
            // InternalBug291022TestLanguage.g:67:2: ( ( rule__RootModel__Group__0 )? )
            {
            // InternalBug291022TestLanguage.g:67:2: ( ( rule__RootModel__Group__0 )? )
            // InternalBug291022TestLanguage.g:68:3: ( rule__RootModel__Group__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup()); 
            // InternalBug291022TestLanguage.g:69:3: ( rule__RootModel__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug291022TestLanguage.g:69:4: rule__RootModel__Group__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RootModel__Group__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getGroup()); 

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
    // $ANTLR end "ruleRootModel"


    // $ANTLR start "entryRuleModelElement"
    // InternalBug291022TestLanguage.g:78:1: entryRuleModelElement : ruleModelElement EOF ;
    public final void entryRuleModelElement() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:79:1: ( ruleModelElement EOF )
            // InternalBug291022TestLanguage.g:80:1: ruleModelElement EOF
            {
             before(grammarAccess.getModelElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModelElement();

            state._fsp--;

             after(grammarAccess.getModelElementRule()); 
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
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // InternalBug291022TestLanguage.g:87:1: ruleModelElement : ( ( rule__ModelElement__Group__0 ) ) ;
    public final void ruleModelElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:91:2: ( ( ( rule__ModelElement__Group__0 ) ) )
            // InternalBug291022TestLanguage.g:92:2: ( ( rule__ModelElement__Group__0 ) )
            {
            // InternalBug291022TestLanguage.g:92:2: ( ( rule__ModelElement__Group__0 ) )
            // InternalBug291022TestLanguage.g:93:3: ( rule__ModelElement__Group__0 )
            {
             before(grammarAccess.getModelElementAccess().getGroup()); 
            // InternalBug291022TestLanguage.g:94:3: ( rule__ModelElement__Group__0 )
            // InternalBug291022TestLanguage.g:94:4: rule__ModelElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getGroup()); 

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
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleModelAttribute"
    // InternalBug291022TestLanguage.g:103:1: entryRuleModelAttribute : ruleModelAttribute EOF ;
    public final void entryRuleModelAttribute() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:104:1: ( ruleModelAttribute EOF )
            // InternalBug291022TestLanguage.g:105:1: ruleModelAttribute EOF
            {
             before(grammarAccess.getModelAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModelAttribute();

            state._fsp--;

             after(grammarAccess.getModelAttributeRule()); 
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
    // $ANTLR end "entryRuleModelAttribute"


    // $ANTLR start "ruleModelAttribute"
    // InternalBug291022TestLanguage.g:112:1: ruleModelAttribute : ( ( rule__ModelAttribute__Alternatives ) ) ;
    public final void ruleModelAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:116:2: ( ( ( rule__ModelAttribute__Alternatives ) ) )
            // InternalBug291022TestLanguage.g:117:2: ( ( rule__ModelAttribute__Alternatives ) )
            {
            // InternalBug291022TestLanguage.g:117:2: ( ( rule__ModelAttribute__Alternatives ) )
            // InternalBug291022TestLanguage.g:118:3: ( rule__ModelAttribute__Alternatives )
            {
             before(grammarAccess.getModelAttributeAccess().getAlternatives()); 
            // InternalBug291022TestLanguage.g:119:3: ( rule__ModelAttribute__Alternatives )
            // InternalBug291022TestLanguage.g:119:4: rule__ModelAttribute__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAttributeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleModelAttribute"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug291022TestLanguage.g:128:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:129:1: ( ruleAttribute EOF )
            // InternalBug291022TestLanguage.g:130:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBug291022TestLanguage.g:137:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:141:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalBug291022TestLanguage.g:142:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalBug291022TestLanguage.g:142:2: ( ( rule__Attribute__Group__0 ) )
            // InternalBug291022TestLanguage.g:143:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalBug291022TestLanguage.g:144:3: ( rule__Attribute__Group__0 )
            // InternalBug291022TestLanguage.g:144:4: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "rule__ModelElement__Alternatives_3"
    // InternalBug291022TestLanguage.g:152:1: rule__ModelElement__Alternatives_3 : ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) );
    public final void rule__ModelElement__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:156:1: ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug291022TestLanguage.g:157:2: ( ';' )
                    {
                    // InternalBug291022TestLanguage.g:157:2: ( ';' )
                    // InternalBug291022TestLanguage.g:158:3: ';'
                    {
                     before(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug291022TestLanguage.g:163:2: ( ( rule__ModelElement__Group_3_1__0 ) )
                    {
                    // InternalBug291022TestLanguage.g:163:2: ( ( rule__ModelElement__Group_3_1__0 ) )
                    // InternalBug291022TestLanguage.g:164:3: ( rule__ModelElement__Group_3_1__0 )
                    {
                     before(grammarAccess.getModelElementAccess().getGroup_3_1()); 
                    // InternalBug291022TestLanguage.g:165:3: ( rule__ModelElement__Group_3_1__0 )
                    // InternalBug291022TestLanguage.g:165:4: rule__ModelElement__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ModelElement__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelElementAccess().getGroup_3_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end "rule__ModelElement__Alternatives_3"


    // $ANTLR start "rule__ModelAttribute__Alternatives"
    // InternalBug291022TestLanguage.g:173:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );
    public final void rule__ModelAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:177:1: ( ( ruleModelElement ) | ( ruleAttribute ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_ID||(LA3_1>=11 && LA3_1<=12)||LA3_1==14) ) {
                    alt3=1;
                }
                else if ( (LA3_1==15) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug291022TestLanguage.g:178:2: ( ruleModelElement )
                    {
                    // InternalBug291022TestLanguage.g:178:2: ( ruleModelElement )
                    // InternalBug291022TestLanguage.g:179:3: ruleModelElement
                    {
                     before(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleModelElement();

                    state._fsp--;

                     after(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug291022TestLanguage.g:184:2: ( ruleAttribute )
                    {
                    // InternalBug291022TestLanguage.g:184:2: ( ruleAttribute )
                    // InternalBug291022TestLanguage.g:185:3: ruleAttribute
                    {
                     before(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAttribute();

                    state._fsp--;

                     after(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end "rule__ModelAttribute__Alternatives"


    // $ANTLR start "rule__RootModel__Group__0"
    // InternalBug291022TestLanguage.g:194:1: rule__RootModel__Group__0 : rule__RootModel__Group__0__Impl rule__RootModel__Group__1 ;
    public final void rule__RootModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:198:1: ( rule__RootModel__Group__0__Impl rule__RootModel__Group__1 )
            // InternalBug291022TestLanguage.g:199:2: rule__RootModel__Group__0__Impl rule__RootModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__RootModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__1();

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
    // $ANTLR end "rule__RootModel__Group__0"


    // $ANTLR start "rule__RootModel__Group__0__Impl"
    // InternalBug291022TestLanguage.g:206:1: rule__RootModel__Group__0__Impl : ( () ) ;
    public final void rule__RootModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:210:1: ( ( () ) )
            // InternalBug291022TestLanguage.g:211:1: ( () )
            {
            // InternalBug291022TestLanguage.g:211:1: ( () )
            // InternalBug291022TestLanguage.g:212:2: ()
            {
             before(grammarAccess.getRootModelAccess().getRootModelAction_0()); 
            // InternalBug291022TestLanguage.g:213:2: ()
            // InternalBug291022TestLanguage.g:213:3: 
            {
            }

             after(grammarAccess.getRootModelAccess().getRootModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootModel__Group__0__Impl"


    // $ANTLR start "rule__RootModel__Group__1"
    // InternalBug291022TestLanguage.g:221:1: rule__RootModel__Group__1 : rule__RootModel__Group__1__Impl rule__RootModel__Group__2 ;
    public final void rule__RootModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:225:1: ( rule__RootModel__Group__1__Impl rule__RootModel__Group__2 )
            // InternalBug291022TestLanguage.g:226:2: rule__RootModel__Group__1__Impl rule__RootModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__RootModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__2();

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
    // $ANTLR end "rule__RootModel__Group__1"


    // $ANTLR start "rule__RootModel__Group__1__Impl"
    // InternalBug291022TestLanguage.g:233:1: rule__RootModel__Group__1__Impl : ( ( rule__RootModel__NameAssignment_1 ) ) ;
    public final void rule__RootModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:237:1: ( ( ( rule__RootModel__NameAssignment_1 ) ) )
            // InternalBug291022TestLanguage.g:238:1: ( ( rule__RootModel__NameAssignment_1 ) )
            {
            // InternalBug291022TestLanguage.g:238:1: ( ( rule__RootModel__NameAssignment_1 ) )
            // InternalBug291022TestLanguage.g:239:2: ( rule__RootModel__NameAssignment_1 )
            {
             before(grammarAccess.getRootModelAccess().getNameAssignment_1()); 
            // InternalBug291022TestLanguage.g:240:2: ( rule__RootModel__NameAssignment_1 )
            // InternalBug291022TestLanguage.g:240:3: rule__RootModel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRootModelAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__RootModel__Group__1__Impl"


    // $ANTLR start "rule__RootModel__Group__2"
    // InternalBug291022TestLanguage.g:248:1: rule__RootModel__Group__2 : rule__RootModel__Group__2__Impl rule__RootModel__Group__3 ;
    public final void rule__RootModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:252:1: ( rule__RootModel__Group__2__Impl rule__RootModel__Group__3 )
            // InternalBug291022TestLanguage.g:253:2: rule__RootModel__Group__2__Impl rule__RootModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__RootModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__3();

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
    // $ANTLR end "rule__RootModel__Group__2"


    // $ANTLR start "rule__RootModel__Group__2__Impl"
    // InternalBug291022TestLanguage.g:260:1: rule__RootModel__Group__2__Impl : ( ( rule__RootModel__TypeAssignment_2 )? ) ;
    public final void rule__RootModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:264:1: ( ( ( rule__RootModel__TypeAssignment_2 )? ) )
            // InternalBug291022TestLanguage.g:265:1: ( ( rule__RootModel__TypeAssignment_2 )? )
            {
            // InternalBug291022TestLanguage.g:265:1: ( ( rule__RootModel__TypeAssignment_2 )? )
            // InternalBug291022TestLanguage.g:266:2: ( rule__RootModel__TypeAssignment_2 )?
            {
             before(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 
            // InternalBug291022TestLanguage.g:267:2: ( rule__RootModel__TypeAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug291022TestLanguage.g:267:3: rule__RootModel__TypeAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RootModel__TypeAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 

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
    // $ANTLR end "rule__RootModel__Group__2__Impl"


    // $ANTLR start "rule__RootModel__Group__3"
    // InternalBug291022TestLanguage.g:275:1: rule__RootModel__Group__3 : rule__RootModel__Group__3__Impl ;
    public final void rule__RootModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:279:1: ( rule__RootModel__Group__3__Impl )
            // InternalBug291022TestLanguage.g:280:2: rule__RootModel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__3__Impl();

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
    // $ANTLR end "rule__RootModel__Group__3"


    // $ANTLR start "rule__RootModel__Group__3__Impl"
    // InternalBug291022TestLanguage.g:286:1: rule__RootModel__Group__3__Impl : ( ( rule__RootModel__Group_3__0 )? ) ;
    public final void rule__RootModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:290:1: ( ( ( rule__RootModel__Group_3__0 )? ) )
            // InternalBug291022TestLanguage.g:291:1: ( ( rule__RootModel__Group_3__0 )? )
            {
            // InternalBug291022TestLanguage.g:291:1: ( ( rule__RootModel__Group_3__0 )? )
            // InternalBug291022TestLanguage.g:292:2: ( rule__RootModel__Group_3__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup_3()); 
            // InternalBug291022TestLanguage.g:293:2: ( rule__RootModel__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug291022TestLanguage.g:293:3: rule__RootModel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RootModel__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getGroup_3()); 

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
    // $ANTLR end "rule__RootModel__Group__3__Impl"


    // $ANTLR start "rule__RootModel__Group_3__0"
    // InternalBug291022TestLanguage.g:302:1: rule__RootModel__Group_3__0 : rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1 ;
    public final void rule__RootModel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:306:1: ( rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1 )
            // InternalBug291022TestLanguage.g:307:2: rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__RootModel__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group_3__1();

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
    // $ANTLR end "rule__RootModel__Group_3__0"


    // $ANTLR start "rule__RootModel__Group_3__0__Impl"
    // InternalBug291022TestLanguage.g:314:1: rule__RootModel__Group_3__0__Impl : ( '{' ) ;
    public final void rule__RootModel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:318:1: ( ( '{' ) )
            // InternalBug291022TestLanguage.g:319:1: ( '{' )
            {
            // InternalBug291022TestLanguage.g:319:1: ( '{' )
            // InternalBug291022TestLanguage.g:320:2: '{'
            {
             before(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 

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
    // $ANTLR end "rule__RootModel__Group_3__0__Impl"


    // $ANTLR start "rule__RootModel__Group_3__1"
    // InternalBug291022TestLanguage.g:329:1: rule__RootModel__Group_3__1 : rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2 ;
    public final void rule__RootModel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:333:1: ( rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2 )
            // InternalBug291022TestLanguage.g:334:2: rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__RootModel__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group_3__2();

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
    // $ANTLR end "rule__RootModel__Group_3__1"


    // $ANTLR start "rule__RootModel__Group_3__1__Impl"
    // InternalBug291022TestLanguage.g:341:1: rule__RootModel__Group_3__1__Impl : ( ( rule__RootModel__ElementsAssignment_3_1 )* ) ;
    public final void rule__RootModel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:345:1: ( ( ( rule__RootModel__ElementsAssignment_3_1 )* ) )
            // InternalBug291022TestLanguage.g:346:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* )
            {
            // InternalBug291022TestLanguage.g:346:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* )
            // InternalBug291022TestLanguage.g:347:2: ( rule__RootModel__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getRootModelAccess().getElementsAssignment_3_1()); 
            // InternalBug291022TestLanguage.g:348:2: ( rule__RootModel__ElementsAssignment_3_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug291022TestLanguage.g:348:3: rule__RootModel__ElementsAssignment_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__RootModel__ElementsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRootModelAccess().getElementsAssignment_3_1()); 

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
    // $ANTLR end "rule__RootModel__Group_3__1__Impl"


    // $ANTLR start "rule__RootModel__Group_3__2"
    // InternalBug291022TestLanguage.g:356:1: rule__RootModel__Group_3__2 : rule__RootModel__Group_3__2__Impl ;
    public final void rule__RootModel__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:360:1: ( rule__RootModel__Group_3__2__Impl )
            // InternalBug291022TestLanguage.g:361:2: rule__RootModel__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group_3__2__Impl();

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
    // $ANTLR end "rule__RootModel__Group_3__2"


    // $ANTLR start "rule__RootModel__Group_3__2__Impl"
    // InternalBug291022TestLanguage.g:367:1: rule__RootModel__Group_3__2__Impl : ( '}' ) ;
    public final void rule__RootModel__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:371:1: ( ( '}' ) )
            // InternalBug291022TestLanguage.g:372:1: ( '}' )
            {
            // InternalBug291022TestLanguage.g:372:1: ( '}' )
            // InternalBug291022TestLanguage.g:373:2: '}'
            {
             before(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2()); 

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
    // $ANTLR end "rule__RootModel__Group_3__2__Impl"


    // $ANTLR start "rule__ModelElement__Group__0"
    // InternalBug291022TestLanguage.g:383:1: rule__ModelElement__Group__0 : rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 ;
    public final void rule__ModelElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:387:1: ( rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 )
            // InternalBug291022TestLanguage.g:388:2: rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ModelElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__1();

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
    // $ANTLR end "rule__ModelElement__Group__0"


    // $ANTLR start "rule__ModelElement__Group__0__Impl"
    // InternalBug291022TestLanguage.g:395:1: rule__ModelElement__Group__0__Impl : ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) ;
    public final void rule__ModelElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:399:1: ( ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) )
            // InternalBug291022TestLanguage.g:400:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) )
            {
            // InternalBug291022TestLanguage.g:400:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) )
            // InternalBug291022TestLanguage.g:401:2: ( rule__ModelElement__FirstReferenceAssignment_0 )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 
            // InternalBug291022TestLanguage.g:402:2: ( rule__ModelElement__FirstReferenceAssignment_0 )
            // InternalBug291022TestLanguage.g:402:3: rule__ModelElement__FirstReferenceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__FirstReferenceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 

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
    // $ANTLR end "rule__ModelElement__Group__0__Impl"


    // $ANTLR start "rule__ModelElement__Group__1"
    // InternalBug291022TestLanguage.g:410:1: rule__ModelElement__Group__1 : rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 ;
    public final void rule__ModelElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:414:1: ( rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 )
            // InternalBug291022TestLanguage.g:415:2: rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ModelElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__2();

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
    // $ANTLR end "rule__ModelElement__Group__1"


    // $ANTLR start "rule__ModelElement__Group__1__Impl"
    // InternalBug291022TestLanguage.g:422:1: rule__ModelElement__Group__1__Impl : ( ( rule__ModelElement__Group_1__0 )? ) ;
    public final void rule__ModelElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:426:1: ( ( ( rule__ModelElement__Group_1__0 )? ) )
            // InternalBug291022TestLanguage.g:427:1: ( ( rule__ModelElement__Group_1__0 )? )
            {
            // InternalBug291022TestLanguage.g:427:1: ( ( rule__ModelElement__Group_1__0 )? )
            // InternalBug291022TestLanguage.g:428:2: ( rule__ModelElement__Group_1__0 )?
            {
             before(grammarAccess.getModelElementAccess().getGroup_1()); 
            // InternalBug291022TestLanguage.g:429:2: ( rule__ModelElement__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug291022TestLanguage.g:429:3: rule__ModelElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ModelElement__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ModelElement__Group__1__Impl"


    // $ANTLR start "rule__ModelElement__Group__2"
    // InternalBug291022TestLanguage.g:437:1: rule__ModelElement__Group__2 : rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3 ;
    public final void rule__ModelElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:441:1: ( rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3 )
            // InternalBug291022TestLanguage.g:442:2: rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ModelElement__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__3();

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
    // $ANTLR end "rule__ModelElement__Group__2"


    // $ANTLR start "rule__ModelElement__Group__2__Impl"
    // InternalBug291022TestLanguage.g:449:1: rule__ModelElement__Group__2__Impl : ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) ;
    public final void rule__ModelElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:453:1: ( ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) )
            // InternalBug291022TestLanguage.g:454:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? )
            {
            // InternalBug291022TestLanguage.g:454:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? )
            // InternalBug291022TestLanguage.g:455:2: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 
            // InternalBug291022TestLanguage.g:456:2: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug291022TestLanguage.g:456:3: rule__ModelElement__SecondReferenceAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ModelElement__SecondReferenceAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 

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
    // $ANTLR end "rule__ModelElement__Group__2__Impl"


    // $ANTLR start "rule__ModelElement__Group__3"
    // InternalBug291022TestLanguage.g:464:1: rule__ModelElement__Group__3 : rule__ModelElement__Group__3__Impl ;
    public final void rule__ModelElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:468:1: ( rule__ModelElement__Group__3__Impl )
            // InternalBug291022TestLanguage.g:469:2: rule__ModelElement__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__3__Impl();

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
    // $ANTLR end "rule__ModelElement__Group__3"


    // $ANTLR start "rule__ModelElement__Group__3__Impl"
    // InternalBug291022TestLanguage.g:475:1: rule__ModelElement__Group__3__Impl : ( ( rule__ModelElement__Alternatives_3 ) ) ;
    public final void rule__ModelElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:479:1: ( ( ( rule__ModelElement__Alternatives_3 ) ) )
            // InternalBug291022TestLanguage.g:480:1: ( ( rule__ModelElement__Alternatives_3 ) )
            {
            // InternalBug291022TestLanguage.g:480:1: ( ( rule__ModelElement__Alternatives_3 ) )
            // InternalBug291022TestLanguage.g:481:2: ( rule__ModelElement__Alternatives_3 )
            {
             before(grammarAccess.getModelElementAccess().getAlternatives_3()); 
            // InternalBug291022TestLanguage.g:482:2: ( rule__ModelElement__Alternatives_3 )
            // InternalBug291022TestLanguage.g:482:3: rule__ModelElement__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getAlternatives_3()); 

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
    // $ANTLR end "rule__ModelElement__Group__3__Impl"


    // $ANTLR start "rule__ModelElement__Group_1__0"
    // InternalBug291022TestLanguage.g:491:1: rule__ModelElement__Group_1__0 : rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1 ;
    public final void rule__ModelElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:495:1: ( rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1 )
            // InternalBug291022TestLanguage.g:496:2: rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ModelElement__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_1__1();

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
    // $ANTLR end "rule__ModelElement__Group_1__0"


    // $ANTLR start "rule__ModelElement__Group_1__0__Impl"
    // InternalBug291022TestLanguage.g:503:1: rule__ModelElement__Group_1__0__Impl : ( ':' ) ;
    public final void rule__ModelElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:507:1: ( ( ':' ) )
            // InternalBug291022TestLanguage.g:508:1: ( ':' )
            {
            // InternalBug291022TestLanguage.g:508:1: ( ':' )
            // InternalBug291022TestLanguage.g:509:2: ':'
            {
             before(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 

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
    // $ANTLR end "rule__ModelElement__Group_1__0__Impl"


    // $ANTLR start "rule__ModelElement__Group_1__1"
    // InternalBug291022TestLanguage.g:518:1: rule__ModelElement__Group_1__1 : rule__ModelElement__Group_1__1__Impl ;
    public final void rule__ModelElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:522:1: ( rule__ModelElement__Group_1__1__Impl )
            // InternalBug291022TestLanguage.g:523:2: rule__ModelElement__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_1__1__Impl();

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
    // $ANTLR end "rule__ModelElement__Group_1__1"


    // $ANTLR start "rule__ModelElement__Group_1__1__Impl"
    // InternalBug291022TestLanguage.g:529:1: rule__ModelElement__Group_1__1__Impl : ( ( rule__ModelElement__NameAssignment_1_1 ) ) ;
    public final void rule__ModelElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:533:1: ( ( ( rule__ModelElement__NameAssignment_1_1 ) ) )
            // InternalBug291022TestLanguage.g:534:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            {
            // InternalBug291022TestLanguage.g:534:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            // InternalBug291022TestLanguage.g:535:2: ( rule__ModelElement__NameAssignment_1_1 )
            {
             before(grammarAccess.getModelElementAccess().getNameAssignment_1_1()); 
            // InternalBug291022TestLanguage.g:536:2: ( rule__ModelElement__NameAssignment_1_1 )
            // InternalBug291022TestLanguage.g:536:3: rule__ModelElement__NameAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getNameAssignment_1_1()); 

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
    // $ANTLR end "rule__ModelElement__Group_1__1__Impl"


    // $ANTLR start "rule__ModelElement__Group_3_1__0"
    // InternalBug291022TestLanguage.g:545:1: rule__ModelElement__Group_3_1__0 : rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1 ;
    public final void rule__ModelElement__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:549:1: ( rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1 )
            // InternalBug291022TestLanguage.g:550:2: rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ModelElement__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_3_1__1();

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
    // $ANTLR end "rule__ModelElement__Group_3_1__0"


    // $ANTLR start "rule__ModelElement__Group_3_1__0__Impl"
    // InternalBug291022TestLanguage.g:557:1: rule__ModelElement__Group_3_1__0__Impl : ( '{' ) ;
    public final void rule__ModelElement__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:561:1: ( ( '{' ) )
            // InternalBug291022TestLanguage.g:562:1: ( '{' )
            {
            // InternalBug291022TestLanguage.g:562:1: ( '{' )
            // InternalBug291022TestLanguage.g:563:2: '{'
            {
             before(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 

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
    // $ANTLR end "rule__ModelElement__Group_3_1__0__Impl"


    // $ANTLR start "rule__ModelElement__Group_3_1__1"
    // InternalBug291022TestLanguage.g:572:1: rule__ModelElement__Group_3_1__1 : rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2 ;
    public final void rule__ModelElement__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:576:1: ( rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2 )
            // InternalBug291022TestLanguage.g:577:2: rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ModelElement__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_3_1__2();

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
    // $ANTLR end "rule__ModelElement__Group_3_1__1"


    // $ANTLR start "rule__ModelElement__Group_3_1__1__Impl"
    // InternalBug291022TestLanguage.g:584:1: rule__ModelElement__Group_3_1__1__Impl : ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) ;
    public final void rule__ModelElement__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:588:1: ( ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) )
            // InternalBug291022TestLanguage.g:589:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* )
            {
            // InternalBug291022TestLanguage.g:589:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* )
            // InternalBug291022TestLanguage.g:590:2: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            {
             before(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1()); 
            // InternalBug291022TestLanguage.g:591:2: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug291022TestLanguage.g:591:3: rule__ModelElement__ElementsAssignment_3_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__ModelElement__ElementsAssignment_3_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1()); 

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
    // $ANTLR end "rule__ModelElement__Group_3_1__1__Impl"


    // $ANTLR start "rule__ModelElement__Group_3_1__2"
    // InternalBug291022TestLanguage.g:599:1: rule__ModelElement__Group_3_1__2 : rule__ModelElement__Group_3_1__2__Impl ;
    public final void rule__ModelElement__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:603:1: ( rule__ModelElement__Group_3_1__2__Impl )
            // InternalBug291022TestLanguage.g:604:2: rule__ModelElement__Group_3_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_3_1__2__Impl();

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
    // $ANTLR end "rule__ModelElement__Group_3_1__2"


    // $ANTLR start "rule__ModelElement__Group_3_1__2__Impl"
    // InternalBug291022TestLanguage.g:610:1: rule__ModelElement__Group_3_1__2__Impl : ( '}' ) ;
    public final void rule__ModelElement__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:614:1: ( ( '}' ) )
            // InternalBug291022TestLanguage.g:615:1: ( '}' )
            {
            // InternalBug291022TestLanguage.g:615:1: ( '}' )
            // InternalBug291022TestLanguage.g:616:2: '}'
            {
             before(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2()); 

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
    // $ANTLR end "rule__ModelElement__Group_3_1__2__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalBug291022TestLanguage.g:626:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:630:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalBug291022TestLanguage.g:631:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__1();

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
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalBug291022TestLanguage.g:638:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__FeatureAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:642:1: ( ( ( rule__Attribute__FeatureAssignment_0 ) ) )
            // InternalBug291022TestLanguage.g:643:1: ( ( rule__Attribute__FeatureAssignment_0 ) )
            {
            // InternalBug291022TestLanguage.g:643:1: ( ( rule__Attribute__FeatureAssignment_0 ) )
            // InternalBug291022TestLanguage.g:644:2: ( rule__Attribute__FeatureAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 
            // InternalBug291022TestLanguage.g:645:2: ( rule__Attribute__FeatureAssignment_0 )
            // InternalBug291022TestLanguage.g:645:3: rule__Attribute__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__FeatureAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 

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
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalBug291022TestLanguage.g:653:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:657:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalBug291022TestLanguage.g:658:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__2();

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
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalBug291022TestLanguage.g:665:1: rule__Attribute__Group__1__Impl : ( '=' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:669:1: ( ( '=' ) )
            // InternalBug291022TestLanguage.g:670:1: ( '=' )
            {
            // InternalBug291022TestLanguage.g:670:1: ( '=' )
            // InternalBug291022TestLanguage.g:671:2: '='
            {
             before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 

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
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalBug291022TestLanguage.g:680:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:684:1: ( rule__Attribute__Group__2__Impl )
            // InternalBug291022TestLanguage.g:685:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__2__Impl();

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
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalBug291022TestLanguage.g:691:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:695:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // InternalBug291022TestLanguage.g:696:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // InternalBug291022TestLanguage.g:696:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // InternalBug291022TestLanguage.g:697:2: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // InternalBug291022TestLanguage.g:698:2: ( rule__Attribute__ValueAssignment_2 )
            // InternalBug291022TestLanguage.g:698:3: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getValueAssignment_2()); 

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
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__RootModel__NameAssignment_1"
    // InternalBug291022TestLanguage.g:707:1: rule__RootModel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RootModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:711:1: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:712:2: ( RULE_ID )
            {
            // InternalBug291022TestLanguage.g:712:2: ( RULE_ID )
            // InternalBug291022TestLanguage.g:713:3: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__RootModel__NameAssignment_1"


    // $ANTLR start "rule__RootModel__TypeAssignment_2"
    // InternalBug291022TestLanguage.g:722:1: rule__RootModel__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__RootModel__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:726:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:727:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:727:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:728:3: ( RULE_ID )
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 
            // InternalBug291022TestLanguage.g:729:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:730:4: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getTypeModelElementIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 

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
    // $ANTLR end "rule__RootModel__TypeAssignment_2"


    // $ANTLR start "rule__RootModel__ElementsAssignment_3_1"
    // InternalBug291022TestLanguage.g:741:1: rule__RootModel__ElementsAssignment_3_1 : ( ruleModelAttribute ) ;
    public final void rule__RootModel__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:745:1: ( ( ruleModelAttribute ) )
            // InternalBug291022TestLanguage.g:746:2: ( ruleModelAttribute )
            {
            // InternalBug291022TestLanguage.g:746:2: ( ruleModelAttribute )
            // InternalBug291022TestLanguage.g:747:3: ruleModelAttribute
            {
             before(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleModelAttribute();

            state._fsp--;

             after(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__RootModel__ElementsAssignment_3_1"


    // $ANTLR start "rule__ModelElement__FirstReferenceAssignment_0"
    // InternalBug291022TestLanguage.g:756:1: rule__ModelElement__FirstReferenceAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__FirstReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:760:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:761:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:761:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:762:3: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 
            // InternalBug291022TestLanguage.g:763:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:764:4: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getFirstReferenceModelElementIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 

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
    // $ANTLR end "rule__ModelElement__FirstReferenceAssignment_0"


    // $ANTLR start "rule__ModelElement__NameAssignment_1_1"
    // InternalBug291022TestLanguage.g:775:1: rule__ModelElement__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ModelElement__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:779:1: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:780:2: ( RULE_ID )
            {
            // InternalBug291022TestLanguage.g:780:2: ( RULE_ID )
            // InternalBug291022TestLanguage.g:781:3: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__ModelElement__NameAssignment_1_1"


    // $ANTLR start "rule__ModelElement__SecondReferenceAssignment_2"
    // InternalBug291022TestLanguage.g:790:1: rule__ModelElement__SecondReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__SecondReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:794:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:795:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:795:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:796:3: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 
            // InternalBug291022TestLanguage.g:797:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:798:4: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getSecondReferenceModelElementIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 

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
    // $ANTLR end "rule__ModelElement__SecondReferenceAssignment_2"


    // $ANTLR start "rule__ModelElement__ElementsAssignment_3_1_1"
    // InternalBug291022TestLanguage.g:809:1: rule__ModelElement__ElementsAssignment_3_1_1 : ( ruleModelAttribute ) ;
    public final void rule__ModelElement__ElementsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:813:1: ( ( ruleModelAttribute ) )
            // InternalBug291022TestLanguage.g:814:2: ( ruleModelAttribute )
            {
            // InternalBug291022TestLanguage.g:814:2: ( ruleModelAttribute )
            // InternalBug291022TestLanguage.g:815:3: ruleModelAttribute
            {
             before(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleModelAttribute();

            state._fsp--;

             after(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 

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
    // $ANTLR end "rule__ModelElement__ElementsAssignment_3_1_1"


    // $ANTLR start "rule__Attribute__FeatureAssignment_0"
    // InternalBug291022TestLanguage.g:824:1: rule__Attribute__FeatureAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:828:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:829:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:829:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:830:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 
            // InternalBug291022TestLanguage.g:831:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:832:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getFeatureModelElementIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 

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
    // $ANTLR end "rule__Attribute__FeatureAssignment_0"


    // $ANTLR start "rule__Attribute__ValueAssignment_2"
    // InternalBug291022TestLanguage.g:843:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:847:1: ( ( RULE_STRING ) )
            // InternalBug291022TestLanguage.g:848:2: ( RULE_STRING )
            {
            // InternalBug291022TestLanguage.g:848:2: ( RULE_STRING )
            // InternalBug291022TestLanguage.g:849:3: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Attribute__ValueAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000005810L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    }


}