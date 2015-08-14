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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug289187TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug289187TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PRIVATE'", "'PROTECTED'", "'PACKAGE_PRIVATE'", "'PUBLIC'", "'class'", "'{'", "'}'", "'extends'", "'implements'", "','", "'classNumber'", "'='", "'quid'", "'documentation'", "'attribute'", "'operation'", "'abstract'", "'transient'"
    };
    public static final int RULE_ID=4;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
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


        public InternalBug289187TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug289187TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug289187TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug289187TestLanguage.g"; }


     
     	private Bug289187TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug289187TestLanguageGrammarAccess grammarAccess) {
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
    // InternalBug289187TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:61:1: ( ruleModel EOF )
            // InternalBug289187TestLanguage.g:62:1: ruleModel EOF
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
    // InternalBug289187TestLanguage.g:69:1: ruleModel : ( ( rule__Model__ClassesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:73:2: ( ( ( rule__Model__ClassesAssignment )* ) )
            // InternalBug289187TestLanguage.g:74:1: ( ( rule__Model__ClassesAssignment )* )
            {
            // InternalBug289187TestLanguage.g:74:1: ( ( rule__Model__ClassesAssignment )* )
            // InternalBug289187TestLanguage.g:75:1: ( rule__Model__ClassesAssignment )*
            {
             before(grammarAccess.getModelAccess().getClassesAssignment()); 
            // InternalBug289187TestLanguage.g:76:1: ( rule__Model__ClassesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15||(LA1_0>=27 && LA1_0<=28)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:76:2: rule__Model__ClassesAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__ClassesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getClassesAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleClass"
    // InternalBug289187TestLanguage.g:88:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:89:1: ( ruleClass EOF )
            // InternalBug289187TestLanguage.g:90:1: ruleClass EOF
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
    // InternalBug289187TestLanguage.g:97:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:101:2: ( ( ( rule__Class__Group__0 ) ) )
            // InternalBug289187TestLanguage.g:102:1: ( ( rule__Class__Group__0 ) )
            {
            // InternalBug289187TestLanguage.g:102:1: ( ( rule__Class__Group__0 ) )
            // InternalBug289187TestLanguage.g:103:1: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // InternalBug289187TestLanguage.g:104:1: ( rule__Class__Group__0 )
            // InternalBug289187TestLanguage.g:104:2: rule__Class__Group__0
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


    // $ANTLR start "entryRuleAttribute"
    // InternalBug289187TestLanguage.g:116:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:117:1: ( ruleAttribute EOF )
            // InternalBug289187TestLanguage.g:118:1: ruleAttribute EOF
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
    // InternalBug289187TestLanguage.g:125:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:129:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalBug289187TestLanguage.g:130:1: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalBug289187TestLanguage.g:130:1: ( ( rule__Attribute__Group__0 ) )
            // InternalBug289187TestLanguage.g:131:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalBug289187TestLanguage.g:132:1: ( rule__Attribute__Group__0 )
            // InternalBug289187TestLanguage.g:132:2: rule__Attribute__Group__0
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


    // $ANTLR start "entryRuleOperation"
    // InternalBug289187TestLanguage.g:144:1: entryRuleOperation : ruleOperation EOF ;
    public final void entryRuleOperation() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:145:1: ( ruleOperation EOF )
            // InternalBug289187TestLanguage.g:146:1: ruleOperation EOF
            {
             before(grammarAccess.getOperationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOperation();

            state._fsp--;

             after(grammarAccess.getOperationRule()); 
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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalBug289187TestLanguage.g:153:1: ruleOperation : ( ( rule__Operation__Group__0 ) ) ;
    public final void ruleOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:157:2: ( ( ( rule__Operation__Group__0 ) ) )
            // InternalBug289187TestLanguage.g:158:1: ( ( rule__Operation__Group__0 ) )
            {
            // InternalBug289187TestLanguage.g:158:1: ( ( rule__Operation__Group__0 ) )
            // InternalBug289187TestLanguage.g:159:1: ( rule__Operation__Group__0 )
            {
             before(grammarAccess.getOperationAccess().getGroup()); 
            // InternalBug289187TestLanguage.g:160:1: ( rule__Operation__Group__0 )
            // InternalBug289187TestLanguage.g:160:2: rule__Operation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Operation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "ruleVisibility"
    // InternalBug289187TestLanguage.g:173:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:177:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // InternalBug289187TestLanguage.g:178:1: ( ( rule__Visibility__Alternatives ) )
            {
            // InternalBug289187TestLanguage.g:178:1: ( ( rule__Visibility__Alternatives ) )
            // InternalBug289187TestLanguage.g:179:1: ( rule__Visibility__Alternatives )
            {
             before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            // InternalBug289187TestLanguage.g:180:1: ( rule__Visibility__Alternatives )
            // InternalBug289187TestLanguage.g:180:2: rule__Visibility__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Visibility__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVisibilityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "rule__Visibility__Alternatives"
    // InternalBug289187TestLanguage.g:191:1: rule__Visibility__Alternatives : ( ( ( 'PRIVATE' ) ) | ( ( 'PROTECTED' ) ) | ( ( 'PACKAGE_PRIVATE' ) ) | ( ( 'PUBLIC' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:195:1: ( ( ( 'PRIVATE' ) ) | ( ( 'PROTECTED' ) ) | ( ( 'PACKAGE_PRIVATE' ) ) | ( ( 'PUBLIC' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBug289187TestLanguage.g:196:1: ( ( 'PRIVATE' ) )
                    {
                    // InternalBug289187TestLanguage.g:196:1: ( ( 'PRIVATE' ) )
                    // InternalBug289187TestLanguage.g:197:1: ( 'PRIVATE' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0()); 
                    // InternalBug289187TestLanguage.g:198:1: ( 'PRIVATE' )
                    // InternalBug289187TestLanguage.g:198:3: 'PRIVATE'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug289187TestLanguage.g:203:6: ( ( 'PROTECTED' ) )
                    {
                    // InternalBug289187TestLanguage.g:203:6: ( ( 'PROTECTED' ) )
                    // InternalBug289187TestLanguage.g:204:1: ( 'PROTECTED' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    // InternalBug289187TestLanguage.g:205:1: ( 'PROTECTED' )
                    // InternalBug289187TestLanguage.g:205:3: 'PROTECTED'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug289187TestLanguage.g:210:6: ( ( 'PACKAGE_PRIVATE' ) )
                    {
                    // InternalBug289187TestLanguage.g:210:6: ( ( 'PACKAGE_PRIVATE' ) )
                    // InternalBug289187TestLanguage.g:211:1: ( 'PACKAGE_PRIVATE' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2()); 
                    // InternalBug289187TestLanguage.g:212:1: ( 'PACKAGE_PRIVATE' )
                    // InternalBug289187TestLanguage.g:212:3: 'PACKAGE_PRIVATE'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug289187TestLanguage.g:217:6: ( ( 'PUBLIC' ) )
                    {
                    // InternalBug289187TestLanguage.g:217:6: ( ( 'PUBLIC' ) )
                    // InternalBug289187TestLanguage.g:218:1: ( 'PUBLIC' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3()); 
                    // InternalBug289187TestLanguage.g:219:1: ( 'PUBLIC' )
                    // InternalBug289187TestLanguage.g:219:3: 'PUBLIC'
                    {
                    match(input,14,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__Visibility__Alternatives"


    // $ANTLR start "rule__Class__Group__0"
    // InternalBug289187TestLanguage.g:231:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:235:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalBug289187TestLanguage.g:236:2: rule__Class__Group__0__Impl rule__Class__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalBug289187TestLanguage.g:243:1: rule__Class__Group__0__Impl : ( ( rule__Class__AbstractAssignment_0 )? ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:247:1: ( ( ( rule__Class__AbstractAssignment_0 )? ) )
            // InternalBug289187TestLanguage.g:248:1: ( ( rule__Class__AbstractAssignment_0 )? )
            {
            // InternalBug289187TestLanguage.g:248:1: ( ( rule__Class__AbstractAssignment_0 )? )
            // InternalBug289187TestLanguage.g:249:1: ( rule__Class__AbstractAssignment_0 )?
            {
             before(grammarAccess.getClassAccess().getAbstractAssignment_0()); 
            // InternalBug289187TestLanguage.g:250:1: ( rule__Class__AbstractAssignment_0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==27) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug289187TestLanguage.g:250:2: rule__Class__AbstractAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__AbstractAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getAbstractAssignment_0()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:260:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:264:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalBug289187TestLanguage.g:265:2: rule__Class__Group__1__Impl rule__Class__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalBug289187TestLanguage.g:272:1: rule__Class__Group__1__Impl : ( ( rule__Class__TransientAssignment_1 )? ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:276:1: ( ( ( rule__Class__TransientAssignment_1 )? ) )
            // InternalBug289187TestLanguage.g:277:1: ( ( rule__Class__TransientAssignment_1 )? )
            {
            // InternalBug289187TestLanguage.g:277:1: ( ( rule__Class__TransientAssignment_1 )? )
            // InternalBug289187TestLanguage.g:278:1: ( rule__Class__TransientAssignment_1 )?
            {
             before(grammarAccess.getClassAccess().getTransientAssignment_1()); 
            // InternalBug289187TestLanguage.g:279:1: ( rule__Class__TransientAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==28) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug289187TestLanguage.g:279:2: rule__Class__TransientAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__TransientAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getTransientAssignment_1()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:289:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:293:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalBug289187TestLanguage.g:294:2: rule__Class__Group__2__Impl rule__Class__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
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
    // InternalBug289187TestLanguage.g:301:1: rule__Class__Group__2__Impl : ( 'class' ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:305:1: ( ( 'class' ) )
            // InternalBug289187TestLanguage.g:306:1: ( 'class' )
            {
            // InternalBug289187TestLanguage.g:306:1: ( 'class' )
            // InternalBug289187TestLanguage.g:307:1: 'class'
            {
             before(grammarAccess.getClassAccess().getClassKeyword_2()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getClassKeyword_2()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:320:1: rule__Class__Group__3 : rule__Class__Group__3__Impl rule__Class__Group__4 ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:324:1: ( rule__Class__Group__3__Impl rule__Class__Group__4 )
            // InternalBug289187TestLanguage.g:325:2: rule__Class__Group__3__Impl rule__Class__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalBug289187TestLanguage.g:332:1: rule__Class__Group__3__Impl : ( ( rule__Class__NameAssignment_3 ) ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:336:1: ( ( ( rule__Class__NameAssignment_3 ) ) )
            // InternalBug289187TestLanguage.g:337:1: ( ( rule__Class__NameAssignment_3 ) )
            {
            // InternalBug289187TestLanguage.g:337:1: ( ( rule__Class__NameAssignment_3 ) )
            // InternalBug289187TestLanguage.g:338:1: ( rule__Class__NameAssignment_3 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_3()); 
            // InternalBug289187TestLanguage.g:339:1: ( rule__Class__NameAssignment_3 )
            // InternalBug289187TestLanguage.g:339:2: rule__Class__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAssignment_3()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:349:1: rule__Class__Group__4 : rule__Class__Group__4__Impl rule__Class__Group__5 ;
    public final void rule__Class__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:353:1: ( rule__Class__Group__4__Impl rule__Class__Group__5 )
            // InternalBug289187TestLanguage.g:354:2: rule__Class__Group__4__Impl rule__Class__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalBug289187TestLanguage.g:361:1: rule__Class__Group__4__Impl : ( ( rule__Class__Group_4__0 )? ) ;
    public final void rule__Class__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:365:1: ( ( ( rule__Class__Group_4__0 )? ) )
            // InternalBug289187TestLanguage.g:366:1: ( ( rule__Class__Group_4__0 )? )
            {
            // InternalBug289187TestLanguage.g:366:1: ( ( rule__Class__Group_4__0 )? )
            // InternalBug289187TestLanguage.g:367:1: ( rule__Class__Group_4__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_4()); 
            // InternalBug289187TestLanguage.g:368:1: ( rule__Class__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug289187TestLanguage.g:368:2: rule__Class__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_4()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:378:1: rule__Class__Group__5 : rule__Class__Group__5__Impl rule__Class__Group__6 ;
    public final void rule__Class__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:382:1: ( rule__Class__Group__5__Impl rule__Class__Group__6 )
            // InternalBug289187TestLanguage.g:383:2: rule__Class__Group__5__Impl rule__Class__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalBug289187TestLanguage.g:390:1: rule__Class__Group__5__Impl : ( ( rule__Class__Group_5__0 )? ) ;
    public final void rule__Class__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:394:1: ( ( ( rule__Class__Group_5__0 )? ) )
            // InternalBug289187TestLanguage.g:395:1: ( ( rule__Class__Group_5__0 )? )
            {
            // InternalBug289187TestLanguage.g:395:1: ( ( rule__Class__Group_5__0 )? )
            // InternalBug289187TestLanguage.g:396:1: ( rule__Class__Group_5__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_5()); 
            // InternalBug289187TestLanguage.g:397:1: ( rule__Class__Group_5__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug289187TestLanguage.g:397:2: rule__Class__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_5()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:407:1: rule__Class__Group__6 : rule__Class__Group__6__Impl rule__Class__Group__7 ;
    public final void rule__Class__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:411:1: ( rule__Class__Group__6__Impl rule__Class__Group__7 )
            // InternalBug289187TestLanguage.g:412:2: rule__Class__Group__6__Impl rule__Class__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__7();

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
    // InternalBug289187TestLanguage.g:419:1: rule__Class__Group__6__Impl : ( '{' ) ;
    public final void rule__Class__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:423:1: ( ( '{' ) )
            // InternalBug289187TestLanguage.g:424:1: ( '{' )
            {
            // InternalBug289187TestLanguage.g:424:1: ( '{' )
            // InternalBug289187TestLanguage.g:425:1: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__Class__Group__7"
    // InternalBug289187TestLanguage.g:438:1: rule__Class__Group__7 : rule__Class__Group__7__Impl rule__Class__Group__8 ;
    public final void rule__Class__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:442:1: ( rule__Class__Group__7__Impl rule__Class__Group__8 )
            // InternalBug289187TestLanguage.g:443:2: rule__Class__Group__7__Impl rule__Class__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__8();

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
    // $ANTLR end "rule__Class__Group__7"


    // $ANTLR start "rule__Class__Group__7__Impl"
    // InternalBug289187TestLanguage.g:450:1: rule__Class__Group__7__Impl : ( ( rule__Class__Group_7__0 )? ) ;
    public final void rule__Class__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:454:1: ( ( ( rule__Class__Group_7__0 )? ) )
            // InternalBug289187TestLanguage.g:455:1: ( ( rule__Class__Group_7__0 )? )
            {
            // InternalBug289187TestLanguage.g:455:1: ( ( rule__Class__Group_7__0 )? )
            // InternalBug289187TestLanguage.g:456:1: ( rule__Class__Group_7__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_7()); 
            // InternalBug289187TestLanguage.g:457:1: ( rule__Class__Group_7__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug289187TestLanguage.g:457:2: rule__Class__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__7__Impl"


    // $ANTLR start "rule__Class__Group__8"
    // InternalBug289187TestLanguage.g:467:1: rule__Class__Group__8 : rule__Class__Group__8__Impl rule__Class__Group__9 ;
    public final void rule__Class__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:471:1: ( rule__Class__Group__8__Impl rule__Class__Group__9 )
            // InternalBug289187TestLanguage.g:472:2: rule__Class__Group__8__Impl rule__Class__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__9();

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
    // $ANTLR end "rule__Class__Group__8"


    // $ANTLR start "rule__Class__Group__8__Impl"
    // InternalBug289187TestLanguage.g:479:1: rule__Class__Group__8__Impl : ( ( rule__Class__Group_8__0 )? ) ;
    public final void rule__Class__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:483:1: ( ( ( rule__Class__Group_8__0 )? ) )
            // InternalBug289187TestLanguage.g:484:1: ( ( rule__Class__Group_8__0 )? )
            {
            // InternalBug289187TestLanguage.g:484:1: ( ( rule__Class__Group_8__0 )? )
            // InternalBug289187TestLanguage.g:485:1: ( rule__Class__Group_8__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_8()); 
            // InternalBug289187TestLanguage.g:486:1: ( rule__Class__Group_8__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug289187TestLanguage.g:486:2: rule__Class__Group_8__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__8__Impl"


    // $ANTLR start "rule__Class__Group__9"
    // InternalBug289187TestLanguage.g:496:1: rule__Class__Group__9 : rule__Class__Group__9__Impl rule__Class__Group__10 ;
    public final void rule__Class__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:500:1: ( rule__Class__Group__9__Impl rule__Class__Group__10 )
            // InternalBug289187TestLanguage.g:501:2: rule__Class__Group__9__Impl rule__Class__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__10();

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
    // $ANTLR end "rule__Class__Group__9"


    // $ANTLR start "rule__Class__Group__9__Impl"
    // InternalBug289187TestLanguage.g:508:1: rule__Class__Group__9__Impl : ( ( rule__Class__Group_9__0 )? ) ;
    public final void rule__Class__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:512:1: ( ( ( rule__Class__Group_9__0 )? ) )
            // InternalBug289187TestLanguage.g:513:1: ( ( rule__Class__Group_9__0 )? )
            {
            // InternalBug289187TestLanguage.g:513:1: ( ( rule__Class__Group_9__0 )? )
            // InternalBug289187TestLanguage.g:514:1: ( rule__Class__Group_9__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_9()); 
            // InternalBug289187TestLanguage.g:515:1: ( rule__Class__Group_9__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug289187TestLanguage.g:515:2: rule__Class__Group_9__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__9__Impl"


    // $ANTLR start "rule__Class__Group__10"
    // InternalBug289187TestLanguage.g:525:1: rule__Class__Group__10 : rule__Class__Group__10__Impl rule__Class__Group__11 ;
    public final void rule__Class__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:529:1: ( rule__Class__Group__10__Impl rule__Class__Group__11 )
            // InternalBug289187TestLanguage.g:530:2: rule__Class__Group__10__Impl rule__Class__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__11();

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
    // $ANTLR end "rule__Class__Group__10"


    // $ANTLR start "rule__Class__Group__10__Impl"
    // InternalBug289187TestLanguage.g:537:1: rule__Class__Group__10__Impl : ( ( rule__Class__AttributesAssignment_10 )* ) ;
    public final void rule__Class__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:541:1: ( ( ( rule__Class__AttributesAssignment_10 )* ) )
            // InternalBug289187TestLanguage.g:542:1: ( ( rule__Class__AttributesAssignment_10 )* )
            {
            // InternalBug289187TestLanguage.g:542:1: ( ( rule__Class__AttributesAssignment_10 )* )
            // InternalBug289187TestLanguage.g:543:1: ( rule__Class__AttributesAssignment_10 )*
            {
             before(grammarAccess.getClassAccess().getAttributesAssignment_10()); 
            // InternalBug289187TestLanguage.g:544:1: ( rule__Class__AttributesAssignment_10 )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case 11:
                    {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==25) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 12:
                    {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==25) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 13:
                    {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3==25) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 14:
                    {
                    int LA10_4 = input.LA(2);

                    if ( (LA10_4==25) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 25:
                    {
                    alt10=1;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:544:2: rule__Class__AttributesAssignment_10
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Class__AttributesAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getAttributesAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__10__Impl"


    // $ANTLR start "rule__Class__Group__11"
    // InternalBug289187TestLanguage.g:554:1: rule__Class__Group__11 : rule__Class__Group__11__Impl rule__Class__Group__12 ;
    public final void rule__Class__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:558:1: ( rule__Class__Group__11__Impl rule__Class__Group__12 )
            // InternalBug289187TestLanguage.g:559:2: rule__Class__Group__11__Impl rule__Class__Group__12
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group__11__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__12();

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
    // $ANTLR end "rule__Class__Group__11"


    // $ANTLR start "rule__Class__Group__11__Impl"
    // InternalBug289187TestLanguage.g:566:1: rule__Class__Group__11__Impl : ( ( rule__Class__OperationsAssignment_11 )* ) ;
    public final void rule__Class__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:570:1: ( ( ( rule__Class__OperationsAssignment_11 )* ) )
            // InternalBug289187TestLanguage.g:571:1: ( ( rule__Class__OperationsAssignment_11 )* )
            {
            // InternalBug289187TestLanguage.g:571:1: ( ( rule__Class__OperationsAssignment_11 )* )
            // InternalBug289187TestLanguage.g:572:1: ( rule__Class__OperationsAssignment_11 )*
            {
             before(grammarAccess.getClassAccess().getOperationsAssignment_11()); 
            // InternalBug289187TestLanguage.g:573:1: ( rule__Class__OperationsAssignment_11 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=11 && LA11_0<=14)||LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:573:2: rule__Class__OperationsAssignment_11
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__Class__OperationsAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getOperationsAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__11__Impl"


    // $ANTLR start "rule__Class__Group__12"
    // InternalBug289187TestLanguage.g:583:1: rule__Class__Group__12 : rule__Class__Group__12__Impl ;
    public final void rule__Class__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:587:1: ( rule__Class__Group__12__Impl )
            // InternalBug289187TestLanguage.g:588:2: rule__Class__Group__12__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__12__Impl();

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
    // $ANTLR end "rule__Class__Group__12"


    // $ANTLR start "rule__Class__Group__12__Impl"
    // InternalBug289187TestLanguage.g:594:1: rule__Class__Group__12__Impl : ( '}' ) ;
    public final void rule__Class__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:598:1: ( ( '}' ) )
            // InternalBug289187TestLanguage.g:599:1: ( '}' )
            {
            // InternalBug289187TestLanguage.g:599:1: ( '}' )
            // InternalBug289187TestLanguage.g:600:1: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_12()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__12__Impl"


    // $ANTLR start "rule__Class__Group_4__0"
    // InternalBug289187TestLanguage.g:639:1: rule__Class__Group_4__0 : rule__Class__Group_4__0__Impl rule__Class__Group_4__1 ;
    public final void rule__Class__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:643:1: ( rule__Class__Group_4__0__Impl rule__Class__Group_4__1 )
            // InternalBug289187TestLanguage.g:644:2: rule__Class__Group_4__0__Impl rule__Class__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Class__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_4__1();

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
    // $ANTLR end "rule__Class__Group_4__0"


    // $ANTLR start "rule__Class__Group_4__0__Impl"
    // InternalBug289187TestLanguage.g:651:1: rule__Class__Group_4__0__Impl : ( 'extends' ) ;
    public final void rule__Class__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:655:1: ( ( 'extends' ) )
            // InternalBug289187TestLanguage.g:656:1: ( 'extends' )
            {
            // InternalBug289187TestLanguage.g:656:1: ( 'extends' )
            // InternalBug289187TestLanguage.g:657:1: 'extends'
            {
             before(grammarAccess.getClassAccess().getExtendsKeyword_4_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getExtendsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_4__0__Impl"


    // $ANTLR start "rule__Class__Group_4__1"
    // InternalBug289187TestLanguage.g:670:1: rule__Class__Group_4__1 : rule__Class__Group_4__1__Impl ;
    public final void rule__Class__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:674:1: ( rule__Class__Group_4__1__Impl )
            // InternalBug289187TestLanguage.g:675:2: rule__Class__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_4__1__Impl();

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
    // $ANTLR end "rule__Class__Group_4__1"


    // $ANTLR start "rule__Class__Group_4__1__Impl"
    // InternalBug289187TestLanguage.g:681:1: rule__Class__Group_4__1__Impl : ( ( rule__Class__SuperClassAssignment_4_1 ) ) ;
    public final void rule__Class__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:685:1: ( ( ( rule__Class__SuperClassAssignment_4_1 ) ) )
            // InternalBug289187TestLanguage.g:686:1: ( ( rule__Class__SuperClassAssignment_4_1 ) )
            {
            // InternalBug289187TestLanguage.g:686:1: ( ( rule__Class__SuperClassAssignment_4_1 ) )
            // InternalBug289187TestLanguage.g:687:1: ( rule__Class__SuperClassAssignment_4_1 )
            {
             before(grammarAccess.getClassAccess().getSuperClassAssignment_4_1()); 
            // InternalBug289187TestLanguage.g:688:1: ( rule__Class__SuperClassAssignment_4_1 )
            // InternalBug289187TestLanguage.g:688:2: rule__Class__SuperClassAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__SuperClassAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getSuperClassAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_4__1__Impl"


    // $ANTLR start "rule__Class__Group_5__0"
    // InternalBug289187TestLanguage.g:702:1: rule__Class__Group_5__0 : rule__Class__Group_5__0__Impl rule__Class__Group_5__1 ;
    public final void rule__Class__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:706:1: ( rule__Class__Group_5__0__Impl rule__Class__Group_5__1 )
            // InternalBug289187TestLanguage.g:707:2: rule__Class__Group_5__0__Impl rule__Class__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Class__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_5__1();

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
    // $ANTLR end "rule__Class__Group_5__0"


    // $ANTLR start "rule__Class__Group_5__0__Impl"
    // InternalBug289187TestLanguage.g:714:1: rule__Class__Group_5__0__Impl : ( 'implements' ) ;
    public final void rule__Class__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:718:1: ( ( 'implements' ) )
            // InternalBug289187TestLanguage.g:719:1: ( 'implements' )
            {
            // InternalBug289187TestLanguage.g:719:1: ( 'implements' )
            // InternalBug289187TestLanguage.g:720:1: 'implements'
            {
             before(grammarAccess.getClassAccess().getImplementsKeyword_5_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getImplementsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_5__0__Impl"


    // $ANTLR start "rule__Class__Group_5__1"
    // InternalBug289187TestLanguage.g:733:1: rule__Class__Group_5__1 : rule__Class__Group_5__1__Impl rule__Class__Group_5__2 ;
    public final void rule__Class__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:737:1: ( rule__Class__Group_5__1__Impl rule__Class__Group_5__2 )
            // InternalBug289187TestLanguage.g:738:2: rule__Class__Group_5__1__Impl rule__Class__Group_5__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Class__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_5__2();

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
    // $ANTLR end "rule__Class__Group_5__1"


    // $ANTLR start "rule__Class__Group_5__1__Impl"
    // InternalBug289187TestLanguage.g:745:1: rule__Class__Group_5__1__Impl : ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) ) ;
    public final void rule__Class__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:749:1: ( ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) ) )
            // InternalBug289187TestLanguage.g:750:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) )
            {
            // InternalBug289187TestLanguage.g:750:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) )
            // InternalBug289187TestLanguage.g:751:1: ( rule__Class__ImplementedInterfacesAssignment_5_1 )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_1()); 
            // InternalBug289187TestLanguage.g:752:1: ( rule__Class__ImplementedInterfacesAssignment_5_1 )
            // InternalBug289187TestLanguage.g:752:2: rule__Class__ImplementedInterfacesAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__ImplementedInterfacesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_5__1__Impl"


    // $ANTLR start "rule__Class__Group_5__2"
    // InternalBug289187TestLanguage.g:762:1: rule__Class__Group_5__2 : rule__Class__Group_5__2__Impl ;
    public final void rule__Class__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:766:1: ( rule__Class__Group_5__2__Impl )
            // InternalBug289187TestLanguage.g:767:2: rule__Class__Group_5__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_5__2__Impl();

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
    // $ANTLR end "rule__Class__Group_5__2"


    // $ANTLR start "rule__Class__Group_5__2__Impl"
    // InternalBug289187TestLanguage.g:773:1: rule__Class__Group_5__2__Impl : ( ( rule__Class__Group_5_2__0 )* ) ;
    public final void rule__Class__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:777:1: ( ( ( rule__Class__Group_5_2__0 )* ) )
            // InternalBug289187TestLanguage.g:778:1: ( ( rule__Class__Group_5_2__0 )* )
            {
            // InternalBug289187TestLanguage.g:778:1: ( ( rule__Class__Group_5_2__0 )* )
            // InternalBug289187TestLanguage.g:779:1: ( rule__Class__Group_5_2__0 )*
            {
             before(grammarAccess.getClassAccess().getGroup_5_2()); 
            // InternalBug289187TestLanguage.g:780:1: ( rule__Class__Group_5_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==20) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:780:2: rule__Class__Group_5_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    rule__Class__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_5__2__Impl"


    // $ANTLR start "rule__Class__Group_5_2__0"
    // InternalBug289187TestLanguage.g:796:1: rule__Class__Group_5_2__0 : rule__Class__Group_5_2__0__Impl rule__Class__Group_5_2__1 ;
    public final void rule__Class__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:800:1: ( rule__Class__Group_5_2__0__Impl rule__Class__Group_5_2__1 )
            // InternalBug289187TestLanguage.g:801:2: rule__Class__Group_5_2__0__Impl rule__Class__Group_5_2__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Class__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_5_2__1();

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
    // $ANTLR end "rule__Class__Group_5_2__0"


    // $ANTLR start "rule__Class__Group_5_2__0__Impl"
    // InternalBug289187TestLanguage.g:808:1: rule__Class__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__Class__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:812:1: ( ( ',' ) )
            // InternalBug289187TestLanguage.g:813:1: ( ',' )
            {
            // InternalBug289187TestLanguage.g:813:1: ( ',' )
            // InternalBug289187TestLanguage.g:814:1: ','
            {
             before(grammarAccess.getClassAccess().getCommaKeyword_5_2_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_5_2__0__Impl"


    // $ANTLR start "rule__Class__Group_5_2__1"
    // InternalBug289187TestLanguage.g:827:1: rule__Class__Group_5_2__1 : rule__Class__Group_5_2__1__Impl rule__Class__Group_5_2__2 ;
    public final void rule__Class__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:831:1: ( rule__Class__Group_5_2__1__Impl rule__Class__Group_5_2__2 )
            // InternalBug289187TestLanguage.g:832:2: rule__Class__Group_5_2__1__Impl rule__Class__Group_5_2__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Class__Group_5_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_5_2__2();

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
    // $ANTLR end "rule__Class__Group_5_2__1"


    // $ANTLR start "rule__Class__Group_5_2__1__Impl"
    // InternalBug289187TestLanguage.g:839:1: rule__Class__Group_5_2__1__Impl : ( 'implements' ) ;
    public final void rule__Class__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:843:1: ( ( 'implements' ) )
            // InternalBug289187TestLanguage.g:844:1: ( 'implements' )
            {
            // InternalBug289187TestLanguage.g:844:1: ( 'implements' )
            // InternalBug289187TestLanguage.g:845:1: 'implements'
            {
             before(grammarAccess.getClassAccess().getImplementsKeyword_5_2_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getImplementsKeyword_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_5_2__1__Impl"


    // $ANTLR start "rule__Class__Group_5_2__2"
    // InternalBug289187TestLanguage.g:858:1: rule__Class__Group_5_2__2 : rule__Class__Group_5_2__2__Impl ;
    public final void rule__Class__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:862:1: ( rule__Class__Group_5_2__2__Impl )
            // InternalBug289187TestLanguage.g:863:2: rule__Class__Group_5_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_5_2__2__Impl();

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
    // $ANTLR end "rule__Class__Group_5_2__2"


    // $ANTLR start "rule__Class__Group_5_2__2__Impl"
    // InternalBug289187TestLanguage.g:869:1: rule__Class__Group_5_2__2__Impl : ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) ) ;
    public final void rule__Class__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:873:1: ( ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) ) )
            // InternalBug289187TestLanguage.g:874:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) )
            {
            // InternalBug289187TestLanguage.g:874:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) )
            // InternalBug289187TestLanguage.g:875:1: ( rule__Class__ImplementedInterfacesAssignment_5_2_2 )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_2_2()); 
            // InternalBug289187TestLanguage.g:876:1: ( rule__Class__ImplementedInterfacesAssignment_5_2_2 )
            // InternalBug289187TestLanguage.g:876:2: rule__Class__ImplementedInterfacesAssignment_5_2_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__ImplementedInterfacesAssignment_5_2_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_5_2__2__Impl"


    // $ANTLR start "rule__Class__Group_7__0"
    // InternalBug289187TestLanguage.g:892:1: rule__Class__Group_7__0 : rule__Class__Group_7__0__Impl rule__Class__Group_7__1 ;
    public final void rule__Class__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:896:1: ( rule__Class__Group_7__0__Impl rule__Class__Group_7__1 )
            // InternalBug289187TestLanguage.g:897:2: rule__Class__Group_7__0__Impl rule__Class__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Class__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_7__1();

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
    // $ANTLR end "rule__Class__Group_7__0"


    // $ANTLR start "rule__Class__Group_7__0__Impl"
    // InternalBug289187TestLanguage.g:904:1: rule__Class__Group_7__0__Impl : ( 'classNumber' ) ;
    public final void rule__Class__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:908:1: ( ( 'classNumber' ) )
            // InternalBug289187TestLanguage.g:909:1: ( 'classNumber' )
            {
            // InternalBug289187TestLanguage.g:909:1: ( 'classNumber' )
            // InternalBug289187TestLanguage.g:910:1: 'classNumber'
            {
             before(grammarAccess.getClassAccess().getClassNumberKeyword_7_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getClassNumberKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_7__0__Impl"


    // $ANTLR start "rule__Class__Group_7__1"
    // InternalBug289187TestLanguage.g:923:1: rule__Class__Group_7__1 : rule__Class__Group_7__1__Impl rule__Class__Group_7__2 ;
    public final void rule__Class__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:927:1: ( rule__Class__Group_7__1__Impl rule__Class__Group_7__2 )
            // InternalBug289187TestLanguage.g:928:2: rule__Class__Group_7__1__Impl rule__Class__Group_7__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Class__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_7__2();

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
    // $ANTLR end "rule__Class__Group_7__1"


    // $ANTLR start "rule__Class__Group_7__1__Impl"
    // InternalBug289187TestLanguage.g:935:1: rule__Class__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Class__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:939:1: ( ( '=' ) )
            // InternalBug289187TestLanguage.g:940:1: ( '=' )
            {
            // InternalBug289187TestLanguage.g:940:1: ( '=' )
            // InternalBug289187TestLanguage.g:941:1: '='
            {
             before(grammarAccess.getClassAccess().getEqualsSignKeyword_7_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getEqualsSignKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_7__1__Impl"


    // $ANTLR start "rule__Class__Group_7__2"
    // InternalBug289187TestLanguage.g:954:1: rule__Class__Group_7__2 : rule__Class__Group_7__2__Impl ;
    public final void rule__Class__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:958:1: ( rule__Class__Group_7__2__Impl )
            // InternalBug289187TestLanguage.g:959:2: rule__Class__Group_7__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_7__2__Impl();

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
    // $ANTLR end "rule__Class__Group_7__2"


    // $ANTLR start "rule__Class__Group_7__2__Impl"
    // InternalBug289187TestLanguage.g:965:1: rule__Class__Group_7__2__Impl : ( ( rule__Class__ClassNumberAssignment_7_2 ) ) ;
    public final void rule__Class__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:969:1: ( ( ( rule__Class__ClassNumberAssignment_7_2 ) ) )
            // InternalBug289187TestLanguage.g:970:1: ( ( rule__Class__ClassNumberAssignment_7_2 ) )
            {
            // InternalBug289187TestLanguage.g:970:1: ( ( rule__Class__ClassNumberAssignment_7_2 ) )
            // InternalBug289187TestLanguage.g:971:1: ( rule__Class__ClassNumberAssignment_7_2 )
            {
             before(grammarAccess.getClassAccess().getClassNumberAssignment_7_2()); 
            // InternalBug289187TestLanguage.g:972:1: ( rule__Class__ClassNumberAssignment_7_2 )
            // InternalBug289187TestLanguage.g:972:2: rule__Class__ClassNumberAssignment_7_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__ClassNumberAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getClassNumberAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_7__2__Impl"


    // $ANTLR start "rule__Class__Group_8__0"
    // InternalBug289187TestLanguage.g:988:1: rule__Class__Group_8__0 : rule__Class__Group_8__0__Impl rule__Class__Group_8__1 ;
    public final void rule__Class__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:992:1: ( rule__Class__Group_8__0__Impl rule__Class__Group_8__1 )
            // InternalBug289187TestLanguage.g:993:2: rule__Class__Group_8__0__Impl rule__Class__Group_8__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Class__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_8__1();

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
    // $ANTLR end "rule__Class__Group_8__0"


    // $ANTLR start "rule__Class__Group_8__0__Impl"
    // InternalBug289187TestLanguage.g:1000:1: rule__Class__Group_8__0__Impl : ( 'quid' ) ;
    public final void rule__Class__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1004:1: ( ( 'quid' ) )
            // InternalBug289187TestLanguage.g:1005:1: ( 'quid' )
            {
            // InternalBug289187TestLanguage.g:1005:1: ( 'quid' )
            // InternalBug289187TestLanguage.g:1006:1: 'quid'
            {
             before(grammarAccess.getClassAccess().getQuidKeyword_8_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getQuidKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_8__0__Impl"


    // $ANTLR start "rule__Class__Group_8__1"
    // InternalBug289187TestLanguage.g:1019:1: rule__Class__Group_8__1 : rule__Class__Group_8__1__Impl rule__Class__Group_8__2 ;
    public final void rule__Class__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1023:1: ( rule__Class__Group_8__1__Impl rule__Class__Group_8__2 )
            // InternalBug289187TestLanguage.g:1024:2: rule__Class__Group_8__1__Impl rule__Class__Group_8__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Class__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_8__2();

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
    // $ANTLR end "rule__Class__Group_8__1"


    // $ANTLR start "rule__Class__Group_8__1__Impl"
    // InternalBug289187TestLanguage.g:1031:1: rule__Class__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Class__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1035:1: ( ( '=' ) )
            // InternalBug289187TestLanguage.g:1036:1: ( '=' )
            {
            // InternalBug289187TestLanguage.g:1036:1: ( '=' )
            // InternalBug289187TestLanguage.g:1037:1: '='
            {
             before(grammarAccess.getClassAccess().getEqualsSignKeyword_8_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getEqualsSignKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_8__1__Impl"


    // $ANTLR start "rule__Class__Group_8__2"
    // InternalBug289187TestLanguage.g:1050:1: rule__Class__Group_8__2 : rule__Class__Group_8__2__Impl ;
    public final void rule__Class__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1054:1: ( rule__Class__Group_8__2__Impl )
            // InternalBug289187TestLanguage.g:1055:2: rule__Class__Group_8__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_8__2__Impl();

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
    // $ANTLR end "rule__Class__Group_8__2"


    // $ANTLR start "rule__Class__Group_8__2__Impl"
    // InternalBug289187TestLanguage.g:1061:1: rule__Class__Group_8__2__Impl : ( ( rule__Class__QuidAssignment_8_2 ) ) ;
    public final void rule__Class__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1065:1: ( ( ( rule__Class__QuidAssignment_8_2 ) ) )
            // InternalBug289187TestLanguage.g:1066:1: ( ( rule__Class__QuidAssignment_8_2 ) )
            {
            // InternalBug289187TestLanguage.g:1066:1: ( ( rule__Class__QuidAssignment_8_2 ) )
            // InternalBug289187TestLanguage.g:1067:1: ( rule__Class__QuidAssignment_8_2 )
            {
             before(grammarAccess.getClassAccess().getQuidAssignment_8_2()); 
            // InternalBug289187TestLanguage.g:1068:1: ( rule__Class__QuidAssignment_8_2 )
            // InternalBug289187TestLanguage.g:1068:2: rule__Class__QuidAssignment_8_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__QuidAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getQuidAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_8__2__Impl"


    // $ANTLR start "rule__Class__Group_9__0"
    // InternalBug289187TestLanguage.g:1084:1: rule__Class__Group_9__0 : rule__Class__Group_9__0__Impl rule__Class__Group_9__1 ;
    public final void rule__Class__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1088:1: ( rule__Class__Group_9__0__Impl rule__Class__Group_9__1 )
            // InternalBug289187TestLanguage.g:1089:2: rule__Class__Group_9__0__Impl rule__Class__Group_9__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Class__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_9__1();

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
    // $ANTLR end "rule__Class__Group_9__0"


    // $ANTLR start "rule__Class__Group_9__0__Impl"
    // InternalBug289187TestLanguage.g:1096:1: rule__Class__Group_9__0__Impl : ( 'documentation' ) ;
    public final void rule__Class__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1100:1: ( ( 'documentation' ) )
            // InternalBug289187TestLanguage.g:1101:1: ( 'documentation' )
            {
            // InternalBug289187TestLanguage.g:1101:1: ( 'documentation' )
            // InternalBug289187TestLanguage.g:1102:1: 'documentation'
            {
             before(grammarAccess.getClassAccess().getDocumentationKeyword_9_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getDocumentationKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_9__0__Impl"


    // $ANTLR start "rule__Class__Group_9__1"
    // InternalBug289187TestLanguage.g:1115:1: rule__Class__Group_9__1 : rule__Class__Group_9__1__Impl rule__Class__Group_9__2 ;
    public final void rule__Class__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1119:1: ( rule__Class__Group_9__1__Impl rule__Class__Group_9__2 )
            // InternalBug289187TestLanguage.g:1120:2: rule__Class__Group_9__1__Impl rule__Class__Group_9__2
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Class__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_9__2();

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
    // $ANTLR end "rule__Class__Group_9__1"


    // $ANTLR start "rule__Class__Group_9__1__Impl"
    // InternalBug289187TestLanguage.g:1127:1: rule__Class__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Class__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1131:1: ( ( '=' ) )
            // InternalBug289187TestLanguage.g:1132:1: ( '=' )
            {
            // InternalBug289187TestLanguage.g:1132:1: ( '=' )
            // InternalBug289187TestLanguage.g:1133:1: '='
            {
             before(grammarAccess.getClassAccess().getEqualsSignKeyword_9_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getEqualsSignKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_9__1__Impl"


    // $ANTLR start "rule__Class__Group_9__2"
    // InternalBug289187TestLanguage.g:1146:1: rule__Class__Group_9__2 : rule__Class__Group_9__2__Impl ;
    public final void rule__Class__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1150:1: ( rule__Class__Group_9__2__Impl )
            // InternalBug289187TestLanguage.g:1151:2: rule__Class__Group_9__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_9__2__Impl();

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
    // $ANTLR end "rule__Class__Group_9__2"


    // $ANTLR start "rule__Class__Group_9__2__Impl"
    // InternalBug289187TestLanguage.g:1157:1: rule__Class__Group_9__2__Impl : ( ( rule__Class__DocumentationAssignment_9_2 ) ) ;
    public final void rule__Class__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1161:1: ( ( ( rule__Class__DocumentationAssignment_9_2 ) ) )
            // InternalBug289187TestLanguage.g:1162:1: ( ( rule__Class__DocumentationAssignment_9_2 ) )
            {
            // InternalBug289187TestLanguage.g:1162:1: ( ( rule__Class__DocumentationAssignment_9_2 ) )
            // InternalBug289187TestLanguage.g:1163:1: ( rule__Class__DocumentationAssignment_9_2 )
            {
             before(grammarAccess.getClassAccess().getDocumentationAssignment_9_2()); 
            // InternalBug289187TestLanguage.g:1164:1: ( rule__Class__DocumentationAssignment_9_2 )
            // InternalBug289187TestLanguage.g:1164:2: rule__Class__DocumentationAssignment_9_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__DocumentationAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getDocumentationAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_9__2__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalBug289187TestLanguage.g:1180:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1184:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalBug289187TestLanguage.g:1185:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
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
    // InternalBug289187TestLanguage.g:1192:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__VisibilityAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1196:1: ( ( ( rule__Attribute__VisibilityAssignment_0 )? ) )
            // InternalBug289187TestLanguage.g:1197:1: ( ( rule__Attribute__VisibilityAssignment_0 )? )
            {
            // InternalBug289187TestLanguage.g:1197:1: ( ( rule__Attribute__VisibilityAssignment_0 )? )
            // InternalBug289187TestLanguage.g:1198:1: ( rule__Attribute__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getVisibilityAssignment_0()); 
            // InternalBug289187TestLanguage.g:1199:1: ( rule__Attribute__VisibilityAssignment_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=11 && LA13_0<=14)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBug289187TestLanguage.g:1199:2: rule__Attribute__VisibilityAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute__VisibilityAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getVisibilityAssignment_0()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:1209:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1213:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalBug289187TestLanguage.g:1214:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
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
    // InternalBug289187TestLanguage.g:1221:1: rule__Attribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1225:1: ( ( 'attribute' ) )
            // InternalBug289187TestLanguage.g:1226:1: ( 'attribute' )
            {
            // InternalBug289187TestLanguage.g:1226:1: ( 'attribute' )
            // InternalBug289187TestLanguage.g:1227:1: 'attribute'
            {
             before(grammarAccess.getAttributeAccess().getAttributeKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getAttributeKeyword_1()); 

            }


            }

        }
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
    // InternalBug289187TestLanguage.g:1240:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1244:1: ( rule__Attribute__Group__2__Impl )
            // InternalBug289187TestLanguage.g:1245:2: rule__Attribute__Group__2__Impl
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
    // InternalBug289187TestLanguage.g:1251:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__NameAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1255:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) )
            // InternalBug289187TestLanguage.g:1256:1: ( ( rule__Attribute__NameAssignment_2 ) )
            {
            // InternalBug289187TestLanguage.g:1256:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // InternalBug289187TestLanguage.g:1257:1: ( rule__Attribute__NameAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            // InternalBug289187TestLanguage.g:1258:1: ( rule__Attribute__NameAssignment_2 )
            // InternalBug289187TestLanguage.g:1258:2: rule__Attribute__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Operation__Group__0"
    // InternalBug289187TestLanguage.g:1274:1: rule__Operation__Group__0 : rule__Operation__Group__0__Impl rule__Operation__Group__1 ;
    public final void rule__Operation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1278:1: ( rule__Operation__Group__0__Impl rule__Operation__Group__1 )
            // InternalBug289187TestLanguage.g:1279:2: rule__Operation__Group__0__Impl rule__Operation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Operation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Operation__Group__1();

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
    // $ANTLR end "rule__Operation__Group__0"


    // $ANTLR start "rule__Operation__Group__0__Impl"
    // InternalBug289187TestLanguage.g:1286:1: rule__Operation__Group__0__Impl : ( ( rule__Operation__VisibilityAssignment_0 )? ) ;
    public final void rule__Operation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1290:1: ( ( ( rule__Operation__VisibilityAssignment_0 )? ) )
            // InternalBug289187TestLanguage.g:1291:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            {
            // InternalBug289187TestLanguage.g:1291:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            // InternalBug289187TestLanguage.g:1292:1: ( rule__Operation__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 
            // InternalBug289187TestLanguage.g:1293:1: ( rule__Operation__VisibilityAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=11 && LA14_0<=14)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBug289187TestLanguage.g:1293:2: rule__Operation__VisibilityAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Operation__VisibilityAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation__Group__0__Impl"


    // $ANTLR start "rule__Operation__Group__1"
    // InternalBug289187TestLanguage.g:1303:1: rule__Operation__Group__1 : rule__Operation__Group__1__Impl rule__Operation__Group__2 ;
    public final void rule__Operation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1307:1: ( rule__Operation__Group__1__Impl rule__Operation__Group__2 )
            // InternalBug289187TestLanguage.g:1308:2: rule__Operation__Group__1__Impl rule__Operation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Operation__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Operation__Group__2();

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
    // $ANTLR end "rule__Operation__Group__1"


    // $ANTLR start "rule__Operation__Group__1__Impl"
    // InternalBug289187TestLanguage.g:1315:1: rule__Operation__Group__1__Impl : ( 'operation' ) ;
    public final void rule__Operation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1319:1: ( ( 'operation' ) )
            // InternalBug289187TestLanguage.g:1320:1: ( 'operation' )
            {
            // InternalBug289187TestLanguage.g:1320:1: ( 'operation' )
            // InternalBug289187TestLanguage.g:1321:1: 'operation'
            {
             before(grammarAccess.getOperationAccess().getOperationKeyword_1()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getOperationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation__Group__1__Impl"


    // $ANTLR start "rule__Operation__Group__2"
    // InternalBug289187TestLanguage.g:1334:1: rule__Operation__Group__2 : rule__Operation__Group__2__Impl ;
    public final void rule__Operation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1338:1: ( rule__Operation__Group__2__Impl )
            // InternalBug289187TestLanguage.g:1339:2: rule__Operation__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Operation__Group__2__Impl();

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
    // $ANTLR end "rule__Operation__Group__2"


    // $ANTLR start "rule__Operation__Group__2__Impl"
    // InternalBug289187TestLanguage.g:1345:1: rule__Operation__Group__2__Impl : ( ( rule__Operation__NameAssignment_2 ) ) ;
    public final void rule__Operation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1349:1: ( ( ( rule__Operation__NameAssignment_2 ) ) )
            // InternalBug289187TestLanguage.g:1350:1: ( ( rule__Operation__NameAssignment_2 ) )
            {
            // InternalBug289187TestLanguage.g:1350:1: ( ( rule__Operation__NameAssignment_2 ) )
            // InternalBug289187TestLanguage.g:1351:1: ( rule__Operation__NameAssignment_2 )
            {
             before(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            // InternalBug289187TestLanguage.g:1352:1: ( rule__Operation__NameAssignment_2 )
            // InternalBug289187TestLanguage.g:1352:2: rule__Operation__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Operation__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOperationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation__Group__2__Impl"


    // $ANTLR start "rule__Model__ClassesAssignment"
    // InternalBug289187TestLanguage.g:1369:1: rule__Model__ClassesAssignment : ( ruleClass ) ;
    public final void rule__Model__ClassesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1373:1: ( ( ruleClass ) )
            // InternalBug289187TestLanguage.g:1374:1: ( ruleClass )
            {
            // InternalBug289187TestLanguage.g:1374:1: ( ruleClass )
            // InternalBug289187TestLanguage.g:1375:1: ruleClass
            {
             before(grammarAccess.getModelAccess().getClassesClassParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getModelAccess().getClassesClassParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ClassesAssignment"


    // $ANTLR start "rule__Class__AbstractAssignment_0"
    // InternalBug289187TestLanguage.g:1384:1: rule__Class__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__Class__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1388:1: ( ( ( 'abstract' ) ) )
            // InternalBug289187TestLanguage.g:1389:1: ( ( 'abstract' ) )
            {
            // InternalBug289187TestLanguage.g:1389:1: ( ( 'abstract' ) )
            // InternalBug289187TestLanguage.g:1390:1: ( 'abstract' )
            {
             before(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0()); 
            // InternalBug289187TestLanguage.g:1391:1: ( 'abstract' )
            // InternalBug289187TestLanguage.g:1392:1: 'abstract'
            {
             before(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0()); 

            }

             after(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__AbstractAssignment_0"


    // $ANTLR start "rule__Class__TransientAssignment_1"
    // InternalBug289187TestLanguage.g:1407:1: rule__Class__TransientAssignment_1 : ( ( 'transient' ) ) ;
    public final void rule__Class__TransientAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1411:1: ( ( ( 'transient' ) ) )
            // InternalBug289187TestLanguage.g:1412:1: ( ( 'transient' ) )
            {
            // InternalBug289187TestLanguage.g:1412:1: ( ( 'transient' ) )
            // InternalBug289187TestLanguage.g:1413:1: ( 'transient' )
            {
             before(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0()); 
            // InternalBug289187TestLanguage.g:1414:1: ( 'transient' )
            // InternalBug289187TestLanguage.g:1415:1: 'transient'
            {
             before(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0()); 

            }

             after(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__TransientAssignment_1"


    // $ANTLR start "rule__Class__NameAssignment_3"
    // InternalBug289187TestLanguage.g:1430:1: rule__Class__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Class__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1434:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1435:1: ( RULE_ID )
            {
            // InternalBug289187TestLanguage.g:1435:1: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1436:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__NameAssignment_3"


    // $ANTLR start "rule__Class__SuperClassAssignment_4_1"
    // InternalBug289187TestLanguage.g:1445:1: rule__Class__SuperClassAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperClassAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1449:1: ( ( ( RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:1450:1: ( ( RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:1450:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1451:1: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_4_1_0()); 
            // InternalBug289187TestLanguage.g:1452:1: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1453:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__SuperClassAssignment_4_1"


    // $ANTLR start "rule__Class__ImplementedInterfacesAssignment_5_1"
    // InternalBug289187TestLanguage.g:1464:1: rule__Class__ImplementedInterfacesAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__ImplementedInterfacesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1468:1: ( ( ( RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:1469:1: ( ( RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:1469:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1470:1: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_1_0()); 
            // InternalBug289187TestLanguage.g:1471:1: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1472:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getImplementedInterfacesClassIDTerminalRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ImplementedInterfacesAssignment_5_1"


    // $ANTLR start "rule__Class__ImplementedInterfacesAssignment_5_2_2"
    // InternalBug289187TestLanguage.g:1483:1: rule__Class__ImplementedInterfacesAssignment_5_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__Class__ImplementedInterfacesAssignment_5_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1487:1: ( ( ( RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:1488:1: ( ( RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:1488:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1489:1: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_2_2_0()); 
            // InternalBug289187TestLanguage.g:1490:1: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1491:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassIDTerminalRuleCall_5_2_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getImplementedInterfacesClassIDTerminalRuleCall_5_2_2_0_1()); 

            }

             after(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ImplementedInterfacesAssignment_5_2_2"


    // $ANTLR start "rule__Class__ClassNumberAssignment_7_2"
    // InternalBug289187TestLanguage.g:1502:1: rule__Class__ClassNumberAssignment_7_2 : ( RULE_INT ) ;
    public final void rule__Class__ClassNumberAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1506:1: ( ( RULE_INT ) )
            // InternalBug289187TestLanguage.g:1507:1: ( RULE_INT )
            {
            // InternalBug289187TestLanguage.g:1507:1: ( RULE_INT )
            // InternalBug289187TestLanguage.g:1508:1: RULE_INT
            {
             before(grammarAccess.getClassAccess().getClassNumberINTTerminalRuleCall_7_2_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getClassNumberINTTerminalRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ClassNumberAssignment_7_2"


    // $ANTLR start "rule__Class__QuidAssignment_8_2"
    // InternalBug289187TestLanguage.g:1517:1: rule__Class__QuidAssignment_8_2 : ( RULE_INT ) ;
    public final void rule__Class__QuidAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1521:1: ( ( RULE_INT ) )
            // InternalBug289187TestLanguage.g:1522:1: ( RULE_INT )
            {
            // InternalBug289187TestLanguage.g:1522:1: ( RULE_INT )
            // InternalBug289187TestLanguage.g:1523:1: RULE_INT
            {
             before(grammarAccess.getClassAccess().getQuidINTTerminalRuleCall_8_2_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getQuidINTTerminalRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__QuidAssignment_8_2"


    // $ANTLR start "rule__Class__DocumentationAssignment_9_2"
    // InternalBug289187TestLanguage.g:1532:1: rule__Class__DocumentationAssignment_9_2 : ( RULE_STRING ) ;
    public final void rule__Class__DocumentationAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1536:1: ( ( RULE_STRING ) )
            // InternalBug289187TestLanguage.g:1537:1: ( RULE_STRING )
            {
            // InternalBug289187TestLanguage.g:1537:1: ( RULE_STRING )
            // InternalBug289187TestLanguage.g:1538:1: RULE_STRING
            {
             before(grammarAccess.getClassAccess().getDocumentationSTRINGTerminalRuleCall_9_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getDocumentationSTRINGTerminalRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__DocumentationAssignment_9_2"


    // $ANTLR start "rule__Class__AttributesAssignment_10"
    // InternalBug289187TestLanguage.g:1547:1: rule__Class__AttributesAssignment_10 : ( ruleAttribute ) ;
    public final void rule__Class__AttributesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1551:1: ( ( ruleAttribute ) )
            // InternalBug289187TestLanguage.g:1552:1: ( ruleAttribute )
            {
            // InternalBug289187TestLanguage.g:1552:1: ( ruleAttribute )
            // InternalBug289187TestLanguage.g:1553:1: ruleAttribute
            {
             before(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__AttributesAssignment_10"


    // $ANTLR start "rule__Class__OperationsAssignment_11"
    // InternalBug289187TestLanguage.g:1562:1: rule__Class__OperationsAssignment_11 : ( ruleOperation ) ;
    public final void rule__Class__OperationsAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1566:1: ( ( ruleOperation ) )
            // InternalBug289187TestLanguage.g:1567:1: ( ruleOperation )
            {
            // InternalBug289187TestLanguage.g:1567:1: ( ruleOperation )
            // InternalBug289187TestLanguage.g:1568:1: ruleOperation
            {
             before(grammarAccess.getClassAccess().getOperationsOperationParserRuleCall_11_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleOperation();

            state._fsp--;

             after(grammarAccess.getClassAccess().getOperationsOperationParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__OperationsAssignment_11"


    // $ANTLR start "rule__Attribute__VisibilityAssignment_0"
    // InternalBug289187TestLanguage.g:1577:1: rule__Attribute__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Attribute__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1581:1: ( ( ruleVisibility ) )
            // InternalBug289187TestLanguage.g:1582:1: ( ruleVisibility )
            {
            // InternalBug289187TestLanguage.g:1582:1: ( ruleVisibility )
            // InternalBug289187TestLanguage.g:1583:1: ruleVisibility
            {
             before(grammarAccess.getAttributeAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVisibility();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__VisibilityAssignment_0"


    // $ANTLR start "rule__Attribute__NameAssignment_2"
    // InternalBug289187TestLanguage.g:1592:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1596:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1597:1: ( RULE_ID )
            {
            // InternalBug289187TestLanguage.g:1597:1: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1598:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_2"


    // $ANTLR start "rule__Operation__VisibilityAssignment_0"
    // InternalBug289187TestLanguage.g:1607:1: rule__Operation__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Operation__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1611:1: ( ( ruleVisibility ) )
            // InternalBug289187TestLanguage.g:1612:1: ( ruleVisibility )
            {
            // InternalBug289187TestLanguage.g:1612:1: ( ruleVisibility )
            // InternalBug289187TestLanguage.g:1613:1: ruleVisibility
            {
             before(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVisibility();

            state._fsp--;

             after(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation__VisibilityAssignment_0"


    // $ANTLR start "rule__Operation__NameAssignment_2"
    // InternalBug289187TestLanguage.g:1622:1: rule__Operation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug289187TestLanguage.g:1626:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1627:1: ( RULE_ID )
            {
            // InternalBug289187TestLanguage.g:1627:1: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1628:1: RULE_ID
            {
             before(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation__NameAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000018008002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000018008000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000D0000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000007A27800L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002007802L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004007802L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002007800L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004007800L});
    }


}