package org.eclipse.xtext.xbase.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalXtypeParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'=>'", "'('", "')'", "','", "'<'", "'>'", "'.'", "'?'", "'extends'", "'&'", "'super'", "'*'", "'import'", "';'", "'static'", "'extension'"
    };
    public static final int RULE_ID=4;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=7;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=6;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int RULE_WS=8;

    // delegates
    // delegators


        public InternalXtypeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtypeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtypeParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXtype.g"; }


    	private XtypeGrammarAccess grammarAccess;

    	public void setGrammarAccess(XtypeGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleJvmTypeReference"
    // InternalXtype.g:57:1: entryRuleJvmTypeReference : ruleJvmTypeReference EOF ;
    public final void entryRuleJvmTypeReference() throws RecognitionException {
        try {
            // InternalXtype.g:58:1: ( ruleJvmTypeReference EOF )
            // InternalXtype.g:59:1: ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // InternalXtype.g:66:1: ruleJvmTypeReference : ( ( rule__JvmTypeReference__Alternatives ) ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:70:2: ( ( ( rule__JvmTypeReference__Alternatives ) ) )
            // InternalXtype.g:71:2: ( ( rule__JvmTypeReference__Alternatives ) )
            {
            // InternalXtype.g:71:2: ( ( rule__JvmTypeReference__Alternatives ) )
            // InternalXtype.g:72:3: ( rule__JvmTypeReference__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); 
            }
            // InternalXtype.g:73:3: ( rule__JvmTypeReference__Alternatives )
            // InternalXtype.g:73:4: rule__JvmTypeReference__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JvmTypeReference__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); 
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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // InternalXtype.g:82:1: entryRuleArrayBrackets : ruleArrayBrackets EOF ;
    public final void entryRuleArrayBrackets() throws RecognitionException {
        try {
            // InternalXtype.g:83:1: ( ruleArrayBrackets EOF )
            // InternalXtype.g:84:1: ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // InternalXtype.g:91:1: ruleArrayBrackets : ( ( rule__ArrayBrackets__Group__0 ) ) ;
    public final void ruleArrayBrackets() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:95:2: ( ( ( rule__ArrayBrackets__Group__0 ) ) )
            // InternalXtype.g:96:2: ( ( rule__ArrayBrackets__Group__0 ) )
            {
            // InternalXtype.g:96:2: ( ( rule__ArrayBrackets__Group__0 ) )
            // InternalXtype.g:97:3: ( rule__ArrayBrackets__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getGroup()); 
            }
            // InternalXtype.g:98:3: ( rule__ArrayBrackets__Group__0 )
            // InternalXtype.g:98:4: rule__ArrayBrackets__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayBrackets__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsAccess().getGroup()); 
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
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // InternalXtype.g:107:1: entryRuleXFunctionTypeRef : ruleXFunctionTypeRef EOF ;
    public final void entryRuleXFunctionTypeRef() throws RecognitionException {
        try {
            // InternalXtype.g:108:1: ( ruleXFunctionTypeRef EOF )
            // InternalXtype.g:109:1: ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // InternalXtype.g:116:1: ruleXFunctionTypeRef : ( ( rule__XFunctionTypeRef__Group__0 ) ) ;
    public final void ruleXFunctionTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:120:2: ( ( ( rule__XFunctionTypeRef__Group__0 ) ) )
            // InternalXtype.g:121:2: ( ( rule__XFunctionTypeRef__Group__0 ) )
            {
            // InternalXtype.g:121:2: ( ( rule__XFunctionTypeRef__Group__0 ) )
            // InternalXtype.g:122:3: ( rule__XFunctionTypeRef__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup()); 
            }
            // InternalXtype.g:123:3: ( rule__XFunctionTypeRef__Group__0 )
            // InternalXtype.g:123:4: rule__XFunctionTypeRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup()); 
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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // InternalXtype.g:132:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // InternalXtype.g:133:1: ( ruleJvmParameterizedTypeReference EOF )
            // InternalXtype.g:134:1: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // InternalXtype.g:141:1: ruleJvmParameterizedTypeReference : ( ( rule__JvmParameterizedTypeReference__Group__0 ) ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:145:2: ( ( ( rule__JvmParameterizedTypeReference__Group__0 ) ) )
            // InternalXtype.g:146:2: ( ( rule__JvmParameterizedTypeReference__Group__0 ) )
            {
            // InternalXtype.g:146:2: ( ( rule__JvmParameterizedTypeReference__Group__0 ) )
            // InternalXtype.g:147:3: ( rule__JvmParameterizedTypeReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); 
            }
            // InternalXtype.g:148:3: ( rule__JvmParameterizedTypeReference__Group__0 )
            // InternalXtype.g:148:4: rule__JvmParameterizedTypeReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); 
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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // InternalXtype.g:157:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // InternalXtype.g:158:1: ( ruleJvmArgumentTypeReference EOF )
            // InternalXtype.g:159:1: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // InternalXtype.g:166:1: ruleJvmArgumentTypeReference : ( ( rule__JvmArgumentTypeReference__Alternatives ) ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:170:2: ( ( ( rule__JvmArgumentTypeReference__Alternatives ) ) )
            // InternalXtype.g:171:2: ( ( rule__JvmArgumentTypeReference__Alternatives ) )
            {
            // InternalXtype.g:171:2: ( ( rule__JvmArgumentTypeReference__Alternatives ) )
            // InternalXtype.g:172:3: ( rule__JvmArgumentTypeReference__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); 
            }
            // InternalXtype.g:173:3: ( rule__JvmArgumentTypeReference__Alternatives )
            // InternalXtype.g:173:4: rule__JvmArgumentTypeReference__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JvmArgumentTypeReference__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); 
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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // InternalXtype.g:182:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // InternalXtype.g:183:1: ( ruleJvmWildcardTypeReference EOF )
            // InternalXtype.g:184:1: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // InternalXtype.g:191:1: ruleJvmWildcardTypeReference : ( ( rule__JvmWildcardTypeReference__Group__0 ) ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:195:2: ( ( ( rule__JvmWildcardTypeReference__Group__0 ) ) )
            // InternalXtype.g:196:2: ( ( rule__JvmWildcardTypeReference__Group__0 ) )
            {
            // InternalXtype.g:196:2: ( ( rule__JvmWildcardTypeReference__Group__0 ) )
            // InternalXtype.g:197:3: ( rule__JvmWildcardTypeReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); 
            }
            // InternalXtype.g:198:3: ( rule__JvmWildcardTypeReference__Group__0 )
            // InternalXtype.g:198:4: rule__JvmWildcardTypeReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); 
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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // InternalXtype.g:207:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // InternalXtype.g:208:1: ( ruleJvmUpperBound EOF )
            // InternalXtype.g:209:1: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // InternalXtype.g:216:1: ruleJvmUpperBound : ( ( rule__JvmUpperBound__Group__0 ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:220:2: ( ( ( rule__JvmUpperBound__Group__0 ) ) )
            // InternalXtype.g:221:2: ( ( rule__JvmUpperBound__Group__0 ) )
            {
            // InternalXtype.g:221:2: ( ( rule__JvmUpperBound__Group__0 ) )
            // InternalXtype.g:222:3: ( rule__JvmUpperBound__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getGroup()); 
            }
            // InternalXtype.g:223:3: ( rule__JvmUpperBound__Group__0 )
            // InternalXtype.g:223:4: rule__JvmUpperBound__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmUpperBound__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getGroup()); 
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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // InternalXtype.g:232:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // InternalXtype.g:233:1: ( ruleJvmUpperBoundAnded EOF )
            // InternalXtype.g:234:1: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // InternalXtype.g:241:1: ruleJvmUpperBoundAnded : ( ( rule__JvmUpperBoundAnded__Group__0 ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:245:2: ( ( ( rule__JvmUpperBoundAnded__Group__0 ) ) )
            // InternalXtype.g:246:2: ( ( rule__JvmUpperBoundAnded__Group__0 ) )
            {
            // InternalXtype.g:246:2: ( ( rule__JvmUpperBoundAnded__Group__0 ) )
            // InternalXtype.g:247:3: ( rule__JvmUpperBoundAnded__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); 
            }
            // InternalXtype.g:248:3: ( rule__JvmUpperBoundAnded__Group__0 )
            // InternalXtype.g:248:4: rule__JvmUpperBoundAnded__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmUpperBoundAnded__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); 
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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // InternalXtype.g:257:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // InternalXtype.g:258:1: ( ruleJvmLowerBound EOF )
            // InternalXtype.g:259:1: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // InternalXtype.g:266:1: ruleJvmLowerBound : ( ( rule__JvmLowerBound__Group__0 ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:270:2: ( ( ( rule__JvmLowerBound__Group__0 ) ) )
            // InternalXtype.g:271:2: ( ( rule__JvmLowerBound__Group__0 ) )
            {
            // InternalXtype.g:271:2: ( ( rule__JvmLowerBound__Group__0 ) )
            // InternalXtype.g:272:3: ( rule__JvmLowerBound__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getGroup()); 
            }
            // InternalXtype.g:273:3: ( rule__JvmLowerBound__Group__0 )
            // InternalXtype.g:273:4: rule__JvmLowerBound__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmLowerBound__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getGroup()); 
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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // InternalXtype.g:282:1: entryRuleJvmLowerBoundAnded : ruleJvmLowerBoundAnded EOF ;
    public final void entryRuleJvmLowerBoundAnded() throws RecognitionException {
        try {
            // InternalXtype.g:283:1: ( ruleJvmLowerBoundAnded EOF )
            // InternalXtype.g:284:1: ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAndedRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // InternalXtype.g:291:1: ruleJvmLowerBoundAnded : ( ( rule__JvmLowerBoundAnded__Group__0 ) ) ;
    public final void ruleJvmLowerBoundAnded() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:295:2: ( ( ( rule__JvmLowerBoundAnded__Group__0 ) ) )
            // InternalXtype.g:296:2: ( ( rule__JvmLowerBoundAnded__Group__0 ) )
            {
            // InternalXtype.g:296:2: ( ( rule__JvmLowerBoundAnded__Group__0 ) )
            // InternalXtype.g:297:3: ( rule__JvmLowerBoundAnded__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAndedAccess().getGroup()); 
            }
            // InternalXtype.g:298:3: ( rule__JvmLowerBoundAnded__Group__0 )
            // InternalXtype.g:298:4: rule__JvmLowerBoundAnded__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmLowerBoundAnded__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAndedAccess().getGroup()); 
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
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalXtype.g:307:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalXtype.g:308:1: ( ruleQualifiedName EOF )
            // InternalXtype.g:309:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalXtype.g:316:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:320:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalXtype.g:321:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalXtype.g:321:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalXtype.g:322:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalXtype.g:323:3: ( rule__QualifiedName__Group__0 )
            // InternalXtype.g:323:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalXtype.g:332:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // InternalXtype.g:333:1: ( ruleQualifiedNameWithWildcard EOF )
            // InternalXtype.g:334:1: ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalXtype.g:341:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:345:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // InternalXtype.g:346:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // InternalXtype.g:346:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // InternalXtype.g:347:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            }
            // InternalXtype.g:348:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            // InternalXtype.g:348:4: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // InternalXtype.g:357:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // InternalXtype.g:358:1: ( ruleValidID EOF )
            // InternalXtype.g:359:1: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalXtype.g:366:1: ruleValidID : ( RULE_ID ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:370:2: ( ( RULE_ID ) )
            // InternalXtype.g:371:2: ( RULE_ID )
            {
            // InternalXtype.g:371:2: ( RULE_ID )
            // InternalXtype.g:372:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
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
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportDeclaration"
    // InternalXtype.g:382:1: entryRuleXImportDeclaration : ruleXImportDeclaration EOF ;
    public final void entryRuleXImportDeclaration() throws RecognitionException {
        try {
            // InternalXtype.g:383:1: ( ruleXImportDeclaration EOF )
            // InternalXtype.g:384:1: ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // InternalXtype.g:391:1: ruleXImportDeclaration : ( ( rule__XImportDeclaration__Group__0 ) ) ;
    public final void ruleXImportDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:395:2: ( ( ( rule__XImportDeclaration__Group__0 ) ) )
            // InternalXtype.g:396:2: ( ( rule__XImportDeclaration__Group__0 ) )
            {
            // InternalXtype.g:396:2: ( ( rule__XImportDeclaration__Group__0 ) )
            // InternalXtype.g:397:3: ( rule__XImportDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getGroup()); 
            }
            // InternalXtype.g:398:3: ( rule__XImportDeclaration__Group__0 )
            // InternalXtype.g:398:4: rule__XImportDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getGroup()); 
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
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // InternalXtype.g:407:1: entryRuleQualifiedNameInStaticImport : ruleQualifiedNameInStaticImport EOF ;
    public final void entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        try {
            // InternalXtype.g:408:1: ( ruleQualifiedNameInStaticImport EOF )
            // InternalXtype.g:409:1: ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameInStaticImportRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameInStaticImportRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // InternalXtype.g:416:1: ruleQualifiedNameInStaticImport : ( ( ( rule__QualifiedNameInStaticImport__Group__0 ) ) ( ( rule__QualifiedNameInStaticImport__Group__0 )* ) ) ;
    public final void ruleQualifiedNameInStaticImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:420:2: ( ( ( ( rule__QualifiedNameInStaticImport__Group__0 ) ) ( ( rule__QualifiedNameInStaticImport__Group__0 )* ) ) )
            // InternalXtype.g:421:2: ( ( ( rule__QualifiedNameInStaticImport__Group__0 ) ) ( ( rule__QualifiedNameInStaticImport__Group__0 )* ) )
            {
            // InternalXtype.g:421:2: ( ( ( rule__QualifiedNameInStaticImport__Group__0 ) ) ( ( rule__QualifiedNameInStaticImport__Group__0 )* ) )
            // InternalXtype.g:422:3: ( ( rule__QualifiedNameInStaticImport__Group__0 ) ) ( ( rule__QualifiedNameInStaticImport__Group__0 )* )
            {
            // InternalXtype.g:422:3: ( ( rule__QualifiedNameInStaticImport__Group__0 ) )
            // InternalXtype.g:423:4: ( rule__QualifiedNameInStaticImport__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); 
            }
            // InternalXtype.g:424:4: ( rule__QualifiedNameInStaticImport__Group__0 )
            // InternalXtype.g:424:5: rule__QualifiedNameInStaticImport__Group__0
            {
            pushFollow(FOLLOW_3);
            rule__QualifiedNameInStaticImport__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); 
            }

            }

            // InternalXtype.g:427:3: ( ( rule__QualifiedNameInStaticImport__Group__0 )* )
            // InternalXtype.g:428:4: ( rule__QualifiedNameInStaticImport__Group__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); 
            }
            // InternalXtype.g:429:4: ( rule__QualifiedNameInStaticImport__Group__0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==18) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // InternalXtype.g:429:5: rule__QualifiedNameInStaticImport__Group__0
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__QualifiedNameInStaticImport__Group__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); 
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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameInStaticImport"


    // $ANTLR start "rule__JvmTypeReference__Alternatives"
    // InternalXtype.g:438:1: rule__JvmTypeReference__Alternatives : ( ( ( rule__JvmTypeReference__Group_0__0 ) ) | ( ruleXFunctionTypeRef ) );
    public final void rule__JvmTypeReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:442:1: ( ( ( rule__JvmTypeReference__Group_0__0 ) ) | ( ruleXFunctionTypeRef ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtype.g:443:2: ( ( rule__JvmTypeReference__Group_0__0 ) )
                    {
                    // InternalXtype.g:443:2: ( ( rule__JvmTypeReference__Group_0__0 ) )
                    // InternalXtype.g:444:3: ( rule__JvmTypeReference__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); 
                    }
                    // InternalXtype.g:445:3: ( rule__JvmTypeReference__Group_0__0 )
                    // InternalXtype.g:445:4: rule__JvmTypeReference__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JvmTypeReference__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXtype.g:449:2: ( ruleXFunctionTypeRef )
                    {
                    // InternalXtype.g:449:2: ( ruleXFunctionTypeRef )
                    // InternalXtype.g:450:3: ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__JvmTypeReference__Alternatives"


    // $ANTLR start "rule__JvmArgumentTypeReference__Alternatives"
    // InternalXtype.g:459:1: rule__JvmArgumentTypeReference__Alternatives : ( ( ruleJvmTypeReference ) | ( ruleJvmWildcardTypeReference ) );
    public final void rule__JvmArgumentTypeReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:463:1: ( ( ruleJvmTypeReference ) | ( ruleJvmWildcardTypeReference ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID||(LA3_0>=12 && LA3_0<=13)) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtype.g:464:2: ( ruleJvmTypeReference )
                    {
                    // InternalXtype.g:464:2: ( ruleJvmTypeReference )
                    // InternalXtype.g:465:3: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXtype.g:470:2: ( ruleJvmWildcardTypeReference )
                    {
                    // InternalXtype.g:470:2: ( ruleJvmWildcardTypeReference )
                    // InternalXtype.g:471:3: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__JvmArgumentTypeReference__Alternatives"


    // $ANTLR start "rule__JvmWildcardTypeReference__Alternatives_2"
    // InternalXtype.g:480:1: rule__JvmWildcardTypeReference__Alternatives_2 : ( ( ( rule__JvmWildcardTypeReference__Group_2_0__0 ) ) | ( ( rule__JvmWildcardTypeReference__Group_2_1__0 ) ) );
    public final void rule__JvmWildcardTypeReference__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:484:1: ( ( ( rule__JvmWildcardTypeReference__Group_2_0__0 ) ) | ( ( rule__JvmWildcardTypeReference__Group_2_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==22) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtype.g:485:2: ( ( rule__JvmWildcardTypeReference__Group_2_0__0 ) )
                    {
                    // InternalXtype.g:485:2: ( ( rule__JvmWildcardTypeReference__Group_2_0__0 ) )
                    // InternalXtype.g:486:3: ( rule__JvmWildcardTypeReference__Group_2_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0()); 
                    }
                    // InternalXtype.g:487:3: ( rule__JvmWildcardTypeReference__Group_2_0__0 )
                    // InternalXtype.g:487:4: rule__JvmWildcardTypeReference__Group_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JvmWildcardTypeReference__Group_2_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXtype.g:491:2: ( ( rule__JvmWildcardTypeReference__Group_2_1__0 ) )
                    {
                    // InternalXtype.g:491:2: ( ( rule__JvmWildcardTypeReference__Group_2_1__0 ) )
                    // InternalXtype.g:492:3: ( rule__JvmWildcardTypeReference__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1()); 
                    }
                    // InternalXtype.g:493:3: ( rule__JvmWildcardTypeReference__Group_2_1__0 )
                    // InternalXtype.g:493:4: rule__JvmWildcardTypeReference__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JvmWildcardTypeReference__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1()); 
                    }

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Alternatives_2"


    // $ANTLR start "rule__XImportDeclaration__Alternatives_1"
    // InternalXtype.g:501:1: rule__XImportDeclaration__Alternatives_1 : ( ( ( rule__XImportDeclaration__Group_1_0__0 ) ) | ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_1 ) ) | ( ( rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 ) ) );
    public final void rule__XImportDeclaration__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:505:1: ( ( ( rule__XImportDeclaration__Group_1_0__0 ) ) | ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_1 ) ) | ( ( rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 ) ) )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalXtype.g:506:2: ( ( rule__XImportDeclaration__Group_1_0__0 ) )
                    {
                    // InternalXtype.g:506:2: ( ( rule__XImportDeclaration__Group_1_0__0 ) )
                    // InternalXtype.g:507:3: ( rule__XImportDeclaration__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclarationAccess().getGroup_1_0()); 
                    }
                    // InternalXtype.g:508:3: ( rule__XImportDeclaration__Group_1_0__0 )
                    // InternalXtype.g:508:4: rule__XImportDeclaration__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XImportDeclaration__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclarationAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXtype.g:512:2: ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_1 ) )
                    {
                    // InternalXtype.g:512:2: ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_1 ) )
                    // InternalXtype.g:513:3: ( rule__XImportDeclaration__ImportedTypeAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1()); 
                    }
                    // InternalXtype.g:514:3: ( rule__XImportDeclaration__ImportedTypeAssignment_1_1 )
                    // InternalXtype.g:514:4: rule__XImportDeclaration__ImportedTypeAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XImportDeclaration__ImportedTypeAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXtype.g:518:2: ( ( rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 ) )
                    {
                    // InternalXtype.g:518:2: ( ( rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 ) )
                    // InternalXtype.g:519:3: ( rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2()); 
                    }
                    // InternalXtype.g:520:3: ( rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 )
                    // InternalXtype.g:520:4: rule__XImportDeclaration__ImportedNamespaceAssignment_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__XImportDeclaration__ImportedNamespaceAssignment_1_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2()); 
                    }

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
    // $ANTLR end "rule__XImportDeclaration__Alternatives_1"


    // $ANTLR start "rule__XImportDeclaration__Alternatives_1_0_3"
    // InternalXtype.g:528:1: rule__XImportDeclaration__Alternatives_1_0_3 : ( ( ( rule__XImportDeclaration__WildcardAssignment_1_0_3_0 ) ) | ( ( rule__XImportDeclaration__MemberNameAssignment_1_0_3_1 ) ) );
    public final void rule__XImportDeclaration__Alternatives_1_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:532:1: ( ( ( rule__XImportDeclaration__WildcardAssignment_1_0_3_0 ) ) | ( ( rule__XImportDeclaration__MemberNameAssignment_1_0_3_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtype.g:533:2: ( ( rule__XImportDeclaration__WildcardAssignment_1_0_3_0 ) )
                    {
                    // InternalXtype.g:533:2: ( ( rule__XImportDeclaration__WildcardAssignment_1_0_3_0 ) )
                    // InternalXtype.g:534:3: ( rule__XImportDeclaration__WildcardAssignment_1_0_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0()); 
                    }
                    // InternalXtype.g:535:3: ( rule__XImportDeclaration__WildcardAssignment_1_0_3_0 )
                    // InternalXtype.g:535:4: rule__XImportDeclaration__WildcardAssignment_1_0_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XImportDeclaration__WildcardAssignment_1_0_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXtype.g:539:2: ( ( rule__XImportDeclaration__MemberNameAssignment_1_0_3_1 ) )
                    {
                    // InternalXtype.g:539:2: ( ( rule__XImportDeclaration__MemberNameAssignment_1_0_3_1 ) )
                    // InternalXtype.g:540:3: ( rule__XImportDeclaration__MemberNameAssignment_1_0_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1()); 
                    }
                    // InternalXtype.g:541:3: ( rule__XImportDeclaration__MemberNameAssignment_1_0_3_1 )
                    // InternalXtype.g:541:4: rule__XImportDeclaration__MemberNameAssignment_1_0_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XImportDeclaration__MemberNameAssignment_1_0_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1()); 
                    }

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
    // $ANTLR end "rule__XImportDeclaration__Alternatives_1_0_3"


    // $ANTLR start "rule__JvmTypeReference__Group_0__0"
    // InternalXtype.g:549:1: rule__JvmTypeReference__Group_0__0 : rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1 ;
    public final void rule__JvmTypeReference__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:553:1: ( rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1 )
            // InternalXtype.g:554:2: rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1
            {
            pushFollow(FOLLOW_4);
            rule__JvmTypeReference__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmTypeReference__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmTypeReference__Group_0__0"


    // $ANTLR start "rule__JvmTypeReference__Group_0__0__Impl"
    // InternalXtype.g:561:1: rule__JvmTypeReference__Group_0__0__Impl : ( ruleJvmParameterizedTypeReference ) ;
    public final void rule__JvmTypeReference__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:565:1: ( ( ruleJvmParameterizedTypeReference ) )
            // InternalXtype.g:566:1: ( ruleJvmParameterizedTypeReference )
            {
            // InternalXtype.g:566:1: ( ruleJvmParameterizedTypeReference )
            // InternalXtype.g:567:2: ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0__1"
    // InternalXtype.g:576:1: rule__JvmTypeReference__Group_0__1 : rule__JvmTypeReference__Group_0__1__Impl ;
    public final void rule__JvmTypeReference__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:580:1: ( rule__JvmTypeReference__Group_0__1__Impl )
            // InternalXtype.g:581:2: rule__JvmTypeReference__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmTypeReference__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmTypeReference__Group_0__1"


    // $ANTLR start "rule__JvmTypeReference__Group_0__1__Impl"
    // InternalXtype.g:587:1: rule__JvmTypeReference__Group_0__1__Impl : ( ( rule__JvmTypeReference__Group_0_1__0 )* ) ;
    public final void rule__JvmTypeReference__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:591:1: ( ( ( rule__JvmTypeReference__Group_0_1__0 )* ) )
            // InternalXtype.g:592:1: ( ( rule__JvmTypeReference__Group_0_1__0 )* )
            {
            // InternalXtype.g:592:1: ( ( rule__JvmTypeReference__Group_0_1__0 )* )
            // InternalXtype.g:593:2: ( rule__JvmTypeReference__Group_0_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); 
            }
            // InternalXtype.g:594:2: ( rule__JvmTypeReference__Group_0_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==10) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXtype.g:594:3: rule__JvmTypeReference__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__JvmTypeReference__Group_0_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0__1__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1__0"
    // InternalXtype.g:603:1: rule__JvmTypeReference__Group_0_1__0 : rule__JvmTypeReference__Group_0_1__0__Impl ;
    public final void rule__JvmTypeReference__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:607:1: ( rule__JvmTypeReference__Group_0_1__0__Impl )
            // InternalXtype.g:608:2: rule__JvmTypeReference__Group_0_1__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmTypeReference__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1__0"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1__0__Impl"
    // InternalXtype.g:614:1: rule__JvmTypeReference__Group_0_1__0__Impl : ( ( rule__JvmTypeReference__Group_0_1_0__0 ) ) ;
    public final void rule__JvmTypeReference__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:618:1: ( ( ( rule__JvmTypeReference__Group_0_1_0__0 ) ) )
            // InternalXtype.g:619:1: ( ( rule__JvmTypeReference__Group_0_1_0__0 ) )
            {
            // InternalXtype.g:619:1: ( ( rule__JvmTypeReference__Group_0_1_0__0 ) )
            // InternalXtype.g:620:2: ( rule__JvmTypeReference__Group_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); 
            }
            // InternalXtype.g:621:2: ( rule__JvmTypeReference__Group_0_1_0__0 )
            // InternalXtype.g:621:3: rule__JvmTypeReference__Group_0_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmTypeReference__Group_0_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__0"
    // InternalXtype.g:630:1: rule__JvmTypeReference__Group_0_1_0__0 : rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1 ;
    public final void rule__JvmTypeReference__Group_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:634:1: ( rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1 )
            // InternalXtype.g:635:2: rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1
            {
            pushFollow(FOLLOW_4);
            rule__JvmTypeReference__Group_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmTypeReference__Group_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__0"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__0__Impl"
    // InternalXtype.g:642:1: rule__JvmTypeReference__Group_0_1_0__0__Impl : ( () ) ;
    public final void rule__JvmTypeReference__Group_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:646:1: ( ( () ) )
            // InternalXtype.g:647:1: ( () )
            {
            // InternalXtype.g:647:1: ( () )
            // InternalXtype.g:648:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); 
            }
            // InternalXtype.g:649:2: ()
            // InternalXtype.g:649:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__1"
    // InternalXtype.g:657:1: rule__JvmTypeReference__Group_0_1_0__1 : rule__JvmTypeReference__Group_0_1_0__1__Impl ;
    public final void rule__JvmTypeReference__Group_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:661:1: ( rule__JvmTypeReference__Group_0_1_0__1__Impl )
            // InternalXtype.g:662:2: rule__JvmTypeReference__Group_0_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmTypeReference__Group_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__1"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__1__Impl"
    // InternalXtype.g:668:1: rule__JvmTypeReference__Group_0_1_0__1__Impl : ( ruleArrayBrackets ) ;
    public final void rule__JvmTypeReference__Group_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:672:1: ( ( ruleArrayBrackets ) )
            // InternalXtype.g:673:1: ( ruleArrayBrackets )
            {
            // InternalXtype.g:673:1: ( ruleArrayBrackets )
            // InternalXtype.g:674:2: ruleArrayBrackets
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__1__Impl"


    // $ANTLR start "rule__ArrayBrackets__Group__0"
    // InternalXtype.g:684:1: rule__ArrayBrackets__Group__0 : rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 ;
    public final void rule__ArrayBrackets__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:688:1: ( rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 )
            // InternalXtype.g:689:2: rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__ArrayBrackets__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayBrackets__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArrayBrackets__Group__0"


    // $ANTLR start "rule__ArrayBrackets__Group__0__Impl"
    // InternalXtype.g:696:1: rule__ArrayBrackets__Group__0__Impl : ( '[' ) ;
    public final void rule__ArrayBrackets__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:700:1: ( ( '[' ) )
            // InternalXtype.g:701:1: ( '[' )
            {
            // InternalXtype.g:701:1: ( '[' )
            // InternalXtype.g:702:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
            }
            match(input,10,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
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
    // $ANTLR end "rule__ArrayBrackets__Group__0__Impl"


    // $ANTLR start "rule__ArrayBrackets__Group__1"
    // InternalXtype.g:711:1: rule__ArrayBrackets__Group__1 : rule__ArrayBrackets__Group__1__Impl ;
    public final void rule__ArrayBrackets__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:715:1: ( rule__ArrayBrackets__Group__1__Impl )
            // InternalXtype.g:716:2: rule__ArrayBrackets__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayBrackets__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArrayBrackets__Group__1"


    // $ANTLR start "rule__ArrayBrackets__Group__1__Impl"
    // InternalXtype.g:722:1: rule__ArrayBrackets__Group__1__Impl : ( ']' ) ;
    public final void rule__ArrayBrackets__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:726:1: ( ( ']' ) )
            // InternalXtype.g:727:1: ( ']' )
            {
            // InternalXtype.g:727:1: ( ']' )
            // InternalXtype.g:728:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
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
    // $ANTLR end "rule__ArrayBrackets__Group__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group__0"
    // InternalXtype.g:738:1: rule__XFunctionTypeRef__Group__0 : rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1 ;
    public final void rule__XFunctionTypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:742:1: ( rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1 )
            // InternalXtype.g:743:2: rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__XFunctionTypeRef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group__0__Impl"
    // InternalXtype.g:750:1: rule__XFunctionTypeRef__Group__0__Impl : ( ( rule__XFunctionTypeRef__Group_0__0 )? ) ;
    public final void rule__XFunctionTypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:754:1: ( ( ( rule__XFunctionTypeRef__Group_0__0 )? ) )
            // InternalXtype.g:755:1: ( ( rule__XFunctionTypeRef__Group_0__0 )? )
            {
            // InternalXtype.g:755:1: ( ( rule__XFunctionTypeRef__Group_0__0 )? )
            // InternalXtype.g:756:2: ( rule__XFunctionTypeRef__Group_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); 
            }
            // InternalXtype.g:757:2: ( rule__XFunctionTypeRef__Group_0__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtype.g:757:3: rule__XFunctionTypeRef__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XFunctionTypeRef__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group__1"
    // InternalXtype.g:765:1: rule__XFunctionTypeRef__Group__1 : rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2 ;
    public final void rule__XFunctionTypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:769:1: ( rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2 )
            // InternalXtype.g:770:2: rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__XFunctionTypeRef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group__1__Impl"
    // InternalXtype.g:777:1: rule__XFunctionTypeRef__Group__1__Impl : ( '=>' ) ;
    public final void rule__XFunctionTypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:781:1: ( ( '=>' ) )
            // InternalXtype.g:782:1: ( '=>' )
            {
            // InternalXtype.g:782:1: ( '=>' )
            // InternalXtype.g:783:2: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group__2"
    // InternalXtype.g:792:1: rule__XFunctionTypeRef__Group__2 : rule__XFunctionTypeRef__Group__2__Impl ;
    public final void rule__XFunctionTypeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:796:1: ( rule__XFunctionTypeRef__Group__2__Impl )
            // InternalXtype.g:797:2: rule__XFunctionTypeRef__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group__2"


    // $ANTLR start "rule__XFunctionTypeRef__Group__2__Impl"
    // InternalXtype.g:803:1: rule__XFunctionTypeRef__Group__2__Impl : ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) ) ;
    public final void rule__XFunctionTypeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:807:1: ( ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) ) )
            // InternalXtype.g:808:1: ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) )
            {
            // InternalXtype.g:808:1: ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) )
            // InternalXtype.g:809:2: ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); 
            }
            // InternalXtype.g:810:2: ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 )
            // InternalXtype.g:810:3: rule__XFunctionTypeRef__ReturnTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__ReturnTypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group__2__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__0"
    // InternalXtype.g:819:1: rule__XFunctionTypeRef__Group_0__0 : rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1 ;
    public final void rule__XFunctionTypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:823:1: ( rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1 )
            // InternalXtype.g:824:2: rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1
            {
            pushFollow(FOLLOW_9);
            rule__XFunctionTypeRef__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__0__Impl"
    // InternalXtype.g:831:1: rule__XFunctionTypeRef__Group_0__0__Impl : ( '(' ) ;
    public final void rule__XFunctionTypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:835:1: ( ( '(' ) )
            // InternalXtype.g:836:1: ( '(' )
            {
            // InternalXtype.g:836:1: ( '(' )
            // InternalXtype.g:837:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,13,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__1"
    // InternalXtype.g:846:1: rule__XFunctionTypeRef__Group_0__1 : rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2 ;
    public final void rule__XFunctionTypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:850:1: ( rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2 )
            // InternalXtype.g:851:2: rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2
            {
            pushFollow(FOLLOW_9);
            rule__XFunctionTypeRef__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__1__Impl"
    // InternalXtype.g:858:1: rule__XFunctionTypeRef__Group_0__1__Impl : ( ( rule__XFunctionTypeRef__Group_0_1__0 )? ) ;
    public final void rule__XFunctionTypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:862:1: ( ( ( rule__XFunctionTypeRef__Group_0_1__0 )? ) )
            // InternalXtype.g:863:1: ( ( rule__XFunctionTypeRef__Group_0_1__0 )? )
            {
            // InternalXtype.g:863:1: ( ( rule__XFunctionTypeRef__Group_0_1__0 )? )
            // InternalXtype.g:864:2: ( rule__XFunctionTypeRef__Group_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); 
            }
            // InternalXtype.g:865:2: ( rule__XFunctionTypeRef__Group_0_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||(LA9_0>=12 && LA9_0<=13)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXtype.g:865:3: rule__XFunctionTypeRef__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XFunctionTypeRef__Group_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__2"
    // InternalXtype.g:873:1: rule__XFunctionTypeRef__Group_0__2 : rule__XFunctionTypeRef__Group_0__2__Impl ;
    public final void rule__XFunctionTypeRef__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:877:1: ( rule__XFunctionTypeRef__Group_0__2__Impl )
            // InternalXtype.g:878:2: rule__XFunctionTypeRef__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__2"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__2__Impl"
    // InternalXtype.g:884:1: rule__XFunctionTypeRef__Group_0__2__Impl : ( ')' ) ;
    public final void rule__XFunctionTypeRef__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:888:1: ( ( ')' ) )
            // InternalXtype.g:889:1: ( ')' )
            {
            // InternalXtype.g:889:1: ( ')' )
            // InternalXtype.g:890:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__2__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__0"
    // InternalXtype.g:900:1: rule__XFunctionTypeRef__Group_0_1__0 : rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1 ;
    public final void rule__XFunctionTypeRef__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:904:1: ( rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1 )
            // InternalXtype.g:905:2: rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1
            {
            pushFollow(FOLLOW_10);
            rule__XFunctionTypeRef__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group_0_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__0__Impl"
    // InternalXtype.g:912:1: rule__XFunctionTypeRef__Group_0_1__0__Impl : ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) ) ;
    public final void rule__XFunctionTypeRef__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:916:1: ( ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) ) )
            // InternalXtype.g:917:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) )
            {
            // InternalXtype.g:917:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) )
            // InternalXtype.g:918:2: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); 
            }
            // InternalXtype.g:919:2: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 )
            // InternalXtype.g:919:3: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__1"
    // InternalXtype.g:927:1: rule__XFunctionTypeRef__Group_0_1__1 : rule__XFunctionTypeRef__Group_0_1__1__Impl ;
    public final void rule__XFunctionTypeRef__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:931:1: ( rule__XFunctionTypeRef__Group_0_1__1__Impl )
            // InternalXtype.g:932:2: rule__XFunctionTypeRef__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__1__Impl"
    // InternalXtype.g:938:1: rule__XFunctionTypeRef__Group_0_1__1__Impl : ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* ) ;
    public final void rule__XFunctionTypeRef__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:942:1: ( ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* ) )
            // InternalXtype.g:943:1: ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* )
            {
            // InternalXtype.g:943:1: ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* )
            // InternalXtype.g:944:2: ( rule__XFunctionTypeRef__Group_0_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); 
            }
            // InternalXtype.g:945:2: ( rule__XFunctionTypeRef__Group_0_1_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalXtype.g:945:3: rule__XFunctionTypeRef__Group_0_1_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__XFunctionTypeRef__Group_0_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__0"
    // InternalXtype.g:954:1: rule__XFunctionTypeRef__Group_0_1_1__0 : rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1 ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:958:1: ( rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1 )
            // InternalXtype.g:959:2: rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1
            {
            pushFollow(FOLLOW_8);
            rule__XFunctionTypeRef__Group_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__0__Impl"
    // InternalXtype.g:966:1: rule__XFunctionTypeRef__Group_0_1_1__0__Impl : ( ',' ) ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:970:1: ( ( ',' ) )
            // InternalXtype.g:971:1: ( ',' )
            {
            // InternalXtype.g:971:1: ( ',' )
            // InternalXtype.g:972:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__1"
    // InternalXtype.g:981:1: rule__XFunctionTypeRef__Group_0_1_1__1 : rule__XFunctionTypeRef__Group_0_1_1__1__Impl ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:985:1: ( rule__XFunctionTypeRef__Group_0_1_1__1__Impl )
            // InternalXtype.g:986:2: rule__XFunctionTypeRef__Group_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__Group_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__1__Impl"
    // InternalXtype.g:992:1: rule__XFunctionTypeRef__Group_0_1_1__1__Impl : ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) ) ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:996:1: ( ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) ) )
            // InternalXtype.g:997:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) )
            {
            // InternalXtype.g:997:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) )
            // InternalXtype.g:998:2: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); 
            }
            // InternalXtype.g:999:2: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 )
            // InternalXtype.g:999:3: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__0"
    // InternalXtype.g:1008:1: rule__JvmParameterizedTypeReference__Group__0 : rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 ;
    public final void rule__JvmParameterizedTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1012:1: ( rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 )
            // InternalXtype.g:1013:2: rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__JvmParameterizedTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__0__Impl"
    // InternalXtype.g:1020:1: rule__JvmParameterizedTypeReference__Group__0__Impl : ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1024:1: ( ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) )
            // InternalXtype.g:1025:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            {
            // InternalXtype.g:1025:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            // InternalXtype.g:1026:2: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); 
            }
            // InternalXtype.g:1027:2: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            // InternalXtype.g:1027:3: rule__JvmParameterizedTypeReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__1"
    // InternalXtype.g:1035:1: rule__JvmParameterizedTypeReference__Group__1 : rule__JvmParameterizedTypeReference__Group__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1039:1: ( rule__JvmParameterizedTypeReference__Group__1__Impl )
            // InternalXtype.g:1040:2: rule__JvmParameterizedTypeReference__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__1__Impl"
    // InternalXtype.g:1046:1: rule__JvmParameterizedTypeReference__Group__1__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) ;
    public final void rule__JvmParameterizedTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1050:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) )
            // InternalXtype.g:1051:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            {
            // InternalXtype.g:1051:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            // InternalXtype.g:1052:2: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); 
            }
            // InternalXtype.g:1053:2: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtype.g:1053:3: rule__JvmParameterizedTypeReference__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JvmParameterizedTypeReference__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__0"
    // InternalXtype.g:1062:1: rule__JvmParameterizedTypeReference__Group_1__0 : rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1066:1: ( rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 )
            // InternalXtype.g:1067:2: rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1
            {
            pushFollow(FOLLOW_13);
            rule__JvmParameterizedTypeReference__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__0__Impl"
    // InternalXtype.g:1074:1: rule__JvmParameterizedTypeReference__Group_1__0__Impl : ( ( '<' ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1078:1: ( ( ( '<' ) ) )
            // InternalXtype.g:1079:1: ( ( '<' ) )
            {
            // InternalXtype.g:1079:1: ( ( '<' ) )
            // InternalXtype.g:1080:2: ( '<' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); 
            }
            // InternalXtype.g:1081:2: ( '<' )
            // InternalXtype.g:1081:3: '<'
            {
            match(input,16,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__1"
    // InternalXtype.g:1089:1: rule__JvmParameterizedTypeReference__Group_1__1 : rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1093:1: ( rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 )
            // InternalXtype.g:1094:2: rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2
            {
            pushFollow(FOLLOW_14);
            rule__JvmParameterizedTypeReference__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__1__Impl"
    // InternalXtype.g:1101:1: rule__JvmParameterizedTypeReference__Group_1__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1105:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) )
            // InternalXtype.g:1106:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            {
            // InternalXtype.g:1106:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            // InternalXtype.g:1107:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); 
            }
            // InternalXtype.g:1108:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            // InternalXtype.g:1108:3: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__2"
    // InternalXtype.g:1116:1: rule__JvmParameterizedTypeReference__Group_1__2 : rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1120:1: ( rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 )
            // InternalXtype.g:1121:2: rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3
            {
            pushFollow(FOLLOW_14);
            rule__JvmParameterizedTypeReference__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__2"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__2__Impl"
    // InternalXtype.g:1128:1: rule__JvmParameterizedTypeReference__Group_1__2__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1132:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) )
            // InternalXtype.g:1133:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            {
            // InternalXtype.g:1133:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            // InternalXtype.g:1134:2: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); 
            }
            // InternalXtype.g:1135:2: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalXtype.g:1135:3: rule__JvmParameterizedTypeReference__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__JvmParameterizedTypeReference__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__2__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__3"
    // InternalXtype.g:1143:1: rule__JvmParameterizedTypeReference__Group_1__3 : rule__JvmParameterizedTypeReference__Group_1__3__Impl rule__JvmParameterizedTypeReference__Group_1__4 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1147:1: ( rule__JvmParameterizedTypeReference__Group_1__3__Impl rule__JvmParameterizedTypeReference__Group_1__4 )
            // InternalXtype.g:1148:2: rule__JvmParameterizedTypeReference__Group_1__3__Impl rule__JvmParameterizedTypeReference__Group_1__4
            {
            pushFollow(FOLLOW_15);
            rule__JvmParameterizedTypeReference__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__3"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__3__Impl"
    // InternalXtype.g:1155:1: rule__JvmParameterizedTypeReference__Group_1__3__Impl : ( '>' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1159:1: ( ( '>' ) )
            // InternalXtype.g:1160:1: ( '>' )
            {
            // InternalXtype.g:1160:1: ( '>' )
            // InternalXtype.g:1161:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__3__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__4"
    // InternalXtype.g:1170:1: rule__JvmParameterizedTypeReference__Group_1__4 : rule__JvmParameterizedTypeReference__Group_1__4__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1174:1: ( rule__JvmParameterizedTypeReference__Group_1__4__Impl )
            // InternalXtype.g:1175:2: rule__JvmParameterizedTypeReference__Group_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__4"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__4__Impl"
    // InternalXtype.g:1181:1: rule__JvmParameterizedTypeReference__Group_1__4__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_4__0 )* ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1185:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_4__0 )* ) )
            // InternalXtype.g:1186:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4__0 )* )
            {
            // InternalXtype.g:1186:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4__0 )* )
            // InternalXtype.g:1187:2: ( rule__JvmParameterizedTypeReference__Group_1_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4()); 
            }
            // InternalXtype.g:1188:2: ( rule__JvmParameterizedTypeReference__Group_1_4__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==18) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalXtype.g:1188:3: rule__JvmParameterizedTypeReference__Group_1_4__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__JvmParameterizedTypeReference__Group_1_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__4__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__0"
    // InternalXtype.g:1197:1: rule__JvmParameterizedTypeReference__Group_1_2__0 : rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1201:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 )
            // InternalXtype.g:1202:2: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1
            {
            pushFollow(FOLLOW_13);
            rule__JvmParameterizedTypeReference__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__0__Impl"
    // InternalXtype.g:1209:1: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1213:1: ( ( ',' ) )
            // InternalXtype.g:1214:1: ( ',' )
            {
            // InternalXtype.g:1214:1: ( ',' )
            // InternalXtype.g:1215:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__1"
    // InternalXtype.g:1224:1: rule__JvmParameterizedTypeReference__Group_1_2__1 : rule__JvmParameterizedTypeReference__Group_1_2__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1228:1: ( rule__JvmParameterizedTypeReference__Group_1_2__1__Impl )
            // InternalXtype.g:1229:2: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__1__Impl"
    // InternalXtype.g:1235:1: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1239:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) )
            // InternalXtype.g:1240:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            {
            // InternalXtype.g:1240:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            // InternalXtype.g:1241:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); 
            }
            // InternalXtype.g:1242:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            // InternalXtype.g:1242:3: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4__0"
    // InternalXtype.g:1251:1: rule__JvmParameterizedTypeReference__Group_1_4__0 : rule__JvmParameterizedTypeReference__Group_1_4__0__Impl rule__JvmParameterizedTypeReference__Group_1_4__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1255:1: ( rule__JvmParameterizedTypeReference__Group_1_4__0__Impl rule__JvmParameterizedTypeReference__Group_1_4__1 )
            // InternalXtype.g:1256:2: rule__JvmParameterizedTypeReference__Group_1_4__0__Impl rule__JvmParameterizedTypeReference__Group_1_4__1
            {
            pushFollow(FOLLOW_17);
            rule__JvmParameterizedTypeReference__Group_1_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4__0__Impl"
    // InternalXtype.g:1263:1: rule__JvmParameterizedTypeReference__Group_1_4__0__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_4_0__0 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1267:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_4_0__0 ) ) )
            // InternalXtype.g:1268:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_0__0 ) )
            {
            // InternalXtype.g:1268:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_0__0 ) )
            // InternalXtype.g:1269:2: ( rule__JvmParameterizedTypeReference__Group_1_4_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0()); 
            }
            // InternalXtype.g:1270:2: ( rule__JvmParameterizedTypeReference__Group_1_4_0__0 )
            // InternalXtype.g:1270:3: rule__JvmParameterizedTypeReference__Group_1_4_0__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4__1"
    // InternalXtype.g:1278:1: rule__JvmParameterizedTypeReference__Group_1_4__1 : rule__JvmParameterizedTypeReference__Group_1_4__1__Impl rule__JvmParameterizedTypeReference__Group_1_4__2 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1282:1: ( rule__JvmParameterizedTypeReference__Group_1_4__1__Impl rule__JvmParameterizedTypeReference__Group_1_4__2 )
            // InternalXtype.g:1283:2: rule__JvmParameterizedTypeReference__Group_1_4__1__Impl rule__JvmParameterizedTypeReference__Group_1_4__2
            {
            pushFollow(FOLLOW_12);
            rule__JvmParameterizedTypeReference__Group_1_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4__1__Impl"
    // InternalXtype.g:1290:1: rule__JvmParameterizedTypeReference__Group_1_4__1__Impl : ( ( rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1294:1: ( ( ( rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1 ) ) )
            // InternalXtype.g:1295:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1 ) )
            {
            // InternalXtype.g:1295:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1 ) )
            // InternalXtype.g:1296:2: ( rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1()); 
            }
            // InternalXtype.g:1297:2: ( rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1 )
            // InternalXtype.g:1297:3: rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4__2"
    // InternalXtype.g:1305:1: rule__JvmParameterizedTypeReference__Group_1_4__2 : rule__JvmParameterizedTypeReference__Group_1_4__2__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1309:1: ( rule__JvmParameterizedTypeReference__Group_1_4__2__Impl )
            // InternalXtype.g:1310:2: rule__JvmParameterizedTypeReference__Group_1_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4__2"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4__2__Impl"
    // InternalXtype.g:1316:1: rule__JvmParameterizedTypeReference__Group_1_4__2__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_4_2__0 )? ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1320:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_4_2__0 )? ) )
            // InternalXtype.g:1321:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_2__0 )? )
            {
            // InternalXtype.g:1321:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_2__0 )? )
            // InternalXtype.g:1322:2: ( rule__JvmParameterizedTypeReference__Group_1_4_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2()); 
            }
            // InternalXtype.g:1323:2: ( rule__JvmParameterizedTypeReference__Group_1_4_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==16) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXtype.g:1323:3: rule__JvmParameterizedTypeReference__Group_1_4_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JvmParameterizedTypeReference__Group_1_4_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4__2__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_0__0"
    // InternalXtype.g:1332:1: rule__JvmParameterizedTypeReference__Group_1_4_0__0 : rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1336:1: ( rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl )
            // InternalXtype.g:1337:2: rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_0__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl"
    // InternalXtype.g:1343:1: rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__0 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1347:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__0 ) ) )
            // InternalXtype.g:1348:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__0 ) )
            {
            // InternalXtype.g:1348:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__0 ) )
            // InternalXtype.g:1349:2: ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0()); 
            }
            // InternalXtype.g:1350:2: ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__0 )
            // InternalXtype.g:1350:3: rule__JvmParameterizedTypeReference__Group_1_4_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_0_0__0"
    // InternalXtype.g:1359:1: rule__JvmParameterizedTypeReference__Group_1_4_0_0__0 : rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_0_0__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1363:1: ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_0_0__1 )
            // InternalXtype.g:1364:2: rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_0_0__1
            {
            pushFollow(FOLLOW_15);
            rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_0_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_0_0__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl"
    // InternalXtype.g:1371:1: rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl : ( () ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1375:1: ( ( () ) )
            // InternalXtype.g:1376:1: ( () )
            {
            // InternalXtype.g:1376:1: ( () )
            // InternalXtype.g:1377:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); 
            }
            // InternalXtype.g:1378:2: ()
            // InternalXtype.g:1378:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_0_0__1"
    // InternalXtype.g:1386:1: rule__JvmParameterizedTypeReference__Group_1_4_0_0__1 : rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1390:1: ( rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl )
            // InternalXtype.g:1391:2: rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_0_0__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl"
    // InternalXtype.g:1397:1: rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl : ( '.' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1401:1: ( ( '.' ) )
            // InternalXtype.g:1402:1: ( '.' )
            {
            // InternalXtype.g:1402:1: ( '.' )
            // InternalXtype.g:1403:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__0"
    // InternalXtype.g:1413:1: rule__JvmParameterizedTypeReference__Group_1_4_2__0 : rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1417:1: ( rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__1 )
            // InternalXtype.g:1418:2: rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__1
            {
            pushFollow(FOLLOW_13);
            rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl"
    // InternalXtype.g:1425:1: rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl : ( ( '<' ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1429:1: ( ( ( '<' ) ) )
            // InternalXtype.g:1430:1: ( ( '<' ) )
            {
            // InternalXtype.g:1430:1: ( ( '<' ) )
            // InternalXtype.g:1431:2: ( '<' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0()); 
            }
            // InternalXtype.g:1432:2: ( '<' )
            // InternalXtype.g:1432:3: '<'
            {
            match(input,16,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__1"
    // InternalXtype.g:1440:1: rule__JvmParameterizedTypeReference__Group_1_4_2__1 : rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__2 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1444:1: ( rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__2 )
            // InternalXtype.g:1445:2: rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__2
            {
            pushFollow(FOLLOW_14);
            rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_2__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl"
    // InternalXtype.g:1452:1: rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1456:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1 ) ) )
            // InternalXtype.g:1457:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1 ) )
            {
            // InternalXtype.g:1457:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1 ) )
            // InternalXtype.g:1458:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1()); 
            }
            // InternalXtype.g:1459:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1 )
            // InternalXtype.g:1459:3: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__2"
    // InternalXtype.g:1467:1: rule__JvmParameterizedTypeReference__Group_1_4_2__2 : rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__3 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1471:1: ( rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__3 )
            // InternalXtype.g:1472:2: rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl rule__JvmParameterizedTypeReference__Group_1_4_2__3
            {
            pushFollow(FOLLOW_14);
            rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_2__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__2"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl"
    // InternalXtype.g:1479:1: rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__0 )* ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1483:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__0 )* ) )
            // InternalXtype.g:1484:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__0 )* )
            {
            // InternalXtype.g:1484:1: ( ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__0 )* )
            // InternalXtype.g:1485:2: ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2()); 
            }
            // InternalXtype.g:1486:2: ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==15) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalXtype.g:1486:3: rule__JvmParameterizedTypeReference__Group_1_4_2_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__JvmParameterizedTypeReference__Group_1_4_2_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__3"
    // InternalXtype.g:1494:1: rule__JvmParameterizedTypeReference__Group_1_4_2__3 : rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1498:1: ( rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl )
            // InternalXtype.g:1499:2: rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__3"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl"
    // InternalXtype.g:1505:1: rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl : ( '>' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1509:1: ( ( '>' ) )
            // InternalXtype.g:1510:1: ( '>' )
            {
            // InternalXtype.g:1510:1: ( '>' )
            // InternalXtype.g:1511:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2_2__0"
    // InternalXtype.g:1521:1: rule__JvmParameterizedTypeReference__Group_1_4_2_2__0 : rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_2_2__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1525:1: ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_2_2__1 )
            // InternalXtype.g:1526:2: rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_4_2_2__1
            {
            pushFollow(FOLLOW_13);
            rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_2_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2_2__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl"
    // InternalXtype.g:1533:1: rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl : ( ',' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1537:1: ( ( ',' ) )
            // InternalXtype.g:1538:1: ( ',' )
            {
            // InternalXtype.g:1538:1: ( ',' )
            // InternalXtype.g:1539:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2_2__1"
    // InternalXtype.g:1548:1: rule__JvmParameterizedTypeReference__Group_1_4_2_2__1 : rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1552:1: ( rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl )
            // InternalXtype.g:1553:2: rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2_2__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl"
    // InternalXtype.g:1559:1: rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1563:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1 ) ) )
            // InternalXtype.g:1564:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1 ) )
            {
            // InternalXtype.g:1564:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1 ) )
            // InternalXtype.g:1565:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1()); 
            }
            // InternalXtype.g:1566:2: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1 )
            // InternalXtype.g:1566:3: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__0"
    // InternalXtype.g:1575:1: rule__JvmWildcardTypeReference__Group__0 : rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 ;
    public final void rule__JvmWildcardTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1579:1: ( rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 )
            // InternalXtype.g:1580:2: rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__JvmWildcardTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__0"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__0__Impl"
    // InternalXtype.g:1587:1: rule__JvmWildcardTypeReference__Group__0__Impl : ( () ) ;
    public final void rule__JvmWildcardTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1591:1: ( ( () ) )
            // InternalXtype.g:1592:1: ( () )
            {
            // InternalXtype.g:1592:1: ( () )
            // InternalXtype.g:1593:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); 
            }
            // InternalXtype.g:1594:2: ()
            // InternalXtype.g:1594:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__0__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__1"
    // InternalXtype.g:1602:1: rule__JvmWildcardTypeReference__Group__1 : rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 ;
    public final void rule__JvmWildcardTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1606:1: ( rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 )
            // InternalXtype.g:1607:2: rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__JvmWildcardTypeReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__1"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__1__Impl"
    // InternalXtype.g:1614:1: rule__JvmWildcardTypeReference__Group__1__Impl : ( '?' ) ;
    public final void rule__JvmWildcardTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1618:1: ( ( '?' ) )
            // InternalXtype.g:1619:1: ( '?' )
            {
            // InternalXtype.g:1619:1: ( '?' )
            // InternalXtype.g:1620:2: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__1__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__2"
    // InternalXtype.g:1629:1: rule__JvmWildcardTypeReference__Group__2 : rule__JvmWildcardTypeReference__Group__2__Impl ;
    public final void rule__JvmWildcardTypeReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1633:1: ( rule__JvmWildcardTypeReference__Group__2__Impl )
            // InternalXtype.g:1634:2: rule__JvmWildcardTypeReference__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__2"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__2__Impl"
    // InternalXtype.g:1640:1: rule__JvmWildcardTypeReference__Group__2__Impl : ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) ;
    public final void rule__JvmWildcardTypeReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1644:1: ( ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) )
            // InternalXtype.g:1645:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            {
            // InternalXtype.g:1645:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            // InternalXtype.g:1646:2: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); 
            }
            // InternalXtype.g:1647:2: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20||LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalXtype.g:1647:3: rule__JvmWildcardTypeReference__Alternatives_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__JvmWildcardTypeReference__Alternatives_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__2__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_0__0"
    // InternalXtype.g:1656:1: rule__JvmWildcardTypeReference__Group_2_0__0 : rule__JvmWildcardTypeReference__Group_2_0__0__Impl rule__JvmWildcardTypeReference__Group_2_0__1 ;
    public final void rule__JvmWildcardTypeReference__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1660:1: ( rule__JvmWildcardTypeReference__Group_2_0__0__Impl rule__JvmWildcardTypeReference__Group_2_0__1 )
            // InternalXtype.g:1661:2: rule__JvmWildcardTypeReference__Group_2_0__0__Impl rule__JvmWildcardTypeReference__Group_2_0__1
            {
            pushFollow(FOLLOW_19);
            rule__JvmWildcardTypeReference__Group_2_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group_2_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_0__0"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_0__0__Impl"
    // InternalXtype.g:1668:1: rule__JvmWildcardTypeReference__Group_2_0__0__Impl : ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0 ) ) ;
    public final void rule__JvmWildcardTypeReference__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1672:1: ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0 ) ) )
            // InternalXtype.g:1673:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0 ) )
            {
            // InternalXtype.g:1673:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0 ) )
            // InternalXtype.g:1674:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0()); 
            }
            // InternalXtype.g:1675:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0 )
            // InternalXtype.g:1675:3: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0
            {
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_0__0__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_0__1"
    // InternalXtype.g:1683:1: rule__JvmWildcardTypeReference__Group_2_0__1 : rule__JvmWildcardTypeReference__Group_2_0__1__Impl ;
    public final void rule__JvmWildcardTypeReference__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1687:1: ( rule__JvmWildcardTypeReference__Group_2_0__1__Impl )
            // InternalXtype.g:1688:2: rule__JvmWildcardTypeReference__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group_2_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_0__1"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_0__1__Impl"
    // InternalXtype.g:1694:1: rule__JvmWildcardTypeReference__Group_2_0__1__Impl : ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1 )* ) ;
    public final void rule__JvmWildcardTypeReference__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1698:1: ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1 )* ) )
            // InternalXtype.g:1699:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1 )* )
            {
            // InternalXtype.g:1699:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1 )* )
            // InternalXtype.g:1700:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1()); 
            }
            // InternalXtype.g:1701:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==21) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalXtype.g:1701:3: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_0__1__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_1__0"
    // InternalXtype.g:1710:1: rule__JvmWildcardTypeReference__Group_2_1__0 : rule__JvmWildcardTypeReference__Group_2_1__0__Impl rule__JvmWildcardTypeReference__Group_2_1__1 ;
    public final void rule__JvmWildcardTypeReference__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1714:1: ( rule__JvmWildcardTypeReference__Group_2_1__0__Impl rule__JvmWildcardTypeReference__Group_2_1__1 )
            // InternalXtype.g:1715:2: rule__JvmWildcardTypeReference__Group_2_1__0__Impl rule__JvmWildcardTypeReference__Group_2_1__1
            {
            pushFollow(FOLLOW_19);
            rule__JvmWildcardTypeReference__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_1__0"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_1__0__Impl"
    // InternalXtype.g:1722:1: rule__JvmWildcardTypeReference__Group_2_1__0__Impl : ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0 ) ) ;
    public final void rule__JvmWildcardTypeReference__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1726:1: ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0 ) ) )
            // InternalXtype.g:1727:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0 ) )
            {
            // InternalXtype.g:1727:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0 ) )
            // InternalXtype.g:1728:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0()); 
            }
            // InternalXtype.g:1729:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0 )
            // InternalXtype.g:1729:3: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_1__0__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_1__1"
    // InternalXtype.g:1737:1: rule__JvmWildcardTypeReference__Group_2_1__1 : rule__JvmWildcardTypeReference__Group_2_1__1__Impl ;
    public final void rule__JvmWildcardTypeReference__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1741:1: ( rule__JvmWildcardTypeReference__Group_2_1__1__Impl )
            // InternalXtype.g:1742:2: rule__JvmWildcardTypeReference__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmWildcardTypeReference__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_1__1"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group_2_1__1__Impl"
    // InternalXtype.g:1748:1: rule__JvmWildcardTypeReference__Group_2_1__1__Impl : ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1 )* ) ;
    public final void rule__JvmWildcardTypeReference__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1752:1: ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1 )* ) )
            // InternalXtype.g:1753:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1 )* )
            {
            // InternalXtype.g:1753:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1 )* )
            // InternalXtype.g:1754:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1()); 
            }
            // InternalXtype.g:1755:2: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==21) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalXtype.g:1755:3: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__Group_2_1__1__Impl"


    // $ANTLR start "rule__JvmUpperBound__Group__0"
    // InternalXtype.g:1764:1: rule__JvmUpperBound__Group__0 : rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 ;
    public final void rule__JvmUpperBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1768:1: ( rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 )
            // InternalXtype.g:1769:2: rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__JvmUpperBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmUpperBound__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmUpperBound__Group__0"


    // $ANTLR start "rule__JvmUpperBound__Group__0__Impl"
    // InternalXtype.g:1776:1: rule__JvmUpperBound__Group__0__Impl : ( 'extends' ) ;
    public final void rule__JvmUpperBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1780:1: ( ( 'extends' ) )
            // InternalXtype.g:1781:1: ( 'extends' )
            {
            // InternalXtype.g:1781:1: ( 'extends' )
            // InternalXtype.g:1782:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); 
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
    // $ANTLR end "rule__JvmUpperBound__Group__0__Impl"


    // $ANTLR start "rule__JvmUpperBound__Group__1"
    // InternalXtype.g:1791:1: rule__JvmUpperBound__Group__1 : rule__JvmUpperBound__Group__1__Impl ;
    public final void rule__JvmUpperBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1795:1: ( rule__JvmUpperBound__Group__1__Impl )
            // InternalXtype.g:1796:2: rule__JvmUpperBound__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmUpperBound__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmUpperBound__Group__1"


    // $ANTLR start "rule__JvmUpperBound__Group__1__Impl"
    // InternalXtype.g:1802:1: rule__JvmUpperBound__Group__1__Impl : ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1806:1: ( ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) )
            // InternalXtype.g:1807:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            {
            // InternalXtype.g:1807:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            // InternalXtype.g:1808:2: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // InternalXtype.g:1809:2: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            // InternalXtype.g:1809:3: rule__JvmUpperBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmUpperBound__TypeReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); 
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
    // $ANTLR end "rule__JvmUpperBound__Group__1__Impl"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__0"
    // InternalXtype.g:1818:1: rule__JvmUpperBoundAnded__Group__0 : rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 ;
    public final void rule__JvmUpperBoundAnded__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1822:1: ( rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 )
            // InternalXtype.g:1823:2: rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__JvmUpperBoundAnded__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmUpperBoundAnded__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__0"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__0__Impl"
    // InternalXtype.g:1830:1: rule__JvmUpperBoundAnded__Group__0__Impl : ( '&' ) ;
    public final void rule__JvmUpperBoundAnded__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1834:1: ( ( '&' ) )
            // InternalXtype.g:1835:1: ( '&' )
            {
            // InternalXtype.g:1835:1: ( '&' )
            // InternalXtype.g:1836:2: '&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); 
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
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__0__Impl"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__1"
    // InternalXtype.g:1845:1: rule__JvmUpperBoundAnded__Group__1 : rule__JvmUpperBoundAnded__Group__1__Impl ;
    public final void rule__JvmUpperBoundAnded__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1849:1: ( rule__JvmUpperBoundAnded__Group__1__Impl )
            // InternalXtype.g:1850:2: rule__JvmUpperBoundAnded__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmUpperBoundAnded__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__1"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__1__Impl"
    // InternalXtype.g:1856:1: rule__JvmUpperBoundAnded__Group__1__Impl : ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBoundAnded__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1860:1: ( ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) )
            // InternalXtype.g:1861:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            {
            // InternalXtype.g:1861:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            // InternalXtype.g:1862:2: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); 
            }
            // InternalXtype.g:1863:2: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            // InternalXtype.g:1863:3: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmUpperBoundAnded__TypeReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); 
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
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__1__Impl"


    // $ANTLR start "rule__JvmLowerBound__Group__0"
    // InternalXtype.g:1872:1: rule__JvmLowerBound__Group__0 : rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 ;
    public final void rule__JvmLowerBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1876:1: ( rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 )
            // InternalXtype.g:1877:2: rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__JvmLowerBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmLowerBound__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmLowerBound__Group__0"


    // $ANTLR start "rule__JvmLowerBound__Group__0__Impl"
    // InternalXtype.g:1884:1: rule__JvmLowerBound__Group__0__Impl : ( 'super' ) ;
    public final void rule__JvmLowerBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1888:1: ( ( 'super' ) )
            // InternalXtype.g:1889:1: ( 'super' )
            {
            // InternalXtype.g:1889:1: ( 'super' )
            // InternalXtype.g:1890:2: 'super'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); 
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
    // $ANTLR end "rule__JvmLowerBound__Group__0__Impl"


    // $ANTLR start "rule__JvmLowerBound__Group__1"
    // InternalXtype.g:1899:1: rule__JvmLowerBound__Group__1 : rule__JvmLowerBound__Group__1__Impl ;
    public final void rule__JvmLowerBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1903:1: ( rule__JvmLowerBound__Group__1__Impl )
            // InternalXtype.g:1904:2: rule__JvmLowerBound__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmLowerBound__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmLowerBound__Group__1"


    // $ANTLR start "rule__JvmLowerBound__Group__1__Impl"
    // InternalXtype.g:1910:1: rule__JvmLowerBound__Group__1__Impl : ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmLowerBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1914:1: ( ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) )
            // InternalXtype.g:1915:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            {
            // InternalXtype.g:1915:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            // InternalXtype.g:1916:2: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // InternalXtype.g:1917:2: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            // InternalXtype.g:1917:3: rule__JvmLowerBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmLowerBound__TypeReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); 
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
    // $ANTLR end "rule__JvmLowerBound__Group__1__Impl"


    // $ANTLR start "rule__JvmLowerBoundAnded__Group__0"
    // InternalXtype.g:1926:1: rule__JvmLowerBoundAnded__Group__0 : rule__JvmLowerBoundAnded__Group__0__Impl rule__JvmLowerBoundAnded__Group__1 ;
    public final void rule__JvmLowerBoundAnded__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1930:1: ( rule__JvmLowerBoundAnded__Group__0__Impl rule__JvmLowerBoundAnded__Group__1 )
            // InternalXtype.g:1931:2: rule__JvmLowerBoundAnded__Group__0__Impl rule__JvmLowerBoundAnded__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__JvmLowerBoundAnded__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__JvmLowerBoundAnded__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmLowerBoundAnded__Group__0"


    // $ANTLR start "rule__JvmLowerBoundAnded__Group__0__Impl"
    // InternalXtype.g:1938:1: rule__JvmLowerBoundAnded__Group__0__Impl : ( '&' ) ;
    public final void rule__JvmLowerBoundAnded__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1942:1: ( ( '&' ) )
            // InternalXtype.g:1943:1: ( '&' )
            {
            // InternalXtype.g:1943:1: ( '&' )
            // InternalXtype.g:1944:2: '&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0()); 
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
    // $ANTLR end "rule__JvmLowerBoundAnded__Group__0__Impl"


    // $ANTLR start "rule__JvmLowerBoundAnded__Group__1"
    // InternalXtype.g:1953:1: rule__JvmLowerBoundAnded__Group__1 : rule__JvmLowerBoundAnded__Group__1__Impl ;
    public final void rule__JvmLowerBoundAnded__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1957:1: ( rule__JvmLowerBoundAnded__Group__1__Impl )
            // InternalXtype.g:1958:2: rule__JvmLowerBoundAnded__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JvmLowerBoundAnded__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__JvmLowerBoundAnded__Group__1"


    // $ANTLR start "rule__JvmLowerBoundAnded__Group__1__Impl"
    // InternalXtype.g:1964:1: rule__JvmLowerBoundAnded__Group__1__Impl : ( ( rule__JvmLowerBoundAnded__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmLowerBoundAnded__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1968:1: ( ( ( rule__JvmLowerBoundAnded__TypeReferenceAssignment_1 ) ) )
            // InternalXtype.g:1969:1: ( ( rule__JvmLowerBoundAnded__TypeReferenceAssignment_1 ) )
            {
            // InternalXtype.g:1969:1: ( ( rule__JvmLowerBoundAnded__TypeReferenceAssignment_1 ) )
            // InternalXtype.g:1970:2: ( rule__JvmLowerBoundAnded__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1()); 
            }
            // InternalXtype.g:1971:2: ( rule__JvmLowerBoundAnded__TypeReferenceAssignment_1 )
            // InternalXtype.g:1971:3: rule__JvmLowerBoundAnded__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JvmLowerBoundAnded__TypeReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1()); 
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
    // $ANTLR end "rule__JvmLowerBoundAnded__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalXtype.g:1980:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1984:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalXtype.g:1985:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalXtype.g:1992:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:1996:1: ( ( ruleValidID ) )
            // InternalXtype.g:1997:1: ( ruleValidID )
            {
            // InternalXtype.g:1997:1: ( ruleValidID )
            // InternalXtype.g:1998:2: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
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
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalXtype.g:2007:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2011:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalXtype.g:2012:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalXtype.g:2018:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2022:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalXtype.g:2023:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalXtype.g:2023:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalXtype.g:2024:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalXtype.g:2025:2: ( rule__QualifiedName__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==18) ) {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2==RULE_ID) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // InternalXtype.g:2025:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
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
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalXtype.g:2034:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2038:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalXtype.g:2039:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalXtype.g:2046:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2050:1: ( ( '.' ) )
            // InternalXtype.g:2051:1: ( '.' )
            {
            // InternalXtype.g:2051:1: ( '.' )
            // InternalXtype.g:2052:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
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
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalXtype.g:2061:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2065:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalXtype.g:2066:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalXtype.g:2072:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2076:1: ( ( ruleValidID ) )
            // InternalXtype.g:2077:1: ( ruleValidID )
            {
            // InternalXtype.g:2077:1: ( ruleValidID )
            // InternalXtype.g:2078:2: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
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
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0"
    // InternalXtype.g:2088:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2092:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // InternalXtype.g:2093:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0__Impl"
    // InternalXtype.g:2100:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2104:1: ( ( ruleQualifiedName ) )
            // InternalXtype.g:2105:1: ( ruleQualifiedName )
            {
            // InternalXtype.g:2105:1: ( ruleQualifiedName )
            // InternalXtype.g:2106:2: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
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
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1"
    // InternalXtype.g:2115:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl rule__QualifiedNameWithWildcard__Group__2 ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2119:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl rule__QualifiedNameWithWildcard__Group__2 )
            // InternalXtype.g:2120:2: rule__QualifiedNameWithWildcard__Group__1__Impl rule__QualifiedNameWithWildcard__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__QualifiedNameWithWildcard__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1__Impl"
    // InternalXtype.g:2127:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2131:1: ( ( '.' ) )
            // InternalXtype.g:2132:1: ( '.' )
            {
            // InternalXtype.g:2132:1: ( '.' )
            // InternalXtype.g:2133:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); 
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
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__2"
    // InternalXtype.g:2142:1: rule__QualifiedNameWithWildcard__Group__2 : rule__QualifiedNameWithWildcard__Group__2__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2146:1: ( rule__QualifiedNameWithWildcard__Group__2__Impl )
            // InternalXtype.g:2147:2: rule__QualifiedNameWithWildcard__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__2"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__2__Impl"
    // InternalXtype.g:2153:1: rule__QualifiedNameWithWildcard__Group__2__Impl : ( '*' ) ;
    public final void rule__QualifiedNameWithWildcard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2157:1: ( ( '*' ) )
            // InternalXtype.g:2158:1: ( '*' )
            {
            // InternalXtype.g:2158:1: ( '*' )
            // InternalXtype.g:2159:2: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); 
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
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__2__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__0"
    // InternalXtype.g:2169:1: rule__XImportDeclaration__Group__0 : rule__XImportDeclaration__Group__0__Impl rule__XImportDeclaration__Group__1 ;
    public final void rule__XImportDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2173:1: ( rule__XImportDeclaration__Group__0__Impl rule__XImportDeclaration__Group__1 )
            // InternalXtype.g:2174:2: rule__XImportDeclaration__Group__0__Impl rule__XImportDeclaration__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__XImportDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XImportDeclaration__Group__0"


    // $ANTLR start "rule__XImportDeclaration__Group__0__Impl"
    // InternalXtype.g:2181:1: rule__XImportDeclaration__Group__0__Impl : ( 'import' ) ;
    public final void rule__XImportDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2185:1: ( ( 'import' ) )
            // InternalXtype.g:2186:1: ( 'import' )
            {
            // InternalXtype.g:2186:1: ( 'import' )
            // InternalXtype.g:2187:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportKeyword_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportKeyword_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__Group__0__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__1"
    // InternalXtype.g:2196:1: rule__XImportDeclaration__Group__1 : rule__XImportDeclaration__Group__1__Impl rule__XImportDeclaration__Group__2 ;
    public final void rule__XImportDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2200:1: ( rule__XImportDeclaration__Group__1__Impl rule__XImportDeclaration__Group__2 )
            // InternalXtype.g:2201:2: rule__XImportDeclaration__Group__1__Impl rule__XImportDeclaration__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__XImportDeclaration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XImportDeclaration__Group__1"


    // $ANTLR start "rule__XImportDeclaration__Group__1__Impl"
    // InternalXtype.g:2208:1: rule__XImportDeclaration__Group__1__Impl : ( ( rule__XImportDeclaration__Alternatives_1 ) ) ;
    public final void rule__XImportDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2212:1: ( ( ( rule__XImportDeclaration__Alternatives_1 ) ) )
            // InternalXtype.g:2213:1: ( ( rule__XImportDeclaration__Alternatives_1 ) )
            {
            // InternalXtype.g:2213:1: ( ( rule__XImportDeclaration__Alternatives_1 ) )
            // InternalXtype.g:2214:2: ( rule__XImportDeclaration__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getAlternatives_1()); 
            }
            // InternalXtype.g:2215:2: ( rule__XImportDeclaration__Alternatives_1 )
            // InternalXtype.g:2215:3: rule__XImportDeclaration__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getAlternatives_1()); 
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
    // $ANTLR end "rule__XImportDeclaration__Group__1__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__2"
    // InternalXtype.g:2223:1: rule__XImportDeclaration__Group__2 : rule__XImportDeclaration__Group__2__Impl ;
    public final void rule__XImportDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2227:1: ( rule__XImportDeclaration__Group__2__Impl )
            // InternalXtype.g:2228:2: rule__XImportDeclaration__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XImportDeclaration__Group__2"


    // $ANTLR start "rule__XImportDeclaration__Group__2__Impl"
    // InternalXtype.g:2234:1: rule__XImportDeclaration__Group__2__Impl : ( ( ';' )? ) ;
    public final void rule__XImportDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2238:1: ( ( ( ';' )? ) )
            // InternalXtype.g:2239:1: ( ( ';' )? )
            {
            // InternalXtype.g:2239:1: ( ( ';' )? )
            // InternalXtype.g:2240:2: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2()); 
            }
            // InternalXtype.g:2241:2: ( ';' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalXtype.g:2241:3: ';'
                    {
                    match(input,25,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2()); 
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
    // $ANTLR end "rule__XImportDeclaration__Group__2__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__0"
    // InternalXtype.g:2250:1: rule__XImportDeclaration__Group_1_0__0 : rule__XImportDeclaration__Group_1_0__0__Impl rule__XImportDeclaration__Group_1_0__1 ;
    public final void rule__XImportDeclaration__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2254:1: ( rule__XImportDeclaration__Group_1_0__0__Impl rule__XImportDeclaration__Group_1_0__1 )
            // InternalXtype.g:2255:2: rule__XImportDeclaration__Group_1_0__0__Impl rule__XImportDeclaration__Group_1_0__1
            {
            pushFollow(FOLLOW_24);
            rule__XImportDeclaration__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__0"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__0__Impl"
    // InternalXtype.g:2262:1: rule__XImportDeclaration__Group_1_0__0__Impl : ( ( rule__XImportDeclaration__StaticAssignment_1_0_0 ) ) ;
    public final void rule__XImportDeclaration__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2266:1: ( ( ( rule__XImportDeclaration__StaticAssignment_1_0_0 ) ) )
            // InternalXtype.g:2267:1: ( ( rule__XImportDeclaration__StaticAssignment_1_0_0 ) )
            {
            // InternalXtype.g:2267:1: ( ( rule__XImportDeclaration__StaticAssignment_1_0_0 ) )
            // InternalXtype.g:2268:2: ( rule__XImportDeclaration__StaticAssignment_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0()); 
            }
            // InternalXtype.g:2269:2: ( rule__XImportDeclaration__StaticAssignment_1_0_0 )
            // InternalXtype.g:2269:3: rule__XImportDeclaration__StaticAssignment_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__StaticAssignment_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__0__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__1"
    // InternalXtype.g:2277:1: rule__XImportDeclaration__Group_1_0__1 : rule__XImportDeclaration__Group_1_0__1__Impl rule__XImportDeclaration__Group_1_0__2 ;
    public final void rule__XImportDeclaration__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2281:1: ( rule__XImportDeclaration__Group_1_0__1__Impl rule__XImportDeclaration__Group_1_0__2 )
            // InternalXtype.g:2282:2: rule__XImportDeclaration__Group_1_0__1__Impl rule__XImportDeclaration__Group_1_0__2
            {
            pushFollow(FOLLOW_24);
            rule__XImportDeclaration__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group_1_0__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__1"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__1__Impl"
    // InternalXtype.g:2289:1: rule__XImportDeclaration__Group_1_0__1__Impl : ( ( rule__XImportDeclaration__ExtensionAssignment_1_0_1 )? ) ;
    public final void rule__XImportDeclaration__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2293:1: ( ( ( rule__XImportDeclaration__ExtensionAssignment_1_0_1 )? ) )
            // InternalXtype.g:2294:1: ( ( rule__XImportDeclaration__ExtensionAssignment_1_0_1 )? )
            {
            // InternalXtype.g:2294:1: ( ( rule__XImportDeclaration__ExtensionAssignment_1_0_1 )? )
            // InternalXtype.g:2295:2: ( rule__XImportDeclaration__ExtensionAssignment_1_0_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1()); 
            }
            // InternalXtype.g:2296:2: ( rule__XImportDeclaration__ExtensionAssignment_1_0_1 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==27) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalXtype.g:2296:3: rule__XImportDeclaration__ExtensionAssignment_1_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XImportDeclaration__ExtensionAssignment_1_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1()); 
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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__1__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__2"
    // InternalXtype.g:2304:1: rule__XImportDeclaration__Group_1_0__2 : rule__XImportDeclaration__Group_1_0__2__Impl rule__XImportDeclaration__Group_1_0__3 ;
    public final void rule__XImportDeclaration__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2308:1: ( rule__XImportDeclaration__Group_1_0__2__Impl rule__XImportDeclaration__Group_1_0__3 )
            // InternalXtype.g:2309:2: rule__XImportDeclaration__Group_1_0__2__Impl rule__XImportDeclaration__Group_1_0__3
            {
            pushFollow(FOLLOW_25);
            rule__XImportDeclaration__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group_1_0__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__2"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__2__Impl"
    // InternalXtype.g:2316:1: rule__XImportDeclaration__Group_1_0__2__Impl : ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_0_2 ) ) ;
    public final void rule__XImportDeclaration__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2320:1: ( ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_0_2 ) ) )
            // InternalXtype.g:2321:1: ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_0_2 ) )
            {
            // InternalXtype.g:2321:1: ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_0_2 ) )
            // InternalXtype.g:2322:2: ( rule__XImportDeclaration__ImportedTypeAssignment_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2()); 
            }
            // InternalXtype.g:2323:2: ( rule__XImportDeclaration__ImportedTypeAssignment_1_0_2 )
            // InternalXtype.g:2323:3: rule__XImportDeclaration__ImportedTypeAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__ImportedTypeAssignment_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2()); 
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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__2__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__3"
    // InternalXtype.g:2331:1: rule__XImportDeclaration__Group_1_0__3 : rule__XImportDeclaration__Group_1_0__3__Impl ;
    public final void rule__XImportDeclaration__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2335:1: ( rule__XImportDeclaration__Group_1_0__3__Impl )
            // InternalXtype.g:2336:2: rule__XImportDeclaration__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Group_1_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__3"


    // $ANTLR start "rule__XImportDeclaration__Group_1_0__3__Impl"
    // InternalXtype.g:2342:1: rule__XImportDeclaration__Group_1_0__3__Impl : ( ( rule__XImportDeclaration__Alternatives_1_0_3 ) ) ;
    public final void rule__XImportDeclaration__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2346:1: ( ( ( rule__XImportDeclaration__Alternatives_1_0_3 ) ) )
            // InternalXtype.g:2347:1: ( ( rule__XImportDeclaration__Alternatives_1_0_3 ) )
            {
            // InternalXtype.g:2347:1: ( ( rule__XImportDeclaration__Alternatives_1_0_3 ) )
            // InternalXtype.g:2348:2: ( rule__XImportDeclaration__Alternatives_1_0_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3()); 
            }
            // InternalXtype.g:2349:2: ( rule__XImportDeclaration__Alternatives_1_0_3 )
            // InternalXtype.g:2349:3: rule__XImportDeclaration__Alternatives_1_0_3
            {
            pushFollow(FOLLOW_2);
            rule__XImportDeclaration__Alternatives_1_0_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3()); 
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
    // $ANTLR end "rule__XImportDeclaration__Group_1_0__3__Impl"


    // $ANTLR start "rule__QualifiedNameInStaticImport__Group__0"
    // InternalXtype.g:2358:1: rule__QualifiedNameInStaticImport__Group__0 : rule__QualifiedNameInStaticImport__Group__0__Impl rule__QualifiedNameInStaticImport__Group__1 ;
    public final void rule__QualifiedNameInStaticImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2362:1: ( rule__QualifiedNameInStaticImport__Group__0__Impl rule__QualifiedNameInStaticImport__Group__1 )
            // InternalXtype.g:2363:2: rule__QualifiedNameInStaticImport__Group__0__Impl rule__QualifiedNameInStaticImport__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__QualifiedNameInStaticImport__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedNameInStaticImport__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedNameInStaticImport__Group__0"


    // $ANTLR start "rule__QualifiedNameInStaticImport__Group__0__Impl"
    // InternalXtype.g:2370:1: rule__QualifiedNameInStaticImport__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedNameInStaticImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2374:1: ( ( ruleValidID ) )
            // InternalXtype.g:2375:1: ( ruleValidID )
            {
            // InternalXtype.g:2375:1: ( ruleValidID )
            // InternalXtype.g:2376:2: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); 
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
    // $ANTLR end "rule__QualifiedNameInStaticImport__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameInStaticImport__Group__1"
    // InternalXtype.g:2385:1: rule__QualifiedNameInStaticImport__Group__1 : rule__QualifiedNameInStaticImport__Group__1__Impl ;
    public final void rule__QualifiedNameInStaticImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2389:1: ( rule__QualifiedNameInStaticImport__Group__1__Impl )
            // InternalXtype.g:2390:2: rule__QualifiedNameInStaticImport__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameInStaticImport__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedNameInStaticImport__Group__1"


    // $ANTLR start "rule__QualifiedNameInStaticImport__Group__1__Impl"
    // InternalXtype.g:2396:1: rule__QualifiedNameInStaticImport__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedNameInStaticImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2400:1: ( ( '.' ) )
            // InternalXtype.g:2401:1: ( '.' )
            {
            // InternalXtype.g:2401:1: ( '.' )
            // InternalXtype.g:2402:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); 
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
    // $ANTLR end "rule__QualifiedNameInStaticImport__Group__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0"
    // InternalXtype.g:2412:1: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2416:1: ( ( ruleJvmTypeReference ) )
            // InternalXtype.g:2417:2: ( ruleJvmTypeReference )
            {
            // InternalXtype.g:2417:2: ( ruleJvmTypeReference )
            // InternalXtype.g:2418:3: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0"


    // $ANTLR start "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1"
    // InternalXtype.g:2427:1: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2431:1: ( ( ruleJvmTypeReference ) )
            // InternalXtype.g:2432:2: ( ruleJvmTypeReference )
            {
            // InternalXtype.g:2432:2: ( ruleJvmTypeReference )
            // InternalXtype.g:2433:3: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1"


    // $ANTLR start "rule__XFunctionTypeRef__ReturnTypeAssignment_2"
    // InternalXtype.g:2442:1: rule__XFunctionTypeRef__ReturnTypeAssignment_2 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ReturnTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2446:1: ( ( ruleJvmTypeReference ) )
            // InternalXtype.g:2447:2: ( ruleJvmTypeReference )
            {
            // InternalXtype.g:2447:2: ( ruleJvmTypeReference )
            // InternalXtype.g:2448:3: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__ReturnTypeAssignment_2"


    // $ANTLR start "rule__JvmParameterizedTypeReference__TypeAssignment_0"
    // InternalXtype.g:2457:1: rule__JvmParameterizedTypeReference__TypeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__JvmParameterizedTypeReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2461:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXtype.g:2462:2: ( ( ruleQualifiedName ) )
            {
            // InternalXtype.g:2462:2: ( ( ruleQualifiedName ) )
            // InternalXtype.g:2463:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            }
            // InternalXtype.g:2464:3: ( ruleQualifiedName )
            // InternalXtype.g:2465:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__TypeAssignment_0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1"
    // InternalXtype.g:2476:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2480:1: ( ( ruleJvmArgumentTypeReference ) )
            // InternalXtype.g:2481:2: ( ruleJvmArgumentTypeReference )
            {
            // InternalXtype.g:2481:2: ( ruleJvmArgumentTypeReference )
            // InternalXtype.g:2482:3: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1"
    // InternalXtype.g:2491:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2495:1: ( ( ruleJvmArgumentTypeReference ) )
            // InternalXtype.g:2496:2: ( ruleJvmArgumentTypeReference )
            {
            // InternalXtype.g:2496:2: ( ruleJvmArgumentTypeReference )
            // InternalXtype.g:2497:3: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1"
    // InternalXtype.g:2506:1: rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1 : ( ( ruleValidID ) ) ;
    public final void rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2510:1: ( ( ( ruleValidID ) ) )
            // InternalXtype.g:2511:2: ( ( ruleValidID ) )
            {
            // InternalXtype.g:2511:2: ( ( ruleValidID ) )
            // InternalXtype.g:2512:3: ( ruleValidID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0()); 
            }
            // InternalXtype.g:2513:3: ( ruleValidID )
            // InternalXtype.g:2514:4: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1"
    // InternalXtype.g:2525:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2529:1: ( ( ruleJvmArgumentTypeReference ) )
            // InternalXtype.g:2530:2: ( ruleJvmArgumentTypeReference )
            {
            // InternalXtype.g:2530:2: ( ruleJvmArgumentTypeReference )
            // InternalXtype.g:2531:3: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1"
    // InternalXtype.g:2540:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2544:1: ( ( ruleJvmArgumentTypeReference ) )
            // InternalXtype.g:2545:2: ( ruleJvmArgumentTypeReference )
            {
            // InternalXtype.g:2545:2: ( ruleJvmArgumentTypeReference )
            // InternalXtype.g:2546:3: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); 
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
    // $ANTLR end "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1"


    // $ANTLR start "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0"
    // InternalXtype.g:2555:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0 : ( ruleJvmUpperBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2559:1: ( ( ruleJvmUpperBound ) )
            // InternalXtype.g:2560:2: ( ruleJvmUpperBound )
            {
            // InternalXtype.g:2560:2: ( ruleJvmUpperBound )
            // InternalXtype.g:2561:3: ruleJvmUpperBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0"


    // $ANTLR start "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1"
    // InternalXtype.g:2570:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1 : ( ruleJvmUpperBoundAnded ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2574:1: ( ( ruleJvmUpperBoundAnded ) )
            // InternalXtype.g:2575:2: ( ruleJvmUpperBoundAnded )
            {
            // InternalXtype.g:2575:2: ( ruleJvmUpperBoundAnded )
            // InternalXtype.g:2576:3: ruleJvmUpperBoundAnded
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1"


    // $ANTLR start "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0"
    // InternalXtype.g:2585:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0 : ( ruleJvmLowerBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2589:1: ( ( ruleJvmLowerBound ) )
            // InternalXtype.g:2590:2: ( ruleJvmLowerBound )
            {
            // InternalXtype.g:2590:2: ( ruleJvmLowerBound )
            // InternalXtype.g:2591:3: ruleJvmLowerBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0"


    // $ANTLR start "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1"
    // InternalXtype.g:2600:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1 : ( ruleJvmLowerBoundAnded ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2604:1: ( ( ruleJvmLowerBoundAnded ) )
            // InternalXtype.g:2605:2: ( ruleJvmLowerBoundAnded )
            {
            // InternalXtype.g:2605:2: ( ruleJvmLowerBoundAnded )
            // InternalXtype.g:2606:3: ruleJvmLowerBoundAnded
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); 
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
    // $ANTLR end "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1"


    // $ANTLR start "rule__JvmUpperBound__TypeReferenceAssignment_1"
    // InternalXtype.g:2615:1: rule__JvmUpperBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2619:1: ( ( ruleJvmTypeReference ) )
            // InternalXtype.g:2620:2: ( ruleJvmTypeReference )
            {
            // InternalXtype.g:2620:2: ( ruleJvmTypeReference )
            // InternalXtype.g:2621:3: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__JvmUpperBound__TypeReferenceAssignment_1"


    // $ANTLR start "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1"
    // InternalXtype.g:2630:1: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBoundAnded__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2634:1: ( ( ruleJvmTypeReference ) )
            // InternalXtype.g:2635:2: ( ruleJvmTypeReference )
            {
            // InternalXtype.g:2635:2: ( ruleJvmTypeReference )
            // InternalXtype.g:2636:3: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1"


    // $ANTLR start "rule__JvmLowerBound__TypeReferenceAssignment_1"
    // InternalXtype.g:2645:1: rule__JvmLowerBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmLowerBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2649:1: ( ( ruleJvmTypeReference ) )
            // InternalXtype.g:2650:2: ( ruleJvmTypeReference )
            {
            // InternalXtype.g:2650:2: ( ruleJvmTypeReference )
            // InternalXtype.g:2651:3: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__JvmLowerBound__TypeReferenceAssignment_1"


    // $ANTLR start "rule__JvmLowerBoundAnded__TypeReferenceAssignment_1"
    // InternalXtype.g:2660:1: rule__JvmLowerBoundAnded__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmLowerBoundAnded__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2664:1: ( ( ruleJvmTypeReference ) )
            // InternalXtype.g:2665:2: ( ruleJvmTypeReference )
            {
            // InternalXtype.g:2665:2: ( ruleJvmTypeReference )
            // InternalXtype.g:2666:3: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__JvmLowerBoundAnded__TypeReferenceAssignment_1"


    // $ANTLR start "rule__XImportDeclaration__StaticAssignment_1_0_0"
    // InternalXtype.g:2675:1: rule__XImportDeclaration__StaticAssignment_1_0_0 : ( ( 'static' ) ) ;
    public final void rule__XImportDeclaration__StaticAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2679:1: ( ( ( 'static' ) ) )
            // InternalXtype.g:2680:2: ( ( 'static' ) )
            {
            // InternalXtype.g:2680:2: ( ( 'static' ) )
            // InternalXtype.g:2681:3: ( 'static' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); 
            }
            // InternalXtype.g:2682:3: ( 'static' )
            // InternalXtype.g:2683:4: 'static'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__StaticAssignment_1_0_0"


    // $ANTLR start "rule__XImportDeclaration__ExtensionAssignment_1_0_1"
    // InternalXtype.g:2694:1: rule__XImportDeclaration__ExtensionAssignment_1_0_1 : ( ( 'extension' ) ) ;
    public final void rule__XImportDeclaration__ExtensionAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2698:1: ( ( ( 'extension' ) ) )
            // InternalXtype.g:2699:2: ( ( 'extension' ) )
            {
            // InternalXtype.g:2699:2: ( ( 'extension' ) )
            // InternalXtype.g:2700:3: ( 'extension' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); 
            }
            // InternalXtype.g:2701:3: ( 'extension' )
            // InternalXtype.g:2702:4: 'extension'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__ExtensionAssignment_1_0_1"


    // $ANTLR start "rule__XImportDeclaration__ImportedTypeAssignment_1_0_2"
    // InternalXtype.g:2713:1: rule__XImportDeclaration__ImportedTypeAssignment_1_0_2 : ( ( ruleQualifiedNameInStaticImport ) ) ;
    public final void rule__XImportDeclaration__ImportedTypeAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2717:1: ( ( ( ruleQualifiedNameInStaticImport ) ) )
            // InternalXtype.g:2718:2: ( ( ruleQualifiedNameInStaticImport ) )
            {
            // InternalXtype.g:2718:2: ( ( ruleQualifiedNameInStaticImport ) )
            // InternalXtype.g:2719:3: ( ruleQualifiedNameInStaticImport )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); 
            }
            // InternalXtype.g:2720:3: ( ruleQualifiedNameInStaticImport )
            // InternalXtype.g:2721:4: ruleQualifiedNameInStaticImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__ImportedTypeAssignment_1_0_2"


    // $ANTLR start "rule__XImportDeclaration__WildcardAssignment_1_0_3_0"
    // InternalXtype.g:2732:1: rule__XImportDeclaration__WildcardAssignment_1_0_3_0 : ( ( '*' ) ) ;
    public final void rule__XImportDeclaration__WildcardAssignment_1_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2736:1: ( ( ( '*' ) ) )
            // InternalXtype.g:2737:2: ( ( '*' ) )
            {
            // InternalXtype.g:2737:2: ( ( '*' ) )
            // InternalXtype.g:2738:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); 
            }
            // InternalXtype.g:2739:3: ( '*' )
            // InternalXtype.g:2740:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__WildcardAssignment_1_0_3_0"


    // $ANTLR start "rule__XImportDeclaration__MemberNameAssignment_1_0_3_1"
    // InternalXtype.g:2751:1: rule__XImportDeclaration__MemberNameAssignment_1_0_3_1 : ( ruleValidID ) ;
    public final void rule__XImportDeclaration__MemberNameAssignment_1_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2755:1: ( ( ruleValidID ) )
            // InternalXtype.g:2756:2: ( ruleValidID )
            {
            // InternalXtype.g:2756:2: ( ruleValidID )
            // InternalXtype.g:2757:3: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__MemberNameAssignment_1_0_3_1"


    // $ANTLR start "rule__XImportDeclaration__ImportedTypeAssignment_1_1"
    // InternalXtype.g:2766:1: rule__XImportDeclaration__ImportedTypeAssignment_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__XImportDeclaration__ImportedTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2770:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXtype.g:2771:2: ( ( ruleQualifiedName ) )
            {
            // InternalXtype.g:2771:2: ( ( ruleQualifiedName ) )
            // InternalXtype.g:2772:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); 
            }
            // InternalXtype.g:2773:3: ( ruleQualifiedName )
            // InternalXtype.g:2774:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__ImportedTypeAssignment_1_1"


    // $ANTLR start "rule__XImportDeclaration__ImportedNamespaceAssignment_1_2"
    // InternalXtype.g:2785:1: rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__XImportDeclaration__ImportedNamespaceAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtype.g:2789:1: ( ( ruleQualifiedNameWithWildcard ) )
            // InternalXtype.g:2790:2: ( ruleQualifiedNameWithWildcard )
            {
            // InternalXtype.g:2790:2: ( ruleQualifiedNameWithWildcard )
            // InternalXtype.g:2791:3: ruleQualifiedNameWithWildcard
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__XImportDeclaration__ImportedNamespaceAssignment_1_2"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\2\uffff\1\4\3\uffff\1\4";
    static final String dfa_3s = "\1\4\1\uffff\1\22\1\4\2\uffff\1\22";
    static final String dfa_4s = "\1\32\1\uffff\1\31\1\27\2\uffff\1\31";
    static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String dfa_6s = "\7\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\25\uffff\1\1",
            "",
            "\1\3\6\uffff\1\4",
            "\1\6\22\uffff\1\5",
            "",
            "",
            "\1\3\6\uffff\1\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "501:1: rule__XImportDeclaration__Alternatives_1 : ( ( ( rule__XImportDeclaration__Group_1_0__0 ) ) | ( ( rule__XImportDeclaration__ImportedTypeAssignment_1_1 ) ) | ( ( rule__XImportDeclaration__ImportedNamespaceAssignment_1_2 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000083010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000800010L});

}