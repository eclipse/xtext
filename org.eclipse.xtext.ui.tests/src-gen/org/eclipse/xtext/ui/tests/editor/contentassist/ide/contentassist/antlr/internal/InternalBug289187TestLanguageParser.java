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
    public static final int RULE_STRING=6;
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // InternalBug289187TestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:54:1: ( ruleModel EOF )
            // InternalBug289187TestLanguage.g:55:1: ruleModel EOF
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
    // InternalBug289187TestLanguage.g:62:1: ruleModel : ( ( rule__Model__ClassesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:66:2: ( ( ( rule__Model__ClassesAssignment )* ) )
            // InternalBug289187TestLanguage.g:67:2: ( ( rule__Model__ClassesAssignment )* )
            {
            // InternalBug289187TestLanguage.g:67:2: ( ( rule__Model__ClassesAssignment )* )
            // InternalBug289187TestLanguage.g:68:3: ( rule__Model__ClassesAssignment )*
            {
             before(grammarAccess.getModelAccess().getClassesAssignment()); 
            // InternalBug289187TestLanguage.g:69:3: ( rule__Model__ClassesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15||(LA1_0>=27 && LA1_0<=28)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:69:4: rule__Model__ClassesAssignment
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
    // InternalBug289187TestLanguage.g:78:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:79:1: ( ruleClass EOF )
            // InternalBug289187TestLanguage.g:80:1: ruleClass EOF
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
    // InternalBug289187TestLanguage.g:87:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:91:2: ( ( ( rule__Class__Group__0 ) ) )
            // InternalBug289187TestLanguage.g:92:2: ( ( rule__Class__Group__0 ) )
            {
            // InternalBug289187TestLanguage.g:92:2: ( ( rule__Class__Group__0 ) )
            // InternalBug289187TestLanguage.g:93:3: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // InternalBug289187TestLanguage.g:94:3: ( rule__Class__Group__0 )
            // InternalBug289187TestLanguage.g:94:4: rule__Class__Group__0
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
    // InternalBug289187TestLanguage.g:103:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:104:1: ( ruleAttribute EOF )
            // InternalBug289187TestLanguage.g:105:1: ruleAttribute EOF
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
    // InternalBug289187TestLanguage.g:112:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:116:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalBug289187TestLanguage.g:117:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalBug289187TestLanguage.g:117:2: ( ( rule__Attribute__Group__0 ) )
            // InternalBug289187TestLanguage.g:118:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalBug289187TestLanguage.g:119:3: ( rule__Attribute__Group__0 )
            // InternalBug289187TestLanguage.g:119:4: rule__Attribute__Group__0
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
    // InternalBug289187TestLanguage.g:128:1: entryRuleOperation : ruleOperation EOF ;
    public final void entryRuleOperation() throws RecognitionException {
        try {
            // InternalBug289187TestLanguage.g:129:1: ( ruleOperation EOF )
            // InternalBug289187TestLanguage.g:130:1: ruleOperation EOF
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
    // InternalBug289187TestLanguage.g:137:1: ruleOperation : ( ( rule__Operation__Group__0 ) ) ;
    public final void ruleOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:141:2: ( ( ( rule__Operation__Group__0 ) ) )
            // InternalBug289187TestLanguage.g:142:2: ( ( rule__Operation__Group__0 ) )
            {
            // InternalBug289187TestLanguage.g:142:2: ( ( rule__Operation__Group__0 ) )
            // InternalBug289187TestLanguage.g:143:3: ( rule__Operation__Group__0 )
            {
             before(grammarAccess.getOperationAccess().getGroup()); 
            // InternalBug289187TestLanguage.g:144:3: ( rule__Operation__Group__0 )
            // InternalBug289187TestLanguage.g:144:4: rule__Operation__Group__0
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
    // InternalBug289187TestLanguage.g:153:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:157:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // InternalBug289187TestLanguage.g:158:2: ( ( rule__Visibility__Alternatives ) )
            {
            // InternalBug289187TestLanguage.g:158:2: ( ( rule__Visibility__Alternatives ) )
            // InternalBug289187TestLanguage.g:159:3: ( rule__Visibility__Alternatives )
            {
             before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            // InternalBug289187TestLanguage.g:160:3: ( rule__Visibility__Alternatives )
            // InternalBug289187TestLanguage.g:160:4: rule__Visibility__Alternatives
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
    // InternalBug289187TestLanguage.g:168:1: rule__Visibility__Alternatives : ( ( ( 'PRIVATE' ) ) | ( ( 'PROTECTED' ) ) | ( ( 'PACKAGE_PRIVATE' ) ) | ( ( 'PUBLIC' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:172:1: ( ( ( 'PRIVATE' ) ) | ( ( 'PROTECTED' ) ) | ( ( 'PACKAGE_PRIVATE' ) ) | ( ( 'PUBLIC' ) ) )
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
                    // InternalBug289187TestLanguage.g:173:2: ( ( 'PRIVATE' ) )
                    {
                    // InternalBug289187TestLanguage.g:173:2: ( ( 'PRIVATE' ) )
                    // InternalBug289187TestLanguage.g:174:3: ( 'PRIVATE' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0()); 
                    // InternalBug289187TestLanguage.g:175:3: ( 'PRIVATE' )
                    // InternalBug289187TestLanguage.g:175:4: 'PRIVATE'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug289187TestLanguage.g:179:2: ( ( 'PROTECTED' ) )
                    {
                    // InternalBug289187TestLanguage.g:179:2: ( ( 'PROTECTED' ) )
                    // InternalBug289187TestLanguage.g:180:3: ( 'PROTECTED' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    // InternalBug289187TestLanguage.g:181:3: ( 'PROTECTED' )
                    // InternalBug289187TestLanguage.g:181:4: 'PROTECTED'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug289187TestLanguage.g:185:2: ( ( 'PACKAGE_PRIVATE' ) )
                    {
                    // InternalBug289187TestLanguage.g:185:2: ( ( 'PACKAGE_PRIVATE' ) )
                    // InternalBug289187TestLanguage.g:186:3: ( 'PACKAGE_PRIVATE' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2()); 
                    // InternalBug289187TestLanguage.g:187:3: ( 'PACKAGE_PRIVATE' )
                    // InternalBug289187TestLanguage.g:187:4: 'PACKAGE_PRIVATE'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug289187TestLanguage.g:191:2: ( ( 'PUBLIC' ) )
                    {
                    // InternalBug289187TestLanguage.g:191:2: ( ( 'PUBLIC' ) )
                    // InternalBug289187TestLanguage.g:192:3: ( 'PUBLIC' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3()); 
                    // InternalBug289187TestLanguage.g:193:3: ( 'PUBLIC' )
                    // InternalBug289187TestLanguage.g:193:4: 'PUBLIC'
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
    // InternalBug289187TestLanguage.g:201:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:205:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalBug289187TestLanguage.g:206:2: rule__Class__Group__0__Impl rule__Class__Group__1
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
    // InternalBug289187TestLanguage.g:213:1: rule__Class__Group__0__Impl : ( ( rule__Class__AbstractAssignment_0 )? ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:217:1: ( ( ( rule__Class__AbstractAssignment_0 )? ) )
            // InternalBug289187TestLanguage.g:218:1: ( ( rule__Class__AbstractAssignment_0 )? )
            {
            // InternalBug289187TestLanguage.g:218:1: ( ( rule__Class__AbstractAssignment_0 )? )
            // InternalBug289187TestLanguage.g:219:2: ( rule__Class__AbstractAssignment_0 )?
            {
             before(grammarAccess.getClassAccess().getAbstractAssignment_0()); 
            // InternalBug289187TestLanguage.g:220:2: ( rule__Class__AbstractAssignment_0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==27) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug289187TestLanguage.g:220:3: rule__Class__AbstractAssignment_0
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
    // InternalBug289187TestLanguage.g:228:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:232:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalBug289187TestLanguage.g:233:2: rule__Class__Group__1__Impl rule__Class__Group__2
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
    // InternalBug289187TestLanguage.g:240:1: rule__Class__Group__1__Impl : ( ( rule__Class__TransientAssignment_1 )? ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:244:1: ( ( ( rule__Class__TransientAssignment_1 )? ) )
            // InternalBug289187TestLanguage.g:245:1: ( ( rule__Class__TransientAssignment_1 )? )
            {
            // InternalBug289187TestLanguage.g:245:1: ( ( rule__Class__TransientAssignment_1 )? )
            // InternalBug289187TestLanguage.g:246:2: ( rule__Class__TransientAssignment_1 )?
            {
             before(grammarAccess.getClassAccess().getTransientAssignment_1()); 
            // InternalBug289187TestLanguage.g:247:2: ( rule__Class__TransientAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==28) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug289187TestLanguage.g:247:3: rule__Class__TransientAssignment_1
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
    // InternalBug289187TestLanguage.g:255:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:259:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalBug289187TestLanguage.g:260:2: rule__Class__Group__2__Impl rule__Class__Group__3
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
    // InternalBug289187TestLanguage.g:267:1: rule__Class__Group__2__Impl : ( 'class' ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:271:1: ( ( 'class' ) )
            // InternalBug289187TestLanguage.g:272:1: ( 'class' )
            {
            // InternalBug289187TestLanguage.g:272:1: ( 'class' )
            // InternalBug289187TestLanguage.g:273:2: 'class'
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
    // InternalBug289187TestLanguage.g:282:1: rule__Class__Group__3 : rule__Class__Group__3__Impl rule__Class__Group__4 ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:286:1: ( rule__Class__Group__3__Impl rule__Class__Group__4 )
            // InternalBug289187TestLanguage.g:287:2: rule__Class__Group__3__Impl rule__Class__Group__4
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
    // InternalBug289187TestLanguage.g:294:1: rule__Class__Group__3__Impl : ( ( rule__Class__NameAssignment_3 ) ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:298:1: ( ( ( rule__Class__NameAssignment_3 ) ) )
            // InternalBug289187TestLanguage.g:299:1: ( ( rule__Class__NameAssignment_3 ) )
            {
            // InternalBug289187TestLanguage.g:299:1: ( ( rule__Class__NameAssignment_3 ) )
            // InternalBug289187TestLanguage.g:300:2: ( rule__Class__NameAssignment_3 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_3()); 
            // InternalBug289187TestLanguage.g:301:2: ( rule__Class__NameAssignment_3 )
            // InternalBug289187TestLanguage.g:301:3: rule__Class__NameAssignment_3
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
    // InternalBug289187TestLanguage.g:309:1: rule__Class__Group__4 : rule__Class__Group__4__Impl rule__Class__Group__5 ;
    public final void rule__Class__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:313:1: ( rule__Class__Group__4__Impl rule__Class__Group__5 )
            // InternalBug289187TestLanguage.g:314:2: rule__Class__Group__4__Impl rule__Class__Group__5
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
    // InternalBug289187TestLanguage.g:321:1: rule__Class__Group__4__Impl : ( ( rule__Class__Group_4__0 )? ) ;
    public final void rule__Class__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:325:1: ( ( ( rule__Class__Group_4__0 )? ) )
            // InternalBug289187TestLanguage.g:326:1: ( ( rule__Class__Group_4__0 )? )
            {
            // InternalBug289187TestLanguage.g:326:1: ( ( rule__Class__Group_4__0 )? )
            // InternalBug289187TestLanguage.g:327:2: ( rule__Class__Group_4__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_4()); 
            // InternalBug289187TestLanguage.g:328:2: ( rule__Class__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug289187TestLanguage.g:328:3: rule__Class__Group_4__0
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
    // InternalBug289187TestLanguage.g:336:1: rule__Class__Group__5 : rule__Class__Group__5__Impl rule__Class__Group__6 ;
    public final void rule__Class__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:340:1: ( rule__Class__Group__5__Impl rule__Class__Group__6 )
            // InternalBug289187TestLanguage.g:341:2: rule__Class__Group__5__Impl rule__Class__Group__6
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
    // InternalBug289187TestLanguage.g:348:1: rule__Class__Group__5__Impl : ( ( rule__Class__Group_5__0 )? ) ;
    public final void rule__Class__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:352:1: ( ( ( rule__Class__Group_5__0 )? ) )
            // InternalBug289187TestLanguage.g:353:1: ( ( rule__Class__Group_5__0 )? )
            {
            // InternalBug289187TestLanguage.g:353:1: ( ( rule__Class__Group_5__0 )? )
            // InternalBug289187TestLanguage.g:354:2: ( rule__Class__Group_5__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_5()); 
            // InternalBug289187TestLanguage.g:355:2: ( rule__Class__Group_5__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug289187TestLanguage.g:355:3: rule__Class__Group_5__0
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
    // InternalBug289187TestLanguage.g:363:1: rule__Class__Group__6 : rule__Class__Group__6__Impl rule__Class__Group__7 ;
    public final void rule__Class__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:367:1: ( rule__Class__Group__6__Impl rule__Class__Group__7 )
            // InternalBug289187TestLanguage.g:368:2: rule__Class__Group__6__Impl rule__Class__Group__7
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
    // InternalBug289187TestLanguage.g:375:1: rule__Class__Group__6__Impl : ( '{' ) ;
    public final void rule__Class__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:379:1: ( ( '{' ) )
            // InternalBug289187TestLanguage.g:380:1: ( '{' )
            {
            // InternalBug289187TestLanguage.g:380:1: ( '{' )
            // InternalBug289187TestLanguage.g:381:2: '{'
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
    // InternalBug289187TestLanguage.g:390:1: rule__Class__Group__7 : rule__Class__Group__7__Impl rule__Class__Group__8 ;
    public final void rule__Class__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:394:1: ( rule__Class__Group__7__Impl rule__Class__Group__8 )
            // InternalBug289187TestLanguage.g:395:2: rule__Class__Group__7__Impl rule__Class__Group__8
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
    // InternalBug289187TestLanguage.g:402:1: rule__Class__Group__7__Impl : ( ( rule__Class__Group_7__0 )? ) ;
    public final void rule__Class__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:406:1: ( ( ( rule__Class__Group_7__0 )? ) )
            // InternalBug289187TestLanguage.g:407:1: ( ( rule__Class__Group_7__0 )? )
            {
            // InternalBug289187TestLanguage.g:407:1: ( ( rule__Class__Group_7__0 )? )
            // InternalBug289187TestLanguage.g:408:2: ( rule__Class__Group_7__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_7()); 
            // InternalBug289187TestLanguage.g:409:2: ( rule__Class__Group_7__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug289187TestLanguage.g:409:3: rule__Class__Group_7__0
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
    // InternalBug289187TestLanguage.g:417:1: rule__Class__Group__8 : rule__Class__Group__8__Impl rule__Class__Group__9 ;
    public final void rule__Class__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:421:1: ( rule__Class__Group__8__Impl rule__Class__Group__9 )
            // InternalBug289187TestLanguage.g:422:2: rule__Class__Group__8__Impl rule__Class__Group__9
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
    // InternalBug289187TestLanguage.g:429:1: rule__Class__Group__8__Impl : ( ( rule__Class__Group_8__0 )? ) ;
    public final void rule__Class__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:433:1: ( ( ( rule__Class__Group_8__0 )? ) )
            // InternalBug289187TestLanguage.g:434:1: ( ( rule__Class__Group_8__0 )? )
            {
            // InternalBug289187TestLanguage.g:434:1: ( ( rule__Class__Group_8__0 )? )
            // InternalBug289187TestLanguage.g:435:2: ( rule__Class__Group_8__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_8()); 
            // InternalBug289187TestLanguage.g:436:2: ( rule__Class__Group_8__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug289187TestLanguage.g:436:3: rule__Class__Group_8__0
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
    // InternalBug289187TestLanguage.g:444:1: rule__Class__Group__9 : rule__Class__Group__9__Impl rule__Class__Group__10 ;
    public final void rule__Class__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:448:1: ( rule__Class__Group__9__Impl rule__Class__Group__10 )
            // InternalBug289187TestLanguage.g:449:2: rule__Class__Group__9__Impl rule__Class__Group__10
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
    // InternalBug289187TestLanguage.g:456:1: rule__Class__Group__9__Impl : ( ( rule__Class__Group_9__0 )? ) ;
    public final void rule__Class__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:460:1: ( ( ( rule__Class__Group_9__0 )? ) )
            // InternalBug289187TestLanguage.g:461:1: ( ( rule__Class__Group_9__0 )? )
            {
            // InternalBug289187TestLanguage.g:461:1: ( ( rule__Class__Group_9__0 )? )
            // InternalBug289187TestLanguage.g:462:2: ( rule__Class__Group_9__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_9()); 
            // InternalBug289187TestLanguage.g:463:2: ( rule__Class__Group_9__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug289187TestLanguage.g:463:3: rule__Class__Group_9__0
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
    // InternalBug289187TestLanguage.g:471:1: rule__Class__Group__10 : rule__Class__Group__10__Impl rule__Class__Group__11 ;
    public final void rule__Class__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:475:1: ( rule__Class__Group__10__Impl rule__Class__Group__11 )
            // InternalBug289187TestLanguage.g:476:2: rule__Class__Group__10__Impl rule__Class__Group__11
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
    // InternalBug289187TestLanguage.g:483:1: rule__Class__Group__10__Impl : ( ( rule__Class__AttributesAssignment_10 )* ) ;
    public final void rule__Class__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:487:1: ( ( ( rule__Class__AttributesAssignment_10 )* ) )
            // InternalBug289187TestLanguage.g:488:1: ( ( rule__Class__AttributesAssignment_10 )* )
            {
            // InternalBug289187TestLanguage.g:488:1: ( ( rule__Class__AttributesAssignment_10 )* )
            // InternalBug289187TestLanguage.g:489:2: ( rule__Class__AttributesAssignment_10 )*
            {
             before(grammarAccess.getClassAccess().getAttributesAssignment_10()); 
            // InternalBug289187TestLanguage.g:490:2: ( rule__Class__AttributesAssignment_10 )*
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
            	    // InternalBug289187TestLanguage.g:490:3: rule__Class__AttributesAssignment_10
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
    // InternalBug289187TestLanguage.g:498:1: rule__Class__Group__11 : rule__Class__Group__11__Impl rule__Class__Group__12 ;
    public final void rule__Class__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:502:1: ( rule__Class__Group__11__Impl rule__Class__Group__12 )
            // InternalBug289187TestLanguage.g:503:2: rule__Class__Group__11__Impl rule__Class__Group__12
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
    // InternalBug289187TestLanguage.g:510:1: rule__Class__Group__11__Impl : ( ( rule__Class__OperationsAssignment_11 )* ) ;
    public final void rule__Class__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:514:1: ( ( ( rule__Class__OperationsAssignment_11 )* ) )
            // InternalBug289187TestLanguage.g:515:1: ( ( rule__Class__OperationsAssignment_11 )* )
            {
            // InternalBug289187TestLanguage.g:515:1: ( ( rule__Class__OperationsAssignment_11 )* )
            // InternalBug289187TestLanguage.g:516:2: ( rule__Class__OperationsAssignment_11 )*
            {
             before(grammarAccess.getClassAccess().getOperationsAssignment_11()); 
            // InternalBug289187TestLanguage.g:517:2: ( rule__Class__OperationsAssignment_11 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=11 && LA11_0<=14)||LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:517:3: rule__Class__OperationsAssignment_11
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
    // InternalBug289187TestLanguage.g:525:1: rule__Class__Group__12 : rule__Class__Group__12__Impl ;
    public final void rule__Class__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:529:1: ( rule__Class__Group__12__Impl )
            // InternalBug289187TestLanguage.g:530:2: rule__Class__Group__12__Impl
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
    // InternalBug289187TestLanguage.g:536:1: rule__Class__Group__12__Impl : ( '}' ) ;
    public final void rule__Class__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:540:1: ( ( '}' ) )
            // InternalBug289187TestLanguage.g:541:1: ( '}' )
            {
            // InternalBug289187TestLanguage.g:541:1: ( '}' )
            // InternalBug289187TestLanguage.g:542:2: '}'
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
    // InternalBug289187TestLanguage.g:552:1: rule__Class__Group_4__0 : rule__Class__Group_4__0__Impl rule__Class__Group_4__1 ;
    public final void rule__Class__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:556:1: ( rule__Class__Group_4__0__Impl rule__Class__Group_4__1 )
            // InternalBug289187TestLanguage.g:557:2: rule__Class__Group_4__0__Impl rule__Class__Group_4__1
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
    // InternalBug289187TestLanguage.g:564:1: rule__Class__Group_4__0__Impl : ( 'extends' ) ;
    public final void rule__Class__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:568:1: ( ( 'extends' ) )
            // InternalBug289187TestLanguage.g:569:1: ( 'extends' )
            {
            // InternalBug289187TestLanguage.g:569:1: ( 'extends' )
            // InternalBug289187TestLanguage.g:570:2: 'extends'
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
    // InternalBug289187TestLanguage.g:579:1: rule__Class__Group_4__1 : rule__Class__Group_4__1__Impl ;
    public final void rule__Class__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:583:1: ( rule__Class__Group_4__1__Impl )
            // InternalBug289187TestLanguage.g:584:2: rule__Class__Group_4__1__Impl
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
    // InternalBug289187TestLanguage.g:590:1: rule__Class__Group_4__1__Impl : ( ( rule__Class__SuperClassAssignment_4_1 ) ) ;
    public final void rule__Class__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:594:1: ( ( ( rule__Class__SuperClassAssignment_4_1 ) ) )
            // InternalBug289187TestLanguage.g:595:1: ( ( rule__Class__SuperClassAssignment_4_1 ) )
            {
            // InternalBug289187TestLanguage.g:595:1: ( ( rule__Class__SuperClassAssignment_4_1 ) )
            // InternalBug289187TestLanguage.g:596:2: ( rule__Class__SuperClassAssignment_4_1 )
            {
             before(grammarAccess.getClassAccess().getSuperClassAssignment_4_1()); 
            // InternalBug289187TestLanguage.g:597:2: ( rule__Class__SuperClassAssignment_4_1 )
            // InternalBug289187TestLanguage.g:597:3: rule__Class__SuperClassAssignment_4_1
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
    // InternalBug289187TestLanguage.g:606:1: rule__Class__Group_5__0 : rule__Class__Group_5__0__Impl rule__Class__Group_5__1 ;
    public final void rule__Class__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:610:1: ( rule__Class__Group_5__0__Impl rule__Class__Group_5__1 )
            // InternalBug289187TestLanguage.g:611:2: rule__Class__Group_5__0__Impl rule__Class__Group_5__1
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
    // InternalBug289187TestLanguage.g:618:1: rule__Class__Group_5__0__Impl : ( 'implements' ) ;
    public final void rule__Class__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:622:1: ( ( 'implements' ) )
            // InternalBug289187TestLanguage.g:623:1: ( 'implements' )
            {
            // InternalBug289187TestLanguage.g:623:1: ( 'implements' )
            // InternalBug289187TestLanguage.g:624:2: 'implements'
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
    // InternalBug289187TestLanguage.g:633:1: rule__Class__Group_5__1 : rule__Class__Group_5__1__Impl rule__Class__Group_5__2 ;
    public final void rule__Class__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:637:1: ( rule__Class__Group_5__1__Impl rule__Class__Group_5__2 )
            // InternalBug289187TestLanguage.g:638:2: rule__Class__Group_5__1__Impl rule__Class__Group_5__2
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
    // InternalBug289187TestLanguage.g:645:1: rule__Class__Group_5__1__Impl : ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) ) ;
    public final void rule__Class__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:649:1: ( ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) ) )
            // InternalBug289187TestLanguage.g:650:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) )
            {
            // InternalBug289187TestLanguage.g:650:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) )
            // InternalBug289187TestLanguage.g:651:2: ( rule__Class__ImplementedInterfacesAssignment_5_1 )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_1()); 
            // InternalBug289187TestLanguage.g:652:2: ( rule__Class__ImplementedInterfacesAssignment_5_1 )
            // InternalBug289187TestLanguage.g:652:3: rule__Class__ImplementedInterfacesAssignment_5_1
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
    // InternalBug289187TestLanguage.g:660:1: rule__Class__Group_5__2 : rule__Class__Group_5__2__Impl ;
    public final void rule__Class__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:664:1: ( rule__Class__Group_5__2__Impl )
            // InternalBug289187TestLanguage.g:665:2: rule__Class__Group_5__2__Impl
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
    // InternalBug289187TestLanguage.g:671:1: rule__Class__Group_5__2__Impl : ( ( rule__Class__Group_5_2__0 )* ) ;
    public final void rule__Class__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:675:1: ( ( ( rule__Class__Group_5_2__0 )* ) )
            // InternalBug289187TestLanguage.g:676:1: ( ( rule__Class__Group_5_2__0 )* )
            {
            // InternalBug289187TestLanguage.g:676:1: ( ( rule__Class__Group_5_2__0 )* )
            // InternalBug289187TestLanguage.g:677:2: ( rule__Class__Group_5_2__0 )*
            {
             before(grammarAccess.getClassAccess().getGroup_5_2()); 
            // InternalBug289187TestLanguage.g:678:2: ( rule__Class__Group_5_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==20) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:678:3: rule__Class__Group_5_2__0
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
    // InternalBug289187TestLanguage.g:687:1: rule__Class__Group_5_2__0 : rule__Class__Group_5_2__0__Impl rule__Class__Group_5_2__1 ;
    public final void rule__Class__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:691:1: ( rule__Class__Group_5_2__0__Impl rule__Class__Group_5_2__1 )
            // InternalBug289187TestLanguage.g:692:2: rule__Class__Group_5_2__0__Impl rule__Class__Group_5_2__1
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
    // InternalBug289187TestLanguage.g:699:1: rule__Class__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__Class__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:703:1: ( ( ',' ) )
            // InternalBug289187TestLanguage.g:704:1: ( ',' )
            {
            // InternalBug289187TestLanguage.g:704:1: ( ',' )
            // InternalBug289187TestLanguage.g:705:2: ','
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
    // InternalBug289187TestLanguage.g:714:1: rule__Class__Group_5_2__1 : rule__Class__Group_5_2__1__Impl rule__Class__Group_5_2__2 ;
    public final void rule__Class__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:718:1: ( rule__Class__Group_5_2__1__Impl rule__Class__Group_5_2__2 )
            // InternalBug289187TestLanguage.g:719:2: rule__Class__Group_5_2__1__Impl rule__Class__Group_5_2__2
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
    // InternalBug289187TestLanguage.g:726:1: rule__Class__Group_5_2__1__Impl : ( 'implements' ) ;
    public final void rule__Class__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:730:1: ( ( 'implements' ) )
            // InternalBug289187TestLanguage.g:731:1: ( 'implements' )
            {
            // InternalBug289187TestLanguage.g:731:1: ( 'implements' )
            // InternalBug289187TestLanguage.g:732:2: 'implements'
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
    // InternalBug289187TestLanguage.g:741:1: rule__Class__Group_5_2__2 : rule__Class__Group_5_2__2__Impl ;
    public final void rule__Class__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:745:1: ( rule__Class__Group_5_2__2__Impl )
            // InternalBug289187TestLanguage.g:746:2: rule__Class__Group_5_2__2__Impl
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
    // InternalBug289187TestLanguage.g:752:1: rule__Class__Group_5_2__2__Impl : ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) ) ;
    public final void rule__Class__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:756:1: ( ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) ) )
            // InternalBug289187TestLanguage.g:757:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) )
            {
            // InternalBug289187TestLanguage.g:757:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) )
            // InternalBug289187TestLanguage.g:758:2: ( rule__Class__ImplementedInterfacesAssignment_5_2_2 )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_2_2()); 
            // InternalBug289187TestLanguage.g:759:2: ( rule__Class__ImplementedInterfacesAssignment_5_2_2 )
            // InternalBug289187TestLanguage.g:759:3: rule__Class__ImplementedInterfacesAssignment_5_2_2
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
    // InternalBug289187TestLanguage.g:768:1: rule__Class__Group_7__0 : rule__Class__Group_7__0__Impl rule__Class__Group_7__1 ;
    public final void rule__Class__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:772:1: ( rule__Class__Group_7__0__Impl rule__Class__Group_7__1 )
            // InternalBug289187TestLanguage.g:773:2: rule__Class__Group_7__0__Impl rule__Class__Group_7__1
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
    // InternalBug289187TestLanguage.g:780:1: rule__Class__Group_7__0__Impl : ( 'classNumber' ) ;
    public final void rule__Class__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:784:1: ( ( 'classNumber' ) )
            // InternalBug289187TestLanguage.g:785:1: ( 'classNumber' )
            {
            // InternalBug289187TestLanguage.g:785:1: ( 'classNumber' )
            // InternalBug289187TestLanguage.g:786:2: 'classNumber'
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
    // InternalBug289187TestLanguage.g:795:1: rule__Class__Group_7__1 : rule__Class__Group_7__1__Impl rule__Class__Group_7__2 ;
    public final void rule__Class__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:799:1: ( rule__Class__Group_7__1__Impl rule__Class__Group_7__2 )
            // InternalBug289187TestLanguage.g:800:2: rule__Class__Group_7__1__Impl rule__Class__Group_7__2
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
    // InternalBug289187TestLanguage.g:807:1: rule__Class__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Class__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:811:1: ( ( '=' ) )
            // InternalBug289187TestLanguage.g:812:1: ( '=' )
            {
            // InternalBug289187TestLanguage.g:812:1: ( '=' )
            // InternalBug289187TestLanguage.g:813:2: '='
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
    // InternalBug289187TestLanguage.g:822:1: rule__Class__Group_7__2 : rule__Class__Group_7__2__Impl ;
    public final void rule__Class__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:826:1: ( rule__Class__Group_7__2__Impl )
            // InternalBug289187TestLanguage.g:827:2: rule__Class__Group_7__2__Impl
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
    // InternalBug289187TestLanguage.g:833:1: rule__Class__Group_7__2__Impl : ( ( rule__Class__ClassNumberAssignment_7_2 ) ) ;
    public final void rule__Class__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:837:1: ( ( ( rule__Class__ClassNumberAssignment_7_2 ) ) )
            // InternalBug289187TestLanguage.g:838:1: ( ( rule__Class__ClassNumberAssignment_7_2 ) )
            {
            // InternalBug289187TestLanguage.g:838:1: ( ( rule__Class__ClassNumberAssignment_7_2 ) )
            // InternalBug289187TestLanguage.g:839:2: ( rule__Class__ClassNumberAssignment_7_2 )
            {
             before(grammarAccess.getClassAccess().getClassNumberAssignment_7_2()); 
            // InternalBug289187TestLanguage.g:840:2: ( rule__Class__ClassNumberAssignment_7_2 )
            // InternalBug289187TestLanguage.g:840:3: rule__Class__ClassNumberAssignment_7_2
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
    // InternalBug289187TestLanguage.g:849:1: rule__Class__Group_8__0 : rule__Class__Group_8__0__Impl rule__Class__Group_8__1 ;
    public final void rule__Class__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:853:1: ( rule__Class__Group_8__0__Impl rule__Class__Group_8__1 )
            // InternalBug289187TestLanguage.g:854:2: rule__Class__Group_8__0__Impl rule__Class__Group_8__1
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
    // InternalBug289187TestLanguage.g:861:1: rule__Class__Group_8__0__Impl : ( 'quid' ) ;
    public final void rule__Class__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:865:1: ( ( 'quid' ) )
            // InternalBug289187TestLanguage.g:866:1: ( 'quid' )
            {
            // InternalBug289187TestLanguage.g:866:1: ( 'quid' )
            // InternalBug289187TestLanguage.g:867:2: 'quid'
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
    // InternalBug289187TestLanguage.g:876:1: rule__Class__Group_8__1 : rule__Class__Group_8__1__Impl rule__Class__Group_8__2 ;
    public final void rule__Class__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:880:1: ( rule__Class__Group_8__1__Impl rule__Class__Group_8__2 )
            // InternalBug289187TestLanguage.g:881:2: rule__Class__Group_8__1__Impl rule__Class__Group_8__2
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
    // InternalBug289187TestLanguage.g:888:1: rule__Class__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Class__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:892:1: ( ( '=' ) )
            // InternalBug289187TestLanguage.g:893:1: ( '=' )
            {
            // InternalBug289187TestLanguage.g:893:1: ( '=' )
            // InternalBug289187TestLanguage.g:894:2: '='
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
    // InternalBug289187TestLanguage.g:903:1: rule__Class__Group_8__2 : rule__Class__Group_8__2__Impl ;
    public final void rule__Class__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:907:1: ( rule__Class__Group_8__2__Impl )
            // InternalBug289187TestLanguage.g:908:2: rule__Class__Group_8__2__Impl
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
    // InternalBug289187TestLanguage.g:914:1: rule__Class__Group_8__2__Impl : ( ( rule__Class__QuidAssignment_8_2 ) ) ;
    public final void rule__Class__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:918:1: ( ( ( rule__Class__QuidAssignment_8_2 ) ) )
            // InternalBug289187TestLanguage.g:919:1: ( ( rule__Class__QuidAssignment_8_2 ) )
            {
            // InternalBug289187TestLanguage.g:919:1: ( ( rule__Class__QuidAssignment_8_2 ) )
            // InternalBug289187TestLanguage.g:920:2: ( rule__Class__QuidAssignment_8_2 )
            {
             before(grammarAccess.getClassAccess().getQuidAssignment_8_2()); 
            // InternalBug289187TestLanguage.g:921:2: ( rule__Class__QuidAssignment_8_2 )
            // InternalBug289187TestLanguage.g:921:3: rule__Class__QuidAssignment_8_2
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
    // InternalBug289187TestLanguage.g:930:1: rule__Class__Group_9__0 : rule__Class__Group_9__0__Impl rule__Class__Group_9__1 ;
    public final void rule__Class__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:934:1: ( rule__Class__Group_9__0__Impl rule__Class__Group_9__1 )
            // InternalBug289187TestLanguage.g:935:2: rule__Class__Group_9__0__Impl rule__Class__Group_9__1
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
    // InternalBug289187TestLanguage.g:942:1: rule__Class__Group_9__0__Impl : ( 'documentation' ) ;
    public final void rule__Class__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:946:1: ( ( 'documentation' ) )
            // InternalBug289187TestLanguage.g:947:1: ( 'documentation' )
            {
            // InternalBug289187TestLanguage.g:947:1: ( 'documentation' )
            // InternalBug289187TestLanguage.g:948:2: 'documentation'
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
    // InternalBug289187TestLanguage.g:957:1: rule__Class__Group_9__1 : rule__Class__Group_9__1__Impl rule__Class__Group_9__2 ;
    public final void rule__Class__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:961:1: ( rule__Class__Group_9__1__Impl rule__Class__Group_9__2 )
            // InternalBug289187TestLanguage.g:962:2: rule__Class__Group_9__1__Impl rule__Class__Group_9__2
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
    // InternalBug289187TestLanguage.g:969:1: rule__Class__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Class__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:973:1: ( ( '=' ) )
            // InternalBug289187TestLanguage.g:974:1: ( '=' )
            {
            // InternalBug289187TestLanguage.g:974:1: ( '=' )
            // InternalBug289187TestLanguage.g:975:2: '='
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
    // InternalBug289187TestLanguage.g:984:1: rule__Class__Group_9__2 : rule__Class__Group_9__2__Impl ;
    public final void rule__Class__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:988:1: ( rule__Class__Group_9__2__Impl )
            // InternalBug289187TestLanguage.g:989:2: rule__Class__Group_9__2__Impl
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
    // InternalBug289187TestLanguage.g:995:1: rule__Class__Group_9__2__Impl : ( ( rule__Class__DocumentationAssignment_9_2 ) ) ;
    public final void rule__Class__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:999:1: ( ( ( rule__Class__DocumentationAssignment_9_2 ) ) )
            // InternalBug289187TestLanguage.g:1000:1: ( ( rule__Class__DocumentationAssignment_9_2 ) )
            {
            // InternalBug289187TestLanguage.g:1000:1: ( ( rule__Class__DocumentationAssignment_9_2 ) )
            // InternalBug289187TestLanguage.g:1001:2: ( rule__Class__DocumentationAssignment_9_2 )
            {
             before(grammarAccess.getClassAccess().getDocumentationAssignment_9_2()); 
            // InternalBug289187TestLanguage.g:1002:2: ( rule__Class__DocumentationAssignment_9_2 )
            // InternalBug289187TestLanguage.g:1002:3: rule__Class__DocumentationAssignment_9_2
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
    // InternalBug289187TestLanguage.g:1011:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1015:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalBug289187TestLanguage.g:1016:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
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
    // InternalBug289187TestLanguage.g:1023:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__VisibilityAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1027:1: ( ( ( rule__Attribute__VisibilityAssignment_0 )? ) )
            // InternalBug289187TestLanguage.g:1028:1: ( ( rule__Attribute__VisibilityAssignment_0 )? )
            {
            // InternalBug289187TestLanguage.g:1028:1: ( ( rule__Attribute__VisibilityAssignment_0 )? )
            // InternalBug289187TestLanguage.g:1029:2: ( rule__Attribute__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getVisibilityAssignment_0()); 
            // InternalBug289187TestLanguage.g:1030:2: ( rule__Attribute__VisibilityAssignment_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=11 && LA13_0<=14)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBug289187TestLanguage.g:1030:3: rule__Attribute__VisibilityAssignment_0
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
    // InternalBug289187TestLanguage.g:1038:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1042:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalBug289187TestLanguage.g:1043:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
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
    // InternalBug289187TestLanguage.g:1050:1: rule__Attribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1054:1: ( ( 'attribute' ) )
            // InternalBug289187TestLanguage.g:1055:1: ( 'attribute' )
            {
            // InternalBug289187TestLanguage.g:1055:1: ( 'attribute' )
            // InternalBug289187TestLanguage.g:1056:2: 'attribute'
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
    // InternalBug289187TestLanguage.g:1065:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1069:1: ( rule__Attribute__Group__2__Impl )
            // InternalBug289187TestLanguage.g:1070:2: rule__Attribute__Group__2__Impl
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
    // InternalBug289187TestLanguage.g:1076:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__NameAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1080:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) )
            // InternalBug289187TestLanguage.g:1081:1: ( ( rule__Attribute__NameAssignment_2 ) )
            {
            // InternalBug289187TestLanguage.g:1081:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // InternalBug289187TestLanguage.g:1082:2: ( rule__Attribute__NameAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            // InternalBug289187TestLanguage.g:1083:2: ( rule__Attribute__NameAssignment_2 )
            // InternalBug289187TestLanguage.g:1083:3: rule__Attribute__NameAssignment_2
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
    // InternalBug289187TestLanguage.g:1092:1: rule__Operation__Group__0 : rule__Operation__Group__0__Impl rule__Operation__Group__1 ;
    public final void rule__Operation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1096:1: ( rule__Operation__Group__0__Impl rule__Operation__Group__1 )
            // InternalBug289187TestLanguage.g:1097:2: rule__Operation__Group__0__Impl rule__Operation__Group__1
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
    // InternalBug289187TestLanguage.g:1104:1: rule__Operation__Group__0__Impl : ( ( rule__Operation__VisibilityAssignment_0 )? ) ;
    public final void rule__Operation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1108:1: ( ( ( rule__Operation__VisibilityAssignment_0 )? ) )
            // InternalBug289187TestLanguage.g:1109:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            {
            // InternalBug289187TestLanguage.g:1109:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            // InternalBug289187TestLanguage.g:1110:2: ( rule__Operation__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 
            // InternalBug289187TestLanguage.g:1111:2: ( rule__Operation__VisibilityAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=11 && LA14_0<=14)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBug289187TestLanguage.g:1111:3: rule__Operation__VisibilityAssignment_0
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
    // InternalBug289187TestLanguage.g:1119:1: rule__Operation__Group__1 : rule__Operation__Group__1__Impl rule__Operation__Group__2 ;
    public final void rule__Operation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1123:1: ( rule__Operation__Group__1__Impl rule__Operation__Group__2 )
            // InternalBug289187TestLanguage.g:1124:2: rule__Operation__Group__1__Impl rule__Operation__Group__2
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
    // InternalBug289187TestLanguage.g:1131:1: rule__Operation__Group__1__Impl : ( 'operation' ) ;
    public final void rule__Operation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1135:1: ( ( 'operation' ) )
            // InternalBug289187TestLanguage.g:1136:1: ( 'operation' )
            {
            // InternalBug289187TestLanguage.g:1136:1: ( 'operation' )
            // InternalBug289187TestLanguage.g:1137:2: 'operation'
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
    // InternalBug289187TestLanguage.g:1146:1: rule__Operation__Group__2 : rule__Operation__Group__2__Impl ;
    public final void rule__Operation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1150:1: ( rule__Operation__Group__2__Impl )
            // InternalBug289187TestLanguage.g:1151:2: rule__Operation__Group__2__Impl
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
    // InternalBug289187TestLanguage.g:1157:1: rule__Operation__Group__2__Impl : ( ( rule__Operation__NameAssignment_2 ) ) ;
    public final void rule__Operation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1161:1: ( ( ( rule__Operation__NameAssignment_2 ) ) )
            // InternalBug289187TestLanguage.g:1162:1: ( ( rule__Operation__NameAssignment_2 ) )
            {
            // InternalBug289187TestLanguage.g:1162:1: ( ( rule__Operation__NameAssignment_2 ) )
            // InternalBug289187TestLanguage.g:1163:2: ( rule__Operation__NameAssignment_2 )
            {
             before(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            // InternalBug289187TestLanguage.g:1164:2: ( rule__Operation__NameAssignment_2 )
            // InternalBug289187TestLanguage.g:1164:3: rule__Operation__NameAssignment_2
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
    // InternalBug289187TestLanguage.g:1173:1: rule__Model__ClassesAssignment : ( ruleClass ) ;
    public final void rule__Model__ClassesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1177:1: ( ( ruleClass ) )
            // InternalBug289187TestLanguage.g:1178:2: ( ruleClass )
            {
            // InternalBug289187TestLanguage.g:1178:2: ( ruleClass )
            // InternalBug289187TestLanguage.g:1179:3: ruleClass
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
    // InternalBug289187TestLanguage.g:1188:1: rule__Class__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__Class__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1192:1: ( ( ( 'abstract' ) ) )
            // InternalBug289187TestLanguage.g:1193:2: ( ( 'abstract' ) )
            {
            // InternalBug289187TestLanguage.g:1193:2: ( ( 'abstract' ) )
            // InternalBug289187TestLanguage.g:1194:3: ( 'abstract' )
            {
             before(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0()); 
            // InternalBug289187TestLanguage.g:1195:3: ( 'abstract' )
            // InternalBug289187TestLanguage.g:1196:4: 'abstract'
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
    // InternalBug289187TestLanguage.g:1207:1: rule__Class__TransientAssignment_1 : ( ( 'transient' ) ) ;
    public final void rule__Class__TransientAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1211:1: ( ( ( 'transient' ) ) )
            // InternalBug289187TestLanguage.g:1212:2: ( ( 'transient' ) )
            {
            // InternalBug289187TestLanguage.g:1212:2: ( ( 'transient' ) )
            // InternalBug289187TestLanguage.g:1213:3: ( 'transient' )
            {
             before(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0()); 
            // InternalBug289187TestLanguage.g:1214:3: ( 'transient' )
            // InternalBug289187TestLanguage.g:1215:4: 'transient'
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
    // InternalBug289187TestLanguage.g:1226:1: rule__Class__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Class__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1230:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1231:2: ( RULE_ID )
            {
            // InternalBug289187TestLanguage.g:1231:2: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1232:3: RULE_ID
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
    // InternalBug289187TestLanguage.g:1241:1: rule__Class__SuperClassAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperClassAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1245:1: ( ( ( RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:1246:2: ( ( RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:1246:2: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1247:3: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_4_1_0()); 
            // InternalBug289187TestLanguage.g:1248:3: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1249:4: RULE_ID
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
    // InternalBug289187TestLanguage.g:1260:1: rule__Class__ImplementedInterfacesAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__ImplementedInterfacesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1264:1: ( ( ( RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:1265:2: ( ( RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:1265:2: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1266:3: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_1_0()); 
            // InternalBug289187TestLanguage.g:1267:3: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1268:4: RULE_ID
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
    // InternalBug289187TestLanguage.g:1279:1: rule__Class__ImplementedInterfacesAssignment_5_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__Class__ImplementedInterfacesAssignment_5_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1283:1: ( ( ( RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:1284:2: ( ( RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:1284:2: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1285:3: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_2_2_0()); 
            // InternalBug289187TestLanguage.g:1286:3: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1287:4: RULE_ID
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
    // InternalBug289187TestLanguage.g:1298:1: rule__Class__ClassNumberAssignment_7_2 : ( RULE_INT ) ;
    public final void rule__Class__ClassNumberAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1302:1: ( ( RULE_INT ) )
            // InternalBug289187TestLanguage.g:1303:2: ( RULE_INT )
            {
            // InternalBug289187TestLanguage.g:1303:2: ( RULE_INT )
            // InternalBug289187TestLanguage.g:1304:3: RULE_INT
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
    // InternalBug289187TestLanguage.g:1313:1: rule__Class__QuidAssignment_8_2 : ( RULE_INT ) ;
    public final void rule__Class__QuidAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1317:1: ( ( RULE_INT ) )
            // InternalBug289187TestLanguage.g:1318:2: ( RULE_INT )
            {
            // InternalBug289187TestLanguage.g:1318:2: ( RULE_INT )
            // InternalBug289187TestLanguage.g:1319:3: RULE_INT
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
    // InternalBug289187TestLanguage.g:1328:1: rule__Class__DocumentationAssignment_9_2 : ( RULE_STRING ) ;
    public final void rule__Class__DocumentationAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1332:1: ( ( RULE_STRING ) )
            // InternalBug289187TestLanguage.g:1333:2: ( RULE_STRING )
            {
            // InternalBug289187TestLanguage.g:1333:2: ( RULE_STRING )
            // InternalBug289187TestLanguage.g:1334:3: RULE_STRING
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
    // InternalBug289187TestLanguage.g:1343:1: rule__Class__AttributesAssignment_10 : ( ruleAttribute ) ;
    public final void rule__Class__AttributesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1347:1: ( ( ruleAttribute ) )
            // InternalBug289187TestLanguage.g:1348:2: ( ruleAttribute )
            {
            // InternalBug289187TestLanguage.g:1348:2: ( ruleAttribute )
            // InternalBug289187TestLanguage.g:1349:3: ruleAttribute
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
    // InternalBug289187TestLanguage.g:1358:1: rule__Class__OperationsAssignment_11 : ( ruleOperation ) ;
    public final void rule__Class__OperationsAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1362:1: ( ( ruleOperation ) )
            // InternalBug289187TestLanguage.g:1363:2: ( ruleOperation )
            {
            // InternalBug289187TestLanguage.g:1363:2: ( ruleOperation )
            // InternalBug289187TestLanguage.g:1364:3: ruleOperation
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
    // InternalBug289187TestLanguage.g:1373:1: rule__Attribute__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Attribute__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1377:1: ( ( ruleVisibility ) )
            // InternalBug289187TestLanguage.g:1378:2: ( ruleVisibility )
            {
            // InternalBug289187TestLanguage.g:1378:2: ( ruleVisibility )
            // InternalBug289187TestLanguage.g:1379:3: ruleVisibility
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
    // InternalBug289187TestLanguage.g:1388:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1392:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1393:2: ( RULE_ID )
            {
            // InternalBug289187TestLanguage.g:1393:2: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1394:3: RULE_ID
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
    // InternalBug289187TestLanguage.g:1403:1: rule__Operation__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Operation__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1407:1: ( ( ruleVisibility ) )
            // InternalBug289187TestLanguage.g:1408:2: ( ruleVisibility )
            {
            // InternalBug289187TestLanguage.g:1408:2: ( ruleVisibility )
            // InternalBug289187TestLanguage.g:1409:3: ruleVisibility
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
    // InternalBug289187TestLanguage.g:1418:1: rule__Operation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug289187TestLanguage.g:1422:1: ( ( RULE_ID ) )
            // InternalBug289187TestLanguage.g:1423:2: ( RULE_ID )
            {
            // InternalBug289187TestLanguage.g:1423:2: ( RULE_ID )
            // InternalBug289187TestLanguage.g:1424:3: RULE_ID
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