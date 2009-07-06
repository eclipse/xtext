package org.eclipse.xtext.grammarinheritance.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalAbstractTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_REAL", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=7;
    public static final int RULE_REAL=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalAbstractTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g"; }


     
     	private AbstractTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(AbstractTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleInheritedParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:55:1: entryRuleInheritedParserRule : ruleInheritedParserRule EOF ;
    public final void entryRuleInheritedParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:55:30: ( ruleInheritedParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:56:1: ruleInheritedParserRule EOF
            {
             before(grammarAccess.getInheritedParserRuleRule()); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule60);
            ruleInheritedParserRule();
            _fsp--;

             after(grammarAccess.getInheritedParserRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule67); 

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
    // $ANTLR end entryRuleInheritedParserRule


    // $ANTLR start ruleInheritedParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:63:1: ruleInheritedParserRule : ( ( rule__InheritedParserRule__Group__0 ) ) ;
    public final void ruleInheritedParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:67:2: ( ( ( rule__InheritedParserRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:68:1: ( ( rule__InheritedParserRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:68:1: ( ( rule__InheritedParserRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:69:1: ( rule__InheritedParserRule__Group__0 )
            {
             before(grammarAccess.getInheritedParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:70:1: ( rule__InheritedParserRule__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:70:2: rule__InheritedParserRule__Group__0
            {
            pushFollow(FOLLOW_rule__InheritedParserRule__Group__0_in_ruleInheritedParserRule94);
            rule__InheritedParserRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getInheritedParserRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleInheritedParserRule


    // $ANTLR start entryRuleOverridableParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:84:1: entryRuleOverridableParserRule : ruleOverridableParserRule EOF ;
    public final void entryRuleOverridableParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:84:32: ( ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:85:1: ruleOverridableParserRule EOF
            {
             before(grammarAccess.getOverridableParserRuleRule()); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule122);
            ruleOverridableParserRule();
            _fsp--;

             after(grammarAccess.getOverridableParserRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule129); 

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
    // $ANTLR end entryRuleOverridableParserRule


    // $ANTLR start ruleOverridableParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:92:1: ruleOverridableParserRule : ( ( rule__OverridableParserRule__Group__0 ) ) ;
    public final void ruleOverridableParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:96:2: ( ( ( rule__OverridableParserRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:97:1: ( ( rule__OverridableParserRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:97:1: ( ( rule__OverridableParserRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:98:1: ( rule__OverridableParserRule__Group__0 )
            {
             before(grammarAccess.getOverridableParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:99:1: ( rule__OverridableParserRule__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:99:2: rule__OverridableParserRule__Group__0
            {
            pushFollow(FOLLOW_rule__OverridableParserRule__Group__0_in_ruleOverridableParserRule156);
            rule__OverridableParserRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getOverridableParserRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleOverridableParserRule


    // $ANTLR start entryRuleExtendableParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:115:1: entryRuleExtendableParserRule : ruleExtendableParserRule EOF ;
    public final void entryRuleExtendableParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:115:31: ( ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:116:1: ruleExtendableParserRule EOF
            {
             before(grammarAccess.getExtendableParserRuleRule()); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule186);
            ruleExtendableParserRule();
            _fsp--;

             after(grammarAccess.getExtendableParserRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule193); 

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
    // $ANTLR end entryRuleExtendableParserRule


    // $ANTLR start ruleExtendableParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:123:1: ruleExtendableParserRule : ( ( rule__ExtendableParserRule__Group__0 ) ) ;
    public final void ruleExtendableParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:127:2: ( ( ( rule__ExtendableParserRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:128:1: ( ( rule__ExtendableParserRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:128:1: ( ( rule__ExtendableParserRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:129:1: ( rule__ExtendableParserRule__Group__0 )
            {
             before(grammarAccess.getExtendableParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:130:1: ( rule__ExtendableParserRule__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:130:2: rule__ExtendableParserRule__Group__0
            {
            pushFollow(FOLLOW_rule__ExtendableParserRule__Group__0_in_ruleExtendableParserRule220);
            rule__ExtendableParserRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getExtendableParserRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleExtendableParserRule


    // $ANTLR start rule__InheritedParserRule__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:144:1: rule__InheritedParserRule__Group__0 : ( 'element' ) rule__InheritedParserRule__Group__1 ;
    public final void rule__InheritedParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:148:1: ( ( 'element' ) rule__InheritedParserRule__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:149:1: ( 'element' ) rule__InheritedParserRule__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:149:1: ( 'element' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:150:1: 'element'
            {
             before(grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__InheritedParserRule__Group__0259); 
             after(grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__InheritedParserRule__Group__1_in_rule__InheritedParserRule__Group__0269);
            rule__InheritedParserRule__Group__1();
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
    // $ANTLR end rule__InheritedParserRule__Group__0


    // $ANTLR start rule__InheritedParserRule__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:164:1: rule__InheritedParserRule__Group__1 : ( ( rule__InheritedParserRule__NameAssignment_1 ) ) ;
    public final void rule__InheritedParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:168:1: ( ( ( rule__InheritedParserRule__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:169:1: ( ( rule__InheritedParserRule__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:169:1: ( ( rule__InheritedParserRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:170:1: ( rule__InheritedParserRule__NameAssignment_1 )
            {
             before(grammarAccess.getInheritedParserRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:171:1: ( rule__InheritedParserRule__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:171:2: rule__InheritedParserRule__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__InheritedParserRule__NameAssignment_1_in_rule__InheritedParserRule__Group__1297);
            rule__InheritedParserRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getInheritedParserRuleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__InheritedParserRule__Group__1


    // $ANTLR start rule__OverridableParserRule__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:186:1: rule__OverridableParserRule__Group__0 : ( 'element' ) rule__OverridableParserRule__Group__1 ;
    public final void rule__OverridableParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:190:1: ( ( 'element' ) rule__OverridableParserRule__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:191:1: ( 'element' ) rule__OverridableParserRule__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:191:1: ( 'element' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:192:1: 'element'
            {
             before(grammarAccess.getOverridableParserRuleAccess().getElementKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__OverridableParserRule__Group__0337); 
             after(grammarAccess.getOverridableParserRuleAccess().getElementKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__OverridableParserRule__Group__1_in_rule__OverridableParserRule__Group__0347);
            rule__OverridableParserRule__Group__1();
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
    // $ANTLR end rule__OverridableParserRule__Group__0


    // $ANTLR start rule__OverridableParserRule__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:206:1: rule__OverridableParserRule__Group__1 : ( ( rule__OverridableParserRule__NameAssignment_1 ) ) ;
    public final void rule__OverridableParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:210:1: ( ( ( rule__OverridableParserRule__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:211:1: ( ( rule__OverridableParserRule__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:211:1: ( ( rule__OverridableParserRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:212:1: ( rule__OverridableParserRule__NameAssignment_1 )
            {
             before(grammarAccess.getOverridableParserRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:213:1: ( rule__OverridableParserRule__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:213:2: rule__OverridableParserRule__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__OverridableParserRule__NameAssignment_1_in_rule__OverridableParserRule__Group__1375);
            rule__OverridableParserRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getOverridableParserRuleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OverridableParserRule__Group__1


    // $ANTLR start rule__ExtendableParserRule__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:229:1: rule__ExtendableParserRule__Group__0 : ( 'element' ) rule__ExtendableParserRule__Group__1 ;
    public final void rule__ExtendableParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:233:1: ( ( 'element' ) rule__ExtendableParserRule__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:234:1: ( 'element' ) rule__ExtendableParserRule__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:234:1: ( 'element' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:235:1: 'element'
            {
             before(grammarAccess.getExtendableParserRuleAccess().getElementKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__ExtendableParserRule__Group__0416); 
             after(grammarAccess.getExtendableParserRuleAccess().getElementKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ExtendableParserRule__Group__1_in_rule__ExtendableParserRule__Group__0426);
            rule__ExtendableParserRule__Group__1();
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
    // $ANTLR end rule__ExtendableParserRule__Group__0


    // $ANTLR start rule__ExtendableParserRule__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:249:1: rule__ExtendableParserRule__Group__1 : ( ( rule__ExtendableParserRule__NameAssignment_1 ) ) ;
    public final void rule__ExtendableParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:253:1: ( ( ( rule__ExtendableParserRule__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:254:1: ( ( rule__ExtendableParserRule__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:254:1: ( ( rule__ExtendableParserRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:255:1: ( rule__ExtendableParserRule__NameAssignment_1 )
            {
             before(grammarAccess.getExtendableParserRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:256:1: ( rule__ExtendableParserRule__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:256:2: rule__ExtendableParserRule__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ExtendableParserRule__NameAssignment_1_in_rule__ExtendableParserRule__Group__1454);
            rule__ExtendableParserRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getExtendableParserRuleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExtendableParserRule__Group__1


    // $ANTLR start rule__InheritedParserRule__NameAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:270:1: rule__InheritedParserRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__InheritedParserRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:274:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:275:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:275:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:276:1: RULE_ID
            {
             before(grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__InheritedParserRule__NameAssignment_1492); 
             after(grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__InheritedParserRule__NameAssignment_1


    // $ANTLR start rule__OverridableParserRule__NameAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:286:1: rule__OverridableParserRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OverridableParserRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:290:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:291:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:291:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:292:1: RULE_ID
            {
             before(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OverridableParserRule__NameAssignment_1524); 
             after(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OverridableParserRule__NameAssignment_1


    // $ANTLR start rule__ExtendableParserRule__NameAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:303:1: rule__ExtendableParserRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ExtendableParserRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:307:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:308:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:308:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:309:1: RULE_ID
            {
             before(grammarAccess.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExtendableParserRule__NameAssignment_1557); 
             after(grammarAccess.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExtendableParserRule__NameAssignment_1


 

    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InheritedParserRule__Group__0_in_ruleInheritedParserRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OverridableParserRule__Group__0_in_ruleOverridableParserRule156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtendableParserRule__Group__0_in_ruleExtendableParserRule220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__InheritedParserRule__Group__0259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__InheritedParserRule__Group__1_in_rule__InheritedParserRule__Group__0269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InheritedParserRule__NameAssignment_1_in_rule__InheritedParserRule__Group__1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__OverridableParserRule__Group__0337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OverridableParserRule__Group__1_in_rule__OverridableParserRule__Group__0347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OverridableParserRule__NameAssignment_1_in_rule__OverridableParserRule__Group__1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ExtendableParserRule__Group__0416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExtendableParserRule__Group__1_in_rule__ExtendableParserRule__Group__0426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtendableParserRule__NameAssignment_1_in_rule__ExtendableParserRule__Group__1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__InheritedParserRule__NameAssignment_1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OverridableParserRule__NameAssignment_1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExtendableParserRule__NameAssignment_1557 = new BitSet(new long[]{0x0000000000000002L});

}