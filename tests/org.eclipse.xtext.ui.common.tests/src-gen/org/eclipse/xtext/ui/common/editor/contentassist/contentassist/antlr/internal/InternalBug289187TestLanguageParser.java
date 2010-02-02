package org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.services.Bug289187TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug289187TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PRIVATE'", "'PROTECTED'", "'PACKAGE_PRIVATE'", "'PUBLIC'", "'class'", "'{'", "'}'", "'extends'", "'implements'", "','", "'classNumber'", "'='", "'quid'", "'documentation'", "'attribute'", "'operation'", "'abstract'", "'transient'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug289187TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g"; }


     
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:69:1: ruleModel : ( ( rule__Model__ClassesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:73:2: ( ( ( rule__Model__ClassesAssignment )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:74:1: ( ( rule__Model__ClassesAssignment )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:74:1: ( ( rule__Model__ClassesAssignment )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:75:1: ( rule__Model__ClassesAssignment )*
            {
             before(grammarAccess.getModelAccess().getClassesAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:76:1: ( rule__Model__ClassesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15||(LA1_0>=27 && LA1_0<=28)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:76:2: rule__Model__ClassesAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ClassesAssignment_in_ruleModel95);
            	    rule__Model__ClassesAssignment();
            	    _fsp--;


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleClass
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:88:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:89:1: ( ruleClass EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:90:1: ruleClass EOF
            {
             before(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleClass_in_entryRuleClass123);
            ruleClass();
            _fsp--;

             after(grammarAccess.getClassRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleClass130); 

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
    // $ANTLR end entryRuleClass


    // $ANTLR start ruleClass
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:97:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:101:2: ( ( ( rule__Class__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:102:1: ( ( rule__Class__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:102:1: ( ( rule__Class__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:103:1: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:104:1: ( rule__Class__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:104:2: rule__Class__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__0_in_ruleClass157);
            rule__Class__Group__0();
            _fsp--;


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
    // $ANTLR end ruleClass


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:116:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:117:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:118:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute184);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute191); 

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:125:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:129:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:130:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:130:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:131:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:132:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:132:2: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0_in_ruleAttribute218);
            rule__Attribute__Group__0();
            _fsp--;


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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:144:1: entryRuleOperation : ruleOperation EOF ;
    public final void entryRuleOperation() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:145:1: ( ruleOperation EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:146:1: ruleOperation EOF
            {
             before(grammarAccess.getOperationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_in_entryRuleOperation245);
            ruleOperation();
            _fsp--;

             after(grammarAccess.getOperationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation252); 

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
    // $ANTLR end entryRuleOperation


    // $ANTLR start ruleOperation
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:153:1: ruleOperation : ( ( rule__Operation__Group__0 ) ) ;
    public final void ruleOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:157:2: ( ( ( rule__Operation__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:158:1: ( ( rule__Operation__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:158:1: ( ( rule__Operation__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:159:1: ( rule__Operation__Group__0 )
            {
             before(grammarAccess.getOperationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:160:1: ( rule__Operation__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:160:2: rule__Operation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__0_in_ruleOperation279);
            rule__Operation__Group__0();
            _fsp--;


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
    // $ANTLR end ruleOperation


    // $ANTLR start ruleVisibility
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:173:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:177:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:178:1: ( ( rule__Visibility__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:178:1: ( ( rule__Visibility__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:179:1: ( rule__Visibility__Alternatives )
            {
             before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:180:1: ( rule__Visibility__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:180:2: rule__Visibility__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Visibility__Alternatives_in_ruleVisibility316);
            rule__Visibility__Alternatives();
            _fsp--;


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
    // $ANTLR end ruleVisibility


    // $ANTLR start rule__Visibility__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:191:1: rule__Visibility__Alternatives : ( ( ( 'PRIVATE' ) ) | ( ( 'PROTECTED' ) ) | ( ( 'PACKAGE_PRIVATE' ) ) | ( ( 'PUBLIC' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:195:1: ( ( ( 'PRIVATE' ) ) | ( ( 'PROTECTED' ) ) | ( ( 'PACKAGE_PRIVATE' ) ) | ( ( 'PUBLIC' ) ) )
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
                    new NoViableAltException("191:1: rule__Visibility__Alternatives : ( ( ( 'PRIVATE' ) ) | ( ( 'PROTECTED' ) ) | ( ( 'PACKAGE_PRIVATE' ) ) | ( ( 'PUBLIC' ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:196:1: ( ( 'PRIVATE' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:196:1: ( ( 'PRIVATE' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:197:1: ( 'PRIVATE' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:198:1: ( 'PRIVATE' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:198:3: 'PRIVATE'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Visibility__Alternatives352); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:203:6: ( ( 'PROTECTED' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:203:6: ( ( 'PROTECTED' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:204:1: ( 'PROTECTED' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:205:1: ( 'PROTECTED' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:205:3: 'PROTECTED'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Visibility__Alternatives373); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:210:6: ( ( 'PACKAGE_PRIVATE' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:210:6: ( ( 'PACKAGE_PRIVATE' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:211:1: ( 'PACKAGE_PRIVATE' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:212:1: ( 'PACKAGE_PRIVATE' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:212:3: 'PACKAGE_PRIVATE'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Visibility__Alternatives394); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:217:6: ( ( 'PUBLIC' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:217:6: ( ( 'PUBLIC' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:218:1: ( 'PUBLIC' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:219:1: ( 'PUBLIC' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:219:3: 'PUBLIC'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Visibility__Alternatives415); 

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
    // $ANTLR end rule__Visibility__Alternatives


    // $ANTLR start rule__Class__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:231:1: rule__Class__Group__0 : ( ( rule__Class__AbstractAssignment_0 )? ) rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:235:1: ( ( ( rule__Class__AbstractAssignment_0 )? ) rule__Class__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:236:1: ( ( rule__Class__AbstractAssignment_0 )? ) rule__Class__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:236:1: ( ( rule__Class__AbstractAssignment_0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:237:1: ( rule__Class__AbstractAssignment_0 )?
            {
             before(grammarAccess.getClassAccess().getAbstractAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:238:1: ( rule__Class__AbstractAssignment_0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==27) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:238:2: rule__Class__AbstractAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Class__AbstractAssignment_0_in_rule__Class__Group__0452);
                    rule__Class__AbstractAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getAbstractAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__1_in_rule__Class__Group__0462);
            rule__Class__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__0


    // $ANTLR start rule__Class__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:249:1: rule__Class__Group__1 : ( ( rule__Class__TransientAssignment_1 )? ) rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:253:1: ( ( ( rule__Class__TransientAssignment_1 )? ) rule__Class__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:254:1: ( ( rule__Class__TransientAssignment_1 )? ) rule__Class__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:254:1: ( ( rule__Class__TransientAssignment_1 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:255:1: ( rule__Class__TransientAssignment_1 )?
            {
             before(grammarAccess.getClassAccess().getTransientAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:256:1: ( rule__Class__TransientAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==28) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:256:2: rule__Class__TransientAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Class__TransientAssignment_1_in_rule__Class__Group__1490);
                    rule__Class__TransientAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getTransientAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__2_in_rule__Class__Group__1500);
            rule__Class__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__1


    // $ANTLR start rule__Class__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:267:1: rule__Class__Group__2 : ( 'class' ) rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:271:1: ( ( 'class' ) rule__Class__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:272:1: ( 'class' ) rule__Class__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:272:1: ( 'class' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:273:1: 'class'
            {
             before(grammarAccess.getClassAccess().getClassKeyword_2()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Class__Group__2529); 
             after(grammarAccess.getClassAccess().getClassKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__3_in_rule__Class__Group__2539);
            rule__Class__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__2


    // $ANTLR start rule__Class__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:287:1: rule__Class__Group__3 : ( ( rule__Class__NameAssignment_3 ) ) rule__Class__Group__4 ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:291:1: ( ( ( rule__Class__NameAssignment_3 ) ) rule__Class__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:292:1: ( ( rule__Class__NameAssignment_3 ) ) rule__Class__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:292:1: ( ( rule__Class__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:293:1: ( rule__Class__NameAssignment_3 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:294:1: ( rule__Class__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:294:2: rule__Class__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__NameAssignment_3_in_rule__Class__Group__3567);
            rule__Class__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__4_in_rule__Class__Group__3576);
            rule__Class__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__3


    // $ANTLR start rule__Class__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:305:1: rule__Class__Group__4 : ( ( rule__Class__Group_4__0 )? ) rule__Class__Group__5 ;
    public final void rule__Class__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:309:1: ( ( ( rule__Class__Group_4__0 )? ) rule__Class__Group__5 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:310:1: ( ( rule__Class__Group_4__0 )? ) rule__Class__Group__5
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:310:1: ( ( rule__Class__Group_4__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:311:1: ( rule__Class__Group_4__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:312:1: ( rule__Class__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:312:2: rule__Class__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Class__Group_4__0_in_rule__Class__Group__4604);
                    rule__Class__Group_4__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__5_in_rule__Class__Group__4614);
            rule__Class__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__4


    // $ANTLR start rule__Class__Group__5
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:323:1: rule__Class__Group__5 : ( ( rule__Class__Group_5__0 )? ) rule__Class__Group__6 ;
    public final void rule__Class__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:327:1: ( ( ( rule__Class__Group_5__0 )? ) rule__Class__Group__6 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:328:1: ( ( rule__Class__Group_5__0 )? ) rule__Class__Group__6
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:328:1: ( ( rule__Class__Group_5__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:329:1: ( rule__Class__Group_5__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_5()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:330:1: ( rule__Class__Group_5__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:330:2: rule__Class__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Class__Group_5__0_in_rule__Class__Group__5642);
                    rule__Class__Group_5__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__6_in_rule__Class__Group__5652);
            rule__Class__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__5


    // $ANTLR start rule__Class__Group__6
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:341:1: rule__Class__Group__6 : ( '{' ) rule__Class__Group__7 ;
    public final void rule__Class__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:345:1: ( ( '{' ) rule__Class__Group__7 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:346:1: ( '{' ) rule__Class__Group__7
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:346:1: ( '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:347:1: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Class__Group__6681); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__7_in_rule__Class__Group__6691);
            rule__Class__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__6


    // $ANTLR start rule__Class__Group__7
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:361:1: rule__Class__Group__7 : ( ( rule__Class__Group_7__0 )? ) rule__Class__Group__8 ;
    public final void rule__Class__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:365:1: ( ( ( rule__Class__Group_7__0 )? ) rule__Class__Group__8 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:366:1: ( ( rule__Class__Group_7__0 )? ) rule__Class__Group__8
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:366:1: ( ( rule__Class__Group_7__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:367:1: ( rule__Class__Group_7__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_7()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:368:1: ( rule__Class__Group_7__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:368:2: rule__Class__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Class__Group_7__0_in_rule__Class__Group__7719);
                    rule__Class__Group_7__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_7()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__8_in_rule__Class__Group__7729);
            rule__Class__Group__8();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__7


    // $ANTLR start rule__Class__Group__8
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:379:1: rule__Class__Group__8 : ( ( rule__Class__Group_8__0 )? ) rule__Class__Group__9 ;
    public final void rule__Class__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:383:1: ( ( ( rule__Class__Group_8__0 )? ) rule__Class__Group__9 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:384:1: ( ( rule__Class__Group_8__0 )? ) rule__Class__Group__9
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:384:1: ( ( rule__Class__Group_8__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:385:1: ( rule__Class__Group_8__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_8()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:386:1: ( rule__Class__Group_8__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:386:2: rule__Class__Group_8__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Class__Group_8__0_in_rule__Class__Group__8757);
                    rule__Class__Group_8__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_8()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__9_in_rule__Class__Group__8767);
            rule__Class__Group__9();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__8


    // $ANTLR start rule__Class__Group__9
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:397:1: rule__Class__Group__9 : ( ( rule__Class__Group_9__0 )? ) rule__Class__Group__10 ;
    public final void rule__Class__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:401:1: ( ( ( rule__Class__Group_9__0 )? ) rule__Class__Group__10 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:402:1: ( ( rule__Class__Group_9__0 )? ) rule__Class__Group__10
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:402:1: ( ( rule__Class__Group_9__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:403:1: ( rule__Class__Group_9__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_9()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:404:1: ( rule__Class__Group_9__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:404:2: rule__Class__Group_9__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Class__Group_9__0_in_rule__Class__Group__9795);
                    rule__Class__Group_9__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_9()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__10_in_rule__Class__Group__9805);
            rule__Class__Group__10();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__9


    // $ANTLR start rule__Class__Group__10
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:415:1: rule__Class__Group__10 : ( ( rule__Class__AttributesAssignment_10 )* ) rule__Class__Group__11 ;
    public final void rule__Class__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:419:1: ( ( ( rule__Class__AttributesAssignment_10 )* ) rule__Class__Group__11 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:420:1: ( ( rule__Class__AttributesAssignment_10 )* ) rule__Class__Group__11
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:420:1: ( ( rule__Class__AttributesAssignment_10 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:421:1: ( rule__Class__AttributesAssignment_10 )*
            {
             before(grammarAccess.getClassAccess().getAttributesAssignment_10()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:422:1: ( rule__Class__AttributesAssignment_10 )*
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
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:422:2: rule__Class__AttributesAssignment_10
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Class__AttributesAssignment_10_in_rule__Class__Group__10833);
            	    rule__Class__AttributesAssignment_10();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getAttributesAssignment_10()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__11_in_rule__Class__Group__10843);
            rule__Class__Group__11();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__10


    // $ANTLR start rule__Class__Group__11
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:433:1: rule__Class__Group__11 : ( ( rule__Class__OperationsAssignment_11 )* ) rule__Class__Group__12 ;
    public final void rule__Class__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:437:1: ( ( ( rule__Class__OperationsAssignment_11 )* ) rule__Class__Group__12 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:438:1: ( ( rule__Class__OperationsAssignment_11 )* ) rule__Class__Group__12
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:438:1: ( ( rule__Class__OperationsAssignment_11 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:439:1: ( rule__Class__OperationsAssignment_11 )*
            {
             before(grammarAccess.getClassAccess().getOperationsAssignment_11()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:440:1: ( rule__Class__OperationsAssignment_11 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=11 && LA11_0<=14)||LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:440:2: rule__Class__OperationsAssignment_11
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Class__OperationsAssignment_11_in_rule__Class__Group__11871);
            	    rule__Class__OperationsAssignment_11();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getOperationsAssignment_11()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group__12_in_rule__Class__Group__11881);
            rule__Class__Group__12();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group__11


    // $ANTLR start rule__Class__Group__12
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:451:1: rule__Class__Group__12 : ( '}' ) ;
    public final void rule__Class__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:455:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:456:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:456:1: ( '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:457:1: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_12()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Class__Group__12910); 
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
    // $ANTLR end rule__Class__Group__12


    // $ANTLR start rule__Class__Group_4__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:496:1: rule__Class__Group_4__0 : ( 'extends' ) rule__Class__Group_4__1 ;
    public final void rule__Class__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:500:1: ( ( 'extends' ) rule__Class__Group_4__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:501:1: ( 'extends' ) rule__Class__Group_4__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:501:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:502:1: 'extends'
            {
             before(grammarAccess.getClassAccess().getExtendsKeyword_4_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Class__Group_4__0972); 
             after(grammarAccess.getClassAccess().getExtendsKeyword_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_4__1_in_rule__Class__Group_4__0982);
            rule__Class__Group_4__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_4__0


    // $ANTLR start rule__Class__Group_4__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:516:1: rule__Class__Group_4__1 : ( ( rule__Class__SuperClassAssignment_4_1 ) ) ;
    public final void rule__Class__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:520:1: ( ( ( rule__Class__SuperClassAssignment_4_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:521:1: ( ( rule__Class__SuperClassAssignment_4_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:521:1: ( ( rule__Class__SuperClassAssignment_4_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:522:1: ( rule__Class__SuperClassAssignment_4_1 )
            {
             before(grammarAccess.getClassAccess().getSuperClassAssignment_4_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:523:1: ( rule__Class__SuperClassAssignment_4_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:523:2: rule__Class__SuperClassAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__SuperClassAssignment_4_1_in_rule__Class__Group_4__11010);
            rule__Class__SuperClassAssignment_4_1();
            _fsp--;


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
    // $ANTLR end rule__Class__Group_4__1


    // $ANTLR start rule__Class__Group_5__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:537:1: rule__Class__Group_5__0 : ( 'implements' ) rule__Class__Group_5__1 ;
    public final void rule__Class__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:541:1: ( ( 'implements' ) rule__Class__Group_5__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:542:1: ( 'implements' ) rule__Class__Group_5__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:542:1: ( 'implements' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:543:1: 'implements'
            {
             before(grammarAccess.getClassAccess().getImplementsKeyword_5_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Class__Group_5__01049); 
             after(grammarAccess.getClassAccess().getImplementsKeyword_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_5__1_in_rule__Class__Group_5__01059);
            rule__Class__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_5__0


    // $ANTLR start rule__Class__Group_5__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:557:1: rule__Class__Group_5__1 : ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) ) rule__Class__Group_5__2 ;
    public final void rule__Class__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:561:1: ( ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) ) rule__Class__Group_5__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:562:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) ) rule__Class__Group_5__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:562:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:563:1: ( rule__Class__ImplementedInterfacesAssignment_5_1 )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:564:1: ( rule__Class__ImplementedInterfacesAssignment_5_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:564:2: rule__Class__ImplementedInterfacesAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__ImplementedInterfacesAssignment_5_1_in_rule__Class__Group_5__11087);
            rule__Class__ImplementedInterfacesAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_5__2_in_rule__Class__Group_5__11096);
            rule__Class__Group_5__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_5__1


    // $ANTLR start rule__Class__Group_5__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:575:1: rule__Class__Group_5__2 : ( ( rule__Class__Group_5_2__0 )* ) ;
    public final void rule__Class__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:579:1: ( ( ( rule__Class__Group_5_2__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:580:1: ( ( rule__Class__Group_5_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:580:1: ( ( rule__Class__Group_5_2__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:581:1: ( rule__Class__Group_5_2__0 )*
            {
             before(grammarAccess.getClassAccess().getGroup_5_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:582:1: ( rule__Class__Group_5_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==20) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:582:2: rule__Class__Group_5_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Class__Group_5_2__0_in_rule__Class__Group_5__21124);
            	    rule__Class__Group_5_2__0();
            	    _fsp--;


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
    // $ANTLR end rule__Class__Group_5__2


    // $ANTLR start rule__Class__Group_5_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:598:1: rule__Class__Group_5_2__0 : ( ',' ) rule__Class__Group_5_2__1 ;
    public final void rule__Class__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:602:1: ( ( ',' ) rule__Class__Group_5_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:603:1: ( ',' ) rule__Class__Group_5_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:603:1: ( ',' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:604:1: ','
            {
             before(grammarAccess.getClassAccess().getCommaKeyword_5_2_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Class__Group_5_2__01166); 
             after(grammarAccess.getClassAccess().getCommaKeyword_5_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_5_2__1_in_rule__Class__Group_5_2__01176);
            rule__Class__Group_5_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_5_2__0


    // $ANTLR start rule__Class__Group_5_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:618:1: rule__Class__Group_5_2__1 : ( 'implements' ) rule__Class__Group_5_2__2 ;
    public final void rule__Class__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:622:1: ( ( 'implements' ) rule__Class__Group_5_2__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:623:1: ( 'implements' ) rule__Class__Group_5_2__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:623:1: ( 'implements' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:624:1: 'implements'
            {
             before(grammarAccess.getClassAccess().getImplementsKeyword_5_2_1()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Class__Group_5_2__11205); 
             after(grammarAccess.getClassAccess().getImplementsKeyword_5_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_5_2__2_in_rule__Class__Group_5_2__11215);
            rule__Class__Group_5_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_5_2__1


    // $ANTLR start rule__Class__Group_5_2__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:638:1: rule__Class__Group_5_2__2 : ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) ) ;
    public final void rule__Class__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:642:1: ( ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:643:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:643:1: ( ( rule__Class__ImplementedInterfacesAssignment_5_2_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:644:1: ( rule__Class__ImplementedInterfacesAssignment_5_2_2 )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_2_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:645:1: ( rule__Class__ImplementedInterfacesAssignment_5_2_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:645:2: rule__Class__ImplementedInterfacesAssignment_5_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__ImplementedInterfacesAssignment_5_2_2_in_rule__Class__Group_5_2__21243);
            rule__Class__ImplementedInterfacesAssignment_5_2_2();
            _fsp--;


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
    // $ANTLR end rule__Class__Group_5_2__2


    // $ANTLR start rule__Class__Group_7__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:661:1: rule__Class__Group_7__0 : ( 'classNumber' ) rule__Class__Group_7__1 ;
    public final void rule__Class__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:665:1: ( ( 'classNumber' ) rule__Class__Group_7__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:666:1: ( 'classNumber' ) rule__Class__Group_7__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:666:1: ( 'classNumber' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:667:1: 'classNumber'
            {
             before(grammarAccess.getClassAccess().getClassNumberKeyword_7_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Class__Group_7__01284); 
             after(grammarAccess.getClassAccess().getClassNumberKeyword_7_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_7__1_in_rule__Class__Group_7__01294);
            rule__Class__Group_7__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_7__0


    // $ANTLR start rule__Class__Group_7__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:681:1: rule__Class__Group_7__1 : ( '=' ) rule__Class__Group_7__2 ;
    public final void rule__Class__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:685:1: ( ( '=' ) rule__Class__Group_7__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:686:1: ( '=' ) rule__Class__Group_7__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:686:1: ( '=' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:687:1: '='
            {
             before(grammarAccess.getClassAccess().getEqualsSignKeyword_7_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Class__Group_7__11323); 
             after(grammarAccess.getClassAccess().getEqualsSignKeyword_7_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_7__2_in_rule__Class__Group_7__11333);
            rule__Class__Group_7__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_7__1


    // $ANTLR start rule__Class__Group_7__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:701:1: rule__Class__Group_7__2 : ( ( rule__Class__ClassNumberAssignment_7_2 ) ) ;
    public final void rule__Class__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:705:1: ( ( ( rule__Class__ClassNumberAssignment_7_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:706:1: ( ( rule__Class__ClassNumberAssignment_7_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:706:1: ( ( rule__Class__ClassNumberAssignment_7_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:707:1: ( rule__Class__ClassNumberAssignment_7_2 )
            {
             before(grammarAccess.getClassAccess().getClassNumberAssignment_7_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:708:1: ( rule__Class__ClassNumberAssignment_7_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:708:2: rule__Class__ClassNumberAssignment_7_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__ClassNumberAssignment_7_2_in_rule__Class__Group_7__21361);
            rule__Class__ClassNumberAssignment_7_2();
            _fsp--;


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
    // $ANTLR end rule__Class__Group_7__2


    // $ANTLR start rule__Class__Group_8__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:724:1: rule__Class__Group_8__0 : ( 'quid' ) rule__Class__Group_8__1 ;
    public final void rule__Class__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:728:1: ( ( 'quid' ) rule__Class__Group_8__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:729:1: ( 'quid' ) rule__Class__Group_8__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:729:1: ( 'quid' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:730:1: 'quid'
            {
             before(grammarAccess.getClassAccess().getQuidKeyword_8_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Class__Group_8__01402); 
             after(grammarAccess.getClassAccess().getQuidKeyword_8_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_8__1_in_rule__Class__Group_8__01412);
            rule__Class__Group_8__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_8__0


    // $ANTLR start rule__Class__Group_8__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:744:1: rule__Class__Group_8__1 : ( '=' ) rule__Class__Group_8__2 ;
    public final void rule__Class__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:748:1: ( ( '=' ) rule__Class__Group_8__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:749:1: ( '=' ) rule__Class__Group_8__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:749:1: ( '=' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:750:1: '='
            {
             before(grammarAccess.getClassAccess().getEqualsSignKeyword_8_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Class__Group_8__11441); 
             after(grammarAccess.getClassAccess().getEqualsSignKeyword_8_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_8__2_in_rule__Class__Group_8__11451);
            rule__Class__Group_8__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_8__1


    // $ANTLR start rule__Class__Group_8__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:764:1: rule__Class__Group_8__2 : ( ( rule__Class__QuidAssignment_8_2 ) ) ;
    public final void rule__Class__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:768:1: ( ( ( rule__Class__QuidAssignment_8_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:769:1: ( ( rule__Class__QuidAssignment_8_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:769:1: ( ( rule__Class__QuidAssignment_8_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:770:1: ( rule__Class__QuidAssignment_8_2 )
            {
             before(grammarAccess.getClassAccess().getQuidAssignment_8_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:771:1: ( rule__Class__QuidAssignment_8_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:771:2: rule__Class__QuidAssignment_8_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__QuidAssignment_8_2_in_rule__Class__Group_8__21479);
            rule__Class__QuidAssignment_8_2();
            _fsp--;


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
    // $ANTLR end rule__Class__Group_8__2


    // $ANTLR start rule__Class__Group_9__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:787:1: rule__Class__Group_9__0 : ( 'documentation' ) rule__Class__Group_9__1 ;
    public final void rule__Class__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:791:1: ( ( 'documentation' ) rule__Class__Group_9__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:792:1: ( 'documentation' ) rule__Class__Group_9__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:792:1: ( 'documentation' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:793:1: 'documentation'
            {
             before(grammarAccess.getClassAccess().getDocumentationKeyword_9_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Class__Group_9__01520); 
             after(grammarAccess.getClassAccess().getDocumentationKeyword_9_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_9__1_in_rule__Class__Group_9__01530);
            rule__Class__Group_9__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_9__0


    // $ANTLR start rule__Class__Group_9__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:807:1: rule__Class__Group_9__1 : ( '=' ) rule__Class__Group_9__2 ;
    public final void rule__Class__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:811:1: ( ( '=' ) rule__Class__Group_9__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:812:1: ( '=' ) rule__Class__Group_9__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:812:1: ( '=' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:813:1: '='
            {
             before(grammarAccess.getClassAccess().getEqualsSignKeyword_9_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Class__Group_9__11559); 
             after(grammarAccess.getClassAccess().getEqualsSignKeyword_9_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Class__Group_9__2_in_rule__Class__Group_9__11569);
            rule__Class__Group_9__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_9__1


    // $ANTLR start rule__Class__Group_9__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:827:1: rule__Class__Group_9__2 : ( ( rule__Class__DocumentationAssignment_9_2 ) ) ;
    public final void rule__Class__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:831:1: ( ( ( rule__Class__DocumentationAssignment_9_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:832:1: ( ( rule__Class__DocumentationAssignment_9_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:832:1: ( ( rule__Class__DocumentationAssignment_9_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:833:1: ( rule__Class__DocumentationAssignment_9_2 )
            {
             before(grammarAccess.getClassAccess().getDocumentationAssignment_9_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:834:1: ( rule__Class__DocumentationAssignment_9_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:834:2: rule__Class__DocumentationAssignment_9_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Class__DocumentationAssignment_9_2_in_rule__Class__Group_9__21597);
            rule__Class__DocumentationAssignment_9_2();
            _fsp--;


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
    // $ANTLR end rule__Class__Group_9__2


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:850:1: rule__Attribute__Group__0 : ( ( rule__Attribute__VisibilityAssignment_0 )? ) rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:854:1: ( ( ( rule__Attribute__VisibilityAssignment_0 )? ) rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:855:1: ( ( rule__Attribute__VisibilityAssignment_0 )? ) rule__Attribute__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:855:1: ( ( rule__Attribute__VisibilityAssignment_0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:856:1: ( rule__Attribute__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:857:1: ( rule__Attribute__VisibilityAssignment_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=11 && LA13_0<=14)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:857:2: rule__Attribute__VisibilityAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute__VisibilityAssignment_0_in_rule__Attribute__Group__01637);
                    rule__Attribute__VisibilityAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getVisibilityAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01647);
            rule__Attribute__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group__0


    // $ANTLR start rule__Attribute__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:868:1: rule__Attribute__Group__1 : ( 'attribute' ) rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:872:1: ( ( 'attribute' ) rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:873:1: ( 'attribute' ) rule__Attribute__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:873:1: ( 'attribute' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:874:1: 'attribute'
            {
             before(grammarAccess.getAttributeAccess().getAttributeKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Attribute__Group__11676); 
             after(grammarAccess.getAttributeAccess().getAttributeKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11686);
            rule__Attribute__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group__1


    // $ANTLR start rule__Attribute__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:888:1: rule__Attribute__Group__2 : ( ( rule__Attribute__NameAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:892:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:893:1: ( ( rule__Attribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:893:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:894:1: ( rule__Attribute__NameAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:895:1: ( rule__Attribute__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:895:2: rule__Attribute__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__NameAssignment_2_in_rule__Attribute__Group__21714);
            rule__Attribute__NameAssignment_2();
            _fsp--;


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
    // $ANTLR end rule__Attribute__Group__2


    // $ANTLR start rule__Operation__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:911:1: rule__Operation__Group__0 : ( ( rule__Operation__VisibilityAssignment_0 )? ) rule__Operation__Group__1 ;
    public final void rule__Operation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:915:1: ( ( ( rule__Operation__VisibilityAssignment_0 )? ) rule__Operation__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:916:1: ( ( rule__Operation__VisibilityAssignment_0 )? ) rule__Operation__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:916:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:917:1: ( rule__Operation__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:918:1: ( rule__Operation__VisibilityAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=11 && LA14_0<=14)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:918:2: rule__Operation__VisibilityAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Operation__VisibilityAssignment_0_in_rule__Operation__Group__01754);
                    rule__Operation__VisibilityAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__1_in_rule__Operation__Group__01764);
            rule__Operation__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__0


    // $ANTLR start rule__Operation__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:929:1: rule__Operation__Group__1 : ( 'operation' ) rule__Operation__Group__2 ;
    public final void rule__Operation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:933:1: ( ( 'operation' ) rule__Operation__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:934:1: ( 'operation' ) rule__Operation__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:934:1: ( 'operation' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:935:1: 'operation'
            {
             before(grammarAccess.getOperationAccess().getOperationKeyword_1()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Operation__Group__11793); 
             after(grammarAccess.getOperationAccess().getOperationKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__2_in_rule__Operation__Group__11803);
            rule__Operation__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__1


    // $ANTLR start rule__Operation__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:949:1: rule__Operation__Group__2 : ( ( rule__Operation__NameAssignment_2 ) ) ;
    public final void rule__Operation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:953:1: ( ( ( rule__Operation__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:954:1: ( ( rule__Operation__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:954:1: ( ( rule__Operation__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:955:1: ( rule__Operation__NameAssignment_2 )
            {
             before(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:956:1: ( rule__Operation__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:956:2: rule__Operation__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__NameAssignment_2_in_rule__Operation__Group__21831);
            rule__Operation__NameAssignment_2();
            _fsp--;


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
    // $ANTLR end rule__Operation__Group__2


    // $ANTLR start rule__Model__ClassesAssignment
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:972:1: rule__Model__ClassesAssignment : ( ruleClass ) ;
    public final void rule__Model__ClassesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:976:1: ( ( ruleClass ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:977:1: ( ruleClass )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:977:1: ( ruleClass )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:978:1: ruleClass
            {
             before(grammarAccess.getModelAccess().getClassesClassParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleClass_in_rule__Model__ClassesAssignment1871);
            ruleClass();
            _fsp--;

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
    // $ANTLR end rule__Model__ClassesAssignment


    // $ANTLR start rule__Class__AbstractAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:987:1: rule__Class__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__Class__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:991:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:992:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:992:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:993:1: ( 'abstract' )
            {
             before(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:994:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:995:1: 'abstract'
            {
             before(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Class__AbstractAssignment_01907); 
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
    // $ANTLR end rule__Class__AbstractAssignment_0


    // $ANTLR start rule__Class__TransientAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1010:1: rule__Class__TransientAssignment_1 : ( ( 'transient' ) ) ;
    public final void rule__Class__TransientAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1014:1: ( ( ( 'transient' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1015:1: ( ( 'transient' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1015:1: ( ( 'transient' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1016:1: ( 'transient' )
            {
             before(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1017:1: ( 'transient' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1018:1: 'transient'
            {
             before(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Class__TransientAssignment_11951); 
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
    // $ANTLR end rule__Class__TransientAssignment_1


    // $ANTLR start rule__Class__NameAssignment_3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1033:1: rule__Class__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Class__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1037:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1038:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1038:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1039:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Class__NameAssignment_31990); 
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
    // $ANTLR end rule__Class__NameAssignment_3


    // $ANTLR start rule__Class__SuperClassAssignment_4_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1048:1: rule__Class__SuperClassAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperClassAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1052:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1053:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1053:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1054:1: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_4_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1055:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1056:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Class__SuperClassAssignment_4_12025); 
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
    // $ANTLR end rule__Class__SuperClassAssignment_4_1


    // $ANTLR start rule__Class__ImplementedInterfacesAssignment_5_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1067:1: rule__Class__ImplementedInterfacesAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__ImplementedInterfacesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1071:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1072:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1072:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1073:1: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1074:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1075:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Class__ImplementedInterfacesAssignment_5_12064); 
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
    // $ANTLR end rule__Class__ImplementedInterfacesAssignment_5_1


    // $ANTLR start rule__Class__ImplementedInterfacesAssignment_5_2_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1086:1: rule__Class__ImplementedInterfacesAssignment_5_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__Class__ImplementedInterfacesAssignment_5_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1090:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1091:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1091:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1092:1: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_2_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1093:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1094:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getImplementedInterfacesClassIDTerminalRuleCall_5_2_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Class__ImplementedInterfacesAssignment_5_2_22103); 
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
    // $ANTLR end rule__Class__ImplementedInterfacesAssignment_5_2_2


    // $ANTLR start rule__Class__ClassNumberAssignment_7_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1105:1: rule__Class__ClassNumberAssignment_7_2 : ( RULE_INT ) ;
    public final void rule__Class__ClassNumberAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1109:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1110:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1110:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1111:1: RULE_INT
            {
             before(grammarAccess.getClassAccess().getClassNumberINTTerminalRuleCall_7_2_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Class__ClassNumberAssignment_7_22138); 
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
    // $ANTLR end rule__Class__ClassNumberAssignment_7_2


    // $ANTLR start rule__Class__QuidAssignment_8_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1120:1: rule__Class__QuidAssignment_8_2 : ( RULE_INT ) ;
    public final void rule__Class__QuidAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1124:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1125:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1125:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1126:1: RULE_INT
            {
             before(grammarAccess.getClassAccess().getQuidINTTerminalRuleCall_8_2_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Class__QuidAssignment_8_22169); 
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
    // $ANTLR end rule__Class__QuidAssignment_8_2


    // $ANTLR start rule__Class__DocumentationAssignment_9_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1135:1: rule__Class__DocumentationAssignment_9_2 : ( RULE_STRING ) ;
    public final void rule__Class__DocumentationAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1139:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1140:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1140:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1141:1: RULE_STRING
            {
             before(grammarAccess.getClassAccess().getDocumentationSTRINGTerminalRuleCall_9_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Class__DocumentationAssignment_9_22200); 
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
    // $ANTLR end rule__Class__DocumentationAssignment_9_2


    // $ANTLR start rule__Class__AttributesAssignment_10
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1150:1: rule__Class__AttributesAssignment_10 : ( ruleAttribute ) ;
    public final void rule__Class__AttributesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1154:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1155:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1155:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1156:1: ruleAttribute
            {
             before(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Class__AttributesAssignment_102231);
            ruleAttribute();
            _fsp--;

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
    // $ANTLR end rule__Class__AttributesAssignment_10


    // $ANTLR start rule__Class__OperationsAssignment_11
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1165:1: rule__Class__OperationsAssignment_11 : ( ruleOperation ) ;
    public final void rule__Class__OperationsAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1169:1: ( ( ruleOperation ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1170:1: ( ruleOperation )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1170:1: ( ruleOperation )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1171:1: ruleOperation
            {
             before(grammarAccess.getClassAccess().getOperationsOperationParserRuleCall_11_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_in_rule__Class__OperationsAssignment_112262);
            ruleOperation();
            _fsp--;

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
    // $ANTLR end rule__Class__OperationsAssignment_11


    // $ANTLR start rule__Attribute__VisibilityAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1180:1: rule__Attribute__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Attribute__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1184:1: ( ( ruleVisibility ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1185:1: ( ruleVisibility )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1185:1: ( ruleVisibility )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1186:1: ruleVisibility
            {
             before(grammarAccess.getAttributeAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_rule__Attribute__VisibilityAssignment_02293);
            ruleVisibility();
            _fsp--;

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
    // $ANTLR end rule__Attribute__VisibilityAssignment_0


    // $ANTLR start rule__Attribute__NameAssignment_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1195:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1199:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1200:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1200:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1201:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_22324); 
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
    // $ANTLR end rule__Attribute__NameAssignment_2


    // $ANTLR start rule__Operation__VisibilityAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1210:1: rule__Operation__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Operation__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1214:1: ( ( ruleVisibility ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1215:1: ( ruleVisibility )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1215:1: ( ruleVisibility )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1216:1: ruleVisibility
            {
             before(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_rule__Operation__VisibilityAssignment_02355);
            ruleVisibility();
            _fsp--;

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
    // $ANTLR end rule__Operation__VisibilityAssignment_0


    // $ANTLR start rule__Operation__NameAssignment_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1225:1: rule__Operation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1229:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1230:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1230:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug289187TestLanguage.g:1231:1: RULE_ID
            {
             before(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation__NameAssignment_22386); 
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
    // $ANTLR end rule__Operation__NameAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ClassesAssignment_in_ruleModel95 = new BitSet(new long[]{0x0000000018008002L});
        public static final BitSet FOLLOW_ruleClass_in_entryRuleClass123 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleClass130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__Group__0_in_ruleClass157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation245 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__0_in_ruleOperation279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Visibility__Alternatives_in_ruleVisibility316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Visibility__Alternatives352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Visibility__Alternatives373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Visibility__Alternatives394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Visibility__Alternatives415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__AbstractAssignment_0_in_rule__Class__Group__0452 = new BitSet(new long[]{0x0000000010008000L});
        public static final BitSet FOLLOW_rule__Class__Group__1_in_rule__Class__Group__0462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__TransientAssignment_1_in_rule__Class__Group__1490 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Class__Group__2_in_rule__Class__Group__1500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Class__Group__2529 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Class__Group__3_in_rule__Class__Group__2539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__NameAssignment_3_in_rule__Class__Group__3567 = new BitSet(new long[]{0x00000000000D0000L});
        public static final BitSet FOLLOW_rule__Class__Group__4_in_rule__Class__Group__3576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__Group_4__0_in_rule__Class__Group__4604 = new BitSet(new long[]{0x0000000000090000L});
        public static final BitSet FOLLOW_rule__Class__Group__5_in_rule__Class__Group__4614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__Group_5__0_in_rule__Class__Group__5642 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Class__Group__6_in_rule__Class__Group__5652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Class__Group__6681 = new BitSet(new long[]{0x0000000007A27800L});
        public static final BitSet FOLLOW_rule__Class__Group__7_in_rule__Class__Group__6691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__Group_7__0_in_rule__Class__Group__7719 = new BitSet(new long[]{0x0000000007827800L});
        public static final BitSet FOLLOW_rule__Class__Group__8_in_rule__Class__Group__7729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__Group_8__0_in_rule__Class__Group__8757 = new BitSet(new long[]{0x0000000007027800L});
        public static final BitSet FOLLOW_rule__Class__Group__9_in_rule__Class__Group__8767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__Group_9__0_in_rule__Class__Group__9795 = new BitSet(new long[]{0x0000000006027800L});
        public static final BitSet FOLLOW_rule__Class__Group__10_in_rule__Class__Group__9805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__AttributesAssignment_10_in_rule__Class__Group__10833 = new BitSet(new long[]{0x0000000006027800L});
        public static final BitSet FOLLOW_rule__Class__Group__11_in_rule__Class__Group__10843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__OperationsAssignment_11_in_rule__Class__Group__11871 = new BitSet(new long[]{0x0000000004027800L});
        public static final BitSet FOLLOW_rule__Class__Group__12_in_rule__Class__Group__11881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Class__Group__12910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Class__Group_4__0972 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Class__Group_4__1_in_rule__Class__Group_4__0982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__SuperClassAssignment_4_1_in_rule__Class__Group_4__11010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Class__Group_5__01049 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Class__Group_5__1_in_rule__Class__Group_5__01059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__ImplementedInterfacesAssignment_5_1_in_rule__Class__Group_5__11087 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_rule__Class__Group_5__2_in_rule__Class__Group_5__11096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__Group_5_2__0_in_rule__Class__Group_5__21124 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_rule__Class__Group_5_2__01166 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Class__Group_5_2__1_in_rule__Class__Group_5_2__01176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Class__Group_5_2__11205 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Class__Group_5_2__2_in_rule__Class__Group_5_2__11215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__ImplementedInterfacesAssignment_5_2_2_in_rule__Class__Group_5_2__21243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Class__Group_7__01284 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Class__Group_7__1_in_rule__Class__Group_7__01294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Class__Group_7__11323 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Class__Group_7__2_in_rule__Class__Group_7__11333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__ClassNumberAssignment_7_2_in_rule__Class__Group_7__21361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Class__Group_8__01402 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Class__Group_8__1_in_rule__Class__Group_8__01412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Class__Group_8__11441 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Class__Group_8__2_in_rule__Class__Group_8__11451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__QuidAssignment_8_2_in_rule__Class__Group_8__21479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Class__Group_9__01520 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Class__Group_9__1_in_rule__Class__Group_9__01530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Class__Group_9__11559 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Class__Group_9__2_in_rule__Class__Group_9__11569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Class__DocumentationAssignment_9_2_in_rule__Class__Group_9__21597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__VisibilityAssignment_0_in_rule__Attribute__Group__01637 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Attribute__Group__11676 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__NameAssignment_2_in_rule__Attribute__Group__21714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__VisibilityAssignment_0_in_rule__Operation__Group__01754 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Operation__Group__1_in_rule__Operation__Group__01764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Operation__Group__11793 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation__Group__2_in_rule__Operation__Group__11803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__NameAssignment_2_in_rule__Operation__Group__21831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleClass_in_rule__Model__ClassesAssignment1871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Class__AbstractAssignment_01907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Class__TransientAssignment_11951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Class__NameAssignment_31990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Class__SuperClassAssignment_4_12025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Class__ImplementedInterfacesAssignment_5_12064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Class__ImplementedInterfacesAssignment_5_2_22103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Class__ClassNumberAssignment_7_22138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Class__QuidAssignment_8_22169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Class__DocumentationAssignment_9_22200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Class__AttributesAssignment_102231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_in_rule__Class__OperationsAssignment_112262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_rule__Attribute__VisibilityAssignment_02293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_22324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_rule__Operation__VisibilityAssignment_02355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation__NameAssignment_22386 = new BitSet(new long[]{0x0000000000000002L});
    }


}