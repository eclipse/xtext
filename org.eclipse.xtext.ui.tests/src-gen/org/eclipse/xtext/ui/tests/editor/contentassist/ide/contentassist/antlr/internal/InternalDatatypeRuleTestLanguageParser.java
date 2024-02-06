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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;



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
public class InternalDatatypeRuleTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Types'", "'Type'", "';'", "'Composite'", "'base'", "'<'", "'>'", "','"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalDatatypeRuleTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDatatypeRuleTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDatatypeRuleTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDatatypeRuleTestLanguage.g"; }


    	private DatatypeRuleTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleModel"
    // InternalDatatypeRuleTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalDatatypeRuleTestLanguage.g:60:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalDatatypeRuleTestLanguage.g:67:1: ruleModel : ( ruleTypes ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:71:2: ( ( ruleTypes ) )
            // InternalDatatypeRuleTestLanguage.g:72:2: ( ruleTypes )
            {
            // InternalDatatypeRuleTestLanguage.g:72:2: ( ruleTypes )
            // InternalDatatypeRuleTestLanguage.g:73:3: ruleTypes
            {
             before(grammarAccess.getModelAccess().getTypesParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypes();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTypesParserRuleCall()); 

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


    // $ANTLR start "entryRuleTypes"
    // InternalDatatypeRuleTestLanguage.g:83:1: entryRuleTypes : ruleTypes EOF ;
    public final void entryRuleTypes() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:84:1: ( ruleTypes EOF )
            // InternalDatatypeRuleTestLanguage.g:85:1: ruleTypes EOF
            {
             before(grammarAccess.getTypesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypes();

            state._fsp--;

             after(grammarAccess.getTypesRule()); 
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
    // $ANTLR end "entryRuleTypes"


    // $ANTLR start "ruleTypes"
    // InternalDatatypeRuleTestLanguage.g:92:1: ruleTypes : ( ( rule__Types__Group__0 ) ) ;
    public final void ruleTypes() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:96:2: ( ( ( rule__Types__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:97:2: ( ( rule__Types__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:97:2: ( ( rule__Types__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:98:3: ( rule__Types__Group__0 )
            {
             before(grammarAccess.getTypesAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:99:3: ( rule__Types__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:99:4: rule__Types__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Types__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypesAccess().getGroup()); 

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
    // $ANTLR end "ruleTypes"


    // $ANTLR start "entryRuleType"
    // InternalDatatypeRuleTestLanguage.g:108:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:109:1: ( ruleType EOF )
            // InternalDatatypeRuleTestLanguage.g:110:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalDatatypeRuleTestLanguage.g:117:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:121:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalDatatypeRuleTestLanguage.g:122:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalDatatypeRuleTestLanguage.g:122:2: ( ( rule__Type__Alternatives ) )
            // InternalDatatypeRuleTestLanguage.g:123:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalDatatypeRuleTestLanguage.g:124:3: ( rule__Type__Alternatives )
            // InternalDatatypeRuleTestLanguage.g:124:4: rule__Type__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleSimpleType"
    // InternalDatatypeRuleTestLanguage.g:133:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:134:1: ( ruleSimpleType EOF )
            // InternalDatatypeRuleTestLanguage.g:135:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleType();

            state._fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
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
    // $ANTLR end "entryRuleSimpleType"


    // $ANTLR start "ruleSimpleType"
    // InternalDatatypeRuleTestLanguage.g:142:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:146:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:147:2: ( ( rule__SimpleType__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:147:2: ( ( rule__SimpleType__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:148:3: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:149:3: ( rule__SimpleType__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:149:4: rule__SimpleType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getGroup()); 

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
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleCompositeType"
    // InternalDatatypeRuleTestLanguage.g:158:1: entryRuleCompositeType : ruleCompositeType EOF ;
    public final void entryRuleCompositeType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:159:1: ( ruleCompositeType EOF )
            // InternalDatatypeRuleTestLanguage.g:160:1: ruleCompositeType EOF
            {
             before(grammarAccess.getCompositeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCompositeType();

            state._fsp--;

             after(grammarAccess.getCompositeTypeRule()); 
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
    // $ANTLR end "entryRuleCompositeType"


    // $ANTLR start "ruleCompositeType"
    // InternalDatatypeRuleTestLanguage.g:167:1: ruleCompositeType : ( ( rule__CompositeType__Group__0 ) ) ;
    public final void ruleCompositeType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:171:2: ( ( ( rule__CompositeType__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:172:2: ( ( rule__CompositeType__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:172:2: ( ( rule__CompositeType__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:173:3: ( rule__CompositeType__Group__0 )
            {
             before(grammarAccess.getCompositeTypeAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:174:3: ( rule__CompositeType__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:174:4: rule__CompositeType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getGroup()); 

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
    // $ANTLR end "ruleCompositeType"


    // $ANTLR start "entryRuleCompositeTypeEntry"
    // InternalDatatypeRuleTestLanguage.g:183:1: entryRuleCompositeTypeEntry : ruleCompositeTypeEntry EOF ;
    public final void entryRuleCompositeTypeEntry() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:184:1: ( ruleCompositeTypeEntry EOF )
            // InternalDatatypeRuleTestLanguage.g:185:1: ruleCompositeTypeEntry EOF
            {
             before(grammarAccess.getCompositeTypeEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCompositeTypeEntry();

            state._fsp--;

             after(grammarAccess.getCompositeTypeEntryRule()); 
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
    // $ANTLR end "entryRuleCompositeTypeEntry"


    // $ANTLR start "ruleCompositeTypeEntry"
    // InternalDatatypeRuleTestLanguage.g:192:1: ruleCompositeTypeEntry : ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) ;
    public final void ruleCompositeTypeEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:196:2: ( ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) )
            // InternalDatatypeRuleTestLanguage.g:197:2: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            {
            // InternalDatatypeRuleTestLanguage.g:197:2: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            // InternalDatatypeRuleTestLanguage.g:198:3: ( rule__CompositeTypeEntry__DataTypeAssignment )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 
            // InternalDatatypeRuleTestLanguage.g:199:3: ( rule__CompositeTypeEntry__DataTypeAssignment )
            // InternalDatatypeRuleTestLanguage.g:199:4: rule__CompositeTypeEntry__DataTypeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeTypeEntry__DataTypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 

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
    // $ANTLR end "ruleCompositeTypeEntry"


    // $ANTLR start "entryRuleTypeId"
    // InternalDatatypeRuleTestLanguage.g:208:1: entryRuleTypeId : ruleTypeId EOF ;
    public final void entryRuleTypeId() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:209:1: ( ruleTypeId EOF )
            // InternalDatatypeRuleTestLanguage.g:210:1: ruleTypeId EOF
            {
             before(grammarAccess.getTypeIdRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeId();

            state._fsp--;

             after(grammarAccess.getTypeIdRule()); 
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
    // $ANTLR end "entryRuleTypeId"


    // $ANTLR start "ruleTypeId"
    // InternalDatatypeRuleTestLanguage.g:217:1: ruleTypeId : ( ( rule__TypeId__Group__0 ) ) ;
    public final void ruleTypeId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:221:2: ( ( ( rule__TypeId__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:222:2: ( ( rule__TypeId__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:222:2: ( ( rule__TypeId__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:223:3: ( rule__TypeId__Group__0 )
            {
             before(grammarAccess.getTypeIdAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:224:3: ( rule__TypeId__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:224:4: rule__TypeId__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeIdAccess().getGroup()); 

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
    // $ANTLR end "ruleTypeId"


    // $ANTLR start "rule__Type__Alternatives"
    // InternalDatatypeRuleTestLanguage.g:232:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:236:1: ( ( ruleSimpleType ) | ( ruleCompositeType ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalDatatypeRuleTestLanguage.g:237:2: ( ruleSimpleType )
                    {
                    // InternalDatatypeRuleTestLanguage.g:237:2: ( ruleSimpleType )
                    // InternalDatatypeRuleTestLanguage.g:238:3: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSimpleType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDatatypeRuleTestLanguage.g:243:2: ( ruleCompositeType )
                    {
                    // InternalDatatypeRuleTestLanguage.g:243:2: ( ruleCompositeType )
                    // InternalDatatypeRuleTestLanguage.g:244:3: ruleCompositeType
                    {
                     before(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCompositeType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1()); 

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
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__Types__Group__0"
    // InternalDatatypeRuleTestLanguage.g:253:1: rule__Types__Group__0 : rule__Types__Group__0__Impl rule__Types__Group__1 ;
    public final void rule__Types__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:257:1: ( rule__Types__Group__0__Impl rule__Types__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:258:2: rule__Types__Group__0__Impl rule__Types__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Types__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Types__Group__1();

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
    // $ANTLR end "rule__Types__Group__0"


    // $ANTLR start "rule__Types__Group__0__Impl"
    // InternalDatatypeRuleTestLanguage.g:265:1: rule__Types__Group__0__Impl : ( () ) ;
    public final void rule__Types__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:269:1: ( ( () ) )
            // InternalDatatypeRuleTestLanguage.g:270:1: ( () )
            {
            // InternalDatatypeRuleTestLanguage.g:270:1: ( () )
            // InternalDatatypeRuleTestLanguage.g:271:2: ()
            {
             before(grammarAccess.getTypesAccess().getTypesAction_0()); 
            // InternalDatatypeRuleTestLanguage.g:272:2: ()
            // InternalDatatypeRuleTestLanguage.g:272:3: 
            {
            }

             after(grammarAccess.getTypesAccess().getTypesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Types__Group__0__Impl"


    // $ANTLR start "rule__Types__Group__1"
    // InternalDatatypeRuleTestLanguage.g:280:1: rule__Types__Group__1 : rule__Types__Group__1__Impl rule__Types__Group__2 ;
    public final void rule__Types__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:284:1: ( rule__Types__Group__1__Impl rule__Types__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:285:2: rule__Types__Group__1__Impl rule__Types__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Types__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Types__Group__2();

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
    // $ANTLR end "rule__Types__Group__1"


    // $ANTLR start "rule__Types__Group__1__Impl"
    // InternalDatatypeRuleTestLanguage.g:292:1: rule__Types__Group__1__Impl : ( 'Types' ) ;
    public final void rule__Types__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:296:1: ( ( 'Types' ) )
            // InternalDatatypeRuleTestLanguage.g:297:1: ( 'Types' )
            {
            // InternalDatatypeRuleTestLanguage.g:297:1: ( 'Types' )
            // InternalDatatypeRuleTestLanguage.g:298:2: 'Types'
            {
             before(grammarAccess.getTypesAccess().getTypesKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypesAccess().getTypesKeyword_1()); 

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
    // $ANTLR end "rule__Types__Group__1__Impl"


    // $ANTLR start "rule__Types__Group__2"
    // InternalDatatypeRuleTestLanguage.g:307:1: rule__Types__Group__2 : rule__Types__Group__2__Impl ;
    public final void rule__Types__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:311:1: ( rule__Types__Group__2__Impl )
            // InternalDatatypeRuleTestLanguage.g:312:2: rule__Types__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Types__Group__2__Impl();

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
    // $ANTLR end "rule__Types__Group__2"


    // $ANTLR start "rule__Types__Group__2__Impl"
    // InternalDatatypeRuleTestLanguage.g:318:1: rule__Types__Group__2__Impl : ( ( rule__Types__TypesAssignment_2 )* ) ;
    public final void rule__Types__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:322:1: ( ( ( rule__Types__TypesAssignment_2 )* ) )
            // InternalDatatypeRuleTestLanguage.g:323:1: ( ( rule__Types__TypesAssignment_2 )* )
            {
            // InternalDatatypeRuleTestLanguage.g:323:1: ( ( rule__Types__TypesAssignment_2 )* )
            // InternalDatatypeRuleTestLanguage.g:324:2: ( rule__Types__TypesAssignment_2 )*
            {
             before(grammarAccess.getTypesAccess().getTypesAssignment_2()); 
            // InternalDatatypeRuleTestLanguage.g:325:2: ( rule__Types__TypesAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDatatypeRuleTestLanguage.g:325:3: rule__Types__TypesAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Types__TypesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTypesAccess().getTypesAssignment_2()); 

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
    // $ANTLR end "rule__Types__Group__2__Impl"


    // $ANTLR start "rule__SimpleType__Group__0"
    // InternalDatatypeRuleTestLanguage.g:334:1: rule__SimpleType__Group__0 : rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:338:1: ( rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:339:2: rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__SimpleType__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleType__Group__1();

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
    // $ANTLR end "rule__SimpleType__Group__0"


    // $ANTLR start "rule__SimpleType__Group__0__Impl"
    // InternalDatatypeRuleTestLanguage.g:346:1: rule__SimpleType__Group__0__Impl : ( 'Type' ) ;
    public final void rule__SimpleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:350:1: ( ( 'Type' ) )
            // InternalDatatypeRuleTestLanguage.g:351:1: ( 'Type' )
            {
            // InternalDatatypeRuleTestLanguage.g:351:1: ( 'Type' )
            // InternalDatatypeRuleTestLanguage.g:352:2: 'Type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

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
    // $ANTLR end "rule__SimpleType__Group__0__Impl"


    // $ANTLR start "rule__SimpleType__Group__1"
    // InternalDatatypeRuleTestLanguage.g:361:1: rule__SimpleType__Group__1 : rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:365:1: ( rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:366:2: rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__SimpleType__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleType__Group__2();

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
    // $ANTLR end "rule__SimpleType__Group__1"


    // $ANTLR start "rule__SimpleType__Group__1__Impl"
    // InternalDatatypeRuleTestLanguage.g:373:1: rule__SimpleType__Group__1__Impl : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:377:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // InternalDatatypeRuleTestLanguage.g:378:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:378:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // InternalDatatypeRuleTestLanguage.g:379:2: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // InternalDatatypeRuleTestLanguage.g:380:2: ( rule__SimpleType__NameAssignment_1 )
            // InternalDatatypeRuleTestLanguage.g:380:3: rule__SimpleType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__SimpleType__Group__1__Impl"


    // $ANTLR start "rule__SimpleType__Group__2"
    // InternalDatatypeRuleTestLanguage.g:388:1: rule__SimpleType__Group__2 : rule__SimpleType__Group__2__Impl ;
    public final void rule__SimpleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:392:1: ( rule__SimpleType__Group__2__Impl )
            // InternalDatatypeRuleTestLanguage.g:393:2: rule__SimpleType__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SimpleType__Group__2__Impl();

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
    // $ANTLR end "rule__SimpleType__Group__2"


    // $ANTLR start "rule__SimpleType__Group__2__Impl"
    // InternalDatatypeRuleTestLanguage.g:399:1: rule__SimpleType__Group__2__Impl : ( ';' ) ;
    public final void rule__SimpleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:403:1: ( ( ';' ) )
            // InternalDatatypeRuleTestLanguage.g:404:1: ( ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:404:1: ( ';' )
            // InternalDatatypeRuleTestLanguage.g:405:2: ';'
            {
             before(grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end "rule__SimpleType__Group__2__Impl"


    // $ANTLR start "rule__CompositeType__Group__0"
    // InternalDatatypeRuleTestLanguage.g:415:1: rule__CompositeType__Group__0 : rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 ;
    public final void rule__CompositeType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:419:1: ( rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:420:2: rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__CompositeType__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__Group__1();

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
    // $ANTLR end "rule__CompositeType__Group__0"


    // $ANTLR start "rule__CompositeType__Group__0__Impl"
    // InternalDatatypeRuleTestLanguage.g:427:1: rule__CompositeType__Group__0__Impl : ( 'Composite' ) ;
    public final void rule__CompositeType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:431:1: ( ( 'Composite' ) )
            // InternalDatatypeRuleTestLanguage.g:432:1: ( 'Composite' )
            {
            // InternalDatatypeRuleTestLanguage.g:432:1: ( 'Composite' )
            // InternalDatatypeRuleTestLanguage.g:433:2: 'Composite'
            {
             before(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 

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
    // $ANTLR end "rule__CompositeType__Group__0__Impl"


    // $ANTLR start "rule__CompositeType__Group__1"
    // InternalDatatypeRuleTestLanguage.g:442:1: rule__CompositeType__Group__1 : rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 ;
    public final void rule__CompositeType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:446:1: ( rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:447:2: rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__CompositeType__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__Group__2();

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
    // $ANTLR end "rule__CompositeType__Group__1"


    // $ANTLR start "rule__CompositeType__Group__1__Impl"
    // InternalDatatypeRuleTestLanguage.g:454:1: rule__CompositeType__Group__1__Impl : ( ( rule__CompositeType__NameAssignment_1 ) ) ;
    public final void rule__CompositeType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:458:1: ( ( ( rule__CompositeType__NameAssignment_1 ) ) )
            // InternalDatatypeRuleTestLanguage.g:459:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:459:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            // InternalDatatypeRuleTestLanguage.g:460:2: ( rule__CompositeType__NameAssignment_1 )
            {
             before(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 
            // InternalDatatypeRuleTestLanguage.g:461:2: ( rule__CompositeType__NameAssignment_1 )
            // InternalDatatypeRuleTestLanguage.g:461:3: rule__CompositeType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__CompositeType__Group__1__Impl"


    // $ANTLR start "rule__CompositeType__Group__2"
    // InternalDatatypeRuleTestLanguage.g:469:1: rule__CompositeType__Group__2 : rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 ;
    public final void rule__CompositeType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:473:1: ( rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 )
            // InternalDatatypeRuleTestLanguage.g:474:2: rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__CompositeType__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__Group__3();

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
    // $ANTLR end "rule__CompositeType__Group__2"


    // $ANTLR start "rule__CompositeType__Group__2__Impl"
    // InternalDatatypeRuleTestLanguage.g:481:1: rule__CompositeType__Group__2__Impl : ( 'base' ) ;
    public final void rule__CompositeType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:485:1: ( ( 'base' ) )
            // InternalDatatypeRuleTestLanguage.g:486:1: ( 'base' )
            {
            // InternalDatatypeRuleTestLanguage.g:486:1: ( 'base' )
            // InternalDatatypeRuleTestLanguage.g:487:2: 'base'
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 

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
    // $ANTLR end "rule__CompositeType__Group__2__Impl"


    // $ANTLR start "rule__CompositeType__Group__3"
    // InternalDatatypeRuleTestLanguage.g:496:1: rule__CompositeType__Group__3 : rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 ;
    public final void rule__CompositeType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:500:1: ( rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 )
            // InternalDatatypeRuleTestLanguage.g:501:2: rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__CompositeType__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__Group__4();

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
    // $ANTLR end "rule__CompositeType__Group__3"


    // $ANTLR start "rule__CompositeType__Group__3__Impl"
    // InternalDatatypeRuleTestLanguage.g:508:1: rule__CompositeType__Group__3__Impl : ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) ;
    public final void rule__CompositeType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:512:1: ( ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) )
            // InternalDatatypeRuleTestLanguage.g:513:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:513:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            // InternalDatatypeRuleTestLanguage.g:514:2: ( rule__CompositeType__BaseTypeAssignment_3 )
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 
            // InternalDatatypeRuleTestLanguage.g:515:2: ( rule__CompositeType__BaseTypeAssignment_3 )
            // InternalDatatypeRuleTestLanguage.g:515:3: rule__CompositeType__BaseTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__BaseTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 

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
    // $ANTLR end "rule__CompositeType__Group__3__Impl"


    // $ANTLR start "rule__CompositeType__Group__4"
    // InternalDatatypeRuleTestLanguage.g:523:1: rule__CompositeType__Group__4 : rule__CompositeType__Group__4__Impl ;
    public final void rule__CompositeType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:527:1: ( rule__CompositeType__Group__4__Impl )
            // InternalDatatypeRuleTestLanguage.g:528:2: rule__CompositeType__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CompositeType__Group__4__Impl();

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
    // $ANTLR end "rule__CompositeType__Group__4"


    // $ANTLR start "rule__CompositeType__Group__4__Impl"
    // InternalDatatypeRuleTestLanguage.g:534:1: rule__CompositeType__Group__4__Impl : ( ';' ) ;
    public final void rule__CompositeType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:538:1: ( ( ';' ) )
            // InternalDatatypeRuleTestLanguage.g:539:1: ( ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:539:1: ( ';' )
            // InternalDatatypeRuleTestLanguage.g:540:2: ';'
            {
             before(grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4()); 

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
    // $ANTLR end "rule__CompositeType__Group__4__Impl"


    // $ANTLR start "rule__TypeId__Group__0"
    // InternalDatatypeRuleTestLanguage.g:550:1: rule__TypeId__Group__0 : rule__TypeId__Group__0__Impl rule__TypeId__Group__1 ;
    public final void rule__TypeId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:554:1: ( rule__TypeId__Group__0__Impl rule__TypeId__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:555:2: rule__TypeId__Group__0__Impl rule__TypeId__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__TypeId__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group__1();

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
    // $ANTLR end "rule__TypeId__Group__0"


    // $ANTLR start "rule__TypeId__Group__0__Impl"
    // InternalDatatypeRuleTestLanguage.g:562:1: rule__TypeId__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__TypeId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:566:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:567:1: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:567:1: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:568:2: RULE_ID
            {
             before(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__TypeId__Group__0__Impl"


    // $ANTLR start "rule__TypeId__Group__1"
    // InternalDatatypeRuleTestLanguage.g:577:1: rule__TypeId__Group__1 : rule__TypeId__Group__1__Impl ;
    public final void rule__TypeId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:581:1: ( rule__TypeId__Group__1__Impl )
            // InternalDatatypeRuleTestLanguage.g:582:2: rule__TypeId__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group__1__Impl();

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
    // $ANTLR end "rule__TypeId__Group__1"


    // $ANTLR start "rule__TypeId__Group__1__Impl"
    // InternalDatatypeRuleTestLanguage.g:588:1: rule__TypeId__Group__1__Impl : ( ( rule__TypeId__Group_1__0 )? ) ;
    public final void rule__TypeId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:592:1: ( ( ( rule__TypeId__Group_1__0 )? ) )
            // InternalDatatypeRuleTestLanguage.g:593:1: ( ( rule__TypeId__Group_1__0 )? )
            {
            // InternalDatatypeRuleTestLanguage.g:593:1: ( ( rule__TypeId__Group_1__0 )? )
            // InternalDatatypeRuleTestLanguage.g:594:2: ( rule__TypeId__Group_1__0 )?
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1()); 
            // InternalDatatypeRuleTestLanguage.g:595:2: ( rule__TypeId__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDatatypeRuleTestLanguage.g:595:3: rule__TypeId__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TypeId__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeIdAccess().getGroup_1()); 

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
    // $ANTLR end "rule__TypeId__Group__1__Impl"


    // $ANTLR start "rule__TypeId__Group_1__0"
    // InternalDatatypeRuleTestLanguage.g:604:1: rule__TypeId__Group_1__0 : rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 ;
    public final void rule__TypeId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:608:1: ( rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 )
            // InternalDatatypeRuleTestLanguage.g:609:2: rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TypeId__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group_1__1();

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
    // $ANTLR end "rule__TypeId__Group_1__0"


    // $ANTLR start "rule__TypeId__Group_1__0__Impl"
    // InternalDatatypeRuleTestLanguage.g:616:1: rule__TypeId__Group_1__0__Impl : ( '<' ) ;
    public final void rule__TypeId__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:620:1: ( ( '<' ) )
            // InternalDatatypeRuleTestLanguage.g:621:1: ( '<' )
            {
            // InternalDatatypeRuleTestLanguage.g:621:1: ( '<' )
            // InternalDatatypeRuleTestLanguage.g:622:2: '<'
            {
             before(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 

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
    // $ANTLR end "rule__TypeId__Group_1__0__Impl"


    // $ANTLR start "rule__TypeId__Group_1__1"
    // InternalDatatypeRuleTestLanguage.g:631:1: rule__TypeId__Group_1__1 : rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 ;
    public final void rule__TypeId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:635:1: ( rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 )
            // InternalDatatypeRuleTestLanguage.g:636:2: rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__TypeId__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group_1__2();

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
    // $ANTLR end "rule__TypeId__Group_1__1"


    // $ANTLR start "rule__TypeId__Group_1__1__Impl"
    // InternalDatatypeRuleTestLanguage.g:643:1: rule__TypeId__Group_1__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:647:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:648:1: ( ruleTypeId )
            {
            // InternalDatatypeRuleTestLanguage.g:648:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:649:2: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeId();

            state._fsp--;

             after(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 

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
    // $ANTLR end "rule__TypeId__Group_1__1__Impl"


    // $ANTLR start "rule__TypeId__Group_1__2"
    // InternalDatatypeRuleTestLanguage.g:658:1: rule__TypeId__Group_1__2 : rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 ;
    public final void rule__TypeId__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:662:1: ( rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 )
            // InternalDatatypeRuleTestLanguage.g:663:2: rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__TypeId__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group_1__3();

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
    // $ANTLR end "rule__TypeId__Group_1__2"


    // $ANTLR start "rule__TypeId__Group_1__2__Impl"
    // InternalDatatypeRuleTestLanguage.g:670:1: rule__TypeId__Group_1__2__Impl : ( ( rule__TypeId__Group_1_2__0 )* ) ;
    public final void rule__TypeId__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:674:1: ( ( ( rule__TypeId__Group_1_2__0 )* ) )
            // InternalDatatypeRuleTestLanguage.g:675:1: ( ( rule__TypeId__Group_1_2__0 )* )
            {
            // InternalDatatypeRuleTestLanguage.g:675:1: ( ( rule__TypeId__Group_1_2__0 )* )
            // InternalDatatypeRuleTestLanguage.g:676:2: ( rule__TypeId__Group_1_2__0 )*
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1_2()); 
            // InternalDatatypeRuleTestLanguage.g:677:2: ( rule__TypeId__Group_1_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDatatypeRuleTestLanguage.g:677:3: rule__TypeId__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    rule__TypeId__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTypeIdAccess().getGroup_1_2()); 

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
    // $ANTLR end "rule__TypeId__Group_1__2__Impl"


    // $ANTLR start "rule__TypeId__Group_1__3"
    // InternalDatatypeRuleTestLanguage.g:685:1: rule__TypeId__Group_1__3 : rule__TypeId__Group_1__3__Impl ;
    public final void rule__TypeId__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:689:1: ( rule__TypeId__Group_1__3__Impl )
            // InternalDatatypeRuleTestLanguage.g:690:2: rule__TypeId__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group_1__3__Impl();

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
    // $ANTLR end "rule__TypeId__Group_1__3"


    // $ANTLR start "rule__TypeId__Group_1__3__Impl"
    // InternalDatatypeRuleTestLanguage.g:696:1: rule__TypeId__Group_1__3__Impl : ( '>' ) ;
    public final void rule__TypeId__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:700:1: ( ( '>' ) )
            // InternalDatatypeRuleTestLanguage.g:701:1: ( '>' )
            {
            // InternalDatatypeRuleTestLanguage.g:701:1: ( '>' )
            // InternalDatatypeRuleTestLanguage.g:702:2: '>'
            {
             before(grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3()); 

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
    // $ANTLR end "rule__TypeId__Group_1__3__Impl"


    // $ANTLR start "rule__TypeId__Group_1_2__0"
    // InternalDatatypeRuleTestLanguage.g:712:1: rule__TypeId__Group_1_2__0 : rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 ;
    public final void rule__TypeId__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:716:1: ( rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 )
            // InternalDatatypeRuleTestLanguage.g:717:2: rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TypeId__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group_1_2__1();

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
    // $ANTLR end "rule__TypeId__Group_1_2__0"


    // $ANTLR start "rule__TypeId__Group_1_2__0__Impl"
    // InternalDatatypeRuleTestLanguage.g:724:1: rule__TypeId__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__TypeId__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:728:1: ( ( ',' ) )
            // InternalDatatypeRuleTestLanguage.g:729:1: ( ',' )
            {
            // InternalDatatypeRuleTestLanguage.g:729:1: ( ',' )
            // InternalDatatypeRuleTestLanguage.g:730:2: ','
            {
             before(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 

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
    // $ANTLR end "rule__TypeId__Group_1_2__0__Impl"


    // $ANTLR start "rule__TypeId__Group_1_2__1"
    // InternalDatatypeRuleTestLanguage.g:739:1: rule__TypeId__Group_1_2__1 : rule__TypeId__Group_1_2__1__Impl ;
    public final void rule__TypeId__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:743:1: ( rule__TypeId__Group_1_2__1__Impl )
            // InternalDatatypeRuleTestLanguage.g:744:2: rule__TypeId__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeId__Group_1_2__1__Impl();

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
    // $ANTLR end "rule__TypeId__Group_1_2__1"


    // $ANTLR start "rule__TypeId__Group_1_2__1__Impl"
    // InternalDatatypeRuleTestLanguage.g:750:1: rule__TypeId__Group_1_2__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:754:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:755:1: ( ruleTypeId )
            {
            // InternalDatatypeRuleTestLanguage.g:755:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:756:2: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeId();

            state._fsp--;

             after(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1()); 

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
    // $ANTLR end "rule__TypeId__Group_1_2__1__Impl"


    // $ANTLR start "rule__Types__TypesAssignment_2"
    // InternalDatatypeRuleTestLanguage.g:766:1: rule__Types__TypesAssignment_2 : ( ruleType ) ;
    public final void rule__Types__TypesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:770:1: ( ( ruleType ) )
            // InternalDatatypeRuleTestLanguage.g:771:2: ( ruleType )
            {
            // InternalDatatypeRuleTestLanguage.g:771:2: ( ruleType )
            // InternalDatatypeRuleTestLanguage.g:772:3: ruleType
            {
             before(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Types__TypesAssignment_2"


    // $ANTLR start "rule__SimpleType__NameAssignment_1"
    // InternalDatatypeRuleTestLanguage.g:781:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:785:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:786:2: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:786:2: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:787:3: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__SimpleType__NameAssignment_1"


    // $ANTLR start "rule__CompositeType__NameAssignment_1"
    // InternalDatatypeRuleTestLanguage.g:796:1: rule__CompositeType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CompositeType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:800:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:801:2: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:801:2: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:802:3: RULE_ID
            {
             before(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__CompositeType__NameAssignment_1"


    // $ANTLR start "rule__CompositeType__BaseTypeAssignment_3"
    // InternalDatatypeRuleTestLanguage.g:811:1: rule__CompositeType__BaseTypeAssignment_3 : ( ruleCompositeTypeEntry ) ;
    public final void rule__CompositeType__BaseTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:815:1: ( ( ruleCompositeTypeEntry ) )
            // InternalDatatypeRuleTestLanguage.g:816:2: ( ruleCompositeTypeEntry )
            {
            // InternalDatatypeRuleTestLanguage.g:816:2: ( ruleCompositeTypeEntry )
            // InternalDatatypeRuleTestLanguage.g:817:3: ruleCompositeTypeEntry
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleCompositeTypeEntry();

            state._fsp--;

             after(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__CompositeType__BaseTypeAssignment_3"


    // $ANTLR start "rule__CompositeTypeEntry__DataTypeAssignment"
    // InternalDatatypeRuleTestLanguage.g:826:1: rule__CompositeTypeEntry__DataTypeAssignment : ( ( ruleTypeId ) ) ;
    public final void rule__CompositeTypeEntry__DataTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:830:1: ( ( ( ruleTypeId ) ) )
            // InternalDatatypeRuleTestLanguage.g:831:2: ( ( ruleTypeId ) )
            {
            // InternalDatatypeRuleTestLanguage.g:831:2: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:832:3: ( ruleTypeId )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 
            // InternalDatatypeRuleTestLanguage.g:833:3: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:834:4: ruleTypeId
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeTypeIdParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeId();

            state._fsp--;

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeTypeIdParserRuleCall_0_1()); 

            }

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 

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
    // $ANTLR end "rule__CompositeTypeEntry__DataTypeAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000005000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});
    }


}