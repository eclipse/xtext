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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:63:1: ruleInheritedParserRule : ( ( rule__InheritedParserRule__Group ) ) ;
    public final void ruleInheritedParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:67:2: ( ( ( rule__InheritedParserRule__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:68:1: ( ( rule__InheritedParserRule__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:68:1: ( ( rule__InheritedParserRule__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:69:1: ( rule__InheritedParserRule__Group )
            {
             before(grammarAccess.getInheritedParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:70:1: ( rule__InheritedParserRule__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:70:2: rule__InheritedParserRule__Group
            {
            pushFollow(FOLLOW_rule__InheritedParserRule__Group_in_ruleInheritedParserRule94);
            rule__InheritedParserRule__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:83:1: entryRuleOverridableParserRule : ruleOverridableParserRule EOF ;
    public final void entryRuleOverridableParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:83:32: ( ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:84:1: ruleOverridableParserRule EOF
            {
             before(grammarAccess.getOverridableParserRuleRule()); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule121);
            ruleOverridableParserRule();
            _fsp--;

             after(grammarAccess.getOverridableParserRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule128); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:91:1: ruleOverridableParserRule : ( ( rule__OverridableParserRule__Group ) ) ;
    public final void ruleOverridableParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:95:2: ( ( ( rule__OverridableParserRule__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:96:1: ( ( rule__OverridableParserRule__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:96:1: ( ( rule__OverridableParserRule__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:97:1: ( rule__OverridableParserRule__Group )
            {
             before(grammarAccess.getOverridableParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:98:1: ( rule__OverridableParserRule__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:98:2: rule__OverridableParserRule__Group
            {
            pushFollow(FOLLOW_rule__OverridableParserRule__Group_in_ruleOverridableParserRule155);
            rule__OverridableParserRule__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:113:1: entryRuleExtendableParserRule : ruleExtendableParserRule EOF ;
    public final void entryRuleExtendableParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:113:31: ( ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:114:1: ruleExtendableParserRule EOF
            {
             before(grammarAccess.getExtendableParserRuleRule()); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule184);
            ruleExtendableParserRule();
            _fsp--;

             after(grammarAccess.getExtendableParserRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule191); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:121:1: ruleExtendableParserRule : ( ( rule__ExtendableParserRule__Group ) ) ;
    public final void ruleExtendableParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:125:2: ( ( ( rule__ExtendableParserRule__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:126:1: ( ( rule__ExtendableParserRule__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:126:1: ( ( rule__ExtendableParserRule__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:127:1: ( rule__ExtendableParserRule__Group )
            {
             before(grammarAccess.getExtendableParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:128:1: ( rule__ExtendableParserRule__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:128:2: rule__ExtendableParserRule__Group
            {
            pushFollow(FOLLOW_rule__ExtendableParserRule__Group_in_ruleExtendableParserRule218);
            rule__ExtendableParserRule__Group();
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


    // $ANTLR start rule__InheritedParserRule__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:140:1: rule__InheritedParserRule__Group : ( 'element' ) ( ( ( RULE_ID ) ) ) ;
    public final void rule__InheritedParserRule__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:144:1: ( ( 'element' ) ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:145:1: ( 'element' ) ( ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:145:1: ( 'element' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:146:1: 'element'
            {
             before(grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__InheritedParserRule__Group255); 
             after(grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:151:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:152:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getInheritedParserRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:153:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:154:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:154:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:155:1: RULE_ID
            {
             before(grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__InheritedParserRule__Group274); 
             after(grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


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
    // $ANTLR end rule__InheritedParserRule__Group


    // $ANTLR start rule__OverridableParserRule__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:168:1: rule__OverridableParserRule__Group : ( 'element' ) ( ( ( RULE_ID ) ) ) ;
    public final void rule__OverridableParserRule__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:172:1: ( ( 'element' ) ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:173:1: ( 'element' ) ( ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:173:1: ( 'element' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:174:1: 'element'
            {
             before(grammarAccess.getOverridableParserRuleAccess().getElementKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__OverridableParserRule__Group314); 
             after(grammarAccess.getOverridableParserRuleAccess().getElementKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:179:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:180:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getOverridableParserRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:181:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:182:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:182:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:183:1: RULE_ID
            {
             before(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OverridableParserRule__Group333); 
             after(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


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
    // $ANTLR end rule__OverridableParserRule__Group


    // $ANTLR start rule__ExtendableParserRule__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:197:1: rule__ExtendableParserRule__Group : ( 'element' ) ( ( ( RULE_ID ) ) ) ;
    public final void rule__ExtendableParserRule__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:201:1: ( ( 'element' ) ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:202:1: ( 'element' ) ( ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:202:1: ( 'element' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:203:1: 'element'
            {
             before(grammarAccess.getExtendableParserRuleAccess().getElementKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__ExtendableParserRule__Group374); 
             after(grammarAccess.getExtendableParserRuleAccess().getElementKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:208:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:209:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getExtendableParserRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:210:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:211:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:211:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/contentassist/antlr/internal/InternalAbstractTestLanguage.g:212:1: RULE_ID
            {
             before(grammarAccess.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExtendableParserRule__Group393); 
             after(grammarAccess.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


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
    // $ANTLR end rule__ExtendableParserRule__Group


 

    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InheritedParserRule__Group_in_ruleInheritedParserRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OverridableParserRule__Group_in_ruleOverridableParserRule155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExtendableParserRule__Group_in_ruleExtendableParserRule218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__InheritedParserRule__Group255 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__InheritedParserRule__Group274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__OverridableParserRule__Group314 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OverridableParserRule__Group333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ExtendableParserRule__Group374 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExtendableParserRule__Group393 = new BitSet(new long[]{0x0000000000000002L});

}