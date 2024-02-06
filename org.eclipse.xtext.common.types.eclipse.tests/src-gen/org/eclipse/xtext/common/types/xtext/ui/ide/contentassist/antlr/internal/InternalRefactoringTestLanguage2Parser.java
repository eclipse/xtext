package org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguage2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalRefactoringTestLanguage2Parser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'$'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalRefactoringTestLanguage2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguage2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguage2Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalRefactoringTestLanguage2.g"; }


    	private RefactoringTestLanguage2GrammarAccess grammarAccess;

    	public void setGrammarAccess(RefactoringTestLanguage2GrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleEntry"
    // InternalRefactoringTestLanguage2.g:58:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage2.g:59:1: ( ruleEntry EOF )
            // InternalRefactoringTestLanguage2.g:60:1: ruleEntry EOF
            {
             before(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getEntryRule()); 
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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // InternalRefactoringTestLanguage2.g:67:1: ruleEntry : ( ruleModel ) ;
    public final void ruleEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:71:2: ( ( ruleModel ) )
            // InternalRefactoringTestLanguage2.g:72:2: ( ruleModel )
            {
            // InternalRefactoringTestLanguage2.g:72:2: ( ruleModel )
            // InternalRefactoringTestLanguage2.g:73:3: ruleModel
            {
             before(grammarAccess.getEntryAccess().getModelParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getEntryAccess().getModelParserRuleCall()); 

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
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleModel"
    // InternalRefactoringTestLanguage2.g:83:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage2.g:84:1: ( ruleModel EOF )
            // InternalRefactoringTestLanguage2.g:85:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalRefactoringTestLanguage2.g:92:1: ruleModel : ( ( rule__Model__ReferenceHolderAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:96:2: ( ( ( rule__Model__ReferenceHolderAssignment )* ) )
            // InternalRefactoringTestLanguage2.g:97:2: ( ( rule__Model__ReferenceHolderAssignment )* )
            {
            // InternalRefactoringTestLanguage2.g:97:2: ( ( rule__Model__ReferenceHolderAssignment )* )
            // InternalRefactoringTestLanguage2.g:98:3: ( rule__Model__ReferenceHolderAssignment )*
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment()); 
            // InternalRefactoringTestLanguage2.g:99:3: ( rule__Model__ReferenceHolderAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRefactoringTestLanguage2.g:99:4: rule__Model__ReferenceHolderAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ReferenceHolderAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getReferenceHolderAssignment()); 

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleReferenceHolder"
    // InternalRefactoringTestLanguage2.g:108:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage2.g:109:1: ( ruleReferenceHolder EOF )
            // InternalRefactoringTestLanguage2.g:110:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FOLLOW_1);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // InternalRefactoringTestLanguage2.g:117:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Group__0 ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:121:2: ( ( ( rule__ReferenceHolder__Group__0 ) ) )
            // InternalRefactoringTestLanguage2.g:122:2: ( ( rule__ReferenceHolder__Group__0 ) )
            {
            // InternalRefactoringTestLanguage2.g:122:2: ( ( rule__ReferenceHolder__Group__0 ) )
            // InternalRefactoringTestLanguage2.g:123:3: ( rule__ReferenceHolder__Group__0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getGroup()); 
            // InternalRefactoringTestLanguage2.g:124:3: ( rule__ReferenceHolder__Group__0 )
            // InternalRefactoringTestLanguage2.g:124:4: rule__ReferenceHolder__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getGroup()); 

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
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleFQN"
    // InternalRefactoringTestLanguage2.g:133:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage2.g:134:1: ( ruleFQN EOF )
            // InternalRefactoringTestLanguage2.g:135:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalRefactoringTestLanguage2.g:142:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:146:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalRefactoringTestLanguage2.g:147:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalRefactoringTestLanguage2.g:147:2: ( ( rule__FQN__Group__0 ) )
            // InternalRefactoringTestLanguage2.g:148:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalRefactoringTestLanguage2.g:149:3: ( rule__FQN__Group__0 )
            // InternalRefactoringTestLanguage2.g:149:4: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "rule__ReferenceHolder__Group__0"
    // InternalRefactoringTestLanguage2.g:157:1: rule__ReferenceHolder__Group__0 : rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 ;
    public final void rule__ReferenceHolder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:161:1: ( rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 )
            // InternalRefactoringTestLanguage2.g:162:2: rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ReferenceHolder__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group__1();

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
    // $ANTLR end "rule__ReferenceHolder__Group__0"


    // $ANTLR start "rule__ReferenceHolder__Group__0__Impl"
    // InternalRefactoringTestLanguage2.g:169:1: rule__ReferenceHolder__Group__0__Impl : ( ( rule__ReferenceHolder__NameAssignment_0 ) ) ;
    public final void rule__ReferenceHolder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:173:1: ( ( ( rule__ReferenceHolder__NameAssignment_0 ) ) )
            // InternalRefactoringTestLanguage2.g:174:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            {
            // InternalRefactoringTestLanguage2.g:174:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            // InternalRefactoringTestLanguage2.g:175:2: ( rule__ReferenceHolder__NameAssignment_0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getNameAssignment_0()); 
            // InternalRefactoringTestLanguage2.g:176:2: ( rule__ReferenceHolder__NameAssignment_0 )
            // InternalRefactoringTestLanguage2.g:176:3: rule__ReferenceHolder__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group__1"
    // InternalRefactoringTestLanguage2.g:184:1: rule__ReferenceHolder__Group__1 : rule__ReferenceHolder__Group__1__Impl ;
    public final void rule__ReferenceHolder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:188:1: ( rule__ReferenceHolder__Group__1__Impl )
            // InternalRefactoringTestLanguage2.g:189:2: rule__ReferenceHolder__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group__1__Impl();

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
    // $ANTLR end "rule__ReferenceHolder__Group__1"


    // $ANTLR start "rule__ReferenceHolder__Group__1__Impl"
    // InternalRefactoringTestLanguage2.g:195:1: rule__ReferenceHolder__Group__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) ;
    public final void rule__ReferenceHolder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:199:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) )
            // InternalRefactoringTestLanguage2.g:200:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            {
            // InternalRefactoringTestLanguage2.g:200:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            // InternalRefactoringTestLanguage2.g:201:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1()); 
            // InternalRefactoringTestLanguage2.g:202:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            // InternalRefactoringTestLanguage2.g:202:3: rule__ReferenceHolder__DefaultReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__DefaultReferenceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalRefactoringTestLanguage2.g:211:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:215:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalRefactoringTestLanguage2.g:216:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group__1();

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
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // InternalRefactoringTestLanguage2.g:223:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:227:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage2.g:228:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage2.g:228:1: ( RULE_ID )
            // InternalRefactoringTestLanguage2.g:229:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // InternalRefactoringTestLanguage2.g:238:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl rule__FQN__Group__2 ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:242:1: ( rule__FQN__Group__1__Impl rule__FQN__Group__2 )
            // InternalRefactoringTestLanguage2.g:243:2: rule__FQN__Group__1__Impl rule__FQN__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FQN__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group__2();

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
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // InternalRefactoringTestLanguage2.g:250:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:254:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalRefactoringTestLanguage2.g:255:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalRefactoringTestLanguage2.g:255:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalRefactoringTestLanguage2.g:256:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage2.g:257:2: ( rule__FQN__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRefactoringTestLanguage2.g:257:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

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
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__2"
    // InternalRefactoringTestLanguage2.g:265:1: rule__FQN__Group__2 : rule__FQN__Group__2__Impl ;
    public final void rule__FQN__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:269:1: ( rule__FQN__Group__2__Impl )
            // InternalRefactoringTestLanguage2.g:270:2: rule__FQN__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group__2__Impl();

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
    // $ANTLR end "rule__FQN__Group__2"


    // $ANTLR start "rule__FQN__Group__2__Impl"
    // InternalRefactoringTestLanguage2.g:276:1: rule__FQN__Group__2__Impl : ( ( rule__FQN__Group_2__0 )* ) ;
    public final void rule__FQN__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:280:1: ( ( ( rule__FQN__Group_2__0 )* ) )
            // InternalRefactoringTestLanguage2.g:281:1: ( ( rule__FQN__Group_2__0 )* )
            {
            // InternalRefactoringTestLanguage2.g:281:1: ( ( rule__FQN__Group_2__0 )* )
            // InternalRefactoringTestLanguage2.g:282:2: ( rule__FQN__Group_2__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_2()); 
            // InternalRefactoringTestLanguage2.g:283:2: ( rule__FQN__Group_2__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRefactoringTestLanguage2.g:283:3: rule__FQN__Group_2__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__FQN__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_2()); 

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
    // $ANTLR end "rule__FQN__Group__2__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // InternalRefactoringTestLanguage2.g:292:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:296:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalRefactoringTestLanguage2.g:297:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group_1__1();

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
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // InternalRefactoringTestLanguage2.g:304:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:308:1: ( ( '.' ) )
            // InternalRefactoringTestLanguage2.g:309:1: ( '.' )
            {
            // InternalRefactoringTestLanguage2.g:309:1: ( '.' )
            // InternalRefactoringTestLanguage2.g:310:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // InternalRefactoringTestLanguage2.g:319:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:323:1: ( rule__FQN__Group_1__1__Impl )
            // InternalRefactoringTestLanguage2.g:324:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group_1__1__Impl();

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
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // InternalRefactoringTestLanguage2.g:330:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:334:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage2.g:335:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage2.g:335:1: ( RULE_ID )
            // InternalRefactoringTestLanguage2.g:336:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__FQN__Group_2__0"
    // InternalRefactoringTestLanguage2.g:346:1: rule__FQN__Group_2__0 : rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 ;
    public final void rule__FQN__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:350:1: ( rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 )
            // InternalRefactoringTestLanguage2.g:351:2: rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__FQN__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group_2__1();

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
    // $ANTLR end "rule__FQN__Group_2__0"


    // $ANTLR start "rule__FQN__Group_2__0__Impl"
    // InternalRefactoringTestLanguage2.g:358:1: rule__FQN__Group_2__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:362:1: ( ( '$' ) )
            // InternalRefactoringTestLanguage2.g:363:1: ( '$' )
            {
            // InternalRefactoringTestLanguage2.g:363:1: ( '$' )
            // InternalRefactoringTestLanguage2.g:364:2: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 

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
    // $ANTLR end "rule__FQN__Group_2__0__Impl"


    // $ANTLR start "rule__FQN__Group_2__1"
    // InternalRefactoringTestLanguage2.g:373:1: rule__FQN__Group_2__1 : rule__FQN__Group_2__1__Impl ;
    public final void rule__FQN__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:377:1: ( rule__FQN__Group_2__1__Impl )
            // InternalRefactoringTestLanguage2.g:378:2: rule__FQN__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group_2__1__Impl();

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
    // $ANTLR end "rule__FQN__Group_2__1"


    // $ANTLR start "rule__FQN__Group_2__1__Impl"
    // InternalRefactoringTestLanguage2.g:384:1: rule__FQN__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:388:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage2.g:389:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage2.g:389:1: ( RULE_ID )
            // InternalRefactoringTestLanguage2.g:390:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 

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
    // $ANTLR end "rule__FQN__Group_2__1__Impl"


    // $ANTLR start "rule__Model__ReferenceHolderAssignment"
    // InternalRefactoringTestLanguage2.g:400:1: rule__Model__ReferenceHolderAssignment : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:404:1: ( ( ruleReferenceHolder ) )
            // InternalRefactoringTestLanguage2.g:405:2: ( ruleReferenceHolder )
            {
            // InternalRefactoringTestLanguage2.g:405:2: ( ruleReferenceHolder )
            // InternalRefactoringTestLanguage2.g:406:3: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__ReferenceHolderAssignment"


    // $ANTLR start "rule__ReferenceHolder__NameAssignment_0"
    // InternalRefactoringTestLanguage2.g:415:1: rule__ReferenceHolder__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ReferenceHolder__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:419:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage2.g:420:2: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage2.g:420:2: ( RULE_ID )
            // InternalRefactoringTestLanguage2.g:421:3: RULE_ID
            {
             before(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__NameAssignment_0"


    // $ANTLR start "rule__ReferenceHolder__DefaultReferenceAssignment_1"
    // InternalRefactoringTestLanguage2.g:430:1: rule__ReferenceHolder__DefaultReferenceAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage2.g:434:1: ( ( ( ruleFQN ) ) )
            // InternalRefactoringTestLanguage2.g:435:2: ( ( ruleFQN ) )
            {
            // InternalRefactoringTestLanguage2.g:435:2: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage2.g:436:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 
            // InternalRefactoringTestLanguage2.g:437:3: ( ruleFQN )
            // InternalRefactoringTestLanguage2.g:438:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__DefaultReferenceAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001002L});

}