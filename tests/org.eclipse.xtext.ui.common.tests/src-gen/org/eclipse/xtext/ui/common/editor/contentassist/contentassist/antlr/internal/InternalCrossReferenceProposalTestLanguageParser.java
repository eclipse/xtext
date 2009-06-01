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
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCrossReferenceProposalTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'<-'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g"; }


     
     	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:55:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:55:16: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:56:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:63:1: ruleModel : ( ( ( ruleClass ) )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:67:2: ( ( ( ( ruleClass ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:68:1: ( ( ( ruleClass ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:68:1: ( ( ( ruleClass ) )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:69:1: ( ( ruleClass ) )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:70:1: ( ( ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:71:1: ( ruleClass )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:71:1: ( ruleClass )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:72:1: ruleClass
            	    {
            	     before(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); 
            	    pushFollow(FOLLOW_ruleClass_in_ruleModel101);
            	    ruleClass();
            	    _fsp--;

            	     after(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:87:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:87:16: ( ruleClass EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:88:1: ruleClass EOF
            {
             before(grammarAccess.getClassRule()); 
            pushFollow(FOLLOW_ruleClass_in_entryRuleClass133);
            ruleClass();
            _fsp--;

             after(grammarAccess.getClassRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClass140); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:95:1: ruleClass : ( ( rule__Class__Group ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:99:2: ( ( ( rule__Class__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:100:1: ( ( rule__Class__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:100:1: ( ( rule__Class__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:101:1: ( rule__Class__Group )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:102:1: ( rule__Class__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:102:2: rule__Class__Group
            {
            pushFollow(FOLLOW_rule__Class__Group_in_ruleClass167);
            rule__Class__Group();
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


    // $ANTLR start rule__Class__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:114:1: rule__Class__Group : ( ( rule__Class__Group_0 )? ) ( ( ( RULE_ID ) ) ) ( '{' ) ( '}' ) ;
    public final void rule__Class__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:118:1: ( ( ( rule__Class__Group_0 )? ) ( ( ( RULE_ID ) ) ) ( '{' ) ( '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:119:1: ( ( rule__Class__Group_0 )? ) ( ( ( RULE_ID ) ) ) ( '{' ) ( '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:119:1: ( ( rule__Class__Group_0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:120:1: ( rule__Class__Group_0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:121:1: ( rule__Class__Group_0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==13) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:121:2: rule__Class__Group_0
                    {
                    pushFollow(FOLLOW_rule__Class__Group_0_in_rule__Class__Group203);
                    rule__Class__Group_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:123:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:124:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:125:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:126:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:126:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:127:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Class__Group222); 
             after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getClassAccess().getNameAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:133:1: ( '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:134:1: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,11,FOLLOW_11_in_rule__Class__Group240); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:139:1: ( '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:140:1: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__Class__Group253); 
             after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group


    // $ANTLR start rule__Class__Group_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:151:1: rule__Class__Group_0 : ( ( ( ( RULE_ID ) ) ) ) ( '<-' ) ;
    public final void rule__Class__Group_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:155:1: ( ( ( ( ( RULE_ID ) ) ) ) ( '<-' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:156:1: ( ( ( ( RULE_ID ) ) ) ) ( '<-' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:156:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:157:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:158:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:159:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:159:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:160:1: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:161:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:162:1: RULE_ID
            {
             before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Class__Group_0297); 
             after(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0()); 

            }


            }

             after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:170:1: ( '<-' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g:171:1: '<-'
            {
             before(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); 
            match(input,13,FOLLOW_13_in_rule__Class__Group_0319); 
             after(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Class__Group_0


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_ruleModel101 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleClass_in_entryRuleClass133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClass140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group_in_ruleClass167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group_0_in_rule__Class__Group203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Class__Group222 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_rule__Class__Group240 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rule__Class__Group253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Class__Group_0297 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rule__Class__Group_0319 = new BitSet(new long[]{0x0000000000000002L});

}