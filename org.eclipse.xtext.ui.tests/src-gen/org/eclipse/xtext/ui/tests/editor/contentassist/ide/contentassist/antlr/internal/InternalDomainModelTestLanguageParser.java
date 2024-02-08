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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DomainModelTestLanguageGrammarAccess;



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
public class InternalDomainModelTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'datatype'", "';'", "'class'", "'{'", "'}'", "'extends'", "'attr'", "':'", "'ref'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;

    // delegates
    // delegators


        public InternalDomainModelTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDomainModelTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDomainModelTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDomainModelTestLanguage.g"; }


    	private DomainModelTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(DomainModelTestLanguageGrammarAccess grammarAccess) {
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
    // InternalDomainModelTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalDomainModelTestLanguage.g:60:1: ruleModel EOF
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
    // InternalDomainModelTestLanguage.g:67:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:71:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalDomainModelTestLanguage.g:72:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalDomainModelTestLanguage.g:72:2: ( ( rule__Model__Group__0 ) )
            // InternalDomainModelTestLanguage.g:73:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalDomainModelTestLanguage.g:74:3: ( rule__Model__Group__0 )
            // InternalDomainModelTestLanguage.g:74:4: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

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


    // $ANTLR start "entryRuleImport"
    // InternalDomainModelTestLanguage.g:83:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:84:1: ( ruleImport EOF )
            // InternalDomainModelTestLanguage.g:85:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalDomainModelTestLanguage.g:92:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:96:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalDomainModelTestLanguage.g:97:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalDomainModelTestLanguage.g:97:2: ( ( rule__Import__Group__0 ) )
            // InternalDomainModelTestLanguage.g:98:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalDomainModelTestLanguage.g:99:3: ( rule__Import__Group__0 )
            // InternalDomainModelTestLanguage.g:99:4: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleType"
    // InternalDomainModelTestLanguage.g:108:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:109:1: ( ruleType EOF )
            // InternalDomainModelTestLanguage.g:110:1: ruleType EOF
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
    // InternalDomainModelTestLanguage.g:117:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:121:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalDomainModelTestLanguage.g:122:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalDomainModelTestLanguage.g:122:2: ( ( rule__Type__Alternatives ) )
            // InternalDomainModelTestLanguage.g:123:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalDomainModelTestLanguage.g:124:3: ( rule__Type__Alternatives )
            // InternalDomainModelTestLanguage.g:124:4: rule__Type__Alternatives
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


    // $ANTLR start "entryRuleDataType"
    // InternalDomainModelTestLanguage.g:133:1: entryRuleDataType : ruleDataType EOF ;
    public final void entryRuleDataType() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:134:1: ( ruleDataType EOF )
            // InternalDomainModelTestLanguage.g:135:1: ruleDataType EOF
            {
             before(grammarAccess.getDataTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getDataTypeRule()); 
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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalDomainModelTestLanguage.g:142:1: ruleDataType : ( ( rule__DataType__Group__0 ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:146:2: ( ( ( rule__DataType__Group__0 ) ) )
            // InternalDomainModelTestLanguage.g:147:2: ( ( rule__DataType__Group__0 ) )
            {
            // InternalDomainModelTestLanguage.g:147:2: ( ( rule__DataType__Group__0 ) )
            // InternalDomainModelTestLanguage.g:148:3: ( rule__DataType__Group__0 )
            {
             before(grammarAccess.getDataTypeAccess().getGroup()); 
            // InternalDomainModelTestLanguage.g:149:3: ( rule__DataType__Group__0 )
            // InternalDomainModelTestLanguage.g:149:4: rule__DataType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DataType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getGroup()); 

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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleClass"
    // InternalDomainModelTestLanguage.g:158:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:159:1: ( ruleClass EOF )
            // InternalDomainModelTestLanguage.g:160:1: ruleClass EOF
            {
             before(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getClassRule()); 
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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalDomainModelTestLanguage.g:167:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:171:2: ( ( ( rule__Class__Group__0 ) ) )
            // InternalDomainModelTestLanguage.g:172:2: ( ( rule__Class__Group__0 ) )
            {
            // InternalDomainModelTestLanguage.g:172:2: ( ( rule__Class__Group__0 ) )
            // InternalDomainModelTestLanguage.g:173:3: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // InternalDomainModelTestLanguage.g:174:3: ( rule__Class__Group__0 )
            // InternalDomainModelTestLanguage.g:174:4: rule__Class__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getGroup()); 

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleProperty"
    // InternalDomainModelTestLanguage.g:183:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:184:1: ( ruleProperty EOF )
            // InternalDomainModelTestLanguage.g:185:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getPropertyRule()); 
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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalDomainModelTestLanguage.g:192:1: ruleProperty : ( ( rule__Property__Alternatives ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:196:2: ( ( ( rule__Property__Alternatives ) ) )
            // InternalDomainModelTestLanguage.g:197:2: ( ( rule__Property__Alternatives ) )
            {
            // InternalDomainModelTestLanguage.g:197:2: ( ( rule__Property__Alternatives ) )
            // InternalDomainModelTestLanguage.g:198:3: ( rule__Property__Alternatives )
            {
             before(grammarAccess.getPropertyAccess().getAlternatives()); 
            // InternalDomainModelTestLanguage.g:199:3: ( rule__Property__Alternatives )
            // InternalDomainModelTestLanguage.g:199:4: rule__Property__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Property__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getAlternatives()); 

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleAttribute"
    // InternalDomainModelTestLanguage.g:208:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:209:1: ( ruleAttribute EOF )
            // InternalDomainModelTestLanguage.g:210:1: ruleAttribute EOF
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
    // InternalDomainModelTestLanguage.g:217:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:221:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalDomainModelTestLanguage.g:222:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalDomainModelTestLanguage.g:222:2: ( ( rule__Attribute__Group__0 ) )
            // InternalDomainModelTestLanguage.g:223:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalDomainModelTestLanguage.g:224:3: ( rule__Attribute__Group__0 )
            // InternalDomainModelTestLanguage.g:224:4: rule__Attribute__Group__0
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


    // $ANTLR start "entryRuleReference"
    // InternalDomainModelTestLanguage.g:233:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalDomainModelTestLanguage.g:234:1: ( ruleReference EOF )
            // InternalDomainModelTestLanguage.g:235:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalDomainModelTestLanguage.g:242:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:246:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalDomainModelTestLanguage.g:247:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalDomainModelTestLanguage.g:247:2: ( ( rule__Reference__Group__0 ) )
            // InternalDomainModelTestLanguage.g:248:3: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // InternalDomainModelTestLanguage.g:249:3: ( rule__Reference__Group__0 )
            // InternalDomainModelTestLanguage.g:249:4: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

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
    // $ANTLR end "ruleReference"


    // $ANTLR start "rule__Type__Alternatives"
    // InternalDomainModelTestLanguage.g:257:1: rule__Type__Alternatives : ( ( ruleDataType ) | ( ruleClass ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:261:1: ( ( ruleDataType ) | ( ruleClass ) )
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
                    // InternalDomainModelTestLanguage.g:262:2: ( ruleDataType )
                    {
                    // InternalDomainModelTestLanguage.g:262:2: ( ruleDataType )
                    // InternalDomainModelTestLanguage.g:263:3: ruleDataType
                    {
                     before(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDataType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDomainModelTestLanguage.g:268:2: ( ruleClass )
                    {
                    // InternalDomainModelTestLanguage.g:268:2: ( ruleClass )
                    // InternalDomainModelTestLanguage.g:269:3: ruleClass
                    {
                     before(grammarAccess.getTypeAccess().getClassParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleClass();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getClassParserRuleCall_1()); 

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


    // $ANTLR start "rule__Property__Alternatives"
    // InternalDomainModelTestLanguage.g:278:1: rule__Property__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );
    public final void rule__Property__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:282:1: ( ( ruleAttribute ) | ( ruleReference ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:283:2: ( ruleAttribute )
                    {
                    // InternalDomainModelTestLanguage.g:283:2: ( ruleAttribute )
                    // InternalDomainModelTestLanguage.g:284:3: ruleAttribute
                    {
                     before(grammarAccess.getPropertyAccess().getAttributeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAttribute();

                    state._fsp--;

                     after(grammarAccess.getPropertyAccess().getAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDomainModelTestLanguage.g:289:2: ( ruleReference )
                    {
                    // InternalDomainModelTestLanguage.g:289:2: ( ruleReference )
                    // InternalDomainModelTestLanguage.g:290:3: ruleReference
                    {
                     before(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 

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
    // $ANTLR end "rule__Property__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalDomainModelTestLanguage.g:299:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:303:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalDomainModelTestLanguage.g:304:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__1();

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
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalDomainModelTestLanguage.g:311:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:315:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // InternalDomainModelTestLanguage.g:316:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // InternalDomainModelTestLanguage.g:316:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // InternalDomainModelTestLanguage.g:317:2: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // InternalDomainModelTestLanguage.g:318:2: ( rule__Model__ImportsAssignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:318:3: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Model__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

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
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalDomainModelTestLanguage.g:326:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:330:1: ( rule__Model__Group__1__Impl )
            // InternalDomainModelTestLanguage.g:331:2: rule__Model__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__1__Impl();

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
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalDomainModelTestLanguage.g:337:1: rule__Model__Group__1__Impl : ( ( rule__Model__ElementsAssignment_1 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:341:1: ( ( ( rule__Model__ElementsAssignment_1 )* ) )
            // InternalDomainModelTestLanguage.g:342:1: ( ( rule__Model__ElementsAssignment_1 )* )
            {
            // InternalDomainModelTestLanguage.g:342:1: ( ( rule__Model__ElementsAssignment_1 )* )
            // InternalDomainModelTestLanguage.g:343:2: ( rule__Model__ElementsAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_1()); 
            // InternalDomainModelTestLanguage.g:344:2: ( rule__Model__ElementsAssignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12||LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:344:3: rule__Model__ElementsAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Model__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment_1()); 

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
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalDomainModelTestLanguage.g:353:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:357:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalDomainModelTestLanguage.g:358:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalDomainModelTestLanguage.g:365:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:369:1: ( ( 'import' ) )
            // InternalDomainModelTestLanguage.g:370:1: ( 'import' )
            {
            // InternalDomainModelTestLanguage.g:370:1: ( 'import' )
            // InternalDomainModelTestLanguage.g:371:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

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
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalDomainModelTestLanguage.g:380:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:384:1: ( rule__Import__Group__1__Impl )
            // InternalDomainModelTestLanguage.g:385:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__1__Impl();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalDomainModelTestLanguage.g:391:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:395:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // InternalDomainModelTestLanguage.g:396:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // InternalDomainModelTestLanguage.g:396:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // InternalDomainModelTestLanguage.g:397:2: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // InternalDomainModelTestLanguage.g:398:2: ( rule__Import__ImportURIAssignment_1 )
            // InternalDomainModelTestLanguage.g:398:3: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

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
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__DataType__Group__0"
    // InternalDomainModelTestLanguage.g:407:1: rule__DataType__Group__0 : rule__DataType__Group__0__Impl rule__DataType__Group__1 ;
    public final void rule__DataType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:411:1: ( rule__DataType__Group__0__Impl rule__DataType__Group__1 )
            // InternalDomainModelTestLanguage.g:412:2: rule__DataType__Group__0__Impl rule__DataType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__DataType__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__DataType__Group__1();

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
    // $ANTLR end "rule__DataType__Group__0"


    // $ANTLR start "rule__DataType__Group__0__Impl"
    // InternalDomainModelTestLanguage.g:419:1: rule__DataType__Group__0__Impl : ( 'datatype' ) ;
    public final void rule__DataType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:423:1: ( ( 'datatype' ) )
            // InternalDomainModelTestLanguage.g:424:1: ( 'datatype' )
            {
            // InternalDomainModelTestLanguage.g:424:1: ( 'datatype' )
            // InternalDomainModelTestLanguage.g:425:2: 'datatype'
            {
             before(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0()); 

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
    // $ANTLR end "rule__DataType__Group__0__Impl"


    // $ANTLR start "rule__DataType__Group__1"
    // InternalDomainModelTestLanguage.g:434:1: rule__DataType__Group__1 : rule__DataType__Group__1__Impl rule__DataType__Group__2 ;
    public final void rule__DataType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:438:1: ( rule__DataType__Group__1__Impl rule__DataType__Group__2 )
            // InternalDomainModelTestLanguage.g:439:2: rule__DataType__Group__1__Impl rule__DataType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__DataType__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__DataType__Group__2();

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
    // $ANTLR end "rule__DataType__Group__1"


    // $ANTLR start "rule__DataType__Group__1__Impl"
    // InternalDomainModelTestLanguage.g:446:1: rule__DataType__Group__1__Impl : ( ( rule__DataType__NameAssignment_1 ) ) ;
    public final void rule__DataType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:450:1: ( ( ( rule__DataType__NameAssignment_1 ) ) )
            // InternalDomainModelTestLanguage.g:451:1: ( ( rule__DataType__NameAssignment_1 ) )
            {
            // InternalDomainModelTestLanguage.g:451:1: ( ( rule__DataType__NameAssignment_1 ) )
            // InternalDomainModelTestLanguage.g:452:2: ( rule__DataType__NameAssignment_1 )
            {
             before(grammarAccess.getDataTypeAccess().getNameAssignment_1()); 
            // InternalDomainModelTestLanguage.g:453:2: ( rule__DataType__NameAssignment_1 )
            // InternalDomainModelTestLanguage.g:453:3: rule__DataType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DataType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__DataType__Group__1__Impl"


    // $ANTLR start "rule__DataType__Group__2"
    // InternalDomainModelTestLanguage.g:461:1: rule__DataType__Group__2 : rule__DataType__Group__2__Impl ;
    public final void rule__DataType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:465:1: ( rule__DataType__Group__2__Impl )
            // InternalDomainModelTestLanguage.g:466:2: rule__DataType__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DataType__Group__2__Impl();

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
    // $ANTLR end "rule__DataType__Group__2"


    // $ANTLR start "rule__DataType__Group__2__Impl"
    // InternalDomainModelTestLanguage.g:472:1: rule__DataType__Group__2__Impl : ( ( ';' )? ) ;
    public final void rule__DataType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:476:1: ( ( ( ';' )? ) )
            // InternalDomainModelTestLanguage.g:477:1: ( ( ';' )? )
            {
            // InternalDomainModelTestLanguage.g:477:1: ( ( ';' )? )
            // InternalDomainModelTestLanguage.g:478:2: ( ';' )?
            {
             before(grammarAccess.getDataTypeAccess().getSemicolonKeyword_2()); 
            // InternalDomainModelTestLanguage.g:479:2: ( ';' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:479:3: ';'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getDataTypeAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end "rule__DataType__Group__2__Impl"


    // $ANTLR start "rule__Class__Group__0"
    // InternalDomainModelTestLanguage.g:488:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:492:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalDomainModelTestLanguage.g:493:2: rule__Class__Group__0__Impl rule__Class__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__1();

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
    // $ANTLR end "rule__Class__Group__0"


    // $ANTLR start "rule__Class__Group__0__Impl"
    // InternalDomainModelTestLanguage.g:500:1: rule__Class__Group__0__Impl : ( 'class' ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:504:1: ( ( 'class' ) )
            // InternalDomainModelTestLanguage.g:505:1: ( 'class' )
            {
            // InternalDomainModelTestLanguage.g:505:1: ( 'class' )
            // InternalDomainModelTestLanguage.g:506:2: 'class'
            {
             before(grammarAccess.getClassAccess().getClassKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getClassKeyword_0()); 

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
    // $ANTLR end "rule__Class__Group__0__Impl"


    // $ANTLR start "rule__Class__Group__1"
    // InternalDomainModelTestLanguage.g:515:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:519:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalDomainModelTestLanguage.g:520:2: rule__Class__Group__1__Impl rule__Class__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Class__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__2();

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
    // $ANTLR end "rule__Class__Group__1"


    // $ANTLR start "rule__Class__Group__1__Impl"
    // InternalDomainModelTestLanguage.g:527:1: rule__Class__Group__1__Impl : ( ( rule__Class__NameAssignment_1 ) ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:531:1: ( ( ( rule__Class__NameAssignment_1 ) ) )
            // InternalDomainModelTestLanguage.g:532:1: ( ( rule__Class__NameAssignment_1 ) )
            {
            // InternalDomainModelTestLanguage.g:532:1: ( ( rule__Class__NameAssignment_1 ) )
            // InternalDomainModelTestLanguage.g:533:2: ( rule__Class__NameAssignment_1 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_1()); 
            // InternalDomainModelTestLanguage.g:534:2: ( rule__Class__NameAssignment_1 )
            // InternalDomainModelTestLanguage.g:534:3: rule__Class__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Class__Group__1__Impl"


    // $ANTLR start "rule__Class__Group__2"
    // InternalDomainModelTestLanguage.g:542:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:546:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalDomainModelTestLanguage.g:547:2: rule__Class__Group__2__Impl rule__Class__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Class__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__3();

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
    // $ANTLR end "rule__Class__Group__2"


    // $ANTLR start "rule__Class__Group__2__Impl"
    // InternalDomainModelTestLanguage.g:554:1: rule__Class__Group__2__Impl : ( ( rule__Class__Group_2__0 )? ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:558:1: ( ( ( rule__Class__Group_2__0 )? ) )
            // InternalDomainModelTestLanguage.g:559:1: ( ( rule__Class__Group_2__0 )? )
            {
            // InternalDomainModelTestLanguage.g:559:1: ( ( rule__Class__Group_2__0 )? )
            // InternalDomainModelTestLanguage.g:560:2: ( rule__Class__Group_2__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_2()); 
            // InternalDomainModelTestLanguage.g:561:2: ( rule__Class__Group_2__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:561:3: rule__Class__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Class__Group__2__Impl"


    // $ANTLR start "rule__Class__Group__3"
    // InternalDomainModelTestLanguage.g:569:1: rule__Class__Group__3 : rule__Class__Group__3__Impl rule__Class__Group__4 ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:573:1: ( rule__Class__Group__3__Impl rule__Class__Group__4 )
            // InternalDomainModelTestLanguage.g:574:2: rule__Class__Group__3__Impl rule__Class__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Class__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__4();

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
    // $ANTLR end "rule__Class__Group__3"


    // $ANTLR start "rule__Class__Group__3__Impl"
    // InternalDomainModelTestLanguage.g:581:1: rule__Class__Group__3__Impl : ( '{' ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:585:1: ( ( '{' ) )
            // InternalDomainModelTestLanguage.g:586:1: ( '{' )
            {
            // InternalDomainModelTestLanguage.g:586:1: ( '{' )
            // InternalDomainModelTestLanguage.g:587:2: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__Class__Group__3__Impl"


    // $ANTLR start "rule__Class__Group__4"
    // InternalDomainModelTestLanguage.g:596:1: rule__Class__Group__4 : rule__Class__Group__4__Impl rule__Class__Group__5 ;
    public final void rule__Class__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:600:1: ( rule__Class__Group__4__Impl rule__Class__Group__5 )
            // InternalDomainModelTestLanguage.g:601:2: rule__Class__Group__4__Impl rule__Class__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Class__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__5();

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
    // $ANTLR end "rule__Class__Group__4"


    // $ANTLR start "rule__Class__Group__4__Impl"
    // InternalDomainModelTestLanguage.g:608:1: rule__Class__Group__4__Impl : ( ( rule__Class__PropertiesAssignment_4 )* ) ;
    public final void rule__Class__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:612:1: ( ( ( rule__Class__PropertiesAssignment_4 )* ) )
            // InternalDomainModelTestLanguage.g:613:1: ( ( rule__Class__PropertiesAssignment_4 )* )
            {
            // InternalDomainModelTestLanguage.g:613:1: ( ( rule__Class__PropertiesAssignment_4 )* )
            // InternalDomainModelTestLanguage.g:614:2: ( rule__Class__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getClassAccess().getPropertiesAssignment_4()); 
            // InternalDomainModelTestLanguage.g:615:2: ( rule__Class__PropertiesAssignment_4 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18||LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:615:3: rule__Class__PropertiesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    rule__Class__PropertiesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getPropertiesAssignment_4()); 

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
    // $ANTLR end "rule__Class__Group__4__Impl"


    // $ANTLR start "rule__Class__Group__5"
    // InternalDomainModelTestLanguage.g:623:1: rule__Class__Group__5 : rule__Class__Group__5__Impl rule__Class__Group__6 ;
    public final void rule__Class__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:627:1: ( rule__Class__Group__5__Impl rule__Class__Group__6 )
            // InternalDomainModelTestLanguage.g:628:2: rule__Class__Group__5__Impl rule__Class__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Class__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__6();

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
    // $ANTLR end "rule__Class__Group__5"


    // $ANTLR start "rule__Class__Group__5__Impl"
    // InternalDomainModelTestLanguage.g:635:1: rule__Class__Group__5__Impl : ( ( rule__Class__SubClassesAssignment_5 )* ) ;
    public final void rule__Class__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:639:1: ( ( ( rule__Class__SubClassesAssignment_5 )* ) )
            // InternalDomainModelTestLanguage.g:640:1: ( ( rule__Class__SubClassesAssignment_5 )* )
            {
            // InternalDomainModelTestLanguage.g:640:1: ( ( rule__Class__SubClassesAssignment_5 )* )
            // InternalDomainModelTestLanguage.g:641:2: ( rule__Class__SubClassesAssignment_5 )*
            {
             before(grammarAccess.getClassAccess().getSubClassesAssignment_5()); 
            // InternalDomainModelTestLanguage.g:642:2: ( rule__Class__SubClassesAssignment_5 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:642:3: rule__Class__SubClassesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Class__SubClassesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getSubClassesAssignment_5()); 

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
    // $ANTLR end "rule__Class__Group__5__Impl"


    // $ANTLR start "rule__Class__Group__6"
    // InternalDomainModelTestLanguage.g:650:1: rule__Class__Group__6 : rule__Class__Group__6__Impl ;
    public final void rule__Class__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:654:1: ( rule__Class__Group__6__Impl )
            // InternalDomainModelTestLanguage.g:655:2: rule__Class__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__6__Impl();

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
    // $ANTLR end "rule__Class__Group__6"


    // $ANTLR start "rule__Class__Group__6__Impl"
    // InternalDomainModelTestLanguage.g:661:1: rule__Class__Group__6__Impl : ( '}' ) ;
    public final void rule__Class__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:665:1: ( ( '}' ) )
            // InternalDomainModelTestLanguage.g:666:1: ( '}' )
            {
            // InternalDomainModelTestLanguage.g:666:1: ( '}' )
            // InternalDomainModelTestLanguage.g:667:2: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_6()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__Class__Group__6__Impl"


    // $ANTLR start "rule__Class__Group_2__0"
    // InternalDomainModelTestLanguage.g:677:1: rule__Class__Group_2__0 : rule__Class__Group_2__0__Impl rule__Class__Group_2__1 ;
    public final void rule__Class__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:681:1: ( rule__Class__Group_2__0__Impl rule__Class__Group_2__1 )
            // InternalDomainModelTestLanguage.g:682:2: rule__Class__Group_2__0__Impl rule__Class__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_2__1();

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
    // $ANTLR end "rule__Class__Group_2__0"


    // $ANTLR start "rule__Class__Group_2__0__Impl"
    // InternalDomainModelTestLanguage.g:689:1: rule__Class__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Class__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:693:1: ( ( 'extends' ) )
            // InternalDomainModelTestLanguage.g:694:1: ( 'extends' )
            {
            // InternalDomainModelTestLanguage.g:694:1: ( 'extends' )
            // InternalDomainModelTestLanguage.g:695:2: 'extends'
            {
             before(grammarAccess.getClassAccess().getExtendsKeyword_2_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getExtendsKeyword_2_0()); 

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
    // $ANTLR end "rule__Class__Group_2__0__Impl"


    // $ANTLR start "rule__Class__Group_2__1"
    // InternalDomainModelTestLanguage.g:704:1: rule__Class__Group_2__1 : rule__Class__Group_2__1__Impl ;
    public final void rule__Class__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:708:1: ( rule__Class__Group_2__1__Impl )
            // InternalDomainModelTestLanguage.g:709:2: rule__Class__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_2__1__Impl();

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
    // $ANTLR end "rule__Class__Group_2__1"


    // $ANTLR start "rule__Class__Group_2__1__Impl"
    // InternalDomainModelTestLanguage.g:715:1: rule__Class__Group_2__1__Impl : ( ( rule__Class__SuperClassAssignment_2_1 ) ) ;
    public final void rule__Class__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:719:1: ( ( ( rule__Class__SuperClassAssignment_2_1 ) ) )
            // InternalDomainModelTestLanguage.g:720:1: ( ( rule__Class__SuperClassAssignment_2_1 ) )
            {
            // InternalDomainModelTestLanguage.g:720:1: ( ( rule__Class__SuperClassAssignment_2_1 ) )
            // InternalDomainModelTestLanguage.g:721:2: ( rule__Class__SuperClassAssignment_2_1 )
            {
             before(grammarAccess.getClassAccess().getSuperClassAssignment_2_1()); 
            // InternalDomainModelTestLanguage.g:722:2: ( rule__Class__SuperClassAssignment_2_1 )
            // InternalDomainModelTestLanguage.g:722:3: rule__Class__SuperClassAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__SuperClassAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getSuperClassAssignment_2_1()); 

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
    // $ANTLR end "rule__Class__Group_2__1__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalDomainModelTestLanguage.g:731:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:735:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalDomainModelTestLanguage.g:736:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
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
    // InternalDomainModelTestLanguage.g:743:1: rule__Attribute__Group__0__Impl : ( 'attr' ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:747:1: ( ( 'attr' ) )
            // InternalDomainModelTestLanguage.g:748:1: ( 'attr' )
            {
            // InternalDomainModelTestLanguage.g:748:1: ( 'attr' )
            // InternalDomainModelTestLanguage.g:749:2: 'attr'
            {
             before(grammarAccess.getAttributeAccess().getAttrKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getAttrKeyword_0()); 

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
    // InternalDomainModelTestLanguage.g:758:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:762:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalDomainModelTestLanguage.g:763:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
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
    // InternalDomainModelTestLanguage.g:770:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__NameAssignment_1 ) ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:774:1: ( ( ( rule__Attribute__NameAssignment_1 ) ) )
            // InternalDomainModelTestLanguage.g:775:1: ( ( rule__Attribute__NameAssignment_1 ) )
            {
            // InternalDomainModelTestLanguage.g:775:1: ( ( rule__Attribute__NameAssignment_1 ) )
            // InternalDomainModelTestLanguage.g:776:2: ( rule__Attribute__NameAssignment_1 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_1()); 
            // InternalDomainModelTestLanguage.g:777:2: ( rule__Attribute__NameAssignment_1 )
            // InternalDomainModelTestLanguage.g:777:3: rule__Attribute__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_1()); 

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
    // InternalDomainModelTestLanguage.g:785:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:789:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalDomainModelTestLanguage.g:790:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Attribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__3();

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
    // InternalDomainModelTestLanguage.g:797:1: rule__Attribute__Group__2__Impl : ( ':' ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:801:1: ( ( ':' ) )
            // InternalDomainModelTestLanguage.g:802:1: ( ':' )
            {
            // InternalDomainModelTestLanguage.g:802:1: ( ':' )
            // InternalDomainModelTestLanguage.g:803:2: ':'
            {
             before(grammarAccess.getAttributeAccess().getColonKeyword_2()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getColonKeyword_2()); 

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


    // $ANTLR start "rule__Attribute__Group__3"
    // InternalDomainModelTestLanguage.g:812:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:816:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalDomainModelTestLanguage.g:817:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Attribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__4();

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
    // $ANTLR end "rule__Attribute__Group__3"


    // $ANTLR start "rule__Attribute__Group__3__Impl"
    // InternalDomainModelTestLanguage.g:824:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__TypeAssignment_3 ) ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:828:1: ( ( ( rule__Attribute__TypeAssignment_3 ) ) )
            // InternalDomainModelTestLanguage.g:829:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            {
            // InternalDomainModelTestLanguage.g:829:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            // InternalDomainModelTestLanguage.g:830:2: ( rule__Attribute__TypeAssignment_3 )
            {
             before(grammarAccess.getAttributeAccess().getTypeAssignment_3()); 
            // InternalDomainModelTestLanguage.g:831:2: ( rule__Attribute__TypeAssignment_3 )
            // InternalDomainModelTestLanguage.g:831:3: rule__Attribute__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getTypeAssignment_3()); 

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
    // $ANTLR end "rule__Attribute__Group__3__Impl"


    // $ANTLR start "rule__Attribute__Group__4"
    // InternalDomainModelTestLanguage.g:839:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:843:1: ( rule__Attribute__Group__4__Impl )
            // InternalDomainModelTestLanguage.g:844:2: rule__Attribute__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__4__Impl();

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
    // $ANTLR end "rule__Attribute__Group__4"


    // $ANTLR start "rule__Attribute__Group__4__Impl"
    // InternalDomainModelTestLanguage.g:850:1: rule__Attribute__Group__4__Impl : ( ( ';' )? ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:854:1: ( ( ( ';' )? ) )
            // InternalDomainModelTestLanguage.g:855:1: ( ( ';' )? )
            {
            // InternalDomainModelTestLanguage.g:855:1: ( ( ';' )? )
            // InternalDomainModelTestLanguage.g:856:2: ( ';' )?
            {
             before(grammarAccess.getAttributeAccess().getSemicolonKeyword_4()); 
            // InternalDomainModelTestLanguage.g:857:2: ( ';' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:857:3: ';'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getSemicolonKeyword_4()); 

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
    // $ANTLR end "rule__Attribute__Group__4__Impl"


    // $ANTLR start "rule__Reference__Group__0"
    // InternalDomainModelTestLanguage.g:866:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:870:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalDomainModelTestLanguage.g:871:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__1();

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
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // InternalDomainModelTestLanguage.g:878:1: rule__Reference__Group__0__Impl : ( 'ref' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:882:1: ( ( 'ref' ) )
            // InternalDomainModelTestLanguage.g:883:1: ( 'ref' )
            {
            // InternalDomainModelTestLanguage.g:883:1: ( 'ref' )
            // InternalDomainModelTestLanguage.g:884:2: 'ref'
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 

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
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // InternalDomainModelTestLanguage.g:893:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:897:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // InternalDomainModelTestLanguage.g:898:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__2();

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
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // InternalDomainModelTestLanguage.g:905:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__NameAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:909:1: ( ( ( rule__Reference__NameAssignment_1 ) ) )
            // InternalDomainModelTestLanguage.g:910:1: ( ( rule__Reference__NameAssignment_1 ) )
            {
            // InternalDomainModelTestLanguage.g:910:1: ( ( rule__Reference__NameAssignment_1 ) )
            // InternalDomainModelTestLanguage.g:911:2: ( rule__Reference__NameAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            // InternalDomainModelTestLanguage.g:912:2: ( rule__Reference__NameAssignment_1 )
            // InternalDomainModelTestLanguage.g:912:3: rule__Reference__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__2"
    // InternalDomainModelTestLanguage.g:920:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:924:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // InternalDomainModelTestLanguage.g:925:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__3();

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
    // $ANTLR end "rule__Reference__Group__2"


    // $ANTLR start "rule__Reference__Group__2__Impl"
    // InternalDomainModelTestLanguage.g:932:1: rule__Reference__Group__2__Impl : ( ':' ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:936:1: ( ( ':' ) )
            // InternalDomainModelTestLanguage.g:937:1: ( ':' )
            {
            // InternalDomainModelTestLanguage.g:937:1: ( ':' )
            // InternalDomainModelTestLanguage.g:938:2: ':'
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__Reference__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__3"
    // InternalDomainModelTestLanguage.g:947:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:951:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // InternalDomainModelTestLanguage.g:952:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Reference__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__4();

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
    // $ANTLR end "rule__Reference__Group__3"


    // $ANTLR start "rule__Reference__Group__3__Impl"
    // InternalDomainModelTestLanguage.g:959:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__TypeAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:963:1: ( ( ( rule__Reference__TypeAssignment_3 ) ) )
            // InternalDomainModelTestLanguage.g:964:1: ( ( rule__Reference__TypeAssignment_3 ) )
            {
            // InternalDomainModelTestLanguage.g:964:1: ( ( rule__Reference__TypeAssignment_3 ) )
            // InternalDomainModelTestLanguage.g:965:2: ( rule__Reference__TypeAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
            // InternalDomainModelTestLanguage.g:966:2: ( rule__Reference__TypeAssignment_3 )
            // InternalDomainModelTestLanguage.g:966:3: rule__Reference__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 

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
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__4"
    // InternalDomainModelTestLanguage.g:974:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:978:1: ( rule__Reference__Group__4__Impl )
            // InternalDomainModelTestLanguage.g:979:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__4__Impl();

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
    // $ANTLR end "rule__Reference__Group__4"


    // $ANTLR start "rule__Reference__Group__4__Impl"
    // InternalDomainModelTestLanguage.g:985:1: rule__Reference__Group__4__Impl : ( ( ';' )? ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:989:1: ( ( ( ';' )? ) )
            // InternalDomainModelTestLanguage.g:990:1: ( ( ';' )? )
            {
            // InternalDomainModelTestLanguage.g:990:1: ( ( ';' )? )
            // InternalDomainModelTestLanguage.g:991:2: ( ';' )?
            {
             before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4()); 
            // InternalDomainModelTestLanguage.g:992:2: ( ';' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:992:3: ';'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4()); 

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
    // $ANTLR end "rule__Reference__Group__4__Impl"


    // $ANTLR start "rule__Model__ImportsAssignment_0"
    // InternalDomainModelTestLanguage.g:1001:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1005:1: ( ( ruleImport ) )
            // InternalDomainModelTestLanguage.g:1006:2: ( ruleImport )
            {
            // InternalDomainModelTestLanguage.g:1006:2: ( ruleImport )
            // InternalDomainModelTestLanguage.g:1007:3: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Model__ImportsAssignment_0"


    // $ANTLR start "rule__Model__ElementsAssignment_1"
    // InternalDomainModelTestLanguage.g:1016:1: rule__Model__ElementsAssignment_1 : ( ruleType ) ;
    public final void rule__Model__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1020:1: ( ( ruleType ) )
            // InternalDomainModelTestLanguage.g:1021:2: ( ruleType )
            {
            // InternalDomainModelTestLanguage.g:1021:2: ( ruleType )
            // InternalDomainModelTestLanguage.g:1022:3: ruleType
            {
             before(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Model__ElementsAssignment_1"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // InternalDomainModelTestLanguage.g:1031:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1035:1: ( ( RULE_STRING ) )
            // InternalDomainModelTestLanguage.g:1036:2: ( RULE_STRING )
            {
            // InternalDomainModelTestLanguage.g:1036:2: ( RULE_STRING )
            // InternalDomainModelTestLanguage.g:1037:3: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Import__ImportURIAssignment_1"


    // $ANTLR start "rule__DataType__NameAssignment_1"
    // InternalDomainModelTestLanguage.g:1046:1: rule__DataType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1050:1: ( ( RULE_ID ) )
            // InternalDomainModelTestLanguage.g:1051:2: ( RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:1051:2: ( RULE_ID )
            // InternalDomainModelTestLanguage.g:1052:3: RULE_ID
            {
             before(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__DataType__NameAssignment_1"


    // $ANTLR start "rule__Class__NameAssignment_1"
    // InternalDomainModelTestLanguage.g:1061:1: rule__Class__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Class__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1065:1: ( ( RULE_ID ) )
            // InternalDomainModelTestLanguage.g:1066:2: ( RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:1066:2: ( RULE_ID )
            // InternalDomainModelTestLanguage.g:1067:3: RULE_ID
            {
             before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Class__NameAssignment_1"


    // $ANTLR start "rule__Class__SuperClassAssignment_2_1"
    // InternalDomainModelTestLanguage.g:1076:1: rule__Class__SuperClassAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperClassAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1080:1: ( ( ( RULE_ID ) ) )
            // InternalDomainModelTestLanguage.g:1081:2: ( ( RULE_ID ) )
            {
            // InternalDomainModelTestLanguage.g:1081:2: ( ( RULE_ID ) )
            // InternalDomainModelTestLanguage.g:1082:3: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_2_1_0()); 
            // InternalDomainModelTestLanguage.g:1083:3: ( RULE_ID )
            // InternalDomainModelTestLanguage.g:1084:4: RULE_ID
            {
             before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_2_1_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_2_1"


    // $ANTLR start "rule__Class__PropertiesAssignment_4"
    // InternalDomainModelTestLanguage.g:1095:1: rule__Class__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__Class__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1099:1: ( ( ruleProperty ) )
            // InternalDomainModelTestLanguage.g:1100:2: ( ruleProperty )
            {
            // InternalDomainModelTestLanguage.g:1100:2: ( ruleProperty )
            // InternalDomainModelTestLanguage.g:1101:3: ruleProperty
            {
             before(grammarAccess.getClassAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getClassAccess().getPropertiesPropertyParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__Class__PropertiesAssignment_4"


    // $ANTLR start "rule__Class__SubClassesAssignment_5"
    // InternalDomainModelTestLanguage.g:1110:1: rule__Class__SubClassesAssignment_5 : ( ruleClass ) ;
    public final void rule__Class__SubClassesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1114:1: ( ( ruleClass ) )
            // InternalDomainModelTestLanguage.g:1115:2: ( ruleClass )
            {
            // InternalDomainModelTestLanguage.g:1115:2: ( ruleClass )
            // InternalDomainModelTestLanguage.g:1116:3: ruleClass
            {
             before(grammarAccess.getClassAccess().getSubClassesClassParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getClassAccess().getSubClassesClassParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__Class__SubClassesAssignment_5"


    // $ANTLR start "rule__Attribute__NameAssignment_1"
    // InternalDomainModelTestLanguage.g:1125:1: rule__Attribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1129:1: ( ( RULE_ID ) )
            // InternalDomainModelTestLanguage.g:1130:2: ( RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:1130:2: ( RULE_ID )
            // InternalDomainModelTestLanguage.g:1131:3: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Attribute__NameAssignment_1"


    // $ANTLR start "rule__Attribute__TypeAssignment_3"
    // InternalDomainModelTestLanguage.g:1140:1: rule__Attribute__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1144:1: ( ( ( RULE_ID ) ) )
            // InternalDomainModelTestLanguage.g:1145:2: ( ( RULE_ID ) )
            {
            // InternalDomainModelTestLanguage.g:1145:2: ( ( RULE_ID ) )
            // InternalDomainModelTestLanguage.g:1146:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getTypeDataTypeCrossReference_3_0()); 
            // InternalDomainModelTestLanguage.g:1147:3: ( RULE_ID )
            // InternalDomainModelTestLanguage.g:1148:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getTypeDataTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getTypeDataTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getTypeDataTypeCrossReference_3_0()); 

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
    // $ANTLR end "rule__Attribute__TypeAssignment_3"


    // $ANTLR start "rule__Reference__NameAssignment_1"
    // InternalDomainModelTestLanguage.g:1159:1: rule__Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1163:1: ( ( RULE_ID ) )
            // InternalDomainModelTestLanguage.g:1164:2: ( RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:1164:2: ( RULE_ID )
            // InternalDomainModelTestLanguage.g:1165:3: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Reference__NameAssignment_1"


    // $ANTLR start "rule__Reference__TypeAssignment_3"
    // InternalDomainModelTestLanguage.g:1174:1: rule__Reference__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDomainModelTestLanguage.g:1178:1: ( ( ( RULE_ID ) ) )
            // InternalDomainModelTestLanguage.g:1179:2: ( ( RULE_ID ) )
            {
            // InternalDomainModelTestLanguage.g:1179:2: ( ( RULE_ID ) )
            // InternalDomainModelTestLanguage.g:1180:3: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getTypeClassCrossReference_3_0()); 
            // InternalDomainModelTestLanguage.g:1181:3: ( RULE_ID )
            // InternalDomainModelTestLanguage.g:1182:4: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getTypeClassIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getTypeClassIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getTypeClassCrossReference_3_0()); 

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
    // $ANTLR end "rule__Reference__TypeAssignment_3"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000005000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000028000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000155000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000140002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    }


}