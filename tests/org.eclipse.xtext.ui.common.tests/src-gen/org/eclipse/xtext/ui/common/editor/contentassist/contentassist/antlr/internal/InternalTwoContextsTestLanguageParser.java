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
import org.eclipse.xtext.ui.common.editor.contentassist.services.TwoContextsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTwoContextsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'refersTo'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTwoContextsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g"; }


     
     	private TwoContextsTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TwoContextsTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleMainModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:55:1: entryRuleMainModel : ruleMainModel EOF ;
    public final void entryRuleMainModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:55:20: ( ruleMainModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:56:1: ruleMainModel EOF
            {
             before(grammarAccess.getMainModelRule()); 
            pushFollow(FOLLOW_ruleMainModel_in_entryRuleMainModel60);
            ruleMainModel();
            _fsp--;

             after(grammarAccess.getMainModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMainModel67); 

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
    // $ANTLR end entryRuleMainModel


    // $ANTLR start ruleMainModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:63:1: ruleMainModel : ( ( ( ruleAnElement ) )* ) ;
    public final void ruleMainModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:67:2: ( ( ( ( ruleAnElement ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:68:1: ( ( ( ruleAnElement ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:68:1: ( ( ( ruleAnElement ) )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:69:1: ( ( ruleAnElement ) )*
            {
             before(grammarAccess.getMainModelAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:70:1: ( ( ruleAnElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:71:1: ( ruleAnElement )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:71:1: ( ruleAnElement )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:72:1: ruleAnElement
            	    {
            	     before(grammarAccess.getMainModelAccess().getElementsAnElementParserRuleCall_0()); 
            	    pushFollow(FOLLOW_ruleAnElement_in_ruleMainModel101);
            	    ruleAnElement();
            	    _fsp--;

            	     after(grammarAccess.getMainModelAccess().getElementsAnElementParserRuleCall_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleMainModel


    // $ANTLR start entryRuleAnElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:87:1: entryRuleAnElement : ruleAnElement EOF ;
    public final void entryRuleAnElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:87:20: ( ruleAnElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:88:1: ruleAnElement EOF
            {
             before(grammarAccess.getAnElementRule()); 
            pushFollow(FOLLOW_ruleAnElement_in_entryRuleAnElement133);
            ruleAnElement();
            _fsp--;

             after(grammarAccess.getAnElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnElement140); 

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
    // $ANTLR end entryRuleAnElement


    // $ANTLR start ruleAnElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:95:1: ruleAnElement : ( ( rule__AnElement__Group ) ) ;
    public final void ruleAnElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:99:2: ( ( ( rule__AnElement__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:100:1: ( ( rule__AnElement__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:100:1: ( ( rule__AnElement__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:101:1: ( rule__AnElement__Group )
            {
             before(grammarAccess.getAnElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:102:1: ( rule__AnElement__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:102:2: rule__AnElement__Group
            {
            pushFollow(FOLLOW_rule__AnElement__Group_in_ruleAnElement167);
            rule__AnElement__Group();
            _fsp--;


            }

             after(grammarAccess.getAnElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAnElement


    // $ANTLR start rule__AnElement__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:114:1: rule__AnElement__Group : ( ( ( RULE_ID ) ) ) ( ( rule__AnElement__Group_1 )? ) ( ';' ) ;
    public final void rule__AnElement__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:118:1: ( ( ( ( RULE_ID ) ) ) ( ( rule__AnElement__Group_1 )? ) ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:119:1: ( ( ( RULE_ID ) ) ) ( ( rule__AnElement__Group_1 )? ) ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:119:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:120:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getAnElementAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:121:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:122:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:122:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:123:1: RULE_ID
            {
             before(grammarAccess.getAnElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AnElement__Group210); 
             after(grammarAccess.getAnElementAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

             after(grammarAccess.getAnElementAccess().getNameAssignment_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:129:1: ( ( rule__AnElement__Group_1 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:130:1: ( rule__AnElement__Group_1 )?
            {
             before(grammarAccess.getAnElementAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:131:1: ( rule__AnElement__Group_1 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:131:2: rule__AnElement__Group_1
                    {
                    pushFollow(FOLLOW_rule__AnElement__Group_1_in_rule__AnElement__Group227);
                    rule__AnElement__Group_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAnElementAccess().getGroup_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:133:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:134:1: ';'
            {
             before(grammarAccess.getAnElementAccess().getSemicolonKeyword_2()); 
            match(input,11,FOLLOW_11_in_rule__AnElement__Group240); 
             after(grammarAccess.getAnElementAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AnElement__Group


    // $ANTLR start rule__AnElement__Group_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:145:1: rule__AnElement__Group_1 : ( 'refersTo' ) ( ( ( ( RULE_ID ) ) ) ) ;
    public final void rule__AnElement__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:149:1: ( ( 'refersTo' ) ( ( ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:150:1: ( 'refersTo' ) ( ( ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:150:1: ( 'refersTo' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:151:1: 'refersTo'
            {
             before(grammarAccess.getAnElementAccess().getRefersToKeyword_1_0()); 
            match(input,12,FOLLOW_12_in_rule__AnElement__Group_1274); 
             after(grammarAccess.getAnElementAccess().getRefersToKeyword_1_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:156:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:157:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getAnElementAccess().getReferredAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:158:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:159:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:159:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:160:1: ( RULE_ID )
            {
             before(grammarAccess.getAnElementAccess().getReferredAnElementCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:161:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:162:1: RULE_ID
            {
             before(grammarAccess.getAnElementAccess().getReferredAnElementIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AnElement__Group_1297); 
             after(grammarAccess.getAnElementAccess().getReferredAnElementIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getAnElementAccess().getReferredAnElementCrossReference_1_1_0()); 

            }


            }

             after(grammarAccess.getAnElementAccess().getReferredAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AnElement__Group_1


 

    public static final BitSet FOLLOW_ruleMainModel_in_entryRuleMainModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMainModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnElement_in_ruleMainModel101 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleAnElement_in_entryRuleAnElement133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnElement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AnElement__Group_in_ruleAnElement167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AnElement__Group210 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__AnElement__Group_1_in_rule__AnElement__Group227 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_rule__AnElement__Group240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__AnElement__Group_1274 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AnElement__Group_1297 = new BitSet(new long[]{0x0000000000000002L});

}