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
import org.eclipse.xtext.ui.common.editor.contentassist.services.Bug288760TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug288760TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_END_TAG_SHORT", "RULE_GT", "RULE_EQ", "RULE_START_TAG", "RULE_END_TAG", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_LT", "RULE_END_TAG_START", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_START_TAG=7;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_ID=9;
    public static final int RULE_WS=15;
    public static final int RULE_END_TAG_START=13;
    public static final int RULE_INT=14;
    public static final int EOF=-1;
    public static final int RULE_EQ=6;
    public static final int RULE_STRING=10;
    public static final int RULE_END_TAG_SHORT=4;
    public static final int RULE_LT=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_GT=5;
    public static final int RULE_END_TAG=8;

        public InternalBug288760TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g"; }


     
     	private Bug288760TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug288760TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleWorkflowElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:60:1: entryRuleWorkflowElement : ruleWorkflowElement EOF ;
    public final void entryRuleWorkflowElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:60:26: ( ruleWorkflowElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:61:1: ruleWorkflowElement EOF
            {
             before(grammarAccess.getWorkflowElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWorkflowElement_in_entryRuleWorkflowElement60);
            ruleWorkflowElement();
            _fsp--;

             after(grammarAccess.getWorkflowElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWorkflowElement67); 

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
    // $ANTLR end entryRuleWorkflowElement


    // $ANTLR start ruleWorkflowElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:68:1: ruleWorkflowElement : ( ( rule__WorkflowElement__Alternatives ) ) ;
    public final void ruleWorkflowElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:72:2: ( ( ( rule__WorkflowElement__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:73:1: ( ( rule__WorkflowElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:73:1: ( ( rule__WorkflowElement__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:74:1: ( rule__WorkflowElement__Alternatives )
            {
             before(grammarAccess.getWorkflowElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:75:1: ( rule__WorkflowElement__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:75:2: rule__WorkflowElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Alternatives_in_ruleWorkflowElement94);
            rule__WorkflowElement__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getWorkflowElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleWorkflowElement


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:87:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:87:20: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:88:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute120);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute127); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:95:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:99:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:100:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:100:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:101:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:102:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:102:2: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0_in_ruleAttribute154);
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


    // $ANTLR start rule__WorkflowElement__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:114:1: rule__WorkflowElement__Alternatives : ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) );
    public final void rule__WorkflowElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:118:1: ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:119:1: ( ( rule__WorkflowElement__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:119:1: ( ( rule__WorkflowElement__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:120:1: ( rule__WorkflowElement__Group_0__0 )
                    {
                     before(grammarAccess.getWorkflowElementAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:121:1: ( rule__WorkflowElement__Group_0__0 )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:121:2: rule__WorkflowElement__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__0_in_rule__WorkflowElement__Alternatives190);
                    rule__WorkflowElement__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getWorkflowElementAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:125:6: ( ( rule__WorkflowElement__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:125:6: ( ( rule__WorkflowElement__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:126:1: ( rule__WorkflowElement__Group_1__0 )
                    {
                     before(grammarAccess.getWorkflowElementAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:127:1: ( rule__WorkflowElement__Group_1__0 )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:127:2: rule__WorkflowElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__0_in_rule__WorkflowElement__Alternatives208);
                    rule__WorkflowElement__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getWorkflowElementAccess().getGroup_1()); 

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
    // $ANTLR end rule__WorkflowElement__Alternatives


    // $ANTLR start rule__WorkflowElement__Group_0__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:138:1: rule__WorkflowElement__Group_0__0 : ( ( rule__WorkflowElement__NameAssignment_0_0 ) ) rule__WorkflowElement__Group_0__1 ;
    public final void rule__WorkflowElement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:142:1: ( ( ( rule__WorkflowElement__NameAssignment_0_0 ) ) rule__WorkflowElement__Group_0__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:143:1: ( ( rule__WorkflowElement__NameAssignment_0_0 ) ) rule__WorkflowElement__Group_0__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:143:1: ( ( rule__WorkflowElement__NameAssignment_0_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:144:1: ( rule__WorkflowElement__NameAssignment_0_0 )
            {
             before(grammarAccess.getWorkflowElementAccess().getNameAssignment_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:145:1: ( rule__WorkflowElement__NameAssignment_0_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:145:2: rule__WorkflowElement__NameAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__NameAssignment_0_0_in_rule__WorkflowElement__Group_0__0243);
            rule__WorkflowElement__NameAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getWorkflowElementAccess().getNameAssignment_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__1_in_rule__WorkflowElement__Group_0__0252);
            rule__WorkflowElement__Group_0__1();
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
    // $ANTLR end rule__WorkflowElement__Group_0__0


    // $ANTLR start rule__WorkflowElement__Group_0__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:156:1: rule__WorkflowElement__Group_0__1 : ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* ) rule__WorkflowElement__Group_0__2 ;
    public final void rule__WorkflowElement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:160:1: ( ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* ) rule__WorkflowElement__Group_0__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:161:1: ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* ) rule__WorkflowElement__Group_0__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:161:1: ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:162:1: ( rule__WorkflowElement__AttributesAssignment_0_1 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:163:1: ( rule__WorkflowElement__AttributesAssignment_0_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:163:2: rule__WorkflowElement__AttributesAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__AttributesAssignment_0_1_in_rule__WorkflowElement__Group_0__1280);
            	    rule__WorkflowElement__AttributesAssignment_0_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__2_in_rule__WorkflowElement__Group_0__1290);
            rule__WorkflowElement__Group_0__2();
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
    // $ANTLR end rule__WorkflowElement__Group_0__1


    // $ANTLR start rule__WorkflowElement__Group_0__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:174:1: rule__WorkflowElement__Group_0__2 : ( RULE_END_TAG_SHORT ) ;
    public final void rule__WorkflowElement__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:178:1: ( ( RULE_END_TAG_SHORT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:179:1: ( RULE_END_TAG_SHORT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:179:1: ( RULE_END_TAG_SHORT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:180:1: RULE_END_TAG_SHORT
            {
             before(grammarAccess.getWorkflowElementAccess().getEND_TAG_SHORTTerminalRuleCall_0_2()); 
            match(input,RULE_END_TAG_SHORT,FollowSets000.FOLLOW_RULE_END_TAG_SHORT_in_rule__WorkflowElement__Group_0__2318); 
             after(grammarAccess.getWorkflowElementAccess().getEND_TAG_SHORTTerminalRuleCall_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__Group_0__2


    // $ANTLR start rule__WorkflowElement__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:197:1: rule__WorkflowElement__Group_1__0 : ( ( rule__WorkflowElement__NameAssignment_1_0 ) ) rule__WorkflowElement__Group_1__1 ;
    public final void rule__WorkflowElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:201:1: ( ( ( rule__WorkflowElement__NameAssignment_1_0 ) ) rule__WorkflowElement__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:202:1: ( ( rule__WorkflowElement__NameAssignment_1_0 ) ) rule__WorkflowElement__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:202:1: ( ( rule__WorkflowElement__NameAssignment_1_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:203:1: ( rule__WorkflowElement__NameAssignment_1_0 )
            {
             before(grammarAccess.getWorkflowElementAccess().getNameAssignment_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:204:1: ( rule__WorkflowElement__NameAssignment_1_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:204:2: rule__WorkflowElement__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__NameAssignment_1_0_in_rule__WorkflowElement__Group_1__0357);
            rule__WorkflowElement__NameAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getWorkflowElementAccess().getNameAssignment_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__1_in_rule__WorkflowElement__Group_1__0366);
            rule__WorkflowElement__Group_1__1();
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
    // $ANTLR end rule__WorkflowElement__Group_1__0


    // $ANTLR start rule__WorkflowElement__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:215:1: rule__WorkflowElement__Group_1__1 : ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* ) rule__WorkflowElement__Group_1__2 ;
    public final void rule__WorkflowElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:219:1: ( ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* ) rule__WorkflowElement__Group_1__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:220:1: ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* ) rule__WorkflowElement__Group_1__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:220:1: ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:221:1: ( rule__WorkflowElement__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:222:1: ( rule__WorkflowElement__AttributesAssignment_1_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:222:2: rule__WorkflowElement__AttributesAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__AttributesAssignment_1_1_in_rule__WorkflowElement__Group_1__1394);
            	    rule__WorkflowElement__AttributesAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__2_in_rule__WorkflowElement__Group_1__1404);
            rule__WorkflowElement__Group_1__2();
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
    // $ANTLR end rule__WorkflowElement__Group_1__1


    // $ANTLR start rule__WorkflowElement__Group_1__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:233:1: rule__WorkflowElement__Group_1__2 : ( RULE_GT ) rule__WorkflowElement__Group_1__3 ;
    public final void rule__WorkflowElement__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:237:1: ( ( RULE_GT ) rule__WorkflowElement__Group_1__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:238:1: ( RULE_GT ) rule__WorkflowElement__Group_1__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:238:1: ( RULE_GT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:239:1: RULE_GT
            {
             before(grammarAccess.getWorkflowElementAccess().getGTTerminalRuleCall_1_2()); 
            match(input,RULE_GT,FollowSets000.FOLLOW_RULE_GT_in_rule__WorkflowElement__Group_1__2432); 
             after(grammarAccess.getWorkflowElementAccess().getGTTerminalRuleCall_1_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__3_in_rule__WorkflowElement__Group_1__2440);
            rule__WorkflowElement__Group_1__3();
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
    // $ANTLR end rule__WorkflowElement__Group_1__2


    // $ANTLR start rule__WorkflowElement__Group_1__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:251:1: rule__WorkflowElement__Group_1__3 : ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* ) rule__WorkflowElement__Group_1__4 ;
    public final void rule__WorkflowElement__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:255:1: ( ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* ) rule__WorkflowElement__Group_1__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:256:1: ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* ) rule__WorkflowElement__Group_1__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:256:1: ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:257:1: ( rule__WorkflowElement__ChildrenAssignment_1_3 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getChildrenAssignment_1_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:258:1: ( rule__WorkflowElement__ChildrenAssignment_1_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_START_TAG) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:258:2: rule__WorkflowElement__ChildrenAssignment_1_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__ChildrenAssignment_1_3_in_rule__WorkflowElement__Group_1__3468);
            	    rule__WorkflowElement__ChildrenAssignment_1_3();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getWorkflowElementAccess().getChildrenAssignment_1_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__4_in_rule__WorkflowElement__Group_1__3478);
            rule__WorkflowElement__Group_1__4();
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
    // $ANTLR end rule__WorkflowElement__Group_1__3


    // $ANTLR start rule__WorkflowElement__Group_1__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:269:1: rule__WorkflowElement__Group_1__4 : ( ( rule__WorkflowElement__EndAssignment_1_4 ) ) ;
    public final void rule__WorkflowElement__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:273:1: ( ( ( rule__WorkflowElement__EndAssignment_1_4 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:274:1: ( ( rule__WorkflowElement__EndAssignment_1_4 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:274:1: ( ( rule__WorkflowElement__EndAssignment_1_4 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:275:1: ( rule__WorkflowElement__EndAssignment_1_4 )
            {
             before(grammarAccess.getWorkflowElementAccess().getEndAssignment_1_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:276:1: ( rule__WorkflowElement__EndAssignment_1_4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:276:2: rule__WorkflowElement__EndAssignment_1_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__EndAssignment_1_4_in_rule__WorkflowElement__Group_1__4506);
            rule__WorkflowElement__EndAssignment_1_4();
            _fsp--;


            }

             after(grammarAccess.getWorkflowElementAccess().getEndAssignment_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__Group_1__4


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:296:1: rule__Attribute__Group__0 : ( ( rule__Attribute__NameAssignment_0 ) ) rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:300:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:301:1: ( ( rule__Attribute__NameAssignment_0 ) ) rule__Attribute__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:301:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:302:1: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:303:1: ( rule__Attribute__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:303:2: rule__Attribute__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0550);
            rule__Attribute__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__0559);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:314:1: rule__Attribute__Group__1 : ( RULE_EQ ) rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:318:1: ( ( RULE_EQ ) rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:319:1: ( RULE_EQ ) rule__Attribute__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:319:1: ( RULE_EQ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:320:1: RULE_EQ
            {
             before(grammarAccess.getAttributeAccess().getEQTerminalRuleCall_1()); 
            match(input,RULE_EQ,FollowSets000.FOLLOW_RULE_EQ_in_rule__Attribute__Group__1587); 
             after(grammarAccess.getAttributeAccess().getEQTerminalRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__1595);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:332:1: rule__Attribute__Group__2 : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:336:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:337:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:337:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:338:1: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:339:1: ( rule__Attribute__ValueAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:339:2: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2623);
            rule__Attribute__ValueAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getValueAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start rule__WorkflowElement__NameAssignment_0_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:355:1: rule__WorkflowElement__NameAssignment_0_0 : ( RULE_START_TAG ) ;
    public final void rule__WorkflowElement__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:359:1: ( ( RULE_START_TAG ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:360:1: ( RULE_START_TAG )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:360:1: ( RULE_START_TAG )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:361:1: RULE_START_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_0_0_0()); 
            match(input,RULE_START_TAG,FollowSets000.FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_0_0663); 
             after(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__NameAssignment_0_0


    // $ANTLR start rule__WorkflowElement__AttributesAssignment_0_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:370:1: rule__WorkflowElement__AttributesAssignment_0_1 : ( ruleAttribute ) ;
    public final void rule__WorkflowElement__AttributesAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:374:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:375:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:375:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:376:1: ruleAttribute
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_0_1694);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__AttributesAssignment_0_1


    // $ANTLR start rule__WorkflowElement__NameAssignment_1_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:385:1: rule__WorkflowElement__NameAssignment_1_0 : ( RULE_START_TAG ) ;
    public final void rule__WorkflowElement__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:389:1: ( ( RULE_START_TAG ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:390:1: ( RULE_START_TAG )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:390:1: ( RULE_START_TAG )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:391:1: RULE_START_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_1_0_0()); 
            match(input,RULE_START_TAG,FollowSets000.FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_1_0725); 
             after(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__NameAssignment_1_0


    // $ANTLR start rule__WorkflowElement__AttributesAssignment_1_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:400:1: rule__WorkflowElement__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__WorkflowElement__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:404:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:405:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:405:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:406:1: ruleAttribute
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_1_1756);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__AttributesAssignment_1_1


    // $ANTLR start rule__WorkflowElement__ChildrenAssignment_1_3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:415:1: rule__WorkflowElement__ChildrenAssignment_1_3 : ( ruleWorkflowElement ) ;
    public final void rule__WorkflowElement__ChildrenAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:419:1: ( ( ruleWorkflowElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:420:1: ( ruleWorkflowElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:420:1: ( ruleWorkflowElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:421:1: ruleWorkflowElement
            {
             before(grammarAccess.getWorkflowElementAccess().getChildrenWorkflowElementParserRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWorkflowElement_in_rule__WorkflowElement__ChildrenAssignment_1_3787);
            ruleWorkflowElement();
            _fsp--;

             after(grammarAccess.getWorkflowElementAccess().getChildrenWorkflowElementParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__ChildrenAssignment_1_3


    // $ANTLR start rule__WorkflowElement__EndAssignment_1_4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:430:1: rule__WorkflowElement__EndAssignment_1_4 : ( RULE_END_TAG ) ;
    public final void rule__WorkflowElement__EndAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:434:1: ( ( RULE_END_TAG ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:435:1: ( RULE_END_TAG )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:435:1: ( RULE_END_TAG )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:436:1: RULE_END_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getEndEND_TAGTerminalRuleCall_1_4_0()); 
            match(input,RULE_END_TAG,FollowSets000.FOLLOW_RULE_END_TAG_in_rule__WorkflowElement__EndAssignment_1_4818); 
             after(grammarAccess.getWorkflowElementAccess().getEndEND_TAGTerminalRuleCall_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__EndAssignment_1_4


    // $ANTLR start rule__Attribute__NameAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:445:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:449:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:450:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:450:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:451:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_0849); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__NameAssignment_0


    // $ANTLR start rule__Attribute__ValueAssignment_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:460:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:464:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:465:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:465:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288760TestLanguage.g:466:1: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_2880); 
             after(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__ValueAssignment_2


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\7\uffff";
    static final String DFA1_eofS =
        "\7\uffff";
    static final String DFA1_minS =
        "\1\7\1\4\1\6\2\uffff\1\12\1\4";
    static final String DFA1_maxS =
        "\1\7\1\11\1\6\2\uffff\1\12\1\11";
    static final String DFA1_acceptS =
        "\3\uffff\1\1\1\2\2\uffff";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\3\1\4\3\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\3\1\4\3\uffff\1\2"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "114:1: rule__WorkflowElement__Alternatives : ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleWorkflowElement_in_entryRuleWorkflowElement60 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWorkflowElement67 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Alternatives_in_ruleWorkflowElement94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__0_in_rule__WorkflowElement__Alternatives190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__0_in_rule__WorkflowElement__Alternatives208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__NameAssignment_0_0_in_rule__WorkflowElement__Group_0__0243 = new BitSet(new long[]{0x0000000000000210L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__1_in_rule__WorkflowElement__Group_0__0252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__AttributesAssignment_0_1_in_rule__WorkflowElement__Group_0__1280 = new BitSet(new long[]{0x0000000000000210L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__2_in_rule__WorkflowElement__Group_0__1290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_END_TAG_SHORT_in_rule__WorkflowElement__Group_0__2318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__NameAssignment_1_0_in_rule__WorkflowElement__Group_1__0357 = new BitSet(new long[]{0x0000000000000220L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__1_in_rule__WorkflowElement__Group_1__0366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__AttributesAssignment_1_1_in_rule__WorkflowElement__Group_1__1394 = new BitSet(new long[]{0x0000000000000220L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__2_in_rule__WorkflowElement__Group_1__1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_GT_in_rule__WorkflowElement__Group_1__2432 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__3_in_rule__WorkflowElement__Group_1__2440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__ChildrenAssignment_1_3_in_rule__WorkflowElement__Group_1__3468 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__4_in_rule__WorkflowElement__Group_1__3478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__EndAssignment_1_4_in_rule__WorkflowElement__Group_1__4506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0550 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__0559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_EQ_in_rule__Attribute__Group__1587 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__1595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_0_0663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_0_1694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_1_0725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_1_1756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWorkflowElement_in_rule__WorkflowElement__ChildrenAssignment_1_3787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_END_TAG_in_rule__WorkflowElement__EndAssignment_1_4818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_0849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_2880 = new BitSet(new long[]{0x0000000000000002L});
    }


}