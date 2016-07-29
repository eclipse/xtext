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
    // InternalDatatypeRuleTestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:54:1: ( ruleModel EOF )
            // InternalDatatypeRuleTestLanguage.g:55:1: ruleModel EOF
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
    // InternalDatatypeRuleTestLanguage.g:62:1: ruleModel : ( ruleTypes ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:66:2: ( ( ruleTypes ) )
            // InternalDatatypeRuleTestLanguage.g:67:2: ( ruleTypes )
            {
            // InternalDatatypeRuleTestLanguage.g:67:2: ( ruleTypes )
            // InternalDatatypeRuleTestLanguage.g:68:3: ruleTypes
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
    // InternalDatatypeRuleTestLanguage.g:78:1: entryRuleTypes : ruleTypes EOF ;
    public final void entryRuleTypes() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:79:1: ( ruleTypes EOF )
            // InternalDatatypeRuleTestLanguage.g:80:1: ruleTypes EOF
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
    // InternalDatatypeRuleTestLanguage.g:87:1: ruleTypes : ( ( rule__Types__Group__0 ) ) ;
    public final void ruleTypes() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:91:2: ( ( ( rule__Types__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:92:2: ( ( rule__Types__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:92:2: ( ( rule__Types__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:93:3: ( rule__Types__Group__0 )
            {
             before(grammarAccess.getTypesAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:94:3: ( rule__Types__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:94:4: rule__Types__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:103:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:104:1: ( ruleType EOF )
            // InternalDatatypeRuleTestLanguage.g:105:1: ruleType EOF
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
    // InternalDatatypeRuleTestLanguage.g:112:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:116:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalDatatypeRuleTestLanguage.g:117:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalDatatypeRuleTestLanguage.g:117:2: ( ( rule__Type__Alternatives ) )
            // InternalDatatypeRuleTestLanguage.g:118:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalDatatypeRuleTestLanguage.g:119:3: ( rule__Type__Alternatives )
            // InternalDatatypeRuleTestLanguage.g:119:4: rule__Type__Alternatives
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
    // InternalDatatypeRuleTestLanguage.g:128:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:129:1: ( ruleSimpleType EOF )
            // InternalDatatypeRuleTestLanguage.g:130:1: ruleSimpleType EOF
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
    // InternalDatatypeRuleTestLanguage.g:137:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:141:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:142:2: ( ( rule__SimpleType__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:142:2: ( ( rule__SimpleType__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:143:3: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:144:3: ( rule__SimpleType__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:144:4: rule__SimpleType__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:153:1: entryRuleCompositeType : ruleCompositeType EOF ;
    public final void entryRuleCompositeType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:154:1: ( ruleCompositeType EOF )
            // InternalDatatypeRuleTestLanguage.g:155:1: ruleCompositeType EOF
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
    // InternalDatatypeRuleTestLanguage.g:162:1: ruleCompositeType : ( ( rule__CompositeType__Group__0 ) ) ;
    public final void ruleCompositeType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:166:2: ( ( ( rule__CompositeType__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:167:2: ( ( rule__CompositeType__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:167:2: ( ( rule__CompositeType__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:168:3: ( rule__CompositeType__Group__0 )
            {
             before(grammarAccess.getCompositeTypeAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:169:3: ( rule__CompositeType__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:169:4: rule__CompositeType__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:178:1: entryRuleCompositeTypeEntry : ruleCompositeTypeEntry EOF ;
    public final void entryRuleCompositeTypeEntry() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:179:1: ( ruleCompositeTypeEntry EOF )
            // InternalDatatypeRuleTestLanguage.g:180:1: ruleCompositeTypeEntry EOF
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
    // InternalDatatypeRuleTestLanguage.g:187:1: ruleCompositeTypeEntry : ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) ;
    public final void ruleCompositeTypeEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:191:2: ( ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) )
            // InternalDatatypeRuleTestLanguage.g:192:2: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            {
            // InternalDatatypeRuleTestLanguage.g:192:2: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            // InternalDatatypeRuleTestLanguage.g:193:3: ( rule__CompositeTypeEntry__DataTypeAssignment )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 
            // InternalDatatypeRuleTestLanguage.g:194:3: ( rule__CompositeTypeEntry__DataTypeAssignment )
            // InternalDatatypeRuleTestLanguage.g:194:4: rule__CompositeTypeEntry__DataTypeAssignment
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
    // InternalDatatypeRuleTestLanguage.g:203:1: entryRuleTypeId : ruleTypeId EOF ;
    public final void entryRuleTypeId() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:204:1: ( ruleTypeId EOF )
            // InternalDatatypeRuleTestLanguage.g:205:1: ruleTypeId EOF
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
    // InternalDatatypeRuleTestLanguage.g:212:1: ruleTypeId : ( ( rule__TypeId__Group__0 ) ) ;
    public final void ruleTypeId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:216:2: ( ( ( rule__TypeId__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:217:2: ( ( rule__TypeId__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:217:2: ( ( rule__TypeId__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:218:3: ( rule__TypeId__Group__0 )
            {
             before(grammarAccess.getTypeIdAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:219:3: ( rule__TypeId__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:219:4: rule__TypeId__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:227:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:231:1: ( ( ruleSimpleType ) | ( ruleCompositeType ) )
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
                    // InternalDatatypeRuleTestLanguage.g:232:2: ( ruleSimpleType )
                    {
                    // InternalDatatypeRuleTestLanguage.g:232:2: ( ruleSimpleType )
                    // InternalDatatypeRuleTestLanguage.g:233:3: ruleSimpleType
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
                    // InternalDatatypeRuleTestLanguage.g:238:2: ( ruleCompositeType )
                    {
                    // InternalDatatypeRuleTestLanguage.g:238:2: ( ruleCompositeType )
                    // InternalDatatypeRuleTestLanguage.g:239:3: ruleCompositeType
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
    // InternalDatatypeRuleTestLanguage.g:248:1: rule__Types__Group__0 : rule__Types__Group__0__Impl rule__Types__Group__1 ;
    public final void rule__Types__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:252:1: ( rule__Types__Group__0__Impl rule__Types__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:253:2: rule__Types__Group__0__Impl rule__Types__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:260:1: rule__Types__Group__0__Impl : ( () ) ;
    public final void rule__Types__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:264:1: ( ( () ) )
            // InternalDatatypeRuleTestLanguage.g:265:1: ( () )
            {
            // InternalDatatypeRuleTestLanguage.g:265:1: ( () )
            // InternalDatatypeRuleTestLanguage.g:266:2: ()
            {
             before(grammarAccess.getTypesAccess().getTypesAction_0()); 
            // InternalDatatypeRuleTestLanguage.g:267:2: ()
            // InternalDatatypeRuleTestLanguage.g:267:3: 
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
    // InternalDatatypeRuleTestLanguage.g:275:1: rule__Types__Group__1 : rule__Types__Group__1__Impl rule__Types__Group__2 ;
    public final void rule__Types__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:279:1: ( rule__Types__Group__1__Impl rule__Types__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:280:2: rule__Types__Group__1__Impl rule__Types__Group__2
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
    // InternalDatatypeRuleTestLanguage.g:287:1: rule__Types__Group__1__Impl : ( 'Types' ) ;
    public final void rule__Types__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:291:1: ( ( 'Types' ) )
            // InternalDatatypeRuleTestLanguage.g:292:1: ( 'Types' )
            {
            // InternalDatatypeRuleTestLanguage.g:292:1: ( 'Types' )
            // InternalDatatypeRuleTestLanguage.g:293:2: 'Types'
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
    // InternalDatatypeRuleTestLanguage.g:302:1: rule__Types__Group__2 : rule__Types__Group__2__Impl ;
    public final void rule__Types__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:306:1: ( rule__Types__Group__2__Impl )
            // InternalDatatypeRuleTestLanguage.g:307:2: rule__Types__Group__2__Impl
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
    // InternalDatatypeRuleTestLanguage.g:313:1: rule__Types__Group__2__Impl : ( ( rule__Types__TypesAssignment_2 )* ) ;
    public final void rule__Types__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:317:1: ( ( ( rule__Types__TypesAssignment_2 )* ) )
            // InternalDatatypeRuleTestLanguage.g:318:1: ( ( rule__Types__TypesAssignment_2 )* )
            {
            // InternalDatatypeRuleTestLanguage.g:318:1: ( ( rule__Types__TypesAssignment_2 )* )
            // InternalDatatypeRuleTestLanguage.g:319:2: ( rule__Types__TypesAssignment_2 )*
            {
             before(grammarAccess.getTypesAccess().getTypesAssignment_2()); 
            // InternalDatatypeRuleTestLanguage.g:320:2: ( rule__Types__TypesAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDatatypeRuleTestLanguage.g:320:3: rule__Types__TypesAssignment_2
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
    // InternalDatatypeRuleTestLanguage.g:329:1: rule__SimpleType__Group__0 : rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:333:1: ( rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:334:2: rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:341:1: rule__SimpleType__Group__0__Impl : ( 'Type' ) ;
    public final void rule__SimpleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:345:1: ( ( 'Type' ) )
            // InternalDatatypeRuleTestLanguage.g:346:1: ( 'Type' )
            {
            // InternalDatatypeRuleTestLanguage.g:346:1: ( 'Type' )
            // InternalDatatypeRuleTestLanguage.g:347:2: 'Type'
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
    // InternalDatatypeRuleTestLanguage.g:356:1: rule__SimpleType__Group__1 : rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:360:1: ( rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:361:2: rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2
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
    // InternalDatatypeRuleTestLanguage.g:368:1: rule__SimpleType__Group__1__Impl : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:372:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // InternalDatatypeRuleTestLanguage.g:373:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:373:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // InternalDatatypeRuleTestLanguage.g:374:2: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // InternalDatatypeRuleTestLanguage.g:375:2: ( rule__SimpleType__NameAssignment_1 )
            // InternalDatatypeRuleTestLanguage.g:375:3: rule__SimpleType__NameAssignment_1
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
    // InternalDatatypeRuleTestLanguage.g:383:1: rule__SimpleType__Group__2 : rule__SimpleType__Group__2__Impl ;
    public final void rule__SimpleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:387:1: ( rule__SimpleType__Group__2__Impl )
            // InternalDatatypeRuleTestLanguage.g:388:2: rule__SimpleType__Group__2__Impl
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
    // InternalDatatypeRuleTestLanguage.g:394:1: rule__SimpleType__Group__2__Impl : ( ';' ) ;
    public final void rule__SimpleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:398:1: ( ( ';' ) )
            // InternalDatatypeRuleTestLanguage.g:399:1: ( ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:399:1: ( ';' )
            // InternalDatatypeRuleTestLanguage.g:400:2: ';'
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
    // InternalDatatypeRuleTestLanguage.g:410:1: rule__CompositeType__Group__0 : rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 ;
    public final void rule__CompositeType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:414:1: ( rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:415:2: rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:422:1: rule__CompositeType__Group__0__Impl : ( 'Composite' ) ;
    public final void rule__CompositeType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:426:1: ( ( 'Composite' ) )
            // InternalDatatypeRuleTestLanguage.g:427:1: ( 'Composite' )
            {
            // InternalDatatypeRuleTestLanguage.g:427:1: ( 'Composite' )
            // InternalDatatypeRuleTestLanguage.g:428:2: 'Composite'
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
    // InternalDatatypeRuleTestLanguage.g:437:1: rule__CompositeType__Group__1 : rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 ;
    public final void rule__CompositeType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:441:1: ( rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:442:2: rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2
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
    // InternalDatatypeRuleTestLanguage.g:449:1: rule__CompositeType__Group__1__Impl : ( ( rule__CompositeType__NameAssignment_1 ) ) ;
    public final void rule__CompositeType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:453:1: ( ( ( rule__CompositeType__NameAssignment_1 ) ) )
            // InternalDatatypeRuleTestLanguage.g:454:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:454:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            // InternalDatatypeRuleTestLanguage.g:455:2: ( rule__CompositeType__NameAssignment_1 )
            {
             before(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 
            // InternalDatatypeRuleTestLanguage.g:456:2: ( rule__CompositeType__NameAssignment_1 )
            // InternalDatatypeRuleTestLanguage.g:456:3: rule__CompositeType__NameAssignment_1
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
    // InternalDatatypeRuleTestLanguage.g:464:1: rule__CompositeType__Group__2 : rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 ;
    public final void rule__CompositeType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:468:1: ( rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 )
            // InternalDatatypeRuleTestLanguage.g:469:2: rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3
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
    // InternalDatatypeRuleTestLanguage.g:476:1: rule__CompositeType__Group__2__Impl : ( 'base' ) ;
    public final void rule__CompositeType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:480:1: ( ( 'base' ) )
            // InternalDatatypeRuleTestLanguage.g:481:1: ( 'base' )
            {
            // InternalDatatypeRuleTestLanguage.g:481:1: ( 'base' )
            // InternalDatatypeRuleTestLanguage.g:482:2: 'base'
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
    // InternalDatatypeRuleTestLanguage.g:491:1: rule__CompositeType__Group__3 : rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 ;
    public final void rule__CompositeType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:495:1: ( rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 )
            // InternalDatatypeRuleTestLanguage.g:496:2: rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4
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
    // InternalDatatypeRuleTestLanguage.g:503:1: rule__CompositeType__Group__3__Impl : ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) ;
    public final void rule__CompositeType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:507:1: ( ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) )
            // InternalDatatypeRuleTestLanguage.g:508:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:508:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            // InternalDatatypeRuleTestLanguage.g:509:2: ( rule__CompositeType__BaseTypeAssignment_3 )
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 
            // InternalDatatypeRuleTestLanguage.g:510:2: ( rule__CompositeType__BaseTypeAssignment_3 )
            // InternalDatatypeRuleTestLanguage.g:510:3: rule__CompositeType__BaseTypeAssignment_3
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
    // InternalDatatypeRuleTestLanguage.g:518:1: rule__CompositeType__Group__4 : rule__CompositeType__Group__4__Impl ;
    public final void rule__CompositeType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:522:1: ( rule__CompositeType__Group__4__Impl )
            // InternalDatatypeRuleTestLanguage.g:523:2: rule__CompositeType__Group__4__Impl
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
    // InternalDatatypeRuleTestLanguage.g:529:1: rule__CompositeType__Group__4__Impl : ( ';' ) ;
    public final void rule__CompositeType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:533:1: ( ( ';' ) )
            // InternalDatatypeRuleTestLanguage.g:534:1: ( ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:534:1: ( ';' )
            // InternalDatatypeRuleTestLanguage.g:535:2: ';'
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
    // InternalDatatypeRuleTestLanguage.g:545:1: rule__TypeId__Group__0 : rule__TypeId__Group__0__Impl rule__TypeId__Group__1 ;
    public final void rule__TypeId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:549:1: ( rule__TypeId__Group__0__Impl rule__TypeId__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:550:2: rule__TypeId__Group__0__Impl rule__TypeId__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:557:1: rule__TypeId__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__TypeId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:561:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:562:1: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:562:1: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:563:2: RULE_ID
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
    // InternalDatatypeRuleTestLanguage.g:572:1: rule__TypeId__Group__1 : rule__TypeId__Group__1__Impl ;
    public final void rule__TypeId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:576:1: ( rule__TypeId__Group__1__Impl )
            // InternalDatatypeRuleTestLanguage.g:577:2: rule__TypeId__Group__1__Impl
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
    // InternalDatatypeRuleTestLanguage.g:583:1: rule__TypeId__Group__1__Impl : ( ( rule__TypeId__Group_1__0 )? ) ;
    public final void rule__TypeId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:587:1: ( ( ( rule__TypeId__Group_1__0 )? ) )
            // InternalDatatypeRuleTestLanguage.g:588:1: ( ( rule__TypeId__Group_1__0 )? )
            {
            // InternalDatatypeRuleTestLanguage.g:588:1: ( ( rule__TypeId__Group_1__0 )? )
            // InternalDatatypeRuleTestLanguage.g:589:2: ( rule__TypeId__Group_1__0 )?
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1()); 
            // InternalDatatypeRuleTestLanguage.g:590:2: ( rule__TypeId__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDatatypeRuleTestLanguage.g:590:3: rule__TypeId__Group_1__0
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
    // InternalDatatypeRuleTestLanguage.g:599:1: rule__TypeId__Group_1__0 : rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 ;
    public final void rule__TypeId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:603:1: ( rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 )
            // InternalDatatypeRuleTestLanguage.g:604:2: rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1
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
    // InternalDatatypeRuleTestLanguage.g:611:1: rule__TypeId__Group_1__0__Impl : ( '<' ) ;
    public final void rule__TypeId__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:615:1: ( ( '<' ) )
            // InternalDatatypeRuleTestLanguage.g:616:1: ( '<' )
            {
            // InternalDatatypeRuleTestLanguage.g:616:1: ( '<' )
            // InternalDatatypeRuleTestLanguage.g:617:2: '<'
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
    // InternalDatatypeRuleTestLanguage.g:626:1: rule__TypeId__Group_1__1 : rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 ;
    public final void rule__TypeId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:630:1: ( rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 )
            // InternalDatatypeRuleTestLanguage.g:631:2: rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2
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
    // InternalDatatypeRuleTestLanguage.g:638:1: rule__TypeId__Group_1__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:642:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:643:1: ( ruleTypeId )
            {
            // InternalDatatypeRuleTestLanguage.g:643:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:644:2: ruleTypeId
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
    // InternalDatatypeRuleTestLanguage.g:653:1: rule__TypeId__Group_1__2 : rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 ;
    public final void rule__TypeId__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:657:1: ( rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 )
            // InternalDatatypeRuleTestLanguage.g:658:2: rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3
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
    // InternalDatatypeRuleTestLanguage.g:665:1: rule__TypeId__Group_1__2__Impl : ( ( rule__TypeId__Group_1_2__0 )* ) ;
    public final void rule__TypeId__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:669:1: ( ( ( rule__TypeId__Group_1_2__0 )* ) )
            // InternalDatatypeRuleTestLanguage.g:670:1: ( ( rule__TypeId__Group_1_2__0 )* )
            {
            // InternalDatatypeRuleTestLanguage.g:670:1: ( ( rule__TypeId__Group_1_2__0 )* )
            // InternalDatatypeRuleTestLanguage.g:671:2: ( rule__TypeId__Group_1_2__0 )*
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1_2()); 
            // InternalDatatypeRuleTestLanguage.g:672:2: ( rule__TypeId__Group_1_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDatatypeRuleTestLanguage.g:672:3: rule__TypeId__Group_1_2__0
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
    // InternalDatatypeRuleTestLanguage.g:680:1: rule__TypeId__Group_1__3 : rule__TypeId__Group_1__3__Impl ;
    public final void rule__TypeId__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:684:1: ( rule__TypeId__Group_1__3__Impl )
            // InternalDatatypeRuleTestLanguage.g:685:2: rule__TypeId__Group_1__3__Impl
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
    // InternalDatatypeRuleTestLanguage.g:691:1: rule__TypeId__Group_1__3__Impl : ( '>' ) ;
    public final void rule__TypeId__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:695:1: ( ( '>' ) )
            // InternalDatatypeRuleTestLanguage.g:696:1: ( '>' )
            {
            // InternalDatatypeRuleTestLanguage.g:696:1: ( '>' )
            // InternalDatatypeRuleTestLanguage.g:697:2: '>'
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
    // InternalDatatypeRuleTestLanguage.g:707:1: rule__TypeId__Group_1_2__0 : rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 ;
    public final void rule__TypeId__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:711:1: ( rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 )
            // InternalDatatypeRuleTestLanguage.g:712:2: rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1
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
    // InternalDatatypeRuleTestLanguage.g:719:1: rule__TypeId__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__TypeId__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:723:1: ( ( ',' ) )
            // InternalDatatypeRuleTestLanguage.g:724:1: ( ',' )
            {
            // InternalDatatypeRuleTestLanguage.g:724:1: ( ',' )
            // InternalDatatypeRuleTestLanguage.g:725:2: ','
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
    // InternalDatatypeRuleTestLanguage.g:734:1: rule__TypeId__Group_1_2__1 : rule__TypeId__Group_1_2__1__Impl ;
    public final void rule__TypeId__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:738:1: ( rule__TypeId__Group_1_2__1__Impl )
            // InternalDatatypeRuleTestLanguage.g:739:2: rule__TypeId__Group_1_2__1__Impl
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
    // InternalDatatypeRuleTestLanguage.g:745:1: rule__TypeId__Group_1_2__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:749:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:750:1: ( ruleTypeId )
            {
            // InternalDatatypeRuleTestLanguage.g:750:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:751:2: ruleTypeId
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
    // InternalDatatypeRuleTestLanguage.g:761:1: rule__Types__TypesAssignment_2 : ( ruleType ) ;
    public final void rule__Types__TypesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:765:1: ( ( ruleType ) )
            // InternalDatatypeRuleTestLanguage.g:766:2: ( ruleType )
            {
            // InternalDatatypeRuleTestLanguage.g:766:2: ( ruleType )
            // InternalDatatypeRuleTestLanguage.g:767:3: ruleType
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
    // InternalDatatypeRuleTestLanguage.g:776:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:780:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:781:2: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:781:2: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:782:3: RULE_ID
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
    // InternalDatatypeRuleTestLanguage.g:791:1: rule__CompositeType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CompositeType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:795:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:796:2: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:796:2: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:797:3: RULE_ID
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
    // InternalDatatypeRuleTestLanguage.g:806:1: rule__CompositeType__BaseTypeAssignment_3 : ( ruleCompositeTypeEntry ) ;
    public final void rule__CompositeType__BaseTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:810:1: ( ( ruleCompositeTypeEntry ) )
            // InternalDatatypeRuleTestLanguage.g:811:2: ( ruleCompositeTypeEntry )
            {
            // InternalDatatypeRuleTestLanguage.g:811:2: ( ruleCompositeTypeEntry )
            // InternalDatatypeRuleTestLanguage.g:812:3: ruleCompositeTypeEntry
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
    // InternalDatatypeRuleTestLanguage.g:821:1: rule__CompositeTypeEntry__DataTypeAssignment : ( ( ruleTypeId ) ) ;
    public final void rule__CompositeTypeEntry__DataTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypeRuleTestLanguage.g:825:1: ( ( ( ruleTypeId ) ) )
            // InternalDatatypeRuleTestLanguage.g:826:2: ( ( ruleTypeId ) )
            {
            // InternalDatatypeRuleTestLanguage.g:826:2: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:827:3: ( ruleTypeId )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 
            // InternalDatatypeRuleTestLanguage.g:828:3: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:829:4: ruleTypeId
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