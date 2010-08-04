package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288760TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug288760TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_END_TAG_SHORT", "RULE_GT", "RULE_EQ", "RULE_START_TAG", "RULE_END_TAG", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_LT", "RULE_END_TAG_START", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=9;
    public static final int RULE_STRING=10;
    public static final int RULE_END_TAG=8;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_GT=5;
    public static final int RULE_EQ=6;
    public static final int RULE_INT=14;
    public static final int RULE_WS=15;
    public static final int EOF=-1;
    public static final int RULE_END_TAG_START=13;
    public static final int RULE_END_TAG_SHORT=4;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_START_TAG=7;
    public static final int RULE_LT=12;

        public InternalBug288760TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:61:1: entryRuleWorkflowElement : ruleWorkflowElement EOF ;
    public final void entryRuleWorkflowElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:62:1: ( ruleWorkflowElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:63:1: ruleWorkflowElement EOF
            {
             before(grammarAccess.getWorkflowElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWorkflowElement_in_entryRuleWorkflowElement61);
            ruleWorkflowElement();
            _fsp--;

             after(grammarAccess.getWorkflowElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWorkflowElement68); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:70:1: ruleWorkflowElement : ( ( rule__WorkflowElement__Alternatives ) ) ;
    public final void ruleWorkflowElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:74:2: ( ( ( rule__WorkflowElement__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:75:1: ( ( rule__WorkflowElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:75:1: ( ( rule__WorkflowElement__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:76:1: ( rule__WorkflowElement__Alternatives )
            {
             before(grammarAccess.getWorkflowElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:77:1: ( rule__WorkflowElement__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:77:2: rule__WorkflowElement__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:89:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:90:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:91:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute121);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute128); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:98:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:102:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:103:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:103:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:104:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:105:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:105:2: rule__Attribute__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:117:1: rule__WorkflowElement__Alternatives : ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) );
    public final void rule__WorkflowElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:121:1: ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:122:1: ( ( rule__WorkflowElement__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:122:1: ( ( rule__WorkflowElement__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:123:1: ( rule__WorkflowElement__Group_0__0 )
                    {
                     before(grammarAccess.getWorkflowElementAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:124:1: ( rule__WorkflowElement__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:124:2: rule__WorkflowElement__Group_0__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:128:6: ( ( rule__WorkflowElement__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:128:6: ( ( rule__WorkflowElement__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:129:1: ( rule__WorkflowElement__Group_1__0 )
                    {
                     before(grammarAccess.getWorkflowElementAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:130:1: ( rule__WorkflowElement__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:130:2: rule__WorkflowElement__Group_1__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:141:1: rule__WorkflowElement__Group_0__0 : rule__WorkflowElement__Group_0__0__Impl rule__WorkflowElement__Group_0__1 ;
    public final void rule__WorkflowElement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:145:1: ( rule__WorkflowElement__Group_0__0__Impl rule__WorkflowElement__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:146:2: rule__WorkflowElement__Group_0__0__Impl rule__WorkflowElement__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__0__Impl_in_rule__WorkflowElement__Group_0__0239);
            rule__WorkflowElement__Group_0__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__1_in_rule__WorkflowElement__Group_0__0242);
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


    // $ANTLR start rule__WorkflowElement__Group_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:153:1: rule__WorkflowElement__Group_0__0__Impl : ( ( rule__WorkflowElement__NameAssignment_0_0 ) ) ;
    public final void rule__WorkflowElement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:157:1: ( ( ( rule__WorkflowElement__NameAssignment_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:158:1: ( ( rule__WorkflowElement__NameAssignment_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:158:1: ( ( rule__WorkflowElement__NameAssignment_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:159:1: ( rule__WorkflowElement__NameAssignment_0_0 )
            {
             before(grammarAccess.getWorkflowElementAccess().getNameAssignment_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:160:1: ( rule__WorkflowElement__NameAssignment_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:160:2: rule__WorkflowElement__NameAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__NameAssignment_0_0_in_rule__WorkflowElement__Group_0__0__Impl269);
            rule__WorkflowElement__NameAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getWorkflowElementAccess().getNameAssignment_0_0()); 

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
    // $ANTLR end rule__WorkflowElement__Group_0__0__Impl


    // $ANTLR start rule__WorkflowElement__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:170:1: rule__WorkflowElement__Group_0__1 : rule__WorkflowElement__Group_0__1__Impl rule__WorkflowElement__Group_0__2 ;
    public final void rule__WorkflowElement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:174:1: ( rule__WorkflowElement__Group_0__1__Impl rule__WorkflowElement__Group_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:175:2: rule__WorkflowElement__Group_0__1__Impl rule__WorkflowElement__Group_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__1__Impl_in_rule__WorkflowElement__Group_0__1299);
            rule__WorkflowElement__Group_0__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__2_in_rule__WorkflowElement__Group_0__1302);
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


    // $ANTLR start rule__WorkflowElement__Group_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:182:1: rule__WorkflowElement__Group_0__1__Impl : ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* ) ;
    public final void rule__WorkflowElement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:186:1: ( ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:187:1: ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:187:1: ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:188:1: ( rule__WorkflowElement__AttributesAssignment_0_1 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:189:1: ( rule__WorkflowElement__AttributesAssignment_0_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:189:2: rule__WorkflowElement__AttributesAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__AttributesAssignment_0_1_in_rule__WorkflowElement__Group_0__1__Impl329);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__Group_0__1__Impl


    // $ANTLR start rule__WorkflowElement__Group_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:199:1: rule__WorkflowElement__Group_0__2 : rule__WorkflowElement__Group_0__2__Impl ;
    public final void rule__WorkflowElement__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:203:1: ( rule__WorkflowElement__Group_0__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:204:2: rule__WorkflowElement__Group_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_0__2__Impl_in_rule__WorkflowElement__Group_0__2360);
            rule__WorkflowElement__Group_0__2__Impl();
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
    // $ANTLR end rule__WorkflowElement__Group_0__2


    // $ANTLR start rule__WorkflowElement__Group_0__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:210:1: rule__WorkflowElement__Group_0__2__Impl : ( RULE_END_TAG_SHORT ) ;
    public final void rule__WorkflowElement__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:214:1: ( ( RULE_END_TAG_SHORT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:215:1: ( RULE_END_TAG_SHORT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:215:1: ( RULE_END_TAG_SHORT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:216:1: RULE_END_TAG_SHORT
            {
             before(grammarAccess.getWorkflowElementAccess().getEND_TAG_SHORTTerminalRuleCall_0_2()); 
            match(input,RULE_END_TAG_SHORT,FollowSets000.FOLLOW_RULE_END_TAG_SHORT_in_rule__WorkflowElement__Group_0__2__Impl387); 
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
    // $ANTLR end rule__WorkflowElement__Group_0__2__Impl


    // $ANTLR start rule__WorkflowElement__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:233:1: rule__WorkflowElement__Group_1__0 : rule__WorkflowElement__Group_1__0__Impl rule__WorkflowElement__Group_1__1 ;
    public final void rule__WorkflowElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:237:1: ( rule__WorkflowElement__Group_1__0__Impl rule__WorkflowElement__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:238:2: rule__WorkflowElement__Group_1__0__Impl rule__WorkflowElement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__0__Impl_in_rule__WorkflowElement__Group_1__0422);
            rule__WorkflowElement__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__1_in_rule__WorkflowElement__Group_1__0425);
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


    // $ANTLR start rule__WorkflowElement__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:245:1: rule__WorkflowElement__Group_1__0__Impl : ( ( rule__WorkflowElement__NameAssignment_1_0 ) ) ;
    public final void rule__WorkflowElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:249:1: ( ( ( rule__WorkflowElement__NameAssignment_1_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:250:1: ( ( rule__WorkflowElement__NameAssignment_1_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:250:1: ( ( rule__WorkflowElement__NameAssignment_1_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:251:1: ( rule__WorkflowElement__NameAssignment_1_0 )
            {
             before(grammarAccess.getWorkflowElementAccess().getNameAssignment_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:252:1: ( rule__WorkflowElement__NameAssignment_1_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:252:2: rule__WorkflowElement__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__NameAssignment_1_0_in_rule__WorkflowElement__Group_1__0__Impl452);
            rule__WorkflowElement__NameAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getWorkflowElementAccess().getNameAssignment_1_0()); 

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
    // $ANTLR end rule__WorkflowElement__Group_1__0__Impl


    // $ANTLR start rule__WorkflowElement__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:262:1: rule__WorkflowElement__Group_1__1 : rule__WorkflowElement__Group_1__1__Impl rule__WorkflowElement__Group_1__2 ;
    public final void rule__WorkflowElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:266:1: ( rule__WorkflowElement__Group_1__1__Impl rule__WorkflowElement__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:267:2: rule__WorkflowElement__Group_1__1__Impl rule__WorkflowElement__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__1__Impl_in_rule__WorkflowElement__Group_1__1482);
            rule__WorkflowElement__Group_1__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__2_in_rule__WorkflowElement__Group_1__1485);
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


    // $ANTLR start rule__WorkflowElement__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:274:1: rule__WorkflowElement__Group_1__1__Impl : ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* ) ;
    public final void rule__WorkflowElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:278:1: ( ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:279:1: ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:279:1: ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:280:1: ( rule__WorkflowElement__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:281:1: ( rule__WorkflowElement__AttributesAssignment_1_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:281:2: rule__WorkflowElement__AttributesAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__AttributesAssignment_1_1_in_rule__WorkflowElement__Group_1__1__Impl512);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__Group_1__1__Impl


    // $ANTLR start rule__WorkflowElement__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:291:1: rule__WorkflowElement__Group_1__2 : rule__WorkflowElement__Group_1__2__Impl rule__WorkflowElement__Group_1__3 ;
    public final void rule__WorkflowElement__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:295:1: ( rule__WorkflowElement__Group_1__2__Impl rule__WorkflowElement__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:296:2: rule__WorkflowElement__Group_1__2__Impl rule__WorkflowElement__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__2__Impl_in_rule__WorkflowElement__Group_1__2543);
            rule__WorkflowElement__Group_1__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__3_in_rule__WorkflowElement__Group_1__2546);
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


    // $ANTLR start rule__WorkflowElement__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:303:1: rule__WorkflowElement__Group_1__2__Impl : ( RULE_GT ) ;
    public final void rule__WorkflowElement__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:307:1: ( ( RULE_GT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:308:1: ( RULE_GT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:308:1: ( RULE_GT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:309:1: RULE_GT
            {
             before(grammarAccess.getWorkflowElementAccess().getGTTerminalRuleCall_1_2()); 
            match(input,RULE_GT,FollowSets000.FOLLOW_RULE_GT_in_rule__WorkflowElement__Group_1__2__Impl573); 
             after(grammarAccess.getWorkflowElementAccess().getGTTerminalRuleCall_1_2()); 

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
    // $ANTLR end rule__WorkflowElement__Group_1__2__Impl


    // $ANTLR start rule__WorkflowElement__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:320:1: rule__WorkflowElement__Group_1__3 : rule__WorkflowElement__Group_1__3__Impl rule__WorkflowElement__Group_1__4 ;
    public final void rule__WorkflowElement__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:324:1: ( rule__WorkflowElement__Group_1__3__Impl rule__WorkflowElement__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:325:2: rule__WorkflowElement__Group_1__3__Impl rule__WorkflowElement__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__3__Impl_in_rule__WorkflowElement__Group_1__3602);
            rule__WorkflowElement__Group_1__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__4_in_rule__WorkflowElement__Group_1__3605);
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


    // $ANTLR start rule__WorkflowElement__Group_1__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:332:1: rule__WorkflowElement__Group_1__3__Impl : ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* ) ;
    public final void rule__WorkflowElement__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:336:1: ( ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:337:1: ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:337:1: ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:338:1: ( rule__WorkflowElement__ChildrenAssignment_1_3 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getChildrenAssignment_1_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:339:1: ( rule__WorkflowElement__ChildrenAssignment_1_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_START_TAG) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:339:2: rule__WorkflowElement__ChildrenAssignment_1_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__ChildrenAssignment_1_3_in_rule__WorkflowElement__Group_1__3__Impl632);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WorkflowElement__Group_1__3__Impl


    // $ANTLR start rule__WorkflowElement__Group_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:349:1: rule__WorkflowElement__Group_1__4 : rule__WorkflowElement__Group_1__4__Impl ;
    public final void rule__WorkflowElement__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:353:1: ( rule__WorkflowElement__Group_1__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:354:2: rule__WorkflowElement__Group_1__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__Group_1__4__Impl_in_rule__WorkflowElement__Group_1__4663);
            rule__WorkflowElement__Group_1__4__Impl();
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
    // $ANTLR end rule__WorkflowElement__Group_1__4


    // $ANTLR start rule__WorkflowElement__Group_1__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:360:1: rule__WorkflowElement__Group_1__4__Impl : ( ( rule__WorkflowElement__EndAssignment_1_4 ) ) ;
    public final void rule__WorkflowElement__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:364:1: ( ( ( rule__WorkflowElement__EndAssignment_1_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:365:1: ( ( rule__WorkflowElement__EndAssignment_1_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:365:1: ( ( rule__WorkflowElement__EndAssignment_1_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:366:1: ( rule__WorkflowElement__EndAssignment_1_4 )
            {
             before(grammarAccess.getWorkflowElementAccess().getEndAssignment_1_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:367:1: ( rule__WorkflowElement__EndAssignment_1_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:367:2: rule__WorkflowElement__EndAssignment_1_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__WorkflowElement__EndAssignment_1_4_in_rule__WorkflowElement__Group_1__4__Impl690);
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
    // $ANTLR end rule__WorkflowElement__Group_1__4__Impl


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:387:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:391:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:392:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__0730);
            rule__Attribute__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__0733);
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


    // $ANTLR start rule__Attribute__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:399:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:403:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:404:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:404:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:405:1: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:406:1: ( rule__Attribute__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:406:2: rule__Attribute__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0__Impl760);
            rule__Attribute__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_0()); 

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
    // $ANTLR end rule__Attribute__Group__0__Impl


    // $ANTLR start rule__Attribute__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:416:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:420:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:421:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__1790);
            rule__Attribute__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__1793);
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


    // $ANTLR start rule__Attribute__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:428:1: rule__Attribute__Group__1__Impl : ( RULE_EQ ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:432:1: ( ( RULE_EQ ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:433:1: ( RULE_EQ )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:433:1: ( RULE_EQ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:434:1: RULE_EQ
            {
             before(grammarAccess.getAttributeAccess().getEQTerminalRuleCall_1()); 
            match(input,RULE_EQ,FollowSets000.FOLLOW_RULE_EQ_in_rule__Attribute__Group__1__Impl820); 
             after(grammarAccess.getAttributeAccess().getEQTerminalRuleCall_1()); 

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
    // $ANTLR end rule__Attribute__Group__1__Impl


    // $ANTLR start rule__Attribute__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:445:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:449:1: ( rule__Attribute__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:450:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__2849);
            rule__Attribute__Group__2__Impl();
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
    // $ANTLR end rule__Attribute__Group__2


    // $ANTLR start rule__Attribute__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:456:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:460:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:461:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:461:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:462:1: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:463:1: ( rule__Attribute__ValueAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:463:2: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2__Impl876);
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
    // $ANTLR end rule__Attribute__Group__2__Impl


    // $ANTLR start rule__WorkflowElement__NameAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:480:1: rule__WorkflowElement__NameAssignment_0_0 : ( RULE_START_TAG ) ;
    public final void rule__WorkflowElement__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:484:1: ( ( RULE_START_TAG ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:485:1: ( RULE_START_TAG )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:485:1: ( RULE_START_TAG )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:486:1: RULE_START_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_0_0_0()); 
            match(input,RULE_START_TAG,FollowSets000.FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_0_0917); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:495:1: rule__WorkflowElement__AttributesAssignment_0_1 : ( ruleAttribute ) ;
    public final void rule__WorkflowElement__AttributesAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:499:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:500:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:500:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:501:1: ruleAttribute
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_0_1948);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:510:1: rule__WorkflowElement__NameAssignment_1_0 : ( RULE_START_TAG ) ;
    public final void rule__WorkflowElement__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:514:1: ( ( RULE_START_TAG ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:515:1: ( RULE_START_TAG )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:515:1: ( RULE_START_TAG )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:516:1: RULE_START_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_1_0_0()); 
            match(input,RULE_START_TAG,FollowSets000.FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_1_0979); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:525:1: rule__WorkflowElement__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__WorkflowElement__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:529:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:530:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:530:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:531:1: ruleAttribute
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_1_11010);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:540:1: rule__WorkflowElement__ChildrenAssignment_1_3 : ( ruleWorkflowElement ) ;
    public final void rule__WorkflowElement__ChildrenAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:544:1: ( ( ruleWorkflowElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:545:1: ( ruleWorkflowElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:545:1: ( ruleWorkflowElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:546:1: ruleWorkflowElement
            {
             before(grammarAccess.getWorkflowElementAccess().getChildrenWorkflowElementParserRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWorkflowElement_in_rule__WorkflowElement__ChildrenAssignment_1_31041);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:555:1: rule__WorkflowElement__EndAssignment_1_4 : ( RULE_END_TAG ) ;
    public final void rule__WorkflowElement__EndAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:559:1: ( ( RULE_END_TAG ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:560:1: ( RULE_END_TAG )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:560:1: ( RULE_END_TAG )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:561:1: RULE_END_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getEndEND_TAGTerminalRuleCall_1_4_0()); 
            match(input,RULE_END_TAG,FollowSets000.FOLLOW_RULE_END_TAG_in_rule__WorkflowElement__EndAssignment_1_41072); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:570:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:574:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:575:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:575:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:576:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_01103); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:585:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:589:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:590:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:590:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288760TestLanguage.g:591:1: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_21134); 
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
            return "117:1: rule__WorkflowElement__Alternatives : ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleWorkflowElement_in_entryRuleWorkflowElement61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWorkflowElement68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Alternatives_in_ruleWorkflowElement94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__0_in_rule__WorkflowElement__Alternatives190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__0_in_rule__WorkflowElement__Alternatives208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__0__Impl_in_rule__WorkflowElement__Group_0__0239 = new BitSet(new long[]{0x0000000000000210L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__1_in_rule__WorkflowElement__Group_0__0242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__NameAssignment_0_0_in_rule__WorkflowElement__Group_0__0__Impl269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__1__Impl_in_rule__WorkflowElement__Group_0__1299 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__2_in_rule__WorkflowElement__Group_0__1302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__AttributesAssignment_0_1_in_rule__WorkflowElement__Group_0__1__Impl329 = new BitSet(new long[]{0x0000000000000202L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_0__2__Impl_in_rule__WorkflowElement__Group_0__2360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_END_TAG_SHORT_in_rule__WorkflowElement__Group_0__2__Impl387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__0__Impl_in_rule__WorkflowElement__Group_1__0422 = new BitSet(new long[]{0x0000000000000220L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__1_in_rule__WorkflowElement__Group_1__0425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__NameAssignment_1_0_in_rule__WorkflowElement__Group_1__0__Impl452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__1__Impl_in_rule__WorkflowElement__Group_1__1482 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__2_in_rule__WorkflowElement__Group_1__1485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__AttributesAssignment_1_1_in_rule__WorkflowElement__Group_1__1__Impl512 = new BitSet(new long[]{0x0000000000000202L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__2__Impl_in_rule__WorkflowElement__Group_1__2543 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__3_in_rule__WorkflowElement__Group_1__2546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_GT_in_rule__WorkflowElement__Group_1__2__Impl573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__3__Impl_in_rule__WorkflowElement__Group_1__3602 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__4_in_rule__WorkflowElement__Group_1__3605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__ChildrenAssignment_1_3_in_rule__WorkflowElement__Group_1__3__Impl632 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_rule__WorkflowElement__Group_1__4__Impl_in_rule__WorkflowElement__Group_1__4663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WorkflowElement__EndAssignment_1_4_in_rule__WorkflowElement__Group_1__4__Impl690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__0730 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__0733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0__Impl760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__1790 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__1793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_EQ_in_rule__Attribute__Group__1__Impl820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__2849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2__Impl876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_0_0917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_0_1948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_START_TAG_in_rule__WorkflowElement__NameAssignment_1_0979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__WorkflowElement__AttributesAssignment_1_11010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWorkflowElement_in_rule__WorkflowElement__ChildrenAssignment_1_31041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_END_TAG_in_rule__WorkflowElement__EndAssignment_1_41072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_01103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_21134 = new BitSet(new long[]{0x0000000000000002L});
    }


}