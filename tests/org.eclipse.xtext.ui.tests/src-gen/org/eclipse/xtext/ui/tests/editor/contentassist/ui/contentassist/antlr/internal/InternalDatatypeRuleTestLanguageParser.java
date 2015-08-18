package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
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
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

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
    // InternalDatatypeRuleTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:61:1: ( ruleModel EOF )
            // InternalDatatypeRuleTestLanguage.g:62:1: ruleModel EOF
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
    // InternalDatatypeRuleTestLanguage.g:69:1: ruleModel : ( ruleTypes ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:73:2: ( ( ruleTypes ) )
            // InternalDatatypeRuleTestLanguage.g:74:1: ( ruleTypes )
            {
            // InternalDatatypeRuleTestLanguage.g:74:1: ( ruleTypes )
            // InternalDatatypeRuleTestLanguage.g:75:1: ruleTypes
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
    // InternalDatatypeRuleTestLanguage.g:88:1: entryRuleTypes : ruleTypes EOF ;
    public final void entryRuleTypes() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:89:1: ( ruleTypes EOF )
            // InternalDatatypeRuleTestLanguage.g:90:1: ruleTypes EOF
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
    // InternalDatatypeRuleTestLanguage.g:97:1: ruleTypes : ( ( rule__Types__Group__0 ) ) ;
    public final void ruleTypes() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:101:2: ( ( ( rule__Types__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:102:1: ( ( rule__Types__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:102:1: ( ( rule__Types__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:103:1: ( rule__Types__Group__0 )
            {
             before(grammarAccess.getTypesAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:104:1: ( rule__Types__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:104:2: rule__Types__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:116:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:117:1: ( ruleType EOF )
            // InternalDatatypeRuleTestLanguage.g:118:1: ruleType EOF
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
    // InternalDatatypeRuleTestLanguage.g:125:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:129:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalDatatypeRuleTestLanguage.g:130:1: ( ( rule__Type__Alternatives ) )
            {
            // InternalDatatypeRuleTestLanguage.g:130:1: ( ( rule__Type__Alternatives ) )
            // InternalDatatypeRuleTestLanguage.g:131:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalDatatypeRuleTestLanguage.g:132:1: ( rule__Type__Alternatives )
            // InternalDatatypeRuleTestLanguage.g:132:2: rule__Type__Alternatives
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
    // InternalDatatypeRuleTestLanguage.g:144:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:145:1: ( ruleSimpleType EOF )
            // InternalDatatypeRuleTestLanguage.g:146:1: ruleSimpleType EOF
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
    // InternalDatatypeRuleTestLanguage.g:153:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:157:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:159:1: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:160:1: ( rule__SimpleType__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:160:2: rule__SimpleType__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:172:1: entryRuleCompositeType : ruleCompositeType EOF ;
    public final void entryRuleCompositeType() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:173:1: ( ruleCompositeType EOF )
            // InternalDatatypeRuleTestLanguage.g:174:1: ruleCompositeType EOF
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
    // InternalDatatypeRuleTestLanguage.g:181:1: ruleCompositeType : ( ( rule__CompositeType__Group__0 ) ) ;
    public final void ruleCompositeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:185:2: ( ( ( rule__CompositeType__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:186:1: ( ( rule__CompositeType__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:186:1: ( ( rule__CompositeType__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:187:1: ( rule__CompositeType__Group__0 )
            {
             before(grammarAccess.getCompositeTypeAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:188:1: ( rule__CompositeType__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:188:2: rule__CompositeType__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:200:1: entryRuleCompositeTypeEntry : ruleCompositeTypeEntry EOF ;
    public final void entryRuleCompositeTypeEntry() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:201:1: ( ruleCompositeTypeEntry EOF )
            // InternalDatatypeRuleTestLanguage.g:202:1: ruleCompositeTypeEntry EOF
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
    // InternalDatatypeRuleTestLanguage.g:209:1: ruleCompositeTypeEntry : ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) ;
    public final void ruleCompositeTypeEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:213:2: ( ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) )
            // InternalDatatypeRuleTestLanguage.g:214:1: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            {
            // InternalDatatypeRuleTestLanguage.g:214:1: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            // InternalDatatypeRuleTestLanguage.g:215:1: ( rule__CompositeTypeEntry__DataTypeAssignment )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 
            // InternalDatatypeRuleTestLanguage.g:216:1: ( rule__CompositeTypeEntry__DataTypeAssignment )
            // InternalDatatypeRuleTestLanguage.g:216:2: rule__CompositeTypeEntry__DataTypeAssignment
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
    // InternalDatatypeRuleTestLanguage.g:228:1: entryRuleTypeId : ruleTypeId EOF ;
    public final void entryRuleTypeId() throws RecognitionException {
        try {
            // InternalDatatypeRuleTestLanguage.g:229:1: ( ruleTypeId EOF )
            // InternalDatatypeRuleTestLanguage.g:230:1: ruleTypeId EOF
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
    // InternalDatatypeRuleTestLanguage.g:237:1: ruleTypeId : ( ( rule__TypeId__Group__0 ) ) ;
    public final void ruleTypeId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:241:2: ( ( ( rule__TypeId__Group__0 ) ) )
            // InternalDatatypeRuleTestLanguage.g:242:1: ( ( rule__TypeId__Group__0 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:242:1: ( ( rule__TypeId__Group__0 ) )
            // InternalDatatypeRuleTestLanguage.g:243:1: ( rule__TypeId__Group__0 )
            {
             before(grammarAccess.getTypeIdAccess().getGroup()); 
            // InternalDatatypeRuleTestLanguage.g:244:1: ( rule__TypeId__Group__0 )
            // InternalDatatypeRuleTestLanguage.g:244:2: rule__TypeId__Group__0
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
    // InternalDatatypeRuleTestLanguage.g:256:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:260:1: ( ( ruleSimpleType ) | ( ruleCompositeType ) )
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
                    // InternalDatatypeRuleTestLanguage.g:261:1: ( ruleSimpleType )
                    {
                    // InternalDatatypeRuleTestLanguage.g:261:1: ( ruleSimpleType )
                    // InternalDatatypeRuleTestLanguage.g:262:1: ruleSimpleType
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
                    // InternalDatatypeRuleTestLanguage.g:267:6: ( ruleCompositeType )
                    {
                    // InternalDatatypeRuleTestLanguage.g:267:6: ( ruleCompositeType )
                    // InternalDatatypeRuleTestLanguage.g:268:1: ruleCompositeType
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
    // InternalDatatypeRuleTestLanguage.g:280:1: rule__Types__Group__0 : rule__Types__Group__0__Impl rule__Types__Group__1 ;
    public final void rule__Types__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:284:1: ( rule__Types__Group__0__Impl rule__Types__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:285:2: rule__Types__Group__0__Impl rule__Types__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:292:1: rule__Types__Group__0__Impl : ( () ) ;
    public final void rule__Types__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:296:1: ( ( () ) )
            // InternalDatatypeRuleTestLanguage.g:297:1: ( () )
            {
            // InternalDatatypeRuleTestLanguage.g:297:1: ( () )
            // InternalDatatypeRuleTestLanguage.g:298:1: ()
            {
             before(grammarAccess.getTypesAccess().getTypesAction_0()); 
            // InternalDatatypeRuleTestLanguage.g:299:1: ()
            // InternalDatatypeRuleTestLanguage.g:301:1: 
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
    // InternalDatatypeRuleTestLanguage.g:311:1: rule__Types__Group__1 : rule__Types__Group__1__Impl rule__Types__Group__2 ;
    public final void rule__Types__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:315:1: ( rule__Types__Group__1__Impl rule__Types__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:316:2: rule__Types__Group__1__Impl rule__Types__Group__2
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
    // InternalDatatypeRuleTestLanguage.g:323:1: rule__Types__Group__1__Impl : ( 'Types' ) ;
    public final void rule__Types__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:327:1: ( ( 'Types' ) )
            // InternalDatatypeRuleTestLanguage.g:328:1: ( 'Types' )
            {
            // InternalDatatypeRuleTestLanguage.g:328:1: ( 'Types' )
            // InternalDatatypeRuleTestLanguage.g:329:1: 'Types'
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
    // InternalDatatypeRuleTestLanguage.g:342:1: rule__Types__Group__2 : rule__Types__Group__2__Impl ;
    public final void rule__Types__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:346:1: ( rule__Types__Group__2__Impl )
            // InternalDatatypeRuleTestLanguage.g:347:2: rule__Types__Group__2__Impl
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
    // InternalDatatypeRuleTestLanguage.g:353:1: rule__Types__Group__2__Impl : ( ( rule__Types__TypesAssignment_2 )* ) ;
    public final void rule__Types__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:357:1: ( ( ( rule__Types__TypesAssignment_2 )* ) )
            // InternalDatatypeRuleTestLanguage.g:358:1: ( ( rule__Types__TypesAssignment_2 )* )
            {
            // InternalDatatypeRuleTestLanguage.g:358:1: ( ( rule__Types__TypesAssignment_2 )* )
            // InternalDatatypeRuleTestLanguage.g:359:1: ( rule__Types__TypesAssignment_2 )*
            {
             before(grammarAccess.getTypesAccess().getTypesAssignment_2()); 
            // InternalDatatypeRuleTestLanguage.g:360:1: ( rule__Types__TypesAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDatatypeRuleTestLanguage.g:360:2: rule__Types__TypesAssignment_2
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
    // InternalDatatypeRuleTestLanguage.g:376:1: rule__SimpleType__Group__0 : rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:380:1: ( rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:381:2: rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:388:1: rule__SimpleType__Group__0__Impl : ( 'Type' ) ;
    public final void rule__SimpleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:392:1: ( ( 'Type' ) )
            // InternalDatatypeRuleTestLanguage.g:393:1: ( 'Type' )
            {
            // InternalDatatypeRuleTestLanguage.g:393:1: ( 'Type' )
            // InternalDatatypeRuleTestLanguage.g:394:1: 'Type'
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
    // InternalDatatypeRuleTestLanguage.g:407:1: rule__SimpleType__Group__1 : rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:411:1: ( rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:412:2: rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2
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
    // InternalDatatypeRuleTestLanguage.g:419:1: rule__SimpleType__Group__1__Impl : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:423:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // InternalDatatypeRuleTestLanguage.g:424:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:424:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // InternalDatatypeRuleTestLanguage.g:425:1: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // InternalDatatypeRuleTestLanguage.g:426:1: ( rule__SimpleType__NameAssignment_1 )
            // InternalDatatypeRuleTestLanguage.g:426:2: rule__SimpleType__NameAssignment_1
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
    // InternalDatatypeRuleTestLanguage.g:436:1: rule__SimpleType__Group__2 : rule__SimpleType__Group__2__Impl ;
    public final void rule__SimpleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:440:1: ( rule__SimpleType__Group__2__Impl )
            // InternalDatatypeRuleTestLanguage.g:441:2: rule__SimpleType__Group__2__Impl
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
    // InternalDatatypeRuleTestLanguage.g:447:1: rule__SimpleType__Group__2__Impl : ( ';' ) ;
    public final void rule__SimpleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:451:1: ( ( ';' ) )
            // InternalDatatypeRuleTestLanguage.g:452:1: ( ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:452:1: ( ';' )
            // InternalDatatypeRuleTestLanguage.g:453:1: ';'
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
    // InternalDatatypeRuleTestLanguage.g:472:1: rule__CompositeType__Group__0 : rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 ;
    public final void rule__CompositeType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:476:1: ( rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:477:2: rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:484:1: rule__CompositeType__Group__0__Impl : ( 'Composite' ) ;
    public final void rule__CompositeType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:488:1: ( ( 'Composite' ) )
            // InternalDatatypeRuleTestLanguage.g:489:1: ( 'Composite' )
            {
            // InternalDatatypeRuleTestLanguage.g:489:1: ( 'Composite' )
            // InternalDatatypeRuleTestLanguage.g:490:1: 'Composite'
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
    // InternalDatatypeRuleTestLanguage.g:503:1: rule__CompositeType__Group__1 : rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 ;
    public final void rule__CompositeType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:507:1: ( rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 )
            // InternalDatatypeRuleTestLanguage.g:508:2: rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2
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
    // InternalDatatypeRuleTestLanguage.g:515:1: rule__CompositeType__Group__1__Impl : ( ( rule__CompositeType__NameAssignment_1 ) ) ;
    public final void rule__CompositeType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:519:1: ( ( ( rule__CompositeType__NameAssignment_1 ) ) )
            // InternalDatatypeRuleTestLanguage.g:520:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:520:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            // InternalDatatypeRuleTestLanguage.g:521:1: ( rule__CompositeType__NameAssignment_1 )
            {
             before(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 
            // InternalDatatypeRuleTestLanguage.g:522:1: ( rule__CompositeType__NameAssignment_1 )
            // InternalDatatypeRuleTestLanguage.g:522:2: rule__CompositeType__NameAssignment_1
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
    // InternalDatatypeRuleTestLanguage.g:532:1: rule__CompositeType__Group__2 : rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 ;
    public final void rule__CompositeType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:536:1: ( rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 )
            // InternalDatatypeRuleTestLanguage.g:537:2: rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3
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
    // InternalDatatypeRuleTestLanguage.g:544:1: rule__CompositeType__Group__2__Impl : ( 'base' ) ;
    public final void rule__CompositeType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:548:1: ( ( 'base' ) )
            // InternalDatatypeRuleTestLanguage.g:549:1: ( 'base' )
            {
            // InternalDatatypeRuleTestLanguage.g:549:1: ( 'base' )
            // InternalDatatypeRuleTestLanguage.g:550:1: 'base'
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
    // InternalDatatypeRuleTestLanguage.g:563:1: rule__CompositeType__Group__3 : rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 ;
    public final void rule__CompositeType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:567:1: ( rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 )
            // InternalDatatypeRuleTestLanguage.g:568:2: rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4
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
    // InternalDatatypeRuleTestLanguage.g:575:1: rule__CompositeType__Group__3__Impl : ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) ;
    public final void rule__CompositeType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:579:1: ( ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) )
            // InternalDatatypeRuleTestLanguage.g:580:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            {
            // InternalDatatypeRuleTestLanguage.g:580:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            // InternalDatatypeRuleTestLanguage.g:581:1: ( rule__CompositeType__BaseTypeAssignment_3 )
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 
            // InternalDatatypeRuleTestLanguage.g:582:1: ( rule__CompositeType__BaseTypeAssignment_3 )
            // InternalDatatypeRuleTestLanguage.g:582:2: rule__CompositeType__BaseTypeAssignment_3
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
    // InternalDatatypeRuleTestLanguage.g:592:1: rule__CompositeType__Group__4 : rule__CompositeType__Group__4__Impl ;
    public final void rule__CompositeType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:596:1: ( rule__CompositeType__Group__4__Impl )
            // InternalDatatypeRuleTestLanguage.g:597:2: rule__CompositeType__Group__4__Impl
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
    // InternalDatatypeRuleTestLanguage.g:603:1: rule__CompositeType__Group__4__Impl : ( ';' ) ;
    public final void rule__CompositeType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:607:1: ( ( ';' ) )
            // InternalDatatypeRuleTestLanguage.g:608:1: ( ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:608:1: ( ';' )
            // InternalDatatypeRuleTestLanguage.g:609:1: ';'
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
    // InternalDatatypeRuleTestLanguage.g:632:1: rule__TypeId__Group__0 : rule__TypeId__Group__0__Impl rule__TypeId__Group__1 ;
    public final void rule__TypeId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:636:1: ( rule__TypeId__Group__0__Impl rule__TypeId__Group__1 )
            // InternalDatatypeRuleTestLanguage.g:637:2: rule__TypeId__Group__0__Impl rule__TypeId__Group__1
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
    // InternalDatatypeRuleTestLanguage.g:644:1: rule__TypeId__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__TypeId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:648:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:649:1: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:649:1: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:650:1: RULE_ID
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
    // InternalDatatypeRuleTestLanguage.g:661:1: rule__TypeId__Group__1 : rule__TypeId__Group__1__Impl ;
    public final void rule__TypeId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:665:1: ( rule__TypeId__Group__1__Impl )
            // InternalDatatypeRuleTestLanguage.g:666:2: rule__TypeId__Group__1__Impl
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
    // InternalDatatypeRuleTestLanguage.g:672:1: rule__TypeId__Group__1__Impl : ( ( rule__TypeId__Group_1__0 )? ) ;
    public final void rule__TypeId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:676:1: ( ( ( rule__TypeId__Group_1__0 )? ) )
            // InternalDatatypeRuleTestLanguage.g:677:1: ( ( rule__TypeId__Group_1__0 )? )
            {
            // InternalDatatypeRuleTestLanguage.g:677:1: ( ( rule__TypeId__Group_1__0 )? )
            // InternalDatatypeRuleTestLanguage.g:678:1: ( rule__TypeId__Group_1__0 )?
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1()); 
            // InternalDatatypeRuleTestLanguage.g:679:1: ( rule__TypeId__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDatatypeRuleTestLanguage.g:679:2: rule__TypeId__Group_1__0
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
    // InternalDatatypeRuleTestLanguage.g:693:1: rule__TypeId__Group_1__0 : rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 ;
    public final void rule__TypeId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:697:1: ( rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 )
            // InternalDatatypeRuleTestLanguage.g:698:2: rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1
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
    // InternalDatatypeRuleTestLanguage.g:705:1: rule__TypeId__Group_1__0__Impl : ( '<' ) ;
    public final void rule__TypeId__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:709:1: ( ( '<' ) )
            // InternalDatatypeRuleTestLanguage.g:710:1: ( '<' )
            {
            // InternalDatatypeRuleTestLanguage.g:710:1: ( '<' )
            // InternalDatatypeRuleTestLanguage.g:711:1: '<'
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
    // InternalDatatypeRuleTestLanguage.g:724:1: rule__TypeId__Group_1__1 : rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 ;
    public final void rule__TypeId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:728:1: ( rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 )
            // InternalDatatypeRuleTestLanguage.g:729:2: rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2
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
    // InternalDatatypeRuleTestLanguage.g:736:1: rule__TypeId__Group_1__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:740:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:741:1: ( ruleTypeId )
            {
            // InternalDatatypeRuleTestLanguage.g:741:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:742:1: ruleTypeId
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
    // InternalDatatypeRuleTestLanguage.g:753:1: rule__TypeId__Group_1__2 : rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 ;
    public final void rule__TypeId__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:757:1: ( rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 )
            // InternalDatatypeRuleTestLanguage.g:758:2: rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3
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
    // InternalDatatypeRuleTestLanguage.g:765:1: rule__TypeId__Group_1__2__Impl : ( ( rule__TypeId__Group_1_2__0 )* ) ;
    public final void rule__TypeId__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:769:1: ( ( ( rule__TypeId__Group_1_2__0 )* ) )
            // InternalDatatypeRuleTestLanguage.g:770:1: ( ( rule__TypeId__Group_1_2__0 )* )
            {
            // InternalDatatypeRuleTestLanguage.g:770:1: ( ( rule__TypeId__Group_1_2__0 )* )
            // InternalDatatypeRuleTestLanguage.g:771:1: ( rule__TypeId__Group_1_2__0 )*
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1_2()); 
            // InternalDatatypeRuleTestLanguage.g:772:1: ( rule__TypeId__Group_1_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDatatypeRuleTestLanguage.g:772:2: rule__TypeId__Group_1_2__0
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
    // InternalDatatypeRuleTestLanguage.g:782:1: rule__TypeId__Group_1__3 : rule__TypeId__Group_1__3__Impl ;
    public final void rule__TypeId__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:786:1: ( rule__TypeId__Group_1__3__Impl )
            // InternalDatatypeRuleTestLanguage.g:787:2: rule__TypeId__Group_1__3__Impl
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
    // InternalDatatypeRuleTestLanguage.g:793:1: rule__TypeId__Group_1__3__Impl : ( '>' ) ;
    public final void rule__TypeId__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:797:1: ( ( '>' ) )
            // InternalDatatypeRuleTestLanguage.g:798:1: ( '>' )
            {
            // InternalDatatypeRuleTestLanguage.g:798:1: ( '>' )
            // InternalDatatypeRuleTestLanguage.g:799:1: '>'
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
    // InternalDatatypeRuleTestLanguage.g:820:1: rule__TypeId__Group_1_2__0 : rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 ;
    public final void rule__TypeId__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:824:1: ( rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 )
            // InternalDatatypeRuleTestLanguage.g:825:2: rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1
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
    // InternalDatatypeRuleTestLanguage.g:832:1: rule__TypeId__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__TypeId__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:836:1: ( ( ',' ) )
            // InternalDatatypeRuleTestLanguage.g:837:1: ( ',' )
            {
            // InternalDatatypeRuleTestLanguage.g:837:1: ( ',' )
            // InternalDatatypeRuleTestLanguage.g:838:1: ','
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
    // InternalDatatypeRuleTestLanguage.g:851:1: rule__TypeId__Group_1_2__1 : rule__TypeId__Group_1_2__1__Impl ;
    public final void rule__TypeId__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:855:1: ( rule__TypeId__Group_1_2__1__Impl )
            // InternalDatatypeRuleTestLanguage.g:856:2: rule__TypeId__Group_1_2__1__Impl
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
    // InternalDatatypeRuleTestLanguage.g:862:1: rule__TypeId__Group_1_2__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:866:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:867:1: ( ruleTypeId )
            {
            // InternalDatatypeRuleTestLanguage.g:867:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:868:1: ruleTypeId
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
    // InternalDatatypeRuleTestLanguage.g:884:1: rule__Types__TypesAssignment_2 : ( ruleType ) ;
    public final void rule__Types__TypesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:888:1: ( ( ruleType ) )
            // InternalDatatypeRuleTestLanguage.g:889:1: ( ruleType )
            {
            // InternalDatatypeRuleTestLanguage.g:889:1: ( ruleType )
            // InternalDatatypeRuleTestLanguage.g:890:1: ruleType
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
    // InternalDatatypeRuleTestLanguage.g:899:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:903:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:904:1: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:904:1: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:905:1: RULE_ID
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
    // InternalDatatypeRuleTestLanguage.g:914:1: rule__CompositeType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CompositeType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:918:1: ( ( RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:919:1: ( RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:919:1: ( RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:920:1: RULE_ID
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
    // InternalDatatypeRuleTestLanguage.g:929:1: rule__CompositeType__BaseTypeAssignment_3 : ( ruleCompositeTypeEntry ) ;
    public final void rule__CompositeType__BaseTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:933:1: ( ( ruleCompositeTypeEntry ) )
            // InternalDatatypeRuleTestLanguage.g:934:1: ( ruleCompositeTypeEntry )
            {
            // InternalDatatypeRuleTestLanguage.g:934:1: ( ruleCompositeTypeEntry )
            // InternalDatatypeRuleTestLanguage.g:935:1: ruleCompositeTypeEntry
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
    // InternalDatatypeRuleTestLanguage.g:944:1: rule__CompositeTypeEntry__DataTypeAssignment : ( ( ruleTypeId ) ) ;
    public final void rule__CompositeTypeEntry__DataTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDatatypeRuleTestLanguage.g:948:1: ( ( ( ruleTypeId ) ) )
            // InternalDatatypeRuleTestLanguage.g:949:1: ( ( ruleTypeId ) )
            {
            // InternalDatatypeRuleTestLanguage.g:949:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:950:1: ( ruleTypeId )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 
            // InternalDatatypeRuleTestLanguage.g:951:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:952:1: ruleTypeId
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